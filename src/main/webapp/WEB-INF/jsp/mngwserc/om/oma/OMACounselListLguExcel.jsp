<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "상담관리(LGU+)";
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
	파일명 		:	OMACounselListLguExcel.jsp
	프로그램 명 : 	온라인 상담관리 엑셀 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.29
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.29				김필기				최초작성
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
			<tr>
				<th>번호</th>
				<th>ID_NO</th>				
				<th>코드1</th>
				<th>코드2</th>
			</tr>
			
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
			<tr>
				<td>${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
				<td>${list.idNo}</td>
				<td>${list.prodNo}</td>
				<td>${list.statNo}</td>								
			</tr>
			</c:forEach>
			
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td colspan="4" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>	
		</table>
	</body>
</html>