<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
a.btn { color: #ffffff !important; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }
</style>

<h6 style="float:left;">대명아임레디 박람회 - 메인 배포 관리</h6>

<div style="position:relative;clear: both;">
	<button type="button" class="btn btn-success" style="float:left; width:49%; margin:0;box-sizing: border-box;" id="distribute_btn">현재버전 배포하기</button>
	<a class="btn btn-danger" href="https://www.daemyungimready.com/fair/preview.do" target="_blank" style="float:left; width:49%; margin:0 0 0 2%;box-sizing: border-box;">현재버전 미리보기</a>
	<div style="clear:both;"></div>
</div>
<table class="table table-bordered table-hover sorttable" style="margin-top:10px; ">
	<caption style="display: none;">대명아임레디 박람회 - 상담 관리</caption>
 	<thead>
  		<tr>
		    <th width="80%">날짜</th>
		    <th width="20%">삭제</th>
  		</tr>
  		<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
		<c:if test="${fn:length(list) == 0}">
			<tr>
				<td class="lt_text3" style="text-align:center;">
					이전 버전이 존재하지 않습니다.
				</td>
			</tr>
		</c:if>
		<c:if test="${fn:length(list) > 0}">
			<c:forEach var="dir" items="${list}">
				<tr>
					<td style="text-align:center;">
						${fn:substring(dir,0,4)}-${fn:substring(dir,4,6)}-${fn:substring(dir,6,8)}&nbsp;
						${fn:substring(dir,8,10)}:${fn:substring(dir,10,12)}:${fn:substring(dir,12,14)}
					</td>
					<td style="text-align:center;">
						<input type="button" value="삭제" class="btn btn-danger" onclick="javascript:delete_dir('${dir}');"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
 	</thead>
</table>
 
<script>
jQuery(document).ready(function(){
	jQuery("#distribute_btn").click(function(){
		if(confirm("배포하시겠습니까?"))
		{
			jQuery.ajax({
				url: "./create.ajax",
				type: "POST",
				dataType: "JSON",
				data: {},
				error: function(data) {
	            },
	            beforeSend: function() {
	            	jQuery("#distribute_btn").attr("disabled", true);
	            },
				success: function(data) {
					alert("배포 완료");
					document.location.reload();
				}
			});
		}
	});
});
function delete_dir(directory) {
	if(confirm("삭제하시겠습니까?"))
	{
		jQuery.ajax({
			url: "./delete.ajax",
			type: "POST",
			dataType: "JSON",
			data: {
				"directory": directory
			},
			error: function(data) {
            },
            beforeSend: function() {
            	
            },
			success: function(data) {
				alert("삭제 완료");
				document.location.reload();
			}
		});
	}
}
 
</script>