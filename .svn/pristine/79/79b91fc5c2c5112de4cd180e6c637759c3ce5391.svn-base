<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%@page import="java.util.ArrayList"%>
<%@page import="emf.core.vo.EmfMap"%>
<%@page import="emf.core.util.EMFStringUtil"%>
<%
	EmfMap emfMap = (EmfMap) request.getAttribute("rtnMap");

	EmfMap cdDtlMap = (EmfMap) emfMap.get("cdDtlList");
	
	
	/* ------------------------------ 상품구분 select setting start ------------------------------ */
	
	ArrayList<EmfMap> prdctArr = (ArrayList<EmfMap>) cdDtlMap.get("prdctGb");

	String prdctCd = "";
	
	ArrayList<EmfMap> tmpArr = null;
	
	StringBuffer prdctSb;
	
	ArrayList<Object> selectPrdcts = new ArrayList<Object>();
	
	if(prdctArr != null && prdctArr.size() > 0)
	{
		for(int i = 0; i < prdctArr.size(); i++)
		{
			prdctCd = EMFStringUtil.lowerCase(prdctArr.get(i).getString("cd"));
	
			if(emfMap.get(prdctCd) != null)
			{
				tmpArr = (ArrayList<EmfMap>) emfMap.get(prdctCd);
						
				prdctSb = new StringBuffer();
	
				for(int j = 0; j < tmpArr.size(); j++)
				{
					prdctSb.append("<option value='" + tmpArr.get(j).getString("prdctSeq") + "'>" + tmpArr.get(j).getString("prdctNm") + "</option>");
				}
	
				selectPrdcts.add(prdctSb);
			}
			else
			{
				selectPrdcts.add(null);
			}
		}
	}
	
	/* ------------------------------  상품구분 select setting end  ------------------------------ */
%>
<!--   
	######################################################################
	파일명 		:	CMBChngSysList.jsp
	프로그램 명 : 	전환서비스 쳬계 그룹 목록을 조회한다.
	설명		: 	전환서비스 쳬계 그룹 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.17
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.17				허진영				최초작성
	######################################################################
-->

<c:set var="prdctGbLen" value="${fn:length(rtnMap.cdDtlList.prdctGb)}"/>

<c:set var="rnum" value="0" />

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="grpSeq" value="" />
	<input type="hidden" name="pGrpNm" value="" />

	<div class="well well-small">
		그룹등록
		<input type="text" name="grpNm" value="" class="inputType" maxlength="15" />
		<a href="javascript:insertChngSysGrp();" class="btn ">등록</a>
	</div>
	
	<div style="width:100%; overflow-x:auto; font-size:13px;">
		<table class="table table-bordered table-hover">
			<caption style="display: none;">전환서비스 체계 관리</caption>
			<thead>
				<tr>
					<th width="5%">번호</th>
					<th width="7%">그룹명</th>
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.prdctGb}" varStatus="status">
						<th width="<fmt:parseNumber value='${73 / prdctGbLen}' integerOnly='true' />%">${cdlist.cdNm}</th>
					</c:forEach>
					<th width="15%" colspan="3">-</th>
				</tr>
			</thead>
			<tbody id="chngSysTbody">
				<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
				<c:if test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="${5 + prdctGbLen}" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:if>
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
					<c:if test="${status.index % prdctGbLen eq 0}">
						<c:set var="rnum" value="${rnum + 1}" />
						<tr>
							<td style="text-align:center; vertical-align:middle; cursor:pointer;">
								<fmt:parseNumber value="${fn:length(rtnMap.list) / prdctGbLen - rnum + 1}" integerOnly="true" />
							</td>
							<td style="text-align:left; vertical-align:middle; cursor:pointer;">
								<font style="font-weight:bold;">${list.grpNm}</font> 
								<span>(${list.prdctCnt})</span>
							</td>
					</c:if>
							<td style="text-align:center; vertical-align:middle;">
								<select name="${list.prdctCd}" style="min-width:100%; font-size:12px;">
									<option value="">선택</option>
								</select>
							</td>
					<c:if test="${status.count % prdctGbLen eq 0}">
							<td style="text-align:center; vertical-align:middle;">
								<a href="javascript:" class="btn btn-danger" style="padding:3px 10px; font-size:12px;" onclick="deleteChngSysGrp('${list.grpSeq}', this);">삭제</a>
							</td>
							<td style="text-align:center; vertical-align:middle;">
								<a href="javascript:" class="btn btn-success" style="padding:3px 10px; font-size:12px;" onclick="updateChngSysGrp('${list.grpSeq}', this);">적용</a>
							</td>
							<td style="text-align:center; vertical-align:middle;">
								<a href="javascript:" class="btn btn-warning" style="padding:3px 10px; font-size:12px;" onclick="selectChngSysPrdctList('${list.grpSeq}', this);">관리</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>
	
