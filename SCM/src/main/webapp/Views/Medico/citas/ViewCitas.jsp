<%@page import="logic.Medico"%>
<%@page import="java.util.List"%>
<%@page import="presentation.medico.citas.ModelCitas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ModelCitas model = (ModelCitas) request.getAttribute("ModelCitas");
 List<Cita> citas = model.getCitas() ;
 Medico med = model.getMedico();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/Head.jsp" %>
        <title>SCM</title>
        <link rel="icon" href="Images/logo.png">
    </head>
    <body>
        <%@ include file="/Header.jsp" %>
        
        <div> <% for(Cita c:citas){%>
            <div>
    <table>
        <tr><td>ID</td><td><%= c.getId()%></td></tr>
        <tr><td>Medico</td><td><%= med.getName()%></td></tr>
        <tr><td>Especialty</td><td><%= med.getEspecialidad()%></td></tr>
        <tr><td>Costo</td><td><%= med.getCosto()%></td></tr>
        <tr><td>Ciudad</td><td><%= med.getCiudad().getCiudad()%></td></tr>
        <tr><td>Paciente</td><td><%= c.getpaciente().getName()%></td></tr>
        <tr><td>Fecha</td><td><%= c.getDate()%></td></tr>
    </table>
    <div>
        <br>
        <br>
        <br>
    <%}%></div>

                <%--<a href="/proyecto1P4/presentation/medico/citas/cancelarCita?citaId=<%=citas.get(i).getIdCita()%>" class="btn btn-primary">Cancelar</a>--%>
            </div>
        </div>
        
        
        
        <%@ include file="/Footer.jsp" %>
    </body>
</html>

