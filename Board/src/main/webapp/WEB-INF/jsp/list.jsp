<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
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
	<a href="write">�۾���</a>
	</div>
	<table>
	<tr>
	<th>��ȣ</th>
	<th>����</th>
	<th>�ۼ�����</th>
	
	<c:forEach items="${list}" var="item" >
	${param.iboard }
	</c:forEach>
	</tr>
	</table>
	<script>
	<tr class="" onclick="moveToDeatil">
	moveToDetail="detail?=iboard";
	</tr>
	</script>
</body>
</html>