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
				<th style="width:60px; vertical-align:middle;">번호</th>
				<th style="width:100px; vertical-align:middle;">대명<br /> 가입번호(idNo)</th>				
				<th style="width:100px; vertical-align:middle;">실제 판매자 이름</th>
				<th style="width:120px; vertical-align:middle;">유치대리점명</th>
				<th style="width:120px; vertical-align:middle;">실제 판매자 연락처</th>
				<th style="width:160px; vertical-align:middle;">1구좌 상품명</th>
				<th style="width:160px; vertical-align:middle;">2구좌 상품명</th>
				<th style="width:100px; vertical-align:middle;">주 계약	</th>
				<th style="width:100px; vertical-align:middle;">고객명</th>
				<th style="width:100px; vertical-align:middle;">할인 받을 연락처(CTN)</th>
				<th style="width:100px; vertical-align:middle;">U+가입번호</th>
				<th style="width:120px; vertical-align:middle;">U+서비스명</th>
				<th style="width:120px; vertical-align:middle;">U+상품번호</th>
				<th style="width:120px; vertical-align:middle;">고객 연락처(핸드폰)</th>
				<th style="width:100px; vertical-align:middle;">상담 신청일</th>
				<th style="width:100px; vertical-align:middle;">상담 확인</th>
				<th style="width:100px; vertical-align:middle;">상담자</th>
				<th style="width:200px; vertical-align:middle;">메모</th>
				<th style="width:200px; vertical-align:middle;">상담상태</th>
			</tr>
			
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
			<tr>
				<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
				<td style="text-align:center;">${list.idNo}</td>
				<td style="text-align:center;">${list.agentEmpNm}</td>
				<td style="text-align:center;">${list.uDlrNm}</td>								
				<td style="text-align:center;">${list.agentEmpTel}</td>								
				<td style="text-align:center;">${list.prdctNm}</td>								
				<td style="text-align:center;">${list.prdctNm2}</td>								
				<td style="text-align:center;">${list.mainContType}</td>							
				<td style="text-align:center;">${list.name}</td>							
				<td style="text-align:center;">${list.discountCtn}</td>
				<td style="text-align:center;">${list.homePrdNum}</td>	
				<td style="text-align:center;">${list.uProdNm}</td>	
				<td style="text-align:center;">${list.uProdNo}</td>	
				<td style="text-align:center;">${list.hp}</td>		
				<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
				<td style="text-align:center;">${list.callStts}</td>
				<td style="text-align:center;">${list.cnslDtlCntn}</td>
				<td style="text-align:center;">${list.memo}</td>
				<td style="text-align:center;">${list.targetStts}</td>
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