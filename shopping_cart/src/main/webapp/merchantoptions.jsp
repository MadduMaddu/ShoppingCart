<%@page import="com.madduu.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style=color:green>${msg}</h1>
<% Merchant m=(Merchant)session.getAttribute("merchantinfo"); %>
<% if(m!=null){ %>
<h1><a href="addproduct">Add Product</a></h1>
<h1><a href=" viewallproducts.jsp">View Products</a></h1>
<%} else { %>
<h1> <a href="merchantloginform.jsp">please login</a></h1>
<%} %>
</body>
</html>