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
	파일명 		:	OMACounselListMainExcel.jsp
	프로그램 명 : 	온라인 상담관리 엑셀 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.29
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.29				김필기				최초작성
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
			<tr>
				<th>번호</th>

				<c:if test="${rtnMap.loginId eq 'lgadmin' || rtnMap.loginId eq 'csadmin' || rtnMap.loginId eq 'lguplus' }">
				<th>매장명</th>
				<th>담당사원</th>
				<th>담당사번</th>
				<th>담당전화번호</th>
				<th>유입경로</th>
				<th>ID_NO</th>
				</c:if>
				
				<c:choose>
					<c:when test="${rtnMap.loginId eq 'homeplus001' || rtnMap.loginId eq 'lgsh001'}">				
				<th>선택상품명</th>
				<th>상담신청일</th>
				<th>휴대전화</th>
				<th>연락가능시간</th>
				<th>모집인</th>
				<th>모집인연락처</th>
				<th>상담확인</th>
				<th>상담자</th>
					</c:when>
					<c:otherwise>
				<th>고객명</th>
				<th>상품명</th>
				<th>가입일</th>
				<th>주소</th>
				<th>유선전화</th>
				<th>통신사</th>
				<th>휴대전화</th>
				<th>이메일</th>
				<th>회사코드</th>
				<th>선택상품명</th>
				<th>회원번호</th>
				<th>상담시간</th>
				<th>카드번호</th>
				<th>상담이력</th>
				<th>업체명</th>
				<th>상담확인</th>
				<th>상담자</th>
				<th>상담이력</th>
				<th>매장상담여부</th>
					</c:otherwise>
				</c:choose>
			</tr>
			
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
			<tr>
				<td>${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
				
				<c:if test="${rtnMap.loginId eq 'lgadmin' || rtnMap.loginId eq 'csadmin' || rtnMap.loginId eq 'lguplus' }">
				<td>${list.agentNm}</td>
				<td>${list.agentEmpNm}</td>								
				<td>${list.agentEmpId }</td>
				<td>${list.agentEmpTel }</td>
				<td>${list.b2bStts }</td>
				<td>${list.idNo}</td>
				</c:if>
				
				<c:choose>
					<c:when test="${rtnMap.loginId eq 'homeplus001' || rtnMap.loginId eq 'lgsh001'}">
				<td>${list.prdctNm}</td>
				<td>${list.regDtm}</td>
				<td>${list.hp}</td>
				<td>${list.calltime}</td>
				<td>${list.b2bCd }</td>
				<td>${list.agentEmpTel}</td>
				<td>${list.callStts }</td>
				<td>${list.cnslr}</td>		
					</c:when>
					<c:otherwise>
				<td>${list.name}</td>
				<td>${list.prdctNm}</td>
				<td>${list.regDtm}</td>
				<td>${list.adr} ${list.adrDtl }</td>
				<td>${list.tel}</td>
				<td>${list.telecom}</td>
				<td>${list.hp}</td>
				<td>${list.email}</td>
				<td>${list.b2bCd}</td>
				<td>${list.prdctNm}</td>
				<td>${list.idNo}</td>
				
					<c:if test="${list.code1 eq '' || list.code1 eq null }">
				<td>${list.calltime }</td>
					</c:if>
					
					<c:if test="${list.code1 ne '' && list.code1 ne null }">
				<td>${list.code1 }</td>
					</c:if>
				
				<td>${list.code2}</td>
				<td>${list.memo}</td>
				<td>${list.b2bNm}</td>
				<td>${list.callStts}</td>
				<td>${list.cnslr}</td>
				<td>${list.contents}</td>
				<td>${list.agentCallStts}</td>
					</c:otherwise>
				</c:choose>				
				
			</tr>
			</c:forEach>
			
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td colspan="20" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>	
		</table>
	</body>
</html>