<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COGCntnsMngList.jsp
	프로그램 명 : 	컨텐츠관리
	설명		: 	MngList
	작성자		: 	김대환
	작성일		:	2015.11.17
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.17				김대환				최초작성
	######################################################################
-->

컨텐츠 버전 목록 조회<br /><br />
<p class="text-info">
	연관 메뉴 :
	<c:choose>
		<c:when test="${fn:length(rtnMap.relMenuList) > 0}">
			<c:forEach var="list" items="${rtnMap.relMenuList}" varStatus="status">
				${list.menuNm}
				<c:if test="${not status.last}">,</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			등록된 메뉴가 없습니다.
		</c:otherwise>
	</c:choose>
</p>
<br />
<form name="frm" method="post">
 	<a href="javascript:writeCntns();" class="btn btn-success">컨텐츠 등록</a>
 	<a href="javascript:chkCntns();" class="btn btn-primary">컨텐츠 복사</a>
 	
 	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="cntsSeq" value="" />
	<input type="hidden" name="menuSeqArr" value="" />

	<table id="cntnsTbl" class="table table-bordered table-hover" style="margin-top:30px;">	
		<thead>
			<tr>
				<th width="8%"><input type="checkbox" name="allCheck" /></th>
				<th width="10%">번호</th>
				<th width="32%">컨텐츠 명</th>
				<th width="10%">버전</th>
				<th width="16%">등록자</th>
				<th width="12%">상태</th>
				<th width="12%">등록일</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center; vertical-align:middle;">
						<input type="checkbox" name="chk" value="${list.cntsSeq}" />
					</td>
					<td style="text-align:center; vertical-align:middle; cursor:pointer;" onclick="selectCntns('${list.cntsSeq}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:center; vertical-align:middle; cursor:pointer;" onclick="selectCntns('${list.cntsSeq}');">
						${pageTitle}
					</td>
					<td style="text-align:center; vertical-align:middle; cursor:pointer;" onclick="selectCntns('${list.cntsSeq}');">
						${list.ver}
					</td>
					<td style="text-align:center; vertical-align:middle; cursor:pointer;" onclick="selectCntns('${list.cntsSeq}');">
						${list.regId}
					</td>
					<td style="text-align:center; vertical-align:middle; cursor:pointer;" onclick="selectCntns('${list.cntsSeq}');">
						${egov:contentsStatus(list.prcsStts)}
					</td>	
					<td style="text-align:center; vertical-align:middle;" onclick="selectCntns('${list.cntsSeq}');">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	
	<div style="float:left;">
		<a href="javascript:deleteCntnsList();" class="btn btn-danger">삭제</a>
	</div>
	
	<div style="float:right;">
		<a href="javascript:setApproval();" class="btn btn-success">승인</a>
	    <a href="javascript:setImmdApproval();" class="btn btn-primary">즉시배포</a>
	    <a href="javascript:setBackCntns();" class="btn btn-warning">되돌리기</a>
	</div>
	
	<!--// 페이징과 버튼 부분 -->
	<div class="paging_all c_box">
		<!--// 페이징 부분 -->
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
			</ul>
		</div>
		<!-- 페이징 부분 //-->
	</div>
	<!-- 페이징과 버튼 부분 //-->
</form>	

