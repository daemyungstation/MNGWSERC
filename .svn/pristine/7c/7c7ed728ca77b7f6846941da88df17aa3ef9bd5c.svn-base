
/**
	공통 ajax 모듈 
*/
function commonAjax(	  sendUrl 				/* 요청 url */
						, paramData  			/* 요청 data */
						, dataType 				/* dataType 설정 */
						, successFunc 			/* 성공 후 function 객체 */
						, failFunc 				/* 실패 후 function 객체 */
					){

		if(dataType==undefined || dataType =='') dataType='html';
					
		$.ajax({
			type: 	"post",
			url: 	sendUrl,
			data: 	paramData,
			dataType: dataType,
			error: function(a, b, c){		
				failFunc.apply();
			},
			success: function (data) {
				try{
					successFunc.call(data);
				}catch(e){	    		
					alert('server Error!!');
				}
			}
		});

}
	
