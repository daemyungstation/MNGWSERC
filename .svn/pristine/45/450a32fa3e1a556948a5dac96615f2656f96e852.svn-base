<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CNAZeroChoiList.jsp
	프로그램 명 : 	제로초이스 (상품 관리 목록 & 이미지 관리 목록)을 조회한다.
	설명		: 	제로초이스 (상품 관리 목록 & 이미지 관리 목록)을 조회하는 페이지
	작성자		: 	박주윤
	작성일		:	2018.03.29
	수정일자	 			수정자				수정내용
	=====================================================================
	
	######################################################################
-->

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" id="useYnChk" value="${rtnMap.list[0].useYnChk }">	<!-- 1 보다 크면 Y가 1개 이상임 --> 
	<input type="hidden" name="zeroChoiGb" value="" />
	
	<div class="well well-small">
		조건검색 : 
		<select name="f1">
			<c:choose>
				<c:when test="${rtnMap.zeroChoiGb eq 'prdmgr'}">
					<option value="1" <c:if test="${rtnMap.f1 eq '1'}">selected</c:if>>전체</option>
					<option value="2" <c:if test="${rtnMap.f1 eq '2'}">selected</c:if>>카테고리</option>
					<option value="3" <c:if test="${rtnMap.f1 eq '3'}">selected</c:if>>상품명</option>
					<option value="4" <c:if test="${rtnMap.f1 eq '4'}">selected</c:if>>모델명</option>
				</c:when>
				<c:when test="${rtnMap.zeroChoiGb eq 'imgmgr'}">
					<option value="1" <c:if test="${rtnMap.f1 eq '1'}">selected</c:if>>전체</option>
					<option value="2" <c:if test="${rtnMap.f1 eq '2'}">selected</c:if>>제목</option>
					<option value="3" <c:if test="${rtnMap.f1 eq '3'}">selected</c:if>>작성자</option>
				</c:when>
			</c:choose>
			
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		&emsp; 노출여부 : 
		<select name="f2">
			<option value="" <c:if test="${rtnMap.f2 eq '1'}">selected</c:if>>전체</option>
			<option value="2" <c:if test="${rtnMap.f2 eq '2'}">selected</c:if>>Y</option>
			<option value="3" <c:if test="${rtnMap.f2 eq '3'}">selected</c:if>>N</option>
		</select>
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">이용안내 관리</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th width="6%">번호</th>
				<c:choose>
					<c:when test="${rtnMap.zeroChoiGb eq 'prdmgr'}">
						<th width="12%">카테고리</th>
						<th width="25%">상품명</th>
						<th width="15%">모델명</th>
						<th width="15%">상품가격</th>
						<th width="13%">작성일</th>
						<th width="8%">노출여부</th>
					</c:when>
					<c:when test="${rtnMap.zeroChoiGb eq 'imgmgr'}">
						<th width="52%">제목</th>
						<th width="15%">작성자</th>
						<th width="14%">작성일</th>
						<th width="8%">노출여부</th>
					</c:when>
				</c:choose>
			</tr>
		</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<c:choose>
						<c:when test="${rtnMap.zeroChoiGb eq 'prdmgr'}">
							<td class="lt_text3" colspan="8" style="text-align:center">
								<fmt:message key="common.nodata.msg" />
							</td>
						</c:when>
						<c:when test="${rtnMap.zeroChoiGb eq 'imgmgr'}">
							<td class="lt_text3" colspan="6" style="text-align:center">
								<fmt:message key="common.nodata.msg" />
							</td>
						</c:when>
					</c:choose>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<c:choose>
						<c:when test="${rtnMap.zeroChoiGb eq 'prdmgr'}">
							<td style="text-align:center;">
									<input type="checkbox" name="delSeq" value="${list.prdctSeq}" />
							</td>
							<td style="text-align:center; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}');">
								${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
							</td>		
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}', '${rtnMap.zeroChoiGb}');">
								${list.cateNm}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}', '${rtnMap.zeroChoiGb}');">
								${list.prdctNm}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}', '${rtnMap.zeroChoiGb}');">
								${list.modelNm}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}', '${rtnMap.zeroChoiGb}');">
								${list.priceBenefit}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}', '${rtnMap.zeroChoiGb}');">
								${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.prdctSeq}', '${rtnMap.zeroChoiGb}');">
								${list.useYn}
							</td>
						</c:when>
						<c:when test="${rtnMap.zeroChoiGb eq 'imgmgr'}">
							<td style="text-align:center;">
								<c:if test="${list.useYn eq 'Y' }">
									<input type="checkbox" name="delSeq" value="${list.imgrSeq}" disabled="disabled"/>
								</c:if>
								<c:if test="${list.useYn eq 'N' }">
									<input type="checkbox" name="delSeq" value="${list.imgrSeq}" />
								</c:if>
							</td>
							<td style="text-align:center; cursor:pointer;" onclick="selectZeroChoiDtl('${list.imgrSeq}');">
								${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
							</td>		
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.imgrSeq}', '${rtnMap.zeroChoiGb}');">
								${list.title}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.imgrSeq}', '${rtnMap.zeroChoiGb}');">
								${list.name}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.imgrSeq}', '${rtnMap.zeroChoiGb}');">
								${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							</td>
							<td style="text-align:left; cursor:pointer;" onclick="selectZeroChoiDtl('${list.imgrSeq}', '${rtnMap.zeroChoiGb}');">
								${list.useYn}
							</td>
						</c:when>
					</c:choose>			
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</form>

<c:choose>
	<c:when test="${rtnMap.zeroChoiGb eq 'prdmgr'}">
		<!-- 상품관리 등록 Modal -->
		<div class="modal fade" id="prdModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1000px; margin-left: -500px;">
		  	<div class="modal-dialog">
		    	<div class="modal-content">
		      		<div class="modal-header">
		        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        		<h4 class="modal-title" id="zeroChoiPrdMgrLabel"></h4>
		      		</div>
		      		<div class="modal-body" style="text-align:center;">
								<%@ include file="./CNAZeroChoiPrdMgrRegPoP.jsp" %>
								</div>
		      		<!-- <div class="modal-footer">
		       			<a href="javascript:excelRcvModList();" class="btn btn-info">엑셀 다운로드</a>
		        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
		      		</div> -->
		    	</div>
		  	</div>
		</div>
	</c:when>
	<c:when test="${rtnMap.zeroChoiGb eq 'imgmgr'}">
		<!-- 이미지관리 등록 Modal -->
		<div class="modal fade" id="imgModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1000px; margin-left: -500px;">
		  	<div class="modal-dialog">
		    	<div class="modal-content">
		      		<div class="modal-header">
		        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        		<h4 class="modal-title" id="zeroChoiImgMgrLabel"></h4>
		      		</div>
		      		<div class="modal-body" style="text-align:center;">
								<%@ include file="./CNAZeroChoiImgMgrPoP.jsp" %>
								</div>
		      		<!-- <div class="modal-footer">
		       			<a href="javascript:excelRcvModList();" class="btn btn-info">엑셀 다운로드</a>
		        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
		      		</div> -->
		    	</div>
		  	</div>
		</div>
	</c:when>
</c:choose>

<div style="float:left;">
	<a href="javascript:deleteZeroChoiList();" class="btn btn-danger">삭제</a>
	<a href="javascript:insertZeroChoiCopy();" class="btn btn-info">복사</a>
</div>

<div style="float:right;">
	<c:choose>
		<c:when test="${rtnMap.zeroChoiGb eq 'prdmgr'}">
			<a href="javascript:write_prdmgr();" class="btn btn-success">등록</a>
		</c:when>
		<c:when test="${rtnMap.zeroChoiGb eq 'imgmgr'}">
			<a href="javascript:write_imgmgr();" class="btn btn-success">등록</a>
		</c:when>
	</c:choose>
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
				jQuery("input:checkbox[name='delSeq']").not(":disabled").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='delSeq']").not(":disabled").prop("checked", false);
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

