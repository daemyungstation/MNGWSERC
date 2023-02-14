// 전역변수 설정
var del_img_seq = [];

$(function() {
	//삭제 체크박스 전체 선택 & 해제
	$("input:checkbox[name='all_check']").click(function(){
		if($(this).is(":checked"))
		{
			$("input:checkbox[name='delSeq']").prop("checked", true);
		}
		else
		{
			$("input:checkbox[name='delSeq']").prop("checked", false);
		}	
	});
	
	//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
	$("input:checkbox[name='delSeq']").click(function(){
		var allChkCnt = $("input:checkbox[name='delSeq']").length;
		var selChkCnt = $("input:checkbox[name='delSeq']:checked").length;
		
		if(allChkCnt==selChkCnt)
		{
			$("input:checkbox[name='all_check']").prop("checked", true);
		}
		else
		{
			$("input:checkbox[name='all_check']").prop("checked", false);
		}
	});
	
	// 팝업이 닫힐때 수행할 이벤트
	$("#popup").on("hidden.bs.modal", function() {
		$("input:file").val("");
		$("._text").text("");
		$("input:text[name='title']").val("");
		$("td>button").addClass("hidden");
		$(".btn_pop_preview").addClass("hidden");
		$(".pop_visible input:checkbox").prop("checked", false);
		$("#pop_show_div").addClass("hidden");
		$("._chk_img_word").text("");
		$("#_oprt_dtm_chk_word").text("");
		
		$("input:radio[name='use_yn']:radio[value='Y']").prop("checked", true);
		$("input:radio[name='oprt_yn']:radio[value='Y']").prop("checked", true);
		$("#start_dtm").val("");
		$("#end_dtm").val("");
		
		$("._loop").html("");
	});
});

/**
 * 리스트 > 등록버튼
 */
function inserPopOpen() {
	loopHTML();
	
	$("#popup").modal("show");
	$("form[name='frm_write']").attr("data-type", "insert");
	$("#pop_Label").text("리미티드 초이스 이미지 등록");
	$("#write_btn").text("등록");
	$("input:text[name='title']").siblings("span").text("");
}

/**
 *  리스트 > 상세보기
 */
function selectLimitedChoiDtl(seq) {
	$.ajax({
		url : "./view.ajax",
		type : "post",
		async : false,
		dataType : "json",
		data : {"seq" : seq},
		success : function(res) {
			console.log(res)
			$("#pop_Label").text("리미티드 초이스 이미지 수정");
			$("#write_btn").text("수정");
			$("form[name='frm_write']").attr("data-type", "update");
			$("input:hidden[name='seq']").val(seq);
			
			
			var limtInfo = res.data.limtInfo;
			var imgFileList = res.data.imgFileList;
			
			// 값세팅
			$("input:text[name='title']").val(limtInfo.title);
			$("input:radio[name='use_yn']:radio[value='"+ limtInfo.useYn +"']").prop("checked", true)
			$("input:radio[name='oprt_yn']:radio[value='"+ limtInfo.oprtYn +"']").prop("checked", true)
			$("#start_dtm").val(limtInfo.startDtm.split(" ")[0]);
			$("#end_dtm").val(limtInfo.endDtm.split(" ")[0]);
			$("input:radio[name='oprt_yn']").closest("td").attr("data-oprtyn", limtInfo.oprtYn);
			
			// 이미지 영역개수 구함
			var imgCnt = 0;
			
			for(var i=0; i<imgFileList.length; i++) {
				var regOrder = imgFileList[i].regOrder;
				
				imgCnt = (imgCnt < regOrder) ? regOrder : imgCnt;
			}
			
			// 이미지 영역개수 만큼 html 생성
			for(var i=0; i<imgCnt; i++) {	// 이미지 영역개수 만큼 반복하며 HTML 삽입
				loopHTML();
			}
			
			// 이미지 데이터 로딩
			var main_img = [];
			var pop_img = [];
			
			// 생성된 html에 데이터 바인딩
			for(var i=0; i<imgCnt; i++) {
				// 데이터 로딩
				for(var j=0; j<imgFileList.length; j++) {
					var using = imgFileList[j].using;
					var regOrder =  imgFileList[j].regOrder;
					var $rootLoc = {};
					
					if(regOrder == (i+1)) {
						if(using === 'pop') { // 팝업노출 상품이미지일 경우
							$(".pop_visible").eq(i).find("._btn_popShow").prop("checked", true);
							$(".pop_visible").eq(i).find("._popShow").removeClass("hidden");
							pop_img.push(imgFileList[j])

						} else {
							main_img.push(imgFileList[j])
						}
					}
				}
			}
			
			// 제품 이미지 있을경우 바인딩
			var mainTable = $(".table_add[data-location='main']");
			for(var i=0; i<main_img.length; i++) {
				mainTable.find(".td_name span").eq(i).text(main_img[i].fileNm);
				mainTable.find(".td_name input:button").eq(i).removeClass("hidden");
				mainTable.find(".td_name input:button").eq(i).attr("data-fileseq", main_img[i].fileSeq);
				mainTable.find(".td_name").closest("tr").eq(i).find("td:eq(2)").text(main_img[i].fileSize);
				mainTable.find(".td_name").closest("tr").eq(i).find("td:eq(3)").text(main_img[i].fileType);
				mainTable.find(".td_name").closest("tr").eq(i).find("td:eq(4) button").removeClass("hidden");
			}
			
			// 팝업 노출 이미지 있을경우 바인딩
			var popTable = $(".table_add[data-location='pop']");
			
			for(var t=0; t<popTable.length; t++) {
				for(var i=0; i<pop_img.length; i++) {
					if((t+1) == pop_img[i].regOrder) {
						popTable.eq(t).find(".td_name span").eq(0).text(pop_img[i].fileNm);
						popTable.eq(t).find(".td_name span").eq(1).text(pop_img[i+1].fileNm);
						
						popTable.eq(t).find(".td_name input:button").eq(0).removeClass("hidden");
						popTable.eq(t).find(".td_name input:button").eq(1).removeClass("hidden");
						
						popTable.eq(t).find(".td_name input:button").eq(0).attr("data-fileseq", pop_img[i].fileSeq);
						popTable.eq(t).find(".td_name input:button").eq(1).attr("data-fileseq", pop_img[i+1].fileSeq);
						
						popTable.eq(t).find(".td_name").closest("tr").eq(0).find("td:eq(2)").text(pop_img[i].fileSize);
						popTable.eq(t).find(".td_name").closest("tr").eq(1).find("td:eq(2)").text(pop_img[i+1].fileSize);
						
						popTable.eq(t).find(".td_name").closest("tr").eq(0).find("td:eq(3)").text(pop_img[i].fileSize);
						popTable.eq(t).find(".td_name").closest("tr").eq(1).find("td:eq(3)").text(pop_img[i+1].fileSize);
						
						popTable.eq(t).find(".td_name").closest("tr").eq(0).find("td:eq(4) button").removeClass("hidden");
						popTable.eq(t).find(".td_name").closest("tr").eq(1).find("td:eq(4) button").removeClass("hidden");
						
						i++;
					}
				}
			}
			
			$("#popup").modal("show");
		}
	});
}

