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
	border-bottom:1px solid #ddd;
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
.pop_visible{
	margin-top:10px;
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
<form name="frm_write" data-type="" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="" />
	<input type="hidden" name="del_fileseq" value="" /> 
	<div class="wrap_pop">
		<h1></h1>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>
						제목
					</th>
					<td>
						<!--상세 내용 -->
						<input type="text" name="title">
						<span></span>
					</td>
				</tr>
				<tr>
					<th>이미지<span class="btn_cate_add btn btn-success" onclick="imgAddBtn();">+ 추가</span></th>
					<td>
						<div class="_loop">
<!-- 							HTML 들어갈 자리 -->							
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-bordered">
			<tr>
				<th style="vertical-align:middle;">
					진행기간
				</th>
				<td>
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="start_dtm" name="start_dtm" value="${egov:convertDate(pfmcInfo.pfmcStrtDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input input-small" style="width:100px; text-align:center;" readonly="readonly"/>
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
					~
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="end_dtm" name="end_dtm" value="${egov:convertDate(pfmcInfo.pfmcEndDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input input-small" style="width:100px; text-align:center;" readonly="readonly"/>
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
					<span id="_oprt_dtm_chk_word"></span>
					<br/><br/>* 진행기간이 지나면 PC & Mobile의 배너 이미지가 썸네일로 수정됩니다.
				</td>			
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					진행 중
				</th>
				<td style="vertical-align:middle;">
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="oprt_yn" value="Y" checked="checked" /> 진행 중
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="oprt_yn" value="N" /> 종료
					</span>
				</td>
				<td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					노출여부
				</th>
				<td style="vertical-align:middle;">
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="use_yn" value="Y" checked="checked" /> 예
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="use_yn" value="N" /> 아니오
					</span>
				</td>
				<td>
			</tr>
		</table>
	</div>
</form>

<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<button type="button" onclick="preview_close()"></button>
		<div>
			<img src="" />
		</div>
	</div>
</div>

<div style="text-align:center;">
	<a href="javascript:writeBtn();" class="btn btn-success" id="write_btn"></a>
	<a href="javascript:cancelBtn();" class="btn btn-default" id="cancel_btn">취소</a>
</div>
