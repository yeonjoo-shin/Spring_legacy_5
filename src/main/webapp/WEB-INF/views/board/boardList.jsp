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
	<h1>${board} List</h1>
		<table class="table table-hover">
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		
		<c:forEach items="${list}" var="vo"> <!-- list 에서 하나꺼내서  vo에 넣어서 돌리기 -->
		<tr>
			<td>${vo.num}</td>
			<td><a href="./${board}Select?num=${vo.num}"> ${vo.title }</a></td>
			<td>${vo.name }</td>
			<td>${vo.ddate }</td>
			<td>${vo.hit}</td>
		</tr>
		</c:forEach>
		</table>
		<div>
			<a href="./${board}Write" class="btn btn-danger">write</a>
		
		</div>
	
	</div>

</div>


		
		
		
		
		
</body>
</html>