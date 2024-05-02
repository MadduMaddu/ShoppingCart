<%@page import="com.madduu.shoppingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div
{
background:linear-gradient(180deg,aqua,gray);
			width: 500px;
			height: 300px;
			padding: 20px;
			margin: 100px auto;
			position: relative;

}
body
{
background-color: olive;
}
</style>
</head>
<body>
<div>
<h1 style=color:green>${msg}</h1>
<% Customer c=(Customer)session.getAttribute("customerinfo"); %>
<%if(c!=null){ %>
<h1><a href="displayproducts">Display all Products</a></h1>
<h1><a href="readbrandfromcustomer.jsp">Display Products by Brand</a></h1>


<%} else{ %>
<h1><a href="customerloginform.jsp">Please Login</a></h1>
<%} %>
</div>
</body>
</html>