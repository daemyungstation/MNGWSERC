<% 	String status = request.getParameter("status"); %>
<div class="_loop_div">
	<span class="_check_image_word"></span>
	<div class="title">
		<span class="tit">제품이미지<span class="_prdImgCnt">1</span>
		</span>
		<% if("append".equals(status)) { %>
			<button type='button' onclick='div_del(this)'>영역 삭제</button>
		<%}%>
		<span class="txt">*PC 700x450, Mobile 700x450의 JPG, PNG, GIF 파일을 등록해주세요.</span>
	</div>					
	<table class="table_add">			
		<colgroup>
			<col width="20%">
			<col width="*">
			<col width="10%">
			<col width="10%">
			<col width="10%">
		</colgroup>
		<tbody>
		<tr>
			<th>분류</th>
			<th>파일 이름</th>
			<th>파일 사이즈</th>
			<th>파일 구분</th>
			<th>파일 삭제</th>
		</tr>
		<tr>
			<td>PC 
				<input type="file" class="_pc_img hidden" name="prd_pc_img_1">
				<input type="button" class="_file_search_btn" value="파일 찾기"/>
			</td>
			<td class="td_name">
				<span></span>
				<input type="button" value="미리보기" class="btn_pop_preview hidden"/>
			</td>
			<td class="_clear"></td>
			<td class="_clear"></td>
			<td><button type="button" class="_prdImg_delBtn hidden">삭제</button></td>
		</tr>
		<tr>
			<td>Mobile 
				<input type="file" class="_mobile_img hidden" name="prd_mobile_img_1">
				<input type="button" class="_file_search_btn" value="파일 찾기"/>
			</td>
			<td class="td_name">
				<span></span>
				<input type="button" value="미리보기" class="btn_pop_preview hidden"/>
			</td>
			<td class="_clear"></td>
			<td class="_clear"></td>
			<td><button type="button" class="_prdImg_delBtn hidden">삭제</button></td>
		</tr>
		</tbody>
	</table>
</div>

<script type="text/javascript">
$(function(){
// 파일찾기 버튼 클릭 이벤트
	$(document).off("click", "._file_search_btn").on("click", "._file_search_btn", function() {
		$(this).siblings().click();
	});
	
// 파일 변경이벤트
	$(document).off("change", "input:file").on("change", "input:file", function() {
		var file = $(this)[0].files[0];
		
		if (typeof file === 'undefined') {
			$(this).closest("tr").find(".td_name span").text("");
			$(this).closest("tr").find(".td_name input:button").addClass("hidden");
			$(this).closest("tr").find("td").eq(2).text("");
			$(this).closest("tr").find("td").eq(3).text("");
			$(this).closest("tr").find("td").eq(4).find("button").addClass("hidden");

			return;
		}

		var ext = file.name.substring(file.name.lastIndexOf(".") + 1, file.name.length);
		var fileNm = file.name.substring(0, file.name.lastIndexOf("."));

		var size = 0;
		if (file.size / 1024 / 1024 > 1) { //MB 
			size = Math.round(Math.ceil(file.size / 1024 / 1024)) + " MB";
		} else { // KB
			size = Math.round(Math.ceil(file.size / 1024)) + " KB";
		}

		$(this).closest("tr").find(".td_name span").text(fileNm);
		$(this).closest("tr").find(".td_name input:button").removeClass("hidden");
		$(this).closest("tr").find("td").eq(2).text(size);
		$(this).closest("tr").find("td").eq(3).text(ext);
		$(this).closest("tr").find("td").eq(4).find("button").removeClass("hidden");
	});
	
// 개별 이미지 삭제버튼 클릭
	$(document).off("click", "._prdImg_delBtn").on("click", "._prdImg_delBtn", function() {
		$(this).addClass("hidden");
		$(this).closest("tr").find("input:file").val("");
		$(this).closest("tr").find(".td_name span").text("");
		$(this).closest("tr").find(".td_name input:button").addClass("hidden");
		$(this).closest("tr").find("td").eq(2).text("")
		$(this).closest("tr").find("td").eq(3).text("")
		$(this).closest("tr").find("td").eq(4).find("button").addClass("hidden");
	});
	
// 이미지 미리보기 버튼 클릭
	$(document).off("click", ".btn_pop_preview").on("click", ".btn_pop_preview", function() {
		console.log("preview click");
		if ($(this).closest("tr").find("input:file").val() != '') {
			var file = $(this).closest("tr").find("input:file")[0].files[0];

			var reader = new FileReader();

			reader.onload = function(event) {
				$("#preview").find("img").attr("src", event.target.result);
			}
			reader.readAsDataURL(file);
		
			$("#preview").css("display","table");
			
		} else {
			var fileseq = $(this).data("fileseq");
			var $this = $this;
			if (location.pathname.includes('limited')) {
				$("#preview").find("img").attr("src", "/mngwserc/cna/limited/product/previewImg.do?fileSeq=" + fileseq);
			} else {
				$("#preview").find("img").attr("src", "/mngwserc/cna/prdmgr/previewImg.do?fileSeq=" + fileseq);
			}
			$("#preview").show();
		}
	});
});
</script>