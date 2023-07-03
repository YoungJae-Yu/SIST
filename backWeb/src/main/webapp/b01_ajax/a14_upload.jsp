<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	    function uploadFile() {
	        var fileInput = document.querySelector("#fileInput");
	        console.log(fileInput.files)
            // FormData 객체 생성
            var formData = new FormData();
            for (var i = 0; i < fileInput.files.length; i++) {
                formData.append('files', fileInput.files[i]); // 파일 정보를 FormData에 추가
            }
	        var writerVal = document.querySelector("#writer").value
	        var contentVal = document.querySelector("#content").value
	        formData.append("writer", writerVal);
	        formData.append("content", contentVal);
	        var xhr = new XMLHttpRequest();
	        xhr.open("POST", "/backendWeb/upload", true);
	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === 4 && xhr.status === 200) {
	                console.log(xhr.responseText);
	                alert("File uploaded successfully.");
	            }
	        };
	        xhr.send(formData);
	    }
</script>
</head>
<body>
	<div class="container mt-3">
		<h2>파일등록</h2>
		<div class="mb-3 mt-3">
			<label for="writer">작성자:</label> <input type="text"
				class="form-control" id="writer" placeholder="작성자 입력" name="writer">
		</div>
		<div class="mb-3 mt-3">
			<label for="content">기타내용:</label> <input type="text"
				class="form-control" id="content" placeholder="기타내용 입력"
				name="content">
		</div>
		<div class="mb-3 mt-3">
			<label for="fileInput">파일업로드:</label> <input type="file"
				class="form-control" id="fileInput" placeholder="기타내용 입력" multiple>
		</div>
		<button type="button" onclick="uploadFile()" class="btn btn-primary">파일업로드</button>
	</div>
</body>
</html>