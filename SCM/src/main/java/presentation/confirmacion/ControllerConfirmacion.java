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
import logic.Medico;

@WebServlet(name = "ControllerConfirmacion", urlPatterns = {"/presentation/confirmacion/show", "/presentation/confirmacion/confirmacion"})
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
            case "/presentation/confirmacion/confirmacion":
                viewUrl = this.searchAction(request);
                break;
          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String searchAction(HttpServletRequest request) {
        ModelConfirmacion model = (ModelConfirmacion) request.getAttribute("ModelConfirmacion");
        Service service = Service.instance();

        try {
            String especialidades = request.getParameter("Especialidad");
           
            if(especialidades == null){
              
             especialidades = ""; 
            
            }
            
            
            
            
            
            Medico medico = service.search_Medico();
            
            for (Medico m: medicos){
                 m.setCitas(service.searchCita(m.getID()));
            }
            
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
