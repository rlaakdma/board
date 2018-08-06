<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<style> pre {width:530px} </style>
<script>
$(function(){
	// write update button
	$("#updateBtn").on("click", function(){
		$("#updatefrm").submit();
	});
	
	// write delete button
	$("#deletebtn").on("click", function(){	
		$("#deletefrm").submit();
	});
	
	// write reply button
	$("#replybtn").on("click", function(){
		$("#replyfrm").submit();
	});
	
	// Comments insert button
	$("#insertCntBtn").on("click", function(){
		if($("#c_cnt").val().length==""||$("#c_cnt").val().length<3){
			alert("3자 이상 입력하세요.");
			$("#c_cnt").focus();
			return false;
		}
		$("#insertC1").submit();	
	});
	
	// Comments delete button
	$("#deleteCntBtn").on("click", function(){
		$("#deleteC1").submit();	
	});
});	
</script>
</head>
<body>
	<!-- top -->
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">		
			<!-- left -->
			<%@ include file="/common/left.jsp"%>			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
				<div class="form-group">
					<label for="w_name" class="col-sm-2 control-label">작성자 : </label>
					<div id="w_nameLabel" class="col-sm-10">
					<label class="control-label">${writeVo.w_name}</label>
					<input id="w_name" type="hidden" name="w_name" value="${writeVo.w_name }">
					</div>
				</div>	
							
				<div class="form-group">
					<label for="w_name" class="col-sm-2 control-label">작성일 : </label>
					<div id="w_nameLabel" class="col-sm-10">
					<label class="control-label"><fmt:formatDate value="${writeVo.w_date}" pattern="yyyy-MM-dd HH:MM" /></label>
					<input type="hidden" name="w_no" value="${writeVo.w_no}">	
					</div>
				</div>	
							
				<div class="form-group">
					<label for="w_title" class="col-sm-2 control-label">제목 : </label>
					<div id="w_titleLabel" class="col-sm-10">
					<label class="control-label">${writeVo.w_title}</label>
					<input type="hidden" name="w_title" value="${writeVo.w_title}">	
					</div>
				</div>	
																	
				<div class="form-group">
					<label for="w_cnt" class="col-sm-2 control-label">내용 : </label>
					<div id="w_cntLabel" class="col-sm-6">
					<label for="w_cnt" class="form-control" style="width:600px;height:300px;text-align:left;">${writeVo.w_cnt}</label>
					<input type="hidden" name="w_cnt" value="${writeVo.w_cnt}">	
					</div>
				</div>
				
				<!-- files -->
				
				<!-- write update, delete -->				
				<form id="updatefrm" action="/updateWrite" method="get">
					　        
					<label for="w_cnt" class="col-sm-2 control-label"></label>
					<div id="buttondiv1" class="col-sm-6">
					${studentVo.std_id==writeVo.w_name?
					'<button type="submit" id="updatebtn" class="btn btn-default">수정</button>':""}
					<input type="hidden" name="w_no" value="${writeVo.w_no}">
					
					</div>
				</form>
					
				<form id="deletefrm" action="/deleteWrite" method="get">
					<label for="w_cnt" class="col-sm-2 control-label"></label>
					<div id="buttondiv2" class="col-sm-6">							　					
					${studentVo.std_id==writeVo.w_name?
					'<button type="submit" id="deletebtn" class="btn btn-default">삭제</button>':""}
					<input type="hidden" name="w_no" value="${writeVo.w_no}">
					<input type="hidden" name="w_dlt" value="y">
					<input type="hidden" name="b_no" value="${writeVo.b_no}">
					</div>
				</form>	
						
				<!-- reply -->							
				<form id="replyfrm" action="/replyWrite" method="get">			
				<div class="form-group">
				<div id="buttondiv2" class="col-sm-6">	
					${studentVo.std_id==writeVo.w_name?"":
					'<button type="submit" id="replybtn" class="btn btn-default">답글</button>'}
					<input type="hidden" name="w_no" value="${writeVo.w_no}">
					<input type="hidden" name="b_no" value="${writeVo.b_no}">
					<input type="hidden" name="w_gno" value="${writeVo.w_gno}">
				</div>
				</div>
				</form>	
				
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">첨부 파일</label>
					<div class="col-sm-10">
						<c:if test="${addFileList != null }">
							<c:forEach items="${addFileList }" var="vo">
								<a href="/fileDownload?f_no=${vo.f_no}&filename=${vo.f_name}">${vo.f_name}</a>
								<br>
							</c:forEach>
						</c:if>
					</div>
				</div>
				
				<!-- Comments insert, delete -->		
				<form id="deleteC1" action="/deleteCnt" method="get">
					<div class="form-group">
						<c:forEach items="${commentsList}" var="vo">
						<label for="c_cnt" class="col-sm-2 control-label">댓글 : </label>
							  <c:choose>
								  <c:when test="${vo.c_dlt=='y'}">
								  	[  삭제된 댓글입니다.  ]
								  </c:when>
							  </c:choose>
							  <c:choose>
								  <c:when test="${vo.c_dlt=='n'}">
								  	${vo.c_cnt}   [  작성자 : ${vo.c_name}  /  <fmt:formatDate value="${vo.c_date}" pattern="yyyy/MM/dd HH:MM:ss" />  ]
								  </c:when>
							  </c:choose>				  	
							<c:if test="${studentVo.std_id==vo.c_name}">
								<button type="submit" id="deleteCntBtn" name="c_no" value="${vo.c_no}" class="btn btn-default">삭제</button>
							</c:if><br><hr>
						</c:forEach><br>
						<input type="hidden" name="w_no" value="${writeVo.w_no}">
					</div>
				</form>
					
				<form id="insertC1" action="/insertCnt" method="get">
					<div class="form-group">
						<div id="w_cntLabel" class="col-sm-6">
						<input type="text" id="c_cnt" name="c_cnt" class="form-control">
						</div>
						<input type="hidden" name="w_no" value="${writeVo.w_no}">
						<input type="hidden" name="id" value="${studentVo.id}">
						<input type="hidden" name="c_name" value="${studentVo.std_id}">
						<button type="submit" id="insertCntBtn" class="btn btn-default">추가</button>
					</div>											
				</form>
				
			</div>
		</div>
	</div>
</body>