<%@page import="logic.Registro"%>
<%@page import="logic.Medico"%>
<%@page import="java.util.List"%>
<%@page import="logic.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Service service = Service.instance();
    List registros = service.getRegistros();
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
                <tr><h2>SOLICITUDES: </h2></tr>
        
            <%
                for (int i = 0; i < registros.size(); i++) {
                    Registro reg = (Registro) registros.get(i);
                    Medico med = reg.getMedico();
            %>
            <tr>
            <td><h2>ID: </h2><h3><%=med.getID()%></h3></td>
            <td><h2>Nombre: </h2><h3><%=med.getName()%></h3></td>
            <td><h2>Estado: </h2>
                <%if (med.getEstado() == 0) {%>
                <h3> Pendiente</h3>
                <%} else {%>
                <h3> Abrobado</h3>
                <%}%>
            </td>
            <%-- Boton Aprobar--%>
        </tr>
            <%}%>
            </tbody>
    </table>
    <%@ include file="/Footer.jsp" %> 
</body>
</html>
