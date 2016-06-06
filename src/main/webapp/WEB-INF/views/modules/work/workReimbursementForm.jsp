<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>差旅报销单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 结束日期控制
			$("#endDate").live("click",function(){
				var beginDate=$("#beginDate").val();
				WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,minDate:beginDate});
			});
			$("#actualEnd").live("click",function(){
				var beginDate=$("#actualBegin").val();
				WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,minDate:beginDate});
			});
			
			
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
				}else if(state==0){
					$("#examine10").attr("style","display:block;");
				}
			
			
			/* 单选按钮控制 */
			// 请假类型
			var type=$("#type").val();
			var typere=$(".controls").find(".typere");
			if(type==1){
				typere.eq(0).attr("checked","checked");
			}else if(type==2){
				typere.eq(1).attr("checked","checked");
			}else if(type==3){
				typere.eq(2).attr("checked","checked");
			}else if(type==4){
				typere.eq(3).attr("checked","checked");
			}else if(type==5){
				typere.eq(4).attr("checked","checked");
			}else if(type==6){
				typere.eq(5).attr("checked","checked");
			}else if(type==7){
				typere.eq(6).attr("checked","checked");
			}
			
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
			// 设置table里面的input宽度
			$("table input").css("width","65px");
			$("table input").css("border","0px");
			$("table .Wdate").css("width","100px");
			$("table #money").css("width","160px");
			$(".subMoney").keyup(function(){
				sumMoney();
				});
			$("#borrow").keyup(function(){
				calculation();
			});
		});
		
		// 自动计算合计金额（为空的自动填0）
		function sumMoney(){
			var subMoney=$(".subMoney");
			var sum=0;
			for(i=0;i<subMoney.length;i++){
				if(subMoney.eq(i).val()!=""){
					sum+=parseFloat(subMoney.eq(i).val());
				}
			}
			$("#money").val(sum);
		}
		// 根据报销总额和预借差旅费计算补领和退款金额
		function calculation(){
			var reimbursement=parseFloat($("#reimbursement").val().trim());
			var borrow=parseFloat($("#borrow").val().trim());
			if(reimbursement>borrow){
				$("#replacement").val(parseFloat(reimbursement-borrow));
				$("#refund").val(0);
			}else{
				$("#replacement").val(0);
				$("#refund").val(parseFloat(borrow-reimbursement));
			}
		}	
		function exportBtna(){
			$("#expor").submit();
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/reimbursement/listflowType">差旅报销单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/reimbursement/list">差旅报销单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/reimbursement/edit?item.id=${item.id}">差旅报销单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/6.png">
	</div>
	<form:form id="inputForm" modelAttribute="workReimbursementForm" action="${ctx}/work/reimbursement/save" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="beginRole" value="${item.beginRole }" type="hidden" name="item.beginRole"/>
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		<input id="fill" value="${item.fill }" type="hidden" name="item.fill"/>
		<input id="fillTime" value="<fmt:formatDate value='${item.fillTime }' pattern='yyyy-MM-dd HH:mm:ss'/>" type="hidden" name="item.fillTime"/>
		<input id="pstater" value="${processState }"  type="hidden"><!-- 流程标识 -->
		
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
			<label class="control-label">出差人:</label>
			<div class="controls">
			<label class="lbl">${item.name}</label> 
                <input id="name" name="item.name" value="${item.name }" type="hidden" maxlength="50" class="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出差地点:</label>
			<div class="controls">
                <input id="place" name="item.place" value="${item.place }" type="text" maxlength="50" class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出差时间:</label>
			<div class="controls">
				<input id="beginDate" class="input Wdate required" style="width:160px;" type="text" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" value="<fmt:formatDate value='${item.timeBegin }' pattern='yyyy-MM-dd HH:mm'/>" maxlength="20" name="item.timeBegin">
				<span class="help-inline"><font color="red">*</font> </span>
				<label> -- </label>
				<input id="endDate" class="input Wdate required" style="width:160px;" type="text" readonly="readonly" value="<fmt:formatDate value='${item.timeEnd }' pattern='yyyy-MM-dd'/>" maxlength="20"  name="item.timeEnd">
				<span class="help-inline"><font color="red">*</font> </span>
				共计:<input id="day" class="input required digits" style="width:50px;" type="text" maxlength="20"name="item.day">（天）
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出差事由:</label>
			<div class="controls">
                <textarea rows="2" id="reason" name="item.reason"  class="required"></textarea>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">费用详情:</label>
		<div class="controls">
				<table border="3" style="text-align: center;">
					<tr>
						<td>出发</td>
						<td>到达</td>
						<td rowspan="2">交通工具</td>
						<td colspan="2">交通费</td>
						<td colspan="2">出差补贴</td>
						<td colspan="3">其他费用</td>
					</tr>
					<tr>
						<td>日期</td>
						<td>日期</td>
						<td>单据张数</td>
						<td>金额</td>
						<td>天数</td>
						<td>金额</td>
						<td>项目</td>
						<td>单据张数</td>
						<td>金额</td>
					</tr>
					<tr>
						<td><input id="timeSetout1" name="item.timeSetout1" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input id="timeArrive1" name="item.timeArrive1" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input type="text" id="traffic1" name="item.traffic1"/></td>
						<td><input id="trafficBill1" name="item.trafficBill1" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="trafficAmount1" name="item.trafficAmount1" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td><input id="subsidyDay1" name="item.subsidyDay1" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="subsidyAmount1" name="item.subsidyAmount1" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td>住宿费</td>
						<td><input id="otherNum1" name="item.otherNum1" type="text" class="digits"/></td>
						<td><input id="otherAmount1" name="item.otherAmount1" type="text" class="number subMoney"/></td>
					</tr>
					<tr>
						<td><input id="timeSetout2" name="item.timeSetout2" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input id="timeArrive2" name="item.timeArrive2" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input type="text" id="traffic2" name="item.traffic2"/></td>
						<td><input id="trafficBill2" name="item.trafficBill2" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="trafficAmount2" name="item.trafficAmount2" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td><input id="subsidyDay2" name="item.subsidyDay2" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="subsidyAmount2" name="item.subsidyAmount2" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td>市内车费</td>
						<td><input id="otherNum2" name="item.otherNum2" type="text" class="digits"/></td>
						<td><input id="otherAmount2" name="item.otherAmount2" type="text" class="number subMoney"/></td>
					</tr>
					<tr>
						<td><input id="timeSetout3" name="item.timeSetout3" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input id="timeArrive3" name="item.timeArrive3" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input type="text" id="traffic3" name="item.traffic3"/></td>
						<td><input id="trafficBill3" name="item.trafficBill3" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="trafficAmount3" name="item.trafficAmount3" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td><input id="subsidyDay3" name="item.subsidyDay3" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="subsidyAmount3" name="item.subsidyAmount3" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td>用餐费</td>
						<td><input id="otherNum3" name="item.otherNum3" type="text" class="digits"/></td>
						<td><input id="otherAmount3" name="item.otherAmount3" type="text" class="number subMoney"/></td>
					</tr>
					<tr>
						<td><input id="timeSetout4" name="item.timeSetout4" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input id="timeArrive4" name="item.timeArrive4" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input type="text" id="traffic4" name="item.traffic4"/></td>
						<td><input id="trafficBill4" name="item.trafficBill4" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="trafficAmount4" name="item.trafficAmount4" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td><input id="subsidyDay4" name="item.subsidyDay4" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="subsidyAmount4" name="item.subsidyAmount4" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td>办公用品费</td>
						<td><input id="otherNum4" name="item.otherNum4" type="text" class="digits"/></td>
						<td><input id="otherAmount4" name="item.otherAmount4" type="text" class="number subMoney"/></td>
					</tr>
					<tr>
						<td><input id="timeSetout5" name="item.timeSetout5" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input id="timeArrive5" name="item.timeArrive5" type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/></td>
						<td><input type="text" id="traffic5" name="item.traffic5"/></td>
						<td><input id="trafficBill5" name="item.trafficBill5" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="trafficAmount5" name="item.trafficAmount5" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td><input id="subsidyDay5" name="item.subsidyDay5" type="text" class="digits"/><span class="help-inline" ></span></td>
						<td><input id="subsidyAmount5" name="item.subsidyAmount5" type="text" class="number subMoney"/><span class="help-inline" ></span></td>
						<td>其他</td>
						<td><input id="otherNum5" name="item.otherNum5" type="text" class="digits"/></td>
						<td><input id="otherAmount5" name="item.otherAmount5" type="text" class="number subMoney"/></td>
					</tr>
					<tr>
					<td><b>合计:</b></td>
					<td colspan="9" style="text-align: left;"><input id="money" name="item.money" type="text" class="number" readonly="readonly"/>￥</td>
					</tr>
				</table>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">报销总额:</label>
				<div class="controls">
	                <input id="reimbursement" name="item.reimbursement" type="text" maxlength="50" class="required number" />￥
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
		</div>
		<div class="control-group" >
				<label class="control-label">预借差旅费:</label>
				<div class="controls">
	                <input id="borrow" name="item.borrow" type="text" maxlength="50" class="required number" />￥
					<span class="help-inline"><font color="red">*</font> </span>
				</div>
		</div>
		<div class="control-group">
				<label class="control-label">补领金额:</label>
				<div class="controls">
	                <input id="replacement" name="item.replacement" type="text" maxlength="50" class="required number" />￥
	                <span class="help-inline"><font color="red">*(无补领填0)</font> </span>
				</div>
		</div>
		<div class="control-group">
				<label class="control-label">退款金额:</label>
				<div class="controls">
	                <input id="refund" name="item.refund" type="text" maxlength="50" class="required number" />￥
					<span class="help-inline"><font color="red">*(无退款填0)</font> </span>
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
			<label class="control-label">出差人:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出差地点:</label>
			<div class="controls">
			<label class="lbl">${item.place }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出差时间:</label>
			<div class="controls">
			<label class="lbl"><fmt:formatDate value='${item.timeBegin }' pattern='yyyy-MM-dd'/> -- <fmt:formatDate value='${item.timeEnd }' pattern='yyyy-MM-dd'/>
			总共出差时长：<label id="timeLabel">${item.day }</label>（天）</label>
			
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出差事由:</label>
			<div class="controls">
			<label class="lbl">${item.reason }</label>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">费用详情:</label>
		<div class="controls">
				<table border="3" style="text-align: center;width:810px;height:323px;">
					<tr>
						<td>出发</td>
						<td>到达</td>
						<td rowspan="2">交通工具</td>
						<td colspan="2">交通费</td>
						<td colspan="2">出差补贴</td>
						<td colspan="3">其他费用</td>
					</tr>
					<tr>
						<td>日期</td>
						<td>日期</td>
						<td>单据张数</td>
						<td>金额</td>
						<td>天数</td>
						<td>金额</td>
						<td>项目</td>
						<td>单据张数</td>
						<td>金额</td>
					</tr>
					<tr>
						<td><fmt:formatDate value='${item.timeSetout1 }' pattern='yyyy-MM-dd'/></td>
						<td><fmt:formatDate value='${item.timeArrive1 }' pattern='yyyy-MM-dd'/></td>
						<td>${item.traffic1 }</td>
						<td>${item.trafficBill1 }</td>
						<td>${item.trafficAmount1 }</td>
						<td>${item.subsidyDay1 }</td>
						<td>${item.subsidyAmount1 }</td>
						<td>住宿费</td>
						<td>${item.otherNum1 }</td>
						<td>${item.otherAmount1 }</td>
					</tr>
					<tr>
						<td><fmt:formatDate value='${item.timeSetout2 }' pattern='yyyy-MM-dd'/></td>
						<td><fmt:formatDate value='${item.timeArrive2 }' pattern='yyyy-MM-dd'/></td>
						<td>${item.traffic2 }</td>
						<td>${item.trafficBill2 }</td>
						<td>${item.trafficAmount2 }</td>
						<td>${item.subsidyDay2 }</td>
						<td>${item.subsidyAmount2 }</td>
						<td>市内车费</td>
						<td>${item.otherNum2 }</td>
						<td>${item.otherAmount2 }</td>
					</tr>
					<tr>
						<td><fmt:formatDate value='${item.timeSetout3 }' pattern='yyyy-MM-dd'/></td>
						<td><fmt:formatDate value='${item.timeArrive3 }' pattern='yyyy-MM-dd'/></td>
						<td>${item.traffic3 }</td>
						<td>${item.trafficBill3 }</td>
						<td>${item.trafficAmount3 }</td>
						<td>${item.subsidyDay3 }</td>
						<td>${item.subsidyAmount3 }</td>
						<td>用餐费</td>
						<td>${item.otherNum3 }</td>
						<td>${item.otherAmount3 }</td>
					</tr>
					<tr>
						<td><fmt:formatDate value='${item.timeSetout4 }' pattern='yyyy-MM-dd'/></td>
						<td><fmt:formatDate value='${item.timeArrive4 }' pattern='yyyy-MM-dd'/></td>
						<td>${item.traffic4 }</td>
						<td>${item.trafficBill4 }</td>
						<td>${item.trafficAmount4 }</td>
						<td>${item.subsidyDay4 }</td>
						<td>${item.subsidyAmount4 }</td>
						<td>办公用品费</td>
						<td>${item.otherNum4 }</td>
						<td>${item.otherAmount4 }</td>
					</tr>
					<tr>
						<td><fmt:formatDate value='${item.timeSetout5 }' pattern='yyyy-MM-dd'/></td>
						<td><fmt:formatDate value='${item.timeArrive5 }' pattern='yyyy-MM-dd'/></td>
						<td>${item.traffic5 }</td>
						<td>${item.trafficBill5 }</td>
						<td>${item.trafficAmount5 }</td>
						<td>${item.subsidyDay5 }</td>
						<td>${item.subsidyAmount5 }</td>
						<td>其他</td>
						<td>${item.otherNum5 }</td>
						<td>${item.otherAmount5 }</td>
					</tr>
					<tr>
					<td><b>合计:</b></td>
					<td colspan="10">${item.money }￥</td>
					</tr>
				</table>
				</div>
			</div>
					<div class="control-group">
				<label class="control-label">报销总额:</label>
				<div class="controls">
					<label class="lbl">${item.reimbursement }￥</label>
				</div>
		</div>
		<div class="control-group" >
				<label class="control-label">预借差旅费:</label>
				<div class="controls">
					<label class="lbl">${item.borrow }￥</label>
				</div>
		</div>
		<div class="control-group">
				<label class="control-label">补领金额:</label>
				<div class="controls">
					<label class="lbl">${item.replacement }￥</label>
				</div>
		</div>
		<div class="control-group">
				<label class="control-label">退款金额:</label>
				<div class="controls">
					<label class="lbl">${item.refund }￥</label>
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
		<div class="control-group">
			<label class="control-label">实际出差日期:</label>
			<div class="controls">
			<label class="lbl">
			<fmt:formatDate value='${item.actualBegin }' pattern='yyyy-MM-dd'/>
			 -- 
			 <fmt:formatDate value='${item.actualEnd }' pattern='yyyy-MM-dd'/>
			</label>
			</div>
		</div>
		<c:if test="${state!=0 && saveBut !=0}">
		<div class="control-group" style="display: none;" id="examine10">
				<label class="control-label">实际出差日期:</label>
				<div class="controls">
	            <input id="actualBegin" class="input Wdate required" style="width:160px;" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" maxlength="20" name="item.actualBegin">
				<span class="help-inline"><font color="red">*</font> </span>
				<label> -- </label>
				<input id="actualEnd" class="input Wdate required" style="width:160px;" type="text" maxlength="20" name="item.actualEnd">
				<span class="help-inline"><font color="red">*</font> </span>
				<label id="timeLabel"></label>
				<%-- 共计:<label>${item.day }</label>（天） --%>
				</div>
		</div>
		<div class="control-group" style="display: none;" id="examine1">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text1" style="width: 315px; height: 73px;">${item.text1 }</textarea><br/><br/>
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
				<textarea name="item.text2" style="width: 315px; height: 73px;">${item.text2 }</textarea><br/><br/>
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
				<textarea name="item.text3" style="width: 315px; height: 73px;">${item.text3 }</textarea><br/><br/>
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
				<textarea name="item.text4" style="width: 315px; height: 73px;">${item.text4 }</textarea><br/><br/>
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
				<input id="opinion5ra1" value="1" type="radio" name="item.opinion5" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion5ra2" value="2" type="radio" name="item.opinion5" class="required"/>不同意
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
		<div class="control-group">
			<label class="control-label">备注：</label><br/>
			<div class="controls">
				1.本表适适用范围为员工外地出差均应填写；	<br/>						
				2.本表填写完毕后，原件复印件分存人力行政中心及工作部门；<br/>					
				3.出差员工应于返回当日到前台核对出差日期，并于返回后3天之内去财务部将钱款结清；<br/>	
				4.金额单位：元。
			</div>
		</div>
		<div class="form-actions">
			<c:if test="${saveBut !=0 && item.state!=0 && item.state!=100  }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/></c:if>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			<c:if test="${addFlag!=1 }"><input id="exportBtn" class="btn" type="button" value="导出" onclick="exportBtna();"/></c:if>
		</div>
	</form:form>
	<!-- 专为导出而用，吼吼吼^O^  -->
	<form action="${ctx}/work/reimbursement/exportReimbursement" method="post" id="expor">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
	</form>
</body>
</html>