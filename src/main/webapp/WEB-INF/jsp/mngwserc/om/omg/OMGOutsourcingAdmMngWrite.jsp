<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMGOutsourcingAdmMngWrite.jsp
	프로그램 명 : 	외주업체 관리자 조건을 등록/수정한다.
	설명		: 	외주업체 관리자 조건을 등록/수정한다.
	작성자		: 	김필기
	작성일		:	2016.05.20
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.05.20				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap.info}" />

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(info, null, './insert.do', './update.do')}">
	<input type="hidden" name="seq" value="${info.oscAdmMstSeq}" />
	
	<table class="table table-bordered">
		<colgroup>
			<col style="width:15%;" />
			<col style="width:85%;" />	
		</colgroup>
		<tbody> 
			<tr>
				<th style="vertical-align:middle;">외주업체 관리자 ID</th>
				<td>
					<select name="admId" >
						<option value="">[외주업체 관리자 ID 선택]</option>
						<c:forEach var="admList" items="${admList}">
						<option value="${admList.id }" <c:if test="${admList.id eq info.admId}">selected="selected"</c:if>>${admList.id }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">외주업체 코드</th>
				<td>
					<select name="oscCd"  data-code1="${info.code1}">
						<option value="">[외주업체 코드 선택]</option>
						<c:forEach var="osclist" items="${osclist.outsourcing}">
						<option value="${osclist.cd }" <c:if test="${osclist.cd eq info.oscCd}">selected="selected"</c:if>>${osclist.cd }</option>
						</c:forEach>
					</select>
					
					<span id="channelSelect"></span>
				</td>
			</tr>			
			<tr>
				<th style="vertical-align:middle;">B2B_STTS</th>
				<td><input type="text" name="b2bStts" value="${info.b2bStts}" /></td>
			</tr>
			
			
		</tbody>		
	</table>
	
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty info}">
			<a href="javascript: chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript: chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript: cancel()" class="btn btn-default">취소</a>
</div>

<script type="text/javascript">


//유효성 체크
function chkForm()
{		
	var f = document.frm;	
	var msg = "";
	
	if(f.title.value == ""){
		alert("제목을 입력하세요.");
		f.title.focus();
		return false;
	}
	if(f.oscCd.value == ""){
		alert("외주업체 코드를 선택해주세요.");
		f.oscCd.focus();
		return false;
	}
	if(f.b2bStts.value == ""){
		alert("B2B_STTS 값을 입력해주세요.");
		f.b2bStts.focus();
		return false;
	}
	
	if(!validate(f))
	{
		return;
	}	
	
	if(f.seq.value == ''){
		msg = "등록하시겠습니까?";	
	}
	else{
		msg = "수정하시겠습니까?";
	}
	
	if(confirm(msg))
	{
		f.submit();		 
	}
}

//취소하기
function cancel()
{
	var f = document.frm;	
	
	f.action = "./list.do";
	f.submit();
}

	

	$('select[name=oscCd]').change(function(){
		var highDtlCd = $(this).val();
		var code1 = $(this).data('code1');
		
		$('#channelSelect').html('');
		
		$.ajax({
			type : 'POST',
			url : './getChannelList.ajax',
			data : 'highDtlCd=' + highDtlCd,
			success : function(r){
				
				if(r.list.length > 0){
					var $select = "<select name='code1'>";
					
					$select = $select + "<option value=''>[영업채널1 선택]</option>";
					$(r.list).each(function(i, e){
						if(e.cd == code1){
							$select = $select + "<option value='"+e.cd+"' selected='selected'>"+e.cdNm+"</option>";
						}else{
							$select = $select + "<option value='"+e.cd+"'>"+e.cdNm+"</option>";	
						}
					});
					
					$select = $select + "</select>";
					
					$('#channelSelect').html($select);	
				}
			}
		});
	});
	
	$('select[name=oscCd]').trigger('change');

</script>