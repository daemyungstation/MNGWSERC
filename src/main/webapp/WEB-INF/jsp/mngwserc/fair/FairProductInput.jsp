<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
a.btn { color: #ffffff !important; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }

table.sorttable {  margin-bottom: -1px !important; }
.td-no { width: 6%; }
.td-auto { width: auto; }
.td-title { width: 20%; }
.td-time { width: 20%; }
.td-use { width: 6%; }
.td-order { width: 5%; }
.td-mng { width: 10%; }

.json_convert { color:#ffffff; }
</style>

<h6 style="float:left;">대명아임레디 박람회 - 제품 입력폼 관리 : 총 ${rtnMap.list[0].totCnt}건</h6>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	<input type="hidden" name="seq" value="" />
	
	<table class="table table-bordered table-hover sorttable">
		<caption style="display: none;">대명아임레디 박람회 - 제품 입력폼 관리</caption>
	 	<thead>
	  		<tr>
			    <th class="td-no">번호</th>
			    <th class="td-title">제목</th>
			    <th class="td-auto">입력폼</th>
			    <th class="td-mng">관리</th>
	  		</tr>
	 	</thead>
	 	<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="4" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
				    <td class="td-no" style="text-align:center;">
				   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
				   	</td>
				   	<td class="td-title">${ list.fpiTitle }</td>
				    <td class="td-auto json_convert">${ list.fpiInput }</td>
				    <td class="td-mng" style="text-align:center;">
				    	<a href="./write.do?seq=${list.fpiSeq}" class="btn btn-warning btn-xs">
				    		수정
				    	</a>
				    	<a href="javascript:del('${list.fpiSeq}');" class="btn btn-danger btn-xs">
				    		삭제
				    	</a>
			    	</td>
			  	</tr>
	 		</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />				
		</ul>
	</div>
</div>
	
<script type="text/javascript">
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
		
		f.action = "./index.do";
		f.submit();
	}
	
	//삭제
	function del(seq)
	{
		if(confirm("삭제하시겠습니까? 복구할수 없습니다."))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.method = "POST";
			f.seq.value = seq;
			f.submit();
		}
	}
	
	jQuery(document).ready(function(){
		jQuery(".json_convert").each(function(){
			var json = JSON.parse(jQuery(this).text());
			var txtAry = new Array();
			for(var i = 0; i < json.length; i++) {
				var txt = "";
				if(json[i].KEY == "TEXT") {
					txt = "텍스트형";
				}
				else if(json[i].KEY == "HPHONE") {
					txt = "전화번호형";
				}
				else if(json[i].KEY == "EMAIL") {
					txt = "이메일형";
				}
				else if(json[i].KEY == "NUMBER") {
					txt = "숫자형";
				}
				else if(json[i].KEY == "DATE") {
					txt = "달력형";
				}
				else if(json[i].KEY == "SELECT") {
					txt = "선택형";
				}
				txtAry.push(json[i].TITLE);
			}
			jQuery(this).css("color", "#333333").html(txtAry.join(", "));
		});
	});
</script>