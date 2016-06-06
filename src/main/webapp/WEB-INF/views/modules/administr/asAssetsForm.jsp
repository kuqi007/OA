<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>固定资产详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			// 去掉框架的渲染
			$("#s2id_type1").remove();
			$("#type1").removeAttr("class");
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/office/treeData",
				   data: "type=2",
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
					   }
					   $("#type1").html(selectText);
					   $("#type1").val($("#departmentIdHidden").val());
				   }
			});
			$("#number").blur(function(){
				if($("#number").val()!=""){
					$.ajax({
						   type: "POST",
						   url: "${ctx}/administr/assets/selectCheck",
						   data:"number="+$("#number").val(),
						   success: function(date){
							   if(date==false){
								   showTip("此资产编号已存在！");
								   $("#number").val("");
							   }
						   }
					});	
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/administr/assets/listAsAssetsByPage">固定资产列表</a></li>
		<li class="active"><a href="${ctx}/administr/assets/edit?item.id=${item.id}">固定资产${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" action="${ctx}/administr/assets/saveAsAssets" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<div class="control-group">
			<label class="control-label">所属部门:</label>
			<div class="controls"><input id="departmentIdHidden" value="${item.departmentId }" type="hidden" />
				<select name="item.departmentId" id="type1">
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">购入时间:</label>
			<div class="controls">
				 <input id="time" readonly="readonly" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});" name="item.time" value="<fmt:formatDate value='${item.time }' pattern='yyyy-MM-dd'/>" type="text" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资产名字:</label>
			<div class="controls">
                <input id="name" name="item.name" value="${item.name }" type="text" class="required"/>
                <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资产编号:</label>
			<div class="controls">
				 <input id="number" name="item.number" value="${item.number }" type="text" class="required"/>
				 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资产型号:</label>
			<div class="controls">
				 <input id="model" name="item.model" value="${item.model }" type="text"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资产品牌:</label>
			<div class="controls">
				 <input id="brand" name="item.brand" value="${item.brand }" type="text" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格:</label>
			<div class="controls">
				 <input id="price" class="number" name="item.price" value="${item.price }" type="text" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数量:</label>
			<div class="controls">
				 <input id="count"  class="digits" name="item.count" value="${item.count }" type="text" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
			<textarea id="remarks" name="item.remarks">${item.remarks }</textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>