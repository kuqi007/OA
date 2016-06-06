<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
<title>会议室申请列表</title>
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
		<li class="active"><a href="${ctx}/administr/recode/listCroom">会议室列表</a></li>
		<%-- <li><a href="${ctx}/administr/recode/edit">添加会议室申请</a></li> --%>
	</ul>
	<br />
	<form:form id="searchForm" action="${ctx}/administr/recode/listAsCroomByPage" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden"value="${page.pageNo}" />
		<input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
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
					<td><a href="${ctx}/administr/recode/editCroom?item.id=${item.id}">申请</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
