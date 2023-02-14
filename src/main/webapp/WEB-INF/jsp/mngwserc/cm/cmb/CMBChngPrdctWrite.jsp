<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMBChngPrdctList.jsp
	프로그램 명 : 	전환서비스 상품 등록/수정을 한다.
	설명		: 	전환서비스 상품 등록/수정하는 페이지
	작성자		: 	김대환
	작성일		:	2016.02.19
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.19				김대환				최초작성
	######################################################################
-->

<c:set var="prdctInfo" value="${rtnMap.prdctInfo}"/>

<form name="frm" method="post" action="${egov:decode(prdctInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="prdctSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">전환서비스 상품관리</caption>
		<colgroup>
			<col width="20%" />
			<col width="80%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 상품구분
				</th>
				<td>
					<select name="prdctCd" required="상품구분을 선택해주세요.">
						<option value="">선택</option>
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.prdctGb}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${prdctInfo.prdctCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>
					</select>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 상품명
				</th>
				<td>
					<input type="text" name="prdctNm" value="${prdctInfo.prdctNm}" style="width:50%;" maxlength="50" required="상품명 입력해주세요." />
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 상품내용
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="prdctCntn" name="prdctCntn" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력하세요.">${prdctInfo.prdctCntn}</textarea>
					<script type="text/javascript">editorAdd("prdctCntn");</script>
				</td>				
			</tr>
 			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 이용안내
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea id="oprtGuide" name="oprtGuide" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력하세요.">${prdctInfo.oprtGuide}</textarea>
					<script type="text/javascript">editorAdd("oprtGuide");</script>
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty prdctInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:cancelChngPrdct()" class="btn btn-default">취소</a>
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
			<c:when test="${empty prdctInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.prdctSeq.value = "${prdctInfo.prdctSeq}";
			f.submit();		 
		}
	}
	
	//취소하기
	function cancelChngPrdct()
	{
		<c:choose>
			<c:when test="${empty prdctInfo.prdctSeq}">
				location.href = "./list.do";	
			</c:when>
			<c:otherwise>
				var f = document.frm;	
				
				f.action = "./view.do";
				f.prdctSeq.value = "${prdctInfo.prdctSeq}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
</script>