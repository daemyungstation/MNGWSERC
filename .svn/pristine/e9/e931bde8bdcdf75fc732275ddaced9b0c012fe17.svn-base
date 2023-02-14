<%
	String gubun = "top".equals(request.getParameter("gubun")) ? "상단이미지" : "하단이미지";
	String imgCnt = request.getParameter("imgCnt");
	boolean status = "append".equals(request.getParameter("status")) ? true : false;
	
	String fileNm_pc = request.getParameter("fileNm_pc");
	String classification_pc = request.getParameter("classification_pc");
	String fileSeq_pc = request.getParameter("fileSeq_pc");
	String fileSize_pc = request.getParameter("fileSize_pc");
	String fileType_pc = request.getParameter("fileType_pc");
	String prdOrImgSeq_pc = request.getParameter("prdOrImgSeq_pc");
	String regOrder_pc = request.getParameter("regOrder_pc");
	String using_pc = request.getParameter("using_pc");
	
	String fileNm_mobile = request.getParameter("fileNm_mobile");
	String classification_mobile = request.getParameter("classification_mobile");
	String fileSeq_mobile = request.getParameter("fileSeq_mobile");
	String fileSize_mobile = request.getParameter("fileSize_mobile");
	String fileType_mobile = request.getParameter("fileType_mobile");
	String prdOrImgSeq_mobile = request.getParameter("prdOrImgSeq_mobile");
	String regOrder_mobile = request.getParameter("regOrder_mobile");
	String using_mobile = request.getParameter("using_mobile");
%>
<div class="_loop_div">
	<span class="_check_image_word"></span>
	<div class="title">
		<span class="tit"><%=gubun %><span class="_imgCnt"><%=imgCnt %></span></span>
		<% if(status) { %>
				<button type='button' onclick='div_del(this)'>영역 삭제</button>
		<%}%>
		<span class="txt">*PC 가로 1920, Mobile 가로 640의 JPG, PNG, GIF 파일을 등록해주세요.</span>
	</div>					
	<table class="table_add">			
		<colgroup>
			<col width="20%">
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
			<td>PC 
				<input type="file" data-img_type="pc" name="" style="display: none;">
				<input type="button" class="file_search_btn" value="파일 찾기"/>
			</td>
			<td class="td_name">
				<span><%=fileNm_pc %></span>
				<input type="button" value="미리보기" data-fileseq="<%=fileSeq_pc %>" data-regorder="<%=regOrder_pc %>" class="btn_pop_preview hidden"/>
			</td>
			<td><%=fileSize_pc %></td>
			<td><%=fileType_pc %></td>
			<td><button type="button" class="_btn_pop_img_del hidden">삭제</button></td>
		</tr>
		<tr>
			<td>Mobile 
				<input type="file" data-img_type="mobile" name="" style="display: none;">
				<input type="button" class="file_search_btn" value="파일 찾기"/>
			</td>
			<td class="td_name">
				<span><%=fileNm_mobile %></span>
				<input type="button" value="미리보기" data-fileseq="<%=fileSeq_mobile %>" data-regorder="<%=regOrder_mobile %>" class="btn_pop_preview hidden"/>
			</td>
			<td><%=fileSize_mobile %></td>
			<td><%=fileType_mobile %></td>
			<td><button type="button" class="_btn_pop_img_del hidden">삭제</button></td>
		</tr>
	</table>
	<div class="pop_visible">
		<div class="pop_check">
			<input type="checkbox" name="" id="1">팝업 노출
		</div>		
		<div class="div_pop_img"></div>
	</div>
</div>

