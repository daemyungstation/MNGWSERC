<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/method.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><c:out value="${pageTitle}"/>|대명아임레디</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="/egov/css/bootstrap.css" rel="stylesheet">
<link href="/egov/css/table.css" rel="stylesheet">
<style type="text/css">
	@media (max-width: 980px) {
	  /* Enable use of floated navbar text */
	  .navbar-text.pull-right {
	    float: none;
	    padding-left: 5px;
	    padding-right: 5px;
	  }
	}
</style>
<link href="/egov/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/egov/css/paging.css" rel="stylesheet">
<link href="/egov/css/table.css" rel="stylesheet">
<link href="/common/css/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet">
<script src="/common/js/jquery.js"></script>
<script src="/common/js/jquery-ui.js"></script>
<script src="/common/js/jquery.ui.datepicker-ko.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<form name="frm" id="frm" method="post" enctype="multipart/form-data" style="margin-top:20px">
				<input type="hidden" name="link" value="${pageLink}" />
				<table class="table table-bordered" summary="상담등록">
					<caption style="display: none;">상담등록</caption>
					<colgroup>
						<col width="100%" />
					</colgroup>
					<tbody>
						<tr>
							<th style="vertical-align:middle;">
								<font style="float:left; margin-left:12px">상담등록</font>
								<a href="/cmm/download.do?subpath=/CNCProdUploadSample.xls" class="btn" style="float:right; margin-right:10px">양식 다운로드</a>
							</th>
						</tr>
						<tr>
							<td>
								<font style="margin-left:7px">* Microsoft Excel 97-2003 엑셀파일(.xls)만 업로드 가능합니다.</font><br />
								<font style="margin-left:7px">* 첫번째 시트에 데이터가 있어야 합니다.</font><br />
								<font style="margin-left:7px;">* 엑셀작성 시 중간에 빈줄이 없어야 합니다.</font><br />
								<font style="margin-left:7px;">* 빈셀에도 서식이 있다면 데이터로 인식되니 삭제 후 업로드 합니다.</font>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:middle; text-align:left;">
								<p style="margin-left:7px; margin-bottom:0px">
									<font style="margin-right:10px">* 파일명</font>
									<input type="file" name="atchfile" ext />
								</p>
							</td>
						</tr>
						<tr>
							<td style="text-align: center;" id="sendExcel">
								<a href="javascript:frmSubmit();" class="btn btn-success">등록</a>
							</td>
							
						</tr>
					</tbody>
				</table>
			</form>	
		</div><!--/row-->
	    <footer>
	    	<p>&copy; COPYRIGHT 2016 ALL RIGHTS RESERVED.</p>
	    </footer>
    </div><!--/.fluid-container-->
    <script type="text/javascript">
		jQuery(document).ready(function(){
			//첨부파일 input filestyle
			jQuery("input[name=atchfile]").filestyle({
				  image : "/common/images/file_bt.gif",
				  imageheight : 30,
		 		  imagewidth : 84
			});
		});
		
		//파일업로드 확장자 검사
		jQuery("input[name=atchfile]").on("change", function(){
			
			var fileName = jQuery(this).val();
			
			if(fileName)
			{
				var exts = "xls";
				
				var fileExt = fileName.substr(fileName.lastIndexOf(".") + 1);

				if(exts.indexOf(fileExt.toLowerCase()) < 0)
				{
					alert("지원하지 않는 파일확장자입니다.");
					
					jQuery(this).val("");
				}
			}
		});
		
		//엑셀 등록
		function frmSubmit() {
			var f = document.frm;
					
			if (!validate(f)) {
				return;
			}
			
			if (jQuery("input[name=atchfile]").val() == "") {
				alert("* 엑셀파일을 등록해주십시오.");
				return;
			}
			
			if (confirm("등록하시겠습니까?")) {
				var data = new FormData($("#frm"));
				data.append('atchFile', $('input[type=file]')[0].files[0]);
	             
	            jQuery.ajax({
	                url : "./upload/excel.do",
	                type : "post",
	                data : data,
	                async : false,
	                cache : false,
	                contentType : false,
	                processData : false,
	                success : function(data) {
	                	if (data.success) {
	                	    console.log('result info :: ', data.result.success, data.result.fail);
	                		alert("등록되었습니다. (성공: " + data.result.success.length + ', 실패: ' +  data.result.fail.length + ')');
	                		opener.location.reload();
	                		self.close();
	                	} else {
	                		alert("예기치 않은 오류입니다.");
	                	}
	                },
	                error : function() {
	                	alert("잠시후 다시 시도 바랍니다.");
	                }
	            });	
			}
		};
	</script>

	<script src="/common/js/frm.js"></script>
	<script src="/common/js/jquery.filestyle.js"></script>
</body>
</html>