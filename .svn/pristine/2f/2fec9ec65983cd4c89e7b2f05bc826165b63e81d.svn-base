<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
 <!-- 
	######################################################################
	파일명 		:	CMBChngPrdctList.jsp
	프로그램 명 : 	전환서비스 상품 에디터 View
	설명		: 	전환서비스 상품 에디터 View
	작성자		: 	허진영
	작성일		:	2016.02.24
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.24				허진영				최초작성
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
					
					if(jQuery(this).attr("src").indexOf("http") == -1 && jQuery(this).attr("src").indexOf("data:") == -1){
						jQuery(this).attr("src", "<fmt:message key='Globals.httpUrl' />" + jQuery(this).attr("src"));
					}	
				});
			});
		</script>
	</head>
	<body>
		<div id="wrapper">
			<div id="popup">
				<div class="popBody type2">
					${rtnMap.dtlInfo.prdctCntn}
				</div>
			</div>
		</div>
	</body>
</html>