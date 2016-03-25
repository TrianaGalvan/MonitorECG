<%-- 
    Document   : Informacion
    Created on : 22-feb-2016, 21:15:08
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
            <img src="../img/Student-id.png">
            <h1>información del paciente</h1>
            <hr>
            <div class="content">
                <div class="row">
                    <div class="col-md-6">
                        <fieldset>
                            <legend >Datos personales</legend>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Nombre:</label>        
                                </div>
                                <div class="col-md-5">
                                    <label class="value-label">${sessionScope.paciente.nombre}</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Apellido Paterno: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>${sessionScope.paciente.apellidoPaterno} </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Apellido Materno: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>${sessionScope.paciente.apellidoMaterno} </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Edad: </label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.edad != 0}">
                                        <label>${sessionScope.paciente.edad} años</label>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Sexo: </label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.sexo != null}">
                                        <c:if test="${sessionScope.cardiologo.sexo eq 'F'}">
                                            <label>Femenino</label>
                                        </c:if>
                                        <c:if test="${sessionScope.cardiologo.sexo eq 'M'}">
                                            <label>Masculino</label>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.sexo == null}">
                                        <label>No resgitrado </label>
                                    </c:if>    
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>CURP: </label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.curp != null}">
                                        <label>${sessionScope.paciente.curp} </label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.curp == null}">
                                        <label>No resgitrado </label>
                                    </c:if> 
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="col-md-6">
                        <fieldset>
                            <legend >Datos clínicos</legend>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Peso:</label>        
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.peso != 0}">
                                        <label>${sessionScope.paciente.peso} Kg</label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.peso == 0}">
                                        <label>No resgitrado </label>
                                    </c:if> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Frecuencia respiratoria: </label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.frecuenciaRespiratoria != 0}">
                                        <label>${sessionScope.paciente.frecuenciaRespiratoria} respiraciones por minuto</label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.frecuenciaRespiratoria == 0}">
                                        <label>No resgitrado </label>
                                    </c:if> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Presión arterial:</label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.presionArterial != 0}">
                                        <label>${sessionScope.paciente.presionArterial} mmHg</label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.presionArterial == 0}">
                                        <label>No resgitrado </label>
                                    </c:if> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Altura: </label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.altura != 0}">
                                        <label>${sessionScope.paciente.altura} m</label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.altura == 0}">
                                        <label>No resgitrado </label>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Fecha de actualización: </label>
                                </div>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope.paciente.fechamodificacion != null}">
                                        <label>${sessionScope.paciente.fechamodificacion} </label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.fechamodificacion == null}">
                                        <label>No resgitrado </label>
                                    </c:if>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-2 col-md-offset-8">
                        <button type="submit" class="btn btn-default color-boton pull-right"><a href="Pacientes.jsp" style="color: #333;">Regresar</a></button>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
