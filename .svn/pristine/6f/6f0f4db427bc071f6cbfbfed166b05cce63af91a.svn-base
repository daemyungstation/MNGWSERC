<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "상담관리";
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
	파일명 		:	OMACounselListMainExcel.jsp
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
		<c:set var="loginMap" value="${admLgnMap}" />

		<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />
	
		<table border="1">
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
			</tr>
		</thead>
			<tbody>
				<c:set var="totCnt" value="${fn:length(rtnMap.list)}" />
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
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</body>
</html>