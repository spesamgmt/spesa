
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container" style="width: 100%; background: #f0f8ff">
	<div class="clearfix" style="height: 60px"></div>
	<form:form action="submitLogin.sem" method="POST" commandName="loginForm">
		<fieldset style="width: 300px; margin: auto;">
			<legend>Login</legend>
			<div class="form-group">
				<!-- <span class="input-group-addon" id="basic-addon1">@</span> -->
				<label for="username"><spring:message code="login.username" /></label>
				<spring:message code="login.enter.username" var="userNameTtip"/>
				<form:input type="text" path="userName" class="form-control"
					placeholder="${userNameTtip}" aria-describedby="basic-addon1" />
			</div>

			<div class="form-group">
				<!-- <span class="input-group-addon" id="basic-addon1">@</span> -->
				<label for="password"><spring:message code="login.password" /></label>
				<spring:message code="login.enter.password" var="passwordTtip"/>
				<form:password path="password" class="form-control"
					placeholder="${passwordTtip}" aria-describedby="basic-addon1" />
			</div>
			<button type="submit" class="btn btn-default"><spring:message code="common.Submit" /></button>
		</fieldset>
	</form:form>
	<div class="clearfix" style="height: 60px"></div>
</div>
