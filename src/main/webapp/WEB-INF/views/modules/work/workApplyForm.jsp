<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>办公用品申领单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			// 职务的控制
			var roleInput=$("#roleInput").val();
			var roleInputName=$("#roleInputName").val();
			if(roleInput!=""){
				$("#role").val(roleInput);
			}
			// 领导签字显示控制
			var state=$("#pstater").val();
				if(state==1){
					$("#examine1").attr("style","display:block;");
				}else if(state==2){
					$("#examine2").attr("style","display:block;");
				}
			
			/* 单选按钮控制 */
			// 领导同意单选按钮
			var opinion1=$("#opinion1").val();
			var opinion2=$("#opinion2").val();
			if(opinion1!=""){if(opinion1==1){$("#opinion1ra1").attr("checked","checked");}else{$("#opinion1ra2").attr("checked","checked");}}
			if(opinion2!=""){if(opinion2==1){$("#opinion2ra1").attr("checked","checked");}else{$("#opinion2ra2").attr("checked","checked");}}
			
			// 去掉框架的渲染
			$("#s2id_type1").remove();
			$("#s2id_type2").remove();
			$("#type1").removeAttr("class");
			$("#type2").removeAttr("class");
			
			$("#s2id_productLists").remove();
			$("#productLists").removeAttr("class");
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
					   $("#type1").html(selectText);
					   type2();
				   }
			});
			// 动态加载二级类别
			$("#type1").change(function(){
				type2();
			});
			$("#type2").change(function(){
				supplies();
			});
			$("#productLists").change(function(){
				supplies2();
			});
			event();
		});
		function re(){
			$(".removeProduct").click(function(){
				$(this).parent().parent().remove();
				productList();
			});
		}
		function type2(){
			$.ajax({
				   type: "POST",
				   url: "${ctx}/sys/product/listProductType",
				   data: "item.upper="+$("#type1").val(),
				   success: function(date){
					   var selectText="";
					   for(var i=0;i<date.length;i++){
						   selectText+="<option value='"+date[i].id+"'>"+date[i].name+"</option>";
					   }
					   $("#type2").html(selectText);
					   supplies();
				   }
			});
	}
		// 加载用品
		function supplies(){
			$.ajax({
				   type: "POST",
				   url: "${ctx}/administr/suppliesOut/listSuppliesByType",
				   data: "typeId="+$("#type2").val(),
				   success: function(date){
					   for(var i=0;i<date.length;i++){
						   $("#productLists").append("<option value='"+date[i].id+"'>"+date[i].name+"</option>");
					   supplies2();
				   }
			}
				   });
		}
		// 填充用品数据
		function supplies2(){
			$.ajax({
				   type: "POST",
				   url: "${ctx}/administr/supplies/getAsSuppliesById",
				   data: "id="+$("#productLists").val(),
				   success: function(date){
					   $("#warehouseNum").val(date.num);
					   $("#company").text(date.company);
				   }
			});
		}
		// 添加按钮点击事件
		function event(){
			// 点击添加按钮，将商品添加到右侧列表
			$("#addBtn2").click(function(){
				var id=$("#productLists").find("option:selected").val();// 产品id
				var name=$("#productLists").find("option:selected").text();// 产品名字
				var num=$("#addNum").val();// 用户选择添加的产品数量 
				var company=$("#company").text();// 计量单位 
				if(num==""||num==null||num=="0"){
					showTip("数量不能为空");
					return;
					}
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
					str+="<td class='count'>"+num+"</td>";
					str+="<td>"+company+"</td>";
					str+="<td><a class='removeProduct' href='javascript:void(0);'>移除</a></td>";
					str+="</tr>";
					$("#myTable").append(str);
					re();
					$(".number").keyup(function(){
						sumMoney();
					});
					productList();
			});
		}
		// 记录物品列表数据  格式：物品id-物品数量-价格
		function productList(){
			var list=$("#myTable").find(".suppliesIds");
			var str="";
			var sum=0;
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/apply/listflowType">办公用品申领单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/apply/list">办公用品申领单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/apply/edit?item.id=${item.id}">办公用品申领单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/2.png">
	</div>
	<sys:message content="${message}"/>
	<form:form id="inputForm" modelAttribute="workApplyForm" action="${ctx}/work/apply/saveWorkApply" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="products" name="products" value="" type="hidden"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		<!-- 5个老大的id，为空则代表其没有做操作（） -->
		<input type="hidden" id="people1" value="${item.people1}" name="item.people1"/>
		<input type="hidden" id="people2" value="${item.people2}" name="item.people2"/>
		
		<c:if test="${addFlag ==1 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName}</label>
			<input type="hidden" id="department" value="${item.department}" name="item.department" />
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">职务:</label>
			<div class="controls">
			<label class="lbl">${postName }</label>
			<input type="hidden" id="roleInput" value="${item.post }" name="item.post"/><!-- 编号 -->
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<label class="lbl">${item.name }</label>
                <input id="name" name="item.name" value="${item.name }" type="hidden"/>
			</div>
		</div>
		<div class="control-group" style="display: none">
			<label class="control-label">产品一级类:</label>
			<div class="controls">
			<select id="type1" name="item.type1" >
			</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办公用品选择:</label>
			<div class="controls">
			<select id="type2" name="item.type2" style="float: left;display: none;">
			</select>
			<select id="productLists" style="float: left;"></select>
			<table border="1" id="listTable" style="float: left;margin-left: 20px;">
			</table>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">仓库数量:</label>
			<div class="controls">
			<input id="warehouseNum" type="text" readonly="readonly"/>(<label id="company"></label>)
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">申领数量:</label>
			<div class="controls">
			<input id="addNum" type="text" class="required digits" /><input id="addBtn2" type="button" value="添加" class="btn"/>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">申领列表:</label>
			<div class="controls">
			<table border="1" id="myTable" >
			<tr>
			<td>用品名字</td>
			<td>数量</td>
			<td>计量单位</td>
			<c:if test="${addFlag==1 }"><td>操作</td></c:if>
			</tr>
		</table>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
			<textarea id="remarks" name="item.remarks"></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单据紧急情况:</label>
			<div class="controls">
				<form:select path="item.emergency">
					<form:options items="${fns:getDictList('flag_emergency')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		</c:if>
		<c:if test="${addFlag ==0 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职务:</label>
			<div class="controls">
			<label class="lbl">${postName }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">申领列表:</label>
		<div class="controls">
			<table border="1" id="myTable">
			<!-- <caption>采购列表</caption> -->
			<tr>
			<td>用品名字</td>
			<td>数量</td>
			<td>计量单位</td>
			<c:if test="${addFlag==1 }"><td>操作</td></c:if>
			</tr>
			<c:forEach items="${list }" var="supplies">
			<tr>
				<td style="display:none"><input class="suppliesIds" type="hidden" value="${supplies.articles }"/></td>
				<td>${supplies.articlesName }</td>
				<td>${supplies.num }</td>
				<td>${supplies.company }</td>
			</tr>
			</c:forEach>
		</table>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
			<label class="lbl">${item.remarks }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单据紧急情况:</label>
			<div class="controls">
				<form:select path="item.emergency" disabled="true">
					<form:options items="${fns:getDictList('flag_emergency')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<c:if test="${state!=0 && saveBut !=0 }">
		<div class="control-group" style="display: none;" id="examine1">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text1" rows="2">${item.text1 }</textarea><br/><br/>
				<input id="opinion1ra1" value="1" type="radio" name="item.opinion1" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion1ra2" value="2" type="radio" name="item.opinion1" class="required"/>不同意
				<input id="opinion1" value="${item.opinion1 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign1" name="item.sign1" value="${item.sign1 }" />
					<input type="hidden" value="<fmt:formatDate value='${item.date1 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date1"/> 
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine2">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text2" rows="2">${item.text2 }</textarea><br/><br/>
				<input id="opinion2ra1" value="1" type="radio" name="item.opinion2" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion2ra2" value="2" type="radio" name="item.opinion2" class="required"/>不同意
				<input id="opinion2" value="${item.opinion2 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign2" name="item.sign2" value="${item.sign2 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date2 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date2"/>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${not empty listSign }">
		<div class="control-group">
			<label class="control-label">审批情况：</label><br/>
				<div class="controls">
					<table border="1">
					<tr><td>序号</td><td>处理步骤</td><td>签名</td><td>情况</td><td>审批日期</td><td>审批意见</td></tr>
					<c:forEach items="${listSign }" var="signInfo" varStatus="varStatus">
					<tr><td>${varStatus.count }</td>
					<td>${signInfo.signName }</td>
					<td><img style="width:120px;height:60px;" alt="审批人签名" src="${signInfo.sign }"> </td>
					<td><c:if test="${signInfo.operation==1 }"><img src="${ctxUserfiles }/staticImages/yes.png" width="20" height="20"/></c:if><c:if test="${signInfo.operation==2 }"><img src="${ctxUserfiles }/staticImages/no.png" width="20" height="20"/></c:if></td>
					<td><fmt:formatDate value='${signInfo.dateTime }' pattern='yyyy-MM-dd HH:mm:ss'/></td>
					<td>${signInfo.text }</td></tr>
					</c:forEach>
					</table>
				</div>
		</div>
		</c:if>
		</c:if>
		<div class="form-actions">
			<c:if test="${saveBut !=0 && item.state!=0  && item.state!=100  }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/></c:if>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>