<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMBChngPrdctList.jsp
	프로그램 명 : 	전환서비스 상품관리 상세
	설명		: 	전환서비스 상품관리 상세 페이지
	작성자		: 	김대환
	작성일		:	2016.02.19
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.19				김대환				최초작성
	######################################################################
-->

<c:set var="prdctInfo" value="${rtnMap.prdctInfo}"/>

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="prdctSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">전환서비스 상품관리</caption>
		<colgroup>
			<col width="20%" />
			<col width="80%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					구분
				</th>
				<td style="vertical-align:middle;">
					${prdctInfo.prdctGb}
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					상품명
				</th>
				<td style="vertical-align:middle;">
					${prdctInfo.prdctNm}
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					상품내용
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<iframe src="/mngwserc/cmb/prdct/view.do?prdctSeq=${prdctInfo.prdctSeq}&editorView=Y&editorGb=prdctCntn" style="width:100%" frameborder="0" onload="autoResize(this)"></iframe>
				</td>
			</tr>
	 		<tr>
				<th colspan="2" style="vertical-align:middle;">
					이용안내
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<iframe src="/mngwserc/cmb/prdct/view.do?prdctSeq=${prdctInfo.prdctSeq}&editorView=Y&editorGb=oprtGuide" style="width:100%;" frameborder="0" onload="autoResize(this)"></iframe>
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:selectChngPrdctDtl();" class="btn btn-primary">수정</a>
	<a href="javascript:deleteChngPrdct();" class="btn btn-danger">삭제</a>
	<a href="./list.do" class="btn btn-default">목록</a>
</div>

<script type="text/javascript">
	
	//수정페이지
	function selectChngPrdctDtl()
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.prdctSeq.value = "${prdctInfo.prdctSeq}";
		f.submit();
	}

	//삭제하기
	function deleteChngPrdct(prdctSeq)
	{
		if(confirm("삭제하시겠습니까?")) 
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.delSeq.value = "${prdctInfo.prdctSeq}";
			f.submit();
		}
	}
	
	function autoResize(i)
	{
	    var iframeHeight = (i).contentWindow.document.body.scrollHeight;
	    (i).height = iframeHeight;
	}
	
</script>