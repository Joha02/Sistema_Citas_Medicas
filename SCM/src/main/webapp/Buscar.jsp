<%@page import="logic.Cita"%>
<%@page import="logic.Medico"%>
<%@page import="java.util.List"%>
<%@page import="presentation.ciudad.ModelCiudad"%>
<%@page import="logic.Ciudad"%>
<%@page import="presentation.buscar.ModelBuscar"%>
<link href="/SCM/CSS/Form.css" rel="stylesheet" type="text/css" /> 

<%-- 
    ¡¡EXCEPCIÓN CON EL MODEL (NULL POINTER)!!
    ModelCiudad model = (ModelCiudad) request.getAttribute("ModelCiudad");
    List<Ciudad> ciudades = model.getCiudades();
--%>
<% ModelBuscar model = (ModelBuscar) request.getAttribute("ModelBuscar");
%>

<html>
    <head>
        <%@ include file="/Head.jsp" %>
        <title>Buscar</title>
    </head>
    <body>
        <%@ include file="/Header.jsp" %>
        <div>
            <h1>&bull; Indicar Datos Compra&bull;</h1>
            <form action = "/SCM/presentation/buscar/buscar" method = "GET">
                <div class="name">
                    <label for="subject"></label>
                    <input  placeholder="Especialidad" type="text" name="Especialidad">
                </div>

                <div class="email">
                    <label for="subject"></label>
                        <input  placeholder="Ciudad" type="text" name="Ciudad">
                </div>


                <div class="submit">
                    <input type="submit" value="Buscar" id="form_button" />
                </div>
            </form>
            <table>  
                <% for (Medico m : model.getMedicos()) {%> 
                <tr>
                    <td><% m.getName(); %></td>
                    <td>
                        <table>
                            <tr>
                                <td>Dia</td>
                                <td>Hora</td>
                            </tr>
                            <% for (Cita c : m.getCitas()) {%> 
                            <tr>
                                <td><% c.getDate(); %></td>
                            </tr>
                            <%}%>
                        </table>
                    </td>
                </tr>
                <%}%>


            </table>
        </div>
    </body>
</html>