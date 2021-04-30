<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Track & Bug - Proyectos</title>
<br></br>
</head>
<body>
<h1>Panel Proyectos</h1>
<table border="1" width="50%">
  <tr>
  	<th>&nbsp;</th>
    <th>ID PROYECTO</th>
    <th>NOMBRE DE PROYECTO</th>
    <th>HORAS LIBRES</th>
  </tr>
	<c:forEach items="${proyectos}" var="p">
	    <tr>
	    	<td></td>
	    	<td>${p.idProyecto}</td>
  		  	<td>${p.nombreProyecto}</td>
  		  	<td>${p.horasAsignadas}</td>
  		</tr>
	</c:forEach>
</table> 
</body>
</html>