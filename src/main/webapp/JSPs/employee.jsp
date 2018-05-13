
<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/CarRentalBilling/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="/CarRentalBilling/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="/CarRentalBilling/js/jQuery_v3.2.1.js" type="text/javascript"></script>
<script src="/CarRentalBilling/js/angular.min_v1.6.6.js" type="text/javascript"></script>
<script src="/CarRentalBilling/js/employeeExternal.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Rental Invoice</title>
</head>
<body ng-app="employee">
	 <div class="col-md-10 first-one" ng-controller="employeeController as empCon">
	  <div class="first-one-inner">
	     <h3 class="tittle"><spring:message code="label.signup"/></h3>
	     

		<form:form action="/CarRentalBilling/all/save" method="post" commandName="emp" >
	<%@ include file="/JSPs/acknowledgement.jsp" %>	
			<div>
				<form:input  path="firstName" class="text" ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'First Name');" />
				<font color="red"><form:errors path="firstName" /></font>
			</div>
			<div>
				<form:input  path="lastName" class="text"  ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'last Name');" />
				<font color="red"><form:errors path="lastName" /></font>
			</div>
			<div>
				<form:input  path="mobileNo" class="text"  ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'Mobile No.');" />
				<font color="red"><form:errors path="mobileNo" /></font>
			</div>
			<div>
				<form:input  path="emailId" class="text"  ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'Email-Id');" />
				<font color="red"><form:errors path="emailId" /></font>
			</div>
			<div>
				<form:input type="date" path="empDOB" class="text"   />
				<font color="red"><form:errors path="empDOB" /></font>
			</div>
			<div>
				<form:select  path="roles"  class="text" >
				<option value="-1">--Select Roles--</option>
					  <option value="0">Volvo</option>
					  <option value="1">Saab</option>
					  <option value="2">Mercedes</option>
					  <option value="3">Audi</option>
				</form:select>
				<font color="red"><form:errors path="roles" /></font>
			</div>
			<div>
				<form:input path="empAddress.city" class="text" ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'City');" />
				<font color="red"><form:errors path="empAddress.city" /></font>
				<form:input path="empAddress.street" class="text"  ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'Street');" />
				<font color="red"><form:errors path="empAddress.street" /></font>
				<form:input path="empAddress.pincode" class="text" ng-focus="empCon.clearFields($event);" ng-blur="empCon.setDefaultValues($event,'Pin code');" />
				<font color="red"><form:errors path="empAddress.pincode" /></font>
			</div>
			
			<div class="submit"><input type="button" value="back" onclick="window.location.href='/CarRentalBilling';"> <input type="submit" value="Sign up" ></div>
			<div class="clearfix"></div>
		</form:form>
		
		
	   </div>
      </div>

</body>
</html>