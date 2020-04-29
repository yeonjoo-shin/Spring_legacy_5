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
<h1>${borad}write </h1>
<form action="./${board}Write" id="frm" method="post" enctype="multipart/form-data">
  
     <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" >
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" value="${member.id}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="content">Content:</label>
      <textarea rows="20" cols=""  class="form-control" id="content" placeholder="Enter Content" name="content"  ></textarea>
    </div>
    
    <input type="button" id="add" class="btn btn-info" value="AddFile">
   
    <div id="file">
	   
    </div>
   
    <input type="button" id="btn" class="btn btn-default" value="Write">
    
</form>
</div>


<script type="text/javascript" src="../resources/js/boardForm.js">


<script type="text/javascript">
$("#content").summernote({
	height : 400,
	callbacks : {
		onImageUpload : function(files) {
			//console.log("upload");//이미지 업로드 했을때 제대로 작동하는지 확인
			$.ajax({
				type:"POST",
				url : "../boardFile/fileInsert",
				enctype : "multipart/form-data",
				cache:false,
				contentType:false,
				processData:false,
				success:function(imageName){}//저장한 이상한 이름 긴것을 보내줌
			});
		}
	}
});

</script>
	
</body>
</html>