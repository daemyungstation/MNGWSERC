<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	BMABoardEditorView.jsp
	프로그램 명 : 	게시판 통합 상세보기 에디터 View
	설명		: 	게시판 통합 상세보기 에디터 View 페이지
	작성자		: 	안진용
	작성일		:	2015.11.24
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.24				안진용				최초작성
	######################################################################
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<link rel="stylesheet" href="<fmt:message key='Globals.httpUrl' />/common/css/lifeway_style.css" media="all" />
		<script type="text/javascript" src="/common/js/jquery.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("img").each(function(){
					jQuery(this).attr("src", "<fmt:message key='Globals.httpUrl' />" + jQuery(this).attr("src"));	
				});
			});
		</script>
	</head>
	<body>
		<div id="wrapper">
			<div id="cBody">
				<div class="subBody">
					<div id="subCon">
						<div class="prView">
							<div class="view">
								<c:if test="${mstInfo.communityType eq 'MOVIE'}">
									<style> 
										.embed-container { 
											position: relative; 
											padding-bottom: 56.25%; 
											height: 0; 
											overflow: hidden; 
											max-width:100%;
											margin-bottom:20px; 
										}
 										.embed-container embed, 
 										.embed-container object, 
 										.embed-container embed { 
 											position: absolute; 
 											top: 0; 
 											left: 0; 
 											width: 100%; 
 											height: 100%; 
 										}
									</style>
									<div class="embed-container">
										<c:set var="videoUrl" value="${fn:replace(rtnMap.boardInfo.movieUrl, 'https://youtu.be/', '')}" /> 
										<object data="https://www.youtube.com/embed/${videoUrl}?re=0&fs=0" border="0"></object>
									</div>
									<div class="mvScript mt25">
										${rtnMap.boardInfo.movieContents}
									</div>
								</c:if>
							 	<c:forEach var="list" items="${rtnMap.contentsFileList}" varStatus="status">
							   		<div>
							   			<img src="/cmm/fms/getImage.do?fileId=${list.atchFileId}&fileSn=${list.fileSeq}" style="max-width:900px;" alt="${list.fileDsc}" />
							   		</div>
						       	</c:forEach>
								${rtnMap.boardInfo.contents}
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>