<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMETermsWrite.jsp
	프로그램 명 : 	약관 등록/수정을 한다.
	설명		: 	약관 등록/수정을 하는 페이지
	작성자		: 	김필기
	작성일		:	2016.02.18
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.18				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap.termsInfo}" />

<form name="viewFrm" method="post" action='./view.do'>
	<input type="hidden" name="trsMstSeq" value="${info.trsMstSeq}" />
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="trsGb" value="${sTrsGb}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
</form>

<form name="frm" method="post"  action="${egov:decode(info, null, './insert.do', './update.do')}" enctype="multipart/form-data"  >
	<input type="hidden" name="trsMstSeq" value="${info.trsMstSeq}" />

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
			<col style="width:85%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 구분
				</th>
				<td>
					<select name="trsGb" required="약관 구분을 선택해주세요.">
						<option value="">[선택]</option>
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.trsGb}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${info.trsGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.contractGb}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${rtnMap.trsGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>							
					</select>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 적용시점
				</th>
				<td>
					<div>
						<input type="text" id="applyDt" name="applyDt" class="datepicker_input input-small" value="${egov:convertDate(info.applyDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">제목	</th>
				<td><input type="text" name="title" value="${info.title}" required="약관명을 입력해주세요." style="width: 98%" /></td>
			</tr>
			
			
		</tbody>		
	</table>
</form>

<div style="text-align:right; margin-bottom: 15px">
	<c:choose>
		<c:when test="${empty info}">
			<input type="button" value="등록"  class="btn btn-success" onclick="chkForm()">
		</c:when>
		<c:otherwise>
			<input type="button" value="수정"  class="btn btn-primary" onclick="chkForm()">			
		</c:otherwise>
	</c:choose>
	<a href="javascript: document.viewFrm.submit()" class="btn btn-inverse">목록</a>
</div>

<table class="table table-bordered">
	<colgroup>
		<col style="width:10%;" />
		<col style="width:85%;" />				
	</colgroup>
	<tbody>
		<c:if test="${info ne null}">
		<!-- <tr>
			<th rowspan="2">약관 내용</th>
			<td>
				<table class="table table-bordered" style="margin-bottom:0;">
					<colgroup>
						<col width="5%" />
						<col width="*" />
					</colgroup>
					<tr>
						<td>대분류</td>
						<td>
							<input type="text" id="lev1" style="width:92%" />
							<input type="button" value="등록" class="btn btn-small btn-info" onclick="Reg(${info.trsMstSeq}, 0, 1)" />
						</td>
					</tr>																				
				</table>
			</td>
		</tr> -->
		<tr>
			<th>약관 내용</th>
		</tr>
		<tr>
			<td style="vertical-align:middle;">
				<iframe name="" src="./termsDtl.do?seq=${info.trsMstSeq}" frameborder="0" style="width:100%; height: 450px"></iframe>				
			</td>		 		
		</tr>  
		</c:if>
	</tbody>
</table>


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
			<c:when test="${empty info}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.trsMstSeq.value = "${info.trsMstSeq}";
			f.submit();		 
		}		
	}
	
	</script>