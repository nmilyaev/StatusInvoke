<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</body>
</html>