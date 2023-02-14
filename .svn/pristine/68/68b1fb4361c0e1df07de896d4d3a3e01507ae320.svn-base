<%@include file="/WEB-INF/jsp/include/el.jspf"%>
<link href="/egov/css/table.css" rel="stylesheet" />
<link href="/egov/css/bootstrap.css" rel="stylesheet" />
<style>
.wrap_pop {
	padding: 14px;
	box-sizing: border-box;
}

h1 {
	padding: 0 10px;
	font-size: 22px;
}

.title {
	overflow: hidden;
}

.title .tit {
	float: left;
}

.title .txt {
	float: right;
	color: #9e9e9e;
}

.title button {
	float: right;
	margin-left: 10px;
}

.table tr>* {
	padding: 10px;
	border-top:0 none;
	border-bottom:1px solid #ddd;
	vertical-align: middle;
}

.table th {
	background-color: #f9f9f9;
	text-align: left;
}

.table td {
	text-align: left;
}

.table th {
	background-color: #f9f9f9;
	text-align: center;
	vertical-align: middle;
}

.table input[type="radio"] {
	width: 20px;
	height: 20px;
	margin: 0 6px 0 0;
}

.table input[type="text"] {
	width: 100%;
	/*padding: 20px 10px;*/
	height:30px;
	box-sizing: border-box;
}

.table input[type="file"] {
	display: block;
	margin: 6px auto 0;
}

.table .btn_cate_add {
	display: block;
	width: 54px;
	margin: 4px auto 0;
}

.table .table_add {
	width: 100%;
	margin-top: 10px;
	border: 1px solid #d0d0d0;
}

.table .table_add td {
	/*overflow:hidden;*/
	text-align: center;
}

.table .table_add td.td_name {
	position: relative;
	text-align: left;
}

.table .table_add td.td_name .pop_preview {
	position: absolute;
	bottom: -50%;
	right: -57%;
	width: 200px;
	height: 200px;
	overflow-y: auto;
}

.table .table_add td.td_name a {
	display: inline-block;
	border: 1px solid #8c8c8c;
	padding: 6px 10px;
	margin-left: 4px;
	color: #8c8c8c;
}

.table .table_add td.td_name a:hover {
	text-decoration: none;
}

.table .table_add td .btn-danger {
	float: right;
}

.table .loop>div+div {
	margin-top: 20px;
	padding-top: 20px;
	border-top: 1px solid #ddd
}

.table .visible_yn {
	display: inline-block;
}

.table .visible_yn+.visible_yn {
	margin-left: 10px;
}

.table .customer_pay {
	overflow: hidden;
}

.table .customer_pay+.customer_pay {
	margin-top: 10px;
}

.table .customer_pay span {
	display: inline-block;
	width: 19%;
}

.table .customer_pay input {
	width: 80%;
}

.table textarea {
	width: 95.5%;
	height: 100px;
}
._loop_div{
	margin-bottom:20px;
}
.pop_visible{
	margin-top:10px;
}

#preview{ 
	position:fixed;
	display:table;
	top:0;
	left:0;
	width:100%;
	height:100%;
	background-color:rgba(0,0,0,0.6);
}
#preview > div{ 
	display:table-cell;
	text-align:center;
	vertical-align:middle;
}
#preview > div > div{ 
	position:relative;
    overflow-y: auto;
    width: 500px;
    height: 500px;
    margin: 0 auto;
}
#preview > div > div > img{ 
	width:100%;
}
#preview button{
    display: block;
    width: 70px;
    height: 30px;
    margin: 0 auto 16px;
    background: transparent url(//www.daemyungimready.com/common/images/btn/popupClose_btn.png) no-repeat center center;
    border: 0 none;
}
</style>
<form name="frm_imgMgr_pop" data-type="" method="post" enctype="multipart/form-data">
	<input type="hidden" name="imgSeq" value="" />
	<input type="hidden" name="space_del_orders" value="" />	<!-- 영역삭제된 이미지 order -->
	<input type="hidden" name="pop_show_none_orders" value="" />  <!-- 팝업 노출 해제된 이미지 order -->
	<div class="wrap_pop">
		<h1></h1>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>
						제목
					</th>
					<td>
						<!--상세 내용 -->
						<input type="text" name="imp_title"> <!-- image_mgr_popup_title -->
						<span></span>
					</td>
				</tr>
				<tr>
					<th>
						상단 이미지
						<span class="btn_cate_add btn btn-success">+ 추가</span>
					</th>
					<td>
						<!-- loop -->
						<div class="loop" data-gubun="top"></div>
						<!-- // loop -->
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>
						하단 이미지
						<span class="btn_cate_add btn btn-success">+ 추가</span>
					</th>
					<td>
						<!-- loop -->
						<div class="loop" data-gubun="bottom"></div>
						<!-- // loop -->
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-bordered">
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					노출여부
				</th>
				<td style="vertical-align:middle;">
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="use_yn" value="Y" checked="checked" /> 예
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="use_yn" value="N" /> 아니오
					</span>
				</td>
				<td>
			</tr>
		</table>
	</div>
