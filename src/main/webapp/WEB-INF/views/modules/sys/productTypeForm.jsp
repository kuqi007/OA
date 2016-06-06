<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>产品类型管理详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 类型的控制
			var upperId=$("#upperId").val();
			if(upperId!=0){
				$("#typeSelect").val(upperId);
				$(".select2-chosen").text($("#typeSelect option:selected").text());// 强行改变O(∩_∩)O哈哈~
			}
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/product/list">产品类型列表</a></li>
		<li class="active"><a href="${ctx}/sys/product/edit?id=${item.id}">产品类型${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/product/saveProductType" method="post" class="form-horizontal">
			<!-- state  0-表示用户点击的 查看
            				注：item.upper等于0表示其类型为一级类型！
						1-表示用户点击的 添加下级类型
						3-表示用户点击的 添加类型 -->
	
		<c:if test="${state==0 }"><input id="id" value="${item.id }" type="hidden" name="item.id"/></c:if>
		<div class="control-group">
			<label class="control-label">类型名称:</label>
			<div class="controls">
                <input id="name" name="item.name" <c:if test="${state==0 }">value="${item.name }"</c:if> type="text" maxlength="50" class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<c:choose>
			<c:when test="${state==0 && item.upper!='0' }">
				<div class="control-group">
				<label class="control-label">上级类型:</label>
				<div class="controls">
				<input type="hidden" id="upperId" value="${item.upper }"/>
	             <select id="typeSelect" name="item.upper">
	                <c:forEach var="typee" items="${listProductType }">
	                	<option value="${typee.id }">${typee.name }</option>
	                </c:forEach>
	             </select>
	            
				</div>
			</div>
			</c:when>
			<c:when test="${state==1 }"><!-- 添加下级类别时，其上级类别就是本类别的id -->
				<input type="hidden" id="upperId" name="item.upper" value="${item.id }"/>
			</c:when>
			<c:when test="${state==0 && item.upper=='0' }">
				<input type="hidden" id="upperId" name="item.upper" value="${item.upper }"/>
			</c:when>
			<c:when test="${state==3 }">
				<input type="hidden" id="upperId" name="item.upper" value="0"/>
			</c:when>
		</c:choose>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>