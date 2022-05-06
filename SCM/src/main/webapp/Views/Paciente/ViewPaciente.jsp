<%@ page import="logic.Paciente,java.text.SimpleDateFormat" %>
<% 
    Paciente pat = (Paciente) session.getAttribute("usuario");
%>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/Images/paciente.png">
    <%@ include file="/Head.jsp" %>
    <title>SCM</title>
    <link rel="icon" href="Images/logo.png">
</head>
<body>
    <%@ include file="/Header.jsp" %>  
    <h1>Información del paciente</h1>
    <br>
    <table>
        <tr><td>Username</td><td><%= pat.getID()%></td></tr>
        <tr><td>Name</td><td><%= pat.getName()%></td></tr>

    </table><br>

    <%@ include file="/Footer.jsp" %>
</body>

<%--
<!DOCTYPE html>
<head>
        <%@ include file="/Head.jsp" %>
        <title>SCM</title>
        <link rel="icon" href="Images/logo.png">
    </head>
    <body>
        <%@ include file="/Header.jsp" %>  
        <h1>Información del paciente</h1>
        <br>
	<table>
		<tr><td>Username</td><td>111</td></tr>
		<tr><td>Nombre</td><td>Ana Martinez</td></tr>

	</table><br>
        
        <%@ include file="/Footer.jsp" %>
    </body>--%>
