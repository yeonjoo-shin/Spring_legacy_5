<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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