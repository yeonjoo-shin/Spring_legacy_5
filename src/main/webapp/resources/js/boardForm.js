/**
 * 게시판 글 쓰기 할 때 파일업로드를 위한 추가 삭제 자바 스크립트
 */


	var count = 1;
	
	
	
	$("#add").click(function(){
		
		if(count<6){
			$("#file").append('<div class="form-group"><label for="file">File:</label><input type="file" class="form-control files" name="files" ><i class="glyphicon glyphicon-remove remove"></i></div>');
			
			count++;
		}else{
			alert("파일은 5개까지만 추가 가능합니다.");
		}
	});
		
	$("#file").on("click",".remove",function(){
		$(this).parent().remove();//자기자신의 부모를 찾아서 지우기
		count--;
	});
	
////////////////////////////////////
	$("#content").summernote({
	    height:400,
	    callbacks: {
	       onImageUpload: function(files,editor) {//editor-섬머노트 그 자체/files-업로드할 파일 정보(꺼내서 서버로 전송)
	    	   
	    	   	var formData = new FormData();//<form>태그같은 것
	    	   	
	    	   	formData.append('files',files[0]);//폼태그안에 정보 강제로 집어 넣기<input type="file" name="">(파리미터이름 'files',value files)
	    	   
	             $.ajax({
	              type="POST",
	              url:"../boardFile/fileInsert",
	              data:formData,//파라미터이름과 벨류값이 들어잇는 것 자체를 가지고 오기
	              enctype:"multipart/form-data",
	              cache:false,
	              contentType:false,
	              processData:false,
	              success:function(imageName){}
//	              	imageName = imageName.trim();
//	              	$(editor).summernote('editor.insertImage',imageName);
	              //하드디스크에 저장 후 > 저장된 이름 > 이쪽으로 받아줄거임 > img태그 써서 경로명 붙일 거임
	                
	             });
	             
	       }
	    }
	    
	 });

	////////////////////////////////


	$("#btn").click(function(){
		//title, contents 데이터 유무 확인
		var title = $("#title").val();
		var content =$("#content").val();
		
		var ch3 = true;
		$(".files").each(function(){
			if($(this).val()==""){
				ch3 = false;
			}
		});
		
		var ch1 = title !="";
		var ch2 = content !="";
		//var ch2 = $("#content").summernote('isEmpty'); 섬머노트가 컨텐츠못받아올때 사용
		
		if(ch1 && ch2 && ch3){
			//form 전송(submit event 강제 발생)
			$("#frm").submit();
		}else {
			//submit event 종료
			alert("필수 요소는 모두 입력하세요.");
		}
		
		
		/*	console.log(title=='');
		console.log(content=="");
		console.log(title.length);
		console.log(content.length);*/
		
		//content = $("#content").summernote("code"); 섬머노트가 컨텐츠못받아올때 사용
		//console.log($("#content").summernote('isEmpty'));
	});
	
	
	
	

	//$("선택자"). action();
//	$("#content").summernote({
//		height : 400,
//		callbacks : {
//			onImageUpload : function(file) {
//				console.log("upload");//이미지 업로드 했을때 제대로 작동하는지 확인
//			}
//		}

//	});