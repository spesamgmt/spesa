<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/CodeGenerationUtility/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="/CodeGenerationUtility/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="/CodeGenerationUtility/js/jQuery_v3.2.1.js" type="text/javascript"></script>
<script src="/CodeGenerationUtility/js/angular.min_v1.6.6.js" type="text/javascript"></script>
<script src="/CodeGenerationUtility/js/employeeExternal.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="codeGenerator">


<div class="col-md-10 first-one" ng-controller="codeGeneratorController as code">
	  <div class="first-one-inner">
	  <h3 class="tittle">Master Generation</h3>
	  
<form:form action="/CodeGenerationUtility/all/generate" method="post" commandName="fields" >
<%@ include file="/JSPs/acknowledgement.jsp" %>	
			
			<div>
				<form:input  path="title" class="text" placeholder="Enter title" ng-focus="code.clearFields($event);"  />
				<font color="red"><form:errors path="title" /></font>
			</div>
			<div>
				<form:select  path="element"  class="text" >
				<option value="-1">--Select Element--</option>
					  <option value="0">TextBox</option>
					  <option value="1">TextArea</option>
					  <option value="2">Radio</option>
					  <option value="3">Checkbox</option>
					  <option value="4">Button</option>
				</form:select>
				<font color="red"><form:errors path="element" /></font>
			</div>
			<div>
				<form:input  path="label" class="text" placeholder="Enter Label" ng-focus="code.clearFields($event);"  />
				<font color="red"><form:errors path="label" /></font>
			</div>
			<div>
				<form:input  path="path" class="text"  placeholder="Enter variable name" ng-focus="code.clearFields($event);" />
				<font color="red"><form:errors path="path" /></font>
			</div>
			
			<div class="submit"><input type="button" value="back" onclick="window.location.href='/CodeGenerationUtility';"> <input type="submit" value="Generate" ></div>
</form:form>
</div>
</div>

</body>
</html>