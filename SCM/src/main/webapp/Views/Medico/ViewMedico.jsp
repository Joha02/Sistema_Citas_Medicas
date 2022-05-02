<%@ page import="logic.Medico,java.text.SimpleDateFormat" %>
<% Medico med = (Medico) session.getAttribute("usuario");
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/Images/medico.png">
    <%@ include file="/Head.jsp" %>
    <title>SCM</title>
    <link rel="icon" href="Images/logo.png">
</head>
<body>
    <%@ include file="/Header.jsp" %>  
    <h1>Información del medico</h1>
    <br>
    <table>
        <tr><td>Username</td><td><%= med.getID()%></td></tr>
        <tr><td>Name</td><td><%= med.getName()%></td></tr>
        <tr><td>Especialidad</td><td><%= med.getEspecialidad()%></td></tr>
        <tr><td>Costo</td><td><%= med.getCosto()%></td></tr>
        <tr><td>Ciudad</td><td><%= med.getCiudad().getCiudad()%></td></tr>
        <tr><td>Direccion</td><td><%= med.getDireccion()%></td></tr>
        <tr><td>Presentacion</td><td><%= med.getInfo()%></td></tr>
    </table>
    <br>
    
    <% if (med.getEstado() == 1) { %>
        <a  href="/SCM/Views/Medico/EditarPerfil.jsp">Editar Perfil</a>
    <% } %>

    <%@ include file="/Footer.jsp" %>