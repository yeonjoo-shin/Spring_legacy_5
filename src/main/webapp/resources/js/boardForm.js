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
		height: 300,
		callbacks:{
			onImageUpload:function(files, editor){
				var formData = new FormData();//<form></form>
				formData.append('files', files[0]); //<input type="file" name="">
				$.ajax({
					type:"POST",
					url:"../boardFile/fileInsert",
					data:formData,
					enctype:"multipart/form-data",
					cache:false,
					contentType:false,
					processData:false,
					success:function(imageName){
						console.log(imageName);
						imageName=imageName.trim();
						$("#content").summernote('editor.insertImage', imageName);
					}
					
				});
			},//onImageUpload
			
			onMediaDelete:function(files){
				
				var fileName = $(files[0]).attr("src");
				fileName = fileName.substring(fileName.lastIndexOf("/"));
				console.log(fileName);
				$.ajax({
					type: "POST",
					url: "../boardFile/summerDelete",
					data:{
						fileName:fileName
					},
					success:function(data){
						console.log(data);
					}
					
				});
			}//OnMediarDelete
			
		}//callBack
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
	
	
	
	
//	//$("선택자"). action();
//	$("#content").summernote({
//		height : 400
//	});