<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registro Usuario</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
 <a href="eventos"> Eventos </a>
    <a href="registroEvento.jsp"> Registrar Eventos </a>
    <a href="usuarios"> Usuarios</a>
    <a href="registroUsuario.jsp"> Registro Usuarios </a>
    
    
    <form method="POST" action="registroUsuario" class="form-signin">
        <h2 class="form-heading">Registro de usuarios</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="nombre" type="text" class="form-control" placeholder="Nombre"
                   autofocus="true"/>
            <input name="apellidoPaterno" type="text" class="form-control" placeholder="Apellido Paterno"
                   autofocus="true"/>
            <input name="apellidoMaterno" type="text" class="form-control" placeholder="Apellido Materno"
                   autofocus="true"/>
            <input name="correoElectronico" type="text" class="form-control" placeholder="Correo electronico"
                   autofocus="true"/>
            <input name="password" type="text" class="form-control" placeholder="Password"
                   autofocus="true"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>

        </div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
