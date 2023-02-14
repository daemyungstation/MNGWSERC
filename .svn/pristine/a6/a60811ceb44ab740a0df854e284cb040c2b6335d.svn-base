<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMACounselView.jsp
	프로그램 명 : 	외주업체 상담관리 조회.
	설명		: 	외주업체 상담관리 조회
	작성자		: 	김필기
	작성일		:	2016.02.29
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.29				김필기				최초작성
	2016.05.20				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap}" />

<c:set var="answerList" value="${rtnMap.answerList}" />

<jsp:scriptlet>
	pageContext.setAttribute("crlf", "\r\n");
	pageContext.setAttribute("lf", "\n");
	pageContext.setAttribute("cr", "\r");
</jsp:scriptlet>

<form name="frm" method="post"  enctype="multipart/form-data" >
	<input type="hidden" name="idx" value="${info.prodCnclSeq}" />
	<input type="hidden" name="updateSkb" value="" />
	
	<input type="hidden" name="f" value="${f}" />
	<input type="hidden" name="q" value="${q}" />
	<input type="hidden" name="shCallStts" value="${callStts}" />
	<input type="hidden" name="pageIndex" value="${pageIndex}" />
	<input type="hidden" name="strtDt" value="${strtDt}" />
	<input type="hidden" name="endDt" value="${endDt}" />
	
 	<h5>고객 정보</h5>
	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>고객명</th>
				<td>${info.custName }</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${info.custHphone }</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>${info.prodNm }</td>
			</tr>
			<tr>
				<th>상담시간</th>
				<td>${info.calltime }</td>
			</tr>
			<tr>
				<th>상담신청일</th>
				<td>${info.regDtm }</td>
			</tr>
		</tbody>
	</table>

	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />			
			<col width="*" />
			<col width="15%" />
		</colgroup>
		<tbody>
			<tr>
				<th colspan="3">상담현황</th>
			</tr>
			
			<c:forEach var="list" items="${answerList}" varStatus="status">
				<tr>
					<th>${list.name}</th>
					<td>${fn:replace(fn:replace(list.cntn, ' ', '&nbsp;'), crlf, '<br />')}</td>
					<td>${list.regDtm}</td>
				</tr>
			</c:forEach>
			
			<c:if test="${fn:length(answerList) == 0}">
				<tr>
					<td class="lt_text3" colspan="3" style="text-align:center">등록된 상담현황이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th colspan="2">답변등록</th>
			</tr>
			<tr>
				<th>상담원명</th>
				<td><input type="text" name="answer" value="" class="" maxlength="20"/> </td>
			</tr>
			<tr>
				<th>상담상태</th>
				<td>
					<select name="call_stts">
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
							<option value="${cdlist.cd}">${cdlist.cdNm}</option>
						</c:forEach>					
					</select>
				</td>
			</tr>
			<tr>
				<th>상담이력</th>
				<td>
					<textarea name="cntn" style="width:99%; height:100px" maxlength="500"></textarea>
				</td>
			</tr>						
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="button" value="상담이력 등록" class="btn btn-info2" onclick="memoReg()" />
				</td>
			</tr>					
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="./list.do?f=${f}&q=${q}&callStts=${callStts}&pageIndex=${pageIndex}&strtDt=${strtDt}&endDt=${endDt}" class="btn btn-inverse">목록</a>
</div>

<script type="text/javascript">
	function memoReg()
	{
		var f = document.frm;
		
		if(f.answer.value == "")
		{
			alert("상담원명을 입력하세요.");
			f.answer.focus();
			return false;
		}
		
		if(f.cntn.value == "")
		{
			alert("상담내용을 입력해주세요.");
			f.cntn.focus();
			return false;
		}
	
		if(confirm("상담내용을 등록하시겠습니까?"))
		{
			f.action = "./update.do";
			f.submit();
		}
	}
</script>