<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/CarRentalBilling/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="/CarRentalBilling/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Rental Invoice</title>
</head>
<body>
<%@ include file="/JSPs/acknowledgement.jsp" %>
	 <div class="col-md-4 first-one">
	  <div class="first-one-inner">
	     <h3 class="tittle">Sign up</h3>
		<form:form action="/CarRentalBilling/all/save" method="post">
			<form:input  path="firstName" class="text" value="First Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'First Name';}" />
			<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
			<div class="submit"><input type="submit" value="Sign in" ></div>
			<div class="clearfix"></div>
			<div class="new">
				<h3><a href="#">Forgot your password ?</a></h3>
			</div>-
		</form:form>
	   </div>
	   <a href="#" class="hvr-bounce-to-bottom">Sign in with Twitter</a>
      </div>

</body>
</html>