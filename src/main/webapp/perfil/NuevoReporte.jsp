<%-- 
    Document   : NuevoReporte
    Created on : 22-feb-2016, 21:20:10
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
                <h1>Generar reporte</h1>
                <hr>
            </div>

            <div class="content">
                <form class="form-horizontal content">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2">
                                <label>Nombre del paciente: </label>
                            </div>
                            <div class="col-md-4">
                                <input type="text" class="form-control tamano-letra" id="inputEmail3">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label>Diagnóstico: </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <textarea class="form-control tam-letra-text" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="row margin-final">
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default boton-guardar-pendiente pull-right">Guardar como pendiente</button>    
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default color-boton">Registrar</button>    
                    </div>
                    <div class="col-md-2 col-md-offset-6">
                        <button type="submit" class="btn btn-default color-boton pull-left"><a href="VerElectrocardiogramas.jsp" style="color: #333;">Cancelar</a></button>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
