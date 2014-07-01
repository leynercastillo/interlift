<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z"%>
<!DOCTYPE html>
<html>
<head>
<%
	request.setAttribute(org.zkoss.zk.ui.sys.Attributes.NO_CACHE, Boolean.TRUE);
%>
<z:zkhead />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interlift</title>
<link rel="stylesheet" type="text/css" href="resource/style/stylePage.css" />
<link rel="icon" type="image/png" href="resource/images/icons/logo.png" />
<link rel="stylesheet" type="text/css" href="resource/style/bootstrap.css" />
</head>
<body style="height: auto">
	<z:page>
		<z:window>
	    <div class="container-fluid">
		     <div class="row-fluid">
		          <div class="span2"><jsp:include page="/system/frmMenu.zul" /></div>
		          <div class="span10"><jsp:include page="/system/index.zul" /></div>
	         </div>
	    </div>
		</z:window>
	</z:page>
</body>
</html>