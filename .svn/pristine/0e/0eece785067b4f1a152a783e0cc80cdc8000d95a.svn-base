<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMACounselList.jsp
	프로그램 명 : 	외주업체 상담관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.26
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.26				김필기				최초작성
	2016.05.20				김필기				최초작성
	######################################################################
-->

<c:set var="loginMap" value="${admLgnMap}" />

<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />

<form name="excelFrm" method="post" action="excel.do">
	<input type="hidden" name="f" id="fExcel" value="${rtnMap.f}" />
	<input type="hidden" name="q" id="qExcel" value="${rtnMap.q}" />
	<input type="hidden" name="callStts" id="callSttsExcel" value="${rtnMap.callStts}" />	
	<input type="hidden" name="strtDt" id="strtDtExcel" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" id="endDtExcel" value="${rtnMap.endDt}" />
</form>

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		${((opmInfMap.b2bStts eq 'ONLIFECC') or (opmInfMap.b2bStts eq 'EZWEL')) ? '등록일 : ' : '신청일 : '} 
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${rtnMap.strtDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${rtnMap.endDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		
		&nbsp;&nbsp;	
		
		<select name="f" id="f">
			<c:if test="${opmInfMap.idNoYn eq 'Y'}">
				<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>
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
				</option>
			</c:if>
			<c:if test="${loginMap.id eq 'lguplus' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
				<option value="25" <c:if test="${rtnMap.f eq '25'}">selected</c:if>>U+가입번호</option>
			</c:if>
			<c:if test="${opmInfMap.b2bStts eq 'LGU' or opmInfMap.b2bStts eq 'MODETOUR' or loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon'}">
				<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>
					<c:choose>
						<c:when test="${loginMap.id eq 'lguplus' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">실제 판매자 이름</c:when>
						<c:otherwise>판매사원 명</c:otherwise>
					</c:choose>
				</option>
			</c:if>
			<c:if test="${opmInfMap.agentNmYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
				<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>
				<c:if test="${loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon' }">판매자 소속</c:if>
				<c:if test="${loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon' }"> 대리점명 </c:if>
				</option>
			</c:if>
			<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
				<option value="26" <c:if test="${rtnMap.f eq '26'}">selected</c:if>>대리점/직영점코드</option>
			</c:if>
			<c:if test="${opmInfMap.nameYn eq 'Y' and (loginMap.roleCd ne 'ROLE_00024' or opmInfMap.b2bStts eq 'WEDDING')}">
				<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고객명</option>
			</c:if>
			<c:if test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00007'}">
				<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>고객 연락처</option>
				<option value="6" <c:if test="${rtnMap.f eq '6'}">selected</c:if>>상담자</option>
			</c:if>
			<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024' and opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'KBCAR'}">
				<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>고객 연락처(핸드폰)</option>
			</c:if>
			<c:if test="${loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon' and loginMap.id ne 'hansawon' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager'}">
				<c:choose>
					<c:when test="${opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE' or opmInfMap.b2bStts eq 'KBCAR'}"></c:when>
					<c:otherwise><option value="6" <c:if test="${rtnMap.f eq '6'}">selected</c:if>>상담자</option></c:otherwise>
				</c:choose>
			</c:if> 
			<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
				<option value="7" <c:if test="${rtnMap.f eq '7'}">selected</c:if>>코드(판매사)</option>
			</c:if>
			<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
				<option value="8" <c:if test="${rtnMap.f eq '8'}">selected</c:if>>CODE(판매사)</option>
			</c:if>
			<c:if test="${opmInfMap.hanssMbspNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
				<option value="12" <c:if test="${rtnMap.f eq '12'}">selected</c:if>>한샘 통합 멤버십</option>
			</c:if>
			<c:if test="${opmInfMap.mbspNumYn eq 'Y'}">
				<option value="13" <c:if test="${rtnMap.f eq '13'}">selected</c:if>>멤버십 번호</option>
			</c:if>
			<c:if test="${opmInfMap.sllrNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon' } ">
				<option value="14" <c:if test="${rtnMap.f eq '14'}">selected</c:if>>판매자 번호</option>
			</c:if>
			<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'SONE'}">
				<option value="15" <c:if test="${rtnMap.f eq '15'}">selected</c:if>>판매자 소속</option>
			</c:if>
			<c:if test="${opmInfMap.funnelYn eq 'Y'}">
				<option value="16" <c:if test="${rtnMap.f eq '16'}">selected</c:if>>
					<c:if test="${loginMap.id ne 'smartlife' and loginMap.id ne 'smartmobile'}">인입경로</c:if>
					<c:if test="${loginMap.id eq 'smartlife' or loginMap.id eq 'smartmobile'}">채널</c:if>
				</option>
			</c:if>
			<c:if test="${opmInfMap.jauNumYn eq 'Y'}">
				<option value="17" <c:if test="${rtnMap.f eq '17'}">selected</c:if>>자유투어 예약번호</option>
			</c:if>
			<c:if test="${opmInfMap.dmTourNumYn eq 'Y'}">
				<option value="19" <c:if test="${rtnMap.f eq '19'}">selected</c:if>>대명 투어몰 예약번호</option>
			</c:if>
			<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y'}">
				<option value="18" <c:if test="${rtnMap.f eq '18'}">selected</c:if>>판매 대리점명</option>
			</c:if>
			<c:if test="${opmInfMap.tourBookNoYn eq 'Y'}">
				<option value="20" <c:if test="${rtnMap.f eq '20'}">selected</c:if>>여행예약번호</option>
			</c:if>
			<c:if test="${loginMap.id eq 'modetour' or loginMap.id eq 'modesawon' or loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon'}">
				<option value="21" <c:if test="${rtnMap.f eq '21'}">selected</c:if>>고객등록번호</option>
			</c:if>
			<c:if test="${opmInfMap.lotteCardPayYn eq 'Y' and loginMap.id ne 'hansawon'}">
				<option value="22" <c:if test="${rtnMap.f eq '22'}">selected</c:if>>롯데카드 결제상태</option>
			</c:if>
			<c:if test="${loginMap.id eq 'hansawon'}">
				<option value="23" <c:if test="${rtnMap.f eq '23'}">selected</c:if>>가입일</option>
			</c:if>
			<%-- <c:if test="${loginMap.id eq 'lguplus'}">
				<option value="24" <c:if test="${rtnMap.f eq '24'}">selected</c:if>>판매사 구분</option>
			</c:if> --%>
			<!-- 웨딩 사원 페이지 검색 조건 -->
			<c:if test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
				<option value="4"  <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고객명</option>
				<option value="32" <c:if test="${rtnMap.f eq '32'}">selected</c:if>>웨딩의 여신 친구 초대코드</option>
				<option value="15" <c:if test="${rtnMap.f eq '15'}">selected</c:if>>판매사 소속</option>
				<option value="2"  <c:if test="${rtnMap.f eq '2'}">selected</c:if>>판매사 성함</option>
				<option value="1"  <c:if test="${rtnMap.f eq '1'}">selected</c:if>>대명 회원번호</option>
			</c:if>
			<c:if test="${opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
				<option value="4"  <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고객명</option>
				<option value="2"  <c:if test="${rtnMap.f eq '2'}">selected</c:if>>사원명</option>
				<option value="14" <c:if test="${rtnMap.f eq '14'}">selected</c:if>>사번</option>
				<option value="15" <c:if test="${rtnMap.f eq '15'}">selected</c:if>>지사</option>
			</c:if>
			<c:if test="${opmInfMap.b2bStts eq 'KBCAR' }">
				<option value="33"  <c:if test="${rtnMap.f eq '4'}">selected</c:if>>계약자명</option>
				<option value="3"  <c:if test="${rtnMap.f eq '2'}">selected</c:if>>상사명</option>
				<option value="6" <c:if test="${rtnMap.f eq '6'}">selected</c:if>>상담자</option>
			</c:if>
			<!-- SMART, SMARTHOMEPLUS 검색 조건 추가 -->
			<c:if test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'SMARTHOMEPLUS'}">
				<option value="2"  <c:if test="${rtnMap.f eq '2'}">selected</c:if>>판매사원 명</option>
				<option value="34"  <c:if test="${rtnMap.f eq '34'}">selected</c:if>>판매자 연락처</option>
				<option value="35" <c:if test="${rtnMap.f eq '35'}">selected</c:if>>점코드</option>				
			</c:if>
		</select>
	
		<input type="text" name="q" id="q" value="${rtnMap.q}" class="inputType w146" maxlength="50" />
		
		<select name="callStts" id="callStts" >
			<c:choose>
				<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
					<option value="">[상담현황선택]</option>
				</c:when>
				<c:otherwise>
					<option value="">[상담확인선택]</option>
				</c:otherwise>
			</c:choose>
			<option value="no" <c:if test="${'no' eq rtnMap.callStts}">selected</c:if>>미상담</option> 
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${cdlist.cd eq rtnMap.callStts}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>					
		</select>
		
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>	
	
	<p>전체 게시물 수 : ${rtnMap.list[0].totCnt}</p>
	
	<table class="table table-bordered table-hover" style="font-size:12px;">
		<caption style="display: none;">외주업체 상담 관리</caption>
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

				<!-- 계약번호 -->
				<c:if test="${opmInfMap.contractNoYn eq 'Y'}">
					<th style="width:120px; vertical-align:middle;">
						계약번호
					</th>
				</c:if>
				 
				<!-- 웨딩의 여신 친구 초대코드 -->
				<c:if test="${opmInfMap.inviteCodeYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}">
							<th style="width:120px; vertical-align:middle;">
								웨딩의 여신<br>친구 초대코드
							</th>
						</c:when>
						<c:otherwise>
							<th style="width:120px; vertical-align:middle;">
								친구 초대코드
							</th>
						</c:otherwise>
					</c:choose>
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
						<%-- 매장코드 --%>
						점코드
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
								대명<br/>가입번호(idNo)
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
				
				<!-- 채널유형코드 -->
				<c:if test="${opmInfMap.uCmmnCdYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">
						채널유형코드
					</th>
				</c:if>
				<!-- 채널유형코드명 -->
				<c:if test="${opmInfMap.uCmmnCdNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
					<th style="width:100px; vertical-align:middle;">
						채널유형코드명
					</th>
				</c:if>
				<!-- 유치대리점명 -->
				<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.id eq 'lgusawon'}">
					<th style="width:100px; vertical-align:middle;">
						유치대리점명
					</th>
				</c:if>
				<!-- 대리점/직영점 코드 -->
				<c:if test="${opmInfMap.uDlrCdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
					<th style="width:100px; vertical-align:middle;">
						대리점/<br/>직영점 코드
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
				
				<!-- 판매사구분
				<c:if test="${opmInfMap.b2bStts eq 'LGU' }">
					<th style="width:100px; vertical-align:middle;">판매사 구분</th>
				</c:if>
				 -->
				 
				<!-- 가입일 -->
				<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
					<th style="width:100px; vertical-align:middle;">
						가입일
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
				
				<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y' and (loginMap.id eq 'hanssem' or loginMap.id eq 'hansawon')}">
					<th style="width:100px; vertical-align:middle;">
						판매자 이름
					</th>
				</c:if>
				
				<!-- 유치대리점명 -->
				<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.id eq 'lguplus'}">
					<th style="width:100px; vertical-align:middle;">
						유치대리점명
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
					</th>
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
						결합 상품2
					</th>
				</c:if>
				
				<!-- 3구좌 상품명 -->
				<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
					<th style="width:160px; vertical-align:middle;">
						3구좌 상품명
					</th>
				</c:if>
				
				<!-- 주 계약 -->
				<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
					<th style="width:100px; vertical-align:middle;">주 계약	</th>
				</c:if>
				
				<!-- 카드결제 유무 -->
				<c:if test="${opmInfMap.cardPayYn eq 'Y'}">
					<th style="width:100px; vertical-align:middle;">
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
				<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts ne 'SONE' and (loginMap.roleCd ne 'ROLE_00024' or (loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'tmon' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon') or (opmInfMap.b2bStts eq 'WEDDING'))}">
					<th style="width:100px; vertical-align:middle;">
						고객명
					</th>
				</c:if>
				
				<!-- 판매사 소속 (업체명) -->
				<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						판매사 소속<br>(업체명)
					</th>
				</c:if>
				
				<!-- 판매사원 성명 -->
				<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024' and opmInfMap.b2bStts ne 'KBCAR'}">
							<th style="width:100px; vertical-align:middle;">판매사<br>성함</th>
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
				
				<!-- U+ 서비스명, 상품번호 -->
				<c:if test="${opmInfMap.uProdNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
						U+ 서비스명
					</th>
				</c:if>
				<c:if test="${opmInfMap.uProdNoYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:100px; vertical-align:middle;">
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
				<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon' and opmInfMap.b2bStts ne 'SONE' and opmInfMap.b2bStts ne 'KBCAR'}">
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
				<c:if test="${opmInfMap.travelYn eq 'Y'}">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}">
							<c:if test="${loginMap.roleCd eq 'ROLE_00007'}">
								<th style="width:120px; vertical-align:middle;">
									희망 허니문 여행지
								</th>
							</c:if>
							<c:if test="${loginMap.roleCd eq 'ROLE_00024'}">
							</c:if>
						</c:when>
						<c:otherwise>
							<th style="width:120px; vertical-align:middle;">
								여행지
							</th>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<!-- 희망 허니문 출발일 -->
				<c:if test="${opmInfMap.weddingDateYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd ne 'ROLE_00024'}">
					<th style="width:120px; vertical-align:middle;">
						희망 허니문 출발일
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
							상담<br>신청일
						</th>
						
						<!-- 상담현황 -->
						<th style="width:100px; vertical-align:middle;">
							상담<br>현황
						</th>
						
						<!-- 상담확인 >
						<th style="width:100px; vertical-align:middle;">
							상담확인
						</th -->
						
						<!-- 상담이력 -->
						<th style="width:200px; vertical-align:middle;">
							상담이력
						</th>
						
						<!-- 가입상태 -->
						<th style="width:80px; vertical-align:middle;">
							가입<br>상태
						</th>
						
						<!-- 가입일 -->
						<th style="width:100px; vertical-align:middle;">
							가입일
						</th>
						
						<!-- 대명 회원번호 -->
						<th style="width:100px; vertical-align:middle;">
							대명<br>회원번호
						</th>
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
					<c:when test="${loginMap.id eq 'kbsawon' }">
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
				
				<!-- 상담이력 -->
				<c:if test="${loginMap.id eq 'dmsawon' or loginMap.id eq 'jausawon' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager' or ((opmInfMap.b2bStts eq 'ONLIFECC' or opmInfMap.b2bStts eq 'EZWEL' or opmInfMap.b2bStts eq 'TMON') and (loginMap.id ne 'ezwel' and loginMap.id ne 'tmon' and loginMap.id ne 'interpark') ) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon' or loginMap.id eq 'lgstay001'}">
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
						
						<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
						
						
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
							<td style="text-align:center;"> ${ list.unqNo }</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'SMART' and loginMap.roleCd eq 'ROLE_00007'}">
									<td style="text-align:center;"> ${list.mainContType} [1]</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 계약번호 -->
						<c:if test="${opmInfMap.contractNoYn eq 'Y'}">
							<td style="text-align:center;"> ${ list.contractNo } [2]</td>
						</c:if>
						
						<!-- 웨딩의 여신 친구 초대코드 --> 
						<c:if test="${opmInfMap.inviteCodeYn eq 'Y'}">
							<td style="text-align:center;"> ${ list.inviteCode } [3]</td>
						</c:if>
						
						<!-- 고객등록번호 -->
						<c:if test="${loginMap.id eq 'modetour' or loginMap.id eq 'modesawon'}">
							<td style="text-align:center;"> ${ list.oscCnslSeq } [4]</td>
						</c:if>
						
						<!-- 고객등록번호 -->
						<c:if test="${loginMap.id eq 'hansawon' or loginMap.id eq 'hanssem'}">
							<td style="text-align:center;"> ${list.hanssMbspNum}_${ list.oscCnslSeq } [5]</td>
						</c:if>
						
						<!-- 여행예약번호 --> 
						<c:if test="${opmInfMap.tourBookNoYn eq 'Y'}">
							<td style="width:100px; text-align:center;">
								${ list.tourBookNo } [6]
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
							[7]
							</td>
						</c:if>

						<!-- 코드(판매사) -->
						<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
							<td style="text-align:center;">${list.agentCode1}[8]</td>
						</c:if>
						
						<!-- CODE(판매사) -->
						<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
							<td style="text-align:center;">${list.agentCode2}[9]</td>
						</c:if>
						
						<!-- 한샘 통합 멤버십 -->
						<c:if test="${opmInfMap.hanssMbspNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
							<td style="text-align:center;">${list.hanssMbspNum}[10]</td>
						</c:if>
						
						<!-- 멤버십 번호 -->
						<c:if test="${opmInfMap.mbspNumYn eq 'Y'}">
							<td style="text-align:center;">${list.mbspNum}[11]</td>
						</c:if>
						
						<!-- 판매자 번호 -->
						<c:if test="${opmInfMap.sllrNumYn eq 'Y' and loginMap.id ne 'hanssem' and loginMap.id ne 'hansawon'}">
							<td style="text-align:center;">${list.sllrNum}[12]</td>
						</c:if>
						
						<!-- 사원명 -->
						<c:if test="${opmInfMap.agentEmpNmYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.agentEmpNm}[13]</td>
						</c:if>
						
						<!-- 사번 -->
						<c:if test="${opmInfMap.agentEmpNumYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.agentEmpNum}[14]</td>
						</c:if>
						
						<!-- 지사 -->
						<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.sllrPart}[15]</td>
						</c:if>
						
						<!-- 판매자 소속 -->
						<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'SONE'}">
							<td style="text-align:center;">${list.sllrPart}[16]</td>
						</c:if>
						
						<!-- 판매 대리점명 -->
						<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y'}">
							<td style="text-align:center;">${list.sllrAgentNm}[17]</td>
						</c:if>
						
						<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
							<!-- 코드1 --> 
							<c:if test="${opmInfMap.idNoYn eq 'Y'}">
								<td style="text-align:center;">${list.prodNo}[18]</td>
							</c:if>
							<!-- 코드2 -->
							<td style="text-align:center;">${list.statNo}[19]</td>
						</c:if>
						
						<!-- 매장코드 -->
						<c:if test="${opmInfMap.agentCdYn eq 'Y'}">
							<%--<td style="text-align:center;">${list.agentCd}</td>--%>
							<td style="text-align:center;">${list.agentCd2}[20]</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024'}">
									<td style="text-align:center;"> ${list.mainContType} [21]</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 대명 가입번호 -->
						<c:if test="${opmInfMap.idNoYn eq 'Y'}">
							<td style="text-align:center;">${list.idNo}[22]</td>
						</c:if>
						
						<!-- U+가입번호 -->
						<c:if test="${opmInfMap.homePrdNumYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.homePrdNum}[23]</td>
						</c:if>

						<!-- 채널유형코드 -->
						<c:if test="${opmInfMap.uCmmnCdYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.uCmmnCd}[24]</td>
						</c:if>
						<!-- 채널유형코드명 -->
						<c:if test="${opmInfMap.uCmmnCdNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.uCmmnCdNm}[25]</td>
						</c:if>
						<!-- 유치대리점명 -->
						<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.uDlrNm}[26]</td>
						</c:if>

						<!-- 대리점/직영점 코드 -->
						<c:if test="${opmInfMap.uDlrCdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.uDlrCd}[27]</td>
						</c:if>

						<!-- 상담등록자사번 -->
						<c:if test="${opmInfMap.uIndcEmpnoYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.uIndcEmpno}[28]</td>
						</c:if>

						<!-- 상담등록자마당 ID -->
						<c:if test="${opmInfMap.uIntgUserIdYn eq 'Y' and (loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager')}">
							<td style="text-align:center;">${list.uIntgUserId}[29]</td>
						</c:if>
						
						<!-- 도매직영점 판매구분 -->
						<c:if test="${opmInfMap.salesTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00024'}">
									<td style="text-align:center;">${list.salesType}[30]</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 도매직영점 POS 코드 -->
						<c:if test="${opmInfMap.whPosCdYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.whPosCd}[31]</td>
						</c:if>
						
						<!-- 도매판매점명 -->
						<c:if test="${opmInfMap.whStoreNmYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and loginMap.id ne 'lgumanager'}">
							<td style="text-align:center;">${list.whStoreNm}[32]</td>
						</c:if>
						<!-- 판매사구분 
						<c:if test="${opmInfMap.b2bStts eq 'LGU' }">
							<th style="width:100px; vertical-align:middle;">${list.agentGubun}</th>
						</c:if>
						-->
						
						<!-- 가입일 -->
						<c:if test="${(opmInfMap.idNoYn eq 'Y' and loginMap.roleCd eq 'ROLE_00024' and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon')) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">
							<td style="text-align:center;">${list.joinDt}[33]</td>
						</c:if>
						
						<!-- 해약일자 -->
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
							<td style="text-align:center;">
								<c:if test="${list.statNo == '5'}">
									<!-- ${list.eventCompDay}	-->
									${list.resnProcDay}
								</c:if>
								[34]
							 </td>
						</c:if>
	
						<!-- 납입회차 -->
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">
							<td style="text-align:center;">
								<c:if test="${list.statNo > '2'}">
									${list.trueCount}
								</c:if>
								[35]
							</td>
						</c:if>
							
						<!-- 판매사원 성명 -->
						<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'SONE' and opmInfMap.b2bStts ne 'KBCAR'}">
									<td style="text-align:center;">${list.agentEmpNm}[36]</td>
								</c:when>
							</c:choose>
						</c:if>
						
						<!-- lguplus 유치대리점명 -->
						<c:if test="${opmInfMap.uDlrNmYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.uDlrNm}[37]</td>
						</c:if>
						
						<!-- 롯데카드 결제상태 -->
						<c:if test="${opmInfMap.lotteCardPayYn eq 'Y' and loginMap.id ne 'hansawon'}">
							<td style="width:100px; vertical-align:middle;">
								<c:if test="${list.lotteCardPay eq '1' }"> 35개월 할부 결제 완료 </c:if>
								<c:if test="${list.lotteCardPay eq '2' }"> 35개월 할부 미결제(롯데카드미소지포함) </c:if>
								[38]
							</td>
						</c:if>
						
						<!-- 가입 구좌 -->
						<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}"></c:when>
								<c:otherwise>
									<td style="width:100px; text-align:center;">
										${list.joinProd}
										[39]
									</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 대리점명 -->
						<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'KBCAR'}">
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">${list.agentNm}[40]</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 담당자 연락처 -->
						<c:if test="${opmInfMap.agentEmpTelYn eq 'Y' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager'  and opmInfMap.b2bStts ne 'KBCAR'}">
							<td style="text-align:center;">${list.agentEmpTel}[41]</td>
						</c:if>
						
						<!-- 가입회사명 -->
						<c:if test="${opmInfMap.companyNmYn eq 'Y'}">
							<td style="text-align:center;">${list.companyNm}[42]</td>
						</c:if>
						
						<!-- 담당자명 -->
						<c:if test="${opmInfMap.b2bEmpCdYn eq 'Y'}">
							<td style="text-align:center;">${list.b2bEmpCd}[43]</td>
						</c:if>
						
						<!-- 영업채널1 -->
						<c:if test="${opmInfMap.code1Yn eq 'Y'}">
							<td style="text-align:center;">${list.code1}[44]</td>
						</c:if>
						
						<!-- 영업채널2 -->
						<c:if test="${opmInfMap.code3Yn eq 'Y'}">
							<td style="text-align:center;">${list.code3}[45]</td>
						</c:if>
						
						<!-- 판매사코드/사번 -->
						<c:if test="${opmInfMap.code2Yn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'KBCAR'}">
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">${list.code2}[46]</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- 주문번호 -->
						<c:if test="${opmInfMap.orderNumYn eq 'Y'}">
							<td style="text-align:center;">${list.orderNum}[47]</td>
						</c:if>
						
						<!-- 회원번호 -->
						<c:if test="${opmInfMap.b2bStts eq 'KBCAR' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.idNo}[48]</td>
						</c:if>
						
						<!-- 계약자명 -->
						<c:if test="${opmInfMap.contractorNameYn eq 'Y'}">
							<td style="text-align:center;">${list.contractorName}[49]</td>
						</c:if>
						
						<!-- 판매사원 사번 -->
						<c:if test="${opmInfMap.agentEmpNumYn eq 'Y' and opmInfMap.b2bStts ne 'SONE'}">
							<td style="text-align:center;">${list.agentEmpNum}[50]</td>
						</c:if>
						
						<!-- NUMBER(판매사) -->
						<c:if test="${opmInfMap.agentNumYn eq 'Y'}">
							<td style="text-align:center;">${list.agentNum}[51]</td>
						</c:if>
						
						<!-- 기타(판매사) -->
						<c:if test="${opmInfMap.agentEtcYn eq 'Y'}">
							<td style="text-align:center;">${list.agentEtc}[52]</td>
						</c:if>
						
						<!-- 고유번호 -->
						<c:if test="${opmInfMap.agentUnqNumYn eq 'Y'}">
							<td style="text-align:center;">${list.agentUnqNum}[53]</td>
						</c:if>
						
						<!-- 고객명 -->
						<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts eq 'SONE'}">
							<td style="text-align:center;">
								${list.name}
								[54]
							</td>
						</c:if>
				
						<!-- 고객 연락처(핸드폰) -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
							<td style="text-align:center;">
								${list.hp}
								[55]
							</td>
						</c:if>
						
						<!-- 1구좌 상품명 -->
						<c:if test="${opmInfMap.prdctNmYn eq 'Y'}">
							<td style="text-align:center;">${list.prdctNm}[56]</td>
						</c:if>
		
						<!-- 결합 상품 -->
						<c:if test="${opmInfMap.fusionPrdctYn eq 'Y'}">
							<td style="text-align:center;">${list.fusionPrdctNm}[57]</td>
						</c:if>
						
						<!-- 2구좌 상품명 -->
						<c:if test="${opmInfMap.prdctNm2Yn eq 'Y'}">
							<td style="text-align:center;">${list.prdctNm2}[58]</td>
						</c:if>
		
						<!-- 결합 상품2 -->
						<c:if test="${opmInfMap.fusionPrdct2Yn eq 'Y'}">
							<td style="text-align:center;">${list.fusionPrdctNm2}[59]</td>
						</c:if>
						
						<!-- 3구좌 상품명 -->
						<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
							<td style="text-align:center;">${list.prdctNm3}[60]</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'SONE' and loginMap.roleCd eq 'ROLE_00007'}">
							<td style="text-align:center;">${list.mainContType}[61]</td>
						</c:if>
						
						<!-- 카드결제 유무 -->
						<c:if test="${opmInfMap.cardPayYn eq 'Y'}">
							<td style="text-align:center">
								<c:choose>
									<c:when test="${list.cardPay eq 'Y'}">카드결제</c:when>
									<c:when test="${list.cardPay eq 'N'}">일반결제</c:when>
								</c:choose>
								[62]
							</td>
						</c:if>
						
						<!-- 주 계약 -->
						<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd eq 'ROLE_00007'}">
									<td style="text-align:center;"> ${list.mainContType} [63]</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 고객명 -->
						<c:if test="${opmInfMap.nameYn eq 'Y' and opmInfMap.b2bStts ne 'SONE' and (loginMap.roleCd ne 'ROLE_00024' or (loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'tmon' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon') or (opmInfMap.b2bStts eq 'WEDDING'))}">
							<c:choose>
								<c:when test="${(opmInfMap.b2bStts eq 'ONLIFECC') or (opmInfMap.b2bStts eq 'EZWEL')}">
									<td style="text-align:center;">
										<c:if test="${not empty list.name}">
											${fn:substring(list.name, 0, 1)}*${fn:substring(list.name, 2, fn:length(list.name))}
										</c:if>
										[64]
									</td>
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">${list.name}[65]</td>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!-- weddingsawon 판매자 소속 -->
						<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
							<td style="text-align:center;">${list.sllrPart}[66]</td>
						</c:if>
						
						<!-- 판매사원 성명 -->
						<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
									<td style="text-align:center;">${list.agentEmpNm}[67]</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 할인 받을 연락처 (CTN) -->
						<c:if test="${opmInfMap.discountCtnYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.discountCtn}[68]</td>
						</c:if>

						<!-- 할인 받을 명의자 생년월일 -->
						<c:if test="${opmInfMap.discountPinYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.discountPin}[69]</td>
						</c:if>

						<!-- U+가입번호 -->
						<c:if test="${opmInfMap.homePrdNumYn eq 'Y' and loginMap.id eq 'lguplus'}">
							<td style="text-align:center;">${list.homePrdNum}[70]</td>
						</c:if>
						
						<!-- 점포명 -->
						<c:if test="${opmInfMap.storeNmYn eq 'Y'}">
							<td style="text-align:center;">${list.storeNm}[71]</td>
						</c:if>
						
						<!-- U+ 서비스명 -->
						<c:if test="${opmInfMap.uProdNmYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">${list.uProdNm}[72]</td>
						</c:if>
						<!-- U+ 상품번호 -->
						<c:if test="${opmInfMap.uProdNoYn eq 'Y' and opmInfMap.b2bStts eq 'LGU' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">${list.uProdNo}[73]</td>
						</c:if>
						
						<!-- 고객 연락처(핸드폰) -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024' and opmInfMap.b2bStts ne 'SONE' and opmInfMap.b2bStts ne 'KBCAR'}">
							<td style="text-align:center;">${list.hp}[74]</td>
						</c:if>
						<c:if test="${opmInfMap.b2bStts eq 'KBCAR'}">
							<!-- 계약자 연락처 -->
							<c:if test="${opmInfMap.contractorPhoneYn eq 'Y'}">
								<td style="text-align:center;">${list.contractorPhone}[75]</td>
							</c:if>
							<c:choose>
								<c:when test ="${loginMap.roleCd eq 'ROLE_00007'}">
									<!-- 계약자 생년월일 -->
									<c:if test="${opmInfMap.contractorBirthYn eq 'Y'}">
										<td style="text-align:center;">${list.contractorBirth}[76]</td>
									</c:if>
				
									<!-- 구좌수 -->
									<c:if test="${opmInfMap.orderQtyYn eq 'Y'}">
										<td style="text-align:center;">${list.orderQty}[77]</td>
									</c:if>
									
									<!-- 주계약 서비스1 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}[78]</td>
									</c:if>
					
									<!-- 주계약 서비스2 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}[79]</td>
									</c:if>
									
									<!-- 신용카드사 -->
									<c:if test="${opmInfMap.cardCompanyYn eq 'Y'}">
										<td style="text-align:center;">${list.cardCompany}[80]</td>
									</c:if>
				
									<!-- 카드번호 -->
									<c:if test="${opmInfMap.creditCardNumYn eq 'Y'}">
										<td style="text-align:center;">${list.creditCardNum}[81]</td>
									</c:if>
				
									<!-- 유효기간 -->
									<c:if test="${opmInfMap.validThruYn eq 'Y'}">
										<td style="text-align:center;">${list.validThru}[82]</td>
									</c:if>
									
									<!-- 상사코드 -->
									<c:if test="${opmInfMap.code2Yn eq 'Y'}">
										<td style="text-align:center;">${list.code2}[83]</td>
									</c:if>
				
									<!-- 상사명 -->
									<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentNm}[84]</td>
									</c:if>
				
									<!-- 상사 담당자명 -->
									<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentEmpNm}[85]</td>
									</c:if>
					
									<!-- 상사 연락처 -->
									<c:if test="${opmInfMap.agentEmpTelYn eq 'Y'}">
										<td style="text-align:center;">${list.agentEmpTel}[86]</td>
									</c:if>
									
									<!-- 구매차량번호 -->
									<c:if test="${opmInfMap.plateNumYn eq 'Y'}">
										<td style="text-align:center;">${list.plateNum}[87]</td>
									</c:if>
									
									<!-- 상담시간 -->
									<c:if test="${opmInfMap.calltimeYn eq 'Y'}">
										<td style="text-align:center;">${list.calltime}[88]</td>
									</c:if>
							
									<!-- 주소 -->
									<c:if test="${opmInfMap.addressYn eq 'Y'}">
										<td style="text-align:center;">${list.adr}[89]</td>
									</c:if>
									
									<!-- 비상연락처 -->
									<c:if test="${opmInfMap.hpYn eq 'Y'}">
										<td style="text-align:center;">${list.hp}[90]</td>
									</c:if>
									
									<!-- 이메일 -->
									<c:if test="${opmInfMap.emailYn eq 'Y'}">
										<td style="text-align:center;">${list.email}[91]</td>
									</c:if>
									
									<td style="text-align:center;">${list.termAgree}[92]</td>
									
									<td style="text-align:center;">${list.memo}[93]</td>
								</c:when>
								
								<c:when test ="${loginMap.roleCd eq 'ROLE_00024'}">
									<!-- 주계약 서비스1 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}[94]</td>
									</c:if>
					
									<!-- 주계약 서비스2 -->
									<c:if test="${opmInfMap.mainContService2Yn eq 'Y'}">
										<td style="text-align:center;">${list.mainContService2}[95]</td>
									</c:if>
									
									<!-- 등록일자 -->
									<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[96]</td>
									
									<!-- 가입일자 -->
									<td style="text-align:center;">${list.joinDt}[97]</td>
									
									<!-- 가입상태 -->
									<td style="text-align:center;">${list.statNo}[98]</td>
									
									<!-- 상사코드 -->
									<c:if test="${opmInfMap.code2Yn eq 'Y'}">
										<td style="text-align:center;">${list.code2}[99]</td>
									</c:if>
				
									<!-- 상사명 -->
									<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentNm}[100]</td>
									</c:if>
				
									<!-- 담당자명 -->
									<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
										<td style="text-align:center;">${list.agentEmpNm}[101]</td>
									</c:if>
								</c:when>
							</c:choose>
						</c:if>
						<!-- 고객 연락처(핸드폰) -->
						<c:if test="${opmInfMap.hpYn eq 'Y' and loginMap.id eq 'hansawon'}">
							<td style="text-align:center;">${list.hp}[102]</td>
						</c:if>

						<!-- 가입 구좌 -->
						<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}"></c:when>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd ne 'ROLE_00024'}">
									<td style="width:100px; text-align:center;">
										${list.joinProd}
										[103]
									</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:if>

						<!-- 여행지 -->
						<c:if test="${opmInfMap.travelYn eq 'Y'}">
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}">
									<c:if test="${loginMap.roleCd eq 'ROLE_00007'}">
										<th style="width:120px; vertical-align:middle;">
											${list.travel }
											[104]
										</th>
									</c:if>
									<c:if test="${loginMap.roleCd eq 'ROLE_00024'}">
									</c:if>
								</c:when>
								<c:otherwise>
									<th style="width:120px; vertical-align:middle;">
										${list.travel }
										[105]
									</th>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<!--  희망 허니문 출발일 -->
						<c:if test="${opmInfMap.weddingDateYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center;">
								${list.weddingDate }
								[106]
							</td>
						</c:if>
						
						<!-- 자유투어 예약번호 -->
						<c:if test="${opmInfMap.jauNumYn eq 'Y'}">
							<td style="text-align:center;">
								${list.jauNum }
								[107]
							</td>
						</c:if>
		
						<!-- 대명투어몰 예약번호 -->
						<c:if test="${opmInfMap.dmTourNumYn eq 'Y'}">
							<td style="text-align:center;">
								${list.dmTourNum }
								[108]
							</td>
						</c:if>
		
						<!-- 롯데카드 발급상태 -->
						<c:if test="${opmInfMap.lotteCardYn eq 'Y'}">
							<td style="text-align:center;">
								<c:if test="${list.lotteCard eq '1' }"> 보유 </c:if>
								<c:if test="${list.lotteCard eq '2' }"> 신규발급 </c:if>
								[109]
							</td>
						</c:if>
						
						<!-- skb 가입상태 -->
						<c:if test="${opmInfMap.skbJoinYn eq 'Y'}">
							<td style="text-align:center">${list.skbJoin}[110]</td>
						</c:if>
						
						<!-- 코드(고객) -->
						<c:if test="${opmInfMap.cstmrCodeKrYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrCode1}[111]</td>
						</c:if>
						
						<!-- CODE(고객) -->
						<c:if test="${opmInfMap.cstmrCodeEnYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrCode2}[112]</td>
						</c:if>
						
						<!-- 고객 고유번호 -->
						<c:if test="${opmInfMap.cstmrUnqNumYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrUnqNum}[113]</td>
						</c:if>
						
						<!-- 카드번호 -->
						<c:if test="${opmInfMap.cardNumYn eq 'Y' and loginMap.roleCd ne 'ROLE_00024'}">
							<td style="text-align:center">${list.cardNum}[114]</td>
						</c:if>
						
						<!-- NUMBER(고객) -->
						<c:if test="${opmInfMap.cstmrNumYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrNum}[115]</td>
						</c:if>
						
						<!-- 기타(고객) -->
						<c:if test="${opmInfMap.cstmrEtcYn eq 'Y'}">
							<td style="text-align:center">${list.cstmrEtc}[116]</td>
						</c:if>
						<c:choose>
							<c:when test="${loginMap.id eq 'interpark' or loginMap.id eq 'ezwel' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon' or loginMap.id eq 'tmon' }">
								<!-- 가입상태 -->
								<td style="text-align:center;">${list.statNo}[117]</td>
								
								<!-- 가입일 -->
								<td style="text-align:center;">${list.joinDt}[118]</td>
								<c:if test="${loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' }">
									<!-- 등록일 -->
									<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[119]</td>
								</c:if>
							</c:when>
							<c:when test="${(opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE') and loginMap.roleCd ne 'ROLE_00024'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[120]</td>
								<!-- 상담자 -->
								<td style="text-align:center;">${list.cnslr}[121]</td>
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}[122]</td>
							</c:when>
							<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[123]</td>
								<!-- 상담현황  -->
								<td style="text-align:center;">${list.callStts}[124]</td >
								<!-- 상담이력 -->
								<c:set var="cnslDate" value="(${egov:convertDate(list.cnslDtlDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')})" />
								<td style="text-align:center;">
									${list.cnslDtlCntn} 
									<c:if test="${cnslDate eq '()'}">
									</c:if> 
									<c:if test="${cnslDate ne '()'}">
										${cnslDate}
									</c:if>
									[125]
								</td>
								<!-- 가입상태 -->
								<td style="text-align:center;">${list.statNo}[126]</td>
								
								<!-- 가입일 -->
								<td style="text-align:center;">${list.joinDt}[127]</td>

								<!-- 대명 회원번호 -->
								<td style="text-align:center;">${list.idNo}[128]</td>
							</c:when>						
							<c:when test='${opmInfMap.b2bStts eq "SONE" and loginMap.roleCd eq "ROLE_00024"}'>							
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[129]</td>
								
								<!-- 가입상태 -->
								<%-- <td style="text-align:center;">${list.statNo}[130]~</td> --%>
								<td style="text-align:center;">${list.callStts}[130]~</td>
								
								<!-- 가입일 -->
								<td style="text-align:center;">${list.joinDt}[131]~</td>
							</c:when>
							<c:when test="${loginMap.id eq 'kbsawon' }">
							</c:when>
							<c:otherwise>
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[132]</td>
								
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}[133]</td>
								
								<!-- 상담자 -->
								<c:if test="${loginMap.id ne 'hansawon' and loginMap.id ne 'lgusawon' and loginMap.id ne 'lgumanager'}">
									<td style="text-align:center;">${list.cnslr}[134]</td>
								</c:if>
							</c:otherwise>
						</c:choose>

						<c:if test="${loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon'}">
								<!-- 상담신청일 -->
								<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}[135]</td>
								
								<!-- 상담확인 -->
								<td style="text-align:center;">${list.callStts}[136]</td>
								
								<!-- 상담자 -->
								<td style="text-align:center;">${list.cnslr}[137]</td>
						</c:if>
						
						<!-- 메모 -->
						<c:if test="${opmInfMap.memoYn eq 'Y' and loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' and loginMap.id ne 'weddingsawon' and loginMap.id ne 's1sawon' and opmInfMap.b2bStts ne 'KBCAR'}">
							<td style="text-align:center;">${list.memo}[138]</td>
						</c:if>
						
						<!-- 상담이력 -->
						<c:if test="${loginMap.id eq 'lgstay001'}">
							<td style="text-align:center;">${list.cnslDtlCntn}[139]</td>
						</c:if>
						<!-- 상담이력 -->
						<c:set var="cnslDate" value="(${egov:convertDate(list.cnslDtlDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')})" />
						<c:if test="${loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon' or ((opmInfMap.b2bStts eq 'ONLIFECC' or opmInfMap.b2bStts eq 'EZWEL' or opmInfMap.b2bStts eq 'TMON') and (loginMap.id ne 'interpark' and loginMap.id ne 'ezwel' and loginMap.id ne 'tmon') ) or loginMap.id eq 'hansawon' or loginMap.id eq 'modesawon'}">         
							<td style="text-align:center;">
								<c:if test="${(list.callStts eq '가입취소' and not empty list.cnslDtlCntn) or (loginMap.id eq 'ezweltm' or loginMap.id eq 'ezwel' or loginMap.id eq 'tmontm' or loginMap.id eq 'tmon' or loginMap.id eq 'interparktm' or loginMap.id eq 'interpark' or loginMap.id eq 'jausawon' or loginMap.id eq 'dmsawon')}">
									${list.cnslDtlCntn} 
									<c:if test="${cnslDate eq '()'}">
										
									</c:if> 
									<c:if test="${cnslDate ne '()'}">
										${cnslDate}
									</c:if>
								</c:if>
								[140]
							</td>
						</c:if>
						
						<!-- 판매자 연락처(SMART, SMARTHOMEPLUS) -->
						<c:if test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'SMARTHOMEPLUS'}">
							<td style="text-align:center;">${list.sllrCtel}[141]</td>				
						</c:if>						
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<c:choose>
		<c:when test="${(loginMap.id eq 'interparkdb') or (loginMap.id eq 'ezweldb') or (loginMap.id eq 'tmondb')}">
			<a href="javascript:excelUploadPop();" class="btn btn-info2">엑셀 업로드</a>
		</c:when>
		<c:when test="${loginMap.id eq 'jautour'}"></c:when>
		<c:when test="${loginMap.id eq 'lgusawon'}">
			<a href= "javascript:lguExcelDownload();" class="btn btn-info2">전체 DB 다운로드</a>
			<a href="javascript:excel();" class="btn btn-info2">엑셀 다운로드</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:excel();" class="btn btn-info2">엑셀 다운로드</a>
		</c:otherwise>
	</c:choose>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>

