<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<style>
	tbody tr:hover {
		background-color: red;
		cursor: pointer;
	}
</style>
<script>
	function fnDetail(n) {
		location.href = '${contextPath}/board/detail.do?board_no=' + n;
	}
</script>
</head>
<body>
	
	<div>
		<a href="${contextPath}/board/write.do">새글작성하기</a>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty boardList}">
					<tr>
						<td colspan="3">첫 게시글 작성</td>
					</tr>
				</c:if>
				<c:if test="${not empty boardList}">
					<c:forEach var="b" items="${boardList}">
						<tr onclick="fnDetail(${b.board_no})">
							<td>${b.title}</td>
							<td>${b.writer}</td>
							<td>${b.created_at}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	
</body>
</html>