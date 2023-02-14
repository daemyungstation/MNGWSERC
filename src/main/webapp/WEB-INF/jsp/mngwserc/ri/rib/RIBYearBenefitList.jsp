<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	RIBBenefitList.jsp
	프로그램 명 : 	수당내역 목록을 조회한다.
	설명		: 	수당내역 목록을 조회하는 페이지
	작성자		: 	김필기
	작성일		:	2016.04.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.04.11				김필기				최초작성
	######################################################################
-->
<c:set var="cnt01" value="0" />
<c:set var="cnt02" value="0" />
<c:set var="cnt03" value="0" />
<c:set var="cnt04" value="0" />
<c:set var="cnt05" value="0" />
<c:set var="cnt06" value="0" />
<c:set var="cnt07" value="0" />
<c:set var="cnt08" value="0" />
<c:set var="cnt09" value="0" />
<c:set var="cnt10" value="0" />
<c:set var="cnt11" value="0" />
<c:set var="cnt12" value="0" />

<c:set var="t21_01" value="0" />
<c:set var="t21_02" value="0" />
<c:set var="t21_03" value="0" />
<c:set var="t21_04" value="0" />
<c:set var="t21_05" value="0" />
<c:set var="t21_06" value="0" />
<c:set var="t21_07" value="0" />
<c:set var="t21_08" value="0" />
<c:set var="t21_09" value="0" />
<c:set var="t21_10" value="0" />
<c:set var="t21_11" value="0" />
<c:set var="t21_12" value="0" />

<jsp:useBean id="now" class="java.util.Date" />

<fmt:formatDate var="nowYear" value="${now}" pattern="yyyy" />

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		<select name="year">
			<option value="">[년도검색]</option>
			<c:forEach var="year" begin="2011" end="${nowYear}" step="1">
				<option value="${year}" <c:if test="${rtnMap.year eq year}">selected="selected"</c:if>>${year}년</option>
			</c:forEach>
		</select>		 
		
		<a href="javascript:document.frm.submit()" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn" title="전체검색"><i class="icon-refresh"></i></a>
	</div>

	<table class="table table-bordered table-hover" id="benefitTable">
	 	<thead>
		  	<tr>	  	
			    <th width="50px">월</th>	    
			    <c:forEach var="month" begin="1" end="12" step="1">
					<th width="100px">${month}월</th>
				</c:forEach>
		  	</tr>
	 	</thead>
		<tbody>
		 	<tr>
		 		<th>인원</th>
		 		
		 		<c:forEach var="list" items="${rtnMap.list}">
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '01'}"><c:set var="cnt01" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '02'}"><c:set var="cnt02" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '03'}"><c:set var="cnt03" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '04'}"><c:set var="cnt04" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '05'}"><c:set var="cnt05" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '06'}"><c:set var="cnt06" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '07'}"><c:set var="cnt07" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '08'}"><c:set var="cnt08" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '09'}"><c:set var="cnt09" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '10'}"><c:set var="cnt10" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '11'}"><c:set var="cnt11" value="${list.cnt}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '12'}"><c:set var="cnt12" value="${list.cnt}" /></c:if>		 					 					 					 					 					 			
		 		</c:forEach>
		 		
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=1"><fmt:formatNumber value="${cnt01}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=2"><fmt:formatNumber value="${cnt02}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=3"><fmt:formatNumber value="${cnt03}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=4"><fmt:formatNumber value="${cnt04}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=5"><fmt:formatNumber value="${cnt05}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=6"><fmt:formatNumber value="${cnt06}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=7"><fmt:formatNumber value="${cnt07}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=8"><fmt:formatNumber value="${cnt08}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=9"><fmt:formatNumber value="${cnt09}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=10"><fmt:formatNumber value="${cnt10}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=11"><fmt:formatNumber value="${cnt11}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view.do?year=${rtnMap.year}&month=12"><fmt:formatNumber value="${cnt12}" type="number"/></a></td>
		 	</tr>
		 	<tr>
		 		<th>수당</th>
		 		
		 		<c:forEach var="list" items="${rtnMap.list}">
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '01'}"><c:set var="t21_01" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '02'}"><c:set var="t21_02" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '03'}"><c:set var="t21_03" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '04'}"><c:set var="t21_04" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '05'}"><c:set var="t21_05" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '06'}"><c:set var="t21_06" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '07'}"><c:set var="t21_07" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '08'}"><c:set var="t21_08" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '09'}"><c:set var="t21_09" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '10'}"><c:set var="t21_10" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '11'}"><c:set var="t21_11" value="${list.rtSumT}" /></c:if>
		 			<c:if test="${fn:substringAfter(list.alowDt, rtnMap.year) eq '12'}"><c:set var="t21_12" value="${list.rtSumT}" /></c:if>		 					 					 					 					 					 			
		 		</c:forEach>
		 		
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=1"><fmt:formatNumber value="${t21_01}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=2"><fmt:formatNumber value="${t21_02}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=3"><fmt:formatNumber value="${t21_03}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=4"><fmt:formatNumber value="${t21_04}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=5"><fmt:formatNumber value="${t21_05}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=6"><fmt:formatNumber value="${t21_06}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=7"><fmt:formatNumber value="${t21_07}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=8"><fmt:formatNumber value="${t21_08}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=9"><fmt:formatNumber value="${t21_09}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=10"><fmt:formatNumber value="${t21_10}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=11"><fmt:formatNumber value="${t21_11}" type="number"/></a></td>
				<td style="text-align:center"><a href="./view2.do?year=${rtnMap.year}&month=12"><fmt:formatNumber value="${t21_12}" type="number"/></a></td>
		 	</tr>
		</tbody>
	</table>	
</form>

<script>
$('#benefitTable').ready(function(){
	$('#benefitTable td > a').each(function(){
	    if($(this).text() == '0'){
	        $(this).parent().text('0');
	    }
	});	
});
</script>