/**
 * 리스트 > 삭제 버튼
 */
function deleteList() {
	if($("input:checkbox[name='delSeq']:checked").length > 0)
	{
		if(confirm("삭제하시겠습니까?")) 
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.submit();
		}
	} 
	else 
	{
		alert("삭제할 대상을 선택하세요.");
		return;
	}
}

/**
 *  팝업 > 이미지 추가 버튼
 */
function imgAddBtn() {
	loopHTML();
}

/**
 * 	팝업 > 등록/수정 버튼
 */
function writeBtn() {
	var form_type = $("form[name='frm_write']").attr("data-type");
	
	// 유효성 체크
	var title = $("input:text[name='title']");
	
	if(title.val() === '') {
		title.siblings("span").text("* 제목을 입력해주세요.").css("color", "red");
		return;
		
	} else {
		title.siblings("span").text("");
	}
	
	// 이미지 등록여부 체크
	var $_loop = $("._imgAdd");
	// 제품이미지 한개당 체크
	for(var i=0; i<$_loop.length; i++) {
		var $_imgAdd = $_loop.eq(i);
		var pc_img = $_imgAdd.find(".td_name span").eq(0).text();
		var mobile_img = $_imgAdd.find(".td_name span").eq(1).text();
		var thumb_img = $_imgAdd.find(".td_name span").eq(2).text();
		
		if(pc_img === '' || mobile_img === '' || thumb_img === '') {
			$_imgAdd.find("._chk_img_word:eq(0)").text("* 이미지를 등록해주세요.").css("color", "red");
			return;
		} else {
			$_imgAdd.find("._chk_img_word:eq(0)").text("");
		}
		
		// 팝업 노출 이미지 등록 여부 체크
		var popShow_chk = $_imgAdd.find("._btn_popShow").prop("checked");
		
		if(popShow_chk) {
			var pc_img = $_imgAdd.find(".td_name span").eq(3).text();
			var mobile_img = $_imgAdd.find(".td_name span").eq(4).text();
			
			if(pc_img === '' || mobile_img === '') {
				$_imgAdd.find("._chk_img_word:eq(1)").text("* 이미지를 등록해주세요.").css("color", "red");
				return;
			} else {
				$_imgAdd.find("._chk_img_word:eq(1)").text("");
			}
		}
		
		// 현재 있는 이미지 파일의 name 값 세팅
		var cnt = $_imgAdd.find("._imgCnt").text();
		
		$_imgAdd.find("input:file:eq(0)").attr("name", "pc_main_" + cnt);
		$_imgAdd.find("input:file:eq(1)").attr("name", "mobile_main_" + cnt);
		$_imgAdd.find("input:file:eq(2)").attr("name", "thumb_main_" + cnt);
		$_imgAdd.find("input:file:eq(3)").attr("name", "pc_pop_" + cnt);
		$_imgAdd.find("input:file:eq(4)").attr("name", "mobile_pop_" + cnt);
	}// end for
	
	// 진행기간 선택 여부 체크
	var start_dtm = $("#start_dtm").val();
	var end_dtm = $("#end_dtm").val();
	
	if(start_dtm === '' || end_dtm === '') {
		$("#_oprt_dtm_chk_word").text("* 진행기간을 선택해 주세요.").css("color", "red");
		return;
	} else {
		$("#_oprt_dtm_chk_word").text("");
	}
	
	// 진행기간 체크
	var msg = "";
	var cur_oprtYn = $("input:radio[name='oprt_yn']:checked").val();	// 현재 선택된 노출여부
	var db_oprtYn = $("input:radio[name='oprt_yn']").closest("td").attr("data-oprtyn");	// db에 저장된 노출여부
	var oprtYnChk = $("#oprtYnChk").val();		// 노출 여부가 Y로 된것이 있는지 체크
	
	if(form_type === 'update') {
		msg = "수정하시겠습니까?";
		
		if(db_oprtYn != cur_oprtYn) {	// 선택이 바뀌었을 경우
			if(cur_oprtYn === 'Y') {	// 'Y'로 선택했을 경우
				if(oprtYnChk === '1') {	// 'Y'가 존재할 경우
					msg = "진행 중인 리미티드 초이스가 있습니다. 이미지를 수정하시겠습니까? (기간 내 1개의 이미지만 노출됩니다.)";
				}
			}
		}
	} else {
		msg = "등록하시겠습니까?";
		
		if(cur_oprtYn === 'Y') {	// 'Y'로 선택했을 경우
			if(oprtYnChk === '1') {	// 'Y'가 존재할 경우
				msg = "진행 중인 리미티드 초이스가 있습니다. 새로 등록하시겠습니까? (기간 내 1개의 이미지만 노출됩니다.)";
			}
		}
	}
	
	// 등록
	if(confirm(msg))
	{
		var url = "";
		
		if(form_type === 'update') {
			url = "./update.do";
		} else {
			url = "./insert.do";
		}
		
		// 영역삭제 및 팝업 노출 해제에 따른 삭제될 이미지의 filseq 의 중복 제거
		var del_fileseq = "";
		
		$.each(del_img_seq, function(i, el) {
			if($.inArray(el, del_fileseq) === -1) {
				del_fileseq += (el + ",");
			}
		});
		
		$("input:hidden[name='del_fileseq']").val(del_fileseq);
		
		$("form[name='frm_write']").attr("action", url);
		$("form[name='frm_write']").submit();
	}
}

