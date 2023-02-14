<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	RIAInviteMemList.jsp
	프로그램 명 : 	유치회원 목록을 조회한다.
	설명		: 	유치회원 목록을 조회하는 페이지
	작성자		: 	김필기
	작성일		:	2016.04.08
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.04.08				김필기				최초작성
	######################################################################
-->

<!-- 
<style>
.ui-datepicker-calendar {display: none;}
</style>
 -->
 
<form name="frm" action ="${pageLink}" method="post"  >
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		구분 : 
		<select name="payStat">
			<option value="">전체</option>
			<!--<option value="정상" <c:if test="${rtnMap.payStat eq '정상' }">selected="selected"</c:if>>정상납입회원</option>-->
			<option value="1회 연체" <c:if test="${rtnMap.payStat eq '1회 연체' }">selected="selected"</c:if>>최초 납입 미납자</option>	
		</select>
		
		<div style="margin-top:10px;">
		<select name="dateGb">			
			<option value="1" <c:if test="${rtnMap.dateGb eq '1' }">selected="selected"</c:if>>가입일자</option>
			<!-- <option value="2" <c:if test="${rtnMap.dateGb eq '2' }">selected="selected"</c:if>>행사일자</option> -->					
		</select>
		
		<div class="input-append" style="margin-bottom:0px;">
		<!-- 
			<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${fn:substring(rtnMap.strtDt, 0, 7)}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		 -->
		 	<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${egov:convertDate(rtnMap.strtDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
		<!-- 
			<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${fn:substring(rtnMap.endDt, 0, 7)}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		 -->
		 	<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${egov:convertDate(rtnMap.endDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		&nbsp;&nbsp;
		
		<!-- 연체횟수 <input type="text" name="overdueStrt" style="width: 20px;" maxlength="2" />~<input type="text" name="overdueEnd" style="width: 20px;" maxlength="2" />
		 -->
		
		<input type="text" name="memNm" style="width: 70px;" placeholder="회원명" /> 
		<input type="text" name="accntNo" style="width: 120px;" placeholder="회원번호" />
		
		<a href="javascript: getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
		</div>
	</div>
	
	<table class="table table-bordered table-hover">
	 	<thead>
		  	<tr>	  	
			    <th width="4%">순번</th>	    
			    <th width="8%">회원번호</th>
			    <th width="6%">회원명</th>
			    <th width="10%">휴대전화</th>
			    <th width="14%">가입상품</th>
			    <th width="14%">모델분류</th>
			    <th width="8%">가입일자</th>
			    <th width="3%">실납입회차</th>
			    <th width="5%">만기회차</th>
			    <th width="7%">가입상태</th>
			    <th width="7%">승인상태</th>
			    <th width="5%">해약처리</th>
			    <th width="8%">행사일자</th>
		  	</tr>
	 	</thead>
		<tbody>
		 	<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="12" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
	  			
		   			<td style="text-align:center;">
		   				${rtnMap.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
		   			</td>
		   			<td style="text-align:center;">${list.accntNo}</td>
		   			<td style="text-align:center;">${list.memNm}</td>
		   			<td style="text-align:center;">${list.cell}</td>
		   			<td style="text-align:center;">${list.prodNm}</td>
		   			<td style="text-align:center;">${list.prodModel}</td>
		   			<td style="text-align:center;">${egov:convertDate(list.joinDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
		   			<td style="text-align:right;">${list.trueCnt}회</td>
		   			<td style="text-align:right;">${list.exprNo}회</td>
		   			<td style="text-align:center;">${list.accStat}</td>
		   			<td style="text-align:center;">${list.stat}</td>
		   			<td style="text-align:center;">
						<c:choose>
							<c:when test="${empty list.resnCl}">
								-
							</c:when>
							<c:when test="${list.resnCl eq '02'}">
								미대상
							</c:when>
							<c:when test="${list.resnProcYn eq 'Y'}">
								처리
							</c:when>
							<c:otherwise>
								미처리
							</c:otherwise>
						</c:choose>		   			
		   			</td>
		   			<td style="text-align:center;">
		   				${egov:nvl(list.evntDay, '-')}
		   			</td>
		  		</tr>
		 	</c:forEach>
		</tbody>
	</table>
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


/* 
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
*/

</script>
