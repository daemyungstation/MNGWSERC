<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }

#list_sort { margin:0; }
#list_sort li { list-style:none; background:#ffffff !important; color:inherit !important; border:none !important; font-weight:normal !important; }

a.btn { color: #ffffff !important; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }

table.sorttable {  margin-bottom: -1px !important; }
.td-no { width: 6%; }
.td-auto { width: auto; }
.td-title { width: 20%; }
.td-time { width: 20%; }
.td-use { width: 6%; }
.td-order { width: 5%; }
.td-mng { width: 10%; }

.modal.fade { top: -100%; } 
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.4/clipboard.min.js"></script>

<h6 style="float:left;">대명아임레디 박람회 - 상담 관리 : 총 ${rtnMap.list[0].totCnt}건</h6>

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	<input type="hidden" name="seq" value="" />
	<input type="hidden" name="fcseq" value="${formMap.fcseq}" />
	
	<div style="position:relative; clear:both;">
		<div>
			<button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#cateModal">카테고리별 URL 확인</button>
			<button type="button" class="btn btn-danger btn-xs" onclick="javascript:search_category('');">전체</button>
			<c:forEach var="list" items="${cateMap.list}" varStatus="status">
				<button type="button" class="btn btn-success btn-xs" onclick="javascript:search_category('${list.fcSeq}');">${list.fcTitle}</button>
			</c:forEach>
			<%--	/*BLOCK_EXCEL*/					<a class="btn btn-success btn-xs" style="float:right;" onclick="javascript:search_excel();">엑셀다운</a>--%>
		</div>
		<div style="margin-top:10px;">
			<label style="float:left;">
				이름: 
				<input type="text" name="name" value="${formMap.name}" class="form-control" placeholder="이름을 입력하세요" style="width:100px;">
			</label>
			<label style="float:left; margin-left:10px;">
				전화번호: 
				<input type="text" name="phone" value="${formMap.phone}" class="form-control" placeholder="전화번호을 입력하세요" style="width:100px;">
			</label>
			<label style="float:left; margin-left:10px;">
				상담상태: 
				<select name="status">
					<option value="" <c:if test="${formMap.status eq ''}">selected</c:if>>선택해주세요.</option>
					<option value="상담취소" <c:if test="${formMap.status eq '상담취소'}">selected</c:if>>상담취소</option>
					<option value="가입녹취요청" <c:if test="${formMap.status eq '가입녹취요청'}">selected</c:if>>가입녹취요청</option>
					<option value="전화번호오류" <c:if test="${formMap.status eq '전화번호오류'}">selected</c:if>>전화번호오류</option>
					<option value="DB중복(기처리)" <c:if test="${formMap.status eq 'DB중복(기처리)'}">selected</c:if>>DB중복(기처리)</option>
					<option value="결번(FAX등)" <c:if test="${formMap.status eq '결번(FAX등)'}">selected</c:if>>결번(FAX등)</option>
					<option value="재통화요청" <c:if test="${formMap.status eq '재통화요청'}">selected</c:if>>재통화요청</option>
					<option value="장기부재취소" <c:if test="${formMap.status eq '장기부재취소'}">selected</c:if>>장기부재취소</option>
					<option value="대기중" <c:if test="${formMap.status eq '대기중'}">selected</c:if>>대기중</option>
					<option value="진행중" <c:if test="${formMap.status eq '진행중'}">selected</c:if>>진행중</option>
					<option value="부재중" <c:if test="${formMap.status eq '부재중'}">selected</c:if>>부재중</option>
					<option value="보류" <c:if test="${formMap.status eq '보류'}">selected</c:if>>보류</option>
					<option value="기타" <c:if test="${formMap.status eq '기타'}">selected</c:if>>기타</option>
					<option value="가입완료" <c:if test="${formMap.status eq '가입완료'}">selected</c:if>>가입완료</option>
					<option value="가입취소" <c:if test="${formMap.status eq '가입취소'}">selected</c:if>>가입취소</option>		    	
		    	</select>
			</label>
			<label style="float:left; margin-left:10px;">
				신청일: 
				<input type="date" name="sregdate" value="${formMap.sregdate}" class="form-control" placeholder="시작일" style="width:100px;">
			</label>
			<label style="float:left; margin-left:10px;">
				<input type="date" name="eregdate" value="${formMap.eregdate}" class="form-control" placeholder="마감일" style="width:100px;">
			</label>
			<input type="button" class="btn btn-default" style="float:left; margin-left:10px;" onclick="javascript:search_list();" value="검색">
		</div>
		
		
	</div>
	
	<table class="table table-bordered table-hover sorttable" style="margin-top:10px;">
		<caption style="display: none;">대명아임레디 박람회 - 상담 관리</caption>
	 	<thead>
	  		<tr>
			    <th class="td-no">번호</th>
			    <th class="td-mng">카테고리</th>
			    <th class="td-mng">상품</th>
			    <th class="td-mng">이름</th>
			    <th class="td-mng">연락처</th>
			    <th class="td-time">등록일</th>
			    <th class="td-order">유입경로</th>
			    <th class="td-mng">상담차수</th>
			    <th class="td-mng">상담상태</th>
			    <th class="td-order">관리</th>
	  		</tr>
	 	</thead>
	 	<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
		</tbody>
		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
 			<tr>
			    <td style="text-align:center;">
			   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
			   	</td>
			   	<td style="text-align:left;" class="fcTitle">${list.fcTitle}</td>
			    <td style="text-align:left;">${list.fpMainTitle}</td>
			   	<td class="input_name" style="text-align:center; cursor:pointer; text-decoration: underline;" onclick="javascript:document.location.href='./detail.do?fupSeq=${list.fupSeq}';"></td>
			   	<td class="input_phone" style="text-align:center; cursor:pointer; text-decoration: underline;" onclick="javascript:document.location.href='./detail.do?fupSeq=${list.fupSeq}';"></td>
			    <td style="text-align:center;">${list.fupRegdate}</td>
			    <td style="text-align:center;">${list.fupFromurl}</td>
			    <td style="text-align:center;">${list.fupcStatusNumber}</td>
			    <td style="text-align:center;">${list.fupcStatus}</td>
			    <td style="text-align:center;">
			    	<a href="javascript:del('${list.fupSeq}');" class="btn btn-danger btn-xs">삭제</a>
			    	<textarea class="userInput" style="display:none;">${list.fupValue}</textarea>
		    	</td>
		  	</tr>
	 	</c:forEach>
	 </table>
</form>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />				
		</ul>
	</div>
</div>

<!-- 메모 모달 -->
<div id="memoModal" class="modal fade" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">상담메모</h4>
			</div>
			<div class="modal-body">
				<form name="memoForm" id="memoForm">
					<input type="hidden" name="FAIR_USER_PRODUCT_FUP_SEQ" value="">
					<textarea name="FUPC_MEMO" style="width:100%; height:200px;"></textarea>
					<button type="button" class="btn btn-primary" onclick="javascript:memo_insert();">확인</button>
				</form>
				<div id="memoList"></div>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" onclick="javascript:document.location.reload();">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- 카테고리별 상담 URL 모달 -->
<div id="cateModal" class="modal fade" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">각 상담업체 계정별 메뉴를 생성해주세요.</h4>
			</div>
			<div class="modal-body">
				<table class="table table-bordered table-hover sorttable" style="margin-top:10px;">
			  		<tr>
					    <th width=30%">카테고리</th>
					    <th width="*">URL</th>
					    <th width="20%">복사</th>
			  		</tr>
			  		<c:forEach var="list" items="${cateMap.list}" varStatus="status">
				  		<tr>
				  			<td style="text-align:center;">${list.fcTitle}</td>
				  			<td><input type="text" value="${domain}/mngwserc/fair/user/${list.fcSeq}/consult.do" class="form-control" readonly id="cateLink${list.fcSeq}"></td>
				  			<td style="text-align:center;"><button type="button" class="btn btn-default btn-xs copyLink" data-clipboard-target="#cateLink${list.fcSeq}">복사</button></td>
				  		</tr>
					</c:forEach>
			  	</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
	
<script type="text/javascript">
	//리스트 가져오기
	function getPageList()
	{	
		var f = document.frm;

		if(arguments.length > 0) f.pageIndex.value = arguments[0];
		else f.pageIndex.value = 1;
		
		f.action = "./index.do";
		f.submit();
	}
	
	function search_category(cate) {
		var f = document.frm;
		f.action = "./index.do";
		f.pageIndex.value = "1";
		f.fcseq.value = cate;
		f.name.value = "";
		f.phone.value = "";
		f.status.value = "";
		f.sregdate.value = "";
		f.eregdate.value = "";
		getPageList();
	}
	
	function search_list(){
		var f = document.frm;
		f.pageIndex.value = "1";
		f.action = "./index.do";
		f.submit();
	}
	
	//삭제
	function del(seq)
	{
		if(confirm("삭제하시겠습니까? 복구할수 없습니다."))
		{
			jQuery.ajax({
				url: "./delete.ajax",
				type: "POST",
				dataType: "JSON",
				data: {
					"fupSeq": seq
				},
				error: function(data) {
// 					console.log(data);
	            },
	            complete: function() {
	            	
	            },
				success: function(data) {
					alert("삭제완료 되었습니다.");
					location.reload();
				}
			});
		}
	}
	
	Number.prototype.format = function(){
	    if(this==0) return 0;
	    var reg = /(^[+-]?\d+)(\d{3})/;
	    var n = (this + '');
	    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
	    return n;
	};
	jQuery(document).ready(function(){
		jQuery(".userInput").each(function(){
			var obj = jQuery(this).closest("tr");

			var json = JSON.parse(jQuery(this).val());

			for(var i =0; i < json.INPUT.length; i++) {
				var input = json.INPUT[i];
				if(input.TITLE == '이름') jQuery(obj.find(".input_name").html(input.VALUE))
				if(input.KEY == 'HPHONE') jQuery(obj.find(".input_phone").html(input.VALUE))
			}
		});
		
		var clipboard = new ClipboardJS('.copyLink');
		clipboard.on('success', function(e) {
			alert("복사 완료");
		    e.clearSelection();
		});
		clipboard.on('error', function(e) {
		    alert("복사 실패. 관리자에게 문의해주세요.")
		});
	});
	
	function memoModal(fupSeq, _this) {
		var f = document.memoForm;
		f.FAIR_USER_PRODUCT_FUP_SEQ.value = fupSeq;
		
		jQuery.ajax({
			url: "./memo_select.do",
			type: "POST",
			dataType: "html",
			data: {
				"fupSeq": fupSeq
			},
			error: function(data) {
// 				console.log(data);
            },
            complete: function() {
            	
            },
			success: function(data) {
				jQuery("#memoList").html(data);
				
				var fcTitle = _this.closest("tr").find(".fcTitle").text();
				var jsonString = _this.closest("tr").find(".userInput").val();
				var jsonData = JSON.parse(jsonString);
				
				
				jQuery("#memoModal").modal();
			}
		});
		
	}
	
	function memo_insert() {
		var f = document.memoForm;
		if(f.FAIR_USER_PRODUCT_FUP_SEQ.value == "") {
			alert("유저정보를 찾을수 없습니다. 새로고침후 다시 시도해주세요.");
			return;
		}
		if(f.FUPC_MEMO.value == "") {
			alert("메모를 입력해주세요.");
			f.FUPC_MEMO.focus();
			return;
		}
		var options = { 
	        url: "./memo_insert.ajax", 
	        type: "post", 
	        dataType: "json", 
	        beforeSubmit: function() {
	        	
	        }, 
	        success: function(data) {
	        	memoModal(f.FAIR_USER_PRODUCT_FUP_SEQ.value);
	        },
	        error: function(){
	        	alert("저장에 실패하였습니다. 다시 시도해주세요.")
	        }
	    }; 
        jQuery("#memoForm").ajaxSubmit(options); 
	}
	
	function memo_delete(seq)
	{
		if(confirm("삭제하시겠습니까? 복구할수 없습니다."))
		{
			jQuery.ajax({
				url: "./memo_delete.ajax",
				type: "POST",
				dataType: "JSON",
				data: {
					"fupcSeq": seq
				},
				error: function(data) {
					console.log(data);
	            },
	            complete: function() {
	            	
	            },
				success: function(data) {
					memoModal(document.memoForm.FAIR_USER_PRODUCT_FUP_SEQ.value);
				}
			});
		}
	}
	
	function status_change(_this, fupSeq) {
		jQuery.ajax({
			url: "./status_change.ajax",
			type: "POST",
			dataType: "JSON",
			data: {
				"fupSeq": fupSeq,
				"FAIR_STATUS": _this.val()
			},
			error: function(data) {
				console.log(data);
            },
            complete: function() {
            	
            },
			success: function(data) {
				alert('저장완료');
			}
		});
	}
	
	function search_excel() {
		document.frm.action = "./excel.do";
		document.frm.submit();
	}
</script>