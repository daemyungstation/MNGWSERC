<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "약관내용";
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
		<c:set var="info" value="${rtnMap.termsInfo}" />
	
		<table border="1">
			<tbody>
				<tr>
					<th>구분</th>
					<td>${info.cdNm}</td>				
				</tr>
				<tr>
					<th>적용시점</th>
					<td>${egov:convertDate(info.applyDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
				</tr>
				<tr>
					<th>약관명</th>
					<td>${info.title}</td>
				</tr>
				
				<tr>
					<th colspan="2">내용</th>
				</tr>
				<tr>
					<td colspan="2" >
										
					<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
						<div class="level1" style="margin-bottom:5px">
							<h5 style="color:green">${list.cntn}</h5>
					
							<div class="level level2">
								<c:if test="${list.level2List ne null}">
									<c:forEach var="list2" items="${list.level2List}" varStatus="status">
									<div style="margin: 1px 0; ">
										<c:choose>
											<c:when test="${list2.level3List ne null}">
											<p style="white-space: pre-wrap; font-weight:bold">${list2.cntn }</p>	
											</c:when>
											<c:otherwise>
											<p style="white-space: pre-wrap;">${list2.cntn }</p>
											</c:otherwise>
										</c:choose>	
					
										<div class="level level3">
											<c:if test="${list2.level3List ne null}">
												<c:forEach var="list3" items="${list2.level3List}" varStatus="status">
												
												<div style="margin: 1px 0; " >
													<p style="white-space: pre-wrap;">${list3.cntn }</p>
												</div>
																			
												</c:forEach>
											</c:if>
										</div>			
									</div>						
									</c:forEach>			
								</c:if>
							</div>	
						</div>
						</c:forEach>					
										
					</td>				
				</tr>
			</tbody>		
		</table>
	</body>
</html>	