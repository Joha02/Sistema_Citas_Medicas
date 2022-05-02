<%@page import="logic.Hora"%>
<%@page import="java.util.List"%>
<%@ page import="logic.Medico,java.text.SimpleDateFormat" %>
<% Medico med = (Medico) session.getAttribute("usuario");


    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
<html>
    <head>
        <link rel="icon" href="${pageContext.request.contextPath}/Images/medico.png">
        <%@ include file="/Head.jsp" %>
        <title>SCM</title>
    </head>
    <body>
        <%@ include file="/Header.jsp" %>  
        <div><div class="center"><h1>Información del medico</h1></div>
            <br>
            <table>
                <tr><td>ID</td><td><%= med.getID()%></td></tr>
                <tr><td>Nombre</td><td><%= med.getName()%></td></tr>
      
                <tr><td>Costo</td><td><%= med.getCosto()%></td></tr>

                <tr><td>Direccion</td><td><%= med.getDireccion()%></td></tr>

                <tr><td>Presentacion</td><td><%= med.getInfo()%></td></tr>

                <tr><td>Especialidad</td><td><%= med.getEspecialidad()%></td></tr>

                <tr><td>Localidad</td><td><%= med.getCiudad()%></td></tr>
                <% if(med.getDias() != null){%>
                <tr><td>Dias Laborales</td></tr>
                <% 
                    List<String> dias = med.getDias();
                    for(int i = 0; i < dias.size(); i++){
                %>
                <tr><td><%=dias.get(i)%></td></tr>
                <%}} if(med.getHoras() != null){%>
                <tr><td>Horario</td><tr>
                <% 
                    List<Hora> horas = med.getHoras();
                    for(int i = 0; i < horas.size(); i++){
                %>
                <tr><td><%=horas.get(i)%></td></tr>
                <%}}%>
            </table>
            <br>
            <div class="center">
                <% if (med.getEstado() == 1) { %>
                <h3><a  href="/SCM/presentation/medico/editarPerfilShow">Editar Perfil</a></h3>
                <% }%>
            </div>
            <br>
            <br>
            <br>
            <br>
        </div>
        <%@ include file="/Footer.jsp" %>
    </body>
</html>

