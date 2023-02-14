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
					<th>번호</th>
					<th>상품명</th>
					<th>회원번호</th>
					<th>회원명</th>
					
					<c:choose>
						<c:when test="${rtnMap.id eq 'sktelecom' }">
						<th>채널1</th>
						<th>채널2</th>
						<th>사번</th>
						<th>가입상태</th>
						<th>가입일</th>
						<th>등록일</th>
						<th>실납입회차</th>
						<th>납입상태</th>
						<th>행사일자</th>
						</c:when>
						<c:when test="${rtnMap.id eq 'skbroadband' }">
						<th>채널1</th>
						<th>사번</th>
						<th>가입상태</th>
						<th>가입일</th>
						<th>등록일</th>
						<th>납입상태</th>
						<th>행사일자</th>
						</c:when>
						<c:otherwise>
							<c:if test="${rtnMap.id eq 'kbadmin'}">
							<th>KBNO</th>
							</c:if>
							<th>주문번호</th>
							<th>가입신청(변환일)</th>
							<th>가입완료(입금시점)</th>
							<th>최종납일일</th>
							<th>모집사원</th>
							<th>등록사원</th>
							<th>납입방법</th>				
							<th>당월회차</th>
							<th>실납입회차</th>
							<th>납입상태</th>
							<th>가입상태</th>
							<th>해피콜상태</th>				
							<th>행사일자</th>
							<th>영업형태</th>
							<th>B2B회사명</th>
							<th>B2B사원</th>
							<th>비고</th>
							<th>납입내역</th>					
						</c:otherwise>
					</c:choose>					
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
					<td style="text-align:center;">${list.prodNm}</td>
					<td style="text-align:center;">${list.accntNo}</td>
					<td style="text-align:center;">${list.memNm}</td>
					
					<c:choose>
						<c:when test="${rtnMap.id eq 'sktelecom' }">
						
					<td style="text-align:center;">${list.kbNo}</td>
					<td style="text-align:center;">${list.b2bEmpleNo}</td>
					<td style="text-align:center;">${list.idNo}</td>
					<td style="text-align:center;">${list.accStat}</td>
					<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.regDm}</td>
					<td style="text-align:center;">${list.trueCount}</td>
					<td style="text-align:center;">${list.payState}</td>
					<td style="text-align:center;">${list.eventDay}</td>
					
						
						</c:when>
						<c:when test="${rtnMap.id eq 'skbroadband' }">
						
					<td style="text-align:center;">${list.kbNo}</td>
					<td style="text-align:center;">${list.idNo}</td>
					<td style="text-align:center;">${list.accStat}</td>
					<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.regDm}</td>
					<td style="text-align:center;">${list.trueCount}</td>
					<td style="text-align:center;">${list.payState}</td>
					<td style="text-align:center;">${list.eventDay}</td>
						
						</c:when>						
						<c:otherwise>
						
					<c:if test="${rtnMap.id eq 'kbadmin'}">
					<td style="text-align:center;">${list.kbNo}</td>
					</c:if>
					
					<td style="text-align:center;">${list.orderNum}</td>
					<td style="text-align:center;">${list.regDm}</td>
					<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.payDay}</td>
					<td style="text-align:center;">${list.empleNm}</td>
					<td style="text-align:center;">${list.regMan}</td>
					<td style="text-align:center;">${list.payMthd}</td>
					<td style="text-align:center;">${list.monthCount}</td>
					<td style="text-align:center;">${list.trueCount}</td>
					<td style="text-align:center;">${list.payState}</td>
					<td style="text-align:center;">${list.accStat}</td>
					<td style="text-align:center;">${list.hpcallStat}</td>
					<td style="text-align:center;">${list.eventDay}</td>
					<td style="text-align:center;">${list.saleType}</td>
					<td style="text-align:center;">${list.b2bCompNm}</td>
					<td style="text-align:center;">${list.b2bEmpleNo}</td>
					<td style="text-align:center;">${list.accntNote}</td>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>			
			</tbody>
		</table>
	</body>
</html>