<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
.mainVisualTableList { width:1470px; margin-bottom:-1px;}
.mainVisualTableList .title { width:250px; text-align:center; box-sizing:border-box; }
.mainVisualTableList .title_type { width:150px; text-align:center; box-sizing:border-box; }
.mainVisualTableList .title_column { width:150px; box-sizing:border-box; }
.mainVisualTableList .title_cntns { width:1170px; box-sizing:border-box; }

form { margin:0; }
.form-inline { float:left; margin-left:15px; margin-bottom:15px; }
.form-inline:first-child { margin-left:0; }
</style>

<script>
jQuery(document).ready(function(){
	jQuery("#writeContentBtn").click(function(){
		var f = document.content_form;
		
		if(f.GRP_ID.value == '') {
			alert("그룹을 선택해주세요.");
			f.GRP_ID.focus();
			return;
		}
		if(f.TITLE_TXT.value.replace(/ /g, '') == '') {
			alert("타이틀 내용을 입력해주세요.");
			f.TITLE_TXT.focus();
			return;
		}
		if(f.USE_YN[0].checked == false && f.USE_YN[1].checked == false) {
			alert("사용여부를 선택해주세요.");
			f.USE_YN[0].focus();
			return;
		}
		if(f.USE_STRT_DTM.value.replace(/ /g, '') == '') {
			alert("사용시작일을 입력해주세요.");
			f.USE_STRT_DTM.focus();
			return;
		}
		if(f.USE_END_DTM.value.replace(/ /g, '') == '') {
			alert("사용마감일을 입력해주세요.");
			f.USE_END_DTM.focus();
			return;
		}
		
		var form = jQuery("#content_form")[0];
		var form_data = new FormData(form);
		
		var ajax_url = "/mngwserc/main/content/insert.ajax";
		var alert_msg = "등록";
		if(f.CNTNS_MST_SEQ.value != "") {
			ajax_url = "/mngwserc/main/content/update.ajax";
			alert_msg = "수정";
		}
		jQuery.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: ajax_url,
            data: form_data,
            dataType: "json",
            processData: false,
            contentType: false,
            cache: false,
            beforeSend: function() {
            	jQuery("#form-loading").show();
            },
            success: function (data) {
                if(data.result == "OK") {
                	alert(alert_msg +" 완료되었습니다.");
                	content_manager(f.GRP_ID.value);
                }else {
                	alert(alert_msg +"에 실패하였습니다.\n다시 시도해주세요.");
                	document.location.reload();
                }
            },
            error: function (e) {
                alert("ERROR : "+alert_msg +"에 실패하였습니다.\n다시 시도해주세요.", e);
            },
            complete: function() {
            	jQuery("#form-loading").hide();
            }
        });
	});
});
</script>

<!-- 메인 컨텐츠 목록 Modal -->
<div class="modal fade" id="mainContentListModalPop" tabindex="-1" role="dialog" aria-labelledby="writeModalLabel" aria-hidden="true" style="display:none; width:1500px; margin-left: -750px;">
  	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        		<h4 class="modal-title" id="myModalLabel">Main Content 섹션 
	        		<c:if test="${rtnMap.rstMap.cntnsMstSeq ne null}">수정</c:if>
	      			<c:if test="${rtnMap.rstMap.cntnsMstSeq eq null}">등록</c:if>
      			</h4>
      		</div>
      		<div class="modal-body" style="text-align:center;">
      			<form name="content_form" id="content_form" method="post" action="" enctype="multipart/form-data">
      			<input type="hidden" name="CNTNS_MST_SEQ" value="${ rtnMap.rstMap.cntnsMstSeq }">
      			<table class="mainContentTableList table table-bordered">
      				<tr>
      					<td class="title_type">* 그룹</td>
      					<td>
      						<select name="GRP_ID" style="width:100%;">
      							<c:forEach var="grp" items="${rtnMap.grpIds}">
									<option value="${ grp.grpId }" <c:if test="${rtnMap.rstMap.grpId eq grp.grpId || searchGrpId eq grp.grpId}">selected</c:if>>그룹${ grp.grpId }</option>
		  						</c:forEach>
      						</select>
      					</td>
      				</tr>
      				<tr>
      					<td class="title_column">* 타이틀내용</td>
      					<td class="title_cntns">
      						<input type="text"  class="form-control" name="TITLE_TXT" style="width:100%;" value="${rtnMap.rstMap.titleTxt}">
      						<div>※ 강조텍스트는 ##로 감싸주세요. ex)꿈꾸던 삶으로의 초대 ##신규회원 혜택##</div>
      					</td>
      				</tr>
      				<tr>
						<td class="title_column">타이틀상단바 색깔</td>
						<td class="title_cntns">
							<input type="text"  class="form-control" name="TITLE_COLOR" style="width:90%;" value="${rtnMap.rstMap.titleColor}">
						</td>
					</tr>
      				<tr>
      					<td class="title">* 사용여부</td>
      					<td class="title_cntns">
      						<input type="radio" name="USE_YN" value="Y" <c:if test="${rtnMap.rstMap.useYn eq 'Y'}">checked</c:if>>&nbsp;예&nbsp;
							<input type="radio" name="USE_YN" value="N" <c:if test="${rtnMap.rstMap.useYn eq 'N'}">checked</c:if>>&nbsp;아니요&nbsp;
      					</td>
      				</tr>
      				<tr>
      					<td class="title" >* 사용기간</td>
      					<td class="title_cntns">
      						<input type="date" name="USE_STRT_DTM" value="${rtnMap.rstMap.useStrtDtm}">&nbsp; ~ &nbsp;
							<input type="date" name="USE_END_DTM" value="${rtnMap.rstMap.useEndDtm}">&nbsp;
      					</td>
      				</tr>
      			</table>
      			</form>
      		</div>
      		<div class="modal-footer">
      			<c:if test="${rtnMap.rstMap.cntnsMstSeq ne null}">
      			<a href="#" class="btn btn-success" id="writeContentBtn">수정</a>
      			</c:if>
      			<c:if test="${rtnMap.rstMap.cntnsMstSeq eq null}">
      			<a href="#" class="btn btn-success" id="writeContentBtn">등록</a>
      			</c:if>
        		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>        
      		</div>
    	</div>
  	</div>
</div>