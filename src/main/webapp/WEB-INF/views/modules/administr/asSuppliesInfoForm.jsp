<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>商品入库详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 去掉框架的渲染
			$("#s2id_type").remove();
			$("#type").removeAttr("class");
			// 采购单的加载
			$.ajax({
				   type: "POST",
				   url: "${ctx}/work/shopping/listShopping",
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].serialNumber+"</option>";
					   }
					   $("#shoppingIdSelect").html(selectText);
					   if($("#shoppingIdSelect").text()==""){
						   $(".select2-chosen").text("未找到符合要求的采购单")
						}else{
						   $(".select2-chosen").text($("#shoppingIdSelect").text().substring(0,17));// 强行写入
					   };
					   
				   }
			});
			$(".Input1").css("border","2px solid #c59562");
			$(".Input1").click(function(){
				$("#select1").css("display","block");
				$("#select2").css("display","none");
				$(".Input1").css("border","2px solid #c59562");
				$(".Input2").css("border","0px");
			});
			$(".Input2").click(function(){
				$("#select2").css("display","block");
				$("#select1").css("display","none");
				$(".Input2").css("border","2px solid #c59562");
				$(".Input1").css("border","0px");
			});
			// 根据采购单的唯一流水号更新仓库办公用品信息
			$("#btnSubmitAjax").click(function(){
				$.ajax({
					   type: "POST",
					   url: "${ctx}/administr/suppliesInfo/updateAsSuppliesById",
					   data: "shoppingId="+$("#shoppingIdSelect").val()+"&id="+$("#shoppingIdSelect").text(),
					   success: function(date){
						   alert("入库成功！");
						   document.getElementById("updateSelect").click()
					   }
				});
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/administr/suppliesInfo/listAsSuppliesInfoByPage">办公用品入库信息列表</a></li>
		<li class="active"><a id="updateSelect" href="${ctx}/administr/suppliesInfo/edit?item.id=${item.id}">办公用品入库信息${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" action="${ctx}/administr/suppliesInfo/saveAsSuppliesInfo" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<div class="control-group">
				<label class="control-label">入库方式:</label>
				<div class="controls">
					<span class="Input1 btn">手动录入</span><span class="Input2 btn">根据采购单流水号录入</span>
				</div>
			</div>
		<div id="select1">
			<div class="control-group">
				<label class="control-label">入库用品:</label>
				<div class="controls">
					<select id="type" name="item.articles">
					<c:forEach items="${listaSupplies }" var="su" >
					<option value="${su.id }">${su.name }</option>
					</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">数量:</label>
				<div class="controls">
					 <input id="num" name="item.num" type="text" class="required digits"/>
					 <span class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
			<div class="form-actions">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</div>
		<div id="select2" style="display:none;">
			<div class="control-group">
				<label class="control-label">采购订单流水号:</label>
				<div class="controls">
					<select id="shoppingIdSelect">
					</select>&nbsp;（保存前请仔细核对）
				</div>
			</div>
			<div class="form-actions">
			<input id="btnSubmitAjax" class="btn btn-primary" type="button" value="保 存"/>&nbsp;
			<input id="btnCancelAjax" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</div>
	</form:form>
</body>
</html>