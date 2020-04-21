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
<div class="container"> 
<div class="row">
	<h1> title :  ${vo.title }</h1>
	<h1> writer : ${vo.name }</h1>
	<h1> content  : ${vo.content } </h1>

</div>


<div>
	<a href="./${board}Update?num=${vo.num}" class="btn btn-danger">Update</a>
	<a href="./${board}Delete?num=${vo.num}" class="btn btn-primary">Delete</a>
	<c:if test="${board ne 'notice'}">
	<a href="./${board}Reply?num=${vo.num}" class="btn btn-info">Reply</a>
	</c:if>
</div>
</div>
</body>
</html>