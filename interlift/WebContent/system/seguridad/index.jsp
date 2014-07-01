<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Interlift - Login</title>
<link rel="icon" type="image/png" href="../../resource/images/icons/logo.png" />
<link rel="stylesheet" type="text/css" href="../../resource/style/stylePage.css" />
<link rel="stylesheet" type="text/css" href="../../resource/style/bootstrap.css" />
</head>
<body>
	<div class="navbar">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span7">
					<img alt="Interlift Logo" src="../../resource/images/logo-web.jpg" />
				</div>
				<div class="span5">
					<div class="form-group">
						<jsp:include page="login.zul" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div>
				<div class="span7"></div>
				<div class="span5">
					<jsp:include page="../contacto/frmContact.zul" />
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<p>Interlift</p>
			<p>Autopista Medellin Km 2.5 - Centro Empresarial Portos Sabana 80 Bodega 112. Bogotá, Colombia.</p>
			
			<p>Todos los derechos reservados.</p>
		</div>
	</div>
</body>
</html>