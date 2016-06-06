<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
	<title>办公用品申领单列表</title>
		<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
		$(function(){
			$("#btnSubmit").click(function(){
				/* var state=${state};
				if(state==0){
					$("#searchForm").attr("action","${ctx}/work/apply/listflowType");
				}else{
					$("#searchForm").attr("action","${ctx}/work/apply/list");
				} */
				
			});
			$("#s2id_flagType").remove();
			$("#flagType").removeAttr("class");
			$("#flagType").val($("#hiddenFlag").val());
		});
	</script>
</head>
<body>
<ul class="nav nav-tabs">
		<li class="active">
		<c:if test="${state==0 }"><a href="${ctx}/work/apply/listflowType">办公用品申领单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/apply/list">办公用品申领单列表</a></c:if>
		</li>
		<li><c:if test="${state==0 }"><a href="${ctx}/work/apply/edit">添加办公用品申领单</a></c:if></li>
</ul><br/>
<form:form id="searchForm" action="" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="page.pageSize" type="hidden" value="${page.pageSize}"/>
		<c:if test="${state==6 }">
		<ul class="ul-form">
			<li><label>归属部门：</label><c:if test="${bossFlag==0 }"><sys:treeselect id="office" name="condition.department" value="${condition.department}" labelName="condition.departmentName" labelValue="${condition.departmentName}" 
				title="部门" url="/sys/office/treeData?type=2&isAll=true" cssClass="input-small" allowClear="true" notAllowSelectParent="true" cssStyle="height:29px;width:163px;"/></c:if>
				<c:if test="${bossFlag!=0 }">${condition.departmentName }<input type="hidden" name="condition.department" value="${condition.department}"/></c:if>
			</li>
			<li><label>单据编号：</label>
				<input type="text" value="${condition.transaction }" name="condition.transaction" maxlength="200" style="height:29px;width:163px;"/>
			</li>
			<li><label>名字：</label>
				<input type="text" value="${condition.name }" name="condition.name" maxlength="200" style="height:29px;width:163px;"/>
			</li>
			<li><label>状态：</label>
			<select id="flagType" name="condition.flag" style="width:130px;">
			<option value="">--请选择状态--</option>
			<option value="0">审批中</option>
			<option value="1">已审批</option>
			<option value="2">未通过</option>
			<option value="3">已终止</option></select>
				<input type="hidden" value="${condition.flag }" id="hiddenFlag"/>
			</li>
			<li><label>时间段：</label>
				<input type="text" style="height:29px;width:163px;" class="input Wdate" value="<fmt:formatDate value='${condition.beginTime }' pattern='yyyy-MM-dd HH:mm'/>" name="condition.beginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false});"/>--
				<input type="text" style="height:29px;width:163px;" class="input Wdate" value="<fmt:formatDate value='${condition.endTime }' pattern='yyyy-MM-dd HH:mm'/>" name="condition.endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
		</c:if>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
				<th>申领单编号</th>
				<th>归属部门</th>
				<th>名字</th>
				<th>申请时间</th>
				<th>情况等级</th>
				<th>操作</th>
				<th>状态</th>
				</tr></thead>
		<tbody>
			<c:forEach var="item" items="${page.list }">
			<tr>
					<td>${item.transaction }</td>
					<td>${item.departmentName }</td>
					<td>${item.name }</td>
					<td><fmt:formatDate value='${item.createDate }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
					<td>
					<c:if test="${item.emergency == 0 }">普通</c:if>
					<c:if test="${item.emergency == 1 }">紧急</c:if>
					<c:if test="${item.emergency == 2 }">加急</c:if></td>
					<td>
	    				<a href="${ctx}/work/apply/edit?item.id=${item.id}&state=${state}">查看</a>
						<shiro:hasPermission name="work:apply:delete"><a href="${ctx}/work/apply/del?item.id=${item.id}" onclick="return confirmx('确认要删除该条记录吗？', this.href)">删除</a></shiro:hasPermission>
						<c:if test="${state==0 }"><a href="${ctx}/work/apply/termination?item.id=${item.id}" onclick="return confirmx('确认要终止该条记录吗？', this.href)">终止</a></c:if>
					</td>
					<td>
						<c:if test="${item.flag==0 }">审批中</c:if>
						<c:if test="${item.flag==1 }">已审批</c:if>
						<c:if test="${item.flag==2 }">未通过</c:if>
						<c:if test="${item.flag==3 }">已终止</c:if>
					</td>
				</tr>
	</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
