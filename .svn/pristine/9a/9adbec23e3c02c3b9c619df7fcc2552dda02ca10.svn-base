<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMCPfmcInfWrite.jsp
	프로그램 명 : 	공연정보를 등록/수정한다.
	설명		: 	공연정보를 등록/수정하는 페이지
	작성자		: 	정지만
	작성일		:	2016.02.12
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.12				정지만				최초작성
	######################################################################
-->

<c:set var="pfmcInfo" value="${rtnMap.pfmcInfo}" />

<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="pfmcGb" value="${sPfmcGb}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(pfmcInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="pfmcSeq" value="" />
	
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sPfmcGb" value="${sPfmcGb}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<table class="table table-bordered">
		<caption style="display: none;">공연정보 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 공연구분
				</th>
				<td>
					<span style="margin-right:30px;">
						<c:set var="pfmcGb" value="${egov:nvl(pfmcInfo.pfmcGb, 'free')}" />
						<span style="display:inline-block; width:100px;">
							<input type="radio" name="pfmcGb" value="free" <c:if test="${pfmcGb eq 'free'}">checked</c:if>/> 무료공연
						</span>
						<span style="display:inline-block; width:100px;">
							<input type="radio" name="pfmcGb" value="dscnt" <c:if test="${pfmcGb eq 'dscnt'}">checked</c:if>/> 할인공연
						</span>
					</span>
					<span style="margin-left:65px;">(※ 무료공연일 경우에만 예약을 받을 수 있습니다)</span>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 공연명
				</th>
				<td>
					<input type="text" name="pfmcNm" value="${pfmcInfo.pfmcNm}" style="width:50%;" maxlength="50" required="공연명을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 장소
				</th>
				<td>
					<input type="text" name="plce" value="${pfmcInfo.plce}" style="width:50%;" maxlength="250" required="장소를 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 출연
				</th>
				<td>
					<input type="text" name="cast" value="${pfmcInfo.cast}" style="width:50%;" maxlength="250" required="출연을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 관람등급
				</th>
				<td>
					<input type="text" name="vwngGrd" value="${pfmcInfo.vwngGrd}" style="width:50%;" maxlength="250" required="관람등급을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 제작
				</th>
				<td>
					<input type="text" name="prdcCo" value="${pfmcInfo.prdcCo}" style="width:50%;" maxlength="250" required="제작사를 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 공연기간
				</th>
				<td>
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="pfmcStrtDt" name="pfmcStrtDt" value="${egov:convertDate(pfmcInfo.pfmcStrtDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input input-small" style="width:100px; text-align:center;" readonly="readonly" required="공연시작일을 선택해주세요." />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
					~
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="pfmcEndDt" name="pfmcEndDt" value="${egov:convertDate(pfmcInfo.pfmcEndDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input input-small" style="width:100px; text-align:center;" readonly="readonly" required="공연종료일을 선택해주세요." />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 공연시간
				</th>
				<td>
					<input type="text" name="pfmcTime" value="${pfmcInfo.pfmcTime}" style="width:50%;" maxlength="250" required="공연시간을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 티켓정가
				</th>
				<td>
					<input type="text" name="tcktPrc" value="${pfmcInfo.tcktPrc}" style="width:50%;" maxlength="250" required="티켓정가를 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 회원혜택
				</th>
				<td>
					<input type="text" name="dscntPct" value="${pfmcInfo.dscntPct}" style="width:50%;" maxlength="250" required="회원혜택을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 예매방법
				</th>
				<td>
					<input type="text" name="rsvtnMns" value="${pfmcInfo.rsvtnMns}" style="width:50%;" maxlength="250" required="예매방법을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 주의사항
				</th>
				<td>
					<input type="text" name="prctn" value="${pfmcInfo.prctn}" style="width:50%;" maxlength="250" required="주의사항을 입력해주세요." />
				</td>			
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 포스트이미지
				</th>
				<td>
					<input type="file" name="atchFile" onchange="extnChk(this);" <c:if test="${empty pfmcInfo}">requiredfile="포스트이미지를 입력해주세요."</c:if>/>
					<div id="sizeGuide" style="margin-top:10px;">
						<fmt:message var="imgFileSize" key="Globals.imgFileSize" />
						• 이미지 최적 사이즈는 가로 250 x 360 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.fileList) > 0}">
						<div id="orgnAtchFile" style="margin-top:5px;">
							• 원본 파일 : 
							<c:forEach var="fileList" items="${rtnMap.fileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="atchFileId" value="${pfmcInfo.atchFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
		</tbody>		
	</table>
</form>
					
<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty pfmcInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:document.listFrm.submit();" class="btn btn-default">취소</a>
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
		
		//시작일 종료일 유효성 체크
		var pfmcStrtDt = parseInt(jQuery("#pfmcStrtDt").val().replace(/-/gi, ""));
		var pfmcEndDt = parseInt(jQuery("#pfmcEndDt").val().replace(/-/gi, ""));
	
		if(pfmcStrtDt > pfmcEndDt)
		{
			alert("* 시작일이 종료일보다 클 수 없습니다.");
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty pfmcInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.pfmcSeq.value = "${pfmcInfo.pfmcSeq}";
			f.submit();		 
		}
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
				
				var tdObj = jQuery(obj).closest("td");
				
				jQuery(tdObj).children().not("#sizeGuide, #orgnAtchFile").remove();
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