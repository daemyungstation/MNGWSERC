<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMBChngDtlList.jsp
	프로그램 명 : 	전환서비스 상품내역 목록을 조회한다.
	설명		: 	전환서비스 상품내역 목록을 조회하는 페이지
	작성자		: 	김대환
	작성일		:	2016.02.19
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.19				김대환				최초작성
	######################################################################
-->

<form id="frm" name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="prdctDtlSeq" value="" />
	<input type="hidden" name="useYn" value="" />
	
	<div class="well well-small">
		구분 : 
		<select name="prdctCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.prdctGb}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prdctCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>작성자</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>상품명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">전환서비스 상품내역 관리</caption>
		<thead>
			<tr>
				<th width="3%"><input type="checkbox" name="all_check"/></th>
				<th width="5%">번호</th>
				<th width="8%">상품구분</th>
				<th width="24%">상품제목</th>
				<th width="14%">신청기간</th>
				<th width="18%">일정</th>
				<th width="12%">작성자</th>
				<th width="10%">작성일</th>
				<th width="6%">노출여부</th>
			</tr>
		</thead>
		<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="9" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delSeq" value="${list.prdctDtlSeq}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>					
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${list.prdctGb}					
					</td>
					<td style="text-align:left; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${list.prdctTitl}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						<c:choose>
							<c:when test="${list.odtmYn eq 'Y'}">
								상시
							</c:when>
							<c:when test="${list.odtmYn eq 'N'}">
								${egov:convertDate(list.rqstStrtDt,'yyyyMMdd','yyyy-MM-dd','')}
								&nbsp;~&nbsp;
								${egov:convertDate(list.rqstEndDt,'yyyyMMdd','yyyy-MM-dd','')}
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose> 
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${egov:tldCutString(list.schd, '...', 18)}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${list.regId}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="selectChngDtl('${list.prdctDtlSeq}');">
						${list.useYn}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<button type="button" class="btn btn-danger" onclick="deleteChngDtlList()">삭제</button>
	<button type="button" class="btn btn-info" onclick="insertChngDtlCopy()">복사</button>
	<button type="button" class="btn btn-default" onclick="blindChngDtlList(true)">블라인드 설정</button>
	<button type="button" class="btn btn-default" onclick="blindChngDtlList(false)">블라인드 해제</button>
</div>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
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
	jQuery(document).ready(function()
	{
		//삭제 체크박스 전체 선택 & 해제
		jQuery("input:checkbox[name='all_check']").click(function()
		{
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
		jQuery("input:checkbox[name='delSeq']").click(function()
		{
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
	function selectChngDtl(prdctDtlSeq)
	{
		var f = document.frm;	
		
		f.action = "./view.do";
		f.prdctDtlSeq.value = prdctDtlSeq;
		f.submit();
	}
	
	//선택 삭제하기
	function deleteChngDtlList()
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
	function insertChngDtlCopy()
	{
		var chkCnt = jQuery("input:checkbox[name='delSeq']:checked").length;
		
		if(chkCnt > 0)
		{
			if(chkCnt == 1)
			{
				if(confirm("복사 하시겠습니까?"))
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

	//선택 블라인드
	function blindChngDtlList(blind)
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			var msg = "";
			
			if(blind)
			{
				msg = "블라인드 처리하겠습니까?";
			}
			else
			{
				msg = "블라인드 해제하겠습니까?";
			}
			
			if(confirm(msg)) 
			{
				jQuery("input[name='useYn']").val(blind ? "N" : "Y")
				
				jQuery.post("./blind.ajax", jQuery("#frm").serialize(),
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
		} 
		else 
		{
			alert("블라인드 대상을 선택하세요.");
			return;
		}
	}

</script>
