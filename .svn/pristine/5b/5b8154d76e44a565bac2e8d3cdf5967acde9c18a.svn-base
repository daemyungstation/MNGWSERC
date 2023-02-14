<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
.mainContentTableList { width:100%; margin-bottom:-1px;}
.mainContentTableList.mainContentTableContents { border-top:2px solid #333; }
.mainContentTableList .title { width:auto; box-sizing:border-box; }
.mainContentTableList .title.ttls { color:blue; cursor:pointer; }
.mainContentTableList .link { width:200px; box-sizing:border-box; }
.mainContentTableList .use { width:100px; text-align:center; box-sizing:border-box; }
.mainContentTableList .date { width:200px; text-align:center; box-sizing:border-box; font-size:12px; }
.mainContentTableList .dtl { width:100px; text-align:center; box-sizing:border-box; }
.mainContentTableList .order { width:100px; text-align:center; box-sizing:border-box; }
.mainContentTableList .mng { width:100px; text-align:center; box-sizing:border-box; }
.mainContentTableList .title_type { width:150px; text-align:center; box-sizing:border-box; }
.mainContentTableList .title_column { width:150px; box-sizing:border-box; }
.mainContentTableList .title_cntns { width:auto; box-sizing:border-box; }

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


.panel {
	margin-top:20px;
    margin-bottom: 20px;
    background-color: #fff;
    border: 1px solid transparent;
    border-radius: 4px;
    -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.05);
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.panel-default {
    border-color: #ddd;
}
.panel-default>.panel-heading {
    color: #333;
    background-color: #f5f5f5;
    border-color: #ddd;
    text-align:left;
}
.panel-heading {
    padding: 10px 15px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
}
.panel-body {
    padding: 15px;
}
.panel-footer {
    padding: 10px 15px;
    background-color: #f5f5f5;
    border-top: 1px solid #ddd;
    border-bottom-right-radius: 3px;
    border-bottom-left-radius: 3px;
}
</style>

<script>
jQuery(document).ready(function(){
	//수정
	jQuery(".btn-content-modify").click(function(){
		var seq = jQuery(this).data("seq");
		jQuery.ajax({
			url: "/mngwserc/main/content/modify.do",
			type: "get",
			dataType: "html",
			data: { cntnsMstSeq: seq },
			beforeSend: function() {
            	jQuery("#form-loading").show();
            },
            complete: function() {
            	jQuery("#form-loading").hide();
            },
			success: function(data) {
				jQuery("#mainContentListModalPop").hide();
				jQuery(".modal-backdrop").remove();
				jQuery("#mainModalPop").html(data);
				jQuery("#mainContentListModalPop").modal({
					backdrop: 'static',
					keyboard: false
				});
			}
		});
	});
	
	//삭제
	jQuery(".btn-content-delete").click(function(){
		var seq = jQuery(this).data("seq");
		if(confirm("정말삭제하시겠습니까?\n복구할 수 없으며 즉시 적용됩니다.")) {
			jQuery.ajax({
				url: "/mngwserc/main/content/delete.ajax",
				type: "POST",
				dataType: "JSON",
				data: { cntnsMstSeq: seq },
				beforeSend: function() {
	            	jQuery("#form-loading").show();
	            },
	            complete: function() {
	            	jQuery("#form-loading").hide();
	            },
				success: function(data) {
					content_manager('');
				}
			});
		}
	});
	
	//정렬
	var sortable_index = new Array();
	jQuery("#content_list_sortable").sortable({
		revert: true,
		start: function( event, ui ) {
			sortable_index = new Array();
			jQuery("#content_list_sortable > li").each(function(){
				if(typeof jQuery(this).data("seq") !== "undefined") {
					sortable_index.push(jQuery(this).data("seq"));
				}
			});
		},
		stop: function( event, ui ) {
			var contentSeq = new Array();
			jQuery("#content_list_sortable > li").each(function(){
				contentSeq.push(jQuery(this).data("seq"));
			});
			if(sortable_index.join(",") != contentSeq.join(",")) {
				jQuery.ajax({
					url: "/mngwserc/main/content/order.ajax",
					type: "POST",
					dataType: "JSON",
					data: { contentSeq: contentSeq.join(",") },
					beforeSend: function() {
						jQuery("#form-loading").show();
		            },
		            complete: function() {
		            	jQuery("#form-loading").hide();
		            },
					success: function(data) {
						var i = 1;
						jQuery("#content_list_sortable > li").each(function(){
							jQuery(this).find(".order").text(i);
							i++;
						});
					}
				});
			}
		}
	});
	$( "#content_list_sortable.ul, #content_list_sortable > li" ).disableSelection();
});
function content_search() {
	var f = document.content_search_form;
	content_manager(f.grpId.value);
}

function content_write() {
	var f = document.content_search_form;
	jQuery.ajax({
		url: "/mngwserc/main/content/write.do",
		type: "get",
		data: {
			grpId: f.grpId.value
		},
		dataType: "html",
		success: function(data) {
			jQuery("#mainContentListModalPop").hide();
			jQuery(".modal-backdrop").remove();
			jQuery("#mainModalPop").html(data);
			jQuery("#mainContentListModalPop").modal({
				backdrop: 'static',
				keyboard: false
			});
		}
	});
}

function content_dtl_manager(cntnsMstSeq) {
	jQuery.ajax({
		url: "/mngwserc/main/contentdtl/list.do",
		type: "get",
		dataType: "html",
		data: { cntnsMstSeq: cntnsMstSeq },
		success: function(data) {
			jQuery("#content_dtl").html(data);
		}
	});
}
</script>
<!-- 메인 컨텐츠 목록 Modal -->
<div class="modal fade" id="mainContentListModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1500px; margin-left: -750px;">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="myModalLabel">Main Content 섹션 목록</h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
				<form name="content_search_form" method="get">
					<select name="grpId" class="form-inline" onchange="javascript:content_search();">
  						<c:forEach var="grp" items="${rtnMap.grpIds}">
							<option value="${ grp.grpId }" <c:if test="${grp.grpId eq searchGrpId}">selected</c:if>>그룹${ grp.grpId }<c:if test="${grp.grpId eq grp.liveGrpId}">-LIVE</c:if></option>
  						</c:forEach>
					</select>
					<!-- 
					<input type="text" name="sword" class="form-inline" placeholder="검색어">
					<button type="button" onclick="javascript:content_search();" class="form-inline btn btn-default">검색</button>
					-->
					<a onclick="javascript:content_write();" class="btn btn-primary pull-right">등록</a>
					<div class="clearfix"></div>
				</form>
				
				<div style="text-align:left; margin-bottom:15px;">
				※ 줄을 드래그하여 순서를 변경하실 수 있습니다.<br>
				※ 제목을 클릭하면 하단에 컨텐츠를 등록/수정/삭제/순서변경이 가능한 창이 나타납니다.
				</div>
				
      			<table class="mainContentTableList table table-bordered">
      				<tr>
      					<th class="title">제목</th>
      					<th class="use">사용</th>
      					<th class="date">기간</th>
      					<th class="dtl">컨텐츠수</th>
      					<th class="order">순서</th>
      					<th class="mng">관리</th>
      				</tr>
      			</table>
      			<c:choose>
	      			<c:when test="${fn:length(rtnMap.list) eq 0}">
	      				<table class="mainContentTableList table table-bordered">
							<tr>
								<td class="lt_text3" style="text-align:center">
									<fmt:message key="common.nodata.msg" />
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<ul id="content_list_sortable">
						<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
							<li class="ui-state-default" data-seq="${ list.cntnsMstSeq }">
			      			<table class="mainContentTableList mainContentTableContents table table-bordered">
			      				<tr>
			      				    <td class="title ttls" onclick="javascript:content_dtl_manager('${ list.cntnsMstSeq }');">${ list.titleTxt }</td>
									<td class="use">${ list.useYn }</td>
									<td class="date">${ list.useStrtDtm } ~ ${ list.useEndDtm }</td>
									<td class="dtl">${ list.subCnt }</td>
									<td class="order">${ list.orderby }</td>
									<td class="mng">
										<input type="button" value="수정" class="btn btn-warning btn-xs btn-content-modify" data-seq="${ list.cntnsMstSeq }"/>
										<input type="button" value="삭제" class="btn btn-danger btn-xs btn-content-delete" data-seq="${ list.cntnsMstSeq }"/>
									</td>
			      				</tr>
			      			</table>
			      			</li>
			      		</c:forEach>
			      		</ul>
			      		
			      		<div id="content_dtl"></div>
		      		</c:otherwise>
		      	</c:choose>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
      		</div>
    	</div>
  	</div>
</div>
