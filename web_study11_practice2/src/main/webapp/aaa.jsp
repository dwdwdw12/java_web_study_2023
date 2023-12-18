<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SummerNoteExample</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="summernote/summernote-lite.js"></script>
  <script src="summernote/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="summernote/summernote-lite.css">
  <!--  -->
  
</head>
<body>

<div id="wrap">
    
     <label>내용</label>
     <textarea id="summernote" class="summernote" name="contents"></textarea><br/>
     <input type="button" value="글쓰기" class="btn" id="btn"/>
 
    
</div>

<!-- <h1>example</h1>
<div class="container">
  <textarea class="summernote" name="editordata"></textarea>    
</div> -->
<!-- <script>
$('.summernote').summernote({
	  height: 450,
	  lang: "ko-KR"
	});
</script> -->

	<script>
		$(document).ready(
				function() {
					$('#summernote').summernote({
						height : 300,
						width : 700,
						lang : "ko-KR",
						callbacks : {
							onImageUpload : function(files) {
								uploadSummernoteImageFile(files[0], this);
							}
						}
					});

					function uploadSummernoteImageFile(file, editor) {
						data = new FormData();
						data.append("file", file);
						$.ajax({
							data : data,
							type : "POST",
							url : "/uploadSummernoteImageFile",
							dataType : "JSON",
							contentType : false,
							processData : false,
							success : function(data) {
								$(editor).summernote("insertImage", data.url);
								$("#thumbnailPath")
										.append(
												"<option value="+data.url+">"
														+ data.originName
														+ "</option>");
							}
						});
					}
				});
	</script>
</body>
</html>