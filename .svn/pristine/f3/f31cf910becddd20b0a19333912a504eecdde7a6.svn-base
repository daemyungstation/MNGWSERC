	// 프로토 타입임, url, data, dataType 과 성공시 펑션이름을 던져준다.
	function commonAjax(url, data, dataType, successFnc){
		$.ajax({
			type : "GET" //"POST", "GET"
			, url : url
			, data : data
			, dataType : dataType //전송받을 데이터의 타입
			, contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			, error : function(request, status, error) {
				alert("code : " + request.status + "\r\nmessage : " + request.reponseText +" \r\n status : " + status);
			}
			, success : function(data) {
				if(successFnc != null){
					eval(sucessFnc+"("+data+")");
				}else if(successFnc == ""){
					return data;
				}
			}
		});		
	}
	
	// JSON 형식임
	function commonJsonAjax(urls, datas, successFnc){

		$.ajax({
			type : "GET" , //"POST", "GET"
			 url : urls ,
			 data : datas ,
			 dataType : "json" , //전송받을 데이터의 타입
			 contentType: "application/x-www-form-urlencoded; charset=UTF-8" ,
			 error : function(request, status, error) {
				alert("code : " + request.status + "\r\nmessage : " + request.reponseText +" \r\n status : " + status);
			}
			, success : function(data) {
				if(successFnc != ""){
					eval(successFnc+"('"+data+"')");
				}else if(successFnc == ""){
					return data;
				}
			}
		});
	}
	
	
	
	
	// 작성 페이지 이동
	function goWrite(){
		location.href="/mngwserc/contentsid/${vo.TREEID}/write.do";
	}	
	
	// 삭제 이벤트
	function goDelete(){
		if($("input[id^='chk']").is(":checked")){
			if(confirm("삭제하시겠습니까?")){
				var chkArray = new Array();
				
				$("input[id^='chk']:checked").each(function(){
					chkArray.push($(this).val());
				});
				
				$("input[name='chk']").val(chkArray.join(","));

				var f = document.contentsList;
				f.action="/mngwserc/contentsid/${vo.TREEID}/delete.do";
				f.submit();					
			}
		}else{
			alert("삭제할 대상을 선택하세요.");
			return ;
		}
	}
	
	// 상세 보기
	function goView(idx){
		/**/
		var f = document.contentsList;
		f.action = "/mngwserc/contentsid/${vo.TREEID}/view.do";
		$("input[name='IDX']").val(idx);
		f.submit();
		/**/
	}
	
	// 토글 체크 이벤트 부분
	var flag = false;
	function allCheck(){
		
		if(flag==false){
			$("input[id^='chk']").each(function(){
				var id = $(this).attr("id");
				document.getElementById(id).checked=true;
			});
			
			flag=true;
		}else{
			$("input[id^='chk']").each(function(){
				var id = $(this).attr("id");
				document.getElementById(id).checked=false;					
			});
			flag=false;
		}
	}
	
	
	// 전체 체크시 상단 토글 체크박스도 체크
	function allChkFalse(){
		var temp = $("input[id^='chk']:checked");
		var chkCnt = $("input[id^='chk']").length;
		if(temp.length == 0){
			document.getElementById("allChk").checked = false;
		}
		
		if(temp.length == chkCnt){
			document.getElementById("allChk").checked = true;
			flag=true;
		}else{
			document.getElementById("allChk").checked = false;
			flag=false;
		}
	}
	
	// 컨텐츠 선택 여부 확인
	function chkContents(){
		var chkObj = $("input[id^=chk]:checked");
		
		if(chkObj.length==0){
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		
		if($(chkObj).length > 1){
			alert("1 개 이상 선택할 수 없습니다.");
			return ;
		}
			jQuery('#myModal').modal('show');
		
	}
	
	// 승인
	function goApproval(){
		
		var chkObj = $("input[id^=chk]:checked");
		
		if(chkObj.length==0){
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		
		if($(chkObj).length > 1){
			alert("1 개 이상 선택할 수 없습니다.");
			return ;
		}
		
		if(confirm("해당 컨텐츠를 승인하시겠습니까?")){
			var urls ="/mngwserc/contentsid/${vo.TREEID}/checkStatus.ajax";
			var datas ="IDX="+$("input[id^='chk']:checked").val();

			$.ajax({
				type : "GET" , //"POST", "GET"
				 url : urls ,
				 data : datas ,
				 dataType : "json" , //전송받을 데이터의 타입
				 contentType: "application/x-www-form-urlencoded; charset=UTF-8" ,
				 error : function(request, status, error) {
					alert("code : " + request.status + "\r\nmessage : " + request.reponseText +" \r\n status : " + status);
				}
				, success : function(data) {
					if(data.status != '1'){
						alert("승인요청 콘텐츠가 아닙니다.");
						return;
					}else{
						confirmApproval();
					}
				}
			});
		}
	}
	// 확인 후 승인
	function confirmApproval(){
		$("input[name='IDX']").val($("input[id^='chk']:checked").val());	// idx 셋팅
		
		var frm = document.contentsList;
		frm.action="/mngwserc/contentsid/${vo.TREEID}/updateApproval.do";
		frm.submit();
	}
	
	// 되돌리기
	function goBackContents(){
		var chkObj = $("input[id^=chk]:checked");
		
		if(chkObj.length==0){
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		
		if($(chkObj).length > 1){
			alert("1 개 이상 선택할 수 없습니다.");
			return ;
		}
		
		if(confirm("해당 컨텐츠로 되돌리시겠습니까?")){
			var urls ="/mngwserc/contentsid/${vo.TREEID}/checkStatus.ajax";
			var datas ="IDX="+$("input[id^='chk']:checked").val();

			$.ajax({
				type : "GET" , //"POST", "GET"
				 url : urls ,
				 data : datas ,
				 dataType : "json" , //전송받을 데이터의 타입
				 contentType: "application/x-www-form-urlencoded; charset=UTF-8" ,
				 error : function(request, status, error) {
					alert("code : " + request.status + "\r\nmessage : " + request.reponseText +" \r\n status : " + status);
				}
				, success : function(data) {
					if(data.status != '3'){
						alert("배포(만기) 콘텐츠가 아닙니다.");
						return;
					}else{
						confirmApproval();
					}
				}
			});		
		}
	}
	
	//즉시 배포
	function immediatelyApproval(){
		var chkObj = $("input[id^=chk]:checked");
		
		if(chkObj.length==0){
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		
		if($(chkObj).length > 1){
			alert("1 개 이상 선택할 수 없습니다.");
			return ;
		}
		
		if(confirm("해당 컨텐츠로 즉시배포 하시겠습니까?")){
			var urls ="/mngwserc/contentsid/${vo.TREEID}/checkStatus.ajax";
			var datas ="IDX="+$("input[id^='chk']:checked").val();

			$.ajax({
				type : "GET" , //"POST", "GET"
				 url : urls ,
				 data : datas ,
				 dataType : "json" , //전송받을 데이터의 타입
				 contentType: "application/x-www-form-urlencoded; charset=UTF-8" ,
				 error : function(request, status, error) {
					alert("code : " + request.status + "\r\nmessage : " + request.reponseText +" \r\n status : " + status);
				}
				, success : function(data) {
					if(data.status != '0'){
						alert("작성중인 콘텐츠가 아닙니다.");
						return;
					}else{
						confirmApproval();
					}
				}
			});		
		}
	}
	
	// 컨텐츠 복사 선택
	function goCopyContents(){
		if(!confirm("복사하시겠습니까?")){
			return ;
		}
		
		var val = $("input[name='copyType']:checked").val();
		if(val=='nomal'){
			jQuery('#myModal').modal('hide');
			
			nomalCopyContents();
		}else if(val=='multi'){
			
			jQuery('#myModal').modal('hide');

			$.ajax({
				type : "GET" , //"POST", "GET"
				 url : "/mngwserc/trees/contents/list.ajax?TREEID=14&TTYPE=cms" ,
				 dataType : "json" , //전송받을 데이터의 타입
				 contentType: "application/x-www-form-urlencoded; charset=UTF-8" ,
				 error : function(request, status, error) {
					alert("code : " + request.status + "\r\nmessage : " + request.reponseText +" \r\n status : " + status);
				}
				, success : function(data) {
					var list    = data.cmsList;
					var htmlSrc = new Array();
					
					for(var i=0; i<list.length; i++){
						htmlSrc.push("<tr>");
						htmlSrc.push("<td> "+list[i].title.replace(/ /gi,"&nbsp;")+" </td>");
						htmlSrc.push("<td><input type='checkbox' name='cmsChk"+i+"' value='"+list[i].treeid+"' /></td>");
						htmlSrc.push("</tr>");
					}
					$("#cmsList table tbody").html(htmlSrc.join(""));
				}
			});	
			jQuery("#myModal2").modal("show");

		}
	}
	
	// 일반 복사
	function nomalCopyContents(){
		$("input[name='IDX']").val($("input[id^='chk']:checked").val());	// idx 셋팅
		
		var f 	 =  document.contentsList;
		f.action =  "/mngwserc/contentsid/${vo.TREEID}/copyContents.do";
		f.submit();
	}
	
	// 복사 컨텐츠 선택 후 확인
	function goMultiCopy(){
		var chkArray = new Array();
		var chkObj 	 = $("input[name^=cmsChk]:checked");
		
		
		$(chkObj).each(function(){
			chkArray.push($(this).val());
		});
		
		$("input[name='IDX']").val($("input[id^='chk']:checked").val());	// idx 셋팅
		$("input[name='chk']").val(chkArray.join(","));						// treeid 값 셋팅
		
		var f 	 = document.contentsList;
		f.action = "/mngwserc/contentsid/${vo.TREEID}/multiCopy.do";
		f.submit();
	}
				