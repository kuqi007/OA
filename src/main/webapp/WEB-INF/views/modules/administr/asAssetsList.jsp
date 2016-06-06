<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
<title>固定资产列表</title>
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
		<li class="active"><a href="${ctx}/administr/assets/listAsAssetsByPage">固定资产列表</a></li>
		<li><a href="${ctx}/administr/assets/edit">添加固定资产</a></li>
	</ul>
	<br />
	<form:form id="searchForm" action="${ctx}/administr/assets/listAsAssetsByPage" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden"value="${page.pageNo}" />
		<input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>归属部门：</label>
			<sys:treeselect id="office" name="condition.departmentId" value="${condition.departmentId}" labelName="condition.departmentName" labelValue="${condition.departmentName}" 
				title="部门" url="/sys/office/treeData?type=2&isAll=true" cssClass="input-small" allowClear="true" notAllowSelectParent="true" cssStyle="height:29px;width:163px;"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>归属部门</th>
				<th>资产名字</th>
				<th>资产编号</th>
				<th>价格</th>
				<th>购入时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
				<tr>
					<td>${item.departmentName }</td>
					<td>${item.name }</td> 
					<td>${item.number }</td>
					<td>${item.price }</td>
					<td><fmt:formatDate value="${item.time }" pattern="yyyy-MM-dd"/></td>
					<td><a href="${ctx}/administr/assets/edit?item.id=${item.id}">查看</a>
						<shiro:hasPermission name="administr:assets:delete"><a href="${ctx}/administr/assets/del?item.id=${item.id}"onclick="return confirmx('确认要删除该条记录吗？', this.href)">删除</a></shiro:hasPermission>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
