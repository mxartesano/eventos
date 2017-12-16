<%-- 
    Document   : usuarios
    Created on : Dec 16, 2017, 12:09:54 PM
    Author     : igarcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <div class="container">

            <form class="form-signin" action="login" method="POST">
        <h2 class="form-signin-heading">Iniciar sesion</h2>
        <label for="inputEmail" class="sr-only">Correo Electronico</label>
        <input type="email" id="email" name="email" class="form-control" placeholder="Correo Electrónico" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Contraseña" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recordarme
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesión</button>
      </form>

            ${loginError}
    </div> <!-- /container -->
    
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/common.css" rel="stylesheet">
    
      </body>

</html>
