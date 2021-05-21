<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div>글 목록</div>

	<div>
	<div>
	<form action="list" method="get">
	<div>
	<input type="search" name="search">
	<input type="submit" value="검색">
	</div>
	</form>
	</div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>
			
			<c:forEach items="${requestScope.list }" var="item">
				<tr class="record" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard }</td>
					<td>${item.title }</td>
					<td>${item.unm }</td>
					<td>${item.ctnt }</td>
					<td>${item.regdt }</td>
				</tr>
			</c:forEach>
		</table>
		<div>
		<c:forEach begin="1" end="${requestScope.totalPage }" var="cnt">
		<a href="list?page=${cnt}&search=${param.search}"><span>${cnt }</span></a>
		</c:forEach>
		</div>
	</div>
