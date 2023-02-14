<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	SMBOprtGuideView.jsp
	프로그램 명 : 	이용안내 상세를 조회한다.
	설명		: 	이용안내 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.12
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.12				허진영				최초작성
	######################################################################
-->

<c:set var="oprtGuideInfo" value="${rtnMap.oprtGuideInfo}" />

<form name="frm" method="post" action="">
	<input type="hidden" name="oprtGuideSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">이용안내 관리</caption>
		<colgroup>
			<col width="100%" />	
		</colgroup>
		<tbody>
			<tr>
				<td style="background-color:#f9f9f9">
					<font style="display:inline-block; float:left; margin-left:10px;">
						<b>${oprtGuideInfo.titl}</b>
					</font>
					<font style="display:inline-block; float:right; margin-right:10px;">
						${oprtGuideInfo.regId}&nbsp;
						${egov:convertDate(oprtGuideInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</font>
				</td>
			</tr>
			<tr>
				<td>
					<iframe src="./view.do?oprtGuideSeq=${oprtGuideInfo.oprtGuideSeq}&editorView=Y" style="width:100%" frameborder="0" onload="autoResize(this)"></iframe>
 				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:selectOprtGuide();" class="btn btn-primary">수정</a>
	<a href="javascript:deleteOprtGuide();" class="btn btn-danger">삭제</a>		
	<a href="./list.do" class="btn btn-default">목록</a>
</div>

<script type="text/javascript">

	//수정페이지
	function selectOprtGuide()
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.oprtGuideSeq.value = "${oprtGuideInfo.oprtGuideSeq}";
		f.submit();		
	}
	
	//삭제하기
	function deleteOprtGuide()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			
			f.action = "./delete.do";
			f.delSeq.value = "${oprtGuideInfo.oprtGuideSeq}";
			f.submit();
		}
	}
	
	function autoResize(i)
	{
	    var iframeHeight = (i).contentWindow.document.body.scrollHeight;
	    (i).height = iframeHeight + 40;
	}
</script>