<!-- Button trigger modal -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="myModalLabel">복사 선택</h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
        		<input type="radio" name="copyType" id="copyType1" value="nomal" checked="checked" /> 일반복사
        		<input type="radio" name="copyType" id="copyType2" value="multi" /> 다중복사
      		</div>
      		<div class="modal-footer">
       			<a href="javascript:copyCntns();" class="btn btn-success">선택</a>
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
      		</div>
    	</div>
  	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="myModalLabel">복사 위치 선택</h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
				<div id="cmsList">
					<table class="table table-bordered table-hover">
				 		<thead>
							<tr>
								<th width="80%">컨텐츠 목록</th>
								<th width="20%">선택</th>
							</tr>				 
				 		</thead>
				  		<tbody>
				  
				  		</tbody>
					</table>
				</div>
      		</div>
      		<div class="modal-footer">
        		<a href="javascript:multiCopyCntns();" class="btn btn-primary">선택</a>
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
      		</div>
    	</div>
  	</div>
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("#cntnsTbl tbody tr").on("mouseenter", function(){
			jQuery(this).addClass("success");
		});
		
		jQuery("#cntnsTbl tbody tr").on("mouseleave", function(){
			jQuery(this).removeClass("success");
		});
		
		//삭제 체크박스 전체 선택 & 해제
		jQuery("input:checkbox[name='allCheck']").on("click", function(){
			if(jQuery(this).is(":checked")) 
			{
				jQuery("input:checkbox[name='chk']").prop("checked", true);
			} 
			else 
			{
				jQuery("input:checkbox[name='chk']").prop("checked", false);
			}	
		});
		
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='chk']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='chk']").length;
			var selChkCnt = jQuery("input:checkbox[name='chk']:checked").length;
			
			if(allChkCnt == selChkCnt) 
			{
				jQuery("input:checkbox[name='allCheck']").prop("checked", true);
			} 
			else 
			{
				jQuery("input:checkbox[name='allCheck']").prop("checked", false);
			}
		});
	});
	
	//페이지번호 클릭시
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
		
		f.action = "./index.do";
		f.submit();
	}	
	
	//목록 클릭시
	function selectCntns(cntsSeq)
	{
		var f = document.frm;
		f.action = "./view.do";
		f.cntsSeq.value = cntsSeq;
		f.submit();
	}
	
	//등록 클릭시
	function writeCntns()
	{
		var f = document.frm;
		f.action = "./write.do";
		f.submit();
	}	
	
	//삭제 클릭시
	function deleteCntnsList()
	{
		var f = document.frm;
		
		if(jQuery("input:checkbox[name='chk']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?"))
			{
				f.action="./delete.do";
				f.submit();					
			}
		}
		else
		{
			alert("삭제할 대상을 선택하세요.");
			return ;
		}
	}
	
	//컨텐츠 선택여부 체크
	function chkCntns()
	{
		var chkCnt = jQuery("input:checkbox[name='chk']:checked").length;
		
		if(chkCnt == 0)
		{
			alert("선택된 컨텐츠가 없습니다.");
			return;
		}
		else if(chkCnt > 1)
		{
			alert("1개 이상 선택할 수 없습니다.");
			return ;
		}
		else
		{
			jQuery("#myModal").modal("show");
		}
	}
	
	//컨텐츠 복사
	function copyCntns()
	{
		if(confirm("복사하시겠습니까?"))
		{
			jQuery("#myModal").modal("hide");
			
			var copyType = jQuery("input[name='copyType']:checked").val();
			
			if(copyType == "nomal")
			{
				nomalCopyCntns();
			}
			else if(copyType == "multi")
			{
				jQuery.get("/mngwserc/contentsid/${rtnMap.menuSeq}/getCntnsList.ajax",
					{
						"menuSeq" : "21",
						"menuGb" : "cms"
					},
					function(r) {
						var rtnList = r.rtnList;
						var htmlSrc = new Array();
						
						for(var i = 0; i < rtnList.length; i++)
						{
							htmlSrc.push("<tr>\n");
							htmlSrc.push("	<td>" + rtnList[i].menuNm.replace(/ /gi, "&nbsp;") + "</td>\n");
							htmlSrc.push("	<td style='text-align:center; vertical-align:middle;'><input type='checkbox' name='cmsChk' value='" + rtnList[i].menuSeq + "' /></td>\n");
							htmlSrc.push("</tr>\n");
						}
						
						jQuery("#cmsList table tbody").html(htmlSrc.join(""));
					}
				);
			
				jQuery("#myModal2").modal("show");
			}
		}
	}
	
	//일반 복사
	function nomalCopyCntns()
	{
		var f = document.frm;
		
		f.action = "./copy.do";
		f.cntsSeq.value = jQuery("input[name='chk']:checked").val();
		f.submit();
	}
	
	//다중 복사
	function multiCopyCntns()
	{
		var multiCopyChkArr = new Array();
		
		jQuery("input[name='cmsChk']:checked").each(function(){
			multiCopyChkArr.push(jQuery(this).val());
		});
		
		var f = document.frm;
		f.action = "./multiCopy.do";
		f.cntsSeq.value = jQuery("input[name='chk']:checked").val();
		f.menuSeqArr.value = multiCopyChkArr.join(",");
		f.submit();
	}
	
	//승인요청
	function setApproval()
	{
		var chkObj = jQuery("input[name='chk']:checked");
		
		if(chkObj.length == 0)
		{
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		else if(chkObj.length > 1)
		{
			alert("1개 이상 선택할 수 없습니다.");
			return ;
		}
		else
		{
			if(confirm("해당 컨텐츠를 승인하시겠습니까?"))
			{
				jQuery.get("/mngwserc/contentsid/${rtnMap.menuSeq}/chkStatus.ajax",
					{
						"cntsSeq" : jQuery("input[name='chk']:checked").val()
					},
					function(r) {
						var prcsStts = r.prcsStts;

						if(prcsStts == "1")
						{
							confirmApproval();
						}
						else
						{
							alert("승인요청 컨텐츠가 아닙니다.");
							return;
						}
					}
				);
			}
		}
	}
	
	// 즉시배포 클릭시
	function setImmdApproval()
	{
		var chkObj = jQuery("input[name='chk']:checked");
		
		if(chkObj.length == 0)
		{
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		else if(chkObj.length > 1)
		{
			alert("1개 이상 선택할 수 없습니다.");
			return ;
		}
		else
		{
			if(confirm("해당 컨텐츠로 즉시배포 하시겠습니까?"))
			{
				jQuery.get("/mngwserc/contentsid/${rtnMap.menuSeq}/chkStatus.ajax",
					{
						"cntsSeq" : jQuery("input[name='chk']:checked").val()
					},
					function(r) {
						var prcsStts = r.prcsStts;

						if(prcsStts == "0")
						{
							confirmApproval();
						}
						else
						{
							alert("작성중인 컨텐츠가 아닙니다.");
							return;
						}
					}
				);		
			}
		}
	}
	
	// 되돌리기 클릭시
	function setBackCntns()
	{
		var chkObj = jQuery("input[name='chk']:checked");
		
		if(chkObj.length == 0)
		{
			alert("선택된 컨텐츠가 없습니다.");
			return ;
		}
		else if(chkObj.length > 1)
		{
			alert("1개 이상 선택할 수 없습니다.");
			return ;
		}
		else
		{
			if(confirm("해당 컨텐츠로 되돌리시겠습니까?"))
			{
				jQuery.get("/mngwserc/contentsid/${rtnMap.menuSeq}/chkStatus.ajax",
					{
						"cntsSeq" : jQuery("input[name='chk']:checked").val()
					},
					function(r) {
						var prcsStts = r.prcsStts;

						if(prcsStts == "3")
						{
							confirmApproval();
						}
						else
						{
							alert("배포(만기) 컨텐츠가 아닙니다.");
							return;
						}
					}
				);		
			}
		}
	}
	
	// 확인 후 승인
	function confirmApproval()
	{
		var f = document.frm;
		f.action = "./updateApproval.do";
		f.cntsSeq.value = jQuery("input[name='chk']:checked").val();
		f.submit();
	}
</script>