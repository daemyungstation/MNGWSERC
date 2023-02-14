<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMBChngPrdctList.jsp
	프로그램 명 : 	전환서비스 상품내역 등록/수정을 한다.
	설명		: 	전환서비스 상품내역 등록/수정하는 페이지
	작성자		: 	김대환
	작성일		:	2016.02.19
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.19				김대환				최초작성
	######################################################################
-->

<c:set var="dtlInfo" value="${rtnMap.dtlInfo}" />

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(dtlInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="prdctDtlSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">전환서비스 상품내역 관리</caption>
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
							<option value="${cdlist.cd}" <c:if test="${dtlInfo.prdctCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>
					</select>
				</td>				
			</tr>
			<c:if test="${not empty dtlInfo}">
				<tr>
					<th style="vertical-align:middle;">
						상태
					</th>
					<td>
						<select name="prcsCd">
							<option value="">선택</option>
							<c:forEach var="cdlist" items="${rtnMap.cdDtlList.chngPrdctDtlStts}" varStatus="status">
								<option value="${cdlist.cd}" <c:if test="${dtlInfo.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</c:if>
			<tr>
				<th style="vertical-align:middle;">
					* 신청기간
				</th>
				<td>
					<input type="text" name="rqstStrtDt" id="rqstStrtDt" class="datepicker_input input-small" value="${egov:convertDate(dtlInfo.rqstStrtDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
					<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					&nbsp;~&nbsp;
					<input type="text" name="rqstEndDt" id="rqstEndDt"  class="datepicker_input input-small" value="${egov:convertDate(dtlInfo.rqstEndDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
					<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					<input type="checkbox" name="odtmYn" value="Y" style="margin-left:15px;" <c:if test="${dtlInfo.odtmYn eq 'Y'}">checked</c:if> onchange="setOdtmYn(this)" /> 상시
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					일정
				</th>
				<td>
					<input type="text" name="schd" value="${dtlInfo.schd}" style="width:50%;" maxlength="50" />
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 상품제목
				</th>
				<td>
					<input type="text" name="prdctTitl" value="${dtlInfo.prdctTitl}" style="width:50%;" maxlength="250" required="상품제목을 입력해주세요." />
					<input type="button" class="btn btn-default" value="+" onclick="plusPrdctInf();" style="padding-left:10px; width:30px;" />
				</td>
			</tr>
			<c:forEach var="dtlList" items="${rtnMap.infoDtl}" varStatus="status">
				<tr>
					<th>
						<input type="text" name="titl" value="${dtlList.titl}" style="width:80%; text-align:center;" maxlength="250" required="제목을 입력해주세요." />
					</th>
					<td>
						<input type="text" name="cntn" value="${dtlList.cntn}" style="width:50%;" maxlength="250" required="내용을 입력해주세요."  />
						<input type="button" class="btn btn-default" value="-" onclick="minusPrdctInf(this);" style="padding-left:12px; width:30px;" />
					</td>
				</tr>
			</c:forEach>
			<tr id="thnlTr">
				<th style="vertical-align:middle;">
					* 썸네일 이미지
				</th>
				<td style="vertical-align:middle;">
					<input type="file" name="thnlFile" onchange="extnChk(this);" />
					<div id="thnlSizeGuide" style="margin-top:10px;">
						<fmt:message var="thnlFileSize" key="Globals.thnlFileSize" /> 
						• 썸네일 최적 사이즈는 가로 290 x 150 입니다. (<fmt:formatNumber value="${thnlFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.thnlFileList) > 0}">
						<div id="orgnThnlFile" style="margin-top:5px;">
							<c:forEach var="fileList" items="${rtnMap.thnlFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="thnlFileId" value="${dtlInfo.thnlFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 이미지 등록(20개)
				</th>
				<td style="vertical-align:middle;">
					<div id="atchFileDiv">
						<p>
							<input type="file" name="atchFile0" onchange="extnChk(this);" />
							<input type="button" class="btn btn-default" value="+" onclick="plusAtchFile();" style="margin-left:90px; padding-left:10px; width:30px;" />
							<input type="button" class="btn btn-default" value="-" onclick="minusAtchFile(this);" style="padding-left:12px; width:30px;" />
						</p>
					</div>
					<div id="atchSizeGuide" style="margin-top:10px;">
						<fmt:message var="imgFileSize" key="Globals.imgFileSize" />
						• 이미지 최적 사이즈는 가로 500 x 333 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.atchFileList) > 0}">
						<div id="orgnAtchFile" style="margin-top:5px;">
							<div style="margin-bottom:5px;">
								• 원본 이미지를 체크 후 저장하시면 삭제됩니다.					
							</div>
							• 원본 이미지 : 
							<c:forEach var="fileList" items="${rtnMap.atchFileList}" varStatus="status">
		      					<input type="checkbox" name="delFileSeq" value="${fileList.fileSeq}" style="margin-right:3px; <c:if test="${status.first}">margin-left:5px</c:if>" />
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="atchFileId" value="${dtlInfo.atchFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					URL
				</th>
				<td>
					<input type="text" name="link" value="${dtlInfo.link}" style="width:50%;" maxlength="500" />
					<div style="margin-top:10px;">
						• ex) http://www.naver.com
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 상품 상세내용
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="prdctCntn" name="prdctCntn" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력하세요.">${dtlInfo.prdctCntn}</textarea>
					<script type="text/javascript">editorAdd("prdctCntn");</script>
				</td>				
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty dtlInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:cancelChngDtl()" class="btn btn-default">취소</a>
</div>

