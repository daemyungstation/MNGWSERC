<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<script src="/common/js/jquery.minicolors.js"></script>
<link rel="stylesheet" href="/common/css/jquery.minicolors.css">
  
<style>
.mainVisualTableList { width:1470px; margin-bottom:-1px;}
.mainVisualTableList .title { width:250px; text-align:center; box-sizing:border-box; }
.mainVisualTableList .title_type { width:150px; text-align:center; box-sizing:border-box; }
.mainVisualTableList .title_column { width:150px; box-sizing:border-box; }
.mainVisualTableList .title_cntns { width:1170px; box-sizing:border-box; }

form { margin:0; }
.form-inline { float:left; margin-left:15px; margin-bottom:15px; }
.form-inline:first-child { margin-left:0; }
</style>

<script>
jQuery(document).ready(function(){

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

    
	jQuery("input[name='WEB_BG'], input[name='WEB_TITLE'], input[name='WEB_BTN'], input[name='MO']").change(function(){
		var file = jQuery(this)[0].files[0];

		if(typeof file === 'undefined') {
			jQuery(this).closest(".title_cntns").find(".file_name").text("");
			jQuery(this).closest(".title_cntns").find(".btn_pop_preview").hide();
			return;
		}
		var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
		var fileNm = file.name.substring(0, file.name.lastIndexOf("."));

		jQuery(this).closest(".title_cntns").find(".file_name").html("&nbsp;["+fileNm+"]");
		jQuery(this).closest(".title_cntns").find(".btn_pop_preview").show();;		
	
		// 이미지 미리보기 버튼 클릭
		imagePreview();
	});
	
	function imagePreview(){
		jQuery(".btn_pop_preview").off("click").on("click", function(){
			var select_file = jQuery(this).closest(".title_cntns").find("input:file");
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
				var select_span = jQuery(this).closest(".title_cntns").find(".file_name");
				if(select_span.data("path") != "" && select_span.data("save") != "") {
					var path = select_span.data("path");
			 		var save = select_span.data("save");
					var saveFile = save.split(".");		
				
					//jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=main&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").css("display","table");
				}
			}
		});
	}
	imagePreview();
	
	jQuery("#writeVisualBtn").click(function(){
		var f = document.visual_form;
		if(f.VISUAL_SEQ.value == "") {
			if(f.WEB_BG.value.replace(/ /g, '') == '') {
				alert("배경이미지를 등록해주세요.");
				return;
			}
			if(f.WEB_TITLE.value.replace(/ /g, '') == '') {
				alert("타이틀 이미지를 등록해주세요.");
				return;
			}
			if(f.WEB_BTN.value.replace(/ /g, '') == '') {
				alert("버튼 이미지를 등록해주세요.");
				return;
			}
		}
		if(f.LINK.value.replace(/ /g, '') == '') {
			alert("링크를 입력해주세요.");
			f.LINK.focus();
			return;
		}
		if(f.LINK_TYPE[0].checked == false && f.LINK_TYPE[1].checked == false) {
			alert("새창여부를 선택해주세요.");
			f.LINK_TYPE[0].focus();
			return;
		}
		if(f.USE_YN[0].checked == false && f.USE_YN[1].checked == false) {
			alert("사용여부를 선택해주세요.");
			f.USE_YN[0].focus();
			return;
		}
		if(f.USE_STRT_DTM.value.replace(/ /g, '') == '') {
			alert("사용시작일을 입력해주세요.");
			f.USE_STRT_DTM.focus();
			return;
		}
		if(f.USE_END_DTM.value.replace(/ /g, '') == '') {
			alert("사용마감일을 입력해주세요.");
			f.USE_END_DTM.focus();
			return;
		}
		
		var form = jQuery("#visual_form")[0];
		var form_data = new FormData(form);
		
		var ajax_url = "/mngwserc/main/visual/insert.ajax";
		var alert_msg = "등록";
		if(f.VISUAL_SEQ.value != "") {
			ajax_url = "/mngwserc/main/visual/update.ajax";
			alert_msg = "수정";
		}
		jQuery.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: ajax_url,
            data: form_data,
            dataType: "json",
            processData: false,
            contentType: false,
            cache: false,
            beforeSend: function() {
            	jQuery("#form-loading").show();
            },
            success: function (data) {
                if(data.result == "OK") {
                	alert(alert_msg +" 완료되었습니다.");
                	visual_manager(f.GRP_ID.value);
                }else {
                	alert(alert_msg +"에 실패하였습니다.\n다시 시도해주세요.");
                	document.location.reload();
                }
            },
            error: function (e) {
                alert("ERROR : "+alert_msg +"에 실패하였습니다.\n다시 시도해주세요.", e);
            },
            complete: function() {
            	jQuery("#form-loading").hide();
            }
        });
	});
});
</script>

