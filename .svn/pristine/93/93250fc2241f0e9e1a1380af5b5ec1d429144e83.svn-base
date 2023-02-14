<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	RIBBenefitList.jsp
	프로그램 명 : 	수당내역 목록을 조회한다.
	설명		: 	수당내역 목록을 조회하는 페이지
	작성자		: 	김필기
	작성일		:	2016.04.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.04.11				김필기				최초작성
	######################################################################
-->
<style>
	.ui-datepicker-calendar {display: none;}
</style>

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${fn:substring(rtnMap.strtDt, 0, 7)}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${fn:substring(rtnMap.endDt, 0, 7)}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		<input type="text" name="memNm" value="${rtnMap.memNm}" style="width: 70px;" placeholder="회원명" /> 
		<input type="text" name="accntNo"  value="${rtnMap.accntNo}" style="width: 120px;" placeholder="회원번호" />
		<a href="javascript: getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
	 	<thead>
		  	<tr>	  	
			    <th width="50px">순번</th>	    
			    <th width="140px">회원번호</th>
			    <th width="100px">회원명</th>
			    <th width="180px">상품명</th>
			    <th width="80px">상품코드</th>
			    <th width="180px">모델분류명</th>
			    <th width="100px">총납입회차</th>
			    <th width="120px">총상조부금</th>
			    <th width="200px">직군</th>
			    <th width="70px">회원상태</th>
			    <th width="80px">근거회차</th>
			    <th width="100px">발생수당</th>
			    <th width="100px">환수</th>
				<th width="100px">실지급(세전)</th>
		  	</tr>
	 	</thead>
		<tbody>
		 	<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="27" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
		   			<td style="text-align:center;">${rtnMap.totCnt - status.count + 1}</td>
		   			<td style="text-align:center;">${list.accntNo}</td>
		   			<td style="text-align:center;">${list.memNm}</td>
		   			<td>${list.prodNm}</td>
		   			<td style="text-align:center;">${list.prodCd}</td>
		   			<td>${list.modelClNm }</td>
		   			<td style="text-align:center;">${list.totPayNo}</td>
		   			<td style="text-align:right;"><fmt:formatNumber value="${list.totPayAmt}" /></td>
		   			<td style="text-align:center;">${list.ocpClusterNm}</td>
		   			<td style="text-align:center;">${list.accntStat}</td>
		   			<td style="text-align:right;">${list.daPayNo}</td>
		   			<td style="text-align:right;"><fmt:formatNumber value="${list.t21 + list.t32}" /></td>
		   			<td style="text-align:right;"><fmt:formatNumber value="${list.f7 + list.f11}" /></td>
					<td style="text-align:right;"><fmt:formatNumber value="${list.rtAlowAmt}" /></td>
		  		</tr>
		 	</c:forEach>
		</tbody>
	</table>
	<p>※ 본 내용은 2016년 데이터부터 조회 가능합니다.</p>
</form>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<script type="text/javascript">
 
	//페이지번호 클릭시
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
		f.submit();
	}	
	
	jQuery(".datepicker_input").datepicker({
		dateFormat : "yy-mm",
		showButtonPanel: true,
		changeMonth:true,
		changeYear :true,
		onClose: function(dateText, inst) { 
			var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
			var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
			
			$(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
			$(this).datepicker('setDate', new Date(year, month, 1));
		},
		beforeShow : function () {
	        var selectDate = $(this).val().split("-");
	        var year = selectDate[0];
	        var month = selectDate[1] - 1;
	        
	        $(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
	    }	
	});
	
</script>
