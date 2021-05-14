<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
<h1>디테일 페이지</h1>
<div>${param.iboard }</div>

<div>제목:${data.title }</div>
<div>작성자:${data.unm }</div>
<div>작성일:${data.regdt }</div>
<div>내용:${data.ctnt }</div>
<!-- 쿼리값을 가져올 때 param을 쓴다 -->
<c:if test = " ${data.iuser  == loginUser.iuser}">
	<div><a href="/board/del?iboard=${param.iboard }">삭제</a></div>
	<div><a href="/board/mod?iboard=${param.iboard }">수정</a></div>
</c:if>
</body>
</html>