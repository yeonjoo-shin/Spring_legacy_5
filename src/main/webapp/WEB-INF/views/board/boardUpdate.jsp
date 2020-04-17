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
<c:import url="../template/header.jsp"></c:import>
	<h1>${board} page</h1>
	<div class="container">

<form action="./noticeUpdate" method="post">
  	<input type="hidden" name="num" value="${vo.num}">
     <div class="form-group">
      <label for="title">title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" value="${vo.title}">
    </div>
    
    <div class="form-group">
      <label for="name">name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" value="${vo.name}" disabled="disabled" >
    </div>
    
     <div class="form-group">
      <label for="content">content:</label>
      <textarea type="text" class="form-control" id="content" placeholder="Enter Content" name="content"  >${vo.content}</textarea>
    </div>
    
    <input type="submit" id="btn" class="btn btn-default" value="Write">
    
    </form>
		</div>
	
	</div>
	
	
</body>
</html>