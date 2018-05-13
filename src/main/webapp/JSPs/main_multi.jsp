<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix='form'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/spesa/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="/spesa/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="/spesa/js/jQuery_v3.2.1.js" type="text/javascript"></script>
<script src="/spesa/js/angular.min_v1.6.6.js" type="text/javascript"></script>
<script src="/spesa/js/employeeExternal.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="codeGenerator">


<div class="col-md-10 first-one" ng-controller="codeGeneratorController as code">
	  <div class="first-one-inner">
	  <h3 class="tittle">Master Generation</h3>
	  
<form:form action="/spesa/all/codeGenerator/generate" method="post" commandName="fields" >
<%@ include file="/JSPs/acknowledgement.jsp" %>	
	
			<div>
				<form:input  path="title" class="text" placeholder="Enter title" ng-focus="code.clearFields($event);"  />
				<font color="red"><form:errors path="title" /></font>
			</div>
			
			
	<table>
	<tr>
		<th>Order</th>
		<th>Element</th>
		<th>label</th>
		<th>variable name</th>
	</tr>	
	<c:forEach items="${fields.fieldList}" var="fieldForm" varStatus="status">
		<tr>
			<td align="">${status.count}</td>
			
				<td><select name="fieldList[${status.index}].element" value="${fieldForm.element}">
				<option value="-1">--Select Element--</option>
					  <option value="text">TextBox</option>
					  <option value="textarea">TextArea</option>
					  <option value="radiobutton">Radio</option>
					  <option value="checkbox">Checkbox</option>
					  <option value="button">Button</option>
				</select></td>
			<td><input  type="text"  name="fieldList[${status.index}].label" value="${fieldForm.label}"/></td>
			<td><input  type="text"  name="fieldList[${status.index}].path" value="${fieldForm.path}"/></td>
		</tr>
	</c:forEach>
	</table>
			
			<div class="submit"><input type="button" value="back" onclick="window.location.href='/spesa';"> <input type="submit" value="Generate" ></div>
</form:form>
</div>
</div>

</body>
</html>