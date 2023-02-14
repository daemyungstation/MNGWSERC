<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
input[type="radio"], input[type="checkbox"] { margin: 0; }
label { display:inline-block; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }

#list_sort { list-style-type: none; margin: 0; padding: 0; width: 100%; }
#list_sort li { margin: 3px 3px 3px 0px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; list-style:none; }
#list_sort li span { position: absolute; margin-left: -1.3em; }
.daterangepicker .drp-calendar { max-width: 350px !important; }
.ui-widget { font-size:1.0em; }
.modal.fade { top:-100%; }
</style>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-ui-multidatespicker@1.6.6/jquery-ui.multidatespicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/jquery-ui-multidatespicker@1.6.6/jquery-ui.multidatespicker.min.css" />

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tag-it/2.0/js/tag-it.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/tag-it/2.0/css/jquery.tagit.min.css" />


<h6>대명아임레디 박람회 - 제품 입력폼 등록/수정</h6>

<form id="fairFrm" name="fairFrm" action ="./action.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${rtnMap.fpiSeq}" class="form-control">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">대명아임레디 박람회 -제품 입력폼 등록/수정</caption>

		<tr>
		    <th width="20%">* 제목</th>
		    <td width="80%">
		    	<input type="text" name="FPI_TITLE" value="${ rtnMap.fpiTitle }" class="form-control">
		    </td>
  		</tr>
  		
  		
		<tr>
		    <th width="20%">* 입력폼</th>
		    <td width="80%">
		    	<input type="hidden" name="FPI_INPUT" value='${ rtnMap.fpiInput }'>
		    	
		    	<button name="input_add" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#writeModal">+ 추가</button>
		    	*드래그로 순서 변경 가능.
		    	
		    	<ul id="list_sort">
		    	</ul>
		    </td>
  		</tr>
	</table>
	<div style="text-align:center;">
		<a class="btn btn-default" href="./index.do">목록</a>
		<a class="btn btn-success" onclick="javascript:chkFormFair();">저장</a>
	</div>
</form>

<div id="writeModal" class="modal fade" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">입력폼 추가</h4>
			</div>
			<div class="modal-body">
				<table class="table table-bordered table-hover">
					<tr>
						<th width="30%">형태</th>
						<td width="*">
							<label><input type="radio" name="KEY" value="TEXT">텍스트형</label>&nbsp;
							<label><input type="radio" name="KEY" value="HPHONE">전화번호형</label>&nbsp;
							<label><input type="radio" name="KEY" value="EMAIL">이메일형</label>&nbsp;
							<label><input type="radio" name="KEY" value="NUMBER">숫자형</label>&nbsp;
							<label><input type="radio" name="KEY" value="DATE">달력형</label>&nbsp;
							<label><input type="radio" name="KEY" value="SELECT">선택형</label>
						</td>
					</tr>
					<tr>
						<th>입력명</th>
						<td>
							<input type="text" name="TITLE" placeholder="">
						</td>
					</tr>
					<tr>
						<th>값(선택형)</th>
						<td>
							<input type="text" name="VALUE" placeholder="쉼표로 구분 (2,4,기타,..)" disabled>
						</td>
					</tr>
					<tr>
						<th>가능날짜(달력형)</th>
						<td>
							<input type="text" name="DATE"/>
							<button type="button" class="btn btn-default btn-xs" id="DATE_PICKER_RANGE" disabled>범위선택</button>
							<button type="button" class="btn btn-default btn-xs" id="DATE_PICKER_EACH" disabled>지정선택</button>
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary" onclick="javascript:inputs_insert();">확인</button>
			</div>
		</div>
	</div>
</div>

