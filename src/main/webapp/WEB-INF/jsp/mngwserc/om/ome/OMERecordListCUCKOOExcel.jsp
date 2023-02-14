<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "실적관리";
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
	파일명 		:	OMERecordListExcel.jsp
	프로그램 명 : 	실적관리 엑셀 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.18
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.18				김필기				최초작성
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
		
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="text-align: center">No.</th>
					<th style="text-align: center">회원명</th>
					<th style="text-align: center">휴대전화</th>
					<th style="text-align: center">가입상품</th>
					<th style="text-align: center">등록일자</th>
					<th style="text-align: center">가입일자</th>
					<th style="text-align: center">가입상태</th>
					<th style="text-align: center">수당</th>
				</tr>
			</thead>
			<tbody style="font-size: 12px">
				<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
				<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="20" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
				</c:if>
	
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>

					<td>${list.memNm}</td>
					<td>${list.cell}</td>
					<td>${list.prodNm}</td>
					<td>${list.regDm}</td>
					<td>${egov:convertDate(list.joinDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}</td>
					<td>${list.accStat}</td>
					<td>${list.ccAlow}</td>
					<td>
						<c:if test="${list.accStat ne '해약'}">
							<c:set var="sum" value="${sum + (list.ccAlow eq null ? 0 : list.ccAlow)}" />
						</c:if>
						<fmt:formatNumber value="${(list.ccAlow eq null) ? 0 : list.ccAlow}" type="currency" />
					</td>
				</tr>
				</c:forEach>			
			</tbody>
		</table>
	</body>
</html>