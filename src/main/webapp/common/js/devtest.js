		// test를 클릭하면 실행
//		document.write("<a href='javascript:testviewVal();' style='color:#FF0000'>test</a>");
		// 화면 빈곳을 [ctrl + alt + 더블클릭] 하면 실행
		jQuery(document).ready(function(){
			$("body").dblclick(function(){
				if(event.ctrlKey && event.altKey){
					testviewVal();
				}
			});
		});
		function testviewVal(){
			// 기존에 이미 있으면 제거하고 새로만들기
			if($("#testviewVal")){
				$("#testviewVal").remove();
			}
			$("body").append("<div id='testviewVal'><table><tr><th>type</td><th>id</td><th>name</td><th>value</td></tr></table></div>");
			var tmptxt = "";
			var $testviewTb = $("#testviewVal table");
			var $thatobj = null;
			$(":input").each(function(){
				var tagType = $(this).prop("tagName").toLowerCase();
				if (tagType == "input") {
					tagType = $(this).attr("type").toLowerCase();
				}

				if($(this).is(":visible")){
					tmptxt = "<tr>";
				}else{
					tmptxt = "<tr style='background:#CCCCCC'>";
				}
				if(tagType == "text" || tagType == "hidden" || tagType == "password"){
					tmptxt +="	<td>" + tagType + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("id"))==="undefined"?"":$(this).attr("id")) + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("name"))==="undefined"?"":$(this).attr("name")) + "</td>"
						   + "	<td><input 	";
					if(jQuery.type($(this).attr("id"))!=="undefined"){
						tmptxt +="			id='"+$(this).attr("id")+"_view'";
					}
					if(jQuery.type($(this).attr("name"))!=="undefined"){
						tmptxt +="			name='"+$(this).attr("name")+"_view'";
					}
					tmptxt +="				value='"+$(this).val()+"'"
						   + "				style='border:1px solid #CC3333'>"
						   + "	</td>";
					tmptxt +="</tr>";
				}else if(tagType == "radio" || tagType == "checkbox"){
					if($thatobj!=null &&
							( ($(this).attr("id") && $thatobj.attr("id") == $(this).attr("id"))
							|| ($(this).attr("name") && $thatobj.attr("name") == $(this).attr("name")))){
						if($(this).is(":checked")){
							tmptxt = "<strong> " + $(this).val() + " </strong>";
						}else{
							tmptxt = "	" + $(this).val() + " ";
						}
						$("td:last",$("tr:last",$testviewTb)).append(tmptxt);
						tmptxt = "";
					}else{
						tmptxt +="	<td>" + tagType + "</td>"
						   	   + "	<td>" + (jQuery.type($(this).attr("id"))==="undefined"?"":$(this).attr("id")) + "</td>"
						   	   + "	<td>" + (jQuery.type($(this).attr("name"))==="undefined"?"":$(this).attr("name")) + "</td>";
						if($(this).is(":checked")){
							tmptxt +="	<td><strong>" + $(this).val() + "</strong></td>";
						}else{
							tmptxt +="	<td>" + $(this).val() + "</td>";
						}
						tmptxt +="</tr>";
					}
					$thatobj = $(this);
				}else if(tagType == "select"){
					tmptxt +="	<td>" + tagType + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("id"))==="undefined"?"":$(this).attr("id")) + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("name"))==="undefined"?"":$(this).attr("name")) + "</td>"
						   //+ "	<td>" + $(this).val() + "</td>"
						   + "	<td><select ";
					if(jQuery.type($(this).attr("id"))!=="undefined"){
						tmptxt +="			id='"+$(this).attr("id")+"_view'";
					}
					if(jQuery.type($(this).attr("name"))!=="undefined"){
						tmptxt +="			name='"+$(this).attr("name")+"_view'";
					}
					tmptxt +="				>";
					for(var i=0; i<$(this).children("option").size();i++){
						if($(this).children("option:eq("+i+")").val()==$(this).val()){
							tmptxt += "<option value='"+$(this).children("option:eq("+i+")").val()+"' selected>"+$(this).children("option:eq("+i+")").text()+"</option>";
						}else{
							tmptxt += "<option value='"+$(this).children("option:eq("+i+")").val()+"'>"+$(this).children("option:eq("+i+")").text()+"</option>";
						}
					}
					tmptxt +="		</select>"
						   + "	</td>";
					tmptxt +="</tr>";
				}else if(tagType == "textarea"){
					tmptxt +="	<td>" + tagType + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("id"))==="undefined"?"":$(this).attr("id")) + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("name"))==="undefined"?"":$(this).attr("name")) + "</td>"
						   + "	<td><textarea	";
					if(jQuery.type($(this).attr("id"))!=="undefined"){
						tmptxt +="			id='"+$(this).attr("id")+"_view'";
					}
					if(jQuery.type($(this).attr("name"))!=="undefined"){
						tmptxt +="			name='"+$(this).attr("name")+"_view'";
					}
					tmptxt +="				style='border:1px solid #CC3333'>" + $(this).val() + "</textarea>"
						   + "	</td>";
					tmptxt +="</tr>";
				}else if(tagType == "button"){
					tmptxt +="	<td>" + tagType + "</td>"
						   + "	<td colspan='3'>"+$(this).html()+"</td>";
					tmptxt +="</tr>";
				}else{
					tmptxt +="	<td>" + tagType+"::"+$(this).attr("type") + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("id"))==="undefined"?"":$(this).attr("id")) + "</td>"
						   + "	<td>" + (jQuery.type($(this).attr("name"))==="undefined"?"":$(this).attr("name")) + "</td>"
						   + "	<td style='color:red;font:bold'>" + tagType + "</td>";
					tmptxt +="</tr>";
				}
				if(tmptxt != ""){
					$testviewTb.append(tmptxt);
				}

			});
			$("#testviewVal").append("<a id='testviewinput' href='javascript:' style='margin:5px'>INPUT</a>");
			$("#testviewVal").append("<a id='testviewclose' href='javascript:' style='margin:5px;color:#FF0000'>CLOSE</a>");
			var divheight = $testviewTb.outerHeight()+100;
			if(divheight > window.innerHeight-100) divheight=window.innerHeight-100;
			var divwidth = $testviewTb.outerWidth()+50;
			if(divwidth > window.innerWidth-100) divwidth=window.innerWidth-100;
			//alert($("#testviewVal table").outerHeight());
			$("#testviewVal td").css("border","1px solid #CCCCCC");
			$("#testviewVal td").css("padding","5px");
			$("#testviewVal").css({
				"position":"fixed",
				"bottom":"30px",
				"right":"30px",
				"border":"1px solid #FF0000",
				"background":"#FFFFFF",
				"text-align":"left",
				"overflow":"scroll",
				"padding":"5px",
				"width":divwidth+"px",
				"height":divheight+"px"
			});
			// 입력값 반영
			$("#testviewinput").click(function(){
				$("#testviewVal input").each(function(){
					if($(this).attr("name")){
						$("input[name="+$(this).attr("name").substring(0,$(this).attr("name").length-5)+"]").val($(this).val());
					}
					if($(this).attr("id")){
						$("#"+$(this).attr("id").substring(0,$(this).attr("id").length-5)).val($(this).val());
					}
				});
				$("#testviewVal select").each(function(){
					if($(this).attr("name")){
						$("select[name="+$(this).attr("name").substring(0,$(this).attr("name").length-5)+"]").val($(this).val());
					}
					if($(this).attr("id")){
						$("#"+$(this).attr("id").substring(0,$(this).attr("id").length-5)).val($(this).val());
					}
				});
				$("#testviewVal textarea").each(function(){
					if($(this).attr("name")){
						$("textarea[name="+$(this).attr("name").substring(0,$(this).attr("name").length-5)+"]").text($(this).text());
					}
					if($(this).attr("id")){
						$("#"+$(this).attr("id").substring(0,$(this).attr("id").length-5)).text($(this).text());
					}
				});
			});
			// 레이어 클릭 시 닫기
//			$("#testviewVal").click(function(){
//				$("#testviewVal").remove();
//			});
			// 버튼 클릭 시 닫기
			$("#testviewclose").click(function(){
				$("#testviewVal").remove();
			});
		}
