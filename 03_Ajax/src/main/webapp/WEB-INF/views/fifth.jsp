<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<style>
	.papago {
		display: flex;
		justify-content: space-between;
		width: 1380px;
		margin: 0 auto;
	}
	.source_area, .target_area {
		width: 640px;
	}
	.btn_area {
		width: 50px;
		line-height: 320px;
		text-align: center;
	}
	#text, #translatedText {
		width: 100%;
		height: 300px;
		border: 1px solid gray;
		outline: 0;
		font-size: 24px;
	}
	#text:focus, #translatedText:focus {
		border: 1px solid skyblue;
	}
	img {
	width: 300px;
	}
</style>
</head>
<body>
	
	<div class="papago">
		<div class="source_area">
			<div>
				<select id="source">
					<option value="ko">한국어</option>
					<option value="en">영어</option>
					<option value="ja">일본어</option>
				</select>
			</div>
			<div>
				<textarea id="text"></textarea>
			</div>
		</div>
		<div class="btn_area">
			<input type="button" id="btn_translate" value="번역">
		</div>
		<div class="target_area">
			<div>
				<select id="target">
					<option value="ko">한국어</option>
					<option value="en">영어</option>
					<option value="ja">일본어</option>
				</select>
			</div>
			<div>
				<textarea id="translatedText"></textarea>
			</div>
		</div>
	</div>
	
	<hr>
	
	<h1>주말에 풀어보기</h1>
	
		<div>검색결과검수 <select id="display" name="display">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			<option value="50">50</option>
			<option value="60">60</option>
			<option value="70">70</option>
			<option value="80">80</option>
			<option value="90">90</option>
			<option value="100">100</option>
		</select></div>
		<div>
			<input type="radio" name="sort" value="sim" checked="checked"> 유사도순
			<input type="radio" name="sort" value="date"> 날짜순
			<input type="radio" name="sort" value="asc"> 낮은가격순
			<input type="radio" name="sort" value="dsc"> 높은가격순
		</div>
		<div>
			검색어 입력 <input type="text" id="query" name="query"> 
			<input type="button" value="검색" id="btn1">
		</div>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>상품명</td>
				<td>썸네일</td>
				<td>가격</td>
				<td>판매처</td>
			</tr>
		</thead>
		<tbody id="tbody">
				
		</tbody>
	</table>
	
	
	
	
	<script>
		$('#btn_translate').on('click', function(){
			if($('#text').val() == ''){
				alert('번역할 텍스트를 입력하세요');
				$('#text').focus();
				return;
			}
			$.ajax({
				// 요청
				type: 'get',
				url: '${contextPath}/papago.do',
				data: 'source=' + $('#source').val() + '&target=' + $('#target').val() + '&text=' + $('#text').val(),
				// 응답
				dataType: 'json',
				success: function(resData){
					$('#translatedText').text(resData.message.result.translatedText);
				},
				error: function(jqXHR){
					if(jqXHR.status == 503){  // HttpStatus.SERVICE_UNAVAILABLE는 503이다.
						alert('파파고 서비스 사용이 불가합니다. 입력 정보를 확인하세요.');
					}
				}
			})
		})
		$('#btn1').on('click', function(){
			if($('#query').val() == ''){
				alert('검색어를 입력하세요.');
				$('#query').focus();
				return;
			}
			$.ajax({
				type: 'get',
				url: '${contextPath}/search.do',
				data: 'query=' + $('#query').val() + '&display=' + $('#display').val() + '&sort=' + $('input[name=sort]:checked').val(),
				dataType: 'json',
				success: function(resData) {
					let str = '';
					for(i = 0; i < resData.display; i++){
						if(resData.items.lprice != '') {
						str += ('<tr><td><a href="' + resData.items[i].link + '">' + resData.items[i].title + '</a></td><td><img src="' + resData.items[i].image + '"></td><td>' + resData.items[i].lprice + '원</td><td>' + resData.items[i].mallName + '</td></tr>');
						} else {
							str += ('<tr><td><a href="' + resData.items[i].link + '">' + resData.items[i].title + '</a></td><td><img src="' + resData.items[i].image + '"></td><td>' + resData.items[i].hprice + '원</td><td>' + resData.items[i].mallName + '</td></tr>');
						}
					}
					$('#tbody').html(str);
				},
				error: function(jqXHR) {
					if(jqXHR.status == 503){
						alert('검색 서비스 사용 불가.');
					}
				}
			})
			
		})
		
	</script>

</body>
</html>