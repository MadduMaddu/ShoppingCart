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
background-color:pink;
			width: 500px;
			height: 300px;
			padding: 20px;
			margin: 100px auto;
			position: relative;

}
table
{
background:linear-gradient(45deg,pink,orange,red);
			background-size: cover;
			margin: 25px;
			top:55px;
			left: 50px;
			bottom:50px;
			position: absolute;

}
body
{
background-color: gray;
}

td>input
{
background-color: gray;
padding: 10px;
}
</style>
</head>
<body>
<div>
<h1>${msg}</h1>
<table>
<form action="customerloginvalidation">
<tr>
<td>Enter Email:</td><td><input type="email" name="email"></td></tr>
<tr>
<td>Enter Password:</td><td><input type="password" name="password"></td></tr>
<tr>
<td><input type="submit"></td>
</tr>
<tr>
<td>
don't have account<a href="customer_menu.jsp">Click here</a>
</td>
</tr>
</form>
</table>
</div>
</body>
</html>