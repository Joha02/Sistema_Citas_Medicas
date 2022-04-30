<%@ page import="logic.Admin,java.text.SimpleDateFormat" %>
<% Admin adm = (Admin) session.getAttribute("usuario");
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/Images/administrador.png">
    <%@ include file="/Head.jsp" %>
    <title>SCM</title>
    <link rel="icon" href="Images/logo.png">
</head>
<body>
    <%@ include file="/Header.jsp" %>  
    <h1>Información del admin</h1>
    <br>
    <table>
        <tr><td>Username</td><td><%= adm.getID()%></td></tr>
        <tr><td>Name</td><td><%= adm.getName()%></td></tr>
    </table><br>
        <h2><a href="/SCM/presentation/admin/ListadoMedicosShow">Listado Medicos</a></h2>
        <h2><a href="/SCM/presentation/admin/EspecialidadShow">Registrar Especialidad</a></h2>
        <h2><a href="/SCM/Views/Admin/Ciudad.jsp">Agregar Ciudad</a></h2>

    <%@ include file="/Footer.jsp" %>
