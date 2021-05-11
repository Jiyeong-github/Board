<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<div>${loginUser.unm }님
		(${loginUser.uid}) 환영합니다. <a href="/user/logout">로그아웃</a>
	</div>
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>리스트</div>

	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
		</tr>

		<c:forEach items="${list}" var="item">
		<tr>
		<td>${item.iboard }</td>
		<td>${item.title }</td>
		<td>${itme.unm }</td>
		<td>${item.regdt }</td>
		</tr>
</c:forEach>
	</table>
</body>
</html>