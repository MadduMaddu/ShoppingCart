<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="java.util.List"%>
<%@page import="com.madduu.shoppingcart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	table
	{
	background-color:pink;
			width: 500px;
			height: 400px;
			padding: 20px;
			margin: 10px auto;
			position: relative;
	}
	td
	{
	background-color:gray;
	}
	th
	{
	background-color:navy;
	}
	</style>
</head>
<body>
<%List<Product> products=(List<Product>)request.getAttribute("productslist");%>
<h1><a href="fetchitemsfromcart">View Cart</a></h1>
<div>
	<table cellpadding=20px; border="1">
	
   <th>brand</th>
   <th>model</th>
   <th>category</th>
   <th>price</th>
   <th>AddtoCart</th>
   <% for(Product p:products){ %>
   <tr>
   		<td><%= p.getBrand() %></td>
   		<td><%= p.getModel() %></td>
   		<td><%= p.getCategory() %></td>
   		<td><%= p.getPrice() %></td>
   		<td><a href="additem?id=<%=p.getId()%>">add</a></td>
  	</tr>
  	<% } %>
	</table>
	</div>
</body>
</html>