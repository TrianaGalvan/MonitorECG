<%-- 
    Document   : VerPerfil
    Created on : 22-feb-2016, 21:29:51
    Author     : trianaandaluciaprietogalvan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="tittle">
                <img src="../img/icon--medico.png">
                <h1>Perfil</h1>
                <hr>
            </div>

            <div class="content">
                <!-- tabs --> 
                <div>
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active tamano-letra-tabs"><a href="#datosPersonales" aria-controls="home" role="tab" data-toggle="tab">Datos personales</a></li>
                        <li role="presentation" class="tamano-letra-tabs"><a href="#datosClinicos" aria-controls="profile" role="tab" data-toggle="tab">Seguridad</a></li>
                    </ul>
                </div>

                <div class="tab-content">

                    <div role="tabpanel" class="tab-pane fade in active" id="datosPersonales">
                        <%
                            String msj = (String) request.getSession().getAttribute("msj-guardar-cambios");
                            String msje = (String) request.getSession().getAttribute("msj-error-guardar-cambios");
                            String msjc = (String) request.getSession().getAttribute("msj-error-guardar-cambios");

                            if (msj != null) {%>
                        <div class="row">
                            <div class="alert alert-success fade in col-md-8 col-md-offset-2" style="margin-top: 10px;  margin-bottom: -10px; font-size: 18px;">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Éxito! </strong> <%=msj%> 
                            </div>
                        </div>
                        <%request.getSession().removeAttribute("msj-guardar-cambios");
                                    } else if (msje != null) {%>
                        <div class="row">
                            <div class="alert alert-danger fade in col-md-8 col-md-offset-2" style="margin-top: 10px;  margin-bottom: -10px;  font-size: 18px;">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Ups! </strong> <%=msje%> 
                            </div>
                        </div>
                        <%request.getSession().removeAttribute("msj-error-guardar-cambios");
                                    } else if (msjc != null) {%>
                        <div class="row">
                            <div class="alert alert-info fade in col-md-8 col-md-offset-2" style="margin-top: 10px;  margin-bottom: -10px;  font-size: 18px;">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Ups! </strong> <%=msjc%> 
                            </div>
                        </div>
                        <%}
                        %>
                        <div class="margin-content-tab">
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Nombre:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">${sessionScope.cardiologo.nombre}</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Teléfono celular: </label>
                                </div>
                                <div class="col-md-3">
                                    <c:if test="${sessionScope.cardiologo.telefono != null}">
                                        <label>${sessionScope.cardiologo.telefono}</label>
                                    </c:if>
                                    <c:if test="${sessionScope.cardiologo.telefono == null}">
                                        <label>No registrado</label>
                                    </c:if>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Apellido paterno:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">${sessionScope.cardiologo.apellidoPaterno}</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Cédula profesional: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>${sessionScope.cardiologo.cedula}</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Apellido materno:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">${sessionScope.cardiologo.apellidoMaterno}</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Instituto de estudios: </label>
                                </div>
                                <div class="col-md-3">
                                    <c:if test="${sessionScope.cardiologo.instituto != null}">
                                        <label>${sessionScope.cardiologo.instituto}</label>
                                    </c:if>
                                    <c:if test="${sessionScope.cardiologo.instituto == null}">
                                        <label>No registrado</label>
                                    </c:if> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Edad:</label>        
                                </div>
                                <div class="col-md-3">
                                    <c:if test="${sessionScope.cardiologo.edad != 0}">
                                        <label>${sessionScope.cardiologo.edad} años</label>
                                    </c:if>
                                    <c:if test="${sessionScope.cardiologo.edad == 0}">
                                        <label>No registrado</label>
                                    </c:if>
                                </div>
                                <div class="col-md-3">
                                    <label>Sexo: </label>
                                </div>
                                <div class="col-md-3">
                                    <c:if test="${not empty sessionScope.cardiologo.sexo}">
                                        <c:if test="${sessionScope.cardiologo.sexo eq 'F'}">
                                            <label>Femenino</label>
                                        </c:if>
                                        <c:if test="${sessionScope.cardiologo.sexo eq 'M'}">
                                            <label>Masculino</label>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${empty sessionScope.cardiologo.sexo}">
                                        <label>No registrado</label>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>CURP:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">${sessionScope.cardiologo.curp}</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Correo electrónico:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">${sessionScope.cardiologo.correo}</label>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-md-2 col-md-offset-8">
                                <button type="submit" class="btn btn-default color-boton pull-right"><a href="EditarDatos.jsp" style="color: #333">Editar datos</a></button>    
                            </div>
                        </div>
                    </div>

                    <div role="tabpanel" class="tab-pane fade" id="datosClinicos">
                        <div class="margin-content-tab">
                            <%
                                String msjpass = (String)request.getSession().getAttribute("msj-cambio-contrasena");
                                String msjepass = (String)request.getSession().getAttribute("msj-error-cambio-contrasena");
                                if(msjepass != null){%>
                                    <div class="row">
                                        <div class="alert alert-danger fade in col-md-8 col-md-offset-2" style="margin-top: 10px;  margin-bottom: -10px; font-size: 18px;">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            <strong>Ups! </strong> <%=msjepass%> 
                                        </div>
                                    </div>
                                <%}else if(msjpass != null){%>
                                    <div class="row">
                                        <div class="alert alert-success fade in col-md-8 col-md-offset-2" style="margin-top: 10px;  margin-bottom: -10px; font-size: 18px;">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            <strong>Éxito! </strong> <%=msjpass%> 
                                        </div>
                                    </div>
                                <%}%>
                            <h2>Cambiar contraseña</h2>   

                                <form class="form-horizontal col-md-offset-2" action="../ModuloPerfil?accion=CambiarCotrasena" method="post" novalidate>
                                    <div class="form-group"> 
                                        <div class="control-group">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <label class="pull-right">Nueva contraseña: </label>    
                                                </div>
                                                <div class="col-md-3">
                                                    <input type="password" class="form-control col-md-3" id="usr" name="contrasena"
                                                           required 
                                                           data-validation-required-message="* Campo requerido">
                                                    <div class="warnings">
                                                        <p class="help-block style-warnings"></p> 
                                                    </div>  
                                                </div>
                                            </div> 
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <label class="pull-right">Confirmar contraseña: </label>    
                                                </div>
                                                <div class="col-md-3 control-group">
                                                    <input type="password" class="form-control col-md-3" id="usr"
                                                           required 
                                                           data-validation-required-message="* Campo requerido"
                                                           data-validation-match-match="contrasena"
                                                           data-validation-match-message="No coinciden las contraseñas">
                                                    <div class="warnings">
                                                        <p class="help-block style-warnings"></p> 
                                                    </div>
                                                </div>
                                            </div> 
                                            <div class="form-actions">
                                                <div class="col-md-2 col-md-offset-4">
                                                    <button type="submit" class="btn btn-default color-boton pull-right">Guardar</button>    
                                                </div>
                                            </div>                                        
                                        </div> 
                                    </div>
                                </form>
                        </div><!-- margin content tab-->
                    </div><!-- tab seguridad -->
                </div>
            </div>
        </div>
    </body>
</html>
