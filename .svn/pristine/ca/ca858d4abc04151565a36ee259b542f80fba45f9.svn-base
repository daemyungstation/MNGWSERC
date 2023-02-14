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
	border-bottom: 1px solid #ddd;
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

._loop_div {
	margin-bottom: 20px;
}

.pop_visible {
	margin-top: 10px;
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
    background: transparent url(/www.daemyungimready.com/common/images/btn/popupClose_btn.png) no-repeat center center;
    border: 0 none;
}
</style>
<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
<div class="wrap_pop">
	<!-- 	<h1>제로 초이스 상품 등록</h1> -->
	<form name="frm_prdMgr_pop" method="post" enctype="multipart/form-data">
		<input type="hidden" name="prdctSeq" value="" />
		<input type="hidden" name="isIorU" value="" />
		<input type="hidden" name="space_del_orders" value="" />
		<table class="table table-bordered">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
				<tr>
					<th style="text-align: center; vertical-align: middle;">카테고리</th>
					<td style="text-align: left;">
						<select name="category" required="카테고리를 선택하세요.">
							<option value="">선택하세요.</option>
							<c:forEach var="cl" items="${rtnMap.cateList}" varStatus="status">
								<c:if test="${rtnMap.CATE_SEQ }"></c:if>
								<c:choose>
									<c:when test="${cl.cateSeq eq  rtnMap.CATE_SEQ}">
										<option value="${cl.cateSeq }" selected>${cl.cateNm}</option>
									</c:when>
									<c:otherwise>
										<option value="${cl.cateSeq }">${cl.cateNm}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">제품명</th>
					<td style="text-align: left;">
						<input type="text" placeholder="* 제품명을 입력해주세요." required="제품명을 입력해주세요." name="prdctNm" onkeyup="fnChkByte(this, 28);">
					</td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">모델명</th>
					<td style="text-align: left;">
						<input type="text" placeholder="* 모델명을 입력해주세요." required="모델명을 입력해주세요." name="modelNm" onkeyup="fnChkByte(this, 28);">
					</td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">상품가격</th>
					<td style="text-align: left;">
						<div class="customer_pay">
							정상가
							<input type="text" required="가격분류를 입력해주세요." placeholder="* 가격분류를 입력해주세요." name="price_text" onkeyup="fnChkByte(this, 12);" style="width: 200px;"/>
							<input type="text" required="정상가를 입력해주세요." placeholder="* 정상가를 입력해주세요." name="price" onkeydown="onyNumber(this);" style="width: 200px;"/>
							<input type="checkbox" name="price_yn" style="width: 30px;"> 노출
						</div>
						<div class="customer_pay">
							혜택가
							<input type="text" required="혜택가를 입력해주세요." placeholder="* 혜택가를 입력해주세요." onkeyup="fnChkByte(this, 10);" name="priceBenefit" style="width: 300px;">
							<input type="checkbox" name="price_benefit_unit_yn" style="width: 30px;"> "원" 노출
						</div>
					</td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">할부기간</th>
					<td style="text-align: left;">
						<select name="instalment">
							<option value="-1">해당없음</option>
							<option value="0">일시불</option>
							<option value="12">12개월</option>
							<option value="24">24개월</option>
							<option value="36">36개월</option>
							<option value="48">48개월</option>
						</select>
					</td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">
						제품이미지 <span class="btn_cate_add btn btn-success">+ 추가</span>
					</th>
					<td class="loop" style="text-align: left;"></td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">제품스펙</th>
					<td class="_prd_spec_td" style="vertical-align:middle;">
						<textarea id="prd_spec" name="prd_spec" rows="20" style="display:block; width:98%;" exec="editorSync(this.id)" required="내용을 입력하세요."></textarea>
					</td>
				</tr>
				<tr>
					<th style="text-align: center; vertical-align: middle;">노출여부</th>
					<td style="vertical-align: middle;">
						<c:set var="visible_yn" value="${egov:nvl(prdMgrInfo.useYn, 'N')}" />
						<span style="display: inline-block; width: 100px;"> <input type="radio" name="visible_yn" value="Y" <c:if test="${visible_yn eq 'Y'}">checked</c:if> /> 예
						</span> <span style="display: inline-block; width: 100px;"> <input type="radio" name="visible_yn" value="N" <c:if test="${visible_yn eq 'N'}">checked</c:if> /> 아니오
						</span>
					</td>
					<td>
				</tr>
			</tbody>
		</table>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
				<tr>
					<th>제품설명</th>
					<td>
						<p class="title">
							<span class="txt">*200자 내의 작성해주세요. (<span id="cntnWordCnt">0</span>/200 byte)</span>
						</p>
						<textarea name="cntn" onkeyup="fnChkByte(this, 200);"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
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

<div style="text-align: center;">
	<a href="#" class="btn btn-success" id="writePrdMgrBtn"></a> 
	<a href="#" class="btn btn-default" onclick="cancelPrdMgrPop();">취소</a>
</div>
	

