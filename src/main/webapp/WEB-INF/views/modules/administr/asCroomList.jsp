<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
<title>会议室列表</title>
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
		<li class="active"><a href="${ctx}/administr/croom/listAsCroomByPage">会议室列表</a></li>
		<li><a href="${ctx}/administr/croom/edit">添加会议室</a></li>
	</ul>
	<br />
	<form:form id="searchForm" action="${ctx}/administr/croom/listAsCroomByPage" method="post" class="breadcrumb form-search">
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
				<th>会议室名字</th>
				<th>可容纳人数</th>
				<th>设备情况</th>
				<th>所在地点</th>
				<th>会议室描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
				<tr>
					<td>${item.name }</td>
					<td>${item.number }</td> 
					<td>${item.equipment }</td>
					<td>${item.position }</td>
					<td>${item.describe }</td>
					<td>
						<a href="${ctx}/administr/croom/edit?item.id=${item.id}">查看</a>
						<a href="${ctx}/administr/croom/del?item.id=${item.id}"onclick="return confirmx('确认要删除该条记录吗？', this.href)">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
