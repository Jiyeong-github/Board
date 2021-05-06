<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 수정</title>
</head>
<body>
	<form action="/mod" method="post">
	<input type="hidden" name="iboard" value="${param.iboard }"> <!-- 디테일 jsp 넘겨받음 -->
		<div>
			제목:<input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용:
			<textarea name="ctnt">${data.ctnt }</textarea>
		</div>
		<div>
			<input type="submit" value="삭제"> 
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>