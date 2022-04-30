<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="presentation.login.ModelLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="${pageContext.request.contextPath}/Images/login.png">
        <%@ include file="/Head.jsp" %>
    </head>
    <body >
        <%@ include file="/Header.jsp" %>

        <% ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin"); %>
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
        <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>

        <form style="text-align: center" name="usuario" action="/SCM/presentation/login/login" method="POST" > 
            <table class="tableCenter">
            <div><h2>Login</h2></div>
            <div><h2></h2></div>
            <div class="fila"> 
                <img src="${pageContext.request.contextPath}/Images/usuario.png" width="20" height="20"/>
                <input class="<%=erroneo("IDFld", errores)%>" placeholder="ID User" type="text" name="IDFld" value="<%=form.get("IDFld")[0]%>" title="<%=title("IDFld", errores)%>" required>
            </div>
            <div><h2></h2></div>
            <div class="fila">
                <img src="${pageContext.request.contextPath}/Images/contraseña.png" width="20" height="20"/>
                <input class="<%=erroneo("passwordFld", errores)%>" placeholder="Password User" type="password" name="passwordFld" value="<%=form.get("passwordFld")[0]%>" title="<%=title("passwordFld", errores)%>"  required>
            </div>
            <div><h2></h2></div>
            <div>
                <input type="radio" name="tipo" value="1" checked> <img src="${pageContext.request.contextPath}/Images/medico.png" width="50" height="50">
                <input type="radio" name="tipo" value="2"> <img src="${pageContext.request.contextPath}/Images/paciente.png" width="50" height="50">
                <input type="radio" name="tipo" value="3"> <img src="${pageContext.request.contextPath}/Images/administrador.png" width="50" height="50">
            </div>
            <div><h2></h2></div>
            <div><input type="submit" name="loginBoton" value="Ingresar"></div> 
            </table>
        </form>
        <%@ include file="/Footer.jsp" %>                  
    </body>
</html>

<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "error";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(ModelLogin model) {
        Map<String, String[]> values = new HashMap<>();
        values.put("IDFld", new String[]{model.getCurrent().getID()});
        values.put("passwordFld", new String[]{model.getCurrent().getPassword()});
        return values;
    }
%> 

