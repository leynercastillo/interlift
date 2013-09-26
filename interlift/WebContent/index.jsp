<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z"%>
<!DOCTYPE html>
<html>
<head>
<z:zkhead />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interlift</title>
<link rel="stylesheet" type="text/css"
	href="resource/style/stylePage.css" />
<link rel="icon" type="image/png" href="resource/images/icons/logo.png" />
</head>
<body style="height: auto">
	<%
	    request.setAttribute(org.zkoss.zk.ui.sys.Attributes.NO_CACHE, Boolean.TRUE);
	%>
	<z:page>
		<z:window>
			<div class="page">
				<div class="aside">
					<jsp:include page="/system/frmMenu.zul" />
				</div>
				<div class="section-main">
					<jsp:include page="/system/index.zul" />
				</div>
			</div>
		</z:window>
	</z:page>
</body>
</html>