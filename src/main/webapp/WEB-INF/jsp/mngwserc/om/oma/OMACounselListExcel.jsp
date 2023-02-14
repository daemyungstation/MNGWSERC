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
				<th style="width:60px; vertical-align:middle;">
					번호
				</th>
				
				<!-- 상품 만료 연기 신청 페이지 -->
				<c:if test="${loginMap.id eq 'lifeway09' }">
					<th style="width:120px; vertical-align:middle;">
						상품내역
					</th>
					<th style="width:120px; vertical-align:middle;">
						회원번호
					</th>
					<th style="width:120px; vertical-align:middle;">
						납입회차
					</th>
					<th style="width:120px; vertical-align:middle;">
						구매상품
					</th>
					<th style="width:120px; vertical-align:middle;">
						배송지
					</th>
					<th style="width:120px; vertical-align:middle;">
						이름
					</th>
					<th style="width:120px; vertical-align:middle;">
						휴대폰
					</th>
					<th style="width:120px; vertical-align:middle;">
						생년월일
					</th>
					<th style="width:120px; vertical-align:middle;">
						성별
					</th>
					<th style="width:120px; vertical-align:middle;">
						고유번호
					</th>
				</c:if>
				
				<!-- 주 계약 -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'SMART' and loginMap.roleCd eq 'ROLE_00007'}">
							<th style="width:100px; vertical-align:middle;">주 계약	</th>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:if>

				<!-- 웨딩의 여신 친구 초대코드 --> 
				<c:if test="${opmInfMap.inviteCodeYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						웨딩의 여신 친구<br>초대코드
					</th>
				</c:if>

				<!-- 고객등록번호 --> 
				<c:if test="${loginMap.id eq 'modetour' or loginMap.id eq 'modesawon' }">
					<th style="width:120px; vertical-align:middle;">
						고객등록번호
					</th>
				</c:if>
				
				<!-- 고객등록번호 --> 
				<c:if test="${loginMap.id eq 'hansawon' or loginMap.id eq 'hanssem' }">
					<th style="width:130px; vertical-align:middle;">
						고객등록번호<br /> (한샘통합멤버십_난수값)
					</th>
				</c:if>

				<!-- 여행예약번호 --> 
				<c:if test="${opmInfMap.tourBookNoYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						여행예약번호
					</th>
				</c:if>

				<!-- 인입경로 --> 
				<c:if test="${opmInfMap.funnelYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						<c:if test="${loginMap.id ne 'smartlife' and loginMap.id ne 'smartmobile'}">인입경로</c:if>
						<c:if test="${loginMap.id eq 'smartlife' or loginMap.id eq 'smartmobile'}">채널</c:if>
					</th>
				</c:if>

				<!-- 코드(판매사) -->
				<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						코드(판매사)
					</th>
				</c:if>
				
				<!-- CODE(판매사) -->
				<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						CODE(판매사)
					</th>
				</c:if>
				
				<!-- 한샘 통합 멤버십 -->
				<c:if test="${opmInfMap.hanssMbspNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
					<th style="width:120px; vertical-align:middle;">
						한샘 통합 멤버십
					</th>
				</c:if>
				
				<!-- 멤버십 번호 -->
				<c:if test="${opmInfMap.mbspNumYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						멤버십 번호
					</th>
				</c:if>
				
				<!-- 판매자 번호 -->
				<c:if test="${opmInfMap.sllrNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
					<th style="width:100px; vertical-align:middle;">
						판매자 번호
					</th>
				</c:if>
				
				<!-- 사원명 -->
				<c:if test="${opmInfMap.agentEmpNmYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						사원명
					</th>
				</c:if>
				
				<!-- 사번 -->
				<c:if test="${opmInfMap.agentEmpNumYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						사번
					</th>
				</c:if>
				
				<!-- 지사 -->
				<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
				<th style="width:100px; vertical-align:middle;">
						지사
					</th>
				</c:if>
				
				<!-- 판매자 소속 -->
				<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'SONE'}">
					<th style="width:100px; vertical-align:middle;">
						판매자 소속
					</th>
				</c:if>
				
				<!-- 판매 대리점명 -->
				<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
					<th style="width:100px; vertical-align:middle;">
						판매 대리점명
					</th>
				</c:if>
				
				<!-- 판매 대리점명 -->
				<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y' and (loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon')}">
					<th style="width:100px; vertical-align:middle;">
						대리점명
					</th>
				</c:if>

				<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
					<c:if test="${opmInfMap.idNoYn eq 'Y'}">
						<th style="width:70px; vertical-align:middle;">
							코드1
						</th>
					</c:if>
					<c:if test="${ loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon' }" >
						<th style="width:70px; vertical-align:middle;">
							코드2
						</th>
					</c:if>
					<c:if test="${ (loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon') }" >
						<th style="width:70px; vertical-align:middle;">
							상태 코드
						</th>
					</c:if>
				</c:if>

				<!-- 매장코드 -->
				<c:if test="${opmInfMap.agentCdYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">	
						매장코드
					</th>
				</c:if>
				
				<!-- 주 계약 -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024'}">
							<th style="width:100px; vertical-align:middle;">주 계약	</th>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:if>

				<!-- 대명 가입번호 -->
				<c:if test="${opmInfMap.idNoYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'ONLIFECC'}">
								인터파크주문번호
							</c:when>
							<c:when test="${opmInfMap.b2bStts eq 'EZWEL'}">
								이지웰주문번호
							</c:when>
							<c:when test="${opmInfMap.b2bStts eq 'TMON'}">
								티몬주문번호
							</c:when>
							<c:otherwise>
								대명<br />가입번호(idNo)
							</c:otherwise>
						</c:choose>
					</th>
				</c:if>

				<!-- U+ 가입번호 -->
				<c:if test="${opmInfMap.homePrdNumYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
					<th style="width:100px; vertical-align:middle;">
						U+가입번호
					</th>
				</c:if>
				
				<!-- 대리점/직영점 코드 -->
				<c:if test="${opmInfMap.uDlrCdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
					<th style="width:100px; vertical-align:middle;">
						대리점/<br/>직영점 코드
					</th>
				</c:if>
				
				
				
				<!-- 채널유형코드 -->
				<!-- 
				<c:if test="${opmInfMap.uCmmnCdYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:120px; vertical-align:middle;">
						채널유형코드
					</th>
				</c:if>
				 -->
				<!-- 채널유형코드명 -->
				<c:if test="${opmInfMap.uCmmnCdNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:120px; vertical-align:middle;">
						채널유형코드명
					</th>
				</c:if>
				<!-- 유치대리점명 -->
				<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:120px; vertical-align:middle;">
						유치대리점명
					</th>
				</c:if>
				
				<!-- 상담등록자 사번 -->
				<c:if test="${opmInfMap.uIndcEmpnoYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
					<th style="width:100px; vertical-align:middle;">
						상담등록자<br/>사번
					</th>
				</c:if>
				
				<!-- 상담등록자 마당 ID -->
				<c:if test="${opmInfMap.uIntgUserIdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
					<th style="width:100px; vertical-align:middle;">
						상담등록자<br/>마당 ID
					</th>
				</c:if>
	
				<!-- 도매직영점 판매구분 -->
				<c:if test="${opmInfMap.salesTypeYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024'}">
							<th style="width:100px; vertical-align:middle;">도매직영점<br/>판매구분</th>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:if>

				<!-- 판매사구분
				<c:if test="${opmInfMap.b2bStts eq 'LGU' }">
					<th style="width:100px; vertical-align:middle;">판매사 구분</th>
				</c:if>
				 -->
				
				<!--  도매 판매점 POS 코드 -->
				<c:if test="${opmInfMap.whPosCdYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">
						도매 판매점<br/>POS 코드
					</th>
				</c:if>
				
				<!-- 도매 판매점명 -->
				<c:if test="${opmInfMap.whStoreNmYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">
						도매 판매점명
					</th>
				</c:if>
				
				<!-- 등록일 -->
				<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">등록일</th>
				</c:if>
				
				<!-- 출금일 -->
				<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
					<th style="width:100px; vertical-align:middle;">
						출금일
					</th> 
				</c:if>
				
				<!-- 해약일자 -->
				<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">해약일자</th>
				</c:if>

				<!-- 납입회차 -->
				<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">납입회차</th>
				</c:if>
				
				<!-- 납입수단 -->
				<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">납입수단</th>
				</c:if>
				
				<!-- 판매사원 성명 -->
				<c:if test="${opmInfMap.agentEmpNmYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE' or opmInfMap.b2bStts eq 'KBCAR'}"></c:when>
						<c:otherwise>
							<th style="width:100px; vertical-align:middle;">
								<c:choose>
									<c:when test="${loginMap.id eq 'lguplus' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">실제 판매자 이름</c:when>
									<c:otherwise>판매사원 명</c:otherwise>
								</c:choose>
							</th>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<!-- lguplus 유치대리점명 -->
				<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.id eq 'lguplus'}">
					<th style="width:100px; vertical-align:middle;">
						유치대리점명
					</th>
				</c:if>
				
				<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y' and (loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon')}">
					<th style="width:100px; vertical-align:middle;">
						판매자 이름
					</th>
				</c:if>
				
				<!-- 롯데카드 결제상태 -->
				<c:if test="${opmInfMap.lotteCardPayYn eq 'Y' and loginMap.id ne 'hansawon'}">
					<th style="width:100px; vertical-align:middle;">
						롯데카드 결제상태
					</th>
				</c:if>
				
				<!-- 가입 구좌 -->
				<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}"></c:when>
						<c:otherwise>
							<th style="width:100px; vertical-align:middle;">가입구좌</th>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<!-- 대리점명 -->
				<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
					<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'HANSSEM'}">
								<th style="width:120px; vertical-align:middle;">
									<c:if test="${loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon' }">판매자 소속</c:if>
								</th>
							</c:when>
							<c:when test="${opmInfMap.b2bStts eq 'KBCAR'}">
							</c:when>
							<c:otherwise>
								<th style="width:120px; vertical-align:middle;">
									대리점명
								</th>
							</c:otherwise>
						</c:choose>
				</c:if>
				
				<!-- 담당자 연락처 -->
				<c:if test="${opmInfMap.agentEmpTelYn eq 'Y' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager' and opmInfMap.b2bStts ne 'KBCAR'}">
					<th style="width:120px; vertical-align:middle;">
						<c:choose>
							<c:when test="${loginMap.id eq 'lguplus' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">실제 판매자 연락처</c:when>
							<c:otherwise>담당자 연락처</c:otherwise>
						</c:choose>
					</th>
				</c:if>
				
				<!-- 가입회사명 -->
				<c:if test="${opmInfMap.companyNmYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						가입회사명
					</th>
				</c:if>
				
				<!-- 담당자명 -->
				<c:if test="${opmInfMap.b2bEmpCdYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						담당자명
					</th>
				</c:if>
				
				<!-- 영업채널1 -->
				<c:if test="${opmInfMap.code1Yn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						영업채널1
					</th>
				</c:if>

				<!-- 영업채널2 -->
				<c:if test="${opmInfMap.code3Yn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						영업채널2
					</th>
				</c:if>
				
				<!-- 판매사코드/사번 -->
				<c:if test="${opmInfMap.code2Yn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'KBCAR'}">
						</c:when>
						<c:otherwise>
							<th style="width:100px; vertical-align:middle;">
								판매사코드<br />/사번
							</th>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<!-- 인입경로(KBCAR) -->
				<c:if test="${opmInfMap.b2bStts eq 'KBCAR'}">
					<th style="width:100px; vertical-align:middle;">
						인입경로
					</th>				
				</c:if>				
				
				<!-- 주문번호 -->
				<c:if test="${opmInfMap.orderNumYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						주문번호
					</th>
				</c:if>
				
				<!-- 판매사원 사번 -->
				<c:if test="${opmInfMap.agentEmpNumYn eq 'Y' and opmInfMap.b2bStts ne 'SONE'}">
					<th style="width:100px; vertical-align:middle;">
						판매사원 사번
					</th>
				</c:if>
				
				<!-- NUMBER(판매사) -->
				<c:if test="${opmInfMap.agentNumYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						NUMBER(판매사)
					</th>
				</c:if>
				
				<!-- 기타(판매사) -->
				<c:if test="${opmInfMap.agentEtcYn eq 'Y'}">
					<th style="width:150px; vertical-align:middle;">
						기타(판매사)
					</th>
				</c:if>
				
				<!-- 고유번호 -->
				<c:if test="${opmInfMap.agentUnqNumYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						고유번호
					</th>
				</c:if>
				
				<!-- 고객명 -->
				<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts eq 'SONE'}">
					<th style="width:100px; vertical-align:middle;">
						고객명
					</th>
				</c:if>
				
				<!-- 고객 연락처(핸드폰) -->
				<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
					<th style="width:120px; vertical-align:middle;">
						고객 연락처<br/>(핸드폰)
					</th>
				</c:if>
				
				<!-- 1구좌 상품명 -->
				<c:if test="${opmInfMap.prdctNmYn eq 'Y'}"> 
					<th style="width:160px; vertical-align:middle;">
						<c:if test="${loginMap.id eq 'jautour'}">
							상품명
						</c:if>
						<c:if test="${loginMap.id ne 'jautour'}">
							1구좌 상품명
						</c:if>
					</th>
				</c:if>
				
				<!-- 결합 상품 -->
				<c:if test="${opmInfMap.fusionPrdctYn eq 'Y'}">
					<th style="width:160px; vertical-align:middle;">
						결합 상품
					</th>
				</c:if>
				
				<!-- 2구좌 상품명 -->
				<c:if test="${opmInfMap.prdctNm2Yn eq 'Y'}">
					<th style="width:160px; vertical-align:middle;">
						2구좌 상품명
					</th>
				</c:if>
				
				<!-- 결합 상품2 -->
				<c:if test="${opmInfMap.fusionPrdct2Yn eq 'Y'}">
					<th style="width:160px; vertical-align:middle;">
						결합 상품
					</th>
				</c:if>
				
				<!-- 3구좌 상품명 -->
				<!-- 
				<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
					<th style="width:160px; vertical-align:middle;">
						3구좌 상품명
					</th>
				</c:if>
				 -->
				
				<!-- 주 계약 -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
					<th style="width:100px; vertical-align:middle;">주 계약	</th>
				</c:if>
				
				<!-- 카드결제 유무 -->
				<c:if test="${opmInfMap.cardPayYn eq 'Y'}">
					<th style="width:160px; vertical-align:middle;">
						카드결제 유무
					</th>
				</c:if>
				
				<!-- 주 계약 -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00007'}">
							<th style="width:100px; vertical-align:middle;">주 계약	</th>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:if>

				<!-- 고객명 -->
				<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts ne 'SONE' and (loginMap.roleCd ne 'ROLE_00024' or (loginMap.id eq 'rohasdb' or loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'tmon' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon') or (opmInfMap.b2bStts eq 'WEDDING'))}">
					<th style="width:100px; vertical-align:middle;">
						고객명
					</th>
				</c:if>
				
				<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						판매사 소속<br>(업체명)
					</th>
				</c:if>

				<!-- 판매사원 성명 -->
				<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024' and opmInfMap.b2bStts ne 'KBCAR'}">
							<th style="width:100px; vertical-align:middle;">판매사 성함</th>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:if>

				<!-- 할인 받을 연락처 (CTN) -->
				<c:if test="${opmInfMap.discountCtnYn eq 'Y' and loginMap.id eq 'lguplus'}">
					<th style="width:100px; vertical-align:middle;">
						할인 받을 연락처 <br />(CTN)
					</th>
				</c:if>

				<!-- 할인 받을 명의자 생년월일 -->
				<c:if test="${opmInfMap.discountPinYn eq 'Y' and loginMap.id eq 'lguplus'}">
					<th style="width:100px; vertical-align:middle;">
						할인 받을 명의자 <br />생년월일
					</th>
				</c:if>

				<!-- U+ 가입번호 -->
				<c:if test="${opmInfMap.homePrdNumYn eq 'Y' and loginMap.id eq 'lguplus'}">
					<th style="width:100px; vertical-align:middle;">
						U+가입번호
					</th>
				</c:if>
				
				<!-- 점포명 -->
				<c:if test="${opmInfMap.storeNmYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						점포명
					</th>
				</c:if>
				
				<!-- U+ 서비스명 -->
				<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:120px; vertical-align:middle;">
						U+ 서비스명
					</th>
				</c:if>
				<!-- U+ 상품번호 -->
				<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:120px; vertical-align:middle;">
						U+ 상품번호
					</th>
				</c:if>
				
				<!-- 회원번호 -->
				<c:if test="${opmInfMap.b2bStts eq 'KBCAR' and loginMap.roleCd eq 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						회원번호
					</th>
				</c:if>
				
				<!-- 계약자명 -->
				<c:if test="${opmInfMap.contractorNameYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						계약자명
					</th>
				</c:if>
				
				<!-- 고객 연락처(핸드폰) -->
				<c:if test="${opmInfMap.hpYn eq 'Y' and (loginMap.id eq 'rohasdb' or (loginMap.roleCd ne 'ROLE_00024' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon' and opmInfMap.b2bStts ne 'SONE' and opmInfMap.b2bStts ne 'KBCAR'))}">
					<th style="width:120px; vertical-align:middle;">
						<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00007'}">
								고객 연락처
							</c:when>
							<c:otherwise>고객 연락처<br />(핸드폰)</c:otherwise>
						</c:choose>
					</th>
				</c:if>
				<c:if test="${opmInfMap.b2bStts eq 'KBCAR'}">
					<!-- 계약자 연락처 -->
					<c:if test="${opmInfMap.contractorPhoneYn eq 'Y'}">
						<th style="width:100px; vertical-align:middle;">
							계약자 연락처
						</th>
					</c:if>
					<c:choose>
						<c:when test="${loginMap.roleCd eq 'ROLE_00007'}">
							<!-- 계약자 생년월일 -->
							<c:if test="${opmInfMap.contractorBirthYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									계약자 생년월일
								</th>
							</c:if>
				
							<!-- 구좌수 -->
							<c:if test="${opmInfMap.orderQtyYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									주계약 구좌수
								</th>
							</c:if>
							
							<!-- 주계약 서비스1 -->
							<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									주계약 서비스1
								</th>
							</c:if>
						
							<!-- 주계약 서비스2 -->
							<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									주계약 서비스2
								</th>
							</c:if>
							
							<!-- 신용카드사 -->
							<c:if test="${opmInfMap.code2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									신용카드사
								</th>
							</c:if>
							
							<!-- 카드번호 -->
							<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									카드번호
								</th>
							</c:if>
							
							<!-- 유효기간 -->
							<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									유효기간
								</th>
							</c:if>
							
							<!-- 상사코드 -->
							<c:if test="${opmInfMap.code2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상사코드
								</th>
							</c:if>
							
							<!-- 상사명 -->
							<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상사명
								</th>
							</c:if>
				
							<!-- 담당자명 -->
							<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상사 담당자명
								</th>
							</c:if>
							
							<!-- 상사연락처 -->
							<c:if test="${opmInfMap.agentEmpTelYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상사연락처
								</th>
							</c:if>
							
							<!-- 구매차량번호 -->
							<c:if test="${opmInfMap.plateNumYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									구매차량번호
								</th>
							</c:if>
							
							<!-- 상담시간 -->
							<c:if test="${opmInfMap.calltimeYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상담시간
								</th>
							</c:if>
							
							<!-- 주소 -->
							<c:if test="${opmInfMap.addressYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									주소
								</th>
							</c:if>
							
							<!-- 비상연락처 -->
							<c:if test="${opmInfMap.hpYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									비상연락처
								</th>
							</c:if>
							
							<!-- 이메일 -->
							<c:if test="${opmInfMap.emailYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									이메일
								</th>
							</c:if>
							
							<!-- 약관동의여부 -->
							<th style="width:100px; vertical-align:middle;">
								약관동의여부
							</th>
							
							<!-- 메모 -->
							<th style="width:100px; vertical-align:middle;">
								메모
							</th>
						</c:when>
						<c:when test="${loginMap.roleCd eq 'ROLE_00024'}">
							<!-- 주계약 서비스1 -->
							<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									주계약 서비스1
								</th>
							</c:if>
						
							<!-- 주계약 서비스2 -->
							<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									주계약 서비스2
								</th>
							</c:if>
							
							<th style="width:100px; vertical-align:middle;">
								등록일자
							</th> 
							
							<th style="width:100px; vertical-align:middle;">
								가입일자
							</th>
							
							<th style="width:100px; vertical-align:middle;">
								가입상태
							</th>
							
							<!-- 상사코드 -->
							<c:if test="${opmInfMap.code2Yn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상사코드
								</th>
							</c:if>
				
							<!-- 상사명 -->
							<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									상사명
								</th>
							</c:if>
				
							<!-- 담당자명 -->
							<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
								<th style="width:100px; vertical-align:middle;">
									담당자명
								</th>
							</c:if>
						</c:when>
					</c:choose>
				</c:if>
				<!-- 고객 연락처(핸드폰) -->
				<c:if test="${opmInfMap.hpYn eq 'Y' and (loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon')}">
					<th style="width:120px; vertical-align:middle;">
						고객 연락처
					</th>
				</c:if>

				<c:if test="${loginMap.id eq 'rohasdb'}">
					<!-- 계약자 생년월일 -->
					<c:if test="${opmInfMap.contractorBirthYn eq 'Y'}">
						<th style="width:100px; vertical-align:middle;">
							고객 생년월일
						</th>
					</c:if>
					<!-- 계약자 생별 -->
					<th style="width:120px; vertical-align:middle;">
						성별
					</th>
				</c:if>

				<!-- 이용 서비스 -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'ALLSERVICE'}">
					<th style="width:100px; vertical-align:middle;">이용 서비스</th>
				</c:if>				

				<!-- 이용 서비스(가전전환) -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'MOVEMENT'}">
					<th style="width:100px; vertical-align:middle;">이용 서비스</th>
				</c:if>				

				<!-- 가입 구좌 -->
				<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}"></c:when>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd ne 'ROLE_00024'}">
							<th style="width:100px; vertical-align:middle;">가입 희망 구좌</th>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:if>

				<!-- 여행지 -->
				<c:if test="${opmInfMap.travelYn eq 'Y' and opmInfMap.b2bStts ne 'WEDDING'}">
					<th style="width:120px; vertical-align:middle;">
						여행지
					</th>
				</c:if>
				<c:if test="${opmInfMap.travelYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:120px; vertical-align:middle;">
						희망 허니문<br>여행지
					</th>
				</c:if>
				
				<!-- 희망 허니문 출발일 -->
				<c:if test="${opmInfMap.weddingDateYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:120px; vertical-align:middle;">
						희망 허니문<br>출발일
					</th>
				</c:if>
				<!-- 자유투어 예약번호 -->
				<c:if test="${opmInfMap.jauNumYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						자유투어 <br /> 예약번호
					</th>
				</c:if>

				<!-- 대명투어몰 예약번호 -->
				<c:if test="${opmInfMap.dmTourNumYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						대명투어몰 <br /> 예약번호
					</th>
				</c:if>

				<!-- 롯데카드 발급상태 -->
				<c:if test="${opmInfMap.lotteCardYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						롯데카드 <br /> 발급상태
					</th>
				</c:if>

				<!-- skb 가입상태 -->
				<c:if test="${opmInfMap.skbJoinYn eq 'Y'}">
					<th style="width:80px; vertical-align:middle;">
						SKB 가입상태
					</th>
				</c:if>
				
				<!-- 코드(고객) -->
				<c:if test="${opmInfMap.cstmrCodeKrYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						코드(고객)
					</th>
				</c:if>
				
				<!-- CODE(고객) -->
				<c:if test="${opmInfMap.cstmrCodeEnYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						CODE(고객)
					</th>
				</c:if>
				
				<!-- 고객 고유번호 -->
				<c:if test="${opmInfMap.cstmrUnqNumYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						고객 고유번호
					</th>
				</c:if>
				
				<!-- 카드번호 -->
				<c:if test="${opmInfMap.cardNumYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						카드번호
					</th>
				</c:if>
				
				<!-- NUMBER(고객) -->
				<c:if test="${opmInfMap.cstmrNumYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
						NUMBER(고객)
					</th>
				</c:if>
				
				<!-- 기타(고객) -->
				<c:if test="${opmInfMap.cstmrEtcYn eq 'Y'}">
					<th style="width:150px; vertical-align:middle;">
						기타(고객)
					</th>
				</c:if>
				
				<c:choose>
					<c:when test="${loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon' or loginMap.id eq 'tmon'}">
						<!-- 가입상태 -->
						<th style="width:80px; vertical-align:middle;">
							가입상태
						</th>
						
						<!-- 가입일 -->
						<th style="width:100px; vertical-align:middle;">
							가입일
						</th>
						<c:if test="${loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' and loginMap.id ne 'tmon'}">
							<!-- 등록일 -->
							<th style="width:100px; vertical-align:middle;">
								등록일
							</th>
						</c:if>
						<c:if test="${loginMap.id eq 'tmon' }">
							<!-- 등록일 -->
							<th style="width:100px; vertical-align:middle;">
								DB등록일
							</th>
						</c:if>
					</c:when>
					<c:when test="${(opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE') and loginMap.roleCd ne 'ROLE_00024'}">
						<!-- 상담신청일 -->
						<th style="width:100px; vertical-align:middle;">
							상담신청일
						</th>
						<!-- 상담자 -->
						<th style="width:100px; vertical-align:middle;">
							상담자
						</th>
						<!-- 상담현황 -->
						<th style="width:100px; vertical-align:middle;">
							상담현황
						</th>
					</c:when>
					<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
						<!-- 상담신청일 -->
						<th style="width:100px; vertical-align:middle;">
							상담신청일
						</th>
						<!-- 상담현황 -->
						<th style="width:100px; vertical-align:middle;">
							상담현황
						</th>
						<!-- 상담이력 -->
						<th style="width:200px; vertical-align:middle;">
							상담이력
						</th>
						<!-- 가입상태 -->
						<th style="width:80px; vertical-align:middle;">
							가입상태
						</th>
						<!-- 가입일 -->
						<th style="width:100px; vertical-align:middle;">
							가입일
						</th>
						<!-- 대명 회원번호 -->
						<th style="width:100px; vertical-align:middle;">
							대명 회원번호
						</th>
					</c:when>
					<c:when test="${loginMap.id eq 'kbsawon' }">
					</c:when>
					<c:when test="${opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
						<!-- 상담신청일 -->
						<th style="width:100px; vertical-align:middle;">
							상담신청일
						</th>
						
						<!-- 가입상태 -->
						<th style="width:100px; vertical-align:middle;">
							가입상태
						</th>
						
						<!-- 가입일 -->
						<th style="width:100px; vertical-align:middle;">
							가입일
						</th>
					</c:when>
					<c:otherwise>
						<!-- 상담신청일 -->
						<th style="width:100px; vertical-align:middle;">
							<c:choose>
								<c:when test="${loginMap.id eq 'interparktm' or loginMap.id eq 'interparkdb' or loginMap.id eq 'ezweltm' or loginMap.id eq 'ezweldb' or loginMap.id eq 'tmondb' or loginMap.id eq 'tmontm' or loginMap.id eq 'tmon'}">
									DB등록일
								</c:when>
								<c:otherwise>
									상담신청일
								</c:otherwise>
							</c:choose>
						</th>
						
						<!-- 상담가능시간대 -->
						<c:if test="${opmInfMap.calltimeYn eq 'Y'}">
							<th style="width:100px; vertical-align:middle;">
								상담가능시간대
							</th>
						</c:if>
						
						<!-- 상담확인 -->
						<th style="width:100px; vertical-align:middle;">
							상담확인
						</th>
						
						<!-- 상담자 -->
						<c:if test="${loginMap.id ne 'hansawon' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager'}">
							<th style="width:100px; vertical-align:middle;">
								상담자
							</th>
						</c:if>
					</c:otherwise>
				</c:choose>
				
				<c:if test="${loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon'}">
					<!-- 상담신청일 -->
					<th style="width:100px; vertical-align:middle;">
						상담신청일
					</th>

					<!-- 상담확인 -->
					<th style="width:100px; vertical-align:middle;">
						상담확인
					</th>
					
					<!-- 상담자 -->
					<th style="width:100px; vertical-align:middle;">
						상담자
					</th>
				</c:if>
				
				
				<!-- 메모 -->
				<c:if test="${opmInfMap.memoYn eq 'Y' and loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' and loginMap.id ne 'weddingsawon' and loginMap.id ne 's1sawon' and opmInfMap.b2bStts ne 'KBCAR'}">
					<th style="width:200px; vertical-align:middle;">
						메모
					</th>
				</c:if>
				
				<!-- agentCode1 (CI값) -->
				<c:if test="${loginMap.id eq 'smartlife' or loginMap.id eq 'smartmobile' }">
					<th style="width:200px; vertical-align:middle;">
						CI값
					</th>
				</c:if>
				
				<!-- 상담이력 -->
				<c:if test="${loginMap.id eq 'dmsawon' or loginMap.id eq 'jausawon' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager' or ((opmInfMap.b2bStts eq 'ONLIFECC' or opmInfMap.b2bStts eq 'EZWEL' or opmInfMap.b2bStts eq 'TMON') and (loginMap.id ne 'ezwel' and loginMap.id ne 'tmon' and loginMap.id ne 'interpark') ) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
					<th style="width:200px; vertical-align:middle;">
						상담이력
					</th>
				</c:if>
				
				<!-- 판매자 연락처(SMART, SMARTHOMEPLUS) -->
				<c:if test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'SMARTHOMEPLUS'}">
					<th style="width:100px; vertical-align:middle;">
						판매자 연락처
					</th>				
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
						<c:choose>
							<c:when test="${loginMap.roleCd eq 'ROLE_00024' or loginMap.id eq 'interparkdb' or loginMap.id eq 'ezweldb' or loginMap.id eq 'tmondb'}">
								<c:choose>
									<c:when test="${loginMap.id eq 'tmon' and list.statNo eq 4}">
										<tr class="tmon_background">
									</c:when>
									<c:otherwise>
										<tr>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<tr onclick="view('${list.oscCnslSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}','${list.kbNo}')" style="cursor:pointer">				
							</c:otherwise>
						</c:choose>
						
						<td style="text-align:center;">${ totCnt - status.index}</td>
						
						<!-- 상품 만료 연기 신청 페이지 -->
						<c:if test="${loginMap.id eq 'lifeway09' }">
							<td style="text-align:center;"> ${ list.expireRenewAccntName } </td>
							<td style="text-align:center;"> ${ list.expireRenewAccntNo } </td>
							<td style="text-align:center;"> ${ list.expireRenewAccntCnt } </td>
							<c:choose>
								<c:when test="${ list.expireRenewGiftNo eq 1004}">
									<td style="text-align:center;">1년 : 퀸메이드 씨에로 32p 홈세트</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1005}">
									<td style="text-align:center;">1년 : 황제황진환 골드</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1006}">
									<td style="text-align:center;">1년 : FULL HD 방수 액션캠</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1002}">
									<td style="text-align:center;">1년 : 세탁가능 전기요(더블)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1007}">
									<td style="text-align:center;">1년 : 한경희 스팀다리미</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1008}">
									<td style="text-align:center;">1년 : 차량겸용 공기청정기(블랙)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1011}">
									<td style="text-align:center;">1년 : 차량겸용 공기청정기(화이트)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1009}">
									<td style="text-align:center;">1년 : 온풍기 팬히터</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1010}">
									<td style="text-align:center;">1년 : 메모리폼 경추베개</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 1003}">
									<td style="text-align:center;">1년 : 일렉트로룩스 커피메이커</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2001}">
									<td style="text-align:center;">2년 : 모던하임 에어프라이어 (3.5L)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2006}">
									<td style="text-align:center;">2년 : 쌤소나이트 DELAENO 백팩(그레이)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2002}">
									<td style="text-align:center;">2년 : 26형 캐리어(프레시민트)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2003}">
									<td style="text-align:center;">2년 : 26형 캐리어(콜드그레이)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2004}">
									<td style="text-align:center;">2년 : 26형 캐리어(스위트옐로우)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2007}">
									<td style="text-align:center;">2년 : 스위스 몽크로스 가습기(4L)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2008}">
									<td style="text-align:center;">2년 : 스위스 몽크로스 미러오븐기(12L)</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2005}">
									<td style="text-align:center;">2년 : 바디휴 무선 어깨안마기</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2009}">
									<td style="text-align:center;">2년 : HAZZYS 프라하 슬링백</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2010}">
									<td style="text-align:center;">2년 : 가펠 프리마 인덕션</td>
								</c:when>
								<c:when test="${ list.expireRenewGiftNo eq 2011}">
									<td style="text-align:center;">2년 : 정관장 홍삼지감/정화액SET</td>
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">제공하지 않는 상품</td>
								</c:otherwise>
							</c:choose>
							<td style="text-align:center;">
								(${ list.zipcd }) ${list.adr }
								&nbsp; ${list.adrDtl } 
							</td>
							<td style="text-align:center;"> ${ list.name } </td>
							<td style="text-align:center;"> ${ list.hp } </td>
							<td style="text-align:center;"> ${ list.birth } </td>
							<td style="text-align:center;"> ${ list.gender }</td>
							<c:if test="${list.gender == '0001' }">
								<td style="text-align:center;">남</td>
							</c:if>
							<c:if test="${list.gender == '0002' }">
								<td style="text-align:center;">여</td>
							</c:if>
							<td style="text-align:center;">${list.unqNo}</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'SMART' and loginMap.roleCd eq 'ROLE_00007'}">
									<td style="text-align:center;"> ${list.mainContType} </td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 웨딩의 여신 친구 초대코드 --> 
						<c:if test="${opmInfMap.inviteCodeYn eq 'Y'}">
							<td style="text-align:center;"> ${ list.inviteCode } </td>
						</c:if>
						
						<!-- 고객등록번호 -->
						<c:if test="${loginMap.id eq 'modetour' or loginMap.id eq 'modesawon'}">
							<td style="text-align:center;"> ${ list.oscCnslSeq } </td>
						</c:if>
						
						<!-- 고객등록번호 -->
						<c:if test="${loginMap.id eq 'hansawon' or loginMap.id eq 'hanssem'}">
							<td style="text-align:center;"> ${list.hanssMbspNum}_${ list.oscCnslSeq } </td>
						</c:if>
						
						<!-- 여행예약번호 --> 
						<c:if test="${opmInfMap.tourBookNoYn eq 'Y'}">
							<td style="width:100px; text-align:center;">
								${ list.tourBookNo }
							</td>
						</c:if>
						
						<!-- 인입경로 -->
						<c:if test="${opmInfMap.funnelYn eq 'Y'}">
							<td style="text-align:center;">
							<c:if test="${list.funnel eq '1' }">온라인</c:if>
							<c:if test="${list.funnel eq '2' }">홈쇼핑</c:if>
							<c:if test="${list.funnel eq '3' }">가전</c:if>
							<c:if test="${list.funnel eq '4' }">모바일</c:if>
							<c:if test="${list.funnel eq '5' }">투어캐빈</c:if>
							<c:if test="${list.funnel eq '6' }">홈플러스</c:if>
							</td>
						</c:if>

						<!-- 코드(판매사) -->
						<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
							<td style="text-align:center;">${list.agentCode1}</td>
						</c:if>
						
						<!-- CODE(판매사) -->
						<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
							<td style="text-align:center;">${list.agentCode2}</td>
						</c:if>
						
						<!-- 한샘 통합 멤버십 -->
						<c:if test="${opmInfMap.hanssMbspNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
							<td style="text-align:center;">${list.hanssMbspNum}</td>
						</c:if>
						
						<!-- 멤버십 번호 -->
						<c:if test="${opmInfMap.mbspNumYn eq 'Y'}">
							<td style="text-align:center;">${list.mbspNum}</td>
						</c:if>
						
						<!-- 판매자 번호 -->
						<c:if test="${opmInfMap.sllrNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
							<td style="text-align:center;">${list.sllrNum}</td>
						</c:if>
						
						<!-- 사원명 -->
						<c:if test="${opmInfMap.agentEmpNmYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.agentEmpNm}</td>
						</c:if>
						
						<!-- 사번 -->
						<c:if test="${opmInfMap.agentEmpNumYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.agentEmpNum}</td>
						</c:if>
						
						<!-- 지사 -->
						<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.sllrPart}</td>
						</c:if>
						
						<!-- 판매자 소속 -->
						<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'SONE'}">
							<td style="text-align:center;">${list.sllrPart}</td>
						</c:if>
						
						<!-- 판매 대리점명 -->
						<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y'}">
							<td style="text-align:center;">${list.sllrAgentNm}</td>
						</c:if>
						
						<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
							<!-- 코드1 --> 
							<c:if test="${opmInfMap.idNoYn eq 'Y'}">
								<td style="text-align:center;">${list.prodNo}</td>
							</c:if>
							<!-- 코드2 -->
							<td style="text-align:center;">${list.statNo}</td>
						</c:if>
						
						<!-- 매장코드 -->
						<c:if test="${opmInfMap.agentCdYn eq 'Y'}">
							<td style="text-align:center;">${list.agentCd}</td>	
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024'}">
									<td style="text-align:center;"> ${list.mainContType} </td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 대명 가입번호 -->
						<c:if test="${opmInfMap.idNoYn eq 'Y'}">
							<td style="text-align:center;">${list.idNo}</td>
						</c:if>

						<!-- U+가입번호 -->
						<c:if test="${opmInfMap.homePrdNumYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.homePrdNum}</td>
						</c:if>

						<!-- 대리점/직영점 코드 -->
						<c:if test="${opmInfMap.uDlrCdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.uDlrCd}</td>
						</c:if>

						<!-- 채널유형코드 -->
						<!-- 
						<c:if test="${opmInfMap.uCmmnCdYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.uCmmnCd}</td>
						</c:if>
				 		-->
						<!-- 채널유형코드명 -->
						<c:if test="${opmInfMap.uCmmnCdNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.uCmmnCdNm}</td>
						</c:if>
						<!-- 유치대리점명 -->
						<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.uDlrNm}</td>
						</c:if>
						
						<!-- 상담등록자사번 -->
						<c:if test="${opmInfMap.uIndcEmpnoYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.uIndcEmpno}</td>
						</c:if>

						<!-- 상담등록자마당 ID -->
						<c:if test="${opmInfMap.uIntgUserIdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.uIntgUserId}</td>
						</c:if>						
						
						<!-- 도매직영점 판매구분 -->
						<c:if test="${opmInfMap.salesTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024'}">
									<td style="text-align:center;">${list.salesType}</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 판매사구분 
						<c:if test="${opmInfMap.b2bStts eq 'LGU' }">
							<th style="width:100px; vertical-align:middle;">${list.agentGubun}</th>
						</c:if>
						-->
						
						<!-- 도매직영점 POS 코드 -->
						<c:if test="${opmInfMap.whPosCdYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.whPosCd}</td>
						</c:if>
						
						<!-- 도매판매점명 -->
						<c:if test="${opmInfMap.whStoreNmYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.whStoreNm}</td>
						</c:if>
						
						<!-- 출금일 -->
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
							<td style="text-align:center;">${list.regDm}</td>
						</c:if>
						
						<!-- 등록일 -->
						<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
							<td style="text-align:center;">${list.joinDt}</td>
						</c:if>
						
						<!-- 해약일자 -->
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
							<td style="text-align:center;">
								<c:if test="${list.statNo == '5'}">
									<!-- ${list.eventCompDay}	-->
									${list.resnProcDay}
								</c:if>
							 </td>
						</c:if>
	
						<!-- 납입회차 -->
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
							<td style="text-align:center;">
								<c:if test="${list.statNo > '2'}">
									${list.trueCount}
								</c:if>
							</td>
						</c:if>
								
						<!-- 납입수단 -->
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
							<td style="text-align:center;">${list.payMthd}</td>
						</c:if>
						
						<!-- 판매사원 성명 -->
						<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE' or opmInfMap.b2bStts eq 'KBCAR'}"></c:when>
								<c:otherwise>
									<td style="text-align:center;">${list.agentEmpNm}</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 롯데카드 결제상태 -->
						<c:if test="${opmInfMap.lotteCardPayYn eq 'Y' and loginMap.id ne 'hansawon'}">
							<td style="width:100px; vertical-align:middle;">
								<c:if test="${list.lotteCardPay eq '1' }"> 35개월 할부 결제 완료 </c:if>
								<c:if test="${list.lotteCardPay eq '2' }"> 35개월 할부 미결제(롯데카드미소지포함) </c:if>
							</td>
						</c:if>
						
						<!-- 가입 구좌 -->
						<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}"></c:when>
								<c:otherwise>
									<td style="width:100px; text-align:center;">
										${list.joinProd}
									</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 대리점명 -->
						<c:if test="${opmInfMap.agentNmYn eq 'Y' }">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'KBCAR'}">
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">${list.agentNm}</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- lguplus 유치대리점명 -->
						<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.uDlrNm}</td>
						</c:if>
						
						<!-- 담당자 연락처 -->
						<c:if test="${opmInfMap.agentEmpTelYn eq 'Y' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager' and opmInfMap.b2bStts ne 'KBCAR'}">
							<td style="text-align:center;">${list.agentEmpTel}</td>
						</c:if>
						
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
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'KBCAR'}">
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">${list.code2}</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 인입번호 -->
						<c:if test="${opmInfMap.b2bStts eq 'KBCAR'}">
							<td style="text-align:center;">${list.b2bNm}</td>
						</c:if>							
						
						<!-- 주문번호 -->
						<c:if test="${opmInfMap.orderNumYn eq 'Y'}">
							<td style="text-align:center;">${list.orderNum}</td>
						</c:if>
						
						<!-- 회원번호 -->
						<c:if test="${opmInfMap.b2bStts eq 'KBCAR' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.idNo}</td>
						</c:if>
						
						<!-- 계약자명 -->
						<c:if test="${opmInfMap.contractorNameYn eq 'Y'}">
							<td style="text-align:center;">${list.contractorName}</td>
						</c:if>
						
						<!-- 판매사원 사번 -->
						<c:if test="${opmInfMap.agentEmpNumYn eq 'Y' and opmInfMap.b2bStts ne 'SONE'}">
							<td style="text-align:center;">${list.agentEmpNum}</td>
						</c:if>
						
						<!-- NUMBER(판매사) -->
						<c:if test="${opmInfMap.agentNumYn eq 'Y'}">
							<td style="text-align:center;">${list.agentNum}</td>
						</c:if>
						
						<!-- 기타(판매사) -->
						<c:if test="${opmInfMap.agentEtcYn eq 'Y'}">
							<td style="text-align:center;">${list.agentEtc}</td>
						</c:if>
						
						<!-- 고유번호 -->
						<c:if test="${opmInfMap.agentUnqNumYn eq 'Y'}">
							<td style="text-align:center;">${list.agentUnqNum}</td>
						</c:if>
						
						<!-- 고객명 -->
						<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts eq 'SONE'}">
							<td style="text-align:center;">
								${list.name}
							</td>
						</c:if>
				
						<!-- 고객 연락처(핸드폰) -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
							<td style="text-align:center;">
								${list.hp}
							</td>
						</c:if>
						
						<!-- 1구좌 상품명 -->
						<c:if test="${opmInfMap.prdctNmYn eq 'Y'}">
							<td style="text-align:center;">${list.prdctNm}</td>
						</c:if>
		
						<!-- 결합 상품 -->
						<c:if test="${opmInfMap.fusionPrdctYn eq 'Y'}">
							<td style="text-align:center;">${list.fusionPrdctNm}</td>
						</c:if>
						
						<!-- 2구좌 상품명 -->
						<c:if test="${opmInfMap.prdctNm2Yn eq 'Y'}">
							<td style="text-align:center;">${list.prdctNm2}</td>
						</c:if>
		
						<!-- 결합 상품2 -->
						<c:if test="${opmInfMap.fusionPrdct2Yn eq 'Y'}">
							<td style="text-align:center;">${list.fusionPrdctNm2}</td>
						</c:if>
						
						<!-- 3구좌 상품명 -->
						<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
							<td style="text-align:center;">${list.prdctNm3}</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
							<td style="text-align:center;">${list.mainContType}</td>
						</c:if>
						
						<!-- 카드결제 유무 -->
						<c:if test="${opmInfMap.cardPayYn eq 'Y'}">
							<td style="text-align:center">
								<c:choose>
									<c:when test="${list.cardPay eq 'Y'}">카드결제</c:when>
									<c:when test="${list.cardPay eq 'N'}">일반결제</c:when>
								</c:choose>
							</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00007'}">
									<td style="text-align:center;"> ${list.mainContType} </td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 고객명 -->
						<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts ne 'SONE' and (loginMap.roleCd ne 'ROLE_00024' or (loginMap.id eq 'rohasdb' or loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'tmon' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon') or (opmInfMap.b2bStts eq 'WEDDING'))}">
							<c:choose>
								<c:when test="${(opmInfMap.b2bStts eq 'ONLIFECC') or (opmInfMap.b2bStts eq 'EZWEL')}">
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
						
						<!-- weddingsawon 판매자 소속 -->
						<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.sllrPart}</td>
						</c:if>
						
						<!-- 판매사원 성명 -->
						<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024' and opmInfMap.b2bStts ne 'KBCAR'}">
									<td style="text-align:center;">${list.agentEmpNm}</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 할인 받을 연락처 (CTN) -->
						<c:if test="${opmInfMap.discountCtnYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.discountCtn}</td>
						</c:if>

						<!-- 할인 받을 명의자 생년월일 -->
						<c:if test="${opmInfMap.discountPinYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.discountPin}</td>
						</c:if>

						<!-- U+가입번호 -->
						<c:if test="${opmInfMap.homePrdNumYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.homePrdNum}</td>
						</c:if>
										
						<!-- 점포명 -->
						<c:if test="${opmInfMap.storeNmYn eq 'Y'}">
							<td style="text-align:center;">${list.storeNm}</td>
						</c:if>
						
						<!-- U+ 서비스명 -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">${list.uProdNm}</td>
						</c:if>
						<!-- U+ 상품번호 -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">${list.uProdNo}</td>
						</c:if>
						
						<!-- 고객 연락처(핸드폰) -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and (loginMap.id eq 'rohasdb' or (loginMap.roleCd ne 'ROLE_00024' and opmInfMap.b2bStts ne 'SONE' and opmInfMap.b2bStts ne 'KBCAR'))}">
							<td style="text-align:center;">${list.hp}</td>
						</c:if>

						<!-- 고객 연락처(핸드폰) -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.id eq 'hansawon'}">
							<td style="text-align:center;">${list.hp}</td>
						</c:if>
						
						<c:if test="${opmInfMap.b2bStts eq 'KBCAR'}">
							<!-- 계약자 연락처 -->
							<c:if test="${opmInfMap.contractorPhoneYn eq 'Y'}">
								<td style="text-align:center;">${list.contractorPhone}</td>
							</c:if>
							<c:choose>
								<c:when test ="${loginMap.roleCd eq 'ROLE_00007'}">
									<!-- 계약자 생년월일 -->
									<c:if test="${opmInfMap.contractorBirthYn eq 'Y'}">
										<td style="text-align:center;">${list.contractorBirth}</td>
									</c:if>
				
									<!-- 구좌수 -->
									<c:if test="${opmInfMap.orderQtyYn eq 'Y'}">
										<td style="text-align:center;">${list.orderQty}</td>
									</c:if>
									
									<!-- 주계약 서비스1 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}</td>
									</c:if>
					
									<!-- 주계약 서비스2 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}</td>
									</c:if>
									
									<!-- 신용카드사 -->
									<c:if test="${opmInfMap.cardCompanyYn eq 'Y'}">
										<td style="text-align:center;">${list.cardCompany}</td>
									</c:if>
				
									<!-- 카드번호 -->
									<c:if test="${opmInfMap.creditCardNumYn eq 'Y'}">
										<td style="text-align:center;">${list.creditCardNum}</td>
									</c:if>
				
									<!-- 유효기간 -->
									<c:if test="${opmInfMap.validThruYn eq 'Y'}">
										<td style="text-align:center;">${list.validThru}</td>
									</c:if>
									
									<!-- 상사코드 -->
									<c:if test="${opmInfMap.code2Yn eq 'Y'}">
										<td style="text-align:center;">${list.code2}</td>
									</c:if>
				
									<!-- 상사명 -->
									<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentNm}</td>
									</c:if>
				
									<!-- 상사 담당자명 -->
									<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentEmpNm}</td>
									</c:if>
					
									<!-- 상사 연락처 -->
									<c:if test="${opmInfMap.agentEmpTelYn eq 'Y'}">
										<td style="text-align:center;">${list.agentEmpTel}</td>
									</c:if>
									
									<!-- 구매차량번호 -->
									<c:if test="${opmInfMap.plateNumYn eq 'Y'}">
										<td style="text-align:center;">${list.plateNum}</td>
									</c:if>
									
									<!-- 상담시간 -->
									<c:if test="${opmInfMap.calltimeYn eq 'Y'}">
										<td style="text-align:center;">${list.calltime}</td>
									</c:if>
							
									<!-- 주소 -->
									<c:if test="${opmInfMap.addressYn eq 'Y'}">
										<td style="text-align:center;">${list.adr}</td>
									</c:if>
									
									<!-- 비상연락처 -->
									<c:if test="${opmInfMap.hpYn eq 'Y'}">
										<td style="text-align:center;">${list.hp}</td>
									</c:if>
									
									<!-- 이메일 -->
									<c:if test="${opmInfMap.emailYn eq 'Y'}">
										<td style="text-align:center;">${list.email}</td>
									</c:if>
									
									<td style="text-align:center;">${list.termAgree}</td>
									
									<td style="text-align:center;">${list.memo}</td>
								</c:when>
								
								<c:when test ="${loginMap.roleCd eq 'ROLE_00024'}">
									<!-- 주계약 서비스1 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}</td>
									</c:if>
					
									<!-- 주계약 서비스2 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}</td>
									</c:if>
									
									<!-- 등록일자 -->
									<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
									
									<!-- 가입일자 -->
									<td style="text-align:center;">${list.joinDt}</td>
									
									<!-- 가입상태 -->
									<td style="text-align:center;">
										${list.statNm}
