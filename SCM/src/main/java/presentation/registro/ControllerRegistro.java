package presentation.registro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Medico;
import logic.Paciente;
import logic.Service;
import presentation.registro.ModelRegistro;

@WebServlet(name = "ControllerRegistro", urlPatterns = {"/presentation/registro/show", "/presentation/registro/registro"})
public class ControllerRegistro extends HttpServlet{
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelRegistro", new ModelRegistro());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/registro/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/registro/registro":
                viewUrl = this.registro(request);
                break;
                
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        ModelRegistro model = (ModelRegistro) request.getAttribute("ModelRegistro");
        model.getCurrent().setID("");
        model.getCurrent().setPassword("");
        return "/ViewRegistro.jsp";
    }
    
    public String registro(HttpServletRequest request) {
        ModelRegistro model = (ModelRegistro) request.getAttribute("ModelRegistro");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        try {
            String viewUrl = "";
            switch (request.getParameter("tipo")) {
                case "1":
                    String idM = request.getParameter("IDFld");
                    String passwordM = request.getParameter("passwordFld");
                    String nameM = request.getParameter("NomFld");
                    service.AddMedico(idM, passwordM, nameM);
                    Medico medico = service.searchMedico(idM, passwordM);  
                    
                    service.AddRegistro(medico);
                    model.setCurrent(medico);
                    request.setAttribute("ModelRegistro", model);
                    session.setAttribute("usuario", medico);
                    viewUrl = "/presentation/medico/show";
                    break;

                case "2":
                    String idP = request.getParameter("IDFld");
                    String passwordP = request.getParameter("passwordFld");
                    String nameP = request.getParameter("NomFld");
                    service.AddPaciente(idP, passwordP, nameP);
                    Paciente paciente = service.searchPaciente(idP, passwordP);                    
                    session.setAttribute("usuario", paciente);
                    viewUrl = "/presentation/paciente/show";
                    break;
            }
            
            return viewUrl;
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            return "/ViewError.jsp";
        }
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
