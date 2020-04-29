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
	<button id="btn2">button2</button>
	<!-- 
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
	 -->
	<script type="text/javascript">
		$("#btn2").click(function() {
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY",function(data){
				console.log(data);
				console.log(data[1].rate);
			});
		});
	
	
	
		$("#btn").click(function() {
			
			$.get("./json/json1", function(data) {
				
				//0. data가 String 인지 Json Object 인지 판별
				// console.log(data);  "name":"iu" -> string
				// console.log(data);  object -> json Object
				
				//1. String 이라면 Json Object 변환
				//data = data.trim();
				console.log(data);
				//data = JSON.parse(data);//body 어쩌구하면 json으로 넘겨오니까 필요없음
				console.log(data);
				console.log(data.num);
				console.log(data.title);
			});
			
		});
	
	</script> 
	 
</body>
</html>