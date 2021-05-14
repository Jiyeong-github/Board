<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<div>${loginUser.unm }님(${loginUser.uid })
		환영합니다.<a href="/user/logout">로그아웃</a>
	</div>
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>글 목록</div>

	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>

			<c:forEach items="${list }" var="item">
				<tr onclick="moveToDetail(${item.iboard})">
					<th>${item.iboard }</th>
					<th>${item.title }</th>
					<th>${item.ctnt }</th>
					<th>${item.regdt }</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
	function moveToDetail(iboard){
		location.href='/board/detail?iboard='+iboard;
	}
	</script>
</body>
</html>