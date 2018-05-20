<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/sidebar.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="header" ignore="true"  />
	</div>
	<%-- <div>
		<tiles:insertAttribute name="menu" />
	</div> --%>
	<div>
		<tiles:insertAttribute name="body" ignore="true" />
	</div>
	<div>
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>