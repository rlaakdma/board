<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	
</script>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a href="/newBoard">게시판 생성</a></li>
		<c:forEach items="${boardYList}" var="vo">
			<li class="active"><a href="/boardList?b_no=${vo.b_no}&b_boardname=${vo.b_boardname}&page=1&pageSize=10">${vo.b_boardname}</a></li>
		</c:forEach>
	</ul>
</div>