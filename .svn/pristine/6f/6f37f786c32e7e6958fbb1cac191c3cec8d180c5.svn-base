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

<script type="text/javascript" src="/common/js/jquery.fileDownload.js"></script>

<c:set var="loginMap" value="${admLgnMap}" />

<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />


<form id="excelFrm" name="excelFrm" method="post" action="excel.do">
	<input type="hidden" name="f" id="fExcel" value="${rtnMap.f}" />
	<input type="hidden" name="q" id="qExcel" value="${rtnMap.q}" />
	<input type="hidden" name="callStts" id="callSttsExcel" value="${rtnMap.callStts}" />	
	<input type="hidden" name="strtDt" id="strtDtExcel" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" id="endDtExcel" value="${rtnMap.endDt}" />
</form>

<div class="row">
    <div class="col-12">
        <div class="page-title-box d-flex align-items-center justify-content-between">
            <h4 class="page-title">상담 목록</h4>
        </div>
    </div>
</div>

<form id="frm" name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<div class="card-box">
	    <div class="form-inline">
	        <div class="form-group">
	            <label for="inputPassword2">${((opmInfMap.b2bStts eq 'ONLIFECC') or (opmInfMap.b2bStts eq 'EZWEL')) ? '등록일 : ' : '신청일 : '} </label>
	            &nbsp;&nbsp;
	            <div class="input-group">
                    <input type="text" class="datepicker_input form-control form-control-sm" placeholder="검색 시작일" id="strtDt" name="strtDt" value="${rtnMap.strtDt}" readonly="readonly"  />
                    <div class="input-group-append">
                        <button class="btn btn-dark btn-sm waves-effect waves-light" type="button" onclick="jQuery('#strtDt').focus();">
                        	<i class="dripicons-calendar"></i>
                        </button>
                    </div>
                </div>
                &nbsp;&nbsp;
                <div class="input-group">
                    <input type="text" class="datepicker_input form-control form-control-sm" placeholder="검색 종료일" id="endDt" name="endDt" value="${rtnMap.endDt}" readonly="readonly"  />
                    <div class="input-group-append">
                        <button class="btn btn-dark btn-sm waves-effect waves-light" type="button" onclick="jQuery('#endDt').focus();">
                        	<i class="dripicons-calendar"></i>
                        </button>
                    </div>
                </div>
                &nbsp;&nbsp;
				<select name="f" id="f" class="form-control form-control-sm" onchange="changeFSelect()">
					<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>대명<br />가입번호(idNo)</option>
					<option value="25" <c:if test="${rtnMap.f eq '25'}">selected</c:if>>U+가입번호</option>
					<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>실제 판매자 이름</option>
					<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고객명</option>
					<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>고객 연락처</option>
					<option value="6" <c:if test="${rtnMap.f eq '6'}">selected</c:if>>상담자</option>
					<option value="37" <c:if test="${rtnMap.f eq '37'}">selected</c:if>>계약종류</option>
					<option value="38" <c:if test="${rtnMap.f eq '38'}">selected</c:if>>가입센터</option>
				</select>
				
				&nbsp;&nbsp;
                <div class="input-group">
                	<input type="text" name="q" id="q" value="${rtnMap.q}" class="form-control form-control-sm" maxlength="50" />
                </div>
                &nbsp;&nbsp;
                <select name="callStts" id="callStts" class="form-control form-control-sm">
					<c:choose>
						<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
							<option value="">[상담현황선택]</option>
						</c:when>
						<c:otherwise>
							<option value="">[상담확인선택]</option>
						</c:otherwise>
					</c:choose>
					<option value="no" <c:if test="${'no' eq rtnMap.callStts}">selected</c:if>>미상담</option> 
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
						<option value="${cdlist.cd}" <c:if test="${cdlist.cd eq rtnMap.callStts}">selected</c:if>>${cdlist.cdNm}</option>
					</c:forEach>					
				</select>
				&nbsp;&nbsp;
				<a href="javascript:getPageList();" class="btn btn-sm btn-primary" title="검색">검색</a>
				&nbsp;&nbsp;
				<a href="javascript:getPageNew();" class="btn btn-sm btn-primary" title="전체검색">초기화</a>
	        </div>
	    </div>
    </div>
	
	<p>전체 게시물 수 : ${rtnMap.list[0].totCnt}</p>
	
	<div class="row">
	    <div class="col-12">
	        <div class="card-box">
				<div class="table-responsive">
				<table class="table mb-0 table-bordered table-hover" style="font-size:12px;">
					<caption style="display: none;">외주업체 상담 관리</caption>
		<thead>
			<tr>				
				<th style="width:60px; vertical-align:middle;">번호</th>
				<th style="width:60px; vertical-align:middle;">계약종류</th>
				<th style="width:60px; vertical-align:middle;">가입센터</th>
				<th style="width:100px; vertical-align:middle;">대명<br/>가입번호(idNo)</th>
				<th style="width:100px; vertical-align:middle;">실제판매자 이름</th>
				<th style="width:100px; vertical-align:middle;">유치대리점명</th>
				<th style="width:100px; vertical-align:middle;">실제판매자 연락처</th>
				<th style="width:100px; vertical-align:middle;">1구좌 상품명</th>
				<th style="width:100px; vertical-align:middle;">2구좌 상품명</th>
				<th style="width:100px; vertical-align:middle;">주 계약</th>
				<th style="width:100px; vertical-align:middle;">고객명</th>
				<th style="width:100px; vertical-align:middle;">할인 받을 연락처(CTN)</th>
				<th style="width:100px; vertical-align:middle;">U+가입번호</th>
				<th style="width:100px; vertical-align:middle;">U+서비스명</th>
				<th style="width:100px; vertical-align:middle;">U+상품번호</th>
				<th style="width:100px; vertical-align:middle;">고객 연락처(핸드폰)</th>
				<th style="width:100px; vertical-align:middle;">상담신청일</th>
				<th style="width:100px; vertical-align:middle;">상담확인</th>
				<th style="width:100px; vertical-align:middle;">상담자</th>
				<th style="width:100px; vertical-align:middle;">메모</th>
				<th style="width:100px; vertical-align:middle;">상담상태</th>
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
						<tr onclick="view('${list.idNo}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}','${list.kbNo}')" style="cursor:pointer">				
							<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
							<c:choose>
								<c:when test="${list.joinMethod eq 'fixedLine'}">
									<td style="text-align:center;">TM</td>
								</c:when>
								<c:otherwise>
									<td style="text-align:center;">전자서명</td>
								</c:otherwise>
							</c:choose>
							<%-- <c:if test="${list.joinMethod eq 'fixedLine'}">
								<td style="text-align:center;">TM</td>
							</c:if>
							<c:if test="${list.joinMethod eq 'electronicContract'}">
								<td style="text-align:center;">전자서명</td>
							</c:if> --%>
							<td style="text-align:center;">${list.regCenter}</td>
							<td style="text-align:center;">${list.idNo}</td>
							<td style="text-align:center;">${list.agentEmpNm}</td>							
							<td style="text-align:center;">${list.uDlrNm}</td>
							<td style="text-align:center;">${list.agentEmpTel}</td>
							<td style="text-align:center;">${list.prdctNm}</td>
							<td style="text-align:center;">${list.prdctNm2}</td>
							<td style="text-align:center;">${list.mainContType}</td>
							<td style="text-align:center;">${list.name}</td>
							<td style="text-align:center;">${list.discountCtn}</td>
							<td style="text-align:center;">${list.uProdNo}</td>
							<td style="text-align:center;">${list.uProdNm}</td>
							<td style="text-align:center;">${list.homePrdNum}</td>
							<td style="text-align:center;">${list.hp}</td>
							<td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
							<td style="text-align:center;">${list.callStts}</td>
							<td style="text-align:center;">${list.cnslDtlCntn}</td>
							<td style="text-align:center;">${list.memo}</td>
							<td style="text-align:center;">${list.targetStts}</td>
						</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				</div>
			</div>
		</div>
	</div>
