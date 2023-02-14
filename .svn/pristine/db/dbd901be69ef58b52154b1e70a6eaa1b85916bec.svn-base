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
<form name="frm" action ="${pageLink}" method="post"  >
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

	<h4>${rtnMap.year}년 ${rtnMap.month}월</h4>
	<table class="table table-bordered table-hover" style="width:1000px">
		<colgroup>
			<col width="12%" />
			<col width="15%" />
			<col width="*" />
		</colgroup>
	 	<tbody>
	 		<c:forEach var="info" items="${rtnMap.list}">
		  	<tr>	  	
			    <th rowspan="3" style="vertical-align:middle">수당</th>
			    <th>모집수당</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.t21}" /></td>
			</tr>
			<tr>
			    <th>누진수당</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.t32}" /></td>
			</tr>
			<tr>
			    <th>B2B수당</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.t33}" /></td>
		  	</tr>
		  	<tr>
		  		<th colspan="2">수당계</th>
		  		<td style="text-align:right; color:red">
		  			<fmt:formatNumber value="${info.rtSumT}" />
		  		</td>
		  	</tr>
		  	
		  	<tr>	  	
			    <th rowspan="2" style="vertical-align:middle">공제</th>
			    <th>소득세</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.f5}" /></td>
			</tr>
			<tr>
			    <th>주민세</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.f6}" /></td>
			</tr>
		  	<tr>
		  		<th colspan="2">공제계</th>
		  		<td style="text-align:right; color:blue">
					<c:set var="sum2" value="${info.f5 + info.f6}" />
		  			<fmt:formatNumber value="${sum2}" />		  		
		  		</td>
		  	</tr>
		  	
		  	<tr>	  	
			    <th rowspan="2" style="vertical-align:middle">환수</th>
			    <th>모집환수</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.f7}" /></td>
			</tr>
			<tr>
			    <th>누진환수</th>
			    <td style="text-align:right;"><fmt:formatNumber value="${info.f11}" /></td>
			</tr>
		  	<tr>
		  		<th colspan="2">환수계</th>
		  		<td style="text-align:right; color:blue"><fmt:formatNumber value="${info.rtSumF}" /></td>
		  	</tr>
		  	<tr>
		  		<th colspan="2">실지급액(수당계 - (공제계+환수액))</th>
		  		<td style="text-align:right;"><fmt:formatNumber value="${info.totAlowAmt}" /></td>
		  	</tr>		
		  	</c:forEach>  	
	 	</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="./index.do?year=${rtnMap.year}" class="btn btn-default">목록</a>
</div>