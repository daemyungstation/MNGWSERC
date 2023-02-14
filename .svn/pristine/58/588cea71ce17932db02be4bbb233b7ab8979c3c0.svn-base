<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMFAppynList.jsp
	프로그램 명 : 	확인요청 내역 목록을 조회한다.
	설명		: 	확인요청 내역 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		현황 : 
		<select name="appyn">
			<option value="">전체</option>
<%-- 			<option value="01" <c:if test="${rtnMap.appyn eq '01'}">selected</c:if>>승인</option> --%>
<%-- 			<option value="02" <c:if test="${rtnMap.appyn eq '02'}">selected</c:if>>거부</option>	 --%>
<%-- 			<option value="03" <c:if test="${rtnMap.appyn eq '03'}">selected</c:if>>대기</option> --%>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.appynStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.appyn eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>				
			</c:forEach>		
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>연락처</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>생년월일</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
</form>
	
<form name="frm1" >
	<table class="table table-bordered table-hover">
		<caption style="display: none;">확인요청 내역 관리</caption>
		<thead>
			<tr>
				<th width="3%"><input type="checkbox" name="all_check"/></th>
				<th width="15%">이름</th>
				<th width="10%">연락처</th>
				<th width="10%">생년월일</th>
				<th width="10%">사용자아이디</th>
				<th width="25%">이용사유</th>
				<th width="10%">현황</th>
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
					<td style="text-align:center; vertical-align:middle;">
						<input type="checkbox" name="delSeq" value="${list.id}" />
					</td>
					<td style="text-align:left; vertical-align:middle;">
						${list.name}
					</td>
					<td style="text-align:left; vertical-align:middle;">
						${list.tel}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${list.birth}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${list.id}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${list.reason}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						<select name="appyn" onchange="updateAppyn(this, '${list.id}', '${list.appyn}');">
							<option value="">선택하세요.</option>
							<c:forEach var="cdlist" items="${rtnMap.cdDtlList.appynStts}" varStatus="status">
								<option value="${cdlist.cd}" <c:if test="${list.appyn eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
							</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<!-- <DIV STYLE="FLOAT:LEFT;"> -->
<!-- 	<A HREF="JAVASCRIPT:DELETECHKREQNLIST();" CLASS="BTN BTN-DANGER">삭제</A> -->
<!-- </DIV> -->
<div style="float:right;">
	<select id="allAppyn" name="allAppyn">
		<c:forEach var="cdlist" items="${rtnMap.cdDtlList.appynStts}" varStatus="status">
			<option value="${cdlist.cd}">${cdlist.cdNm}</option>
		</c:forEach>
	</select> 
	<input type="button" value="현황변경" class="btn btn-primary"  onclick="changeAppyn()" />
</div>

</form>

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
		var f = document.frm;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}
		
		f.action = "./applist.do";
		f.submit();
	}
	
	//선택 삭제하기
	function deleteChkReqnList()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				var f = document.frm;
				
				f.action = "./appdelete.do";
				f.submit();
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
	//처리현황을 수정한다.
	function updateAppyn(obj, id, appyn)
	{
		if(confirm("현황을 변경하시겠습니까?"))
		{
			var f = document.frm1;
			
			jQuery.post("./prcs-update1.ajax",
				{
					"id" : id, 
					"appyn" : jQuery(obj).val() 
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
			jQuery(obj).find("option[value='"+appyn+"']").prop("selected", true);
		}
	}
	
	// 처리현황을 수정한다(선택한 데이터)
	function changeAppyn(){
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("현황을 변경하시겠습니까?")) 
			{
				
				$.ajax({
					type : 'post',
					url : './prcs-updateall.ajax',
					data : $('form[name=frm1]').serialize(),
					success : function(r){
						var status = r.status;
						if(status == "Y") 
						{
							alert("변경되었습니다.");
							window.location.reload(true);
						}
					}
				});
				
			}
		} 
		else 
		{
			alert("변경할 대상을 선택하세요.");
			return;
		}
	}	
	
</script>