<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	PRAMgznWrite.jsp
	프로그램 명 : 	라이프웨이 매거진 등록/수정을 한다.
	설명		: 	라이프웨이 매거진 등록/수정을 하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.16
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.16				허진영				최초작성
	######################################################################
-->

<c:set var="lifeMgznInfo" value="${rtnMap.lifeMgznInfo}" />

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(lifeMgznInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="mgznSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">라이프웨이 매거진 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />	
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 매거진 발간년도
				</th>
				<td>
					<c:choose>
						<c:when test="${empty lifeMgznInfo}">
							<input type="text" name="mgznPbtnYr" value="" maxlength="7" required="발간년도를 입력해주세요." />	
						</c:when>
						<c:otherwise>
							${lifeMgznInfo.mgznPbtnYr}
						</c:otherwise>
					</c:choose>
				</td>				
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					1
				</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					<input type="text" name="sprTitl" value="${lifeMgznInfo.sprTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					<input type="text" name="sprSubTitl" value="${lifeMgznInfo.sprSubTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<input type="file" name="sprCvrFile" onchange="extnChk(this, 'cvr');" />
					<div id="sizeGuideSprCvr" style="margin-top:10px;">
						<fmt:message var="imgFileSize" key="Globals.imgFileSize" />
						• 이미지 최적 사이즈는 가로 248 x 294 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.sprCvrFileList) > 0}">
						<div id="orgnSprCvrFile" style="margin-top:5px;">
							• 원본 표지이미지 : 
							<c:forEach var="fileList" items="${rtnMap.sprCvrFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="sprCvrFileId" value="${lifeMgznInfo.sprCvrFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<input type="file" name="sprPdfFile" onchange="extnChk(this, 'pdf');" />
					<div id="sizeGuideSprPdf" style="margin-top:10px;">
						<fmt:message var="atchFileSize" key="Globals.atchFileSize" />
						• <fmt:formatNumber value="${atchFileSize / 1024 / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>MB 이하만 업로드 가능합니다.
					</div>
					<c:if test="${fn:length(rtnMap.sprPdfFileList) > 0}">
						<div id="orgnSprPdfFile" style="margin-top:5px;">
							• 원본 PDF파일 : 
							<c:forEach var="fileList" items="${rtnMap.sprPdfFileList}" varStatus="status">
		      					<input type="checkbox" name="delSprPdfFileSeq" value="${fileList.fileSeq}" style="margin-right:3px; <c:if test="${status.first}">margin-left:5px</c:if>" />
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="sprPdfFileId" value="${lifeMgznInfo.sprPdfFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
				<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					<input type="text" name="sprEbkUrl" value="${lifeMgznInfo.sprEbkUrl}" style="width:50%;" maxlength="500" />
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">2</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					<input type="text" name="smmrTitl" value="${lifeMgznInfo.smmrTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					<input type="text" name="smmrSubTitl" value="${lifeMgznInfo.smmrSubTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<input type="file" name="smmrCvrFile" onchange="extnChk(this, 'cvr');" />
					<div id="sizeGuideSmmrCvr" style="margin-top:10px;">
						• 이미지 최적 사이즈는 가로 248 x 294 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.smmrCvrFileList) > 0}">
						<div id="orgnSmmrCvrFile" style="margin-top:5px;">
							• 원본 표지이미지 : 
							<c:forEach var="fileList" items="${rtnMap.smmrCvrFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="smmrCvrFileId" value="${lifeMgznInfo.smmrCvrFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<input type="file" name="smmrPdfFile" onchange="extnChk(this, 'pdf');" />
					<div id="sizeGuideSmmrPdf" style="margin-top:10px;">
						• <fmt:formatNumber value="${atchFileSize / 1024 / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>MB 이하만 업로드 가능합니다.
					</div>
					<c:if test="${fn:length(rtnMap.smmrPdfFileList) > 0}">
						<div id="orgnSmmrPdfFile" style="margin-top:5px;">
							• 원본 PDF파일 : 
							<c:forEach var="fileList" items="${rtnMap.smmrPdfFileList}" varStatus="status">
		      					<input type="checkbox" name="delSmmrPdfFileSeq" value="${fileList.fileSeq}" style="margin-right:3px; <c:if test="${status.first}">margin-left:5px</c:if>" />
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="smmrPdfFileId" value="${lifeMgznInfo.smmrPdfFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					<input type="text" name="smmrEbkUrl" value="${lifeMgznInfo.smmrEbkUrl}" style="width:50%;" maxlength="500" />
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">3</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					<input type="text" name="atmnTitl" value="${lifeMgznInfo.atmnTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					<input type="text" name="atmnSubTitl" value="${lifeMgznInfo.atmnSubTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<input type="file" name="atmnCvrFile" onchange="extnChk(this, 'cvr');" />
					<div id="sizeGuideAtmnCvr" style="margin-top:10px;">
						• 이미지 최적 사이즈는 가로 248 x 294 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.atmnCvrFileList) > 0}">
						<div id="orgnAtmnCvrFile" style="margin-top:5px;">
							• 원본 표지이미지 : 
							<c:forEach var="fileList" items="${rtnMap.atmnCvrFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="atmnCvrFileId" value="${lifeMgznInfo.atmnCvrFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<input type="file" name="atmnPdfFile" onchange="extnChk(this, 'pdf');" />
					<div id="sizeGuideAtmnPdf" style="margin-top:10px;">
						• <fmt:formatNumber value="${atchFileSize / 1024 / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>MB 이하만 업로드 가능합니다.
					</div>
					<c:if test="${fn:length(rtnMap.atmnPdfFileList) > 0}">
						<div id="orgnAtmnPdfFile" style="margin-top:5px;">
							• 원본 PDF파일 : 
							<c:forEach var="fileList" items="${rtnMap.atmnPdfFileList}" varStatus="status">
		      					<input type="checkbox" name="delAtmnPdfFileSeq" value="${fileList.fileSeq}" style="margin-right:3px; <c:if test="${status.first}">margin-left:5px</c:if>" />
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="atmnPdfFileId" value="${lifeMgznInfo.atmnPdfFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					<input type="text" name="atmnEbkUrl" value="${lifeMgznInfo.atmnEbkUrl}" style="width:50%;" maxlength="500" />
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">4</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					<input type="text" name="wntrTitl" value="${lifeMgznInfo.wntrTitl}" style="width: 50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					<input type="text" name="wntrSubTitl" value="${lifeMgznInfo.wntrSubTitl}" style="width:50%;" maxlength="250" />
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<input type="file" name="wntrCvrFile" onchange="extnChk(this, 'cvr');" />
					<div id="sizeGuideWntrCvr" style="margin-top:10px;">
						• 이미지 최적 사이즈는 가로 248 x 294 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.wntrCvrFileList) > 0}">
						<div id="orgnWnrCvrFile" style="margin-top:5px;">
							• 원본 표지이미지 : 
							<c:forEach var="fileList" items="${rtnMap.wntrCvrFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="wntrCvrFileId" value="${lifeMgznInfo.wntrCvrFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<input type="file" name="wntrPdfFile" onchange="extnChk(this, 'pdf');" />
					<div id="sizeGuideWntrPdf" style="margin-top:10px;">
						• <fmt:formatNumber value="${atchFileSize / 1024 / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>MB 이하만 업로드 가능합니다.
					</div>
					<c:if test="${fn:length(rtnMap.wntrPdfFileList) > 0}">
						<div id="orgnWntrPdfFile" style="margin-top:5px;">
							• 원본 PDF파일 : 
							<c:forEach var="fileList" items="${rtnMap.wntrPdfFileList}" varStatus="status">
		      					<input type="checkbox" name="delWntrPdfFileSeq" value="${fileList.fileSeq}" style="margin-right:3px; <c:if test="${status.first}">margin-left:5px</c:if>" />
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="wntrCvrFileId" value="${lifeMgznInfo.wntrPdfFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					<input type="text" name="wntrEbkUrl" value="${lifeMgznInfo.wntrEbkUrl}" style="width:50%;" maxlength="500" />
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty lifeMgznInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:cancelLifeMgzn();" class="btn btn-default">취소</a>
</div>

<script src="/common/js/jquery.filestyle.js"></script>
<script type="text/javascript">

	jQuery(document).ready(function(){
		//첨부파일 input filestyle 씌우기
		jQuery("input[name$='File']").filestyle({
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
		
		<c:choose>
			<c:when test="${empty lifeMgznInfo}">
				//발간년도 유효성 체크
				var pttn = /^20[0-9]{2}/;
				var mgznPbtnYr = jQuery("input[name='mgznPbtnYr']").val();
	
				if (!pttn.test(mgznPbtnYr))
				{
					alert("* 발간년도 입력이 올바르지 않습니다.");
					jQuery("input[name='mgznPbtnYr']").focus();
					return;
				} 
				
				if(confirm("등록하시겠습니까?"))
				{
					f.submit();		 
				}
				
				/*
				jQuery.post("/mngwserc/pr-center/lifeway-magazine/getMgznPbtnYrChk.ajax",
					{
						"mgznPbtnYr" : jQuery("input[name='mgznPbtnYr']").val()
					},
					function(r)
					{
						if(r.mgznPbtnYr_chk != "Y")
						{
							alert("이미 등록된 발간년도 입니다.");
							return;
						}
						else
						{
							if(confirm("등록하시겠습니까?"))
							{
								f.submit();		 
							}
						}
					}
				).fail(function () {
					alert("예기치 않은 오류입니다.");
				});
				*/
			</c:when>
			<c:otherwise>
				if(confirm("수정하시겠습니까?"))
				{
					f.mgznSeq.value = "${lifeMgznInfo.mgznSeq}";
					f.submit();		 
				}
			</c:otherwise>
		</c:choose>
	}

	//취소하기
	function cancelLifeMgzn()
	{
		<c:choose>
			<c:when test="${empty lifeMgznInfo}">
				location.href = "./index.do";	
			</c:when>
			<c:otherwise>
				var f = document.frm;	
				
				f.action = "./view.do";
				f.mgznSeq.value = "${lifeMgznInfo.mgznSeq}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
	
	//파일 업로드시
	function extnChk(obj, fileGb)
	{
		var fileName = jQuery(obj).val();
		
		if(fileName)
		{
			var exts = "";
			
			if(fileGb == "cvr")
			{
				exts = "<fmt:message key='Globals.imgFileExtns' />";
			}
			else if(fileGb == "pdf")
			{
				exts = "pdf";
			}
			
			var fileExt = fileName.substr(fileName.lastIndexOf(".") + 1);

			if(exts.indexOf(fileExt.toLowerCase()) < 0)
			{
				alert("* 지원하지 않는 파일확장자입니다.");
				
				var tdObj = jQuery(obj).closest("td");
				
				jQuery(tdObj).children().not("div[id^='sizeGuide'], div[id^='orgn']").remove();
				jQuery(tdObj).prepend("<input type=\"file\" name=\"" + jQuery(obj).attr("name") + "\" onchange=\"extnChk(this,'" + fileGb + "');\" />");
				
				jQuery(tdObj).children("input[name$='File']").filestyle({
					  image : "/common/images/file_bt.gif",
					  imageheight : 30,
					  imagewidth : 82
				});
			}
		}
	}
</script>