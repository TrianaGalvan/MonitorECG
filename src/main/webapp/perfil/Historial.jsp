<%-- 
    Document   : HistorialPruebas
    Created on : 22-feb-2016, 21:12:35
    Author     : trianaandaluciaprietogalvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <img src="../img/historial_clinico.png">
            <h1>Historial de pruebas</h1>
            <hr>
            <div class="content">
                <div class="row">
                    <div class="col-md-5"> 
                        <label>Nombre del paciente: &nbsp;&nbsp; </label>
                    </div>
                </div>

                <div class="row">
                    <h2>Historial del paciente</h2>
                </div>

                <!-- table -->
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Fecha del electrocardiograma</th>
                            <th>Hora</th>
                            <th>Estatus</th>
                            <th>Acciones</th>
                        </tr>
                        <c:forEach var="item"
                                   items="${sessionScope.pruebas}">
                            <tr>
                                <td>
                                    <c:out value="${item.fecha}"/>
                                </td>
                                <td>
                                    <c:out value="${item.hora}"/>
                                </td>
                                <c:if test="${item.estatus == 0}">
                                     <td class="revisado">Revisado</td>
                                </c:if>
                                <c:if test="${item.estatus == 1}">
                                    <td class="pendiente">Pendiente</td>
                                </c:if>
                                <c:if test="${item.estatus == 2}">
                                    <td class="no-revisado">No revisado</td>
                                </c:if>
                                </td>
                                <td style="margin-left:20px;">
                                    <a href="../ModuloElectrocardiogramas?accion=verECG&idm=${item.idPrueba}&idr=${item.idReporte}&idp=${item.idPaciente}&pag=historial" data-toggle="tooltip" title="Ver" ><img src="../img/lupa_icono_tabla.png"  style="width: 38px; height: 32px;"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-md-2 col-md-offset-9">
                        <button type="submit" class="btn btn-default color-boton pull-right"><a href="Pacientes.jsp" style="color: #fff;">Regresar</a></button>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
