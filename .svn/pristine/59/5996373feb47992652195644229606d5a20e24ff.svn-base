<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
 
<!-- 
	######################################################################
	파일명 		:	OMFOutsourcingPageMngList.jsp
	프로그램 명 : 	외주업체 코드별 관리 목록을 조회한다.
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.05.16
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.05.16				김필기				최초작성
	######################################################################
-->

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

	<table class="table table-bordered table-hover" >
		<thead>
			<tr>
				<th width="6%">번호</th>
				<th width="42%">상단 제목</th>
				<th width="13%">외주업체 코드</th>				
				<th width="13%">B2B_STTS</th>
				<th width="13%">B2B_CD</th>
				<th width="13%">B2B_NM</th>
			</tr>
		</thead>
		<tbody style="font-size: 12px">
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="6" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
					<td><a href="./write.do?seq=${list.oscInputMstSeq}">${list.title}</a></td>
					<td style="text-align:center;">${list.oscCd}</td>
					<td style="text-align:center;">${list.b2bStts}</td>
					<td style="text-align:center;">${list.b2bCd}</td>
					<td style="text-align:center;">${list.b2bNm}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</form>

<div style="float:right;">
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