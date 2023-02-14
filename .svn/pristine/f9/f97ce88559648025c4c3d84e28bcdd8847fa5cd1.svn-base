<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "공연예약";
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
				    <th width="10%">접수일자</th>
				    <th width="12%">회원번호</th>
				    <th width="14%">회원명</th>
				    <th width="12%">예약일1순위</th>
				    <th width="12%">예약일2순위</th>
				    <th width="5%">관람인원</th>
				    <th width="5%">관람좌석</th>
				    <th width="20%">요청사항</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(excelList) eq 0}">
						<tr>
							<td class="lt_text3" colspan="8" style="text-align:center">
								<fmt:message key="common.nodata.msg" />
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="excelList" items="${excelList}" varStatus="status">
							<c:choose>
								<c:when test="${excelList.prcsCd eq '00' and (excelList.confYn1 eq 'N' or excelList.confYn2 eq 'N')}">
									<tr style="background-color:#FF7171;">
								</c:when>
								<c:otherwise>
									<tr>
								</c:otherwise>
							</c:choose>
								<td style="text-align:center;">
									${egov:convertDate(excelList.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
								</td>
								<td style="text-align:center;">
									${excelList.accntNo}
								</td>
								<td style="text-align:center;">
							    	${excelList.name}
							    </td>
								<td style="text-align:center;">
									${egov:convertDate(excelList.fstRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy년 MM월 dd일(EE) HH시 mm분', '')}
								</td>
								<td style="text-align:center;">
									${egov:convertDate(excelList.secnRsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy년 MM월 dd일(EE) HH시 mm분', '')}
								</td>
								<td style="text-align:center;">
									${excelList.seatCnt}명
								</td>
								<td style="text-align:center;">
									${excelList.seatGb}석
								</td>
								<td style="text-align:center;">
									${excelList.reqn}
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</body>
</html>