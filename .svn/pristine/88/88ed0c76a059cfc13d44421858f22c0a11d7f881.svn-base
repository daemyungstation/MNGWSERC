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
.table input[type="text"]{ 
	width:100%;
    padding: 20px 10px;
	box-sizing:border-box;
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
	position:absolute;
	top:10px;
    right: 10px;
	display: block;
    background: transparent url(//www.daemyungimready.com/common/images/btn/popupClose_btn.png) no-repeat center center;
    width: 22px;
    height: 22px;
    border: 0 none;
}
</style>
<div class="wrap_pop">
	<h1>팝업 타이틀</h1>
	<table class="table table-bordered">
		<colgroup>
			<col width="20%">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>
					상세 타이틀
				</th>
				<td>
					<!--상세 내용 -->
					<input type="text" name="">
				</td>
			</tr>
			<tr>
				<th>
					상단 이미지
					<span class="btn_cate_add btn btn-success">+ 추가</span>
				</th>
				<td>
					<!-- loop -->
					<div class="loop">
						<div class="title">
							<span class="tit">상단이미지1</span>
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
							<tr>
								<th>분류</th>
								<th>파일 이름</th>
								<th>파일 사이즈</th>
								<th>파일 구분</th>
								<th>파일 삭제</th>
							</tr>
							<tr>
								<td>PC <input type="file" name=""></td>
								<td class="td_name">
									<span>제로 초이스 PC 1</span>
									<a href="javascript:preview();">미리보기</a>
								</td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
							<tr>
								<td>Mobile <input type="file" name=""></td>
								<td class="td_name">
									<span>제로 초이스 Mobile 1</span>
									<a href="javascript:preview();">미리보기</a>
								</td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
						</table>
						<div class="pop_visible">
							<div class="pop_check">
								<input type="checkbox" name="" id="1">팝업 노출
							</div>		
							<table class="table_add" style="display:none;">			
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
									<td>PC <input type="file" name=""></td>
									<td class="td_name">
										<span>제로 초이스 PC 1</span>
										<a href="javascript:preview();">미리보기</a>
									</td>
									<td>43MB</td>
									<td>JPG</td>
									<td><button type="button">삭제</button></td>
								</tr>
								<tr>
									<td>Mobile <input type="file" name=""></td>
									<td class="td_name">
										<span>제로 초이스 Mobile 1</span>
										<a href="javascript:preview();">미리보기</a>
									</td>
									<td>43MB</td>
									<td>JPG</td>
									<td><button type="button">삭제</button></td>
								</tr>
							</table>
						</div>
					</div>
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
					상세 타이틀
				</th>
				<td>
					<!--상세 내용 -->
					<input type="text" name="">
				</td>
			</tr>
			<tr>
				<th>
					하단 이미지
					<span class="btn_cate_add btn btn-success">+ 추가</span>
				</th>
				<td>
					<!-- loop -->
					<div class="loop">
						<div class="title">
							<span class="tit">상단이미지1</span>
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
							<tr>
								<th>분류</th>
								<th>파일 이름</th>
								<th>파일 사이즈</th>
								<th>파일 구분</th>
								<th>파일 삭제</th>
							</tr>
							<tr>
								<td>PC <input type="file" name=""></td>
								<td class="td_name">
									<span>제로 초이스 PC 1</span>
									<a href="javascript:preview();">미리보기</a>
								</td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
							<tr>
								<td>Mobile <input type="file" name=""></td>
								<td class="td_name">
									<span>제로 초이스 Mobile 1</span>
									<a href="javascript:preview();">미리보기</a>
								</td>
								<td>43MB</td>
								<td>JPG</td>
								<td><button type="button">삭제</button></td>
							</tr>
						</table>
						<div class="pop_visible">
							<div class="pop_check">
								<input type="checkbox" name="" id="1">팝업 노출
							</div>
							<table class="table_add" style="display:none;">			
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
									<td>PC <input type="file" name=""></td>
									<td class="td_name">
										<span>제로 초이스 PC 1</span>
										<a href="javascript:preview();">미리보기</a>
									</td>
									<td>43MB</td>
									<td>JPG</td>
									<td><button type="button">삭제</button></td>
								</tr>
								<tr>
									<td>Mobile <input type="file" name=""></td>
									<td class="td_name">
										<span>제로 초이스 Mobile 1</span>
										<a href="javascript:preview();">미리보기</a>
									</td>
									<td>43MB</td>
									<td>JPG</td>
									<td><button type="button">삭제</button></td>
								</tr>
							</table>
						</div>
					</div>
					<!-- // loop -->
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<div>
			<button type="button" onclick="preview_close()"></button>
			<img src="http://image.lifewayshopping.com/data/dlwmall_data/images/banner/71/로그인배너_씨유.jpg" />
		</div>
	</div>
</div>
<!-- // 미리보기 -->
<script type="text/javascript">
$(function(){
	$(".btn_cate_add").click(function(){
		$(this).parents('tr').children('td').append("<div class='loop'><div class='title'><span class='tit'>상단이미지1</span><button type='button' onclick='div_del(this)'>영역 삭제</button><span class='txt'>*PC 가로 000, Mobile 가로 000의 JPG, PNG, GIF 파일을 등록해주세요.</span></div><table class='table_add'><colgroup><col width='20%'><col width='*'><col width='10%'><col width='10%'><col width='10%'></colgroup><tr><th>분류</th><th>파일 이름</th><th>파일 사이즈</th><th>파일 구분</th><th>파일 삭제</th></tr><tr><td>PC <input type='file' name=''></td><td class='td_name'><span>제로 초이스 PC 1</span><a href='javascript:preview();'>미리보기</a></td><td>43MB</td><td>JPG</td><td><button type='button'>삭제</button></td></tr><tr><td>Mobile <input type='file' name=''></td><td class='td_name'><span>제로 초이스 Mobile 1</span><a href='#'>미리보기</a></td><td>43MB</td><td>JPG</td><td><button type='button'>삭제</button></td></tr></table><div class='pop_visible'><div class='pop_check'><input type='checkbox' name='' id='1'>팝업 노출</div><table class='table_add' style='display:none;'><colgroup><col width='20%'><col width='*'><col width='10%'><col width='10%'><col width='10%'></colgroup><tr><th>분류</th><th>파일 이름</th><th>파일 사이즈</th><th>파일 구분</th><th>파일 삭제</th></tr><tr><td>PC <input type='file' name=''></td><td class='td_name'><span>제로 초이스 PC 1</span><a href='javascript:preview();'>미리보기</a></td><td>43MB</td><td>JPG</td><td><button type='button'>삭제</button></td></tr><tr><td>Mobile <input type='file' name=''></td><td class='td_name'><span>제로 초이스 Mobile 1</span><a href='#'>미리보기</a></td><td>43MB</td><td>JPG</td><td><button type='button'>삭제</button></td></tr></table></div></div>");
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
	$(e).closest(".loop").remove();
}
function preview() {
	$("#preview").css("display","table")
}
function preview_close() {
	$("#preview").css("display","none")
}
</script>