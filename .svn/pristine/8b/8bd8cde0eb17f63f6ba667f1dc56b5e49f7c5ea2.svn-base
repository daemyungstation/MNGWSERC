<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMFOutsourcingPageMngWrite.jsp
	프로그램 명 : 	외주업체 코드별 관리 목록을 등록/수정한다.
	설명		: 	외주업체 코드별 관리 목록을 등록/수정한다.
	작성자		: 	김필기
	작성일		:	2016.05.16
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.05.16				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap.info}" />

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(info, null, './insert.do', './update.do')}">
	<input type="hidden" name="seq" value="${info.oscInputMstSeq}" />
	
	<h4>고정값</h4>
	<table class="table table-bordered">
		<colgroup>
			<col style="width:15%;" />
			<col style="width:85%;" />	
		</colgroup>
		<tbody> 
			<tr>
				<th style="vertical-align:middle;">제목</th>
				<td><input type="text" name="title" value="${info.title}" /></td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">외주업체 코드</th>
				<td>
					<select name="oscCd" >
						<option value="">[외주업체 선택]</option>
						<c:forEach var="osclist" items="${osclist.outsourcing}">
						<option value="${osclist.cd }" <c:if test="${osclist.cd eq info.oscCd}">selected="selected"</c:if>>${osclist.cd}</option>
						</c:forEach>
					</select>
					<span style="color:red"> ※ 해당 업체 코드가 이미 등록(입력페이지)되어 있다면 해당 페이지가 덮어쓰여집니다. 주의하여주세요.</span>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">B2B_STTS</th>
				<td><input type="text" name="b2bStts" value="${info.b2bStts}" /></td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">B2B_CD</th>
				<td><input type="text" name="b2bCd" value="${info.b2bCd}" /></td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">B2B_NM</th>
				<td><input type="text" name="b2bNm" value="${info.b2bNm}" /></td>
			</tr>
		</tbody>
	</table>
	
	<h4>선택값</h4>
	<div>
		<table class="table table-bordered" style="width:500px; float:left; margin-right: 10px "> 
			<colgroup>
				<col style="width:20%;" />
				<col style="width:50%;" />
				<col style="width:30%;" />	
			</colgroup>
			<tbody>
				<tr>
					<th style="vertical-align:middle;">&nbsp;</th>
					<th style="vertical-align:middle;">항목</th>
					<th style="vertical-align:middle;">사용유무</th>
				</tr>
				<tr>
					<th rowspan="47">판매사 정보<br>
						<input type="checkbox" name="agentInfoYn" value="Y" <c:if test="${info.agentInfoYn eq 'Y'}">checked="checked"</c:if> />
					</th>
				</tr> 
				<tr>
					<th style="vertical-align:middle;">멤버쉽 블루 선불카드 번호</th>
					<td style="text-align:center"><input type="checkbox" name="prepaidCardNumYn" value="Y" <c:if test="${info.prepaidCardNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">대리점/직영점 코드</th>
					<td style="text-align:center"><input type="checkbox" name="uDlrCdYn" value="Y" <c:if test="${info.uDlrCdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">상담등록자 사번</th>
					<td style="text-align:center"><input type="checkbox" name="uIndcEmpnoYn" value="Y" <c:if test="${info.uIndcEmpnoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">상담등록자 마당 ID</th>
					<td style="text-align:center"><input type="checkbox" name="uIntgUserIdYn" value="Y" <c:if test="${info.uIntgUserIdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매사원 성명</th>
					<td style="text-align:center"><input type="checkbox" name="agentEmpNmYn" value="Y" <c:if test="${info.agentEmpNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">매장코드(점코드)</th>
					<td style="text-align:center"><input type="checkbox" name="agentCdYn" value="Y" <c:if test="${info.agentCdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">대명 가입번호</th>
					<td style="text-align:center"><input type="checkbox" name="idNoYn" value="Y" <c:if test="${info.idNoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">대리점명</th>
					<td style="text-align:center"><input type="checkbox" name="agentNmYn" value="Y" <c:if test="${info.agentNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">담당자 연락처</th>
					<td style="text-align:center"><input type="checkbox" name="agentEmpTelYn" value="Y" <c:if test="${info.agentEmpTelYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">가입회사명</th>
					<td style="text-align:center"><input type="checkbox" name="companyNmYn" value="Y" <c:if test="${info.companyNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">담당자명</th>
					<td style="text-align:center"><input type="checkbox" name="b2bEmpCdYn" value="Y" <c:if test="${info.b2bEmpCdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">영업채널1</th>
					<td style="text-align:center"><input type="checkbox" name="code1Yn" value="Y" <c:if test="${info.code1Yn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">영업채널2</th>
					<td style="text-align:center"><input type="checkbox" name="code3Yn" value="Y" <c:if test="${info.code3Yn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매사코드/사번</th>
					<td style="text-align:center"><input type="checkbox" name="code2Yn" value="Y" <c:if test="${info.code2Yn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">코드</th>
					<td style="text-align:center"><input type="checkbox" name="agentCodeKrYn" value="Y" <c:if test="${info.agentCodeKrYn eq 'Y'}">checked="checked"</c:if> onclick="setCodeReadonly(this, 'agentCodeEnYn')" /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">주문번호</th>
					<td style="text-align:center"><input type="checkbox" name="orderNumYn" value="Y" <c:if test="${info.orderNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매사원 사번</th>
					<td style="text-align:center"><input type="checkbox" name="agentEmpNumYn" value="Y" <c:if test="${info.agentEmpNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">NUMBER</th>
					<td style="text-align:center"><input type="checkbox" name="agentNumYn" value="Y" <c:if test="${info.agentNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">CODE</th>
					<td style="text-align:center"><input type="checkbox" name="agentCodeEnYn" value="Y" <c:if test="${info.agentCodeEnYn eq 'Y'}">checked="checked"</c:if> onclick="setCodeReadonly(this, 'agentCodeKrYn')" /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">기타</th>
					<td style="text-align:center"><input type="checkbox" name="agentEtcYn" value="Y" <c:if test="${info.agentEtcYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">고유번호</th>
					<td style="text-align:center"><input type="checkbox" name="agentUnqNumYn" value="Y" <c:if test="${info.agentUnqNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매자 번호</th>
					<td style="text-align:center"><input type="checkbox" name="sllrNumYn" value="Y" <c:if test="${info.sllrNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매자 소속</th>
					<td style="text-align:center"><input type="checkbox" name="sllrPartYn" value="Y" <c:if test="${info.sllrPartYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매자 연락처</th>
					<td style="text-align:center"><input type="checkbox" name="sllrCtelYn" value="Y" <c:if test="${info.sllrCtelYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">판매 대리점명</th>
					<td style="text-align:center"><input type="checkbox" name="sllrAgentNmYn" value="Y" <c:if test="${info.sllrAgentNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">생년월일</th>
					<td style="text-align:center"><input type="checkbox" name="birthDayYn" value="Y" <c:if test="${info.birthDayYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">도매직영점 판매 구분</th>
					<td style="text-align:center"><input type="checkbox" name="salesTypeYn" value="Y" <c:if test="${info.salesTypeYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">서비스명</th>
					<td style="text-align:center"><input type="checkbox" name="uProdNmYn" value="Y" <c:if test="${info.uProdNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">채널유형코드</th>
					<td style="text-align:center"><input type="checkbox" name="uCmmnCdYn" value="Y" <c:if test="${info.uCmmnCdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">채널유형코드명</th>
					<td style="text-align:center"><input type="checkbox" name="uCmmnCdNmYn" value="Y" <c:if test="${info.uCmmnCdNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">유치대리점명</th>
					<td style="text-align:center"><input type="checkbox" name="uDlrNmYn" value="Y" <c:if test="${info.uDlrNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">상품번호</th>
					<td style="text-align:center"><input type="checkbox" name="uProdNoYn" value="Y" <c:if test="${info.uProdNoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">도매 판매점 POS코드</th>
					<td style="text-align:center"><input type="checkbox" name="whPosCdYn" value="Y" <c:if test="${info.whPosCdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">도매 판매점명</th>
					<td style="text-align:center"><input type="checkbox" name="whStoreNmYn" value="Y" <c:if test="${info.whStoreNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">계약자명</th>
					<td style="text-align:center"><input type="checkbox" name="contractorNameYn" value="Y" <c:if test="${info.contractorNameYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">계약자 생년월일</th>
					<td style="text-align:center"><input type="checkbox" name="contractorBirthYn" value="Y" <c:if test="${info.contractorBirthYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">계약자 연락처</th>
					<td style="text-align:center"><input type="checkbox" name="contractorPhoneYn" value="Y" <c:if test="${info.contractorPhoneYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">카드사</th>
					<td style="text-align:center"><input type="checkbox" name="cardCompanyYn" value="Y" <c:if test="${info.cardCompanyYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">카드번호 (4자리)</th>
					<td style="text-align:center"><input type="checkbox" name="creditCardNumYn" value="Y" <c:if test="${info.creditCardNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">카드 유효기간</th>
					<td style="text-align:center"><input type="checkbox" name="validThruYn" value="Y" <c:if test="${info.validThruYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">차량번호</th>
					<td style="text-align:center"><input type="checkbox" name="plateNumYn" value="Y" <c:if test="${info.plateNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">가입구좌 수</th>
					<td style="text-align:center"><input type="checkbox" name="orderQtyYn" value="Y" <c:if test="${info.orderQtyYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">주계약 서비스 1</th>
					<td style="text-align:center"><input type="checkbox" name="mainContService1Yn" value="Y" <c:if test="${info.mainContService1Yn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">주계약 서비스 2</th>
					<td style="text-align:center"><input type="checkbox" name="mainContService2Yn" value="Y" <c:if test="${info.mainContService2Yn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">안내사항</th>
					<td style="text-align:center"><input type="checkbox" name="infoYn" value="Y" <c:if test="${info.infoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="info" style="width:96%">${info.info}</textarea></td>
				</tr>
			</tbody>		
		</table>
		
		<table class="table table-bordered" style="width:500px"> 
			<colgroup>
				<col style="width:20%;" />
				<col style="width:50%;" />
				<col style="width:30%;" />	
			</colgroup>
			<tbody>
				<tr>
					<th style="vertical-align:middle;">&nbsp;</th>
					<th style="vertical-align:middle;">항목</th>
					<th style="vertical-align:middle;">사용유무</th>
				</tr>
				<tr>
					<th rowspan="44">고객 정보<br>
						<input type="checkbox" name="customerInfoYn" value="Y" <c:if test="${info.customerInfoYn eq 'Y'}">checked="checked"</c:if> />
					</th>
				</tr> 
				<tr>
					<th style="vertical-align:middle;">1구좌 상품정보</th>
					<td style="text-align:center"><input type="checkbox" name="prdctNmYn" value="Y" <c:if test="${info.prdctNmYn eq 'Y'}">checked="checked"</c:if> onclick="setPrdctReadonly(this)" /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">2구좌 상품정보</th>
					<td style="text-align:center"><input type="checkbox" name="prdctNm2Yn" value="Y" <c:choose><c:when test="${info.prdctNmYn ne 'Y'}">disabled="disabled"</c:when><c:when test="${info.prdctNm2Yn eq 'Y'}">checked="checked"</c:when></c:choose> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">3구좌 상품정보</th>
					<td style="text-align:center"><input type="checkbox" name="prdctNm3Yn" value="Y" <c:choose><c:when test="${info.prdctNmYn ne 'Y'}">disabled="disabled"</c:when><c:when test="${info.prdctNm3Yn eq 'Y'}">checked="checked"</c:when></c:choose> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">결합 상품</th>
					<td style="text-align:center"><input type="checkbox" name="fusionPrdctYn" value="Y" <c:if test="${info.fusionPrdctYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">결합 상품2</th>
					<td style="text-align:center"><input type="checkbox" name="fusionPrdct2Yn" value="Y" <c:if test="${info.fusionPrdct2Yn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">고객명</th>
					<td style="text-align:center"><input type="checkbox" name="nameYn" value="Y" <c:if test="${info.nameYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">점포명(GS수퍼)</th>
					<td style="text-align:center"><input type="checkbox" name="storeNmYn" value="Y" <c:if test="${info.storeNmYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">통신사</th>
					<td style="text-align:center"><input type="checkbox" name="telecomYn"  value="Y" <c:if test="${info.telecomYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">고객 연락처(핸드폰)</th>
					<td style="text-align:center"><input type="checkbox" name="hpYn"  value="Y" <c:if test="${info.hpYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">고객 연락처(유선전화)</th>
					<td style="text-align:center"><input type="checkbox" name="telYn"  value="Y" <c:if test="${info.telYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">이메일</th>
					<td style="text-align:center"><input type="checkbox" name="emailYn"  value="Y" <c:if test="${info.emailYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">주소</th>
					<td style="text-align:center"><input type="checkbox" name="addressYn"  value="Y" <c:if test="${info.addressYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>												
				<tr>
					<th style="vertical-align:middle;">상담 가능 시간대</th>
					<td style="text-align:center"><input type="checkbox" name="calltimeYn" value="Y" <c:if test="${info.calltimeYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">SKB 가입상태</th>
					<td style="text-align:center"><input type="checkbox" name="skbJoinYn" value="Y" <c:if test="${info.skbJoinYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">롯데카드번호</th>
					<td style="text-align:center"><input type="checkbox" name="lotCardNumYn" value="Y" <c:if test="${info.lotCardNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">코드</th>
					<td style="text-align:center"><input type="checkbox" name="cstmrCodeKrYn" value="Y" <c:if test="${info.cstmrCodeKrYn eq 'Y'}">checked="checked"</c:if> onclick="setCodeReadonly(this, 'cstmrCodeEnYn')" /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">고객 고유번호</th>
					<td style="text-align:center"><input type="checkbox" name="cstmrUnqNumYn" value="Y" <c:if test="${info.cstmrUnqNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">카드번호</th>
					<td style="text-align:center"><input type="checkbox" name="cardNumYn" value="Y" <c:if test="${info.cardNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">NUMBER</th>
					<td style="text-align:center"><input type="checkbox" name="cstmrNumYn" value="Y" <c:if test="${info.cstmrNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">CODE</th>
					<td style="text-align:center"><input type="checkbox" name="cstmrCodeEnYn" value="Y" <c:if test="${info.cstmrCodeEnYn eq 'Y'}">checked="checked"</c:if> onclick="setCodeReadonly(this, 'cstmrCodeKrYn')" /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">기타</th>
					<td style="text-align:center"><input type="checkbox" name="cstmrEtcYn" value="Y" <c:if test="${info.cstmrEtcYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">한샘 통합 멤버십</th>
					<td style="text-align:center"><input type="checkbox" name="hanssMbspNumYn" value="Y" <c:if test="${info.hanssMbspNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">멤버십 번호</th>
					<td style="text-align:center"><input type="checkbox" name="mbspNumYn" value="Y" <c:if test="${info.mbspNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">메모</th>
					<td style="text-align:center"><input type="checkbox" name="memoYn" value="Y" <c:if test="${info.memoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">인입경로</th>
					<td style="text-align:center"><input type="checkbox" name="funnelYn" value="Y" <c:if test="${info.funnelYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">여행지</th>
					<td style="text-align:center"><input type="checkbox" name="travelYn" value="Y" <c:if test="${info.travelYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">자유투어 예약번호</th>
					<td style="text-align:center"><input type="checkbox" name="jauNumYn" value="Y" <c:if test="${info.jauNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">대명투어몰 예약번호</th>
					<td style="text-align:center"><input type="checkbox" name="dmTourNumYn" value="Y" <c:if test="${info.dmTourNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">롯데카드 발급 상태</th>
					<td style="text-align:center"><input type="checkbox" name="lotteCardYn" value="Y" <c:if test="${info.lotteCardYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">롯데카드 결제 상태</th>
					<td style="text-align:center"><input type="checkbox" name="lotteCardPayYn" value="Y" <c:if test="${info.lotteCardPayYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">여행 예약 번호</th>
					<td style="text-align:center"><input type="checkbox" name="tourBookNoYn" value="Y" <c:if test="${info.tourBookNoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">가입구좌</th>
					<td style="text-align:center"><input type="checkbox" name="joinProdYn" value="Y" <c:if test="${info.joinProdYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>				
				<tr>
					<th style="vertical-align:middle;">U+홈상품 가입번호</th>
					<td style="text-align:center"><input type="checkbox" name="homePrdNumYn" value="Y" <c:if test="${info.homePrdNumYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">카드결제 유무</th>
					<td style="text-align:center"><input type="checkbox" name="cardPayYn" value="Y" <c:if test="${info.cardPayYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">할인 받을 연락처(CTN)</th>
					<td style="text-align:center"><input type="checkbox" name="discountCtnYn" value="Y" <c:if test="${info.discountCtnYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">할인 받을 명의자 생년월일</th>
					<td style="text-align:center"><input type="checkbox" name="discountPinYn" value="Y" <c:if test="${info.discountPinYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">계약 번호</th>
					<td style="text-align:center"><input type="checkbox" name="contractNoYn" value="Y" <c:if test="${info.contractNoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">견적 금액</th>
					<td style="text-align:center"><input type="checkbox" name="estimatePriceYn" value="Y" <c:if test="${info.estimatePriceYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">예식일</th>
					<td style="text-align:center"><input type="checkbox" name="weddingDateYn" value="Y" <c:if test="${info.weddingDateYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">주 계약</th>
					<td style="text-align:center"><input type="checkbox" name="mainContTypeYn" value="Y" <c:if test="${info.mainContTypeYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">초대코드</th>
					<td style="text-align:center"><input type="checkbox" name="inviteCodeYn" value="Y" <c:if test="${info.inviteCodeYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">안내사항</th>
					<td style="text-align:center"><input type="checkbox" name="cinfoYn" value="Y" <c:if test="${info.cinfoYn eq 'Y'}">checked="checked"</c:if> /></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="cinfo" style="width:96%">${info.cinfo}</textarea></td>
				</tr>
			</tbody>		
		</table>		
	</div>
	
	<div style="clear:left">
		<h4>정보동의 <input type="checkbox" name="termsYn" value="Y" <c:if test="${info.termsYn eq 'Y'}">checked="checked"</c:if> /></h4>
		
		<table class="table table-bordered">
			<tr>
				<th colspan="4" style="vertical-align:middle;">내용</th>
			</tr>
			
			<tr>
				<td colspan="4" style="vertical-align:middle;">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="terms" name="terms" style="display:none; width:98%;" exec="editorSync(this.id)">${info.terms}</textarea>
					<script type="text/javascript">editorAdd("terms");</script>
				</td>
			</tr>		
		</table>
	</div>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty info}">
			<a href="javascript: chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript: chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript: cancel()" class="btn btn-default">취소</a>
