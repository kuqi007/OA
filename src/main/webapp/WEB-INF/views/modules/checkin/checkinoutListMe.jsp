<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>日志管理</title>
<meta name="decorator" content="default" />
<style type="text/css">
body{
font-size:16px
}
</style>
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	$(document).ready(function(){
	/* 规范日期选择，结束日期不能小于开始日期 */
	$("#endDate").live("click", function() {
							var beginDate = $("#beginDate").val();
							WdatePicker({
								dateFmt : 'yyyy-MM-dd',
								isShowClear : false,
								minDate : beginDate
							});
						});
						});
</script>
</head>
<body>
	<!-- 	<ul class="nav nav-tabs"> -->
	<%-- 		<li class="active"><a href="${ctx}/sys/log/">日志列表</a></li> --%>
	<!-- 	</ul> -->
	<form:form id="searchForm"
		action="${ctx}/checkin/${url}" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden"
			value="${page.pageNo}" />
		<input id="pageSize" name="page.pageSize" type="hidden"
			value="${page.pageSize}" />
		<div>
			<%-- <label>姓名：</label><input id="title" name="condition.userName" type="text"
				maxlength="50" class="input-mini" value="${condition.userName}" /> <label>工号：</label><input
				id="createBy.id" name="condition.userNo" type="text" maxlength="50"
				class="input-mini" value="${condition.userNo}" />  --%><%-- <label>URI：</label><input
				id="requestUri" name="requestUri" type="text" maxlength="50"
				class="input-mini" value="${log.requestUri}" /> --%>
		</div>
		<div style="margin-top: 8px;">
			<label>日期：&nbsp;</label><input id="beginDate"
				name="condition.beginDate" type="text" readonly="readonly"
				maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${condition.beginDate}" pattern="yyyy-MM-dd"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" />
			<label>&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input
				id="endDate" name="condition.endDate" type="text"
				readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${condition.endDate}" pattern="yyyy-MM-dd"/>"
				 />&nbsp;&nbsp;
			&nbsp;<%-- <label for="exception"><input id="exception"
				name="exception" type="checkbox"
				${log.exception eq '1'?' checked':''} value="1" />只查询异常信息</label> --%>
			&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" />&nbsp;&nbsp;
		</div> 
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>工号</th>
				<th>部门</th>
				<th>姓名</th>
				<th>打卡时间</th>
				<!-- <th>更新时间</th> -->
		</thead>
		<tbody>
			<%
				request.setAttribute("strEnter", "\n");
				request.setAttribute("strTab", "\t");
			%>
			<c:forEach items="${page.list}" var="check">
				<tr>
					<td>${check.user.no}</td>
					<td>${check.user.office.name}</td>
					<td>${check.user.name}</td>
					<td><fmt:formatDate value="${check.checkTime}" type="both" /></td>
					<%-- 			<td>${check.verifycode}</td> --%>
					<%-- <td><strong>${check.requestUri}</strong></td> --%>
					<%-- <td><fmt:formatDate value="${check.updateTime}" type="both" /></td> --%>
				</tr>
				<c:if test="${not empty log.exception}">
					<tr>
						<td colspan="8"
							style="word-wrap: break-word; word-break: break-all;">
							<%-- 					用户代理: ${log.userAgent}<br/> --%> <%-- 					提交参数: ${fns:escapeHtml(log.params)} <br/> --%>
							异常信息: <br />
							${fn:replace(fn:replace(fns:escapeHtml(log.exception), strEnter, '<br/>'), strTab, '&nbsp; &nbsp; ')}
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>