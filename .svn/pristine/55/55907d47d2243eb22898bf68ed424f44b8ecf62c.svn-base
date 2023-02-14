<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CODCntnsMenu.jsp
	프로그램 명 : 	CMS 메뉴관리
	설명		: 	CMS 메뉴관리
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
<script type="text/javascript" src="/common/js/mngwserc/co/cod/CODCntnsMenu.js?{topNode:21}"></script>

<div id="mmenu" style="margin-top:20px;">
	<a href="javascript:" id="add_root" class="btn btn-info" style="margin-right:7px;">루트 생성</a>
	<a href="javascript:" id="add_folder" class="btn btn-success" style="margin-right:7px;">하위 생성</a>
	<a href="javascript:" id="rename" class="btn btn-primary" style="margin-right:7px;">메뉴명 변경</a>
	<!-- 
	<a href="javascript:" id="remove" class="btn btn-danger">삭제</a>&nbsp;&nbsp; 
	-->
</div>

<div id="divCategoris" style="width:355px; height:500px; margin-top:10px; float:left; overflow-y:auto;">

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
			</tbody>
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
</div>