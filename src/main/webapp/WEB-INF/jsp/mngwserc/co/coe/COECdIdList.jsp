<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COECdIdList.jsp
	프로그램 명 : 	코드관리
	설명		: 	IdList
	작성자		: 	김대환
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				김대환				최초작성
	######################################################################
-->
<c:forEach var="list" items="${rtnList}" varStatus="status">
	<tr style="cursor:pointer;" class="cdTrOne" onclick="getCdDtlList(this,'${status.index}', '${list.cdId}');">
		<td width="10%" align="center">${status.count}</td>
		<td width="60%" align="center" id="cdIdNm${status.index}">${list.cdIdNm}</td>
		<td width="30%" align="center" id="cdId${status.index}">${list.cdId}</td>
	</tr>
</c:forEach>