<%--										
										${list.accStat} 
										${list.callStts}
--%>
									</td>
									
									<!-- 상사코드 -->
									<c:if test="${opmInfMap.code2Yn eq 'Y'}">
										<td style="text-align:center;">${list.code2}</td>
									</c:if>
				
									<!-- 상사명 -->
									<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentNm}</td>
									</c:if>
				
									<!-- 담당자명 -->
									<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentEmpNm}</td>
									</c:if>
								</c:when>
							</c:choose>
						</c:if>

						<c:if test="${loginMap.id eq 'rohasdb'}">
							<td style="text-align:center;"> ${ list.contractorBirth } </td>
							<td style="text-align:center;">
								<c:if test="${list.gender == '0001' }">남</c:if>
								<c:if test="${list.gender == '0002' }">여</c:if>
								<c:if test="${list.gender ne '0002' and list.gender ne '0001'}">${list.gender}</c:if>
							</td>
						</c:if>

						<!-- 이용 서비스 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'ALLSERVICE'}">
							<td style="text-align:center;">${list.mainContType}</td>
						</c:if>
						
						<!-- 이용 서비스(가전전환) -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'MOVEMENT'}">
							<td style="text-align:center;">${list.mainContType}</td>
						</c:if>
						
						<!-- 가입 구좌 -->
						<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}"></c:when>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd ne 'ROLE_00024'}">
									<td style="width:100px; text-align:center;">
										${list.joinProd}
									</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 여행지 -->
						<c:if test="${opmInfMap.travelYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">
								${list.travel }
							</td>
						</c:if>
						
						<!-- 희망 허니문 출발일 -->
						<c:if test="${opmInfMap.weddingDateYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">
								${list.weddingDate }
							</td>
						</c:if>
						<!-- 자유투어 예약번호 -->
						<c:if test="${opmInfMap.jauNumYn eq 'Y'}">
							<td style="text-align:center;">
								${list.jauNum }
							</td>
						</c:if>
		
						<!-- 대명투어몰 예약번호 -->
						<c:if test="${opmInfMap.dmTourNumYn eq 'Y'}">
							<td style="text-align:center;">
								${list.dmTourNum }
							</td>
						</c:if>
		
						<!-- 롯데카드 발급상태 -->
						<c:if test="${opmInfMap.lotteCardYn eq 'Y'}">
							<td style="text-align:center;">
								<c:if test="${list.lotteCard eq '1' }"> 보유 </c:if>
								<c:if test="${list.lotteCard eq '2' }"> 신규발급 </c:if>
							</td>
						</c:if>
						
						<!-- skb 가입상태 -->
						<c:if test="${opmInfMap.skbJoinYn eq 'Y'}">
							<td style="text-align:center">${list.skbJoin}</td>
						</c:if>
						
						<!-- 코드(고객) -->
						<c:if test="${opmInfMap.cstmrCodeKrYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrCode1}</td>
						</c:if>
						
						<!-- CODE(고객) -->
						<c:if test="${opmInfMap.cstmrCodeEnYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrCode2}</td>
						</c:if>
						
						<!-- 고객 고유번호 -->
						<c:if test="${opmInfMap.cstmrUnqNumYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrUnqNum}</td>
						</c:if>
						
						<!-- 카드번호 -->
						<c:if test="${opmInfMap.cardNumYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center">${list.cardNum}</td>
						</c:if>
						
						<!-- NUMBER(고객) -->
						<c:if test="${opmInfMap.cstmrNumYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrNum}</td>
						</c:if>
						
						<!-- 기타(고객) -->
						<c:if test="${opmInfMap.cstmrEtcYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrEtc}</td>
						</c:if>
						<c:choose>
							<c:when test="${loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon' or loginMap.id eq 'tmon' }">
								<!-- 가입상태 -->
								<td style="text-align:center;">${list.statNo}</td>
								
								<!-- 가입일 -->
								<td style="text-align:center;">${list.joinDt}</td>
								<c:if test="${loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' }">
									<!-- 등록일 -->
									<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								</c:if>
							</c:when>
							<c:when test="${(opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE') and loginMap.roleCd ne 'ROLE_00024'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								<!-- 상담자 -->
								<td style="text-align:center;">${list.cnslr}</td>
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}</td>
							</c:when>
							<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}</td>
								<!-- 상담이력 -->
								<c:set var="cnslDate" value="(${egov:convertDate(list.cnslDtlDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')})" />
								<td style="text-align:center;">
									${list.cnslDtlCntn} 
									<c:if test="${cnslDate eq '()'}">
									</c:if> 
									<c:if test="${cnslDate ne '()'}">
										${cnslDate}
									</c:if>
								</td>
								<!-- 가입상태 -->
								<td style="text-align:center;">${list.statNo}</td>
								
								<!-- 가입일 -->
								<td style="text-align:center;">${list.joinDt}</td>

								<!-- 할인 대상 여부 -->
								<c:if test="${opmInfMap.b2bStts ne 'WEDDING'}">
									<td style="text-align:center;">
										<c:choose>
											<c:when test="${list.trueCount > '2'}"> Y </c:when>
											<c:otherwise> N </c:otherwise>
										</c:choose>
									</td>
								</c:if>
								<!-- 대명 회원번호 -->
								<td style="text-align:center;">${list.idNo}</td>
							</c:when>
							<c:when test="${opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								
								<!-- 가입상태 -->
								<td style="text-align:center;">${list.callStts}</td>
								
								<!-- 가입일 -->
								<td style="text-align:center;">${list.joinDt}</td>
							</c:when>
							<c:when test="${loginMap.id eq 'kbsawon' }">
							</c:when>
							<c:otherwise>
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								
								<!-- 상담가능시간대 -->
								<c:if test="${opmInfMap.calltimeYn eq 'Y'}">
									<td style="text-align:center;">${list.calltime}</td>
								</c:if>
								
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}</td>
								
								<!-- 상담자 -->
								<c:if test="${loginMap.id ne 'hansawon' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager'}">
									<td style="text-align:center;">${list.cnslr}</td>
								</c:if>
							</c:otherwise>
						</c:choose>

						<c:if test="${loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
								
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}</td>
								
								<!-- 상담자 -->
								<td style="text-align:center;">${list.cnslr}</td>
						</c:if>
						
						<!-- 메모 -->
						<c:if test="${opmInfMap.memoYn eq 'Y' and loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' and loginMap.id ne 'weddingsawon' and loginMap.id ne 's1sawon' and opmInfMap.b2bStts ne 'KBCAR'}">
							<td style="text-align:center;">${list.memo}</td>
						</c:if>
						
						<!-- agentCode1 (CI값) -->
						<c:if test="${loginMap.id eq 'smartlife' or loginMap.id eq 'smartmobile' }">
							<td style="text-align:center;">${list.agentCode1}</td>
						</c:if>
						
						<!-- 상담이력 -->
						<c:set var="cnslDate" value="(${egov:convertDate(list.cnslDtlDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')})" />
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon' or ((opmInfMap.b2bStts eq 'ONLIFECC' or opmInfMap.b2bStts eq 'EZWEL' or opmInfMap.b2bStts eq 'TMON') and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon') ) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
							<td style="text-align:center;">
								<c:if test="${(list.callStts eq '가입취소' and not empty list.cnslDtlCntn) or (loginMap.id eq 'ezweltm' or loginMap.id eq 'ezwel' or loginMap.id eq 'tmontm' or loginMap.id eq 'tmon' or loginMap.id eq 'interparktm' or loginMap.id eq 'interpark' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon') }">
									${list.cnslDtlCntn} 
									<c:if test="${cnslDate eq '()'}">
										
									</c:if> 
									<c:if test="${cnslDate ne '()'}">
										${cnslDate}
									</c:if>
								</c:if>
							</td>
						</c:if>
						
						<!-- 판매자 연락처(SMART, SMARTHOMEPLUS) -->
						<c:if test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'SMARTHOMEPLUS'}">
							<td style="text-align:center;">${list.sllrCtel}</td>				
						</c:if>							
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		</table>
	</body>
</html>