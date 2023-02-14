<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "회원정보 변경로그";
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
					<th>고유번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>구분</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>휴대번호</th>
					<th>주소</th>
					<th>SMS 수신여부</th>
					<th>전화 수신여부</th>
					<th>카탈로그 수신여부</th>
					<th>이메일 수신여부</th>
					<th>접수일</th>
					<th>완료일</th>
					<th>현황</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(excelList) eq 0}">
					<tr>
						<td class="lt_text3" colspan="16" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:if>
				<c:choose>
					<c:when test="${type eq 'rowData'}">
						<c:forEach var="excelList" items="${excelList}" varStatus="status">
						  	<tr>
						  		<%-- 
							    <td style="text-align:center;">
							    	${excelList.totCnt - status.count + 1}
							    </td>
							    --%>
							    <td style="text-align:center;">
							    	${excelList.unqNo}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.name}
							    </td>	    
							    <td style="text-align:left;">
							    	${excelList.id}
							    </td>
								<td style="text-align:left;">
							    	변경후
							    </td>	   
								<td style="text-align:left;">
							    	${excelList.aftName}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.aftEmail}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.aftTel}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.aftHp}
							    </td>
							    <td style="text-align:left;">
							    	(${excelList.aftZipcd})&nbsp;${excelList.aftAdr}&nbsp;${excelList.aftAdrDtl}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.smsRcvYn}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.telRcvYn}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.ctlgRcvYn}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.emailRcvYn}
							    </td>
							    <td style="text-align:center;">
							    	${egov:convertDate(excelList.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							    </td>
							    <td style="text-align:center;">
							    	${egov:decode(excelList.prcsYn, 'Y', egov:convertDate(excelList.modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '')}
							    </td>
							    <td style="text-align:center;">
							    	${egov:decode(excelList.prcsYn, 'Y', '완료', '대기')}
							    </td>
						  	</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="excelList" items="${excelList}" varStatus="status">
						  	<tr>
						  		<%-- 
							    <td style="text-align:center;">
							    	${excelList.totCnt - status.count + 1}
							    </td>
							    --%>
							    <td rowspan="2" style="text-align:center;">
							    	${excelList.unqNo}
							    </td>
							    <td rowspan="2" style="text-align:left;">
							    	${excelList.name}
							    </td>	    
							    <td rowspan="2" style="text-align:left;">
							    	${excelList.id}
							    </td>
							    <td style="text-align:left;">
							    	변경전
							    </td>	   
								<td style="text-align:left;">
							    	${excelList.bfrName}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.bfrEmail}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.bfrTel}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.bfrHp}
							    </td>
							    <td style="text-align:left;">
							    	(${excelList.bfrZipcd})&nbsp;${excelList.bfrAdr}&nbsp;${excelList.bfrAdrDtl}
							    </td>
							    <td rowspan="2" style="text-align:left;">
							    	${excelList.smsRcvYn}
							    </td>
							    <td rowspan="2" style="text-align:left;">
							    	${excelList.telRcvYn}
							    </td>
							    <td rowspan="2" style="text-align:left;">
							    	${excelList.ctlgRcvYn}
							    </td>
							    <td rowspan="2" style="text-align:left;">
							    	${excelList.emailRcvYn}
							    </td>
							    <td rowspan="2" style="text-align:center;">
							    	${egov:convertDate(excelList.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							    </td>
							    <td rowspan="2" style="text-align:center;">
							    	${egov:decode(excelList.prcsYn, 'Y', egov:convertDate(excelList.modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '')}
							    </td>
							    <td rowspan="2" style="text-align:center;">
							    	${egov:decode(excelList.prcsYn, 'Y', '완료', '대기')}
							    </td>
						  	</tr>
						  	<tr>
								<td style="text-align:left;">
							    	변경후
							    </td>	  
							    <td style="text-align:left;">
							    	${excelList.aftName}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.aftEmail}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.aftTel}
							    </td>
							    <td style="text-align:left;">
							    	${excelList.aftHp}
							    </td>
							    <td style="text-align:left;">
							    	(${excelList.aftZipcd})&nbsp;${excelList.aftAdr}&nbsp;${excelList.aftAdrDtl}
							    </td>
						  	</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		 	</tbody>
		</table>
	</body>
</html>