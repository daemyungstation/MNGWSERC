<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COHBoardMngCategoryBoard.jsp
	프로그램 명 : 	게시판
	설명		: 	카테고리 설정 페이지
	작성자		: 	손의균
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				손의균				최초작성
	######################################################################
-->

<h6>검색 : ${rtnMap.list[0].totCnt}건</h6>

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="communityId" value="" />
	
	<div class="well well-small">
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
	</div>
	<table class="table table-bordered table-hover">
		<caption style="display: none;">게시판 관리</caption>
	 	<thead>
		  	<tr>	    
			    <th width="9%">선택</th>
			    <th width="14%">사용여부</th>
			    <th width="17%">게시판타입</th>
			    <th width="17%">게시판NO</th>
			    <th width="25%">게시판명</th>
			    <th width="18%">등록일</th>
		  	</tr>
	 	</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="6" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr id="tr${list.communityId}">	    
			    	<td style="text-align:center; vertical-align:middle;">
			    		<input type="radio" class="check2" name="boardcheck" value="${list.communityId}" categoryYn="${list.categoryYn}" categoryId="${list.categoryId}" communitytype="${list.communityType}" />
			    	</td>
			    	<td style="text-align:center; vertical-align:middle;">
			    		${list.useYn}	
			    	</td>
			    	<td style="text-align:left; vertical-align:middle;">
						${list.cdNm}
					</td>
			    	<td style="text-align:left; vertical-align:middle;">
						${list.communityId}
					</td>
			    	<td class="refNm" style="text-align:left; vertical-align:middle;">
			    		${list.communityName}
			    	</td>
			    	<td style="text-align:center; vertical-align:middle;">
			    		${egov:convertDate(list.regdate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
			    	</td>
			  	</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<script type="text/javascript">

	//리스트 가져오기
	function getPageList()
	{	
		jQuery.get("/mngwserc/coh/list.ajax",
			{
				"pageIndex" : arguments.length > 0 ? arguments[0] : 1,
				"q" : jQuery("input[name='q']").val()
			},
			function(r) {
				jQuery("#divContentsCategory").html("");
				jQuery("#divContentsCategory").html(r);
			},
			"text"
		).fail(function () {
			alert("예기치 않은 오류입니다.");
		});
	}
</script>