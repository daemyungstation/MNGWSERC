<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COCAdmList.jsp
	프로그램 명 : 	관리자관리
	설명		: 	리스트
	작성자		: 	김대환
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				김대환				최초작성
	######################################################################
-->

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="admSeq" value="" />
	
	<div class="well well-small">
		계정상태 : 
		<select name="useYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.useYn eq 'Y'}">selected</c:if>>허용</option>
			<option value="N" <c:if test="${rtnMap.useYn eq 'N'}">selected</c:if>>차단</option>
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">관리자 관리</caption>
	 	<thead>
	  		<tr>
				<th width="8%">번호</th>
				<th width="34%">부서 (ROLE)</th>
	    		<th width="17%">이름</th>
	    		<th width="17%">아이디</th>
	    		<th width="16%">최종접속일</th>
	    		<th width="8%">계정상태</th>
	  		</tr>
	 	</thead>
	 	<tbody>
		 	<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="6" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
		    		<td style="text-align:center; cursor:pointer;" onclick="selectAdmDtl('${list.admSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
		    		</td>
		    		<td style="text-align:left; cursor:pointer;" onclick="selectAdmDtl('${list.admSeq}');">
						${list.roleNm}
		    		</td>
		    		<td style="text-align:left; cursor:pointer;" onclick="selectAdmDtl('${list.admSeq}');">
		    			${list.name}
		    		</td>
		    		<td style="text-align:left; cursor:pointer;" onclick="selectAdmDtl('${list.admSeq}');">
		    			${list.id}
		    		</td>
		    		<td style="text-align:center; cursor:pointer;" onclick="selectAdmDtl('${list.admSeq}');">
		    			${egov:convertDate(list.lastLgnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
		    		</td>
		    		<td style="text-align:center; cursor:pointer;" onclick="selectAdmDtl('${list.admSeq}');">
						${egov:decode(list.useYn, 'Y', '허용', '차단')}
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
	
	//상세 가져오기
	function selectAdmDtl(admSeq)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.admSeq.value = admSeq;
		f.submit();
	}
</script>