<script src="/common/js/jquery.filestyle.js"></script>
<script type="text/javascript">

	jQuery(document).ready(function(){
		
		//첨부파일 input filestyle 씌우기
		jQuery("input[type='file']").filestyle({
			  image : "/common/images/file_bt.gif",
			  imageheight : 30,
			  imagewidth : 82
		});
		
		setOdtmYn(jQuery("input[name='odtmYn']"));
	});

	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!jQuery("input[name='odtmYn']").is(":checked"))
		{
			if(!jQuery("#rqstStrtDt").val())
			{
				alert("시작일을 선택해 주세요.");
				jQuery("#rqstStrtDt").focus();
				return;
			}
			
			if(!jQuery("#rqstEndDt").val())
			{
				alert("종료일을 선택해 주세요.");
				jQuery("#rqstEndDt").focus();
				return;
			}
			
			//시작일 종료일 유효성 체크
			var rqstStrtDt = parseInt(jQuery("#rqstStrtDt").val().replace(/-/gi, ""));
			var rqstEndDt = parseInt(jQuery("#rqstEndDt").val().replace(/-/gi, ""));
		
			if(rqstStrtDt > rqstEndDt)
			{
				alert("* 시작일이 종료일보다 클 수 없습니다.");
				return;
			}
		}
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty dtlInfo.prdctDtlSeq}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			jQuery("#rqstStrtDt").val(jQuery("#rqstStrtDt").val().replace(/-/gi, ""));
			jQuery("#rqstEndDt").val(jQuery("#rqstEndDt").val().replace(/-/gi, ""));
			
			f.prdctDtlSeq.value = "${dtlInfo.prdctDtlSeq}";
			f.submit();		 
		}
	}
	
	//취소하기
	function cancelChngDtl()
	{
		<c:choose>
			<c:when test="${empty dtlInfo}">
				location.href = "./list.do";	
			</c:when>
			<c:otherwise>
				var f = document.frm;	
				
				f.action = "./view.do";
				f.prdctDtlSeq.value = "${dtlInfo.prdctDtlSeq}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
	
	//파일 업로드시
	function extnChk(obj)
	{
		var fileName = jQuery(obj).val();
		
		if(fileName)
		{
			var exts = "<fmt:message key='Globals.imgFileExtns' />";
			
			var fileExt = fileName.substr(fileName.lastIndexOf(".") + 1);

			if(exts.indexOf(fileExt.toLowerCase()) < 0)
			{
				alert("* 지원하지 않는 파일확장자입니다.");
				
				var pObj = jQuery(obj).closest("p");
				
				jQuery(pObj).children().not(".btn").remove();
				jQuery(pObj).prepend("<input type=\"file\" name=\"" + jQuery(obj).attr("name") + "\" onchange=\"extnChk(this);\" />");
				
				jQuery(pObj).children("input:file[name^='atchFile']").filestyle({
					  image : "/common/images/file_bt.gif",
					  imageheight : 30,
					  imagewidth : 82
				});
			}
		}
	}
	
	//첨부파일 업로드 추가버튼
	function plusAtchFile() 
	{
		var atchFileCnt = jQuery("input:file[name^='atchFile']").length;
		var atchFileIdx = jQuery("input:file[name^='atchFile']:last").attr("name").replace("atchFile", "");
		var htmlSrc  = "<p>\n";
			htmlSrc += "	<input type=\"file\" name=\"atchFile" + (parseInt(atchFileIdx) + 1) + "\" onchange=\"extnChk(this);\" />\n";
			htmlSrc += "	<input type=\"button\" class=\"btn btn-default\" value=\"+\" onclick=\"plusAtchFile();\" style=\"margin-left:90px; padding-left:10px; width:30px;\" />\n";
			htmlSrc += "	<input type=\"button\" class=\"btn btn-default\" value=\"-\" onclick=\"minusAtchFile(this);\" style=\"padding-left:12px; width:30px;\" />\n";
			htmlSrc += "</p>\n";
		
		<c:choose>
			<c:when test="${empty dtlInfo}">
				if(atchFileCnt < 20)
				{
					//첨부파일 업로드 추가
					jQuery("#atchFileDiv").append(htmlSrc);
					
					//첨부파일 이벤트 추가
					jQuery("#atchFileDiv").find("input:file[name^='atchFile']:last").filestyle({
						  image : "/common/images/file_bt.gif",
						  imageheight : 30,
						  imagewidth : 82
					});
				}
				else
				{
					alert("첨부파일은 20개까지만 등록 가능합니다.");
					return;
				}
			</c:when>
			<c:otherwise>
				var atchFileLen = "${fn:length(rtnMap.atchFileList)}";
				var delFileCnt = jQuery("input:checkbox[name='delFileSeq']:checked").length;
				
				if(atchFileCnt < (20 - atchFileLen + delFileCnt))
				{
					//첨부파일 업로드 추가
					jQuery("#atchFileDiv").append(htmlSrc);
					
					//첨부파일 이벤트 추가
					jQuery("#atchFileDiv").find("input:file[name^='atchFile']:last").filestyle({
						  image : "/common/images/file_bt.gif",
						  imageheight : 30,
						  imagewidth : 82
					});
				}
				else
				{
					alert("첨부파일은 20개까지만 등록 가능합니다.");
					return;
				}
			</c:otherwise>
		</c:choose>
	}

	//첨부파일 업로드 삭제버튼
	function minusAtchFile(obj) 
	{
		var atchFileIdx = jQuery(obj).parent().index();
		
		if(atchFileIdx == 0)
		{
			var atchFileCnt = jQuery("input:file[name^='atchFile']").length;
			
			if(atchFileCnt == 1)
			{
				resetAtchFile();
			}
			else
			{
				//첨부파일 업로드 삭제
				jQuery("#atchFileDiv").children(":last").remove();
			}
		}
		else
		{
			//첨부파일 업로드 삭제
			jQuery(obj).parent().remove();
		}
	}

	//첨부파일 업로드 초기화
	function resetAtchFile() 
	{
		var htmlSrc  = "<p>\n";
			htmlSrc += "	<input type=\"file\" name=\"atchFile0\" onchange=\"extnChk(this);\" />\n";
			htmlSrc += "	<input type=\"button\" class=\"btn btn-default\" value=\"+\" onclick=\"plusAtchFile();\" style=\"margin-left:90px; padding-left:10px; width:30px;\" />\n";
			htmlSrc += "	<input type=\"button\" class=\"btn btn-default\" value=\"-\" onclick=\"minusAtchFile(this);\" style=\"padding-left:12px; width:30px;\" />\n";
			htmlSrc += "</p>\n";
			
		//첨부파일 업로드 삭제
		jQuery("#atchFileDiv").children().remove();
		
		//첨부파일 업로드 추가
		jQuery("#atchFileDiv").append(htmlSrc);
		
		//첨부파일 이벤트 추가
		jQuery("#atchFileDiv").find("input:file[name='atchFile0']").filestyle({
			  image : "/common/images/file_bt.gif",
			  imageheight : 30,
			  imagewidth : 82
		});
	}
	
	//상품정보 추가버튼
	function plusPrdctInf() 
	{
		var prdctInfCnt = jQuery("input[name='titl']").length;
		var htmlSrc  = "<tr>\n";
			htmlSrc += "	<th><input type=\"text\" name=\"titl\" value=\"\" style=\"width:80%; text-align:center;\" maxlength=\"250\" required=\"제목을 입력해주세요.\" /></th>\n";
			htmlSrc += "	<td>\n";
			htmlSrc += "		<input type=\"text\" name=\"cntn\" value=\"\" style=\"width:50%;\" maxlength=\"250\" required=\"내용을 입력해주세요.\"  />\n";
			htmlSrc += "		<input type=\"button\" class=\"btn btn-default\" value=\"-\" onclick=\"minusPrdctInf(this);\" style=\"padding-left:12px; width:30px;\" />\n";
			htmlSrc += "	</td>\n";
			htmlSrc += "</tr>\n";

		if(prdctInfCnt < 10)
		{
			jQuery("#thnlTr").before(htmlSrc);
		}
		else
		{
			alert("상품정보는 10개까지만 등록 가능합니다.");
			return;
		}
	}
	
	//상품정보 삭제버튼
	function minusPrdctInf(obj) 
	{
		jQuery(obj).closest("tr").remove();
	}
	
	//상시버튼 체크
	function setOdtmYn(obj)
	{
		if(jQuery(obj).is(":checked"))
		{
			jQuery(obj).siblings("input").val("");
			jQuery(obj).siblings("input").prop("disabled", true);
		}
		else
		{
			jQuery(obj).siblings("input").prop("disabled", false);
		}
	}
</script>