<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
input[type="radio"], input[type="checkbox"] { margin: 0; }
label { display:inline-block; }

#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }
</style>

<h6>대명아임레디 박람회 - 이벤트 등록/수정</h6>

<form id="fairFrm" name="fairFrm" action ="./action.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${rtnMap.feSeq}" class="form-control">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">대명아임레디 박람회 -이벤트 등록/수정</caption>
		
		<tr>
		    <th width="20%">* 이벤트 타입</th>
		    <td width="80%">
		    	<label><input type="radio" name="FE_TYPE" value="1" <c:if test="${rtnMap.feType eq '1' or rtnMap.feType eq null}">checked</c:if>> 1개</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_TYPE" value="2" <c:if test="${rtnMap.feType eq '2'}">checked</c:if>> 2개</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_TYPE" value="3" <c:if test="${rtnMap.feType eq '3'}">checked</c:if>> 3개</label>
		    </td>
  		</tr>
  		
		<tr id="IMG_1_W">
			<th style="text-align:center; vertical-align:middle;">
				* PC 이미지 1
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FE_IMAGE_1_W" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.feImage1WSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.feImage1WPath }" data-save="${ rtnMap.feImage1WSaveNm }">&nbsp;[${rtnMap.feImage1WRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 550px 권장, height: 300px 권장
			</td>
		</tr>
		
		<tr id="IMG_1_M">
			<th style="text-align:center; vertical-align:middle;">
				* 모바일 이미지 1
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FE_IMAGE_1_M" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.feImage1MSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.feImage1MPath }" data-save="${ rtnMap.feImage1MSaveNm }">&nbsp;[${rtnMap.feImage1MRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 335px 권장, height: 300px 권장
			</td>
		</tr>
		
		<tr id="LINK_1">
		    <th width="20%">* 링크 1</th>
		    <td width="80%">
		    	<input type="text" name="FE_LINK_1" value="${ rtnMap.feLink1 }" class="form-control">
		    </td>
  		</tr>
  		
		<tr id="LINK_1_TYPE">
		    <th width="20%">* 링크 1 타입</th>
		    <td width="80%">
		    	<label><input type="radio" name="FE_LINK_1_TYPE" value="_self" <c:if test="${rtnMap.feLink1Type eq '_self'}">checked</c:if>> 이동</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_LINK_1_TYPE" value="_blank" <c:if test="${rtnMap.feLink1Type eq '_blank'}">checked</c:if>> 새창</label>
		    </td>
  		</tr>
		
		<tr id="IMG_2_W">
			<th style="text-align:center; vertical-align:middle;">
				PC 이미지 2
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FE_IMAGE_2_W" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.feImage2WSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.feImage2WPath }" data-save="${ rtnMap.feImage2WSaveNm }">&nbsp;[${rtnMap.feImage2WRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 240px 권장, height: 300px 권장
			</td>
		</tr>
		
		<tr id="IMG_2_M">
			<th style="text-align:center; vertical-align:middle;">
				모바일 이미지 2
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FE_IMAGE_2_M" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.feImage2MSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.feImage2MPath }" data-save="${ rtnMap.feImage2MSaveNm }">&nbsp;[${rtnMap.feImage2MRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 240px 권장, height: 300px 권장
			</td>
		</tr>
		
		<tr id="LINK_2">
		    <th width="20%">* 링크 2</th>
		    <td width="80%">
		    	<input type="text" name="FE_LINK_2" value="${ rtnMap.feLink2 }" class="form-control">
		    </td>
  		</tr>
  		
		<tr id="LINK_2_TYPE">
		    <th width="20%">* 링크 2 타입</th>
		    <td width="80%">
		    	<label><input type="radio" name="FE_LINK_2_TYPE" value="_self" <c:if test="${rtnMap.feLink2Type eq '_self'}">checked</c:if>> 이동</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_LINK_2_TYPE" value="_blank" <c:if test="${rtnMap.feLink2Type eq '_blank'}">checked</c:if>> 새창</label>
		    </td>
  		</tr>
		
		<tr id="IMG_3_W">
			<th style="text-align:center; vertical-align:middle;">
				PC 이미지 3
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FE_IMAGE_3_W" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.feImage3WSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.feImage3WPath }" data-save="${ rtnMap.feImage3WSaveNm }">&nbsp;[${rtnMap.feImage3WRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 240px 권장, height: 300px 권장
			</td>
		</tr>
		
		<tr id="IMG_3_M">
			<th style="text-align:center; vertical-align:middle;">
				모바일 이미지 3
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FE_IMAGE_3_M" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.feImage3MSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.feImage3MPath }" data-save="${ rtnMap.feImage3MSaveNm }">&nbsp;[${rtnMap.feImage3MRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 240px 권장, height: 300px 권장
			</td>
		</tr>
		
		<tr id="LINK_3">
		    <th width="20%">* 링크 3</th>
		    <td width="80%">
		    	<input type="text" name="FE_LINK_3" value="${ rtnMap.feLink3 }" class="form-control">
		    </td>
  		</tr>
  		
		<tr id="LINK_3_TYPE">
		    <th width="20%">* 링크 3 타입</th>
		    <td width="80%">
		    	<label><input type="radio" name="FE_LINK_3_TYPE" value="_self" <c:if test="${rtnMap.feLink3Type eq '_self'}">checked</c:if>> 이동</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_LINK_3_TYPE" value="_blank" <c:if test="${rtnMap.feLink3Type eq '_blank'}">checked</c:if>> 새창</label>
		    </td>
  		</tr>
  		
   		<tr>
		    <th width="20%">* 활성화</th>
		    <td width="80%">
		    	<label><input type="radio" name="FE_STATUS" value="Y" <c:if test="${rtnMap.feStatus eq 'Y'}">checked</c:if>> 사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_STATUS" value="N" <c:if test="${rtnMap.feStatus eq 'N'}">checked</c:if>> 미사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FE_STATUS" value="A" <c:if test="${rtnMap.feStatus eq 'A'}">checked</c:if>> 상시사용(기간영향X)</label>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 시작시간</th>
		    <td width="80%">
		    	<input type="date" name="FE_SDAY" value="${rtnMap.feStimeDay}">
		    	
		    	<select name="FE_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.feStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.feStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FE_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.feStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.feStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FE_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.feStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.feStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 마감시간</th>
		    <td width="80%">
		    	<input type="date" name="FE_EDAY" value="${rtnMap.feEtimeDay}">
		    	
		    	<select name="FE_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.feEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.feEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FE_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.feEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.feEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FE_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.feEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.feEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
	</table>
	<div style="text-align:center;">
		<a class="btn btn-default" href="./index.do">목록</a>
		<a class="btn btn-success" onclick="javascript:chkFormFair();">저장</a>
	</div>
</form>

<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<button type="button" onclick="preview_close()" class="btn btn-success btn-sm mb-1">닫기</button>
		<div>
			<img src="" />
		</div>
	</div>
</div>
<!-- // 미리보기 -->

<script>
//등록하기
	function chkFormFair()
	{
		var f = document.fairFrm;
		
		if(f.FE_TYPE[0].checked == false && f.FE_TYPE[1].checked == false && f.FE_TYPE[2].checked == false) {
			alert("타입을 선택해주세요.");
			f.FE_TYPE[0].focus();
			return;
		}
		
		if(f.FE_TYPE[0].checked == true) {
			<c:if test="${rtnMap.feImage1WSaveNm eq null}">
			if(f.FE_IMAGE_1_W.value == "") {
				alert("PC용 이미지 1을 선택해주세요.");
				return;
			}
			</c:if>
			
			<c:if test="${rtnMap.feImage1MSaveNm eq null}">
			if(f.FE_IMAGE_1_M.value == "") {
				alert("모바일용 이미지 1을 선택해주세요.");
				return;
			}
			</c:if>
			if(f.FE_LINK_1.value == "") {
				alert("링크 1을 입력해주세요.");
				f.FE_LINK_1.focus();
				return;
			}
			
			if(f.FE_LINK_1_TYPE[0].checked == false && f.FE_LINK_1_TYPE[1].checked == false) {
				alert("링크 1 타입을 선택해주세요.");
				f.FE_LINK_1_TYPE[0].focus();
				return;
			}
		}
		
		if(f.FE_TYPE[1].checked == true) {
			<c:if test="${rtnMap.feImage2WSaveNm eq null}">
			if(f.FE_IMAGE_2_W.value == "") {
				alert("PC용 이미지 1을 선택해주세요.");
				return;
			}
			</c:if>
			if(f.FE_LINK_2.value == "") {
				alert("링크 2을 입력해주세요.");
				f.FE_LINK_2.focus();
				return;
			}
			
			if(f.FE_LINK_2_TYPE[0].checked == false && f.FE_LINK_2_TYPE[1].checked == false) {
				alert("링크 2 타입을 선택해주세요.");
				f.FE_LINK_2_TYPE[0].focus();
				return;
			}
		}
		
		if(f.FE_TYPE[2].checked == true) {
			<c:if test="${rtnMap.feImage3WSaveNm eq null}">
			if(f.FE_IMAGE_3_W.value == "") {
				alert("PC용 이미지 1을 선택해주세요.");
				return;
			}
			</c:if>
			if(f.FE_LINK_3.value == "") {
				alert("링크 3을 입력해주세요.");
				f.FE_LINK_3.focus();
				return;
			}
			
			if(f.FE_LINK_3_TYPE[0].checked == false && f.FE_LINK_3_TYPE[1].checked == false) {
				alert("링크 3 타입을 선택해주세요.");
				f.FE_LINK_3_TYPE[0].focus();
				return;
			}
		}
		
		
		if(f.FE_STATUS[0].checked == false && f.FE_STATUS[1].checked == false && f.FE_STATUS[2].checked == false) {
			alert("활성화 여부를 선택해주세요.");
			f.FE_STATUS[0].focus();
			return;
		}
		
		if(f.FE_STATUS[0].checked == true) {
			if(f.FE_SDAY.value == "") {
				alert("시작일을 선택해주세요.");
				f.FE_SDAY.focus();
				return;
			}
			if(f.FE_SHH.value == "") {
				alert("시작시간(시)을 선택해주세요.");
				f.FE_SHH.focus();
				return;
			}
			if(f.FE_SMM.value == "") {
				alert("시작시간(분)을 선택해주세요.");
				f.FE_SMM.focus();
				return;
			}
			if(f.FE_SSS.value == "") {
				alert("시작시간(초)을 선택해주세요.");
				f.FE_SSS.focus();
				return;
			}
			
			if(f.FE_EDAY.value == "") {
				alert("마감일을 선택해주세요.");
				f.FE_EDAY.focus();
				return;
			}
			if(f.FE_EHH.value == "") {
				alert("마감시간(시)을 선택해주세요.");
				f.FE_EHH.focus();
				return;
			}
			if(f.FE_EMM.value == "") {
				alert("마감시간(분)을 선택해주세요.");
				f.FE_EMM.focus();
				return;
			}
			if(f.FE_ESS.value == "") {
				alert("마감시간(초)을 선택해주세요.");
				f.FE_ESS.focus();
				return;
			}
		}
		
		f.submit();
	}
	
	jQuery(document).ready(function(){
		imagePreview();
	
		jQuery("input[name='FE_IMAGE_1_W'], input[name='FE_IMAGE_1_M'], input[name='FE_IMAGE_2_W'], input[name='FE_IMAGE_2_M'], input[name='FE_IMAGE_3_W'], input[name='FE_IMAGE_3_M']").change(function(){
			var file = jQuery(this)[0].files[0];
			if(typeof file === 'undefined') {
				jQuery(this).closest("td").find(".file_name").text("");
				jQuery(this).closest("td").find(".btn_pop_preview").hide();
				return;
			}
			var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
			var fileNm = file.name.substring(0, file.name.lastIndexOf("."));
	
			jQuery(this).closest("td").find(".file_name").html("&nbsp;["+fileNm+"]");
			jQuery(this).closest("td").find(".btn_pop_preview").show();;		
		
			// 이미지 미리보기 버튼 클릭
			imagePreview();
		});
		
		var f = document.fairFrm;
		if(f.FE_TYPE[0].checked == true) {
			jQuery("#IMG_1_W").show();
			jQuery("#IMG_1_M").show();
			jQuery("#LINK_1").show();
			jQuery("#LINK_1_TYPE").show();
			jQuery("#IMG_2_W").hide();
			jQuery("#IMG_2_M").hide();
			jQuery("#LINK_2").hide();
			jQuery("#LINK_2_TYPE").hide();
			jQuery("#IMG_3_W").hide();
			jQuery("#IMG_3_M").hide();
			jQuery("#LINK_3").hide();
			jQuery("#LINK_3_TYPE").hide();
		}
		if(f.FE_TYPE[1].checked == true) {
			jQuery("#IMG_1_W").show();
			jQuery("#IMG_1_M").show();
			jQuery("#LINK_1").show();
			jQuery("#LINK_1_TYPE").show();
			jQuery("#IMG_2_W").show();
			jQuery("#IMG_2_M").show();
			jQuery("#LINK_2").show();
			jQuery("#LINK_2_TYPE").show();
			jQuery("#IMG_3_W").hide();
			jQuery("#IMG_3_M").hide();
			jQuery("#LINK_3").hide();
			jQuery("#LINK_3_TYPE").hide();
		}
		if(f.FE_TYPE[2].checked == true) {
			jQuery("#IMG_1_W").show();
			jQuery("#IMG_1_M").show();
			jQuery("#LINK_1").show();
			jQuery("#LINK_1_TYPE").show();
			jQuery("#IMG_2_W").show();
			jQuery("#IMG_2_M").show();
			jQuery("#LINK_2").show();
			jQuery("#LINK_2_TYPE").show();
			jQuery("#IMG_3_W").show();
			jQuery("#IMG_3_M").show();
			jQuery("#LINK_3").show();
			jQuery("#LINK_3_TYPE").show();
		}
	
		jQuery("input[name='FE_TYPE']").click(function(){
			if(f.FE_TYPE[0].checked == true) {
				jQuery("#IMG_1_W").show();
				jQuery("#IMG_1_M").show();
				jQuery("#LINK_1").show();
				jQuery("#LINK_1_TYPE").show();
				jQuery("#IMG_2_W").hide();
				jQuery("#IMG_2_M").hide();
				jQuery("#LINK_2").hide();
				jQuery("#LINK_2_TYPE").hide();
				jQuery("#IMG_3_W").hide();
				jQuery("#IMG_3_M").hide();
				jQuery("#LINK_3").hide();
				jQuery("#LINK_3_TYPE").hide();
			}
			if(f.FE_TYPE[1].checked == true) {
				jQuery("#IMG_1_W").show();
				jQuery("#IMG_1_M").show();
				jQuery("#LINK_1").show();
				jQuery("#LINK_1_TYPE").show();
				jQuery("#IMG_2_W").show();
				jQuery("#IMG_2_M").show();
				jQuery("#LINK_2").show();
				jQuery("#LINK_2_TYPE").show();
				jQuery("#IMG_3_W").hide();
				jQuery("#IMG_3_M").hide();
				jQuery("#LINK_3").hide();
				jQuery("#LINK_3_TYPE").hide();
			}
			if(f.FE_TYPE[2].checked == true) {
				jQuery("#IMG_1_W").show();
				jQuery("#IMG_1_M").show();
				jQuery("#LINK_1").show();
				jQuery("#LINK_1_TYPE").show();
				jQuery("#IMG_2_W").show();
				jQuery("#IMG_2_M").show();
				jQuery("#LINK_2").show();
				jQuery("#LINK_2_TYPE").show();
				jQuery("#IMG_3_W").show();
				jQuery("#IMG_3_M").show();
				jQuery("#LINK_3").show();
				jQuery("#LINK_3_TYPE").show();
			}
		});
	});

	function preview_close() {
		jQuery("#preview").css("display","none");
	};
	
	function imagePreview(){
		jQuery(".btn_pop_preview").off("click").on("click", function(){
			var select_file = jQuery(this).closest("td").find("input:file");
			if(select_file.val() != '') {
				var file = select_file[0].files[0];
				var reader = new FileReader();
				
		        reader.onload = function(event){
		        	jQuery("#preview").find("img").attr("src", event.target.result);
		        }
	            reader.readAsDataURL(file);
				jQuery("#preview").css("display","table");
				return;
			}else {
				var select_span = jQuery(this).closest("td").find(".file_name");
				if(select_span.data("path") != "" && select_span.data("save") != "") {
					var path = select_span.data("path");
			 		var save = select_span.data("save");
					var saveFile = save.split(".");		
				
					//jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=fair&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").css("display","table");
				}
			}
		});
	}
</script>