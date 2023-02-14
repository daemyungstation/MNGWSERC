<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String fileName = "대명아임레디 박람회 상담 내역";
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
		<style> 
		td { mso-number-format:"\@"; }
		br { mso-data-placement:same-cell; }
		</style>
	</head>
	<body>
	<table border="1">
	 	<thead>
	  		<tr>
			    <th>카테고리</th>
			    <th>상품</th>
			    <c:forEach var="titleTd" items="${rtnMap.titleTd}">
		   		<th>${titleTd}</th>
		   		</c:forEach>
			    <th>선택상품</th>
			    <th>가격</th>
			    <th>등록일</th>
			    <th>유입경로</th>
			    <th>상담차수</th>
			    <th>상담상태</th>
			    <th>메모이력</th>
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
				   	<td>${list.fcTitle}</td>
				    <td>${list.fpMainTitle}</td>
				    <c:forEach var="titleTd" items="${rtnMap.titleTd}">
				   	<td class="input">
				   		<c:forEach var="input" items="${list.input}">
				   			<c:if test="${titleTd == input.title}">
				   				${input.value}
				   			</c:if>
				   		</c:forEach>
				   	</td>
				   	</c:forEach>
				   	<td>
				   		<c:if test="${list.benefit.fbTitle ne ''}">
				   			[${list.benefit.fbTitle}]${list.benefit.fbSubtitle}-${list.benefit.fbModel}
				   		</c:if>
				   	</td>
				   	<td>${list.price}</td>
				    <td>${list.fupRegdate}</td>
				    <td>${list.fupFromurl}</td>
				    <td>${list.fupcStatusNumber}</td>
				    <td>${list.fupcStatus}</td>
				    <td>
				    	<c:forEach var="mList" items="${list.memoList.list}">
				    	${mList.fupcStatusNumber} - ${mList.fupcStatus} - ${mList.fupcMemo} - ${mList.regDtm}<br>
				    	</c:forEach>
				    </td>
			  	</tr>
		 	</c:forEach>
	 	</tbody>
	</table>
	</body>
</html>
