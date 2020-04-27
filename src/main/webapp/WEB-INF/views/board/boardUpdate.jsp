<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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

<form action="./${board}Update" method="post">
	<h1>${board} Update Page</h1>
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
    
    <div class="form-group">
    <label for="files">Files:</label>
    <c:forEach items="${vo.boardFileVOs}" var="fileVO">
    	<p>${fileVO.oriName}<i id="${fileVO.fileNum}" class="glyphicon glyphicon-remove remove fileDelete"></i></p>
    </c:forEach>
    
    </div>
    
    <input type="submit" id="btn" class="btn btn-default" value="Write">
    
    </form>
	</div>
	
<script type="text/javascript" >
	$("#content").summernote({
		height :400
	});
	
	
	$(".fileDelete").click(function() {
		var s= $(this);
		$.post("../boardFile/fileDelete",{fileNum:$(this).attr("id")},function(data){
			
			if(data.trim()>0){
				s.parent().remove();
				alert("success");
			}else{
				alert("File Delete Fail")
			}
		});
	});

</script>
	
	
</body>
</html>