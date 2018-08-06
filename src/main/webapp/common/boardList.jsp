<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		$("table tbody tr").on("click", function(){
			//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
			//form 태그를 submit
			if($(this).data("id2") == 'n'){
				$("#id").val($(this).data("id"));
				$("#frm").submit();
			}			
		});
		
		$("#newWritebtn").on("click", function(){
			$("#frm2").submit();
		});		
	});
</script>
</head>
<body>
	<!-- top.jsp -->
	<%@ include file="/common/top.jsp" %>
	<form id="frm" action="/writeDetail" method="get">
		<input type="hidden" name="id" id="id">
	</form>
	<div class="container-fluid">
		<div class="row">
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="table-responsive">
							<h2 class="sub-header">${b_boardname }</h2>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>게시글 번호</th>
										<th>제목</th>
										<th>작성자 아이디</th>
										<th>작성일시</th>
									</tr>
								</thead>
								<tbody>
								<%request.setAttribute("nbsp", " "); %>
									<c:forEach items="${writeList}" var="vo">
										<c:choose>
											<c:when test="${vo.w_dlt=='n'}">
												<tr data-id="${vo.w_no}" data-id2="${vo.w_dlt}">
													<td>${vo.w_no}</td>
													<td>${fn:replace(vo.w_title, nbsp, '&nbsp&nbsp;')}</td>
													<td>${vo.w_name}</td>
													<td><fmt:formatDate value="${vo.w_date}" pattern="yyyy/MM/dd" /></td>
												</tr>
											</c:when>
											<c:when test="${vo.w_dlt=='y'}">
												<tr>
													<td>${vo.w_no}</td>
													<td>${fn:replace('[삭제된 글입니다]', nbsp, '&nbsp&nbsp&nbsp;')}</td>
													<td></td>										
													<td></td>
												</tr>
											</c:when>
										</c:choose>
									</c:forEach> 
								</tbody>
							</table>							
						</div>
						<form id="frm2" action="/newWrite" method="get">
							<button type="submit" id="newWritebtn" class="btn btn-default pull-right">새글 등록</button>
							<input type="hidden" name="b_no" id="b_no" value="${b_no }">
						</form>												
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>