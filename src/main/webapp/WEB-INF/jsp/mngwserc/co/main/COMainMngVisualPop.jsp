<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
.mainVisualTableList { width:100%; margin-bottom:-1px;}
.mainVisualTableList.mainVisualTableContents { border-top:2px solid #333; }
.mainVisualTableList .bg { width:150px; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .title { width:150px; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .desc { width:auto; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .btns { width:150px; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .link { width:200px; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .use { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .date { width:200px; text-align:center; box-sizing:border-box; font-size:12px; word-break: break-all; }
.mainVisualTableList .order { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainVisualTableList .mng { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }

form { margin:0; }
.form-inline { float:left; margin-left:15px; margin-bottom:15px; }
.form-inline:first-child { margin-left:0; }

.btn-xs{
    padding: 1px 5px;
    font-size: 12px;
    line-height: 1.5;
    border-radius: 3px;
}
ul { margin:0; }
li { list-style:none; background:#ffffff !important; color:inherit !important; border:none !important; font-weight:normal !important; }
</style>

<script>
jQuery(document).ready(function(){
	//이미지 미리보기
	jQuery(".btn_pop_preview_img").click(function(){
		var path = jQuery(this).data("path");
 		var save = jQuery(this).data("save");
		var saveFile = save.split(".");		
	
		//$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
		$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=main&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
		$("#preview").css("display","table");
	});
	
	//수정
	jQuery(".btn-modify").click(function(){
		var seq = jQuery(this).data("seq");
		jQuery.ajax({
			url: "/mngwserc/main/visual/modify.do",
			type: "get",
			dataType: "html",
			data: { visualSeq: seq },
			beforeSend: function() {
            	jQuery("#form-loading").show();
            },
            complete: function() {
            	jQuery("#form-loading").hide();
            },
			success: function(data) {
				jQuery("#mainVisualListModalPop").hide();
				jQuery(".modal-backdrop").remove();
				jQuery("#mainModalPop").html(data);
				jQuery("#mainVisualListModalPop").modal({
					backdrop: 'static',
					keyboard: false
				});
			}
		});
	});
	
	//삭제
	jQuery(".btn-delete").click(function(){
		var seq = jQuery(this).data("seq");
		if(confirm("정말삭제하시겠습니까?\n복구할 수 없으며 즉시 적용됩니다.")) {
			jQuery.ajax({
				url: "/mngwserc/main/visual/delete.ajax",
				type: "POST",
				dataType: "JSON",
				data: { visualSeq: seq },
				beforeSend: function() {
	            	jQuery("#form-loading").show();
	            },
	            complete: function() {
	            	jQuery("#form-loading").hide();
	            },
				success: function(data) {
					visual_manager('');
				}
			});
		}
	});
	
	//정렬
	var sortable_index = new Array();
	jQuery("#visual_list_sortable").sortable({
		revert: true,
		start: function( event, ui ) {
			sortable_index = new Array();
			jQuery("#visual_list_sortable > li").each(function(){
				if(typeof jQuery(this).data("seq") !== "undefined") {
					sortable_index.push(jQuery(this).data("seq"));
				}
			});
		},
		stop: function( event, ui ) {
			var visualSeq = new Array();
			jQuery("#visual_list_sortable > li").each(function(){
				visualSeq.push(jQuery(this).data("seq"));
			});
			if(sortable_index.join(",") != visualSeq.join(",")) {
				jQuery.ajax({
					url: "/mngwserc/main/visual/order.ajax",
					type: "POST",
					dataType: "JSON",
					data: { visualSeq: visualSeq.join(",") },
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
		}
	});
	$( "#visual_list_sortable.ul, #visual_list_sortable > li" ).disableSelection();
});
function visual_search() {
	var f = document.visual_search_form;
	visual_manager(f.grpId.value);
}
function visual_write() {
	var f = document.visual_search_form;
	jQuery.ajax({
		url: "/mngwserc/main/visual/write.do",
		type: "get",
		data: {
			grpId: f.grpId.value
		},
		dataType: "html",
		success: function(data) {
			jQuery("#mainVisualListModalPop").hide();
			jQuery(".modal-backdrop").remove();
			jQuery("#mainModalPop").html(data);
			jQuery("#mainVisualListModalPop").modal({
				backdrop: 'static',
				keyboard: false
			});
		}
	});
}
</script>
<!-- 메인 비주얼 목록 Modal -->
<div class="modal fade" id="mainVisualListModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1500px; margin-left: -750px;">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="myModalLabel">Main Visual 목록</h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
				<form name="visual_search_form" method="get">
					<select name="grpId" class="form-inline" onchange="javascript:visual_search();">
  						<c:forEach var="grp" items="${rtnMap.grpIds}">
							<option value="${ grp.grpId }" <c:if test="${grp.grpId eq searchGrpId}">selected</c:if>>그룹${ grp.grpId }<c:if test="${grp.grpId eq grp.liveGrpId}">-LIVE</c:if></option>
  						</c:forEach>
					</select>
					<!-- 
					<input type="text" name="sword" class="form-inline" placeholder="검색어">
					<button type="button" onclick="javascript:visual_search();" class="form-inline btn btn-default">검색</button>
					-->
					<a onclick="javascript:visual_write();" class="btn btn-primary pull-right">등록</a>
					<div class="clearfix"></div>
				</form>
				
				<div style="text-align:left; margin-bottom:15px;">
				※ 줄을 드래그하여 순서를 변경하실 수 있습니다.
				</div>
				
      			<table class="mainVisualTableList table table-bordered">
      				<tr>
      					<th class="bg">배경(색포함)</th>
      					<th class="title">타이틀</th>
      					<th class="desc">내용</th>
      					<th class="btns">버튼</th>
      					<th class="link">링크</th>
      					<th class="use">사용</th>
      					<th class="date">기간</th>
      					<th class="order">순서</th>
      					<th class="mng">관리</th>
      				</tr>
      			</table>
      			<c:choose>
	      			<c:when test="${fn:length(rtnMap.list) eq 0}">
	      				<table class="mainVisualTableList table table-bordered">
							<tr>
								<td class="lt_text3" style="text-align:center">
									<fmt:message key="common.nodata.msg" />
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<ul id="visual_list_sortable">
						<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
							<li class="ui-state-default" data-seq="${ list.visualSeq }">
			      			<table class="mainVisualTableList mainVisualTableContents table table-bordered">
			      				<tr>
			      					<td class="bg" bgcolor="${ list.webBgColor }">
			      						${ list.webBgRealFileNm }<br>
			      						<input type="button" value="미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.webBgPath }" data-save="${ list.webBgSaveFileNm }"/>
			      					</td>
			      					<td class="title">
			      						${ list.webTitleRealFileNm }<br>
			      						<input type="button" value="미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.webTitlePath }" data-save="${ list.webTitleSaveFileNm }"/>
			      					</td>
			      					<td class="desc">${ list.webTitleTxt }</td>
			      					<td class="btns">
			      						${ list.webBtnRealFileNm }<br>
			      						<input type="button" value="미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.webBtnPath }" data-save="${ list.webBtnSaveFileNm }"/>
			      					</td>
			      				    <td class="link"><a href="${ list.link }" target="_blank">${ list.link }</a></td>
									<td class="use">${ list.useYn }</td>
									<td class="date">${ list.useStrtDtm } ~ ${ list.useEndDtm }</td>
									<td class="order">${ list.orderby }</td>
									<td class="mng">
										<input type="button" value="수정" class="btn btn-warning btn-xs btn-modify" data-seq="${ list.visualSeq }"/>
										<input type="button" value="삭제" class="btn btn-danger btn-xs btn-delete" data-seq="${ list.visualSeq }"/>
									</td>
			      				</tr>
			      			</table>
			      			</li>
			      		</c:forEach>
			      		</ul>
		      		</c:otherwise>
		      	</c:choose>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
      		</div>
    	</div>
  	</div>
</div>
