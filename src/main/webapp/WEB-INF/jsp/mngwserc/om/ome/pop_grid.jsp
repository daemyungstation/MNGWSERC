<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<table class="table table-bordered table-hover">
	<colgroup>
		<col width="10%">
		<col width="20%">
		<col width="10%">
		<col width="20%">
		<col width="15%">
		<col width="15%">
		<col width="10%">
	</colgroup>
	<thead>
		<tr>
			<th abbr=순번 scope="col">순번</th>
			<th scope="col">회원번호</th>
			<th scope="col">회차</th>
			<th scope="col">납입일</th>
			<th scope="col">상조부금</th>
			<th scope="col">결합금액</th>
			<th scope="col">추가금</th>
		</tr>
	</thead>
	<tbody>

		<c:if test="${fn:length(rtnMap.list) == 0}">
		<tr>
			<td class="lt_text3" colspan="10" style="text-align:center">
				<fmt:message key="common.nodata.msg" />
			</td>
		</tr>
		</c:if>	
	
		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		<tr>
			<td style="text-align:center;">${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
			<td>${list.accntNo}</td>
			<td style="text-align:center">${list.no}</td>
			<td style="text-align:center">${list.payDay}</td>
			<td style="text-align:right"><fmt:formatNumber value="${list.payAmt}" type="number" />  </td>
			<td style="text-align:right"><fmt:formatNumber value="${list.apayAmt}" type="number" /> </td>
			<td style="text-align:right"><fmt:formatNumber value="${list.bpayAmt}" type="number" /> </td>								
		</tr>
		</c:forEach>

	</tbody>
</table>


<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>

