<%@page import="com.madduu.shoppingcart.dto.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.madduu.shoppingcart.dto.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.cust-info
{
display: inline-flex;
flex-direction: column;
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
	#total
{
 display: block;
    width: 115px;
    height: 40px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
   margin: 10px auto;
    
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style=color:green>${msg}</h1>
<% Orders o=(Orders)request.getAttribute("orderdetails");
List<Item> items= o.getItems(); %>
<div class="cust-info">
<div> <strong>Name:</strong><%= o.getName() %></div>
<div> <strong>Address:</strong> <%= o.getAddress() %></div>
<div> <strong>Mobile:</strong><%= o.getMobile() %></div>
</div>
<table cellpadding="20px" border="1">

	<th>Brand</th>
	<th>Category</th>
	<th>Quantity</th>
	<th>Price</th>

<% for(Item i:items){ %>
<tr>
	<td><%= i.getBrand() %></td>
	<td><%= i.getCategory() %></td>
	<td><%= i.getQuantity() %></td>
	<td><%= i.getPrice() %></td>
	<%} %>

</table>
<div id="total"> Total Price:<%= o.getTotalprice() %></div>
<a href="customeroptions.jsp">Continue Shopping</a>
</body>
</html>