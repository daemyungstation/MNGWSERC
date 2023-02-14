<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	RIBYearBenefitInf.jsp
	프로그램 명 : 	수당내역 상세정보를 조회한다.
	설명		: 	수당내역 상세정보를 조회하는 페이지
	작성자		: 	김필기
	작성일		:	2016.04.25
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.04.25				김필기				최초작성
	######################################################################
-->
<form name="frm" action ="/mngwsercgateway/allowance/benefit/year/view.do" method="get"  >
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="year" value="${rtnMap.year}" />
	<input type="hidden" name="month" value="${rtnMap.month}" />

	<table class="table table-bordered table-hover">
	 	<thead>
		  	<tr>	  	
			    <th width="50px">순번</th>	    
			    <th width="120px">회원번호</th>
			    <th width="110px">회원명</th>
			    <th width="*">상품명</th>
			    <th width="120px">가입일자</th>
			    <th width="100px">총납입회차</th>
			    <th width="120px">납일일</th>
			    
			    <th width="120px">발생수당</th>
			    <th width="120px">환수</th>
			    <th width="120px">실지급(세전)</th>
			    
		  	</tr>
	 	</thead>
		<tbody>
		 	<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
		 	
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="27" style="text-align:left;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
		   			<td style="text-align:center;">		   				
		   				${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
		   			</td>
		   			<td style="text-align:center;">${list.accntNo}</td>
		   			<td style="text-align:center;" >${list.memNm}</td>
		   			<td>${list.prodNm}</td>
		   			<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.daPayNo}</td>
					<td style="text-align:center;">${egov:convertDate(list.payDay, 'yyyy-MM-dd HH:mm:ss', 'yyyy/MM/dd', '')}</td>
					
					<td style="text-align:center;"><fmt:formatNumber value="${list.t21 + list.t32}" type="number" maxFractionDigits="0" /></td>
					
					<td style="text-align:center;"><fmt:formatNumber value="${list.f7 + list.f11}" /></td>
					<td style="text-align:center;"><fmt:formatNumber value="${list.rtAlowAmt}" /></td>
		  		</tr>
		 	</c:forEach>
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="./index.do?year=${rtnMap.year}" class="btn btn-default">목록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<script type="text/javascript">
 
//페이지번호 클릭시
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
	f.submit();
}	

</script>
