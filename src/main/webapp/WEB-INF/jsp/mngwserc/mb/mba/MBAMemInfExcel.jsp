<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "회원정보";
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
					<th>성별</th>
					<th>생년월일</th>
					<th>이메일</th>
					<!-- 
					<th>CI</th>
					 -->
					<th>CI 동의</th>
					<th>마케팅</th>
					<!-- 
					<th>SMS 수신여부</th>
					<th>이메일 수신여부</th>
					 -->
					<th>최종접속일</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(excelList) eq 0}">
					<tr>
						<td class="lt_text3" colspan="10" style="text-align:center">
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
					    	${excelList.unqNo}
					    </td>
					    <td style="text-align:left;">
					    	${excelList.name}
					    </td>	    
					    <td style="text-align:left;">
					    	${excelList.id}
					    </td>	    
					    <td style="text-align:left;">
							<c:choose>
								<c:when test="${excelList.sex eq 0}">
									여
								</c:when>
								<c:when test="${excelList.sex eq 1}">
									남
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
					    </td>
					    <td style="text-align:left;">
					    	${excelList.birth}
					    </td>
					    <td style="text-align:left;">
					    	${excelList.email}
					    </td>
					    <!-- 
					    <td style="text-align:left;">
					    	${excelList.ci}
					    </td>
					     -->
					    <td style="text-align:center;">
					    	${excelList.agreementForThirdParty}
					    </td>	    
					    <td style="text-align:center;">
					    	${excelList.marketingYn}
					    </td>	    
					    <!-- 
					    <td style="text-align:left;">
					    	${excelList.smsRcvYn}
					    </td>
					    <td style="text-align:left;">
					    	${excelList.emailRcvYn}
					    </td>
					     -->
					    <td style="text-align:center;">
					    	${egov:convertDate(excelList.lastLgnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					    </td>
					    <td style="text-align:center;">
					    	${egov:convertDate(excelList.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					    </td>
				  	</tr>
				</c:forEach>
		 	</tbody>
		</table>
	</body>
</html>