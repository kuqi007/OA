<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
<title>会议室申请记录列表</title>
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/administr/recode/${urll}">会议室申请记录列表</a></li>
	</ul>
	<br />
	<form:form id="searchForm" action="${ctx}/administr/recode/listAsCroomByPage" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden"value="${page.pageNo}" />
		<input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- 			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<c:if test="${!requestScope.oaNotify.self}"><li><label>状态：</label>
				<form:radiobuttons path="status" items="${fns:getDictList('oa_notify_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li></c:if>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li> --%>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>会议室</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>申请人所属部门</th>
				<th>申请人</th>
				<th>申请原因</th>
				<th>备注</th>
				<th>状态</th>
				<c:if test="${urll=='listAsCroomRecode2' }"><th>操作</th></c:if> 
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
				<tr>
					<td>${item.croomName }</td>
					<td><fmt:formatDate value="${item.timeBegin }" pattern="yyyy-MM-dd HH:mm"/></td> 
					<td><fmt:formatDate value="${item.timeEnd }" pattern="yyyy-MM-dd HH:mm"/></td>
					<td>${item.officeName }</td>
					<td>${item.peopleName }</td>
					<td>${item.reason }</td>
					<td>${item.text }</td>
					<td><c:if test="${item.state==0 }">审核中</c:if>
					<c:if test="${item.state==1 }">已通过</c:if>
					<c:if test="${item.state==2 }">未通过</c:if></td>
					<c:if test="${urll=='listAsCroomRecode2' }">
					<td>
						<a href="${ctx}/administr/recode/updateAgree?item.id=${item.id}">同意</a>
						<a href="${ctx}/administr/recode/updateNotAgree?item.id=${item.id}">不同意</a>
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
