<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	MBAMemChngList.jsp
	프로그램 명 : 	회원 정보 변경로그 목록을 조회한다.
	설명		: 	회원 정보 변경로그 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.22
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.22				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		현황 : 
		<select name="prcsYn">
			<option value="">전체</option>
			<option value="N" <c:if test="${rtnMap.prcsYn eq 'N'}">selected</c:if>>대기</option>
			<option value="Y" <c:if test="${rtnMap.prcsYn eq 'Y'}">selected</c:if>>완료</option>
		</select>
		&nbsp;&nbsp;
		접수일 : 
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" value="${rtnMap.strtDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" value="${rtnMap.endDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">회원 정보 관리</caption>
		<thead>
			<tr>
				<th width="6%">번호</th>
				<th width="9%">고유번호</th>
				<th width="9%">이름(아이디)</th>
				<th width="48%">변경전 / 변경후</th>
				<th width="10%">접수일</th>
				<th width="10%">완료일</th>
				<th width="8%">현황</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="6" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	 			<tr>
	 				<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${egov:nvl(list.memNo, '-')}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${list.name}<br />
						(${list.id})
					</td>
					<td style="text-align:left;">
						<c:if test="${not empty list.bfrName}">
							이름 : ${list.bfrName} / 
						</c:if>
						이메일 : ${list.bfrEmail} / 
						전화번호 : ${list.bfrTel} / 
						휴대전화 : ${list.bfrHp} 
						<br />
						주소 : (${list.bfrZipcd})&nbsp;${list.bfrAdr}&nbsp;${list.bfrAdrDtl} 
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						${egov:decode(list.prcsYn, 'Y', egov:convertDate(list.modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '-')}
					</td>
					<td rowspan="2" style="text-align:center; vertical-align:middle;">
						<select onchange="updatePrcsYn(this, '${list.chngSeq}', '${list.prcsYn}');">
							<option value="N" <c:if test="${list.prcsYn eq 'N'}">selected</c:if>>대기</option>
							<option value="Y" <c:if test="${list.prcsYn eq 'Y'}">selected</c:if>>완료</option>
						</select>
					</td>
				</tr>
				<tr>
	 				<td style="text-align:left;">
	 					<c:if test="${not empty list.aftName}">
							<font <c:if test="${list.bfrName ne list.aftName}">style="font-weight:bold; color:#ED006D;"</c:if>>
							이름 : ${list.aftName}
							</font> / 
						</c:if>
						<font <c:if test="${list.bfrEmail ne list.aftEmail}">style="font-weight:bold; color:#ED006D;"</c:if>>
							이메일 : ${list.aftEmail}
						</font> / 
						<font <c:if test="${list.bfrTel ne list.aftTel}">style="font-weight:bold; color:#ED006D;"</c:if>>
							전화번호 : ${list.aftTel}
						</font> /
						<font <c:if test="${list.bfrHp ne list.aftHp}">style="font-weight:bold; color:#ED006D;"</c:if>>
							휴대전화 : ${list.aftHp}
						</font>
						<br />
						<font <c:if test="${list.bfrZipcd ne list.aftZipcd or list.bfrAdr ne list.aftAdr or list.bfrAdrDtl ne list.aftAdrDtl}">style="font-weight:bold; color:#ED006D;"</c:if>>
							주소 : (${list.aftZipcd})&nbsp;${list.aftAdr}&nbsp;${list.aftAdrDtl}
						</font> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  	<div class="modal-dialog">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        		<h4 class="modal-title" id="myModalLabel">Type 선택</h4>
	      		</div>
	      		<div class="modal-body" style="text-align:center;">
	        		<input type="radio" name="type" value="nomal" checked="checked" /> 일반 
	        		&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="type" value="rowData" /> ROW 데이터 
	      		</div>
	      		<div class="modal-footer">
	       			<a href="javascript:excelList();" class="btn btn-info">엑셀 다운로드</a>
	        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
	      		</div>
	    	</div>
	  	</div>
	</div>
</form>

<div style="float:left;">
	<a href="javascript:chkType();" class="btn btn-primary">회원정보 변경로그</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>
	
<script type="text/javascript">
	
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
	function selectMemInfDtl(id)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.id.value = id;
		f.submit();
	}
	
	//처리현황을 수정한다.
	function updatePrcsYn(obj, chngSeq, prcsYn)
	{
		if(confirm("현황을 변경하시겠습니까?"))
		{
			jQuery.post("./prcs-update.ajax",
				{
					"chngSeq" : chngSeq, 
					"prcsYn" : jQuery(obj).val() 
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y") 
					{
						alert("변경되었습니다.");
						window.location.reload(true);
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
		else
		{
			jQuery(obj).find("option[value='"+prcsYn+"']").prop("selected", true);
		}
	}
	
	//회원정보 변경로그 Type 체크
	function chkType()
	{
		jQuery("#myModal").modal("show");
	}
	
	//엑셀 다운로드
	function excelList()
	{
		var f = document.frm;
		
		f.action = "./excel.do";
		f.submit();
		
		jQuery("#myModal").modal("hide");
	}
	
</script>