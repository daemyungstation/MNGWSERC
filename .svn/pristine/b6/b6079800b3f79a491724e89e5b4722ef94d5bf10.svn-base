<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMETermsList.jsp
	프로그램 명 : 	약관별관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.18
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.18				김필기				최초작성
	######################################################################
-->
<form name="frm" action ="${pageLink}" method="post">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		구분 : 
		<select name="trsGb">
			<option value="">전체</option>
				
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.trsGb}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.trsGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>			
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.contractGb}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.trsGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>			
		</select>
		&nbsp;&nbsp;
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
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>제목</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">약관별 관리</caption>
	 	<thead>
		  	<tr>
				<th width="8%"><input type="checkbox" name="allCheck" /></th>		  	
			    <th width="8%">번호</th>
			    <th width="10%">구분</th>
			    <th width="*">제목</th>	    			    
			    <th width="12%">적용시점</th>
			    <th width="12%">작성자</th>
			    <th width="12%">작성일</th>
			    <!-- <th width="5%">조회수</th> -->
		  	</tr>
	 	</thead>
		<tbody>
		 	<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
		  			<td style="text-align:center;"><input type="checkbox" name="delSeq" value="${list.trsMstSeq}" /></td>		  			
		   			<td style="text-align:center;">
		   				${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
		   			</td>
		   			<td><a href="./view.do?trsMstSeq=${list.trsMstSeq}&trsGb=${rtnMap.trsGb}&strtDt=${rtnMap.strtDt}&endDt=${rtnMap.endDt}&f=${rtnMap.f}&q=${rtnMap.q}&pageIndex=${rtnMap.pageIndex}">${list.cdNm}</a></td>
		   			<td><a href="./view.do?trsMstSeq=${list.trsMstSeq}&trsGb=${rtnMap.trsGb}&strtDt=${rtnMap.strtDt}&endDt=${rtnMap.endDt}&f=${rtnMap.f}&q=${rtnMap.q}&pageIndex=${rtnMap.pageIndex}">${list.title}</a></td>		   			
		   			<td style="text-align:center">${egov:convertDate(list.applyDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
		   			<td style="text-align:center">${list.regNm}</td>
		   			<td style="text-align:center">${egov:convertDate(list.regDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
		   			<!-- <td style="text-align:center">${list.readCnt}</td> -->
		  		</tr>
		 	</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<input type="button" value="삭제" class="btn btn-danger" onclick="deleteList()" />
	<input type="button" value="복사" onclick="copy()" class="btn btn-info"  /> 		
</div>

<div style="text-align:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>



<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<script type="text/javascript">
// 복사하기
function copy()
{
	var f = document.frm;
	if(jQuery("input:checkbox[name='delSeq']:checked").length > 0){
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 1){
			alert("하나만 선택해주세요.");
		} else {
			f.action="./copy.do";
			f.submit();	
		}
	}
}

//선택 삭제하기
function deleteList()
{
	var f = document.frm;
	
	if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
	{
		if(confirm("삭제하시겠습니까?")) 
		{
			f.action="./delete.do";
			f.submit();
		}
	} 
	else 
	{
		alert("삭제할 대상을 선택하세요.");
		return;
	}
}

//삭제 체크박스 전체 선택 & 해제
jQuery("input:checkbox[name='allCheck']").on("click", function(){
	if(jQuery(this).is(":checked")) 
	{
		jQuery("input:checkbox[name='delSeq']").prop("checked", true);
	} 
	else 
	{
		jQuery("input:checkbox[name='delSeq']").prop("checked", false);
	}	
});

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

</script>