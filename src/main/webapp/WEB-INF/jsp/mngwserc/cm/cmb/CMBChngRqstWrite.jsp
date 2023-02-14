<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--  
	######################################################################
	파일명 		:	CMBChngRqstWrite.jsp
	프로그램 명 : 	전환서비스 신청 상세를 조회한다.
	설명		: 	전환서비스 신청 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.15
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.15				허진영				최초작성
	######################################################################
-->

<c:set var="memInfo" value="${rtnMap.memInfo}" />
						
<c:set var="userInfo" value="${rtnMap.userInfo}" />

<c:set var="prdctInfo" value="${rtnMap.prdctInfo}" />

<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post" action="">
	<input type="hidden" name="rqstSeq" value="" />
	<input type="hidden" name="delSeq" value="" />

	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />


	<h5>● 회원 정보</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">회원 정보</caption>
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
					${memInfo.memNm}
				</td>
				<th style="vertical-align:middle;">
					회원번호
				</th>
				<td>
					${memInfo.accntNo}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					상품명
				</th>
				<td>
					${memInfo.prodNm}
				</td>
				<th style="vertical-align:middle;">
					총 상품금액
				</th>
				<td>
					<fmt:formatNumber value="${memInfo.prodAmt}" type="number" maxFractionDigits="0" />원
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					가입일자
				</th>
				<td>
					${egov:convertDate(memInfo.joinDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
				<th style="vertical-align:middle;">
					생년월일
				</th>
				<td>
					${egov:convertDate(memInfo.brthMonDay, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					연락처
				</th>
				<td>
					${memInfo.cell}
				</td>
				<th style="vertical-align:middle;">
					이메일
				</th>
				<td>
					${userInfo.memEmail}
				</td>
			</tr>
		</tbody>
	</table>
	
	<h5>● 사용자정보</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">사용자 정보</caption>
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 사용자이름
				</th>
				<td>
					<input type="text" name="userNm" value="${userInfo.userNm}" maxlength="25" required="사용자이름을 입력해주세요." />
				</td>
				<th style="vertical-align:middle;">
					* 회원과의 관계
				</th>
				<td>
					<select name="userRelCd">
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.memRelGb}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${userInfo.userRelGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					연락처
				</th>
				<td>
					<input type="text" name="userCtel" value="${userInfo.userCtel}" maxlength="13" tel />
				</td>
				<th style="vertical-align:middle;">
					* 상품 사용 요청일
				</th>
				<td>
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="prdctUseReqnDt" name="prdctUseReqnDt" value="${egov:convertDate(userInfo.prdctUseReqnDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input input-small" style="width:100px; text-align:center;" readonly="readonly" required="상품 사용 요청일을 선택해주세요." />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					이메일
				</th>
				<td colspan="3">
					<input type="text" name="userEmail" value="${userInfo.userEmail}" maxlength="40" emailKr />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					요청사항
				</th>
				<td colspan="3">
					<textarea name="reqnCntn" style="height:200px; width:98%;">${userInfo.reqnCntn}</textarea>
				</td>
			</tr>
		</tbody>
	</table>
	
	<h5>● 전환서비스 정보</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">전환서비스 정보</caption>
		<colgroup>
			<col width="15%" />
			<col width="85%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					전환서비스
				</th>
				<td>
					${prdctInfo.prdctGb}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					상품명
				</th>
				<td>
					${prdctInfo.prdctNm}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					상품상세
				</th>
				<td>
					${egov:nvl(prdctInfo.prdctDtlNm, '-')}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					진행현황
				</th>
				<td>
					<select name="prcsCd">
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.chngPrcsStts}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${userInfo.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					상담이력
				</th>
				<td>
					<textarea name="cnslCntn" style="height:200px; width:98%;">${userInfo.cnslCntn}</textarea>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					진행현황 로그
				</th>
				<td>
					<c:forEach var="list" items="${rtnMap.prcsLog}" varStatus="status">
						<p>
						<span style="display:inline-block; width:140px; text-align:center;">${list.prcsStts}</span> 
						&nbsp;&nbsp;:&nbsp;&nbsp;  
						${egov:convertDate(list.modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</p>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	
	<h5>● 상품 정보</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">전환서비스 정보</caption>
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					납입 회차
				</th>
				<td>
					${memInfo.trueCnt}회
				</td>
				<th style="vertical-align:middle;">
					납입 금액
				</th>
				<td>
					<fmt:formatNumber value="${memInfo.trueAmt + memInfo.relatAmt + memInfo.addAmt}" type="number" maxFractionDigits="0" />원
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					잔여 회차
				</th>
				<td>
					${memInfo.exprNo - memInfo.trueCnt}회
				</td>
				<th style="vertical-align:middle;">
					잔여 금액
				</th>
				<td>
					<fmt:formatNumber value="${memInfo.prodAmt -(memInfo.trueAmt + memInfo.relatAmt + memInfo.addAmt)}" type="number" maxFractionDigits="0" />원
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					중도금
				</th>
				<td colspan="3">
					<input type="text" name="itmdtPay" value="${userInfo.itmdtPay}" <c:if test="${userInfo.prcsCd gt 4}">readonly</c:if> onkeyup="numChk(this);" maxlength="10" number /> 
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:deleteChngRqst();" class="btn btn-danger">삭제</a>
</div>

<div style="float:right;">
	<a href="javascript:chkForm();" class="btn btn-success">저장</a>
	<a href="javascript: document.listFrm.submit()" class="btn btn-default">목록</a>
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
		
		if(confirm("저장하시겠습니까?"))
		{
			startProgress(jQuery(".container-fluid"), jQuery("#progDiv"));
			
			var f = document.frm;
			
			f.action = "./update.do";
			f.rqstSeq.value = "${userInfo.rqstSeq}";
			f.submit();		 
		}
	}
	
	//삭제하기
	function deleteChngRqst()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			
			f.action = "./delete.do";
			f.delSeq.value = "${userInfo.rqstSeq}";
			f.submit();
		}
	}
</script>