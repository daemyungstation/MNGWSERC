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
			<c:if test="${rtnMap.id eq 'kbadmin'}">
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>KB번호</option>
			</c:if>
			
			<c:if test="${rtnMap.id eq 'sktelecom'}">
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>채널1</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>채널2</option>
			<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>사번</option>
			</c:if>
			
			<c:if test="${rtnMap.id eq 'skbroadband'}">
			<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>사번</option>
			</c:if>			
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
					<th>번호</th>
					<th>상품명</th>
					<th>회원번호</th>
					<th>회원명</th>
					
					<c:choose>
						<c:when test="${rtnMap.id eq 'sktelecom' }">
						<th>채널1</th>
						<th>채널2</th>
						<th>사번</th>
						<th>가입상태</th>
						<th>가입일</th>
						<th>등록일</th>
						</c:when>
						<c:when test="${rtnMap.id eq 'skbroadband' }">
						<th>채널1</th>
						<th>사번</th>
						<th>가입상태</th>
						<th>가입일</th>
						<th>등록일</th>
						</c:when>
						<c:otherwise>
							<c:if test="${rtnMap.id eq 'kbadmin'}">
							<th>KBNO</th>
							</c:if>
							<th>주문번호</th>
							<th>가입신청(변환일)</th>
							<th>가입완료(입금시점)</th>
							<th>최종납일일</th>
							<th>모집사원</th>
							<th>등록사원</th>
							<th>납입방법</th>				
							<th>당월회차</th>
							<th>실납입회차</th>
							<th>납입상태</th>				
							<th>가입상태</th>
							<th>해피콜상태</th>				
							<th>행사일자</th>
							<th>영업형태</th>
							<th>B2B회사명</th>
							<th>B2B사원</th>
							<th>비고</th>
							<th>납입내역</th>					
						</c:otherwise>
					</c:choose>
					
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
					<td style="text-align:center;">${list.prodNm}</td>
					<td style="text-align:center;">${list.accntNo}</td>
					<td style="text-align:center;">${list.memNm}</td>
					
					<c:choose>
						<c:when test="${rtnMap.id eq 'sktelecom' }">
						
					<td style="text-align:center;">${list.kbNo}</td>
					<td style="text-align:center;">${list.b2bEmpleNo}</td>
					<td style="text-align:center;">${list.idNo}</td>
					<td style="text-align:center;">${list.accStat}</td>
					<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.regDm}</td>
						
						</c:when>
						<c:when test="${rtnMap.id eq 'skbroadband' }">
						
					<td style="text-align:center;">${list.kbNo}</td>
					<td style="text-align:center;">${list.idNo}</td>
					<td style="text-align:center;">${list.accStat}</td>
					<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.regDm}</td>
						
						</c:when>						
						<c:otherwise>
						
					<c:if test="${rtnMap.id eq 'kbadmin'}">
					<td style="text-align:center;">${list.kbNo}</td>
					</c:if>
					
					<td style="text-align:center;">${list.orderNum}</td>
					<td style="text-align:center;">${list.regDm}</td>
					<td style="text-align:center;">${list.joinDt}</td>
					<td style="text-align:center;">${list.payDay}</td>
					<td style="text-align:center;">${list.empleNm}</td>
					<td style="text-align:center;">${list.regMan}</td>
					<td style="text-align:center;">${list.payMthd}</td>
					<td style="text-align:center;">${list.monthCount}</td>
					<td style="text-align:center;">${list.trueCount}</td>
					<td style="text-align:center;">${list.payState}</td>
					<td style="text-align:center;">${list.accStat}</td>
					<td style="text-align:center;">${list.hpcallStat}</td>
					<td style="text-align:center;">${list.eventDay}</td>
					<td style="text-align:center;">${list.saleType}</td>
					<td style="text-align:center;">${list.b2bCompNm}</td>
					<td style="text-align:center;">${list.b2bEmpleNo}</td>
					<td style="text-align:center;">${list.accntNote}</td>
					<td style="text-align:center;"><input type="button" value="검색" class="btn btn-mini btn-warning" onclick="Search('${list.accntNo}')" /></td>						
						
						</c:otherwise>
					</c:choose>
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
							