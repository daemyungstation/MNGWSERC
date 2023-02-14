<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COCAdmInfoModify.jsp
	프로그램 명 : 	관리자관리
	설명		: 	정보수정
	작성자		: 	김대환
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				김대환				최초작성
	######################################################################
-->

<c:set var="admInfo" value="${rtnMap.admInfo}" />

<form name="frm" method="post" action="">
	<input type="hidden" name="admSeq" value="${admInfo.admSeq}" />
	
	<table class="table table-bordered">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<c:if test="${admLgnMap.intra ne 'Y'}">
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 이름
				</th>
				<td style="text-align:left;">
					${admInfo.name}
				</td>
				<th style="text-align:center; vertical-align:middle;">
					* 아이디
				</th>
				<td style="text-align:left;">
					${admInfo.id}
				</td>
			</tr>
			</c:if>
			<c:if test="${admLgnMap.intra eq 'Y'}">
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 이름
				</th>
				<td colspan="3" style="text-align:left;">
					${admLgnMap.name}
				</td>				
			</tr>
			</c:if>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 비밀번호
				</th>
				<td style="text-align:left;">
					<input type="password" name="pwd" maxlength="20" passChk />
				</td>
				<th style="text-align:center;vertical-align:middle;">
					비밀번호 확인
				</th>
				<td style="text-align:left;">
					<input type="password" name="pwd_chk" maxlength="20" passChk />
				</td>
			</tr>
			<tr>
				<td colspan="4" style="padding-left:25px;">
					• 비밀번호를 변경하실 경우에만 입력해 주세요.<br /> 
					• 특수문자, 숫자, 영문 3가지 조합으로 8자리이상 ~ 20자리 이하<br /> 
				</td>
			</tr>			
			<c:if test="${admLgnMap.intra ne 'Y'}">
				<tr>
					<th style="text-align:center;vertical-align:middle;">
						전화번호
					</th>
					<td style="text-align:left;">
						<input type="text" name="tel" value="${admInfo.tel}" maxlength="30" tel />
					</td>
					<th style="text-align:center; vertical-align:middle;">
						* 이메일
					</th>
					<td style="text-align:left;">
						<input type="text" name="email" value="${admInfo.email}" maxlength="40" required="이메일주소를 입력하세요." emailkr />
					</td>
				</tr>
				<tr>
					<td colspan="4" style="padding-left:25px;">
						• 이름 및 아이디는 변경할 수 없습니다. (최종 관리자에게 문의해 주시기 바랍니다.<br /> 
						• 이메일 및 전화번호는 각종 알림 시 수신받기 위해 필요한 정보입니다.<br />
					</td>
				</tr>
			</c:if>			
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
</div>

<script type="text/javascript">
	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!validate(f))
		{
			return;
		}
		
		if(f.pwd.value != f.pwd_chk.value)
		{
			alert("비밀번호를 다시 확인해 주세요.");
			return;				
		}
		
		if(confirm("수정하시겠습니까?"))
		{
			var reqtUri = location.pathname;
			
			reqtUri = reqtUri.substring(0, reqtUri.lastIndexOf("/"));
			
			f.action = reqtUri + "/modifyAction.do";
			f.submit();			
		}
	}
</script>