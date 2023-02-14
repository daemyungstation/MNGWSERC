<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%
	//시간 선택을 위한 select option 구성
	StringBuffer selectHh = new StringBuffer();

	String strHh = "";

	for(int i = 0; i < 24; i++)
	{
		if(i < 10)
		{
			strHh = "0" + i;
		}
		else
		{
			strHh = String.valueOf(i);
		}
		
		selectHh.append("<option value=\""+strHh+"\">"+strHh+"</option>\n");
	}
	
	//분 선택을 위한 select option 구성
	StringBuffer selectMi = new StringBuffer();
	
	String strMi = "";
	
	for(int i = 0; i < 60; i++)
	{
		if(i < 10)
		{
			strMi = "0" + i;
		}
		else
		{
			strMi = String.valueOf(i);
		}
		
		selectMi.append("<option value=\""+strMi+"\">"+strMi+"</option>\n");
	}
%>
<!-- 
	######################################################################
	파일명 		:	SMAPopWrite.jsp
	프로그램 명 : 	팝업 등록/수정을 한다.
	설명		: 	팝업 등록/수정을 하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<c:set var="popInfo" value="${rtnMap.popInfo}" />

<form name="frm" method="post" action="${egov:decode(popInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="popSeq" value="" />
	
	<table class="table table-bordered">
		<caption style="display:none;">팝업 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					* 팝업명
				</th>
				<td>
					<input type="text" name="popNm" value="${popInfo.popNm}" style="width:50%;" maxlength="250" required="팝업명을 입력해주세요" />
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 게시기간
				</th>
				<td>
					<div>
						<input type="text" id="ptupStrtDt" name="ptupStrtDt" class="datepicker_input input-small" value="${egov:convertDate(popInfo.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						<select id="ptupStrtHh" name="ptupStrtHh" style="min-width:50px;">
							<%=selectHh %>
						</select>
						<select id="ptupStrtMi" name="ptupStrtMi" style="min-width:50px;">
							<%=selectMi %>
						</select>
						&nbsp;~&nbsp; 
						<input type="text" id="ptupEndDt" name="ptupEndDt" class="datepicker_input input-small" value="${egov:convertDate(popInfo.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						<select id="ptupEndHh" name="ptupEndHh" style="min-width:50px;">
							<%=selectHh %>
						</select>
						<select id="ptupEndMi" name="ptupEndMi" style="min-width:50px;">
							<%=selectMi %>
						</select>
						<input type="checkbox" name="odtmYn" value="Y" style="margin-left:15px;" <c:if test="${popInfo.odtmYn eq 'Y'}">checked</c:if> onchange="setOdtmYn(this)"/> 상시여부
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 내용 (팝업 최적 사이즈는 1920 x 150 입니다)
				</th>
			</tr>
			<tr>
				<td colspan="2" style="vertical-align:middle;">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="cntn" name="cntn" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력해주세요.">${popInfo.cntn}</textarea>
					<script type="text/javascript">editorAdd("cntn");</script>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					이동 URL
				</th>
				<td>
					<input type="text" name="link" value="${popInfo.link}" style="width:50%;" maxlength="500" />
					<div style="margin-top:10px;">
						• ex) http://www.naver.com					
					</div>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 새창여부
				</th>
				<td>
					<c:set var="wndYn" value="${egov:nvl(popInfo.wndYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="wndYn" value="Y" <c:if test="${wndYn eq 'Y'}">checked</c:if>/> 새창 이동
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="wndYn" value="N" <c:if test="${wndYn eq 'N'}">checked</c:if>/> 현재창 이동
					</span>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 게시여부
				</th>
				<td>
					<c:set var="ptupYn" value="${egov:nvl(popInfo.ptupYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="ptupYn" value="Y" <c:if test="${ptupYn eq 'Y'}">checked</c:if>/> 게시
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="ptupYn" value="N" <c:if test="${ptupYn eq 'N'}">checked</c:if>/> 미게시
					</span>
				</td>
			</tr>
		</tbody>		
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty popInfo}">
			<a href="javascript:chkForm();" class="btn btn-success">등록</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
		</c:otherwise>
	</c:choose>
	<a href="javascript:cancelPop();" class="btn btn-default">취소</a>
