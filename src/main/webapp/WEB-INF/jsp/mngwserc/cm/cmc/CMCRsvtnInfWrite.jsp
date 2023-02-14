<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMCPfmcInfoWrite.jsp
	프로그램 명 : 	공연예약정보를 조회한다.
	설명		: 	공연예약정보를 관리하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.15
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.15				허진영				최초작성
	######################################################################
-->
<style type="text/css">
    .dtmBox {
		display: inline-block;
		width: 205px;
      	padding: 5px;
      	margin-top: 10px;
      	margin-right: 10px;
      	background-color: #fff;
      	border: 1px solid #ccc;
      	-webkit-border-radius: 5px;
	    -moz-border-radius: 5px;
        border-radius: 5px;
      	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
        -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
       	box-shadow: 0 1px 2px rgba(0,0,0,.05);
    }
</style>
 
<c:set var="pfmcInfo" value="${rtnMap.pfmcInfo}" />

<form name="listFrm" method="post" action="./list.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="pfmcGb" value="${sPfmcGb}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form id="frm" method="post">
	<input type="hidden" name="pfmcSeq" value="${pfmcInfo.pfmcSeq}" />
	
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="sPfmcGb" value="${sPfmcGb}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	
	<table class="table table-bordered">
		<caption style="display: none;">공연예약정보 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="vertical-align:middle;">
					공연명
				</th>
				<td>
					${pfmcInfo.pfmcNm}
				</td>				
			</tr>
			<tr>
				<th style="vertical-align:middle;">
					공연기간
				</th>
				<td>
					${egov:convertDate(pfmcInfo.pfmcStrtDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}(${pfmcInfo.pfmcStrtDay})
					~ 
					${egov:convertDate(pfmcInfo.pfmcEndDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}(${pfmcInfo.pfmcEndDay})
				</td>			
			<tr>
			<tr>
				<th style="vertical-align:middle;">
					티켓정가
				</th>
				<td>
					${pfmcInfo.tcktPrc}
				</td>			
			<tr>
		</tbody>		
	</table>
	
	<h5>● 예약정보 등록</h5>
	
	<table class="table table-bordered">
		<caption style="display: none;">공연예약정보 관리</caption>
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center;vertical-align:middle;">관람좌석</th>
				<td>
					<span style="display:inline-block; width:100px;">
						<input type="checkbox" name="seatRUseYn" value="Y" <c:if test="${pfmcInfo.seatRUseYn eq 'Y'}">checked</c:if>/> R석
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="checkbox" name="seatSUseYn" value="Y" <c:if test="${pfmcInfo.seatSUseYn eq 'Y'}">checked</c:if>/> S석
					</span>
					<span style="display:inline-block; width:100px;">
						<input type="checkbox" name="seatAUseYn" value="Y" <c:if test="${pfmcInfo.seatAUseYn eq 'Y'}">checked</c:if>/> A석
					</span>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">예약일시</th>
				<td>
					<div class="input-append" style="margin-bottom:0px;">
						<input type="text" id="rsvtnDt" name="rsvtnDt" value="" class="datepicker_input input-small" style="width:100px; text-align:center;" readonly="readonly" />
						<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
					</div>
					<select id="rsvtnHh" name="rsvtnHh" style="min-width:65px;">
						<option value="">선택</option>
						<c:forEach var="i" begin="0" end="23" step="1">
							<c:choose>
								<c:when test="${i < 10}">
									<option value="0${i}">0${i}</option>
								</c:when>
								<c:otherwise>
									<option value="${i}">${i}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<select id="rsvtnMi" name="rsvtnMi" style="min-width:65px;">
						<option value="">선택</option>
						<c:forEach var="i" begin="0" end="59" step="1">
							<c:choose>
								<c:when test="${i < 10}">
									<option value="0${i}">0${i}</option>
								</c:when>
								<c:otherwise>
									<option value="${i}">${i}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<a href="javascript:setRsvtnDtm();" class="btn btn-primary" style="margin-left:10px">
						추가
					</a>
				</td>			
			<tr>
		</tbody>		
	</table>
	
	<div id="rsvtnDtmArea" style="margin-top:-10px;">
		<c:forEach var="list" items="${rtnMap.rsvtnDtmList}" varStatus="status">
			<span class="dtmBox">
				${egov:convertDate(list.rsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy', '')}년 
				${egov:convertDate(list.rsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'MM', '')}월
				${egov:convertDate(list.rsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'dd', '')}일
				${egov:convertDate(list.rsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'HH', '')}시
				${egov:convertDate(list.rsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'mm', '')}분
				<input type="hidden" name="rsvtnDtm" value="${egov:convertDate(list.rsvtnDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyyMMddHHmm', '')}" />
				<a href="javascript:" onclick="jQuery(this).closest('span').remove();"><i class="icon-ban-circle" style="margin-top:3px;"></i></a>
			</span>
		</c:forEach>
	</div>
</form>

<div style="margin-top:20px;">
	<div style="text-align:right;">
		<a href="javascript:chkForm();" class="btn btn-success">확인</a>
		<a href="javascript:document.listFrm.submit()" class="btn btn-default">취소</a>
	</div>
</div>

<script type="text/javascript">
	
	//예약일시 추가
	function setRsvtnDtm()
	{
		var rsvtnDt = jQuery("#rsvtnDt").val().replace(/-/gi, "");
		var rsvtnHh = jQuery("#rsvtnHh").val();
		var rsvtnMi = jQuery("#rsvtnMi").val();
		var rsvtnDtm = "";
		
		if(!rsvtnDt)
		{
			alert("* 예약일을 선택해 주세요.");
			jQuery("#rsvtnDt").focus();
			return;
		}
		else if(rsvtnDt < parseInt("${pfmcInfo.pfmcStrtDt}") || rsvtnDt > parseInt("${pfmcInfo.pfmcEndDt}"))
		{
			alert("* 공연기간내에 선택해 주세요.");
			jQuery("#rsvtnDt").focus();
			return;
		}
		else if(!rsvtnHh)
		{
			alert("* 예약시간(시)을 선택해 주세요.");
			jQuery("#rsvtnHh").focus();
			return;
		}
		else if(!rsvtnMi)
		{
			alert("* 예약시간(분)을 선택해 주세요.");
			jQuery("#rsvtnMi").focus();
			return;
		}
		else
		{
			rsvtnDtm = rsvtnDt + rsvtnHh + rsvtnMi;
		}
		
		var isExst = false;
		
		jQuery("#rsvtnDtmArea").find("input[name='rsvtnDtm']").each(function(){
			
			if(rsvtnDtm == jQuery(this).val())
			{
				isExst = true;
				return false;
			}
		});
		
		if(isExst)
		{
			alert("이미 존재하는 예약일시입니다.");
			return;
		}
		
		var htmlSrc  = "";
			htmlSrc += "<span class=\"dtmBox\">\n";
			htmlSrc += "	" + rsvtnDt.substring(0, 4) + "년 " + rsvtnDt.substring(4, 6) + "월 "+ rsvtnDt.substring(6, 8) + "일 " + rsvtnHh + "시 " + rsvtnMi +"분" + "\n";
			htmlSrc += "	<input type=\"hidden\" name=\"rsvtnDtm\" value=\"" + rsvtnDtm + "\" />\n";
			htmlSrc += "	<a href=\"javascript:\" onclick=\"jQuery(this).closest('span').remove();\"><i class=\"icon-ban-circle\" style=\"margin-top:3px;\"></i></a>\n";
			htmlSrc += "</span>\n";
			
		jQuery("#rsvtnDtmArea").append(htmlSrc);
	}
	
	//유효성 체크
	function chkForm()
	{
		var seatCnt = jQuery("input[name^='seat']:checked").length;
		
		if(seatCnt == 0)
		{
			alert("* 관람좌석을 선택해주세요.");
			jQuery("input[name='seatRUseYn']").focus();
			return;
		}
		
		var rsvtnDtmCnt = jQuery("#rsvtnDtmArea").find("input[name='rsvtnDtm']").length;

		if(rsvtnDtmCnt == 0)
		{
			alert("* 예약일시를 추가해주세요.");
			jQuery("input[name='rsvtnDt']").focus();
			return;
		}
		
		if(confirm("저장하시겠습니까?"))
		{
			jQuery.post("./rsvtn-insert.ajax", jQuery("#frm").serialize(),
				function(r)
				{
					var status = r.status;
					
					if(status == "Y")
					{
						alert("예약정보가 등록되었습니다.");
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}

</script>