<script type="text/javascript">
	//금일 날짜 가져온 후 LGU 엑셀 다운로드
	function lguExcelDownload(){
		let date = new Date();
		let year = date.getFullYear();
		let month = date.getMonth();
		let day = date.getDate();
		
		month++;
		
		if(month < 10) {
			month = "0" + month;
		}
		
		if(day < 10) {
			day = "0" + day;
		}
		
		let today = year.toString()+month.toString()+day.toString();
		
		//window.location.assign("/web/common/editor/LGUExcel/LGUDataExcel" + today + ".xls");
		window.location.assign("/common/editor/LGUExcel/LGUDataExcel" + today + ".xls");
	}

	//리스트 가져오기
	function getPageList()
	{	
		var f = document.frm;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}
		
		var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
	
		if(strtDt && endDt && strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
			return;
		}
		
		f.action = "./list.do";
		f.submit();
	}
	
	function excel()
	{
		var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
	
		if(!strtDt || !endDt)
		{
			alert("* 검색 기간을 입력해주세요.");
		}
		else if(strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
		}
		else
		{
			var arrStrgDt = jQuery("#strtDt").val().split("-");
			var arrEndDt = jQuery("#endDt").val().split("-");
			
			var strtDate = new Date(arrStrgDt[0], parseInt(arrStrgDt[1]) - 1, arrStrgDt[2]); 
			var endDate = new Date(arrEndDt[0], parseInt(arrEndDt[1]) - 1, arrEndDt[2]); 

			if((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 30)
			{
				alert("* 검색 기간을 30일 이하로 입력해주세요.");
			}
			else
			{
				$("#fExcel").val($("#f").val());
				$("#qExcel").val($("#q").val());
				$("#callSttsExcel").val($("#callStts").val());
				$("#strtDtExcel").val($("#strtDt").val());
				$("#endDtExcel").val($("#endDt").val());
				document.excelFrm.submit();
			}
		}
	}
	
	function view(seq, f, q, pageIndex, callStts, strtDt, endDt, kbNo)
	{
		location.href = "./view.do?idx="+seq+"&f="+f+"&q="+q+"&pageIndex="+pageIndex+"&callStts=" + callStts + "&strtDt=" + strtDt + "&endDt=" + endDt + "&kbNo=" + kbNo;
	}
	
	// 엑셀 등록 팝업
	function excelUploadPop() 
	{
		setPopup("./excelUploadPop.do", "EXCELUPLOADPOP", 510, 310);
	}	
</script>
