<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/CarRentalBilling/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="/CarRentalBilling/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--menu-->
   <div class="col-md-4 skill-one">
    <div class="mid-menu">
	   <span class="menu2"><lable> MENU</lable></span>
	   <ul class="effct1" style="display: block;">
		<li><a href="/CarRentalBilling/all/create/N"><spring:message code="label.createEmployee"/><span>30</span></a></li>
		<%--<li><a href="/CarRentalBilling/all/create?editable=Y&tempVar=132">Create Employee 2 request params<span>30</span></a></li> --%>
		<%-- <li><a href="/CarRentalBilling/all/create/Y/132">Create Employee map All path vars<span>30</span></a></li>--%>                                             
		<li><a href="/CarRentalBilling/all/create/Y">Edit Employee<span>05</span></a></li>
		<li><a href="/CarRentalBilling/all/events">Events<span>10</span></a></li>  
		<li><a href="#">Account Settings</a></li>  
		<li><a href="#">Folder</a></li> 
		<li class="lost"><a href="#">Statistics</a></li>
		<li><a href="/CarRentalBilling/all/routeToEntryPage?siteLanguage=hi">Hindi</a></li>
		<li><a href="/CarRentalBilling/all/routeToEntryPage?siteLanguage=en">English</a></li>
	  </ul>
	</div>
</div>
    <!--//menu-->
</body>
</html>