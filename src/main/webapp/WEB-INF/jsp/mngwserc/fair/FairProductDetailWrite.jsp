<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
input[type="radio"], input[type="checkbox"] { margin: 0; }
label { display:inline-block; }

a.btn { color: #ffffff !important; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }

#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }
.modal.fade { top:-100%; }

.list_sort { margin:0; }
.list_sort li { list-style:none; background:#ffffff !important; color:inherit !important; border:none !important; font-weight:normal !important; }

.minicolors-theme-bootstrap .minicolors-swatch { top: 0 !important; left: 0 !important; }

.daterangepicker .drp-calendar { max-width: 350px !important; }

ul.tagit { margin-top: 5px; min-height: 20px; }
ul.tagit input { display:none; }
.ui-widget { font-size:0.9em; }
</style>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tag-it/2.0/js/tag-it.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/tag-it/2.0/css/jquery.tagit.min.css" />

<script src="/common/js/jquery.minicolors.js"></script>
<link rel="stylesheet" href="/common/css/jquery.minicolors.css">

<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-ui-multidatespicker@1.6.6/jquery-ui.multidatespicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/jquery-ui-multidatespicker@1.6.6/jquery-ui.multidatespicker.min.css" />

<h6>대명아임레디 박람회 - 제품 상세 등록/수정</h6>

<form id="fairFrm" name="fairFrm" action ="./action.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${rtnMap.fpSeq}" class="form-control">
	<input type="hidden" name="price_type" value="G" class="form-control">
	<table class="table table-bordered">
		<caption style="display: none;">대명아임레디 박람회 -제품 상세 등록</caption>
		
		<tr>
		    <th width="20%">* 카테고리</th>
		    <td width="80%">
		    	<select name="FAIR_CATEGORY_FC_SEQ">
		    		<option value="">카테고리 선택</option>
		    		<c:forEach var="list" items="${rtnMap.cateList}" varStatus="status">
		    		<option value="${ list.fcSeq }" <c:if test="${rtnMap.fairCategoryFcSeq eq list.fcSeq}">selected</c:if>>${ list.fcTitle }</option>
		    		</c:forEach>
		    	</select>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 입력폼 설정</th>
		    <td width="80%">
		    	<input type="hidden" name="FP_INPUT">
				<button type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#inputModal">선택</button>
		    	<div id="FP_INPUT_FORM"></div>
		    </td>
  		</tr>
  		
		<tr id="IMG_MAIN_BG">
			<th style="text-align:center; vertical-align:middle;">
				* 배경 이미지 (메인)
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FP_MAIN_IMAGE_BG" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fpMainImageBgSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fpMainImageBgPath }" data-save="${ rtnMap.fpMainImageBgSaveNm }">&nbsp;[${rtnMap.fpMainImageBgRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 1920px 이상, height: free (700px 권장)
			</td>
		</tr>
		
		<tr id="IMG_MAIN_W">
			<th style="text-align:center; vertical-align:middle;">
				* PC 이미지 (메인)
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FP_MAIN_IMAGE_W" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fpMainImageWSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fpMainImageWPath }" data-save="${ rtnMap.fpMainImageWSaveNm }">&nbsp;[${rtnMap.fpMainImageWRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 1080px 이하, height: free (385px 권장, 배경높이보다 작을것)
			</td>
		</tr>
		
		<tr id="IMG_MAIN_M">
			<th style="text-align:center; vertical-align:middle;">
				* 모바일 이미지 (메인)
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FP_MAIN_IMAGE_M" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.fpMainImageMSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.fpMainImageMPath }" data-save="${ rtnMap.fpMainImageMSaveNm }">&nbsp;[${rtnMap.fpMainImageMRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 560px 권장, height: 500px 권장
			</td>
		</tr>
		
		<tr>
		    <th width="20%">* 썸네일</th>
		    <td width="80%">
		    	<div>
		    		<button type="button" class="btn btn-success btn-xs" onclick="javascript:fp_thumnail_add();">추가</button>
		    		* 드래그앤 드롭으로 순서 변경<br>(PC - width: 380px, height: 460px)(모바일 - width: 550px, height: 350px)
		    	</div>
		    	<table class="table table-bordered" style="margin-top:0;margin-bottom:0;">
					<tr>
						<th width="45%">PC용</th>
						<th width="45%">모바일</th>
						<th width="10%">관리</th>
					</tr>
				</table>
		    	<ul class="list_sort" id="FP_THUMNAIL">
		    	</ul>
		    </td>
  		</tr>
  		
		<tr>
		    <th width="20%">* 제목</th>
		    <td width="80%">
		    	<input type="text" name="FP_MAIN_TITLE" value="${ rtnMap.fpMainTitle }" class="form-control">
		    </td>
  		</tr>
  		
  		
		<tr>
		    <th width="20%">* 서브제목</th>
		    <td width="80%">
		    	<textarea name="FP_MAIN_SUBTITLE" class="form-control">${rtnMap.fpMainSubtitle}</textarea>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 설명</th>
		    <td width="80%">
		    	<textarea name="FP_MAIN_DESC" class="form-control">${rtnMap.fpMainDesc}</textarea>
		    </td>
  		</tr>
  		
  		
  		<tr>
		    <th width="20%">라벨</th>
		    <td width="80%">
		    	<div>
		    		<button type="button" class="btn btn-success btn-xs" onclick="javascript:fp_label_add();">추가</button>
		    		* 드래그앤 드롭으로 순서 변경
		    	</div>
		    	<ul class="list_sort" id="FP_LABEL">
		    	</ul>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">상세</th>
		    <td width="80%">
		    	<div>
		    		<button type="button" class="btn btn-success btn-xs" onclick="javascript:fp_detail_add();">추가</button>
		    		* 드래그앤 드롭으로 순서 변경<br>(배경 - width: 1920px 이상, height: free)(PC - width: 1080px 이하, height: free)(모바일 - width: 640px, height: free)
		    	</div>
		    	<table class="table table-bordered" style="margin-top:0;margin-bottom:0;">
					<tr>
						<th width="10%">탭명</th>
						<th width="10%">배경색</th>
						<th width="24%">배경이미지</th>
						<th width="24%">웹이미지</th>
						<th width="24%">모바일이미지</th>
						<th width="8%">관리</th>
					</tr>
				</table>
		    	<ul class="list_sort" id="FP_DETAIL">
		    	</ul>
		    </td>
  		</tr>
  				
  		
   		<tr>
		    <th width="20%">* 활성화</th>
		    <td width="80%">
		    	<label><input type="radio" name="FP_STATUS" value="Y" <c:if test="${rtnMap.fpStatus eq 'Y'}">checked</c:if>> 사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FP_STATUS" value="N" <c:if test="${rtnMap.fpStatus eq 'N'}">checked</c:if>> 미사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FP_STATUS" value="A" <c:if test="${rtnMap.fpStatus eq 'A'}">checked</c:if>> 상시사용(기간영향X)</label>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 시작시간</th>
		    <td width="80%">
		    	<input type="date" name="FP_SDAY" value="${rtnMap.fpStimeDay}">
		    	
		    	<select name="FP_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fpStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fpStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FP_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fpStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fpStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FP_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fpStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fpStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		
  		<tr>
		    <th width="20%">* 마감시간</th>
		    <td width="80%">
		    	<input type="date" name="FP_EDAY" value="${rtnMap.fpEtimeDay}">
		    	
		    	<select name="FP_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fpEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fpEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FP_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fpEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fpEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FP_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.fpEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.fpEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
	</table>
	<div style="text-align:center;">
		<a class="btn btn-warning" href="./index.do">목록</a>
		<a class="btn btn-success" onclick="javascript:chkFormFair();">저장</a>
	</div>
	
	
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
	
	<!-- 입력폼선택 모달 -->
	<div id="inputModal" class="modal fade" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">입력폼 선택</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="FPI_INPUT_SEQ" value="">
					<input type="hidden" name="FPI_INPUT_EXISTS" value=''>
					<table class="table table-bordered table-hover">
						<tr>
							<th width="20%">제목</th>
							<th width="*">내용</th>
						</tr>
						<c:forEach var="list" items="${rtnMap.inputList}" varStatus="status">
						<tr>
							<td>${list.fpiTitle}</td>
							<td>
								<label>
								<input type="radio" name="FPI_INPUT" class="form-control" value='${list.fpiInput}' data-fpiseq="${list.fpiSeq}">
								<span class="FPI_INPUT_TXT">${list.fpiInput}</span>
								</label>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="javascript:inputs_insert();">확인</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 결합상품 선택 모달 -->
	<div id="benefitModal" class="modal fade" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">결합상품 선택</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="FP_BENEFIT_INDEX">
					<table class="table table-bordered table-hover">
						<tr>
							<th width="20%">상품명</th>
							<td width="20%">서브명</td>
							<td width="25%">모델명</td>
							<td width="25%">가격</td>
						</tr>
						<c:forEach var="list" items="${rtnMap.benefitList}" varStatus="status">
						<tr>
							<td>
								<label>
								<input type="checkbox" name="FB_BENEFIT" class="form-control" value='${list.fbSeq}' data-title="${list.fbTitle}" data-subtitle="${list.fbSubtitle}" data-model="${list.fbModel}" data-price="${list.fbPrice}" data-path="${list.fbImageWPath}" data-save="${list.fbImageWSaveNm}" data-real="${list.fbImageWRealNm}">
								${list.fbTitle}
								</label>
							</td>
							<td>${list.fbSubtitle}</td>
							<td>${list.fbModel}</td>
							<td>${list.fbPrice}</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="javascript:benefit_insert();">확인</button>
				</div>
			</div>
		</div>
	</div>
</form>

<!-- 파일업로드 모달 -->
<form id="fairFileFrm" name="fairFileFrm" action ="./fileupload.ajax" method="post" enctype="multipart/form-data">
	<div id="fileUploadModal" class="modal fade" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">파일 업로드</h4>
				</div>
				<div class="modal-body">
					<input type="file" name="FILE_UPLOAD" id="FILE_UPLOAD">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" onclick="javascript:file_upload();">업로드</button>
				</div>
			</div>
		</div>
	</div>
</form>	
<script>
	jQuery(document).ready(function(){
		imagePreview();
		
		jQuery("input[name='FP_MAIN_IMAGE_BG'], input[name='FP_MAIN_IMAGE_W'], input[name='FP_MAIN_IMAGE_M']").change(function(){
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
		
		jQuery(".FPI_INPUT_TXT").each(function(){
			var json = JSON.parse(jQuery(this).text());
			
			var txtAry = new Array();
			for(var i = 0; i < json.length; i++) {
				var key = json[i].KEY;
				if(Array.isArray(json[i].VALUE)) {
					var val = json[i].VALUE.join(",");	
				}else {
					var val = json[i].VALUE;
				}
				
				var txt = "";
				if(json[i].KEY == "TEXT") {
					txt = "텍스트형";
				}
				else if(json[i].KEY == "HPHONE") {
					txt = "전화번호형";
				}
				else if(json[i].KEY == "EMAIL") {
					txt = "이메일형";
				}
				else if(json[i].KEY == "NUMBER") {
					txt = "숫자형";
				}
				else if(json[i].KEY == "DATE") {
					txt = "달력형";
				}
				else if(json[i].KEY == "SELECT") {
					txt = "선택형";
				}
				txtAry.push(json[i].TITLE);
			}
			var labelTxt = txtAry.join(", ");
			jQuery(this).html(labelTxt);
		});
		
		jQuery("input[name='FPI_INPUT']").click(function(){
			jQuery("input[name='FPI_INPUT_SEQ']").val(jQuery("input[name='FPI_INPUT']:checked").data("fpiseq"));
		});
	});
	
	//등록하기
	function chkFormFair()
	{
		var f = document.fairFrm;
		
		if(f.FAIR_CATEGORY_FC_SEQ.value == "") {
			alert("카테고리를 선택해주세요.");
			f.FAIR_CATEGORY_FC_SEQ.focus();
			return;
		}
		
		<c:if test="${rtnMap.fpSeq eq null}">
		if(jQuery("input[name='FPI_INPUT']:checked").length < 1) {
			alert("입력폼을 선택해주세요.");
			return;
		}
		</c:if>
		
		//날짜지정 값 설정
		<c:if test="${rtnMap.fpSeq eq null}">
		jQuery('input[name="DATE_PICKER_TAG"]').each(function(){
			var _obj = jQuery("input[name='FPI_INPUT']:checked");
			var index = jQuery(this).closest("tr").index() - 1;
			var json = JSON.parse(_obj.val());
			json[index].VALUE = jQuery(this).tagit('assignedTags');
		
			_obj.val(JSON.stringify(json));
		});
		</c:if>
		<c:if test="${rtnMap.fpSeq ne null}">
		jQuery('input[name="DATE_PICKER_TAG"]').each(function(){
			var _obj = jQuery("input[name='FPI_INPUT_EXISTS']");
			var index = jQuery(this).closest("tr").index() - 1;
			var json = JSON.parse(_obj.val());
			json[index].VALUE = jQuery(this).tagit('assignedTags');
		
			_obj.val(JSON.stringify(json));
		});
		</c:if>
		
		if(f.price_type.value == "G") {
			if(f.FP_G_PRICE.value == "") {
				alert("가격을 입력해주세요.");
				f.FP_G_PRICE.focus();
				return;
			}
			/* 
			if(jQuery("input[name='FP_G_PRODUCT_TAG']").tagit("assignedTags").length < 1) {
				alert("결합혜택을 선택해주세요.");
				return;
			}
			 */
			if(jQuery("input[name='FP_G_PRODUCT_TAG']").tagit("assignedTags").length > 0) {
				var fp_g_product = [];
				jQuery("input[name='FP_G_PRODUCT_TAG_DATA']").each(function(){
					var fp_g_product_obj = new Object();
					fp_g_product_obj.fbSeq = jQuery(this).data("fbseq");
					fp_g_product_obj.fbTitle = jQuery(this).data("fbtitle");
					fp_g_product_obj.fbSubtitle = jQuery(this).data("fbsubtitle");
					fp_g_product_obj.fbModel = jQuery(this).data("fbmodel");
					fp_g_product_obj.fbPrice = jQuery(this).data("fbprice");
					fp_g_product_obj.fbPath = jQuery(this).data("fbpath");
					fp_g_product_obj.fbSave = jQuery(this).data("fbsave");
					fp_g_product_obj.fbReal = jQuery(this).data("fbreal");
					
					fp_g_product.push(JSON.stringify(fp_g_product_obj));
				});
				f.FP_G_PRODUCT.value = fp_g_product.join(",");
			}
		}
		
		if(f.price_type.value == "S") {
			
			if(jQuery("input[name='FI_DELEGATE']:checked").length < 1) {
				alert("기준을 선택해주세요. (노출명에서 라디오버튼)");
				return;
			}
			
			var s_price_check = false;
			jQuery("input[name='FP_S_PRICE']").each(function(){
				if(jQuery(this).val() == "" && s_price_check == false) {
					alert("가격을 입력해주세요.");
					jQuery(this).focus();
					s_price_check = true;
					return;
				}
			});
			if(s_price_check == true) {
				return;
			}
			/* 
			var s_product_check = false;
			jQuery("input[name='FP_S_PRODUCT_TAG']").each(function(){
				if(jQuery(this).tagit("assignedTags").length < 1 && s_product_check == false) {
					alert("결합혜택을 선택해주세요.");
					s_product_check = true;
					return;
				}
				
			});
			
			if(s_product_check == true) {
				return;
			}
			 */
			jQuery("input[name='FP_S_PRODUCT']").each(function(){
				if(jQuery(this).closest("td").find("input[name='FP_S_PRODUCT_TAG']").tagit("assignedTags").length > 0) {
					var fp_s_product = [];
					jQuery(this).closest("td").find("input[name='FP_S_PRODUCT_TAG_DATA']").each(function(){
						var fp_s_product_obj = new Object();
						fp_s_product_obj.fbSeq = jQuery(this).data("fbseq");
						fp_s_product_obj.fbTitle = jQuery(this).data("fbtitle");
						fp_s_product_obj.fbSubtitle = jQuery(this).data("fbsubtitle");
						fp_s_product_obj.fbModel = jQuery(this).data("fbmodel");
						fp_s_product_obj.fbPrice = jQuery(this).data("fbprice");
						fp_s_product_obj.fbPath = jQuery(this).data("fbpath");
						fp_s_product_obj.fbSave = jQuery(this).data("fbsave");
						fp_s_product_obj.fbReal = jQuery(this).data("fbreal");
						
						fp_s_product.push(JSON.stringify(fp_s_product_obj));
					});
					jQuery(this).val(fp_s_product.join(","));
				}
			});
		}

		<c:if test="${rtnMap.fpMainImageBgSaveNm eq null}">
		if(f.FP_MAIN_IMAGE_BG.value == "") {
			alert("배경 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		<c:if test="${rtnMap.fpMainImageWSaveNm eq null}">
		if(f.FP_MAIN_IMAGE_W.value == "") {
			alert("PC용 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		<c:if test="${rtnMap.fpMainImageMSaveNm eq null}">
		if(f.FP_MAIN_IMAGE_M.value == "") {
			alert("모바일용 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		//썸네일 체크
		if(jQuery(".FP_THUMNAIL_DETAIL").length < 1) {
			alert("썸네일 이미지를 한가지 이상 추가해주세요.");
			return;
		}
		
		var fp_thumnail_check = false;
		jQuery(".FP_THUMNAIL_DETAIL").each(function(){
			if(jQuery(this).find("input[name='THUMNAIL_W_SAVE']" ).val() == "" && fp_thumnail_check == false) {
				alert("썸네일 PC 이미지를 선택해주세요.");
				fp_thumnail_check = true;
				return;
			}
			if(jQuery(this).find("input[name='THUMNAIL_M_SAVE']" ).val() == "" && fp_thumnail_check == false) {
				alert("썸네일 모바일 이미지를 선택해주세요.");
				fp_thumnail_check = true;
				return;
			}
		});
		
		if(fp_thumnail_check == true) {
			return;
		}
		
		
		if(f.FP_MAIN_TITLE.value == "") {
			alert("제목을 입력해주세요.");
			f.FP_MAIN_TITLE.focus();
			return;
		}
		
		if(f.FP_MAIN_SUBTITLE.value == "") {
			alert("서브 제목을 입력해주세요.");
			f.FP_MAIN_SUBTITLE.focus();
			return;
		}
		
		if(f.FP_MAIN_DESC.value == "") {
			alert("설명을 입력해주세요.");
			f.FP_MAIN_DESC.focus();
			return;
		}
		
		//라벨 체크
		if(jQuery("input[name='FP_LABEL_TITLE']").length > 0) {
			var fp_label_title_check = false;
			jQuery("input[name='FP_LABEL_TITLE']").each(function(){
				if(jQuery(this).val() == "" && fp_label_title_check == false) {
					alert("라벨명을 입력해주세요.");
					jQuery(this).focus();
					fp_label_title_check = true;
					return;
				}
			});
			if(fp_label_title_check == true) {
				return;
			}
			
			var fp_label_bgcolor_check = false;
			jQuery("input[name='FP_LABEL_BGCOLOR']").each(function(){
				if(jQuery(this).val() == "" && fp_label_bgcolor_check == false) {
					alert("라벨 배경색을 입력해주세요.");
					jQuery(this).focus();
					fp_label_bgcolor_check = true;
					return;
				}
			});
			if(fp_label_bgcolor_check == true) {
				return;
			}
		}
		
		//상세 체크
		if(jQuery(".FP_DETAIL_INPUT").length > 0) {
			var fp_detail_check = false;
			var fp_detail_index = 0;
			jQuery(".FP_DETAIL_INPUT").each(function(){
				if(jQuery(this).find("input[name='FP_DETAIL_TITLE']").val() == "" && fp_detail_check == false) {
					alert("탭명을 입력해주세요.");
					jQuery(this).focus();
					fp_detail_check = true;
					return;
				}
				
				if(jQuery(this).find("input[name='DETAIL_W_SAVE']").val() == "" && fp_detail_check == false) {
					alert("상세 웹용 이미지를 선택해주세요.");
					fp_detail_check = true;
					return;
				}
				
				if(jQuery(this).find("input[name='DETAIL_M_SAVE']").val() == "" && fp_detail_check == false) {
					alert("상세 모바일용 이미지를 선택해주세요.");
					fp_detail_check = true;
					return;
				}
				fp_detail_index++;
			});
			if(fp_detail_check == true) {
				return;
			}

		}
		
		if(f.FP_STATUS[0].checked == false && f.FP_STATUS[1].checked == false && f.FP_STATUS[2].checked == false) {
			alert("활성화 여부를 선택해주세요.");
			f.FP_STATUS[0].focus();
			return;
		}
		
		if(f.FP_STATUS[0].checked == true) {
			if(f.FP_SDAY.value == "") {
				alert("시작일을 선택해주세요.");
				f.FP_SDAY.focus();
				return;
			}
			if(f.FP_SHH.value == "") {
				alert("시작시간(시)을 선택해주세요.");
				f.FP_SHH.focus();
				return;
			}
			if(f.FP_SMM.value == "") {
				alert("시작시간(분)을 선택해주세요.");
				f.FP_SMM.focus();
				return;
			}
			if(f.FP_SSS.value == "") {
				alert("시작시간(초)을 선택해주세요.");
				f.FP_SSS.focus();
				return;
			}
			
			if(f.FP_EDAY.value == "") {
				alert("마감일을 선택해주세요.");
				f.FP_EDAY.focus();
				return;
			}
			if(f.FP_EHH.value == "") {
				alert("마감시간(시)을 선택해주세요.");
				f.FP_EHH.focus();
				return;
			}
			if(f.FP_EMM.value == "") {
				alert("마감시간(분)을 선택해주세요.");
				f.FP_EMM.focus();
				return;
			}
			if(f.FP_ESS.value == "") {
				alert("마감시간(초)을 선택해주세요.");
				f.FP_ESS.focus();
				return;
			}
		}
		
		f.submit();
	}
	
	function preview_close() {
		jQuery("#preview").css("display","none");
	};
	
	function imagePreview(){
		jQuery(".btn_pop_preview").off("click").on("click", function(){
			var select_file = jQuery(this).closest("td").find("input:file");
			if(select_file.length > 0 && select_file.val() != '') {
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
	
	function inputs_insert(){
		if(jQuery("input[name='FPI_INPUT']:checked").length < 1) {
			alert("입력폼을 선택해주세요.");
			return;
		}
		
		document.fairFrm.price_type.value = "G";
		
		var selectInput = jQuery("input[name='FPI_INPUT']:checked");
		
		jQuery("input[name='FPI_INPUT_EXISTS']").val( selectInput.val() );
		
		var html = '';
		html += '<table class="table table-bordered" style="width:auto; margin-top:5px; background:#ffffff;">';
		html += '<tr>';
		html += '<th>노출명</th>';
		html += '<th>형태</th>';
		html += '</tr>';
		
		var json = JSON.parse(selectInput.val());
		var txtAry = new Array();
		for(var i = 0; i < json.length; i++) {
			var key = json[i].KEY;
			if(Array.isArray(json[i].VALUE)) {
				var val = json[i].VALUE.join(",");	
			}else {
				var val = json[i].VALUE;
			}
			
			var txt = "";
			if(json[i].KEY == "TEXT") {
				txt = "텍스트형";
			}
			else if(json[i].KEY == "HPHONE") {
				txt = "전화번호형";
			}
			else if(json[i].KEY == "EMAIL") {
				txt = "이메일형";
			}
			else if(json[i].KEY == "NUMBER") {
				txt = "숫자형";
			}
			else if(json[i].KEY == "DATE") {
				txt = "달력형";
				txt += '<input type="text" name="DATE_PICKER_TAG">';
				txt += '<button type="button" class="btn btn-default btn-xs DATE_PICKER_RANGE">범위선택</button>';
				txt += '<button type="button" class="btn btn-default btn-xs DATE_PICKER_EACH">가능일 지정선택</button>';
			}
			else if(json[i].KEY == "SELECT") {
				txt = "선택형";
			}

			html += '<tr>';
			html += '<td><label><input type="radio" name="FI_DELEGATE" class="form-control" value="'+ i +'" data-index="'+ i +'" data-value="'+ val +'" onclick="javascript:select_key(jQuery(this));">'+ json[i].TITLE +'</label></td>';
			html += '<td>'+ txt +'</td>';
			html += '</tr>';
		}
		html += '</table>';
		
		html += '<div role="tabpanel" style="margin-top:5px;">';
		html += '<ul class="nav nav-tabs" role="tablist">';
		html += '<li role="presentation" class="active"><a href="#general_price" aria-controls="general_price" role="tab" data-toggle="tab" onclick="javascript:price_type(\'G\');">공통가격/혜택</a></li>';
		html += '<li role="presentation"><a href="#special_price" aria-controls="special_price" role="tab" data-toggle="tab" onclick="javascript:price_type(\'S\');">별도가격/혜택</a></li>';
		html += '</ul>';
		html += '<div class="tab-content">';
		html += '<div role="tabpanel" class="tab-pane active" id="general_price">';
		html += '<table class="table table-bordered">';
		html += '<tr>';
		html += '<th>가격</th>';
		html += '<td><input type="number" name="FP_G_PRICE"></td>';
		html += '</tr>';
		html += '<tr>';
		html += '<th>혜택</th>';
		html += '<td><input type="hidden" name="FP_G_PRODUCT"><button type="button" class="btn btn-success btn-xs" onclick="javascript:modal_benefit(0);">추가</button><br><input type="text" name="FP_G_PRODUCT_TAG"></td>';
		html += '</tr>';
		html += '</table>';
		html += '</div>';
		html += '<div role="tabpanel" class="tab-pane" id="special_price">';
		html += '상단에서 노출명을 선택해주세요.';
		html += '</div>';
		html += '</div>';
		html += '</div>';
		
		jQuery("#FP_INPUT_FORM").html(html);
		jQuery('input[name="FP_G_PRODUCT_TAG"]').tagit({
			onTagRemoved: function(event, ui) {
				index = ui.index(); 
				ui.closest("td").find("input[name='FP_G_PRODUCT_TAG_DATA']:eq("+ index +")").remove();		
			}
		});
		
		jQuery('.DATE_PICKER_RANGE').daterangepicker({
			autoUpdateInput: false,
			locale: { format: "YYYY-MM-DD" }
		});
		jQuery('.DATE_PICKER_RANGE').on('apply.daterangepicker', function(ev, picker) {
			var val = picker.startDate.format('YYYY-MM-DD') + '~' + picker.endDate.format('YYYY-MM-DD');
			jQuery(this).closest("td").find('input[name="DATE_PICKER_TAG"]').tagit('createTag', val);
			
		});
		
		jQuery('.DATE_PICKER_EACH').daterangepicker({
			singleDatePicker: true,
			locale: { format: "YYYY-MM-DD" }
		});
		jQuery('.DATE_PICKER_EACH').on('apply.daterangepicker', function(ev, picker) {
			var val = picker.startDate.format('YYYY-MM-DD');
			jQuery(this).closest("td").find('input[name="DATE_PICKER_TAG"]').tagit('createTag', val);
		});
		jQuery('input[name="DATE_PICKER_TAG"]').tagit({});
		
		jQuery("#inputModal").modal("hide");
	}
	
	function select_key(obj) {
		var index = obj.data("index");
		var html = '';
		html += '<table class="table table-bordered">';
		html += '<tr>';
		html += '<th width="10%">선택값</th>';
		html += '<th width="30%">가격</th>';
		html += '<th width="*">혜택</th>';
		html += '</tr>';
		if(obj.data("value").indexOf(",") > -1) {
			var value = obj.data("value").split(",");
			for(var i = 0; i < value.length; i++) {
				html += '<th style="text-align:center;">'+ value[i] +'</td>';
				html += '<td><input type="text" name="FP_S_PRICE" placeholder="숫자가 아닐시에는 사용자 메세지로 노출됩니다." style="width:90%;"></td>';
				html += '<td><input type="hidden" name="FP_S_PRODUCT"><button type="button" class="btn btn-success btn-xs" onclick="javascript:modal_benefit('+ i +');">추가</button><br><input type="text" name="FP_S_PRODUCT_TAG"></td>';
				html += '</tr>';
			}
		}else {
			var value = obj.data("value");
			html += '<td>'+ value +'</td>';
			html += '<td><input type="text" name="FP_S_PRICE" placeholder="숫자가 아닐시에는 사용자 메세지로 노출됩니다."></td>';
			html += '<td><input type="hidden" name="FP_S_PRODUCT"><button type="button" class="btn btn-success btn-xs" onclick="javascript:modal_benefit(0);">추가</button><br><input type="text" name="FP_S_PRODUCT_TAG"></td>';
			html += '</tr>';
		}
		html += '</table>';
		
		jQuery("#special_price").html(html);
		
		jQuery('input[name="FP_S_PRODUCT_TAG"]').each(function(){
			var _this = jQuery(this);
			jQuery(this).tagit({
				onTagRemoved: function(event, ui) {
					index = ui.index();
					ui.closest("td").find("input[name='FP_S_PRODUCT_TAG_DATA']:eq("+ index +")").remove();		
				}
			});
		});
	}
	
	function price_type(val) {
		jQuery("input[name='price_type']").val(val);
	}
	
	function modal_benefit(index) {
		jQuery("input[name='FP_BENEFIT_INDEX']").val(index);
		jQuery("#benefitModal").modal();
	}
	
	function benefit_insert() {
		var price_type = jQuery("input[name='price_type']").val();
		var index = jQuery("input[name='FP_BENEFIT_INDEX']").val();
		var objStr = null;
		if(price_type == "G") {
			objStr = "FP_G_PRODUCT_TAG_DATA";
		}
		if(price_type == "S") {
			objStr = "FP_S_PRODUCT_TAG_DATA";
		}
		
		var valueAry = [];
		jQuery("input[name='FB_BENEFIT']:checked").each(function(){
			var fbSeq = jQuery(this).val();
			var fbTitle = jQuery(this).data("title");
			var fbSubtitle = jQuery(this).data("subtitle");
			var fbModel = jQuery(this).data("model");
			var fbPrice = jQuery(this).data("price");
			var fbPath = jQuery(this).data("path");
			var fbSave = jQuery(this).data("save");
			var fbReal = jQuery(this).data("real");
			
			if(price_type == "G") {
				jQuery("input[name='FP_G_PRODUCT_TAG']").tagit('createTag', fbTitle+'['+fbSubtitle+']');
				jQuery("input[name='FP_G_PRODUCT']").closest("td").append('<input type="hidden" name="'+ objStr +'" data-fbseq="'+ fbSeq +'" data-fbtitle="'+ fbTitle +'" data-fbsubtitle="'+ fbSubtitle +'" data-fbmodel="'+ fbModel +'" data-fbprice="'+ fbPrice +'" data-fbpath="'+ fbPath +'" data-fbsave="'+ fbSave +'" data-fbreal="'+ fbReal +'">');
			}
			if(price_type == "S") {
				jQuery("input[name='FP_S_PRODUCT_TAG']").eq(index).tagit('createTag', fbTitle+'['+fbSubtitle+']');
				jQuery("input[name='FP_S_PRODUCT']").eq(index).closest("td").append('<input type="hidden" name="'+ objStr +'" data-fbseq="'+ fbSeq +'" data-fbtitle="'+ fbTitle +'" data-fbsubtitle="'+ fbSubtitle +'" data-fbmodel="'+ fbModel +'" data-fbprice="'+ fbPrice +'" data-fbpath="'+ fbPath +'" data-fbsave="'+ fbSave +'" data-fbreal="'+ fbReal +'">');
			}
		});
		jQuery("input[name='FB_BENEFIT']:checked").prop("checked", false);
		jQuery("#benefitModal").modal("hide");
	}
	
	var file_upload_obj = null;
	function file_upload_set(_this, path, save, real) {
		file_upload_obj = new Object();
		file_upload_obj._this = _this;
		file_upload_obj.path_name = path;
		file_upload_obj.save_name = save;
		file_upload_obj.real_name = real;
		
		jQuery("#fileUploadModal").modal();
	}
	
	function file_upload() {
		var form = $('#fairFileFrm')[0];
        var formData = new FormData(form);
        
        if($("#FILE_UPLOAD")[0].files[0]) {
			formData.append("files", $("#FILE_UPLOAD")[0].files[0]);
			jQuery.ajax({
				url: "./fileupload.ajax",
				type: 'POST',
				dataType: "json",
				processData: false,
	            contentType: false,
				data: formData,
				success: function(data) {
					if(typeof file_upload_obj == "object") {
						var _this = file_upload_obj._this.closest(".FILE_UPLOAD_CONTANIER");
						if(file_upload_obj._this) {
							_this.find("input[name='"+ file_upload_obj.path_name +"']").val(data.path);
							_this.find("input[name='"+ file_upload_obj.save_name +"']").val(data.save);
							_this.find("input[name='"+ file_upload_obj.real_name +"']").val(data.real);
						}
						file_upload_obj = null;
					
						_this.find(".file_name").html("&nbsp;["+data.real+"]");
						_this.find(".file_name").data("path", data.path);
						_this.find(".file_name").data("save", data.save);
						_this.find(".btn_pop_preview").show();
						
						imagePreview();
						
						jQuery("#fileUploadModal").modal('hide');
					}
				},
				error: function(data) {
				}
			});
        }else {
        	alert("파일을 선택해주세요.")
        }
	}
		
	function fp_thumnail_add() {
		html = "";
		html += '<li class="ui-state-default">';
		html += '<table class="FP_THUMNAIL_DETAIL table table-bordered" style="margin-top:0;margin-bottom:0;">';
		html += '<tr>';
		
		html += '<td width="45%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="THUMNAIL_W_PATH" value="">';
		html += '<input type="hidden" name="THUMNAIL_W_SAVE" value="">';
		html += '<input type="hidden" name="THUMNAIL_W_REAL" value="">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'THUMNAIL_W_PATH\', \'THUMNAIL_W_SAVE\', \'THUMNAIL_W_REAL\');">업로드</button>';
		html += '<span class="file_name"></span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="45%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="THUMNAIL_M_PATH" value="">';
		html += '<input type="hidden" name="THUMNAIL_M_SAVE" value="">';
		html += '<input type="hidden" name="THUMNAIL_M_REAL" value="">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'THUMNAIL_M_PATH\', \'THUMNAIL_M_SAVE\', \'THUMNAIL_M_REAL\');">업로드</button>';
		html += '<span class="file_name"></span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="10%"><button type="button" class="btn btn-danger btn-xs" onclick="javascript:fp_thumnail_remove(jQuery(this));">삭제</button></td>';
		html += '</tr>';
		html += '</table>';
		html += '</li>';
		
		jQuery("#FP_THUMNAIL").append(html);
		
		jQuery(".list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				
			},
			stop: function( event, ui ) {
				
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
	}
	
	function fp_thumnail_remove(_this) {
		if(jQuery(".FP_THUMNAIL_DETAIL").length > 1) {
			_this.closest(".FP_THUMNAIL_DETAIL").remove();
		}else {
			alert("첫번째 썸네일은 삭제하실수 없습니다.")
		}
	}
	
	function fp_label_add() {
		html = "";
		html += '<li class="ui-state-default">';
		html += '<table class="table table-bordered" style="margin-top:0;margin-bottom:0;">';
		html += '<tr>';
		html += '<th width="10%">라벨명</th>';
		html += '<td><input type="text" name="FP_LABEL_TITLE" placeholder=""></td>';
		html += '<th width="10%">배경색</th>';
		html += '<td><input type="text" name="FP_LABEL_BGCOLOR" placeholder="" class="minicolor" data-control="wheel"></td>';
		html += '<td width="10%"><button type="button" class="btn btn-danger btn-xs" onclick="javascript:fp_label_remove(jQuery(this));">삭제</button></td>';
		html += '</tr>';
		html += '</table>';
		html += '</li>';
		
		jQuery("#FP_LABEL").append(html);
		
		jQuery(".list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				
			},
			stop: function( event, ui ) {
				
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
		
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
				//console.log(value);
	        }
	      },
	      theme: 'bootstrap'
	    });
	}
	
	function fp_label_remove(_this) {
		_this.closest("li").remove();
	}
	
	function fp_detail_add() {
		var index = jQuery(".FP_DETAIL_INPUT").length;
		html = "";
		html += '<li class="ui-state-default">';
		html += '<table class="FP_DETAIL_INPUT table table-bordered" style="margin-top:0;margin-bottom:0;">';
		html += '<tr>';
		html += '<td width="10%"><input type="text" name="FP_DETAIL_TITLE" style="width:80%"></td>';
		html += '<td width="10%"><input type="text" name="FP_DETAIL_BGCOLOR" placeholder="" class="minicolor" data-control="wheel" style="width:calc(80% - 40px);"></td>';
		
		html += '<td width="24%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="DETAIL_BG_PATH" value="">';
		html += '<input type="hidden" name="DETAIL_BG_SAVE" value="">';
		html += '<input type="hidden" name="DETAIL_BG_REAL" value="">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'DETAIL_BG_PATH\', \'DETAIL_BG_SAVE\', \'DETAIL_BG_REAL\');">업로드</button>';
		html += '<span class="file_name"></span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="24%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="DETAIL_W_PATH" value="">';
		html += '<input type="hidden" name="DETAIL_W_SAVE" value="">';
		html += '<input type="hidden" name="DETAIL_W_REAL" value="">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'DETAIL_W_PATH\', \'DETAIL_W_SAVE\', \'DETAIL_W_REAL\');">업로드</button>';
		html += '<span class="file_name"></span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="24%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="DETAIL_M_PATH" value="">';
		html += '<input type="hidden" name="DETAIL_M_SAVE" value="">';
		html += '<input type="hidden" name="DETAIL_M_REAL" value="">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'DETAIL_M_PATH\', \'DETAIL_M_SAVE\', \'DETAIL_M_REAL\');">업로드</button>';
		html += '<span class="file_name"></span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="8%"><button type="button" class="btn btn-danger btn-xs" onclick="javascript:fp_detail_remove(jQuery(this));">삭제</button></td>';
		html += '</tr>';
		html += '</table>';
		html += '</li>';
		
		jQuery("#FP_DETAIL").append(html);
		
		jQuery(".list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				
			},
			stop: function( event, ui ) {
				
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
		
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
				//console.log(value);
	        }
	      },
	      theme: 'bootstrap'
	    });
		
		jQuery("input[name='FP_DETAIL_BG"+ index +"'], input[name='FP_DETAIL_W"+ index +"'], input[name='FP_DETAIL_M"+ index +"']").each(function() {
			jQuery(this).change(function(){
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
	}
	
	function fp_detail_remove(_this) {
		_this.closest("li").remove();
	}
</script>



<c:if test="${rtnMap.fpSeq ne null}">
<!--  수정모드 데이터 세팅 -->
<script>
jQuery(document).ready(function(){
	var f = document.fairFrm;
	var jsonFpi = JSON.parse('${rtnMap.fpInput}');
	jQuery("input[name='FPI_INPUT']").each(function(){
		if(jQuery(this).data("fpiseq") == jsonFpi.INPUT_SEQ) {
			jQuery(this).prop("checked", true);
		}
	});
	
	jQuery("input[name='FPI_INPUT_SEQ']").val(jsonFpi.INPUT_SEQ);
	jQuery("input[name='FPI_INPUT_EXISTS']").val(JSON.stringify(jsonFpi.INPUT));
	
	//input form 세팅
	var html = '';
	html += '<table class="table table-bordered" style="width:auto; margin-top:5px; background:#ffffff;">';
	html += '<tr>';
	html += '<th>노출명</th>';
	html += '<th>형태</th>';
	html += '</tr>';
	
	var json = jsonFpi.INPUT;
	var txtAry = new Array();
	for(var i = 0; i < json.length; i++) {
		var key = json[i].KEY;
		if(Array.isArray(json[i].VALUE)) {
			var val = json[i].VALUE.join(",");	
		}else {
			var val = json[i].VALUE;
		}
		
		var txt = "";
		if(json[i].KEY == "TEXT") {
			txt = "텍스트형";
		}
		else if(json[i].KEY == "HPHONE") {
			txt = "전화번호형";
		}
		else if(json[i].KEY == "EMAIL") {
			txt = "이메일형";
		}
		else if(json[i].KEY == "NUMBER") {
			txt = "숫자형";
		}
		else if(json[i].KEY == "DATE") {
			txt = "달력형";
			txt += '<input type="text" name="DATE_PICKER_TAG">';
			txt += '<button type="button" class="btn btn-default btn-xs DATE_PICKER_RANGE">범위선택</button>';
			txt += '<button type="button" class="btn btn-default btn-xs DATE_PICKER_EACH">가능일 지정선택</button>';
		}
		else if(json[i].KEY == "SELECT") {
			txt = "선택형";
		}

		html += '<tr>';
		
		html += '<td><label><input type="radio" name="FI_DELEGATE" class="form-control" value="'+ i +'" data-index="'+ i +'" data-value="'+ val +'" onclick="javascript:select_key(jQuery(this));">'+ json[i].TITLE +'</label></td>';
		html += '<td>'+ txt +'</td>';
		html += '</tr>';
	}
	html += '</table>';
	
	html += '<div role="tabpanel" style="margin-top:5px;">';
	html += '<ul class="nav nav-tabs" role="tablist">';
	html += '<li role="presentation" class="active"><a href="#general_price" aria-controls="general_price" role="tab" data-toggle="tab" onclick="javascript:price_type(\'G\');">공통가격/혜택</a></li>';
	html += '<li role="presentation"><a href="#special_price" aria-controls="special_price" role="tab" data-toggle="tab" onclick="javascript:price_type(\'S\');">별도가격/혜택</a></li>';
	html += '</ul>';
	html += '<div class="tab-content">';
	html += '<div role="tabpanel" class="tab-pane active" id="general_price">';
	html += '<table class="table table-bordered">';
	html += '<tr>';
	html += '<th>가격</th>';
	html += '<td><input type="number" name="FP_G_PRICE"></td>';
	html += '</tr>';
	html += '<tr>';
	html += '<th>혜택</th>';
	html += '<td><input type="hidden" name="FP_G_PRODUCT"><button type="button" class="btn btn-success btn-xs" onclick="javascript:modal_benefit(0);">추가</button><br><input type="text" name="FP_G_PRODUCT_TAG"></td>';
	html += '</tr>';
	html += '</table>';
	html += '</div>';
	html += '<div role="tabpanel" class="tab-pane" id="special_price">';
	html += '상단에서 노출명을 선택해주세요.';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	
	jQuery("#FP_INPUT_FORM").html(html);
	jQuery('input[name="FP_G_PRODUCT_TAG"]').tagit({
		onTagRemoved: function(event, ui) {
			index = ui.index(); 
			ui.closest("td").find("input[name='FP_G_PRODUCT_TAG_DATA']:eq("+ index +")").remove();		
		}
	});
	
	jQuery('.DATE_PICKER_RANGE').daterangepicker({
		autoUpdateInput: false,
		locale: { format: "YYYY-MM-DD" }
	});
	jQuery('.DATE_PICKER_RANGE').on('apply.daterangepicker', function(ev, picker) {
		var val = picker.startDate.format('YYYY-MM-DD') + '~' + picker.endDate.format('YYYY-MM-DD');
		jQuery(this).closest("td").find('input[name="DATE_PICKER_TAG"]').tagit('createTag', val);
		
	});
	
	jQuery('.DATE_PICKER_EACH').daterangepicker({
		singleDatePicker: true,
		locale: { format: "YYYY-MM-DD" }
	});
	jQuery('.DATE_PICKER_EACH').on('apply.daterangepicker', function(ev, picker) {
		var val = picker.startDate.format('YYYY-MM-DD');
		jQuery(this).closest("td").find('input[name="DATE_PICKER_TAG"]').tagit('createTag', val);
	});

	jQuery('input[name="DATE_PICKER_TAG"]').tagit({});
	
	var j = 0;
	for(var i = 0; i < json.length; i++) {
		if(json[i].KEY == "DATE") {
			for(var k = 0; k < json[i].VALUE.length; k++) {
				jQuery('input[name="DATE_PICKER_TAG"]:eq('+j+')').tagit('createTag',json[i].VALUE[k]);
			}
			j++;
		}
	}
		
	//가격 세팅
	var jsonPrice = jsonFpi.PRICE;
	var html = '';
	html += '<table class="table table-bordered">';
	html += '<tr>';
	html += '<th width="10%">선택값</th>';
	html += '<th width="30%">가격</th>';
	html += '<th width="*">혜택</th>';
	html += '</tr>';
	for(var i = 0; i < jsonPrice.length; i++) {
		var key = jsonPrice[i].KEY;
		var value = jsonPrice[i].VALUE;
		var price = jsonPrice[i].PRICE;

		//별도가격 책정
		if(key != "-1") {
			jQuery("input[name='FI_DELEGATE']").eq(key).prop("checked", true);
			jQuery("input[name='price_type']").val("S");
			jQuery('a[href="#special_price"]').tab('show');
			
			html += '<th style="text-align:center;">'+ jsonFpi.INPUT[key].VALUE[value] +'</td>';
			html += '<td><input type="text" name="FP_S_PRICE" value="'+ price +'" placeholder="숫자가 아닐시에는 사용자 메세지로 노출됩니다." style="width:90%;"></td>';
			html += '<td><input type="hidden" name="FP_S_PRODUCT"><button type="button" class="btn btn-success btn-xs" onclick="javascript:modal_benefit('+ i +');">추가</button><br><input type="text" name="FP_S_PRODUCT_TAG"></td>';
			html += '</tr>';
		
			jQuery("#special_price").html(html);
			
		//공통가격 책정
		}else {
			jQuery("input[name='price_type']").val("G");
			jQuery("input[name='FP_G_PRICE']").val(price);
		}
	}
	html += '</table>';
	if(jQuery("input[name='price_type']").val() == "S") {
		jQuery("#special_price").html(html);
	}
	
	//결합혜택 세팅
	var jsonBenefit = jsonFpi.BENEFIT;
	for(var i = 0; i < jsonBenefit.length; i++) {
		var key = jsonBenefit[i].KEY;
		var value = jsonBenefit[i].VALUE;
		var benefit = jsonBenefit[i].BENEFIT;
		
		//별도가격 책정
		if(key != "-1") {
			jQuery('input[name="FP_S_PRODUCT_TAG"]').each(function(){
				var _this = jQuery(this);
				jQuery(this).tagit({
					onTagRemoved: function(event, ui) {
						index = ui.index();
						ui.closest("td").find("input[name='FP_S_PRODUCT_TAG_DATA']:eq("+ index +")").remove();		
					}
				});
			});

			for(var j = 0; j < benefit.length; j++) {
				jQuery("input[name='FP_S_PRODUCT']").eq(i).closest("td").find("input[name='FP_S_PRODUCT_TAG']").tagit('createTag', benefit[j].fbTitle +'['+ benefit[j].fbSubtitle +']');
				jQuery("input[name='FP_S_PRODUCT']").eq(i).closest("td").append('<input type="hidden" name="FP_S_PRODUCT_TAG_DATA" data-fbseq="'+ benefit[j].fbSeq +'" data-fbtitle="'+ benefit[j].fbTitle +'" data-fbsubtitle="'+ benefit[j].fbSubtitle +'" data-fbmodel="'+ benefit[j].fbModel +'" data-fbprice="'+ benefit[j].fbPrice +'" data-fbpath="'+ benefit[j].fbPath +'" data-fbsave="'+ benefit[j].fbSave +'" data-fbreal="'+ benefit[j].fbReal +'">');
			}
		//공통가격 책정
		}else {
			for(var j = 0; j < benefit.length; j++) {
				jQuery("input[name='FP_G_PRODUCT_TAG']").tagit('createTag', benefit[j].fbTitle +'['+ benefit[j].fbSubtitle +']');
				jQuery("input[name='FP_G_PRODUCT']").closest("td").append('<input type="hidden" name="FP_G_PRODUCT_TAG_DATA" data-fbseq="'+ benefit[j].fbSeq +'" data-fbtitle="'+ benefit[j].fbTitle +'" data-fbsubtitle="'+ benefit[j].fbSubtitle +'" data-fbmodel="'+ benefit[j].fbModel +'" data-fbprice="'+ benefit[j].fbPrice +'" data-fbpath="'+ benefit[j].fbPath +'" data-fbsave="'+ benefit[j].fbSave +'" data-fbreal="'+ benefit[j].fbReal +'">');
			}
		}
	}
	
	//썸네일 세팅
	var jsonThumnail = JSON.parse('${rtnMap.fpThumnail}');
	for(var i = 0; i < jsonThumnail.length; i++) {
		var w_path = jsonThumnail[i].W_PATH;
		var w_save_nm = jsonThumnail[i].W_SAVE_NM;
		var w_real_nm = jsonThumnail[i].W_REAL_NM;
		var m_path = jsonThumnail[i].M_PATH;
		var m_save_nm = jsonThumnail[i].M_SAVE_NM;
		var m_real_nm = jsonThumnail[i].M_REAL_NM;
		
		html = "";
		html += '<li class="ui-state-default">';
		html += '<table class="FP_THUMNAIL_DETAIL table table-bordered" style="margin-top:0;margin-bottom:0;">';
		html += '<tr>';
		
		html += '<td width="45%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="THUMNAIL_W_PATH" value="'+ w_path +'">';
		html += '<input type="hidden" name="THUMNAIL_W_SAVE" value="'+ w_save_nm +'">';
		html += '<input type="hidden" name="THUMNAIL_W_REAL" value="'+ w_real_nm +'">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'THUMNAIL_W_PATH\', \'THUMNAIL_W_SAVE\', \'THUMNAIL_W_REAL\');">업로드</button>';
		html += '<span class="file_name" data-path="'+ w_path +'" data-save="'+ w_save_nm +'">&nbsp;['+ w_real_nm +']</span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="45%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="THUMNAIL_M_PATH" value="'+ m_path +'">';
		html += '<input type="hidden" name="THUMNAIL_M_SAVE" value="'+ m_save_nm +'">';
		html += '<input type="hidden" name="THUMNAIL_M_REAL" value="'+ m_real_nm +'">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'THUMNAIL_M_PATH\', \'THUMNAIL_M_SAVE\', \'THUMNAIL_M_REAL\');">업로드</button>';
		html += '<span class="file_name" data-path="'+ m_path +'" data-save="'+ m_save_nm +'">&nbsp;['+ m_real_nm +']</span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="10%"><button type="button" class="btn btn-danger btn-xs" onclick="javascript:fp_thumnail_remove(jQuery(this));">삭제</button></td>';
		html += '</tr>';
		html += '</table>';
		html += '</li>';
		
		jQuery("#FP_THUMNAIL").append(html);

		jQuery(".list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				
			},
			stop: function( event, ui ) {
				
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
		imagePreview();
	}
	
	//라벨 세팅
	var jsonLabel = JSON.parse('${rtnMap.fpLabel}');
	for(var i = 0; i < jsonLabel.length; i++) {
		var title = jsonLabel[i].TITLE;
		var bgcolor = jsonLabel[i].BGCOLOR;
		
		html = "";
		html += '<li class="ui-state-default">';
		html += '<table class="table table-bordered" style="margin-top:0;margin-bottom:0;">';
		html += '<tr>';
		html += '<th width="10%">라벨명</th>';
		html += '<td><input type="text" name="FP_LABEL_TITLE" value="'+ title +'"></td>';
		html += '<th width="10%">배경색</th>';
		html += '<td><input type="text" name="FP_LABEL_BGCOLOR" value="'+ bgcolor +'" class="minicolor" data-control="wheel"></td>';
		html += '<td width="10%"><button type="button" class="btn btn-danger btn-xs" onclick="javascript:fp_label_remove(jQuery(this));">삭제</button></td>';
		html += '</tr>';
		html += '</table>';
		html += '</li>';
		
		jQuery("#FP_LABEL").append(html);
		
		jQuery(".list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				
			},
			stop: function( event, ui ) {
				
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
		
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
	          //console.log(value);
	        }
	      },
	      theme: 'bootstrap'
	    });
	}
	
	//상세 세팅
	var jsonDetail = JSON.parse('${rtnMap.fpDetail}');
	for(var i = 0; i < jsonDetail.length; i++) {
		var title = jsonDetail[i].TITLE;
		var bgcolor = jsonDetail[i].BGCOLOR;
		var bg_path = jsonDetail[i].BG_PATH;
		var bg_save_nm = jsonDetail[i].BG_SAVE_NM;
		var bg_real_nm = jsonDetail[i].BG_REAL_NM;
		var w_path = jsonDetail[i].W_PATH;
		var w_save_nm = jsonDetail[i].W_SAVE_NM;
		var w_real_nm = jsonDetail[i].W_REAL_NM;
		var m_path = jsonDetail[i].M_PATH;
		var m_save_nm = jsonDetail[i].M_SAVE_NM;
		var m_real_nm = jsonDetail[i].M_REAL_NM;
		
		html = "";
		html += '<li class="ui-state-default">';
		html += '<table class="FP_DETAIL_INPUT table table-bordered" style="margin-top:0;margin-bottom:0;">';
		html += '<tr>';
		html += '<td width="10%"><input type="text" name="FP_DETAIL_TITLE" value="'+ title +'" style="width:80%"></td>';
		html += '<td width="10%"><input type="text" name="FP_DETAIL_BGCOLOR" value="'+ bgcolor +'" placeholder="" class="minicolor" data-control="wheel" style="width:calc(80% - 40px);"></td>';
		
		html += '<td width="24%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="DETAIL_BG_PATH" value="'+ bg_path +'">';
		html += '<input type="hidden" name="DETAIL_BG_SAVE" value="'+ bg_save_nm +'">';
		html += '<input type="hidden" name="DETAIL_BG_REAL" value="'+ bg_real_nm +'">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'DETAIL_BG_PATH\', \'DETAIL_BG_SAVE\', \'DETAIL_BG_REAL\');">업로드</button>';
		if(bg_save_nm != "") {
		html += '<span class="file_name" data-path="'+ bg_path +'" data-save="'+ bg_save_nm +'">&nbsp;['+ bg_real_nm +']</span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview"/>';
		}else{
			html += '<span class="file_name" data-path="" data-save=""></span>';
			html += '<input type="button" value="미리보기" class="btn btn_pop_preview" style="display:none;"/>';
		}
		html += '</div>';
		html += '</td>';
		
		html += '<td width="24%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="DETAIL_W_PATH" value="'+ w_path +'">';
		html += '<input type="hidden" name="DETAIL_W_SAVE" value="'+ w_save_nm +'">';
		html += '<input type="hidden" name="DETAIL_W_REAL" value="'+ w_real_nm +'">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'DETAIL_W_PATH\', \'DETAIL_W_SAVE\', \'DETAIL_W_REAL\');">업로드</button>';
		html += '<span class="file_name" data-path="'+ w_path +'" data-save="'+ w_save_nm +'">&nbsp;['+ w_real_nm +']</span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="24%">';
		html += '<div class="FILE_UPLOAD_CONTANIER">';
		html += '<input type="hidden" name="DETAIL_M_PATH" value="'+ m_path +'">';
		html += '<input type="hidden" name="DETAIL_M_SAVE" value="'+ m_save_nm +'">';
		html += '<input type="hidden" name="DETAIL_M_REAL" value="'+ m_real_nm +'">';
		html += '<button type="button" class="btn btn-success btn-xs" onclick="javascript:file_upload_set(jQuery(this), \'DETAIL_M_PATH\', \'DETAIL_M_SAVE\', \'DETAIL_M_REAL\');">업로드</button>';
		html += '<span class="file_name" data-path="'+ m_path +'" data-save="'+ m_save_nm +'">&nbsp;['+ m_real_nm +']</span>';
		html += '<input type="button" value="미리보기" class="btn btn_pop_preview"/>';
		html += '</div>';
		html += '</td>';
		
		html += '<td width="8%"><button type="button" class="btn btn-danger btn-xs" onclick="javascript:fp_detail_remove(jQuery(this));">삭제</button></td>';
		html += '</tr>';
		html += '</table>';
		html += '</li>';
		
		jQuery("#FP_DETAIL").append(html);
		
		jQuery(".list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				
			},
			stop: function( event, ui ) {
				
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
		
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
	          //console.log(value);
	        }
	      },
	      theme: 'bootstrap'
	    });
		
		jQuery("input[name='FP_DETAIL_BG"+ i +"'], input[name='FP_DETAIL_W"+ i +"'], input[name='FP_DETAIL_M"+ i +"']").each(function() {
			jQuery(this).change(function(){
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
				
				var inputname = jQuery(this).attr("name");
				if(inputname.indexOf("FP_DETAIL_BG") > -1) {
					jQuery(this).closest("td").find("input[name='FP_DETAIL_EXISTS_BG_CHANGE']").val("Y");
				}
				if(inputname.indexOf("FP_DETAIL_W") > -1) {
					jQuery(this).closest("td").find("input[name='FP_DETAIL_EXISTS_W_CHANGE']").val("Y");
				}
				if(inputname.indexOf("FP_DETAIL_M") > -1) {
					jQuery(this).closest("td").find("input[name='FP_DETAIL_EXISTS_M_CHANGE']").val("Y");
				}
				// 이미지 미리보기 버튼 클릭
				imagePreview();
			});
		});
	}
	imagePreview();
});
</script>		
</c:if>