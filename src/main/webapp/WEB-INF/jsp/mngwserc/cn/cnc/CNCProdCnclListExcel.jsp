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
			<thead>
			<tr>
				<th>
					번호
				</th>
				<th style="width:120px; vertical-align:middle;">
					고객명
				</th>
				<th style="width:120px; vertical-align:middle;">
					연락처
				</th>
				<th style="width:120px; vertical-align:middle;">
					상품명
				</th>
				<c:choose>
					<c:when test="${rtnMap.id eq 'asset'}">
					</c:when>
					<c:otherwise>
						<th style="width:120px; vertical-align:middle;">
							인입 채널
						</th>
					</c:otherwise>
				</c:choose>
				<th style="width:120px; vertical-align:middle;">
					관심 가전
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담시간
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담신청일
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담자
				</th>
				<th style="width:120px; vertical-align:middle;">
					상담상태
				</th>
				<th style="width:200px; vertical-align:middle;">
					상담이력
				</th>
			</tr>
			</thead>
			<tbody>
				<c:set var="totCnt" value="${fn:length(rtnMap.list)}" />
				
				<c:choose>
					<c:when test="${totCnt eq 0}">
						<tr>
							<td class="lt_text3" colspan="20" style="text-align:center">
								<fmt:message key="common.nodata.msg" />
							</td>
						</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
						<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
						<td onclick="view('${list.prodCnclSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}')" style="text-align:center;"> ${ list.custName } </td>
						<td style="text-align:center;"> ${ list.custHphone } </td>
						<td style="text-align:center;"> ${ list.prodNm } </td>
						<c:choose>
							<c:when test="${rtnMap.id eq 'asset'}">
							</c:when>
							<c:otherwise>
								<td style="text-align:center;"> ${ list.inflowChannel }</td>
							</c:otherwise>
						</c:choose>
						<td style="text-align:center;"> ${ list.interestGoods }</td>
						<td style="text-align:center;"> ${ list.calltime } </td>
						<td style="text-align:center;"> ${ list.regDtm } </td>
						<td style="text-align:center;"> ${ list.cnslr } </td>
						<td style="text-align:center;"> ${ list.counselNm } </td>
												
						<!-- 상담이력 -->
						<td style="text-align:center;">
								${list.cntn} 
						</td>
					</tr>
					</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</body>
</html>