<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COBGetLogin.jsp
	프로그램 명 : 	비밀번호를 변경한다.
	설명		: 	비밀번호를 변경하는 화면
	작성자		: 	허진영
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				허진영				최초작성
	######################################################################
-->
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8" />
    	<title>대명아임레디 관리자페이지</title>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    	<meta name="description" content="" />
    	<meta name="author" content="" />
    	<link href="/egov/css/bootstrap.css" rel="stylesheet" />
    	<link href="/egov/css/bootstrap-responsive.css" rel="stylesheet" />
   		<style type="text/css">
			body {
	        	padding-top: 40px;
	        	padding-bottom: 40px;
	        	background-color: #f5f5f5;
	      	}
	      	.form-signin {
	        	max-width: 625px;
	        	padding: 19px 29px 29px;
	        	margin: 0 auto;
	        	background-color: #fff;
	        	border: 1px solid #e5e5e5;
	        	-webkit-border-radius: 5px;
	           	-moz-border-radius: 5px;
	            border-radius: 5px;
	        	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
	           	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
	            box-shadow: 0 1px 2px rgba(0,0,0,.05);
	      	}
	      	.form-signin .form-signin-heading,
			.form-signin input[type="text"],
		</style>
		<script src="/common/js/jquery.js"></script>
		<script src="/common/js/frm.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("input[name='password']").focus();
			});
		
			function chkFrm()
			{
				var f = document.loginForm;
				
				if(!validate(f))
				{
					return;
				}
				
				if(jQuery("input[name='newpassword']").val() != jQuery("input[name='newpasswordconfirm']").val())
				{
					alert("변경 비밀번호와 변경 비밀번호 확인값이 다릅니다.");
					jQuery("input[name='newpasswordconfirm']").focus();
					return;
				}
				
				if(confirm("비밀번호를 변경하시겠습니까?"))
				{
					f.submit();
				}
			}

			function changeLater()
			{
				if(jQuery("input[name='password']").val() == null || jQuery("input[name='password']").val() == "")
				{
					alert("나중에 변경하기 위해선 기존 비밀번호를 입력해야 됩니다.");
					jQuery("input[name='password']").focus();
					return;
				}

				if(confirm("나중에 변경하시겠습니까?"))
				{
					password = jQuery("input[name='password']").val();
					$.ajax({
						type : 'POST',
						url : '/mngwsercgateway/pwdChngLater.ajax',
						data : {
							password : password,
						},
						success : function(e){
							//console.dir(e);
							if (e.msg != "") {
								alert(e.msg);
							}
							/*
							if (e.url != "") {
								location.href = e.url;
							}
							*/
						}
					});
				}
			}

		</script>
  	</head>
	<body>
    	<div class="container">
      		<form name="loginForm" class="form-signin" action ="<fmt:message key='Globals.httpsAdminUrl' />/mngwsercgateway/setPwdChng.do" method="post" onsubmit="return validate(this);">
				<table class="table table-bordered" >
					<colgroup>
						<col width="40%" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th style="text-align:left; vertical-align:middle;">
								• 기존 비밀번호
							</th>
							<td>
								<input type="password" class="input-block-level" name="password" maxlength="20" placeholder="기존 비밀번호" required="기존 비밀번호를 입력해주세요." autocomplete="off" />
							</td>
						</tr>
						<tr>
							<th style="text-align:left; vertical-align:middle;">
								• 신규 비밀번호
							</th>
							<td>
								<input type="password" class="input-block-level" name="newpassword" maxlength="20" placeholder="신규 비밀번호" required="신규 비밀번호를 입력해주세요." autocomplete="off" passChk />
							</td>
						</tr>
						<tr>
							<th style="text-align:left; vertical-align:middle;">
								• 신규 비밀번호 확인
							</th>
							<td>
								<input type="password" class="input-block-level" name="newpasswordconfirm" maxlength="20" placeholder="신규 비밀번호 확인" required="신규 비밀번호를 확인해주세요." autocomplete="off" passChk />
							</td>
						</tr>
					</tbody>
			    </table>
			    
			    <table class="table table-bordered" >
					<colgroup>
						<col width="100%" />
					</colgroup>
					<tbody>
						<tr>
							<th style="text-align:left;">
								• 개인정보 및 관리자 페이지의 각종 정보를 위해 90일마다 반드시 비밀번호를 변경해야 합니다.<br />
								• 특수문자, 숫자, 영문 3가지 조합으로 8자리이상 ~ 20자리 이하로 입력이 가능합니다.
							</th>
						</tr>
					</tbody>
			    </table>
		        <div style="text-align:center;">
		        	<a href="javascript:chkFrm();" class="btn btn-info" style="display:inline;">지금 변경</a>
		        	<a href="javascript:changeLater();" class="btn btn-info" style="display:inline;">나중에 변경</a>
		        	<a href="/mngwserc/coc/adm/setLogout.do" class="btn btn-info" style="display:inline;">로그아웃</a>
		        </div>
			</form>
		</div>
	</body>
</html>