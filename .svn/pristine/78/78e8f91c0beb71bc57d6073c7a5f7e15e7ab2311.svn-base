<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMBChngSysOutPrdctPop.jsp
	프로그램 명 : 	전환서비스 체계 외부상품(엔컴) 목록을 조회한다.
	설명		: 	전환서비스 체계 외부상품(엔컴) 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.19
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.19				허진영				최초작성
	######################################################################
-->

<form name="prdctFrm" method="post" action ="">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	
	<div class="well well-small">
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>상품코드</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>상품명</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="./outPrdct-list.do" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">전환서비스 체계 외부상품</caption>
		<thead>
			<tr>
				<th width="15%">선택</th>
				<th width="20%">코드</th>
				<th width="65%">상품명</th>
			</tr>
		</thead>
		<tbody id="chngSysTbody">
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="3" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center; vertical-align:middle;">
			    		<input type="checkbox" name="chk" value="${list.prodCd},<c:out value="${list.prodNm}" escapeXml="true"/>" />
			    	</td>
					<td style="text-align:center; vertical-align:middle; cursor:pointer;" onclick="jQuery(this).closest('tr').find('input:eq(0)').prop('checked', 'true');">
						${list.prodCd}
					</td>
					<td style="text-align:left; vertical-align:middle; cursor:pointer;" onclick="jQuery(this).closest('tr').find('input:eq(0)').prop('checked', 'true');">
						${list.prodNm}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<div style="text-align:right;">
	<a href="javascript:insertChngSysOutPrdct();" class="btn btn-success">등록</a>
	<a href="javascript:self.close();" class="btn btn-default">취소</a>
</div>

<script type="text/javascript">

	//리스트 가져오기
	function getPageList()
	{	
		var f = document.prdctFrm;
		
		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}
		
		f.action = "./outPrdct-list.do";
		f.submit();
	}
	
	//외부상품(엔컴)을 등록한다.
	function insertChngSysOutPrdct()
	{
		if(jQuery("input[name='chk']:checked").length > 0)
		{
			if(confirm("등록하시겠습니까?"))
			{
				var prodCdArr = new Array();
				var prodNmArr = new Array();
				
				jQuery("input[name='chk']:checked").each(function(){
					var prodInfo = jQuery(this).val();
					
					prodCdArr.push(prodInfo.split(",")[0]);
					prodNmArr.push(prodInfo.split(",")[1]);
				});
				
				jQuery.post("/mngwserc/cmb/sys/prdct-insert.ajax",
					{
						"grpSeq" : jQuery("input[name='grpSeq']", opener.document).val(),
						"prodCdArr" : prodCdArr.join(),
						"prodNmArr" : prodNmArr.join()
					},
					function(r) 
					{
						var status = r.status;
						
						if(status == "Y")
						{
							opener.window.location.reload();
							
							window.location.reload(true);
						}
					}
				).fail(function () {
					alert("예기치 않은 오류입니다.");
				});
			}
		}
		else
		{
			alert("등록할 대상을 선택해주세요.");
			return;
		}
	}

</script>