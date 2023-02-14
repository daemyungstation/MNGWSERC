<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COHBoardMngBanner.jsp
	프로그램 명 : 	게시판
	설명		: 	배너 설정 페이지
	작성자		: 	손의균
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				손의균				최초작성
	######################################################################
-->
<link rel="stylesheet" type="text/css" href="/egov/css/reveal.css" media="all" />

<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>

<c:set var="boardInfo" value="${rtnMap.boardInfo}" />

<form name="frm" method="post" action ="./bannerAction.do">
	<input type="hidden" name="communityId" value="${boardInfo.communityId}">
	
	<table class="table table-bordered">
		<colgroup>
			<col width="17%" />
			<col width="83%" />
		</colgroup>
		<tbody>					
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					상단 배너 사용 여부
				</th>
				<td style="text-align:left;">
					<c:set var="bannerTopYn" value="${egov:nvl(boardInfo.bannerTopYn, 'N')}" />
					<input type="radio" name="bannerTopYn" value="Y" <c:if test="${bannerTopYn eq 'Y'}">checked</c:if> />사용&nbsp;&nbsp;
					<input type="radio" name="bannerTopYn" value="N" <c:if test="${bannerTopYn eq 'N'}">checked</c:if> />사용 안함&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					상단 배너 내용
				</th>
				<td style="text-align:left;">
					<textarea id="bannerTopContents" name="bannerTopContents" style="display:none;width:100%;height:200px;" nofocus exec="editorSync(this.id)" >${boardInfo.bannerTopContents}</textarea>
					<script type="text/javascript">editorAdd("bannerTopContents");</script>
				</td>
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					하단 배너 사용 여부
				</th>
				<td style="text-align:left;">
					<c:set var="bannerBottomYn" value="${egov:nvl(boardInfo.bannerBottomYn, 'N')}" />
					<input type="radio" value="Y" name="bannerBottomYn" <c:if test="${bannerBottomYn eq 'Y'}">checked</c:if> />사용&nbsp;&nbsp;
					<input type="radio" value="N" name="bannerBottomYn" <c:if test="${bannerBottomYn eq 'N'}">checked</c:if> />사용 안함&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					하단 배너 내용
				</th>
				<td style="text-align:left;">
					<textarea id="bannerBottomContents" name="bannerBottomContents" style="display:none;width:100%;height:200px;" nofocus exec="editorSync(this.id)" >${boardInfo.bannerBottomContents}</textarea>
					<script type="text/javascript">editorAdd("bannerBottomContents");</script>
				</td>
			</tr>
		</tbody>
	</table>
	<div style="margin-top:20px;">
		<div style="text-align:left;float:left;">
			<a href="./index.do?pageIndex=${rtnMap.pageIndex}&useYn=${rtnMap.useYn}&cummunityType=${rtnMap.cummunityType}&q=${rtnMap.q}" class="btn btn-inverse">목록</a>
		</div>
		<div style="text-align:right;">
			<c:choose>
				<c:when test="${empty boardInfo}">
					<a href="javascript:chkForm();" class="btn btn-success">등록</a>
				</c:when>
				<c:otherwise>
					<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</form>
<script type="text/javascript">
	function chkForm()
	{
		var f = document.frm;
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${not empty boardInfo}">
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
