<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
.mainContentDtlWriteTableList { width:100%; margin-bottom:-1px;}
.mainContentDtlWriteTableList .title_column { width:150px; box-sizing:border-box; }
.mainContentDtlWriteTableList .title_cntns { width:auto; box-sizing:border-box; }

form { margin:0; }
.form-inline { float:left; margin-left:15px; margin-bottom:15px; }
.form-inline:first-child { margin-left:0; }
</style>
<script>
jQuery(document).ready(function(){
	jQuery("input[name='IMG']").change(function(){
		var file = jQuery(this)[0].files[0];

		if(typeof file === 'undefined') {
			jQuery(this).closest(".title_cntns").find(".file_name").text("");
			jQuery(this).closest(".title_cntns").find(".btn_pop_preview2").hide();
			return;
		}
		var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
		var fileNm = file.name.substring(0, file.name.lastIndexOf("."));

		jQuery(this).closest(".title_cntns").find(".file_name").html("&nbsp;["+fileNm+"]");
		jQuery(this).closest(".title_cntns").find(".btn_pop_preview2").show();;		
	
		// 이미지 미리보기 버튼 클릭
		imagePreview2();
	});
	
	function imagePreview2(){
		jQuery(".btn_pop_preview2").off("click").on("click", function(){
			var select_file = jQuery(this).closest(".title_cntns").find("input:file");
			if(select_file.val() != '') {
				var file = select_file[0].files[0];
				var reader = new FileReader();
				
		        reader.onload = function(event){
		        	$("#preview").find("img").attr("src", event.target.result);
		        }
	            reader.readAsDataURL(file);
				$("#preview").css("display","table");
				return;
			}else {
				var select_span = jQuery(this).closest(".title_cntns").find(".file_name");
				if(select_span.data("path") != "" && select_span.data("save") != "") {
					var path = select_span.data("path");
			 		var save = select_span.data("save");
					var saveFile = save.split(".");		
				
					//$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=main&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					$("#preview").css("display","table");
				}
			}
		});
	}
	imagePreview2();
	
	jQuery("#writeContentDtlBtn").click(function(){
		var f = document.contentdtl_form;
		if(f.CNTNS_DTL_SEQ.value == "") {
			if(f.IMG.value.replace(/ /g, '') == '') {
				alert("이미지를 등록해주세요.");
				return;
			}
		}
		if(f.TITLE.value.replace(/ /g, '') == '') {
			alert("타이틀을 입력해주세요.");
			f.TITLE.focus();
			return;
		}
		if(f.LINK.value.replace(/ /g, '') == '') {
			alert("링크를 입력해주세요.");
			f.LINK.focus();
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
		
		var form = jQuery("#contentdtl_form")[0];
		var form_data = new FormData(form);
		
		var ajax_url = "/mngwserc/main/contentdtl/insert.ajax";
		var alert_msg = "등록";
		if(f.CNTNS_DTL_SEQ.value != "") {
			ajax_url = "/mngwserc/main/contentdtl/update.ajax";
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
                	content_dtl_manager(f.CNTNS_MST_SEQ.value);
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
<!-- 컨텐츠 상세 등록 -->
<div class="panel panel-default">
	<div class="panel-heading">
		Main 컨텐츠 상세
		<c:if test="${rtnMap.rstMap.cntnsDtlSeq ne null}">수정</c:if>
		<c:if test="${rtnMap.rstMap.cntnsDtlSeq eq null}">등록</c:if>
	</div>
	<div class="panel-body">
		<form name="contentdtl_form" id="contentdtl_form" method="post" action="" enctype="multipart/form-data">
		<input type="hidden" name="CNTNS_DTL_SEQ" value="${ rtnMap.rstMap.cntnsDtlSeq }">
		<input type="hidden" name="CNTNS_MST_SEQ" value="${ cntnsMstSeq }">
		<table class="mainContentDtlWriteTableList table table-bordered">
			<tr>
				<td class="title_column">* 이미지</td>
				<td class="title_cntns">
					<span class="btn fileinput-button">
	                <i class="icon-upload"></i>
	                <span>파일추가</span>
	                <input type="file" name="IMG" accept=".gif, .jpg, .png"/>
		            </span>&nbsp;* 권장 사이즈: 640 x 660
		           
		            <c:choose>
					    <c:when test="${rtnMap.rstMap.imgRealFileNm ne null}">
					        <span class="file_name" data-path="${ rtnMap.rstMap.imgPath }" data-save="${ rtnMap.rstMap.imgSaveFileNm }">&nbsp;[${rtnMap.rstMap.imgRealFileNm}]</span>
							<input type="button" value="미리보기" class="btn_pop_preview2"/>
					    </c:when>    
					    <c:otherwise>
					        <span class="file_name"></span>
							<input type="button" value="미리보기" class="btn_pop_preview2" style="display: none;"/>
					    </c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td class="title_column">* 타이틀</td>
				<td class="title_cntns">
					<input type="text"  class="form-control" name="TITLE" style="width:90%;" value="${rtnMap.rstMap.title}">
				</td>
			</tr>
			<tr>
				<td class="title_column">내용</td>
				<td class="title_cntns">
					<textarea name="DSC" class="form-control" rows="3" style="width:90%;">${rtnMap.rstMap.dsc}</textarea>
				</td>
			</tr>
			<tr>
				<td class="title_column">* 링크</td>
				<td class="title_cntns">
					<input type="text"  class="form-control" name="LINK" style="width:90%;" value="${rtnMap.rstMap.link}">
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
	<div class="panel-footer">
		<c:if test="${rtnMap.rstMap.cntnsDtlSeq ne null}">
		<a href="#" class="btn btn-success" id="writeContentDtlBtn">수정</a>
		</c:if>
		<c:if test="${rtnMap.rstMap.cntnsDtlSeq eq null}">
		<a href="#" class="btn btn-success" id="writeContentDtlBtn">등록</a>
		</c:if>
 	</div>
 </div>
