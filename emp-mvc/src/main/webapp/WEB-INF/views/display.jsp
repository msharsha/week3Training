<%@page import="com.sapient.springdemo2.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body bgcolor="#E6E6FA">
	<h2 align="center">Employee Details</h2>
	<table border="1" align=center style="text-align:center">
	<tr>
		<th>ID</th>
		<th>Name</th>
	</tr>
		<c:forEach var="emp" items="${allEmployees}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>