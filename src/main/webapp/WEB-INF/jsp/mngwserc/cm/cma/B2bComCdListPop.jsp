<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	B2bComCdList.jsp
	프로그램 명 : 	엔컴 회사코드 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.10
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.10				김필기				최초작성
	######################################################################
-->
<form name="frm" action ="./list.do" method="post"  >
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
		<caption style="display: none;">엔컴 회사코드</caption>
	 	<thead>
		  	<tr>	  	
			    <th width="8%">번호</th>	    
			    <th width="*">회사명</th>
			    <th width="15%">기능</th>
		  	</tr>
	 	</thead>
		<tbody>
		 	<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
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
		   			<td>${list.comNm}</td>	
		   			<td style="text-align:center;">
		   				<input type="button" value="등록" class="btn btn-info" onclick="Reg('${list.comCd}','${list.comNm}')" />
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

function Reg(coCd, coNm){
	$.ajax({
		type : "POST",
		url : "/mngwserc/cma/company/insert.ajax",
		data : {
			CO_CD : coCd,
			CO_NM : coNm
		},
		success : function(r){
			if(r.result){
				alert("등록되었습니다.");
				opener.location.reload(true);
			}else{
				alert("이미 등록되었습니다.");
			}
		}
	});
}
</script>