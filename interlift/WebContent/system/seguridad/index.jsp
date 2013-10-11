<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Interlift - Login</title>
<link rel="icon" type="image/png" href="../../resource/images/icons/logo.png" />
<link rel="stylesheet" type="text/css" href="../../resource/style/stylePage.css" />
<link rel="stylesheet" type="text/css" href="../../resource/style/bootstrap.min.css" />
</head>
<body>
	<div class="navbar navbar-fixed-top background-header header">
		<div class="container">
			<div class="row">
				<div class="span7">
					<img alt="Ascensores Nardi Logo" src="../../resource/images/logo-web.jpg" />
				</div>
				<div class="span5">
					<jsp:include page="login.zul" />
				</div>
			</div>
		</div>
	</div>
	<div class="container" style="padding-top: 10%;">
		<div class="row">
			<div>
				<div class="span7 hidden-phone"></div>
				<div class="span5">
					<jsp:include page="../contacto/frmContact.zul" />
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<p>Interlift SAS</p>
			<p>Autopista Medellín Km 2.5 - Centro Empresarial Portos Sabana 80 Bodega 112. Bogotá Colombia</p>
			<p>Telf: (571) 8767055 || (571) 8764497</p>
			<p>Todos los derechos reservados.</p>
		</div>
	</div>
</body>
</html>