</form>

<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<button type="button" onclick="preview_close()" style="background: white;">닫기</button>
		<div>
			<img src="" />
		</div>
	</div>
</div>

<div style="text-align:center;">
	<a href="#" class="btn btn-success" id="imp_write_btn"></a><!-- image_mgr_popup_reg_button -->
	<a href="#" class="btn btn-default" id="imp_cancel_btn">취소</a>
</div>

<!-- // 미리보기 -->
<script type="text/javascript">
$(function(){
// 이미지 추가 버튼 클릭 이벤트
	$(".btn_cate_add").click(function(){
		var gubun = $(this).parent().siblings().find(".loop").data("gubun");
		imp_createHTML(gubun, "append");
	});
	
// 이미지 등록 팝업 > 등록/수정 버튼 클릭 이벤트
	$("#imp_write_btn").click(function() {
		// 제목 유효성 체크
		var title = $("input:text[name='imp_title']");
		if(title.val() === '') {
			title.siblings("span").text("* 제목을 입력해주세요.").css("color", "red");
			return;
		} 
		title.siblings("span").text("")
		
		// 상단이미지, 하단이미지 한쌍씩 등록이 되어 있는지 체크
		var check_image_word = $("._check_image_word").closest(".loop").find(".table_add");
		
		for(var i=0; i<check_image_word.length; i++) {
			var pc_img = check_image_word.eq(i).find(".td_name span").eq(0).text() == ''? true : false;
			var mobile_img = check_image_word.eq(i).find(".td_name span").eq(1).text() == ''? true : false;
			
			if(pc_img || mobile_img) {
				$("._check_image_word").eq(i).text("* 이미지를 등록해주세요.").css("color", "red");
				return;
			} else {
				$("._check_image_word").eq(i).text("");
			}
		}
		
		// 현재 있는 이미지 파일의 name 값 세팅
		var fileTags = $("input:file");
		
		for(var i=0; i<fileTags.length; i++) {
			var gubun = fileTags.eq(i).closest(".loop").data("gubun");	// top:상단이미지, bottom:하단이미지
			var img_type = fileTags.eq(i).data("img_type");	// pc, mobile
			var is_pop = typeof fileTags.eq(i).closest(".div_pop_img")[0] === 'undefined' ? "" : "pop_";	// 팝업노출 이미지 여부
			var order = fileTags.eq(i).closest("._loop_div").find("._imgCnt").text();
			var name = "immgr_" + gubun + "_" + is_pop + img_type + "_" + order;
			
			fileTags.eq(i).attr("name", name);
		}
		
		var form_type = $("form[name='frm_imgMgr_pop']").attr("data-type");

		// 노출여부 체크
		var msg = "";
		var menuName = "";
		if (location.pathname.includes('limited')) {
			menuName = "리미티드 초이스";
		} else {
			menuName = "제로 초이스";
		}
		var cur_useYn = $("input:radio[name='use_yn']:checked").val();	// 현재 선택된 노출여부
		var db_useYn = $("input:radio[name='use_yn']").closest("td").attr("data-useyn");	// db에 저장된 노출여부
		var useYnChk = $("#useYnChk").val();		// 노출 여부가 Y로 된것이 있는지 체크
		
		if(form_type === 'update') {	// 수정 팝업
			if(db_useYn === 'Y') {	// 현재 db에 저장되어 있는 노출여부 Y
				if(cur_useYn === 'Y') {	// 노출여부 Y로 선택시
					msg = "수정하시겠습니까?";
				} else {	// 노출여부 N으로 선택시
					alert("노출상태를 수정할 수 없습니다.(최소 1개의 이미지가 노출되어야 합니다.)");
					return;
				}
			} else {	// 현재 db에 저장되어 있는 노출여부 N
				if(cur_useYn === 'Y') {
					if(useYnChk === '1') {
						msg = menuName + " 이미지가 노출중입니다. 이미지를 수정하시겠습니까?";
					} else {
						msg = "수정하시겠습니까?";
					}
				} else {
					msg = "수정하시겠습니까?";
				}
			}
		} else {		// 등록 팝업
			if(cur_useYn === 'Y') {	// 노출 여부 Y로 등록시
				if(useYnChk === '1') {
					msg = menuName + " 이미지가 노출중입니다. 새로 등록하시겠습니까?";
				} else {
					msg = "등록하시겠습니까?";
				}
			} else { // 노출 여부 N으로 등록시
				if(useYnChk === '' || useYnChk === '0') {
					alert("노출상태를 등록할 수 없습니다.(최소 1개의 이미지가 노출되어야 합니다.)");
					return;
				} else {
					msg = "등록하시겠습니까?";
				}
			}
		}
		
		if(confirm(msg))
		{
			var url = "";
			
			if(form_type === 'update') {
				url = "./update.do";
			} else {
				url = "./insert.do";
			}
			
			$("form[name='frm_imgMgr_pop']").attr("action", url);
			$("form[name='frm_imgMgr_pop']").submit();
		}
	});
	
// 이미지 등록 팝업 > 취소버튼 클릭 이벤트
	$("#imp_cancel_btn").click(function() {
		$("#imgModalPop").modal("hide");
	});

// 모달 닫히면서 초기화 이벤트
	$("#imgModalPop").on("hidden.bs.modal", function() {
			$(".loop").html("");
			
			var title = $("input:text[name='imp_title']");
			title.val("");
			title.siblings("span").text("");
	});
}); // end On Load Function


