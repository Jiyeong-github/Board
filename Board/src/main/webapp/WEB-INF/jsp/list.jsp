<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
</head>
<body>
<div>
<a href="/write">�۾���</a>
</div>
<div>
<table>
<tr>
<td>��ȣ</td>
<td>����</td>
<td>��¥</td>
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
	
}
</script>
</body>
</html>