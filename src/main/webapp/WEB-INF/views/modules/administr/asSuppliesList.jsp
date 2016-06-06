<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
<title>商品库存列表</title>
<script type="text/javascript">
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	$(document).ready(function() {
		// 去掉框架的渲染
		$("#s2id_type").remove();
		$("#type").removeAttr("class");
		$.ajax({
			   type: "POST",
			   url: "${ctx}/sys/product/listProductType",
			   data: "item.upper=3",
			   success: function(date){
				   var selectText="<option value=''>--请选择类别--</option>";
				   for(var i=0;i<date.length;i++){
					   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
				   }
				   $("#type").html(selectText);
				   $("#type").val($("#typeHidden").val());  
			   }
		});
	});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/administr/supplies/listAsSuppliesByPage">办公用品列表</a></li>
		<li><a href="${ctx}/administr/supplies/edit">添加办公用品</a></li>
	</ul>
	<br />
	<form:form id="searchForm" action="${ctx}/administr/supplies/listAsSuppliesByPage" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden"value="${page.pageNo}" />
		<input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>物品类型：</label>
				<select id="type" name="condition.type"></select>
				<input id="typeHidden" value="${condition.type }" type="hidden"/>
			</li> --%>
			<li><label>物品名字：</label>
			<input type="text" value="${condition.name}" name="condition.name" maxlength="200" style="height:29px;width:163px;"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用品名字</th>
				<th>类型</th>
				<!-- <th>价格</th> -->
				<th>数量</th>
				<th>计量单位</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
				<tr>
					<td>${item.name }</td>
					<td>${item.typeName }</td> 
					<%-- <td>${item.price }</td> --%>
					<td>${item.num }</td>
					<td>${item.company }</td>
					<td><a href="${ctx}/administr/supplies/edit?item.id=${item.id}">查看</a>
						<%-- <a href="${ctx}/administr/supplies/del?item.id=${item.id}"onclick="return confirmx('确认要删除该条记录吗？', this.href)">删除</a> --%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
