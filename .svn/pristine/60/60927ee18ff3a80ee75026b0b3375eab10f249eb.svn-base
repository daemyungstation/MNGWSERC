<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMBDtlMngView.jsp
	프로그램 명 : 	전환서비스 상세관리 상세
	설명		: 		전환서비스 상세관리 상세 페이지
	작성자		: 	김대환
	작성일		:	2016.02.19
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.19			김대환				최초작성
	######################################################################
-->
<c:set var="dtlInfo" value="${rtnMap.dtlInfo}" />
<jsp:useBean id="toDay" class="java.util.Date"></jsp:useBean>

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="prdctDtlSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display: none;">전환서비스 상품내역 관리</caption>
		<colgroup>
			<col width="20%" />
			<col width="80%" />
		</colgroup>
		<tbody>
				<tr>
					<th style="vertical-align:middle;">
						구분
					</th>
					<td>
						${dtlInfo.prdctGb}
					</td>				
				</tr>
				<tr>
					<th style="vertical-align:middle;">
						상품제목
					</th>
					<td>
						${dtlInfo.prdctTitl}
					</td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">
						신청기간
					</th>
					<td>
						<c:choose>
							<c:when test="${dtlInfo.odtmYn eq 'Y'}">
								상시
							</c:when>
							<c:when test="${dtlInfo.odtmYn eq 'N'}">
								${egov:convertDate(dtlInfo.rqstStrtDt, 'yyyyMMdd', 'yyyy-MM-dd','')}
								&nbsp;~&nbsp;
								${egov:convertDate(dtlInfo.rqstEndDt, 'yyyyMMdd', 'yyyy-MM-dd','')}
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose> 
					</td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">
						일정
					</th>
					<td>
						${dtlInfo.schd}
					</td>
				</tr>
				<c:forEach var="list" items="${rtnMap.infoDtl}" varStatus="status">
					<tr>
						<th style="vertical-align:middle;">
							${list.titl}
						</th>
						<td>
							${list.cntn}
						</td>
					</tr>
				</c:forEach>
				<tr>
					<th style="vertical-align:middle;">
						썸네일 이미지
					</th>
					<td>
						<c:if test="${fn:length(rtnMap.thnlFileList) > 0}">
							<c:forEach var="fileList" items="${rtnMap.thnlFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
						</c:if>
					</td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">
						이미지 등록(20개)
					</th>
					<td>
						<c:if test="${fn:length(rtnMap.atchFileList) > 0}">
							<c:forEach var="fileList" items="${rtnMap.atchFileList}" varStatus="status">
		      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
							</c:forEach>
						</c:if>
					</td>
				</tr>
				<tr>
					<th style="vertical-align:middle;">
						URL
					</th>
					<td>
						${dtlInfo.link}
					</td>
				</tr>
				<tr>
					<th colspan="2" style="vertical-align:middle;">
						상품 상세내용
					</th>
				</tr>
				<tr>
					<td colspan="2">
						<iframe src="/mngwserc/cmb/dtl/view.do?prdctDtlSeq=${dtlInfo.prdctDtlSeq}&editorView=Y" style="width:100%;" frameborder="0" onload="autoResize(this)"></iframe>
					</td>
				</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:selectChngDtl();" class="btn btn-success">수정</a>
	<a href="javascript:deleteChngDtl();" class="btn btn-danger">삭제</a>
	<a href="./list.do" class="btn btn-default">목록</a>
</div>

<script type="text/javascript">
	
	//수정페이지
	function selectChngDtl()
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.prdctDtlSeq.value = "${dtlInfo.prdctDtlSeq}";
		f.submit();
	}

	//삭제하기
	function deleteChngDtl()
	{
		if(confirm("삭제하시겠습니까?")) 
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.delSeq.value = "${dtlInfo.prdctDtlSeq}";
			f.submit();
		}
	}
	
	function autoResize(i)
	{
	    var iframeHeight = (i).contentWindow.document.body.scrollHeight;
	    (i).height = iframeHeight + 40;
	}
	
</script>