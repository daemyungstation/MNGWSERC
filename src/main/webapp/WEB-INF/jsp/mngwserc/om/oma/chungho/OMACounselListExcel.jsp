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
			<caption style="display: none;">외주업체 상담 관리</caption>
			<thead>
			<tr>
				<c:choose>
				<c:when test="${loginMap.id eq 'chungho'}">

				<th style="width:60px; vertical-align:middle;">번호</th>
				<th style="width:100px; vertical-align:middle;">고객명</th>
				<th style="width:100px; vertical-align:middle;">고객 연락처</th>
				<th style="width:100px; vertical-align:middle;">제휴상품1</th>
				<th style="width:100px; vertical-align:middle;">제휴상품2</th>
				<th style="width:100px; vertical-align:middle;">영업담당자 명</th>
				<th style="width:100px; vertical-align:middle;">상담 신청일</th>
				<th style="width:100px; vertical-align:middle;">상담 현황</th>
				<th style="width:100px; vertical-align:middle;">상담자</th>
				<th style="width:100px; vertical-align:middle;">메모</th>

				</c:when>
				<c:otherwise>

				<th style="width:60px; vertical-align:middle;">번호</th>
				<th style="width:60px; vertical-align:middle;">영업담당자 명</th>
				<th style="width:100px; vertical-align:middle;">영업담당자 소속</th>
				<th style="width:100px; vertical-align:middle;">영업담당자 사번</th>
				<th style="width:100px; vertical-align:middle;">고객명</th>
				<th style="width:100px; vertical-align:middle;">계약 번호</th>
				<th style="width:100px; vertical-align:middle;">가입상태</th>
				<th style="width:100px; vertical-align:middle;">가입일</th>
				<th style="width:100px; vertical-align:middle;">제휴상품1</th>
				<th style="width:100px; vertical-align:middle;">제휴상품2</th>
				<th style="width:100px; vertical-align:middle;">제품군</th>
				<th style="width:100px; vertical-align:middle;">제품 모델명</th>
				<th style="width:100px; vertical-align:middle;">상담 신청일</th>
				<th style="width:100px; vertical-align:middle;">상담 현황</th>

				</c:otherwise>
				</c:choose>

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

							<c:choose>
								<c:when test="${loginMap.id eq 'chungho'}">
									<td style="text-align:center;">${totCnt - status.index}</td>
									<td style="text-align:center;">${list.name}</td>
									<td style="text-align:center;">${list.hp}</td>
									<td style="text-align:center;">${list.prdctNm}</td>
									<td style="text-align:center;">${list.prdctNm2}</td>
									<td style="text-align:center;">${list.b2bEmpCd}</td>
									<td style="text-align:center;">${list.regDtm}</td>
									<td style="text-align:center;">${list.callStts}</td>
									<td style="text-align:center;">${list.cnslr}</td>
									<td style="text-align:center;">${list.memo}</td>
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">${totCnt - status.index}</td>
									<td style="text-align:center;">${list.b2bEmpCd}</td>
									<td style="text-align:center;">${list.sllrPart}</td>
									<td style="text-align:center;">${list.agentEmpNum}</td>
									<td style="text-align:center;">${list.name}</td>
									<td style="text-align:center;">${list.contractNo}</td>
									<td style="text-align:center;">
										<c:choose>
											<c:when test="${list.statNo eq 1}">보류</c:when>
											<c:when test="${list.statNo eq 2}">접수</c:when>
											<c:when test="${list.statNo eq 3}">완료</c:when>
											<c:when test="${list.statNo eq 4}">청약철회</c:when>
											<c:when test="${list.statNo eq 5}">해약</c:when>
											<c:when test="${list.statNo eq 6}">행사</c:when>
										</c:choose>
									</td>
									<td style="text-align:center;">${list.joinDt}</td>
									<td style="text-align:center;">${list.prdctNm}</td>
									<td style="text-align:center;">${list.prdctNm2}</td>
									<td style="text-align:center;">${list.productNm}</td>
									<td style="text-align:center;">${list.serialNo}</td>
									<td style="text-align:center;">${list.regDtm}</td>
									<td style="text-align:center;">${list.callStts}</td>
								</c:otherwise>
							</c:choose>

						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</body>
</html>