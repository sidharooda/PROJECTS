<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${employeedata==null }">
<form action="add" method="post">
</c:if>
<c:if test="${employeedata!=null }">
<form action="update" method="post">

</c:if>
<div align="center">
<input type="hidden" name="id" value="${employeedata.getId() }"/><br>
<label>name</label><input type="text" name="txtname" value="${employeedata.getEname() }"><br>
<label>salary</label><input type="number" name="txtsalary" value="${employeedata.getSalary() }"><br>
<%if(request.getAttribute("msg")!=null) {%>
<label style="color: green;"><%=request.getAttribute("msg") %></label>
<%} %><br>
<button type="submit">AddDetails</button><br>
<a href="home">Home</a>
</div>
</form>

</body>
</html>