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
/* 时间格式化函数*/
	Date.prototype.Format = function(fmt) { //author: meizz 
		var o = {
			"M+" : this.getMonth() + 1, //月份 
			"d+" : this.getDate(), //日 
			"h+" : this.getHours(), //小时 
			"m+" : this.getMinutes(), //分 
			"s+" : this.getSeconds(), //秒 
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
			"S" : this.getMilliseconds()
		//毫秒 
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	function queryMonth(){
	var now = new Date();//当前时间
	var lastMonth = new Date(now.getFullYear(),now.getMonth()-1,1);/* 上个月1号 */
	var thisMonth = new Date(now.getFullYear(),now.getMonth(),0);/* 上个月最后一天*/
	$("#beginDate").val((new Date(lastMonth)).Format("yyyy-MM-dd"));
	$("#endDate").val((new Date(thisMonth)).Format("yyyy-MM-dd"));
	}
	function queryYesterday(){
	var now = new Date();//当前时间
	var lastMonth = new Date(now.getFullYear(),now.getMonth(),now.getDate()-1);/*  */
	/* var thisMonth = new Date(now.getFullYear(),now.getMonth(),now.getDate());/*  */ 
	$("#beginDate").val((new Date(lastMonth)).Format("yyyy-MM-dd"));
	$("#endDate").val((new Date(lastMonth)).Format("yyyy-MM-dd"));
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
		action="${ctx}/checkin/listOaCheckinoutByPage" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="page.pageNo" type="hidden"
			value="${page.pageNo}" />
		<input id="pageSize" name="page.pageSize" type="hidden"
			value="${page.pageSize}" />
		<div>
		
			<label>姓名：</label><input id="condition.userName" name="condition.userName" type="text"
				maxlength="50" class="input-mini" value="${condition.userName}" /> <label>工号：</label><input
				id="condition.userNo" name="condition.userNo" type="text" maxlength="50"
				class="input-mini" value="${condition.userNo}" /> <label>部门：</label><sys:treeselect id="office" name="condition.office.id" value="${condition.office.id}" labelName="condition.office.name" labelValue="${condition.office.name}" 
				title="部门" url="/sys/office/treeData?type=2&isAll=true" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
				 <%-- <label>部门：</label><input
				id="condition.office" name="condition.office" type="text" maxlength="50"
				class="input-mini" value="${condition.office}" /> --%>&nbsp;&nbsp; 
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
			&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary"
				type="submit" value="自定义查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btnSubmitMonth" class="btn btn-primary"
				type="submit" onclick="queryMonth()"value="查询上月" />&nbsp;&nbsp;<input id="btnSubmitYesterday" class="btn btn-primary"
				type="submit" onclick="queryYesterday()"value="查询昨日" />
				
				
		</div>
		<div style="margin-top: 8px;">
			
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
					<c:if test="${check.user.no eq 11}"><td><strong>李扣芳阿姨</strong></td></c:if>
					<c:if test="${check.user.no ne 11}"><td><strong>${check.user.name}</strong></td></c:if>
					<%-- <td><strong>${check.user.name}</strong></td> --%>
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