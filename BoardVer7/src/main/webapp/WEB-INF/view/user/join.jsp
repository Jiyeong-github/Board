<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>join</h1>
<form id = "frm" action="join" method="post" onsubmit="return frmChk();">
<!-- on들어가면 submit할때 이벤트 발생 / return false 들어가면 작동 안 함 -->
<div><input type="text" name="uid" placeholder="아이디">
<input type="button" id="btnChkId" value="중복 ID 체크">
</div>
<div id="chkuid"></div>
<div><input type="password" name="upw" placeholder="비밀번호"></div>
<div><input type="password" name="chkupw" placeholder="비밀번호 확인"></div>
<div>성별:<label>여성<input type="radio" name="gender" value="0"></label>
<label>남성<input type="radio" name="gender" value="1"></label></div>
<div><input type="text" name="unm" placeholder="이름"></div>
<div><input type="submit" value="회원가입">
<input type="reset" value="초기화"></div>
</form>

<script src ="/res/js/userJoin.js"></script>