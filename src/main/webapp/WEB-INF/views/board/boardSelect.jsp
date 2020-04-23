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
<div class="panel panel-info">
	<div class="panel-heading">Title</div>
	<div class="panel-body"> ${vo.title }</div>
	<div class="panel-heading"> Writer</div> 
	<div class="panel-body">${vo.name }</div>
	<div class="panel-heading"> Content </div> 
	<div class="panel-body"> ${vo.content } </div> 
</div>



<div>
	<c:forEach items="${vo.boardFileVOs}" var="file">
		<div>
			<a href="../boardFile/fileDown?fileNum=${file.fileNum}&board=${file.board}">${file.oriName}</a>
		</div>
	</c:forEach>
	<div>
		<img src="">
	</div>
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