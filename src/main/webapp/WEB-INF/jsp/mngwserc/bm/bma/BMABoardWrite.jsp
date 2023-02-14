<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	BMABoardWrite.jsp
	프로그램 명 : 	게시판 통합 작성or수정페이지
	설명		: 	게시판 관리에서 생성한 게시판 통합 작성or수정페이지
	작성자		: 	안진용
	작성일		:	2016.02.11
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.11				김대환				최초작성
	######################################################################
-->

<jsp:useBean id="now" class="java.util.Date" />

<c:set var="boardInfo" value="${rtnMap.boardInfo}" />

<form name="viewFrm" method="post">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="idx" value="" />
	<input type="hidden" name="useYn" value="${rtnMap.sUseYn}" />
	<input type="hidden" name="categoryId" value="${rtnMap.sCategoryId}" />
</form>

<form name="frm" method="post" enctype="multipart/form-data" action="${egov:decode(boardInfo, null, './insert.do', './update.do')}">	
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="idx" value="" />
	<input type="hidden" name="sUseYn" value="${rtnMap.sUseYn}" />
	<input type="hidden" name="sCategoryId" value="${rtnMap.sCategoryId}" />
	
	<input type="hidden" name="thumnailFileId" value="${boardInfo.thumnailFileId}" />
	<input type="hidden" name="atchFileId" value="${boardInfo.atchFileId}" />
	<input type="hidden" name="contentsFileId" value="${boardInfo.contentsFileId}" />
		
	<table class="table table-bordered">
	<caption style="display:none;">게시글 관리</caption>
		<colgroup>
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 이름
				</th>
				<td colspan="3"> 
				<c:if test="${boardInfo eq null}">
					<input type="text" name="regname" value="${regNm}" style="width:50%;" maxlength="250" required="이름을 입력해주세요." />
				</c:if>
				<c:if test="${boardInfo ne null}">
					${boardInfo.regname}
				</c:if>
				</td>
			</tr>
			<c:if test="${mstInfo.categoryYn eq 'Y'}">
				<tr>
					<th style="vertical-align:middle;">
						* 구분
					</th>
					<td colspan="3">
						<span id="categoryId" style="margin-left:0px">
		
						</span>
						<script type="text/javascript" src="/common/js/mngwserc/bm/bma/BMABoardCtgr.js?{'select':'categoryId', 'topNode':'${mstInfo.categoryId}', 'id':'${boardInfo.categoryId}', 'required':true}"></script>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${mstInfo.periodYn eq 'Y'}">
				<tr>
					<th style="vertical-align:middle;">
						* 기간
					</th>
					<td colspan="3">
						<input type="text" name="startDt" id="startDt" class="datepicker_input input-small" value="${egov:convertDate(boardInfo.startDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						~
						<input type="text" name="endDt" id="endDt"  class="datepicker_input input-small" value="${egov:convertDate(boardInfo.endDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						&nbsp;
						<input type="checkbox" name="odtmYn" value="Y" <c:if test="${boardInfo.odtmYn eq 'Y'}">checked</c:if> onchange="setOdtmYn(this)" /> 상시
					</td>
				</tr>
			</c:if>
			
			<%-- 언론보도는 정렬 및 노출 기간 설정(2020-03-27) --%>
			<c:if test="${mstInfo.communityId eq 3}">
				<tr>
					<th style="vertical-align:middle;">
						* 기간 
					</th>
					<td colspan="3">
						<input type="text" name="sortDt" id="sortDt" class="datepicker_input input-small" value="${egov:convertDate(boardInfo.sortDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly"/>
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<th style="vertical-align:middle;">
					* 제목
				</th>
				<td colspan="3">
					<input type="text" name="title" value="${boardInfo.title}" style="width:50%;" maxlength="250" required="제목을 입력해주세요." />
					<c:if test="${mstInfo.notifyYn eq 'Y'}">
						&nbsp;
						<input type="checkbox" name="notifyYn" value="Y" <c:if test="${boardInfo.notifyYn eq 'Y'}">checked</c:if> /> 공지
					</c:if>
				</td>
			</tr>
			
			<c:if test="${mstInfo.communityType eq 'MOVIE'}">
				<tr>
					<th style="vertical-align:middle;">
						* Youtube 주소
					</th>
					<td colspan="3">
						<input type="text" name="movieUrl" value="${boardInfo.movieUrl}" style="width:50%;" maxlength="500" required="동영상 URL을 입력해주세요." />
						<div style="margin-top:10px;">
							• ex) https://youtu.be/LlY90lG_Fuww
						</div>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<th colspan="4" style="vertical-align:middle;">
					* 내용 (이미지 최적 사이즈는 가로 910 입니다)
				</th>				
			</tr>
			
			<tr>
				<td colspan="4" style="vertical-align:middle;">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="contents" name="contents" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력해주세요.">${boardInfo.contents}</textarea>
					<script type="text/javascript">editorAdd("contents");</script>
				</td>
			</tr>
			
			<c:if test="${mstInfo.communityType eq 'MOVIE'}">
				<tr>
					<th colspan="4" style="vertical-align:middle;">
						자막
					</th>				
				</tr>
				<tr>
					<td colspan="4" style="vertical-align:middle;">
						<textarea name="movieContents" style="width:98%; height:443px;">${boardInfo.movieContents}</textarea>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${mstInfo.communityType eq 'PHOTOLIST'}">
				<tr>
					<th style="vertical-align:middle;">
						* URL
					</th>
					<td colspan="3">
						<input type="text" name="linkUrl" value="${boardInfo.linkUrl}" style="width:50%;" maxlength="500" required="URL을 입력해주세요." />
						<div style="margin-top:10px;">
							• ex) http://www.naver.com
						</div>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${mstInfo.communityType eq 'PHOTO' or mstInfo.communityType eq 'PHOTOLIST' or mstInfo.communityType eq 'EVENT'}">
				<tr>
					<th style="vertical-align:middle;">
						* 썸내일
						<c:if test="${not empty boardInfo.thumnailFileId}">
							<br />
							<font style="color:red; font-size:11px;">* 파일의 추가, 삭제가 바로 적용됩니다.</font>
						</c:if>
					</th>
					<td colspan="3">
						<span class="btn fileinput-button">
		                    <i class="icon-upload"></i>
		                    <span>파일선택</span>
		                    <input type="file" name="thumfile" />
		                </span>
		                &nbsp;
		                <fmt:message var="thnlFileSize" key="Globals.thnlFileSize" /> 
		                <c:choose>
		                	<c:when test="${mstInfo.communityType eq 'PHOTO'}">
		                		• 이미지 최적 사이즈는 가로 222 x 126 입니다. 
		                	</c:when>
		                	<c:when test="${mstInfo.communityType eq 'PHOTOLIST'}">
		                		• 이미지 최적 사이즈는 가로 220 x 140 입니다. 
		                	</c:when>
		                	<c:when test="${mstInfo.communityType eq 'EVENT'}">
		                		• 이미지 최적 사이즈는 가로 290 x 150 입니다. 
		                	</c:when>
		                </c:choose>
		                (<fmt:formatNumber value="${thnlFileSize / 1024}" type="number" groupingUsed="false" maxFractionDigits="0"/>KB 이하만 업로드 가능합니다)
					    <table id="thumfile-files" class="table table-bordered2" style="margin-top:10px;">
							<tr>
								<th width="40%">파일이름</th>	
								<th width="30%">파일사이즈</th>
							    <th width="20%">파일구분</th>
							    <th width="10%">파일삭제</th>
							</tr>
							<c:forEach var="filelist" items="${rtnMap.thumFileList}" varStatus="status">
					       		<tr class="filelist tr${filelist.fileSeq}" fileSeq="${filelist.fileSeq}">
						       		<td style="vertical-align:middle">
						       			<a href="/cmm/fms/FileDown.do?fileId=${filelist.atchFileId}&fileSn=${filelist.fileSeq}">${filelist.realFileNm}</a>
						       		</td>
						       		<td style="vertical-align:middle">
						       			${filelist.fileSize / 1024}KB
						       		</td>
						       		<td style="vertical-align:middle">
						       			${filelist.fileExtn}
						       		</td>
						       		<td style="text-align:center;">
						       			<a href="javascript:delFileDown('thumfile', '${filelist.atchFileId}', '${filelist.fileSeq}')" class="btn btn-danger">삭제</a>
						       		</td>
					       		</tr>
					       	</c:forEach>
					   	</table>
					</td>
				</tr>		
			</c:if>	
			
			<c:if test="${mstInfo.fileAppdCnt gt 0}">
				<tr>
					<th style="vertical-align:middle;">
						첨부파일
						<c:if test="${not empty boardInfo.atchFileId}">
							<br />
							<font style="color:red; font-size:11px;">* 파일의 추가, 삭제가 바로 적용됩니다.</font>
						</c:if>
					</th>
					<td colspan="3">
						<span class="btn fileinput-button">
		                    <i class="icon-upload"></i>
		                    <span>파일추가</span>
		                    <input type="file" name="attfile" />	                    
		                </span>
		                &nbsp;
		                • ${egov:nvl(mstInfo.fileSize, 0)}MB 이하만 업로드 가능합니다.
					    <table id="attfile-files" class="table table-bordered2" style="margin-top:10px;">
							<tr>
							    <th width="40%">파일이름</th>	
								<th width="30%">파일사이즈</th>
							    <th width="20%">파일구분</th>
							    <th width="10%">파일삭제</th>
							</tr>						
						   	<c:forEach var="filelist" items="${rtnMap.atchFileList}" varStatus="status">
					       		<tr class="filelist tr${filelist.fileSeq}" fileSeq="${filelist.fileSeq}">
						       		<td style="vertical-align:middle">
						       			<a href="/cmm/fms/FileDown.do?fileId=${filelist.atchFileId}&fileSn=${filelist.fileSeq}">${filelist.realFileNm}</a>
						       		</td>
						       		<td style="vertical-align:middle">
						       			${filelist.fileSize / 1024}KB
						       		</td>
						       		<td style="vertical-align:middle">
						       			${filelist.fileExtn}
						       		</td>
						       		<td style="text-align:center">
						       			<a href="javascript:delFileDown('attfile', '${filelist.atchFileId}','${filelist.fileSeq}')" class="btn btn-danger">삭제</a>
						       		</td>
						       </tr>
					       	</c:forEach>
					   	</table>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${mstInfo.contentsFileAppdCnt gt 0}">
				<tr>
					<th style="vertical-align:middle;">
						본문 이미지
						<c:if test="${not empty boardInfo.contentsFileId}">
							<br />
							<font style="color:red; font-size:11px;">* 파일의 추가, 삭제가 바로 적용됩니다.</font>
						</c:if>
					</th>
					<td colspan="3">
						<span class="btn fileinput-button">
		                    <i class="icon-upload"></i>
		                    <span>파일추가</span>
		                    <input type="file" name="contentfile" />	                    
		                </span>
		                &nbsp;
		                • ${egov:nvl(mstInfo.contentsFileSize, 0)}KB 이하만 업로드 가능합니다.
					    <table id="contentfile-files" class="table table-bordered2" style="margin-top:10px;">
					       	<tr>
								<th width="25%">파일이름</th>	
								<th width="25%">파일설명</th>
								<th width="20%">파일사이즈</th>
							    <th width="20%">파일구분</th>
							    <th width="10%">파일삭제</th>
					       	</tr>
					       	<c:forEach var="filelist" items="${rtnMap.contentsFileList}" varStatus="status">
					       	<tr class="filelist tr${filelist.fileSeq}" fileSeq="${filelist.fileSeq}">
					       		<td style="vertical-align:middle">
					       			<a href="/cmm/fms/FileDown.do?fileId=${filelist.atchFileId}&fileSn=${filelist.fileSeq}"><c:out value="${filelist.realFileNm}" /></a>
					       		</td>
					       		<td style="vertical-align:middle">
					       			<input type="text" value="${filelist.fileDsc}" name="contentfile${filelist.fileSeq}" style="width:85%; margin-right:10px;"/><a href="javascript:updFileCn('contentfile${filelist.fileSeq}', '${filelist.atchFileId}', '${filelist.fileSeq}')" class="btn btn-info">수정</a>
					       		</td>
					       		<td style="vertical-align:middle">
					       			${filelist.fileSize / 1024}KB
					       		</td>
					       		<td style="vertical-align:middle">
					       			${filelist.fileExtn}
					       		</td>
					       		<td style="text-align:center;">
					       			<a href="javascript:delFileDown('contentfile', '${filelist.atchFileId}', '${filelist.fileSeq}')" class="btn btn-danger">삭제</a>
					       		</td>
					       </tr>
					       </c:forEach>
					   </table>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<th style="vertical-align:middle;">
					* 노출여부
				</th>
				<td colspan="3">
					<c:set var="useYn" value="${egov:nvl(boardInfo.useYn, 'N')}" />
					<input type="radio" name="useYn" value="Y" <c:if test="${useYn eq 'Y'}">checked</c:if> /> 예&nbsp;&nbsp;
					<input type="radio" name="useYn" value="N" <c:if test="${useYn eq 'N'}">checked</c:if> /> 아니오&nbsp;&nbsp; 
				</td>
			</tr>
			
			<c:if test="${mstInfo.commentYn eq 'Y'}">
				<tr>
					<th style="vertical-align:middle;">
						* 댓글공개여부
					</th>
					<td colspan="3">
						<c:set var="replyYn" value="${egov:nvl(boardInfo.replyYn, 'N')}" />
						<input type="radio" name="replyYn" value="Y" <c:if test="${replyYn eq 'Y'}">checked</c:if> /> 예&nbsp;&nbsp;
						<input type="radio" name="replyYn" value="N" <c:if test="${replyYn eq 'N'}">checked</c:if> /> 아니오&nbsp;&nbsp;
					</td>
				</tr>							
			</c:if>
			
			<c:if test="${mstInfo.openYn eq 'Y'}">
				<tr>
					<th style="vertical-align:middle;">
						* 공개여부
					</th>
					<td colspan="3">
						<c:set var="openYn" value="${egov:nvl(boardInfo.openYn, 'N')}" />
						<input type="radio" name="openYn" value="Y" <c:if test="${openYn eq 'Y'}">checked</c:if> /> 공개&nbsp;&nbsp;
						<input type="radio" name="openYn" value="N" <c:if test="${openYn eq 'N'}">checked</c:if> /> 비공개&nbsp;&nbsp;
					</td>
				</tr>							
			</c:if>
		</tbody>
	</table>	
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty boardInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:cancelBoard();" class="btn btn-default">취소</a>
</div>
	
