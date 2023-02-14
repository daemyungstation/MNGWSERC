<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	SMBOprtGuideView.jsp
	프로그램 명 : 	팝업 상세를 조회한다.
	설명		: 	팝업 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<c:set var="popInfo" value="${rtnMap.popInfo}" />

<form name="frm" method="post" action="">
	<input type="hidden" name="popSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">팝업 관리</caption>
		<colgroup>
			<col width="100%" />	
		</colgroup>
		<tbody>
			<tr>
				<th>
					<font style="display:inline-block; float:left; margin-left:10px;">
						${popInfo.popNm}
					</font>
					<font style="display:inline-block; float:right; margin-right:10px;">
						${popInfo.regId}&nbsp;
						${egov:convertDate(popInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</font>
				</th>
			</tr>
			<tr>
				<td>
					<iframe src="./view.do?popSeq=${popInfo.popSeq}&editorView=Y" style="width:100%" frameborder="0" onload="autoResize(this)"></iframe>
 				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:selectPop();" class="btn btn-primary">수정</a>
	<a href="javascript:deletePop();" class="btn btn-danger">삭제</a>		
	<a href="./list.do" class="btn btn-default">목록</a>
</div>

<script type="text/javascript">

	//수정페이지
	function selectPop()
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.popSeq.value = "${popInfo.popSeq}";
		f.submit();		
	}
	
	//삭제하기
	function deletePop()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			
			f.action = "./delete.do";
			f.delSeq.value = "${popInfo.popSeq}";
			f.submit();
		}
	}
	
	function autoResize(i)
	{
	    var iframeHeight = (i).contentWindow.document.body.scrollHeight;
	    (i).height = iframeHeight + 40;
	}
	
</script>