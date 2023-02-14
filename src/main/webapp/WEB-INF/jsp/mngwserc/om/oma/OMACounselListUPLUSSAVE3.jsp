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

<c:set var="loginMap" value="${admLgnMap}" />

<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />

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
		${opmInfMap.b2bStts eq 'ONLIFECC' ? '등록일 : ' : '신청일 : '} 
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
			<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
				<option value="7" <c:if test="${rtnMap.f eq '7'}">selected</c:if>>코드</option>
			</c:if>
			<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
				<option value="8" <c:if test="${rtnMap.f eq '8'}">selected</c:if>>CODE</option>
			</c:if>
			<c:if test="${opmInfMap.idNoYn eq 'Y'}">
				<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>${egov:decode(opmInfMap.b2bStts, 'ONLIFECC', '이지웰주문번호', '대명 가입번호')}</option>
			</c:if>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>판매채널</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>판매사원명</option>
			<option value="9" <c:if test="${rtnMap.f eq '9'}">selected</c:if>>판매사원사번</option>
			<option value="10" <c:if test="${rtnMap.f eq '10'}">selected</c:if>>판매사연락처</option>
			<option value="11" <c:if test="${rtnMap.f eq '11'}">selected</c:if>>유모비 고객 고유번호</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고객명</option>
			<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>고객 연락처(핸드폰)</option>
			<c:if test="${loginMap.id ne 'hshsawon'}">
				<option value="6" <c:if test="${rtnMap.f eq '6'}">selected</c:if>>상담자</option>
			</c:if>
		</select>
	
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		
		<select name="call_stts">
			<option value="">[상담확인선택]</option>
			<option value="no" <c:if test="${'no' eq rtnMap.callStts}">selected</c:if>>미상담</option> 
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${cdlist.cd eq rtnMap.callStts}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>					
		</select>
		
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>	
	
	<p>전체 게시물 수 : ${rtnMap.list[0].totCnt}</p>
	<table class="table table-bordered table-hover">
		<caption style="display: none;">외주업체 상담 관리</caption>
		<thead>
			<tr>
				<th style="width:80px;">번호</th>

				<!--  판매사원사번 -->
				<th style="width:120px;">판매사원사번</th>
				
				<!-- 대명 가입번호 -->
				<th style="width:120px;">유모비<br /> 고객 고유번호</th>

				<!-- 가입상태 -->
				<th style="width:100px;">가입상태</th>
				
				<!-- 가입일 -->
				<th style="width:100px;">가입일</th> 

				<!-- 상담신청일 -->
				<th style="width:100px;">상담신청일</th>

				<!-- 상담확인 -->
				<th style="width:100px;">상담확인</th>
				
				<!-- th>메모</th-->
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
						<tr>				
						
						<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>

						<!-- 판매사원 사번 -->
						<td style="text-align:center;">${list.agentEmpNum}</td>
						
						<!-- 유모비 고객 고유번호 -->
						<td style="text-align:center;">${list.cstmrUnqNum}</td>

						<!-- 가입상태 -->
						<td style="text-align:center;">${list.statNo}</td>
						
						<!-- 가입일 -->
						<td style="text-align:center;">${list.joinDt}</td>

						<!-- 상담신청일 -->
						<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
						
						<!-- 상담확인 -->
						<td style="text-align:center;"><c:if test="${loginMap.id ne 'hshdb'}">${list.callStts}</c:if></td>
						
						<!-- td style="text-align:center;">${list.memo}</td-->
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<c:choose>
		<c:when test="${loginMap.id eq 'hshdb'}">
			<a href="javascript:excelUploadPop();" class="btn btn-info2">엑셀 업로드</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:excel();" class="btn btn-info2">엑셀 다운로드</a>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="${rtnMap.paginationInfo ne null}">
<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>
</c:if>

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
	
	function excel()
	{
		var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
	
		if(!strtDt || !endDt)
		{
			alert("* 검색 기간을 입력해주세요.");
		}
		else if(strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
		}
		else
		{
			var arrStrgDt = jQuery("#strtDt").val().split("-");
			var arrEndDt = jQuery("#endDt").val().split("-");
			
			var strtDate = new Date(arrStrgDt[0], parseInt(arrStrgDt[1]) - 1, arrStrgDt[2]); 
			var endDate = new Date(arrEndDt[0], parseInt(arrEndDt[1]) - 1, arrEndDt[2]); 

			if((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 180)
			{
				alert("* 검색 기간을 6개월 이하로 입력해주세요.");
			}
			else
			{
				document.excelFrm.submit();				
			}
		}
	}
	
	function view(seq, f, q, pageIndex, callStts, strtDt, endDt, kbNo)
	{
		location.href = "./view.do?idx="+seq+"&f="+f+"&q="+q+"&pageIndex="+pageIndex+"&callStts=" + callStts + "&strtDt=" + strtDt + "&endDt=" + endDt + "&kbNo=" + kbNo;
	}
	
	// 엑셀 등록 팝업
	function excelUploadPop() 
	{
		setPopup("./excelUploadPop.do", "EXCELUPLOADPOP", 510, 310);
	}
</script>
