<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--
	######################################################################
	파일명 		:	COFLogList.jsp
	프로그램 명 : 	로그관리
	설명		: 	리스트
	작성자		: 	김대환
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				김대환				최초작성
	######################################################################
 --> 
 
<form name="frm" action ="${pageLink}" method="post">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		구분 : 
		<select name="prcsCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.systemLog}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${rtnMap.strtDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${rtnMap.endDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">시스템 로그 조회</caption>
	 	<thead>
		  	<tr>
			    <th width="8%">번호</th>	    
			    <th width="40%">페이지</th>
			    <th width="8%">구분</th>
			    <th width="10%">IP</th>
			    <th width="10%">이름</th>
			    <th width="10%">아이디</th>
			    <th width="14%">발생일자</th>
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
		   			<td style="text-align:center;">
		   				${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
		   			</td>
				    <td style="text-align:left;">
				    	${list.trgtMenuNm}
				    </td>
				    <td style="text-align:center; font-weight:bold; color:${egov:decode(result.prcsCd, 'D', 'red', egov:decode(list.prcsCd, 'U', 'blue', egov:decode(list.prcsCd, 'C', 'green', egov:decode(list.prcsCd, 'X', 'brown', 'black'))))}">
				    	${list.prcsNm}
				    </td>
				    <td style="text-align:center;">
				    	${list.reqnIp}
				    </td>
				    <td style="text-align:left;">
				    	${list.reqnNm}
				    </td>
				    <td style="text-align:left;">
				    	${list.reqnId}
				    </td>
				    <td style="text-align:center;">
				    	${egov:convertDate(list.occrDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}
				    </td>
		  		</tr>
		 	</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:selectSysLogExcelList();" class="btn btn-info">엑셀 다운로드</a>
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
	
	//엑셀 다운로드
	function selectSysLogExcelList()
	{	
		var f = document.frm;
		
		f.action = "./excel.do";
		f.submit();
	}
</script>