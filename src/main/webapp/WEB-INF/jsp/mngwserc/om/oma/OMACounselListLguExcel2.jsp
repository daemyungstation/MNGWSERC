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
					<th style="vertical-align:middle;text-align: center; width: 1%;">번호</th>
					<th style="vertical-align:middle;text-align: center; width: 6%;">가입방법</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">코드1</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">코드2</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">U+가입번호</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">대명가입번호</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">상담신청일</th>
					<th style="vertical-align:middle;text-align: center; width: 6%;">통화결과</th>
					<th style="vertical-align:middle;text-align: center; width: 6%;">회원상태</th>
					<th style="vertical-align:middle;text-align: center; width: 6%;">승인상태</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">가입일</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">납입회차</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">납입수단</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">해약(행사)일</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">주계약</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">채널유형코드명</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">유치대리점명</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">대리점/직영점 코드</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">도매직영점 판매구분</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">도매판매점 POS코드</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">도매판매점명</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">판매사명</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">상담등록자 사번</th>
					
					<!-- <th style="vertical-align:middle;text-align: center; width: 5%;">U+가입번호</th>
					<th style="vertical-align:middle;text-align: center; width: 5%;">고객명</th> -->
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
						<td style="text-align:center;">${totCnt - status.index}</td>
						<!-- 가입방법  -->
						<c:choose>
							<c:when test="${list.joinMethod eq 'fixedLine'}">
								<td style="text-align:center;">TM</td>
							</c:when>
							<c:otherwise>
								<td style="text-align:center;">전자서명</td>
							</c:otherwise>
						</c:choose>
						<!-- 코드1 -->
						<td style="text-align:center;">${list.prodNo}</td>
						<!-- 코드2 -->
						<td style="text-align:center;">${list.statNo}</td>
						<!-- U+가입번호 -->
						<td style="text-align:center;">${list.homePrdNum}</td>
						<!-- 대명가입번호 -->
						<td style="text-align:center;">${list.idNo}</td>
						<!-- 상담신청일 -->
						<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
						<!-- 통화결과 -->
						<td style="text-align:center;">${list.dpmsReslNm}</td>
						<!-- 회원상태 -->
						<td style="text-align:center;">${list.accStat}</td>
						<!-- 승인상태 -->
						<td style="text-align:center;">${list.stat}</td>
						<!-- 가입일 -->
						<td style="text-align:center;">${egov:convertDate(list.joinDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
						<!-- 납입회차 -->
						<td style="text-align:center;">${list.trueCount}</td>
						<!-- 납입수단 -->
						<td style="text-align:center;">${list.payMthd}</td>
						<!-- 해약(행사)일 -->
						<td style="text-align:center;">
							<c:if test='${list.statNo eq "5"}'>
								${list.resnProcDay}
							</c:if>
							<c:if test='${list.statNo eq "6"}'>
								${list.eventProcDay}
							</c:if>
						</td>
						<!-- 주계약 -->
						<td style="text-align:center;">${list.mainContType}</td>
						<!-- 채널유형코드명 -->
						<td style="text-align:center;">${list.uCmmnCdNm}</td>
						<!-- 유치대리점명 -->
						<td style="text-align:center;">${list.uDlrNm}</td>
						<!-- 대리점/직영점 코드 -->
						<td style="text-align:center;">${list.uDlrCd}</td>
						<!-- 도매직영점 판매구분 -->
						<td style="text-align:center;">${list.salesType}</td>
						<!-- 도매판매점 POS코드 -->
						<td style="text-align:center;">${list.whPosCd}</td>
						<!-- 도매판매점명 -->
						<td style="text-align:center;">${list.whStoreNm}</td>
						<!-- 판매사명 -->
						<td style="text-align:center;">${list.agentEmpNm}</td>
						<!-- 상담등록자 사번 -->
						<td style="text-align:center;">${list.uIndcEmpno}</td>
						
						
						
						
						<%-- 
						<!-- 고객명 -->
						<td style="text-align:center;">${list.name}</td> --%>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		</table>
	</body>
</html>