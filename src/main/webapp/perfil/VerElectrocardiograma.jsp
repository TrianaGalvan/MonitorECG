<%-- 
    Document   : VerElectrocardiograma
    Created on : 22-feb-2016, 21:27:01
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
            <!-- tittle of page -->
            <div class="row tittle">
                <img src="../img/electro.jpeg">
                <h1>Visualizar &nbsp; electrocardiograma</h1>
                <hr>    
            </div>

            <div class="content">
                <div class="row fecha-electrocardiograma">
                    <div class="col-md-3">
                        <label>Fecha del electrocardiograma</label>
                    </div>
                    <div class="col-md-3">
                        <label>01/07/2015</label>
                    </div>
                </div>
                <div class="row">
                    <fieldset>
                        <legend >Información general</legend>
                        <div class="row">
                            <div class="col-md-2">
                                <label>Nombre:</label>        
                            </div>
                            <div class="col-md-3">
                                <label class="value-label">Triana Andalucia Prieto Galván</label>
                            </div>
                            <div class="col-md-3">
                                <label>Frecuencia cardiaca: </label>
                            </div>
                            <div class="col-md-3">
                                <label>No registrado</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2">
                                <label>Edad: </label>
                            </div>
                            <div class="col-md-3">
                                <label>21 años </label>
                            </div>
                            <div class="col-md-3">
                                <label>Presión arterial: </label>
                            </div>
                            <div class="col-md-3">
                                <label>No registrado </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2">
                                <label>Peso: </label>
                            </div>
                            <div class="col-md-3">
                                <label>59 Kg </label>
                            </div>
                            <div class="col-md-3">
                                <label>Altura: </label>
                            </div>
                            <div class="col-md-3">
                                <label>1.59 m </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <label>Notas adicionales del electrocardiograma: </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <textarea class="form-control" rows="5" ></textarea>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-4 pull-left">
                        <label>Selecciona el tipo de gráfica a visualizar: </label>
                    </div> 
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <label class="checkbox-inline"><input type="checkbox" value="">Electrocardiograma completo</label>
                    </div>
                    <div class="col-md-3">
                        <label class="checkbox-inline"><input type="checkbox" value="">Complejo QRS</label>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default color-boton pull-right">Gráficar</button>    
                    </div>
                </div>
                <br>
                <!-- grafica --> 
                <div class="row">
                    <div class="col-md-12" >
                        <img src="../img/grafica.png" class="grafica">
                    </div>
                </div>

                <div class="row">
                   <div class="col-md-3">
                        <label>Diágnostico de electrocardiograma:</label>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <textarea class="form-control text-diagnostico" rows="8"></textarea>
                    </div>
                </div>
                <br>
                <!-- botones --> 
                <div class="row margin-final">
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default boton-guardar-pendiente">Guardar como pendiente</button>    
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default color-boton">Registrar</button>    
                    </div>
                    <div class="col-md-2 col-md-offset-6">
                        <button type="submit" class="btn btn-default color-boton pull-right"><a href="VerElectrocardiogramas.jsp" style="color: #333;">Cancelar</a></button>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
