<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COGCntnsMngView.jsp
	프로그램 명 : 	컨텐츠관리
	설명		: 	MngView
	작성자		: 	김대환
	작성일		:	2015.11.17
	수정일자					수정자					수정내용
	=====================================================================
	2015.11.17					김대환					최초작성
	######################################################################
--> 
<c:set var="cntnsInfo" value="${rtnMap.cntnsInfo}" />

<form name="frm" method="post">
	<input type="hidden" name="cntsSeq" value="${cntnsInfo.cntsSeq}" />
	<input type="hidden" name="chk" value="${cntnsInfo.cntsSeq}" />
	
	<table class="table table-bordered" summary="정보 테이블">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">컨텐츠 명</th>
				<td colspan="3">${pageTitle} (ver ${cntnsInfo.ver})</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">상태</th>
				<td>${egov:contentsStatus(cntnsInfo.prcsStts)}</td>
				<th style="text-align:center; vertical-align:middle;">작성일</th>
				<td>${egov:convertDate(cntnsInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">작성자</th>
				<td colspan="3">
					${cntnsInfo.regId} (${cntnsInfo.regIp}) 
				</td>
			</tr>
			<tr>
				<th colspan="4" style="text-align:center; vertical-align:middle;">내용</th>
			</tr>
			<tr>
				<td colspan="4">					
					<iframe src="/mngwserc/contentsid/${cntnsInfo.menuSeq}/view.do?status=editor&cntsSeq=${cntnsInfo.cntsSeq}" style="width:980px;" frameborder="0" onload="autoResize(this)"></iframe>
				</td>				
			</tr>
		</tbody>
	</table>
</form>
	
<div style="float:right; margin-bottom:15px;">
	<a href="./index.do?pageIndex=${rtnMap.pageIndex}" class="btn btn-inverse">목록</a>
	<c:if test="${cntnsInfo.prcsStts ne 2}">
		<a href="javascript:updateCntns();" class="btn btn-primary">수정</a>
		<a href="javascript:deleteCntns();" class="btn btn-danger">삭제</a>
	</c:if>
</div>

<table class="table table-bordered">
	<thead>
		<tr>
			<th width="50%">수정자</th>
			<th width="50%">수정일</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(rtnMap.cntnsLogList) > 0}">
				<c:forEach var="list" items="${rtnMap.cntnsLogList}" varStatus="status">
					<tr>
						<td style="text-align:center; vertical-align:middle;">${list.modId} (${list.modIp})</td>
						<td style="text-align:center; vertical-align:middle;">${list.modDtm}</td>		
					</tr>
				</c:forEach>			
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2" style="text-align:center;">수정한 내역이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>				
	</tbody>
</table>
	
<script type="text/javascript">
	function updateCntns()
	{
		var f = document.frm;
		f.action="./modify.do";
		f.submit();
	}
	
	function deleteCntns()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;
			f.action="./delete.do";
			f.submit();
		}
	}
	
	function autoResize(i)
	{
	    var iframeHeight = (i).contentWindow.document.body.scrollHeight;
	    (i).height = iframeHeight + 40;
	}
</script>