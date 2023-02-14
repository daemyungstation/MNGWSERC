<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	SMCDnldFormWrite.jsp
	프로그램 명 : 	다운로드 양식 등록/수정을 한다.
	설명		: 	다운로드 양식 등록/수정을 하는 페이지
	작성자		: 	허진영
	작성일		:	2016.03.30
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.30				허진영				최초작성
	######################################################################
-->

<c:set var="formInfo" value="${rtnMap.formInfo}" />

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(formInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="dnldFormSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display:none;">다운로드 양식 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 다운로드 양식명
				</th>
				<td>
					<input type="text" name="dnldFormNm" value="${formInfo.dnldFormNm}" style="width:50%" maxlength="50" required="다운로드 양식명을 입력해주세요" />
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 다운로드 양식파일
				</th>
				<td>
					<input type="file" name="atchFile" onchange="extnChk(this);" <c:if test="${empty formInfo}">requiredfile="다운로드 양식을 입력해주세요."</c:if> />
					<div id="atchSizeGuide" style="margin-top:10px;">
						<fmt:message var="atchFileSize" key="Globals.atchFileSize" />
						• <fmt:formatNumber value="${atchFileSize / 1024 / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>MB 이하만 업로드 가능합니다.
					</div>
					<c:if test="${fn:length(rtnMap.fileList) > 0}">
						<div id="orgnAtchFile" style="margin-top:5px;">
							• 원본 파일 : 
							<c:forEach var="fileList" items="${rtnMap.fileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="atchFileId" value="${formInfo.atchFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<c:if test="${fn:length(rtnMap.fileList) > 0}">
				<tr>
					<th style="vertical-align:middle;">
						다운로드 Url
					</th>
					<td>
						/cmm/fms/FileDown.do?fileId=${rtnMap.fileList[0].atchFileId}&fileSn=${rtnMap.fileList[0].fileSeq}
					</td>
				</tr>
			</c:if>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty formInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
			<a href="javascript:deleteDnldForm();" class="btn btn-danger">삭제</a>
		</c:otherwise>
	</c:choose>
	<a href="./list.do" class="btn btn-default">취소</a>
</div>

<script src="/common/js/jquery.filestyle.js"></script>
<script type="text/javascript">
	
	jQuery(document).ready(function(){
		//첨부파일 input filestyle 씌우기
		jQuery("input[name='atchFile']").filestyle({
			  image : "/common/images/file_bt.gif",
			  imageheight : 30,
			  imagewidth : 82
		});
	});
	
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
			<c:when test="${empty formInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.dnldFormSeq.value = "${formInfo.dnldFormSeq}";
			f.submit();		 
		}
	}
	
	//배너를 삭제한다.
	function deleteDnldForm()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			
			f.action = "./delete.do";
			f.delSeq.value = "${formInfo.dnldFormSeq}";
			f.submit();
		}
	}
	
	//파일 업로드시
	function extnChk(obj)
	{
		var fileName = jQuery(obj).val();
		
		if(fileName)
		{
			var exts = "<fmt:message key='File.UploadMimeType' />";
			
			var fileExt = fileName.substr(fileName.lastIndexOf(".") + 1);

			if(exts.indexOf(fileExt.toLowerCase()) < 0)
			{
				alert("* 지원하지 않는 파일확장자입니다.");
				
				var tdObj = jQuery(obj).closest("td");
				
				jQuery(tdObj).children().not("#atchSizeGuide, #orgnAtchFile").remove();
				jQuery(tdObj).prepend("<input type=\"file\" name=\"atchFile\" onchange=\"extnChk(this);\" />");
				
				jQuery(tdObj).children("input[name='atchFile']").filestyle({
					  image : "/common/images/file_bt.gif",
					  imageheight : 30,
					  imagewidth : 82
				});
			}
		}
	}
	
</script>