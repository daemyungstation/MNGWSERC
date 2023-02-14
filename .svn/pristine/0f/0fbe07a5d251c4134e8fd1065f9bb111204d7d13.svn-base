<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--  
	######################################################################
	파일명 		:	MBCQscnMemView.jsp
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
					${memInfo.name}
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
					${memInfo.birth}
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
			<td></td>
</c:if>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					이메일
				</th>
				<td colspan="3">
					${memInfo.email}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					휴대전화
				</th>
				<td colspan="3">
					${memInfo.hp}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					전화번호
				</th>
				<td colspan="3">
					${memInfo.tel}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					최종 접속일
				</th>
				<td colspan="3">
					${egov:convertDate(memInfo.lastLgnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
			</tr>
		</tbody>
	</table>
	
	<h5>● 고객서비스 수신동의</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">서비스 수신 관리</caption>
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					SMS
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="smsRcvYn" value="Y" <c:if test="${memInfo.smsRcvYn eq 'Y'}">checked</c:if>/> 예
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="smsRcvYn" value="N" <c:if test="${memInfo.smsRcvYn eq 'N'}">checked</c:if>/> 아니오
					</span>
				</td>
				<th style="vertical-align:middle;">
					전화
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="telRcvYn" value="Y" <c:if test="${memInfo.telRcvYn eq 'Y'}">checked</c:if>/> 예
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="telRcvYn" value="N" <c:if test="${memInfo.telRcvYn eq 'N'}">checked</c:if>/> 아니오
					</span>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					카탈로그
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="ctlgRcvYn" value="Y" <c:if test="${memInfo.ctlgRcvYn eq 'Y'}">checked</c:if>/> 예
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="ctlgRcvYn" value="N" <c:if test="${memInfo.ctlgRcvYn eq 'N'}">checked</c:if>/> 아니오
					</span>
				</td>
				<th style="vertical-align:middle;">
					이메일
				</th>
				<td>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="emailRcvYn" value="Y" <c:if test="${memInfo.emailRcvYn eq 'Y'}">checked</c:if>/> 예
					</span>
					<span style="display:inline-block; width:60px;">
						<input type="radio" name="emailRcvYn" value="N" <c:if test="${memInfo.emailRcvYn eq 'N'}">checked</c:if>/> 아니오
					</span>
				</td>
			</tr>
		</tbody>
	</table>
	
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
						<input type="radio" name="chdrnGb" value="3" <c:if test="${memInfo.chdrnGb eq '3'}">checked</c:if>/> 3 이상
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
							<input type="radio" name="joinPath" value="${list.cd}" <c:if test="${memInfo.joinPath eq list.cd}">checked</c:if>/> ${list.cdNm}
						</span>
						<c:if test="${list.cdNm eq '기타'}">
							<span style="display:inline-block;">
								<input type="text" name="joinPathEtc" value="${memInfo.joinPathEtc}" maxlength="100" <c:if test="${empty memInfo.joinPathEtc}">readonly</c:if>/>
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
							<input type="checkbox" name="pfrnGb" value="${list.cd}" <c:if test="${fn:contains(memInfo.pfrnPtc, list.cd)}">checked</c:if>/> ${list.cdNm}
							<c:if test="${list.cdNm eq '기타'}">
								<input type="text" name="pfrnEtc" value="${memInfo.pfrnEtc}" style="margin-left:10px;" maxlength="100" <c:if test="${empty memInfo.pfrnEtc}">readonly</c:if>/>
							</c:if>
						</div>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="javascript:updateQscnYn();" class="btn btn-success">휴면해제</a>		
	<a href="./list.do" class="btn ">목록</a>						
</div>

<script type="text/javascript">
	
	jQuery(document).ready(function(){
		//readolny setting
		jQuery("form[name='frm']").find("input, radio, select").not("[name='id']").prop("disabled", true);
	});
	
	function updateQscnYn()
	{
		if(confirm("휴면상태를 해제하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./update.do";
			f.id.value = "${memInfo.id}";
			f.submit();
		}
	}
	
</script>