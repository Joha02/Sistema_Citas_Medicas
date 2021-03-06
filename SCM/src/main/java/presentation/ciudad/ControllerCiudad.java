package presentation.ciudad;

import presentation.ciudad.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Service;
import logic.Ciudad;

@WebServlet(name = "ControllerCiudad", urlPatterns = {"/presentation/ciudad/show"})
public class ControllerCiudad extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelCiudad", new ModelCiudad());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/ciudad/show":
                viewUrl = this.show(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    } 
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        
        ModelCiudad model = (ModelCiudad) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        Ciudad ciudad = (Ciudad) session.getAttribute("ciudad");
        try {
            ciudad = service.CiudadFind(ciudad);
        } catch (Exception ex) { ciudad=null; }
        try {        
            model.setCurrent(ciudad);
            return "/Views/Ciudad/ViewCiudad.jsp";
        } catch (Exception ex) { return "/Error.jsp"; }
        
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
