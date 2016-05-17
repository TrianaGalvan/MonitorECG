    <%-- 
        Document   : VerElectrocardiograma
        Created on : 22-feb-2016, 21:27:01
        Author     : trianaandaluciaprietogalvan
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <label>
                                <c:out value="${sessionScope.prueba.fecha}"/>
                            </label>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <fieldset>
                            <legend >Información general</legend>
                            <div class="row">
                                <div class="col-md-2">
                                    <label class="">Actualización de datos: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>
                                        <c:out value="${sessionScope.paciente.fechamodificacion}"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Nombre:</label>        
                                </div>
                                <div class="col-md-3">
                                    <label class="value-label">
                                        <c:out value="${sessionScope.paciente.nombre} ${sessionScope.paciente.apellidoPaterno} ${sessionScope.paciente.apellidoMaterno}"/>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label>Frecuencia respiratoria: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>
                                        <c:if test="${sessionScope.paciente.frecuenciaRespiratoria == 0}">
                                            <c:out value="No registrado"/></label>
                                        </c:if>
                                        <c:if test="${sessionScope.paciente.frecuenciaRespiratoria != 0}">
                                            <c:out value="${sessionScope.paciente.frecuenciaRespiratoria} respiraciones/minuto"/></label>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Edad: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>
                                        <c:if test="${sessionScope.paciente.edad == 0}">
                                            <c:out value="No registrado"/></label>
                                        </c:if>
                                        <c:if test="${sessionScope.paciente.edad != 0}">
                                            <c:out value="${sessionScope.paciente.edad} años"/></label>
                                    </c:if>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label>Presión arterial: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>
                                        <c:if test="${sessionScope.paciente.presionSistolica == 0 && sessionScope.paciente.presionDiastolica == 0}">
                                            <c:out value="No registrado"/></label>
                                        </c:if>
                                        <c:if test="${sessionScope.paciente.presionSistolica != 0 && sessionScope.paciente.presionDiastolica != 0}">
                                            <c:out value="${sessionScope.paciente.presionSistolica}/${sessionScope.paciente.presionDiastolica} mmHg"/></label>
                                    </c:if>
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <label>Peso: </label>
                                </div>
                                <div class="col-md-3">
                                    <label>
                                        <c:if test="${sessionScope.paciente.peso == 0}">
                                            <c:out value="No registrado"/></label>
                                        </c:if>
                                        <c:if test="${sessionScope.paciente.peso != 0}">
                                            <c:out value="${sessionScope.paciente.peso} Kg"/></label>
                                    </c:if>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label>Altura: </label>
                                </div>
                                <div class="col-md-3">
                                    <c:if test="${sessionScope.paciente.altura != 0}">
                                        <label>
                                            <fmt:formatNumber value="${sessionScope.paciente.altura}" type="number"/> m
                                        </label>
                                    </c:if>
                                    <c:if test="${sessionScope.paciente.altura == 0}">
                                        <label>No resgitrado </label>
                                    </c:if>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-md-4">
                                    <label>Notas adicionales del electrocardiograma: </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <textarea readonly class="form-control" rows="5" style="font-size: 22px;"><c:out value="${sessionScope.prueba.observaciones}"/></textarea>
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
                    <!--<div class="row">
                        <div class="col-md-3">
                            <label class="checkbox-inline"><input type="checkbox" value="">Electrocardiograma completo</label>
                        </div>
                        <div class="col-md-3">
                            <label class="checkbox-inline"><input type="checkbox" value="">Complejo QRS</label>
                        </div>
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-default color-boton pull-right" id="graficarECG">Gráficar</button>    
                        </div>
                    </div>
                    <br>-->
                    <!-- grafica --> 
                    <div class="row">
                        <div id="nombreArchivo" style="visibility: hidden">${sessionScope.prueba.idPrueba}</div>
                        <div id='grafica' style='height: 400px; min-width: 310px'></div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-3">
                            <label>Recomendaciones:</label>
                        </div>
                    </div>

                    <form class="form-horizontal" action="../ModuloElectrocardiogramas?accion=GuadarReporte" method="post" novalidate>
                        <div class="form-group">
                            <div class="row">
                                <p id="msj-vacio"></p>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <textarea class="form-control text-diagnostico" name="recomendaciones" rows="8" style="font-size: 22px;" id="text-recomendaciones"><c:out value="${sessionScope.prueba.reporte.recomendaciones}"></c:out></textarea>
                                </div>
                            </div> 
                            <input type="hidden" id="estado" name="estado"/>
                            <br>
                            <!-- botones --> 
                            <div class="row margin-final">
                                <div class="col-md-2">
                                    <button  type="submit" class="btn btn-default boton-guardar-pendiente" onclick="setEstadoPendiente()">Guardar como pendiente</button>    
                                </div>
                                <div class="col-md-2">
                                    <button type="submit" class="btn btn-default color-boton" onclick="setEstadoRegistrar()">Registrar</button>    
                                </div>
                                <div class="col-md-2 col-md-offset-6">
                                    <button  type="button" class="btn btn-default color-boton pull-right" data-toggle="modal" data-target="#myModal">Cancelar</button>    
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- Modal -->
                    <div id="myModal" class="modal fade" role="dialog" style="font-size: 20px;">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title">Salir del electrocardiograma</h4>
                            </div>
                            <div class="modal-body">
                              <p>¿Deseas salir del electrocardiograma?</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-warning"><a href="VerElectrocardiogramas.jsp" style="font-size: 17px;text-decoration: none; color: #FFFFFF;">Aceptar</a></button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal" style="font-size: 17px;">Cancelar</button>
                            </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->   
                    </div>
                </div>
            </div> 
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
            <script src='https://code.highcharts.com/stock/highstock.js'></script>
            <script src='https://code.highcharts.com/stock/modules/exporting.js'></script>
            
            <script>
                function setEstadoPendiente() {
                    document.getElementById("estado").value = "pendiente";
                }

                function setEstadoRegistrar() {
                    document.getElementById("estado").value = "registrar";
                }
               
                
                function descargarDatos(){
                    var path = "/ultimo/prueba/electrocardiograma/"+$("#nombreArchivo").text();
                    $.get(path, function(data) {
                        var lines = data.split("\n");
                        var data = [];
                        var x = 0; 
                        
                        lines.forEach(function(item){
                            data.push([
                                x,
                                Number(item)
                            ]);
                            x = x + 7.8125;
                        });
                        
                        configuracionGrafica.series[0].data = data;
                        $('#grafica').highcharts('StockChart',configuracionGrafica); 
                    });
                }
                
                var configuracionGrafica = {
                    rangeSelector: {
                        buttons: [{
                            count:1,
                            type:'second',
                            text:'1s'
                        }, {
                            count:5,
                            type:'second',
                            text:'5s'
                        }, {
                            count:10,
                            type:'second',
                            text:'10s'
                        }, {
                            count:15,
                            type:'second',
                            text:'15s'
                        }
                        , {
                            type: 'all',
                            text: 'Todo'
                        }],
                        inputEnabled: false,
                        selected: 4
                    },
                    tooltip:{
                        enabled:false
                    },
                    title : {
                        text : 'Electrocardiograma'
                    },

                    exporting: {
                        enabled: true
                    },

                    series : [
                        {
                            name : 'ECG',
                            data : [],
                            type:'spline',
                            color:'#C70039',
                            tooltip:{
                                valueDecimals:2
                            },
                            
                        }
                    ]
                };  
                
                
                $(function () {
                    descargarDatos(); 
                });

            </script>
        </body>
    </html>
