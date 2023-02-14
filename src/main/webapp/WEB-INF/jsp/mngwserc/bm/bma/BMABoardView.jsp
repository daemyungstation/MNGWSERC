<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
 
<!-- 
	######################################################################
	파일명 		:	BMABoardView.jsp
	프로그램 명 : 	게시판 통합 상세보기
	설명		: 	게시판 관리에서 생성한 게시판 통합 상세보기
	작성자		: 	김대환
	작성일		:	2016.02.11
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.11				김대환				최초작성
	######################################################################
-->

<c:set var="boardInfo" value="${rtnMap.boardInfo}" />

<form name="listFrm" method="post">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="useYn" value="${rtnMap.useYn}" />
	<input type="hidden" name="categoryId" value="${rtnMap.categoryId}" />	
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sUseYn" value="${rtnMap.useYn}" />
	<input type="hidden" name="sCategoryId" value="${rtnMap.categoryId}" />	
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="idx" value="" />
	<input type="hidden" name="delidx" value="" />
	

	<table class="table table-bordered">
		<caption style="display: none;">게시글 관리</caption>
		<colgroup>
			<col width="100%" />
		</colgroup>
		<tbody>
			<tr>
				<td style="background-color:#f9f9f9">
					<font style="display:inline-block; float:left; margin-left:10px;">
						<b>
							<c:if test="${boardInfo.notifyYn eq 'Y'}">
								[공지]  
							</c:if>
							<c:if test="${mstInfo.categoryYn eq 'Y'}">
								[${boardInfo.categoryNm}] 
							</c:if>
							${boardInfo.title}
						</b>
					</font>
					<font style="display:inline-block; float:right; margin-right:10px;">
						${boardInfo.regname}&nbsp;
						${egov:convertDate(boardInfo.regdate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
						<c:if test="${mstInfo.communityId eq 3}">
						(${egov:convertDate(boardInfo.sortDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')})
						</c:if>
					</font>
				</td>
			</tr>		
				
			<c:if test="${mstInfo.openYn eq 'Y'}">
				<tr>
					<td style="padding-left:15px; background-color:#f9f9f9">
						<b>공개 / 비공개</b> : ${egov:decode(boardInfo.openYn, 'Y', '공개', '비공개')}
					</td>
				</tr>							
			</c:if>
			
			<c:if test="${mstInfo.periodYn eq 'Y'}">
				<tr>
					<td style="padding-left:15px; background-color:#f9f9f9">
						<b>기간</b> :
						<c:choose>
							<c:when test="${boardInfo.odtmYn eq 'Y'}">
								상시
							</c:when>
							<c:otherwise>
								${egov:convertDate(boardInfo.startDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')} 
								~ 
								${egov:convertDate(boardInfo.endDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							</c:otherwise>
						</c:choose> 
					</td>
				</tr>
		    </c:if>
		    
		    <c:if test="${mstInfo.communityType eq 'PHOTOLIST'}">
		    	<tr>
					<td style="padding-left:15px; background-color:#f9f9f9">
						<b>URL</b> : ${boardInfo.linkUrl}
					</td>
				</tr>
		    </c:if>
			
			<c:if test="${mstInfo.communityType eq 'MOVIE'}">
				<tr>
					<td style="padding-left:15px; background-color:#f9f9f9">
						<b>동영상 URL</b> : ${boardInfo.movieUrl}
					</td>
				</tr>		
			</c:if>
			
			<c:if test="${mstInfo.communityType eq 'PHOTO' or mstInfo.communityType eq 'PHOTOLIST' or mstInfo.communityType eq 'EVENT'}">
				<tr>
					<td style="padding-left:15px;">
						썸네일 : 
						<c:forEach var="filelist" items="${rtnMap.thumFileList}" varStatus="status">
							<a href="/cmm/fms/FileDown.do?fileId=${filelist.atchFileId}&fileSn=${filelist.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${filelist.realFileNm}</a>
						</c:forEach>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${fn:length(rtnMap.atchFileList) > 0}">
				<tr>
					<td style="padding-left:15px;">
						첨부파일 : 
						<c:forEach var="filelist" items="${rtnMap.atchFileList}" varStatus="status">
							<a href="/cmm/fms/FileDown.do?fileId=${filelist.atchFileId}&fileSn=${filelist.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${filelist.realFileNm}</a>
						</c:forEach>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td>					
			       	<iframe src="./view.do?idx=${boardInfo.idx}&editorView=Y" style="width:100%" frameborder="0" onload="autoResize(this)"></iframe>	
				</td>
			</tr>
			
		</tbody>
	</table>
</form>	

<c:if test="${mstInfo.commentYn eq 'Y'}">	
	<div id="divComment">
	
	</div>
</c:if>

<c:if test="${mstInfo.commentYn eq 'Y'}">
	<div style="float:left;">
		<a href="javascript:selecBoardCommentExcelList();" class="btn btn-info">엑셀 다운로드</a>
	</div>
</c:if>

<div style="float:right;">
	<a href="javascript:setModify();" class="btn btn-primary">수정</a>
	<a href="javascript:setDelete();" class="btn btn-danger">삭제</a>
	<a href="javascript: historyGoBack();" class="btn btn-default">목록</a>	
</div>
	
<script type="text/javascript">
	
	//수정페이지
	function setModify()
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.idx.value = "${boardInfo.idx}";
		f.submit();
	}
	
	//삭제하기
	function setDelete()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./deleteMulti.do";
			f.delidx.value = "${boardInfo.idx}";
			f.submit();
		}
	}
	
	function autoResize(i)
	{
	    var iframeHeight = (i).contentWindow.document.body.scrollHeight;
	    (i).height = iframeHeight + 40;
	}
	
	<c:if test="${mstInfo.commentYn eq 'Y'}">
		jQuery(document).ready(function(){
			getCommentList();
		});
	
		//댓글 목록		
		function getCommentList()
		{
			jQuery.get("./commentlist.ajax",
				{
					"pageIndex" : arguments.length > 0 ? arguments[0] : 1,
					"idx" : "${boardInfo.idx}"
				},
				function(r)
				{
					jQuery("#divComment").html("");
					jQuery("#divComment").html(r);
				},
				"text"
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
		
		//댓글 등록
		function insertBoardComment()
		{
			var comment = jQuery("textarea[name='comment']").val();
			
			if(!comment)
			{
				alert("* 내용을 입력해주세요.");
				jQuery("textarea[name='comment']").focus();
				return;
			}
			
			if(confirm("댓글을 등록하시겠습니까?"))
			{
				jQuery.post("./insertComment.ajax",
					{
						"idx" : "${boardInfo.idx}",
						"contents" : comment
					},
					function(r)
					{			
						var status = r.status;
						
						if(status == "Y")
						{
							getCommentList();
						}
					}
				).fail(function(){
					alert("잠시후 다시 시도 바랍니다.");
				});
			}
		}
		
		//댓글 수정폼 set
		function setUpdateForm(obj)
		{
			if(jQuery(obj).next().text() == "취소")
			{
				setReplyForm(jQuery(obj).next());
			}
			
			var objTxt = jQuery(obj).text();
			
			if(objTxt == "수정")
			{
				jQuery(obj).removeClass("btn-info");
				jQuery(obj).text("취소");
				
				jQuery(obj).parent().prev().find(".cntnType1").hide();
				jQuery(obj).parent().prev().find(".cntnType2").show();
			}
			else
			{
				jQuery(obj).addClass("btn-info");
				jQuery(obj).text("수정");
				
				jQuery(obj).parent().prev().find(".cntnType1").show();
				jQuery(obj).parent().prev().find(".cntnType2").hide();
			}
			
			jQuery(obj).parent().prev().find(".cntnType2 textarea").val(jQuery(obj).parent().prev().find(".cntnType1 .contents").text());
		}
		
		//댓글 수정
		function updateBoardComment(cidx, obj)
		{
			var comment = jQuery(obj).closest("tr").find("textarea").val();
			
			if(!comment)
			{
				alert("* 내용을 입력해주세요.");
				jQuery(obj).prev("textarea").focus();
				return;
			}
			
			if(confirm("댓글을 수정하시겠습니까?"))
			{
				jQuery.post("./updateComment.ajax",
					{
						"idx" : "${boardInfo.idx}",
						"cidx" : cidx,
						"contents" : comment
					},
					function(r)
					{
						var status = r.status;
						
						if(status == "Y")
						{
							getCommentList(jQuery("input[name='pageIndex']").val());
						}
					}
				).fail(function(){
					alert("잠시후 다시 시도 바랍니다.");
				});
			}
		}
		
		//답급 입력폼 set
		function setReplyForm(obj, reDepth)
		{
			if(jQuery(obj).prev().text() == "취소")
			{
				setUpdateForm(jQuery(obj).prev());
			}
			
			var objTxt = jQuery(obj).text();
			
			if(objTxt == "답글")
			{
				jQuery(obj).removeClass("btn-warning");
				jQuery(obj).text("취소");
	
				jQuery(obj).parent().prev().find(".replyType").show();
			}
			else
			{
				jQuery(obj).addClass("btn-warning");
				jQuery(obj).text("답글");
				
				jQuery(obj).parent().prev().find(".replyType").hide();
			}
			
			jQuery(obj).parent().prev().find(".replyType textarea").val("");
		}
		
		//답글 입력
		function insertBoardCommentReply(cidx, groupId, reDepth, obj)
		{
			var comment = jQuery(obj).closest("tr").find("textarea").val();
			
			if(!comment)
			{
				alert("* 내용을 입력해주세요.");
				jQuery(obj).prev("textarea").focus();
				return;
			}
			
			if(confirm("답글을 등록하시겠습니까?"))
			{
				jQuery.post("./insertComment.ajax",
					{
						"idx" : "${boardInfo.idx}",
						"groupId" : groupId,
						"reDepth" : parseInt(reDepth) + 1,
						"contents" : comment
					},
					function(r)
					{
						var status = r.status;
						
						if(status == "Y")
						{
							getCommentList(jQuery("input[name='pageIndex']").val());
						}
					}
				).fail(function(){
					alert("잠시후 다시 시도 바랍니다.");
				});
			}
		}
		
		//댓글 삭제
		function deleteBoardComment(cidx)
		{
			if(confirm("댓글을 삭제하시겠습니까?"))
			{				
				jQuery.post("./deleteComment.ajax",
					{
						"idx" : "${boardInfo.idx}",
						"cidx" : cidx
					},
					function(r)
					{
						var status = r.status;
						
						if(status == "Y")
						{
							getCommentList(jQuery("input[name='pageIndex']").val());
						}
					}
				).fail(function(){
					alert("잠시후 다시 시도 바랍니다.");				
				});
			}
		}
		
		//덧글 상태값 변경
		function updateCommentUseYn(cidx, useYn)
		{
			if(confirm("댓글의 상태값을 변경하시겠습니까?"))
			{				
				jQuery.post("./commentUseYn.ajax",
					{
						"idx" : "${boardInfo.idx}",
						"cidx" : cidx,
						"useYn" : useYn
					},
					function(r)
					{			
						var status = r.status;
						
						if(status == "Y")
						{
							getCommentList(jQuery("input[name='pageIndex']").val());
						}
					}
				).fail(function(){
					alert("잠시후 다시 시도 바랍니다.");				
				});
			}
		}
		
		//엑셀다운로드
		function selecBoardCommentExcelList()
		{
			var f = document.frm;
			
			f.action = "./excelComment.do";
			f.idx.value = "${boardInfo.idx}";
			f.submit();
		}
	</c:if>
	
	//검색결과 그대로 목록가기
	function historyGoBack(){		
		var f = document.listFrm;		
		f.action = "./list.do";
		f.submit();		
	}
</script>