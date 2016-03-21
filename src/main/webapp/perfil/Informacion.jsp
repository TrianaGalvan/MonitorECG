<%-- 
    Document   : Informacion
    Created on : 22-feb-2016, 21:15:08
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
                                    <label class="value-label">Triana Andalucia</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Apellido Paterno: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>Prieto </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Apellido Materno: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>Galván </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Edad: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>25 </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Sexo: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>Femenino </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>CURP: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>PIGT950402MOCRLR08 </label>
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
                                    <label class="value-label">59 Kg</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Frecuencia cardiaca: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>No registrado</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Presión arterial:</label>
                                </div>
                                <div class="col-md-5">
                                    <label>No registrado</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Altura: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>1.60 m</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Fecha de actualización: </label>
                                </div>
                                <div class="col-md-5">
                                    <label>01/01/2016</label>
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
