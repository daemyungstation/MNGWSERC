<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--  
	######################################################################
	파일명 		:	MBAMemInfWrite.jsp
	프로그램 명 : 	회원 정보 상세를 조회한다.
	설명		: 	회원 정보 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.22
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.22				허진영				최초작성
	######################################################################
-->
<c:set var="memInfo" value="${rtnMap.memInfo}" />

<form name="frm" method="post" action="">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="ssoId" value="" />

	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="dtGb" value="${rtnMap.dtGb}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="smsRcvYn" value="${rtnMap.smsRcvYn}" />
	<input type="hidden" name="emailRcvYn" value="${rtnMap.emailRcvYn}" />
	<input type="hidden" name="unqExstYn" value="${rtnMap.unqExstYn}" />	

	<h5>● 기본 회원정보</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">회원 정보 관리</caption>
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					이름
				</th>
				<td colspan="3">
					<input type="text" name="name" value="${memInfo.name}" style="width:150px;" maxlength="20" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					아이디
				</th>
				<td>
					${memInfo.id}
				</td>
				<th style="vertical-align:middle;">
					SSO 통합아이디
				</th>
				<td>
					${memInfo.ssoId}
				</td>
			</tr>
			<tr>
<c:if test="${admLgnMap.authCd eq 99}">
				<th style="vertical-align:middle;">
					생년월일
				</th>
				<td>
					<input type="text" name="birth" value="${memInfo.birth}" onkeyup="numChk(this);" style="width:150px;" maxlength="8" />
				</td>
