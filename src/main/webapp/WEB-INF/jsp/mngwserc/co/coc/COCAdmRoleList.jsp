<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COCAdmRoleList.jsp
	프로그램 명 : 	관리자 ROLE 관리
	설명		: 	리스트
	작성자		: 	김대환
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				김대환				최초작성
	######################################################################
-->

<form name="frm" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="roleCd" value="" />

	<div class="well well-small">
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>부서명</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>작성자</option>
		</select>
		<input class="inputType" type="text" name="q" value="${rtnMap.q}" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn" title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover" >
		<caption style="display: none;">관리자 ROLE 관리</caption>
	 	<thead>
			<tr>
		    	<th width="10%">번호</th>	    
		    	<th width="50%">부서명 (ROLE)</th>
		    	<th width="20%">작성자</th>
		    	<th width="20%">등록일</th>
		  	</tr>
		</thead>
		<tbody>
	 		<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="4" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
	 		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
				    <td style="text-align:center; cursor:pointer;" onclick="selectAdmRoleDtl('${list.roleCd}');">
				    	${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
				    </td>
				    <td style="text-align:left; cursor:pointer;" onclick="selectAdmRoleDtl('${list.roleCd}');">
				    	${list.roleNm}
				    </td>
				    <td style="text-align:left; cursor:pointer;" onclick="selectAdmRoleDtl('${list.roleCd}');">
				    	${list.regNm}
				    </td>
				    <td style="text-align:center; cursor:pointer;" onclick="selectAdmRoleDtl('${list.roleCd}');">
				    	${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
				    </td>
				</tr>
	 		</c:forEach>
	 	</tbody>
	</table>
</form>

<div style="float:right;">
	<c:choose>
		<c:when test="${rtnMap.roleGb eq 'AUTH'}">
			<c:if test="${rtnMap.list[0].authCnt ne 0}">
				<a href="./write.do" class="btn btn-success">등록</a>
			</c:if>
		</c:when>
		<c:otherwise>
			<a href="./write.do" class="btn btn-success">등록</a>
		</c:otherwise>
	</c:choose>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>
	
<script type="text/javascript">
	//해당 페이지의 리스트를 조회한다.
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
	
	//해당 관리자 ROLE 상세페이지로 이동한다.
	function selectAdmRoleDtl(roleCd)
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.roleCd.value = roleCd;
		f.submit();
	}
</script>