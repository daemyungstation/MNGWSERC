<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COHBoardMngEditorCallbak.jsp
	프로그램 명	: 	게시판
	설명		: 	EditorCallbak
	작성자		: 	손의균
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				손의균				최초작성
	######################################################################
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="ko">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <title>FileUploader Callback</title>
	</head>
	<body>
	    <script type="text/javascript">
			// document.domain 설정
			try 
			{ 
				document.domain = "<fmt:message key="Globals.HttpSiteUrl" />";
			} 
			catch(e) 
			{
				
			}
			
			try 
			{ 
				var sUrl = "sFileName=${sFileName}&sFileURL=&FileDescription=${FileDescription}&callback_func=${callback_func}";
				
				if(sUrl != "blank") 
				{
					var oParameter = {}; // query array
	
					sUrl.replace(/([^=]+)=([^&]*)(&|$)/g, function(){
						oParameter[arguments[1]] = arguments[2];
						return "";
					});
	
					if((oParameter.errstr || '').length) 
					{ 
						// on error
						(parent.jindo.FileUploader._oCallback[oParameter.callback_func+'_error'])(oParameter);
					} 
					else 
					{
						(parent.jindo.FileUploader._oCallback[oParameter.callback_func+'_success'])(oParameter);
				   	}
				}			
			} 
			catch(e) 
			{			
				var sUrl = "sFileName=${sFileName}&sFileURL=&FileDescription=${FileDescription}&callback_func=${callback_func}";
				
				if(sUrl != "blank") 
				{
					var oParameter = {}; // query array
	
					sUrl.replace(/([^=]+)=([^&]*)(&|$)/g, function(){
						oParameter[arguments[1]] = arguments[2];
						return "";
					});
					
					if((oParameter.errstr || '').length)
					{ // on error
						(parent.jindo.FileUploader._oCallback[oParameter.callback_func+'_error'])(oParameter);
					} 
					else 
					{
						(parent.jindo.FileUploader._oCallback[oParameter.callback_func+'_success'])(oParameter);
				   	}
				}
			}
	    </script>
	</body>
</html>