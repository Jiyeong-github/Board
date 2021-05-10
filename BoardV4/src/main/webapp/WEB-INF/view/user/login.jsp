<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
</head>
<body>
<div>
<div>
<form> 
<!-- form에 아무것도 안 적으면 get 방식으로 날라감 -->
<div><input type="text" name="uid" placeholder="아이디"></div>
<!-- placeholder는 뭐가 적히면 지워짐 -->
<div><input type="password" name="upw" placeholder="비밀번호"></div>
<div><input type="submit" value="Login"></div>
</form>
</div> 
<div><a href="join">회원가입</a></div>
<!-- /을 줬을 때와 안 줬을 때의 차이 알기 -->
</div>
</body>
</html>