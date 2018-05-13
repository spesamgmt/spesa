<%@ page language='java' contentType='text/html; charset=ISO-8859-1' pageEncoding='ISO-8859-1'%>
<%@ taglib uri='http://www.springframework.org/tags/form' prefix='form'%>
<%@ taglib uri='http://www.springframework.org/tags' prefix='spring'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<link href='/spesa/css/bootstrap.css' rel='stylesheet' type='text/css' media='all'>
<link href='/spesa/css/style.css' rel='stylesheet' type='text/css' media='all'/>
<script src='/spesa/js/jQuery_v3.2.1.js' type='text/javascript'></script>
<script src='/spesa/js/angular.min_v1.6.6.js' type='text/javascript'></script>

<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<title>account code</title>
</head>
<body >
<div class='col-md-10 first-one'>
<div class='first-one-inner'>
 <h3 class='tittle'>account code</h3>

<form:form action='/spesa/all/accountCode/save' method='post' commandName='accountCode' >
<%@ include file='/JSPs/acknowledgement.jsp' %>	

<div>

<form:textarea rows="5" cols="30" placeholder='account name' path='accName' class='text' />

</div>

<div>

<form:radiobutton path='gender' value='Male'/>Male
<font color='red'><form:errors path='gender' /></font>

<form:radiobutton path='gender' value='Female'/>Female
<font color='red'><form:errors path='gender' /></font>

</div>

<div class='submit'><input type='button' value='back' onclick="window.location.href='/spesa';"> <input type='submit' value='save' ></div>
</form:form>
</div>
</div>
</body>
</html>

