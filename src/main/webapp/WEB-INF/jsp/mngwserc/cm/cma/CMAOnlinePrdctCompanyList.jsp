<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMAOnlinePrdctCompanyList.jsp
	프로그램 명 : 	온라인 상담 회사관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.10
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.10				김필기				최초작성
	######################################################################
-->
<form name="frm" action ="${pageLink}" method="post"  >
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">		
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>회사명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
	 	<thead>
		  	<tr>
				<th width="8%"><input type="checkbox" name="allCheck" /></th>		  	
			    <th width="8%">번호</th>	    
			    <th width="*">회사명</th>
		  	</tr>
	 	</thead>
		<tbody>
		 	<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
		  			<td style="text-align:center;"><input type="checkbox" name="delSeq" value="${list.coCd}" /></td>		  			
		   			<td style="text-align:center;">
		   				${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
		   			</td>
		   			<td >${list.coNm}</td>
		  		</tr>
		 	</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<input type="button" value="삭제" class="btn btn-danger" onclick="deleteList()" />
</div>

<div style="text-align:right;">
	<input type="button" value="회사등록" class="btn btn-success" onclick="CompanyList()" />
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<script type="text/javascript">
//선택 삭제하기
function deleteList()
{
	var f = document.frm;
	
	if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
	{
		if(confirm("삭제하시겠습니까?")) 
		{
			f.action="./delete.do";
			f.submit();
		}
	} 
	else 
	{
		alert("삭제할 대상을 선택하세요.");
		return;
	}
}

//삭제 체크박스 전체 선택 & 해제
jQuery("input:checkbox[name='allCheck']").on("click", function(){
	if(jQuery(this).is(":checked")) 
	{
		jQuery("input:checkbox[name='delSeq']").prop("checked", true);
	} 
	else 
	{
		jQuery("input:checkbox[name='delSeq']").prop("checked", false);
	}	
});

//페이지번호 클릭시
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
	f.submit();
}	

function CompanyList(){
	window.open('/mngwserc/cma/company/b2bcomcd/list.do','회사목록', 'width=550, height=700');
}

</script>