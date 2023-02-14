<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CODBoardMenu.jsp
	프로그램 명 : 	게시판 카테고리 관리
	설명		: 	게시판 카테고리 관리
	작성자		: 	안진용
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				안진용				최초작성
	######################################################################
-->    

<script type="text/javascript" src="/egov/js/jstree/jquery.jstree.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.hotkeys.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.cookies.js"></script>
<script type="text/javascript" src="/common/js/mngwserc/co/cod/CODBoardCtgr.js?{topNode:4}"></script>

<div id="mmenu" style="margin-top:20px;">
	<a href="javascript:" id="add_root" class="btn btn-info" style="margin-right:7px;">루트 생성</a>
	<a href="javascript:" id="add_folder" class="btn btn-success" style="margin-right:7px;">하위 생성</a>
	<a href="javascript:" id="rename" class="btn btn-primary" style="margin-right:7px;">메뉴명 변경</a>
	<a href="javascript:" id="remove" class="btn btn-danger">삭제</a>
</div>

<div id="divCategoris" style="width:355px; margin-top:10px; float:left; height:500px; overflow-y:auto;">

</div>

<form name="menuFrm">
	<div id="menuInf" style="margin-left:380px; overflow:auto; margin-top:10px;">
		<input type="hidden" id="menuSeq" name="menuSeq" value="" />
		
		<table class="table table-bordered">
			<colgroup>
				<col width="15%" />
				<col width="85%" />
			</colgroup>
			<tbody>
				<tr>
					<td>ID</td>
					<td style="text-align:left; padding-left:5px;">
						<span id="spanMenuSeq"></span>
					</td>
				</tr>
				<tr>
					<td>카테고리 노출</td>
					<td style="text-align:left; padding-left:5px;">
						<select id="userUseYn" name="userUseYn">
							<option value="N">미노출</option>
							<option value="Y">노출</option>
						</select>
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