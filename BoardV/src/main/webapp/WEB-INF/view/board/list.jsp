<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<script defer src="/res/JS/list.js?ver=6"></script>
<link href="/res/CSS/list.css?ver=3" rel="stylesheet" type="text/css">
<!-- defer 넣음으로써 화면 먼저 띄움 -->
</head>
<body>
	<div>${sessionScope.loginUser.unm }님(${sessionScope.loginUser.uid })
		환영합니다.<a href="/user/logout">로그아웃</a>
		<!-- session에 Login.servlet에서 loginUser로 담아서 unm을 저기에다가 담아줌 -->
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
				<th>글쓴이</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>
<!-- 이걸 씀으로써 서버 돌리는 게 아주 죅곰 유용-->
			<c:forEach items="${requestScope.list }" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard }</td>
					<td>${item.title }</td>
					<td>${item.unm }</td>
					<td>${item.ctnt }</td>
					<td>${item.regdt }</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>