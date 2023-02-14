<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMCPfmcRsvtnList.jsp
	프로그램 명 : 	공연예약 목록을 조회한다.
	설명		: 	공연예약 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.18
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.18				허진영				최초작성
	######################################################################
-->

<form name="frm" action="${pageLink}" method="post">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="rsvtnSeq" value="" />
	
	<div class="well well-small">
		예약현황 : 
		<select name="prcsCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.rsvtnPrcsStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
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
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>공연명</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>회원번호</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>회원명</option>
			<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>연락처</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">공연예약 관리</caption>
		<thead>
			<tr>
				<th rowspan="2" width="5%" style="vertical-align:middle;">
					<input type="checkbox" name="all_check" />
				</th>
				<th rowspan="2" width="6%" style="vertical-align:middle;">
					번호
				</th>
				<th rowspan="2" width="8%" style="vertical-align:middle;">
					접수구분
				</th>
				<th rowspan="2" width="20%" style="vertical-align:middle;">
					공연명
				</th>
				<th rowspan="2" width="10%" style="vertical-align:middle;">
					회원명
				</th>
				<th rowspan="2" width="9%" style="vertical-align:middle;">
					회원번호
				</th>
				<th rowspan="2" width="9%" style="vertical-align:middle;">
					연락처
				</th>
				<th rowspan="2" width="9%" style="vertical-align:middle;">
					접수일
				</th>
				<th rowspan="2" width="10%" style="vertical-align:middle;">
					예약현황
				</th>
				<th colspan="2" width="14%" style="vertical-align:middle;">
					예약변경현황
				</th>
			</tr>
			<tr>
				<th width="7%">
					컨택담당자<br />확인연부
				</th>
				<th width="7%">
					공연기획사<br />확인여부
				</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="9" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
						<c:choose>
							<c:when test="${list.prcsCd eq '00' and (list.confYn1 eq 'N' or list.confYn2 eq 'N')}">
								<tr style="background-color:#FF7171;">
							</c:when>
							<c:otherwise>
								<tr>
							</c:otherwise>
						</c:choose>
							<td style="text-align:center; vertical-align:middle;">
								<input type="checkbox" name="delSeq" value="${list.rsvtnSeq}" />
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${egov:decode(list.gubun, '2', '홈페이지', 'DLCC')}
							</td>
							<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${egov:tldCutString(list.pfmcNm, '...', '35')}
							</td>
							<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${list.name}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${list.accntNo}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${list.hp}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								${list.prcsNm}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								<c:if test="${list.prcsCd eq '00'}">${egov:decode(list.confYn1, 'Y', '확인', '미확인')}</c:if>
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectPfmcRsvtnDtl('${list.rsvtnSeq}');">
								<c:if test="${list.prcsCd eq '00'}">${egov:decode(list.confYn2, 'Y', '확인', '미확인')}</c:if>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:excelList();" class="btn btn-info">엑셀 다운로드</a>
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
		
		f.action = "./list.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectPfmcRsvtnDtl(rsvtnSeq)
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.rsvtnSeq.value = rsvtnSeq;
		f.submit();
	}
	
	//선택 삭제하기
	function deletePfmcRsvtnList()
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
	
	//엑셀 다운로드
	function excelList()
	{	
		var f = document.frm;
		
		f.action ="./excel.do";
		f.submit();
	}
	
</script>
