<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="content"/>

<tiles:insertAttribute name="footer"/>

<script type="text/javascript">
var IS_SESSION_CHECK_TIME  = 10;
var AUTO_LOGOUT_COUNT_TIME = 5;

//setInterval(isSessionCheck, (IS_SESSION_CHECK_TIME * 1000));


function isSessionCheck(){
	$.ajax({
		type     : 'POST',
		dataType : 'json',
		url      : '/mngwsercgateway/isSessionCheck.ajax',
    	data     : {},
    	success : function(data, status, xhr){
    		
    		if( data.RETURN_CODE != '000000000' ){
    			IS_SESSION_CHECK_TIME = 999999999;
    			
				setInterval(function(e){
								if(AUTO_LOGOUT_COUNT_TIME == 1){
									fnLogoutProcess(); 
								}else{
									AUTO_LOGOUT_COUNT_TIME--;
								}
								
								//if(AUTO_LOGOUT_COUNT_TIME > 0) $('#forbizMsgBox').text(AUTO_LOGOUT_COUNT_TIME);
								
							}, 1000);
				
				/* fnKendoMessage({message : "<div id=''>다른 PC에서 로그인한 사용자가 있어 자동로그아웃 처리됩니다.<br/><span id='forbizMsgBox'>5</span>초 후 로그인페이지로 이동합니다.</div>"  
				                    ,ok : function(e){
														fnLogoutProcess();
									}
								}); */		    			
				alert(data.msg);
				fnLogoutProcess();
    		}
    	},
    	error : function(xhr, status, strError){	//ajax Error	
    		
    	}
    });		
}


/**
 * 로그아웃
 * 참고 : 여러 페이지에서 사용함. 
 */
function fnLogoutProcess(){
	$.ajax({
		url     : "./setLogout.do",
		success : function( data ){
			location.href = '/mngwsercgateway/getLogin.do';
		}
	}); 
}
</script>