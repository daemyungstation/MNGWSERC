<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>



 <div>
 	<div style="margin-bottom:10px">
		<input type="text" value="" style="width:1200px" id="lev1" />
		<input type="button" value="등록" class="btn btn-small btn-success"  onclick="Reg(${seq}, 0, 1)"/>
	</div>
 	
 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	<div class="level1" style="margin-bottom:5px">
		<input type="text" value="${list.cntn}" class="level1Input" style="width:1200px"  />
		
		<c:if test="${list.trsDtlSeq ne null }">
		<input type="button" value="하위" class="btn btn-small btn-info" onclick="Add(this, 2, ${list.trsDtlSeq})"   />
		<input type="button" value="수정" class="btn btn-small btn-warning" onclick="Modify(this, ${list.trsDtlSeq})" />
		<input type="button" value="삭제" class="btn btn-small btn-danger" onclick="Del(this, ${list.trsDtlSeq}, ${seq})" />
		</c:if>
		
		<div class="level level2">
			<c:if test="${list.level2List ne null}">
				<c:forEach var="list2" items="${list.level2List}" varStatus="status">
				<div style="margin: 1px 0; " >
					<textarea name="" style="margin-left: 20px; width: 1180px; height: 20px">${list2.cntn }</textarea>
										
					<input type="button" value="하위" class="btn btn-small btn-info" onclick="Add(this, 3, ${list2.trsDtlSeq})"   />
					<input type="button" value="수정" class="btn btn-small btn-warning" onclick="Modify(this, ${list2.trsDtlSeq})" />
					<input type="button" value="삭제" class="btn btn-small btn-danger" onclick="Del(this, ${list2.trsDtlSeq}, ${seq})" />
					
					<div class="level level3">
						<c:if test="${list2.level3List ne null}">
							<c:forEach var="list3" items="${list2.level3List}" varStatus="status">
							
							<div style="margin: 1px 0; " >
								<textarea name="" style="margin-left: 40px; width: 1160px; height: 20px">${list3.cntn }</textarea>
								<input type="button" value="수정" class="btn btn-small btn-warning" onclick="Modify(this, ${list3.trsDtlSeq})" />
								<input type="button" value="삭제" class="btn btn-small btn-danger" onclick="Del(this, ${list3.trsDtlSeq}, ${seq})" />								
							</div>
														
							</c:forEach>
						</c:if>
					</div>			
				</div>		
				
				</c:forEach>			
			</c:if>
		</div>
		
	</div>
	</c:forEach>
	<!--  -->
	<div class="base" style="margin: 1px 0; display:none;" >
		<textarea name="" style="margin-left: 0px; width: 1200px; height: 20px"></textarea>
								
		<input type="button" value="등록" class="btn btn-small btn-success"  onclick="Reg(${seq}, '', '', this)"  />
		<input type="button" value="삭제" class="btn btn-small btn-danger" onclick="Del(this)" />			
	</div>						
</div> 

<script>
	function Modify(obj, seq){
		
		if($(obj).parent().children('.level1Input').size() > 0){
			val = $(obj).parent().children('.level1Input').val();
		}else{
			val = $(obj).parent().children('textarea').val();
		}

		if(val == ""){
			alert("내용을 입력해주세요.");
			$(this).parent().children('textarea').focus();
		}else{
			if(confirm("수정하시겠습니까?")){
				$.ajax({
					type : 'POST',
					url : './updateTermDtl.ajax',
					data : {
						trsDtlSeq : seq,
						cntn : val
					},
					success : function(e){
						if(e.result == true){
							alert("수정되었습니다.");
							location.reload(true);
						}
					}
				});			
			}						
		}
		
	}
	
	function Del(obj, seq, mstSeq){

		if(seq == undefined){
			$(obj).parent().remove();
		}else{
			if(confirm("삭제하시겠습니까?")){
				$.ajax({
					type : 'POST',
					url : './deleteTermsDtl.ajax',
					data : {
						trsMstSeq : mstSeq,					
						trsDtlSeq : seq					
					},
					success : function(e){
						if(e.result == true){
							alert("삭제되었습니다.");
							location.reload(true);
						}
					}
				});			
			}		
		}
	}
	
	function Add(obj, level, parentSeq){
		var base = $('.base').eq(0);
		var marginleft = "";
		var width = "";
		var levelCon = "";
		
		if(level == 2){			
			marginleft = "20px";
			width = "1180px";
		}else if(level == 3){
			marginleft = "40px";
			width = "1160px";
		}
		
		$(obj).parent().children('.level').append(
			base.find('textarea').css('margin-left', marginleft).css('width', width)
				.end().clone()
				.attr('data-level', level).attr('data-parentseq', parentSeq)
				.show()				
		)
	}
	
	function Reg(trsMstSeq, parentSeq, lev, obj){
		var val = "";
		
		if(lev == 1){
			val = $('#lev1').val();
		}else{
			val = $(obj).parent().find('textarea').val();
			parentSeq = $(obj).parent().data('parentseq');
			lev = $(obj).parent().data('level');
		}
		
		if(val == ""){
			alert("내용을 입력해주세요.");
		}else{
			$.ajax({
				type : 'POST',
				url : './insertTermsDtl.ajax',
				data : {
					trsMstSeq : trsMstSeq,
					parentSeq : parentSeq,
					lev : lev,
					cntn : val
				},
				success : function(e){
					if(e.result == true){
						alert("등록되었습니다.");
						location.reload(true);
					}
				}
			})
		}
	}
	
	$(document).ready(function(){
		$('footer').remove();
		$('hr').remove();
	});
</script>