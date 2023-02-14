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
			<div class="card-box">
				<div class="table-responsive">
					<table class="table mb-0 table-bordered table-hover" style="font-size:12px;">
						<colgroup>
							<col width="20%" />
							<col width="*" />
						</colgroup>
						<tbody>
						
			
							<!-- 고객명 -->
							<c:if test="${opmInfMap.nameYn eq 'Y'}">
								<tr>
									<th>고객명</th>
									<td>${info.name}</td>
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
							
							<!-- 할인 받을 연락처 (CTN) -->
							<c:if test="${opmInfMap.discountCtnYn eq 'Y' and loginMap.id eq 'lguplus'}">
								<tr>
									<th>할인 받을 연락처 (CTN)<br />[KB NO.]</th>
									<td>${info.discountCtn}</td>
								</tr>
							</c:if>
			
							<!-- 1구좌 상품 -->
							<c:if test="${opmInfMap.prdctNmYn eq 'Y'}">
								<tr>
									<th>1구좌 상품명</th>
									<td>${info.prdctNm}</td>
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
									<c:when test="${opmInfMap.b2bStts eq 'SMART' or opmInfMap.b2bStts eq 'LGU'}">
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
									<c:when test="${opmInfMap.b2bStts eq 'LGU'}">
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
							
							<!-- 메모 -->
							<c:if test="${opmInfMap.memoYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
								<tr>
									<th>메모</th>
									<td>${fn:replace(fn:replace(info.memo, ' ', '&nbsp;'), crlf, '<br />')}</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
	 	</c:if>
	</c:if>
 	
	<c:if test="${loginMap.id ne 'lgusawon' }">
	 	<c:if test="${opmInfMap.agentInfoYn eq 'Y' and opmInfMap.b2bStts ne 'KBCAR'}">
	 		<h5>판매사 정보</h5>
	 		<div class="card-box">
				<div class="table-responsive">
					<table class="table mb-0 table-bordered table-hover" style="font-size:12px;">
						<colgroup>
							<col width="20%" />
							<col width="*" />
						</colgroup>
						<tbody>
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
							
							<!-- U+ 홈상품 가입번호 -->
							<c:if test="${opmInfMap.homePrdNumYn eq 'Y'}">
								<tr>
									<th>U+ 가입번호 <br />[요금할인상품 - CTN 없을 경우만 KB NO.]</th>
									<td>${info.homePrdNum}</td>
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
							
						</tbody>
					</table>
				</div>
			</div>
	 	</c:if>
	</c:if>

	<div class="card-box">
		<div class="table-responsive">
			<table class="table mb-0 table-bordered table-hover" style="font-size:12px;">
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
		</div>
	</div>

	<c:if test="${loginMap.id ne 'lgusawon' }">
	<div class="card-box">
		<div class="table-responsive">
			<table class="table mb-0 table-bordered table-hover" style="font-size:12px;">
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
						<td><input type="text" name="answer" value="" class="form-control form-control-sm" maxlength="20"/> </td>
					</tr>
					<tr>
						<th>상담상태</th>
						<td>
							<select name="call_stts" class="form-control form-control-sm">
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
							<textarea name="cntn" class="form-control"></textarea>
						</td>
					</tr>						
					<tr>
						<td colspan="2" style="text-align:right">
							<input type="button" value="상담이력 등록" class="btn btn-sm btn-primary" onclick="memoReg()" />
						</td>
					</tr>					
				</tbody>
			</table>
		</div>
	</div>
	</c:if>
</form>

<div style="text-align:right;">
	<div class="card-box">
	<a href="./list.do?f=${f}&q=${q}&callStts=${callStts}&pageIndex=${pageIndex}&strtDt=${strtDt}&endDt=${endDt}" class="btn btn-sm btn-primary">목록</a>
	</div>
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