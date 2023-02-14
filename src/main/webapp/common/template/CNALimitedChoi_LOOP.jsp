<%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
._imgAdd {
	margin-bottom: 20px;
}
</style>
<div class="_imgAdd">
<span class="_chk_img_word"></span>
<div class="title">
	<span class="tit">
		<span class="tit">이미지 <span class="_imgCnt"></span></span>
	</span>
	<button type='button' onclick='div_del(this)' class="_btn_imgDel hidden">영역 삭제</button>
	<span class="txt">*PC 가로 1920, Mobile 가로 640, 썸네일 360x210의 JPG, PNG, GIF 파일을 등록해주세요.</span>
</div>					
<table class="table_add" data-location="main">			
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
			<input type="file" style="display: none;">
			<input type="button" onclick="file_search_btn(this)" value="파일 찾기"/>
		</td>
		<td class="td_name">
			<span class="_text"></span>
			<input type="button" value="미리보기" onclick="javascript:preview(this);" data-fileseq="" class="btn_pop_preview hidden"/>
		</td>
		<td class="_text"></td>
		<td class="_text"></td>
		<td><button type="button" class="hidden" onclick="img_delBtn(this)">삭제</button></td>
	</tr>
	<tr>
		<td>Mobile 
			<input type="file" style="display: none;">
			<input type="button" onclick="file_search_btn(this)" value="파일 찾기"/>
		</td>
		<td class="td_name">
			<span class="_text"></span>
			<input type="button" value="미리보기" onclick="javascript:preview(this);" data-fileseq="" class="btn_pop_preview hidden"/>
		</td>
		<td class="_text"></td>
		<td class="_text"></td>
		<td><button type="button" class="hidden" onclick="img_delBtn(this)">삭제</button></td>
	</tr>
	<tr>
		<td>썸네일(Pc/Mobile)
			<input type="file" style="display: none;">
			<input type="button" onclick="file_search_btn(this)" value="파일 찾기"/>
		</td>
		<td class="td_name">
			<span class="_text"></span>
			<input type="button" value="미리보기" onclick="javascript:preview(this);" data-fileseq="" class="btn_pop_preview hidden"/>
		</td>
		<td class="_text"></td>
		<td class="_text"></td>
		<td><button type="button" class="hidden" onclick="img_delBtn(this)">삭제</button></td>
	</tr>
</table>
<div class="pop_visible">
	<div class="pop_check">
		<input type="checkbox" name="" onclick="pop_show(this)" class="_btn_popShow">팝업 노출
		<span class="_chk_img_word"></span>
	</div>		
	
	<div class="_popShow hidden">
		<table class="table_add" data-location="pop">			
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
					<input type="file" style="display: none;">
					<input type="button" onclick="file_search_btn(this)" value="파일 찾기"/>
				</td>
				<td class="td_name">
					<span class="_text"></span>
					<input type="button" value="미리보기" onclick="javascript:preview(this);" data-fileseq="" class="btn_pop_preview hidden"/>
				</td>
				<td class="_text"></td>
				<td class="_text"></td>
				<td><button type="button" class="hidden" onclick="img_delBtn(this)">삭제</button></td>
			</tr>
			<tr>
				<td>Mobile 
					<input type="file" name="mobile_pop" style="display: none;">
					<input type="button" onclick="file_search_btn(this)" value="파일 찾기"/>
				</td>
				<td class="td_name">
					<span class="_text"></span>
					<input type="button" value="미리보기" onclick="javascript:preview(this);" data-fileseq="" class="btn_pop_preview hidden"/>
				</td>
				<td class="_text"></td>
				<td class="_text"></td>
				<td><button type="button" class="hidden" onclick="img_delBtn(this)">삭제</button></td>
			</tr>
		</table>
	</div>
</div>
</div>