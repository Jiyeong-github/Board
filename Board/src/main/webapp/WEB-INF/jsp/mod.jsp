<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
</head>
<body>
	<div><a href="/list">����Ʈ</a></div>
	<form action="/mod" method="post">
	<input type="hidden" name="iboard" value="${vo.iboard }">
	<div>����:<input type="text" name="title" value="${data.title }"></div>
	<div>����:<textarea name="content">${data.ctnt}</textarea></div>
	<div><input type="submit" value="���">
	<input type="submit" value="�ʱ�ȭ"> </div>
	</form>
</body>
</html>