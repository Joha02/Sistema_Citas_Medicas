<%@page import="presentation.admin.ModelAdmin"%>
<%@page import="logic.Medico"%>
<%@page import="java.util.List"%>
<%@page import="logic.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Medico> registros = (List<Medico>)session.getAttribute("ListarMedicos");
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
            <caption><h2>SOLICITUDES</h2></caption>
            <tr>
                <th><h2>ID</h2></th>
                <th><h2>Nombre</h2></th>
                <th><h2>Estado</h2></th>
                <th></th>
            </tr>
            <%
                for (int i = 0; i < registros.size(); i++) {
                    Medico med = (Medico) registros.get(i);
            %>
            <tr>
                <td><h3><%=med.getID()%></h3></td>
                <td><h3><%=med.getName()%></h3></td>
                <td><h3>Pendiente</h3></td>
                <td><a href="/SCM/presentation/admin/ListadoMedicosUpdate?medicoID=<%=med.getID()%>" class="buttonClass">Aprobar</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%@ include file="/Footer.jsp" %> 
</body>
</html>
