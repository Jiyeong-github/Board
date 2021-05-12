<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>%{data.title}</title>
</head>
<body>
<h1>디테일 페이지</h1>
<div>${param.iboard }</div>

<div>제목:${data.title }</div>
<div>작성자:${data.unm }</div>
<div>작성일:${data.regdt }</div>
<div>${data.ctnt }</div>

<c:if test="${loginUser.iuser == data.iuser }">
	<div><a href="/board/del?iboard=${param.iboard }">삭제</a></div>
	<div><a href="/board/mod?iboard=${param.iboard }">수정</a></div>
</c:if>
</body>
</html>