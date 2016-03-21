<%-- 
    Document   : VerElectrocardiogramas
    Created on : 22-feb-2016, 21:28:44
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
            <img src="../img/electro.jpeg">
            <h1>Electrocrdiogramas</h1>
            <hr>
            <div class="content">
                <div class="row">
                    <div class="col-md-4"> 
                        <button type="submit" class="btn btn-default color-boton boton-reporte"><a href="NuevoReporte.jsp" style="color: #333;">Nuevo reporte</a></button>    
                    </div>
                </div>

                <!-- table -->
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Nombre del paciente</th>
                            <th>Fecha de recepción</th>
                            <th>Estatus del reporte</th>
                            <th>Acciones</th>
                        </tr>
                        <tr>
                            <td>Prieto Galván Triana Andalucia</td>
                            <td>10/02/2015</td>
                            <td class="pendiente">Pendiente</td>
                            <td style="margin-left:20px;">
                                <a href="VerElectrocardiograma.jsp" data-toggle="tooltip" title="Generar reporte" ><img src="../img/pencil.png" style="width: 38px; height: 32px;"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>Cifuentes Alonso Claudio Antonio</td>
                            <td>12/02/2015</td>
                            <td class="revisado">Revisado</td>
                            <td style="margin-left:20px;">
                                <a href="#" data-toggle="tooltip" title="Generar reporte" ><img src="../img/pencil.png" style="width: 38px; height: 32px;"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>Peña Velarde Jesus Daniel</td>
                            <td>10/05/2015</td>
                            <td class="no-revisado">No revisado</td>
                            <td style="margin-left:20px;">
                                <a href="#" data-toggle="tooltip" title="Generar reporte" ><img src="../img/pencil.png" style="width: 38px; height: 32px;"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
