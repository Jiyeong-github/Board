<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
</head>
<body>
<form action="/mod?iboard=${param.iboard}" method="post">
	<input type="hidden" name="iboard" value="${param.iboard }">
	<div>����:<input type="text" name="title" value="${data.title }"></div>
	<div>����:<textarea name="ctnt">${data.ctnt }</textarea></div>
	<div>
	<input type="submit" value="����">
	<input type="submit" value="�ʱ�ȭ">
	</div>
	</form>
</body>
</html>