<%@page import="logic.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="presentation.paciente.citas.ModelCitas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ModelCitas model = (ModelCitas) request.getAttribute("ModelCitas");
 List<Cita> citas = model.getCitas() ;
 Paciente pac = model.getPaciente();
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
        <tr><td>Paciente</td><td><%= pac.getName()%></td></tr>
        <tr><td>Especialty</td><td><%= c.getMedic().getName()%></td></tr>
        <tr><td>Costo</td><td><%= c.getMedic().getCosto()%></td></tr>
        <tr><td>Ciudad</td><td><%= c.getMedic().getCiudad().getCiudad()%></td></tr>
        <tr><td>Paciente</td><td><%= c.getpaciente().getName()%></td></tr>
        <tr><td>Fecha</td><td><%= c.getDate()%></td></tr>
    </table>
    <div>
        <br>
        <br>
        <br>
    <%}%></div>
            </div>
        </div>
        
        
        
        <%@ include file="/Footer.jsp" %>
    </body>
</html>

