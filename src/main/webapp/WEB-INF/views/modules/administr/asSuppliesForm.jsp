<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>商品库存详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 去掉框架的渲染
			$("#s2id_type").remove();
			$("#type").removeAttr("class");
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/product/listProductType",
				   data: "item.upper=3",
				   success: function(date){
					   var selectText="";
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
		<li><a href="${ctx}/administr/supplies/listAsSuppliesByPage">办公用品列表</a></li>
		<li class="active"><a href="${ctx}/administr/supplies/edit?item.id=${item.id}">办公用品${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" action="${ctx}/administr/supplies/save" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<div class="control-group">
			<label class="control-label">用品名字:</label>
			<div class="controls">
                <input id="name" name="item.name" value="${item.name }" type="text" class="required"/>
                <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<input type="hidden" value="095bb1d60b5a4c24be93a81bc59b07f2" name="item.type" /><!-- 这是一级类（办公用品）下面的二级类（办公用品）的id -->
		<%-- <div class="control-group">
			<label class="control-label">用品类别:</label>
			<div class="controls">
			<input id="typeHidden" value="${item.type }" type="hidden"/>
				<select id="type" name="item.type" >
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
	<%-- 	<div class="control-group">
			<label class="control-label">用品价格:</label>
			<div class="controls">
				 <input id="price" name="item.price" value="${item.price }" type="text" class="required number"/>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">数量:</label>
			<div class="controls">
				 <input id="num" name="item.num" value="${item.num }" type="text" class="required digits"/>
				 <span class="help-inline"><font color="red">*（必填，可填0）</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计量单位:</label>
			<div class="controls">
				 <input id="company" name="item.company" value="${item.company }" type="text" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>