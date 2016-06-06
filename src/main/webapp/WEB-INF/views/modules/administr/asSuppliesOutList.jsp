<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
<title>商品出库列表</title>
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
		<li class="active"><a href="${ctx}/administr/suppliesOut/${urll }">办公用品出库列表</a></li>
		<c:if test="${urll=='listAsSuppliesOutByPage' }"><li><a href="${ctx}/administr/suppliesOut/edit?urlFlag=${urll}">添加办公用品出库信息</a></li></c:if>
	</ul>
	<br />
	<form:form id="searchForm" action="${ctx}/administr/suppliesOut/${urll }" method="post" class="breadcrumb form-search">
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
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>签收人名字</th>
				<th>所属部门</th>
				<th>申领时间</th>
				<th>操作</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
				<tr>
					<td>${item.peopleName }</td>
					<td>${item.officeName }</td>
					<td><fmt:formatDate value="${item.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td><a href="${ctx}/administr/suppliesOut/edit?item.id=${item.id}&urlFlag=${urll}">查看</a>
						<shiro:hasPermission name="administr:suppliesOut:delete"><a href="${ctx}/administr/suppliesOut/del?item.id=${item.id}&urlFlag=${urll}"onclick="return confirmx('确认要删除该条记录吗？', this.href)">删除</a></shiro:hasPermission>
					</td>
					<td>
					<c:if test="${item.state==0 }">未签收</c:if>
					<c:if test="${item.state==1 }">已签收</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
