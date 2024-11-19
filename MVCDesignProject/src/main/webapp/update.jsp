<%@page import="com.user.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="updatestudent" method="post">
<div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter mobile number</label>
    <input type="number" class="form-control"  style="width:300px;" id="exampleInputEmail1" name="txtnumber" aria-describedby="emailHelp">
    <button type="submit">ViewDetails</button>
  </div>
 </form>
 
 <%Student s=(Student)request.getAttribute("details");
 if(s!=null)
 {
 %>
 <form action="updatestudentdetails" method="post">
 <div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" class="form-control"  style="width:300px;" id="exampleInputEmail1" value="<%=s.getName() %>" name="txtname" aria-describedby="emailHelp">
  </div>
  <div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Age</label>
    <input type="number" class="form-control"  style="width:300px;" id="exampleInputEmail1" value="<%=s.getAge() %>" name="txtage" aria-describedby="emailHelp">
  </div>
  <div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mobile</label>
    <input type="text" class="form-control"  style="width:300px;" id="exampleInputEmail1" value="<%=s.getMobile() %>" name="txtmobile" aria-describedby="emailHelp">
  </div>
  <div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Address</label>
    <input type="text" class="form-control"  style="width:300px;" id="exampleInputEmail1" value="<%=s.getEmail()%>" name="txtemail" aria-describedby="emailHelp">
  </div>
  <div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mail</label>
    <input type="mail" class="form-control"  style="width:300px;" id="exampleInputEmail1" value="<%=s.getAddress() %>" name="txtaddress" aria-describedby="emailHelp">
  </div>
  <div align="center"    class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Course</label>
    <input type="text" class="form-control"  style="width:300px;" id="exampleInputEmail1" value="<%=s.getCource() %>" name="txtcourse" aria-describedby="emailHelp">
  </div>
  <div align="center"    class="mb-3">
    <button type="submit">Update</button>
  </div>
  
  <%} 
 if(request.getAttribute("message")!=null)
 {%>
 <label style="color: green;"><%=request.getAttribute("message") %></label>
<% 	 
 }
 %>
  </form>
</body>
</html>