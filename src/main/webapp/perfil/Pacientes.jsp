<%-- 
    Document   : Pacientes
    Created on : 22-feb-2016, 21:21:28
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
            <img src="../img/lupa.png">
            <h1>Pacientes</h1>
            <hr>
            <div class="content">
                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-4">
                                <label>1. Selecciona el filtro de búsqueda del paciente </label>
                            </div>
                            <div class="col-md-4">
                              <select class="form-control">
                                  <option></option>
                                  <option>Nombre</option>
                                  <option>Correo electrónico</option>
                                  <option>CURP</option>
                                </select>  
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-md-4 ">
                                <label>2. Introduce el parámetro de búsqueda </label>
                            </div>
                            <div class="col-md-4">
                                <input type="text" class="form-control" placeholder="">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-6">
                            <button type="submit" class="btn btn-default color-boton pull-right">Buscar</button>    
                        </div>
                    </div>

                </form>

                <div class="row">
                    <h2>Lista de pacientes </h2>
                </div>

                <!-- table -->
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Nombre del paciente</th>
                            <th>Acciones</th>
                        </tr>
                        <tr>
                            <td>Prieto Galván Triana Andalucia</td>
                            <td style="margin-left:20px;">
                                <a href="Historial.jsp" data-toggle="tooltip" title="Historial" ><img src="../img/foler_blue.png" style="width: 38px; height: 32px;"></a>
                                <a href="Informacion.jsp" data-toggle="tooltip" title="Perfil"><img src="../img/user_buscar.png" style="width: 55px; height: 48px;"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>Peña Velarde Jesus Daniel</td>
                            <td>
                                <a href="#" data-toggle="tooltip" title="Historial"><img src="../img/foler_blue.png" style="width: 38px; height: 32px;"></a>
                                <a href="#" data-toggle="tooltip" title="Perfil"><img src="../img/user_buscar.png" style="width: 55px; height: 48px;"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>Cifuentes Alonso Claudio Antonio    </td>
                            <td>
                                <a href="#"><img src="../img/foler_blue.png" style="width: 38px; height: 32px;"></a>
                                <a href="#"><img src="../img/user_buscar.png" style="width: 55px; height: 48px;"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
