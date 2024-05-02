<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="savecustomer" modelAttribute="customerobj"> 
Enter name:<form:input path="name"/><br>
Enter address:<form:input path="address"/><br>
Enter Mobile:<form:input path="mobile"/><br>
Enter email:<form:input path="email"/><br>
Enter Password:<form:input path="password"/><br>
<input type="submit">
</form:form>
</body>
</html>