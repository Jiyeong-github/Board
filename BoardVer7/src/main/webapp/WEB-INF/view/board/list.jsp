<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

    <h1>글 목록</h1>
    
    <table>
    <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
    </tr>
    </table>
    <c:forEach items="${requestScope.list}" var="item">
    <tr>
    <td>${item.iboard }</td>
    <td>${item.title }</td>
    <td>${item.writerNm }</td>
    <td>${item.regdt}</td>
    </tr>
    </c:forEach>