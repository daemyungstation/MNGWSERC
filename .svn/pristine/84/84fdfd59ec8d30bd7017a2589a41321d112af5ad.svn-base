<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "입금관리";
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
	파일명 		:	OMCDepositExcel.jsp
	프로그램 명 : 	입금관리 엑셀 목록
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
		
		<table border="1">
			<tr>
				<th>번호</th>
				<th>회원번호</th>
				<th>B2B회사명</th>
				<th>휴대전화</th>
				<th>전화번호</th>
				<th>결합금</th>
				<th>회원명</th>
				<c:if test="${loginMap.id ne 'lgupay'}">
				<th>생년월일</th>
				</c:if>
				<th>가입일</th>
				<th>최초가입일</th>
				<th>가입상품</th>
				<th>모델분류</th>
				<th>당월회차</th>
				<th>실납입회차</th>
				<th>회분</th>
				<th>납입방법</th>
				<th>가입상태</th>
				<th>IDNO</th>
				<th>B2B사원코드</th>
				<c:if test="${loginMap.id ne 'lgupay'}">
					<th>설치주소</th>
				</c:if>
				<th>KB NO</th>
				<th>주문번호</th>
				<th>U+가입번호</th>
				<th>행사일자</th>
			</tr>
			
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
			<tr>
				<td style="text-align:center;">${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
				<td>${list.accntNo}</td>
				<td>${list.b2bCompNm}</td>
				<td>${list.cell}</td>
				<td>${list.insplPhone}</td>
				<td>${list.apayAmt}</td>
				<td>${list.memNm}</td>
				<c:if test="${loginMap.id ne 'lgupay'}">
					<c:if test="${!empty list.brthMonDay}">
					<td>${egov:convertDate(list.brthMonDay, 'yyyy-MM-dd', 'yyyy-MM-dd', '')}</td>
					</c:if>
					<c:if test="${empty list.brthMonDay}">
					<td></td>
					</c:if>
				</c:if>
				<td>${list.joinDt}</td>
				<td>${list.regDm}</td>
				<td>${list.prodNm}</td>
				<td>${list.modelClNm}</td>
				<td>${list.mouthCount}</td>
				<td>${list.trueCount}</td>
				<td>${list.no}</td>
				<td>${list.payState}</td>
				<td>${list.accStat}</td>
				<td>${list.idNo}</td>
				<td>${list.b2bEmpleNo}</td>
				<c:if test="${loginMap.id ne 'lgupay'}">
					<td>${list.insplAddr2}</td>
				</c:if>
				<td>${list.kbNo}</td>
				<td>${list.orderNum}</td>
				<td>${list.homeno}</td>
				<td>${list.eventDay}</td>
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