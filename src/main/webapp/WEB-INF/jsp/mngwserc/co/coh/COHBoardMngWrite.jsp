<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COHBoardMngWrite.jsp
	프로그램 명 : 	게시판
	설명		: 	환경설정
	작성자		: 	손의균
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				손의균				최초작성
	######################################################################
-->

<link rel="stylesheet" type="text/css" href="/egov/css/reveal.css" media="all" />

<c:set var="boardInfo" value="${rtnMap.boardInfo}" />

<form name="frm" method="post" action ="./action.do">
	<input type="hidden" name="communityId" value="${boardInfo.communityId}" />
	
	<div class="ui-tabs ui-widget ui-widget-content ui-corner-all" id="tabs">
		<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
			<li class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active ui-tabs-active" role="tab" aria-controls="tabs-1" aria-labelledby="ui-id-1" aria-selected="true">
				<a href="#tabs-1" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">기본 설정</a>
			</li>
			<li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-2" aria-labelledby="ui-id-2" aria-selected="false">
				<a href="#tabs-2" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">시스템 설정</a>
			</li>
			<li class="ui-state-default ui-corner-top div-column" role="tab" tabindex="-1" aria-controls="tabs-3" aria-labelledby="ui-id-3" aria-selected="false">
				<a href="#tabs-3" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">특수 기능 설정</a>
			</li>
		</ul>
		
		<div id="tabs-1">
			<table class="table table-bordered table-hover" style="margin-bottom:0px;">
				<colgroup>
					<col width="17%" />
					<col width="83%" />
				</colgroup>
				<tbody>
					<c:if test="${not empty boardInfo}">
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							게시판 번호 
						</th>
						<td style="text-align:left;">
							${boardInfo.communityId}
						</td>
					</tr>
					</c:if>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 게시판 제목
						</th>
						<td style="text-align:left;">
							<input type="text" value="${boardInfo.communityName}" id="communityName" name="communityName" style="width:98%;" maxlength="100" required="게시판 제목을 입력해주세요." />
						</td>
					</tr>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 게시판 타입
						</th>
						<td style="text-align:left;">
							<select name="communityType" onchange="changeCommunityType(this.value);" required="게시판 타입을 선택해주세요.">
								<option value="">선택</option>
								<c:forEach var="cdlist" items="${rtnMap.cdDtlList.communityType}" varStatus="status">
									<option value="${cdlist.cd}" <c:if test="${boardInfo.communityType eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr> 
						<th style="text-align:center; vertical-align:middle;">
							* 게시판 사용여부 
						</th>
						<td style="text-align:left;">
							<c:set var="useYn" value="${egov:nvl(boardInfo.useYn, 'N')}" />
							<input type="radio" name="useYn" value="Y" <c:if test="${useYn eq 'Y'}">checked</c:if> /> 사용&nbsp;&nbsp;
							<input type="radio" name="useYn" value="N" <c:if test="${useYn eq 'N'}">checked</c:if> /> 미 사용&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 공지 사용여부
						</th>
						<td style="text-align:left;">
							<c:set var="notifyYn" value="${egov:nvl(boardInfo.notifyYn, 'N')}" />
							<input type="radio" name="notifyYn" value="Y" <c:if test="${notifyYn eq 'Y'}">checked</c:if>/> 사용&nbsp;&nbsp;
							<input type="radio" name="notifyYn" value="N" <c:if test="${notifyYn eq 'N'}">checked</c:if> /> 미 사용&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 관리자 승인 사용여부
						</th>
						<td style="text-align:left;">
							<select name="approvalAuthority">
								<option value="0">승인 사용안합니다.</option>
								<c:forEach var="cdlist" items="${rtnMap.cdDtlList.userType}" varStatus="status">
									<option value="${cdlist.cd}" <c:if test="${boardInfo.approvalAuthority eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}부터 승인가능</option>
								</c:forEach>
							</select>
						</td>
					</tr>	
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 카테고리 사용여부
						</th>
						<td style="text-align:left;">
							<c:set var="categoryYn" value="${egov:nvl(boardInfo.categoryYn, 'N')}" />
							<input type="radio" name="categoryYn" value="Y" <c:if test="${categoryYn eq 'Y'}">checked</c:if> /> 사용&nbsp;&nbsp;
							<input type="radio" name="categoryYn" value="N" <c:if test="${categoryYn eq 'N'}">checked</c:if> /> 사용 안함&nbsp;&nbsp;
							<input type="text" name="categoryId" value="<c:if test="${not empty boardInfo.categoryId or boardInfo.categoryId ne 0}">${boardInfo.categoryId}</c:if>" style="width:20%;" maxlength="30" readonly="readonly" />
							<a href="javascript:getCategory();" class="btn" title="검색"><i class="icon-search"></i></a>
						</td>
					</tr>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 댓글 사용여부
						</th>
						<td style="text-align:left;">
							<c:set var="commentYn" value="${egov:nvl(boardInfo.commentYn, 'N')}" />
							<input type="radio" name="commentYn" value="Y" <c:if test="${commentYn eq 'Y'}">checked</c:if> /> 사용&nbsp;&nbsp;
							<input type="radio" name="commentYn" value="N" <c:if test="${commentYn eq 'N'}">checked</c:if> /> 사용 안함&nbsp;&nbsp;
						</td>
					</tr>	
					<tr>
						<th style="text-align:center; vertical-align:middle;" rowspan="3">
							* 사용자 권한 설정
						</th>
						<td style="text-align:left;">
							<select name="listUserAuthority">
								<c:forEach var="cdlist" items="${rtnMap.cdDtlList.userAuthority}" varStatus="status">
									<option value="${cdlist.cd}" <c:if test="${boardInfo.listUserAuthority eq cdlist.cd}">selected</c:if>>[${cdlist.cdNm}]부터 접근</option>
								</c:forEach>
							</select>(리스트)
						</td>	
					</tr>	
					<tr >
						<td style="text-align:left;">
							<select name="viewUserAuthority">
								<c:forEach var="cdlist" items="${rtnMap.cdDtlList.userAuthority}" varStatus="status">
									<option value="${cdlist.cd}" <c:if test="${boardInfo.viewUserAuthority eq cdlist.cd}">selected</c:if>>[${cdlist.cdNm}]부터 접근</option>
								</c:forEach>
							</select>(뷰)
						</td>	
					</tr>	
					<tr>
						<td style="text-align:left;">
							<select name="writeUserAuthority">
								<option value="-1">작성할 수 없습니다.</option>
								<c:forEach var="cdlist" items="${rtnMap.cdDtlList.userAuthority}" varStatus="status">
									<option value="${cdlist.cd}" <c:if test="${boardInfo.writeUserAuthority eq cdlist.cd}">selected</c:if>>[${cdlist.cdNm}]부터 접근</option>
								</c:forEach>
							</select>(쓰기)
						</td>	
					</tr>
					<tr class="writeUserAuthority">
						<th style="text-align:center; vertical-align:middle;">
							* 사용자 공개/비공개 사용여부
						</th>
						<td style="text-align:left;">
							<c:set var="openYn" value="${egov:nvl(boardInfo.openYn, 'N')}" />
							<input type="radio" name="openYn" value="Y" <c:if test="${openYn eq 'Y'}">checked</c:if> /> 사용&nbsp;&nbsp;
							<input type="radio" name="openYn" value="N" <c:if test="${openYn eq 'N'}">checked</c:if> /> 사용 안함&nbsp;&nbsp;
						</td>		
					</tr>		
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 리스트에서 게시글 노출 수
						</th>
						<td style="text-align:left;">
							<c:set var="pageRowCnt" value="${egov:nvl(boardInfo.pageRowCnt, '10')}" />
							<select name="pageRowCnt" >						
								<c:forEach begin="1" end="20" varStatus="status">
									<option value="${status.index}" <c:if test="${status.index eq pageRowCnt}">selected</c:if>>${status.index}</option>
								</c:forEach>
							</select>
						</td>
					</tr>	
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 리스트 말줄임 수치
						</th>
						<td style="text-align:left;">
							<input type="text" id="listTitleCnt" name="listTitleCnt" value="${egov:nvl(boardInfo.listTitleCnt, '35')}" style="width:10%;" maxlength="5" onkeyup="numChk(this);" required="리스트 말줄임 수치를 입력하세요." />
						</td>
					</tr>
				</tbody>
			</table>	
		</div>
		
		<div id="tabs-2">
			<table class="table table-bordered table-hover" style="margin-bottom:0px;">
				<colgroup>
					<col width="17%" />			
					<col width="33%" />
					<col width="17%" />
					<col width="33%" />
				</colgroup>
				<tbody>
					<tr>	
						<th style="text-align:center; vertical-align:middle;">
							* 새글표시
						</th>
						<td style="text-align:left;" colspan="3">
							<c:set var="newCnt" value="${egov:nvl(boardInfo.newCn, '2')}" />
							<select name="newCnt">
								<c:forEach begin="0" end="7" varStatus="status">
									<option value="${status.index}" <c:if test="${status.index eq newCnt}">selected</c:if>>${status.index}</option>
								</c:forEach>
							</select>
						</td>
					</tr>		
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 첨부 가능한 확장자
						</th>
						<td style="text-align:left;" colspan="3">	
							<div>※ 콤마를 사용하여 구분하여 주세요 예: jpg,gif</div>				
							<c:choose>
								<c:when test="${empty boardInfo.filePossibleExtNm}">
									<input type="text" value="<fmt:message key="File.UploadMimeType" />" id="filePossibleExtNm" name="filePossibleExtNm" style="width:98%;" maxlength="100" />
								</c:when>
								<c:otherwise>
									<input type="text" value="${boardInfo.filePossibleExtNm}" id="filePossibleExtNm" name="filePossibleExtNm" style="width:98%;" maxlength="100" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>		
					<tr>	
						<th style="text-align:center; vertical-align:middle;">
							* 첨부파일 수량
						</th>
						<td style="text-align:left;">	
							<c:set var="fileAppdCnt" value="${egov:nvl(boardInfo.fileAppdCnt, '5')}" />
							<select name="fileAppdCnt">
								<c:forEach begin="0" end="10" varStatus="status">
									<option value="${status.index}" <c:if test="${status.index eq fileAppdCnt}">selected</c:if>>${status.index}</option>
								</c:forEach>
							</select>
						</td>
						<th style="text-align:center; vertical-align:middle;">
							* 첨부파일 용량
						</th>
						<td style="text-align:left; vertical-align:middle;">
							기본 5MB <input type="text" id="fileSize" name="fileSize" value="${egov:nvl(boardInfo.fileSize, '5')}" style="width:40%;" maxlength="3" onkeyup="numChk(this);" required="첨부파일 용량을 입력하세요." />MB
						</td>
					</tr>	
					<tr>	
						<th style="text-align:center; vertical-align:middle;">
							* 본문이미지 첨부 수량
						</th>
						<td style="text-align:left;">
							<c:set var="contentsFileAppdCnt" value="${egov:nvl(boardInfo.contentsFileAppdCnt, '5')}" />
							<select name="contentsFileAppdCnt">
								<c:forEach begin="0" end="10" varStatus="status">
									<option value="${status.index}" <c:if test="${status.index eq contentsFileAppdCnt}">selected</c:if>>${status.index}</option>
								</c:forEach>
							</select>
						</td>
						<th style="text-align:center; vertical-align:middle;">
							* 본문이미지 첨부 용량
						</th>
						<td style="text-align:left; vertical-align:middle;">
							기본 500KB <input type="text" id="contentsFileSize" name="contentsFileSize" value="${egov:nvl(boardInfo.contentsFileSize, '500')}" style="width:40%;" maxlength="5" onkeyup="numChk(this);" required="첨부파일 용량을 입력하세요." />KB
						</td>
					</tr>
					<tr>
						<th style="text-align:center;vertical-align:middle;">
							* 내용 항목 설정
						</th>
						<td style="text-align:left;" colspan="3">
							<div>※ 사용자에게 입력 받아야 할 항목을 입력해 주세요. Ex) 1. 접수 일자 : , 2. 제공 받은 자(소속/직위/성명)</div>
							<div>※ 신규 항목 등록 시 [ENTER]키로 구분하여 등록하시기 바랍니다. (미입력시 공백으로 표시됩니다)</div>
							<textarea name="contentsInit" title="내용 입력" style="width:97%; height:100px;">${fn:trim(boardInfo.contentsInit)}</textarea>
						</td>		
					</tr>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 불량 단어 필터링
						</th>
						<td style="text-align:left;" colspan="3">
							<div>※ 콤마를 사용하여 구분하여 주세요. (사용자 게시글 뷰페이지에서 *로 치환됩니다)</div>		
							<textarea name="poorWordNm" title="내용 입력" style="width:97%; height:100px;" maxlength="1000" onkeydown="if(event.keyCode == 13){return false};" onkeyup="return textarea_maxlength(this)">${fn:trim(boardInfo.poorWordNm)}</textarea>
						</td>		
					</tr>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 작성자명 일괄적용
						</th>
						<td style="text-align:left;" colspan="3">	
							<div>※ 사용자 리스트, 뷰페이지의 작성자명이 변경됩니다.</div>
							<c:set var="changeRegnmYn" value="${egov:nvl(boardInfo.changeRegnmYn, 'N')}" />
							<input type="radio" value="Y" name="changeRegnmYn" <c:if test="${changeRegnmYn eq 'Y'}">checked</c:if> /> 사용&nbsp;&nbsp;
							<input type="radio" value="N" name="changeRegnmYn" <c:if test="${changeRegnmYn eq 'N'}">checked</c:if> /> 사용 안함&nbsp;&nbsp;
							<input type="text" id="changeRegnmNm" name="changeRegnmNm" value="${boardInfo.changeRegnmNm}" style="width:85%; margin-top:5px;" maxlength="15" />
						</td>
					</tr>	
				</tbody>
			</table>
		</div>
		
		<div id="tabs-3" >
			<table class="table table-bordered table-hover div-column" style="margin-bottom:0px;">
				<colgroup>
					<col width="17%" />			
					<col width="83%" />
				</colgroup>
				<tbody>
					<tr>	
						<th style="text-align:center; vertical-align:middle;">
							* 시작일, 종료일 사용 유무
						</th>
						<td style="text-align:left;">
							<c:set var="periodYn" value="${egov:nvl(boardInfo.periodYn, 'N')}" />
							<input type="radio" value="Y" name="periodYn" <c:if test="${periodYn eq 'Y'}">checked</c:if> /> 사용&nbsp;&nbsp;
							<input type="radio" value="N" name="periodYn" <c:if test="${periodYn eq 'N'}">checked</c:if> /> 사용 안함&nbsp;&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</form>

