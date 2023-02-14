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
	파일명 		:	OMACounselListSmartExcel.jsp
	프로그램 명 : 	외주업체 상담관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.04.15
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.04.15				김필기				최초작성
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

		<table border="1">
			<caption style="display: none;">외주업체 상담 관리</caption>
			<thead>
				<tr>
					<th>번호</th>
					<th>판매사명</th>
					<th>사번</th>
					<th>매장코드</th>
					<th>매장코드2</th>
					<th>고객명</th>
					<th>연락처</th>
					<th>상품명</th>
					<th>상담신청일</th>
					<th>상담확인</th>
					<th>상담자</th>
					<th>MEMO</th>
					<th>연락처2</th>
				</tr>
			</thead>
			<tbody>
				<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
				<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="13" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
				</c:if>
							
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
					
					<c:choose>
						<c:when test="${rtnMap.loginId eq 'smartlife' }">
						<td style="text-align:center;">${list.code2}</td>
						<td>&nbsp;</td>
						<td style="text-align:center;">${list.code3}</td>
						<td>&nbsp;</td>
						<td style="text-align:center;">${list.name}</td>
						<td style="text-align:center;">${list.hp}</td>
						<td style="text-align:center;">${list.prdctNm}</td>
						<td style="text-align:center;">${list.regDtm}</td>
						<td style="text-align:center;">${list.callStts}</td>
						<td style="text-align:center;">${list.cnslr}</td>
						<td style="text-align:center;">${list.memo}</td>
						<td>&nbsp;</td>
						</c:when>
						
						<c:when test="${rtnMap.loginId eq 'daekyo' }">
						<td>&nbsp;</td>
						<td style="text-align:center;">${list.code2}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td style="text-align:center;"><a href="./view.do?idx=${list.oscCnslSeq}&f=${rtnMap.f}&q=${rtnMap.q}">${list.name}</a></td>
						<td style="text-align:center;">${list.hp}</td>
						<td style="text-align:center;">${list.prdctNm}</td>
						<td style="text-align:center;">${list.regDtm}</td>
						<td style="text-align:center;">${list.callStts}</td>
						<td style="text-align:center;">${list.cnslr}</td>
						<td style="text-align:center;">${list.memo}</td>
						<td>&nbsp;</td>
						
						</c:when>
						
						<c:when test="${rtnMap.loginId eq 'tlife' }">
						<td>&nbsp;</td>
						<td style="text-align:center;">${list.code2}</td>
						<td style="text-align:center;">${list.code1}</td>
						<td style="text-align:center;">${list.code3}</td>
						<td style="text-align:center;"><a href="./view.do?idx=${list.oscCnslSeq}&f=${rtnMap.f}&q=${rtnMap.q}">${list.name}</a></td>
						<td style="text-align:center;">${list.hp}</td>
						<td style="text-align:center;">${list.prdctNm}</td>
						<td style="text-align:center;">${list.regDtm}</td>
						<td style="text-align:center;">${list.callStts}</td>
						<td style="text-align:center;">${list.cnslr}</td>
						<td style="text-align:center;">${list.memo}</td>
						<td style="text-align:center;">${list.agentEmpTel}</td>					
						</c:when>
						
						<c:otherwise>
						<td>&nbsp;</td>
						<td style="text-align:center;">${list.code2}</td>
						<td style="text-align:center;">${list.code1}</td>
						<td>&nbsp;</td>
						<td style="text-align:center;">${list.name}</td>
						<td style="text-align:center;">${list.hp}</td>
						<td style="text-align:center;">${list.prdctNm}</td>
						<td style="text-align:center;">${list.regDtm}</td>
						<td style="text-align:center;">${list.callStts}</td>
						<td style="text-align:center;">${list.cnslr}</td>
						<td style="text-align:center;">${list.memo}</td>
						<td style="text-align:center;">${list.agentEmpTel}</td>
						
						</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>	

