package presentation.medico;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Ciudad;
import logic.Especialidad;
import logic.Hora;
import logic.Medico;
import logic.Service;
import logic.Usuario;

@WebServlet(name = "ControllerMedico", urlPatterns = {"/presentation/medico/show", "/presentation/medico/editarPerfilShow", "/presentation/medico/actualizarPerfil"})
public class ControllerMedico extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {

        request.setAttribute("ModelMedico", new ModelMedico());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/medico/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/medico/editarPerfilShow":
                viewUrl = this.editarPerfilShow(request);
                break;
            case "/presentation/medico/actualizarPerfil":
                viewUrl = this.actualizarPerfil(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    } 

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) {
        ModelMedico model = (ModelMedico) request.getAttribute("ModelMedico");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Medico medico;
        try {
            medico = service.medicoFind(usuario);
            model.setCurrent(medico);
            request.setAttribute("ModelMedico", model);
            session.setAttribute("usuario", medico);
            session.setAttribute("ModelMedico", model);
        
            return "/Views/Medico/ViewMedico.jsp";
        } catch (Exception ex) { return "/ViewError.jsp"; }
        
    }
    
    public String editarPerfilShow(HttpServletRequest request) throws SQLException {
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        
        List<Ciudad> ciudades = service.getCiudades();
        List<Especialidad> especialidades = service.getEspecialidades();

        session.setAttribute("Especialidades", especialidades);
        session.setAttribute("Ciudades", ciudades);
        
        return "/Views/Medico/EditarPerfil.jsp";
    }
    
    public String actualizarPerfil(HttpServletRequest request) throws Exception{
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        ModelMedico model = (ModelMedico) session.getAttribute("ModelMedico");
        List<String> diasL = new ArrayList();
        int cost = 0;
        
        //--- Verifica que no vayan cadenas vacías ---
        String nom = request.getParameter("namem");
        if(nom.isEmpty()){ nom = model.getCurrent().getName(); }
        
        String passw = request.getParameter("passwordm");
        if(passw.isEmpty()){ passw = model.getCurrent().getPassword(); }
        
        String c = request.getParameter("costom");
        if(c.isEmpty()){ cost = model.getCurrent().getCosto(); }
        else { cost = Integer.parseInt(c);}
        
        String direc = request.getParameter("direccionm");
        if(direc.isEmpty()){ direc = model.getCurrent().getDireccion(); }
        
        String inf = request.getParameter("presentacionm");
        if(inf.isEmpty()){ inf = model.getCurrent().getInfo(); }
        
        String espec = request.getParameter("especialidadm");
        Ciudad ciudad = new Ciudad(request.getParameter("ciudadm"));
        
        //-------- Dias laborales --------
        String lun = request.getParameter("L");
        if(lun != null){ diasL.add("LUNES"); }
        
        String mar = request.getParameter("K");
        if(mar != null){ diasL.add("MARTES"); }
        
        String mie = request.getParameter("M");
        if(mie != null){ diasL.add("MIERCOLES"); }
        
        String jue = request.getParameter("J");
        if(jue != null){ diasL.add("JUEVES"); }
        
        String vie = request.getParameter("V");
        if(vie != null){ diasL.add("VIERNES"); }
        
        //-------- Creación del horario -------
        int frec = Integer.parseInt(request.getParameter("frecuenciam"));
        int Hinicio = Integer.parseInt(request.getParameter("iniciom"));
        int Hfinal = Integer.parseInt(request.getParameter("finm"));
        List<Hora> horario = this.horarioLaboral(Hinicio, Hfinal, frec, request);
        
        //------- Actualizar Datos ------------
        model.getCurrent().setName(nom);
        model.getCurrent().setPassword(passw);
        model.getCurrent().setCosto(cost);
        model.getCurrent().setDireccion(direc);
        model.getCurrent().setInfo(inf);
        model.getCurrent().setEspecialidad(espec);
        model.getCurrent().setCiudad(ciudad);
        model.getCurrent().setDias(diasL);
        model.getCurrent().setHoras(horario);
        
        Medico medico = model.getCurrent();
        service.updateMedico(medico);
        request.setAttribute("ModelMedico", model);
        session.setAttribute("usuario", medico);
        
        return "/Views/Medico/ViewMedico.jsp";
    }
    
    public List<Hora> horarioLaboral(int Hinicio, int Hfinal, int frec, HttpServletRequest request) {
        ModelMedico model = (ModelMedico) request.getAttribute("ModelMedico");
        List<Hora> horario = new ArrayList();
        horario.add(new Hora(Hinicio, 0));
        int min = 0;
        int hrs = Hinicio;
        for(int i = Hinicio; i < Hfinal; i++) {
            if(frec > 10){
                min += frec;
                if(min > 59){
                    min = 0;
                    hrs += 1;
                }
                horario.add(new Hora(hrs, min));
            } else {
                hrs += 1;
                horario.add(new Hora(hrs, 0));
            }
        }
        horario.add(new Hora(Hfinal, 0));
        model.getCurrent().setHoras(horario);
        return horario;
    }
    
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

