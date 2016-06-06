<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>费用报销详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 领导签字显示控制
			var state=$("#pstater").val();
				if(state==1){
					$("#examine1").attr("style","display:block;");
				}else if(state==2){
					$("#examine2").attr("style","display:block;");
				}else if(state==3){
					$("#examine3").attr("style","display:block;");
				}else if(state==4){
					$("#examine4").attr("style","display:block;");
				}else if(state==5){
					$("#examine5").attr("style","display:block;");
				}else if(state==6){
					$("#examine6").attr("style","display:block;");
				}
			
			/* 单选按钮控制 */
			// 领导同意单选按钮
			var opinion1=$("#opinion1").val();
			var opinion2=$("#opinion2").val();
			var opinion3=$("#opinion3").val();
			var opinion4=$("#opinion4").val();
			var opinion5=$("#opinion5").val();
			var opinion6=$("#opinion6").val();
			if(opinion1!=""){if(opinion1==1){$("#opinion1ra1").attr("checked","checked");}else{$("#opinion1ra2").attr("checked","checked");}}
			if(opinion2!=""){if(opinion2==1){$("#opinion2ra1").attr("checked","checked");}else{$("#opinion2ra2").attr("checked","checked");}}
			if(opinion3!=""){if(opinion3==1){$("#opinion3ra1").attr("checked","checked");}else{$("#opinion3ra2").attr("checked","checked");}}
			if(opinion4!=""){if(opinion4==1){$("#opinion4ra1").attr("checked","checked");}else{$("#opinion4ra2").attr("checked","checked");}}
			if(opinion5!=""){if(opinion5==1){$("#opinion5ra1").attr("checked","checked");}else{$("#opinion5ra2").attr("checked","checked");}}
			if(opinion6!=""){if(opinion6==1){$("#opinion6ra1").attr("checked","checked");}else{$("#opinion6ra2").attr("checked","checked");}}
			// 表内输入框样式控制
			$("table input").css("border","0px");
			$("table textarea").css("border","0px");
			$("table input").css("width","25px");
			$("#capital").css("width","260px");
			$(".tdHeight").children().css("height","30px");
			// 计算总价
			$("table .money").keyup(function(){
				write();
			});
			
		});
		function write(){
			var my1=$("table .money1");
			var my2=$("table .money2");
			var my3=$("table .money3");
			var my4=$("table .money4");
			var my5=$("table .money5");
			var my6=$("table .money6");
			var num1="";
			var num2="";
			var num3="";
			var num4="";
			var num5="";
			var num6="";
			for(i=0;i<my1.length;i++){
				if(i==6){num1+=".";}
				if(my1.eq(i).val()!=""){num1+=my1.eq(i).val();}else{num1+="0"}
			}
			for(i=0;i<my2.length;i++){
				if(i==6){num2+=".";}
				if(my2.eq(i).val()!=""){num2+=my2.eq(i).val();}else{num2+="0"}
			}
			for(i=0;i<my3.length;i++){
				if(i==6){num3+=".";}
				if(my3.eq(i).val()!=""){num3+=my3.eq(i).val();}else{num3+="0"}
			}
			for(i=0;i<my4.length;i++){
				if(i==6){num4+=".";}
				if(my4.eq(i).val()!=""){num4+=my4.eq(i).val();}else{num4+="0"}
			}
			for(i=0;i<my5.length;i++){
				if(i==6){num5+=".";}
				if(my5.eq(i).val()!=""){num5+=my5.eq(i).val();}else{num5+="0"}
			}
			for(i=0;i<my6.length;i++){
				if(i==6){num6+=".";}
				if(my6.eq(i).val()!=""){num6+=my6.eq(i).val();}else{num6+="0"}
			}
			var num=0;
			if(num1!=""){num+=parseFloat(num1);}	
			if(num2!=""){num+=parseFloat(num2);}	
			if(num3!=""){num+=parseFloat(num3);}	
			if(num4!=""){num+=parseFloat(num4);}	
			if(num5!=""){num+=parseFloat(num5);}	
			if(num6!=""){num+=parseFloat(num6);}	
			$("#capital").val(num);
			/* toUpper("capital","capital"); */
		}
		function exportBtna(){
			$("#expor").submit();
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/cost/listflowType">费用报销单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/cost/list${state}">费用报销单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/cost/edit?item.id=${item.id}">费用报销单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/7.png">
	</div>
	<sys:message content="${message}"/>
	<form:form id="inputForm" modelAttribute="workCostForm" action="${ctx}/work/cost/saveWorkCost" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>		
		<input type="hidden" id="people1" value="${item.people1}" name="item.people1"/>
		<input type="hidden" id="people2" value="${item.people2}" name="item.people2"/>
		<input type="hidden" id="people3" value="${item.people3}" name="item.people3"/>
		<input type="hidden" id="people4" value="${item.people4}" name="item.people4"/>
		<input type="hidden" id="people5" value="${item.people5}" name="item.people5"/>
		<input type="hidden" id="people6" value="${item.people6}" name="item.people6"/>
		
		<c:if test="${addFlag ==1 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName}</label> 
			<input type="hidden" id="department" value="${item.department}" name="item.department" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<label class="lbl">${item.name }</label>
                <input id="name" name="item.name" value="${item.name }" type="hidden"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">费用详情:</label>
			<div class="controls">
			<table border="3" style="text-align: center;width:800px;height:460px;">
			<tr>
				<th rowspan="2">摘要</th>
				<th colspan="8">金额</th>
				<th rowspan="2">科目</th>
				<th rowspan="2">单据张数</th>
			</tr>
			<tr>
			<td>十</td>
			<td>万</td>
			<td>千</td>
			<td>百</td>
			<td>十</td>
			<td>元</td>
			<td>角</td>
			<td>分</td>
			</tr>
			<tr>
			<td><textarea id="abstract1" name="item.abstract1" style="width:278px;height:40px;"></textarea></td>
			<td><input maxlength="1" id="money11" type="text" name="item.money11" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money12" type="text" name="item.money12" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money13" type="text" name="item.money13" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money14" type="text" name="item.money14" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money15" type="text" name="item.money15" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money16" type="text" name="item.money16" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money17" type="text" name="item.money17" value="" class="digits money1 money"/></td>
			<td><input maxlength="1" id="money18" type="text" name="item.money18" value="" class="digits money1 money"/></td>
			<td><textarea id="subject1" name="item.subject1" style="width:210px;height:40px;"></textarea></td>
			<td><input type="text" id="num1" name="item.num1" class="digits"/></td>
			</tr>
			<tr>
			<td><textarea id="abstract2" name="item.abstract2" style="width:278px;height:40px;"></textarea></td>
			<td><input maxlength="1" id="money21" type="text" name="item.money21" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money22" type="text" name="item.money22" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money23" type="text" name="item.money23" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money24" type="text" name="item.money24" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money25" type="text" name="item.money25" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money26" type="text" name="item.money26" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money27" type="text" name="item.money27" value="" class="digits money2 money"/></td>
			<td><input maxlength="1" id="money28" type="text" name="item.money28" value="" class="digits money2 money"/></td>
			<td><textarea id="subject2" name="item.subject2" style="width:210px;height:40px;"></textarea></td>
			<td><input type="text" id="num2" name="item.num2" class="digits"/></td>
			</tr>
			<tr>
			<td><textarea id="abstract3" name="item.abstract3" style="width:278px;height:40px;"></textarea></td>
			<td><input maxlength="1" id="money31" type="text" name="item.money31" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money32" type="text" name="item.money32" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money33" type="text" name="item.money33" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money34" type="text" name="item.money34" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money35" type="text" name="item.money35" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money36" type="text" name="item.money36" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money37" type="text" name="item.money37" value="" class="digits money3 money"/></td>
			<td><input maxlength="1" id="money38" type="text" name="item.money38" value="" class="digits money3 money"/></td>
			<td><textarea id="subject3" name="item.subject3" style="width:210px;height:40px;"></textarea></td>
			<td><input type="text" id="num3" name="item.num3" class="digits"/></td>
			</tr>
			<tr>
			<td><textarea id="abstract4" name="item.abstract4" style="width:278px;height:40px;"></textarea></td>
			<td><input maxlength="1" id="money41" type="text" name="item.money41" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money42" type="text" name="item.money42" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money43" type="text" name="item.money43" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money44" type="text" name="item.money44" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money45" type="text" name="item.money45" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money46" type="text" name="item.money46" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money47" type="text" name="item.money47" value="" class="digits money4 money"/></td>
			<td><input maxlength="1" id="money48" type="text" name="item.money48" value="" class="digits money4 money"/></td>
			<td><textarea id="subject4" name="item.subject4" style="width:210px;height:40px;"></textarea></td>
			<td><input type="text" id="num4" name="item.num4" class="digits"/></td>
			</tr>
			<tr>
			<td><textarea id="abstract5" name="item.abstract5" style="width:278px;height:40px;"></textarea></td>
			<td><input maxlength="1" id="money51" type="text" name="item.money51" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money52" type="text" name="item.money52" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money53" type="text" name="item.money53" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money54" type="text" name="item.money54" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money55" type="text" name="item.money55" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money56" type="text" name="item.money56" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money57" type="text" name="item.money57" value="" class="digits money5 money"/></td>
			<td><input maxlength="1" id="money58" type="text" name="item.money58" value="" class="digits money5 money"/></td>
			<td><textarea id="subject5" name="item.subject5" style="width:210px;height:40px;"></textarea></td>
			<td><input type="text" id="num5" name="item.num5" class="digits"/></td>
			</tr>
			<tr>
			<td><textarea id="abstract6" name="item.abstract6" style="width:278px;height:40px;"></textarea></td>
			<td><input maxlength="1" id="money61" type="text" name="item.money61" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money62" type="text" name="item.money62" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money63" type="text" name="item.money63" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money64" type="text" name="item.money64" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money65" type="text" name="item.money65" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money66" type="text" name="item.money66" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money67" type="text" name="item.money67" value="" class="digits money6 money"/></td>
			<td><input maxlength="1" id="money68" type="text" name="item.money68" value="" class="digits money6 money"/></td>
			<td><textarea id="subject6" name="item.subject6" style="width:210px;height:40px;"></textarea></td>
			<td><input type="text" id="num6" name="item.num6" class="digits"/></td>
			</tr>
			<tr>
			<td colspan="11" style="text-align: left;"><b>合计：</b><input type="text" id="capital" name="item.capital" readonly="readonly"/>￥</td>
			</tr>
			</table>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单据紧急情况:</label>
			<div class="controls">
				<form:select path="item.emergency">
					<form:options items="${fns:getDictList('flag_emergency')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		</c:if>
		<c:if test="${addFlag ==0 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">费用详情:</label>
			<div class="controls">
			<table border="3" style="text-align: center;width:800px;height:360px;">
			<tr>
				<th rowspan="2" style="width:200px;height:30px;">摘要</th>
				<th colspan="8" style="height:30px;">金额</th>
				<th rowspan="2">科目</th>
				<th rowspan="2">单据张数</th>
			</tr>
			<tr class="tdHeight">
			<td>十</td>
			<td>万</td>
			<td>千</td>
			<td>百</td>
			<td>十</td>
			<td>元</td>
			<td>角</td>
			<td>分</td>
			</tr>
			<tr class="tdHeight">
			<td>${item.abstract1 }</td>
			<td>${item.money11 }</td>
			<td>${item.money12 }</td>
			<td>${item.money13 }</td>
			<td>${item.money14 }</td>
			<td>${item.money15 }</td>
			<td>${item.money16 }</td>
			<td>${item.money17 }</td>
			<td>${item.money18 }</td>
			<td>${item.subject1 }</td>
			<td>${item.num1 }</td>
			</tr>
			<tr class="tdHeight">
			<td>${item.abstract2 }</td>
			<td>${item.money21 }</td>
			<td>${item.money22 }</td>
			<td>${item.money23 }</td>
			<td>${item.money24 }</td>
			<td>${item.money25 }</td>
			<td>${item.money26 }</td>
			<td>${item.money27 }</td>
			<td>${item.money28 }</td>
			<td>${item.subject2 }</td>
			<td>${item.num2 }</td>
			</tr>
			<tr class="tdHeight">
			<td>${item.abstract3 }</td>
			<td>${item.money31 }</td>
			<td>${item.money32 }</td>
			<td>${item.money33 }</td>
			<td>${item.money34 }</td>
			<td>${item.money35 }</td>
			<td>${item.money36 }</td>
			<td>${item.money37 }</td>
			<td>${item.money38 }</td>
			<td>${item.subject3 }</td>
			<td>${item.num3 }</td>
			</tr>
			<tr class="tdHeight">
			<td>${item.abstract4 }</td>
			<td>${item.money41 }</td>
			<td>${item.money42 }</td>
			<td>${item.money43 }</td>
			<td>${item.money44 }</td>
			<td>${item.money45 }</td>
			<td>${item.money46 }</td>
			<td>${item.money47 }</td>
			<td>${item.money48 }</td>
			<td>${item.subject4 }</td>
			<td>${item.num4 }</td>
			</tr>
			<tr class="tdHeight">
			<td>${item.abstract5 }</td>
			<td>${item.money51 }</td>
			<td>${item.money52 }</td>
			<td>${item.money53 }</td>
			<td>${item.money54 }</td>
			<td>${item.money55 }</td>
			<td>${item.money56 }</td>
			<td>${item.money57 }</td>
			<td>${item.money58 }</td>
			<td>${item.subject5 }</td>
			<td>${item.num5 }</td>
			</tr>
			<tr class="tdHeight">
			<td>${item.abstract6 }</td>
			<td>${item.money61 }</td>
			<td>${item.money62 }</td>
			<td>${item.money63 }</td>
			<td>${item.money64 }</td>
			<td>${item.money65 }</td>
			<td>${item.money66 }</td>
			<td>${item.money67 }</td>
			<td>${item.money68 }</td>
			<td>${item.subject6 }</td>
			<td>${item.num6 }</td>
			</tr>
			<tr style="height:50px;">
			<td colspan="11" style="text-align: left;">合计：${item.capital }￥</td>
			</tr>
			</table>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单据紧急情况:</label>
			<div class="controls">
				<form:select path="item.emergency" disabled="true">
					<form:options items="${fns:getDictList('flag_emergency')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<c:if test="${state!=0 && saveBut !=0}">
		<div class="control-group" style="display: none;" id="examine1">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text1" cols="2">${item.text1 }</textarea><br/><br/>
				<input id="opinion1ra1" value="1" type="radio" name="item.opinion1" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion1ra2" value="2" type="radio" name="item.opinion1" class="required"/>不同意
				<input id="opinion1" value="${item.opinion1 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign1" name="item.sign1" value="${item.sign1 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date1 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date1"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine2">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text2" cols="2">${item.text2 }</textarea><br/><br/>
				<input id="opinion2ra1" value="1" type="radio" name="item.opinion2" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion2ra2" value="2" type="radio" name="item.opinion2" class="required"/>不同意
				<input id="opinion2" value="${item.opinion2 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign2" name="item.sign2" value="${item.sign2 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date2 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date2"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine3">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text3" cols="2">${item.text3 }</textarea><br/><br/>
				<input id="opinion3ra1" value="1" type="radio" name="item.opinion3" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion3ra2" value="2" type="radio" name="item.opinion3" class="required"/>不同意
				<input id="opinion3" value="${item.opinion3 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign3" name="item.sign3" value="${item.sign3 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date3 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date3"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine4">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text4" cols="2">${item.text4 }</textarea><br/><br/>
				<input id="opinion4ra1" value="1" type="radio" name="item.opinion4" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion4ra2" value="2" type="radio" name="item.opinion4" class="required"/>不同意
				<input id="opinion4" value="${item.opinion4 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign4" name="item.sign4" value="${item.sign4 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date4 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date4"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine5">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text5" style="width: 315px; height: 73px;">${item.text5 }</textarea><br/><br/>
				<input id="opinion5ra1" value="1" type="radio" name="item.opinion5" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion5ra2" value="2" type="radio" name="item.opinion5" class="required"/>不同意
				<input id="opinion5" value="${item.opinion5 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign5" name="item.sign5" value="${item.sign5 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date5 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date5"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine6">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text6" style="width: 315px; height: 73px;">${item.text6 }</textarea><br/><br/>
				<input id="opinion6ra1" value="1" type="radio" name="item.opinion6" class="required"/>确认
				<input id="opinion6" value="${item.opinion6 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign6" name="item.sign6" value="${item.sign6 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date6 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date6"/>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${not empty listSign }">
		<div class="control-group">
			<label class="control-label">审批情况：</label><br/>
				<div class="controls">
					<table border="1">
					<tr><td>序号</td><td>处理步骤</td><td>签名</td><td>情况</td><td>审批日期</td><td>审批意见</td></tr>
					<c:forEach items="${listSign }" var="signInfo" varStatus="varStatus">
					<tr><td>${varStatus.count }</td>
					<td>${signInfo.signName }</td>
					<td><img style="width:120px;height:60px;" alt="审批人签名" src="${signInfo.sign }"> </td>
					<td><c:if test="${signInfo.operation==1 }"><img src="${ctxUserfiles }/staticImages/yes.png" width="20" height="20"/></c:if><c:if test="${signInfo.operation==2 }"><img src="${ctxUserfiles }/staticImages/no.png" width="20" height="20"/></c:if></td>
					<td><fmt:formatDate value='${signInfo.dateTime }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
					<td>${signInfo.text }</td></tr>
					</c:forEach>
					</table>
				</div>
		</div>
		</c:if>
		</c:if>
		<div class="form-actions">
			<c:if test="${saveBut !=0 && item.state!=0 && item.state!=100  }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/></c:if>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			<c:if test="${addFlag!=1 }"><input id="exportBtn" class="btn" type="button" value="导出" onclick="exportBtna();"/></c:if>
		</div>
	</form:form>
	<!-- 专为导出而用，吼吼吼^O^  -->
	<form action="${ctx}/work/cost/exportCost" method="post" id="expor">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
	</form>
</body>
</html>