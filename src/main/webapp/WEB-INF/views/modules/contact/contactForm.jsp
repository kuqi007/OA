<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>用户管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#no").focus();
						$("#inputForm")
								.validate(
										{
											rules : {
												loginName : {
													remote : "${ctx}/sys/user/checkLoginName?oldLoginName="
															+ encodeURIComponent('${user.loginName}')
												}
											},
											messages : {
												loginName : {
													remote : "用户登录名已存在"
												},
												confirmNewPassword : {
													equalTo : "输入与上面相同的密码"
												}
											},
											submitHandler : function(form) {
												loading('正在提交，请稍等...');
												form.submit();
											},
											errorContainer : "#messageBox",
											errorPlacement : function(error,
													element) {
												$("#messageBox").text(
														"输入有误，请先更正。");
												if (element.is(":checkbox")
														|| element.is(":radio")
														|| element
																.parent()
																.is(
																		".input-append")) {
													error.appendTo(element
															.parent().parent());
												} else {
													error.insertAfter(element);
												}
											}
										});
					});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/contact/list">所有用户</a></li>
		<li class="active"><a href="${ctx}/contact/form?id=${user.id}">查看详情</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="user"
		action="${ctx}/sys/user/save" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<c:if test="${not empty (user.photo)}">
					<img src="${user.photo}" width="80px" height="80px"
						style="border-radius: 5px; border: 1px solid #cccccc; box-shadow: 1px 1px 10px #ddd; margin-top: 8px"></img>
				</c:if>
				<c:if test="${empty (user.photo)}">
					<span class="lbl">无</span>
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属公司:</label>
			<div class="controls" >
				<span class="lbl">${user.company.name}</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属部门:</label>
			<div class="controls" >
				<span  class="lbl">${user.office.name}</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">编号:</label>
			<div class="controls">
				<form:input path="no" htmlEscape="false" maxlength="50"
					 readonly="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50"
					 readonly="true" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="100"
					class="email" readonly="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="100" readonly="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="100" readonly="true" />
			</div>
		</div>


		<div class="control-group">
			<label class="control-label">职位:</label>
			<div class="controls" >
				<span class="lbl">${user.role.name}</span>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>