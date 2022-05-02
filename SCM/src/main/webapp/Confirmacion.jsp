<%-- 
    Document   : Confirmacion
    Created on : 1 may. 2022, 15:34:14
    Author     : Llerym
--%>

<%@page import="presentation.confirmacion.ModelConfirmacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ModelConfirmacion model = (ModelConfirmacion) request.getAttribute("ModelConfirmacion");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
       <h1>&bull; Confirmación exitosa&bull;</h1>
       <%= model.getCita().getDate() %>
    </body>
</html>