/**
 * 	팝업 > 취소 버튼
 */
function cancelBtn() {
	$("#popup").modal("hide");
}

/**
 * 	팝업 > 이미지 삭제 버튼
 */
function img_delBtn(e) {
	$(e).closest("tr").find("input:file").val("");
	$(e).closest("tr").find(".td_name span").text("");
	$(e).closest("tr").find(".btn_pop_preview").addClass("hidden");
	$(e).closest("tr").find("td").eq(2).text("");
	$(e).closest("tr").find("td").eq(3).text("");
	$(e).addClass("hidden");
}
/**
 * 	팝업 > 파일찾기 버튼
 */
function file_search_btn(e) {
	var file_element = $(e).siblings("input:file");
	file_element.click();
	
	// 파일 변경 이벤트
	file_element.change(function() {
		var file = file_element[0].files[0];
		
		var fileInfo = file_info(file);
		
		$(e).closest("tr").find(".td_name span").text(fileInfo.name);
		$(e).closest("tr").find(".btn_pop_preview").removeClass("hidden");
		$(e).closest("tr").find("td").eq(2).text(fileInfo.size);
		$(e).closest("tr").find("td").eq(3).text(fileInfo.type);
		$(e).closest("tr").find("td").eq(4).find("button").removeClass("hidden");
	});
}

/**
 *  팝업 > 영역삭제 버튼
 */
