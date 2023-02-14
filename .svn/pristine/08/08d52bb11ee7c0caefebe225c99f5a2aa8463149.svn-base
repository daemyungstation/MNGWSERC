<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<script src="/common/js/jquery.minicolors.js"></script>
<link rel="stylesheet" href="/common/css/jquery.minicolors.css">

<style>
input[type="radio"], input[type="checkbox"] { margin: 0; }
label { display:inline-block; }

#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }

.minicolors-theme-bootstrap .minicolors-swatch { top: 0; left: 0; }
</style>

<h6>대명아임레디 박람회 - 제품 카테고리 등록/수정</h6>

<form id="fairFrm" name="fairFrm" action ="./action.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${rtnMap.fcSeq}" class="form-control">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">대명아임레디 박람회 -제품 카테고리 등록/수정</caption>
		
		<tr id="IMG_W">
			<th style="text-align:center; vertical-align:middle;">
				* PC 이미지
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FC_IMAGE_W" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fcImageWSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fcImageWPath }" data-save="${ rtnMap.fcImageWSaveNm }">&nbsp;[${rtnMap.fcImageWRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 260px 권장, height: 180px 권장
			</td>
		</tr>
		
		<tr id="IMG_M">
			<th style="text-align:center; vertical-align:middle;">
				* 모바일 이미지
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FC_IMAGE_M" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fcImageMSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fcImageMPath }" data-save="${ rtnMap.fcImageMSaveNm }">&nbsp;[${rtnMap.fcImageMRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 90px 권장, height: 90px 권장
			</td>
		</tr>
		
		<tr>
		    <th width="20%">* 제목</th>
		    <td width="80%">
		    	<input type="text" name="FC_TITLE" value="${ rtnMap.fcTitle }" class="form-control">
		    </td>
  		</tr>
  		
  		
		<tr>
		    <th width="20%">* 설명</th>
		    <td width="80%">
		    	<textarea name="FC_SUBTITLE" class="form-control">${rtnMap.fcSubtitle}</textarea>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 메인 카테고리내 제목</th>
		    <td width="80%">
		    	<input type="text" name="FC_CATEGORY_TITLE" value="${ rtnMap.fcCategoryTitle }"class="form-contro">
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 메인 카테고리내 글자색</th>
		    <td width="80%">
		    	<input type="text" name="FC_CATEGORY_TITLE_COLOR" value="${ rtnMap.fcCategoryTitleColor }"class="form-control minicolor" data-control="wheel">
		    </td>
  		</tr>
  		
		<tr>
		    <th width="20%">* 메인 카테고리 배경색</th>
		    <td width="80%">
		    	<input type="text" name="FC_BGCOLOR" value="${ rtnMap.fcBgcolor }"class="form-control minicolor" data-control="wheel"> ex) #ffffff
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 메인 롤링 갯수</th>
		    <td width="80%">
		    	<input type="number" name="FC_MAIN_MAX_COUNT" value="${ rtnMap.fcMainMaxCount }"class="form-control">
		    </td>
  		</tr>
  		
   		<tr>
		    <th width="20%">* 활성화</th>
		    <td width="80%">
		    	<label><input type="radio" name="FC_STATUS" value="Y" <c:if test="${rtnMap.fcStatus eq 'Y'}">checked</c:if>> 사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FC_STATUS" value="N" <c:if test="${rtnMap.fcStatus eq 'N'}">checked</c:if>> 미사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FC_STATUS" value="A" <c:if test="${rtnMap.fcStatus eq 'A'}">checked</c:if>> 상시사용(기간영향X)</label>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 시작시간</th>
		    <td width="80%">
		    	<input type="date" name="FC_SDAY" value="${rtnMap.fcStimeDay}">
		    	
		    	<select name="FC_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FC_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FC_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 마감시간</th>
		    <td width="80%">
		    	<input type="date" name="FC_EDAY" value="${rtnMap.fcEtimeDay}">
		    	
		    	<select name="FC_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FC_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FC_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fcEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fcEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
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
		
		<c:if test="${rtnMap.fcImageWSaveNm eq null}">
		if(f.FC_IMAGE_W.value == "") {
			alert("PC용 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		<c:if test="${rtnMap.fcImageMSaveNm eq null}">
		if(f.FC_IMAGE_M.value == "") {
			alert("모바일용 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		if(f.FC_TITLE.value == "") {
			alert("제목을 입력해주세요.");
			f.FC_TITLE.focus();
			return;
		}
		
		if(f.FC_SUBTITLE.value == "") {
			alert("설명을 입력해주세요.");
			f.FC_SUBTITLE.focus();
			return;
		}
		
		if(f.FC_CATEGORY_TITLE.value == "") {
			alert("메인 제품 상세 부분의 최상단 제목을 입력해주세요.");
			f.FC_CATEGORY_TITLE.focus();
			return;
		}
		
		if(f.FC_BGCOLOR.value == "") {
			alert("배경색을 선택해주세요.");
			return;
		}
		
		if(f.FC_MAIN_MAX_COUNT.value == "") {
			alert("메인 제품 상세 부분의 최대 롤링 갯수를 선택해주세요.");
			f.FC_MAIN_MAX_COUNT.focus();
			return;
		}
		
		if(f.FC_STATUS[0].checked == false && f.FC_STATUS[1].checked == false && f.FC_STATUS[2].checked == false) {
			alert("활성화 여부를 선택해주세요.");
			f.FC_STATUS[0].focus();
			return;
		}
		
		if(f.FC_STATUS[0].checked == true) {
			if(f.FC_SDAY.value == "") {
				alert("시작일을 선택해주세요.");
				f.FC_SDAY.focus();
				return;
			}
			if(f.FC_SHH.value == "") {
				alert("시작시간(시)을 선택해주세요.");
				f.FC_SHH.focus();
				return;
			}
			if(f.FC_SMM.value == "") {
				alert("시작시간(분)을 선택해주세요.");
				f.FC_SMM.focus();
				return;
			}
			if(f.FC_SSS.value == "") {
				alert("시작시간(초)을 선택해주세요.");
				f.FC_SSS.focus();
				return;
			}
			
			if(f.FC_EDAY.value == "") {
				alert("마감일을 선택해주세요.");
				f.FC_EDAY.focus();
				return;
			}
			if(f.FC_EHH.value == "") {
				alert("마감시간(시)을 선택해주세요.");
				f.FC_EHH.focus();
				return;
			}
			if(f.FC_EMM.value == "") {
				alert("마감시간(분)을 선택해주세요.");
				f.FC_EMM.focus();
				return;
			}
			if(f.FC_ESS.value == "") {
				alert("마감시간(초)을 선택해주세요.");
				f.FC_ESS.focus();
				return;
			}
		}
		
		f.submit();
	}
	
	jQuery(document).ready(function(){
		imagePreview();
		
		jQuery(".minicolor").minicolors({
	      control: jQuery(this).attr('data-control') || 'hue',
	      defaultValue: jQuery(this).attr('data-defaultValue') || '',
	      format: jQuery(this).attr('data-format') || 'hex',
	      keywords: jQuery(this).attr('data-keywords') || '',
	      inline: jQuery(this).attr('data-inline') === 'true',
	      letterCase: jQuery(this).attr('data-letterCase') || 'lowercase',
	      opacity: jQuery(this).attr('data-opacity'),
	      position: jQuery(this).attr('data-position') || 'bottom',
	      swatches: jQuery(this).attr('data-swatches') ? jQuery(this).attr('data-swatches').split('|') : [],
	      change: function(value, opacity) {
	        if( !value ) return;
	        if( opacity ) value += ', ' + opacity;
	        if( typeof console === 'object' ) {
	          console.log(value);
	        }
	      },
	      theme: 'bootstrap'
	    });
	
		jQuery("input[name='FC_IMAGE_W'], input[name='FC_IMAGE_M']").change(function(){
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