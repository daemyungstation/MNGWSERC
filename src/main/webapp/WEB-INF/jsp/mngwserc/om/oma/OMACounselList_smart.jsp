<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMACounselList_smart.jsp
	프로그램 명 : 	외주업체 상담관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.04.15
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.04.15				김필기				최초작성
	######################################################################
-->

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		<select name="f">
			<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>연락처</option>
			<option value="6" <c:if test="${rtnMap.f eq '6'}">selected</c:if>>상담자</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>고객명</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>상담확인</option>			    
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>	
	
	<p>전체 게시물 수 : ${rtnMap.totalCount }</p>
	<table class="table table-bordered table-hover">
		<caption style="display: none;">외주업체 상담 관리</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>판매사명</th>
				<th>사번</th>
				<th>매장코드</th>
				<th>매장코드2</th>
				<th>고객명</th>
				<th>연락처</th>
				<th>상품명</th>
				<th>상담신청일</th>
				<th>상담확인</th>
				<th>상담자</th>
				<th>MEMO</th>
				<th>연락처2</th>
			</tr>
		</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
			<tr>
				<td class="lt_text3" colspan="13" style="text-align:center">
					<fmt:message key="common.nodata.msg" />
				</td>
			</tr>
			</c:if>
						
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
			<tr>
				<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
				
				<c:choose>
					<c:when test="${rtnMap.loginId eq 'smartlife' }">
					<td style="text-align:center;">${list.code2}</td>
					<td>&nbsp;</td>
					<td style="text-align:center;">${list.code3}</td>
					<td>&nbsp;</td>
					<td style="text-align:center;"><a href="./view.do?idx=${list.oscCnslSeq}&f=${rtnMap.f}&q=${rtnMap.q}">${list.name}</a></td>
					<td style="text-align:center;">${list.hp}</td>
					<td style="text-align:center;">${list.prdctNm}</td>
					<td style="text-align:center;">${list.regDtm}</td>
					<td style="text-align:center;">${list.callStts}</td>
					<td style="text-align:center;">${list.cnslr}</td>
					<td style="text-align:center;">${list.memo}</td>
					<td>&nbsp;</td>
					</c:when>
					
					<c:when test="${rtnMap.loginId eq 'daekyo' }">
					<td>&nbsp;</td>
					<td style="text-align:center;">${list.code2}</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td style="text-align:center;"><a href="./view.do?idx=${list.oscCnslSeq}&f=${rtnMap.f}&q=${rtnMap.q}">${list.name}</a></td>
					<td style="text-align:center;">${list.hp}</td>
					<td style="text-align:center;">${list.prdctNm}</td>
					<td style="text-align:center;">${list.regDtm}</td>
					<td style="text-align:center;">${list.callStts}</td>
					<td style="text-align:center;">${list.cnslr}</td>
					<td style="text-align:center;">${list.memo}</td>
					<td>&nbsp;</td>
					
					</c:when>
					
					<c:when test="${rtnMap.loginId eq 'tlife' }">
					<td>&nbsp;</td>
					<td style="text-align:center;">${list.code2}</td>
					<td style="text-align:center;">${list.code1}</td>
					<td style="text-align:center;">${list.code3}</td>
					<td style="text-align:center;"><a href="./view.do?idx=${list.oscCnslSeq}&f=${rtnMap.f}&q=${rtnMap.q}">${list.name}</a></td>
					<td style="text-align:center;">${list.hp}</td>
					<td style="text-align:center;">${list.prdctNm}</td>
					<td style="text-align:center;">${list.regDtm}</td>
					<td style="text-align:center;">${list.callStts}</td>
					<td style="text-align:center;">${list.cnslr}</td>
					<td style="text-align:center;">${list.memo}</td>
					<td style="text-align:center;">${list.agentEmpTel}</td>					
					</c:when>
					
					<c:otherwise>
					<td>&nbsp;</td>
					<td style="text-align:center;">${list.code2}</td>
					<td style="text-align:center;">${list.code1}</td>
					<td>&nbsp;</td>
					<td style="text-align:center;">${list.name}</td>
					<td style="text-align:center;">${list.hp}</td>
					<td style="text-align:center;">${list.prdctNm}</td>
					<td style="text-align:center;">${list.regDtm}</td>
					<td style="text-align:center;">${list.callStts}</td>
					<td style="text-align:center;">${list.cnslr}</td>
					<td style="text-align:center;">${list.memo}</td>
					<td style="text-align:center;">${list.agentEmpTel}</td>
					
					</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="./excel.do" class="btn btn-info">엑셀 다운로드</a>
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
</script>
