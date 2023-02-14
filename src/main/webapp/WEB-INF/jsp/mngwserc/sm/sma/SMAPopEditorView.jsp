<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--
	######################################################################
	파일명 		:	SMAPopEditorView.jsp
	프로그램 명 : 	팝업 에디터 View
	설명		: 	팝업 에디터 View 페이지
	작성자		: 	김대환
	작성일		:	2015.11.17
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.17				김대환				최초작성
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
			${rtnMap.popInfo.cntn}
		</div>
	</body>
</html>