<script type="text/javascript">
$(function(){
// 이미지 미리보기 버튼 클릭
	$(document).off("click", ".td_name .btn_pop_preview").on("click", ".td_name .btn_pop_preview", function(){
		var $this = $(this);
		
		if($this.parent().parent().find("input:file").val() != '') {
			var file = $this.parent().parent().find("input:file")[0].files[0];
			
			var reader = new FileReader();
			
	        reader.onload = function(event){
	        	$("#preview").find("img").attr("src", event.target.result);
	        }
	        
            reader.readAsDataURL(file);
			
            $this.siblings(".pop_preview").removeClass("hidden");
//     		$(".btn_pop_preview").addClass("hidden");
			$("#preview").show();
            $(this).siblings(".btn_pop_close").removeClass("hidden");
            
			return;
		}
		var fileseq = $(this).data("fileseq");
		var $this = $(this);
		
		// $("#preview").find("img").attr("src", "/mngwserc/cna/imgmgr/previewImg.do?fileSeq=" + fileseq);

		if (location.pathname.includes('limited')) {
			$("#preview").find("img").attr("src", "/mngwserc/cna/limited/product/previewImg.do?fileSeq=" + fileseq);
		} else {
			$("#preview").find("img").attr("src", "/mngwserc/cna/imgmgr/previewImg.do?fileSeq=" + fileseq);
		}

		$("#preview").show();
	});	
	
// 팝업노출 버튼 이벤트
	var update_add_item = [];	// 업데이트시 새로 추가된 파일
	$(document).off("click", ".pop_check input[type='checkbox']").on("click", ".pop_check input[type='checkbox']", function(){
		if(!$(this).is(":checked")) {
			var filenm_pc = $(this).closest(".pop_visible").find(".td_name span").eq(0).text();
			var filenm_mobile = $(this).closest(".pop_visible").find(".td_name span").eq(1).text();
			
			if(filenm_pc != '' && filenm_mobile != '') {
				var gubun = $(this).closest(".loop").data("gubun");
				var reg_order = $(this).closest(".pop_visible").find(".btn_pop_preview").data("regorder");

				if(typeof reg_order != 'undefined') {
					space_del_orders.push(gubun + "_" + reg_order);
					console.log(space_del_orders);
				}
			}
		}
		
		var pc_file_nm = $(this).closest("._loop_div").find(".td_name span").eq(0).text();
		var mobile_file_nm = $(this).closest("._loop_div").find(".td_name span").eq(1).text();
		
		if(pc_file_nm === '' || mobile_file_nm === '') {
			alert("이미지를 먼저 등록한 후 팝업을 노출할 수 있습니다.");
			$(this).prop("checked", false);
			return;
		} 
	
		var $this = $(this);
		var chk = $this.is(":checked");
		
		$.ajax({
			url : "/common/template/CNAZeroChoiImgMgrImgPop.jsp",
			type : "post",
			async : false,
			dataType : "html",
			success : function(html) {
				if(chk != 1){
					html = "";
				}
				$this.parent().siblings(".div_pop_img").html(html);
			}
		});
	});

// 파일 찾기 버튼 이벤트
	$(document).off("click", ".file_search_btn").on("click", ".file_search_btn", function() {
		$(this).siblings().click();
	});

// 파일 변경시 이벤트
	$(document).off("change", "input:file").on("change", "input:file", function() {
		var file = $(this)[0].files[0];
		
		if(typeof file === 'undefined') {
			$(this).closest("tr").find(".td_name span").text("");
			$(this).closest("tr").children("td").eq(2).text("");
			$(this).closest("tr").children("td").eq(3).text("");
			$(this).closest("tr").find(".btn_pop_preview").addClass("hidden");
			$(this).closest("tr").find("._btn_pop_img_del").addClass("hidden");
			
			// 팝업 노출안에 있는 삭제버튼이 아닐경우
			if(typeof $(this).closest(".pop_visible")[0] === 'undefined') {
				$(this).closest("._loop_div").find("input:checkbox").prop("checked", false);
				$(this).closest("._loop_div").find(".div_pop_img").html("");
			}
			return;
		}
		
		var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
		var fileNm = file.name.substring(0, file.name.lastIndexOf("."));
		var size = 0;
		
		if(file.size/1024/1024 > 1) { //MB 
			size = Math.round(Math.ceil(file.size/1024/1024)) + " MB";
		} else { // KB
			size = Math.round(Math.ceil(file.size/1024)) + " KB";
		}
		
		$(this).closest("tr").find(".td_name span").text(fileNm);
		$(this).closest("tr").children("td").eq(2).text(size);
		$(this).closest("tr").children("td").eq(3).text(ext);
		$(this).closest("tr").children("td").eq(4).find("button").removeClass("hidden");
		$(this).closest("tr").find(".btn_pop_preview").removeClass("hidden");
	});
	
// 개별 파일 삭제 버튼 클릭 이벤트
	$(document).off("click", "._btn_pop_img_del").on("click", "._btn_pop_img_del", function() {
		$(this).closest("tr").find("input:file").val("");
		$(this).closest("tr").find(".td_name span").text("");
		$(this).closest("tr").find(".btn_pop_preview").addClass("hidden");
		$(this).closest("tr").find("td").eq(2).text("");
		$(this).closest("tr").find("td").eq(3).text("");
		$(this).addClass("hidden");
		
		// 팝업 노출안에 있는 삭제버튼이 아닐경우
		if(typeof $(this).closest(".pop_visible")[0] === 'undefined') {
			$(this).closest("._loop_div").find("input:checkbox").prop("checked", false);
			$(this).closest("._loop_div").find(".div_pop_img").html("");
		}
	});
});	// end On Load Function

function preview() {
	$("#preview").css("display", "table");
}
function preview_close() {
	$("#preview").css("display", "none");
}
</script>