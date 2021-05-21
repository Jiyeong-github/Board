<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div><a href="login">로그인으로 돌아가기</a></div>
<div>
<form id="frm">
<div><input type="text" name="uid" placeholder="아이디"></div>
<div><input type="password" name="upw" placeholder="비밀번호"></div>
<div><input type="text" name="unm" placeholder="이름"></div>
<div>
성별:
<label>여성<input type="radio" name="gender" value="0" checked></label>
<label>남성<input type="radio" name="gender" value="1"></label>
</div>
<div><input type="button" value="회원가입" onclick="join();"></div>
</form>
</div>

	<script>
function join(){
	var frmElem = document.querySelector('#frm');
	var uid = frmElem.uid.value; //uid 변수에는 위에 input name 어쩌고가 담김
	var upw = frmElem.upw.value;
	var unm = frmElem.unm.value;
	var gender = frmElem.gender.value;
	
	console.log('uid:'+uid);
	console.log('upw:'+upw);
	console.log('unm:'+unm);
	console.log('gender:'+gender);
	
	var param = {
			uid: uid,
			upw: upw,
			unm: unm,
			gender: gender
	}
	
	// param이나 param2 방법 둘다 가능 var param 2 = { uid, upw, unm, gender };
	ajax(param);
}
</script>

	<script>

function ajax(param){
	const init = {
			method = 'POST',
		/*	headers : {
				'Content-Type':'application/json',
			}, */
			//body:JSON.stringify(param);
			body: new URLSearchParams(param)
			}
		fetch('/user/join',init)
		.then(function(res){return res.json();})
	.then(function(myJson){
		//console.log(myJson)
		//console.log(myJson.result) 시 1이 찍힘
		
		switch(myJson.result){
		case 0:
			alert('회원가입 실패');
			break;
		case 1:
			location.href = '/user/login';
			break;
		}
		
	});
	}
}
</script>
