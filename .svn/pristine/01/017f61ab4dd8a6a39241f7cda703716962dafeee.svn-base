<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMDMbspCardList.jsp
	프로그램 명 : 	멤버십카드 신청내역 상세를 조회한다.
	설명		: 	멤버십카드 신청내역 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11	
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<c:set var="mbspCardInfo" value="${rtnMap.mbspCardInfo}" />

<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>


<form name="frm" method="post" action="" >
	<input type="hidden" name="rqstSeq" value="" />

	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />


	<table class="table table-bordered">
		<caption style="display: none;">멤버십카드 신청내역 상세</caption>
		<colgroup>
			<col width="15%" />
			<col width="35%" />	
			<col width="15%" />	
			<col width="35%" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					회원이름
				</th>
				<td>
					${mbspCardInfo.name}
				</td>
				<th style="vertical-align:middle;">
					아이디
				</th>
				<td>
					${mbspCardInfo.id}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					회원번호
				</th>
				<td>
					${mbspCardInfo.accntNo}
				</td>
				<th style="vertical-align:middle;">
					이메일
				</th>	
				<td>
					${mbspCardInfo.email}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					휴대전화
				</th>
				<td>
					${mbspCardInfo.hp}
				</td>	
				<th style="vertical-align:middle;">
					전화번호
				</th>
				<td>
					${mbspCardInfo.tel}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					주소
				</th>
				<td colspan="3">
				 	${mbspCardInfo.zipcd}&nbsp;${mbspCardInfo.adr}&nbsp;${mbspCardInfo.adrDtl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					처리현황
				</th>
				<td colspan="3">
					<c:set var="prcsCd" value="${egov:nvl(mbspCardInfo.prcsCd, '01')}" />
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
						<span style="display:inline-block; width:60px;">
							<input type="radio" name="prcsCd" value="${cdlist.cd}" <c:if test="${prcsCd eq cdlist.cd}">checked</c:if>/> ${cdlist.cdNm}
						</span>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	
	<table class="table table-bordered">
		<caption style="display: none;">멤버십카드 신청 상담이력</caption>
		<colgroup>
			<col width="100%" />
		</colgroup>
		<tbody>
			<tr>
				<td>• 상담이력</td>
			</tr>
			<tr>
				<td>
					<textarea name="memo" style="height:200px; width:98%;">${mbspCardInfo.memo}</textarea>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="javascript:updateMbspCard();" class="btn btn-success">확인</a>
	<a href="javascript: document.listFrm.submit()" class="btn btn-default">취소</a>
</div>
	
<script type="text/javascript">

	//멤버십카드 신청내역 저장
	function updateMbspCard()
	{
		if(confirm("저장하시겠습니까?"))
		{
			startProgress(jQuery(".container-fluid"), jQuery("#progDiv"));
			
			var f = document.frm;
			
			f.action = "./update.do";
			f.rqstSeq.value = "${mbspCardInfo.rqstSeq}";
			f.submit();		 
		}
	}
	
</script>