</div>

<script type="text/javascript">
	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		var msg = "";
		
		if(f.title.value == "")
		{
			alert("제목을 입력하세요.");
			f.title.focus();
			return false;
		}
		
		if(f.oscCd.value == "")
		{
			alert("외주업체 코드를 선택해주세요.");
			f.oscCd.focus();
			return false;
		}
		
		if(f.b2bStts.value == "")
		{
			alert("B2B_STTS 값을 입력해주세요.");
			f.b2bStts.focus();
			return false;
		}
		
		if(!validate(f))
		{
			return;
		}	
		
		if(f.seq.value == "")
		{
			msg = "등록하시겠습니까?";	
		}
		else
		{
			msg = "수정하시겠습니까?";
		}
		
		if(confirm(msg))
		{
			f.submit();		 
		}
	}
	
	//취소하기
	function cancel()
	{
		var f = document.frm;	
		
		f.action = "./list.do";
		f.submit();
	}
	
	function setPrdctReadonly(trgtObj)
	{
		if(jQuery(trgtObj).is(":checked"))
		{
			jQuery("input[name='prdctNm2Yn']").prop("disabled", false);
			jQuery("input[name='prdctNm3Yn']").prop("disabled", false);
		}
		else
		{
			jQuery("input[name='prdctNm2Yn']").prop("checked", false);
			jQuery("input[name='prdctNm2Yn']").prop("disabled", true);
			jQuery("input[name='prdctNm3Yn']").prop("checked", false);
			jQuery("input[name='prdctNm3Yn']").prop("disabled", true);
		}
	}
	
	function setCodeReadonly(obj, trgt)
	{
		if(jQuery(obj).is(":checked"))
		{
			jQuery("input[name='" + trgt + "']").prop("checked", false);
			jQuery("input[name='" + trgt + "']").prop("disabled", true);
		}
		else
		{
			jQuery("input[name='" + trgt + "']").prop("disabled", false);
		}
	}
</script>