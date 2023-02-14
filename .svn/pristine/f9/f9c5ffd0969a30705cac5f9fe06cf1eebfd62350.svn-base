<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
@font-face{
	font-family:"NanumSquareR";
	src:url('/common/css/fonts/NanumSquareR.eot');
	src:url('/common/css/fonts/NanumSquareR.eot?#iefix') format('embedded-opentype'),
	url('/common/css/fonts/NanumSquareR.woff') format('woff'),
	url('/common/css/fonts/NanumSquareR.ttf') format('truetype');
	src:local('?'), url('/common/css/fonts/NanumSquareR.woff') format('woff');
}
@font-face{
	font-family:"NanumSquareB";
	src:url('/common/css/fonts/NanumSquareB.eot');
	src:url('/common/css/fonts/NanumSquareB.eot?#iefix') format('embedded-opentype'),
	url('/common/css/fonts/NanumSquareB.woff') format('woff'),
	url('/common/css/fonts/NanumSquareB.ttf') format('truetype');
	src:local('?'), url('/common/css/fonts/NanumSquareB.woff') format('woff');
}

@font-face{
	font-family:"NanumSquareEB";
	src:url('/common/css/fonts/NanumSquareEB.eot');
	src:url('/common/css/fonts/NanumSquareEB.eot?#iefix') format('embedded-opentype'),
	url('/common/css/fonts/NanumSquareEB.woff') format('woff'),
	url('/common/css/fonts/NanumSquareEB.ttf') format('truetype');
	src:local('?'), url('/common/css/fonts/NanumSquareEB.woff') format('woff');
}

.main_container { position:relative; width:1920px; height:977px; margin:0 auto; }
.main_container .zindex-2 { z-index:3; position:relative; }
.ml-1 { margin-left:5px; }
.mt-1 { margin-top:5px; }
.mb-1 { margin-bottom:5px; }
.mr-1 { margin-right:5px; }

