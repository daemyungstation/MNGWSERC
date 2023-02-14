<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMCPfmcRsvView.jsp
	프로그램 명 : 	공연예약 상세를 조회한다.
	설명		: 	공연예약 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.18
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.18				허진영				최초작성
	######################################################################
-->

<c:set var="rsvtnInfo" value="${rtnMap.rsvtnInfo}" />

<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post">
	<input type="hidden" name="rsvtnSeq" value="" />
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<table class="table table-bordered">
		<caption style="display:none;">공연예약 관리</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />					
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					회원명
				</th>
				<td>
					${rsvtnInfo.name}
					(${rsvtnInfo.accntNo})
				</td>
				<th style="vertical-align:middle;">
					연락처
				</th>
				<td>
					${rsvtnInfo.hp}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					공연명
				</th>
				<td>
					${rsvtnInfo.pfmcNm}
				</td>
				<th style="vertical-align:middle;">
					접수일
				</th>
				<td>
					${egov:convertDate(rsvtnInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					관람인원
				</th>
				<td colspan="3">
					${rsvtnInfo.seatCnt}명
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					관람좌석
				</th>
				<td colspan="3">
					${rsvtnInfo.seatGb}석
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					예약일시 1순위
				</th>
				<td colspan="3">
					<span style="display:inline-block; width:220px;">
						${egov:convertDate(rsvtnInfo.fstRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy년 MM월 dd일(EE) HH시 mm분', '')}
					</span>
					<c:set var="fstRsvtnDtm" value="${egov:convertDate(rsvtnInfo.fstRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyyMMddHHmm', '')}"/>
					<c:set var="lastRsvtnDtm" value="${egov:nvl(egov:convertDate(rsvtnInfo.lastRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyyMMddHHmm', ''), fstRsvtnDtm)}" />
					<input type="radio" name="lastRsvtnDtm" value="${fstRsvtnDtm}" <c:if test="${lastRsvtnDtm eq fstRsvtnDtm}">checked</c:if>/> 
					1순위 선택 (1순위 혹은 2순위 중 하나만 선택 가능)
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					예약일시 2순위
				</th>
				<td colspan="3">
					<span style="display:inline-block; width:220px;">
						${egov:convertDate(rsvtnInfo.secnRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy년 MM월 dd일(EE) HH시 mm분', '')}
					</span>
					<c:set var="secnRsvtnDtm" value="${egov:convertDate(rsvtnInfo.secnRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyyMMddHHmm', '')}"/>
					<input type="radio" name="lastRsvtnDtm" value="${secnRsvtnDtm}" <c:if test="${lastRsvtnDtm eq secnRsvtnDtm}">checked</c:if>/> 
					2순위 선택 (1순위 혹은 2순위 중 하나만 선택 가능)
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					요청사항
				</th>
				<td colspan="3">
					${rsvtnInfo.reqn}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					예약현황
				</th>
				<td colspan="3">
					<c:set var="prcsCd" value="${egov:nvl(rsvtnInfo.prcsCd, '01')}" />
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.rsvtnPrcsStts}" varStatus="status">
						<span style="display:inline-block; width:140px;">
							<input type="radio" name="prcsCd" value="${cdlist.cd}" <c:if test="${prcsCd eq cdlist.cd}">checked</c:if>/> ${cdlist.cdNm}
						</span>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="text-align:right; margin-bottom:20px;">
	<c:if test="${rsvtnInfo.prcsCd eq '00'}">
		<c:if test="${(admLgnMap.authCd eq '99' or admLgnMap.roleCd eq 'ROLE_00025') and rsvtnInfo.confYn1 ne 'Y'}">
			<a href="javascript:" class="btn btn-primary" onclick="updateConfYn(this, '1');">컨택담당자 확인</a>
		</c:if>
		<c:if test="${(admLgnMap.authCd eq '99' or admLgnMap.roleCd eq 'ROLE_00026') and rsvtnInfo.confYn2 ne 'Y'}">
			<a href="javascript:" class="btn btn-primary" onclick="updateConfYn(this, '2');">공연기획사 확인</a>
		</c:if>
	</c:if>
	<a href="javascript:updatePfmcRsvtn();" class="btn btn-success" id="btn_confirm" data-conf1="${rsvtnInfo.confYn1}" data-conf2="${rsvtnInfo.confYn2}">확인</a>
	<a href="javascript:document.listFrm.submit()" class="btn btn-default">취소</a>
</div>

<table class="table table-bordered">
	<caption style="display:none;">공연예약 상담</caption>
	<colgroup>
		<col width="15%" />
		<col width="85%" />
	</colgroup>
	<tbody>
		<tr>
			<th style="vertical-align:middle;">
				상담원명
			</th>
			<td>
				<input type="text" id="regNm" name="regNm" maxlength="25" />
			</td>
		</tr>
		<tr>
			<th style="vertical-align:middle;">
				상담이력
			</th>
			<td>
				<textarea id="memo" name="memo" style="height:200px; width:98%;">${rsvtnInfo.memo}</textarea>
			</td>
		</tr>
	</tbody>
</table>
	
<div style="float:right;">
	<a href="javascript:updatePfmcRsvtnCnsl();" class="btn btn-success">상담이력 저장</a>
</div>
	
<table class="table table-bordered" style="margin-top:80px;">
	<colgroup>
		<col style="width:15%;" />
		<col style="width:60%;" />
		<col style="width:25%;" />
	</colgroup>
	<tbody>
		<tr>
			<th style="vertical-align:middle;" colspan="3">상담이력</th>
		</tr>
		<c:choose>
			<c:when test="${fn:length(rtnMap.cnslList) eq 0}">
				<tr>
					<td colspan="3" style="text-align:center;">
						등록된 상담이력이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="cnslList" items="${rtnMap.cnslList}" varStatus="status">
					<tr>
						<th style="vertical-align:middle;">${cnslList.regNm}</th>
						<td>
							<jsp:scriptlet>
							    pageContext.setAttribute("cr", "\r");
							    pageContext.setAttribute("lf", "\n");
							    pageContext.setAttribute("crlf", "\r\n");
							</jsp:scriptlet>
							${fn:replace(fn:replace(cnslList.memo, ' ', '&nbsp;'), crlf, '<br />')}
						</td>
						<td style="vertical-align:middle; text-align:center;">
							${egov:convertDate(cnslList.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<script type="text/javascript">

	//예약처리현황 업데이트
	function updatePfmcRsvtn()
	{
		<c:if test="${rsvtnInfo.prcsCd eq '00'}">

		var dataObj = jQuery("#btn_confirm").data();

		if(dataObj.conf1 == "Y" || dataObj.conf2 == "Y")
		{
			alert("취소처리가 완료되어 변경할 수 없습니다.");
			return;
		}
		
		</c:if>
		
		if(confirm("저장하시겠습니까?"))
		{
			startProgress(jQuery(".container-fluid"), jQuery("#progDiv"));
			
			var f = document.frm;
			
			f.action = "./update.do";
			f.rsvtnSeq.value = "${rsvtnInfo.rsvtnSeq}";
			f.submit();		 
		}
	}
	
	//담당자확인 업데이트
	function updateConfYn(obj, trgt)
	{
		if(confirm("처리가 완료되었습니까?\n확인 후에는 변경이 불가합니다."))
		{
			var trgtObj = obj;
			
			jQuery.post("./conf-update.ajax",
				{
					"rsvtnSeq" : "${rsvtnInfo.rsvtnSeq}",
					"trgt" : trgt
				},
				function(r)
				{			
					var status = r.status;

					if(status == "Y")
					{
						jQuery(trgtObj).remove();
						jQuery("#btn_confirm").data("conf" + trgt, "Y");
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	//공연예약 상담이력 저장
	function updatePfmcRsvtnCnsl()
	{
		var regNm = jQuery("#regNm").val().trim();
		
		if (!regNm)
		{
			alert("상담원명을 입력해주세요.");
			jQuery("#regNm").focus();
			return;
		}
		
		var memo = jQuery("#memo").val().trim();
		
		if (!memo)
		{
			alert("상담이력을 입력해주세요.");
			jQuery("#memo").focus();
			return;
		}
		
		if(confirm("저장하시겠습니까?"))
		{
			jQuery.post("./cnsl-insert.ajax",
				{
					"rsvtnSeq" : "${rsvtnInfo.rsvtnSeq}",
					"regNm" : regNm,
					"memo" : memo
				},
				function(r)
				{			
					var status = r.status;
					
					if(status == "Y")
					{
						window.location.reload(true);
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}

</script>