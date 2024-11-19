<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
background-color: powderblue;
height:500px;
width: 100%;

}
.a{
color: blue;
}
.b:hover{
background-color: yellow;
font-size: 15px;
}
</style>
</head>
<body>
<form action="savestudent" method="post">
<div align="center">
<h1>   ADDING STUDENT DETAILS</h1>
<table>
<tr>
<td>
<label class="a">NAME</label>
</td>
<td>
<input type="text" name="txtname"/>
</td>
</tr>
<tr>
<td>
<label class="a">AGE</label>
</td>
<td>
<input type="text" name="txtage"/>
</td>
</tr>
<tr>
<td>
<label class="a">MOBILE</label>
</td>
<td>
<input type="text" name="txtmobile"/>
</td>
</tr>
<tr>
<td>
<label class="a">EMAIL</label>
</td>
<td>
<input type="email" name="txtemail"/>
</td>
</tr>
<tr>
<td>
<label class="a">ADDRESS</label>
</td>
<td>
<input type="text" name="txtaddress"/>
</td>
</tr>
<tr>
<td>
<label class="a">COURSE</label>
</td>
<td>
<input type="text" name="txtcourse"/>
</td>
</tr>
<tr>
<td>
</td>
<td>
<% 
if(request.getAttribute("message")!=null)
{
	out.println("<h4 style=color:red>"+request.getAttribute("message")+"</h4>");
}
if(request.getAttribute("message1")!=null)
{
	out.println("<h4 style=color:green>"+request.getAttribute("message1")+"</h4>");
}
%>
</td>
</tr>
<tr>
<td>
</td>
<td>
<input type="submit"  value="SAVE" class="b"/>
</td>
</tr>
</table>
</div>
</form>
</body>
</html>