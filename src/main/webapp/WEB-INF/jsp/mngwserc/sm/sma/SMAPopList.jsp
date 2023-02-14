<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	SMAPopList.jsp
	프로그램 명 : 	팝업 목록을 조회한다.
	설명		: 	팝업 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="popSeq" value="" />
	
	<div class="well well-small">
		게시여부 : 
		<select name="ptupYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.ptupYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.ptupYn eq 'N'}">selected</c:if>>N</option>
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>팝업명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">팝업 관리</caption>
		<thead>
			<tr>
				<th width="6%"><input type="checkbox" name="all_check"/></th>
				<th width="8%">번호</th>
				<th width="36%">팝업명</th>
				<th width="20%">게시기간</th>
				<th width="10%">작성자</th>
				<th width="12%">작성일</th>
				<th width="8%">게시</th>
			</tr>
		</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delSeq" value="${list.popSeq}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectPopDtl('${list.popSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectPopDtl('${list.popSeq}');">
						${egov:tldCutString(list.popNm, '...', '35')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectPopDtl('${list.popSeq}');">
						<c:choose>
							<c:when test="${list.odtmYn eq 'Y'}">
								상시
							</c:when>
							<c:otherwise>
								${egov:convertDate(list.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
								&nbsp;~&nbsp;
								${egov:convertDate(list.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							</c:otherwise>
						</c:choose>
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectPopDtl('${list.popSeq}');">
						${list.regId}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectPopDtl('${list.popSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectPopDtl('${list.popSeq}');">
						${list.ptupYn}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:deletePopList();" class="btn btn-danger">삭제</a>
</div>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>

<script type="text/javascript">

	//체크박스 jQeury
	jQuery(document).ready(function(){
		//삭제 체크박스 전체 선택 & 해제
		jQuery("input:checkbox[name='all_check']").click(function(){
			if(jQuery(this).is(":checked"))
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", false);
			}	
		});
		
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='delSeq']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='delSeq']").length;
			var selChkCnt = jQuery("input:checkbox[name='delSeq']:checked").length;
			
			if(allChkCnt==selChkCnt)
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", false);
			}
		});
	});

	//리스트 가져오기
	function getPageList()
	{	
		var f = document.frm;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}
		
		f.action = "./list.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectPopDtl(popSeq)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.popSeq.value = popSeq;
		f.submit();
	}
	
	//선택 삭제하기
	function deletePopList()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				var f = document.frm;
				
				f.action = "./delete.do";
				f.submit();
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
</script>