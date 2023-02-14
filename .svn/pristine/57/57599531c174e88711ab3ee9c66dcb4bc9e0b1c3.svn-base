<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMACounselView.jsp
	프로그램 명 : 	외주업체 상담관리 조회.
	설명		: 	외주업체 상담관리 조회
	작성자		: 	김필기
	작성일		:	2016.02.29
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.29				김필기				최초작성
	2016.05.20				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap}" />
<c:set var="loginMap" value="${admLgnMap}" />

<c:set var="answerList" value="${rtnMap.answerList}" />

<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />

<jsp:scriptlet>
	pageContext.setAttribute("crlf", "\r\n");
	pageContext.setAttribute("lf", "\n");
	pageContext.setAttribute("cr", "\r");
</jsp:scriptlet>

<form name="frm" method="post"  enctype="multipart/form-data" >
	<input type="hidden" name="idx" value="${info.oscCnslSeq}" />
	<input type="hidden" name="idNo" value="${info.idNo}" />
	<input type="hidden" name="updateSkb" value="" />
	
	<input type="hidden" name="f" value="${f}" />
	<input type="hidden" name="q" value="${q}" />
	<input type="hidden" name="shCallStts" value="${callStts}" />
	<input type="hidden" name="pageIndex" value="${pageIndex}" />
	<input type="hidden" name="strtDt" value="${strtDt}" />
	<input type="hidden" name="endDt" value="${endDt}" />
	
	<c:if test="${loginMap.id ne 'lgusawon' }">
		<c:if test="${opmInfMap.customerInfoYn eq 'Y'}">
			<h5>고객 정보</h5>
			
			<c:if test="${loginMap.id eq 'lifeway09'}">
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>고객명</th>
							<td>${info.name }</td>
						</tr>
						<tr>
							<th>핸드폰</th>
							<td>${info.hp }</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td>${info.birth }</td>
						</tr>						
						<tr>
							<th>성별</th>
							<td>${info.sex == '0001' ? '남' : '여' }</td>
						</tr>
						<tr>
							<th>가입상품내역</th>
							<td>${info.expireRenewAccntName }</td>
						</tr>
						<tr>
							<th>회원번호</th>
							<td>${info.expireRenewAccntNo }</td>
						</tr>
						<tr>
							<th>고유번호</th>
							<td>${info.unqNo }</td>
						</tr>
						<tr>
							<th>납입회차</th>
							<td>${info.expireRenewAccntCnt }</td>
						</tr>
						<tr>
							<th>구매상품</th>
							<c:choose>
								<c:when test="${ info.expireRenewGiftNo eq 1004}">
									<td>1년 : 퀸메이드 씨에로 32p 홈세트</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1005}">
									<td>1년 : 황제황진환 골드</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1006}">
									<td>1년 : FULL HD 방수 액션캠</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1002}">
									<td>1년 : 세탁가능 전기요(더블)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1007}">
									<td>1년 : 한경희 스팀다리미</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1008}">
									<td>1년 : 차량겸용 공기청정기(블랙)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1011}">
									<td>1년 : 차량겸용 공기청정기(화이트)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1009}">
									<td>1년 : 온풍기 팬히터</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1010}">
									<td>1년 : 메모리폼 경추베개</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 1003}">
									<td>1년 : 일렉트로룩스 커피메이커</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2001}">
									<td>2년 : 모던하임 에어프라이어 (3.5L)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2006}">
									<td>2년 : 쌤소나이트 DELAENO 백팩(그레이)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2002}">
									<td>2년 : 26형 캐리어(프레시민트)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2003}">
									<td>2년 : 26형 캐리어(콜드그레이)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2004}">
									<td>2년 : 26형 캐리어(스위트옐로우)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2007}">
									<td>2년 : 스위스 몽크로스 가습기(4L)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2008}">
									<td>2년 : 스위스 몽크로스 미러오븐기(12L)</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2005}">
									<td>2년 : 바디휴 무선 어깨안마기</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2009}">
									<td>2년 : HAZZYS 프라하 슬링백</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2010}">
									<td>2년 : 가펠 프리마 인덕션</td>
								</c:when>
								<c:when test="${ info.expireRenewGiftNo eq 2011}">
									<td>2년 : 정관장 홍삼지감/정화액SET</td>
								</c:when>
								<c:otherwise>
									<td>제공하지 않는 상품</td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<th>배송지</th>
							<td>(${info.zipcd }) ${info.adr } &nbsp; ${info.adrDtl }</td>
						</tr>	
					</tbody>
				</table>
			</c:if>	
			
			<table class="table table-bordered">
				<colgroup>
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tbody>
				
					<!-- 삼성ON라이프 -->	
					
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'ONLIFECC'}">
							<tr>
								<th>인터파크주문번호</th>
								<td>${info.idNo}</td>
							</tr>
						</c:when>
						<c:when test="${opmInfMap.b2bStts eq 'EZWEL'}">
							<tr>
								<th>이지웰주문번호</th>
								<td>${info.idNo}</td>
							</tr>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
	
					<!-- 고객명 -->
					<c:if test="${opmInfMap.nameYn eq 'Y'}">
						<tr>
							<th>고객명</th>
							<td>${info.name}</td>
						</tr>
					</c:if>
					
					<!-- 점포명 -->
					<c:if test="${opmInfMap.storeNmYn eq 'Y'}">
						<tr>
							<th>점포명</th>
							<td>${info.storeNm}</td>
						</tr>
					</c:if>
				
					<!-- 주소 -->
					<c:if test="${opmInfMap.addressYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
						<tr>
							<th>주소</th>
							<td>${info.adr} ${info.adrDtl}</td>
						</tr>
					</c:if>
					
					<!-- 고객 연락처(핸드폰) -->
					<c:if test="${opmInfMap.hpYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
						<tr>
							<th>
								<c:choose>
									<c:when test="${opmInfMap.b2bStts eq 'HANSSEM'}">고객 연락처</c:when>
									<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}">고객 연락처</c:when>
									<c:otherwise>고객 연락처(핸드폰)</c:otherwise>
								</c:choose>
							</th>
	
							<td>${info.hp}</td>
						</tr>
					</c:if>
					
					<!-- 이용 서비스 -->
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'ALLSERVICE'}">
						<tr>
							<th>이용 서비스</th>
							<td>${info.mainContType}</td>
						</tr>
					</c:if>				
					
					<!-- 이용 서비스(가전전환) -->
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'MOVEMENT'}">
						<tr>
							<th>이용 서비스(가전전환)</th>
							<td>${info.mainContType}</td>
						</tr>
					</c:if>				
					
					<!-- 고객 연락처(유선전화) -->
					<c:if test="${opmInfMap.telYn eq 'Y'}">
						<tr>
							<th>고객 연락처(유선전화)</th>
							<td>${info.tel}</td>
						</tr>
					</c:if>
					
					<!-- lguplus 대명 가입번호 -->
					<c:if test="${opmInfMap.idNoYn eq 'Y' and loginMap.id eq 'lguplus'}">
						<tr>
							<th>대명 가입번호 <br />[ID NO.]</th>
							<td>${info.idNo}</td>
						</tr>
					</c:if>
					
					<c:if test="${opmInfMap.b2bStts eq 'WEDDING'}">
						<!-- 계약번호 --> 
						<tr>
							<th>웨딩의 여신 친구 초대코드</th>
							<td style="vertical-align:middle;">
								<span id="contractNo">${info.inviteCode}</span>
								&nbsp;&nbsp;<button type="button" onclick="copyToClipboard()">복사 </button>
							</td>
						</tr>
						
						<!-- 희망 허니문 여행지 -->
						<tr>
							<th>희망 허니문 여행지</th>
							<td style="vertical-align:middle;">${info.travel}</td>
						</tr>
	
						<!-- 희망 허니문 출발일 --> 
						<tr>
							<th>희망 허니문 출발일</th>
							<td style="vertical-align:middle;">${info.weddingDate}</td>
						</tr>
	
						<!-- 웨딩 견적 금액 >
						<tr>
							<th>웨딩 견적 금액<br/>[KB NO.]</th>
							<td style="vertical-align:middle;">${info.estimatePrice}만원</td>
						</tr-->
					</c:if>
					
					<!-- 할인 받을 연락처 (CTN) -->
					<c:if test="${opmInfMap.discountCtnYn eq 'Y' and loginMap.id eq 'lguplus'}">
						<tr>
							<th>할인 받을 연락처 (CTN)<br />[KB NO.]</th>
							<td>${info.discountCtn}</td>
						</tr>
					</c:if>
	
					<!-- 할인 받을 명의자 생년월일 -->
					<c:if test="${opmInfMap.discountPinYn eq 'Y' and loginMap.id eq 'lguplus'}">
						<tr>
							<th>할인 받을 명의자 생년월일<br />[모바일/홈 할인 시 주문번호]</th>
							<td>${info.discountPin}</td>
						</tr>
					</c:if>
	
					<!-- 이메일 -->
					<c:if test="${opmInfMap.emailYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
						<tr>
							<th>이메일</th>
							<td>${info.email}</td>
						</tr>
					</c:if>
					
					<!-- 1구좌 상품 -->
					<c:if test="${opmInfMap.prdctNmYn eq 'Y'}">
						<tr>
							<c:if test="${loginMap.id eq 'dlive'}">
								<th>1구좌 상품명</th>
								<td>
									<c:choose>
										<c:when test="${list.prodCd eq 'QS'}">대명D라이프(150회)</c:when>
										<c:when test="${list.prodCd eq 'QT'}">대명D라이프(200회)</c:when>
										<c:otherwise>${list.prdctNm}</c:otherwise>
									</c:choose>
								</td>
							</c:if>
							<c:if test="${loginMap.id ne 'dlive'}">
								<th>1구좌 상품명</th>
								<td>${info.prdctNm}</td>
							</c:if>
						</tr>
					</c:if>
					
					<!-- 결합 상품 -->
					<c:if test="${opmInfMap.fusionPrdctYn eq 'Y'}">
						<tr>
							<th>결합 상품명</th>
							<td>${info.fusionPrdctNm}</td>
						</tr>
					</c:if>
					
					<!-- 주 계약 -->
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
						<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'LGU'}">
								<tr>
									<th>1구좌 주 계약</th>
									<td>
										<c:if test="${fn:length(info.prdctNm)> 0}">
											${info.mainContType}
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:if>
	
					<!-- 2구좌 상품 -->
					<c:if test="${opmInfMap.prdctNm2Yn eq 'Y'}">
						<tr>
							<th>2구좌 상품명</th>
							<td>${info.prdctNm2}</td>
						</tr>
					</c:if>
					
					<!-- 결합 상품2 -->
					<c:if test="${opmInfMap.fusionPrdct2Yn eq 'Y'}">
						<tr>
							<th>결합 상품명2</th>
							<td>${info.fusionPrdctNm2}</td>
						</tr>
					</c:if>
					
					<!-- 주 계약 -->
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
						<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'LGU' or opmInfMap.b2bStts eq 'SMARTHOMEPLUS'}">
								<tr>
									<th>2구좌 주 계약</th>
									<td>
										<c:if test="${fn:length(info.prdctNm2)> 0}">
											${info.mainContType}
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:if>
	
					<!-- 3구좌 상품 -->
					<c:if test="${opmInfMap.prdctNm3Yn eq 'Y'}">
						<tr>
							<th>3구좌 상품명</th>
							<td>${info.prdctNm3}</td>
						</tr>
					</c:if>
					
					<!-- 주 계약 -->
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
						<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'LGU' or opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'SMARTHOMEPLUS'}">
								<tr>
									<th>3구좌 주 계약</th>
									<td>
										<c:if test="${fn:length(info.prdctNm3)> 0}">
											${info.mainContType}
										</c:if>
									</td>
								</tr>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:if>
					
					<!-- 카드 결제 -->
					<c:if test="${opmInfMap.cardPayYn eq 'Y'}">
						<tr>
							<th>카드 결제</th>
							<td>
								<c:choose>
									<c:when test="${info.cardPay eq 'Y'}">카드결제</c:when>
									<c:when test="${info.cardPay eq 'N'}">일반결제</c:when>
								</c:choose>
							</td>
						</tr>
					</c:if>
					
					<!-- 주 계약 -->
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y' and opmInfMap.b2bStts eq 'SONE'}">
						<th>주 계약</th>
						<td>${info.mainContType}</td>
					</c:if>
					<!-- U+인터넷/IPTV 가입번호 -->
					<c:if test="${not empty info.lguHomeNo}">
						<tr>
							<th>U+인터넷/IPTV 가입번호</th>
							<td>${info.lguHomeNo}</td>
						</tr>
					</c:if>
		
					<!-- U+모바일/070 CTN -->
					<c:if test="${not empty info.lguMobileNo}">
						<tr>
							<th>U+모바일/070 CTN</th>
							<td>${info.lguMobileNo}</td>
						</tr>
					</c:if>				
					
					<!-- 고객명 -->
					<c:if test="${opmInfMap.contractorNameYn eq 'Y'}">
						<tr>
							<th>고객명</th>
							<td>${info.contractorName}</td>
						</tr>
					</c:if>
					
					<!-- 연락처 -->
					<c:if test="${opmInfMap.contractorPhoneYn eq 'Y'}">
						<tr>
							<th>연락처</th>
							<td>${info.contractorPhone}</td>
						</tr>
					</c:if>
					
					<!-- 차량번호 -->
					<c:if test="${opmInfMap.plateNumYn eq 'Y'}">
						<tr>
							<th>차량번호</th>
							<td>${info.plateNum}</td>
						</tr>
					</c:if>
					
					<!-- 상담 가능 시간대 입력란 -->
					<c:if test="${opmInfMap.calltimeYn eq 'Y'}">
						<tr>
							<th>상담 가능 시간대</th>
							<td>${info.calltime}</td>
						</tr>
					</c:if>
					
					<!-- SKB 가입상태 선택란 -->
					<c:if test="${opmInfMap.skbJoinYn eq 'Y'}">
						<tr>
							<th rowspan="2">SKB 가입상태<br>(비고)</th>
							<td>
								<select name="skbJoin">
									<option value="가입완료" <c:if test="${info.skbJoin eq '가입완료'}">selected="selected"</c:if>>가입완료</option>
									<option value="가입보류" <c:if test="${info.skbJoin eq '가입보류'}">selected="selected"</c:if>>가입보류</option>
									<option value="가입거절" <c:if test="${info.skbJoin eq '가입거절'}">selected="selected"</c:if>>가입거절</option>
								</select>
								<input type="button" value="가입상태 변경" class="btn btn-small btn-info" onclick="changeSkbJoin()" />
							</td>
						</tr>
						<tr>
							<td>
								<textarea name="skbJoinMemo" style="width:300px; height: 50px;">${info.skbJoinMemo}</textarea>
							</td>
						</tr>
					</c:if>
					
					<!-- 코드 -->
					<c:if test="${opmInfMap.cstmrCodeKrYn eq 'Y'}">
						<tr>
							<th>코드</th>
							<td>${info.cstmrCode1}</td>
						</tr>
					</c:if>
					
					<!-- 고객 고유번호 -->
					<c:if test="${opmInfMap.cstmrUnqNumYn eq 'Y'}">
						<tr>
							<th>고객 고유번호</th>
							<td>${info.cstmrUnqNum}</td>
						</tr>
					</c:if>
					
					<!-- 카드번호 -->
					<c:if test="${opmInfMap.cardNumYn eq 'Y'}">
						<tr>
							<th>카드번호</th>
							<td>${info.cardNum}</td>
						</tr>
					</c:if>
					
					<!-- NUMBER -->
					<c:if test="${opmInfMap.cstmrNumYn eq 'Y'}">
						<tr>
							<th>NUMBER</th>
							<td>${info.cstmrNum}</td>
						</tr>
					</c:if>
					
					<!-- CODE -->
					<c:if test="${opmInfMap.cstmrCodeEnYn eq 'Y'}">
						<tr>
							<th>CODE</th>
							<td>${info.cstmrCode2}</td>
						</tr>
					</c:if>
					
					<!-- 기타 -->
					<c:if test="${opmInfMap.cstmrEtcYn eq 'Y'}">
						<tr>
							<th>기타</th>
							<td>${fn:replace(fn:replace(info.cstmrEtc, ' ', '&nbsp;'), crlf, '<br />')}</td>
						</tr>
					</c:if>
					
					<!-- 한샘 통합 멤버십 -->
					<c:if test="${opmInfMap.hanssMbspNumYn eq 'Y' and opmInfMap.b2bStts ne 'HANSSEM'}">
						<tr>
							<th>한샘 통합 멤버십</th>
							<td>${info.hanssMbspNum}</td>
						</tr>
					</c:if>
					
					<!-- 멤버십 번호 -->
					<c:if test="${opmInfMap.mbspNumYn eq 'Y'}">
						<tr>
							<th>멤버십 번호</th>
							<td>${info.mbspNum}</td>
						</tr>
					</c:if>
					
					<!-- 여행예약번호 -->
					<c:if test="${opmInfMap.tourBookNoYn eq 'Y'}">
						<tr>
							<th>여행예약번호</th>
							<td>${info.tourBookNo}</td>
						</tr>
					</c:if>
	
					<!-- 고객 등록번호 -->
					<c:if test="${opmInfMap.b2bStts eq 'MODETOUR' or opmInfMap.b2bStts eq 'HANSSEM'}">
						<tr>
						<c:if test="${opmInfMap.b2bStts ne 'HANSSEM'}">
							<th>고객 등록번호</th>
						</c:if>
						<c:if test="${opmInfMap.b2bStts eq 'HANSSEM'}">
							<th>고객 등록번호<br /> * ID NO. </th>
						</c:if>
						<td>
							<c:if test="${opmInfMap.b2bStts eq 'HANSSEM'}">
								${info.hanssMbspNum}_${ info.oscCnslSeq }
							</c:if>
							<c:if test="${opmInfMap.b2bStts ne 'HANSSEM'}">
								${info.oscCnslSeq}
							</c:if>				
						</td>
						</tr>
					</c:if>
	
					<!-- 가입 구좌 -->
					<c:if test="${opmInfMap.joinProdYn eq 'Y'}">
						<tr>
							<th>
								<c:choose>
									<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}">가입 희망 구좌</c:when>
									<c:otherwise>가입구좌</c:otherwise>
								</c:choose>
							</th>
							<td>
								${info.joinProd }
							</td>
						</tr>
					</c:if>
	
					<!-- 롯데카드 결제 상태 -->
					<c:if test="${opmInfMap.lotteCardPayYn eq 'Y'}">
						<tr>
							<th>롯데카드 결제 상태</th>
							<td>
								<c:if test="${info.lotteCardPay eq '1' }"> 35개월 할부 결제 완료 </c:if>
								<c:if test="${info.lotteCardPay eq '2' }"> 35개월 할부 미결제(롯데카드미소지포함) </c:if>
							</td>
						</tr>
					</c:if>
	
					<!-- 주 계약 -->
					<!--
					<c:if test="${opmInfMap.mainContTypeYn eq 'Y'}">
						<c:choose>
							<c:when test="${opmInfMap.b2bStts eq 'LGU'}">
								<tr>
									<th>주 계약</th>
									<td> ${info.mainContType} </td>
								</tr>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:if>
					-->
	
					<!-- 메모 -->
					<c:if test="${opmInfMap.memoYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
						<tr>
							<th>메모</th>
							<td>${fn:replace(fn:replace(info.memo, ' ', '&nbsp;'), crlf, '<br />')}</td>
						</tr>
					</c:if>
				</tbody>
			</table>
	 	</c:if>
	</c:if>
 	
	<c:if test="${loginMap.id ne 'lgusawon' }">
	 	<c:if test="${opmInfMap.agentInfoYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
	 		<h5>판매사 정보</h5>
			<table class="table table-bordered">
				<colgroup>
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<!-- 멤버십 블루 선불카드번호 -->
					<c:if test="${opmInfMap.prepaidCardNumYn eq 'Y'}">
						<tr>
							<th>선불카드번호</th>
							<td>${info.prepaidCardNum}</td>
						</tr>
					</c:if>
					
	 				<%-- <c:if test="${opmInfMap.b2bStts eq 'LGU' }">
						<tr>
							<th>판매사 구분 <br /> [B2B회사명 -> LG유플러스(재원적립)]</th>
							<td>${info.agentGubun}</td>
						</tr>
					</c:if> --%>
					
					<!-- 웨딩의 여신인 경우 판매자 소속(소속 업체명)을 판매사 성함위에 배치 -->
					<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'WEDDING'}">
						<tr>
							<th>소속(업체명)</th>
							<td>${info.sllrPart}</td>
						</tr>
					</c:if>
					
					<!-- 판매사원 성명 -->
					<c:if test="${opmInfMap.agentEmpNmYn eq 'Y'}">
						<tr>
						<c:if test="${opmInfMap.b2bStts ne 'HANSSEM'}">
							<th>
								<c:choose>
									<c:when test="${loginMap.id eq 'lguplus' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">실제 판매자 이름</c:when>
									<c:when test="${opmInfMap.b2bStts eq 'WEDDING'}">판매사 성함</c:when>
									<c:when test="${opmInfMap.b2bStts eq 'SONE'}">사원명</br>*B2B 사원 코드</c:when>
									<c:otherwise>판매사원 성명</c:otherwise>
								</c:choose>
							</th>
						</c:if>
						<c:if test="${opmInfMap.b2bStts eq 'HANSSEM'}">
							<th>판매자 이름 <br /> * 주문번호 </th>
						</c:if>
							<td style="vertical-align:middle;">${info.agentEmpNm}</td>
						</tr>
					</c:if>
					
					<!-- 매장코드 -->
					<c:if test="${opmInfMap.agentCdYn eq 'Y'}">
						<tr>
							<th>매장코드</th>
							<td>${info.agentCd}</td>
						</tr>
					</c:if>
					
					<!-- 대명 가입번호 -->
					<c:if test="${opmInfMap.idNoYn eq 'Y' and loginMap.id ne 'lguplus'}">
						<tr>
							<c:if test="${loginMap.id eq 'dlive'}">
							<th>대명 가입번호 <br />[Account NO.]</th>
							<td>${info.accntNo}</td>
							</c:if>
							<c:if test="${loginMap.id ne 'dlive'}">
							<th>대명 가입번호 <br />[ID NO.]</th>
							<td>${info.idNo}</td>
							</c:if>
						</tr>
					</c:if>
					
					<!-- U+ 홈상품 가입번호 -->
					<c:if test="${opmInfMap.homePrdNumYn eq 'Y'}">
						<tr>
							<th>U+ 가입번호 <br />[요금할인상품 - CTN 없을 경우만 KB NO.]</th>
							<td>${info.homePrdNum}</td>
						</tr>
					</c:if>
					
					<!-- 대리점명 -->
					<c:if test="${opmInfMap.agentNmYn eq 'Y'}">
						<tr>
							<th>
								<c:if test="${opmInfMap.b2bStts eq 'HANSSEM' }">판매자 소속 <br /> * B2B 회사명</c:if>
								<c:if test="${opmInfMap.b2bStts ne 'HANSSEM' }"> 대리점명<br />[B2B사원코드.] </c:if>
							</th>
							<td>${info.agentNm}</td>
						</tr>
					</c:if>
					
					<!-- 담당자 연락처 -->
					<c:if test="${opmInfMap.agentEmpTelYn eq 'Y'}">
						<tr>
							<th>
								<c:choose>
									<c:when test="${loginMap.id eq 'lguplus' or loginMap.id eq 'lgusawon' or loginMap.id eq 'lgumanager'}">실제 판매자 연락처</c:when>
									<c:otherwise>담당자 연락처</c:otherwise>
								</c:choose>
							</th>
							<td>${info.agentEmpTel}</td>
						</tr>
					</c:if>
					
					<!-- 가입회사명 -->
					<c:if test="${opmInfMap.companyNmYn eq 'Y'}">
						<tr>
							<th>가입회사명</th>
							<td>${info.companyNmYn}</td>
						</tr>
					</c:if>
					
					<!-- 담당자명 -->
					<c:if test="${opmInfMap.b2bEmpCdYn eq 'Y'}">
						<tr>
							<th>담당자명</th>
							<td>${info.b2bEmpCd}</td>
						</tr>
					</c:if>
					
					<!-- 영업채널1 -->
					<c:if test="${opmInfMap.code1Yn eq 'Y'}">
						<tr>
							<th>영업채널1</th>
							<td>${info.code1}</td>
						</tr>
					</c:if>
					
					<!-- 영업채널2 -->
					<c:if test="${opmInfMap.code3Yn eq 'Y'}">
						<tr>
							<th>영업채널2</th>
							<td>${info.code3}</td>
						</tr>
					</c:if>
					
					<!-- 판매사코드/사번 -->
					<c:if test="${opmInfMap.code2Yn eq 'Y'}">
						<tr>
							<th>판매사코드/사번</th>
							<td>${info.code2}</td>
						</tr>
					</c:if>
					
					<!-- 코드 -->
					<c:if test="${opmInfMap.agentCodeKrYn eq 'Y'}">
						<tr>
							<th>코드</th>
							<td>${info.agentCode1}</td>
						</tr>
					</c:if>
					
					<!-- 주문번호 -->
					<c:if test="${opmInfMap.orderNumYn eq 'Y'}">
						<tr>
							<th>주문번호</th>
							<td>${info.orderNum}</td>
						</tr>
					</c:if>
					
					<!-- 판매자 소속 -->
					<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts eq 'SONE'}">
						<tr>
							<th>지사</br>*ID NO.</th>
							<td>${info.sllrPart} (지사)</td>
						</tr>
					</c:if>
					
					<!-- 판매사원 사번 -->
					<c:if test="${opmInfMap.agentEmpNumYn eq 'Y'}">
						<tr>
							<c:choose>
								<c:when test="${opmInfMap.b2bStts eq 'SONE'}">
									<th>사번</br>*주문 번호</th>
									<td>${info.agentEmpNum}</td>
								</c:when>
								<c:otherwise>
									<th>판매사원 사번</th>
									<td>${info.agentEmpNum}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
					
					<!-- NUMBER -->
					<c:if test="${opmInfMap.agentNumYn eq 'Y'}">
						<tr>
							<th>NUMBER</th>
							<td>${info.agentNum}</td>
						</tr>
					</c:if>
					
					<!-- CODE -->
					<c:if test="${opmInfMap.agentCodeEnYn eq 'Y'}">
						<tr>
							<th>CODE</th>
							<td>${info.agentCode2}</td>
						</tr>
					</c:if>
					
					<!-- 기타 -->
					<c:if test="${opmInfMap.agentEtcYn eq 'Y'}">
						<tr>
							<th>기타</th>
							<td>${fn:replace(fn:replace(info.agentEtc, ' ', '&nbsp;'), crlf, '<br />')}</td>
						</tr>
					</c:if>
					
					<!-- 고유번호 -->
					<c:if test="${opmInfMap.agentUnqNumYn eq 'Y'}">
						<tr>
							<th>고유번호</th>
							<td>${info.agentUnqNum}</td>
						</tr>
					</c:if>
					
					<!-- 판매자 번호 -->
					<c:if test="${opmInfMap.sllrNumYn eq 'Y'}">
						<tr>
						<c:if test="${opmInfMap.b2bStts ne 'HANSSEM'}">
							<th>판매자 번호</th>
						</c:if>
						<c:if test="${opmInfMap.b2bStts eq 'HANSSEM'}">
							<th>판매자 번호 <br />* 주문번호</th>
						</c:if>
							<td>${info.sllrNum}</td>
						</tr>
					</c:if>
					
					<!-- 판매자 소속 -->
					<c:if test="${opmInfMap.sllrPartYn eq 'Y' and opmInfMap.b2bStts ne 'WEDDING' and opmInfMap.b2bStts ne 'SONE'}">
						<tr>
							<th>판매자 소속</th>
							<td>${info.sllrPart}</td>
						</tr>
					</c:if>
					
					<!-- 판매 대리점명 -->
					<c:if test="${opmInfMap.sllrAgentNmYn eq 'Y'}">
						<tr>
						<c:if test="${opmInfMap.b2bStts ne 'HANSSEM'}">
							<th>판매 대리점명</th>
						</c:if>
						<c:if test="${opmInfMap.b2bStts eq 'HANSSEM'}">
							<th>대리점명<br /> * B2B 사원코드</th>
						</c:if>
							<td>${info.sllrAgentNm}</td>
						</tr>
					</c:if>
					
					<!-- 판매자 연락처 -->
					<c:if test="${opmInfMap.sllrCtelYn eq 'Y'}">
						<tr>
							<th>
								<c:choose>
									<c:when test="${opmInfMap.b2bStts eq 'WEDDING' or opmInfMap.b2bStts eq 'SONE'}">연락처</c:when>
									<c:otherwise>판매자 연락처</c:otherwise>
								</c:choose>
							</th>
							<td>${info.sllrCtel}</td>
						</tr>
					</c:if>
				</tbody>
			</table>
	 	</c:if>
	</c:if>

	<!-- 자유투어 -->
 	<c:if test="${opmInfMap.b2bStts eq 'JAUTOUR'}">
	 	<h5>기타 정보</h5>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<!-- 인입경로 -->
				<c:if test="${opmInfMap.funnelYn eq 'Y'}">
					<tr>
						<th>인입경로</th>
						<td>
							<c:if test="${info.funnel eq '1' }">온라인</c:if>
							<c:if test="${info.funnel eq '2' }">홈쇼핑</c:if>
							<c:if test="${info.funnel eq '3' }">가전</c:if>
							<c:if test="${info.funnel eq '4' }">모바일</c:if>
							<c:if test="${info.funnel eq '5' }">투어캐빈</c:if>
						</td>
					</tr>
				</c:if>
				<!-- 여행지 -->
				<c:if test="${opmInfMap.travelYn eq 'Y'}">
					<tr>
						<th>여행지</th>
						<td>${info.travel}</td>
					</tr>
				</c:if>
				<!-- 자유투어 예약번호 -->
				<c:if test="${opmInfMap.jauNumYn eq 'Y'}">
					<tr>
						<th>자유투어 예약번호</th>
						<td>${info.jauNum}</td>
					</tr>
				</c:if>
				<!-- 롯데카드 발급상태-->
				<c:if test="${opmInfMap.lotteCardYn eq 'Y'}">
					<tr>
						<th>롯데카드 발급상태</th>
						<td>
							<c:if test="${info.lotteCard eq '1' }"> 보유 </c:if>
							<c:if test="${info.lotteCard eq '2' }"> 신규발급 </c:if>
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
 	</c:if>

	<!-- 대명투어몰 -->
 	<c:if test="${opmInfMap.b2bStts eq 'DMTOUR'}">
	 	<h5>기타 정보</h5>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<!-- 인입경로 -->
				<c:if test="${opmInfMap.funnelYn eq 'Y'}">
					<tr>
						<th>인입경로</th>
						<td>
							<c:if test="${info.funnel eq '1' }">온라인</c:if>
							<c:if test="${info.funnel eq '2' }">홈쇼핑</c:if>
							<c:if test="${info.funnel eq '3' }">가전</c:if>
							<c:if test="${info.funnel eq '4' }">모바일</c:if>
							<c:if test="${info.funnel eq '5' }">투어캐빈</c:if>
						</td>
					</tr>
				</c:if>
				<!-- 여행지 -->
				<c:if test="${opmInfMap.travelYn eq 'Y'}">
					<tr>
						<th>여행지</th>
						<td>${info.travel}</td>
					</tr>
				</c:if>
				<!-- 대명투어몰 예약번호 -->
				<c:if test="${opmInfMap.dmTourNumYn eq 'Y'}">
					<tr>
						<th>대명투어몰 예약번호</th>
						<td>${info.dmTourNum}</td>
					</tr>
				</c:if>
				<!-- 롯데카드 발급상태-->
				<c:if test="${opmInfMap.lotteCardYn eq 'Y'}">
					<tr>
						<th>롯데카드 발급상태</th>
						<td>
							<c:if test="${info.lotteCard eq '1' }"> 보유 </c:if>
							<c:if test="${info.lotteCard eq '2' }"> 신규발급 </c:if>
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
 	</c:if>


	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />			
			<col width="*" />
			<col width="15%" />
		</colgroup>
		<tbody>
			<tr>
				<th colspan="3">상담현황</th>
			</tr>
			
			<c:forEach var="list" items="${answerList}" varStatus="status">
				<tr>
					<th>${list.name}</th>
					<td>${fn:replace(fn:replace(list.cntn, ' ', '&nbsp;'), crlf, '<br />')}</td>
					<td>${list.regDtm}</td>
				</tr>
			</c:forEach>
			
			<c:if test="${fn:length(answerList) == 0}">
				<tr>
					<td class="lt_text3" colspan="3" style="text-align:center">등록된 상담현황이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<c:if test="${loginMap.id ne 'lgusawon' }">
	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th colspan="2">답변등록</th>
			</tr>
			<tr>
				<th>상담원명</th>
				<td><input type="text" name="answer" value="" class="" maxlength="20"/> </td>
			</tr>
			<tr>
				<th>상담상태</th>
				<td>
					<select name="call_stts">
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
							<option value="${cdlist.cd}">
								<c:choose>
									<c:when test="${cdlist.cdNm eq '가입완료' and loginMap.id eq 'tmontm'}">상담가입완료</c:when>
									<c:otherwise>${cdlist.cdNm}</c:otherwise>
								</c:choose>							
							</option>
						</c:forEach>					
					</select>
				</td>
			</tr>
			<tr>
				<th>상담이력</th>
				<td>
					<textarea name="cntn" style="width:99%; height:100px" maxlength="500"></textarea>
				</td>
			</tr>						
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="button" value="상담이력 등록" class="btn btn-info2" onclick="memoReg()" />
				</td>
			</tr>					
		</tbody>
	</table>
	</c:if>
</form>

<div style="text-align:right;">
	<a href="./list.do?f=${f}&q=${q}&callStts=${callStts}&pageIndex=${pageIndex}&strtDt=${strtDt}&endDt=${endDt}" class="btn btn-inverse">목록</a>
</div>

<script type="text/javascript">
	function memoReg()
	{
		var f = document.frm;
		
		if(f.answer.value == "")
		{
			alert("상담원명을 입력하세요.");
			f.answer.focus();
			return false;
		}
		
		if(f.cntn.value == "")
		{
			alert("상담내용을 입력해주세요.");
			f.cntn.focus();
			return false;
		}
	
		if(confirm("상담내용을 등록하시겠습니까?"))
		{
			f.action = "./update.do";
			f.submit();
		}
	}
	
	function changeSkbJoin()
	{
		if(confirm("변경하시겠습니까?"))
		{
			document.frm.updateSkb.value = "Y";
			document.frm.action = "./update.do";
			document.frm.submit();
		}
	}
	
	function copyToClipboard() {
		var t = document.createElement("textarea");
		t.value = $("#contractNo").text();
		document.body.appendChild(t);
		t.select();
		document.execCommand('copy');
		document.body.removeChild(t);
	}
</script>