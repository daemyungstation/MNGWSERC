<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMBChngRqstList.jsp
	프로그램 명 : 	전환서비스 신청 목록을 조회한다.
	설명		: 	전환서비스 신청 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.22
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.22				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="rqstSeq" value="" />
	
	<div class="well well-small">
		&nbsp;&nbsp;
		현황 : 
		<select name="prcsCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.chngPrcsStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>회원번호</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>회원명</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>사용자명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">전화서비스 신청 관리</caption>
		<thead>
			<tr>
				<th width="6%">번호</th>
				<th width="15%">상품명</th>
				<th width="10%">회원번호</th>
				<th width="13%">회원명</th>
				<th width="11%">연락처</th>
				<th width="13%">사용자명</th>
				<th width="11%">전환서비스</th>
				<th width="10%">접수일</th>
				<th width="11%">현황</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="9" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
 			<tr>
				<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
				</td>
				<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.prdctInfo.prodNm}
				</td>
				<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.accntNo}
				</td>
				<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.prdctInfo.memNm}
				</td>
				<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.prdctInfo.cell}
				</td>
				<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.userNm}
				</td>
				<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${list.prdctGb}
				</td>
				<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectChngRqstDtl('${list.rqstSeq}');">
					${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
				</td>
				<td style="text-align:center;">
					<select onchange="updatePrcsCd(this, '${list.rqstSeq}', '${list.prcsCd}');">
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.chngPrcsStts}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${list.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:selectChngRqstExcelList();" class="btn btn-info">엑셀 다운로드</a>
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
		
		f.action = "./list.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectChngRqstDtl(rqstSeq)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.rqstSeq.value = rqstSeq;
		f.submit();
	}
	
	//확인요청 내역 처리현황을 수정한다.
	function updatePrcsCd(obj, rqstSeq, prcsCd)
	{
		if(confirm("현황을 변경하시겠습니까?"))
		{
			jQuery.post("./prcs-update.ajax",
				{
					"rqstSeq" : rqstSeq, 
					"prcsCd" : jQuery(obj).val() 
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y") 
					{
						alert("변경되었습니다.");
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
		else
		{
			jQuery(obj).find("option[value='"+prcsCd+"']").prop("selected", true);
		}
	}
	
	//엑셀 다운로드
	function selectChngRqstExcelList()
	{
		var f = document.frm;
		
		f.action = "./excel.do";
		f.submit();
	}
	
</script>