function div_del(e) {
	var $_imgAdd = $(e).closest("._imgAdd");
	
	// 해당 imgAdd loop 내의 fileseq 들을 삭제할 배열에 push
	var $preBtn = $_imgAdd.find(".btn_pop_preview");
	
	for(var i=0; i<$preBtn.length; i++) {
		var del_fileseq = $preBtn.eq(i).data("fileseq");
		
		if(del_fileseq != '') {
			del_img_seq.push(del_fileseq);
		}
	}
	
	$(e).closest("._imgAdd").find(".td_name input:button").eq(0)
	$(e).closest("._imgAdd").remove();
	img_count();
}

/**
 * 	팝업 > 팝업노출 버튼
 */
function pop_show(e) {
	var pc_img = $(".table_add").eq(0).find(".td_name span").eq(0).text();
	var mobile_img = $(".table_add").eq(0).find(".td_name span").eq(1).text();
	
	if((pc_img === '' || mobile_img === '') && typeof e != 'undefined') {
		alert("이미지를 먼저 등록한 후 팝업을 노출할 수 있습니다.");
		$(e).prop("checked", false);
		return;
	}
	
	var status = $(e).prop("checked");
	
	if(!status) {
		$(e).closest(".pop_visible").find("._popShow").addClass("hidden");
		$(e).closest(".pop_visible").find("input:file").val("");
		$(e).closest(".pop_visible").find("._text").text("");
		$(e).closest(".pop_visible").find("td button").addClass("hidden");
		$(e).closest(".pop_visible").find(".td_name input:button").addClass("hidden");
		$(e).closest(".pop_visible").find(".pop_visible input:checkbox").prop("checked", false);
		
		// 팝업 노출 버튼 해제시 해당 파일 seq 삭제
		if($(e).closest(".pop_visible").find(".btn_pop_preview").data("fileseq") != null) {
			var pc_seq = $(e).closest(".pop_visible").find(".btn_pop_preview").eq(0).data("fileseq");
			var mobile_seq = $(e).closest(".pop_visible").find(".btn_pop_preview").eq(1).data("fileseq");
			
			del_img_seq.push(pc_seq);
			del_img_seq.push(mobile_seq);
		}
		
	} else {
		$(e).closest(".pop_visible").find("._popShow").removeClass("hidden");
	}
}

/**
 * 파일정보를 가공해서 리턴
 */
function file_info(file) {
	var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
	var fileNm = file.name.substring(0, file.name.lastIndexOf("."));
	var size = 0;
	
	if(file.size/1024/1024 > 1) { //MB 
		size = Math.round(Math.ceil(file.size/1024/1024)) + " MB";
	} else { // KB
		size = Math.round(Math.ceil(file.size/1024)) + " KB";
	}
	
	var fileInfo = {};
	fileInfo.type = ext;
	fileInfo.name = fileNm;
	fileInfo.size = size;
	
	return fileInfo;
}

/**
 *  팝업 > 이미지 미리보기
 */
function preview(e) {
	var $this = $(e);
	
	if ($this.closest("tr").find("input:file").val() != '') {
		var file = $this.closest("tr").find("input:file")[0].files[0];

		var reader = new FileReader();

		reader.onload = function(event) {
			$("#preview").find("img").attr("src", event.target.result);
		}
		reader.readAsDataURL(file);
	
		$("#preview").css("display","table");
		
	} else {
		var fileseq = $this.data("fileseq");
		var $this = $this;

		$("#preview").find("img").attr("src", "/mngwserc/cna/limited/previewImg.do?fileSeq=" + fileseq);
		$("#preview").show();
	}
}

/**
 *  팝업 > 이미지 미리보기 닫기
 */
function preview_close() {
	$("#preview").css("display","none");
}

/**
 *  조건 검색버튼 클릭
 */
function getPageList()
{	
	var f = document.frm;
	
	if(arguments.length > 0)
	{
		f.pageIndex.value = arguments[0];
	}
	else
	{
		f.pageIndex.value = 1;
	}
	
	f.action = "./list.do";
	f.submit();
}

/**
 *  이미지 등록 영역 반복되는 HTML 생성
 */
function loopHTML() {
	$.ajax({
		url : "/common/template/CNALimitedChoi_LOOP.jsp",
		type : "post",
		dataType : "html",
		async : false,
		success : function(res) {
			$("._loop").append(res);
			img_count();
		}
	});
}

/**
 *  제품이미지 순번 매기는 기능
 */
function img_count() {
	var $imgAdd = $("._imgAdd");
	
	for(var i=0; i<$imgAdd.length; i++) {
		if(i != 0) {
			$("._btn_imgDel").eq(i).removeClass("hidden");
		} 
		$imgAdd.find("._imgCnt").eq(i).text(i+1);
	}
}

