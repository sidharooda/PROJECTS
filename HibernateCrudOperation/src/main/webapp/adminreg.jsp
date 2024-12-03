<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="adminreg" method="post">
<div align="center">
<h1>Admin Register Page</h1>
<label>Name</label><input type="text" name="txtname"><br>
<label>Email</label><input type="email" name="txtemail"><br>
<label>Password</label><input type="password" name="txtpassword"><br>
<%if(request.getAttribute("msg")!=null){ %>
<label style="color: green;"><%=request.getAttribute("msg") %></label>
<%} %><br>
<input type="submit" value="Register"><br>
<a href="adminvalid.jsp">LoginPage?</a>
</div>
</form>
</body>
</html>