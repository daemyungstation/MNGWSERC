<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMDMbspCardList.jsp
	프로그램 명 : 	멤버십카드 신청내역 목록을 조회한다.
	설명		: 	멤버십카드 신청내역 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11	
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.11		    	허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="rqstSeq" value="" />
	
	<div class="well well-small">
		현황 : 
		<select name="prcsCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
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
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>회원번호</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">멤버십카드 신청내역</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th width="6%">번호</th>
				<th width="15%">회원명</th>
				<th width="15%">아이디</th>
				<th width="13%">회원번호</th>
				<th width="11%">전화번호</th>
				<th width="9%">신청일</th>
				<th width="9%">접수일</th>
				<th width="9%">완료일</th>
				<th width="8%">현황</th>
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
	 				<td style="text-align:center;">
						<input type="checkbox" name="trgtSeq" value="${list.rqstSeq}" />
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${list.name}
					</td>
					<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${list.id}
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${list.accntNo}
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${list.hp}
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${egov:nvl(egov:convertDate(list.acptDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '-')}
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selectMbspCardDtl('${list.rqstSeq}');">
						${egov:nvl(egov:convertDate(list.compDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '-')}
					</td>
					<td style="text-align:center; cursor:pointer; vertical-align:middle;">
						<%-- 
						<select name="prscCd" onchange="updatePrcsCd(this, '${list.rqstSeq}', '${list.prcsCd}');">
							<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
								<option value="${cdlist.cd}" <c:if test="${list.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
							</c:forEach>
						</select>
						--%>
						${list.prcsNm}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:selectMbspCardExcelList();" class="btn btn-info">엑셀 다운로드</a>
</div>

<div style="float:right;">
	<c:if test="${rtnMap.prcsCd eq '01'}">
		<a href="javascript:updatePrcsCdAll('02');" class="btn btn-success">일괄 접수</a>
	</c:if>
	<c:if test="${rtnMap.prcsCd eq '02'}">
		<a href="javascript:updatePrcsCdAll('03');" class="btn btn-success">일괄 완료</a>
	</c:if>
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
				jQuery("input:checkbox[name='trgtSeq']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='trgtSeq']").prop("checked", false);
			}	
		});
		
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='trgtSeq']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='trgtSeq']").length;
			var selChkCnt = jQuery("input:checkbox[name='trgtSeq']:checked").length;
			
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
	function selectMbspCardDtl(rqstSeq)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.rqstSeq.value = rqstSeq;
		f.submit();
	}
	
	//처리현황을 수정한다.
	function updatePrcsCd(obj, rqstSeq, prcsCd)
	{
		if(confirm("현황을 변경하시겠습니까?"))
		{
			jQuery.post("./prcs-update.ajax",
				{
					"rqstSeq" : rqstSeq, 
					"prcsCd" : jQuery(obj).val() 
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
			jQuery(obj).find("option[value='"+prcsCd+"']").prop("selected", true);
		}
	}
	
	//처리현황을 일괄 적용한다.
	function updatePrcsCdAll(prcsCd)
	{
		if(jQuery("input:checkbox[name='trgtSeq']:checked").length > 0)
		{
			if(confirm("현황을 일괄 변경하시겠습니까?"))
			{
				startProgress(jQuery(".container-fluid"), jQuery("#progDiv"));

				var trgtSeqArr = new Array();
				
				jQuery("input:checkbox[name='trgtSeq']:checked").each(function(){
					trgtSeqArr.push(jQuery(this).val());
				});
				
				jQuery.post("./prcsAll-update.ajax",
					{
						"prcsCd" : prcsCd,
						"trgtSeqArr" : trgtSeqArr.join()
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
				
				endProgress(jQuery(".container-fluid"), jQuery("#progDiv"));
			}
		} 
		else 
		{
			alert("적용할 대상을 선택하세요.");
			return;
		}
	}
	
	//엑셀 다운로드
	function selectMbspCardExcelList()
	{
		var f = document.frm;
		
		f.action = "./excel.do";
		f.submit();
	}

</script>