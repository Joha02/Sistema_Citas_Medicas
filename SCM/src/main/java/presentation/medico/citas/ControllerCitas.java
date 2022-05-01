/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package presentation.medico.citas;

import logic.Cita;
import logic.Medico;
import logic.Paciente;
import logic.Service;
import logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MedicoCitasController", urlPatterns = {"/presentation/medico/citas/cancelarCita","/presentation/medico/citas/show","/presentation/paciente/citas/show"})
public class ControllerCitas extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        //response.setContentType("text/html;charset=UTF-8");
        
        
        request.setAttribute("model", new ModelCitas());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/medico/citas/show":
                viewUrl = this.showMedico(request);
                break;
            /*case "/presentation/paciente/citas/show":
                viewUrl = this.showPaciente(request);
                break;
            /*case "/presentation/medico/citas/cancelarCita":
                viewUrl = this.cancelarCitaMedico(request);
                break;*/
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String showMedico(HttpServletRequest request) throws Exception {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) throws Exception {
        
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
 
        Medico medico = (Medico) session.getAttribute("medico");
        ArrayList<Cita> citas = (ArrayList<Cita>) service.seachCitasByMedico(medico.getID());
        
            
        System.out.println("sizeArray->"+citas.size());
        for(int i=0;i<=citas.size()-1;i++){
            citas.get(i).setMedico(medico);
        }
        
        session.setAttribute("citasList", citas);
        
        try {     
            
            return "/Views/Medico/citas/ViewCitas.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    /*public String showPaciente(HttpServletRequest request) throws Exception{
        
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
 
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        ArrayList<Cita> citas = (ArrayList<Cita>) service.seachCitasByPaciente(paciente.getID());
        
            
        for(int i=0;i<=citas.size()-1;i++){
            citas.get(i).setpaciente(paciente);
            
        }
        
        session.setAttribute("citasList", citas);
        
        return "/presentation/paciente/cita/view.jsp";
    }
    
    /*public String cancelarCitaMedico(HttpServletRequest request) throws Exception{
        
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
 
        String idCita = request.getParameter("citaId");
        System.out.println("IDCITA->"+idCita);
        //Cita paciente = service.findPaciente(idPaciente);
//        Paciente paciente = (Paciente) session.getAttribute("paciente");

        service.eliminarCita(idCita);
        
        return "/presentation/medico/citas/view.jsp";
    }*/
    
    

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
        } catch (Exception ex) {
            Logger.getLogger(ControllerCitas.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(ControllerCitas.class.getName()).log(Level.SEVERE, null, ex);
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
