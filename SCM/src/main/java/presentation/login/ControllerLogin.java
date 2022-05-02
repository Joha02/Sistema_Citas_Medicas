package presentation.login;

import logic.Service;
import logic.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerLogin", urlPatterns = {"/presentation/login/show", "/presentation/login/login", "/presentation/login/logout"})
public class ControllerLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelLogin", new ModelLogin());
        HttpSession session = request.getSession(true);

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/login/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/login/login":
                viewUrl = this.login(request);
                session.setAttribute("url", viewUrl);
                break;
            case "/presentation/login/logout":
                viewUrl = this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/index.jsp";
            }
        } catch (Exception e) {
            return "/ViewError.jsp";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("IDFld").isEmpty()) {
            errores.put("ID", "ID requerido");
        }

        if (request.getParameter("passwordFld").isEmpty()) {
            errores.put("password", "Contraseña requerida");
        }
        return errores;
    }

    void updateModel(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin");
        model.getCurrent().setID(request.getParameter("IDFld"));
        model.getCurrent().setPassword(request.getParameter("passwordFld"));
    }

    public String loginAction(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        try {
            String viewUrl = "";
            switch (request.getParameter("tipo")) {
                case "1":
                    Usuario medico = service.searchMedico(model.getCurrent().getID(), model.getCurrent().getPassword());
                    session.setAttribute("usuario", medico);
                    viewUrl = "/presentation/medico/show";
                    break;
                   
                case "2":
                    Usuario paciente = service.searchPaciente(model.getCurrent().getID(), model.getCurrent().getPassword());
                    session.setAttribute("usuario", paciente);
                    viewUrl = "/presentation/paciente/show";
                    break;

                case "3":
                    Usuario admin = service.searchAdmin(model.getCurrent().getID(), model.getCurrent().getPassword());
                    session.setAttribute("usuario", admin);
                    viewUrl = "/presentation/admin/show";
                    break;
            }
            
            return viewUrl;
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("ID", "Usuario o contraseña incorrectos");
            errores.put("password", "Usuario o contraseña incorrectos");
            return "/Error.jsp";
        }
    }

    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/index.jsp";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin");
        model.getCurrent().setID("");
        model.getCurrent().setPassword("");
        return "/ViewLogin.jsp";
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
