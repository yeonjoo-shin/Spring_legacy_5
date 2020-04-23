<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header_sub.jsp"></c:import>


<div class="container">
<h1>${borad}write </h1>
<form action="./${board}Write" method="post" enctype="multipart/form-data">
  
     <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" >
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" >
    </div>
    
     <div class="form-group">
      <label for="content">Content:</label>
      <input type="text" class="form-control" id="content" placeholder="Enter Content" name="content"  >
    </div>
    
    <div class="form-group">
      <label for="files">File:</label>
      <input type="file" class="form-control"  name="files"  >
      <input type="file" class="form-control"  name="files"  >
    </div>
    
    <input type="submit" id="btn" class="btn btn-default" value="Write">
    
    </form>
		</div>
	

		
	
</body>
</html>