<script src="/common/js/jquery.filestyle.js"></script>
<script type="text/javascript">
	
	//유효성 체크
	function chkForm()
	{	
		var f = document.frm;
		
		<c:if test="${mstInfo.categoryYn eq 'Y'}">
			if(!jQuery(".CATEGORYSELECT").last().val())
			{
				alert("* 구분값을 선택해주세요.");
				jQuery(".CATEGORYSELECT").last().focus();
				return;
			}
		</c:if>
		
		<c:if test="${mstInfo.periodYn eq 'Y'}">
			if(!jQuery("input[name='odtmYn']").is(":checked"))
			{
				if(!jQuery("#startDt").val())
				{
					alert("시작일을 선택해 주세요.");
					jQuery("#startDt").focus();
					return;
				}
				
				if(!jQuery("#endDt").val())
				{
					alert("종료일을 선택해 주세요.");
					jQuery("#endDt").focus();
					return;
				}
				
				//시작일 종료일 유효성 체크
				var startDt = parseInt(jQuery("#startDt").val().replace(/-/gi, ""));
				var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
			
				if(startDt > endDt)
				{
					alert("* 시작일이 종료일보다 클 수 없습니다.");
					return;
				}
			}
		</c:if>
		
		<c:if test="${mstInfo.communityId eq 3}">
			if(!jQuery("#sortDt").val())
			{
				alert("기간을 선택해 주세요.");
				jQuery("#sortDt").focus();
				return;
			}		
		</c:if>
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty boardInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>

		if(confirm(msg))
		{
			f.idx.value = "${boardInfo.idx}";
			f.submit();			
		}
	}
		
	//취소하기
	function cancelBoard()
	{
		<c:choose>
			<c:when test="${empty boardInfo}">
				location.href = history.back();	
			</c:when>
			<c:otherwise>
				var f = document.viewFrm;	
				
				f.action = "./view.do";
				f.idx.value = "${boardInfo.idx}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
		
	var fileFormName;
	
	jQuery(document).ready(function(){
		
		//썸네일
		jQuery("input[name='thumfile']").fileupload({
			url : "./fileUpload.ajax",
	        dataType : "json",
	        multipart : true,
	        autoUpload : true,
	        formData : 
	        {
	        	"fileId" : jQuery("input[name='thumnailFileId']").val(), 
	        	"fileSn" : "0"
	        },
	        done : function (event, data) 
	        {
	        	if(data.result.length > 0)
        		{		        		
	        		jQuery("input[name='thumnailFileId']").val(data.result[0].atchFileId);
	        		
	        		jQuery("#" + fileFormName + "-files").find(".tr0").remove();
	        		
        		    jQuery("#" + fileFormName + "-files").append(
                        jQuery("<tr class='filelist tr" + data.result[0].fileSeq + "' fileSeq='0' />")
                        .append(jQuery("<td style='vertical-align:middle'/>").html("<a href='/cmm/fms/FileDown.do?fileId="+data.result[0].atchFileId+"&fileSn="+data.result[0].fileSeq + "'>" + data.result[0].realFileNm  + "</a>"))
                        .append(jQuery("<td style='vertical-align:middle'/>").text(Math.ceil(data.result[0].fileSize / 1024) + "KB"))
                        .append(jQuery("<td style='vertical-align:middle'/>").text(data.result[0].fileExtn))
                        .append(jQuery("<td style='text-align:center;'/>").html("<a href=\"javascript:delFileDown('" + fileFormName + "', '" + data.result[0].atchFileId + "', '" + data.result[0].fileSeq + "')\" class='btn btn-danger'>삭제</a>"))
					);
        		}
	        	else
        		{
	        		alert("파일 용량이 초과되었습니다.");
        		}
	        }
	    }).bind("fileuploadsubmit", function (e, data) {
			jQuery("input[name='thumfile']").fileupload({formData : {"fileId" : jQuery("input[name='thumnailFileId']").val(), "fileSn" :  "0"} });
	    }).bind("click", function(e, data) {
	    	fileFormName = e.target.name;
	    });
		
		//첨부파일
		jQuery("input[name='attfile']").fileupload({
			url : "./fileUpload.ajax",
	        dataType : "json",
	        multipart : true,
	        autoUpload :true,
	        formData : 
	        {
	        	"fileId" : jQuery("input[name='atchFileId']").val(), 
	        	"fileSn" : "0"
	        },
	        done: function (event, data) 
	        {
	        	if(data.result.length > 0)
        		{
	        		jQuery("input[name='atchFileId']").val(data.result[0].atchFileId);	
	        		
        		    jQuery("#" + fileFormName + "-files").append(
						jQuery("<tr class='filelist tr" + data.result[0].fileSeq + "' fileSeq='" + data.result[0].fileSeq + "' />")
                        .append(jQuery("<td style='vertical-align:middle'/>").html("<a href='/cmm/fms/FileDown.do?fileId=" + data.result[0].atchFileId + "&fileSeq=" + data.result[0].fileSeq + "'>" + data.result[0].realFileNm  + "</a>"))
                        .append(jQuery("<td style='vertical-align:middle'/>").text(Math.ceil(data.result[0].fileSize / 1024) + "KB"))
                        .append(jQuery("<td style='vertical-align:middle'/>").text(data.result[0].fileExtn))
                        .append(jQuery("<td style='text-align:center;'/>").html("<a href=\"javascript:delFileDown('" + fileFormName + "', '" + data.result[0].atchFileId + "', '" + data.result[0].fileSeq + "')\" class='btn btn-danger'>삭제</a>"))
					);
        		}
	        	else
        		{
	        		alert("파일 용량이 초과되었습니다.");
        		}
	        }
	    }).bind("fileuploadsubmit", function (e, data) {
	    	var fileSn = jQuery("#" + fileFormName + "-files").find("tr").last().attr("fileSeq");

	    	if(typeof(fileSn) == "undefined")
			{					
				fileSn = 0;
			}
			else
			{
				fileSn = parseInt(fileSn) + 1;
			}	

	    	jQuery("input[name='attfile']").fileupload({formData : {"fileId" : jQuery("input[name='atchFileId']").val(), "fileSn" : fileSn} });
	    }).bind("click", function(e, data) {
	    	fileFormName = e.target.name;
	    	
	    	if(jQuery("#" + fileFormName + "-files").find(".filelist").length >= parseInt("${egov:nvl(mstInfo.fileAppdCnt, 0)}"))
			{
				alert("등록 할 수 있는 첨부파일 갯수는 ${egov:nvl(mstInfo.fileAppdCnt, 0)}개입니다. 삭제 후 등록해주세요.");
				return false;
			}
	    });
		
		//본문이미지
		jQuery("input[name='contentfile']").fileupload({
			url : "./fileUpload.ajax",
	        dataType : 'json',
	        multipart : true,
	        autoUpload : true,
	        formData : 
	        {
	        	"fileId" : jQuery("input[name='contentsFileId']").val(), 
	        	"fileSn" : "0"
	        },
	        done: function (event, data) 
	        {
	        	if(data.result.length > 0)
	       		{
	        		jQuery("input[name='contentsFileId']").val(data.result[0].atchFileId);
	        		
	        		jQuery("#" + fileFormName + "-files").append(
    	        		jQuery("<tr class='filelist tr" + data.result[0].fileSeq + "' fileSeq=" + data.result[0].fileSeq + "'/>")
   	                   	.append(jQuery("<td style='vertical-align:middle'/>").html("<a href='/cmm/fms/FileDown.do?fileId=" + data.result[0].atchFileId + "&fileSn=" + data.result[0].fileSeq + "'>" + data.result[0].realFileNm  + "</a>"))
                       	.append(jQuery("<td style='vertical-align:middle'/>").html("<input type='text' value='' style='width:85%; margin-right:10px;' name='contentfile" + data.result[0].fileSeq + "' /><a href=\"javascript:updFileCn('" + fileFormName + data.result[0].fileSeq + "', '" + data.result[0].atchFileId + "', '" + data.result[0].fileSeq + "')\" class='btn btn-info'>수정</a></td>"))
                       	.append(jQuery("<td style='vertical-align:middle'/>").text(Math.ceil(data.result[0].fileSize / 1024) + "KB"))
                       	.append(jQuery("<td style='vertical-align:middle'/>").text(data.result[0].fileExtn))
                       	.append(jQuery("<td style='text-align:center;'/>").html("<a href=\"javascript:delFileDown('" + fileFormName + "', '" + data.result[0].atchFileId + "', '" + data.result[0].fileSeq + "')\" class=\"btn btn-danger\">삭제</a>"))
    				);
	       		}
	        	else
	       		{
	        		alert("파일 용량이 초과되었습니다.");
	       		}
	        }
	    }).bind("fileuploadsubmit", function (e, data) {
			var fileSn = jQuery("#"+fileFormName+"-files").find("tr").last().attr("fileSn");
			
			if(typeof(fileSn) == "undefined")
			{					
				fileSn = 0;
			}
			else
			{
				fileSn = parseInt(fileSn) + 1;
			}
			
			jQuery("input[name='contentfile']").fileupload({formData: {fileid:jQuery("input[name='contentsFileId']").val(), filesn:fileSn}});
	    }).bind("click", function(e, data){
	    	fileFormName = e.target.name;
	    	
	    	if(jQuery("#" + fileFormName + "-files").find(".filelist").length >= parseInt("${egov:nvl(mstInfo.contentsFileAppdCnt, 0)}"))
			{
				alert("등록 할 수 있는 첨부파일 갯수는 ${egov:nvl(mstInfo.contentsFileAppdCnt, 0)}개입니다. 삭제 후 등록해주세요.");
				return false;
			}
	    });
		
		<c:if test="${mstInfo.periodYn eq 'Y'}">
			setOdtmYn(jQuery("input[name='odtmYn']"));		
		</c:if>
	});
	
	function delFileDown(delNm, fileId, fileSn)
	{		
		if(confirm("* 첨부파일은 수정없이 바로 삭제됩니다. 첨부파일을 삭제하시겠습니까?"))
		{			
			jQuery.post("./fileDelete.ajax",
				{
					"atchFileId" : fileId,
					"fileSeq" : fileSn
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y")
					{
						jQuery("#" + delNm + "-files").find(".tr" + fileSn).remove();
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	function updFileCn(delNm, fileId, fileSn)
	{
		jQuery.post("./fileUpdFileCn.ajax",
			{
				"atchFileId" : fileId,
				"fileSeq" : fileSn,
				"fileDsc" : jQuery("input[name='" + delNm + "']").val()
			},
			function(r)
			{
				var status = r.status;
				
				if(status == "Y")
				{
					alert("수정하였습니다.");
				}
			}
		).fail(function(){
			alert("잠시후 다시 시도 바랍니다.");
		});
	}
	
	<c:if test="${mstInfo.periodYn eq 'Y'}">
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
	</c:if>
</script>