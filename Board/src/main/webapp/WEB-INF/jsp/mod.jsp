<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>수정</title>
</head>
<body>
<form action="/mod?iboard=${param.iboard}" method="post">
	<input type="hidden" name="iboard" value="${param.iboard }">
	<div>제목:<input type="text" name="title" value="${data.title }"></div>
	<div>내용:<textarea name="ctnt">${data.ctnt }</textarea></div>
	<div>
	<input type="submit" value="수정">
	<input type="submit" value="초기화">
	</div>
	</form>
</body>
</html>