<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<table class="table table-bordered table-hover sorttable">
 	<thead>
  		<tr>
		    <th width="15%">상담원</th>
		    <th width="10%">상담차수</th>
		    <th width="10%">상담상태</th>
		    <th width="35%">메모</th>
		    <th width="20%">등록일</th>
		    <th width="10%">삭제</th>
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
	</tbody>
	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		<tr>
	    <td style="text-align:center;">${list.fupcName}</td>
	    <td style="text-align:center;">${list.fupcStatusNumber}</td>
	    <td style="text-align:center;">${list.fupcStatus}</td>
	    <td style="text-align:left;">${list.fupcMemo}</td>
	    <td style="text-align:center;">${list.regDtm}</td>
	    
	    <td style="text-align:center;">
	    	<a href="javascript:memo_delete('${list.fupcSeq}');" class="btn btn-danger btn-xs">삭제</a>
    	</td>
  	</tr>
	</c:forEach>

 </table>