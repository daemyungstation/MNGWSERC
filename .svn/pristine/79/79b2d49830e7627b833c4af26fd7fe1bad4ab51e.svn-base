<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMACounselList.jsp
	프로그램 명 : 	외주업체 상담관리 목록
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.02.26
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.26				김필기				최초작성
	2016.05.20				김필기				최초작성
	######################################################################
-->
<form name="searchFrm" method="post">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		조건 검색 : 
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>전체</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>제목</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>작성자</option>
		</select>

		<input type="text" name="q" value="${rtnMap.q}" class="inputType w146" maxlength="50" />
		
		&nbsp;
		노출 여부 :
		<select name="useYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.useYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.useYn eq 'N'}">selected</c:if>>N</option>
		</select>
		
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>	
	
	<p>전체 게시물 수 : ${rtnMap.list[0].totCnt}</p>
	<table class="table table-bordered table-hover" style="font-size:12px;">
		<caption style="display: none;">배너 관리</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th style="width:60px; vertical-align:middle;">
					번호
				</th>
				<th style="width:120px; vertical-align:middle;">
					이동경로
				</th>
				<th style="width:240px; vertical-align:middle;">
					제목
				</th>
				<th style="width:120px; vertical-align:middle;">
					작성자
				</th>
				<th style="width:120px; vertical-align:middle;">
					작성일
				</th>
				<th style="width:120px; vertical-align:middle;">
					노출여부
				</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="30" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
						<td style="text-align:center;"><input type="checkbox" name="delSeq" value="${list.bannerSeq}" /></td>
						<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
						<td onclick="view('${list.bannerSeq}')" style="text-align:center;"> ${ list.linkGubun } </td>
						<td onclick="view('${list.bannerSeq}')" style="text-align:center;"> ${ list.bannerTitle } </td>
						<td onclick="view('${list.bannerSeq}')" style="text-align:center;"> ${ list.regId } </td>
						<td style="text-align:center;"> ${ list.regDtm } </td>
						<td style="text-align:center;"> ${ list.useYn } </td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>

	<!-- 상품관리 등록 Modal -->
	<div class="modal fade" id="mainModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1500px; margin-left: -750px;">
	  	<div class="modal-dialog">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        		<h4 class="modal-title" id="myModalLabel">Top 배너 등록</h4>
	      		</div>
	      		<div class="modal-body" style="text-align:center;">
	      			<%@ include file="./CNATopBannerPop.jsp" %>	      		
	      		</div>
	    	</div>
	  	</div>
	</div>

<div style="float:left;">
	<a href="javascript:deleteBanner();" class="btn btn-danger">삭제</a>
</div>
<div style="float:right;">
	<a href="javascript:write();" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>

<script type="text/javascript">
	//체크박스 jQeury
	jQuery(document).ready(function(){
		//삭제 체크박스 전체 선택 & 해제
		jQuery("input:checkbox[name='all_check']").click(function(){
			if(jQuery(this).is(":checked"))
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", false);
			}	
		});
	
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='delSeq']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='delSeq']").length;
			var selChkCnt = jQuery("input:checkbox[name='delSeq']:checked").length;
			
			if(allChkCnt==selChkCnt)
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", false);
			}
		});
	});

	//리스트 가져오기
	function getPageList()
	{	
		var f = document.searchFrm;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}

		f.action = "./list.do";
		f.submit();
	}
	
	//상세 가져오기
	function view(seq)
	{
		$.ajax({
			url: "./bannerView.ajax",
			type: "post",
			dataType: "json",
			data: {"bannerSeq" : seq},
			success: function(res) {
				var mgrInfo = res.data.mstMap;
				$("input[name='bannerTitle']").val(mgrInfo.bannerTitle);
				$("input:radio[name='linkGubun'][value='"+ mgrInfo.linkGubun +"']").prop("checked", true);
				if(mgrInfo.linkGubun != "URL"){
					$("input[name='urlText']").attr('readonly', true);
				}
				$("input:radio[name='useYn'][value='"+ mgrInfo.useYn +"']").prop("checked", true);
				
				$("#isIorU").val("update");
				$("input[name='isIorU']").val("update");
				$("#writePrdMgrBtn").text("수정");
				$("input[name='bannerSeq']").val(mgrInfo.bannerSeq);
				$("#mainModalPop").modal("show");
				
				var imgList = res.data.dtlMap;
				console.log(imgList);
				// 등록된 이미지 수대로 제품 이미지 html준비
				for(var i=0; i<imgList.length; i++) {
					console.log(i);
					if(i==0) {
						imgHTML("init", imgList);
					} else {
						imgHTML("append", imgList);
					}
				}
			}
		});
	}

	// 상품관리 팝업이 닫힐때 수행할 이벤트
	$("#mainModalPop").on("hidden.bs.modal", function(e) {
		imgHTML("init");
		clear_inForm("popFrm");
	});
	
	// 폼안에 있는 데이터 초기화
	function clear_inForm(formNm) {
		// 모든 input 박스의 값을 지움
		$("form[name='"+ formNm +"'] input:text").val("");
		$("form[name='"+ formNm +"'] input:file").val("");
		//$("form[name='"+ formNm +"'] textarea").val("");
		$("form[name='"+ formNm +"'] ._clear").text("");
		$("form[name='"+ formNm +"'] .td_name input:button").hide();
		$("form[name='"+ formNm +"'] .td_name span").text("");
		$(".pop_preview").hide();
		$("._check_image_word").text("");
	}
	
	function write()
	{
		$.ajax({
			url: "/mngwserc/cna/banner/TOP/write.ajax",
			type: "post",
			dataType: "json",
			success: function(data) {
				$("#writePrdMgrBtn").text("등록");
				$("input[name='isIorU']").val("insert");
				$("#mainModalPop").modal("show");
// 				$("input[name='linkGubun']").val("URL");
				$("input[type='radio'][name='linkGubun']").eq(0).prop("checked", true);
				$("input[type='radio'][name='useYn']").eq(1).prop("checked", true);
				$("#urlText").removeAttr("readonly");
			}
		});
	}
	
	//선택 삭제하기
	function deleteBanner()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				var f = document.searchFrm;
				f.action = "/mngwserc/cna/banner/TOP/bannerDelete.do";
				f.submit();
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
</script>
