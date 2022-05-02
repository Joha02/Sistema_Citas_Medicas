<%@page import="logic.Admin"%>
<%@page import = "logic.Usuario"%>
<% Usuario usuario = (Usuario) session.getAttribute("usuario");
   String url = (String) session.getAttribute("url");
%>

<header>
    <div class="logo">
        <span>Sistema de Citas Médicas</span>
        <img src="/SCM/Images/logo.png">
    </div> 
    <div class="menu">
        <ul> 
            <li>
                <a href="/SCM/index.jsp">Inicio</a>
            </li>
            
            <% if (usuario != null) {%>
            <li >
                <a  href="/SCM<%=url%>">Perfil</a>
            </li>
            <li >
                <a  href="/SCM/presentation/login/logout">Logout</a>
            </li> 
            <% } %>
            <%  if (usuario != null) { %>
                <% if (Integer.valueOf(usuario.getTipo()) == 1) { %>
                    <li>
                        <a href="/SCM/presentation/medico/citas/show">Citas</a>
                    </li>
                <% } %>
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
