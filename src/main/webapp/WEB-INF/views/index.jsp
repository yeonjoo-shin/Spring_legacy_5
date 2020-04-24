<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <c:import url="./template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<h1>Index Page</h1>
	<button id="btn">button</button>
	<script type="text/javascript">
		$("#btn").click(function(){
			//jquery ajax
			//get
			alert("start");
			$.get("./notice/noticeSelect?num=335",function(result){
				console.log(result);
			});
			alert("finish");
		});
	</script>
	
</body>
</html>