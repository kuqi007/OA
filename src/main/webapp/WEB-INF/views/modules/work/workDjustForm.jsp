<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>商品价格调整审批单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			// 流程图
			 $("#liuChen").hover(function(){
				$("#liuChen").stop().animate({ 
				    height: "273",
				    width:"186"
				  }, 500 );
			},function(){
				$("#liuChen").stop().animate({ 
					height: "25",
				    width:"186"
				  }, 500 );
			});
			
			
			// 职务的控制
			var roleInput=$("#roleInput").val();
			var roleInputName=$("#roleInputName").val();
			if(roleInput!=""){
				$("#role").val(roleInput);
			}
			if(roleInputName!=""){
				$(".select2-chosen").text(roleInputName);// 强行改变O(∩_∩)O哈哈~
			}
			// 领导签字显示控制
			var state=$("#pstater").val();
				if(state==1){
					$("#examine1").attr("style","display:block;");
				}else if(state==2){
					$("#examine2").attr("style","display:block;");
				}else if(state==3){
					$("#examine3").attr("style","display:block;");
				}else if(state==4){
					$("#examine4").attr("style","display:block;");
				}else if(state==5){
					$("#examine5").attr("style","display:block;");
				}
			
			
			// 领导同意单选按钮
			var opinion1=$("#opinion1").val();
			var opinion2=$("#opinion2").val();
			var opinion3=$("#opinion3").val();
			var opinion4=$("#opinion4").val();
			var opinion5=$("#opinion5").val();
			if(opinion1!=""){if(opinion1==1){$("#opinion1ra1").attr("checked","checked");}else{$("#opinion1ra2").attr("checked","checked");}}
			if(opinion2!=""){if(opinion2==1){$("#opinion2ra1").attr("checked","checked");}else{$("#opinion2ra2").attr("checked","checked");}}
			if(opinion3!=""){if(opinion3==1){$("#opinion3ra1").attr("checked","checked");}else{$("#opinion3ra2").attr("checked","checked");}}
			if(opinion4!=""){if(opinion4==1){$("#opinion4ra1").attr("checked","checked");}else{$("#opinion4ra2").attr("checked","checked");}}
			if(opinion5!=""){if(opinion5==1){$("#opinion5ra1").attr("checked","checked");}else{$("#opinion5ra2").attr("checked","checked");}}
			
			change();
		});
		function addProduct(){
			$("#productTable").append('<tr><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td><td><textarea></textarea></td><td><input  class="input Wdate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm:ss\',isShowClear:false,onpicked:upProduct});" type="text"/></td></tr>');
			change();
		}
		// 记录添加的商品
		function upProduct(){
			var pstr="";
			// 遍历table中的数据
			for(i=1; i < document.getElementById("productTable").rows.length; i++)
			{
			　　for(j=0; j < document.getElementById("productTable").rows[i].cells.length; j++)
			　　{
				var vv=document.getElementById("productTable").rows[i].cells[j];
				var values="";
				if(j==11){
					values=vv.getElementsByTagName("textarea")[0].value;// 申请原因
				}else{
					values=vv.getElementsByTagName("input")[0].value;
				}
				pstr+=values;
				if(j!=12){pstr+="_";}
			　　}
			if(i < $("#productTable tr").length-1){pstr+=",";}
			}
			$("#products").val(pstr);
		}
		function change(){
			$("#productTable tr td input").css("width","120");
			$("#productTable tr td input").css("border","0");
			$("#productTable tr td input.Wdate").css("width","160");
			$("#productTable tr td input,#productTable tr td textarea").keyup(function(){
				upProduct();
			});
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/djust/listflowType">商品价格调整审批单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/djust/list">商品价格调整审批单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/djust/edit?item.id=${item.id}">商品价格调整审批单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
 	<div id="liuChen" style="width:186px;height:25px;margin-left: 1100px;position: absolute;overflow: hidden;">
		<h5 class="title" style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/55.png">
	</div>
	<sys:message content="${message}"/>
	<form:form id="inputForm" modelAttribute="workDjustForm" action="${ctx}/work/djust/save?state=${state }" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="products" name="products" value="" type="hidden"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		
		<input type="hidden" id="people1" value="${item.people1}" name="item.people1"/>
		<input type="hidden" id="people2" value="${item.people2}" name="item.people2"/>
		<input type="hidden" id="people3" value="${item.people3}" name="item.people3"/>
		<input type="hidden" id="people4" value="${item.people4}" name="item.people4"/>
		<input type="hidden" id="people5" value="${item.people5}" name="item.people5"/>
		
		<c:if test="${addFlag ==1 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName}</label> 
			<input type="hidden" id="department" value="${item.department}" name="item.department" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<label class="lbl">${item.name }</label>
                <input id="name" name="item.name" value="${item.name }" type="hidden"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格调整商品:</label>
			<div class="controls">
			<table border="1" id="productTable">
			<tr><th>E得货号</th><th>商品品牌</th><th>供应商</th><th>商品名称</th><th>规格/型号</th><th>原供货价</th><th>现供货价</th><th>上调/下调（%）</th><th>原E得价</th><th>现E得价</th><th>上调/下调（%）</th><th>申请原因</th><th>调整日期</th></tr>
			<tr>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><input type="text"/></td>
			<td><textarea></textarea> </td>
			<td><input type="text" class="input Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false,onpicked:upProduct});" /></td></tr>
			</table>
			<input value="继续添加" type="button" onclick="addProduct();">
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
			<label class="control-label">姓名:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格调整商品:</label>
			<div class="controls">
			<table border="1" id="productTable">
			<tr><th>E得货号</th><th>商品品牌</th><th>供应商</th><th>商品名称</th><th>规格/型号</th><th>原供货价</th><th>现供货价</th><th>上调/下调（%）</th><th>原E得价</th><th>现E得价</th><th>上调/下调（%）</th><th>申请原因</th><th>调整日期</th></tr>
			<c:forEach var="djust" items="${list }">
			<tr>
			<td>${djust.ehavingid }</td>
			<td>${djust.brand }</td>
			<td>${djust.supplier }</td>
			<td>${djust.name }</td>
			<td>${djust.specifications }</td>
			<td>${djust.priceOld }</td>
			<td>${djust.priceNew }</td>
			<td>${djust.percentage }</td>
			<td>${djust.onpriceOld }</td>
			<td>${djust.onpriceNew }</td>
			<td>${djust.onpercentage }</td>
			<td>${djust.reason }</td>
			<td><fmt:formatDate value='${djust.time }' pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
			</tr>
			</c:forEach>
			</table>
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
		<c:if test="${state!=0 && saveBut !=0}">
		<div class="control-group" style="display: none;" id="examine1">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text1" rows="2" placeholder="请输入审批意见...">${item.text1 }</textarea><br/><br/>
				<input id="opinion1ra1" value="1" type="radio" name="item.opinion1" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion1ra2" value="2" type="radio" name="item.opinion1" class="required"/>不同意
				<input id="opinion1" value="${item.opinion1 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign1" name="item.sign1" value="${item.sign1 }" />
				<%-- 	<sys:ckfinder input="sign1" type="images" uploadPath="/sign" selectMultiple="false" maxWidth="100" maxHeight="100"/>--%>
					<input type="hidden" value="<fmt:formatDate value='${item.date1 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date1"/> 
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine2">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text2" rows="2" placeholder="请输入审批意见...">${item.text2 }</textarea><br/><br/>
				<input id="opinion2ra1" value="1" type="radio" name="item.opinion2" class="required"/>确认
				<input id="opinion2" value="${item.opinion2 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign2" name="item.sign2" value="${item.sign2 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date2 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date2"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine3">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text3" rows="2" placeholder="请输入审批意见...">${item.text3 }</textarea><br/><br/>
				<input id="opinion3ra1" value="1" type="radio" name="item.opinion3" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion3ra2" value="2" type="radio" name="item.opinion3" class="required"/>不同意
				<input id="opinion3" value="${item.opinion3 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign3" name="item.sign3" value="${item.sign3 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date3 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date3"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine4">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text4" rows="2" placeholder="请输入审批意见...">${item.text4 }</textarea><br/><br/>
				<input id="opinion4ra1" value="1" type="radio" name="item.opinion4" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion4ra2" value="2" type="radio" name="item.opinion4" class="required"/>不同意
				<input id="opinion4" value="${item.opinion4 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign4" name="item.sign4" value="${item.sign4 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date4 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date4"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine5">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text5" rows="2" placeholder="请输入审批意见...">${item.text5 }</textarea><br/><br/>
				<input id="opinion5ra1" value="1" type="radio" name="item.opinion5" class="required"/>确认
				<input id="opinion5" value="${item.opinion5 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign5" name="item.sign5" value="${item.sign5 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date5 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date5"/>
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
			<c:if test="${saveBut !=0 && item.state!=0 && item.state!=100  }"><input id="btnSubmit" class="btn btn-primary" type="submit" value="提 交"/></c:if>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>