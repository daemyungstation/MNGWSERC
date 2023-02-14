<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	productListPop.jsp
	프로그램 명 : 	상품목록 조회
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.19
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.19				김필기				최초작성
	######################################################################
-->
<form name="frm" action ="./productList.do" method="post">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
		
	<div class="well well-small">
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>코드</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>제품명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="./productList.do" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>		
		
	<table class="table table-bordered" style="width:100%">
		<colgroup>
			<col width="10%"/>
			<col width="10%"/>
			<col width="*"/>
			<col width="10%"/>
		</colgroup>
		<tr>
			<th>번호</th>
			<th>코드</th>
			<th>상품명</th>
			<th>기능</th>
		</tr>

		<c:if test="${fn:length(rtnMap.list) == 0}">
		<tr>
			<td class="lt_text3" colspan="3" style="text-align:center;">
				<fmt:message key="common.nodata.msg" />
			</td>
		</tr>
		</c:if>


		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
  		<tr>		  			
   			<td style="text-align:center;">
   				${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
   			</td>
   			<td style="text-align:center;">
   				${list.prodCd}
   			</td>
   			<td>${list.prodNm}</td>
   			<td style="text-align:center">
   				<input type="button" value="등록" class="btn btn-success btn-small regbtn" data-code="${list.prodCd}" data-prodNm='${list.prodNm}' onclick="reg(this, '${list.prodCd}')" >   				
   			</td>
   		</tr>
   		</c:forEach>
	</table>
		
	<div class="paging_all c_box">
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
			</ul>
		</div>
	</div>
</form>	


<script type="text/javascript">
	$('.regbtn').each(function(){
		changeBtn($(this), $(this).data('code'));
	});
	
	function changeBtn($this, code){
		var codeList = '${rtnMap.allList}';
		if(codeList.indexOf(code) > -1){
			$this.attr('disabled', true)
				.removeClass('btn-success')
				.addClass('btn-danger')
				.val('불가');	
		}	
	}
	
	function reg(obj, code){
		
		if(confirm("등록하시겠습니까?")){
			var pf = opener.document.frm;
			//var pf = parent.document.frm;

			pf.PRDCT_CD.value = code;
			pf.PRDCT_NM.value = $(obj).attr('data-prodNm');	
			pf.submit();
			
			$(obj).attr('disabled', true)
				.removeClass('btn-success')
				.addClass('btn-danger')
				.val('불가');		
		}	
	}
	
	//페이지번호 클릭시
	function getPageList()
	{	
		var f = document.frm;
		
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

	resize = function(){
		window.resizeTo(600, $('table').height()+300);	
	}();
	</script>
	