<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ����</title>
</head>
<body>
	<form action="/mod" method="post">
	<input type="hidden" name="iboard" value="${param.iboard }"> <!-- ������ jsp �Ѱܹ��� -->
		<div>
			����:<input type="text" name="title" value="${data.title}">
		</div>
		<div>
			����:
			<textarea name="ctnt">${data.ctnt }</textarea>
		</div>
		<div>
			<input type="submit" value="����"> 
			<input type="reset" value="�ʱ�ȭ">
		</div>
	</form>
</body>
</html>