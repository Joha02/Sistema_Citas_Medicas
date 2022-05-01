<%@page import = "logic.Usuario"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");  %>

<header>
    <div class="logo">
        <span>Sistema de Citas M�dicas</span>
        <img src="/SCM/Images/logo.png">
    </div> 
    <div class="menu">
        <ul> 
            <li>
                <a href="/SCM/index.jsp">Inicio</a>
            </li>
            
            <% if (usuario != null) { %>
            <li >
                <a  href="/SCM/presentation/login/logout">Logout</a>
            </li> 
            <% } %>
            
            <% if (usuario == null) {%>
            <li>
                <a href="/SCM/presentation/login/show">Login</a>
            </li>
            
            <li>
                <a href="/SCM/presentation/registro/show">Registrarse</a>
            </li>
            <% } %>
            <li>
                <a href="/SCM/About.jsp">About</a>
            </li>
            <li >
                <a  href="/SCM/presentation/buscar/show">Buscar</a>
            </li> 
        </ul>
    </div>
</header>  