</div>
<script type="text/javascript">
function fnChkByte(obj, mb) {
	var maxByte = mb;
	var str = obj.value;
	var str_len = str.length;
	
	var rbyte = 0;
	var rlen = 0;
	var one_char = "";
	var str2 = ""
	
	for (var i = 0; i < str_len; i++) {
        one_char = str.charAt(i);
        
        if (escape(one_char).length > 4) {
            rbyte += 2; //한글2Byte
        } else {
            rbyte++; //영문 등 나머지 1Byte
        }
 
        if (rbyte <= maxByte) {
            rlen = i + 1; //return할 문자열 갯수
        }
    }
 
    if (rbyte > maxByte) {
        alert("한글 " + (maxByte / 2) + "자 / 영문 " + maxByte + "자를 초과 입력할 수 없습니다.");
        str2 = str.substr(0, rlen); //문자열 자르기
        obj.value = str2;
        fnChkByte(obj, maxByte);
    } else {
    	if(maxByte == 200) {
	        $("#cntnWordCnt").text(rbyte);
    	}
    }
}

$(function() {
	$(".btn_cate_add").click(function() {
		prdImgHTML("append");
	});
	table_add();
	$(".table .btn_cate_add").click(function() {
		table_add();
	});

	//  cntn 글자수 카운터
/* 	$("textarea[name='cntn']").keyup(function(e) {
		var content = $(this).val();
		$(this).height(((content.split('\n').length + 1) * 3) + 'em');
		$("#cntnWordCnt").html(content.length + '/200');
	});
	$("textarea[name='cntn']").keyup(); */

	// 등록/수정 버튼 클릭	
	$("#writePrdMgrBtn").click(function() {
		console.log('등록');
		var f = document.frm_prdMgr_pop;

		if (!validate(f)) {
			return;
		}
		
		// 등록/수정시 이미지가 등록되어 있는지 체크 
		var fn_span = $(".td_name span");
		
		for(var i=0; i<fn_span.length; i++) {
			var fn = fn_span.eq(i).text();
			
			if(fn === '') {
				fn_span.eq(i).closest("._loop_div").find("._check_image_word").text("* 이미지를 등록해주세요.").css("color", "red");
				return;
			} else {
				fn_span.eq(i).closest("._loop_div").find("._check_image_word").text("");
			}
		}
		
		var msg = "";

		if ($("input[name='isIorU']").val() === 'update') {
			msg = "수정하시겠습니까?";
		} else {
			msg = "등록하시겠습니까?";
		}

		if (confirm(msg)) {
			var url = "";

			if ($("input[name='isIorU']").val() === 'update') {
				url = "./update.do";
			} else {
				url = "./insert.do";
			}

			$("form[name='frm_prdMgr_pop']").attr("action", url);
			
			f.submit();
		}
	});
});

function onyNumber (obj) {
	$(obj).keyup(function(){
        $(this).val($(this).val().replace(/[^0-9]/g,""));
   }); 
}

// 추가되는 제품이미지 html
function prdImgHTML(status, prdImgList) {
	$.ajax({
		url : "/common/template/CNAZeroChoiPrdMgrImg.jsp",
		dataType : "html",
		data : {
			"status" : status
		},
		type : "post",
		success : function(html) {
			$(".loop").append(html);

			var imgCnt = $("._prdImgCnt").length;

			for (var j = 0; j < imgCnt; j++) {
				$("._prdImgCnt").eq(j).text(j + 1);
				$("._pc_img").eq(j).attr("name", "prd_pc_img_" + (j + 1));
				$("._mobile_img").eq(j).attr("name", "prd_mobile_img_" + (j + 1));
			}

			if (prdImgList != null) {
				for (var i = 0; i < prdImgList.length; i++) {
					$(".loop .td_name").eq(i).find("span").text(prdImgList[i].fileNm);
					$(".loop .td_name").eq(i).find(".btn_pop_preview").attr("data-fileseq", prdImgList[i].fileSeq);
					$(".loop .td_name").eq(i).find(".btn_pop_preview").attr("data-regorder", prdImgList[i].regOrder);
					$(".loop .td_name").eq(i).find(".btn_pop_preview").removeClass("hidden");
					$(".loop .td_name").eq(i).siblings().eq(1).text(prdImgList[i].fileSize);
					$(".loop .td_name").eq(i).siblings().eq(2).text(prdImgList[i].fileType);
					$(".loop .td_name").eq(i).siblings().eq(3).find("button").removeClass("hidden");
				}
			}
		}
	});
}

//취소하기
function cancelPrdMgrPop() {
	$("#prdModalPop").modal("hide");
}

function table_add() {
	$("input[type='checkbox']").click(function() {
		
		if($(this).attr("name") == 'price_yn' || $(this).attr("name") == 'price_benefit_unit_yn') {
			return;
		}
		
		var chk = $(this).is(":checked");
		if (chk == 1) {
			$(this).parent("div").next().css("display", "table");
		} else {
			$(this).parent("div").next().css("display", "none");
		}
	});
}

// 영역삭제시 update에 반영하기 위한 변수
var space_del_orders = [];
function div_del(e) {
	var reg_order = $(e).parent().siblings("table").find(".btn_pop_preview").data("regorder");
	space_del_orders.push(reg_order);
	$("input:hidden[name='space_del_orders']").val(space_del_orders);

	$(e).parent("div").parent("div").remove();

	var imgCnt = $("._prdImgCnt").length;

	for (var i = 0; i < imgCnt; i++) {
		$("._prdImgCnt").eq(i).text(i + 1);
		$("._pc_img").eq(i).attr("name", "prd_pc_img_" + (i + 1));
		$("._mobile_img").eq(i).attr("name", "prd_mobile_img_" + (i + 1));
	}
}

function preview() {
	$("#preview").css("display", "table");
}
function preview_close() {
	$("#preview").css("display", "none");
}
</script>