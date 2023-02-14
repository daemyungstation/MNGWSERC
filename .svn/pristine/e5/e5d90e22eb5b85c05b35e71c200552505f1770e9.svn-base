<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>

<c:forEach var="list" items="${rtnMap.list}" varStatus="status">

<div role="tabpanel">
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation" class="<c:if test="${list.pntecDivision == 1}">active</c:if>"><a href="/mngwserc/pr-center/promotion/1/config.do">2019.07 테스트</a></li>
		<li role="presentation" class="<c:if test="${list.pntecDivision == 2}">active</c:if>"><a href="/mngwserc/pr-center/promotion/2/config.do">2019.08 오전</a></li>
		<li role="presentation" class="<c:if test="${list.pntecDivision == 3}">active</c:if>"><a href="/mngwserc/pr-center/promotion/3/config.do">2019.08 오후</a></li>
	</ul>
</div>
<form name="naverFrm" method="post" action ="./action.do">
<input type="hidden" name="PNTEC_DIVISION" value="${list.pntecDivision}">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">네이버 실검 프로모센 설정 관리</caption>
		<tr>
			<th colspan="2" style="text-align:left; padding-left:20px;">
				<c:choose>
					<c:when test = "${list.pntecDivision == 1}">
						네이버 실시간 검색 프로모션 - 7월 테스트
					</c:when>
					<c:when test = "${list.pntecDivision == 2}">
						네이버 실시간 검색 프로모션 - 8월 오전 
					</c:when>
					<c:when test = "${list.pntecDivision == 3}">
						네이버 실시간 검색 프로모션 - 8월 오후 
					</c:when>
				</c:choose>
			</th>
		</tr>
  		<tr>
		    <th width="20%">시작시간</th>
		    <td width="80%">
		    	<input type="date" name="PNTEC_SDAY" value="${list.pntecStimeDay}">
		    	
		    	<select name="PNTEC_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${list.pntecStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${list.pntecStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="PNTEC_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${list.pntecStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${list.pntecStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="PNTEC_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${list.pntecStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${list.pntecStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">마감시간</th>
		    <td width="80%">
		    	<input type="date" name="PNTEC_EDAY" value="${list.pntecEtimeDay}">
		    	
		    	<select name="PNTEC_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${list.pntecEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${list.pntecEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="PNTEC_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${list.pntecEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${list.pntecEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="PNTEC_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${list.pntecEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${list.pntecEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">네이버검색URL 체크</th>
		    <td width="80%">
		    	<input type="radio" name="PNTEC_NAVER_CHECK" value="Y" <c:if test="${list.pntecNaverCheck eq 'Y'}">checked</c:if>> 사용
		    	<input type="radio" name="PNTEC_NAVER_CHECK" value="N" <c:if test="${list.pntecNaverCheck eq 'N'}">checked</c:if>> 미사용
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">네이버검색 FROMURL 체크</th>
		    <td width="80%">
		    	<input type="radio" name="PNTEC_FROMURL_CHECK" value="Y" <c:if test="${list.pntecFromurlCheck eq 'Y'}">checked</c:if>> 사용
		    	<input type="radio" name="PNTEC_FROMURL_CHECK" value="N" <c:if test="${list.pntecFromurlCheck eq 'N'}">checked</c:if>> 미사용
		    </td>
  		</tr>
	</table>
	<div style="text-align:center;">
		<a class="btn btn-success" onclick="javascript:chkFormNaver();">저장</a>
	</div>
</form>
</c:forEach>

<script>
//등록하기
	function chkFormNaver()
	{
		var f = document.naverFrm;
		
		if(f.PNTEC_SDAY.value == "") {
			alert("시작일을 선택해주세요.");
			f.PNTEC_SDAY.focus();
			return;
		}
		if(f.PNTEC_SHH.value == "") {
			alert("시작시간(시)을 선택해주세요.");
			f.PNTEC_SHH.focus();
			return;
		}
		if(f.PNTEC_SMM.value == "") {
			alert("시작시간(분)을 선택해주세요.");
			f.PNTEC_SMM.focus();
			return;
		}
		if(f.PNTEC_SSS.value == "") {
			alert("시작시간(초)을 선택해주세요.");
			f.PNTEC_SSS.focus();
			return;
		}
		
		if(f.PNTEC_EDAY.value == "") {
			alert("마감일을 선택해주세요.");
			f.PNTEC_EDAY.focus();
			return;
		}
		if(f.PNTEC_EHH.value == "") {
			alert("마감시간(시)을 선택해주세요.");
			f.PNTEC_EHH.focus();
			return;
		}
		if(f.PNTEC_EMM.value == "") {
			alert("마감시간(분)을 선택해주세요.");
			f.PNTEC_EMM.focus();
			return;
		}
		if(f.PNTEC_ESS.value == "") {
			alert("마감시간(초)을 선택해주세요.");
			f.PNTEC_ESS.focus();
			return;
		}
		if(f.PNTEC_NAVER_CHECK[0].checked == false && f.PNTEC_NAVER_CHECK[1].checked == false) {
			alert("네이버검색 URL 체크를 선택해주세요.");
			f.PNTEC_NAVER_CHECK[0].focus();
			return;
		}
		if(f.PNTEC_FROMURL_CHECK[0].checked == false && f.PNTEC_FROMURL_CHECK[1].checked == false) {
			alert("네이버검색 URL 체크를 선택해주세요.");
			f.PNTEC_FROMURL_CHECK[0].focus();
			return;
		}
		
		f.submit();
	}
	</script>