<%@include file="/WEB-INF/jsp/include/el.jspf"%>
<link href="/egov/css/table.css" rel="stylesheet" />
<link href="/egov/css/bootstrap.css" rel="stylesheet" />
<style>
.wrap_pop{ 
	padding:14px; 
	box-sizing:border-box;
}
h1{ 
	padding:0 10px;
	font-size:22px; 
}
input[type="file"]{ 
	border:1px solid #bbb;	 
}
.title{ 
	 overflow:hidden;
}
.title .tit{ 
	float:left;
}
.title .txt{ 
	float:right;
	color:#9e9e9e;
}
.title button{ 
	 float:right;
	 margin-left:10px;
}
.loop + .loop{ 
	margin-top:30px;	 
	padding-top:20px;	 
	border-top:1px solid #ddd;
}
._loop_div{
	margin-bottom:20px;
}
.pop_visible{
	margin-top:10px;
}
.table tr > *{  
	padding:10px;
	border-top:0 none;
	border-bottom:1px solid #ddd;
	vertical-align:middle;
}
.table th{  
	background-color:#f9f9f9;
	text-align:left;
}
.table td{ 
	text-align:left;
}
.table th{  
	background-color:#f9f9f9;
	text-align:center;
	vertical-align:middle;
}
.table input[type="text"]{
	/*padding: 20px 10px;*/
	height:30px;
	box-sizing: border-box;
}
.table .btn_cate_add{  
	display:block;
	width:54px;
	margin:4px auto 0;
}
.table .table_add{ 
	width:100%; 
	margin-top:10px;
	border:1px solid #d0d0d0;
}
.table .table_add td{ 
	overflow:hidden;
	text-align:center;
}
.table .table_add td.td_name{ 
	text-align:left;
}
.table .table_add td.td_name a{ 
	display:inline-block;
	border:1px solid #8c8c8c;
	padding:6px 10px;
	margin-left:4px;
	color:#8c8c8c;
}
.table .table_add td.td_name a:hover{ 
	text-decoration:none;
}
.table .table_add td input[type="file"]{ 
	display:block;
	margin:6px auto 0;
}
.table .table_add td .btn-danger{ 
	 float:right;
}
.pop_visible{ 
	padding:20px; 
    margin-top: 20px;
    border: 1px solid #ddd;
    background: #f9f9f9;
}
.pop_visible table,
.pop_visible table tr > *{ 
	background:#fff;
}
.pop_visible .table{
	margin-top:10px;
    border-bottom:0 none;	 
}
.pop_visible .table tr > *{
    border-bottom: 1px solid #d0d0d0;
}
.pop_check input[type="checkbox"]{ 
	width:20px;
	height:20px;
	margin:0 6px 0 0;
}
.pop_check label{ 
	display:inline-block;
    font-size: 16px;
    font-weight: 600;
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
<div class="wrap_pop">
	<form name="popFrm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="isIorU" value="">
	<input type="hidden" name="bannerSeq">
	<input type="hidden" name="linkGubun" value="URL">
	<table class="table table-bordered">
		<colgroup>
			<col width="10%">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>
					제목
				</th>
				<td>
					<!--상세 내용 -->
					<input type="text" name="bannerTitle" style="width:100%;">
				</td>
			</tr>
			<tr>
				<th>
					상단 이미지
				</th>
				<td class="_banner_img_td">
					<div class="title">
						<span class="_check_image_word"></span>
						<span class="tit"></span>
						<span class="txt">*PC 150x280의 JPG, PNG, GIF 파일을 등록해주세요.</span>
					</div>					
					<table class="table_add">			
						<colgroup>
							<col width="25%">
							<col width="*">
							<col width="10%">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<tr>
							<th>분류</th>
							<th>파일 이름</th>
							<th>파일 사이즈</th>
							<th>파일 구분</th>
							<th>파일 삭제</th>
						</tr>
						<tr>
							<td>PC &nbsp;
								<span class="btn fileinput-button">
				                    <i class="icon-upload"></i>
				                    <span>파일추가</span>
				                    <input type="file" name="ppTopImgBtn" accept=".gif, .jpg, .png"/>
				                </span>
							</td>
							<td class="td_name">
								<span></span>
								<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
								<input type="button" value="미리보기 닫기" class="btn_pop_close hidden"/>
							</td>
							<td class="_clear"></td>
							<td class="_clear"></td>
							<td><button type="button" class="_prdImg_delBtn" style="display: none;">삭제</button></td>
						</tr>
<!-- 						<tr>
							<td>Mobile &nbsp;
								<span class="btn fileinput-button">
				                    <i class="icon-upload"></i>
				                    <span>파일추가</span>
				                    <input type="file" name="pmTopImgBtn" accept=".gif, .jpg, .png"/>
				                </span>
							</td>
							<td class="td_name">
								<span></span>
								<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
								<input type="button" value="미리보기 닫기" class="btn_pop_close hidden"/>
							</td>
							<td class="_clear"></td>
							<td class="_clear"></td>
							<td><button type="button" class="_prdImg_delBtn" style="display: none;">삭제</button></td>
						</tr> -->
					</table>
				<br/>
				<b>URL 입력 : </b> 
				<input type="text" name="topUrlText" style="width:90%;">
				</td>
			</tr>
			<tr>
				<th>
					하단 이미지
				</th>
				<td class="_banner_img_td">
					<div class="title">
						<span class="_check_image_word"></span>
						<span class="tit"></span>
						<span class="txt">*PC 150x189의 JPG, PNG, GIF 파일을 등록해주세요.</span>
					</div>					
					<table class="table_add">			
						<colgroup>
							<col width="25%">
							<col width="*">
							<col width="10%">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<tr>
							<th>분류</th>
							<th>파일 이름</th>
							<th>파일 사이즈</th>
							<th>파일 구분</th>
							<th>파일 삭제</th>
						</tr>
						<tr>
							<td>PC &nbsp;
								<span class="btn fileinput-button">
				                    <i class="icon-upload"></i>
				                    <span>파일추가</span>
				                    <input type="file" name="ppUnderImgBtn" accept=".gif, .jpg, .png"/>
				                </span>
							</td>
							<td class="td_name">
								<span></span>
								<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
								<input type="button" value="미리보기 닫기" class="btn_pop_close hidden"/>
							</td>
							<td class="_clear"></td>
							<td class="_clear"></td>
							<td><button type="button" class="_prdImg_delBtn" style="display: none;">삭제</button></td>
						</tr>
<!-- 						<tr>
							<td>Mobile &nbsp;
								<span class="btn fileinput-button">
				                    <i class="icon-upload"></i>
				                    <span>파일추가</span>
				                    <input type="file" name="pmUnderImgBtn" accept=".gif, .jpg, .png"/>
				                </span>
							</td>
							<td class="td_name">
								<span></span>
								<input type="button" value="미리보기" class="btn_pop_preview" style="display: none;"/>
								<input type="button" value="미리보기 닫기" class="btn_pop_close hidden"/>
							</td>
							<td class="_clear"></td>
							<td class="_clear"></td>
							<td><button type="button" class="_prdImg_delBtn" style="display: none;">삭제</button></td>
						</tr> -->
					</table>
				<br/>
				<b>URL 입력 : </b> 
				<input type="text" name="underUrlText" style="width:90%;">
				</td>
			</tr>
			<tr>
				<th>노출여부</th>
				<td>
					<input type="radio" name="useYn" value="Y" checked>&nbsp;예&nbsp;
					<input type="radio" name="useYn" value="N">&nbsp;아니요&nbsp;
				</td>
			</tr>
		</tbody>
	</table>
	</form>
	<div style="text-align:center;">
		<a href="#" class="btn btn-success" id="writePrdMgrBtn"></a>
		<a href="javascript:cancelPrdMgrPop();" class="btn btn-default">취소</a>
	</div>
</div>
<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<button type="button" onclick="preview_close()"></button>
		<div>
			<img src="" />
		</div>
	</div>
</div>
<!-- // 미리보기 -->
<script type="text/javascript">
var img_top_btn_id = {
		'pc' : 'ppTopImgBtn',
		'mobile' : 'pmTopImgBtn'
};
var img_under_btn_id = {
		'pc' : 'ppUnderImgBtn',
		'mobile' : 'pmUnderImgBtn'
};
$(function(){
	imgAddClick(img_top_btn_id);
	imgAddClick(img_under_btn_id);

	// 이미지 미리보기 버튼 클릭
	$(document).off("click", ".td_name .btn_pop_preview").on("click", ".td_name .btn_pop_preview", function(){
		var $this = $(this);
		console.log($this.parent().parent().find("input:file").val());
		if($this.parent().parent().find("input:file").val() != '') {
			var file = $this.parent().parent().find("input:file")[0].files[0];
			var reader = new FileReader();
			
	        reader.onload = function(event){
	        	$("#preview").find("img").attr("src", event.target.result);
	        	//$this.siblings("div").find("img").attr("src", event.target.result);
	        }
	        
            reader.readAsDataURL(file);
			
			//$(".td_name img").show();
			$("#preview").css("display","table");
			return;
		}
// 		var fileseq = $(this).data("fileseq");
		var fileseq = $(this).attr("data-fileseq");
		console.log(fileseq);
		var $this = $(this);
		
		$.ajax({
			url : "./getBannerPreviewImgPath.ajax",
			data: {"fileseq" : fileseq},
			dataType : "json",
			async:false,
			success : function(res) {
				//$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+res.path.phyPath+"&fileNm="+res.path.saveFileNm+"&fileExtn="+res.path.fileExtn);
				$("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=banner&fileNm="+res.path.saveFileNm+"&fileExtn="+res.path.fileExtn);
				$("#preview").css("display","table");
			}
		});
	});
	
	//start ------- 개별 이미지 삭제버튼 클릭
	$(document).off("click", "._prdImg_delBtn").on("click", "._prdImg_delBtn", function() {
		$(this).hide();
		$(this).parent().siblings().eq(0).find("input:file").val("");
		$(this).parent().siblings().eq(1).find("span").text("");
		$(this).parent().siblings().eq(1).find("input:button").hide();
		$(this).parent().siblings().eq(2).text("");
		$(this).parent().siblings().eq(3).text("");
	});
	//end -------

	//start ------- 등록/수정 버튼 클릭	
	$("#writePrdMgrBtn").click(function(e) {
		e.preventDefault();

		//start 항목 체크
		if($("input[name=bannerTitle]").val().replace(/ /g, '') == ''){
			alert("배너 제목을 입력하세요.");
			$("input[name=bannerTitle]").focus();
			return;
		}
		
		var prd_spec_img1 = $("._banner_img_td").find(".td_name span").eq(0).text() == ''? true : false;
		var prd_spec_img2 = $("._banner_img_td").find(".td_name span").eq(1).text() == ''? true : false;
		
		if(prd_spec_img1 || prd_spec_img2) {
			$("._banner_img_td").find("._check_image_word").text("* 이미지를 등록해주세요.").css("color", "red");
			return;
		} else {
			$("._banner_img_td").find("._check_image_word").text("");
		}
		
		if($("input[name=topUrlText]").val().replace(/ /g, '') == ''){
			alert("상단이미지 URL을 입력하세요.");
			$("input[name=topUrlText]").focus();
			return;
		}
		
		if($("input[name=topUrlText]").val().replace(/ /g, '') == ''){
			alert("상단이미지 URL을 입력하세요.");
			$("input[name=topUrlText]").focus();
			return;
		}
		//end -------		

		var msg = "";
		
		if($("input[name='isIorU']").val() === 'update') {
			msg = "수정하시겠습니까?";
		} else {
			msg = "등록하시겠습니까?";
		}
		
		if(confirm(msg))
		{
			var url = "";
			
			if($("input[name='isIorU']").val() === 'update') {
				url = "./updateBanner.do";
			} else {
				url = "./insertBanner.do";
			}
			
			$("form[name='popFrm']").attr("action", url);
			
			$("form[name='popFrm']").submit();		 
		}
	});

});

//제품이미지 버튼 클릭 이벤트
function imgAddClick(btnId) {
	$(document).off("click", "input[name='"+ btnId.pc +"']").on("click", "input[name='"+ btnId.pc +"']", function() {
		imgCtrl($(this));
	});
	$(document).off("click", "input[name='"+ btnId.mobile +"']").on("click", "input[name='"+ btnId.mobile +"']", function() {
		imgCtrl($(this));
	});
}

function imgCtrl($this) {
	$this.change(function() {
		var file = $(this)[0].files[0];

		if(typeof file === 'undefined') {
			$this.parent().parent().siblings().eq(0).children("span").text("");
			$this.parent().parent().siblings().eq(1).text("");
			$this.parent().parent().siblings().eq(2).text("");
			$this.parent().parent().siblings().eq(0).children("input").hide();
			$this.parent().parent().siblings().eq(3).children("button").hide();
			$this.siblings().val("");
			
			return;
		}
		var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
		var fileNm = file.name.substring(0, file.name.lastIndexOf("."));
		
		$this.parent().parent().siblings().eq(0).children("span").text(fileNm);
		var size = 0;
		if(file.size/1024/1024 > 1) { //MB 
			size = Math.round(Math.ceil(file.size/1024/1024)) + " MB";
		} else { // KB
			size = Math.round(Math.ceil(file.size/1024)) + " KB";
		}
		$this.parent().parent().siblings().eq(1).text(size);
		$this.parent().parent().siblings().eq(2).text(ext);
		$this.parent().parent().siblings().eq(0).children("span").siblings().show();
		$this.parent().parent().siblings().eq(3).children("button").show();
	});
}

// 추가되는 제품이미지 html
function imgHTML(status, imgList) {
	console.log("img");
	if (imgList != null) {
		for (var i = 0; i < imgList.length; i++) {
			$("._banner_img_td .td_name").eq(i).find("span").text(
					imgList[i].realFileNm);
			$("._banner_img_td .td_name").eq(i).find(
					".btn_pop_preview").removeClass("hidden");
			$("._banner_img_td .td_name").eq(i).find(
					".btn_pop_preview").show();
			$("._banner_img_td .td_name").eq(i).find(
					".btn_pop_preview").attr("data-fileSeq",
							imgList[i].fileSeq);
			$("._banner_img_td .td_name").eq(i).siblings().eq(1)
					.text(imgList[i].fileSize);
			$("._banner_img_td .td_name").eq(i).siblings().eq(2)
					.text(imgList[i].fileExtn);
			$("._banner_img_td .td_name").eq(i).siblings().eq(3)
					.find("button").show();
			
			if(imgList[i].imageGubun == "top"){
				$("input[name=topUrlText]").val(imgList[i].url);
			} else {
				$("input[name=underUrlText]").val(imgList[i].url);
			}
		}
	}

	imgAddClick(img_top_btn_id);
	imgAddClick(img_under_btn_id);
}

//취소하기
function cancelPrdMgrPop() {
	$("#mainModalPop").modal("hide");
}

function preview() {
	$("#preview").css("display","table");
};
function preview_close() {
	$("#preview").css("display","none");
};
</script>