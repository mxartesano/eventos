<%-- 
    Document   : usuarios
    Created on : Dec 16, 2017, 12:09:54 PM
    Author     : igarcia
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>Usuarios</title>

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

           <table class="table">
        <thead>
          <tr>
            <th scope="col">ID USUARIO</th>
            <th scope="col">Nombre</th>
            <th scope="col">Ap. Paterno</th>
            <th scope="col">Ap. Materno</th>
            <th scope="col">Correo</th>
          </tr>
        </thead>
        <tbody>
            
        <c:forEach items="${usuarios}" var="u">
             <tr>
                <th scope="row">${u.id}</th>
                <td>${u.nombre}</td>
                <td>${u.apellidoPaterno}</td>
                <td>${u.apellidoMaterno}</td>
                <td>${u.correoelectronico}</td>
            </tr>
            </c:forEach>
        </tbody>
</table>

    </div> <!-- /container -->
    
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/common.css" rel="stylesheet">
    
      </body>
</html>