<div style="margin-top:20px;">
	<div style="text-align:right;">
		<c:choose>
			<c:when test="${empty boardInfo}">
				<a href="javascript:chkForm();" class="btn btn-success">등록</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
			</c:otherwise>
		</c:choose>
		<a href="./index.do" class="btn btn-default">취소</a>
	</div>
</div>
	
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
	        	<h4 class="modal-title" id="myModalLabel">카테고리 선택</h4>
	      	</div>
	      	<div class="modal-body">
	       		<div id="divContentsCategory" style="width:100%;float:left;margin-top:10px;">
				
				</div>
	      	</div>
	      	<div class="modal-footer">
	      		<a href="javascript:setBoardCategory();" id="select" class="btn btn-success">선택</a>
	        	<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	      	</div>
    	</div>
  	</div>
</div>	

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("#tabs").tabs();
		
		changeCommunityType("${egov:nvl(boardInfo.communityType, 'NONE')}");
		
		//사용자 쓰기 가능시
		jQuery("select[name='writeUserAuthority']").on("change", function(){
			if(parseInt(jQuery("select[name='writeUserAuthority']").val()) > -1)
			{
				setFormTagEnable(".writeUserAuthority", true);	
			}
			else
			{
				setFormTagEnable(".writeUserAuthority", false);
			}
		});
	});
	
	//등록하기
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
	
		if(jQuery("input[name='categoryYn]:checked").val() == "Y" && jQuery.trim(jQuery("input[name=categoryId]").val()) == "")
		{
			alert("* 카테고리 아이디를 선택해주세요.");			
			return;
		}	
		
		if(confirm(msg))
		{	
			f.submit();
		}		
	}
	
	//게시판 타입을 변경했을때
	function changeCommunityType(val)
	{
		if(parseInt(jQuery("select[name='writeUserAuthority']").val()) > -1)
		{
			setFormTagEnable(".writeUserAuthority", true);	
		}
		else
		{
			setFormTagEnable(".writeUserAuthority", false);
		}
	}
	
	//폼안의 input, select를 비활성화 시키키
	function setFormTagEnable(obj, boo)
	{		
		if(!boo)
		{
			jQuery(obj).prop("disabled", true);
			jQuery(obj).find("input").prop("disabled", true);
			jQuery(obj).find("select").prop("disabled", true);
			jQuery(obj).hide();
		}
		else
		{
			jQuery(obj).prop("disabled", false);
			jQuery(obj).find("input").prop("disabled", false);
			jQuery(obj).find("select").prop("disabled", false);
			jQuery(obj).show();
		}		
	}
	
	function getCategory()
	{
		jQuery("#myModal").modal("show");
		
		jQuery.get("/mngwserc/cod/board/selectCategory.ajax",
			{
				"topNode": 4,
	            "menuGb" : "folder",
	            "treeContainer" : "divContentsCategory"
			},
			function(text) {
				jQuery("#divContentsCategory").removeClass("jstree jstree-1 jstree-focused jstree-default");
				jQuery("#divContentsCategory").html("");
				jQuery("#divContentsCategory").html(text);
			},
			"text"
		).fail(function () {
			alert("예기치 않은 오류입니다.");
		});
	}
	
	function setBoardCategory()
	{
		var obj = jQuery("#divContentsCategory").jstree("get_selected").attr("id").replace("node_","");			
		
		if(isNaN(obj))
		{
			alert("카테고리를 선택해주세요.");
		}
		else
		{
			if(confirm("해당 카테고리를 선택하시겠습니까?"))
			{
				jQuery("input[name='categoryId']").val(obj);
				jQuery("#myModal").modal("hide");
			}
		}
	}
</script>