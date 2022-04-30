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
    <% ModelBuscar model = (ModelBuscar) request.getAttribute("ModelBuscar"); %>

<html>
    <head>
        <%@ include file="/Head.jsp" %>
        <title>Buscar</title>
    </head>
    <body>
        <%@ include file="/Header.jsp" %>
        <div>
            <h1>&bull; Indicar Datos Compra&bull;</h1>
            <form action = "" method = "GET">
                <input type = "hidden" name = "tanda" value="nombre" />
                <div class="name">
                    <label for="subject"></label>
                    <select name="cantGen" >
                        <option disabled hidden selected>Especialidad</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>

                <div class="email">
                    <label for="subject"></label>
                    <select name="cantAM">
                        <option disabled hidden selected>Ciudad</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>


                <div class="submit">
                    <input type="submit" value="Buscar" id="form_button" />
                </div>
            </form>
            <table>  
              <tr>
                <td>Alfreds Futterkiste</td>
                <td>
                <table>
                     <tr>
                       <td>Dia</td>
                       <td>Hora</td>
                     </tr>
                     <tr>
                       <td>Mier 17 de agosto
                       </td>
                       <td>8 am</td>
                     </tr>
                   </table>
                </td>
              </tr>
              
            </table>
        </div>
    </body>
</html>