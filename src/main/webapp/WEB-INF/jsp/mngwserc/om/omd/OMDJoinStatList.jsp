<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>

<!-- 
	######################################################################
	파일명 		:	OMDJoinStatList.jsp
	프로그램 명 : 	가입현황관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.17
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.17				김필기				최초작성
	######################################################################
-->

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
	<table class="table table-bordered table-hover">
		<caption style="display: none;">외주업체 상담 관리</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>회원번호</th>
				<th>이름</th>
				<th>가입신청(변환일)</th>
				<th>가입완료(입금시점)</th>
				<th>B2B업체</th>
				<th>B2B사원</th>
				<th>납입방법</th>
				<th>납입회차</th>
				<th>납입상태</th>
				<th>가입상태</th>
				<th>해피콜상태</th>
			</tr>
		</thead>
		<tbody>
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
				<td>${list.prodNm}</td>
				<td style="text-align:center;">${list.accntNo}</td>
				<td style="text-align:center;">${list.memNm}</td>
				<td style="text-align:center;">${list.regDm}</td>
				<td style="text-align:center;">${list.joinDt}</td>
				<td>${list.b2bCompNm}</td>
				<td>${list.b2bEmpleNo}</td>
				<td>${list.payMthd}</td>
				<td style="text-align:center;">${list.trueCount}</td>
				<td style="text-align:center;">${list.payState}</td>
				<td style="text-align:center;">${list.accStat}</td>
				<td style="text-align:center;">${list.hpcallStat}</td>
			</tr>
			</c:forEach>			
		</tbody>
	</table>
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
							