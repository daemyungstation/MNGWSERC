<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<%
	//시간 선택을 위한 select option 구성
	StringBuffer selectHh = new StringBuffer();
	String strHh = "";

	for (int i = 0; i < 24; i++) {
		if (i < 10) {
			strHh = "0" + i;
		} else {
			strHh = String.valueOf(i);
		}
		selectHh.append("<option value=\""+strHh+"\">"+strHh+"</option>\n");
	}
	
	//분 선택을 위한 select option 구성
	StringBuffer selectMi = new StringBuffer();
	String strMi = "";
	
	for (int i = 0; i < 60; i++) {
		if (i < 10) {
			strMi = "0" + i;
		} else {
			strMi = String.valueOf(i);
		}
		selectMi.append("<option value=\""+strMi+"\">"+strMi+"</option>\n");
	}
%>

<c:set var="popInfo" value="${rtnMap.popInfo}" />

<form name="frm" method="post" action="${egov:decode(popInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="idx" value="" />
	
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
					<input type="text" name="name" value="${popInfo.name}" style="width:50%;" maxlength="250" required="팝업명을 입력해주세요" />
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 게시기간
				</th>
				<td>
					<div>
						<input type="text" id="ptupStrtDt" name="startDtm" class="datepicker_input input-small" value="${egov:convertDate(popInfo.startDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						<select id="ptupStrtHh" name="ptupStrtHh" style="min-width:50px;">
							<%=selectHh %>
						</select>
						<select id="ptupStrtMi" name="ptupStrtMi" style="min-width:50px;">
							<%=selectMi %>
						</select>
						&nbsp;~&nbsp; 
						<input type="text" id="ptupEndDt" name="endDtm" class="datepicker_input input-small" value="${egov:convertDate(popInfo.endDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
						<select id="ptupEndHh" name="ptupEndHh" style="min-width:50px;">
							<%=selectHh %>
						</select>
						<select id="ptupEndMi" name="ptupEndMi" style="min-width:50px;">
							<%=selectMi %>
						</select>
						<input type="checkbox" name="alwaysYn" style="margin-left:15px;" value="${popInfo.alwaysYn eq 'Y' ? popInfo.alwaysYn : 'N'}"
							   <c:if test="${popInfo.alwaysYn eq 'Y'}">checked</c:if> onchange="setAlwaysYn(this)"/> 상시여부
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="2" style="vertical-align:middle;">
					* 내용 (팝업의 경우는 1개만 노출이 가능하며, 등록된 팝업의 게시여부 값이 Y가 2개 이상인 경우 최근등록된 게시글의 팝업이 노출됩니다.)
				</th>
			</tr>
			<tr>
				<td colspan="2" style="vertical-align:middle;">
					<script type="text/javascript" src="/egov/seditor/editor_add.js"></script>
					<textarea id="cntn" name="cntn" rows="20" style="display:none; width:98%;" exec="editorSync(this.id)" required="내용을 입력해주세요.">${popInfo.cntn}</textarea>
					<script type="text/javascript">editorAdd("cntn");</script>
				</td>				
			</tr>
			<%--<tr>
				<th style="vertical-align:middle;">
					이동 URL
				</th>
				<td>
					<input type="text" name="link" value="${popInfo.link}" style="width:50%;" maxlength="500" />
					<div style="margin-top:10px;">
						• ex) http://www.naver.com					
					</div>
				</td>				
			</tr>--%>
			<tr>
				<th style="vertical-align:middle;">
					* 타입
				</th>
				<td>
					<c:set var="type" value="${egov:nvl(popInfo.type, 'W')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="type" value="W" <c:if test="${type eq 'W'}">checked</c:if>/> 팝업
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="type" value="L" <c:if test="${type eq 'L'}">checked</c:if>/> 레이어
					</span>
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 게시여부
				</th>
				<td>
					<c:set var="postYn" value="${egov:nvl(popInfo.postYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="postYn" value="Y" <c:if test="${postYn eq 'Y'}">checked</c:if>/> 게시
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="postYn" value="N" <c:if test="${postYn eq 'N'}">checked</c:if>/> 미게시
					</span>
				</td>
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					* 오늘그만보기여부
				</th>
				<td>
					<c:set var="todayYn" value="${egov:nvl(popInfo.todayYn, 'N')}" />
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="todayYn" value="Y" <c:if test="${todayYn eq 'Y'}" >checked</c:if>/> 활성
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="radio" name="todayYn" value="N" <c:if test="${todayYn eq 'N'}">checked</c:if>/> 비활성
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
		<c:if test="${not empty popInfo and popInfo.alwaysYn eq 'N'}">
		//게시 시작 시, 분 setting
		var ptupStrtHh = "${egov:convertDate(popInfo.startDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}";
		var ptupStrtMi = "${egov:convertDate(popInfo.startDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}";
		
		jQuery("#ptupStrtHh option[value='"+ptupStrtHh+"']").prop("selected", true);
		jQuery("#ptupStrtMi option[value='"+ptupStrtMi+"']").prop("selected", true);
		
		//게시 종료 시, 분 setting
		var ptupEndHh = "${egov:convertDate(popInfo.endDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}";
		var ptupEndMi = "${egov:convertDate(popInfo.endDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}";
		
		jQuery("#ptupEndHh option[value='"+ptupEndHh+"']").prop("selected", true);
		jQuery("#ptupEndMi option[value='"+ptupEndMi+"']").prop("selected", true);
		</c:if>
		
		setAlwaysYn(jQuery("input[name='alwaysYn']"));
	});
	
	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!jQuery("input[name='name']").val())
		{
			alert("* 팝업명을 입력해 주세요.");
			jQuery("input[name='name']").focus();
			return;
		}
		
		if(!jQuery("input[name='alwaysYn']").is(":checked"))
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
		
		if (!validate(f)) return;

		var msg = "";
		
		<c:choose>
			<c:when test="${empty popInfo}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if (confirm(msg)) {
			console.log(f.alwaysYn.value)
			f.idx.value = "${popInfo.idx}";
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
				f.idx.value = "${popInfo.idx}";
				f.submit();
			</c:otherwise>
		</c:choose>
	}
	
	function setAlwaysYn(obj) {
		if (jQuery(obj).is(":checked")) {
			jQuery(obj).siblings("input, select").val("");
			jQuery(obj).siblings("input, select").prop("disabled", true);
			obj.value = 'Y';
		} else {
			jQuery(obj).siblings("input, select").prop("disabled", false);
			obj.value = 'N';
		}
	}
	
</script>