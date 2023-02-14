<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }
</style>

<div><font color="red">* 반드시 사이즈를 지켜주세요! 이미지간 공백이 생길수 있습니다.</font></div>
<form name="frm" method="post" action ="./action.do" enctype="multipart/form-data">
	<input type="hidden" name="SNS_SEQ" value="${rtnMap.snsInfo.snsSeq}">
	<div class="ui-tabs ui-widget ui-widget-content ui-corner-all" id="tabs">
		<div id="tabs-1">
			<table class="table table-bordered table-hover" style="margin-bottom:0px;">
				<colgroup>
					<col width="17%" />
					<col width="83%" />
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center; vertical-align:middle;">
							* 타입
						</th>
						<td style="text-align:left;">
							<input type="radio" name="TYPE" id="TYPE_L" value="L" <c:if test="${rtnMap.snsInfo.type eq 'L'}">checked</c:if> /> LARGE&nbsp;&nbsp;
							<input type="radio" name="TYPE" id="TYPE_S" value="S" <c:if test="${rtnMap.snsInfo.type eq 'S'}">checked</c:if> /> SMALL&nbsp;&nbsp;
						</td>
					</tr>
					
					<tr id="IMG0_TR">
						<th style="text-align:center; vertical-align:middle;">
							* 이미지
						</th>
						<td style="text-align:left;">
							<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="IMG0" accept=".gif, .jpg, .png"/>
			                </span>&nbsp;* 사이즈: 480px x 480px
			                <c:choose>
							    <c:when test="${rtnMap.snsInfo.img1SaveFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.snsInfo.img1Path }" data-save="${ rtnMap.snsInfo.img1SaveFileNm }">&nbsp;[${rtnMap.snsInfo.img1RealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr id="LINK0_TR">
      					<td style="text-align:center; vertical-align:middle;">* 링크</td>
      					<td style="text-align:left;">
      						<input type="text"  class="form-control" name="LINK0" style="width:100%;" value="${rtnMap.snsInfo.link1}">
      					</td>
      				</tr>
      				<tr id="LINK0_TYPE_TR">
      					<td style="text-align:center; vertical-align:middle;">* 새창여부</td>
      					<td style="text-align:left;">
      						<input type="radio" name="LINK0_TYPE" value="_blank" <c:if test="${rtnMap.snsInfo.link1Type eq '_blank'}">checked</c:if>>&nbsp;새창&nbsp;
							<input type="radio" name="LINK0_TYPE" value="_self" <c:if test="${rtnMap.snsInfo.link1Type eq '_self'}">checked</c:if>>&nbsp;이동&nbsp;
      					</td>
      				</tr>
					
					<tr id="IMG1_TR" style="display:none;">
						<th style="text-align:center; vertical-align:middle;">
							* 이미지1
						</th>
						<td style="text-align:left;">
							<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="IMG1" accept=".gif, .jpg, .png"/>
			                </span>&nbsp;* 사이즈: 240px x 240px
			                <c:choose>
							    <c:when test="${rtnMap.snsInfo.img1SaveFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.snsInfo.img1Path }" data-save="${ rtnMap.snsInfo.img1SaveFileNm }">&nbsp;[${rtnMap.snsInfo.img1RealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr id="LINK1_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 링크</td>
      					<td style="text-align:left;">
      						<input type="text"  class="form-control" name="LINK1" style="width:100%;" value="${rtnMap.snsInfo.link1}">
      					</td>
      				</tr>
      				<tr id="LINK1_TYPE_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 새창여부</td>
      					<td style="text-align:left;">
      						<input type="radio" name="LINK1_TYPE" value="_blank" <c:if test="${rtnMap.snsInfo.link1Type eq '_blank'}">checked</c:if>>&nbsp;새창&nbsp;
							<input type="radio" name="LINK1_TYPE" value="_self" <c:if test="${rtnMap.snsInfo.link1Type eq '_self'}">checked</c:if>>&nbsp;이동&nbsp;
      					</td>
      				</tr>
      				
					<tr id="IMG2_TR" style="display:none;">
						<th style="text-align:center; vertical-align:middle;">
							* 이미지2
						</th>
						<td style="text-align:left;">
							<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="IMG2" accept=".gif, .jpg, .png"/>
			                </span>&nbsp;* 사이즈: 240px x 240px
		                
			                <c:choose>
							    <c:when test="${rtnMap.snsInfo.img2SaveFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.snsInfo.img2Path }" data-save="${ rtnMap.snsInfo.img2SaveFileNm }">&nbsp;[${rtnMap.snsInfo.img2RealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr id="LINK2_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 링크</td>
      					<td style="text-align:left;">
      						<input type="text"  class="form-control" name="LINK2" style="width:100%;" value="${rtnMap.snsInfo.link2}">
      					</td>
      				</tr>
      				<tr id="LINK2_TYPE_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 새창여부</td>
      					<td style="text-align:left;">
      						<input type="radio" name="LINK2_TYPE" value="_blank" <c:if test="${rtnMap.snsInfo.link2Type eq '_blank'}">checked</c:if>>&nbsp;새창&nbsp;
							<input type="radio" name="LINK2_TYPE" value="_self" <c:if test="${rtnMap.snsInfo.link2Type eq '_self'}">checked</c:if>>&nbsp;이동&nbsp;
      					</td>
      				</tr>
      				
					<tr id="IMG3_TR" style="display:none;">
						<th style="text-align:center; vertical-align:middle;">
							* 이미지3
						</th>
						<td style="text-align:left;">
							<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="IMG3" accept=".gif, .jpg, .png"/>
			                </span>&nbsp;* 사이즈: 240px x 240px
		                
			                <c:choose>
							    <c:when test="${rtnMap.snsInfo.img3SaveFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.snsInfo.img3Path }" data-save="${ rtnMap.snsInfo.img3SaveFileNm }">&nbsp;[${rtnMap.snsInfo.img3RealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr id="LINK3_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 링크</td>
      					<td style="text-align:left;">
      						<input type="text"  class="form-control" name="LINK3" style="width:100%;" value="${rtnMap.snsInfo.link3}">
      					</td>
      				</tr>
      				<tr id="LINK3_TYPE_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 새창여부</td>
      					<td style="text-align:left;">
      						<input type="radio" name="LINK3_TYPE" value="_blank" <c:if test="${rtnMap.snsInfo.link3Type eq '_blank'}">checked</c:if>>&nbsp;새창&nbsp;
							<input type="radio" name="LINK3_TYPE" value="_self" <c:if test="${rtnMap.snsInfo.link3Type eq '_self'}">checked</c:if>>&nbsp;이동&nbsp;
      					</td>
      				</tr>
      				
					<tr id="IMG4_TR" style="display:none;">
						<th style="text-align:center; vertical-align:middle;">
							* 이미지4
						</th>
						<td style="text-align:left;">
							<span class="btn fileinput-button">
			                    <i class="icon-upload"></i>
			                    <span>파일추가</span>
			                    <input type="file" name="IMG4" accept=".gif, .jpg, .png"/>
			                </span>&nbsp;* 사이즈: 240px x 240px
		                
			                <c:choose>
							    <c:when test="${rtnMap.snsInfo.img4SaveFileNm ne null}">
							        <span class="file_name" data-path="${ rtnMap.snsInfo.img4Path }" data-save="${ rtnMap.snsInfo.img4SaveFileNm }">&nbsp;[${rtnMap.snsInfo.img4RealFileNm}]</span>
									<input type="button" value="미리보기" class="btn_pop_preview"/>
							    </c:when>    
							    <c:otherwise>
							        <span class="file_name"></span>
									<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr id="LINK4_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 링크</td>
      					<td style="text-align:left;">
      						<input type="text"  class="form-control" name="LINK4" style="width:100%;" value="${rtnMap.snsInfo.link4}">
      					</td>
      				</tr>
      				<tr id="LINK4_TYPE_TR" style="display:none;">
      					<td style="text-align:center; vertical-align:middle;">* 새창여부</td>
      					<td style="text-align:left;">
      						<input type="radio" name="LINK4_TYPE" value="_blank" <c:if test="${rtnMap.snsInfo.link4Type eq '_blank'}">checked</c:if>>&nbsp;새창&nbsp;
							<input type="radio" name="LINK4_TYPE" value="_self" <c:if test="${rtnMap.snsInfo.link4Type eq '_self'}">checked</c:if>>&nbsp;이동&nbsp;
      					</td>
      				</tr>
					
					
      				<tr>
      					<th style="text-align:center; vertical-align:middle;">* 사용여부</th>
      					<td style="text-align:left;">
      						<input type="radio" name="USE_YN" value="Y" <c:if test="${rtnMap.snsInfo.useYn eq 'Y'}">checked</c:if>>&nbsp;예&nbsp;
							<input type="radio" name="USE_YN" value="N" <c:if test="${rtnMap.snsInfo.useYn eq 'N'}">checked</c:if>>&nbsp;아니요&nbsp;
      					</td>
      				</tr>
      				<tr>
      					<th style="text-align:center; vertical-align:middle;">* 사용기간</th>
      					<td style="text-align:left;">
      						<input type="date" name="USE_STRT_DTM" value="${rtnMap.snsInfo.useStrtDtm}">&nbsp; ~ &nbsp;
							<input type="date" name="USE_END_DTM" value="${rtnMap.snsInfo.useEndDtm}">&nbsp;
      					</td>
      				</tr>
				</tbody>
			</table>	
		</div>
		
	</div>
</form>

<div style="margin-top:20px;">
	<div style="text-align:right;">
		<c:choose>
			<c:when test="${empty boardInfo}">
				<a href="javascript:chkForm();" class="btn btn-success">등록</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
			</c:otherwise>
		</c:choose>
		<a href="./index.do" class="btn btn-default">취소</a>
	</div>
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

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("#TYPE_L").click(function(){
			type_change();
			
		});
		jQuery("#TYPE_S").click(function(){
			type_change();
		});
		type_change();
		imagePreview();
	});
	
	function type_change(){
		if(jQuery("#TYPE_L").prop("checked") == true){
			jQuery("#IMG1_TR, #IMG2_TR, #IMG3_TR, #IMG4_TR").hide();
			jQuery("#LINK1_TR, #LINK2_TR, #LINK3_TR, #LINK4_TR").hide();
			jQuery("#LINK1_TYPE_TR, #LINK2_TYPE_TR, #LINK3_TYPE_TR, #LINK4_TYPE_TR").hide();
			jQuery("#IMG0_TR").show();
			jQuery("#LINK0_TR").show();
			jQuery("#LINK0_TYPE_TR").show();
		}
		if(jQuery("#TYPE_S").prop("checked") == true){
			jQuery("#IMG1_TR, #IMG2_TR, #IMG3_TR, #IMG4_TR").show();
			jQuery("#LINK1_TR, #LINK2_TR, #LINK3_TR, #LINK4_TR").show();
			jQuery("#LINK1_TYPE_TR, #LINK2_TYPE_TR, #LINK3_TYPE_TR, #LINK4_TYPE_TR").show();
			jQuery("#IMG0_TR").hide();
			jQuery("#LINK0_TR").hide();
			jQuery("#LINK0_TYPE_TR").hide();
		}
	}
	
	jQuery("input[name='IMG0'], input[name='IMG1'], input[name='IMG2'], input[name='IMG3'], input[name='IMG4']").change(function(){
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
					jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=sns&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").css("display","table");
				}
			}
		});
	}
	
	//등록하기
	function chkForm()
	{
		var f = document.frm;
		
		if(f.TYPE[0].checked == false && f.TYPE[1].checked == false) {
			alert("타입을 선택해주세요.");
			f.TYPE[0].focus();
			return;
		}
		
		if(f.TYPE[0].checked == true) {
			if(f.SNS_SEQ.value == "") {
				if(f.IMG0.value.replace(/ /g, '') == '') {
					alert("이미지를 선택해주세요.");
					f.IMG0.focus();
					return;
				}
				var imgExt = "|jpg|jpeg|png|gif";
				var fileType = f.IMG0.value.substring(f.IMG0.value.lastIndexOf(".") + 1);
				if (imgExt.indexOf("|" + fileType.toLowerCase() + "|") == -1) {
					alert("jpg,jpeg,png,gif 파일만 저장할 수 있습니다.");
					return;
				}
			}
			
			if(f.LINK0.value.replace(/ /g, '') == '') {
				alert("링크를 입력해주세요.");
				f.LINK0.focus();
				return;
			}
			if(f.LINK0_TYPE[0].checked == false && f.LINK0_TYPE[1].checked == false) {
				alert("새창여부를 선택해주세요.");
				f.LINK0_TYPE[0].focus();
				return;
			}
		}
		
		if(f.TYPE[1].checked == true) {
			if(f.SNS_SEQ.value == "") {
				if(f.IMG1.value.replace(/ /g, '') == '') {
					alert("이미지1를 선택해주세요.");
					f.IMG1.focus();
					return;
				}
				var imgExt = "|jpg|jpeg|png|gif";
				var fileType = f.IMG1.value.substring(f.IMG1.value.lastIndexOf(".") + 1);
				if (imgExt.indexOf("|" + fileType.toLowerCase() + "|") == -1) {
					alert("jpg,jpeg,png,gif 파일만 저장할 수 있습니다.");
					return;
				}
			}
			
			if(f.LINK1.value.replace(/ /g, '') == '') {
				alert("링크1를 입력해주세요.");
				f.LINK1.focus();
				return;
			}
			if(f.LINK1_TYPE[0].checked == false && f.LINK1_TYPE[1].checked == false) {
				alert("새창여부1를 선택해주세요.");
				f.LINK1_TYPE[0].focus();
				return;
			}
			if(f.SNS_SEQ.value == "") {
				if(f.IMG2.value.replace(/ /g, '') == '') {
					alert("이미지2를 선택해주세요.");
					f.IMG2.focus();
					return;
				}
				var imgExt = "|jpg|jpeg|png|gif";
				var fileType = f.IMG2.value.substring(f.IMG2.value.lastIndexOf(".") + 1);
				if (imgExt.indexOf("|" + fileType.toLowerCase() + "|") == -1) {
					alert("jpg,jpeg,png,gif 파일만 저장할 수 있습니다.");
					return;
				}
			}
			if(f.LINK2.value.replace(/ /g, '') == '') {
				alert("링크2를 입력해주세요.");
				f.LINK2.focus();
				return;
			}
			if(f.LINK2_TYPE[0].checked == false && f.LINK2_TYPE[1].checked == false) {
				alert("새창여부2를 선택해주세요.");
				f.LINK2_TYPE[0].focus();
				return;
			}
			if(f.SNS_SEQ.value == "") {
				if(f.IMG3.value.replace(/ /g, '') == '') {
					alert("이미지3를 선택해주세요.");
					f.IMG3.focus();
					return;
				}
				var imgExt = "|jpg|jpeg|png|gif";
				var fileType = f.IMG3.value.substring(f.IMG3.value.lastIndexOf(".") + 1);
				if (imgExt.indexOf("|" + fileType.toLowerCase() + "|") == -1) {
					alert("jpg,jpeg,png,gif 파일만 저장할 수 있습니다.");
					return;
				}
			}
			
			if(f.LINK3.value.replace(/ /g, '') == '') {
				alert("링크3를 입력해주세요.");
				f.LINK3.focus();
				return;
			}
			if(f.LINK3_TYPE[0].checked == false && f.LINK3_TYPE[1].checked == false) {
				alert("새창여부3를 선택해주세요.");
				f.LINK3_TYPE[0].focus();
				return;
			}
			if(f.SNS_SEQ.value == "") {
				if(f.IMG4.value.replace(/ /g, '') == '') {
					alert("이미지4를 선택해주세요.");
					f.IMG4.focus();
					return;
				}
				var imgExt = "|jpg|jpeg|png|gif";
				var fileType = f.IMG4.value.substring(f.IMG4.value.lastIndexOf(".") + 1);
				if (imgExt.indexOf("|" + fileType.toLowerCase() + "|") == -1) {
					alert("jpg,jpeg,png,gif 파일만 저장할 수 있습니다.");
					return;
				}
			}
			if(f.LINK4.value.replace(/ /g, '') == '') {
				alert("링크4를 입력해주세요.");
				f.LINK4.focus();
				return;
			}
			if(f.LINK4_TYPE[0].checked == false && f.LINK4_TYPE[1].checked == false) {
				alert("새창여부4를 선택해주세요.");
				f.LINK4_TYPE[0].focus();
				return;
			}
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
		
		var msg = "";
		<c:choose>
			<c:when test="${not empty boardInfo}">
			msg = "수정하시겠습니까?";		
			</c:when>
			<c:otherwise>
			msg = "등록하시겠습니까?";
			</c:otherwise>
		</c:choose>
	
		
		if(confirm(msg))
		{	
			f.submit();
		}		
	}
</script>