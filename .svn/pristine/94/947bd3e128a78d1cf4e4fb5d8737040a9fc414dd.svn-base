<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>

<table class="table">
	<tr>
		<th class="lt_text3" style="text-align:left; padding-left:20px;">
			<c:choose>
				<c:when test = "${ntevtDivision == 1}">
					네이버 실시간 검색 프로모션 - 7월 테스트
				</c:when>
				<c:when test = "${ntevtDivision == 2}">
					네이버 실시간 검색 프로모션 - 8월 오전 
				</c:when>
				<c:when test = "${ntevtDivision == 3}">
					네이버 실시간 검색 프로모션 - 8월 오후 
				</c:when>
			</c:choose>
		</th>
	</tr>
</table>

<h6>검색 : ${rtnMap.list[0].totCnt}건 <a href="./excel.do" class="btn btn-success small">엑셀다운</a> </h6>

<div role="tabpanel">
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation" class="<c:if test="${ntevtDivision == 1}">active</c:if>"><a href="/mngwserc/pr-center/promotion/1/index.do">2019.07 테스트</a></li>
		<li role="presentation" class="<c:if test="${ntevtDivision == 2}">active</c:if>"><a href="/mngwserc/pr-center/promotion/2/index.do">2019.08 오전</a></li>
		<li role="presentation" class="<c:if test="${ntevtDivision == 3}">active</c:if>"><a href="/mngwserc/pr-center/promotion/3/index.do">2019.08 오후</a></li>
	</ul>
</div>
<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">네이버 실검 프로모센 테스트 관리</caption>
	 	<thead>
	  		<tr>
			    <th width="5%">번호</th>
			    <th width="20%">이름</th>
			    <th width="20%">핸드폰</th>
			    <th width="5%">약관동의</th>
			    <th width="5%">마케팅동의</th>
			    <th width="10%">사용자ID</th>
			    <th width="10%">등록일</th>
			    <th width="10%">등록IP</th>
			    <th width="10%">FROMURL</th>
	  		</tr>
	 	</thead>
	 	<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="9" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
				    <td style="text-align:center;">
				   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
				   	</td>
				    <td style="text-align:center;">
				    	${ list.ntevtName }
				    </td>
				    <td style="text-align:center;">
				    	${ list.ntevtPhone }
				    </td>
				    <td style="text-align:center;">
				    	${ list.tnevtAgree }
				    </td>
				    <td style="text-align:center;">
				    	${list.ntevtMarketingAgree}
				    </td>
				    <td style="text-align:center;">
				    	${list.ntevtUserid}
			    	</td>
			    	<td style="text-align:center;">
				    	${list.ntevtRegDtmDay}
			    	</td>
			    	<td style="text-align:center;">
				    	${list.ntevtRegIp}
			    	</td>
			    	<td style="text-align:center;">
				    	${list.ntevtFromurl}
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
</script>