<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
input[type="radio"], input[type="checkbox"] { margin: 0; }
label { display:inline-block; }
</style>

<h6>대명아임레디 박람회 - 전체 설정</h6>

<form id="fairConfigFrm" name="fairConfigFrm">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">대명아임레디 박람회 - 전체설정</caption>
		<tr>
		    <th width="20%">타이틀</th>
		    <td width="80%">
		    	<input type="input" name="FCFG_TITLE" value="${rtnMap.fcfgTitle}" class="form-control">
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">D-DAY타이틀</th>
		    <td width="80%">
		    	<input type="input" name="FCFG_DDAY_TITLE" value="${rtnMap.fcfgDdayTitle}" class="form-control">
		    </td>
  		</tr>
   		<tr>
		    <th width="20%">활성화</th>
		    <td width="80%">
		    	<label><input type="radio" name="FCFG_STATUS" value="Y" <c:if test="${rtnMap.fcfgStatus eq 'Y'}">checked</c:if>> 사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FCFG_STATUS" value="N" <c:if test="${rtnMap.fcfgStatus eq 'N'}">checked</c:if>> 미사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FCFG_STATUS" value="A" <c:if test="${rtnMap.fcfgStatus eq 'A'}">checked</c:if>> 상시사용(기간영향X)</label>
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">시작시간</th>
		    <td width="80%">
		    	<input type="date" name="FCFG_SDAY" value="${rtnMap.fcfgStimeDay}">
		    	
		    	<select name="FCFG_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcfgStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcfgStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FCFG_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcfgStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcfgStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FCFG_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcfgStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcfgStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">마감시간</th>
		    <td width="80%">
		    	<input type="date" name="FCFG_EDAY" value="${rtnMap.fcfgEtimeDay}">
		    	
		    	<select name="FCFG_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcfgEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcfgEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FCFG_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcfgEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcfgEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FCFG_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcfgEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcfgEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
	</table>
	<div style="text-align:center;">
		<a class="btn btn-success" onclick="javascript:chkFormFairConfig();">저장</a>
	</div>
</form>


<script>
//등록하기
	function chkFormFairConfig()
	{
		var f = document.fairConfigFrm;
		
		if(f.FCFG_TITLE.value == "") {
			alert("타이틀을 입력해주세요.");
			f.FCFG_TITLE.focus();
			return;
		}
		
		if(f.FCFG_STATUS[0].checked == false && f.FCFG_STATUS[1].checked == false && f.FCFG_STATUS[2].checked == false) {
			alert("활성화 여부를 선택해주세요.");
			f.FCFG_STATUS[0].focus();
			return;
		}
		
		if(f.FCFG_STATUS[0].checked == true) {
			if(f.FCFG_SDAY.value == "") {
				alert("시작일을 선택해주세요.");
				f.FCFG_SDAY.focus();
				return;
			}
			if(f.FCFG_SHH.value == "") {
				alert("시작시간(시)을 선택해주세요.");
				f.FCFG_SHH.focus();
				return;
			}
			if(f.FCFG_SMM.value == "") {
				alert("시작시간(분)을 선택해주세요.");
				f.FCFG_SMM.focus();
				return;
			}
			if(f.FCFG_SSS.value == "") {
				alert("시작시간(초)을 선택해주세요.");
				f.FCFG_SSS.focus();
				return;
			}
			
			if(f.FCFG_EDAY.value == "") {
				alert("마감일을 선택해주세요.");
				f.FCFG_EDAY.focus();
				return;
			}
			if(f.FCFG_EHH.value == "") {
				alert("마감시간(시)을 선택해주세요.");
				f.FCFG_EHH.focus();
				return;
			}
			if(f.FCFG_EMM.value == "") {
				alert("마감시간(분)을 선택해주세요.");
				f.FCFG_EMM.focus();
				return;
			}
			if(f.FCFG_ESS.value == "") {
				alert("마감시간(초)을 선택해주세요.");
				f.FCFG_ESS.focus();
				return;
			}
		}
		
		var form = jQuery("#fairConfigFrm")[0];
		var form_data = new FormData(form);
		
		jQuery.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: './action.ajax',
            data: form_data,
            dataType: "json",
            processData: false,
            contentType: false,
            cache: false,
            beforeSend: function() {
            	
            },
            success: function (data) {
                if(data.result == "OK") {
                	alert("완료되었습니다.");
                }else {
                	alert("저장에 실패하였습니다.\n다시 시도해주세요.");
                }
            	document.location.reload();
            },
            error: function (e) {
                alert("ERROR : 저장에 실패하였습니다.\n다시 시도해주세요.", e);
                document.location.reload();
            },
            complete: function() {
            	
            }
        });
	}
</script>