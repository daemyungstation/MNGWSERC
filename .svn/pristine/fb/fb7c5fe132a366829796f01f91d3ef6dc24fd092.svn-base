<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	MBAMemInfList.jsp
	프로그램 명 : 	회원 정보 목록을 조회한다.
	설명		: 	회원 정보 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.22
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.22				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="id" value="" />
	
	<div class="well well-small">
		고유번호 : 
		<select name="unqExstYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.unqExstYn eq 'Y'}">selected</c:if>>있음</option>
			<option value="N" <c:if test="${rtnMap.unqExstYn eq 'N'}">selected</c:if>>없음</option>
		</select>
		&nbsp;&nbsp;
		이메일 수신여부 : 
		<select name="emailRcvYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.emailRcvYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.emailRcvYn eq 'N'}">selected</c:if>>N</option>
		</select>
		&nbsp;&nbsp;
		SMS 수신여부 : 
		<select name="smsRcvYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.smsRcvYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.smsRcvYn eq 'N'}">selected</c:if>>N</option>
		</select>
		&nbsp;&nbsp;
		<select name="dtGb">
			<option value="1" <c:if test="${rtnMap.dtGb eq '1'}">selected</c:if>>최종접속일</option>
			<option value="2" <c:if test="${rtnMap.dtGb eq '2'}">selected</c:if>>가입일</option>
		</select>
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
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>SSO 통합아이디</option>
			<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고유번호</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="20" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover table-fixed"><!-- 테이블 클래스 추가 2017-08-03 -->
		<caption style="display: none;">회원 정보 관리</caption>
		<thead>
			<tr>
				<th rowspan="2" width="5%" style="vertical-align:middle;">번호</th>
				<th rowspan="2" width="11%" style="vertical-align:middle;">고유번호</th>
				<th rowspan="2" width="7%" style="vertical-align:middle;">이름</th>
				<th rowspan="2" width="15%" style="vertical-align:middle;">아이디</th>
				<th rowspan="2" width="15%" style="vertical-align:middle;">SSO 통합아이디</th>
				<th rowspan="2" width="15%" style="vertical-align:middle;">이메일</th>
				<th rowspan="2" width="10%" style="vertical-align:middle;">최종접속일</th>
				<th rowspan="2" width="10%" style="vertical-align:middle;">가입일</th>
				<th colspan="2" width="12%">수신여부</th>
			</tr>
			<tr>
				<th>CI동의</th>
				<th>마케팅</th>
				<!-- 
				<th>이메일</th>
				<th>SMS</th>
				 -->
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="10" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	 			<tr>
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.unqNo}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.name}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.id}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.ssoId}
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.email}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${egov:convertDate(list.lastLgnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>

					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.agreementForThirdParty}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.marketingYn}
					</td>
					<!-- 
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.emailRcvYn}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectMemInfDtl('${list.id}');">
						${list.smsRcvYn}
					</td>
					 -->
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
	        		<h4 class="modal-title" id="myModalLabel">기간 선택</h4>
	      		</div>
	      		<div class="modal-body" style="text-align:center;">
	        		<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="rcvModStrtDt" name="rcvModStrtDt" value="" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
					&nbsp;&nbsp;~&nbsp;&nbsp;
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="rcvModEndDt" name="rcvModEndDt" value="" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
	      		</div>

	      		<div class="modal-footer">
					<c:if test="${admLgnMap.authCd eq 99}">
					<a href="javascript:excelRcvModList();" class="btn btn-info">엑셀 다운로드</a>
					</c:if>
	        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
	      		</div>

	    	</div>
	  	</div>
	</div>
	
	<div class="modal fade" id="myModalLog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"  style="width:400px">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        		<h4 class="modal-title" id="myModalLabel">엑셀 다운로드 사유</h4>
	      		</div>
	      		<div class="modal-body" style="text-align:left;">
					<table>
						<tr>
							<td>	
								<input type="radio" id="reason" name="reason" value="접수누락확인" checked> 접수누락확인
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" id="reason" name="reason" value="접수현황확인"> 접수현황확인
							</td>	
						</tr>
						<tr>
							<td>
								<input type="radio" id="reason" name="reason" value="실적확인"> 실적확인
							</td>	
						</tr>
						<tr>
							<td>
								<input type="radio" id="reason" name="reason" value="정산확인"> 정산확인
							</td>	
						</tr>
					</table>
	      		</div>
	      		<div class="modal-footer">
	        		<button type="button" class="btn btn-default" data-dismiss="modal" onclick="excelList();">확인</button> 
	        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
	      		</div>
	    	</div>
	</div>
</form>
<c:if test="${admLgnMap.authCd eq 99}">
<%--숨김 처리(2020-04-13)--%>
<div style="float:left;">
	<a href="javascript:excelListChk();" class="btn btn-primary">엑셀 다운로드</a>
</div>
</c:if>


<div style="float:right;">
	<a href="javascript:chkPeriod();" class="btn btn-primary">고객서비스 변경로그</a>
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
	
	//엑셀 다운로드체크
	function excelListChk()
	{
		jQuery("#myModalLog").modal("show");
	}
	<c:if test="${admLgnMap.authCd eq 99}">
	//엑셀 다운로드
	function excelList()
	{
 		var f = document.frm;
		
		f.action = "./excel.do";
		f.id.value = reason;
		f.submit(); 
	}
	</c:if>
	//고객서비스 변경일 체크
	function chkPeriod()
	{
		jQuery("#myModal").modal("show");
	}
	<c:if test="${admLgnMap.authCd eq 99}">
	//엑셀 다운로드 (고객서비스 변경로그)
	function excelRcvModList()
	{
		var f = document.frm;
		
		f.action = "./rcv-excel.do";
		f.submit();
		
		jQuery("#myModal").modal("hide");
	}
	</c:if>
	
</script>