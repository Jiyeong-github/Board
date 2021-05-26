<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>${param.iboard }</div>
<div>
	<a href="#">돌아가기</a>
	<!-- javascript:history.back();이나 .go(-1)해도 뒤로가기 -->
</div>
<div>제목:${requestScope.data.title }</div>
<div>작성자:${data.unm }</div>
<div>작성일:${data.regdt }</div>
<div>내용:${data.ctnt }</div>
<div>
	<c:out value="${requestScope.data.ctnt}" />
</div>


<div>
	<form id="cmtFrm" data-login_user_pk = "${sessionScope.loginUser.iuser}" data-iboaerd="${param.iboard}" onsubmit="return false;">
		<input type="text" id="cmt"> 
		<input type="button" value="덧글달기" onclick="regCmt();">
	</form>
</div>
<div id="cmtList"></div>

<table>
<tr>
<th>내용</th>
<th>작성자</th>
<th>내용</th>
<th>내용</th>
</tr>
</table>
<script src="/res/js/detail.js"></script>