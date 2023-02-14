<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.util.List"%>
<%@page import="emf.core.vo.EmfMap"%>
<%@page import="emf.core.util.EMFStringUtil"%>
<%
	EmfMap emfMap = (EmfMap) request.getAttribute("rtnMap");

	List<EmfMap> chngSysGrpDtl = (List<EmfMap>) emfMap.get("chngSysGrpDtl");

	/* ------------------------------ 체계 그룹 상세 td setting start ------------------------------*/
	
	StringBuffer chngSysGrpDtlSb = new StringBuffer();
	
	EmfMap tmpMap = null;

	if(chngSysGrpDtl != null && chngSysGrpDtl.size() > 0)
	{
		for(int i = 0; i < chngSysGrpDtl.size(); i++)
		{
			tmpMap = chngSysGrpDtl.get(i);
			
			if(!"".equals(EMFStringUtil.nullConvert(tmpMap.getString("prdctNm"))))
			{
				chngSysGrpDtlSb.append("<td style='text-align:center; vertical-align:middle; cursor:pointer;'>" + tmpMap.getString("prdctNm") + "</td>");
			}
			else
			{
				chngSysGrpDtlSb.append("<td style='text-align:center; vertical-align:middle; cursor:pointer;'>-</td>");
			}
		}
	}
	
	/* ------------------------------  체계 그룹 상세 td setting end  ------------------------------*/
%>
<!--   
	######################################################################
	파일명 		:	CMBChngSysPrdctList.jsp
	프로그램 명 : 	전환서비스 쳬계 그룹 상품 목록을 조회한다.
	설명		: 	전환서비스 쳬계 그룹 상품 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.18
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.18				허진영				최초작성
	######################################################################
-->

<c:set var="prdctGbLen" value="${fn:length(rtnMap.cdDtlList.prdctGb)}"/>

<form name="frm" method="post" action ="./prdct-list.do">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="grpSeq" value="${rtnMap.grpSeq}" />
	
	<div class="well well-small">
		그룹명
		<input type="text" name="grpNm" value="${rtnMap.pGrpNm}" class="inputType" maxlength="15" />
		<a href="javascript:updateChngSysGrpNm('${rtnMap.grpSeq}');" class="btn ">수정</a>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>상품명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="javascript:getPageList('all');" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	<div style="width:100%; overflow-x:auto; font-size:13px;">
		<table class="table table-bordered table-hover">
			<caption style="display: none;">전환서비스 체계 관리</caption>
			<thead>
				<tr>
					<th width="3%"><input type="checkbox" name="all_check"/></th>
					<th width="5%">번호</th>
					<th width="5%">코드</th>
					<th width="14%">상품명</th>
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.prdctGb}" varStatus="status">
						<th width="<fmt:parseNumber value='${73 / prdctGbLen}' integerOnly='true' />%">${cdlist.cdNm}</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody id="chngSysTbody">
				<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
				<c:if test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="${4 + prdctGbLen}" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:if>
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
					<tr>
						<td style="text-align:center;">
							<input type="checkbox" name="delSeq" value="${list.grpPrdctSeq}" />
						</td>
						<td style="text-align:center; vertical-align:middle; cursor:pointer;">
							${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
						</td>
						<td style="text-align:center; vertical-align:middle; cursor:pointer;">
							${list.outPrdctCd}
						</td>
						<td style="text-align:left; vertical-align:middle; cursor:pointer;">
							${list.outPrdctNm}
						</td>
						<%=chngSysGrpDtlSb %>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>

<div style="float:left;">
	<a href="javascript:deleteChngSysGrpPrdctList();" class="btn btn-danger">삭제</a>
	<a href="javascript:selectChngSysPrdctExcelList();" class="btn btn-info">엑셀 다운로드</a>
</div>

<div style="float:right;">
	<a href="javascript:getChngSysOutPrdctList();" class="btn btn-success">등록</a>
	<a href="./list.do" class="btn btn-default">취소</a>
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
		var f = document.frm;
		
		if(arguments.length > 0)
		{
			if(arguments[0] == "all")
			{
				f.q.value = "";
			}
			else
			{
				f.pageIndex.value = arguments[0];
			}
		}
		else
		{
			f.pageIndex.value = 1;
		}
		
		f.action = "./prdct-list.do";
		f.submit();
	}
	
	//외부상품(엔컴) 목록을 가져온다.
	function getChngSysOutPrdctList()
	{
		setPopup("./outPrdct-list.do", "outPrdct", 600, 700);
	}
	
	//그룹명을 수정한다.
	function updateChngSysGrpNm(grpSeq)
	{
		var grpNm = (jQuery("input[name='grpNm']").val()).trim();
		
		if(!grpNm)
		{
			alert("* 그룹명을 입력해주세요.");
			return;
		}
		
		jQuery.post("./grpNm-chk.ajax", 
			{
				"grpNm" : grpNm
			},
			function(r)
			{
				var exstCnt = r.exstCnt;
				
				if(exstCnt > 0)
				{
					alert("이미 등록된 그룹명입니다.");
				}
				else
				{
					if(confirm("수정하시겠습니까?"))
					{
						jQuery.post("./grpNm-update.ajax", 
							{
								"grpSeq" : grpSeq,
								"grpNm" : grpNm
							},
							function(r)
							{
								var status = r.status;
								
								if(status == "Y")
								{
									alert("수정되었습니다.");
								}
							}
						).fail(function(){
							alert("잠시후 다시 시도 바랍니다.");
						});
					}
				}
			}
		).fail(function(){
			alert("잠시후 다시 시도 바랍니다.");
		});
	}
	
	//선택 삭제하기
	function deleteChngSysGrpPrdctList()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				jQuery.post("./prdct-delete.ajax", jQuery("form[name='frm']").serialize(),
					function(r)
					{
						var status = r.status;
						
						if(status == "Y")
						{
							window.location.reload();
						}
					}
				).fail(function(){
					alert("잠시후 다시 시도 바랍니다.");
				});
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
	function selectChngSysPrdctExcelList()
	{
		var f = document.frm;
		
		f.action = "./prdct-excel.do";
		f.submit();
	}
	
</script>