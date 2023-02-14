<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMGAcctChngList.jsp
	프로그램 명 : 	결제계좌변경 내역 목록을 조회한다.
	설명		: 	결제계좌변경 내역 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.03.07
	수정일자				수정자				수정내용
	=====================================================================
	2016.03.07				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		현황 : 
		<select name="prcsYn">
			<option value="">전체</option>
			<option value="N" <c:if test="${rtnMap.prcsYn eq 'N'}">selected</c:if>>대기</option>
			<option value="Y" <c:if test="${rtnMap.prcsYn eq 'Y'}">selected</c:if>>완료</option>
		</select>
		&nbsp;&nbsp;
		접수일 : 
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
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">결제계좌변경 내역 관리</caption>
		<thead>
			<tr>
				<th width="5%">번호</th>
				<th width="7%">회원번호</th>
				<th width="9%">이름(아이디)</th>
				<th width="50%">변경전 / 변경후</th>
				<th width="9%">해피콜 가능시간</th>
				<th width="8%">접수일</th>
				<th width="8%">완료일</th>
				<th width="10%">현황</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="8" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	 			<tr onclick="selectMemInfDtl('${list.id}', 'list_${status.index}');" id="list_${status.index}">
	 				<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${list.accntNo}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						<input type="hidden" name="name" value="${list.nameNosk}" />
						<input type="hidden" name="hp" value="${list.hpNosk}" />
						<input type="hidden" name="bfrCardNo" value="${list.bfrCardNoNosk}" />
						<input type="hidden" name="aftCardNo" value="${list.aftCardNoNosk}" />
						<input type="hidden" name="bfrCardExprYr" value="${list.bfrCardExprYrNosk}" />
						<input type="hidden" name="bfrCardExprMm" value="${list.bfrCardExprMmNosk}" />
						<input type="hidden" name="aftCardExprYr" value="${list.aftCardExprYrNosk}" />
						<input type="hidden" name="aftCardExprMm" value="${list.aftCardExprMmNosk}" />
						<span class="name_class">${list.name}</span><br />
						(${list.id})
					</td>
					<td style="text-align:left;">
						예금주 : <span class="name_class">${list.name}</span> / 
						생년월일 : ${egov:convertDate(list.birth, 'yyyyMMdd', 'yyyy-MM-dd', '')} / 
						연락처 : <span class="hp_class">${list.hp}</span>   
						<br />
						<c:choose>
							<c:when test="${list.bfrPmtGb eq '04'}">
								결제유형 : CMS /
								은행명 : ${list.bfrBankNm} /
								계좌번호 : ${list.bfrAcntNo} / 
								납부일자 : ${list.bfrPmtDay}일
							</c:when>
							<c:when test="${list.bfrPmtGb eq '06'}">
								결제유형 : 카드 /
								카드명 : ${list.bfrCardNm} /
								카드번호 : <span class="bfrCardNo_class">${list.bfrCardNo}</span> / 
								납부일자 : ${list.bfrPmtDay}일 /
								카드유효기간 : <span class="bfrCardExprYr_class">${list.bfrCardExprYr}</span>년 <span class="bfrCardExprMm_class">${list.bfrCardExprMm}</span>월
							</c:when>
						</c:choose>
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${list.hyclAbleTimeNm}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${egov:decode(list.prcsYn, 'Y', egov:convertDate(list.modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '-')}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						<select onchange="updatePrcsYn(this, '${list.chngSeq}', '${list.prcsYn}');">
							<option value="N" <c:if test="${list.prcsYn eq 'N'}">selected</c:if>>대기</option>
							<option value="Y" <c:if test="${list.prcsYn eq 'Y'}">selected</c:if>>완료</option>
						</select>
					</td>
				</tr>
				<tr id="list_${status.index}_btm" onclick="selectMemInfDtl('${list.id}', 'list_${status.index}');">
	 				<td style="text-align:left;">
						<font>
							예금주 : <span class="name_class">${list.name}</span>
						</font> / 
						<font>
							생년월일 : ${egov:convertDate(list.birth, 'yyyyMMdd', 'yyyy-MM-dd', '')}
						</font> /
						<font>
							연락처 : <span class="hp_class">${list.hp}</span>
						</font>
						<br />
						
						<c:choose>
							<c:when test="${list.bfrPmtGb eq list.aftPmtGb}">
								<c:choose>
									<c:when test="${list.aftPmtGb eq '04'}">
										결제유형 : CMS /
										<font <c:if test="${list.bfrBankNm ne list.aftBankNm}">style="font-weight:bold; color:#ED006D;"</c:if>>
											은행명 : ${list.aftBankNm}
										</font> /
										<font <c:if test="${list.bfrAcntNo ne list.aftAcntNo}">style="font-weight:bold; color:#ED006D;"</c:if>>
											계좌번호 : ${list.aftAcntNo}
										</font> /
										<font <c:if test="${list.bfrPmtDay ne list.aftPmtDay}">style="font-weight:bold; color:#ED006D;"</c:if>>
											납부일자 : ${list.aftPmtDay}일
										</font>
									</c:when>
									<c:when test="${list.aftPmtGb eq '06'}">
										결제유형 : 카드 /
										<font <c:if test="${list.bfrCardNm ne list.aftCardNm}">style="font-weight:bold; color:#ED006D;"</c:if>>
											카드명 : ${list.aftCardNm}
										</font> /
										<font <c:if test="${list.bfrCardNo ne list.aftCardNo}">style="font-weight:bold; color:#ED006D;"</c:if>>
											카드번호 : <span class="aftCardNo_class">${list.aftCardNo}</span>
										</font> /
										<font <c:if test="${list.bfrPmtDay ne list.aftPmtDay}">style="font-weight:bold; color:#ED006D;"</c:if>>
											납부일자 : ${list.aftPmtDay}일
										</font> /
										<font <c:if test="${list.bfrCardExprYr ne list.aftCardExprYr or list.bfrCardExprMm ne list.aftCardExprMm}">style="font-weight:bold; color:#ED006D;"</c:if>>
											카드유효기간 : <span class="aftCardExprYr_class">${list.aftCardExprYr}</span>년 <span class="aftCardExprMm_class">${list.aftCardExprMm}</span>월
										</font>
									</c:when>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${list.aftPmtGb eq '04'}">
										<font style="font-weight:bold; color:#ED006D;">
											결제유형 : CMS
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											은행명 : ${list.aftBankNm}
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											계좌번호 : ${list.aftAcntNo}
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											납부일자 : ${list.aftPmtDay}일
										</font>
									</c:when>
									<c:when test="${list.aftPmtGb eq '06'}">
										<font style="font-weight:bold; color:#ED006D;">
											결제유형 : 카드
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											카드명 : ${list.aftCardNm}
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											카드번호 : <span class="aftCardNo_class">${list.aftCardNo}</span>
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											납부일자 : ${list.aftPmtDay}일
										</font> /
										<font style="font-weight:bold; color:#ED006D;">
											카드유효기간 : <span class="aftCardExprYr_class">${list.aftCardExprYr}</span>년 <span class="aftCardExprMm_class">${list.aftCardExprMm}</span>월
										</font>
									</c:when>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Modal -->
	<div class="modal fade" id="acctChngDtl" tabindex="-1" role="dialog" style="width:1100px; margin-left: 0; transform: translate(-50%);">
		<div class="modal-content">
		
			<div class="modal-body" style="text-align:left;">
				<table class="table table-bordered table-hover">
					<caption style="display: none;">결제계좌변경 내역 관리</caption>
					<thead>
						<tr>
							<th width="4%">번호</th>
							<th width="7%">회원번호</th>
							<th width="7%">이름(아이디)</th>
							<th width="53%">변경전 / 변경후</th>
							<th width="9%">해피콜 가능시간</th>
							<th width="8%">접수일</th>
							<th width="8%">완료일</th>
							<th width="10%">현황</th>
						</tr>
					</thead>
					<tbody>
						<tr id="detail">
						</tr>
						<tr id="detail_btm">
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
			</div>
			
		</div>
	</div>
</form>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>
	
<script type="text/javascript">

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
		
		f.action = "./list.do";
		f.submit();
	}

	//상세 가져오기
	function selectMemInfDtl(id, listId)
	{
// 		debugger;
		$('#detail').html( $('#'+listId).html() );
		$('#detail_btm').html( $('#'+listId+"_btm").html() );
		
		$('#detail .name_class').html($('#detail input[name=name]').val());
		$('#detail .hp_class').html($('#detail input[name=hp]').val());
		$('#detail .bfrCardNo_class').html($('#detail input[name=bfrCardNo]').val());
		$('#detail .bfrCardExprYr_class').html($('#detail input[name=bfrCardExprYr]').val());
		$('#detail .bfrCardExprMm_class').html($('#detail input[name=bfrCardExprMm]').val());
		
		$('#detail_btm .name_class').html($('#detail input[name=name]').val());
		$('#detail_btm .hp_class').html($('#detail input[name=hp]').val());
		$('#detail_btm .aftCardNo_class').html($('#detail input[name=aftCardNo]').val());
		$('#detail_btm .aftCardExprYr_class').html($('#detail input[name=aftCardExprYr]').val());
		$('#detail_btm .aftCardExprMm_class').html($('#detail input[name=aftCardExprMm]').val());
		
		jQuery("#acctChngDtl").modal("show");
		
	}
	
	//처리현황을 수정한다.
	function updatePrcsYn(obj, chngSeq, prcsYn)
	{
		if(confirm("현황을 변경하시겠습니까?"))
		{
			jQuery.post("./prcs-update.ajax",
				{
					"chngSeq" : chngSeq, 
					"prcsYn" : jQuery(obj).val() 
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y") 
					{
						alert("변경되었습니다.");
						window.location.reload(true);
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
		else
		{
			jQuery(obj).find("option[value='"+prcsYn+"']").prop("selected", true);
		}
	}
	
</script>