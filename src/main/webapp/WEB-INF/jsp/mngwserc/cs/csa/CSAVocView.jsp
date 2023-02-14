<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CSAVocView.jsp
	프로그램 명 : 	VOC 상세를 조회한다.
	설명		: 	VOC 상세를 조회하는 페이지
	작성자		: 	장준일
	작성일		:	2021.02.23	
	수정일자				수정자				수정내용
	=====================================================================
	2021.02.23				장준일				최초작성
	######################################################################
-->

<c:set var="vocInfo" value="${rtnMap.vocInfo}" />

<form name="listFrm" method="post" action="./index.do">
	<input type="hidden" name="delFg" value="${rtnMap.delFg}" />
	<input type="hidden" name="ind" value="${rtnMap.ind}" />
	<input type="hidden" name="dateType" value="${rtnMap.dateType}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

</form>

<form name="frm" method="post" action="" >
	<input type="hidden" name="delSeq" value="" />
	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="inqryDtlCd" value="${rtnMap.inqryDtlCd}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<table class="table table-bordered">
		<caption style="display: none;">VOC 상세</caption>
		<colgroup>
			<col width="20%" />
			<col width="20%" />
			<col width="20%" />	
			<col width="20%" />	
			<col width="20%" />	
		</colgroup>
		<tbody>
			<tr>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>이름</b> : ${vocInfo.guestNm}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>연락처</b> : ${vocInfo.moblNo}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>이메일</b> : ${vocInfo.emailAddr}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>성별/나이</b> : 
					<c:if test="${vocInfo.gen == '1'}">남</c:if>
					<c:if test="${vocInfo.gen == '2'}">여</c:if>
					/
					${vocInfo.age}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>거주지역</b> :
					<c:if test="${vocInfo.locate == '01'}">서울</c:if>
					<c:if test="${vocInfo.locate == '02'}">경기</c:if>
					<c:if test="${vocInfo.locate == '03'}">인천</c:if>
					<c:if test="${vocInfo.locate == '04'}">강원</c:if>
					<c:if test="${vocInfo.locate == '05'}">대전</c:if>
					<c:if test="${vocInfo.locate == '06'}">광주</c:if>
					<c:if test="${vocInfo.locate == '07'}">대구</c:if>
					<c:if test="${vocInfo.locate == '08'}">부산</c:if>
					<c:if test="${vocInfo.locate == '09'}">울산</c:if>
					<c:if test="${vocInfo.locate == '10'}">충남</c:if>
					<c:if test="${vocInfo.locate == '11'}">충북</c:if>
					<c:if test="${vocInfo.locate == '12'}">경남</c:if>
					<c:if test="${vocInfo.locate == '13'}">경북</c:if>
					<c:if test="${vocInfo.locate == '14'}">전남</c:if>
					<c:if test="${vocInfo.locate == '15'}">전북</c:if>
					<c:if test="${vocInfo.locate == '16'}">제주</c:if>
					<c:if test="${vocInfo.locate == '17'}">미확인</c:if>
					<c:if test="${vocInfo.locate == '99'}">기타</c:if>
				</td>
			</tr>
			<tr>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>관련사업장</b> :
					<c:if test="${vocInfo.storeCd == '01'}">비발디파크</c:if>
					<c:if test="${vocInfo.storeCd == '12'}">오션월드</c:if>
					<c:if test="${vocInfo.storeCd == '28'}">스키월드</c:if>
					<c:if test="${vocInfo.storeCd == '33'}">골프클럽</c:if>
					<c:if test="${vocInfo.storeCd == '18'}">소노펠리체 비발디파크</c:if>
					<c:if test="${vocInfo.storeCd == '02'}">델피노</c:if>
					<c:if test="${vocInfo.storeCd == '13'}">쏠비치 양양</c:if>
					<c:if test="${vocInfo.storeCd == '27'}">쏠비치 삼척</c:if>
					<c:if test="${vocInfo.storeCd == '04'}">소노문 양평</c:if>
					<c:if test="${vocInfo.storeCd == '03'}">소노문 단양</c:if>
					<c:if test="${vocInfo.storeCd == '10'}">소노벨 경주</c:if>
					<c:if test="${vocInfo.storeCd == '17'}">소노벨 변산</c:if>
					<c:if test="${vocInfo.storeCd == '22'}">소노캄 거제</c:if>
					<c:if test="${vocInfo.storeCd == '29'}">소노벨 청송</c:if>
					<c:if test="${vocInfo.storeCd == '30'}">소노벨 천안</c:if>
					<c:if test="${vocInfo.storeCd == '14'}">소노벨 제주</c:if>
					<c:if test="${vocInfo.storeCd == '32'}">소노캄 제주</c:if>
					<c:if test="${vocInfo.storeCd == '19'}">소노캄 여수</c:if>
					<c:if test="${vocInfo.storeCd == '20'}">소노캄 고양</c:if>
					<c:if test="${vocInfo.storeCd == '35'}">쏠비치 진도</c:if>
					<c:if test="${vocInfo.storeCd == '31'}">내린천휴게소</c:if>
					<c:if test="${vocInfo.storeCd == '07'}">회원관리/예약</c:if>
					<c:if test="${vocInfo.storeCd == '11'}">홈페이지/앱</c:if>
					<c:if test="${vocInfo.storeCd == '34'}">소노펠리체컨벤션</c:if>
					<c:if test="${vocInfo.storeCd == '36'}">소노펫클럽앤리조트 비발디파크</c:if>
					<c:if test="${vocInfo.storeCd == 'A1'}">대명건설</c:if>
					<c:if test="${vocInfo.storeCd == 'A2'}">소노시즌</c:if>
					<c:if test="${vocInfo.storeCd == 'A3'}">대명아임레디</c:if>
					<c:if test="${vocInfo.storeCd == 'A4'}">IRIS(법인사예약)</c:if>
					<c:if test="${vocInfo.storeCd == 'A5'}">IMP(소노통합구매)</c:if>
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<c:if test="${vocInfo.category1 == 'D1'}">회원관리</c:if>
					<c:if test="${vocInfo.category1 == 'D2'}">상품관리</c:if>
					<c:if test="${vocInfo.category1 == 'D3'}">멤버십서비스</c:if>
					<c:if test="${vocInfo.category1 == 'D4'}">기타</c:if>
					/
					<c:if test="${vocInfo.category2 == 'D1'}">가입관련</c:if>
					<c:if test="${vocInfo.category2 == 'D2'}">납부관련</c:if>
					<c:if test="${vocInfo.category2 == 'D3'}">해약관련</c:if>
					<c:if test="${vocInfo.category2 == 'D4'}">상품관련</c:if>
					<c:if test="${vocInfo.category2 == 'D5'}">의전행사</c:if>
					<c:if test="${vocInfo.category2 == 'D6'}">하이브리드</c:if>
					<c:if test="${vocInfo.category2 == 'D7'}">리조트</c:if>
					<c:if test="${vocInfo.category2 == 'D8'}">부대시설</c:if>
					<c:if test="${vocInfo.category2 == 'D9'}">아임레디몰</c:if>
					<c:if test="${vocInfo.category2 == 'D10'}">홈페이지</c:if>
					<c:if test="${vocInfo.category2 == 'D11'}">컨택센터</c:if>
					<c:if test="${vocInfo.category2 == 'D12'}">기타</c:if>
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>발생일</b> : ${egov:convertDate(vocInfo.rceptDt, 'yyyy-MM-dd', 'yyyy-MM-dd', '')}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>접수일</b> : ${egov:convertDate(vocInfo.regDt, 'yyyy-MM-dd HH:mm', 'yyyy-MM-dd HH:mm', '')}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>회신방법</b> : 
					<c:if test="${vocInfo.resind == '01'}">이메일</c:if>
					<c:if test="${vocInfo.resind == '03'}">휴대전화</c:if>
					<c:if test="${vocInfo.resind == '04'}">회신거부</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="5" style="height:200px; text-align:left;">
					<jsp:scriptlet>
					    pageContext.setAttribute("cr", "\r");
					    pageContext.setAttribute("lf", "\n");
					    pageContext.setAttribute("crlf", "\r\n");
					</jsp:scriptlet>
					${fn:replace(fn:replace(vocInfo.dtlDesc, ' ', '&nbsp;'), crlf, '<br />')}
 				</td>
			</tr>
		</tbody>
	</table>
	
	<div style="text-align:right; margin-bottom:20px;">
		<a href="javascript:deleteVoc();" class="btn btn-danger">삭제</a>
		<a href="javascript:document.listFrm.submit();" class="btn btn-default">목록</a>						
	</div>
</form>

<script type="text/javascript">	
	//1:1 상담 삭제
	function deleteVoc()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.delSeq.value = "${vocInfo.vocNo}";
			f.submit();
		}
	}
	
</script>