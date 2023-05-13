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
		location.href = '${contextPath}/board/detail.do?boardNo=' + n;
	}
	$(function(){
		/* ${addResult}를 ''로 감싸지 않는다면 값이 없을때,
		   let addResult = ;로 저장되어서 빨간줄이 나온다.
		   해결방안으로 ''로 감싸 없다면 빈문자열로 만들어준다.
		   let addResult = '1';		삽입 성공
		   let addResult = '0';		삽입 실패
		   let addResult = '';		삽입과 상관 없음
		*/
		let addResult = '${addResult}';
		if(addResult != ''){
			if(addResult == '1'){
				alert('게시글이 등록되었습니다.');
			} else{
				alert('게시글 등록 실패');
			}
		}
		let removeResult = '${removeResult}';
		if(removeResult != ''){
			if(removeResult == '1'){
				alert('게시글이 삭제되었습니다.');
			} else{
				alert('게시글 삭제 실패');
			}
		}
	})
	
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
						<tr onclick="fnDetail(${b.boardNo})">
							<td>${b.title}</td>
							<td>${b.writer}</td>
							<td>${b.createdAt}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	
</body>
</html>