.main_container .main_visual { float:left; width:50%; height:100%; margin-top:10px; position:relative; }
.main_container .main_visual .dim { position:absolute; width:100%; height:100%; top:0; left:0; background:#000; opacity:0.1; z-index:1; }
.main_container .main_visual .visual_container { position:absolute; width:100%; height:100%; top:0; left:0; z-index:2; overflow:hidden; }
.main_container .main_visual .visual_container .visual_content { position:absolute; width:100%; height:100%; top:0; left:0; display:none; }
.main_container .main_visual .visual_container .visual_content:first-child { display:block; }
.main_container .main_visual .visual_container .visual_slide_btns .visual_prev { position:absolute; top:50%; left:0;  margin-top:-33px; }
.main_container .main_visual .visual_container .visual_slide_btns .visual_next { position:absolute; top:50%; right:0;  margin-top:-33px; }

.main_container .main_visual .visual_container .visual_content .visual_img { position:absolute; display:inline-block;border:2px dotted red; box-sizing:border-box; cursor:move; }
.main_container .main_visual .visual_container .visual_content .visual_title { position:relative; display:block; cursor:move; }
.main_container .main_visual .visual_container .visual_content .visual_title img { border:2px dotted red; box-sizing:border-box; }
.main_container .main_visual .visual_container .visual_content .visual_txt { position:relative; display:block; border:2px dotted red; box-sizing:border-box; cursor:move; }
.main_container .main_visual .visual_container .visual_content .visual_txt span { box-sizing:border-box; cursor:move; font-size: 21px; font-family: 'NanumSquareR', dotum,asans-serif; color: #282828; line-height: 160%; font-weight: 600; }
.main_container .main_visual .visual_container .visual_content .visual_txt small { font-size:0.8rem; display:block; line-height:120%; }
.main_container .main_visual .visual_container .visual_content .visual_btn { position:absolute; display:inline-block;border:2px dotted red; box-sizing:border-box; cursor:move; }

.main_container .main_content { float:left; width:50%; height:100%; margin-top:10px; position:relative; border-left:1px solid #000; box-sizing:border-box; overflow-y:auto;  background: url(/common/images/admin/right_bg.jpg) center top repeat-y; }
.main_container .main_content .dim { position:absolute; width:100%; height:100%; top:0; left:0; background:#000; opacity:0.1; z-index:1; }
.main_container .main_content .main_contents { position:relative; z-index:2;}
.main_container .main_content .main_contents .content_section { position: relative; padding-top: 35px; box-sizing: border-box; z-index:3; }
.main_container .main_content .main_contents .content_section .content_section_title { position: relative; padding-top: 25px; box-sizing: border-box; font-size: 28px; font-family: 'NanumSquareR', dotum,asans-serif; color: #000000; letter-spacing: -1px; text-align: center; }
.main_container .main_content .main_contents .content_section .content_section_title span { font-family: 'NanumSquareEB', dotum,asans-serif; font-size: 34px; font-weight: 800; }
.main_container .main_content .main_contents .content_section .content_section_title .top-bar { position: absolute; top: 0px; left: 50%; margin-left: -25px; width: 50px; height: 2px; z-index:3; }
.main_container .main_content .main_contents .content_section .content_section_container { position: relative; width: 90%; margin: 35px auto 0 auto; }
.main_container .main_content .main_contents .content_section .content_section_container .content_section_inner { float: left; margin-left: 2%; width: 49%; }
.main_container .main_content .main_contents .content_section .content_section_container .content_section_inner:first-child { margin-left:0; }
.main_container .main_content .main_contents .content_section .content_section_container .content_section_inner .contents_img { width: 100%; }
.main_container .main_content .main_contents .content_section .content_section_container .content_section_inner .contents_img img{ width: 100%; }
.main_container .main_content .main_contents .content_section .content_section_container .content_section_inner .contents_title { margin-top: 20px; font-family: 'NanumSquareEB', dotum,asans-serif; font-size: 18px; }
.main_container .main_content .main_contents .content_section .content_section_container .content_section_inner .contents_dsc { margin-top: 10px; font-family: 'NanumSquareB', dotum,asans-serif; font-size: 20px; line-height: 140%; word-break: keep-all; }

.modal-footer { text-align:center; }

#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }

#form-loading {	position:fixed;	display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 99999; }
#form-loading > div{ display:table-cell; text-align:center; vertical-align:middle; }
</style>

<script>
// 비주얼 영역 관리
function visual_manager(grpId) {
	jQuery.ajax({
		url: "/mngwserc/main/visual/list.do",
		type: "get",
		dataType: "html",
		data: { grpId: grpId },
		success: function(data) {
			jQuery("#mainVisualListModalPop").hide();
			jQuery(".modal-backdrop").remove();
			jQuery("#mainModalPop").html(data);
			jQuery("#mainVisualListModalPop").modal({
				backdrop: 'static',
				keyboard: false
			});
			$('#mainVisualListModalPop').on('hidden.bs.modal', function (e) {
				location.reload();
			});
		}
	});
}
function visual_live() {
	var grpId = jQuery("#mainGrpId").val();
	if(grpId != "") {
		if(confirm("메인으로 적용하시겠습니까?")) {
			jQuery.ajax({
				url: "/mngwserc/main/live.ajax",
				type: "POST",
				dataType: "JSON",
				data: { grpId: grpId },
				beforeSend: function() {
					jQuery("#form-loading").show();
	            },
	            complete: function() {
	            	jQuery("#form-loading").hide();
	            },
				success: function(data) {
					document.location.reload();
				}
			});
		}
	}else {
		alert("그룹이 선택되지 않았습니다.");
	}
}

//컨텐츠 영역 관리
function content_manager(grpId) {
	jQuery.ajax({
		url: "/mngwserc/main/content/list.do",
		type: "get",
		dataType: "html",
		data: { grpId: grpId },
		success: function(data) {
			jQuery("#mainContentListModalPop").hide();
			jQuery(".modal-backdrop").remove();
			jQuery("#mainModalPop").html(data);
			jQuery("#mainContentListModalPop").modal({
				backdrop: 'static',
				keyboard: false
			});
			$('#mainContentListModalPop').on('hidden.bs.modal', function (e) {
				location.reload();
			});
		}
	});
}

function preview_close() {
	jQuery("#preview").css("display","none");
};

function main_change(grpId) {
	document.location.href = "/mngwserc/main/index.do?grpId="+grpId;
}

jQuery(document).ready(function(){
	var visual_slide = 0;
	jQuery(".visual_prev").click(function(){
		visual_slide--;
		if(visual_slide < 0) {
			visual_slide = jQuery(".visual_content").length - 1;
		}
		jQuery(".visual_content").hide();
		jQuery(".visual_content").eq(visual_slide).show();
	});
	
	jQuery(".visual_next").click(function(){
		visual_slide++;
		if(visual_slide > jQuery(".visual_content").length - 1) {
			visual_slide = 0;
		}
		jQuery(".visual_content").hide();
		jQuery(".visual_content").eq(visual_slide).show();
	});
	
	$(".visual_title, .visual_txt, .visual_btn").draggable({
		start: function(event, ui) {
			jQuery(this).css("bottom", "auto");
		},
		stop: function(event, ui) {
			var parent_w = jQuery(this).closest(".visual_content").width();
			var parent_h = jQuery(this).closest(".visual_content").height();
			var column = jQuery(this).data("column");
			var seq = jQuery(this).data("seq");
			
			var top = ui.position.top;
			var left = ui.position.left;
			//var bottom = parent_h - top - jQuery(this).find("img").height();
			var right = 0;
			
			var top_pct = (top / parent_h) * 100;
			var left_pct = (left / parent_w) * 100;
			var bottom_pct = (((parent_h - top - jQuery(this).find("img").height()) / parent_h) * 100);
			
			jQuery.ajax({
				url: "/mngwserc/main/xy.ajax",
				type: "POST",
				dataType: "JSON",
				data: {
					visualSeq: seq,
					column: column,
					top: top_pct,
					left: left_pct, 
					right: right,
					bottom: bottom_pct
				},
				beforeSend: function() {
					jQuery("#form-loading").show();
	            },
	            complete: function() {
	            	jQuery("#form-loading").hide();
	            },
				success: function(data) {
					var i = 1;
					jQuery("#visual_list_sortable > li").each(function(){
						jQuery(this).find(".order").text(i);
						i++;
					});
				}
			});
		}
	});
	$(".visual_img").draggable({
		containment: ".main_visual",
		snap: ".main_visual",
		start: function(event, ui) {
			jQuery(this).css("bottom", "auto");
		},
		stop: function(event, ui) {
			var parent_w = jQuery(this).closest(".visual_content").width();
			var parent_h = jQuery(this).closest(".visual_content").height();
			var column = jQuery(this).data("column");
			var seq = jQuery(this).data("seq");
			var top = ui.position.top;
			var left = ui.position.left;
			var right = 0;
			var bottom = parent_h - top - jQuery(this).find("img").height();

			if((left + jQuery(this).find("img").width() + 4) >= parent_w) {
				left = "auto";
				right = "0";
			}else{
				right = "auto";
			}
			if((top + jQuery(this).find("img").height() + 4) >= parent_h) {
				top = "auto";
				bottom = "0";
			}else{
				bottom = "auto";
			}
			jQuery.ajax({
				url: "/mngwserc/main/xy.ajax",
				type: "POST",
				dataType: "JSON",
				data: {
					visualSeq: seq,
					column: column,
					top: top,
					left: left, 
					right: right,
					bottom: bottom
				},
				beforeSend: function() {
					jQuery("#form-loading").show();
	            },
	            complete: function() {
	            	jQuery("#form-loading").hide();
	            },
				success: function(data) {
					var i = 1;
					jQuery("#visual_list_sortable > li").each(function(){
						jQuery(this).find(".order").text(i);
						i++;
					});
				}
			});
		}
	});
});

function preview_web(url) {
	window.open("/mngwserc/main/preview.do?grpId="+jQuery('#mainGrpId').val(), "_blank");
}
function preview_mobile(url) {
	window.open("/mngwserc/main/preview.do?grpId="+jQuery('#mainGrpId').val(), "_blank", "width=640, height=800");
}
</script>

<div class="main_container">
	<!-- 미리보기 버튼 -->
	<div class="main_btns">
		<a href="javascript:preview_web();" target="_blank" class="btn btn-primary btn-sm pull-left zindex-2">WEB 미리보기</a>
		<a href="javascript:preview_mobile();" class="btn btn-primary btn-sm pull-left mt zindex-2 ml-1">MOBILE 미리보기</a>
		<select name="grpId" id="mainGrpId" class="form-inline pull-left ml-1" onchange="javascript:main_change(this.value);">
			<c:forEach var="grp" items="${rtnMap.grpIds}">
				<option value="${ grp.grpId }" <c:if test="${grp.grpId eq mainGrpId}">selected</c:if>>그룹${ grp.grpId }<c:if test="${grp.grpId eq grp.liveGrpId}">-LIVE</c:if></option>
			</c:forEach>
		</select>
		<a href="javascript:visual_live();" class="btn btn-danger btn-sm pull-left mt zindex-2 ml-1">메인적용</a>
		<a href="javascript:document.location.reload();" class="btn btn-warning btn-sm pull-left mt zindex-2 ml-1">새로고침</a>
		<div class="clearfix"></div>
	</div>
	
	<!-- 비쥬얼 영역 -->
	<div class="main_visual">
		<a href="javascript:visual_manager(jQuery('#mainGrpId').val());" class="btn btn-success btn-sm pull-right zindex-2 mt-1 mr-1">편집</a>
		
		<div class="visual_container">
			<c:if test="${fn:length(rtnMap.visualList) > 0}">
				<c:forEach var="vlist" items="${rtnMap.visualList}" varStatus="status">
					<div class="visual_content" style="background:${ vlist.webBgColor };">
						<div class="visual_img" data-column="bg_xy" data-seq="${ vlist.visualSeq }" style="top:${ vlist.bgXyAry[0] }; left:${ vlist.bgXyAry[1] }; right:${ vlist.bgXyAry[2] }; bottom:${ vlist.bgXyAry[3] };">
							<%-- 
							<img src="/cmm/fms/getPrevImage.do?path=${ vlist.webBgPath }&fileNm=${ vlist.webBgSaveFileNm }&fileExtn=">
							--%>
							<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ vlist.webBgSaveFileNm }&fileExtn=">
						</div>
						<div class="visual_title" data-column="title_img_xy" data-seq="${ vlist.visualSeq }" style="top:${ vlist.titleImgXyAry[0] }%; left:${ vlist.titleImgXyAry[1] }%;">
							<%-- 
							<img src="/cmm/fms/getPrevImage.do?path=${ vlist.webTitlePath }&fileNm=${ vlist.webTitleSaveFileNm }&fileExtn="/>
							--%>
							<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ vlist.webTitleSaveFileNm }&fileExtn="/>
						</div>
						<c:if test="${vlist.webTitleTxt ne ''}">
							<div class="visual_txt" data-column="title_txt_xy"  data-seq="${ vlist.visualSeq }" style="top:${ vlist.titleTxtXyAry[0] }%; left:${ vlist.titleTxtXyAry[1] }%;">
								<span>${ vlist.webTitleTxt }</span>
							</div>
						</c:if>
						<div class="visual_btn" data-column="btn_xy" data-seq="${ vlist.visualSeq }" style="bottom:${ vlist.btnXyAry[0] }%; left:${ vlist.btnXyAry[1] }%;">
							<%-- 
							<img src="/cmm/fms/getPrevImage.do?path=${ vlist.webBtnPath }&fileNm=${ vlist.webBtnSaveFileNm }&fileExtn="/>
							--%>
							<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ vlist.webBtnSaveFileNm }&fileExtn="/>
						</div>
					</div>
				</c:forEach>
				<div class="visual_slide_btns">
					<img src="/common/images/admin/slide_prev_btn.png" class="visual_prev">
					<img src="/common/images/admin/slide_next_btn.png" class="visual_next">
				</div>
			</c:if>
		</div>
		<!-- <div class="dim"></div> -->
	</div>
	
	<!-- 컨텐츠 영억 -->
	<div class="main_content">
		<div class="main_contents">
			<!--  편집버튼 -->
			<a href="javascript:content_manager(jQuery('#mainGrpId').val());" class="btn btn-success btn-sm pull-left ml-1 mt-1 mr-1" style="position:relative; z-index:4;">편집</a>
 
			<c:if test="${fn:length(rtnMap.contentList) > 0}">
				<c:forEach var="clist" items="${rtnMap.contentList}">
					<div class="content_section">
						<div class="content_section_title">
							<div class="top-bar" style="background:${ clist.titleColor };"></div>
							${ clist.titleTxt }
						</div>
						<c:if test="${fn:length(rtnMap.contentDtlList) > 0}">
							<div class="content_section_container">
								<c:forEach var="dlist" items="${rtnMap.contentDtlList}">
									<c:if test="${dlist.cntnsMstSeq eq clist.cntnsMstSeq}">
										<div class="content_section_inner">
											<div class="contents_img">
												<a href="${ dlist.link }" target="_blank">
													<%-- 
													<img src="/cmm/fms/getPrevImage.do?path=${ dlist.imgPath }&fileNm=${ dlist.imgSaveFileNm }&fileExtn="/>
													--%>
													<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ dlist.imgSaveFileNm }&fileExtn="/>
												</a>
											</div>
											<div class="contents_title">
												${ dlist.title }
											</div>
											<c:if test="${dlist.dsc ne ''}">
												<div class="contents_dsc">
													${ dlist.dsc }
												</div>
											</c:if>
										</div>
									</c:if>
								</c:forEach>
								<div style="clear:both;"></div>
							</div>
						</c:if>
					</div>
				</c:forEach>
			</c:if>
		</div>
		
		<!-- <div class="dim"></div> -->
	</div>
	
	<div class="clearfix"></div>
</div>

<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<button type="button" onclick="preview_close()"
			class="btn btn-success btn-sm mb-1">닫기</button>
		<div>
			<img src="" />
		</div>
	</div>
</div>
<!-- // 미리보기 -->

<!-- Loading -->
<div id="form-loading" style="display:none;">
	<div>
		<div>
			<img src="/common/images/icon/ajax-loader2.gif" />
		</div>
	</div>
</div>
<!-- // Loading-->

<div id="mainModalPop"></div>