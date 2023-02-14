<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	PRAMgznList.jsp
	프로그램 명 : 	라이프웨이 매거진 목록을 조회한다.
	설명		: 	라이프웨이 매거진 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.16
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.16				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="mgznSeq" value="" />

	<table class="table table-bordered table-hover">
		<caption style="display: none;">라이프웨이 매거진 관리</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th width="6%">번호</th>
				<th width="8%">연도</th>
				<th width="13%">1</th>
				<th width="13%">2</th>
				<th width="13%">3</th>
				<th width="13%">4</th>
				<th width="14%">작성자</th>
				<th width="13%">작성일</th>
			</tr>
		</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="9" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delSeq" value="${list.mgznSeq}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>					
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${list.mgznPbtnYr}							
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${egov:decode(list.sprTitl, null, 'X', 'O')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${egov:decode(list.smmrTitl, null, 'X', 'O')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${egov:decode(list.atmnTitl, null, 'X', 'O')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${egov:decode(list.wntrTitl, null, 'X', 'O')}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${list.regId}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectLifeMgznDtl('${list.mgznSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:deleteLifeMgznList();" class="btn btn-danger">삭제</a>
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
		
		f.action = "./index.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectLifeMgznDtl(mgznSeq)
	{
		var f = document.frm;	
		
		f.action = "./view.do";
		f.mgznSeq.value = mgznSeq;
		f.submit();
	}
	
	//선택 삭제하기
	function deleteLifeMgznList()
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
