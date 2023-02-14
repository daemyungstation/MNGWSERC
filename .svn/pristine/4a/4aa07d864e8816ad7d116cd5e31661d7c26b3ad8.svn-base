<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	MBCQscnMemList.jsp
	프로그램 명 :  	휴면계정 목록을 조회한다.
	설명		: 	휴면계정 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.22
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.22				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="id" value="" />

	<div class="well well-small"> 
		<select name="dtGb">
			<option value="1" <c:if test="${rtnMap.dtGb eq '1'}">selected</c:if>>최종접속일</option>
			<option value="2" <c:if test="${rtnMap.dtGb eq '2'}">selected</c:if>>가입일</option>
		</select>
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" value="${rtnMap.strtDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" value="${rtnMap.endDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>SSO 통합아이디</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고유번호</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	<div class="well well-small"> 
		<strong style="margin-left:5px">※ 휴면계정 수동해제는 해당항목으로 들어가서 설정해주어야 합니다.</strong>
	</div>
	<table class="table table-bordered table-hover">
		<caption style="display: none;">휴면 계정 관리</caption>
		<thead>
			<tr>
				<th width="6%">번호</th>
				<th width="12%">고유번호</th>
				<th width="15%">이름</th>
				<th width="15%">아이디</th>
				<th width="15%">SSO 통합아이디</th>
				<th width="15%">이메일</th>
				<th width="11%">최종접속일</th>
				<th width="11%">가입일</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
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
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}')">
						${list.unqNo}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}')">
						${list.name}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}')">
						${list.id}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}');">
						${list.ssoId}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}')">
						${list.email}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}')">
						${egov:convertDate(list.lastLgnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectQscnMemDtl('${list.id}')">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<%--/*BLOCK_EXCEL*/<div style="float:left;">--%>
<%--	<a href="javascript:excelList();" class="btn btn-primary">엑셀 다운로드</a>--%>
<%--</div>--%>

<div style="float:right;">
	<a href="javascript:qscnChange();" class="btn btn-primary">휴면 회원 전환</a>
</div>

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
	function selectQscnMemDtl(id)
	{
		var f = document.frm;
		
		f.action = "./view.do";
		f.id.value = id;
		f.submit();		
	}
	
	// //엑셀 다운로드
	// function excelList() /*BLOCK_EXCEL*/
	// {
	// 	var f = document.frm;
	//
	// 	f.action = "./excel.do";
	// 	f.submit();
	// }
	
	function qscnChange()
	{
		var f = document.frm;
		
		f.action = "./qscnChange.do";
		f.submit();
	}
	
</script>