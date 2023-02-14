<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CNBOprtGuideWrite.jsp
	프로그램 명 : 	이용안내를 등록/수정을 한다.
	설명		: 	이용안내를 등록/수정을 하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.12
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.12				허진영				최초작성
	######################################################################
-->

<c:set var="oprtGuideInfo" value="${rtnMap.oprtGuideInfo}" />

<form name="frm" method="post" action="${egov:decode(oprtGuideInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="oprtGuideSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">이용안내 관리</caption>
		<colgroup>
			<col width="20%" />
			<col width="80%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 개정일
				</th>
				<td style="vertical-align:middle;">
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="ptupDt" name="ptupDt" class="datepicker_input input-small" value="${egov:convertDate(oprtGuideInfo.ptupDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" readonly="readonly" required="게시일을 선택해주세요." />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
				</td>				
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 내용
				</th>
			</tr>
			<tr>
				<td colspan="2" style="vertical-align:middle;">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="cntn" name="cntn" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력하세요.">${oprtGuideInfo.cntn}</textarea>
					<script type="text/javascript">editorAdd("cntn");</script>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 게시여부
				</th>
				<td style="vertical-align:middle;">
					<c:set var="useYn" value="${egov:nvl(oprtGuideInfo.useYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="useYn" value="Y" <c:if test="${useYn eq 'Y'}">checked</c:if> /> 게시
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="useYn" value="N" <c:if test="${useYn eq 'N'}">checked</c:if> /> 미게시
					</span>
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty oprtGuideInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:cancelOprtGuide();" class="btn btn-default">취소</a>
</div>

<script type="text/javascript">
	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty oprtGuideInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.oprtGuideSeq.value = "${oprtGuideInfo.oprtGuideSeq}";
			f.submit();		 
		}
	}
	
	//취소하기
	function cancelOprtGuide()
	{
		<c:choose>
			<c:when test="${empty oprtGuideInfo}">
				location.href = "./list.do";	
			</c:when>
			<c:otherwise>
				var f = document.frm;	
				
				f.action = "./view.do";
				f.oprtGuideSeq.value = "${oprtGuideInfo.oprtGuideSeq}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
</script>