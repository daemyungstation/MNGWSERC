<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
.mainContentDtlTableList { width:100%; margin-bottom:-1px;}
.mainContentDtlTableList.mainContentDtlTableContents { border-top:2px solid #333; }
.mainContentDtlTableList .img { width:200px; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .title { width:200px; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .dsc { width:auto; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .title.ttls { color:blue; cursor:pointer; word-break: break-all; }
.mainContentDtlTableList .link { width:200px; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .use { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .date { width:200px; text-align:center; box-sizing:border-box; font-size:12px; word-break: break-all; }
.mainContentDtlTableList .dtl { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .order { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .mng { width:100px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .title_type { width:150px; text-align:center; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .title_column { width:150px; box-sizing:border-box; word-break: break-all; }
.mainContentDtlTableList .title_cntns { width:auto; box-sizing:border-box; word-break: break-all; }

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
	jQuery(".btn_pop_preview_img2").click(function(){
		var path = jQuery(this).data("path");
			var save = jQuery(this).data("save");
		var saveFile = save.split(".");		

		//$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
		$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=main&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
		$("#preview").css("display","table");
	});
	//수정
	jQuery(".btn-contentdtl-modify").click(function(){
		var seq = jQuery(this).data("seq");
		var mstseq = jQuery(this).data("mstseq");
		jQuery.ajax({
			url: "/mngwserc/main/contentdtl/modify.do",
			type: "get",
			dataType: "html",
			data: {
				cntnsMstSeq: mstseq,
				cntnsDtlSeq: seq
			},
			beforeSend: function() {
            	jQuery("#form-loading").show();
            },
            complete: function() {
            	jQuery("#form-loading").hide();
            },
			success: function(data) {
				jQuery("#content_dtl").html(data);
			}
		});
	});
	
	//삭제
	jQuery(".btn-contentdtl-delete").click(function(){
		if(confirm("정말삭제하시겠습니까?\n복구할 수 없으며 즉시 적용됩니다.")) {
			var seq = jQuery(this).data("seq");
			var mstseq = jQuery(this).data("mstseq");
			jQuery.ajax({
				url: "/mngwserc/main/contentdtl/delete.ajax",
				type: "POST",
				dataType: "json",
				data: {
					cntnsMstSeq: mstseq,
					cntnsDtlSeq: seq
				},
				beforeSend: function() {
	            	jQuery("#form-loading").show();
	            },
	            complete: function() {
	            	jQuery("#form-loading").hide();
	            },
				success: function(data) {
					content_dtl_manager(mstseq);
				}
			});
		}
	});
	//정렬
	var sortable_index = new Array();
	jQuery("#contentdtl_list_sortable").sortable({
		revert: true,
		start: function( event, ui ) {
			sortable_index = new Array();
			jQuery("#contentdtl_list_sortable > li").each(function(){
				if(typeof jQuery(this).data("seq") !== "undefined") {
					sortable_index.push(jQuery(this).data("seq"));
				}
			});
		},
		stop: function( event, ui ) {
			var contentDtlSeq = new Array();
			jQuery("#contentdtl_list_sortable > li").each(function(){
				contentDtlSeq.push(jQuery(this).data("seq"));
			});
			if(sortable_index.join(",") != contentDtlSeq.join(",")) {
				jQuery.ajax({
					url: "/mngwserc/main/contentdtl/order.ajax",
					type: "POST",
					dataType: "JSON",
					data: { contentDtlSeq: contentDtlSeq.join(",") },
					beforeSend: function() {
						jQuery("#form-loading").show();
		            },
		            complete: function() {
		            	jQuery("#form-loading").hide();
		            },
					success: function(data) {
						var i = 1;
						jQuery("#contentdtl_list_sortable > li").each(function(){
							jQuery(this).find(".order").text(i);
							i++;
						});
					}
				});
			}
		}
	});
	$( "#contentdtl_list_sortable.ul, #contentdtl_list_sortable > li" ).disableSelection();
});
function contentdtl_write(cntnsMstSeq) {
	jQuery.ajax({
		url: "/mngwserc/main/contentdtl/write.do",
		type: "get",
		dataType: "html",
		data: {cntnsMstSeq: cntnsMstSeq },
		success: function(data) {
			jQuery("#content_dtl").html(data);
		}
	});
}
</script>

<!-- 메인 컨텐츠 상세 목록 Modal -->
<div class="panel panel-default">
	<div class="panel-heading">Main Content 상세 목록</div>
	<div class="panel-body">
		<form name="contentdtl_search_form" method="get">
			<a onclick="javascript:contentdtl_write('${ cntnsMstSeq }');" class="btn btn-primary pull-right">등록</a>
		</form>
	
	
		<table class="mainContentDtlTableList table table-bordered">
			<tr>
				<th class="img">이미지</th>
				<th class="title">제목</th>
				<th class="dsc">내용</th>
				<th class="link">링크</th>
				<th class="use">사용</th>
				<th class="date">기간</th>
				<th class="order">순서</th>
				<th class="mng">관리</th>
			</tr>
		</table>
  		<c:choose>
   			<c:when test="${fn:length(rtnMap.list) eq 0}">
   				<table class="mainContentDtlTableList table table-bordered">
					<tr>
						<td class="lt_text3" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<ul id="contentdtl_list_sortable" style="margin-top:15px;">
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
					<li class="ui-state-default" data-seq="${ list.cntnsDtlSeq }">
	      			<table class="mainContentDtlTableList mainContentDtlTableContents table table-bordered">
	      				<tr>
	      					<td class="img">
	      						${ list.imgRealFileNm }&nbsp;
	      						<input type="button" value="미리보기" class="btn btn-default btn-xs btn_pop_preview_img2" data-path="${ list.imgPath }" data-save="${ list.imgSaveFileNm }"/>
	      					</td>
	      				    <td class="title">${ list.title }</td>
	      				    <td class="dsc">${ list.dsc }</td>
	      				    <td class="link"><a href="${ list.link }" target="_blank">${ list.link }</a></td>
							<td class="use">${ list.useYn }</td>
							<td class="date">${ list.useStrtDtm } ~ ${ list.useEndDtm }</td>
							<td class="order">${ list.orderby }</td>
							<td class="mng">
								<input type="button" value="수정" class="btn btn-warning btn-xs btn-contentdtl-modify" data-seq="${ list.cntnsDtlSeq }" data-mstseq="${ list.cntnsMstSeq }"/>
								<input type="button" value="삭제" class="btn btn-danger btn-xs btn-contentdtl-delete" data-seq="${ list.cntnsDtlSeq }" data-mstseq="${ list.cntnsMstSeq }"/>
							</td>
	      				</tr>
	      			</table>
	      			</li>
	      		</c:forEach>
	      		</ul>
      		</c:otherwise>
      	</c:choose>
	</div>
</div>

