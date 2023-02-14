<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COEIndex.jsp
	프로그램 명 : 	코드관리
	설명		: 	Index
	작성자		: 	김대환
	작성일		:	2015.11.18
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.18				김대환				최초작성
	######################################################################
-->
<script type="text/javascript" src="/common/js/frm.js"></script>

<form method="post" name="list">
	<table cellpadding="5" cellspacing="5" border="0" style="width:100%">
		<tr>
			<td>
				<div id="scrollbox1" style="overflow-x:hidden; overflow-y:scroll; width:100%; height:440px; padding-left:1px; border:1px solid #ccc;">
					<table class="table">
						<thead>
							<tr bgcolor="#5b5b5b">
								<th width="10%">번호</th>
								<th width="60%">분류명</th>
								<th width="30%">분류코드</th>
							</tr>
						</thead>
						<tbody id="codeOneContainer">
						
						</tbody>
					</table>
				</div>
			</td>
			<td>
				<div id="scrollbox2" style="overflow-x:hidden; overflow-y:scroll; width:100%; height:440px; padding-left:1px; border:1px solid gray;">
					<table class="table">
						<thead>
							<tr bgcolor="#5b5b5b">
								<th width="50%">분류명</th>
							    <th width="30%">분류코드</th>
								<th width="10%">사용</th>
								<th width="10%">정렬</th>
							</tr>
						</thead>
						<tbody id="codeChildContainer">
						
						</tbody>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div id="setting1">
	                <table class="table table-bordered">
	                    <thead>
	                        <tr bgcolor="#5b5b5b">
	                            <th width="50%">분류명</th>
	                            <th width="50%">분류코드</th>
	                        </tr>
	                    </thead>
	                    <tr>
	                       <td width="170">
	                           <input type="text" id="cdIdNm" name="cdIdNm" class="input1" maxlength="50" />
	                       </td>
	                       <td width="100">
	                       		<input type="text" id="cdId" name="cdId" class="input1" maxlength="20" />
	                       </td>
	                    </tr>
	                </table>
				</div>
			</td>
			<td>
				<div id="setting2">
	                <table class="table table-bordered">
	                    <thead>
	                        <tr bgcolor="#5b5b5b">
	                            <th width="50%">분류명</th>
							    <th width="30%">분류코드</th>
								<th width="10%">사용</th>
								<th width="10%">정렬</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    <tr>
	                        <td width="165"><input type="text" id="cdNm" name="cdNm" class="input1" maxlength="50" /></td>
	                        <td width="100"><input type="text" id="cd" name="cd" class="input1" style="width:80px;" maxlength="20" /></td>
	                        <td width="30">
		                        <select id="useYn" name="useYn">
									<option value="Y">Y</option>
									<option value="N">N</option>
								</select>
	                        </td>
	                        <td width="30"><input type="text" id="cdOrd" name="cdOrd" class="input1" style="width:25px;" maxlength="3" /></td>
	                    </tr>
	                </table>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<table cellpadding="0" cellspacing="0" style="width:100%;">
					<tr>
						<td align="right">
	                        <span id="modDiv" style="display:none;">
	                        	<a href="javascript:updateCdMst()" id="save" class="btn btn-primary">수정</a>
	                        	<a href="javascript:deleteCdMst();" id="del" class="btn btn-danger">삭제</a>
	                        </span>
	                        <span id="regDiv">    
	                       		<a href="javascript:insertCdMst();" id="add" class="btn btn-success">등록</a>
	                        </span>
						</td>
					</tr>
				</table>
			</td>
			<td>
				<table cellpadding="0" cellspacing="0" width="100%" style="margin-top:5px;" id="btSub">
					<tr>
						<td align="right">
							<a href="javascript:updateCdDtl()" id="save_sub" class="btn btn-primary">수정</a>
							<a href="javascript:deleteCdDtl();" id="del_sub" class="btn btn-danger">삭제</a>
							<a href="javascript:insertCdDtl();" id="add_sub" class="btn btn-success">등록</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	jQuery(document).ready(function(){
		selectCdMstList();
	});
	
	function selectCdMstList()
	{
		jQuery.post("./list.ajax",			
			function(text)
			{		
				jQuery("#codeOneContainer").html("");
				jQuery("#codeOneContainer").html(text);
				toggleOneData(false);
			}
		).fail(function(){
			alert("잠시후 다시 시도 바랍니다.");
		});
	}
	
	function getCdDtlList(obj, idx, cdId)
	{
		jQuery(".cdTrOne").css("background-color", "#fff");
		jQuery(obj).css("background-color", "#999");
		jQuery("#add").text("추가");
		jQuery("#modDiv").show();
		toggleOneData(true, idx, cdId);
		selectCdDtlList(cdId);
	};	
	
	function selectCdDtlList(cdId)
	{
		jQuery.post("./selectCdIdDtl.ajax",
			{
				"cdId" : cdId
			},
			function(text)
			{		
				jQuery("#codeChildContainer").html("");
				jQuery("#codeChildContainer").html(text);
				
				jQuery("#cdNm").val("");
				jQuery("#cd").val("");
				jQuery("#cd").prop("disabled", false);
				jQuery("#cdOrd").val("");
				jQuery("#useYn").val("Y");
			}
		).fail(function(){
			alert("잠시후 다시 시도 바랍니다.");
		});
	}
	
	function getCdDtl(obj, idx)
	{
		jQuery(".codeTrChild").css("background-color", "#fff");
		jQuery(obj).css("background-color", "#999");
		jQuery("#cdNm").val(jQuery("#cdNm"+idx).text());
		jQuery("#cd").val(jQuery("#cd"+idx).text());
		jQuery("#cd").prop("disabled", true);
		jQuery("input[name='cdOrd']").val(jQuery("#cdOrd"+idx).text());
		jQuery("#useYn").val(jQuery("#useYn"+idx).text());
		jQuery("#save_sub").text("수정");
		jQuery("#add_sub").text("추가");
		jQuery("#setting2").show();
	}
	
	function toggleOneData(boo, idx, cdId)
	{
		if(boo)
		{
			jQuery("#cdIdNm").val(jQuery("#cdIdNm"+idx).text());
			jQuery("#cdId").val(cdId);
			jQuery("#cdId").prop("disabled", true);
		}
		else
		{
			jQuery("#cdIdNm").val("");
			jQuery("#cdId").val("");
			jQuery("#cdId").prop("disabled", false);
		}		
	}
	
	//상위코드를 등록한다.
	function insertCdMst()
	{
		if(jQuery("#add").text() == "추가")
		{
			jQuery("#modDiv").hide();
			jQuery("#add").text("등록");
			jQuery("#cdIdNm").val("");
			jQuery("#cdId").val("");
			jQuery("#cdId").prop("disabled", false);
		}
		else
		{
			if(confirm("등록하시겠습니까?"))
			{
				jQuery.post("./insertCode.ajax",
					{
						"cdIdNm" : jQuery("#cdIdNm").val(),
					    "cdId" : jQuery("#cdId").val()
					},
					function(r)
					{
						if(r.status == "OK")
						{
							selectCdMstList();
						}
					}
				).fail(function(){
					alert("동일한 코드가 존재합니다.");
				});
			}
		}
	}
	
	//하위코드를 등록한다.
	function insertCdDtl()
	{
		if(jQuery("#add_sub").text() == "추가")
		{
			jQuery("#add_sub").text("등록");
			jQuery("#cdNm").val("");
			jQuery("#cd").val("");
			jQuery("#cd").prop("disabled", false);
			jQuery("#cdOrd").val("");
			jQuery("#useYn").val("Y");
			jQuery("#setting2").show();
		}
		else
		{
			if(jQuery("#cdId").val() == "")
			{
				alert("코드값이 없습니다.");
				return;
			}
			
			if(jQuery("#cd").val() == "")
			{
				alert("코드값이 없습니다.");
				return;
			}
			
			if(confirm("상세코드를 등록하시겠습니까?"))
			{				
				jQuery.post("./insertCodeDetail.ajax",
					{
						"cdId" : jQuery("#cdId").val(),
						"cdNm" : jQuery("#cdNm").val(),
						"cd" : jQuery("#cd").val(),
						"useYn" : jQuery("#useYn").val(),
						"cdOrd" : jQuery("#cdOrd").val()
					},
					function(r)
					{
						if(r.status == "OK")
						{
							selectCdDtlList(jQuery("#cdId").val());
						}
					}
				).fail(function(){
					alert("동일한 코드값이 존재합니다.");
				});		
			}
		}	
	}
	
	//상위코드를 수정한다.
	function updateCdMst()
	{	
		if(confirm("수정하시겠습니까?"))
		{
			jQuery.post("./updateCode.ajax",
				{
				    "cdId" : jQuery("#cdId").val(),
				    "cdIdNm" : jQuery("#cdIdNm").val()
				},
				function(r)
				{				
					if(r.status == "OK")
					{
						selectCdMstList();
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	//하위코드를 수정한다.
	function updateCdDtl()
	{		
		if(jQuery("#cdId").val() == "")
		{
			alert("코드값이 없습니다.");
			return;
		}
		
		if(jQuery("#cd").val() == "")
		{
			alert("코드값이 없습니다.");
			return;
		}
		
		if(confirm("수정하시겠습니까?"))
		{
			jQuery.post("./updateCodeDetail.ajax",
				{
					"cdId" : jQuery("#cdId").val(),
					"cdNm" : jQuery("#cdNm").val(),
					"cd" : jQuery("#cd").val(),
					"useYn" : jQuery("#useYn").val(),
					"cdOrd" : jQuery("#cdOrd").val()
				},
				function(r)
				{				
					if(r.status == "OK")
					{
						selectCdDtlList(jQuery("#cdId").val());
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	//상위코드를 삭제한다.
	function deleteCdMst()
	{
		if(confirm("한번 삭제하면 복구가 불가능합니다. 삭제하시겠습니까?"))
		{
			jQuery.post("./deleteCode.ajax",
				{					
					"cdId" : jQuery("#cdId").val()
				},
				function(r) 
				{				
					if(r.status == "OK")
					{
						selectCdMstList();
						
						jQuery("#modDiv").hide();
						jQuery("#add").text("등록");
						jQuery("#cdIdNm").val("");
						jQuery("#cdId").val("");
						jQuery("#cdId").prop("disabled", false);
						jQuery("#codeChildContainer").html("");
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	function deleteCdDtl()
	{
		if(jQuery("#cd").val() && confirm("한번 삭제하면 복구가 불가능합니다. 삭제하시겠습니까?"))
		{
			jQuery.post("./deleteCodeDetail.ajax",
				{
					"cdId" : jQuery("#cdId").val(),
					"cd" : jQuery("#cd").val()
				},
				function(r)
				{				
					if(r.status == "OK")
					{
						selectCdDtlList(jQuery("#cdId").val());
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
</script>	 