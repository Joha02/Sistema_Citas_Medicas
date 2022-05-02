<%@page import="logic.Ciudad"%>
<%@page import="logic.Service"%>
<%@page import="java.util.List"%>
<%@page import="logic.Especialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Service service = Service.instance();
    List<Especialidad> espec = (List<Especialidad>) session.getAttribute("Especialidades");
    List<Ciudad> ciu = (List<Ciudad>) session.getAttribute("Ciudades");
    List<Integer> frec = service.getFrecuencias();
    List<Integer> costos = service.getCostos();
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="${pageContext.request.contextPath}/Images/medico.png">
        <%@ include file="/Head.jsp" %>
        <title>SCM</title>
    </head>
    <body>
        <%@ include file="/Header.jsp" %>  
        <form class="center" method="POST" action="/SCM/presentation/medico/actualizarPerfil">
            <table class="tableCenter">
                <tbody>
                <caption><h3>EDITAR PERFIL</h3><caption>
                        <tr>
                            <td><label>Nombre </label></td>
                            <td><input placeholder="New Name" id="NName" name="namem" value="" type="text" style="width: 228px;"></td>
                        </tr>
                        <tr>
                            <td><label>Contraseña </label></td>
                            <td><input placeholder="New Password" id="NPassword" name="passwordm" value="" type="text" style="width: 228px;"></td>
                        </tr><br>
                        <tr>
                            <td><label>Dirección </label></td>
                            <td><input placeholder="Dirección Fisica" id="DirecF" name="direccionm" value="" type="text" style="width: 228px; height: 98px"></td>
                        </tr><br>
                        <tr>
                            <td><label>Presentación </label></td>
                            <td><input placeholder="Presentación" id="Present" name="presentacionm" value="" type="text" style="width: 228px; height: 98px"></td>
                        </tr><br>
                        <tr>
                            <td><label>Especialidad </label></td>
                            <td>
                                <select id="Espec" name="especialidadm" style="width: 228px;">
                                    <%for (int i = 0; i < espec.size(); i++) {%>
                                    <option value="<%=espec.get(i).getEspecialidad()%>"><%=espec.get(i).getEspecialidad()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Localidad </label></td>
                            <td>
                                <select id="Ciu" name="ciudadm" style="width: 228px;">
                                    <%for (int i = 0; i < ciu.size(); i++) {%>
                                    <option value="<%=ciu.get(i).getCiudad()%>"><%=ciu.get(i).getCiudad()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Costo </label></td>
                            <td>
                                <select id="Cos" name="costom" style="width: 228px;">
                                    <%for (int i = 0; i < costos.size(); i++) {%>
                                    <option value="<%=costos.get(i)%>"><%=costos.get(i)%> colones</option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Dias de Citas</label></td>
                            <td>
                                <input type="checkbox" name="L" value="L">LUNES<br>
                                <input type="checkbox" name="K" value="K">MARTES<br>
                                <input type="checkbox" name="M" value="M">MIÉRCOLES<br>
                                <input type="checkbox" name="J" value="J">JUEVES<br>
                                <input type="checkbox" name="V" value="V">VIERNES<br>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Frecuencia de Citas</label></td>
                            <td>
                                <select id="Fre" name="frecuenciam" style="width: 228px;">
                                    <%for (int i = 0; i < frec.size(); i++) {
                                            if (frec.get(i) > 10) {
                                    %>
                                    <option value="<%=frec.get(i)%>"><%=frec.get(i)%> Min</option>
                                    <%} else {%>
                                    <option value="<%=frec.get(i)%>"><%=frec.get(i)%> Hrs</option>
                                    <%}}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Hora Inicio Jornada Laboral</label></td>
                            <td>
                                <input type="radio" name="iniciom" value="8">8:00<br>
                                <input type="radio" name="iniciom" value="9">9:00<br>
                                <input type="radio" name="iniciom" value="10">10:00<br>
                                <input type="radio" name="iniciom" value="11">11:00<br>
                                <input type="radio" name="iniciom" value="13">13:00<br>
                            </td>
                        </tr>
                        <tr>
                            <td><label>Hora Fin Jonada Laboral</label></td>
                            <td>
                                <input type="radio" name="finm" value="14">14:00<br>
                                <input type="radio" name="finm" value="15">15:00<br>
                                <input type="radio" name="finm" value="16">16:00<br>
                                <input type="radio" name="finm" value="17">17:00<br>
                                <input type="radio" name="finm" value="18">18:00<br>
                            </td>
                        </tr>
                <tbody>
            </table>
            <br>
            <button class="center" id="btnActualizar" type="submit" class="">Actualizar</button>                  
            <br><br><br><br>                    
        </form>
        <%@ include file="/Footer.jsp" %>
    </body>
</html>
