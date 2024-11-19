<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="deletestudentdetails" method="post">
 <div align="center" class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mobile</label>
    <input  style="width: 300px" type="number" class="form-control" id="exampleInputEmail1" name="txtnumber" aria-describedby="emailHelp">
    <button value="submit">DeleteDetails</button>
  </div>
  
	<%if(request.getAttribute("okk")!=null){ %> 
	 <label style="color:red;align-content: center;"><%=request.getAttribute("okk") %></label>
	 <%} %>
	 <% if(request.getAttribute("message")!=null) 
  {%>
	 <label  style="color: green;align-content: center;"><%=request.getAttribute("message") %></label> 
	 <%  } %> 
	 
	 
 </form>
</body>
</html>