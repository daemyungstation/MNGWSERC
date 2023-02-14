<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--  
	######################################################################
	파일명 		:	CSAJoinCnslList.jsp
	프로그램 명 : 	가입 상담 목록을 조회한다.
	설명		: 	가입 상담 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.07
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.07				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="joinCnslSeq"  value="" />
	
	<div class="well well-small">
		문의구분 : 
		<select name="inqryCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.joinInqryGb}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.inqryCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		현황 : 
		<select name="prcsCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>제목</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>내용</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">가입 상담 관리</caption>
		<thead>
			<tr>
				<th width="4%" rowspan="2" style="vertical-align:middle;"><input type="checkbox" name="all_check"/></th>
				<th width="5%" rowspan="2" style="vertical-align:middle;">번호</th>
				<th width="7%" rowspan="2" style="vertical-align:middle;">구분</th>
				<th width="18%" rowspan="2" style="vertical-align:middle;">제목</th>
				<th width="9%" rowspan="2" style="vertical-align:middle;">작성자</th>
				<th width="9%" rowspan="2" style="vertical-align:middle;">작성일</th>
				<th width="9%" rowspan="2" style="vertical-align:middle;">처리일</th>
				<th width="7%" rowspan="2" style="vertical-align:middle;">현황</th>
				<th width="32%" colspan="3">가입현황</th>				
			</tr>
			<tr>
				<th width="8%">회원번호</th>
				<th width="14%">상품명</th>
				<th width="8%">가입일자</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	 			<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delSeq" value="${list.joinCnslSeq}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${list.inqryNm}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${egov:tldCutString(list.titl, '...', '35')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${list.name}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${egov:decode(list.prcsDtm, null, '-', egov:convertDate(list.prcsDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', ''))}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${list.prcsNm}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${list.accntNo}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${list.prodNm}	
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectJoinCnslDtl('${list.joinCnslSeq}');">
						${egov:convertDate(list.joinDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>										
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:deleteJoinCnslList();" class="btn btn-danger">삭제</a>
</div>

<div style="float:right;">
	<a href="javascript:selectJoinCnslExcelList();" class="btn btn-info">엑셀 다운로드</a>
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
	function selectJoinCnslDtl(joinCnslSeq)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.joinCnslSeq.value = joinCnslSeq;
		f.submit();
	}
	
	//선택 삭제하기
	function deleteJoinCnslList()
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
	function selectJoinCnslExcelList()
	{
		var f = document.frm;
		
		f.action = "./excel.do";
		f.submit();
	}
	
</script>