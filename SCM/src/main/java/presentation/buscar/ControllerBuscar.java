package presentation.buscar;

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

@WebServlet(name = "ControllerBuscar", urlPatterns = {"/presentation/buscar/show", "/presentation/buscar/buscar"})
public class ControllerBuscar extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("ModelBuscar", new ModelBuscar());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/buscar/show":
                viewUrl = this.showAction(request);
                break;
            case "/presentation/buscar/buscar":
                viewUrl = this.searchAction(request);
                break;
          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String searchAction(HttpServletRequest request) {
        ModelBuscar model = (ModelBuscar) request.getAttribute("ModelBuscar");
        Service service = Service.instance();

        try {
            String especialidades = request.getParameter("Especialidad");
           
            if(especialidades == null){
              
             especialidades = ""; 
            
            }
            
            String ciudad = request.getParameter("Ciudad");
            
            if(ciudad == null){
              
             ciudad = ""; 
            
            }
            
            List<Medico> medicos = service.searchMedicos(ciudad, especialidades);
            
            for (Medico m: medicos){
                 m.setCitas(service.searchCita(m.getID()));
            }
            
            model.setMedicos(medicos);
            
            request.setAttribute("ModelBuscar", model);
           
            return "/Buscar.jsp";
            
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
