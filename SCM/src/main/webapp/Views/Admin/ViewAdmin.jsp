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
    <table>
        <tbody>
            <caption><h3>PERFIL ADMINISTRADOR</h3></caption>
        <tr>
            <th><h2>Username</h2></th>
            <th><h2>Name</h2></th>
        </tr>
        <tr>
            <td><h3><%= adm.getID()%></h3></td>
            <td><h3><%= adm.getName()%></h3></td>
        </tr>
        </tbody>
    </table><br>
    <div class="center">
        <h4><a href="/SCM/presentation/admin/ListadoMedicosShow">Ver/Aceptar Solicitudes de Medicos</a></h4>
        <h4><a href="/SCM/presentation/admin/EspecialidadShow">Ver/Agregar Especialidades</a></h4>
        <h4><a href="/SCM/presentation/admin/CiudadShow">Ver/Agregar Ciudades</a></h4>
    </div>

    <%@ include file="/Footer.jsp" %>
