<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	employeeListPop.jsp
	프로그램 명 : 	담당자 목록 조회
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.26
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.26				김필기				최초작성
	######################################################################
-->
<form name="frm" action ="./employeeList.do">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	<input type="hidden" name="target" value="${rtnMap.target}" />
		
	<div class="well well-small">
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>담당자명</option>
		</select>
		
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="./employeeList.do" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>		
		
	<table class="table table-bordered" style="width:100%">
		<colgroup>
			<col width="10%"/>
			<col width="25%"/>
			<col width="*"/>
			<col width="10%"/>
		</colgroup>
		<tr>
			<th>번호</th>
			<th>담당자명</th>
			<th>소속</th>
			<th>기능</th>
		</tr>

		<c:if test="${fn:length(rtnMap.list) == 0}">
		<tr>
			<td class="lt_text3" colspan="4" style="text-align:center;">
				<fmt:message key="common.nodata.msg" />
			</td>
		</tr>
		</c:if>


		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
  		<tr>		  			
   			<td style="text-align:center;">
   				${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
   			</td>
   			<td>${list.empleNm}</td>
   			<td>${list.deptNm}</td>
   			<td style="text-align:center">
   				<input type="button" value="선택" class="btn btn-success btn-small regbtn" data-code="${list.empleNo}" onclick="reg('${rtnMap.target}',  '${list.empleNo}', '${list.empleNm}')" >   				
   			</td>
   		</tr>
   		</c:forEach>
	</table>
		
	<div class="paging_all c_box">
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
			</ul>
		</div>
	</div>
</form>	


<script type="text/javascript">
	function reg(target, code, name){
		var openerTarget = $(opener.document).find('#' + target);
		if(confirm("선택하시겠습니까?")){			
			openerTarget.find('.asgn_cd').val(code);
			openerTarget.find('.asgn_nm').val(name);
			window.close();
		}	
	}
	
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
	</script>
	