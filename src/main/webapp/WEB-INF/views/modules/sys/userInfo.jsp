<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>个人信息</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
	//表单更改确认导航 
		var icon=$("#nameImage").val();
		var signImage=$("#signImage").val();
		var email=$("#email").val();
		var phone=$("#phone").val();
		var mobile=$("#mobile").val();
		var remarks=$("#remarks").val();
			 $(window).on('beforeunload', function(event) {
			 if($("#nameImage").val()!=icon||$("#signImage").val()!=signImage||$("#email").val()!=email||
			 $("#phone").val()!=phone||$("#mobile").val()!=mobile||$("#remarks").val()!=remarks){
		var message = "尚未保存修改的内容，确认要离开此页吗？";
		event.returnValue = message;
		return message;
			}
		}); 	
				//刷新主页
				if (<%=request.getAttribute("ifsaved")%>== "1") {
					setTimeout("window.parent.refresh()", 3000);
				}

				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										$(window).off("beforeunload");/* 取消绑定确认导航 */
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
										} else {
											error.insertAfter(element);
										}
									}
								});

				/* $("#btnicon").click(function(){
				//setTimeout("alert"hhaahh"",2000);
				}) */
			});
	function show() {
		$('#model1').modal('show');
	};

	function show1() {
		$("#hideicon").val("");
		$("#icon").attr("src", "")
		alert("111");
	};
</script>

<style type="text/css">
ol {
	list-style: none
}

.icon {
	max-width: 100px;
	max-height: 100px;
	_height: 100px;
	border: 0;
	padding: 3px;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/user/info">个人信息</a></li>
		<li><a href="${ctx}/sys/user/modifyPwd">修改密码</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="user"
		action="${ctx}/sys/user/info" method="post" class="form-horizontal">
		<%-- <form:hidden path="email" htmlEscape="false" maxlength="255" class="input-xlarge"/>
		<sys:ckfinder input="email" type="files" uploadPath="/mytask" selectMultiple="false"/> --%>
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">

				<%-- <input type="hidden" value="${user.photo}" name="photo"
					id="hideicon"> <img id="icon" class="icon"
					src="${user.photo}"></br> <a class="btn" id="btnicon1"
					onclick="show();">选择</a> <a class="btn" id="btnicon2"
					onclick="show1();">清除</a><a class="btn" id="btnicon2"
					onclick="upload();">上传</a> --%>
				<form:hidden id="nameImage" path="photo" htmlEscape="false"
					maxlength="255" class="input-xlarge" />
				<sys:ckfinder2 input="nameImage" type="images" uploadPath="/photo"
					selectMultiple="false" maxWidth="100" maxHeight="100" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电子签名图片:</label>
			<div class="controls">
				<form:hidden id="signImage" path="userSign" htmlEscape="false"
					maxlength="255" class="input-xlarge" />
				<sys:ckfinder input="signImage" type="images" uploadPath="/sign"
					selectMultiple="false" maxWidth="100" maxHeight="100" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属公司:</label>
			<div class="controls">
				<label class="lbl">${user.company.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属部门:</label>
			<div class="controls">
				<label class="lbl">${user.office.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50"
					class="required" readonly="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="50"
					class="email" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3"
					maxlength="200" class="input-xlarge" style="resize:none" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户类型:</label>
			<div class="controls">
				<label class="lbl">${fns:getDictLabel(user.userType, 'sys_user_type', '无')}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户角色:</label>
			<div class="controls">
				<label class="lbl">${user.role.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上次登录:</label>
			<div class="controls">
				<label class="lbl">IP:
					${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate
						value="${user.oldLoginDate}" type="both" dateStyle="full" />
				</label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" />
		</div>
	</form:form>

	<div class="modal fade" id="model1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">点击图片更换头像</h4>
				</div>
				<div class="modal-body">
					<table>
						<tr>
							<c:forEach items="${fns:getDictList('iconurl')}" var="item"
								begin="0" end="4">
								<td><img alt="" class="icon"
									src="${ctxUserfiles}${item.value}"
									onclick='javascript:$("#icon").attr("src","${ctxUserfiles}${item.value}");
									$("#model1").modal("hide");$("#nameImage").val("${ctxUserfiles}${item.value}");'></td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${fns:getDictList('iconurl')}" var="item"
								begin="5" end="9">
								<td><img alt="" class="icon"
									src="${ctxUserfiles}${item.value}"
									onclick='javascript:$("#icon").attr("src","${ctxUserfiles}${item.value}");
									$("#model1").modal("hide");$("#nameImage").val("${ctxUserfiles}${item.value}");'></td>
							</c:forEach>
						</tr>

					</table>


				</div>
				<div class="modal-footer">
					<!-- 					<a id="delete" class="btn btn-danger"
						onclick="return confirmx('确认要删除该日程吗？', this.href)">删除</a>
 -->
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button> -->
					<button type="button" class="btn btn-default" data-dismiss="modal">取消
					</button>
					<!-- <input id="submit" type="submit" value="新建事件"
						class="btn btn-primary" /> -->

				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


</body>
</html>