<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������</title>
</head>
<body>
<div><a href="/del?iboard=${param.iboard }">����</a></div>
<div><a href="mod?iboard=${param.iboard }">����</a></div>
<div><a href="/list">����Ʈ</a></div>
<div>����:${data.title }</div>
<div>�ۼ�����:${data.regdt }</div>
<div>${data.ctnt }</div>
</body>
</html>