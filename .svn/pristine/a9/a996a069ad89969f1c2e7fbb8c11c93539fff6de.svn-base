<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CSAVocList.jsp
	프로그램 명 : 	VOC 목록을 조회한다.
	설명		: 	VOC 목록을 조회하는 페이지
	작성자		: 	장준일
	작성일		:	2021.02.23	
	수정일자				수정자				수정내용
	=====================================================================
	2021.02.23				장준일				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="vocNo"  value=""/>
	
	<div class="well well-small">
		문의구분 : 
		<select name="ind">
			<option value="">전체</option>
			<option value="01" <c:if test="${rtnMap.ind eq '01'}">selected</c:if>>칭찬</option>
			<option value="02" <c:if test="${rtnMap.ind eq '02'}">selected</c:if>>불편</option>
			<option value="03" <c:if test="${rtnMap.ind eq '03'}">selected</c:if>>문의</option>
			<option value="11" <c:if test="${rtnMap.ind eq '11'}">selected</c:if>>단순칭찬</option>
			<option value="12" <c:if test="${rtnMap.ind eq '12'}">selected</c:if>>단순불편</option>
			<option value="99" <c:if test="${rtnMap.ind eq '99'}">selected</c:if>>기타</option>
		</select>
		&nbsp;&nbsp;
		<select name="delFg">
			<option value="">삭제여부-전체</option>
			<option value="Y" <c:if test="${rtnMap.delFg eq 'Y'}">selected</c:if>>삭제</option>
			<option value="N" <c:if test="${rtnMap.delFg eq 'N'}">selected</c:if>>정상</option>
		</select>
		&nbsp;&nbsp;
		<select name="dateType">
			<option value="">전체</option>
			<option value="regDt" <c:if test="${rtnMap.dateType eq 'regDt'}">selected</c:if>>작성일</option>
			<option value="rceptDt" <c:if test="${rtnMap.dateType eq 'rceptDt'}">selected</c:if>>발생일</option>
		</select>
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" value="${rtnMap.strtDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" value="${rtnMap.endDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		&nbsp;&nbsp;
		<select name="f">
			<option value="title" <c:if test="${rtnMap.f eq 'title'}">selected</c:if>>제목</option>
			<option value="dtlDesc" <c:if test="${rtnMap.f eq 'dtlDesc'}">selected</c:if>>내용</option>
			<option value="guestNm" <c:if test="${rtnMap.f eq 'guestNm'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">1:1 상담 관리</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th width="6%">번호</th>
				<th width="9%">구분</th>
				<th width="*">제목</th>
				<th width="10%">이름</th>
				<th width="11%">관련사업장</th>
				<th width="5%">대분류</th>
				<th width="5%">중분류</th>
				<th width="11%">발생일</th>
				<th width="11%">접수일</th>
				<th width="5%">상태</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="10" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	 			<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delSeq" value="${list.vocNo}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
 						<c:if test="${list.ind eq '01'}">칭찬</c:if>
 						<c:if test="${list.ind eq '02'}">불편</c:if>
 						<c:if test="${list.ind eq '03'}">문의</c:if>
 						<c:if test="${list.ind eq '11'}">단순칭찬</c:if>
 						<c:if test="${list.ind eq '12'}">단순불편</c:if>
 						<c:if test="${list.ind eq '99'}">기타</c:if>
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						${egov:tldCutString(list.title, '...', '35')}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						${list.guestNm}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						<c:if test="${list.storeCd == '01'}">비발디파크</c:if>
						<c:if test="${list.storeCd == '12'}">오션월드</c:if>
						<c:if test="${list.storeCd == '28'}">스키월드</c:if>
						<c:if test="${list.storeCd == '33'}">골프클럽</c:if>
						<c:if test="${list.storeCd == '18'}">소노펠리체 비발디파크</c:if>
						<c:if test="${list.storeCd == '02'}">델피노</c:if>
						<c:if test="${list.storeCd == '13'}">쏠비치 양양</c:if>
						<c:if test="${list.storeCd == '27'}">쏠비치 삼척</c:if>
						<c:if test="${list.storeCd == '04'}">소노문 양평</c:if>
						<c:if test="${list.storeCd == '03'}">소노문 단양</c:if>
						<c:if test="${list.storeCd == '10'}">소노벨 경주</c:if>
						<c:if test="${list.storeCd == '17'}">소노벨 변산</c:if>
						<c:if test="${list.storeCd == '22'}">소노캄 거제</c:if>
						<c:if test="${list.storeCd == '29'}">소노벨 청송</c:if>
						<c:if test="${list.storeCd == '30'}">소노벨 천안</c:if>
						<c:if test="${list.storeCd == '14'}">소노벨 제주</c:if>
						<c:if test="${list.storeCd == '32'}">소노캄 제주</c:if>
						<c:if test="${list.storeCd == '19'}">소노캄 여수</c:if>
						<c:if test="${list.storeCd == '20'}">소노캄 고양</c:if>
						<c:if test="${list.storeCd == '35'}">쏠비치 진도</c:if>
						<c:if test="${list.storeCd == '31'}">내린천휴게소</c:if>
						<c:if test="${list.storeCd == '07'}">회원관리/예약</c:if>
						<c:if test="${list.storeCd == '11'}">홈페이지/앱</c:if>
						<c:if test="${list.storeCd == '34'}">소노펠리체컨벤션</c:if>
						<c:if test="${list.storeCd == '36'}">소노펫클럽앤리조트 비발디파크</c:if>
						<c:if test="${list.storeCd == 'A1'}">대명건설</c:if>
						<c:if test="${list.storeCd == 'A2'}">소노시즌</c:if>
						<c:if test="${list.storeCd == 'A3'}">대명아임레디</c:if>
						<c:if test="${list.storeCd == 'A4'}">IRIS(법인사예약)</c:if>
						<c:if test="${list.storeCd == 'A5'}">IMP(소노통합구매)</c:if>
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						<c:if test="${list.category1 == 'D1'}">회원관리</c:if>
						<c:if test="${list.category1 == 'D2'}">상품관리</c:if>
						<c:if test="${list.category1 == 'D3'}">멤버십서비스</c:if>
						<c:if test="${list.category1 == 'D4'}">기타</c:if>
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						<c:if test="${list.category2 == 'D1'}">가입관련</c:if>
						<c:if test="${list.category2 == 'D2'}">납부관련</c:if>
						<c:if test="${list.category2 == 'D3'}">해약관련</c:if>
						<c:if test="${list.category2 == 'D4'}">상품관련</c:if>
						<c:if test="${list.category2 == 'D5'}">의전행사</c:if>
						<c:if test="${list.category2 == 'D6'}">하이브리드</c:if>
						<c:if test="${list.category2 == 'D7'}">리조트</c:if>
						<c:if test="${list.category2 == 'D8'}">부대시설</c:if>
						<c:if test="${list.category2 == 'D9'}">아임레디몰</c:if>
						<c:if test="${list.category2 == 'D10'}">홈페이지</c:if>
						<c:if test="${list.category2 == 'D11'}">컨택센터</c:if>
						<c:if test="${list.category2 == 'D12'}">기타</c:if>
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						${egov:convertDate(list.rceptDt, 'yyyy-MM-dd', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						${egov:convertDate(list.regDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectVocDtl('${list.vocNo}');">
						<c:if test="${list.delFg == 'Y'}"><span style="color:red;font-weight:bold;">삭제</span></c:if>
						<c:if test="${list.delFg == 'N'}">정상</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:deleteVocList();" class="btn btn-danger">삭제</a>
</div>


<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>
	
<script type="text/javascript">
	
	//체크박스 jQeury
	jQuery(document).ready(function(){
		//삭제 체크박스 전체 선택 & 해제
		jQuery("input:checkbox[name='all_check']").click(function(){
			if(jQuery(this).is(":checked"))
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", false);
			}	
		});
		
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='delSeq']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='delSeq']").length;
			var selChkCnt = jQuery("input:checkbox[name='delSeq']:checked").length;
			
			if(allChkCnt==selChkCnt)
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", false);
			}
		});
		
	});

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
		
		f.action = "./index.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectVocDtl(vocNo)
	{
		var f = document.frm;
		
		f.action = "./view.do";
		f.vocNo.value = vocNo;
		f.submit();
	}
	
	//선택 삭제하기
	function deleteVocList()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				var f = document.frm;
				
				f.action = "./delete.do";
				f.submit();
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
</script>