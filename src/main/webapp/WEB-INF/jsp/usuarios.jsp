<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Track & Bug - Usuarios</title>
<br></br>
</head>
<body>
<h1>Panel Usuarios</h1>
<table border="1" width="50%">
  <tr>
  	<th>&nbsp;</th>
    <th>ID USUARIO</th>
    <th>NOMBRE DE USUARIO</th>
  </tr>
	<c:forEach items="${usuarios}" var="u">
	    <tr>
	    	<td></td>
	    	<td>${u.id}</td>
  		  	<td>${u.nombre}</td>
  		</tr>
	</c:forEach>
</table> 

</body>
</html>