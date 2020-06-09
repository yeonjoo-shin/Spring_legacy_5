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
	<h1>${board} List</h1>
		 <form class="form-inline" action="./${board}List">
		    <div class="input-group input-group-sm col-xs-2" >
		    
		    	<select class="form-control" id="sel1" name="kind">
				    <option value="bt">Title</option>
				    <option value="bc">Content</option>
				    <option value="bn">Name</option>
  				</select>
  				</div>
  				
  				<div class="input-group input-group-sm col-xs-4">
  				
			      <input type="text" class="form-control" placeholder="Search" name="search">
			      <div class="input-group-btn">
			        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			      </div>
	    		</div>
	 	 </form>
	 	 </div>
	 	 
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
			<td>
			<c:catch>
			 <c:forEach begin="1" end="${vo.depth}">
			 	--
			 	<!-- &nbsp;&nbsp; //스페이스바역할 -->
			</c:forEach> 
			</c:catch>
			<a href="./${board}Select?num=${vo.num}"> ${vo.title }</a></td>
			<td>${vo.name }</td>
			<td>${vo.ddate }</td>
			<td>${vo.hit}</td>
		</tr>
		</c:forEach>
		</table>
		
		<div><!-- 페이지 이동을 위한  -->
		<ul class="pagination">
			<c:if test="${pager.curBlock gt 1 }">
			<li><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"> 이전</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="./${board}List?curPage=${i} &kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock lt pager.totalBlock}">
			<li><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"> 다음 </a></li>
			</c:if>
			</ul>
		</div>
		
		<a href="./${board}Write" class="btn btn-danger">write</a>
		<c:catch>
		<c:choose>
			<c:when test="${board eq 'notice'}">
				<c:if test="${member.id eq 'admin'}">
					<div>
						<a href="./${board}Write" class="btn btn-danger">write</a>
					</div>
				
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty member}">
					<div>
						<a href="./${board}Write" class="btn btn-danger">write</a>
					</div>
				</c:if>
			</c:otherwise>
		</c:choose>
		</c:catch>
		
		
	</div>




		
		
		
		
		
</body>
</html>