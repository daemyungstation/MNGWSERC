<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMETermsGroupList.jsp
	프로그램 명 : 	상품 약관그룹관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.17
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.17				김필기				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="./insert.do" enctype="multipart/form-data">
	<input type="hidden" name="PRDCT_CD" id="productCd" value="" />
	<input type="hidden" name="PRDCT_NM"  value="" />
	
	<!-- <div class="well well-small">
		상품검색 : <input type="text" name="PRDCT_NM" id="productNm" value="" class="inputType" />		
		<input type="submit" value="등록" class="btn btn-info" /> 
	</div>-->
</form>

<div class="well well-small">
	<input type="button" value="상품목록" class="btn" onclick="ProductList()" />
</div>

<form name="frm2" action ="${pageLink}" method="post">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div style="width:100%; overflow-x:auto">
		<table class="table table-bordered table-hover">
			<caption style="display: none;">상품약관 그룹관리</caption>
			<thead>
				<tr>
					<th width="6%">상품코드</th>
					<th width="14%">상품명</th>
					<th width="15%">적용일</th>
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.trsGb}" varStatus="status">
						<th width="<fmt:parseNumber value='${12 / fn:length(rtnMap.cdDtlList.trsGb)}' integerOnly='true' />%">${cdlist.cdNm}</th>
					</c:forEach>
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.contractGb}" varStatus="status">
						<th width="<fmt:parseNumber value='${45 / fn:length(rtnMap.cdDtlList.contractGb)}' integerOnly='true' />%">${cdlist.cdNm}</th>
					</c:forEach>			
					<th width="8%">기능</th>
				</tr>
			</thead>
			<tbody>
				<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
				<c:if test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="${fn:length(rtnMap.cdDtlList.trsGb) + fn:length(rtnMap.cdDtlList.contractGb) + 3}" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:if>
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
					<c:set var="yns" value="${fn:split(list.yns,',')}" />
					<tr>
						<td style="text-align:center">${list.prdctCd}</td>
						<td>${list.prdctNm}</td>
						<td style="text-align:right">
							<c:if test="${list.modDtm != ''}">${fn:substring(list.modDtm, 0, 10)}</c:if>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text"  class="moddate_${list.prdctCd} input-small" maxlength="10" placeholder="예)2016-01-01" />
						</td>
						<c:forEach var="yn" items="${yns}" varStatus="status">
							<td style="text-align:center">
								<input type="checkbox" class="terms_${list.prdctCd}" style="margin-top:0;" <c:if test="${yn == 'Y'}"> checked="checked" </c:if> />
							</td>
						</c:forEach>
						<td colspan="2" style="text-align:center">
							<input type="button" value="적용" class="btn btn-small btn-success apply" data-code="${list.prdctCd}" />
							<input type="button" value="삭제" class="btn btn-small btn-danger del" data-code="${list.prdctCd}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>

<div style="float:right;">
	<a href="./excel.do" class="btn btn-info">엑셀 다운로드</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<form name="terms" method="post" action="./update.do">
	<input type="hidden" id="prdctCd" name="prdctCd" value="" />
	<input type="hidden" id="moddate" name="modDtm" value="" />	
	<c:forEach var="cdlist" items="${rtnMap.cdDtlList.trsGb}" varStatus="status">
		<input type="hidden" id="${cdlist.cd}" class="termsYn" name="${cdlist.cd}" value="" />
	</c:forEach>
	<c:forEach var="cdlist" items="${rtnMap.cdDtlList.contractGb}" varStatus="status">
		<input type="hidden" id="${cdlist.cd}" class="termsYn" name="${cdlist.cd}" value="" />
	</c:forEach>
</form>

<form name="delfrm" method="post" action="./delete.do">
	<input type="hidden" id="delprdctCd" name="prdctCd" value="" />
</form>

<script type="text/javascript">
	var code;	
	$('.apply').click(function(){
		termsViewYnList = "";
		code = $(this).data('code');
		
		$('#prdctCd').val(code);		
		$('#moddate').val($('.moddate_'+ code).val());
		
		$('.terms_'+ code).each(function(index, obj){
			if($(this).is(':checked')){
				$('.termsYn').eq(index).val('Y');
			}else{
				$('.termsYn').eq(index).val('N');				
			}
		});
		
		if(confirm("적용하시겠습니까?")){
			document.terms.submit();
		}
	});
		
	$('.del').click(function(){
		code = $(this).data('code');
		$('#delprdctCd').val(code);
		
		if(confirm("삭제하시겠습니까?")){
			document.delfrm.submit();
		}
	});
	
	function ProductList(){
		window.open('./productList.do','상품목록', 'width=600, height=750');
	}
	
	//페이지번호 클릭시
	function getPageList()
	{	
		var f = document.frm2;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}
		f.submit();
	}
	
	/*
    $( "#productNm" ).autocomplete({
        source: function( request, response ) {
            $.ajax({
				type: 'POST',
                url: './productList.ajax',
                dataType: "json",
				data : {
					product_name : request.term
				},
                success: function( data ) {
					if (data != null)
					{
						response(
							$.map(data, function(item){
								console.log(item);								
								return [{
									value : item.attr.productName,
									label : item.attr.productName,
									code : item.attr.productCode
								}]
							})
						);
					}
                }
            });
        },
        minLength: 3,
		select: function (event, ui)
		{
			$('#productCd').val(ui.item.code);
		}
    });*/
</script>
