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

<h6>대명아임레디 박람회 - 제품 결합상품 등록/수정</h6>

<form id="fairFrm" name="fairFrm" action ="./action.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${rtnMap.fbSeq}" class="form-control">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">대명아임레디 박람회 -제품 결합상품 등록/수정</caption>
		
		<tr id="IMG_W">
			<th style="text-align:center; vertical-align:middle;">
				* 이미지
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FB_IMAGE_W" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fbImageWSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fbImageWPath }" data-save="${ rtnMap.fbImageWSaveNm }">&nbsp;[${rtnMap.fbImageWRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 20px, height: 20px
			</td>
		</tr>
		<!--  
		<tr id="IMG_M">
			<th style="text-align:center; vertical-align:middle;">
				* 모바일 이미지
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FB_IMAGE_M" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fbImageMSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fbImageMPath }" data-save="${ rtnMap.fbImageMSaveNm }">&nbsp;[${rtnMap.fbImageMRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 20px, height: 20px
			</td>
		</tr>
		-->
		<tr>
		    <th width="20%">* 브랜드</th>
		    <td width="80%">
		    	<input type="text" name="FB_TITLE" value="${ rtnMap.fbTitle }" class="form-control">
		    </td>
  		</tr>
  		
		<tr>
		    <th width="20%">상품명</th>
		    <td width="80%">
		    	<input type="text" name="FB_SUBTITLE" value="${ rtnMap.fbSubtitle }" class="form-control">
		    </td>
  		</tr>
  		
		<tr>
		    <th width="20%">모델명</th>
		    <td width="80%">
		    	<input type="text" name="FB_MODEL" value="${ rtnMap.fbModel }" class="form-control">
		    </td>
  		</tr>
  		
		<tr>
		    <th width="20%">가격</th>
		    <td width="80%">
		    	<input type="text" name="FB_PRICE" value="${ rtnMap.fbPrice }" class="form-control">
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">유저타겟</th>
		    <td width="80%">
		    	<input type="text" name="FB_USER_TARGET" value="${ rtnMap.fbUserTarget }"class="form-contro">
		    </td>
  		</tr>
  		
		<tr>
		    <th width="20%">제품타겟</th>
		    <td width="80%">
		    	<input type="text" name="FB_PRODUCT_TARGET" value="${ rtnMap.fbProductTarget }"class="form-control">
		    </td>
  		</tr>
  		
   		<tr>
		    <th width="20%">* 활성화</th>
		    <td width="80%">
		    	<label><input type="radio" name="FB_STATUS" value="Y" <c:if test="${rtnMap.fbStatus eq 'Y'}">checked</c:if>> 사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FB_STATUS" value="N" <c:if test="${rtnMap.fbStatus eq 'N'}">checked</c:if>> 미사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FB_STATUS" value="A" <c:if test="${rtnMap.fbStatus eq 'A'}">checked</c:if>> 상시사용(기간영향X)</label>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 시작시간</th>
		    <td width="80%">
		    	<input type="date" name="FB_SDAY" value="${rtnMap.fbStimeDay}">
		    	
		    	<select name="FB_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fbStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fbStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FB_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fbStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fbStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FB_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fbStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fbStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 마감시간</th>
		    <td width="80%">
		    	<input type="date" name="FB_EDAY" value="${rtnMap.fbEtimeDay}">
		    	
		    	<select name="FB_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fbEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fbEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FB_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fbEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fbEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FB_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fbEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fbEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
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
		
		<c:if test="${rtnMap.fbImageWSaveNm eq null}">
		if(f.FB_IMAGE_W.value == "") {
			alert("이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		/* 
		<c:if test="${rtnMap.fbImageMSaveNm eq null}">
		if(f.FB_IMAGE_M.value == "") {
			alert("모바일용 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		 */
		if(f.FB_TITLE.value == "") {
			alert("제목을 입력해주세요.");
			f.FB_TITLE.focus();
			return;
		}
		
		if(f.FB_STATUS[0].checked == false && f.FB_STATUS[1].checked == false && f.FB_STATUS[2].checked == false) {
			alert("활성화 여부를 선택해주세요.");
			f.FB_STATUS[0].focus();
			return;
		}
		
		if(f.FB_STATUS[0].checked == true) {
			if(f.FB_SDAY.value == "") {
				alert("시작일을 선택해주세요.");
				f.FB_SDAY.focus();
				return;
			}
			if(f.FB_SHH.value == "") {
				alert("시작시간(시)을 선택해주세요.");
				f.FB_SHH.focus();
				return;
			}
			if(f.FB_SMM.value == "") {
				alert("시작시간(분)을 선택해주세요.");
				f.FB_SMM.focus();
				return;
			}
			if(f.FB_SSS.value == "") {
				alert("시작시간(초)을 선택해주세요.");
				f.FB_SSS.focus();
				return;
			}
			
			if(f.FB_EDAY.value == "") {
				alert("마감일을 선택해주세요.");
				f.FB_EDAY.focus();
				return;
			}
			if(f.FB_EHH.value == "") {
				alert("마감시간(시)을 선택해주세요.");
				f.FB_EHH.focus();
				return;
			}
			if(f.FB_EMM.value == "") {
				alert("마감시간(분)을 선택해주세요.");
				f.FB_EMM.focus();
				return;
			}
			if(f.FB_ESS.value == "") {
				alert("마감시간(초)을 선택해주세요.");
				f.FB_ESS.focus();
				return;
			}
		}
		
		f.submit();
	}
	
	jQuery(document).ready(function(){
		imagePreview();
		
		jQuery("input[name='FB_IMAGE_W'], input[name='FB_IMAGE_M']").change(function(){
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