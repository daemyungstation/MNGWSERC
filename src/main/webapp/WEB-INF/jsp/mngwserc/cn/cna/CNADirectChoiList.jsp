<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<script type="text/javascript" src="/common/js/mngwserc/cn/cna/CNADirectChoi.js"></script>
<!-- 
	######################################################################
	파일명 		:	CNAZeroChoiList.jsp
	프로그램 명 : 	다이렉트 초이스를 조회한다.
	설명		: 	다이렉트 초이스를 조회하는 페이지
	작성자		: 	박주윤
	작성일		:	2018.03.29
	수정일자	 			수정자				수정내용
	=====================================================================
	
	######################################################################
-->
<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" id="useYnChk" value="${rtnMap.list[0].useYnChk }">	<!-- 1 보다 크면 Y가 1개 이상임 -->
	<input type="hidden" name="gubun" value="" />
	
	<div class="well well-small">
		조건검색 : 
		<select name="f1">
			<option value="1" <c:if test="${rtnMap.f1 eq '1'}">selected</c:if>>전체</option>
			<option value="2" <c:if test="${rtnMap.f1 eq '2'}">selected</c:if>>제목</option>
			<option value="3" <c:if test="${rtnMap.f1 eq '3'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		&emsp; 노출여부 : 
		<select name="f2">
			<option value="" <c:if test="${rtnMap.f2 eq '1'}">selected</c:if>>전체</option>
			<option value="2" <c:if test="${rtnMap.f2 eq '2'}">selected</c:if>>Y</option>
			<option value="3" <c:if test="${rtnMap.f2 eq '3'}">selected</c:if>>N</option>
		</select>
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">이용안내 관리</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th width="6%">번호</th>
				<th width="52%">제목</th>
				<th width="15%">작성자</th>
				<th width="14%">작성일</th>
				<th width="8%">노출여부</th>
			</tr>
		</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="6" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">
						<c:if test="${list.useYn eq 'Y' }">
							<input type="checkbox" name="delSeq" value="${list.dirctSeq}" disabled="disabled"/>
						</c:if>
						<c:if test="${list.useYn eq 'N' }">
							<input type="checkbox" name="delSeq" value="${list.dirctSeq}" />
						</c:if>
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectDirectChoiDtl('${list.dirctSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>		
					<td style="text-align:left; cursor:pointer;" onclick="selectDirectChoiDtl('${list.dirctSeq}');">
						${list.title}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectDirectChoiDtl('${list.dirctSeq}');">
						${list.name}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectDirectChoiDtl('${list.dirctSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectDirectChoiDtl('${list.dirctSeq}');">
						${list.useYn}
					</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</form>

<!-- 이미지관리 등록 Modal -->
<div class="modal fade" id="popup" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1000px; margin-left: -500px;">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="pop_Label"></h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
				<%@ include file="./CNADirectChoiPop.jsp" %>
			</div>
    	</div>
  	</div>
</div>

<div style="float:left;">
	<a href="javascript:deleteList();" class="btn btn-danger">삭제</a>
</div>

<div style="float:right;">
	<a href="javascript:inserPopOpen();" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>
