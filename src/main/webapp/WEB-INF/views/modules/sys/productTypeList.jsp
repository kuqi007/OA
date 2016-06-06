<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
	<title>外出单列表</title>
		<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/product/list">产品类型列表</a></li>
		<li><a href="${ctx}/sys/product/edit?state=3">添加产品类型</a></li>
</ul><br/>
<form:form id="searchForm" action="${ctx}/sys/product" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden" value="${page.pageNo}"/>
		<%-- <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/> --%>
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
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>产品类型ID</th><th>类型名称</th><th>产品级别</th><th>操作</th></tr></thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
			<tr>
					<td>${item.id }</td>
					<td>${item.name }</td>
					<td>
					<c:if test="${item.upper=='0' }">1级</c:if>
					<c:if test="${item.upper!='0' }">2级</c:if>
					</td>
					<td>
	    				<a href="${ctx}/sys/product/edit?item.id=${item.id}&state=0">查看</a>
						<%-- <a href="${ctx}/work/out/del?item.id=${item.id}" onclick="return confirmx('确认要删除该条记录吗？', this.href)">删除</a> --%>
						<c:if test="${item.upper=='0' }"><a href="${ctx}/sys/product/edit?item.id=${item.id}&state=1">添加下级类型</a></c:if>
					</td>
				</tr>
	</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
