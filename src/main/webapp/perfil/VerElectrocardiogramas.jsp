<%-- 
    Document   : VerElectrocardiogramas
    Created on : 22-feb-2016, 21:28:44
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
            <img src="../img/electro.jpeg">
            <h1>Electrocardiogramas</h1>
            <hr>
            <div class="content">
                <div class="row">
                    <!--<div class="col-md-4"> 
                        <button type="submit" class="btn btn-default color-boton boton-reporte"><a href="NuevoReporte.jsp" style="color: #333;">Nuevo reporte</a></button>    
                    </div>-->
                </div>
                
                <%
                    String msj = (String) request.getSession().getAttribute("msj-recomendaciones");
                    String estado = (String) request.getSession().getAttribute("estado");
                    String msje = (String) request.getSession().getAttribute("error-recomendaciones");
                    String tipoAlerta = "";
                    if (msj != null && (!msj.equals(""))) {%>
                        <%if(estado.equals("registrado")){
                            tipoAlerta = "alert-success";
                        }else if(estado.equals("pendiente")){
                             tipoAlerta = "alert-warning";
                        }%>
                        <div class="alert <%=tipoAlerta%> fade in col-md-10 col-md-offset-1" style="margin-top: 20px; font-size: 18px;">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Éxito! </strong> <%=msj%> 
                        </div>
                <%
                    request.getSession().removeAttribute("msj-recomendaciones");
                    request.getSession().removeAttribute("estado");
                    } else if (msje != null) {%>
                        <div class="alert alert-danger fade in col-md-4 col-md-offset-4" style="margin-top: 20px; font-size: 18px;">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Error! </strong> <%=msje%> 
                        </div>
                <%request.getSession().removeAttribute("error-recomendaciones");
                    }%>

                <!-- table -->
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Nombre del paciente</th>
                            <th>Fecha de recepción</th>
                            <th>Estatus del reporte</th>
                            <th>Acciones</th>
                        </tr>
                        <c:forEach var="item"
                                   items="${sessionScope.items}">
                            <tr>
                                <td>
                                    <c:out value="${item.nombrePaciente}  ${item.app}  ${item.apm}"/>
                                </td>
                                <td>
                                    <c:out value="${item.fechaReporte}"/>
                                </td>
                                <c:if test="${item.status == 0}">
                                     <td class="revisado">Revisado</td>
                                </c:if>
                                <c:if test="${item.status == 1}">
                                    <td class="pendiente">Pendiente</td>
                                </c:if>
                                <c:if test="${item.status == 2}">
                                    <td class="no-revisado">No revisado</td>
                                </c:if>
                                <td style="margin-left:20px;">
                                    <a href="../ModuloElectrocardiogramas?accion=verECG&idp=${item.id}&idm=${item.idPrueba}&idr=${item.idReporte}" data-toggle="tooltip" title="Generar reporte" ><img src="../img/pencil.png" style="width: 38px; height: 32px;"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
