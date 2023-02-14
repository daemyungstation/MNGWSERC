<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMACounselList.jsp
	프로그램 명 : 	외주업체 상담관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.26
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.26				김필기				최초작성
	2016.05.20				김필기				최초작성
	######################################################################
-->

<form name="excelFrm" method="post" action="excel.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="callStts" value="${rtnMap.callStts}" />	
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
</form>

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		신청일 :
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${rtnMap.strtDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${rtnMap.endDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		
		&nbsp;&nbsp;	
		
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>고객명</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>연락처</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>상품명</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>상담사명</option>
			<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>인입채널</option>
		</select>

		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="50" />

		<select name="call_stts">
			<option value="">[상담확인선택]</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${cdlist.cd eq rtnMap.callStts}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>					
		</select>

		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>	
	
	<p>전체 게시물 수 : ${rtnMap.list[0].totCnt}</p>
	<table class="table table-bordered table-hover" style="font-size:12px;">
		<caption style="display: none;">외주업체 상담 관리</caption>
		<thead>
			<tr>
				<th style="width:60px; vertical-align:middle;">
					번호
				</th>
				<th style="width:120px; vertical-align:middle;">
					고객명
				</th>
				<th style="width:120px; vertical-align:middle;">
					연락처
				</th>
				<th style="width:120px; vertical-align:middle;">
					상품명
				</th>
				<c:choose>
					<c:when test="${rtnMap.id eq 'asset'}">
					</c:when>
					<c:otherwise>
						<th style="width:120px; vertical-align:middle;">
							인입 채널
						</th>
					</c:otherwise>
				</c:choose>
				<th style="width:120px; vertical-align:middle;">
					관심 가전
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담시간
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담신청일
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담자
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담상태
				</th>
				<th style="width:200px; vertical-align:middle;">
					상담이력
				</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="30" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
						<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
						<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.custName } </td>
						<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.custHphone } </td>
						<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.prodNm } </td>
						<c:choose>
							<c:when test="${rtnMap.id eq 'asset'}">
							</c:when>
							<c:otherwise>
								<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.inflowChannel }</td>
							</c:otherwise>
						</c:choose>		
						<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.interestGoods }</td>
						<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.calltime } </td>
						<td style="text-align:center;"> ${ list.regDtm } </td>
						<td style="text-align:center;"> ${ list.cnslr } </td>
						<td style="text-align:center;"> ${ list.counselNm } </td>
												
						<!-- 상담이력 -->
						<td style="text-align:center;">
								${list.cntn} 
						</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<c:choose>
		<c:when test="${(loginMap.id eq 'interparkdb') or (loginMap.id eq 'ezweldb')}">
			<%--	/*BLOCK_EXCEL*/		<a href="javascript:excelUploadPop();" class="btn btn-info2">엑셀 업로드</a> --%>
		</c:when>
		<c:when test="${loginMap.id eq 'jautour'}">

		</c:when>
		<c:otherwise>
			<%--	/*BLOCK_EXCEL*/					<a href="javascript:excelUploadPop();" class="btn btn-info2">엑셀 업로드</a> --%>
            <%--	/*BLOCK_EXCEL*/		<a href="javascript:excel();" class="btn btn-info2">엑셀 다운로드</a>--%>
		</c:otherwise>
	</c:choose>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>

<script type="text/javascript">
	//리스트 가져오기
	function getPageList()
	{	
		var f = document.frm;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}
		
		var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
	
		if(strtDt && endDt && strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
			return;
		}
		
		f.action = "./list.do";
		f.submit();
	}
	
	// /*BLOCK_EXCEL*/ function excel()
	// {
	// 	var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
	// 	var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
	//
	// 	if(!strtDt || !endDt)
	// 	{
	// 		alert("* 검색 기간을 입력해주세요.");
	// 	}
	// 	else if(strtDt > endDt)
	// 	{
	// 		alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
	// 	}
	// 	else
	// 	{
	// 		var arrStrgDt = jQuery("#strtDt").val().split("-");
	// 		var arrEndDt = jQuery("#endDt").val().split("-");
	//
	// 		var strtDate = new Date(arrStrgDt[0], parseInt(arrStrgDt[1]) - 1, arrStrgDt[2]);
	// 		var endDate = new Date(arrEndDt[0], parseInt(arrEndDt[1]) - 1, arrEndDt[2]);
	//
	// 		if((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 180)
	// 		{
	// 			alert("* 검색 기간을 6개월 이하로 입력해주세요.");
	// 		}
	// 		else
	// 		{
	// 			document.excelFrm.submit();
	// 		}
	// 	}
	// }
	
	function view(seq, f, q, pageIndex, callStts, strtDt, endDt)
	{
		location.href = "/mngwserc/cnc/prodCncl/view.do?idx="+seq+"&f="+f+"&q="+q+"&pageIndex="+pageIndex+"&callStts=" + callStts + "&strtDt=" + strtDt + "&endDt=" + endDt;
	}
	
	// 엑셀 등록 팝업
	function excelUploadPop() 
	{
		setPopup("./excelUploadPop.do", "EXCELUPLOADPOP", 510, 310);
	}
</script>
