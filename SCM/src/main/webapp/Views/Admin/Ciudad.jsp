<%@page import="logic.Ciudad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Ciudad> ciu = (List<Ciudad>) session.getAttribute("Ciudades");
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
            <form class="center" method="POST" action="/SCM/presentation/admin/CiudadIngresar">
                <div><h3>AGREGAR CIUDAD</h3></div>
                <div><input placeholder="Nombre de la ciudad" id="ciu" name="ciudad" value="" type="text" required>
                    <button id="btnAgregar2" type="submit" class="">Agregar</button>
                    <br></br>
                </div>
            </form>
            <table>
                <tbody>
                <caption><h3>LISTA DE CIUDADES</h3></caption>
                <%
                    for (int i = 0; i < ciu.size(); i++) {
                        Ciudad c = (Ciudad) ciu.get(i);
                %>
                <tr>
                    <td><h3><%=c.getCiudad()%></h3></td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <br>
            <div class="center"> <a href="/SCM/Views/Admin/ViewAdmin.jsp" class="buttonClass">Regresar</a></div>
            <br><br><br><br>
        </div>
    </body>
    <%@ include file="/Footer.jsp" %> 
</html>
