package presentation.confirmacion;

import logic.Service;
import logic.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Cita;
import logic.Medico;
import logic.Paciente;

@WebServlet(name = "ControllerConfirmacion", urlPatterns = {"/presentation/confirmacion/show", "/presentation/confirmacion/agendar"})
public class ControllerConfirmacion extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelConfirmacion", new ModelConfirmacion());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/confirmacion/show":
                viewUrl = this.showAction(request);
                break;
            case "/presentation/confirmacion/agendar":
                viewUrl = this.agendarAction(request);
                break;
          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String agendarAction(HttpServletRequest request) {
        ModelConfirmacion model = (ModelConfirmacion) request.getAttribute("ModelConfirmacion");
        Service service = Service.instance();

        try {
            String id_cita = request.getParameter("id_cita");
            Cita cita = service.search_Cita(id_cita);
            HttpSession session = request.getSession(true);
            Paciente pat = (Paciente) session.getAttribute("usuario");
            if(pat == null){
                return "/presentation/login/show";
            }
            cita.setpaciente(pat);
            service.agendarCita(cita);
            Medico medico = service.searchMedicoID(cita.getMedico().getID());
            model.setCita(cita);
            model.setCurrent(pat);
            model.setMedico(medico);
            return "/Confirmacion.jsp";
            
        } catch (Exception ex) {
            
           return "/Error.jsp";
        }
    }

    public String showAction(HttpServletRequest request) {
        return "/Buscar.jsp";
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
        processRequest(request, response);
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
        processRequest(request, response);
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
