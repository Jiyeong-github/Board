<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/mypage.css">

	<c:choose>
		<c:when test="${empty sessionScope.loginUser.profileImg }">
			<c:set var="img" value="/res/img/noprofile.jpg" />
		</c:when>
		<c:otherwise>
			<c:set var="img" value="/res/img/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg}" />
		</c:otherwise>
	</c:choose>

<div>
	<form action="mypage" method="post" enctype="multipart/form-data" id="frm" onsubmit="return imgChk();">
	<!-- 멀티파트 어쩌고 줘야지 파일 올라가는 거구나 할 수 이따 -->
		이미지 변경 : <input type="file" name="profileImg" accept="image/*"> 
		<!-- image/*을 선택해주면 img용 파일들만 보여짐 -->
		<input type="submit" value="이미지 업로드">
	</form>
</div>
<div>
<div><img src="${img}"></div>

<div>${img}</div>
<div>PK:${sessionScope.loginUser.iuser }</div>
<div>ID:${sessionScope.loginUser.uid }</div>
<div>Name:${sessionScope.loginUser.unm }</div>
</div>
<!-- D:\JspClass_AWY\Wepworkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\BoardVer7\res\img -->

<script>
var frmElem = document.querySelector('#frm');
function imgChk(){
	if(frmElem.profileImg.files.length == 0){
	alert('이미지를 선택해 주세요.');
	return false;
	}
	
}
</script>