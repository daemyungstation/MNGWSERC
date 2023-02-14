<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	BMABoardCommentList.jsp
	프로그램 명 : 	게시판 통합 상세보기에 댓글 리스트
	설명		: 	게시판 통합 상세보기에 댓글 리스트
	작성자		: 	안진용
	작성일		:	2015.11.24
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.24				안진용				최초작성
	######################################################################
-->

<c:if test="${not empty mstInfo and mstInfo.useYn eq 'Y' and mstInfo.commentYn eq 'Y'}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<table class="table table-bordered">
		<colgroup>
			<col width="12%" />
			<col width="64%" />
			<col width="12%" />
			<col width="12%" />
		</colgroup>
		<tbody>
			<tr>
				<td colspan="4" style="vertical-align:middle;">
					<table cellpadding="0px" cellspacing="0px" width="100%">
						<tr>
							<td style="padding:0px; vertical-align:middle; width:95%; border-left:0;">
								<textarea name="comment" style="width:98%; height:60px;"></textarea>
							</td>
							<td style="padding:0px; vertical-align:middle; border-left:0;">
								<a href="javascript:insertBoardComment();" class="btn btn-success" style="padding:18px 18px;">등록</a>	
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="4" style="text-align:center">
						등록된 댓글이 없습니다.
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<th style="vertical-align:middle;">
						${list.regid}
					</th>
					<td style="text-align:left; vertical-align:middle;">
	    				<div class="cntnType1">
	    					<c:if test="${list.reDepth gt 0}">
								<span style="margin-left:${list.reDepth * 10}px;"><img src="/egov/img/repl_icon.gif" /></span>
						   	</c:if>	
	    					<span class="contents">${list.contents}</span>
	    				</div>
	    				<div class="cntnType2" style="display:none;">
	    					<table cellpadding="0px" cellspacing="0px" width="100%">
								<tr>
									<td style="padding:0px; vertical-align:middle; width:92%; border-left:0;">
										<textarea name="comment" style="width:98%; height:40px;"></textarea>
									</td>
									<td style="padding:0 0 0 5px; vertical-align:middle; border-left:0;">
										<a href="javascript:" onclick="updateBoardComment('${list.cidx}', this);" class="btn btn-success" style="padding:10px 10px; font-size:12px;">적용</a> 
									</td>
								</tr>
							</table>
	    					<%-- 
	    					<textarea style="width:90%; height:40px;">${list.contents}</textarea>
	    					<a href="javascript:" onclick="updateBoardComment('${list.cidx}', this);" class="btn btn-success" style="padding:10px 10px; font-size:12px;">적용</a> 
	    					--%>
	    				</div>
   						<div class="replyType" style="margin-left:${list.reDepth * 10}px; display:none;">
   							<table cellpadding="0px" cellspacing="0px" width="100%">
								<tr>
									<td style="padding:0px; vertical-align:middle; width:90%; border-left:0;">
										<textarea name="comment" style="width:98%; height:40px;"></textarea>
									</td>
									<td style="padding:0 0 0 5px; vertical-align:middle; border-left:0;">
										<a href="javascript:" onclick="insertBoardCommentReply('${list.cidx}', '${list.groupId}', '${list.reDepth}', this);" class="btn btn-success" style="padding:10px 10px; font-size:12px;">적용</a> 
									</td>
								</tr>
							</table>
							<%-- 
   							<textarea style="width:90%; height:40px;"></textarea>
   							<a href="javascript:" onclick="insertBoardCommentReply('${list.cidx}', '${list.groupId}', '${list.reDepth}', this);" class="btn btn-success" style="padding:10px 10px; font-size:12px;">적용</a> 
   							--%>
   						</div>
					</td>
					<td style="text-align:center; vertical-align:middle;">
						<a href="javascript:" onclick="setUpdateForm(this);" class="btn btn-info" style="padding:2px 10px; font-size:12px">수정</a>
						<a href="javascript:" onclick="setReplyForm(this, '${list.reDepth}');" class="btn btn-warning" style="padding:2px 10px; font-size:12px">답글</a>
						<a href="javascript:" onclick="deleteBoardComment('${list.cidx}');" class="btn btn-danger" style="padding:2px 10px; font-size:12px">삭제</a>
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${egov:convertDate(list.regdate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="paging_all c_box">
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getCommentList" />	
			</ul>
		</div>
	</div>
</c:if>