<script type="text/javascript">

	jQuery(document).ready(function(){
		//상품 selectbox setting
		<% 
			if(prdctArr != null && prdctArr.size() > 0)
			{
				for(int k = 0; k < prdctArr.size(); k++) 
				{
					if(emfMap.get(EMFStringUtil.lowerCase(prdctArr.get(k).getString("cd"))) != null)
					{
		%>
	
		jQuery("select[name='<%=prdctArr.get(k).getString("cd") %>']").append("<%=selectPrdcts.get(k) %>");
	
		<% 
					}
				}
			} 
		%>
		
		//상품 selected setting
		<c:forEach var="prdctlist" items="${rtnMap.list}" varStatus="status">
		
		jQuery("#chngSysTbody tr:eq(<fmt:parseNumber value='${status.index / prdctGbLen}' integerOnly='true' />) select:eq(${status.index % prdctGbLen})").find("option[value='${prdctlist.prdctSeq}']").prop("selected", true);
		
		</c:forEach>
	});
	
	//그룹 체계를 등록한다.
	function insertChngSysGrp()
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
					if(confirm("등록하시겠습니까?"))
					{
						jQuery.post("./insert.ajax", 
							{
								"grpNm" : grpNm
							},
							function(r)
							{
								var grpSeq = r.grpSeq;
								
								if(grpSeq > -1)
								{
									var totCnt = jQuery("#chngSysTbody td.lt_text3").length;

									if(totCnt > 0)
									{
										window.location.reload();
									}
									else
									{
										jQuery("#chngSysTbody").prepend(jQuery("#chngSysTbody tr:eq(0)").clone(true));
										
										//번호 setting
										jQuery("#chngSysTbody tr:eq(0)").find("td:eq(0)").text(parseInt(jQuery("#chngSysTbody tr:eq(1)").find("td:eq(0)").text()) + 1);
										
										//그룹명 setting
										jQuery("#chngSysTbody tr:eq(0)").find("td:eq(1) font").text(grpNm);
										jQuery("#chngSysTbody tr:eq(0)").find("td:eq(1) span").text("(0)");
										
										//selected init
										jQuery("#chngSysTbody tr:eq(0)").find("select option:eq(0)").prop("selected", true);
										
										//그룹명 init
										jQuery("input[name='grpNm']").val("");
										
										//이벤트 setting
										jQuery("#chngSysTbody tr:eq(0)").find(".btn").removeAttr("onclick");
										jQuery("#chngSysTbody tr:eq(0)").find(".btn-danger").attr("onclick", "deleteChngSysGrp('" + grpSeq + "', this);");
										jQuery("#chngSysTbody tr:eq(0)").find(".btn-success").attr("onclick", "updateChngSysGrp('" + grpSeq + "', this);");
										jQuery("#chngSysTbody tr:eq(0)").find(".btn-warning").attr("onclick", "selectChngSysPrdctList('" + grpSeq + "', this)");
									}
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
	
	//그룹 쳬계를 수정한다.
	function updateChngSysGrp(grpSeq, obj)
	{
		if(confirm("적용하시겠습니까?"))
		{
			//전환서비스 체계 Data Setting
			var prdctCdArr = new Array();
			var prdctSeqArr = new Array();
			
			jQuery(obj).closest("tr").find("select").each(function(){
				prdctCdArr.push(jQuery(this).attr("name"));
				prdctSeqArr.push(jQuery(this).val());
			});
			
			jQuery.post("/mngwserc/cmb/sys/update.ajax",
				{
					"grpSeq" : grpSeq,
					"prdctCdArr" : prdctCdArr.join(),
					"prdctSeqArr" : prdctSeqArr.join()
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y")
					{
						alert("적용되었습니다.");
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	//그룹 체계를 삭제한다.
	function deleteChngSysGrp(grpSeq, obj)
	{
		if(confirm("삭제하시겠습니까?"))
		{
			jQuery.post("/mngwserc/cmb/sys/delete.ajax", 
				{
					"grpSeq" : grpSeq
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y")
					{
						//번호 setting
						for(var i = 0; i < jQuery("#chngSysTbody tr").index(jQuery(obj).closest("tr")); i++)
						{
							jQuery("#chngSysTbody tr:eq("+i+")").find("td:eq(0)").text(parseInt(jQuery("#chngSysTbody tr:eq("+i+")").find("td:eq(0)").text()) - 1);
						}
						
						if(jQuery("#chngSysTbody tr").length == 1)
						{
							window.location.reload();
						}
						else
						{
							jQuery(obj).closest("tr").remove();
						}
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
	
	//그룹 체계 관리를 한다.
	function selectChngSysPrdctList(grpSeq, obj)
	{
		var f = document.frm;

		f.action = "./prdct-list.do";
		f.grpSeq.value = grpSeq;
		f.pGrpNm.value = jQuery(obj).closest("tr").find("td:eq(1) font").text();
		f.submit();
	}
	
</script>