<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>加班单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 结束日期控制
			$("#endDate").live("click",function(){
				var beginDate=$("#beginDate").val();
				WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false,minDate:beginDate});
			});
			
			
			// 职务的控制
			var roleInput=$("#roleInput").val();
			var roleInputName=$("#roleInputName").val();
			if(roleInput!=""){
				$("#role").val(roleInput);
			}
			if(roleInputName!=""){
				$(".select2-chosen").text(roleInputName);// 强行改变O(∩_∩)O哈哈~
			}
			
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
				}
			
			
			// 领导同意单选按钮
			var opinion1=$("#opinion1").val();
			var opinion2=$("#opinion2").val();
			var opinion3=$("#opinion3").val();
			var opinion4=$("#opinion4").val();
			var opinion5=$("#opinion5").val();
			if(opinion1!=""){if(opinion1==1){$("#opinion1ra1").attr("checked","checked");}else{$("#opinion1ra2").attr("checked","checked");}}
			if(opinion2!=""){if(opinion2==1){$("#opinion2ra1").attr("checked","checked");}else{$("#opinion2ra2").attr("checked","checked");}}
			if(opinion3!=""){if(opinion3==1){$("#opinion3ra1").attr("checked","checked");}else{$("#opinion3ra2").attr("checked","checked");}}
			if(opinion4!=""){if(opinion4==1){$("#opinion4ra1").attr("checked","checked");}else{$("#opinion4ra2").attr("checked","checked");}}
			if(opinion5!=""){if(opinion5==1){$("#opinion5ra1").attr("checked","checked");}else{$("#opinion5ra2").attr("checked","checked");}}
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/overtime/listflowType">加班申请单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/overtime/list">加班申请单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/overtime/edit?item.id=${item.id}">加班申请单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/5.png">
	</div>
	<form:form id="inputForm" modelAttribute="workOvertimeForm" action="${ctx}/work/overtime/save?state=${state }" method="post" class="form-horizontal">
	<sys:message content="${message}"/>
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->

		
		<input type="hidden" id="people1" value="${item.people1}" name="item.people1"/>
		<input type="hidden" id="people2" value="${item.people2}" name="item.people2"/>
		<input type="hidden" id="people3" value="${item.people3}" name="item.people3"/>
		<input type="hidden" id="people4" value="${item.people4}" name="item.people4"/>
		<input type="hidden" id="people5" value="${item.people5}" name="item.people5"/>
		
		<c:if test="${addFlag ==1 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName}</label>
			<input type="hidden" id="department" value="${item.department}" name="item.department" />
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">职务:</label>
			<div class="controls">
			<label class="lbl">${postName }</label>
			<input type="hidden" id="roleInput" value="${item.post }" name="item.post"/>
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
			<label class="control-label">加班原由:</label>
			<div class="controls">
			<textarea rows="2" id="reason" name="item.reason" class="required"></textarea>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">加班时间:</label>
			<div class="controls">
				<input id="beginDate" class="input Wdate required" style="width:160px;" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false});" maxlength="20" readonly="readonly" name="item.timeBegin">
				<span class="help-inline"><font color="red">*</font> </span>
				<label> -- </label>
				<input id="endDate" class="input Wdate required" style="width:160px;" type="text"  maxlength="20" readonly="readonly" name="item.timeEnd">
				<span class="help-inline"><font color="red">*</font> </span>
				总共加班时长:<input id="dayTime" class="input required digits" style="width:50px;" type="text" maxlength="20"name="item.dayTime">（小时）
				<span class="help-inline"><font color="red">*</font> </span>
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
			<label class="control-label">职务:</label>
			<div class="controls">
			<label class="lbl">${postName }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">加班原由:</label>
			<div class="controls">
			<label class="lbl">${item.reason }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">加班时间:</label>
			<div class="controls">
			<label><fmt:formatDate value='${item.timeBegin }' pattern='yyyy-MM-dd HH:mm'/>--<fmt:formatDate value='${item.timeEnd }' pattern='yyyy-MM-dd HH:mm'/>
			总共加班时长:${item.dayTime }（小时） </label>
			
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
		<%@include file="sign_insert.jsp"%>
		</c:if>
		<div class="form-actions">
			<c:if test="${saveBut !=0 && item.state!=0 && item.state!=100  }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交" /></c:if>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>