</form>

<div style="float:right;">
	<c:choose>
		<c:when test="${(loginMap.id eq 'interparkdb') or (loginMap.id eq 'ezweldb') or (loginMap.id eq 'tmondb')}">
			<a href="javascript:excelUploadPop();" class="btn btn-sm btn-primary">엑셀 업로드</a>
		</c:when>
		<c:when test="${loginMap.id eq 'jautour'}"></c:when>
		<c:when test="${loginMap.id eq 'lgusawon'}">
			<a href= "javascript:lguExcelDownload();" class="btn btn-sm btn-primary">전체 DB 다운로드</a>
			<a href="javascript:excel();" class="btn btn-sm btn-primary">엑셀 다운로드</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:excel();" class="btn btn-sm btn-primary">엑셀 다운로드</a>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="${rtnMap.paginationInfo ne null}">
<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>
</c:if>

<script type="text/javascript">
	// 자동완성
	function changeFSelect() {
		var disabled = true;
		var sourceList = [];
		var selectValue = f.options[f.selectedIndex].value;
		
		if( selectValue == 37 ) {
			sourceList = ['TM', '전자서명'];
			disabled = false;
		} else if( selectValue == 38 ) {
			sourceList = ['윌앤비전', '리딩아이', '효성ITX'];
			disabled = false;
		}
		$("#q").autocomplete({  //오토 컴플릿트 시작
		      source: sourceList,	// source는 data.js파일 내부의 List 배열
		      focus : function(event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌	
		          return true;
		      },
		      minLength: 0,// 최소 글자수
		      delay: 100,	//autocomplete 딜레이 시간(ms)
		      disabled: disabled, //자동완성 기능 끄기
		});
	}
	

	//금일 날짜 가져온 후 LGU 엑셀 다운로드
	function lguExcelDownload(){
		let date = new Date();
		let year = date.getFullYear();
		let month = date.getMonth();
		let day = date.getDate();
		
		month++;
		
		if(month < 10) {
			month = "0" + month;
		}
		
		if(day < 10) {
			day = "0" + day;
		}
		
		let today = year.toString()+month.toString()+day.toString();
		
		//window.location.assign("/web/common/editor/LGUExcel/LGUDataExcel" + today + ".xls");
		window.location.assign("/common/editor/LGUExcel/LGUDataExcel" + today + ".xls");
	}

	//새로 고침
	function getPageNew(){		
		//로딩중 띄우기
		$("#overlay, #pleaseWait").show();
		document.location.href = "${pageLink}";
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
		
		/* var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, "")); */
		
		var strtDt = new Date(jQuery("#strtDt").val());
		var endDt = new Date(jQuery("#endDt").val());
		
		strtDt = strtDt.getTime();
		endDt = endDt.getTime();
		
		
		
		var gapDt = (endDt - strtDt) / 86400000;
		
		if(strtDt && endDt && strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
			return;
		}
		
		if(jQuery("#q").val() != ''){
			if(jQuery("#strtDt").val() == '' || jQuery("#endDt").val() == ''){
				alert("날짜를 입력해 주시기 바랍니다.");
				return;
			}
			if(gapDt > 90){
				alert("검색기간을 90일 이내로 지정해주시기 바랍니다.");
				return;
			}
		}
		if(jQuery("#q").val() == ''){
			if(gapDt > 31){
				alert("검색기간을 31일 이내로 지정해주시기 바랍니다.");
				return;
			}
		}
		
		//로딩중 띄우기
		$("#overlay, #pleaseWait").show();
		
		f.action = "./list.do";
		f.submit();
	}
	
	function excel()
	{
		var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
	
		if(!strtDt || !endDt)
		{
			alert("* 검색 기간을 입력해주세요.");
		}
		else if(strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
		}
		else
		{
			var arrStrgDt = jQuery("#strtDt").val().split("-");
			var arrEndDt = jQuery("#endDt").val().split("-");
			
			var strtDate = new Date(arrStrgDt[0], parseInt(arrStrgDt[1]) - 1, arrStrgDt[2]); 
			var endDate = new Date(arrEndDt[0], parseInt(arrEndDt[1]) - 1, arrEndDt[2]); 

			if((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 30)
			{
				alert("* 검색 기간을 30일 이하로 입력해주세요.");
			}
			else
			{
				$("#fExcel").val($("#f").val());
				$("#qExcel").val($("#q").val());
				$("#callSttsExcel").val($("#callStts").val());
				$("#strtDtExcel").val($("#strtDt").val());
				$("#endDtExcel").val($("#endDt").val());
				
				//document.excelFrm.submit();
				
				//로딩중 띄우고 Submit
				$("#overlay, #pleaseWait").show();
				$.fileDownload($("#excelFrm").prop('action'),{
					httpMethod:"POST",
					data:$("#excelFrm").serialize(),
					successCallback: function(url){
						$("#overlay, #pleaseWait").hide();
					},
					failCallback: function(responseHtml,url){
						$("#overlay, #pleaseWait").hide();
					}
				});					
			}
		}
	}
	
	function view(seq, f, q, pageIndex, callStts, strtDt, endDt, kbNo)
	{
		location.href = "./view.do?idx="+seq+"&f="+f+"&q="+q+"&pageIndex="+pageIndex+"&callStts=" + callStts + "&strtDt=" + strtDt + "&endDt=" + endDt + "&kbNo=" + kbNo;
	}
	
	// 엑셀 등록 팝업
	function excelUploadPop() 
	{
		setPopup("./excelUploadPop.do", "EXCELUPLOADPOP", 510, 310);
	}	

	//로딩바 셋팅
	$(document).ready(function() {
	    $("body").prepend('<div id="overlay" class="ui-widget-overlay" style="z-index: 1001; display: none;"></div>');
	    $("body").prepend("<div id='pleaseWait' style='display: none;'><img src='/common/images/icon/loading-bar.gif'/></div>");
	    $('#pleaseWait').middle();
	});
	
	//레이어 가운데 정렬
	jQuery.fn.middle = function () {
		this.css("position","absolute");
		this.css("top", '50%');
		this.css("left", '50%');
		this.css("margin-top",- ($(this).outerHeight()) / 2) + "px";
		this.css("margin-left",- ($(this).outerWidth()) / 2) + "px";
		return this;
	}
</script>