</div>

<script type="text/javascript">

	jQuery(document).ready(function(){
		<c:if test="${not empty popInfo}">
		//게시 시작 시, 분 setting
		var ptupStrtHh = "${egov:convertDate(popInfo.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}";
		var ptupStrtMi = "${egov:convertDate(popInfo.ptupStrtDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}";
		
		jQuery("#ptupStrtHh option[value='"+ptupStrtHh+"']").prop("selected", true);
		jQuery("#ptupStrtMi option[value='"+ptupStrtMi+"']").prop("selected", true);
		
		//게시 종료 시, 분 setting
		var ptupEndHh = "${egov:convertDate(popInfo.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}";
		var ptupEndMi = "${egov:convertDate(popInfo.ptupEndDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}";
		
		jQuery("#ptupEndHh option[value='"+ptupEndHh+"']").prop("selected", true);
		jQuery("#ptupEndMi option[value='"+ptupEndMi+"']").prop("selected", true);
		</c:if>
		
		setOdtmYn(jQuery("input[name='odtmYn']"));
	});
	
	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!jQuery("input[name='popNm']").val())
		{
			alert("* 팝업명을 입력해 주세요.");
			jQuery("input[name='popNm']").focus();
			return;
		}
		
		if(!jQuery("input[name='odtmYn']").is(":checked"))
		{
			if(!jQuery("#ptupStrtDt").val())
			{
				alert("* 게시 시작일을 선택해 주세요.");
				jQuery("#ptupStrtDt").focus();
				return;
			}
			
			if(!jQuery("#ptupStrtHh").val())
			{
				alert("* 게시 시작시를 선택해 주세요.");
				jQuery("#ptupStrtHh").focus();
				return;
			}
			
			if(!jQuery("#ptupStrtMi").val())
			{
				alert("* 게시 시작분을 선택해 주세요.");
				jQuery("#ptupStrtMi").focus();
				return;
			}
			
			if(!jQuery("#ptupEndDt").val())
			{
				alert("* 게시 종료시을 선택해 주세요.");
				jQuery("#ptupEndDt").focus();
				return;
			}
			
			if(!jQuery("#ptupEndHh").val())
			{
				alert("* 게시 종료분을 선택해 주세요.");
				jQuery("#ptupEndHh").focus();
				return;
			}
			
			if(!jQuery("#ptupEndMi").val())
			{
				alert("* 게시 종료일을 선택해 주세요.");
				jQuery("#ptupEndMi").focus();
				return;
			}
			
			//시작일 종료일 유효성 체크
			var ptupStrtDtm = parseInt(jQuery("#ptupStrtDt").val().replace(/-/gi, "") + jQuery("#ptupStrtHh").val() + jQuery("#ptupStrtMi").val());
			var ptupEndDtm = parseInt(jQuery("#ptupEndDt").val().replace(/-/gi, "") + jQuery("#ptupEndHh").val() + jQuery("#ptupEndMi").val());

			if(ptupStrtDtm > ptupEndDtm)
			{
				alert("* 시작일이 종료일보다 클 수 없습니다.");
				return;
			}
		}
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty popInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.popSeq.value = "${popInfo.popSeq}";
			f.submit();		 
		}
	}
	
	//취소하기
	function cancelPop()
	{
		<c:choose>
			<c:when test="${empty popInfo}">
				location.href = "./list.do";	
			</c:when>
			<c:otherwise>
				var f = document.frm;	
				
				f.action = "./view.do";
				f.popSeq.value = "${popInfo.popSeq}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
	
	function setOdtmYn(obj)
	{
		if(jQuery(obj).is(":checked"))
		{
			jQuery(obj).siblings("input, select").val("");
			jQuery(obj).siblings("input, select").prop("disabled", true);
		}
		else
		{
			jQuery(obj).siblings("input, select").prop("disabled", false);
		}
	}
	
</script>