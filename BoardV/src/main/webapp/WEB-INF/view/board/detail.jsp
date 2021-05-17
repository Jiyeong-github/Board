<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script defer src = "/res/JS/detail.js"></script>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div>${param.iboard }</div>
	<div>
		<a href="list">리스트로 돌아가기</a>
	</div>
	<div>제목:${data.title }</div>
	<div>작성자:${data.unm }</div>
	<div>작성일:${data.regdt }</div>
	<div>내용:${data.ctnt }</div>

	<h3>댓글</h3>
	<div>
		<form action="regCmt" method="post">
			<input type="hidden" name="iboard" value="${data.iboard }">
			<div>
				<textarea name="regCmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 작성">
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
							<input type="button" value="수정">
							<!-- <a href="mod"><button type="button">수정</button></a>-->
							<a
								href="regCmt?icmt=${item.icmt }&iboard=${requestScope.data.iboard}">
								<button
									onclick="delCmt(${requestScope.data.iboard},${item.icmt})">삭제</button>
							</a>
							<!-- userPK값을 절대로 jsp에서 받으면 안 됨, 이건 무조건 servlet -->
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 쿼리값을 가져올 때 param을 쓴다 -->
	<c:if test=" ${data.iuser  == loginUser.iuser}">
		<div>
			<a href="/board/del?iboard=${param.iboard }">삭제</a>
		</div>
		<div>
			<a href="/board/mod?iboard=${param.iboard }">수정</a>
		</div>
	</c:if>
</body>
</html>