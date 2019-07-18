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
	<h1 align="center">Employee Deletion</h1><!-- In model attribute it will call the setter methods of all the fields given -->
	<form style="text-align:center" onsubmit="handleSubmit()">
	<h2 >
	 	 ID:<input id="userId" name="id"/><br>
	</h2>
	<button type="submit" >Delete Employee</button>
	</form>
	<script>
	  function handleSubmit(event){
		  console.log('came here in teh client side');
		  //event.preventDefault();
		  //var userId = document.getElementById("userId");
		  //var url = "/emp-mvc/employee/delete/"+userId;
		 // console.log(url);
	  }
	</script>
</body>
</html>