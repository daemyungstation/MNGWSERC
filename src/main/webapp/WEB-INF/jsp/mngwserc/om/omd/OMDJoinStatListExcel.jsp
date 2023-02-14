<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "가입현황관리";
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
	파일명 		:	OMDJoinStatListExcel.jsp
	프로그램 명 : 	가입현황관리 엑셀 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.17
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.17				김필기				최초작성
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
				<th>상품명</th>
				<th>회원번호</th>
				<th>이름</th>
				<th>가입신청(변환일)</th>
				<th>가입완료(입금시점)</th>
				<th>B2B업체</th>
				<th>B2B사원</th>
				<th>납입방법</th>
				<th>납입회차</th>
				<th>납입상태</th>
				<th>가입상태</th>
				<th>해피콜상태</th>
			</tr>
			
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
			<tr>
				<td style="text-align:center;">${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
				<td>${list.prodNm}</td>
				<td style="text-align:center;">${list.accntNo}</td>
				<td style="text-align:center;">${list.memNm}</td>
				<td style="text-align:center;">${list.regDm}</td>
				<td style="text-align:center;">${list.joinDt}</td>
				<td>${list.b2bCompNm}</td>
				<td>${list.b2bEmpleNo}</td>
				<td>${list.payMthd}</td>
				<td style="text-align:center;">${list.trueCount}</td>
				<td style="text-align:center;">${list.payState}</td>
				<td style="text-align:center;">${list.accStat}</td>
				<td style="text-align:center;">${list.hpcallStat}</td>
			</tr>
			</c:forEach>
			
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td colspan="20" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>	
		</table>
	</body>
</html>