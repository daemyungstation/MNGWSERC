<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "상품약관그룹_변경이력";
	String userAgent = request.getHeader("User-Agent");
	
	if (userAgent != null && userAgent.indexOf("MSIE 5.5") > -1)
	{ 
		// MS IE 5.5 이하
	    response.setHeader("Content-Disposition", "filename=" + URLEncoder.encode(fileName, "UTF-8") + ";");
	} 
	else 
	{
	    if (userAgent != null && userAgent.toLowerCase().indexOf("firefox") > -1) 
	    {                            
	    	fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	    } 
	    else 
	    {
	    	fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
	    }
	    response.setHeader("Content-Disposition","attachment; filename="+fileName+".xls");
	}

	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setContentType("application/vnd.ms-excel");
%>
<!-- 
	######################################################################
	파일명 		:	CMETermsGroupList.jsp
	프로그램 명 : 	상품 약관그룹관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.17
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.17				김필기				최초작성
	######################################################################
-->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>excel</title>
		<style> td { mso-number-format:"\@"; } </style>
	</head>
	<body>
		
		<table border="1">
			<colgroup>
				<col width="10%" />
				<col width="15%" />
				<col width="15%" />
				<c:forEach var="cdlist" items="${excelList.cdDtlList.trsGb}" varStatus="status">
				<col width="*" />
				</c:forEach>
				<c:forEach var="cdlist" items="${excelList.cdDtlList.contractGb}" varStatus="status">
				<col width="*" />
				</c:forEach>				
			</colgroup>
			<tr>
				<th>코드</th>
				<th>상품명</th>
				<th>적용일</th>		
				<c:forEach var="cdlist" items="${excelList.cdDtlList.trsGb}" varStatus="status">
					<th>${cdlist.cdNm} 약관</th>
				</c:forEach>
				<c:forEach var="cdlist" items="${excelList.cdDtlList.contractGb}" varStatus="status">
					<th>${cdlist.cdNm} 계약안내</th>
				</c:forEach>				
			</tr>
			
			<c:forEach var="list" items="${excelList.list}" varStatus="status">
				<c:set var="yns" value="${fn:split(list.yns,',')}" />
			<tr>
			
				<td>${list.prdctCd}</td>
				<td>${list.prdctNm}</td>
				<td style="text-align:center">			
					<c:if test="${list.modDtm != ''}">${fn:substring(list.modDtm, 0, 10)}</c:if>
					<c:if test="${list.modDtm == '' || list.modDtm eq null}">미적용</c:if>
				</td>
				
				<c:forEach var="yn" items="${yns}" varStatus="status">		
				<td style="text-align:center">${yn}</td>
				</c:forEach>
			</tr>
			</c:forEach>
			
			<c:if test="${fn:length(excelList.list) == 0}">
				<tr>
					<td colspan="11" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>	
		</table>
	</body>
</html>