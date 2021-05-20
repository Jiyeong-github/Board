<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
.hidden {display: none;}
.fa-heart{color:red;}
</style>
<script defer src="/res/JS/detail.js?ver=6"></script>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div>${param.iboard }</div>
	<div>
		<a href="list">리스트로 돌아가기</a>
	</div>
	<div>제목:${requestScope.data.title }</div>
	<c:if test="${data.isFav eq 0}">
	<a href="fav?iboard=${param.iboard }&fav=1"><i class="far fa-heart"></i></a>
	</c:if>
	<c:if test="${data.isFav == 1}">
	<a href="fav?iboard=${param.iboard }&fav=0"><i class="fas fa-heart"></i></a>
	</c:if>
	<div>작성자:${data.unm }</div>
	<div>작성일:${data.regdt }</div>
	<div>내용:${data.ctnt }</div>

	<h3>댓글</h3>
	<div>${requestScope.data.iboard },${param.iboard}</div>
	<div>
		<form id="insFrm" action="regCmt" method="post">
			<input type="hidden" name="icmt" value="0"> <input
				type="hidden" name="iboard" value="${requestScope.data.iboard }">
			<div>
				<textarea name="regCmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 작성">
			</div>
		</form>

		<form id="updFrm" action="regCmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0"> <input
				type="hidden" name="iboard" value="${requestScope.data.iboard }">
			<div>
				<textarea name="regCmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 수정"> <input type="button"
					value="수정 취소" onclick="showInsFrm()">
			</div>
		</form>
	</div>

	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt }</td>
					<td>${item.unm }</td>
					<td>${item.regdt }</td>

					<td><c:if
							test="${item.iuser == sessionScope.loginUser.iuser }">
							<!-- <input type="button" value="수정">-->
							<button onclick="updCmt(${item.icmt},'${item.cmt.trim()}');">수정</button>
							<!-- ''안 붙이면 변수로 인식 -->
							<button
								onclick="delCmt(${requestScope.data.iboard},${item.icmt})">삭제</button>
							<!-- <a href="regCmt?icmt=${item.icmt }&iboard=${requestScope.data.iboard}"></a> -->
							<!-- userPK값을 절대로 jsp에서 받으면 안 됨, 이건 무조건 servlet -->
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 쿼리값을 가져올 때 param을 쓴다 -->
	<c:if test="${data.iuser eq loginUser.iuser}">
		<div>
			<a href="/board/del?iboard=${param.iboard }">삭제</a>
		</div>
		<div>
			<a href="/board/mod?iboard=${param.iboard }">수정</a>
		</div>
	</c:if>
</body>
</html>