<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
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
					<h2 class="blog-title">메인화면 ${param.redirectFrom}</h2>
					<p class="lead blog-description">Jsp 과제 torr..</p>
				</div>
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<h2 class="blog-post-title">JSP</h2>
							<p class="blog-post-meta">2018.07.02, room 207</p>

							<p>jsp를 통한 웹 프로그래밍 학습</p>
							<hr>

							<h3>상세내역</h3>
							<p>게시판을 만들어보자.</p>
							<ul>
								<li>게시판 생성</li>
								<li>게시판 수정</li>
								<li>게시판 페이징 기법</li>
								<li>게시글 추가</li>
								<li>게시글 삭제(실제 삭제불가)</li>
								<li>게시글 답글 및 댓글</li>
								<li>게시글 파일첨부 및 내용 안에 사진 첨부</li>
							</ul>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>