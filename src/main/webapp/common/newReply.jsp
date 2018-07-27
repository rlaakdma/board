<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Jsp</title>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="/bootstrap/js/bootstrap.js"></script>
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
	
	//첨부파일 추가
	var rowIndex = 1;
	       
	function addFile(form){
	if(rowIndex > 4) return false;
	
	rowIndex++;
	var getTable = document.getElementById("insertTable");
	var Row = getTable.insertRow(getTable.rows.length);
	var Cell = Row.insertCell(0);
		Cell.innerHTML = "<tr><td colspan=2><input type='file' name='f_name' NAME='f_name" + rowIndex + "' size=25></td></tr>";
	}
	
	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "w_cnt", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, 
			}
		});
	
		// 전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["w_cnt"].exec("UPDATE_CONTENTS_FIELD", []);
	
				// 이부분에 에디터 validation 검증
				if(validation()) {
					$("#frm").submit();
				}
			}
		})
	});
	
	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['w_cnt'].exec('FOCUS');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<!-- top.jsp -->
	<%@ include file="/common/top.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="table-responsive">			
						<form action="/newWrite" method="post" id="frm">
							<label>제목 : </label><input type="text" name="w_title">　　　　　<label>작성자 : ${studentVo.std_id}</label><br><br>
							<input type="hidden" name="w_name" value="${studentVo.std_id}">
							<textarea name="w_cnt" id="w_cnt" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
							<div class="form-group">
								<label for="f_name" class="col-sm-2 control-label">첨부파일</label>
								<div id="w_cntLabel" class="col-sm-6">
								<table id="insertTable">
									<tr>
										<td><input type="file" name="f_name"></td>
										<td><input type="button" value="+" onClick="addFile(this.form)" class="btn btn-default"></td>
									</tr>
								</table>
								</div>
							<input type="hidden" id="id" name="id" value="${studentVo.id}">
							<input type="hidden" id="b_no" name="b_no" value="${b_no}">
							<input type="button" id="cancelbutton" value="돌아가기" />  <input type="button" id="savebutton" value="작성하기" />
							</div>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>