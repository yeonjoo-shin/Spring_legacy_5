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

	<div class="row">
	<h1>Member List</h1>
	 <form class="col-xs-6" action="./memberList">
		    <div class="input-group" >
		    	<select class="form-control" id="sel1" name="kind">
				    <option value="bi">ID</option>
				    <option value="bn">UNAME</option>
				    <option value="bp">PHONE</option>
				    <option value="be">EMAIL</option>
  				</select>
		      <input type="text" class="form-control" placeholder="Search" name="search">
		      <div class="input-group-btn">
		        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
		      </div>
	    </div>
	 	 </form>
	 	 
	 	<div id="result">
	 	<table class="table table-hover">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>PHONE</td>
			<td>EMAIL</td>
			<td><input type="checkbox" id="all"><button class="btn btn-danger" id="delete" >Delete</button></td>
			
		</tr>
		
		<c:forEach items="${list}" var="vo" varStatus="i"> <!-- list 에서 하나꺼내서  vo에 넣어서 돌리기 --><!-- varstatus="변수명" -->
		<tr>
			<td id="id${i.index}">${vo.id}</td> <!-- 체크된 id값과 체크박스를 연결하기 위해 -->
			<td>${vo.uname}</td>
			<td>${vo.phone}</td>
			<td>${vo.email}</td>
			<td><input type="checkbox" name="del" class="ch" title="id${i.index}" id="${vo.id}"></td><!-- 타이틀에 같은 값을 가져와서 -->
		</tr>
		</c:forEach>
		</table>
		
		<div>
		<ul class="pagination">
			<c:if test="${pager.curBlock gt 1}">
			<li><a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
			</c:if> 
			
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum }" var="i">
			<li><a href="./memberList?curPage=${i} &kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>
			
			<c:if test="${pager.curBlock lt pager.totalBlock}">
				<li><a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"> 다음 </a></li>
			</c:if>
			</ul>
		</div>
		</div>
		
	</div>
	</div>
	
	<script type="text/javascript">
		//----체크박스 전체 선택/해제--------
		
		$("#result").on("click","#all",function(){//이벤트 위임(html로 덮어쓴 이후에 안되니까 위임)
			var ch = $(this).prop("checked");		
			$(".ch").prop("checked",ch);
		});
		
		$("#result").on("click",".ch",function(){
			var result = true;
			$(".ch").each(function() {
				if(!$(this).prop("checked")){
					result=false;
				}
			});
			
			$("#all").prop("checked",result);
		})
	
	
		
		//-----체크박스 선택 삭제 ex)장바구니-----
		$("#result").on("click","#delete",function(){
			var ids = [];//빈 배열 만들기 이 배열에 체크된 아이들을 넣을거야
			$(".ch").each(function() {
				if($(this).prop("checked")){
					//var id =$(this).attr("title"); 방법 1
					//alert($("#"+id).text());
					
					//alert($(this).attr("id")); //방법2
					
					ids.push($(this).attr("id"));//반복문을 통해 하나씩 가져와서 ids 배열에 집어넣기
				}
		});
		
			//foreach 끝
			$.ajax({
				type : "get",
				url : "./memberDeletes",
				traditional : true,
				data : {
					ids:ids
				},
				success : function(data) {
				 //alert(data);	지워진거 확인
				 	$.get("./memberLists",function(data){//삭제후, 멤버리스트 가져오기
				 		$("#result").html(data.trim());//리스트 부분 덮어쓰우기
				 	});
				}
				
			});
			
		});
		
		
		
	
	</script>
</body>
</html>