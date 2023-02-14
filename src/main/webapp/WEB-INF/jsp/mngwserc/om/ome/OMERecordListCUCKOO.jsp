<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
 
<!-- 
	######################################################################
	파일명 		:	OMERecordList.jsp
	프로그램 명 : 	실적관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.18
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.18				김필기				최초작성
	######################################################################
-->

<style>
	.scrollX {overflow-x:scroll; width:100%;}
	.scrollX table {width: 1700px; max-width:1700px; font-size: 12px}
</style>

<c:choose>
	<c:when test="${rtnMap.id eq 'sktelecom' || rtnMap.id eq 'skbroadband' }">
		<c:set var="scrollX" value="" />
	</c:when>
	<c:otherwise>
		<c:set var="scrollX" value="scrollX" />
	</c:otherwise>
</c:choose>

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
		
	<div class="well well-small">
		가입일 : 
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
	
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>					
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>회원번호</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>	
	
	<p>전체 게시물 수 : ${rtnMap.totalCount }</p>
	
	<div class="${scrollX}">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style="text-align: center">No.</th>
					<th style="text-align: center">회원명</th>
					<th style="text-align: center">휴대전화</th>
					<th style="text-align: center">가입상품</th>
					<th style="text-align: center">등록일자</th>
					<th style="text-align: center">가입일자</th>
					<th style="text-align: center">가입상태</th>
					<th style="text-align: center">수당</th>
				</tr>
			</thead>
			<tbody style="font-size: 12px">
				<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
				<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="20" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
				</c:if>
	
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>

					<td>${list.memNm}</td>
					<td>${list.cell}</td>
					<td>${list.prodNm}</td>
					<td>${list.regDm}</td>
					<td>${egov:convertDate(list.joinDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}</td>
					<td>${list.accStat}</td>
					<td>${list.ccAlow}</td>
					<td>
					<c:if test="${list.accStat ne '해약'}">
						<c:set var="sum" value="${sum + (list.ccAlow eq null ? 0 : list.ccAlow)}" />
					</c:if>
					<fmt:formatNumber value="${(list.ccAlow eq null) ? 0 : list.ccAlow}" type="currency" />
					</td>
				</tr>
				</c:forEach>			
			</tbody>
		</table>
	</div>
</form>

<div style="float:right;">
	<input type="button" value="엑셀 다운로드" class="btn btn-info2"  onclick="Excel()" />
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>


<script type="text/javascript">
	function Search(accntno){
		window.open('./pop_grid.do?accntno='+accntno,'검색', 'width=570, height=500');
	}
	
	function Excel(){
		var f = document.frm;
		
		frm.action = "excel.do";
		frm.submit();
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
		
		f.action = "./list.do";
		f.submit();
	}
</script>
							