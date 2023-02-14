<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMAOnlinePrdctCsView.jsp
	프로그램 명 : 	온라인 상담신청 조회.
	설명		: 	온라인 상담신청 조회
	작성자		: 	김필기
	작성일		:	2016.02.22
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.22				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap.onlinePrdctCsInfo}" />
<c:set var="prdctInfo" value="${rtnMap.onlinePrdctInf}" />
<c:set var="acntInfo" value="${rtnMap.onlinePrdctAcntInf}" />


<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post"  >
	<input type="hidden" name="onlinePrdctCsSeq" value="${info.onlinePrdctCsSeq}" />
	
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	
	<h5>● 상품정보</h5>
	
	<c:if test="${info.prdctCsGb eq rtnMap.gnrlPrdctCd}">
	<c:forEach var="list" items="${prdctInfo}" varStatus="status">
	<table class="table table-bordered">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 상품선택
				</th>
				<td>${list.prdctNm} 구좌 : ${list.prdctAcnt}</td>				
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 납입방식
				</th>
				<td>${list.payMtd}</td>
			</tr>
			<tr>
				<th>담당자</th>
				<td>${egov:decode(list.asgnYn, 'Y',  list.asgnNm, '없음')}</td>
			</tr>
		</tbody>		
	</table>	
	</c:forEach>
	</c:if>

	<c:if test="${info.prdctCsGb eq rtnMap.b2bPrdctCd}">
	<c:forEach var="list" items="${prdctInfo}" varStatus="status">	
	<table class="table table-bordered">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					상품선택
				</th>
				<td>
					${list.prdctNm}
				</td>				
			</tr>
			
			<c:if test="${info.prdctCsGb eq 'b2b' }">
			<tr>
				<th>상세상품</th>
				<td>
					${list.prdctDtlNm}(${list.prdctDtlModel})
				</td>
			</tr>
			</c:if>
			
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					추가부담금(1~36회차)
				</th>
				<td>
					${list.alt}원
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					납입방식
				</th>
				<td>${list.payMtd}</td>
			</tr>
			<tr>
				<th>담당자</th>
				<c:if test="${list.coNm eq null && list.coCd eq null }">
				<td>${egov:decode(list.asgnYn, 'Y',  list.asgnNm, '없음')}</td>
				</c:if>
				
				<c:if test="${list.coNm ne null && list.coCd ne null }">
				<td>회사명 : ${list.coNm}, 부서(지점명) : ${list.dept}, 사원명 : ${list.stf}</td>
				</c:if>				
			</tr>
		</tbody>		
	</table>
	</c:forEach>		
	</c:if>
		


	<h5>● 고객정보 입력</h5>
	<table class="table table-bordered">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>회원이름</th>
				<td>${info.name}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${info.birth}</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${egov:decode(info.sex, 'm', '남성', '여성')}</td>
			</tr>
			<tr>
				<th>휴대전화</th>
				<td>${info.hp}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${info.tel}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${info.email}</td>
			</tr>
			<tr>
				<th>주소(우편물 수령)</th>
				<td>${info.zipcd1}&nbsp;${info.adr}&nbsp;${info.adrDtl}</td>
			</tr>
			<c:if test="${info.zipcd2 ne null && info.adr2 ne null }">
			<tr>
				<th>주소(전자제품 설치)</th>
				<td>${info.zipcd2}&nbsp;${info.adr2}&nbsp;${info.adrDtl2}</td>
			</tr>																
			</c:if>			
		</tbody>
	</table>
	

	
	<h5>● 계좌정보 입력</h5>
	<table class="table table-bordered">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>결제구분</th>
				<td>${egov:decode(acntInfo.pmtGb, rtnMap.cms, "CMS", "신용카드")}</td>
			</tr>
			<tr>
				<th>예금주</th>
				<td>${acntInfo.acnthd}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${acntInfo.acntBirth }</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${acntInfo.acntHp }</td>
			</tr>	
			<c:if test="${acntInfo.pmtGb eq rtnMap.cms}">
			<tr>
				<th>은행명</th>
				<td>${acntInfo.pmtCoGb}</td>
			</tr>			
			<tr>
				<th>계좌번호</th>
				<td>${acntInfo.pmtNo}</td>
			</tr>
			</c:if>
			
			<c:if test="${acntInfo.pmtGb eq rtnMap.creditCard}">
			<tr>
				<th>카드사</th>
				<td>${acntInfo.pmtCoGb}</td>
			</tr>			
			<tr>
				<th>카드번호</th>
				<td>${acntInfo.pmtNo}&nbsp;&nbsp;&nbsp;&nbsp;${acntInfo.expYr}년 ${acntInfo.expMm}월</td>
			</tr>
			</c:if>			
			<tr>
				<th>납부일자</th>
				<td>${acntInfo.pmtDayGb}</td>
			</tr>
			<tr>
				<th>해피콜 가능시간</th>
				<td>${acntInfo.happyCallGb}</td>
			</tr>					
		</tbody>	
	</table>

	<h5>● 상담내용 입력</h5>
	<table class="table table-bordered">
		<colgroup>
			<col width="15%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>처리현황</th>
				<td>
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
						<input type="radio" name="prcs_cd" value="${cdlist.cd}" <c:if test="${info.prcsCd eq cdlist.cd}">checked="checked"</c:if> />${cdlist.cdNm}&nbsp;
					</c:forEach>					
				</td>
			</tr>
			<tr>
				<th>상담이력</th>
				<td>
					<textarea name="answ" style="width:99%; height:100px">${info.answ}</textarea>
				</td>
			</tr>
			<tr>
				<th>처리일시</th>
				<td>
					<c:if test="${info.modId ne null}">
						${info.modNm}(${info.modId}) &nbsp; ${info.modDtm}
					</c:if>
				</td>
			</tr>	
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="button" value="상담이력 등록" class="btn btn-info" onclick="memoReg()" />
				</td>
			</tr>					
		</tbody>
	</table>

</form>

<div style="float:left;">
	<!-- <input type="button" value="삭제"  class="btn btn-danger" onclick="deleteInfo()"> -->
</div>
<div style="text-align:right;">
	<a href="javascript: document.listFrm.submit()" class="btn btn-inverse">목록</a>
</div>

<script type="text/javascript">
function memoReg(){
	var f = document.frm;
	if(f.answ.value == ""){
		alert("상담이력을 입력해주세요.");
		f.answ.focus();
	}else{
		if(confirm("상담이력을 등록하시겠습니까?")){
			f.action = "./update.do";
			f.submit();
		}		
	}	
}

function deleteInfo()
{
	var f = document.frm;
	
	if(confirm("삭제하시겠습니까?")) 
	{
		f.action="./delete.do";
		f.submit();
	}
}
</script>