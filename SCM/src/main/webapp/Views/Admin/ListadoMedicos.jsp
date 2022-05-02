<%@page import="presentation.admin.ModelAdmin"%>
<%@page import="logic.Medico"%>
<%@page import="java.util.List"%>
<%@page import="logic.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Medico> registros = (List<Medico>)session.getAttribute("ListarMedicos");
    List<Medico> meds = (List<Medico>) session.getAttribute("AllMedicos");
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
        <% if(!registros.isEmpty()){%>
        <table>
            <tbody>
            <caption><h2>SOLICITUDES</h2></caption>
            <tr>
                <th><h3>ID</h3></th>
                <th><h3>Nombre</h3></th>
                <th><h3>Estado</h3></th>
                <th></th>
            </tr>
            <%
                for (int i = 0; i < registros.size(); i++) {
                    Medico med = (Medico) registros.get(i);
            %>
            <tr>
                <td><h4><%=med.getID()%></h4></td>
                <td><h4><%=med.getName()%></h4></td>
                <td><h4>Pendiente</h4></td>
                <td><a href="/SCM/presentation/admin/ListadoMedicosUpdate?medicoID=<%=med.getID()%>" class="buttonClass">Aprobar</a></td>
            </tr>
            <%}%>
        </tbody>
        </table>
        <br>
        <div class="center"> <a href="/SCM/Views/Admin/ViewAdmin.jsp" class="buttonClass">Regresar</a></div>
        <% }%>
        <br><br>
        <table>
            <tbody>
            <caption><h2>LISTA DE MEDICOS</h2></caption>
            <tr>
                <th><h3>ID</h3></th>
                <th><h3>Nombre</h3></th>
                <th><h3>Especialidad</h3></th>
                <th><h3>Localidad</h3></th>
                <th><h3>Direccion</h3></th>
                <th><h3>Estado</h3></th>
                <th></th>
            </tr>
            <%
                for (int i = 0; i < meds.size(); i++) {
                    Medico med = (Medico) meds.get(i);
            %>
            <tr>
                <td><h4><%= med.getID()%></h4></td>
                <td><h4><%= med.getName()%></h4></td>
                <td><h4><%= med.getEspecialidad()%></h4></td>
                <td><h4><%= med.getCiudad()%></h4></td>
                <td><h4><%= med.getDireccion()%></h4></td>
                <% if(med.getEstado() == 0){%>
                <td><h4>Pendiente</h4></td>
                <%} else{%>
                <td><h4>Activo</h4></td>
                <%}%>
            </tr>
            <%}%>
        </tbody>
        </table>    
    <br>
    <div class="center"> <a href="/SCM/Views/Admin/ViewAdmin.jsp" class="buttonClass">Regresar</a></div>
    <br><br><br><br>
    <%@ include file="/Footer.jsp" %> 
</body>
</html>
