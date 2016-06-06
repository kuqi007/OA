<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>会议室详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/administr/croom/listAsCroomByPage">会议室列表</a></li>
		<li class="active"><a href="${ctx}/administr/croom/edit?item.id=${item.id}">会议室${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" action="${ctx}/administr/croom/save" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<div class="control-group">
			<label class="control-label">会议室名字:</label>
			<div class="controls">
                <input id="name" name="item.name" value="${item.name }" type="text" class="required"/>
                <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">可容纳人数:</label>
			<div class="controls">
			<input id="number" name="item.number" value="${item.number }" type="text" class="required digits"/>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设备情况请:</label>
			<div class="controls">
				 <input id="equipment" name="item.equipment" value="${item.equipment }" type="text" class="required"/>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所在地点:</label>
			<div class="controls">
				 <input id="position" name="item.position" value="${item.position }" type="text" class="required"/>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会议室描述:</label>
			<div class="controls">
				 <input id="describe" name="item.describe" value="${item.describe }" type="text" />
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>