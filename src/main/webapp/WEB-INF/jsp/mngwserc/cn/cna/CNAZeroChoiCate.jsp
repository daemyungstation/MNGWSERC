<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CODAdmMenuList.jsp
	프로그램 명 : 	관리자 메뉴 관리
	설명		: 	관리자 메뉴 관리
	작성자		: 	김대환
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				김대환				최초작성
	######################################################################
-->

<script type="text/javascript" src="/egov/js/jstree/jquery.jstree.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.hotkeys.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.cookies.js"></script>
<!-- script type="text/javascript" src="/common/js/mngwserc/co/cod/CODAdmMenu.js?{topNode:2}"></script> -->
<script type="text/javascript" src="/common/js/mngwserc/cn/cna/CNAZeroChoiCate.js"></script>

<div id="mmenu" style="margin-top:20px;">
	<a href="javascript:" id="add_root" class="btn btn-success" style="margin-right:7px;">신규 생성</a>
<!-- 	<a href="javascript:" id="add_folder" class="btn btn-success" style="margin-right:7px;">폴더 추가</a> -->
	<a href="javascript:" id="rename" class="btn btn-primary" style="margin-right:7px;">카테고리명 수정</a>
	<a href="javascript:" id="remove" class="btn btn-danger" style="margin-right:10px;">삭제</a>
</div>

<div id="divCategoris" style="width:355px; height:500px; margin-top:10px; float:left; overflow-y:auto;">

</div>
<!-- <a href="javascript:cateSave();" class="btn btn-danger" style="margin-right:10px;">적용</a>

<script>
function cateSave() {
	$.ajax({
		url : "./cateAllDel.ajax",
		type : "get",
		success : function() {
			var cateList = $("#divCategoris li");
			var param_arr = [];
			
			for(var i=0; i<cateList.length; i++) {
				var pstn = i+1;
				var cateNm = cateList.eq(i).text().trim();
				var obj = {"pstn" : pstn, "cateNm" : cateNm}
				
				param_arr.push(obj);
				console.log(obj)
				console.log("hi");
				
			 	$.ajax({
					url : "./cateWrite.ajax",
					type : "post",
					data : obj
				});
				
				console.log("pstn : "  + pstn + " // cateNm : " + cateNm);
			}
		}
	});

;}
</script> -->
			<!-- <tbody>
				
<form name="menuFrm">
	<div id="menuInf" style="margin-left:380px; overflow:auto; margin-top:10px;">
		<input type="hidden" id="menuSeq" name="menuSeq" value="" />
		<input type="hidden" id="admLink" name="admLink" value="" />
		<input type="hidden" id="refSeq" name="refSeq" value="" />
		
		<table class="table table-bordered">
			<colgroup>
				<col width="15%" />
				<col width="85%" />
			</colgroup>

				<tr>
					<td>ID</td>
					<td style="text-align:left; padding-left:5px;">
						<span id="spanMenuSeq"></span>
					</td>
				</tr>
				<tr>
					<td>형태</td>
					<td style="text-align:left; padding-left:5px;">
						<input type="radio" name="menuGb" value="folder" checked="checked" />&nbsp;<img src="/egov/js/jstree/folder.png" /> 관리자 &nbsp;&nbsp;
						<input type="radio" name="menuGb" value="board" />&nbsp;<img src="/egov/js/jstree/board.png" /> 게시판 &nbsp;&nbsp;
						<input type="radio" name="menuGb" value="cms" />&nbsp;<img src="/egov/js/jstree/cms.png" /> CMS &nbsp;&nbsp;												
						<input type="radio" name="menuGb" value="etc" />&nbsp;<img src="/egov/js/jstree/etc.png" /> 기타 &nbsp;&nbsp;
					</td>
				</tr>
				<tr id="contentstype" style="display:none;">
					<td>컨텐츠 선택</td>
					<td style="text-align:left; padding-left:5px;">		
						<span id="refNm"></span>
						<a href="javascript:getCategory();" class="btn" title="검색"><i class="icon-search"></i></a>
					</td>
				</tr>
				<tr>
					<td>URL</td>
					<td style="text-align:left; padding-left:5px;">
						<input type="text" id="userLink" name="userLink" style="width:80%; height:18px; font-size:12px;" maxlength="600" />
						<span id="urlLastNm" style="display:none;"></span>
					</td>
				</tr>
				-->
				<!--
				<tr>
					<td>새창 여부</td>
					<td style="text-align:left; padding-left:5px;">
						<select id="userWndYn" name="userWndYn">
							<option value="N">미사용</option>
							<option value="Y">사용</option>							
						</select>
					</td>
				</tr>
				<tr>
					<td>사용자 노출</td>
					<td style="text-align:left; padding-left:5px;">
						<select id="userUseYn" name="userUseYn">
							<option value="N">미노출</option>
							<option value="Y">노출</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>SEO Description</td>
					<td style="text-align:left; padding-left:5px;">
						<input type="text" id="seo" name="seo" style="width:98%; height:18px; font-size:12px;" maxlength="2000" />
					</td>
				</tr>
				<tr>
					<td>키워드</td>
					<td style="text-align:left; padding-left:5px;">
						<input type="text" id="kwrd" name="kwrd" style="width:98%; height:18px; font-size:12px;" maxlength="2000" />
					</td>
				</tr>

			</tbody>
		</table>
		
		<table cellpadding="0" cellspacing="0" width="100%" style="margin:10px 0 10px;">
			<tr>
				<td colspan="2" style="border-bottom:0;" align="right">
					<a href="javascript:updateMenuInf();" class="btn btn-success">적용</a>
				</td>
			</tr>
		</table>
	</div>
</form>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
	        	<h4 class="modal-title" id="myModalLabel">카테고리 선택</h4>
			</div>
	      	<div class="modal-body">
	       		<div id="divContentsCategory" style="width:98%;margin-top:10px;float:left;">
				
				</div>
	      	</div>
	      	<div class="modal-footer">
	      		<a href="javascript:setCategory();" id="select" class="btn btn-success">선택</a>
	        	<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	      	</div>
	    </div>
	</div>
</div>-->