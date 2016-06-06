<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招聘需求单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
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
		<c:if test="${state==0 }"><a href="${ctx}/work/recruit/listflowType">招聘申请单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/recruit/list">招聘申请单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/recruit/edit?item.id=${item.id}">招聘申请单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/5.png">
	</div>
	<form:form id="inputForm" modelAttribute="workRecruitForm" action="${ctx}/work/recruit/save" method="post" class="form-horizontal">
	<sys:message content="${message}"/>
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->
		
		<!-- 5个老大的id，为""(你懂我意思吧)则代表其没有做操作 -->
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
			<input type="hidden" id="roleInput" value="${item.post }" name="item.post"/><!-- 编号 -->
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
			<label class="control-label">需求人数:</label>
			<div class="controls">
                <input id="count" name="item.count" value="${item.count }" type="text" maxlength="50" class="digits" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议招聘途径:</label>
			<div class="controls">
			<input type="radio" name="item.channel" value="0" checked="checked"/>社会招聘
			<input type="radio" name="item.channel" value="1" />内部推荐
			<input type="radio" name="item.channel" value="2" />内部调动
			<input type="radio" name="item.channel" value="3" />其他
				<input type="text" id="otherText" value="${item.otherText }" name="item.otherText"/>			
                <input id="channel" value="${item.channel }" type="hidden" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">提报日期:</label>
			<div class="controls">
                <input id="time" class="input Wdate required" style="width:160px;" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" value="<fmt:formatDate value='${item.time }' pattern='yyyy-MM-dd'/>" maxlength="20" readonly="readonly" name="item.time">
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">岗位需求:</label>
			<div class="controls">
			<input type="radio" name="item.type" value="0" checked="checked"/>离职补充 
			<input type="radio" name="item.type" value="1" />调动补充
			<input type="radio" name="item.type" value="2" />岗位新增（编制内）
			<input type="radio" name="item.type" value="3" />岗位扩编（编制外）
                <input id="channel" value="${item.type }" type="hidden" maxlength="50" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议岗位薪资:</label>
			<div class="controls">
               	 试用期：<input id="price1" name="item.price1" value="${item.price1 }" type="text" maxlength="50" class="number required" />
                <span class="help-inline"><font color="red">*</font> </span>
        		转正后：<input id="price2" name="item.price2" value="${item.price2 }" type="text" maxlength="50" class="number required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">需求等级:</label>
			<div class="controls">
			<input type="radio" name="item.grade" value="0" checked="checked"/>紧急
			<input type="radio" name="item.grade" value="1" />一般紧急
			<input type="radio" name="item.grade" value="2" />非紧急
                <input id="grade" value="${item.grade }" type="hidden" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">期望到岗时间:</label>
			<div class="controls">
			<input id="timeing" class="input Wdate required" style="width:160px;" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" value="<fmt:formatDate value='${item.timeing }' pattern='yyyy-MM-dd'/>" maxlength="20" readonly="readonly" name="item.timeing">
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别要求:</label>
			<div class="controls">
			<input type="radio" name="item.sex" value="0" />男
			<input type="radio" name="item.sex" value="1" />女
			<input type="radio" name="item.sex" value="2" checked="checked"/>不限
                <input id="sex" value="${item.sex }" type="hidden" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">年龄要求:</label>
			<div class="controls">
                <input id="age" name="item.age" value="${item.age }" type="text" maxlength="50" class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学历要求:</label>
			<div class="controls">
			<input type="radio" name="item.education" value="0" checked="checked"/>中专/高中
			<input type="radio" name="item.education" value="1" />专科
			<input type="radio" name="item.education" value="2" />本科
			<input type="radio" name="item.education" value="3" />硕士
			<input type="radio" name="item.education" value="4" />博士
			<input type="radio" name="item.education" value="5" />其他
				<input type="text" id="edText" value="${item.edText }" name="item.edText"/>			
                <input id="education" value="${item.education }" type="hidden" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">专业要求:</label>
			<div class="controls">
                <input id="major" name="item.major" type="text" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经验要求:</label>
			<div class="controls">
                <textarea id="experience" name="item.experience" ></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">其他要求（分条列明）:</label>
			<div class="controls">
                <textarea id="other" name="item.other" ></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">岗位职责（分条列明）:</label>
			<div class="controls">
                <textarea id="duty" name="item.duty" ></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
                <textarea id="remarks" name="item.remarks"></textarea>
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
			<label class="control-label">申请人姓名:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求人数:</label>
			<div class="controls">
			<label class="lbl">	${item.count }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议招聘途径:</label>
			<div class="controls">
			<c:if test="${item.channel==0 }">社会招聘</c:if>
			<c:if test="${item.channel==1 }">内部推荐</c:if>
			<c:if test="${item.channel==2 }">内部调动</c:if>
			<c:if test="${item.channel==3 }">${item.otherText }</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">提报日期:</label>
			<div class="controls">
			<fmt:formatDate value='${item.time }' pattern='yyyy-MM-dd'/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">岗位需求类型:</label>
			<div class="controls">
			<c:if test="${item.type==0 }">离职补充</c:if>
			<c:if test="${item.type==1 }">调动补充</c:if>
			<c:if test="${item.type==2 }">岗位新增（编制内）</c:if>
			<c:if test="${item.type==3 }">岗位扩编（编制外）</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建议岗位薪资:</label>
			<div class="controls">
               	 试用期：${item.price1 }
        		转正后：${item.price2 }
			</div>
		</div>
<%-- 		<div class="control-group">
			<label class="control-label">需求等级:</label>
			<div class="controls">
			<c:if test="${item.grade==0 }">紧急</c:if>
			<c:if test="${item.grade==1 }">一般紧急</c:if>
			<c:if test="${item.grade==2 }">非紧急</c:if>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">到岗时间:</label>
			<div class="controls">
			<fmt:formatDate value='${item.timeing }' pattern='yyyy-MM-dd'/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别要求:</label>
			<div class="controls">
			<c:if test="${item.sex==0 }">男</c:if>
			<c:if test="${item.sex==1 }">女</c:if>
			<c:if test="${item.sex==2 }">不限</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">年龄要求:</label>
			<div class="controls">
				<label class="lbl">${item.age }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学历要求:</label>
			<div class="controls">
			<c:if test="${item.education==0 }">中专/高中</c:if>
			<c:if test="${item.education==1 }">专科</c:if>
			<c:if test="${item.education==2 }">本科</c:if>
			<c:if test="${item.education==3 }">硕士</c:if>
			<c:if test="${item.education==4 }">博士</c:if>
			<c:if test="${item.education==5 }">${item.edText }</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">专业要求:</label>
			<div class="controls">
				<label class="lbl">${item.major }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经验要求:</label>
			<div class="controls">
			    <label class="lbl">${item.experience }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">其他要求（分条列明）:</label>
			<div class="controls">
				<label class="lbl">${item.other }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">岗位职责（分条列明）:</label>
			<div class="controls">
				<label class="lbl">${item.duty }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<label class="lbl">${item.remarks }</label>
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
			<c:if test="${saveBut !=0 && item.state!=0 && item.state!=100  }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/></c:if>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>