// 영역삭제 버튼 이벤트
var space_del_orders = [];	// 영역삭제시 update에 반영하기 위한 변수
// pop_show_none_orders
function div_del(e) {
	var gubun = $(e).closest(".loop").data("gubun");
	var reg_order = $(e).parent().siblings("table").find(".btn_pop_preview").data("regorder");
	
	if(reg_order != '') {
		space_del_orders.push(gubun + "_" + reg_order);
	}
	
	$("input:hidden[name='space_del_orders']").val(space_del_orders);

	var img_cnt = $(e).closest(".loop").find("._imgCnt").length - 1;
	var gubun = $(e).closest(".loop").data("gubun");
	
	$(e).closest("._loop_div").remove();
	
	img_cnt = $("._imgCnt").closest(".loop[data-gubun='"+ gubun +"']").find("._imgCnt");
	
	for(var i=0; i<img_cnt.length; i++) {
		img_cnt.eq(i).text(i+1);
	}
}

// 이미지 등록 loop 추가되는 HTML append 시키는 func
function imp_createHTML(gubun, status, type, data) {	// gubun => top/bottom, status => init/append, type => insert/update
	var param = {};
	param.gubun = gubun;
	param.status = status;
	param.imgCnt = $(".loop[data-gubun='"+ gubun +"']>._loop_div").length == 0 ? 1 :
		$(".loop[data-gubun='"+ gubun +"']>._loop_div").length + 1;
	
	param.fileNm_pc = typeof data === 'undefined' ? '' : data[0].fileNm;
	param.classification_pc = typeof data === 'undefined' ? '' : data[0].classification;
	param.fileSeq_pc = typeof data === 'undefined' ? '' : data[0].fileSeq;
	param.fileSize_pc = typeof data === 'undefined' ? '' : data[0].fileSize;
	param.fileType_pc = typeof data === 'undefined' ? '' : data[0].fileType;
	param.prdOrImgSeq_pc = typeof data === 'undefined' ? '' : data[0].prdOrImgSeq;
	param.regOrder_pc = typeof data === 'undefined' ? '' : data[0].regOrder;
	param.using_pc = typeof data === 'undefined' ? '' : data[0].using;
	
	param.fileNm_mobile = typeof data === 'undefined' ? '' : data[1].fileNm;
	param.classification_mobile = typeof data === 'undefined' ? '' : data[1].classification;
	param.fileSeq_mobile = typeof data === 'undefined' ? '' : data[1].fileSeq;
	param.fileSize_mobile = typeof data === 'undefined' ? '' : data[1].fileSize;
	param.fileType_mobile = typeof data === 'undefined' ? '' : data[1].fileType;
	param.prdOrImgSeq_mobile = typeof data === 'undefined' ? '' : data[1].prdOrImgSeq;
	param.regOrder_mobile = typeof data === 'undefined' ? '' : data[1].regOrder;
	param.using_mobile = typeof data === 'undefined' ? '' : data[1].using;
	
	$.ajax({
		url : "/common/template/CNAZeroChoiImgMgrImg.jsp",
		type : "post",
		data : param,
		async : false,
		dataType : "html",
		success : function(html) {
			if(status == 'init') {
				$("div[data-gubun='"+ gubun +"']").html(html);
				
			} else if(status === 'append') {
				$("div[data-gubun='"+ gubun +"']").append(html);
				
			} else {
				alert("이미지 HTML을 생성하는데 status값이 init/append 둘중 하나로 넘어오지 않아 HTML을 불러올 수 없습니다.");
			}
			
			// 수정페이지일때 값 세팅
			if(type === 'update') {
				// 상단 버튼
				$(".loop").eq(0).find("._loop_div").eq(param.regOrder_pc-1).find("._btn_pop_img_del").eq(0).removeClass("hidden");
				$(".loop").eq(0).find("._loop_div").eq(param.regOrder_pc-1).find("._btn_pop_img_del").eq(1).removeClass("hidden");
				$(".loop").eq(0).find("._loop_div").eq(param.regOrder_pc-1).find(".btn_pop_preview").removeClass("hidden");
				
				// 하단 버튼
				$(".loop").eq(1).find("._loop_div").eq(param.regOrder_pc-1).find("._btn_pop_img_del").eq(0).removeClass("hidden");
				$(".loop").eq(1).find("._loop_div").eq(param.regOrder_pc-1).find("._btn_pop_img_del").eq(1).removeClass("hidden");
				$(".loop").eq(1).find("._loop_div").eq(param.regOrder_pc-1).find(".btn_pop_preview").removeClass("hidden");
			}			
		}
	});
}
</script>