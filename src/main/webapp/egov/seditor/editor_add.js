/**
 *
 * @Description : editor 간소화 script
 * @Author : gggl.ko ,
 * @Create : 2009-07-21
 * @Update : 2009-11-04 , 간소화 , 에디터는 사이트내에서 단일한 종류로 사용한다고 가정
 * @Update : 2010-05-14 , 절대경로에 영향받지 않게 구성
 * @Update : 2010-08-21 , EDITORDIR 설정
 */

// #################################################################################################################

/**
 *
 * 네이버 스마트 에디터 설정
 */

	//기본값 지정
	var oEditors = [];
	
    document.write("<script type=\"text/javascript\" src=\"/egov/seditor/js/HuskyEZCreator.js\" charset=\"utf-8\"></script>");
    
    function editorAdd(textareaId)
    {
    	var sDefaultFont;
    	
    	sDefaultFont = '나눔고딕';
    	
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: textareaId,
			sSkinURI: "/egov/seditor/SmartEditor2Skin.do",	
			htParams : {
				bUseToolbar : true,
				fOnBeforeUnload : function(){
				}
			},
			fOnAppLoad : function(){
				//예제 코드							
		    	var nFontSize = 10;
		    	oEditors.getById[textareaId].setDefaultFont(sDefaultFont, nFontSize);
			},
			fCreator: "createSEditor2"
		});
    }
    
    function editorSync(textareaId) 
    {    
    	//에디터의 내용이 textarea에 적용됩니다.
    	oEditors.getById[textareaId].exec("UPDATE_CONTENTS_FIELD", []);
    	document.getElementById(textareaId).value = document.getElementById(textareaId).value.split("<").join("~!left!~");
    	document.getElementById(textareaId).value = document.getElementById(textareaId).value.split(">").join("~!right!~");	 
    	document.getElementById(textareaId).value = document.getElementById(textareaId).value.split("\"").join("~!doublecomma!~");
    	document.getElementById(textareaId).value = document.getElementById(textareaId).value.split("\'").join("~!singlecomma!~"); 
    }
