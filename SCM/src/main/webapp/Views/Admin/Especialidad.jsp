<%@page import="logic.Especialidad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Especialidad> esp = (List<Especialidad>) session.getAttribute("Especialidades");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="${pageContext.request.contextPath}/Images/administrador.png">
        <title>SCM</title>
        <%@ include file="/Head.jsp" %>
    </head>
    <body>
        <div>
            <%@ include file="/Header.jsp" %>
            <form class="center" method="POST" action="/SCM/presentation/admin/EspecialidadIngresar">
                <div><h3>AGREGAR ESPECIALIDAD</h3></div>
                <div><input placeholder="Nombre de Especialidad" id="especialidad" name="especialidad" value="" type="text" required>
                    <button id="btnAgregar" type="submit" class="">Agregar</button>
                    <br></br>
                </div>
            </form>
            <table>
                <tbody>
                <caption><h3>LISTA DE ESPECIALIDADES</h3></caption>
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
            <br><br><br><br>
        </div>
    </body>
    <%@ include file="/Footer.jsp" %> 
</html>
