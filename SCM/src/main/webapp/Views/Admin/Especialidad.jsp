<%@page import="logic.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Especialidad> esp = (List<Especialidad>)session.getAttribute("Especialidades");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="${pageContext.request.contextPath}/Images/administrador.png">
        <title>SCM</title>
        <%@ include file="/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/Header.jsp" %>
        <table>
            <tbody>
            <caption><h2>LISTA DE ESPECIALIDADES</h2></caption>
            <tr>
                <th><h2>Nombre</h2></th>
            </tr>
            <%
                for (int i = 0; i < esp.size(); i++) {
                    Especialidad e = (Especialidad) esp.get(i);
            %>
            <tr>
                <td><h3><%=e.getEspecialidad()%></h3></td>
            </tr>
            <%}%>
        </tbody>
    </table>
        <%@ include file="/Footer.jsp" %> 
    </body>
</html>
