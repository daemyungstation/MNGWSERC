	/* 2013.12.31 파일 삭제 */
	function deleteFile(atch_file_id, file_sn){
		if(confirm("삭제하시겠습니까?")){
			
		$.ajax({
				type : "GET" //"POST", "GET"
				, url : "/cmm/fms/deleteFile.ajax"
				, data : "ATCH_FILE_ID="+atch_file_id+"&FILE_SN="+file_sn
				, dataType : "json" //전송받을 데이터의 타입
				, contentType: "application/x-www-form-urlencoded; charset=UTF-8"
				, success : function(data) {
					var msg = data.msg;
					if(msg == 'Y'){
									
						alert("삭제되었습니다.");
						$("#atchFileDiv").remove();
						$("input[name='ATCH_FILE_ID']").val("");
					}
				}
			});			
		}
	}