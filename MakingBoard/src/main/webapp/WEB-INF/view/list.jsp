<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ���</title>
</head>
<body>
	<div>
		<a href="/write">�۾���</a>
	</div>
	<table>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ�����</th>
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