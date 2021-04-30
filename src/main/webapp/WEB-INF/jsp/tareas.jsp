<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Track & Bug - Tareas</title>
<br></br>
</head>
<body>
<h1>Panel Tareas</h1>
<table border="1" width="70%">
  <tr>
  	<th>&nbsp;</th>
    <th>ID TAREA</th>
    <th>NOMBRE PROYECTO</th>
    <th>NOMBRE DE USUARIO</th>
    <th>TIPO DE TAREA</th>
    <th>ESTADO DE TAREA</th>
  </tr>
	<c:forEach items="${tareas}" var="t">
	    <tr>
	    	<td></td>
	    	<td>${t.idTarea}</td>
  		  	<td>${t.proyecto.nombreProyecto}</td>
  		  	<td>${t.usuarioAsignado.nombre}</td>
  		  	<td>${t.tipo.descripcionTipo}</td>
  		  	<td>${t.estado.descripcionEstado}</td>
  		</tr>
	</c:forEach>
</table> 

</body>
</html>