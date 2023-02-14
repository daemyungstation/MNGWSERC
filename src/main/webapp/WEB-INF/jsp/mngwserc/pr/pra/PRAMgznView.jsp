<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	PRAMgznView.jsp
	프로그램 명 : 	라이프웨이 매거진 상세를 조회한다.
	설명		: 	라이프웨이 매거진 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.16
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.16				허진영				최초작성
	######################################################################
-->

<c:set var="lifeMgznInfo" value="${rtnMap.lifeMgznInfo}" />

<form name="frm" method="post">
	<input type="hidden" name="mgznSeq" value="" />
	<input type="hidden" name="delSeq" value="" />
	<!-- 히든리스트 -->
	
	<table class="table table-bordered">
		<caption style="display: none;">라이프웨이 매거진 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					메거진 발간년도
				</th>
				<td>
					${lifeMgznInfo.mgznPbtnYr}
				</td>				
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">봄</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					${lifeMgznInfo.sprTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					${lifeMgznInfo.sprSubTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.sprCvrFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.sprPdfFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					${lifeMgznInfo.sprEbkUrl}
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">여름</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					${lifeMgznInfo.smmrTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					${lifeMgznInfo.smmrSubTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.smmrCvrFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.smmrPdfFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					${lifeMgznInfo.smmrEbkUrl}
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">가을</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					${lifeMgznInfo.atmnTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					${lifeMgznInfo.atmnSubTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.atmnCvrFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.atmnPdfFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					${lifeMgznInfo.atmnEbkUrl}
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">겨울</th>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					타이틀
				</th>
				<td>
					${lifeMgznInfo.wntrTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					제목
				</th>
				<td>
					${lifeMgznInfo.wntrSubTitl}
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					표지이미지
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.wntrCvrFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					PDF 등록
				</th>
				<td>
					<c:forEach var="fileList" items="${rtnMap.wntrPdfFileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					E-Book URL
				</th>
				<td>
					${lifeMgznInfo.wntrEbkUrl}
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<a href="javascript:selectLifeMgzn();" class="btn btn-primary">수정</a>
	<a href="javascript:deleteLifeMgzn();" class="btn btn-danger">삭제</a>		
	<a href="./index.do" class="btn btn-default">취소</a>
</div>

<script type="text/javascript">

	function selectLifeMgzn()
	{
		var f = document.frm;	
		
		f.action = "./write.do";
		f.mgznSeq.value = "${lifeMgznInfo.mgznSeq}";
		f.submit();		
	}
	
	//삭제하기
	function deleteLifeMgzn()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			
			f.action = "./delete.do";
			f.delSeq.value = "${lifeMgznInfo.mgznSeq}";
			f.submit();
		}
	}
	
</script>