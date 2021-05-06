<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 목록</title>
</head>
<body>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일자</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr class="record" onclick="moveToDatail(${item.iboard});">
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.regdt }</td>
			</tr>
		</c:forEach>
	</table>
	<script>
	function moveToDetail(iboard){
		location.href='/detail?iboard='+iboard;
	}
	</script>
</body>
</html>