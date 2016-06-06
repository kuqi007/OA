<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>会议室申请页面</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
		});
		function sub(){
			// 检查时间段是否有效
			$.ajax({
				   type: "POST",
				   url: "${ctx}/administr/recode/checkTime",
				   data: "item.timeBegin="+$("#timeBegin").val()+"&item.timeEnd="+$("#timeEnd").val(),
				   success: function(msg){
				     if(msg=="0"){
				    	 alert("申请成功，请等待行政审批！");
				    	 $("#inputForm").submit();
				     }else{
				    	 alert("时间冲突,已有会议:"+msg);
				     }
				   }
				});
			return false;
		}
		function getLocalTime(nS) {
			alert(nS);
			return new Date(parseInt(nS) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
			} 
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/administr/recode/listCroom">会议室列表</a></li>
		<li class="active"><a href="${ctx}/administr/recode/editCroom?item.id=${item.id}">会议室申请${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" action="${ctx}/administr/recode/saveAsCroomRecode" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.croomId"/>
		<div class="control-group">
			<label class="control-label">会议预计开始时间:</label>
			<div class="controls">
                <input id="timeBegin" name="item.timeBegin" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false});" readonly="readonly" class="input Wdate required"/>
                <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会议预计结束时间:</label>
			<div class="controls">
			<input id="timeEnd" name="item.timeEnd" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false});" readonly="readonly" class="input Wdate required"/>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">使用原因:</label>
			<div class="controls">
				 <input id="reason" name="item.reason" type="text" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				 <input id="text" name="item.text" type="text" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" onclick="sub();return false;"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>