</c:if>
				<th style="vertical-align:middle;">
					회원 가입일
				</th>
				<td>
					${egov:convertDate(memInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
<c:if test="${admLgnMap.authCd ne 99}">
				<th></th>
				<td>
					<input type="hidden" name="birth" value="${memInfo.birth}" onkeyup="numChk(this);" style="width:150px;" maxlength="8" />
				</td>
</c:if>
			</tr>
<c:if test="${admLgnMap.authCd eq 99}">
			<tr>
				<th style="vertical-align:middle;">
					비밀번호
				</th>
				<td>
					<input type="password" id="pwd1" name="pwd1" value="" style="width:150px;" maxlength="20" />
				</td>
				<th style="vertical-align:middle;">
					비밀번호 확인
				</th>
				<td>
					<input type="password" id="pwd2" name="pwd2" value="" style="width:150px;" maxlength="20" />
				</td>
			</tr>			
</c:if>
			<tr>
				<th style="vertical-align:middle;">
					이메일
				</th>
				<td colspan="3">
					<!-- 2020-01-13 이메일 유효성체크 제거 요청
					<input type="text" id="email1" name="email1" value="${fn:split(memInfo.email, '@')[0]}" style="width:150px;" maxlength="20" required="이메일을 입력해주세요." />&nbsp;@&nbsp;
					<input type="text" id="email2" name="email2" value="${fn:split(memInfo.email, '@')[1]}" style="width:150px;" maxlength="20" required="이메일을 입력해주세요." />
					 -->
					<input type="text" id="email1" name="email1" value="${fn:split(memInfo.email, '@')[0]}" style="width:150px;" maxlength="20" />&nbsp;@&nbsp;
					<input type="text" id="email2" name="email2" value="${fn:split(memInfo.email, '@')[1]}" style="width:150px;" maxlength="20" />					 
					<select id="email3" onchange="changeEmail();">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
                        <option value="nate.com">nate.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="daum.net">daum(hanmail).net</option>				
					</select>
					<input type="hidden" name="email" value="" emailkr />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 휴대전화
				</th>
				<td colspan="3">
					<input type="text" id="hpa" name="hpa" value="${fn:split(memInfo.hp, '-')[0]}" style="width:80px;" onkeyup="numChk(this);" maxlength="4" required="휴대전화를 입력해주세요." number /> - 
					<input type="text" id="hps" name="hps" value="${fn:split(memInfo.hp, '-')[1]}" style="width:80px;" onkeyup="numChk(this);" maxlength="4" required="휴대전화를 입력해주세요." number /> - 
					<input type="text" id="hpi" name="hpi" value="${fn:split(memInfo.hp, '-')[2]}" style="width:80px;" onkeyup="numChk(this);" maxlength="4" required="휴대전화를 입력해주세요." number />
					<input type="hidden" name="hp" value="" phone />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					전화번호
				</th>
				<td colspan="3">
					<input type="text" id="tela" name="tela" value="${fn:split(memInfo.tel, '-')[0]}" style="width:80px;" onkeyup="numChk(this);" maxlength="4" number /> - 
					<input type="text" id="tels" name="tels" value="${fn:split(memInfo.tel, '-')[1]}" style="width:80px;" onkeyup="numChk(this);" maxlength="4" number /> - 
					<input type="text" id="teli" name="teli" value="${fn:split(memInfo.tel, '-')[2]}" style="width:80px;" onkeyup="numChk(this);" maxlength="4" number />
					<input type="hidden" name="tel" value="" tel />
				</td>
			</tr>
<c:if test="${admLgnMap.authCd eq 99}">

			<tr>
				<th style="vertical-align:middle;">
					* 주소
				</th>
				<td colspan="3">
					<div>
						<!-- 2020-01-08. 담당자 요청으로 인한 유효성 체크 제거
						<input type="text" name="zipcd" value="${memInfo.zipcd}" style="width:80px;" maxlength="7" required="우편번호를 입력해주세요." readonly="readonly" />
						<input type="text" name="adr" value="${memInfo.adr}" style="width:410px;" maxlength="100" required="주소를 입력해주세요."  />
						-->
						<input type="text" name="zipcd" value="${memInfo.zipcd}" style="width:80px;" maxlength="7" readonly="readonly" />
						<input type="text" name="adr" value="${memInfo.adr}" style="width:410px;" maxlength="100" />						
						<a href="javascript:" id="zipcode" class="btn ">주소검색</a>
					</div>
					<div style="margin-top:10px;">
						<input type="text" name="adrDtl" value="${memInfo.adrDtl}" style="width:510px;" maxlength="100" />
						<!-- 2020-01-08. 담당자 요청으로 인한 유효성 체크 제거
						<input type="text" name="adrDtl" value="${memInfo.adrDtl}" style="width:510px;" maxlength="100" required="상세주소를 입력해주세요."  />
						-->
					</div>
				</td>
			</tr>
</c:if>
<c:if test="${admLgnMap.authCd ne 99}">
	<input type="hidden" name="zipcd" value="${memInfo.zipcd}" style="width:80px;" maxlength="7" readonly="readonly" />
	<input type="hidden" name="adr" value="${memInfo.adr}" style="width:410px;" maxlength="100" />
	<input type="hidden" name="adrDtl" value="${memInfo.adrDtl}" style="width:510px;" maxlength="100" />
</c:if>
			<tr>
				<th style="vertical-align:middle;">
					최종 접속일
				</th>
				<td>
					${egov:convertDate(memInfo.lastLgnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
				<th style="vertical-align:middle;">
					계정상태
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="useYn" value="Y" <c:if test="${memInfo.useYn eq 'Y'}">checked</c:if>/> 허용
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="useYn" value="N" <c:if test="${memInfo.useYn eq 'N'}">checked</c:if>/> 차단
					</span>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					고유번호
				</th>
				<td>
					<c:choose>
						<c:when test="${not empty memInfo.unqNo}">
							<input type="text" name="unqNo" value="${memInfo.unqNo}" style="width:150px;" onkeyup="numChk(this);" maxlength="20" />
						</c:when>
						<c:when test="${not empty memInfo.memNo}">
							<input type="text" name="unqNo" value="${memInfo.memNo}" style="width:150px;" onkeyup="numChk(this);" maxlength="20" />
							(DLCC 정보)
						</c:when>
						<c:otherwise>
							<input type="text" name="unqNo" value="" style="width:150px;" onkeyup="numChk(this);" maxlength="20" />
						</c:otherwise>
					</c:choose>
				</td>
<c:if test="${admLgnMap.authCd eq 99}">
				<th style="vertical-align:middle;">
					대리 로그인
				</th>

				<td>
					<a href="javascript:" id="proxyLogin" class="btn btn-default">대리로그인</a>
				</td>
</c:if>
<c:if test="${admLgnMap.authCd ne 99}">
				<th></th>
				<td></td>
</c:if>

			</tr>
		</tbody>
	</table>
	<div style="color:white">
		${memInfo.ci}
	</div>
			
	<h5>● 추가정보(선택사항)</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">추가 정보 관리</caption>
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					결혼 유/무
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="mrrgYn" value="Y" <c:if test="${memInfo.mrrgYn eq 'Y'}">checked</c:if>/> 유
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="mrrgYn" value="N" <c:if test="${memInfo.mrrgYn eq 'N'}">checked</c:if>/> 무
					</span>
				</td>
				<th style="vertical-align:middle;">
					자녀 여부
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="chdrnGb" value="0" <c:if test="${memInfo.chdrnGb eq '0'}">checked</c:if>/> 없음
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="chdrnGb" value="1" <c:if test="${memInfo.chdrnGb eq '1'}">checked</c:if>/> 1
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="chdrnGb" value="2" <c:if test="${memInfo.chdrnGb eq '2'}">checked</c:if>/> 2
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="chdrnGb" value="3" <c:if test="${memInfo.chdrnGb eq '3'}">checked</c:if>/> 3이상
					</span>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					관심정보<br />(3가지 선택)
				</th>
				<td colspan="3">
					<c:forEach var="list" items="${rtnMap.cdDtlList.intrGb}" varStatus="status">
						<c:if test="${status.index % 5 eq 0}">
							<c:choose>
								<c:when test="${status.first}">
									<div>
								</c:when>
								<c:otherwise>
									<div style="margin-top:10px;">
								</c:otherwise>
							</c:choose>
						</c:if>
						<span style="display:inline-block; width:150px;">
							<input type="checkbox" name="intrGb" value="${list.cd}" <c:if test="${fn:contains(memInfo.intrPtc, list.cd)}">checked</c:if>/> ${list.cdNm}
						</span>
						<c:if test="${status.count % 5 eq 0}">
							</div>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					가입경로
				</th>
				<td colspan="3">
					<c:forEach var="list" items="${rtnMap.cdDtlList.joinPathGb}" varStatus="status">
						<c:if test="${status.index % 4 eq 0}">
							<c:choose>
								<c:when test="${status.first}">
									<div>
								</c:when>
								<c:otherwise>
									<div style="margin-top:10px;">
								</c:otherwise>
							</c:choose>
						</c:if>
						<span style="display:inline-block; ${egov:decode(list.cdNm, '기타', 'margin-right:10px', 'width:150px')};">
							<input type="radio" name="joinPath" value="${list.cd}" <c:if test="${memInfo.joinPath eq list.cd}">checked</c:if>/> <span>${list.cdNm}</span>
						</span>
						<c:if test="${list.cdNm eq '기타'}">
							<span style="display:inline-block;">
								<input type="text" name="joinPathEtc" value="${memInfo.joinPathEtc}" maxlength="100" <c:if test="${memInfo.joinPath ne list.cd}">readonly</c:if>/>
							</span>
						</c:if>
						<c:if test="${status.count % 4 eq 0}">
							</div>
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					상품가입시 가장 끌렸던 점은?<br />(2가지 선택)
				</th>
				<td colspan="3">
					<c:forEach var="list" items="${rtnMap.cdDtlList.pfrnGb}" varStatus="status">
						<c:choose>
							<c:when test="${status.first}">
								<div>
							</c:when>
							<c:otherwise>
								<div style="margin-top:10px;">
							</c:otherwise>
						</c:choose>
						<input type="checkbox" name="pfrnGb" value="${list.cd}" <c:if test="${fn:contains(memInfo.pfrnPtc, list.cd)}">checked</c:if>/> <span>${list.cdNm}</span>
						<c:if test="${list.cdNm eq '기타'}">
							<input type="text" name="pfrnEtc" value="${memInfo.pfrnEtc}" style="margin-left:10px;" maxlength="100" <c:if test="${not fn:contains(memInfo.pfrnPtc, list.cd)}">readonly</c:if>/>
						</c:if>
						</div>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	
	<div style="float:left;">
		<a href="javascript:deleteAlncCnsl();" class="btn btn-danger">탈퇴처리</a>
	</div>
	
	<div style="float:right;">
		<a href="javascript:chkForm();" class="btn btn-success">확인</a>
		<button type="button" class="btn" onclick="List()">목록</button>
					
	</div>
</form>

<table class="table table-bordered" style="margin-top:80px;">
	<caption style="display: none;">서비스 수신 로그</caption>
	<colgroup>
		<col width="*" />
		<col width="5%" />
		<col width="13%" />
		<col width="13%" />
		<col width="13%" />
		<col width="13%" />
	</colgroup>
	<tbody>
		<c:forEach var="list" items="${rtnMap.srvcRcvModLog}" varStatus="status">
			<tr>
				<th style="vertical-align:middle;">
					<c:choose>
						<c:when test="${list.rcvGb eq 'sms'}">
							SMS 수신여부
						</c:when>
						<c:when test="${list.rcvGb eq 'tel'}">
							전화 수신여부
						</c:when>
						<c:when test="${list.rcvGb eq 'agreementForThirdParty'}">
							CI 동의 여부
						</c:when>
						<c:when test="${list.rcvGb eq 'marketingInfo'}">
							마케팅 수신여부
						</c:when>
						<c:when test="${list.rcvGb eq 'ctlg'}">
							카탈로그 수신여부
						</c:when>
						<c:when test="${list.rcvGb eq 'email'}">
							이메일 수신여부
						</c:when>
					</c:choose>
				</th>
				<td style="text-align:center">
					<c:choose>
						<c:when test="${list.rcvGb eq 'sms'}">
							${memInfo.smsRcvYn}
						</c:when>
						<c:when test="${list.rcvGb eq 'marketingInfo'}">
							${memInfo.marketingYn}
						</c:when>
						<c:when test="${list.rcvGb eq 'agreementForThirdParty'}">
							${memInfo.agreementForThirdParty}
						</c:when>
						<c:when test="${list.rcvGb eq 'email'}">
							${memInfo.emailRcvYn}
						</c:when>
					</c:choose>
				</td>
				<td style="text-align:center;">
					이전 변경일
				</td>
				<td>
					${egov:convertDate(egov:nvl(list.bfrModDtm, list.lastModDtm), 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
				<td style="text-align:center;">
					최종 변경일
				</td>
				<td>
					${egov:convertDate(list.lastModDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form name="proxyFrm" method="post" action="">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="pwd" value="" />
	<input type="hidden" name="authKey" value="" />
</form>	

<script type="text/javascript">
	function List(){
		var frm = document.frm;
		
		frm.action = "./list.do";
		frm.submit();
	}
	
	jQuery(document).ready(function(){
		//이메일 setting
		var eDomain = jQuery("#email2").val();
		
		if(eDomain)
		{
			var drctVal = true;
			
			jQuery("#email3 option").each(function(i){
				if(eDomain == jQuery(this).val())
				{
					drctVal = false;
					return false;
				}
			});
			
			if(!drctVal)
			{
				jQuery("#email2").prop("readonly", true);
				jQuery("#email3").val(eDomain);
			}
			else
			{
				jQuery("#email2").prop("readonly", false);
				jQuery("#email3").val("");
			}
		}
		else
		{
			jQuery("#email2").prop("readonly", false);
			jQuery("#email3").val("");
		}
		
		//관심정보 클릭시
		jQuery("input[name='intrGb']").on("click", function(){
			var chkCnt = jQuery("input[name='intrGb']:checked").length;
			
			if(chkCnt > 3)
			{
				alert("3가지 이상 선택 할 수 없습니다.");
				jQuery(this).prop("checked", false);
			}
		});
		
		//가입경로 변경시
		jQuery("input[name='joinPath']").on("change", function(){
			var joinPath = jQuery(this).next().text();
			
			if(joinPath == "기타")
			{
				jQuery("input[name='joinPathEtc']").prop("readonly", false);
				jQuery("input[name='joinPathEtc']").focus();
			}
			else
			{
				jQuery("input[name='joinPathEtc']").val("");
				jQuery("input[name='joinPathEtc']").prop("readonly", true);
			}
		});
		
		//선호정보 클릭
		jQuery("input[name='pfrnGb']").on("click", function(){
			var chkCnt = jQuery("input[name='pfrnGb']:checked").length;
			
			if(chkCnt > 2)
			{
				alert("2가지 이상 선택 할 수 없습니다.");
				jQuery(this).prop("checked", false);
			}
			else
			{
				var pfrnGb = jQuery(this).next().text();
				
				if(pfrnGb == "기타")
				{
					var isChkd = jQuery(this).is(":checked");
					
					if(isChkd)
					{
						jQuery("input[name='pfrnEtc']").prop("readonly", false);
						jQuery("input[name='pfrnEtc']").focus();
					}
					else
					{
						jQuery("input[name='pfrnEtc']").val("");
						jQuery("input[name='pfrnEtc']").prop("readonly", true);
					}
				}
			}
		});
		
		//주소검색 클릭
		jQuery("#zipcode").on("click", function(e){
			e.preventDefault();
			
			new daum.Postcode({
				oncomplete: function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			        // 예제를 참고하여 다양한 활용법을 확인해 보세요.
					jQuery("input[name='zipcd']").val(data.zonecode);
			        jQuery("input[name='adr']").val(data.roadAddress);
				}
			}).open();
		});
		
		//대리로그인 클릭
		jQuery("#proxyLogin").on("click", function(){
			var popupNm = "proxyLogin";
			
	    	window.open("", popupNm);
	    	
	    	var f = document.proxyFrm;
	    	
	    	f.action = "<fmt:message key='Globals.httpsUrl' />/member/login/admin-login.do";
	    	f.target = popupNm;
	    	f.id.value = "${egov:encrypt(memInfo.id, 'UTF-8')}";
	    	f.pwd.value = "${memInfo.pwd}";
	    	f.authKey.value = "${egov:encrypt('대명아임레디', 'UTF-8')}";
	    	
	    	console.log("action : " + f.action);
			console.log("target : " + f.target);
			console.log("id.value : " + f.id.value);
			console.log("pwd.value : " + f.pwd.value);
			console.log("authKey.value : " + f.authKey.value);
	    
	    	f.submit();
		});
	});
	
	//유효성 체크
	function chkForm()
	{

		//최고관리자 비밀번호 수정(http://183.111.69.197:8080/issues/76)
		if($("#pwd1").val()!="" || $("#pwd2").val()!=""){
			if($("#pwd1").val() != $("#pwd2").val()){
				alert('비밀번호와 비밀번호 확인 값이 동일하지 않습니다.');
				return;
			}
		}		
		
		var f = document.frm;
		
		if(jQuery.trim(f.name.value) == "") {
			f.name.focus();
			alert('이름을 입력해주세요.');
			return;
		}
		if(jQuery.trim(f.birth.value) == "") {
			alert('생년월일을 입력해주세요.');
			f.birth.focus();
			return;
		}
		//이메일 setting
		var email = jQuery.trim(jQuery("#email1").val()) + "@" + jQuery.trim(jQuery("#email2").val());
		email = email=="@" ? "" : email;
		jQuery("input[name='email']").val(email);
		//jQuery("input[name='email']").val(jQuery("#email1").val() + "@" +jQuery("#email2").val());
		
		//휴대전화 setting
		jQuery("input[name='hp']").val(jQuery("#hpa").val() + "-" + jQuery("#hps").val() + "-" + jQuery("#hpi").val());
		
		//전화번호 setting
		if(jQuery("#tela").val() || jQuery("#tels").val() || jQuery("#teli").val())
		{
			var pattern = /^[0-9]{2,4}-?[0-9]{3,4}-?[0-9]{4}$/;

			if (pattern.exec(jQuery("#tela").val() + '-' + jQuery("#tels").val() + '-' + jQuery("#teli").val())) 
			{
				jQuery("input[name='tel']").val(jQuery("#tela").val() + '-' + jQuery("#tels").val() + '-' + jQuery("#teli").val());
			} 
			else 
			{
				alert("* 전화번호 입력값이 올바르지 않습니다.");
				return;
			}
		}
		else
		{
			jQuery("input[name='tel']").val("");
		}
		
		if(!validate(f))
		{
			return;
		}
		
		if(confirm("저장하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./update.do";
			f.id.value = "${memInfo.id}";
			f.ssoId.value = "${memInfo.ssoId}";
			
			f.submit();		 
		}
	}
	
	//이메일 주소 변경
	function changeEmail()
	{
		var eDomain = jQuery("#email3").val();
		
		if(eDomain == "")
		{
			jQuery("#email2").val("");
			jQuery("#email2").prop("readonly", false);
		}
		else
		{
			jQuery("#email2").val(eDomain);
			jQuery("#email2").prop("readonly", true);
		}
	}
	
	//탈퇴처리
	function deleteAlncCnsl()
	{
		if(confirm("탈퇴하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./drot.do";
			f.id.value = "${memInfo.id}";
			f.ssoId.value = "${memInfo.ssoId}";
			f.submit();
		}
	}
	
</script>