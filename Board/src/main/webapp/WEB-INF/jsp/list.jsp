<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>목록</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

.record {
	cursor: pointer;
}

.record:hover {
	background-color: #ddf564;
}
</style>
</head>
<body>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>날짜</td>
			</tr>

			<c:forEach items="${list}" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard});">
					<td>${item.iboard }</td>
					<td>${item.title }</td>
					<td>${item.regdt }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
function moveToDetail(iboard){
	location.href='/detail?iboar='+iboard;
}
</script>
</body>
</html>