<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>积分撤销申请单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
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
				}else if(state==6){
					$("#examine6").attr("style","display:block;");
				}else if(state==7){
					$("#examine7").attr("style","display:block;");
				}else if(state==25){
					$("#examine2_5").attr("style","display:block;");
				}
			
			/* 单选按钮控制 */
			// 领导同意单选按钮
			var opinion1=$("#opinion1").val();
			var opinion2=$("#opinion2").val();
			var opinion3=$("#opinion3").val();
			var opinion4=$("#opinion4").val();
			var opinion5=$("#opinion5").val();
			var opinion6=$("#opinion6").val();
			var opinion7=$("#opinion7").val();
			var opinion2_5=$("#opinion2_5").val();
			if(opinion1!=""){if(opinion1==1){$("#opinion1ra1").attr("checked","checked");}else{$("#opinion1ra2").attr("checked","checked");}}
			if(opinion2!=""){if(opinion2==1){$("#opinion2ra1").attr("checked","checked");}else{$("#opinion2ra2").attr("checked","checked");}}
			if(opinion3!=""){if(opinion3==1){$("#opinion3ra1").attr("checked","checked");}else{$("#opinion3ra2").attr("checked","checked");}}
			if(opinion4!=""){if(opinion4==1){$("#opinion4ra1").attr("checked","checked");}else{$("#opinion4ra2").attr("checked","checked");}}
			if(opinion5!=""){if(opinion5==1){$("#opinion5ra1").attr("checked","checked");}else{$("#opinion5ra2").attr("checked","checked");}}
			if(opinion6!=""){if(opinion6==1){$("#opinion6ra1").attr("checked","checked");}else{$("#opinion6ra2").attr("checked","checked");}}
			if(opinion7!=""){if(opinion7==1){$("#opinion7ra1").attr("checked","checked");}else{$("#opinion7ra2").attr("checked","checked");}}
			if(opinion2_5!=""){if(opinion2_5==1){$("#opinion2_5ra1").attr("checked","checked");}else{$("#opinion2_5ra2").attr("checked","checked");}}
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/integral/listflowType">积分撤销申请单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/integral/list">积分撤销申请单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/integral/edit?item.id=${item.id}">积分撤销申请单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<%-- <div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/5.png">
	</div> --%>
	<sys:message content="${message}"/>
	<form:form id="inputForm" modelAttribute="workIntegralForm" action="${ctx}/work/integral/save" method="post" class="form-horizontal">
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="flowType" value="${flowType}"type="hidden" name="flowType"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		
		<input type="hidden" id="people1" value="${item.people1}" name="item.people1"/>
		<input type="hidden" id="people2" value="${item.people2}" name="item.people2"/>
		<input type="hidden" id="people2_5" value="${item.people2_5}" name="item.people2_5"/>
		<input type="hidden" id="people3" value="${item.people3}" name="item.people3"/>
		<input type="hidden" id="people4" value="${item.people4}" name="item.people4"/>
		<input type="hidden" id="people5" value="${item.people5}" name="item.people5"/>
		<input type="hidden" id="people6" value="${item.people6}" name="item.people6"/>
		<input type="hidden" id="people7" value="${item.people7}" name="item.people7"/>
		
		<c:if test="${addFlag ==1 }">
		<div class="control-group">
			<label class="control-label">所在部门:</label>
			<div class="controls">
			<label class="lbl">${item.departmentName}</label> 
			<input type="hidden" id="department" value="${item.department }" name="item.department" />
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
			<label class="control-label">客户姓名:</label>
			<div class="controls">
			 	<input id="uname" name="item.uname" type="text"  class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户交易账号:</label>
			<div class="controls">
			 	<input id="number" name="item.number" type="text" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户身份证号:</label>
			<div class="controls">
			 	<input id="card" name="item.card" type="text" class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户积分数量:</label>
			<div class="controls">
			 	<input id="uintegral" name="item.uintegral" type="text" class="required number"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员单位名称:</label>
			<div class="controls">
			 	<input id="unitname" name="item.unitname" type="text" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员单位联系电话:</label>
			<div class="controls">
			 	<input id="telephone" name="item.telephone" type="text" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" rows="2" name="item.remarks" class="required"></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片附件:</label>
			<div class="controls">
				<form:hidden id="nameImage" path="item.integralImage" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
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
			<label class="control-label">客户姓名:</label>
			<div class="controls">
			<label class="lbl">${item.uname }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户交易账号:</label>
			<div class="controls">
			<label class="lbl">${item.number }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户身份证号:</label>
			<div class="controls">
			<label class="lbl">${item.card }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户积分数量:</label>
			<div class="controls">
			<label class="lbl">${item.uintegral }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员单位名称:</label>
			<div class="controls">
			<label class="lbl">${item.unitname }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员单位联系电话:</label>
			<div class="controls">
			<label class="lbl">${item.telephone }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
			<label class="lbl">${item.remarks }</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片附件:</label>
			<div class="controls">
			<label class="lbl"><img src="${item.integralImage }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">财务退款数量:</label>
			<div class="controls">
			<label class="lbl">
			<c:if test="${item.refund==null }">暂未付款</c:if>
			<c:if test="${item.refund!=null }">${item.refund }</c:if>
			</label>
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
				<input id="opinion1ra1" value="1" type="radio" name="item.opinion1" class="required"/>已冻结
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
				<input id="opinion2ra1" value="1" type="radio" name="item.opinion2" class="required"/>客户同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion2ra2" value="2" type="radio" name="item.opinion2" class="required"/>客户不同意
				<input id="opinion2" value="${item.opinion2 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign2" name="item.sign2" value="${item.sign2 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date2 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date2"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine2_5">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text2_5" rows="2" placeholder="请输入审批意见...">${item.text2_5 }</textarea><br/><br/>
				<input id="opinion2_5ra1" value="1" type="radio" name="item.opinion2_5" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion2_5ra2" value="2" type="radio" name="item.opinion2_5" class="required"/>不同意
				<input id="opinion2_5" value="${item.opinion2_5 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign2_5" name="item.sign2_5" value="${item.sign2_5 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date2_5 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date2_5"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine3">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text3" rows="2" placeholder="请输入审批意见...">${item.text3 }</textarea><br/><br/>
				<input id="opinion3ra1" value="1" type="radio" name="item.opinion3" class="required"/>已解冻
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
			<label class="control-label">退款金额:</label>
			<div class="controls">
				<input id="refund" type="text" name="item.refund" value="${item.refund }"/>￥
			</div><br/>
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text5" rows="2" placeholder="请输入审批意见...">${item.text5 }</textarea><br/><br/>
				<input id="opinion5ra1" value="1" type="radio" name="item.opinion5" class="required"/>已确认，并付款。
				<input id="opinion5" value="${item.opinion5 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign5" name="item.sign5" value="${item.sign5 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date5 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date5"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine6">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text6" rows="2" placeholder="请输入审批意见...">${item.text6 }</textarea><br/><br/>
				<input id="opinion6ra1" value="1" type="radio" name="item.opinion6" class="required"/>已解冻，并清零积分。
				<input id="opinion6" value="${item.opinion6 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign6" name="item.sign6" value="${item.sign6 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date6 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date6"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine7">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text7" rows="2" placeholder="请输入审批意见...">${item.text7 }</textarea><br/><br/>
				<input id="opinion7ra1" value="1" type="radio" name="item.opinion7" class="required"/>已确认，并入档。
				<input id="opinion7" value="${item.opinion7 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign7" name="item.sign7" value="${item.sign7 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date7 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date7"/>
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