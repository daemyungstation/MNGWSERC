<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COHBoardMngList.jsp
	프로그램 명 : 	게시판 관리
	설명		: 	리스트
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
		구분 : 
		<select name="communityType">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.communityType}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.communityType eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		사용여부 : 
		<select name="useYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.useYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.useYn eq 'N'}">selected</c:if>>N</option>
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>카테고리ID</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>게시판명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn" title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">게시판 관리</caption>
	 	<thead>
	  		<tr>
			    <th width="6%">번호</th>
			    <th width="13%">구분</th>
			    <th width="43%">게시판명</th>
			    <th width="16%">등록일</th>
			    <th width="6%">사용여부</th>
			    <th width="16%">설정관리</th>
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
		  		<tr>
				    <td style="text-align:center;">
				   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
				   	</td>
				    <td style="text-align:left;">
				    	${list.cdNm}
				    </td>
				    <td style="text-align:left;">
				    	${list.communityName}
				    </td>
				    <td style="text-align:center;">
				    	${egov:convertDate(list.regdate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
				    </td>
				    <td style="text-align:center;">
				    	${list.useYn}
				    </td>
				    <td style="text-align:center;">
				    	<a href="javascript:selectBoardStup('${list.communityId}');" class="btn btn-warning">
				    		환경설정
				    	</a>
				    	<!--
				    	<a href="javascript:selectBannerStup('${list.communityId}');" class="btn btn-${egov:decode(list.bannerTopYn, 'Y', 'inverse', egov:decode(list.bannerBottonYn, 'Y', 'inverse', 'info'))}">
				    		배너설정
				    	</a>
				    	-->
				    	<a href="javascript:setCopy('${list.communityId}');" class="btn">
				    		복사
				    	</a>
			    	</td>
			  	</tr>
		 	</c:forEach> 
	 	</tbody>
	</table>
</form>

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
	
	//게시판 환경설정
	function selectBoardStup(communityId)
	{
		var f = document.frm;
		f.action = "./write.do";
		f.communityId.value = communityId;
		f.submit();
	}
	
	//게시판 배너설정
	function selectBannerStup(communityId)
	{
		var f = document.frm;
		f.action = "./banner.do";
		f.communityId.value = communityId;
		f.submit();
	}
	
	//게시판 복사
	function setCopy(communityId)
	{
		if(confirm("해당 게시판을 복사하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./copy.do";
			f.communityId.value = communityId;
			f.submit();
		}
	}
</script>