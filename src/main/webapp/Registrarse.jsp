<%-- 
    Document   : Registrarse
    Created on : 22-feb-2016, 21:23:59
    Author     : trianaandaluciaprietogalvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    String errorRegistrarse = sesion.getAttribute("error-registrarse") == null ? "" : (String) sesion.getAttribute("error-registrarse");
%>
<html>
    <head>
    <head>
        <meta charset="UTF-8">
        <title>Registrarse</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/perfil.css">
        <link rel="stylesheet" href="css/botones.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>

    </head>
</head>
<body style="background: #F7FEFF;">
    <div class="container-fluid">
        <div class="tittle-registrarse">
            <img src="img/icon--medico.png">
            <h1>Registro en el sistema</h1>
            <hr>
        </div>

        <div class="content margin-content-tab"> 

            <form class="form-horizontal" action="Login?accion=registrarse" method="post" novalidate>
                <div class="form-group">
                    <%if (errorRegistrarse.contains("error")) {%>
                    <div class="row">
                        <div class="alert alert-danger col-lg-5 col-md-offset-3" style="font-size: 18px;">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close" style="font-size: 20px;">&times;</a>
                            <%=errorRegistrarse%>
                        </div>    
                    </div>
                    <%errorRegistrarse = "";
                    } else if (errorRegistrarse.contains("registrado")) {%>
                    <div class="row">
                        <div class="alert alert-info col-lg-5 col-md-offset-3" style="font-size: 18px;">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Info! </strong><%=errorRegistrarse%>
                        </div>  
                    </div>
                    <%
                            sesion.removeAttribute("error-registrarse");
                        }%>
                    <div class="row" >
                        <div class="col-md-2">
                            <label>Nombre:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="text" class="form-control tamano-letra"  name="nombre" 
                                   required 
                                   data-validation-required-message="* Campo requerido"
                                   data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                   data-validation-regex-message="Solo se aceptan letras"/>
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                        <div class="col-md-2 segunda-columna">
                            <label>Teléfono celular: </label>
                        </div>
                        <div class="col-md-3">
                            <input type="text" class="form-control tamano-letra"  name="telefono">
                        </div>                               
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label>Apellido paterno:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="text" class="form-control tamano-letra"  name="app"
                                   required  
                                   data-validation-required-message="* Campo requerido"
                                   data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                   data-validation-regex-message="Solo se aceptan letras">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                        <div class="col-md-2 segunda-columna">
                            <label>Cédula profesional: </label>
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="text" class="form-control tamano-letra"  name="cedula" 
                                   required 
                                   data-validation-required-message="* Campo requerido">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                    </div>
                    <div class="row control-group margin-inputs" >
                        <div class="col-md-2">
                            <label>Apellido materno:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="text" class="form-control tamano-letra"  name="apm"
                                   required  
                                   data-validation-required-message="* Campo requerido"
                                   data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                   data-validation-regex-message="Solo se aceptan letras">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                        <div class="col-md-2 segunda-columna">
                            <label>Instituto de estudios: </label>
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="text" class="form-control tamano-letra"  name="instituto" 
                                   required  
                                   data-validation-required-message="* Campo requerido"
                                   data-validation-regex-regex="^([A-Za-z ñáéíóú]{2,60})" 
                                   data-validation-regex-message="Solo se aceptan letras" >
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                    </div>
                    <div class="row margin-inputs">
                        <div class="col-md-2">
                            <label>Edad:</label>        
                        </div>
                        <div class="col-md-3">
                            <input type="number" class="form-control tamano-letra"  name="edad" >
                        </div>
                        <div class="col-md-2 segunda-columna">
                            <label>Sexo: </label>
                        </div>
                        <div class="radio col-md-1">
                            <label><input type="radio" name="sexo" class="tamano-letra">Femenino</label>
                        </div>
                        <div class="radio col-md-1">
                            <label><input type="radio" name="sexo" class="tamano-letra pull-right">Masculino</label>
                        </div>
                    </div>
                    <div class="row margin-inputs">
                        <div class="col-md-2">
                            <label>CURP:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="text" class="form-control tamano-letra"  name="curp" 
                                   required 
                                   data-validation-required-message="* Campo requerido">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                        <div class="col-md-2 segunda-columna">
                            <label>Contraseña:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="password" class="form-control tamano-letra"  name="contrasena"
                                   required 
                                   data-validation-required-message="* Campo requerido">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                    </div>
                    <div class="row margin-inputs">
                        <div class="col-md-2 ">
                            <label>Correo electrónico:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input class="form-control tamano-letra" name="correo"
                                   type="email"
                                   data-validation-email-message="Correo inválido"
                                   required 
                                   data-validation-required-message="* Campo requerido">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                        <div class="col-md-2 segunda-columna">
                            <label>Confirmar contraseña:</label>        
                        </div>
                        <div class="col-md-3 control-group">
                            <input type="password" class="form-control tamano-letra"  name="curp" 
                                   data-validation-match-match="contrasena"
                                   data-validation-match-message="No coinciden las contraseñas">
                            <div class="warnings">
                                <p class="help-block style-warnings"></p> 
                            </div>
                        </div>
                    </div>
                </div><!--form group-->
                <div class="row">
                    <div class="col-md-2 col-md-offset-7">
                        <button type="submit" class="btn btn-default color-boton pull-right"><a href="index.jsp" class="boton-cancelar">Cancelar</a></button>    
                    </div>
                    <div class="form-actions">
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-default color-boton">Guardar</button>    
                        </div>
                    </div>
                </div>
            </form>

        </div><!-- content -->
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- or use local jquery -->
<script src="js/jqBootstrapValidation.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
    });
</script>
</html>
