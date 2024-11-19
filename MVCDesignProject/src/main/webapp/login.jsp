<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.login{
  border: 1px solid black;
  width: 400px;
  height: 500px;
  background: utl('C:\Users\ksidd\Downloads');
  color: white;
  border-radius: 20px;
  box-shadow: opx opx 20px rgba(0,0,0,0.75);
  background-size: cover;
  background-position: center;
  overflow: hidden;
}
form{
display: block;
box-sizing:border-box;
padding: 40px;
width: 100%;
height: 100%;
flex-direction: column;
display: flex;
}
h1{
color:black;
font-weight: normal;
font-size: 24px;
text-shadow: 0px 0px 2px rgba(0,0,0,0.5);
margin-bottom: 60px;

}
label
{
color: rgba(255,255,255,0.8);
text-transform: uppercase;
font-size: 10px;
letter-spacing: 2px;
padding-left: 10px;
}
input{
background: rgba(255,255,255,0.3);
height: 40px;
line-height: 40px;
border-radius: 20px;
padding: 0px 20px;
border: none;
margin-bottom: 20px;
color: white;

}



div{
background-color: powderblue;
height: 250px;
width: 50%;
margin-left: 375px;
}
.a{
color: blue;
}
.b:hover{
background-color: yellow;
  font-size: 18px;
}
</style>
</head>
<body>
<form action="log" method="post">
<div class="login"  align="center">
<marquee><h1>WELCOME TO LOGIN PAGE</h1></marquee>
<table>
<tr>
<td>
<label class="a">USERNAME</label>
</td>
<td>
<input type="email" name="txtusername"><br>
</td>
</tr>
<tr>
<td>
<label class="a">PASSWORD</label>
</td>
<td>
<input type="password" name="txtpassword"><br>
</td>
</tr>
<tr>
<td></td><td>
<label><h4 style="color:red"><% if(request.getAttribute("message")!=null)
{
	out.println(request.getAttribute("message"));
}
%> </h4> </label><br> </td></tr> 
<tr><td></td><td>           
<input type="submit" value="login" class="b">
<a href="reg.jsp">signuppage</a></td></tr>
</table>
</div>
</form>
</body>
</html>