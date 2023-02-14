<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "네이버 실검 테스트 프로모션 PV내역";
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
	<table border="1">
	 	<thead>
	  		<tr>
			    <th>구분</th>
			    <th>페이지</th>
			    <th>리퍼러</th>
			    <th>등록일</th>
			    <th>등록IP</th>
			    <th>FROMURL</th>
	  		</tr>
	 	</thead>
	 	<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="6" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>	
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
				    <td style="text-align:center;">
				    	${ list.ntevtpvType }
				    </td>
				    <td style="text-align:center;">
				    	${ list.ntevtpvPage }
				    </td>
				    <td style="text-align:center;">
				    	${ list.ntevtpvReferer }
				    </td>
				    <td style="text-align:center;">
				    	${list.ntevtpvRegDtm}
				    </td>
				    <td style="text-align:center;">
				    	${list.ntevtpvRegIp}
			    	</td>
			    	<td style="text-align:center;">
				    	${list.ntevtpvFromurl}
			    	</td>
			    	<td style="text-align:center;">
				    	${list.ntevtpvAgent}
			    	</td>
			  	</tr>
		 	</c:forEach>
			 
	 	</tbody>
	</table>
	</body>
</html>
