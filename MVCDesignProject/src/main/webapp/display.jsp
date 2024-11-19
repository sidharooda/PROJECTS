<%@page import="com.user.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.a{
background-color: powderblue;
}
</style>
</head>
<body>
<table class="table table-dark table-striped">
<thead >
<tr>
<th>sid</th>
<th>name</th>
<th>age</th>
<th>mobile</th>
<th>email</th>
<th>Address</th>
<th>course</th>


</thead>
<tbody >
<% ArrayList<Student> al=(ArrayList<Student>)request.getAttribute("student list");
for(Student  s: al) {%>
<tr>
<td> <%=s.getSid() %></td>
<td> <%=s.getName()%></td>
<td> <%=s.getAge() %></td>
<td> <%=s.getMobile() %></td>
<td> <%=s.getEmail()%></td>
<td> <%=s.getAddress() %></td>
<td> <%=s.getCource() %></td>
</tr>
	
<% }
	
%>


</tbody>
</table>

</body>
</html>