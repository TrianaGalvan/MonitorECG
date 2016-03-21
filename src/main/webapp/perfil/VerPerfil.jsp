<%-- 
    Document   : VerPerfil
    Created on : 22-feb-2016, 21:29:51
    Author     : trianaandaluciaprietogalvan
--%>

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
                        <div class="margin-content-tab">
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Nombre:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">Triana Andalucia</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Teléfono celular: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>55-12-97-01-16</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Apellido paterno:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">Prieto</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Ceddula profesional: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>908183</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Apellido materno:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">Galván</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Instituto de estudios: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>Escuela Superior de medicina</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Edad:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">40 años</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Sexo: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>Femenino</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>CURP:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">PIGT940502MOCRLR08</label>
                                </div>
                                <div class="col-md-3">
                                    <label>Nombre de usuario: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>Triana Galván</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Correo electrónico:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">trianagalvan@gmail.com</label>
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
                            <h2>Cambiar contraseña</h2>   

                            <form class="form-horizontal col-md-offset-2">
                                <div class="form-group">    
                                    <div class="row">
                                        <div class="col-md-3">
                                            <label class="pull-right">Introduce tu contraseña: </label>    
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control col-md-3" id="usr">
                                        </div>
                                    </div> 
                                    <div class="row">
                                        <div class="col-md-3">
                                            <label class="pull-right">Nueva contraseña: </label>    
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control col-md-3" id="usr">
                                        </div>
                                    </div> 
                                    <div class="row">
                                        <div class="col-md-3">
                                            <label class="pull-right">Confirmar contraseña: </label>    
                                        </div>
                                        <div class="col-md-3">
                                            <input type="text" class="form-control col-md-3" id="usr">
                                        </div>
                                    </div> 
                                </div>
                                <div class="col-md-2 col-md-offset-4">
                                    <button type="submit" class="btn btn-default color-boton pull-right">Guardar</button>    
                                </div>
                            </form>
                        </div><!-- margin content tab-->
                    </div><!-- tab seguridad -->
                </div>
            </div>
        </div>
    </body>
</html>
