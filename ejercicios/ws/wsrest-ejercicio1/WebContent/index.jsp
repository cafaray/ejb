<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumo del servicio REST</title>
</head>
<body>
	Presiona
	<a href="servicioPersonas/personas">aqu&iacute;</a> para poder acceder
	al servicio REST con el requerimiento a trav&eacute;s de GET
	<hr />
	<br />
	<form action="servicioPersonas/personas" method="post">
		<p>
		En este apartado establecemos la comunicaci&oacute;n por POST
		por lo que se agregar&aacute; un registro en nuestra tabla. Una vez
		terminado podemos regresar y volver a mostrar el listado.
		</p>
		<input type="text" name="nombre" id="nombre" value="" maxlength="30" /><br />
		<input type="text" name="apellidos" id="apellidos" value="" maxlength="60" /><br /> 
		<input type="text" name="rfc" id="rfc" value="" maxlength="13" /><br />
		<input type="submit" value="Agregar" />
	</form>
</body>
</html>