// 상품관리 팝업이 닫힐때 수행할 이벤트
	$("#prdModalPop").on("hidden.bs.modal", function(e) {
		$(".loop").html("");
		prdImgHTML("init");
		clear_inForm("frm_prdMgr_pop");
		
		$("._prd_spec_td").html("");
		$("._prd_spec_td").html("<textarea id=\"prd_spec\" name=\"prd_spec\" rows=\"20\" style=\"display:block; width:98%;\" exec=\"editorSync(this.id)\" required=\"내용을 입력하세요.\"></textarea>");
	});
	
// 제로초이스 이미지 관리 리스트 > 등록 버튼 클릭 이벤트
	function write_imgmgr() {
		$("#imgModalPop").modal("show");
		$("#zeroChoiImgMgrLabel").text("제로 초이스 이미지 등록");
		$("#imp_write_btn").text("등록");
		$("form[name='frm_imgMgr_pop']").attr("data-type", "insert");
		
		imp_createHTML("top", "init", "insert");
		imp_createHTML("bottom", "init", "insert");
	}
	
	
	//상품관리 리스트 > 등록 버튼 클릭 이벤트
	function write_prdmgr()
	{
		if(typeof $(".loop table")[0] == 'undefined') {
			prdImgHTML("init");
		}
		
		$.ajax({
			url: "./write.ajax",
			type: "post",
			dataType: "json",
			success: function(data) {
				$("#zeroChoiPrdMgrLabel").text("제로 초이스 상품 등록");
				$("#writePrdMgrBtn").text("등록");
				$("input[name='price_yn']").prop("checked", true);
				$("input[name='price_benefit_unit_yn']").prop("checked", true);
				$("input[name='isIorU']").val("insert");
				$("#prdModalPop").modal("show");
				
				editorAdd("prd_spec");
			}
		});
	}
	
	//리스트 가져오기
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
		
		f.action = "./list.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectZeroChoiDtl(seq, gubun)
	{
		$.ajax({
			url: "./view.ajax",
			type: "post",
			dataType: "json",
			data: {"seq" : seq, "gubun" : gubun},
			success: function(res) {
				if(gubun === 'prdmgr') {	// 상품관리 상세정보 확인 모달창 세팅
					var prdMgrInfo = res.data.prdMgrInfo;
					$("select[name='category']").val(prdMgrInfo.cateSeq);
					$("input[name='prdctNm']").val(prdMgrInfo.prdctNm);
					$("input[name='modelNm']").val(prdMgrInfo.modelNm);
					$("input[name='price']").val(prdMgrInfo.price);
					$("input[name='priceBenefit']").val(prdMgrInfo.priceBenefit);
					$("select[name='instalment']").val(prdMgrInfo.instalment);
					$("input:radio[name='visible_yn'][value='"+ prdMgrInfo.useYn +"']").prop("checked", true);
					$("textarea[name='cntn']").val(prdMgrInfo.cntn);
					prdMgrInfo.priceYn === 'Y' ? 	$("input[name='price_yn']").prop("checked", true) : $("input[name='price_yn']").prop("checked", false);
					prdMgrInfo.priceBenefitUnitYn === 'Y' ? 	$("input[name='price_benefit_unit_yn']").prop("checked", true) : $("input[name='price_benefit_unit_yn']").prop("checked", false);
					$("input[name='price_text']").val(prdMgrInfo.priceText);
					
					$("#zeroChoiPrdMgrLabel").text("제로 초이스 상품 확인");
					$("#isIorU").val("update");
					$("input[name='isIorU']").val("update");
					$("#writePrdMgrBtn").text("수정");
					$("input[name='prdctSeq']").val(prdMgrInfo.prdctSeq);
					$("#cntnWordCnt").html($("textarea[name='cntn']").val().length + '/200');
					
					$("#prd_spec").val(prdMgrInfo.prdSpec);
					editorAdd("prd_spec");
					$("#prdModalPop").modal("show");
					
					var prdImgList = res.data.prdImgList;
					var prdImgCnt = res.data.prdImgCnt.cnt;
					
					// 등록된 이미지 수대로 제품 이미지 html준비
					for(var i=0; i<prdImgCnt; i++) {
						$(".loop").html("");
						if(i==0) {
							prdImgHTML("init", prdImgList);
						} else {
							prdImgHTML("append", prdImgList);
						}
					}
					
				} else {	// 이미지 관리 상세정보 확인 모달창 세팅
					space_del_orders = [];	// 영역삭제 후 수정버튼 클릭시 영역 삭제된 아이템 적용 변수
					$("#imgModalPop").modal("show");
					$("#zeroChoiImgMgrLabel").text("제로 초이스 이미지 확인");
					$("#imp_write_btn").text("수정");
					$("form[name='frm_imgMgr_pop']").attr("data-type", "update");
					$("input[name='imgSeq']").val(seq);
					
					// 값 세팅
					var imgMgrInfo = res.data.imgMgrInfo;
					var topFileList = res.data.topFileList;
					var topPopFileList = res.data.topPopFileList;
					var bottomFileList = res.data.bottomFileList;
					var bottomPopFileList = res.data.bottomPopFileList;
					var topContCnt = res.data.topContCnt.cnt;
					var bottomContCnt = res.data.bottomContCnt.cnt;
					var topPopContCnt = res.data.topContCnt.cnt;
					var bottomPopContCnt = res.data.bottomContCnt.cnt;
					
					// 제목
					$("input:text[name='imp_title']").val(imgMgrInfo.title);		
					// 노출여부
					$("input:radio[name='use_yn']:radio[value='"+ imgMgrInfo.useYn + "']").prop("checked", true);
					$("input:radio[name='use_yn']").closest("td").attr("data-useyn", imgMgrInfo.useYn);

					
					// 등록된 상단 이미지 파일 수대로 html 생성
					for(var i=0; i<topContCnt; i++) {
						var status = (i==0) ? "init" : "append";
						var tmp = [];
						
						for(var j=0; j<topFileList.length; j++) {
							if((i+1) == topFileList[j].regOrder) {
								tmp.push(topFileList[j]);
							}
						} 
						
						imp_createHTML("top", status, "update", tmp);
					}
					
					// 등록된 하단 이미지 파일 수대로 html 생성
					for(var i=0; i<bottomContCnt; i++) {
						var status = (i==0) ? "init" : "append";
						var tmp = [];
						
						for(var j=0; j<bottomFileList.length; j++) {
							if((i+1) == bottomFileList[j].regOrder) {
								tmp.push(bottomFileList[j]);
							}
						} 
						
						imp_createHTML("bottom", status, "update", tmp);
					}
					
					// 상단 팝업 노출 이미지가 등록되어 있을 경우 html 생성
					if(topPopFileList.length > 0) {
						for(var i=0; i<topPopFileList.length; i++) {
							if(i%2 == 0) {
								$(".loop[data-gubun='top']").find(".pop_visible input:checkbox").eq(topPopFileList[i].regOrder-1).click();
							}
						}
						
						for(var i=0; i<topPopContCnt; i++) {
							var loop_div = $(".pop_visible input:checkbox").closest(".loop[data-gubun='top'] ._loop_div").eq(i);
							
							for(var j=0; j<topPopFileList.length; j++) {
								if((i+1) == topPopFileList[j].regOrder) {
									var cnt = 0;	// pc 이미지
									if(j%2 != 0) {
										cnt = 1;	// mobile 이미지
									} 
									
									loop_div.find(".pop_visible").find(".td_name span").eq(cnt).text(topPopFileList[j].fileNm);
									loop_div.find(".pop_visible").find(".td_name .btn_pop_preview").eq(cnt).removeClass("hidden");
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).siblings("td").eq(1).text(topPopFileList[j].fileSize);
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).siblings("td").eq(2).text(topPopFileList[j].fileType);
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).siblings("td").eq(3).find("._btn_pop_img_del").removeClass("hidden");
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).find(".btn_pop_preview").attr("data-fileseq", topPopFileList[j].fileSeq);
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).find(".btn_pop_preview").attr("data-regorder", topPopFileList[j].regOrder);
								}
							}
						}
					}
					
					// 하단 팝업 노출 이미지가 등록되어 있을 경우 html 생성
					if(bottomPopFileList.length > 0) {
						for(var i=0; i<bottomPopFileList.length; i++) {
							if(i%2 == 0) {
								$(".loop[data-gubun='bottom']").find(".pop_visible input:checkbox").eq(bottomPopFileList[i].regOrder-1).click();
							}
						}
						
						for(var i=0; i<bottomPopContCnt; i++) {
							var loop_div = $(".pop_visible input:checkbox").closest(".loop[data-gubun='bottom'] ._loop_div").eq(i);
							
							for(var j=0; j<bottomPopFileList.length; j++) {
								if((i+1) == bottomPopFileList[j].regOrder) {
									var cnt = 0;	// pc 이미지
									if(j%2 != 0) {
										cnt = 1;	// mobile 이미지
									} 

									loop_div.find(".pop_visible").find(".td_name span").eq(cnt).text(bottomPopFileList[j].fileNm);
									loop_div.find(".pop_visible").find(".td_name .btn_pop_preview").eq(cnt).removeClass("hidden");
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).siblings("td").eq(1).text(bottomPopFileList[j].fileSize);
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).siblings("td").eq(2).text(bottomPopFileList[j].fileType);
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).siblings("td").eq(3).find("._btn_pop_img_del").removeClass("hidden");
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).find(".btn_pop_preview").attr("data-fileseq", bottomPopFileList[j].fileSeq);
									loop_div.find(".pop_visible").find(".td_name").eq(cnt).find(".btn_pop_preview").attr("data-regorder", bottomPopFileList[j].regOrder);
								}
							}
						}
					}
				}
			}
		});
	}
	
	// 폼안에 있는 데이터 초기화
	function clear_inForm(formNm) {
		// 모든 input 박스의 값을 지움
		$("form[name='"+ formNm +"'] input:text").val("");
		$("form[name='"+ formNm +"'] input:file").val("");
		$("form[name='"+ formNm +"'] textarea").val("");
		$("form[name='"+ formNm +"'] ._clear").text("");
		$("form[name='"+ formNm +"'] .td_name input:button").hide();
		$("form[name='"+ formNm +"'] .td_name span").text("");
		$(".pop_preview").hide();
		$("#cntnWordCnt").html("0/200");
		$("._check_image_word").text("");
		
		// 모든 select 박스의 첫번째 option으로 초기화
		var select = $("form[name='"+ formNm +"'] select");
		for(var i=0; i<select.length; i++) {
			if(firstOption = select.eq(i).children("option:eq(0)")) {
				firstOption.prop("selected", "selected");
			}
		}
	}
	
	//선택 삭제하기
	function deleteZeroChoiList()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				var f = document.frm;
				
				f.action = "./delete.do";
				f.submit();
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
	//선택 복사하기
	function insertZeroChoiCopy()
	{
		var chkCnt = jQuery("input:checkbox[name='delSeq']:checked").length;
		
		if(chkCnt > 0)
		{
			if(chkCnt == 1)
			{
				if(confirm("복사하시겠습니까?"))
				{
					var f = document.frm;
					
					f.action = "./copy.do";
					f.submit();
				}
			}
			else
			{
				alert("복사할 대상을 하나만 선택하세요.");
				return;
			}
		}
		else
		{
			alert("복사할 대상을 선택하세요.");
			return;
		}
	}
	
</script>