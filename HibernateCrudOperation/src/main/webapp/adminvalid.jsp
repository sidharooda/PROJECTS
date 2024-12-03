<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="validadmin" method="post">
<div align="center">
<h1>Admin Login Page</h1><br>
<label>UserName</label><input type="email" name="txtusername"><br>
<label>Password</label><input type="password" name="txtpassword"><br>
<%if(request.getAttribute("error")!=null){ %>
<label style="color: red;"><%=request.getAttribute("error") %></label>
<%} %><br>
<input type="submit" value="Login"><br>
<a href="adminreg.jsp">Register Page</a>
</div>
</form>
</body>
</html>