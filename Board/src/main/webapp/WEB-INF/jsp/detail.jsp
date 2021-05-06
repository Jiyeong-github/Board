<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>디테일</title>
</head>
<body>
<div><a href="/del?iboard=${param.iboard }">삭제</a></div>
<div><a href="mod?iboard=${param.iboard }">수정</a></div>
<div><a href="/list">리스트</a></div>
<div>제목:${data.title }</div>
<div>작성일자:${data.regdt }</div>
<div>${data.ctnt }</div>
</body>
</html>