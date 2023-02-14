<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "전환서비스 신청";
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>excel</title>
		<style> td { mso-number-format:"\@"; } </style>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<!-- <th width="6%">번호</th> -->
					<th>신청일</th>
				    <th>회원번호</th>
				    <th>회원명</th>
				    <th>연락처</th>
				    <th>상품코드</th>
				    <th>회원과의 관계</th>
				    <th>사용자명</th>
				    <th>사용자 연락처</th>
				    <th>납입회차</th>
				    <th>출금일</th>
				    <th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(excelList) eq 0}">
					<tr>
						<td class="lt_text3" colspan="11" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:if>
				<c:forEach var="excelList" items="${excelList}" varStatus="status">
					<tr>
						<%-- 
					    <td style="text-align:center;">
					    	${excelList.totCnt - status.count + 1}
					    </td>
					    --%>
					    <td style="text-align:center;">
							${egov:convertDate(excelList.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
						</td>
						<td style="text-align:center;">
							${excelList.prdctInfo.accntNo}
						</td>
						<td style="text-align:center;">
							${excelList.prdctInfo.memNm}
						</td>
						<td style="text-align:center;">
							${excelList.prdctInfo.cell}
						</td>
						<td style="text-align:center;">
							${excelList.prdctInfo.prodCd}
						</td>
						<td style="text-align:center;">
							${excelList.userRelGb}
						</td>
						<td style="text-align:center;">
							${excelList.userNm}
						</td>
						<td style="text-align:center;">
							${excelList.userCtel}
						</td>
						<td style="text-align:center;">
							${excelList.prdctInfo.trueCnt}
						</td>
						<td style="text-align:center;">
							<c:choose>
								<c:when test="${not empty excelList.prdctInfo.cmsPayDt}">
									${excelList.prdctInfo.cmsPayDt}
								</c:when>
								<c:when test="${not empty excelList.prdctInfo.cardPayDt}">
									${excelList.prdctInfo.cardPayDt}
								</c:when>
								<c:otherwise>

								</c:otherwise>
							</c:choose>
						</td>
					    <td style="text-align:center;">
							${egov:convertDate(excelList.prdctInfo.joinDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>