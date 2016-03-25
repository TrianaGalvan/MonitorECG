<%-- 
    Document   : EditarDatos
    Created on : 22-feb-2016, 13:00:30
    Author     : trianaandaluciaprietogalvan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body>
        <div class="container-fluid">
            <div class="tittle">
                <img src="../img/icon--medico.png">
                <h1>Editar datos registrados</h1>
                <hr>
            </div>

            <div class="content margin-content-tab">                  
                <form class="form-horizontal" action="../ModuloPerfil?accion=GuardarCambios" method="post" novalidate>
                    <div class="form-group">
                        <div class="control-group">
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Nombre:</label>        
                                </div>
                                <div class="col-md-3 control-group">
                                    <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.nombre}" name="nombre"
                                           required
                                           data-validation-required-message="* Campo requerido"
                                           data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                           data-validation-regex-message="Solo se aceptan letras"
                                           >
                                    <div class="warnings">
                                        <p class="help-block style-warnings"></p> 
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <label>Teléfono celular: </label>
                                </div>
                                <div class="col-md-3 control-group">
                                    <c:if test="${sessionScope.cardiologo.telefono != null}">
                                        <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.telefono}" name="telefono">
                                    </c:if>
                                    <c:if test="${sessionScope.cardiologo.telefono == null}">
                                        <input type="text" class="form-control tamano-letra" id="inputEmail3" value="" name="telefono">
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Apellido paterno:</label>        
                                </div>
                                <div class="col-md-3 control-group">
                                    <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.apellidoPaterno}" name="apellidoPaterno"
                                           required
                                           data-validation-required-message="* Campo requerido"
                                           data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                           data-validation-regex-message="Solo se aceptan letras">
                                    <div class="warnings">
                                        <p class="help-block style-warnings"></p> 
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <label>Cédula profesional: </label>
                                </div>
                                <div class="col-md-3 control-group">
                                    <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.cedula}" name="cedula"
                                           required 
                                            data-validation-required-message="* Campo requerido">
                                    <div class="warnings">
                                        <p class="help-block style-warnings"></p> 
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Apellido materno:</label>        
                                </div>
                                <div class="col-md-3 control-group">
                                    <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.apellidoMaterno}" name="apellidoMaterno"
                                           required
                                           data-validation-required-message="* Campo requerido"
                                           data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                           data-validation-regex-message="Solo se aceptan letras">
                                    <div class="warnings">
                                        <p class="help-block style-warnings"></p> 
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <label>Instituto de estudios: </label>
                                </div>
                                <div class="col-md-3  control-group">
                                    <c:if test="${sessionScope.cardiologo.instituto != null}">
                                        <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.instituto}" name="instituto"
                                               data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                               data-validation-regex-message="Solo se aceptan letras">
                                        <div class="warnings">
                                            <p class="help-block style-warnings"></p> 
                                        </div>
                                    </c:if>
                                    <c:if test="${sessionScope.cardiologo.instituto == null}">
                                        <input type="text" class="form-control tamano-letra" id="inputEmail3" value="" name="instituto"
                                               data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                               data-validation-regex-message="Solo se aceptan letras">
                                        <div class="warnings">
                                            <p class="help-block style-warnings"></p> 
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Edad:</label>        
                                </div>
                                <div class="col-md-3">
                                    <c:if test="${sessionScope.cardiologo.edad != 0}">
                                        <input type="number" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.edad}" name="edad">
                                    </c:if>
                                    <c:if test="${sessionScope.cardiologo.edad == 0}">
                                        <input type="number" class="form-control tamano-letra" id="inputEmail3" value="" name="edad">
                                    </c:if>
                                </div>
                                <div class="col-md-3">
                                    <label>Sexo: </label>
                                </div>
                                <div class="col-md-3" style="margin-right: 5px;">
                                    <c:if test="${not empty sessionScope.cardiologo.sexo}">
                                        <c:if test="${sessionScope.cardiologo.sexo eq 'F'}">
                                            <label style="margin-right: 10px;"><input type="radio"  class="tamano-letra" id="inputEmail3" name="sexo" checked value="Femenino"> Femenino</label>
                                            <label><input type="radio"  class="tamano-letra" id="inputEmail3"  name="sexo" value="Masculino"> Masculino</label>
                                            </c:if>
                                            <c:if test="${sessionScope.cardiologo.sexo eq 'M'}">
                                            <label><input type="radio"  class="tamano-letra" id="inputEmail3" name="sexo" value="Femenino"> Femenino</label>
                                            <label><input type="radio"  class="tamano-letra" id="inputEmail3" name="sexo" checked value="Masculino"> Masculino</label>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${empty sessionScope.cardiologo.sexo}">
                                        <label><input type="radio"  class="tamano-letra" id="inputEmail3" value="Femenino" name="sexo">Femenino</label>
                                        <label><input type="radio"  class="tamano-letra" id="inputEmail3" value="Masculino" name="sexo">Masculino</label>
                                        </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>CURP:</label>        
                                </div>
                                <div class="col-md-3 control-group">
                                    <input type="text" class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.curp}" name="curp"
                                           required
                                           data-validation-required-message="* Campo requerido">
                                    <div class="warnings">
                                        <p class="help-block style-warnings"></p> 
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <label>Correo electrónico:</label>        
                                </div>
                                <div class="col-md-3 control-group">
                                    <input class="form-control tamano-letra" id="inputEmail3" value="${sessionScope.cardiologo.correo}" name="correo"
                                            required 
                                            data-validation-required-message="* Campo requerido"
                                            type="email"
                                            data-validation-email-message="Correo inválido">
                                    <div class="warnings">
                                        <p class="help-block style-warnings"></p> 
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" value="${sessionScope.cardiologo.idCardiologo}" name="idCardiologo">
                            <br>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-2 col-md-offset-9">
                                        <button type="submit" class="btn btn-default color-boton pull-right">Guardar</button>    
                                    </div>
                                </div>
                            </div>
                        </div><!--form group-->
                    </div>
                </form>
            </div><!-- content -->
        </div>
    </body>
</html>