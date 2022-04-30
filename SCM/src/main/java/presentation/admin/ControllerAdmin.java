package presentation.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Especialidad;
import logic.Medico;
import logic.Service;
import presentation.admin.ModelAdmin;

@WebServlet(name = "ControllerAdmin", urlPatterns = {"/presentation/admin/show", "/presentation/admin/ListadoMedicosShow", "/presentation/admin/ListadoMedicosUpdate",
"/presentation/admin/EspecialidadShow"})
public class ControllerAdmin extends HttpServlet{
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {

        request.setAttribute("ModelAdmin", new ModelAdmin());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/admin/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/admin/ListadoMedicosShow":
                viewUrl = this.ListadoMedicosShow(request);
                break;
            case "/presentation/admin/ListadoMedicosUpdate":
                viewUrl = this.ListadoMedicosUpdate(request);
                break;
            case "/presentation/admin/EspecialidadShow":
                viewUrl = this.EspecialidadShow(request);
                break;
//            case "/presentation/admin/EspecialidadUpdate":
//                viewUrl = this.EspecialidadUpdate(request);
//                break;
//            case "/presentation/admin/EspecialidadIngresar":
//                viewUrl = this.EspecialidadIngresar(request);
//                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        ModelAdmin model = (ModelAdmin) request.getAttribute("ModelAdmin");
        model.getAdmin().setID("");
        model.getAdmin().setPassword("");
        return "/Views/Admin/ViewAdmin.jsp";
    }
    
    public String ListadoMedicosShow(HttpServletRequest request) throws SQLException{
        ModelAdmin model = (ModelAdmin) request.getAttribute("ModelAdmin");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        List<Medico> registros = service.getRegistros();
        
        request.setAttribute("ModelAdmin", model);
        session.setAttribute("ListarMedicos", registros);
        try {

            return "/Views/Admin/ListadoMedicos.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String ListadoMedicosUpdate(HttpServletRequest request) throws SQLException, Exception{
        ModelAdmin model = (ModelAdmin) request.getAttribute("ModelAdmin");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        
        String medID = request.getParameter("medicoID");
        service.setEstadoMed(1, medID);
        
        List<Medico> registros = service.getRegistros();
        
        model.setListarMedicos(registros);
        request.setAttribute("ModelAdmin", model);
        session.setAttribute("ListarMedicos", registros);
        
        return "/Views/Admin/ListadoMedicos.jsp";
    }
    
    public String EspecialidadShow(HttpServletRequest request) throws SQLException{
        ModelAdmin model = (ModelAdmin) request.getAttribute("ModelAdmin");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        List<Especialidad> especialidades = service.getEspecialidades();
        
        request.setAttribute("ModelAdmin", model);
        session.setAttribute("Especialidades", especialidades);
        try {

            return "/Views/Admin/Especialidad.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
//    public String EspecialidadUpdate(HttpServletRequest request){
//    
//    }
//    
//    public String EspecialidadIngresar(HttpServletRequest request){
//    
//    }
    
    
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
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
