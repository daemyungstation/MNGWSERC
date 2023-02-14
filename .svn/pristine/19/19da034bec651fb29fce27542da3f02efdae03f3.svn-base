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
	2018.01.03				강재석				수정
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
			function init()
			{
				<c:choose>
					<c:when test = "${flag == '1'}">
						if(confirm("${msg}")){
							fnHPAuth();
						}
					</c:when>
					<c:when test = "${flag == '2'}">
						fnHPAuth();
					</c:when>
					<c:when test = "${flag == '3'}">
						alert("${msg}");
					</c:when>
					<c:when test = "${flag == '4'}">
					alert("${msg}");
					location.href = "${url}";
				</c:when>
					<c:otherwise>
						//fnGoMessage();
					</c:otherwise>
				</c:choose>
			}
		
			/*
			function checkLogin(){
				var frm = document.loginForm;
				
				frm.action = "/mngwsercgateway/checkLogin.do";
				frm.submit();
			}
			*/
			
			function fnHPAuth(){
				window.open('/mngwsercgateway/phoneAuth2.do', 'auth_popup', 'width=520, height=640');
			}
		</script>
  	</head>
  	<body onload="init();">
		<div id="wrapper">
			
			<!-- <form name="loginForm" id="loginForm" method="post">	 -->
			<form name="loginForm" method="post" action ="/mngwsercgateway/checkLogin.do" onsubmit="return validate(this);">
				<input type="hidden" id="message" name="message" value="" />
				<input type="hidden" id="flag" name="flag" value="" />
				<input type="hidden" value="${sessionScope.retryCount}">
				<div class="adminMain">
					<div class="inputDiv">
						<div class="left"><a href="/"><img src="/common/images/admin/admin_logo.gif" alt="대명아임레디 관리자" /></a></div>
	
						<div class="right">
							<input type="text" name="id" id="id" maxlength="20" placeholder="아이디 혹은 사원번호" required="아이디 또는 사원번호를 입력해 주세요." autocomplete="off" />
							<input type="password" name="password" id="password" maxlength="20" placeholder="비밀번호" required="비밀번호를 입력해 주세요." autocomplete="off" onkeydown="javascript:if(event.keyCode==13){checkLogin();}"/>
							<c:choose>
								<c:when test="${sessionScope.checkCaptha eq 'N'}">
									<div class="login_fail_security">
										<p class="txt_security">비밀번호와 자동입력 방지문자를 입력해주세요.<br /><strong>비밀번호를 5회 이상 잘못 입력</strong>하면, 정보보호를 위해 자동입력방지 문자를 함께 입력하셔야 합니다.</p>
										<img id="captchaImg" class="img_security" name="captchaImg" src="/captcha" alt="보안문자 이미지" width="65px" height="37px" />
										<input type="text" name="captchaText" id="captchaText" value="" title="보안문자" placeholder="보안문자" class="lginInput2" maxlength="5" onkeydown="javascript:if(event.keyCode==13){checkLogin();}"/>
									</div>
								</c:when>
								<c:when test="${sessionScope.retryCount > 4}">
									<div class="login_fail_security">
										<p class="txt_security">비밀번호와 자동입력 방지문자를 입력해주세요.<br /><strong>비밀번호를 5회 이상 잘못 입력</strong>하면, 정보보호를 위해 자동입력방지 문자를 함께 입력하셔야 합니다.</p>
										<img id="captchaImg" class="img_security" name="captchaImg" src="/captcha" alt="보안문자 이미지" width="65px" height="37px" />
										<input type="text" name="captchaText" id="captchaText" value="" title="보안문자" placeholder="보안문자" class="lginInput2" maxlength="5" onkeydown="javascript:if(event.keyCode==13){checkLogin();}"/>
									</div>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
							<button><img src="/common/images/admin/admin_login.gif" alt="로그인"/></button>
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
			
			<form name="form1" action="/mngwsercgateway/phoneAuth.do" method="post">
			</form>
			
			<!-- 본인확인 처리결과 정보 -->
			<form name="kcbResultForm" method="post" action="/mngwsercgateway/getPhoneAuthInf.do">
				<input type="hidden" name="result_cd" 		value="" 	/>
				<input type="hidden" name="result_msg" 	value="" 	/>
				<input type="hidden" name="di" 				value="" 	/>
				<input type="hidden" name="ci" 				value="" 	/>
				<input type="hidden" name="name" 			value="" 	/>
				<input type="hidden" name="birthday" 		value="" 	/>
				<input type="hidden" name="sex" 				value="" 	/>
				<input type="hidden" name="tel_com_cd" 	value="" 	/>
				<input type="hidden" name="tel_no" 			value="" 	/>
				<input type="hidden" name="return_msg" 	value="" 	/>
			</form>
		</div> <!--// wrapper -->

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