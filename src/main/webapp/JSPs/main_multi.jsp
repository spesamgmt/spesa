<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix='form'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/spesa/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="/spesa/js/jQuery_v3.2.1.js" type="text/javascript"></script>
<script src="/spesa/js/dynamic_list_helper.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready( function() {
    var config = {
        rowClass : 'person',
        addRowId : 'addPerson',
        removeRowClass : 'removePerson',
        formId : 'personListForm',
        rowContainerId : 'personListContainer',
        indexedPropertyName : 'fieldList',
        indexedPropertyMemberNames : 'element,label,path',
        rowAddedListener : rowAdded,
        rowRemovedListener : rowRemoved,
        beforeSubmit : beforeSubmit
    };
    new DynamicListHelper(config);
});
function saveNeeded() {
    $('#submit').css('color','red');
    $('#submit').css('font-weight','bold');
    if( $('#submit').val().indexOf('!') != 0 ) {
        $('#submit').val( '!' + $('#submit').val() );
    }
}
function rowAdded(rowElement) {
    //clear the imput fields for the row
    $(rowElement).find("input").val('');
    //may want to reset <select> options etc
    
    //in fact you may want to submit the form
    saveNeeded();
}
function rowRemoved(rowElement) {
    saveNeeded();
   // alert( "Removed Row HTML:\n" + $(rowElement).html() );
}
function beforeSubmit() {
    //alert('submitting....');
    return true;
}

</script>
<body ng-app="codeGenerator">


<div class="col-md-13 first-one" ng-controller="codeGeneratorController as code">
	  <div class="first-one-inner">
	  <h3 class="tittle">Master Generation</h3>
	  
<form:form action="/spesa/all/codeGenerator/generate" method="post" commandName="fields" id="personListForm">
<%@ include file="/JSPs/acknowledgement.jsp" %>	
	
			<div>
				<form:input  path="title" class="text" placeholder="Enter title"  />
				<font color="red"><form:errors path="title" /></font>
			</div>
			
				<div id="addPerson"><a href="#" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-plus"></span> Add 
        </a></div>
	<table >
	<thead>
	<tr>
		<th>Order</th>
		<th>Element</th>
		<th>label</th>
		<th>variable name</th>
	</tr>
	</thead>	
	<tbody id="personListContainer">
	<c:forEach items="${fields.fieldList}" var="fieldForm" varStatus="status">
		<tr  class="person">
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
			
			<!-- <td><span class=" col-md-2 glyphicon glyphicon-trash removePerson" ></span></td>
			<td class="col-md-2"><input type="button" class="removePerson" value="Remove"></a></td> -->
			<td><a href="#" class="btn btn-info btn-lg removePerson">
          <span class="glyphicon glyphicon-trash "></span> Delete 
        </a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
			
			<div class="submit"><input type="button" value="back" onclick="window.location.href='/spesa';"> <input id="submit" type="submit" value="Generate" ></div>
</form:form>
</div>
</div>

</body>
</html>