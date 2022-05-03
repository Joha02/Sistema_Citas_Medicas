<%@page import="logic.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="presentation.paciente.citas.ModelCitas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ModelCitas model = (ModelCitas) request.getAttribute("ModelCitas");%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/Head.jsp" %>
        <title>SCM</title>
        <link rel="icon" href="Images/logo.png">
    </head>
    <body>
        <%@ include file="/Header.jsp" %>
        
        <table>
            <% for(Cita c : model.getCitas()){%> 
         
                <tr><td>ID</td><td><%= c.getId()%></td></tr>
                <tr><td>Paciente</td><td><%= c.getPacient().getName() %></td></tr>
                <tr><td>Especialty</td><td><%= c.getMedic().getName()%></td></tr>
                <tr><td>Costo</td><td><%= c.getMedic().getCosto()%></td></tr>
                <tr><td>Ciudad</td><td><%= c.getMedic().getCiudad().getCiudad()%></td></tr>
                <tr><td>Paciente</td><td><%= c.getpaciente().getName()%></td></tr>
                <tr><td>Fecha</td><td><%= c.getDate()%></td></tr>
          
             <%}%>
        </table>
          
            
        
        <%@ include file="/Footer.jsp" %>
    </body>
</html>

