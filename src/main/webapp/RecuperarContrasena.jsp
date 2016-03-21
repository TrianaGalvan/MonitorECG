<%-- 
    Document   : Registrarse
    Created on : 22-feb-2016, 21:23:59
    Author     : trianaandaluciaprietogalvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="UTF-8">
        <title>Recuperar contraseña</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/perfil.css">
        <link rel="stylesheet" href="css/botones.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>

    </head>
</head>
<body style="background: #DEFDFD;">
    <div class="container-fluid">
        <div class="tittle-registrarse">
            <img src="img/llave.png">
            <h1>Recuperar contraseña</h1>
            <hr>
        </div>   
        <div class="recuperar-contrasena"> 
            <form class="form-horizontal" action="Login?accion=cambiarContrasena" method="post" novalidate>
                <div class="form-group">
                    <div class="control-group">
                        <div class="row">
                            <p style="font-size: 30px;" class="col-md-4">Introduce tu nueva contraseña</p>
                        </div>
                        <div class="row margin-inputs">
                            <div class="col-md-3">
                                <label>Contraseña:</label>        
                            </div>
                            <div class="col-md-4">
                                <input type="password" class="form-control tamano-letra"  name="contrasena" 
                                       required
                                       data-validation-required-message="* Campo requerido">
                                <div class="warnings">
                                    <p class="help-block style-warnings"></p> 
                                </div>
                            </div>
                        </div>
                        <div class="row margin-inputs">
                            <div class="col-md-3 ">
                                <label>Confirmar contraseña:</label>        
                            </div>
                            <div class="col-md-4 control-group">
                                <input type="password" class="form-control tamano-letra"  name="contrasena-repetida" 
                                       data-validation-match-match="contrasena"
                                       data-validation-match-message="No coinciden las contraseñas">
                                <div class="warnings">
                                    <p class="help-block style-warnings"></p> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--form group-->
                <div class="form-actions">
                    <div class="col-md-2 col-md-offset-5">
                        <button type="submit" class="btn btn-default color-boton pull-right">Guardar</button>    
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
