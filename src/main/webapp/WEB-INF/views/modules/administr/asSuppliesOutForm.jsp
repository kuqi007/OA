<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>商品出库详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 去掉框架的渲染
			$("#s2id_type1").remove();
			$("#s2id_type2").remove();
			$("#type1").removeAttr("class");
			$("#type2").removeAttr("class");
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/office/treeData",
				   data: "type=2&isAll=true",
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
					   }
					   $("#type1").html(selectText);
					   type2();
				   }
			});
			// 动态加载二级类别
			$("#type1").change(function(){
				type2();
			});
			
			// 去掉框架的渲染
			$("#s2id_type3").remove();
			$("#s2id_type4").remove();
			$("#type3").removeAttr("class");
			$("#type4").removeAttr("class");
			// 加载一级类别
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/product/listProductType",
				   data: "item.upper=0",
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
					   }
					   $("#type3").html(selectText);
					   type4();
				   }
			});
			// 动态加载二级类别
			$("#type3").change(function(){
				type4();
			});
			// 动态加载办公用品
			$("#type4").change(function(){
				supplies();
			});
			productList();
		});
		// 移除用品
		function re(){
			$(".removeProduct").click(function(){
				$(this).parent().parent().remove();
				productList();
			});
		}
		// 记录物品列表数据  格式：物品id-物品数量, 物品id-物品数量
		function productList(){
			var list=$("#myTable").find(".suppliesIds");
			var str="";
			for(i=0;i<list.length;i++){
				var model=list.eq(i);
				var pid=model.val();
				var num=model.parent().next().next().text();
				if(i!=list.length-1){
					str+=pid+"-"+num+",";
				}else{
					str+=pid+"-"+num;
				}
			}
			$("#products").val(str);
		}
		function type2(){
			if($("#officeId").val()!=""){
				$("#type1").val($("#officeId").val());// 还原部门信息
			}
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/user/treeData2",
				   data: "officeId="+$("#type1").val(),
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
					   }
					   $("#type2").html(selectText);
					   if($("#peopleId").val()!=""){
						   $("#type2").val($("#peopleId").val());// 还原签收人信息
					   }
				   }
			});
		}
		function type4(){
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/product/listProductType",
				   data: "item.upper="+$("#type3").val(),
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
					   }
					   $("#type4").html(selectText);
					   supplies();
				   }
			});
		}
		function supplies(){
			$.ajax({
				   type: "POST",
				   url: "${ctx}/administr/suppliesOut/listSuppliesByType",
				   data: "typeId="+$("#type4").val(),
				   success: function(date){
					   var selectText="";
					   selectText+="<caption>办公用品列表</caption>";
					   selectText+="<tr>";
					   selectText+="<td>用品名字</td>";
					   selectText+="<td>剩余数量</td>";
					   selectText+="<td>计量单位</td>";
					   selectText+="<td>添加数量</td>";
					   selectText+="<td>操作</td>";
					   selectText+="</tr>";
					   for(var i=0;i<date.length;i++){
						   selectText+="<tr>";
						   selectText+="<td style='display:none'><input type='hidden' value='"+date[i].id+"'/></td>";
						   selectText+="<td>"+date[i].name+"</td>";
						   selectText+="<td>"+date[i].num+"</td>";
						   selectText+="<td>"+date[i].company+"</td>";
						   selectText+="<td><input style='width:50px;' class='nums digits' value='1'/></td>";
						   selectText+="<td><a class='addProduct' href='javascript:void(0);'>添加到列表</a></td>";
						   selectText+="</tr>";
					   }
					   $("#listTable").html(selectText);
					   event();
				   }
			});
		}
		function event(){
			// 为空时自动填充1
			$(".nums").blur(function(){
				if($(this).val()=="")$(this).val(1);
			});
			// 点击添加按钮，将商品添加到右侧列表
			$(".addProduct").click(function(){
				var id=$(this).parent().prev().prev().prev().prev().prev().children().val();// 产品id
				var name=$(this).parent().prev().prev().prev().prev().text();// 产品名字
				var num=$(this).parent().prev().children().val();// 用户选择添加的产品数量
				// 查重
				var ids =$(".suppliesIds");
				for(i=0;i<ids.length;i++){
					if(id==ids.eq(i).val()){
						showTip("已存在此物品");
						return;
					}
				}
					var str="<tr>";
					str+="<td style='display:none'><input class='suppliesIds' type='hidden' value='"+id+"'/></td>";
					str+="<td>"+name+"</td>";
					str+="<td>"+num+"</td>";
					str+="<td><a class='removeProduct' href='javascript:void(0);'>移除</a></td>";
					str+="</tr>";
					$("#myTable").append(str);
					re();
					productList();
			});
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/administr/suppliesOut/${urll }">办公用品出库列表</a></li>
		<li class="active"><a href="${ctx}/administr/suppliesOut/edit?item.id=${item.id}&urlFlag=${urll}">办公用品出库${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" action="${ctx}/administr/suppliesOut/save${sign }" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="products" name="products" value="" type="hidden"/>
		<div class="control-group">
			<label class="control-label">签收人部门:</label>
			<div class="controls">
			<input type="hidden" value="${officeId }" id="officeId"/>
				<select id="type1">
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签收人名字:</label>
			<div class="controls">
			<input type="hidden" value="${item.peopleId }" id="peopleId"/>
				<select id="type2" name="item.peopleId">
				</select>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">出库用品选择:</label>
			<div class="controls">
		<c:if test="${addFlag==1 }">
		<div style="width:500px;overflow: hidden;float: left;">
	    <select id="type3" style="float: left;display: none;">
		</select>
		<select id="type4" style="float: left;display: none;">
		</select>
		<table border="1" id="listTable" style="float: left;margin-top: 30px;">
		</table>
		</div>
		</c:if>
		<table border="1" id="myTable" style="float: left;margin-left: 100px;">
		<caption>出库列表</caption>
			<tr>
			<td>用品名字</td>
			<td>数量</td>
			<c:if test="${addFlag==1 }"><td>操作</td></c:if>
			</tr>
			<c:forEach items="${list }" var="supplies">
			<tr>
				<td style="display:none"><input class="suppliesIds" type="hidden" value="${supplies.articles }"/></td>
				<td>${supplies.articlesName }</td>
				<td>${supplies.num }</td>
			</tr>
			</c:forEach>
		</table>
		</div>
		</div>
		<div class="form-actions">
			<c:if test="${addFlag==1 }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</c:if>
			<c:if test="${urll=='listAsSuppliesOut0' }"><input class="btn btn-primary" type="submit" value="确认签收"/></c:if>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>