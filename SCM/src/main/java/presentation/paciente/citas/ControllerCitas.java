package presentation.paciente.citas;
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

@WebServlet(name = "ControllerCitas", urlPatterns = {"/presentation/paciente/citas/show", "/presentation/paciente/show/show"})
public class ControllerCitas extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelCitas", new ModelCitas());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/paciente/citas/show":
                viewUrl = this.showAction(request);
                break;
            case "/presentation/paciente/show/show":
                viewUrl = this.mostrarCitaAction(request);
                break;
          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String mostrarCitaAction(HttpServletRequest request) {
        ModelCitas model = (ModelCitas) request.getAttribute("ModelCitas");
        Service service = Service.instance();

        try {
            HttpSession session = request.getSession(true);
            Paciente pat = (Paciente) session.getAttribute("usuario");
            
            if(pat == null){
                return "/presentation/login/show";
            }
            List<Cita> citas = service.searchCitabyPaciente(pat.getID());
            model.setCitas(citas);
            model.setCurrent(pat);
 
            return "/Views/Paciente/citas/ViewCitas.jsp";
            
        } catch (Exception ex) {
            
           return "/Error.jsp";
        }
    }

    public String showAction(HttpServletRequest request) {
        return "/Views/Paciente/citas/ViewCitas.jsp";
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
