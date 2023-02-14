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
				<th style="width:60px; vertical-align:middle;">번호</th>
				<!-- 1구좌 상품명 -->
				<th style="width:120px; vertical-align:middle;">상품명</th>
				<!-- 고유번호 -->
				<th style="width:120px; vertical-align:middle;">고객번호</th>
				<!-- 고객 연락처(핸드폰) -->
				<th style="width:120px; vertical-align:middle;">대사값</th>
				<!-- 판매사 소속 (업체명) -->
				<th style="width:100px; vertical-align:middle;">지점</th>
				<th style="width:100px; vertical-align:middle;">사번ID<br>(유치자)</th><!--sllrNumYn-->
				<th style="width:100px; vertical-align:middle;">신청일시</th>
				<th style="width:100px; vertical-align:middle;">가입일자</th>
				<!-- 상담현황 -->
				<th style="width:100px; vertical-align:middle;">상담<br>현황</th>
				<!-- 가입상태 -->
				<th style="width:80px; vertical-align:middle;">가입<br>상태</th>
				<th style="width:100px; vertical-align:middle;">납입회차</th>
				<!-- 가입일 -->
				<th style="width:100px; vertical-align:middle;">행사일자</th>
				<!-- 대명 회원번호 -->
				<th style="width:100px; vertical-align:middle;">대명<br>회원번호</th>
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

						<td style="text-align:center;">${ totCnt - status.index}</td>
						<!-- 상품명 --><td style="text-align:center;">
						<c:choose>
						<c:when test="${list.prodCd eq 'QS'}">대명D라이프(150회)</c:when>
						<c:when test="${list.prodCd eq 'QT'}">대명D라이프(200회)</c:when>
						<c:otherwise>${list.prdctNm}</c:otherwise>
						</c:choose>
						</td>
						<!-- 고유번호 --><td style="text-align:center;">${list.cstmrUnqNum}</td>
						<!-- 고객 연락처(핸드폰) --><td style="text-align:center;">${list.hpShort}</td>
						<!-- 판매자 소속 --><td style="text-align:center;">${list.sllrPart}</td>
						<!-- 판매자 번호 --><td style="text-align:center;">${list.sllrNum}</td>
						<!-- 상담신청일 --><td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
						<!-- 가입일 --><td style="text-align:center;">${list.joinDt}</td>
						<!-- 상담현황  --><td style="text-align:center;">${list.callStts}</td >
						<!-- 가입상태 -->
						<td style="text-align:center;">
							<c:if test="${fn:length(list.accntNo) > 0 and list.trueCount == 0 and  list.accStat eq '정상'}">가입대기</c:if>
							<c:if test="${fn:length(list.accntNo) > 0 and ((list.trueCount > 0 and list.accStat eq '정상') or list.accStat ne '정상') }">${list.accStat}</c:if>
							<c:if test="${fn:length(list.accntNo) <= 0}"></c:if>
						</td>
						<!-- 납입회차 -->
						<td style="text-align:center;">
								${list.trueCount}
						</td>
						<!-- 행사날짜 -->
						<td style="text-align:center;">
							<c:if test="${list.statNo == '5'}">
								<!-- ${list.eventCompDay}	-->
								${list.resnProcDay}
							</c:if>
						</td>
						<!-- 대명 회원번호 --><td style="text-align:center;">${list.accntNo}</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		</table>
	</body>
</html>