<script>
	//등록하기
	function chkFormFair()
	{
		var f = document.fairFrm;
		
		if(f.FPI_TITLE.value == "") {
			alert("제목을 입력해주세요.");
			f.FPI_TITLE.focus();
			return;
		}
		
		var FPI_INPUT = new Array();
		jQuery("#list_sort > li" ).each(function(){
			var FPI_INPUT_JSON = new Object();
			FPI_INPUT_JSON.KEY = jQuery(this).data("key");
			FPI_INPUT_JSON.TITLE = jQuery(this).data("title");
			var fval = jQuery(this).data("val") + "";
			if(fval.indexOf(",") > -1) {
				FPI_INPUT_JSON.VALUE = jQuery(this).data("val").split(",");	
			}else {
				FPI_INPUT_JSON.VALUE = jQuery(this).data("val");
			}
			
			FPI_INPUT.push(FPI_INPUT_JSON);
		});
		
		if(FPI_INPUT.length < 1) {
			if(f.FPI_INPUT.value == "") {
				alert("입력폼을 선택해주세요.");
				return;
			}
		}else {
			f.FPI_INPUT.value = JSON.stringify(FPI_INPUT);
		}

		f.submit();
	}
	
	jQuery(document).ready(function(){
		var f = document.fairFrm;
		if(f.FPI_INPUT.value != "") {
			var json = JSON.parse(f.FPI_INPUT.value);
			for(var i = 0; i < json.length; i++) {
				var key = json[i].KEY;
				if(Array.isArray(json[i].VALUE)) {
					var val = json[i].VALUE.join(",");	
				}else {
					var val = json[i].VALUE;
				}

				var txt = "";
				if(key == "TEXT") {
					txt = "텍스트형";
				}
				else if(key == "HPHONE") {
					txt = "전화번호형";
				}
				else if(key == "EMAIL") {
					txt = "이메일형";
				}
				else if(key == "NUMBER") {
					txt = "숫자형";
				}
				else if(key == "DATE") {
					txt = "달력형";
				}
				else if(key == "SELECT") {
					txt = "선택형";
				}
				var html = "<li class='ui-state-default' data-key='"+ key +"' data-val='"+ val +"' data-title='"+ json[i].TITLE +"'>"+ json[i].TITLE +"["+ txt +"]";
				if(val != "") {
					html += "&nbsp;["+ val +"]";
				}
				html += "<button type='button' style='float:right;' onclick='javascript:itemDelete(jQuery(this));' class='btn btn-danger btn-xs'>삭제</button></li>";
				jQuery("#list_sort").append(html);
				
				jQuery("#list_sort").sortable({
					revert: 100,
					start: function( event, ui ) {
					},
					stop: function( event, ui ) {
					}
				});
				jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
			}
		}
		
		jQuery("input[name='KEY']").click(function(){
			if(jQuery(this).val() == "SELECT") {
				jQuery("input[name='VALUE']").attr("disabled", false);
			}else {
				jQuery("input[name='VALUE']").attr("disabled", true);
			}
			if(jQuery(this).val() == "DATE") {
				jQuery('.ui-autocomplete-input').attr("disabled", false);
				jQuery("#DATE_PICKER_RANGE").attr("disabled", false);
				jQuery("#DATE_PICKER_EACH").attr("disabled", false);
			}else {
				jQuery('.ui-autocomplete-input').attr("disabled", true);
				jQuery("#DATE_PICKER_RANGE").attr("disabled", true);
				jQuery("#DATE_PICKER_EACH").attr("disabled", true);
			}
		});
		
		jQuery('#DATE_PICKER_RANGE').daterangepicker({
			autoUpdateInput: false,
			locale: { format: "YYYY-MM-DD" }
		});
		jQuery('#DATE_PICKER_RANGE').on('apply.daterangepicker', function(ev, picker) {
			var val = picker.startDate.format('YYYY-MM-DD') + '~' + picker.endDate.format('YYYY-MM-DD');
			jQuery('input[name="DATE"]').tagit('createTag', val);
		});
		
		jQuery('#DATE_PICKER_RANGE').on('cancel.daterangepicker', function(ev, picker) {
			jQuery('input[name="DATE"]').val('');
		});
		
		jQuery('#DATE_PICKER_EACH').daterangepicker({
			singleDatePicker: true,
			locale: { format: "YYYY-MM-DD" }
		});
		jQuery('#DATE_PICKER_EACH').on('apply.daterangepicker', function(ev, picker) {
			var val = picker.startDate.format('YYYY-MM-DD');
			jQuery('input[name="DATE"]').tagit('createTag', val);
		});
		
		jQuery('#DATE_PICKER_EACH').on('cancel.daterangepicker', function(ev, picker) {
			jQuery('input[name="DATE"]').val('');
		});
		
		jQuery('input[name="DATE"]').tagit({});
		jQuery('.ui-autocomplete-input').attr("disabled", true);
	});
	
	function inputs_insert(){
		if(jQuery("input[name='KEY']:checked").length < 1) {
			alert("형태를 선택해주세요.");
			return;
		}
		var key = jQuery("input[name='KEY']:checked").val();

		if(jQuery("input[name='TITLE']").val() == "") {
			alert("노출명을 입력해주세요.");
			return;
		}
		
		if(key == "SELECT") {
			if(jQuery("input[name='VALUE']").val() == "") {
				alert("선택값을 선택해주세요.");
				return;
			}
		}
		
		var title = jQuery("input[name='TITLE']").val();
		var val = jQuery("input[name='VALUE']").val();
		if(key == "DATE") {
			val = jQuery('input[name="DATE"]').tagit("assignedTags").join(",");
		}
		
		var txt = "";
		if(key == "TEXT") {
			txt = "텍스트형";
		}
		else if(key == "HPHONE") {
			txt = "전화번호형";
		}
		else if(key == "EMAIL") {
			txt = "이메일형";
		}
		else if(key == "NUMBER") {
			txt = "숫자형";
		}
		else if(key == "DATE") {
			txt = "달력형";
		}
		else if(key == "SELECT") {
			txt = "선택형";
		}
		var html = "<li class='ui-state-default' data-key='"+ key +"' data-val='"+ val +"' data-title='"+ title +"'>"+ title +"["+ txt +"]";
		if(val != "") {
			html += "["+ val +"]";
		}
		html += "<button type='button' style='float:right;' onclick='javascript:itemDelete(jQuery(this));' class='btn btn-danger btn-xs'>삭제</button></li>";
		jQuery("#list_sort").append(html);
		
		jQuery("#list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
			},
			stop: function( event, ui ) {
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
		
		jQuery("input[name='KEY']").prop("checked", false);
		jQuery("input[name='VALUE']").val("").attr("disabled", true);
		jQuery('.ui-autocomplete-input').attr("disabled", true);
		jQuery("#DATE_PICKER_RANGE").attr("disabled", true);
		jQuery("#DATE_PICKER_EACH").attr("disabled", true);
		jQuery('input[name="DATE"]').tagit('removeAll');
		jQuery("input[name='TITLE']").val("");
		jQuery("#writeModal").modal("hide");
	}
	
	function itemDelete(obj) {
		var index = obj.parent().index();
		jQuery("#list_sort > li").eq(index).remove();
	}
	

</script>