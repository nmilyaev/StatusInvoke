<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel='stylesheet' type='text/css' href='./css/smoothness/jquery-ui-1.9.2.custom.css'>
	<script type="text/javascript" src="./css/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="./css/js/jquery-ui-1.9.2.custom.js"></script>

	<script type="text/javascript">
	function split(val) {
	    return val.split(/,\s*/);
	}
	function extractLast(term) {
	    return split(term).pop();
	}
	 
	$(document).ready(function() {
	 
	    $( "#name" ).autocomplete({
	        source: "${pageContext. request. contextPath}/landing/find_user.htm"
	        /* source : ["Alex,Agnes,Alan,Bjok,Bill,John,Jason,Maria,Man"] */
	    });
	    
	});
</script>
</head>
<body>
	<b>Shows formatted Date and Currency using Annotation</b>
	<table>		
		<c:forEach var="user" items="${users}"  varStatus="status">
		<tr>
			<td>
				<spring:eval expression="user.name" />
			</td>
			<td>
				<!-- spring:eval not needed here as it does not invoke the binding -->
				${user.date}
			</td>
			<td>
				<spring:eval expression="user.balance" />
			</td>
			<td>
				<spring:eval expression="user.type.description" /> 
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<br/><br/><br/>
	
	<b>Load Users in Edit form and then try updating the values</b>
	<table>
		<form:form method="post" action="landing.htm" modelAttribute="userForm">
		<c:forEach items="${userForm.users}"  varStatus="status">
		<tr>
			<td>
				<form:input path="users[${status.index}].name"  size="10" />
			</td>
			<td>
				<form:input path="users[${status.index}].date" size="30" />
				<%-- <input name="user.date" value="${user.date}" size="30"/> --%>
			</td>
			<td>
				<form:input path="users[${status.index}].balance"  size="5" />
				<%-- <input name="user.balance" value="<spring:eval expression="user.balance" />" size="5"/> --%>
			</td>
			<td>
				<form:select path="users[${status.index}].type" > 
					<form:option value="NONE" label="--- Select ---"/>
					<form:options itemValue="name" itemLabel="description" />
				</form:select>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<input type="submit" value="Submit Me" name="submit"/>
			</td>
		</tr>
		</form:form>
	</table>
	
	
	<br/><br/><br/>
	
	<b>Ajax + JSON [jars included - jackson-mapper-asl-1.9.2 and jackson-core-asl-1.9.12]</b>
	<form:form method="post" modelAttribute="userForm" action="landing.htm">
	<table>
	    <tr>
	        <th>Name</th>
	        <td><form:input path="name" id="name"/></td>
	    </tr>
	    <tr>
	    	<td colspan="2"><br /> </td>
	    </tr>
	    <tr>
	    	<td colspan="2"><br /> </td>
	    </tr>
	    <tr>
	    	<td colspan="2"><br /> </td>
	    </tr>
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="Save" />
	            <input type="reset" value="Reset" />
	        </td>
	    </tr>
	</table>     
	</form:form>

</body>
</html>