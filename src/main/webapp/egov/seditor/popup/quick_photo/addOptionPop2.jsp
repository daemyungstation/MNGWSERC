<link href="/egov/css/table.css" rel="stylesheet" />
<link href="/egov/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src="/common/js/jquery.js"></script>
<style>
.wrap_pop{ 
	padding:14px; 
	box-sizing:border-box;
}
h1{ 
	padding:0 10px;
	font-size:22px; 
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
.table tr > *{  
	padding:10px;
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
.table input[type="radio"] {
    width: 20px;
    height: 20px;
    margin: 0 6px 0 0;
}
.table input[type="text"] {
    width: 100%;
    padding: 20px 10px;
    box-sizing: border-box;
}
.table input[type="file"]{ 
	display:block;
	margin:6px auto 0;
}
.table .btn_cate_add {
    display: block;
    width: 54px;
    margin: 4px auto 0;
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
.table .table_add td .btn-danger{ 
	 float:right;
}
.table .loop > div + div{ 
	 margin-top:20px;
	 padding-top:20px;
	 border-top:1px solid #ddd
}
.table .visible_yn{ 
	display:inline-block; 
}
.table .visible_yn + .visible_yn{ 
	margin-left:10px;
}
.table .customer_pay{ 
	overflow:hidden;
}
.table .customer_pay + .customer_pay{ 
	margin-top:10px;
}
.table .customer_pay span{  
	display:inline-block;
	width:20%;
}
.table .customer_pay input{  
	width:80%;
}
.table textarea{ 
	width:100%;
	height:100px;
}
</style>
<div class="wrap_pop">
	<h1>제로 초이스 상품 등록</h1>
	<table class="table table-bordered">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">카테고리</th>
				<td style="text-align:left;">
					<select>
						<option value="">* 카테고리를 선택해주세요</option>
						<option value="">* 카테고리를 선택해주세요</option>
						<option value="">* 카테고리를 선택해주세요</option>
						<option value="">* 카테고리를 선택해주세요</option>
					</select>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">제품명</th>
				<td style="text-align:left;">
					<input type="text" placeholder="* 제품명을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">모델명</th>
				<td style="text-align:left;">
					<input type="text" placeholder="* 모델명을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">고객부담금</th>
				<td style="text-align:left;">
					<div class="customer_pay"><span>총 금액</span><input type="text" placeholder="* 총 금액을 입력해주세요."></div>
					<div class="customer_pay"><span>총 납부금액</span><input type="text" placeholder="* 월 납부금액을 입력해주세요."></div>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">할부기간</th>
				<td style="text-align:left;">
					<select>
						<option value="">* 할부기간을 선택해주세요</option>
						<option value="">* 할부기간을 선택해주세요</option>
						<option value="">* 할부기간을 선택해주세요</option>
						<option value="">* 할부기간을 선택해주세요</option>
						<option value="">* 할부기간을 선택해주세요</option>
						<option value="">* 할부기간을 선택해주세요</option>
						<option value="">* 할부기간을 선택해주세요</option>
					</select>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					제품이미지
					<span class="btn_cate_add btn btn-success">+ 추가</span>
				</th>
				<td class="loop" style="text-align:left;">
					<div>
						<div class="title">
							<span class="tit">제품이미지1</span>
							<span class="txt">*PC 가로 000, Mobile 가로 000의 JPG, PNG, GIF 파일을 등록해주세요.</span>
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
								<td>PC <input type="file" name=""></td>
								<td class="td_name"></td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
							<tr>
								<td>Mobile <input type="file" name=""></td>
								<td class="td_name"></td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					제품스펙 이미지
				</th>
				<td style="text-align:left;">
					<div>
						<div class="title">
							<span class="tit">제품이미지1</span>
							<span class="txt">*PC 가로 000, Mobile 가로 000의 JPG, PNG, GIF 파일을 등록해주세요.</span>
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
								<td>PC <input type="file" name=""></td>
								<td class="td_name"></td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
							<tr>
								<td>Mobile <input type="file" name=""></td>
								<td class="td_name"></td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					노출여부
				</th>
				<td>
					<span class="visible_yn"><input type="radio" name="">예</span>
					<span class="visible_yn"><input type="radio" name="">아니오</span>
				</td>
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
					<p class="title"><span class="txt">*200자 내의 작성해주세요. (0/200)</span></p>
					<textarea name=""></textarea>
				</td>
			</tr>
		</tbody>
	</table>
	<div style="text-align:center;">
		<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		<a href="./index.do" class="btn btn-default">취소</a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$(".btn_cate_add").click(function(){
		$(".loop").append("<div><div class='title'><span class='tit'>제품이미지1</span><button type='button' onclick='div_del(this)'>영역 삭제</button><span class='txt'>*PC 가로 000, Mobile 가로 000의 JPG, PNG, GIF 파일을 등록해주세요.</span></div><table class='table_add'><colgroup><col width='20%'><col width='*'><col width='10%'><col width='10%'><col width='10%'></colgroup><tbody><tr><th>분류</th><th>파일 이름</th><th>파일 사이즈</th><th>파일 구분</th><th>파일 삭제</th></tr><tr><td>PC <input type='file' name=''></td><td class='td_name'></td><td>43MB</td><td>JPG</td><td><button type='button'>삭제</button></td></tr><tr><td>Mobile <input type='file' name=''></td><td class='td_name'></td><td>43MB</td><td>JPG</td><td><button type='button'>삭제</button></td></tr></tbody></table></div>");
	});
	table_add();
	$(".table .btn_cate_add").click(function(){
		table_add();
	});
});


function table_add() {
	$("input[type='checkbox']").click(function(){
		var chk = $(this).is(":checked");
		if(chk == 1){
			$(this).parent("div").next().css("display","table")
		}else{
			$(this).parent("div").next().css("display","none")
		}
	});
}
function div_del(e) {
	$(e).parent("div").parent("div").remove();
}
function preview() {
	$("#preview").css("display","table")
}
function preview_close() {
	$("#preview").css("display","none")
}
</script>