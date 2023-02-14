<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%
	//시간 선택을 위한 select option 구성
	StringBuffer selectHh = new StringBuffer();

	String strHh = "";

	for(int i = 0; i < 24; i++)
	{
		if(i < 10)
		{
			strHh = "0" + i;
		}
		else
		{
			strHh = String.valueOf(i);
		}
		
		selectHh.append("<option value=\""+strHh+"\">"+strHh+"</option>\n");
	}
	
	//분 선택을 위한 select option 구성
	StringBuffer selectMi = new StringBuffer();
	
	String strMi = "";
	
	for(int i = 0; i < 60; i++)
	{
		if(i < 10)
		{
			strMi = "0" + i;
		}
		else
		{
			strMi = String.valueOf(i);
		}
		
		selectMi.append("<option value=\""+strMi+"\">"+strMi+"</option>\n");
	}
%>
<!-- 
	######################################################################
	파일명 		:	SMABanrWrite.jsp
	프로그램 명 : 	배너 등록/수정을 한다.
	설명		: 	배너 등록/수정을 하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<c:set var="banrInfo" value="${rtnMap.banrInfo}" />

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(banrInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="banrSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display:none;">배너 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 배너명
				</th>
				<td>
					<input type="text" name="banrNm" value="${banrInfo.banrNm}" style="width:50%;" maxlength="50" required="배너명을 입력해주세요" />
				</td>	
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 게시기간
				</th>
				<td>
					<div>
						<input type="text" id="ptupStrtDt" name="ptupStrtDt" class="datepicker_input input-small" value="${egov:convertDate(banrInfo.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" required="게시 시작일을 선택해주세요." />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						<select id="ptupStrtHh" name="ptupStrtHh" style="min-width:50px;">
							<%=selectHh %>
						</select>
						<select id="ptupStrtMi" name="ptupStrtMi" style="min-width:50px;">
							<%=selectMi %>
						</select>
						&nbsp;~&nbsp; 
						<input type="text" id="ptupEndDt" name="ptupEndDt" class="datepicker_input input-small" value="${egov:convertDate(banrInfo.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" required="게시 종료일을 선택해주세요." />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						<select id="ptupEndHh" name="ptupEndHh" style="min-width:50px;">
							<%=selectHh %>
						</select>
						<select id="ptupEndMi" name="ptupEndMi" style="min-width:50px;">
							<%=selectMi %>
						</select>
						<input type="checkbox" name="odtmYn" value="Y" style="margin-left:15px;" <c:if test="${banrInfo.odtmYn eq 'Y'}">checked</c:if>/> 상시여부
					</div>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 배너이미지
				</th>
				<td>
					<input type="file" name="atchFile" onchange="extnChk(this);" <c:if test="${empty banrInfo}">requiredfile="배너이미지를 입력해주세요."</c:if> />
					<div id="sizeGuide" style="margin-top:10px;">
						<fmt:message var="imgFileSize" key="Globals.imgFileSize" />
						• 이미지 최적 사이즈는 가로 259 x 249 입니다. (<fmt:formatNumber value="${imgFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					</div>
					<c:if test="${fn:length(rtnMap.fileList) > 0}">
						<div id="orgnAtchFile" style="margin-top:5px;">
							• 원본 배너이미지 : 
							<c:forEach var="fileList" items="${rtnMap.fileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
							<input type="hidden" name="atchFileId" value="${banrInfo.atchFileId}" />
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					* 이미지 설명
				</th>
				<td>
					<input type="text" name="atchFileDsc" value="${banrInfo.atchFileDsc}" style="width:50%;" required="이미지 설명을 입력해주세요." />
					<div style="margin-top:10px;">
						• 웹 접근성을 위해 배너내용에 대해 간략하게 서술해 주세요.			
					</div>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					이동 URL
				</th>
				<td>
					<input type="text" name="link" value="${banrInfo.link}" style="width:50%;" maxlength="500" />
					<div style="margin-top:10px;">
						• ex) http://www.naver.com					
					</div>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					* 새창여부
				</th>
				<td>
					<c:set var="wndYn" value="${egov:nvl(banrInfo.wndYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="wndYn" value="Y" <c:if test="${wndYn eq 'Y'}">checked</c:if>/> 새창 이동
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="wndYn" value="N" <c:if test="${wndYn eq 'N'}">checked</c:if>/> 현재창 이동
					</span>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					* 게시여부
				</th>
				<td>
					<c:set var="ptupYn" value="${egov:nvl(banrInfo.ptupYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="ptupYn" value="Y" <c:if test="${ptupYn eq 'Y'}">checked</c:if>/> 게시
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="ptupYn" value="N" <c:if test="${ptupYn eq 'N'}">checked</c:if>/> 미게시
					</span>
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty banrInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
			<a href="javascript:deleteBanr();" class="btn btn-danger">삭제</a>
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
		
		<c:if test="${not empty banrInfo}">
		//게시 시작 시, 분 setting
		var ptupStrtHh = "${egov:convertDate(banrInfo.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}";
		var ptupStrtMi = "${egov:convertDate(banrInfo.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}";
		
		jQuery("#ptupStrtHh option[value='"+ptupStrtHh+"']").prop("selected", true);
		jQuery("#ptupStrtMi option[value='"+ptupStrtMi+"']").prop("selected", true);
		
		//게시 종료 시, 분 setting
		var ptupEndHh = "${egov:convertDate(banrInfo.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}";
		var ptupEndMi = "${egov:convertDate(banrInfo.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}";
		
		jQuery("#ptupEndHh option[value='"+ptupEndHh+"']").prop("selected", true);
		jQuery("#ptupEndMi option[value='"+ptupEndMi+"']").prop("selected", true);
		</c:if>
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
		var ptupStrtDtm = parseInt(jQuery("#ptupStrtDt").val().replace(/-/gi, "") + jQuery("#ptupStrtHh").val() + jQuery("#ptupStrtMi").val());
		var ptupEndDtm = parseInt(jQuery("#ptupEndDt").val().replace(/-/gi, "") + jQuery("#ptupEndHh").val() + jQuery("#ptupEndMi").val());
	
		if(ptupStrtDtm > ptupEndDtm)
		{
			alert("* 시작일이 종료일보다 클 수 없습니다.");
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty banrInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.banrSeq.value = "${banrInfo.banrSeq}";
			f.submit();		 
		}
	}
	
	//배너를 삭제한다.
	function deleteBanr()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			f.action = "./delete.do";
			f.delSeq.value = "${banrInfo.banrSeq}";
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