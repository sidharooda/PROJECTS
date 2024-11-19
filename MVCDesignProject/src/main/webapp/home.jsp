<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="studenthome" method="post">
<h1>welcome to home page</h1>
<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
  <input type="submit" class="btn btn-dark" name="action" value="add student"/>
  <input type="submit" class="btn btn-dark" name="action" value="Delete"/> 
  <input type="submit" class="btn btn-dark" name="action" value="Display"/>
  <input type="submit" class="btn btn-dark" name="action" value="Update"/>
</nav>
</form>
</body>
</html>