<%@page import="com.madduu.shoppingcart.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#buy
{
 display: block;
    width: 115px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
   margin: 10px auto;
    
}
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
	#price
	{
	background-color:pink;
	border: none;
	}
</style>
</head>
<body>
<%
List<Item> items=(List<Item>)request.getAttribute("itemslist");
double totalprice=(double)request.getAttribute("totalprice");
%>
<table cellpadding="20px" border="1">
	<th>Brand</th>
	<th>Model</th>
	<th>Category</th>
	<th>Price</th>
	<th>Quantity</th>
	<% for(Item i:items){ %>
	<tr>
		<td><%=i.getBrand() %></td>
		<td><%=i.getModel() %></td>
		<td><%=i.getCategory() %></td>
		<td><%=i.getPrice() %></td>
		<td><%=i.getQuantity() %></td>
	</tr>
	<%} %>
	<tr><td id="price">
Total Price:<%=totalprice %></td></tr>
</table>
<a href="addorder" id="buy">Buy Now</a>

</body>
</html>