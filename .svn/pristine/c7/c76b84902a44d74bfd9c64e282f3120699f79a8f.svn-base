<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COECdLinkWrite.jsp
	프로그램 명 : 	링크코드 등록한다.
	설명		: 	링크코드 등록하는 페이지
	작성자		: 	허진영
	작성일		:	2016.03.28
	수정일자			수정자					수정내용
	=====================================================================
	2016.03.28			허진영					최초작성
	######################################################################
-->

<form name="frm" method="post" action="">
	<input type="hidden" name="highrCd" value="" />
	<input type="hidden" name="highrDtlCd" value="" />
	<input type="hidden" name="lowrCd" value="" />

	<h5>● 상위코드</h5>
	
	<table cellpadding="5" cellspacing="5" border="0" class="" style="width:100%;">
		<tr>
			<td style="width:50%">
				<div id="scrollbox1" style="overflow-x:hidden; overflow-y:scroll; width:100%; height:440px; padding-left:1px; border:1px solid #ccc;">
					<table class="table" >
						<thead>
							<tr bgcolor="#5b5b5b">
								<th width="10%">번호</th>
								<th width="60%">분류명</th>
								<th width="30%">분류코드</th>
							</tr>
						</thead>
						<tbody id="codeOneContainer1">
						
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
						<tbody id="codeChildContainer1">
						
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>

	<h5>● 하위코드</h5>
	
	<table cellpadding="5" cellspacing="5" border="0" class="" style="width:100%;">
		<tr>
			<td  style="width:50%">
				<div id="scrollbox1" style="overflow-x:hidden; overflow-y:scroll; width:100%; height:440px; padding-left:1px; border:1px solid #ccc;">
					<table class="table" >
						<thead>
							<tr bgcolor="#5b5b5b">
								<th width="10%">번호</th>
								<th width="60%">분류명</th>
								<th width="30%">분류코드</th>
							</tr>
						</thead>
						<tbody id="codeOneContainer2">
						
						</tbody>
					</table>
				</div>
			</td>
			<td>
				<div id="scrollbox2" style="overflow-x:hidden; overflow-y:scroll; width:100%; height:440px; padding-left:1px; border:1px solid gray;">
					<table class="table">
						<thead>
							<tr bgcolor="#5b5b5b">
								<th width="10%"><input type="checkbox" name="selectAllCode" /></th>
								<th width="45%">분류명</th>
							    <th width="25%">분류코드</th>
								<th width="10%">사용</th>
								<th width="10%">정렬</th>					
							</tr>
						</thead>
						<tbody id="codeChildContainer2">
						
						</tbody>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<!--// 버튼 부분 -->
				<table cellpadding="0" cellspacing="0" width="100%" style="margin-top:5px;" id="btSub">
					<tr>
						<td align="left">
						
						</td>
						<td align="right">
							<a href="javascript:insertCdLink()" class="btn btn-success">저장</a>
							<a href="./list.do" class="btn btn-default">목록</a>
						</td>
					</tr>
				</table>
				<!-- 버튼 부분 // -->
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	jQuery(document).ready(function(){
		selectCdMstList();
		
		jQuery("input:checkbox[name='selectAllCode']").click(function(){
			if(jQuery(this).is(":checked"))
			{
				jQuery("input:checkbox[name='selectCode']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='selectCode']").prop("checked", false);
			}	
		});
	});
	
	function selectCdMstList()
	{
		jQuery.post("/mngwserc/coe/code/list.ajax",
			{
			
			},
			function(text)
			{
				jQuery("tbody[id^='codeOneContainer']").html("");
				jQuery("tbody[id^='codeOneContainer']").html(text);
			},
			"text"
		).fail(function(){
			alert("잠시후 다시 시도 바랍니다.");
		});
	}
	
	function getCdDtlList(obj, idx, cdId)
	{
		var value = jQuery(obj).closest("tbody").attr("id").replace("codeOneContainer", "");
		
		jQuery("#codeOneContainer" + value).find(".cdTrOne").css("background-color", "#fff");
		jQuery(obj).css("background-color", "#999");
		
		if(value == 1)
		{
			jQuery("input[name='highrCd']").val(cdId);
			jQuery("input[name='highrDtlCd']").val("");
		}
		else if(value == 2)
		{
			jQuery("input[name='lowrCd']").val(cdId);
			jQuery("input[name='lowrDtlCd']").val("");
		}

		selectCdDtlList(cdId, value);
	};	
	
	function selectCdDtlList(cdId, value)
	{
		jQuery.post("/mngwserc/coe/code/selectCdIdDtl.ajax",
			{
				"cdId" : cdId,
				"gubun" : value == "2" ? "last" : "",
				"highrCd" : jQuery("input[name='highrCd']").val(),
				"highrDtlCd" : jQuery("input[name='highrDtlCd']").val(),
				"lowrCd": jQuery("input[name='lowrCd']").val()
		    },
			function(text)
			{		
				jQuery("#codeChildContainer" + value).html("");
				jQuery("#codeChildContainer" + value).html(text);
			},
			"text"
		).fail(function(){
			alert("잠시후 다시 시도 바랍니다.");
		});
	}
	
	function getCdDtl(obj, idx)
	{
		var value = jQuery(obj).closest("tbody").attr("id").replace("codeChildContainer", "");
		
		if(value == 1)
		{
			jQuery("#codeChildContainer" + value).find(".codeTrChild").css("background-color", "#fff");
			jQuery(obj).css("background-color", "#999");
			
			jQuery("input[name='highrDtlCd']").val(jQuery(obj).find("#cd"+idx).text());
		}
		else if(value == 2)
		{
			//jQuery(obj).find("input[name='selectCode']").prop("checked", !jQuery(obj).find("input[name='selectCode']").is(":checked"));
		}
	}
	
	//링크코드 등록하기
	function insertCdLink()
	{
		if(!jQuery("input[name='highrCd']").val())
		{
			alert("상위코드를 선택해주세요.");
			return;
		}
		
		if(!jQuery("input[name='highrDtlCd']").val())
		{
			alert("상위코드상세를 선택해주세요");
			return;
		}
		
		if(!jQuery("input[name='lowrCd']").val())
		{
			alert("하위코드를 선택해주세요");
			return;
		}
		
		if(jQuery("input:checkbox[name='selectCode']:checked").length < 1)
		{
			alert("하위코드상세를 선택해주세요");
			return;
		}
		
		var lowrDtlCds = "";
		
		jQuery("input:checkbox[name='selectCode']:checked").each(function(){
			lowrDtlCds += jQuery(this).val() + ",";
		});

		if(confirm("링크코드를 등록하시겠습니까?"))
		{				
			jQuery.post("./insertCdLink.ajax",
				{
					"highrCd" : jQuery("input[name='highrCd']").val(),
					"highrDtlCd" : jQuery("input[name='highrDtlCd']").val(),
					"lowrCd": jQuery("input[name='lowrCd']").val(),
					"lowrDtlCds" : lowrDtlCds
				},
				function(r)
				{
					if(r.status == "OK")
					{
						alert("등록되었습니다.");
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});		
		}
	}
</script>	 