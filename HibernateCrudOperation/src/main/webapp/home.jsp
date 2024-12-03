<%@page import="com.tech.bean.employee.Employee"%>
<%@page import="java.util.List"%>
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
<form action="openform" method="post">
<h1>welcome to home page</h1><br>
<button type="submit" value="ADD EMPLOYEE">ADD EMPLOYEE</button>
</form>
<c:if test="${employee!=null}">
<table>
<thead>
<tr>
<th>id</th>
<th>Employee_Nam</th>
<th>Salary</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${employee }" var="e">
<tr>
<td>${e.getId()}</td>
<td>${e.getEname() }</td>
<td>${e.getSalary() }</td>
<td>
<a href="deleteemployee?id=${e.getId()}">Delete / </a><a href="getdatafromtable?id=${e.getId()}"> Edit</a>
</td>
</tr>
</tbody>
</c:forEach>
</c:if>
</table>
</body>
</html>