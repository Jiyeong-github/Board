<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글쓰기</title>
</head>
<body>
<form action="/write" method="post">
<div>제목:<input type="text" name="title"></div>
<div>내용:<textarea name="ctnt"></textarea></div>
<div><input type="submit" value="등록"></div>
</form>
</body>
</html>