
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(); 
    String error = sesion.getAttribute("error") == null ? "" : (String) sesion.getAttribute("error");
    String msj = sesion.getAttribute("error-registrarse") == null ? "" : (String) sesion.getAttribute("error-registrarse");
    String tipoEnvio = sesion.getAttribute("tipo-envio") == null ? "" : (String) sesion.getAttribute("tipo-envio");
    String msjCambiarPass = sesion.getAttribute("msj-cambiar-pass") == null ? "" : (String) sesion.getAttribute("msj-cambiar-pass");
    String tipomsj = sesion.getAttribute("tipoMsj") == null ? "" : (String) sesion.getAttribute("tipoMsj");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Monitor ECG</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS(Agency) -->
        <link href="css/navbar.css" rel="stylesheet">

        <!-- login-->
        <link href="css/style.css" rel="stylesheet">
        <!--<link href="css/reset.css" rel="stylesheet">-->
        <!-- Custom Fonts -->
        <link href='https://fonts.googleapis.com/css?family=css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    </head>

    <body id="page-top" class="index">

        <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="img/logo.png" class="navbar-left img-responsive" id="logo">
                </a>
                <a class="navbar-brand page-scroll" href="#page-top" style="margin-left:-10px; font-weight: 700; font-size:45px; letter-spacing:0.2px;">Monitor &nbsp;ECG</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about" style="font-weight: 700px; font-size:17px; letter-spacing:0.2px;">Acerca del proyecto</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
        <%if (!error.isEmpty()) {%>
        <div class="alert alert-danger fade in col-md-4 col-md-offset-4" style="margin-top: 20px;" >
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <%=error%>
        </div>
        <%
            error = "";
            sesion.removeAttribute("error");
        } else if (!msj.contains("error") && !msj.isEmpty()) {%>
        <div class="alert alert-success fade in col-md-4 col-md-offset-4" style="margin-top: 20px;" >
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Éxito!</strong> <%=msj%> 
        </div>
        <% msj = "";
            sesion.removeAttribute("error-registrarse");
        } else if (!tipoEnvio.isEmpty()) {
            String typeAlert = "";
            String textStrong = "";
            String msjEnvio = sesion.getAttribute("msj-envio") == null ? "" : (String) sesion.getAttribute("msj-envio");
            if (tipoEnvio.equals("Exito")) {
                typeAlert = "alert-success";
                textStrong = "Éxito!";
            } else if (tipoEnvio.equals("Error") || tipoEnvio.equals("No Existe")) {
                typeAlert = "alert-danger";
                textStrong = "Error!";
            }%>
        <div class="alert <%=typeAlert%> fade in col-md-4 col-md-offset-4" style="margin-top: 20px;" >
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong><%=textStrong%></strong> <%=msjEnvio%>
        </div>  
        <%
            msjEnvio = "";
            sesion.removeAttribute("tipo-envio");
            sesion.removeAttribute("msj-envio");
        } else if (!tipomsj.isEmpty()) {
            String typeAlert = "";
            String textStrong = "";
            if (tipomsj.equals("OK")) {
                typeAlert = "alert-success";
                textStrong = "Éxito!";
            } else if (tipomsj.equals("Error")) {
                typeAlert = "alert-danger";
                textStrong = "Error!";
            }%>
        <div class="alert <%=typeAlert%> fade in col-md-4 col-md-offset-4" style="margin-top: 20px;">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong><%=textStrong%></strong> <%=msjCambiarPass%> 
        </div>
        <%tipomsj = "";
             sesion.removeAttribute("msj-cambiar-pass");
             sesion.removeAttribute("tipoMsj");
            }
        %>
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="form">
                <div class="thumbnail"><img src="img/iconologin.png"/></div>
                <form class="register-form" action="Login?accion=recuperarContrasena" method="post">
                    <p>Introduce tu correo electrónico</p>
                    <div class="control-group">
                        <input type="email" placeholder="correo electrónico" name="email"
                               data-validation-email-message="Correo inválido"
                               required 
                               data-validation-required-message="* Campo requerido"/>
                        <div class="warnings">
                            <p class="help-block style-warnings"></p> 
                        </div>
                    </div>
                    <button type="submit">Enviar</button>
                    <p class="message"> <a href="#" style="margin-left: 80px;"> Inicia sesión</a></p>
                </form>
                <form class="login-form" action="Login?accion=login" method="post">
                    <input type="text" placeholder="username" name="username" required/>
                    <input type="password" placeholder="password" name="password" required/>
                    <button type="submit"><a class="boton-entrar">Entrar</a></button>
                    <p class="message"> <a href="#">¿Olvidaste tu contraseña?</a></p>
                    <div class="message"><a style="margin-left: 205px;" href="Registrarse.jsp">Registrarse</a></div>
                </form>
            </div>
        </div>
    </header>

    <!-- About Section -->
    <section id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center ">
                    <h2 class="section-heading">Acerca del proyecto</h2>
                    <h3 id="logo-texto">Monitor ECG</h3>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-3 ">
                    <img src="img/iconoacerca2.png" class="acercade-imagen">    
                </div>
                <div class="col-md-7">
                    <p>El proyecto pretende aportar ayuda a los pacientes que sufren de enfermedades cardiovasculares, por medio de un electrocardiografo portátil el cual permita obtener la señal ECG del paciente, mandando la señal a un dispositivo movil, este enviará la señal obtenida a este sitio web, aquí se podrá visualizar  y dar un diagnóstico a cada una de las muestras de los pacientes, para finalmente emitir un diagnóstico del electrocardiograma, con esto se tratará de disminuir el número de pacientes que no son atendidos por un médico especialista para así poder disminuir el índice de mortalidad por enfermedades del corazón.</p>
                </div>
            </div>
        </div>
    </section>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="js/agency.js"></script>
    <!-- login -->
    <script src="js/login.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- or use local jquery -->


    <script src="js/jqBootstrapValidation.js"></script>
    <script>
        $(function () {
            $("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
        });
    </script>

</body>
</html>

