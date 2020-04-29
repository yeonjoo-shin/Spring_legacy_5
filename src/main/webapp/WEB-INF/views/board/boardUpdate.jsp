<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
</head>
<body>
<c:import url="../template/header_sub.jsp"></c:import>
	
<div class="container">

<form action="./${board}Update" method="post" enctype="multipart/form-data">
	<h1>${fn:toUpperCase(board)} Update Page</h1>
	
  	<input type="hidden" name="num" value="${vo.num}" >
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
      <textarea  class="form-control" id="content" placeholder="Enter Content" name="content"  >${vo.content}</textarea>
    </div>
    
    <input type="button" id="add" class="btn btn-info" value="AddFile">
   
    <div id="file">
	   
    </div>
    <div class="form-group">
		  <label for="files">Files:</label>
		  <c:forEach items="${vo.boardFileVOs}" var="fileVO">
		  	<p>${fileVO.oriName}<i id="${fileVO.fileNum}" title="${fileVO.board}" class="glyphicon glyphicon-remove remove fileDelete"></i></p>
		  </c:forEach>
    
    </div>
   
    
    <input type="submit" id="btn" class="btn btn-default" value="Write">
    
    </form>
	</div>
<script type="text/javascript" src="../resources/js/boardForm.js"></script>
<script type="text/javascript" >

	//var size = ${size}
	
	size = ${vo.boardFileVOs.size()};
	
	size = ${fn:length(vo.boardFileVOs)};
	
	count = count+size;//파일 5개만 추가 가능하게
	
	
	$("#content").summernote({
		height :400
	});
	
	
	$(".fileDelete").click(function() {
		var check = confirm("진심 삭제할꺼야?");
		
		if(check){
		var s= $(this);
		$.post("../boardFile/fileDelete",{fileNum:$(this).attr("id"),board:$(this).attr("title")},function(data){
			
			if(data.trim()>0){
				s.parent().remove();
				count--;
				alert("success");
			}else{
				alert("File Delete Fail")
			}
		});
	}
	});

</script>
	
	
</body>
</html>