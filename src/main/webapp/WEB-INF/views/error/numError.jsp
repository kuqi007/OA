<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.thinkgem.jeesite.common.web.Servlets"%>
<%@page import="com.thinkgem.jeesite.common.utils.Exceptions"%>
<%@page import="com.thinkgem.jeesite.common.utils.StringUtils"%>
<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>此单据已过期</title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body><br/>
	此单据已过期,请返回后刷新页面!<br/><br/>
	- ( ゜- ゜)つロ 乾杯~<br/><br/>
	<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
</body>
</html>
<%
 out = pageContext.pushBody();
%>