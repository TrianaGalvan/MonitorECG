<%-- 
    Document   : navbar
    Created on : 22-feb-2016, 12:51:29
    Author     : trianaandaluciaprietogalvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    String nombre = sesion.getAttribute("user") == null ? "" : (String) sesion.getAttribute("user");
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>DOCTOR - Responsive HTML Template</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/perfil.css">
        <link rel="stylesheet" href="../css/tables.css">
        <link rel="stylesheet" href="../css/botones.css">
        <link rel="stylesheet" href="../css/estados.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>
        <!-- script tags
         ============================================================= -->    
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/principal/custom.js"></script>
    </head>
    <body>

        <!-- ====================================================
        header section -->
        <header class="top-header">
            <div class="container">
                <div class="row">
                    <div class="col-xs-5 header-logo" style="margin-top:-10px;">
                        <br>
                        <a href="../perfil/Principal.jsp"><img src="../img/logo.png" alt="" class="img-responsive logo"></a>
                    </div>

                    <div class="col-md-7">
                        <nav class="navbar navbar-default" >
                            <div class="container-fluid nav-bar">
                                <!-- Brand and toggle get grouped for better mobile display -->
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                    <a class="navbar-brand page-scroll" href="../perfil/Principal.jsp" style="margin-left:-400px; font-weight: 700; font-size:38px; letter-spacing:0.2px;">Monitor ECG</a>
                                </div>

                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a class="menu" href="../ModuloElectrocardiogramas?accion=listarElectrocardiogramas"><i class="fa fa-heartbeat"></i>Electrocardiogramas <span class="badge">${sessionScope.noRevisadas}</span></a></li>
                                        <li><a class="menu" href="../perfil/Pacientes.jsp"><i class="fa fa-users"></i> Pacientes</a></li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user-md"></i> <%=nombre%><b class="caret"></b></a>
                                            <ul class="dropdown-menu" >
                                                <li>
                                                    <a href="../ModuloPerfil?accion=VerPerfil"><i class="fa fa-user-md "></i>  Perfil</a>
                                                </li>
                                                <li role="separator" class="divider"></li>
                                                <li>
                                                    <a href="../index.jsp"><i class="fa fa-power-off"></i>  Salir</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div><!-- /navbar-collapse -->
                            </div><!-- / .container-fluid -->
                        </nav>
                    </div>
                </div>
            </div>
        </header> <!-- end of header area -->

        <decorator:body/>


        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });


            $(document).ready(function () {

                $('a[href^="#"]').click(function () {

                    $('a[href^="#"]').removeClass('active'); // remove the class from the currently selected
                    $(this).addClass('active'); // add the class to the newly clicked link
                });

            });
        </script>
        <!-- Validate forms -->
        <script src="../js/jqBootstrapValidation.js"></script>
        <script>
            $(function () {
                $("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
            });
        </script>
        <!-- Colocar ejemplo al seleccionar un filtro de búsqueda -->
        <script>
            function setFormato() {
                var x = document.getElementById("tipo-filtro").value;
                if (!x.localeCompare("Nombre")) {
                    document.getElementById("valor-filtro").placeholder = "Ej. Diana López Martínez";
                } else if (!x.localeCompare("CURP")) {
                    document.getElementById("valor-filtro").placeholder = "Ej. PIGT940502MOCRLR08";
                } else {
                    document.getElementById("valor-filtro").placeholder = "Ej. usuario@gmail.com";
                }
            }
        </script>
        <!--<script>
            function setEstadoRegistrar(){
                var val = document.getElementById("text-recomendaciones");   
                if(val === null){
                    document.getElementById("msj-vacio").innerHTML = "Deberías escribir tus recomendaciones :)";
                }
                
            }
        </script>-->

        <!-- Cambiar el estado active de la navbar -->
        <!--<script>
            $('.nav li').click(function(e) {
                $('.nav li.active').removeClass('active');
                var $this = $(this);
                if (!$this.hasClass('active')) {
                    $this.addClass('active');
                }
                e.preventDefault();
            });
        </script>-->
        
    </body>
</html>
