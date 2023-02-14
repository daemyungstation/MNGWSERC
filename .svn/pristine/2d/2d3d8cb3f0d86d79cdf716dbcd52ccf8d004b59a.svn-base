<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COGCntnsMngWrite.jsp
	프로그램 명 : 	컨텐츠관리
	설명		: 	MngWrite
	작성자		: 	김대환
	작성일		:	2015.11.17
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.17				김대환				최초작성
	######################################################################
-->

<c:set var="cntnsInfo" value="${rtnMap.cntnsInfo}" />

<form name="frm" method="post" action="${egov:decode(cntnsInfo, null, './insert.do', './update.do')}">	
	<input type="hidden" name="cntsSeq" value="${cntnsInfo.cntsSeq}" />
	
	<table class="table table-bordered">
		<colgroup>
			<col width="40%" />
			<col width="60%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">컨텐츠 명</th>
				<td>${pageTitle}</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">상태</th>
				<td>
					<select name="prcsStts" class="form-control">
						<option value="0">작성중</option>					
						<option value="1">승인요청</option>
					</select>
				</td>
			</tr>
			<tr>
				<th colspan="2">내용</th>
			</tr> 
			<tr>
				<td colspan="2">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="cntn" name="cntn" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력하세요.">${cntnsInfo.cntn}</textarea>
					<script type="text/javascript">editorAdd("cntn");</script>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<div style="float:right;">	
	<c:choose>
		<c:when test="${not empty cntnsInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">수정</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:otherwise>
	</c:choose>
	<a href="./index.do" class="btn btn-default">취소</a>
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){
	<c:if test="${not empty cntnsInfo}">
		jQuery("select[name='prcsStts'] option").each(function(){
			var prcsStts = jQuery(this).val();
			
			if(prcsStts == "${cntnsInfo.prcsStts}")
			{
				jQuery(this).prop("selected", true);
				return false;
			}
		});
	</c:if>
	});
	
	function chkForm()
	{
		var f = document.frm;	
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		<c:choose>
			<c:when test="${not empty cntnsInfo}">
			msg = "수정하시겠습니까?";		
			</c:when>
			<c:otherwise>
			msg = "등록하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.submit();
		}
	}
</script>