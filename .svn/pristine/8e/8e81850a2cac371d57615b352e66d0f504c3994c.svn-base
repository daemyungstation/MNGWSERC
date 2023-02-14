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
.td-no { width: 20%; }
.td-auto { width: 30%; }

</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.4/clipboard.min.js"></script>

<h6 style="float:left;">대명아임레디 박람회 - 상품 상담</h6>
<c:forEach var="list" items="${rtnMap.list}" varStatus="status">

<table class="table table-bordered table-hover" style="margin-top:10px;margin-bottom:0px;">
	<caption style="display: none;">대명아임레디 박람회 - 상품 상담</caption>
 		<tr>
	    <th colspan="4" bgcolor="#EEEEEE">고객정보</th>
 		</tr>
 		<tr>
	    <th class="td-no">카테고리</th>
	    <td class="td-auto">${list.fcTitle}</td>
	    <th class="td-no">상품</th>
	    <td class="td-auto">${list.fpMainTitle}</td>
	</tr>
</table>
<div id="inputDetail">
</div>
<table class="table table-bordered table-hover">	
	<tr>
	    <th class="td-no">상품가격</th>
	    <td class="td-auto" id="inputPrice"></td>
	    <th class="td-no">등록일</th>
	    <td class="td-auto">${list.fupRegdate}</td>
	</tr>
	<tr>
	    <th class="td-no">상담차수</th>
	    <td class="td-auto">${list.fupcStatusNumber}</td>
	    <th class="td-no">상담상태</th>
	    <td class="td-auto">${list.fupcStatus}</td>
	</tr>
 </table>
 <textarea class="userInput" style="display:none;">${list.fupValue}</textarea>
 
 
<form name="memoForm" id="memoForm">
<input type="hidden" name="FAIR_USER_PRODUCT_FUP_SEQ" value="${list.fupSeq}">
<input type="hidden" name="FUPC_STATUS_NUMBER" value="본사">
<table class="table table-bordered table-hover" style="margin-top:20px;margin-bottom:0px;">
	<tr>
    	<th colspan="4" bgcolor="#EEEEEE">답변등록</th>
		</tr>
		<tr>
	    <th class="td-no">상담원</th>
	    <td class="td-auto"><input type="text" name="FUPC_NAME" value=""></td>
	    <th class="td-no">상담상태</th>
	    <td class="td-auto">
	    	<select name="FUPC_STATUS">
	    		<option value="">선택해주세요.</option>
				<option value="상담취소">상담취소</option>
				<option value="가입녹취요청">가입녹취요청</option>
				<option value="전화번호오류">전화번호오류</option>
				<option value="DB중복(기처리)">DB중복(기처리)</option>
				<option value="결번(FAX등)">결번(FAX등)</option>
				<option value="재통화요청">재통화요청</option>
				<option value="장기부재취소">장기부재취소</option>
				<option value="대기중">대기중</option>
				<option value="진행중">진행중</option>
				<option value="부재중">부재중</option>
				<option value="보류">보류</option>
				<option value="기타">기타</option>
				<option value="가입완료">가입완료</option>
				<option value="가입취소">가입취소</option>
	    	</select>
	    </td>
	</tr>
	<tr>
	    <th class="td-no">메모</th>
	    <td class="td-auto" colspan="3">
	    	<textarea name="FUPC_MEMO" style="width:90%; height:100px;"></textarea>
	    	<button type="button" class="btn btn-primary" onclick="javascript:memo_insert();">확인</button>
	    </td>
	</tr>
</table>
</form>
<div id="memoList"></div>
</c:forEach>

<div style="text-align:center; margin-top:10px;">
	<a href="./index.do" class="btn btn-success">목록</a>
</div>

<script>
 jQuery(document).ready(function(){
	jQuery(".userInput").each(function(){
		var obj = jQuery("#inputDetail");
		var json = JSON.parse(jQuery(this).val());
		var html = '<table class="table table-bordered table-hover" style="margin-top:0px;margin-bottom:0px;"><tr>';
		var ii = 0;
		for(var i =0; i < json.INPUT.length; i++) {
			if(i > 0 && i % 2 == 0) {
				html += "</tr><tr>";
			}
			var input = json.INPUT[i];
			html += "<th class='td-no'>"+ input.TITLE +"</th>";
			html += "<td class='td-auto'>"+ input.VALUE +"</td>";
			ii++;
		}
		if(ii % 2 == 0) {
			html += "</tr><tr>";
		}
		html += "<th class='td-no'>선택상품</th>";
		if(json.BENEFIT.FB_TITLE && json.BENEFIT.FB_TITLE != ''){
			html += "<td class='td-auto'>["+ json.BENEFIT.FB_TITLE +"]"+ json.BENEFIT.FB_SUBTITLE +"-"+ json.BENEFIT.FB_MODEL +"</td>";
		}else {
			html += "<td class='td-auto'>없음</td>";
		}
		html += "</tr></table>";
		
		jQuery("#inputDetail").html(html);
		jQuery("#inputPrice").html(json.PRICE);
	});
	memoList();
});

function memoList() {
	var f = document.memoForm;
	
	jQuery.ajax({
		url: "./memoselect.do",
		type: "GET",
		dataType: "html",
		data: {
			"fupSeq": f.FAIR_USER_PRODUCT_FUP_SEQ.value
		},
		error: function(data) {
        },
        complete: function() {
        	
        },
		success: function(data) {
			jQuery("#memoList").html(data);
		}
	});
	
}
	
function memo_insert() {
	var f = document.memoForm;
	if(f.FUPC_NAME.value == "") {
		alert("상담원을 입력해주세요.");
		f.FUPC_NAME.focus();
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
        	f.FUPC_NAME.value = "";
        	f.FUPC_STATUS.value = "";
        	f.FUPC_MEMO.value = "";
        	memoList();
        	document.location.reload();
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
				memoList();
				document.location.reload();
			}
		});
	}
}


 </script>