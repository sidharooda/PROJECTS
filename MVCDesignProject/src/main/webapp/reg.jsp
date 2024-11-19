<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
  margin-block: 35px;
}
.a{
border: 1px solid black;
  width: 700px;
  height: 50%;
  background: utl('C:\Users\ksidd\Downloads');
  color: white;
  border-radius: 20px;
  box-shadow: opx opx 20px rgba(0,0,0,0.75);
  background-size: cover;
  background-position: center;
  overflow: hidden;
  background-color: powderblue;
  margin-left: 375px;
  
}
.b{
color:blue;
}
.c:hover{
  background-color: yellow;
  font-size: 18px;
}
h1{
color: black;
}
</style>
</head>
<body>
<form action="reg" method="post">
<div align="center" class="a">
<marquee>
<h1 >WELCOME TO REGISTRATION PAGE</h1></marquee>
<table >
<tr>
<td>
<label class="b">NAME</label>
</td>
<td>
<input type="text" name="txtname"><br>
</td>
</tr>
<tr>
<td>
<label class="b">EMAIL</label>
</td>
<td>
<input type="email" name="txtemail"><br>
</td>
</tr>
<tr>
<td>
<label class="b">PASSWORD</label>
</td>
<td>
<input type="password" name="txtpassword"><br>
</td>
</tr>
<tr>
<td></td><td>
<label> <h4 style="color:red">  <%            
if(request.getAttribute("message")!=null)
{
	out.println(request.getAttribute("message"));
}


%> </h4></label>
</td>
</tr>
<tr>
<td></td><td>
<input type="submit" class="c"><a href="login.jsp">loginpage</a>
</td>
</tr>
</table>
</div>
</form>
</body>
</html>