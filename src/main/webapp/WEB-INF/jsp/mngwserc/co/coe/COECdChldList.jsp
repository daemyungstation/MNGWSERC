<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COECdChldList.jsp
	프로그램 명 : 	코드관리
	설명		: 	ChldList
	작성자		: 	김대환
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				김대환				최초작성
	######################################################################
-->
<c:forEach var="list" items="${rtnList}" varStatus="status">
	 <tr style="cursor:pointer;" class="codeTrChild" onclick="getCdDtl(this,'${status.index}');">	
		<c:if test="${emfMap.gubun eq 'last'}">
	 	<td width="*">
	 		<input type="checkbox" name="selectCode" value="${list.cd}" <c:if test="${list.linkCnt gt 0}">checked</c:if> />
	 	</td>	
	 	</c:if>	
		<td width="45%" id="cdNm${status.index}">${list.cdNm}</td>
		<td width="25%" id="cd${status.index}">${list.cd}</td>
		<td width="*" id="useYn${status.index}">${list.useYn}</td>
		<td width="*" id="cdOrd${status.index}">${list.cdOrd}</td>
	</tr>
</c:forEach>