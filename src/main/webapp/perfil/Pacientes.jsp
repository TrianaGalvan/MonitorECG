<%-- 
    Document   : Pacientes
    Created on : 22-feb-2016, 21:21:28
    Author     : trianaandaluciaprietogalvan
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid tittle">
            <img src="../img/lupa.png">
            <h1>Pacientes</h1>
            <hr>
            <div class="content">
                <%
                        String msj = (String) request.getSession().getAttribute("msj-buscar-paciente");
                        if (msj != null) {%>
                        <div class="row">
                            <div class="alert alert-info fade in col-md-10 col-md-offset-1" style="font-size: 20px;">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Ups!</strong> <%=msj%>
                            </div>
                        </div>
                        <%request.getSession().removeAttribute("msj-buscar-paciente");}
                %>
                <form class="form-horizontal" action="../ModuloPacientes?accion=BuscarPaciente" method="post" accept-charset="UTF-8">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-4">
                                <label>1. Selecciona el filtro de búsqueda del paciente </label>
                            </div>
                            <div class="col-md-4">
                                <select class="form-control" style="font-size: 17px;" name="filtro" onchange="setFormato()" id="tipo-filtro">
                                    <option></option>
                                    <option>Nombre</option>
                                    <option>Correo electrónico</option>
                                    <option>CURP</option>
                                </select>  
                            </div>
                        </div>
                        <br>
                        <div class="row" style="margin-top: -9px;">
                            <div class="col-md-4 ">
                                <label>2. Introduce el parámetro de búsqueda </label>
                            </div>
                            <div class="col-md-4">
                                <input type="text" class="form-control" placeholder="" style="font-size: 19px;" name="valor-filtro" id="valor-filtro">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-6">
                            <button type="submit" class="btn btn-default color-boton pull-right">Buscar</button>    
                        </div>
                    </div>

                </form>
                <div class="row" style="margin-bottom: -10px;margin-top: -10px;">
                    <h2>Lista de pacientes </h2>
                </div>
                <!-- table -->
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Nombre del paciente</th>
                            <th>Acciones</th>
                        </tr>

                        <c:forEach var="item"
                                   items="${sessionScope.pacientes}">
                            <tr>
                                <td>
                                    <c:out value="${item.nombre}  ${item.apellidoPaterno}  ${item.apellidoMaterno}"/>
                                </td>
                                <td style="margin-left:20px;">
                                    <a href="../ModuloPacientes?accion=Historial&idp=${item.idPaciente}" data-toggle="tooltip" title="Historial" ><img src="../img/foler_blue.png" style="width: 38px; height: 32px;"></a>
                                    <a href="../ModuloPacientes?accion=Informacion&idp=${item.idPaciente}" data-toggle="tooltip" title="Perfil"><img src="../img/user_buscar.png" style="width: 55px; height: 48px;"></a>
                                </td>
                            </tr>
                        </c:forEach>
                        <%
                            request.getSession().removeAttribute("pacientes");
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
