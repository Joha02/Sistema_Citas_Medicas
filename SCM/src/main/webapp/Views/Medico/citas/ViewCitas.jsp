<%@page import="java.util.ArrayList"%>
<%@page import="logic.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Cita> citas = (ArrayList<Cita>) session.getAttribute("citasList");%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/Head.jsp" %>
        <title>SCM</title>
        <link rel="icon" href="Images/logo.png">
    </head>
    <body>
        <%@ include file="/Header.jsp" %>
        
        
        <%@ include file="/Footer.jsp" %>
    </body>
</html>

