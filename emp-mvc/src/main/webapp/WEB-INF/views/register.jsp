<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
        .errormsg {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body bgcolor="#E6E6FA">
	<h1 align="center">Employee Registration</h1><!-- In model attribute it will call the setter methods of all the fields given -->
	<form:form action="/emp-mvc/employee/register" method="post" modelAttribute="employee" style="text-align:center">
	<h2 >
	 	 ID:<form:input path="id"/> <small><form:errors path="id" cssClass="errormsg" /></small><br>
		 Name:<form:input path="name"/><small><form:errors path="name" cssClass="errormsg" /></small><br>
	</h2>
	<button type="submit" >Submit</button>
	</form:form>
</body>
</html>