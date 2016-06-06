<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<link rel="shortcut icon" href="${ctxStatic}/index/logg.ico" type="image/x-icon" />
<title>${fns:getConfig('productName')}登录</title>
<meta name="decorator" content="blank" />
<link rel="Stylesheet" href="${ctxStatic}/index/loginin/reset.css" />
<style type="text/css">
html, body, table {
	background-color: #f5f5f5;
	width: 100%;
	/* text-align: center; */
}

.form-signin .checkbox {
	margin-bottom: 10px;
	color: #0663a2;
}

.input-label {
	font-size: 16px;
	line-height: 23px;
	color: #fff;
	text-shadow: 1px 1px 3px #000;
}

.form-signin .input-block-level {
	width: 244px;
	height: 42px;
	border-radius: 5px;
	outline: none;
	font-size: 16px;
	margin-left:10px;
}

.form-signin .btn.btn-large {
	font-size: 16px;
}

.form-signin #themeSwitch {
	position: absolute;
	right: 15px;
	bottom: 10px;
}

.form-signin div.validateCode {
	padding-bottom: 15px;
}

.mid {
	vertical-align: middle;
}

.header {
	/* height: 80px;
	padding-top: 20px; */
	width: 1210px;
	height: 145px;
	background: url(${ctxStatic}/index/loginin/head_bg.png);
	padding-left: 43px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	-o-box-sizing: border-box;
}

.header h1 {
	height: 145px;
	line-height: 145px;
	font-size: 45px;
	color: #fefeff;
	font-weight: normal;
	font-family: "微软雅黑";
	letter-spacing: 4px;
	text-shadow: 4px 4px 6px #000;
	-webkit-text-shadow: 4px 4px 6px #000;
	-moz-text-shadow: 4px 4px 6px #000;
	-ms-text-shadow: 4px 4px 6px #000;
	-o-text-shadow: 4px 4px 6px #000;
}

.alert {
	position: relative;
	width: 300px;
	margin: 10px auto;
	*padding-bottom: 0px;
}

label.error {
	background: none;
	width: 270px;
	font-weight: normal;
	color: inherit;
	margin: 0;
}

.main {
	width: 1210px;
	margin: 0 auto;
}

.main .content {
	width: 1210px;
	height: 655px;
	overflow: hidden;
	background: url(${ctxStatic}/index/loginin/content_bg.png) center center;
}

.main .content .login {
	width: 416px;
	position: relative;
	margin:100px auto 0;
	background: rgba(241, 196, 145, 0.7);
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	overflow: hidden;
}

.main .content .login h3 {
	width: 416px;
	height: 47px;
	line-height: 47px;
	text-align: center;
	font-size: 22px;
	font-family: "微软雅黑";
	color: #fff;
	letter-spacing: 2px;
	background: url(${ctxStatic}/index/loginin/login_bg.png);
	overflow: hidden;
	text-shadow: 1px 1px 3px #000;
	-moz-text-shadow: 1px 1px 3px #000;
	-ms-text-shadow: 1px 1px 3px #000;
	-webkit-text-shadow: 1px 1px 3px #000;
	-o-text-shadow: 1px 1px 3px #000;
}

.login form .zh, .login form .mm {
	line-height: 45px;
	font-size: 16px;
	color: #fff;
	margin-bottom: 15px
}

.main .content .login form {
	width: 416px;
	padding-top: 30px;
	padding-left: 30px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	-o-box-sizing: border-box;
}

.validateCode {
	line-height: 45px;
	font-size: 16px;
	color: #fff;
	position: relative;
}

.validateCodeRefresh {
	color: #CF7D65
}

.btnsub {
	margin-bottom: 27px;
}

.footer {
	text-align: center;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#loginForm")
								.validate(
										{
											rules : {
												validateCode : {
													remote : "${pageContext.request.contextPath}/servlet/validateCodeServlet"
												}
											},
											messages : {
												username : {
													required : "请填写用户名."
												},
												password : {
													required : "请填写密码."
												},
												validateCode : {
													remote : "验证码不正确.",
													required : "请填写验证码."
												}
											},
											errorLabelContainer : "#messageBox",
											errorPlacement : function(error,
													element) {
												error.appendTo($("#loginError")
														.parent());
											}
										});
					});
	// 如果在框架或在对话框中，则弹出提示并跳转到首页
	if (self.frameElement && self.frameElement.tagName == "IFRAME"
			|| $('#left').length > 0 || $('.jbox').length > 0) {
		alert('未登录或登录超时。请重新登录，谢谢！');
		top.location = "${ctx}";
	}
</script>
</head>
<body>
	<div class="main">
		<!--[if lte IE 6]><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 <a href="http://browsehappy.com" target="_blank">升级</a> 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
		<div class="header">
			<h1>${fns:getConfig('productName')}</h1>
		</div>
		<%-- <h1 class="form-signin-heading">${fns:getConfig('productName')}</h1> --%>
		<div class="content">
			<div class="login">
				<h3>用户登录</h3>
				<form id="loginForm" class="form-signin" action="${ctx}/login"
					method="post">
					<div class="zh">
						<label class="input-label" for="username">账 号：</label> <input
							type="text" id="username" name="username"
							class="input-block-level required" value="${username}">
					</div>
					<div class="mm">
						<label class="input-label" for="password">密  码：</label> <input
							type="password" id="password" name="password"
							class="input-block-level required">
					</div>
					<c:if test="${isValidateCodeLogin}">
						<div class="validateCode">
							<label class="input-label mid" for="validateCode">验证码：</label>
							<sys:validateCode name="validateCode"
								inputCssStyle="margin-bottom:0;height:30px;width:132px" />
						</div>
					</c:if>
					<%--
		<label for="mobile" title="手机登录"><input type="checkbox" id="mobileLogin" name="mobileLogin" ${mobileLogin ? 'checked' : ''}/></label> --%>
					<div class="btnsub">
						<%-- <label for="rememberMe" title="下次不需要再登录" style="margin-left: 60px"><input
							type="checkbox" id="rememberMe" name="rememberMe"
							${rememberMe ? 'checked' : ''} /> 记住我（公共场所慎用）</label> --%>&nbsp;&nbsp;&nbsp;&nbsp;<input
							class="btn btn-large btn-primary" type="submit" value="登 录"
							style="margin-left:199px" />
					</div>
					<%-- <div id="themeSwitch" class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">${fns:getDictLabel(cookie.theme.value,'theme','默认主题')}<b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<c:forEach items="${fns:getDictList('theme')}" var="dict">
					<li><a href="#"
						onclick="location='${pageContext.request.contextPath}/theme/${dict.value}?url='+location.href">${dict.label}</a></li>
				</c:forEach>
			</ul>
			<!--[if lte IE 6]><script type="text/javascript">$('#themeSwitch').hide();</script><![endif]-->
		</div> --%>
				</form>
			</div>
			<div id="messageBox"
			class="alert alert-error ${empty message ? 'hide' : ''}">
			<button data-dismiss="alert" class="close">×</button>
			<label id="loginError" class="error">${message}</label>
		</div>
		</div>
		
		<div class="footer">
			Copyright &copy; 2015-${fns:getConfig('copyrightYear')} <a
				href="${ctx}">${fns:getConfig('productName')}</a>
			- Powered By <a href="http://jeesite.com"  target="_blank">JeeSite</a>
			${fns:getConfig('version')}
		</div>
	</div>
	<script src="${ctxStatic}/flash/zoom.min.js" type="text/javascript"></script>
</body>
</html>