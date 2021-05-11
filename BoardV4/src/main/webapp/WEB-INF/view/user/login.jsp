<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
msg{color:red}
</style>
</head>
<body>
	<div>
		<%
		String msg = null;
		msg = (String) pageContext.getAttribute("msg");
		if (msg == null) {
			msg = (String) request.getAttribute("msg");
			if (msg == null) {
				msg = (String) session.getAttribute("msg");
				if (msg == null) {
			msg = (String) application.getAttribute("msg");
				}
			}
		}
		%>
		<div class="msg">${msg}</div>
		<!-- pageContext, request, session (여기까진 개인용), application - 수명이 다르다
하나라도 setAttribute 되어야만 사용 가능하다
 -->
		<div>
			<form action="login" method="post">
				<!-- form에 아무것도 안 적으면 get 방식으로 날라감 -->
				<div>
					<input type="text" name="uid" placeholder="아이디">
				</div>
				<!-- placeholder는 뭐가 적히면 지워짐 -->
				<div>
					<input type="password" name="upw" placeholder="비밀번호">
				</div>
				<div>
					<input type="submit" value="Login">
				</div>
			</form>
		</div>
		<div>
			<a href="join">회원가입</a>
		</div>
		<!-- /을 줬을 때와 안 줬을 때의 차이 알기 -->
	</div>
</body>
</html>