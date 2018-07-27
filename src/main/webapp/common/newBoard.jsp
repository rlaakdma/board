<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Jsp</title>
<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<script>
$(function(){
	// 생성 버튼 클릭 이벤트
	$("#insertBtn").on("click", function(){		
		// 게시판 이름 입력
		if($("#b_boardname1").val().length > 16 || $("#b_boardname1").val().length==""){
			alert("15자 이하로 입력하세요.");
			$("#b_boardname1").focus();
			return false;
		}			
		// 여기까지 진행되면 validation 통과 --> submit
 		console.log($("#insert").serialize());
		$("#insert").submit();
	});
	
	// 생성 버튼 클릭 이벤트
// 	$("#updateBtn").on("click", function(){	
// //  		console.log($("#update").serialize());
// 		// 게시판 이름 입력			
// 		$("#update").submit();
// 	});	
});
</script>
</head>
<body>
	<!-- top.jsp -->
	<%@ include file="/common/top.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
		
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-header">
					<h2>게시판 생성 게시판입니다.</h2>
					<p class="lead blog-description">기존 게시판은 활성화 및 비활성화가 가능하며, 신규생성이 가능함</p>
				</div>

				<form id="insert" action="/createBoard" method="post">
					<h4>
					게시판 생성 : <input id="b_boardname1" name="b_boardname1" type="text" placeholder="생성할 게시판명을 입력하세요.">
					<select name="b_use1">
						<option value="y" selected="selected">사용</option>
						<option value="n" >미사용</option>
					</select>
					<input type="hidden" name="id1" value="${studentVo.id }">
					<input type="hidden" name="b_name" value="${studentVo.name }">
					<button id="insertBtn" type="button">생성</button>
					</h4>
				</form>
					
				<c:forEach items="${boardAllList}" var="vo">
				<form id="update" action="/updateBoard" method="post">
					<h4>
					게시판 이름 : <input id="b_boardname2" name="b_boardname2" value="${vo.b_boardname }" type="text">
					<select name="b_use2">
						<option ${vo.b_use == 'y' ? "selected" : ''} value="y">사용</option>
						<option ${vo.b_use == 'n' ? "selected" : ''} value="n">미사용</option>
					</select>
					<input type="hidden" name="b_no" value="${vo.b_no}">
					<button id="updateBtn" type="submit">수정</button>
					</h4>
				</form>
				</c:forEach>
			</div>			
		</div>
	</div>
</body>
</html>