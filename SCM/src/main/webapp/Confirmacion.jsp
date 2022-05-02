<%-- 
    Document   : Confirmacion
    Created on : 1 may. 2022, 15:34:14
    Author     : Llerym
--%>

<%@page import="presentation.confirmacion.ModelConfirmacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/SCM/CSS/Form.css" rel="stylesheet" type="text/css" /> 
<% ModelConfirmacion model = (ModelConfirmacion) request.getAttribute("ModelConfirmacion");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/Head.jsp" %>
        <title>Confirmacion</title>
    </head>
    <body>
         <%@ include file="/Header.jsp" %>
         <table>  
            <tr>
                <th colspan="2">&bull; Confirmación exitosa&bull;</th>
            </tr>
            <tr>
                <td> <b> Horario: </b></td>
                <td><%= model.getCita().getDate().split(" ")[0] %> - <%= model.getCita().getDate().split(" ")[1] %></td>
            </tr>
            <tr>
                <td> <b> Medico </b></td>
                <td><%= model.getMedico().getName() %> - <%= model.getMedico().getEspecialidad() %> - <%= model.getMedico().getCiudad().getCiudad()%></td>
            </tr>
             <tr>
                <td> <b> Paciente </b></td>
                <td><%= model.getCurrent().getName() %></td>
            </tr>
       </table>
    </body>
</html>
