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
					jQuery(this).attr("src", "<fmt:message key='Globals.httpUrl' />" + jQuery(this).attr("src"));	
				});
				
				jQuery(".csConDiv").show();
				
				jQuery(".csConDiv .subSelDiv .selUnit").hide();
				jQuery(".csConDiv .subSelDiv .selUnit").eq(0).show();
				
				jQuery(".csConDiv .subSelDiv .subSel").each(function(k){
					jQuery(this).css("left", 90 * k);
				});
				
				jQuery(".csConDiv .subSelDiv .subSel").on("click", function(){
					jQuery(this).parent(".subSelDiv").find(".subSel").not(this).removeClass("on");
					
					jQuery(this).addClass("on");
					
					jQuery(this).parent(".subSelDiv").find(".selUnit").hide();
					
					jQuery(this).next().show();
				});
			});
		</script>
	</head>
	<body>
		<div id="wrapper">
			<div id="cBody">
				<div class="subBody">
					<div id="subCon">
						<c:if test="${rtnMap.editorGb eq 'prdctCntn'}">
							<div class="changeSer mt30">
								<div class="csConDiv"><!-- 전환서비스 콘텐츠 -->
									${rtnMap.prdctInfo.prdctCntn}
								</div>
							</div>
						</c:if>
						<c:if test="${rtnMap.editorGb eq 'oprtGuide'}">
							<div class="termDiv mt40">
								<div class="termBox">
									${rtnMap.prdctInfo.oprtGuide}
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>