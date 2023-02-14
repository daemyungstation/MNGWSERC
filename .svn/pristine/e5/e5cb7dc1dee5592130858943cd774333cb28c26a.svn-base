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
		<c:set var="loginMap" value="${admLgnMap}" />

		<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />
	
		<table border="1">
			<thead>
				<tr>
					<th style="width:80px;">번호</th>
					<!-- 대리점명 -->
					<th style="width:100px;">판매채널</th>
	
					<!-- 코드 -->
					<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
						<th style="width:80px;">코드</th>
					</c:if>
					
					<!-- CODE -->
					<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
						<th style="width:80px;">CODE</th>
					</c:if>
					
					<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'hshsawon') or loginMap.id eq 'hansawon'}">
						<c:if test="${opmInfMap.idNoYn eq 'Y'}">
							<th style="width:80px;">코드1</th>
						</c:if>
						<th style="width:80px;">코드2</th>
					</c:if>
					
					<!-- 매장코드 -->
					<c:if test="${opmInfMap.agentCdYn eq 'Y'}">
						<th style="width:100px;">매장코드</th>
					</c:if>
					
					<!-- 대명 가입번호 -->
					<c:if test="${opmInfMap.idNoYn eq 'Y'}">
						<th style="width:120px;">${egov:decode(opmInfMap.b2bStts, 'ONLIFECC', '이지웰주문번호', '대명<br />가입번호(idNo)')}</th>
					</c:if>
					
					<!-- 가입일 -->
					<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'hshsawon') or loginMap.id eq 'hansawon'}">
						<th style="width:100px;">가입일</th> 
					</c:if>
					
					<!-- 판매사원 성명 -->
					<th style="width:100px;">판매사원명</th>
					
					<!--  판매사원사번 -->
					<th style="width:120px;">판매사원사번</th>
					
					<!-- 판매사 연락처 -->
					<th style="width:120px;">판매사 연락처</th>
					
					<!-- 유모비 고객 고유번호 -->
					<th style="width:120px;">유모비<br />고객 고유번호</th>
					
					<!-- 가입회사명 -->
					<c:if test="${opmInfMap.companyNmYn eq 'Y'}">
						<th style="width:100px;">가입회사명</th>
					</c:if>
					
					<!-- 담당자명 -->
					<c:if test="${opmInfMap.b2bEmpCdYn eq 'Y'}">
						<th style="width:100px;">담당자명</th>
					</c:if>
					
					<!-- 영업채널1 -->
					<c:if test="${opmInfMap.code1Yn eq 'Y'}">
						<th style="width:100px;">영업채널1</th>
					</c:if>
	
					<!-- 영업채널2 -->
					<c:if test="${opmInfMap.code3Yn eq 'Y'}">
						<th style="width:100px;">영업채널2</th>
					</c:if>
					
					<!-- 판매사코드/사번 -->
					<c:if test="${opmInfMap.code2Yn eq 'Y'}">
						<th style="width:120px;">판매사코드<br />/사번</th>
					</c:if>
					
					<!-- 1구좌 상품명 -->
					<c:if test="${opmInfMap.prdctNmYn eq 'Y'}">
						<th style="width:180px;">1구좌 상품명</th>
					</c:if>
					
					<!-- 2구좌 상품명 -->
					<c:if test="${opmInfMap.prdctNm2Yn eq 'Y'}">
						<th style="width:180px;">2구좌 상품명</th>
					</c:if>
					
					<!-- 3구좌 상품명 -->
					<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
						<th style="width:180px;">3구좌 상품명</th>
					</c:if>
					
					<!-- 결합 상품 -->
					<c:if test="${opmInfMap.fusionPrdctYn eq 'Y'}">
						<th style="width:180px;">결합 상품</th>
					</c:if>
					
					<!-- 고객명 -->
					<c:if test="${opmInfMap.nameYn eq 'Y' and (loginMap.roleCd ne 'ROLE_00024' or loginMap.id eq 'hshsawon')}">
						<th style="width:100px;">고객명</th>
					</c:if>
					
					<!-- 점포명 -->
					<c:if test="${opmInfMap.storeNmYn eq 'Y'}">
						<th style="width:100px;">점포명</th>
					</c:if>
					
					<!-- 고객 연락처(핸드폰) -->
					<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
						<th style="width:100px;">고객 연락처</th>
					</c:if>
	
					<!-- skb 가입상태 -->
					<c:if test="${opmInfMap.skbJoinYn eq 'Y'}">
						<th style="width:80px;">SKB 가입상태</th>
					</c:if>
					
					<c:choose>
						<c:when test="${loginMap.id eq 'hshsawon'}">
							<!-- 가입상태 -->
							<th style="width:80px;">가입상태</th>
							
							<!-- 가입일 -->
							<th style="width:100px;">가입일</th>
							
							<!-- 등록일 -->
							<th style="width:100px;">등록일</th>
						</c:when>
						<c:otherwise>
							<!-- 상담신청일 -->
							<th style="width:100px;">상담신청일</th>
							
							<!-- 상담확인 -->
							<th style="width:100px;">상담확인</th>
							
							<!-- 상담자 -->
							<th style="width:100px;">상담자</th>
						</c:otherwise>
					</c:choose>
					
					<!-- 메모 -->
					<c:if test="${opmInfMap.memoYn eq 'Y'}">
						<th style="width:240px;">메모</th>
					</c:if>
					
					<!-- 상담이력 -->
					<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager' or (opmInfMap.b2bStts eq 'ONLIFECC' and loginMap.id ne 'hshsawon') or loginMap.id eq 'hansawon'}">
						<th style="width:240px;">상담이력</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:set var="totCnt" value="${fn:length(rtnMap.list)}" />
				<c:choose>
					<c:when test="${fn:length(rtnMap.list) eq 0}">
						<tr>
							<td class="lt_text3" colspan="30" style="text-align:center">
								<fmt:message key="common.nodata.msg" />
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	
							<td style="text-align:center;">${ totCnt - status.index}</td>

							<!-- 판매채널 -->
							<c:if test="${empty list.agentNm}">
								<td style="text-align:center;">온라인</td>
							</c:if>
							<c:if test="${not empty list.agentNm}">
								<td style="text-align:center;">${list.agentNm}</td>
							</c:if>
	
							<!-- 코드 -->
							<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
								<td style="text-align:center;">${list.agentCode1}</td>
							</c:if>
							
							<!-- CODE -->
							<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
								<td style="text-align:center;">${list.agentCode2}</td>
							</c:if>
							
							<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'hshsawon') or loginMap.id eq 'hansawon'}">
								<c:if test="${opmInfMap.idNoYn eq 'Y'}">
									<td style="text-align:center;">${list.prodNo}</td>
								</c:if>
								<td style="text-align:center;">${list.statNo}</td>
							</c:if>
							
							<!-- 매장코드 -->
							<c:if test="${opmInfMap.agentCdYn eq 'Y'}">
								<td style="text-align:center;">${list.agentCd}</td>	
							</c:if>
							
							<!-- 대명 가입번호 -->
							<c:if test="${opmInfMap.idNoYn eq 'Y'}">
								<td style="text-align:center;">${list.idNo}</td>
							</c:if>
							
							<!-- 가입일 -->
							<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'hshsawon') or loginMap.id eq 'hansawon'}">
								<td style="text-align:center;">${list.joinDt}</td>
							</c:if>
								
							<!-- 판매사원 성명 -->
							<td style="text-align:center;">${list.agentEmpNm}</td>
							
							<!-- 판매사원 사번 -->
							<td style="text-align:center;">${list.agentEmpNum}</td>
							
							<!-- 판매사 연락처 -->
							<td style="text-align:center;">${list.agentEmpTel}</td>
							
							<!-- 유모비 고객 고유번호 -->
							<td style="text-align:center;">${list.cstmrUnqNum}</td>
	
							<!-- 가입회사명 -->
							<c:if test="${opmInfMap.companyNmYn eq 'Y'}">
								<td style="text-align:center;">${list.companyNm}</td>
							</c:if>
							
							<!-- 담당자명 -->
							<c:if test="${opmInfMap.b2bEmpCdYn eq 'Y'}">
								<td style="text-align:center;">${list.b2bEmpCd}</td>
							</c:if>
							
							<!-- 영업채널1 -->
							<c:if test="${opmInfMap.code1Yn eq 'Y'}">
								<td style="text-align:center;">${list.code1}</td>
							</c:if>
							
							<!-- 영업채널2 -->
							<c:if test="${opmInfMap.code3Yn eq 'Y'}">
								<td style="text-align:center;">${list.code3}</td>
							</c:if>
							
							<!-- 판매사코드/사번 -->
							<c:if test="${opmInfMap.code2Yn eq 'Y'}">
								<td style="text-align:center;">${list.code2}</td>
							</c:if>
							
							<!-- 1구좌 상품명 -->
							<c:if test="${opmInfMap.prdctNmYn eq 'Y'}">
								<td style="text-align:center;">${list.prdctNm}</td>
							</c:if>
							
							<!-- 2구좌 상품명 -->
							<c:if test="${opmInfMap.prdctNm2Yn eq 'Y'}">
								<td style="text-align:center;">${list.prdctNm2}</td>
							</c:if>
							
							<!-- 3구좌 상품명 -->
							<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
								<td style="text-align:center;">${list.prdctNm3}</td>
							</c:if>
			
							<!-- 결합 상품 -->
							<c:if test="${opmInfMap.fusionPrdctYn eq 'Y'}">
								<td style="text-align:center;">${list.fusionPrdctNm}</td>
							</c:if>
							
							<!-- 고객명 -->
							<c:if test="${opmInfMap.nameYn eq 'Y' and (loginMap.roleCd ne 'ROLE_00024' or loginMap.id eq 'hshsawon')}">
								<c:choose>
									<c:when test="${opmInfMap.b2bStts eq 'ONLIFECC'}">
										<td style="text-align:center;">
											<c:if test="${not empty list.name}">
												${fn:substring(list.name, 0, 1)}*${fn:substring(list.name, 2, fn:length(list.name))}
											</c:if>
										</td>
									</c:when>
									<c:otherwise>
										<td style="text-align:center;">${list.name}</td>
									</c:otherwise>
								</c:choose>
							</c:if>
							
							<!-- 점포명 -->
							<c:if test="${opmInfMap.storeNmYn eq 'Y'}">
								<td style="text-align:center;">${list.storeNm}</td>
							</c:if>
							
							<!-- 고객 연락처(핸드폰) -->
							<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
								<td style="text-align:center;">${list.hp}</td>
							</c:if>
							
							<!-- skb 가입상태 -->
							<c:if test="${opmInfMap.skbJoinYn eq 'Y'}">
								<td style="width:130px; text-align:center">${list.skbJoin}</td>
							</c:if>
							
							<c:choose>
								<c:when test="${loginMap.id eq 'hshsawon'}">
									<!-- 가입상태 -->
									<td style="text-align:center;">${list.statNo}</td>
									
									<!-- 가입일 -->
									<td style="text-align:center;">${list.joinDt}</td>
									
									<!-- 등록일 -->
									<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								</c:when>
								<c:otherwise>
									<!-- 상담신청일 -->
									<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
									
									<!-- 상담확인 -->
									<td style="text-align:center;"><c:if test="${loginMap.id ne 'hshdb'}">${list.callStts}</c:if></td>
									
									<!-- 상담자 -->
									<td style="text-align:center;"><c:if test="${loginMap.id ne 'hshdb'}">${list.cnslr}</c:if></td>
								</c:otherwise>
							</c:choose>
							
							<!-- 메모 -->
							<c:if test="${opmInfMap.memoYn eq 'Y'}">
								<td style="text-align:center;">${list.memo}</td>
							</c:if>
							
							<!-- 상담이력 -->
							<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager' or (opmInfMap.b2bStts eq 'ONLIFECC' and loginMap.id ne 'hshsawon') or loginMap.id eq 'hansawon'}">
								<td style="text-align:center;">
									<c:if test="${list.callStts eq '가입취소' and not empty list.cnslDtlCntn}">
										${list.cnslDtlCntn} (${egov:convertDate(list.cnslDtlDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')})
									</c:if>
								</td>
							</c:if>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</body>
</html>