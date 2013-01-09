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
	Shows formatted Date and Currency using Annotation
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
		</tr>
		</c:forEach>
	</table>
</body>
</html>