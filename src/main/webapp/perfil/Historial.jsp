<%-- 
    Document   : HistorialPruebas
    Created on : 22-feb-2016, 21:12:35
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
            <img src="../img/historial_clinico.png">
            <h1>Historial de pruebas</h1>
            <hr>
            <div class="content">
                <div class="row">
                    <div class="col-md-5"> 
                        <label>Nombre del paciente: Prieto Galván Triana Andalucia </label>
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
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                        <tr>
                            <td>10/02/2015</td>
                            <td>12:00 pm</td>
                            <td class="pendiente">Pendiente</td>
                            <td style="margin-left:20px;">
                                <a href="VerElectrocardiograma.jsp" data-toggle="tooltip" title="Ver" ><img src="../img/lupa_icono_tabla.png" style="width: 38px; height: 32px;"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>10/08/2014</td>
                            <td>03:00 pm</td>
                            <td class="revisado">Revisado</td>
                            <td style="margin-left:20px;">
                                <a href="#" data-toggle="tooltip" title="Ver" ><img src="../img/lupa_icono_tabla.png" style="width: 38px; height: 32px;"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>12/08/2014</td>
                            <td>10:00 am</td>
                            <td class="no-revisado">No revisado</td>
                            <td style="margin-left:20px;">
                                <a href="#" data-toggle="tooltip" title="Ver" ><img src="../img/lupa_icono_tabla.png"  style="width: 38px; height: 32px;"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-md-2 col-md-offset-9">
                        <button type="submit" class="btn btn-default color-boton pull-right"><a href="Pacientes.jsp" style="color: #333;">Regresar</a></button>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
