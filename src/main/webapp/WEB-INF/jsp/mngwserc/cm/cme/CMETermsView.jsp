<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMETermsView.jsp
	프로그램 명 : 	약관 정보 조회.
	설명		: 	약관 정보 조회
	작성자		: 	김필기
	작성일		:	2016.02.18
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.18				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap.termsInfo}" />


<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="trsGb" value="${sTrsGb}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post"  >
	<input type="hidden" name="delSeq" value="${info.trsMstSeq}" />
	
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sTrsGb" value="${sTrsGb}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<table class="table table-bordered">
		<caption style="display:none;">약관 관리</caption>
		<colgroup>
			<col style="width:10%;" />
			<col style="*" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 구분
				</th>
				<td>${info.cdNm}</td>				
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 적용시점
				</th>
				<td>${egov:convertDate(info.applyDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 약관명
				</th>
				<td>${info.title}</td>
			</tr>
			
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 내용
				</th>
			</tr>
			<tr>
				<td colspan="2" style="vertical-align:middle;">
					<iframe name="" src="./termsDtl.do?seq=${info.trsMstSeq}&view=true" frameborder=0; style="width:100%; height: 450px;"></iframe>				
				</td>				
			</tr>
		</tbody>		
	</table>
</form>

<div style="float:left;">
	<input type="button" value="삭제"  class="btn btn-danger" onclick="deleteInfo()">
	<a href="./excel.do?trsMstSeq=${rtnMap.trsMstSeq}"  class="btn btn-info">엑셀 다운로드</a>
</div>
<div style="text-align:right;">
	<a href="./write.do?trsMstSeq=${info.trsMstSeq}&trsGb=${rtnMap.trsGb}&strtDt=${rtnMap.strtDt}&endDt=${rtnMap.endDt}&f=${rtnMap.f}&q=${rtnMap.q}&pageIndex=${rtnMap.pageIndex}" class="btn btn-primary">수정</a>
	<a href="javascript: document.listFrm.submit()"" class="btn btn-inverse">목록</a>
</div>

<script type="text/javascript">
function deleteInfo()
{
	var f = document.frm;
	
	if(confirm("삭제하시겠습니까?")) 
	{
		f.action="./delete.do";
		f.submit();
	}
}
</script>