<!-- 메인 등록 Modal -->
<div class="modal fade" id="mainVisualListModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1500px; margin-left: -750px;">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="myModalLabel">Main Visual
	        		<c:if test="${rtnMap.rstMap.visualSeq ne null}">수정</c:if>
	      			<c:if test="${rtnMap.rstMap.visualSeq eq null}">등록</c:if>
        		</h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
      			<form name="visual_form" id="visual_form" method="post" action="" enctype="multipart/form-data">
      			<input type="hidden" name="VISUAL_SEQ" value="${ rtnMap.rstMap.visualSeq }">
      			<table class="mainVisualTableList table table-bordered">
      				<tr>
      					<td class="title_column">* 그룹</td>
      					<td class="title_cntns">
      						<select name="GRP_ID" style="width:100%;">
      							<option value="">새로생성</option>
      							<c:forEach var="grp" items="${rtnMap.grpIds}">
									<option value="${ grp.grpId }" <c:if test="${rtnMap.rstMap.grpId eq grp.grpId || searchGrpId eq grp.grpId}">selected</c:if>>그룹${ grp.grpId }</option>
		  						</c:forEach>
      						</select>
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">배경색</td>
      					<td class="title_cntns"><input type="text" name="webBgColor" value="${ rtnMap.rstMap.webBgColor }"class="form-control minicolor" data-control="wheel"> ex) #ffffff</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 배경이미지</td>
      					<td class="title_cntns">
      						<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="WEB_BG" accept=".gif, .jpg, .png"/>
			                </span>
			                <br>* 사이즈: 960px 보다 작게 x 977px 보다 작게 (화면 크기에 맞춰 이미지 크기 자동 변화 적용)
			                <br>* 기본정렬 : 우측하단  bottom:0px, right:50px
		                
			                <c:choose>
							    <c:when test="${rtnMap.rstMap.webBgRealFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.rstMap.webBgPath }" data-save="${ rtnMap.rstMap.webBgSaveFileNm }">&nbsp;[${rtnMap.rstMap.webBgRealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 타이틀이미지</td>
      					<td class="title_cntns">
      						<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="WEB_TITLE" accept=".gif, .jpg, .png"/>
			                </span>
			                <br>* 사이즈: 960px 보다 작게 x 977px 보다 작게 (화면 크기에 맞춰 이미지 크기 자동 변화 적용)
			                <br>* 기본정렬 : 좌측상단 top:50px, left:50px

			                <c:choose>
							    <c:when test="${rtnMap.rstMap.webTitleRealFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.rstMap.webTitlePath }" data-save="${ rtnMap.rstMap.webTitleSaveFileNm }">&nbsp;[${rtnMap.rstMap.webTitleRealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">타이틀이미지-설명(alt)</td>
      					<td class="title_cntns">
      						<input type="text"  class="form-control" name="WEB_TITLE_DSC" style="width:100%;" value="${rtnMap.rstMap.webTitleDsc}">
      					</td>
      				</tr>      				
      				<tr>
      					<td class="title_column">타이틀내용</td>
      					<td class="title_cntns">
      						<textarea name="WEB_TITLE_TXT" class="form-control" rows="3" style="width:100%;">${rtnMap.rstMap.webTitleTxt}</textarea>
      						<br>*작은 내용 삽입은 ##로 감싸주세요. ex) 19년 대명아임레디 수상내역 ##올해의 소비자 공감브랜드 대상##
      						<br>* 기본정렬 : 좌측상단 top:250px, left:50px
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 버튼이미지</td>
      					<td class="title_cntns">
      						<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="WEB_BTN" accept=".gif, .jpg, .png"/>
			                </span>
			                <br>* 사이즈: 960px 보다 작게 x 977px 보다 작게 (화면 크기에 맞춰 이미지 크기 자동 변화 적용)
			                <br>* 기본정렬 : 좌측하단 bottom:100px, left:50px
			                
			                <c:choose>
							    <c:when test="${rtnMap.rstMap.webBtnRealFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.rstMap.webBtnPath }" data-save="${ rtnMap.rstMap.webBtnSaveFileNm }">&nbsp;[${rtnMap.rstMap.webBtnRealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 링크</td>
      					<td class="title_cntns">
      						<input type="text"  class="form-control" name="LINK" style="width:100%;" value="${rtnMap.rstMap.link}">
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 새창여부</td>
      					<td class="title_cntns">
      						<input type="radio" name="LINK_TYPE" value="_blank" <c:if test="${rtnMap.rstMap.linkType eq '_blank'}">checked</c:if>>&nbsp;새창&nbsp;
							<input type="radio" name="LINK_TYPE" value="_self" <c:if test="${rtnMap.rstMap.linkType eq '_self'}">checked</c:if>>&nbsp;이동&nbsp;
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 사용여부</td>
      					<td class="title_cntns">
      						<input type="radio" name="USE_YN" value="Y" <c:if test="${rtnMap.rstMap.useYn eq 'Y'}">checked</c:if>>&nbsp;예&nbsp;
							<input type="radio" name="USE_YN" value="N" <c:if test="${rtnMap.rstMap.useYn eq 'N'}">checked</c:if>>&nbsp;아니요&nbsp;
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 사용기간</td>
      					<td class="title_cntns">
      						<input type="date" name="USE_STRT_DTM" value="${rtnMap.rstMap.useStrtDtm}">&nbsp; ~ &nbsp;
							<input type="date" name="USE_END_DTM" value="${rtnMap.rstMap.useEndDtm}">&nbsp;
      					</td>
      				</tr>
      			</table>
      			</form>
      		</div>
      		<div class="modal-footer">
      			<c:if test="${rtnMap.rstMap.visualSeq ne null}">
      			<a href="#" class="btn btn-success" id="writeVisualBtn">수정</a>
      			</c:if>
      			<c:if test="${rtnMap.rstMap.visualSeq eq null}">
      			<a href="#" class="btn btn-success" id="writeVisualBtn">등록</a>
      			</c:if>
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
      		</div>
    	</div>
  	</div>
</div>
