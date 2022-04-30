package presentation.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import presentation.admin.ModelAdmin;

@WebServlet(name = "ControllerAdmin", urlPatterns = {"/presentation/admin/show"})
public class ControllerAdmin extends HttpServlet{
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelAdmin", new ModelAdmin());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/admin/show":
                viewUrl = this.show(request);
                break;
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
