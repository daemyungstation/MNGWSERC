<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COBGetLogin.jsp
	프로그램 명 : 	로그인
	설명		: 	로그인 화면
	작성자		: 	허진영
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				허진영				최초작성
	######################################################################
-->
<!doctype html>
<html lang="ko">
  	<head>
    	<meta charset="utf-8" />
   	 	<title>${pageTitle}|대명아임레디</title>
    	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0,target-densitydpi=medium-dpi" />
		<meta name="author" content="http://www..co.kr" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name="format-detection" content="telephone=no"/>
		<meta property="og:type" content="article" />
		<meta property="og:site_name" content="대명아임레디" />
		<meta property="og:url" content="<fmt:message key='Globals.httpUrl' />" />
		<meta property="og:title" content="대명아임레디 2016" />
		<meta property="og:description" content="대명아임레디" />
		<meta property="og:image" content="" />
		<link rel="shortcut icon" href="" />
		
		<link rel="stylesheet" href="/common/css/lifeway_style.css" />
    	<script src="/common/js/fnc.js"></script>
    	<script src="/common/js/frm.js"></script>
    	<script src="/common/js/jquery.js"></script>
    	<script src="/common/js/jquery-ui.js"></script>
    	<script src="/common/js/jquery.ui.datepicker-ko.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function(){
				var message = document.loginForm.message.value;
		    	
				if (message != "") 
				{
		        	alert(message);
		    	}
			});
		</script>
  	</head>
  	<body>
		<div id="wrapper">
			<form name="loginForm" method="post" action ="/mngwsercgateway/setLogin.do" onsubmit="return validate(this);">
				<input type="hidden" id="message" name="message" value="" />
				<input type="hidden" value="${sessionScope.retryCount}">
				<div class="adminMain">
					<div class="inputDiv">
						<div class="left"><a href="/"><img src="/common/images/admin/admin_logo.gif" alt="대명아임레디 관리자" /></a></div>
	
						<div class="right">
							<input type="text" value="" name="id" maxlength="20" placeholder="아이디 혹은 사원번호" required="아이디 또는 사원번호를 입력해 주세요." autocomplete="off" />
							<input type="password" value="" name="password" maxlength="20" placeholder="비밀번호" required="비밀번호를 입력해 주세요." autocomplete="off" />

							<c:if test="${sessionScope.retryCount > 4}">
							<div class="login_fail_security">
								<p class="txt_security">비밀번호와 자동입력 방지문자를 입력해주세요.<br /><strong>비밀번호를 5회 이상 잘못 입력</strong>하면, 정보보호를 위해 자동입력방지 문자를 함께 입력하셔야 합니다.</p>
								<img id="captchaImg" class="img_security" name="captchaImg" src="/captcha" alt="보안문자 이미지" width="65px" height="37px" />
								<input type="text" name="captchaText" value="" title="보안문자" placeholder="보안문자" class="lginInput2" maxlength="5" />
							</div>
							</c:if>

							<button><img src="/common/images/admin/admin_login.gif" alt="로그인" /></button>
						</div>
					</div>
	
					<div class="adminTxt" style="padding-top:8px;">
						<p class="txt1">
							<span>관리자 로그인 : 지정 아이디 / 비밀번호</span>
							<span class="bar">|</span>
							<span>임직원 로그인 : 사원 번호 / 비밀번호</span>
						</p>
						<p class="txt2" style="font-size:15px; font-weight:bold; padding-top:10px;">
							<span>비밀번호 초기화등 업무지원은 IT지원 <strong>유길상M</strong>에게 문의바랍니다.</span>
						</p>
						<p class="txt2" style="color:#e80000; font-size:13px; font-weight:bold; padding-top:10px;">
						<b>[보안 관련 강화 안내]</b> <br /><br />
							 1. 관리자 페이지 로그인 시 본인인증이 필요하여 SMS 인증을 진행해주시기 바랍니다.<br />
							 2. 관리자 페이지 주소는 다음과 같이 변경되어 다음의 주소로 접근 부탁 드리며, <br />
							 즐겨찾기 하신 경우 다시 저장 부탁 드립니다.<br /><br />
							<b> 변경주소 : <a href="https://sales.daemyungimready.com/mngwsercgateway/getLogin.do">https://sales.daemyungimready.com/mngwsercgateway/getLogin.do</a> </b>
							<br />
							<br />
							</p>
							<p class="txt2" style="color:black; font-size:13px;">
							[이외 기타 로그인 문의] <br /> 유길상M
						</p>
					</div>

					<div class="cert">
						<!--KISA Certificate Mark-->
						<a href='javascript:window.open("https://www.ucert.co.kr/trustlogo/sseal_cert.html?sealnum=04e7de242465a332e56d1f3478666d46aef869581e44e976edf712e9fd8625fb&sealid=9829d0e94b87895acf4b1b43ef057f7a52c141666402efa0bb8f3efd8d30efbee58206c03f1855eb52ee806864945609","mark","scrollbars=no,resizable=no,width=565,height=780");'>
							<img src="https://www.daemyungimready.com/common/images/icon/kisia.png" align="absmiddle" style="cursor:hand; width: 71.74px; height:40px; padding-top: 5px; border: none;"></a>
						<!--KISA Certificate Mark-->
						<a class href="javascript:window.open('https://www.daemyungimready.com/ism-popup/ismsp.do','window','width=810, height=1050, left=0, top=0, scrollbars=0, resizable=no')">
							<img src="https://www.daemyungimready.com/common/images/main/isms_p.png" alt="ISMS-P 인증 달성"/>
						</a>
					</div>

				</div>
			</form>
			<button onclick="mail_test()">mail</button>
		</div> <!--// wrapper -->
		<script>
			function mail_test() {
				jQuery.ajax({
					url : "/mngwsercgateway/sadfjklasdfjewfe/simpletest.ajax",
					type : "post",
					data : {
						"simple_test" : "mail_test"
					},
					success : function(data){
						alert("success");
					}
				});
			}
		</script>
    	<script src="/egov/js/bootstrap-alert.js"></script>
	   	<script src="/egov/js/bootstrap-button.js"></script>
	   	<script src="/egov/js/bootstrap-carousel.js"></script>
	   	<script src="/egov/js/bootstrap-collapse.js"></script>
	   	<script src="/egov/js/bootstrap-dropdown.js"></script>
	   	<script src="/egov/js/bootstrap-modal.js"></script>
	   	<script src="/egov/js/bootstrap-popover.js"></script>
	   	<script src="/egov/js/bootstrap-scrollspy.js"></script>
	   	<script src="/egov/js/bootstrap-tab.js"></script>
	   	<script src="/egov/js/bootstrap-tooltip.js"></script>
	   	<script src="/egov/js/bootstrap-transition.js"></script>
	   	<script src="/egov/js/bootstrap-typeahead.js"></script>
  	</body>
</html>