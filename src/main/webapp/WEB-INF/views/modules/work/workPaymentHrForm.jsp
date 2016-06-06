<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>行政付款申请单详情</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate();// 初始化表单提交验证
			
			// 结束日期控制
			$("#endDate").live("click",function(){
				var beginDate=$("#beginDate").val();
				WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false,minDate:beginDate});
			});
			
			// 计算时间
			$("#sumDate").live("click",function(){
				var beginDate=Date.parse($("#beginDate").val().replace(/-/g, "/"));
				var endDate=Date.parse($("#endDate").val().replace(/-/g, "/"));
				var date=endDate-beginDate;
				var days=Math.floor(date/(24*3600*1000));  //天
				var leave=date%(24*3600*1000);//计算天数后剩余的毫秒数  
				var hours=Math.floor(leave/(3600*1000)); // 小时
				$("#sumDate").text(days+"天"+hours+"小时");
			});
			
			
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
			
			
			// 设置table里面的input宽度
			$("table .moneys").css("width","20");
			$("table input").css("border","0px");
			$("table textarea").css("border","0px");
			$("#capital").css("width","290px");
			$("table .moneys").keyup(function(){
				write();
			});
		});
		function write(){
			var my=$("table .moneys");
			var num="";
			for(i=0;i<my.length;i++){
				if(i==8){num+=".";}
				if(my.eq(i).val()!=""){num+=my.eq(i).val();}else{num+="0"}
			}
			$("#capital").val(parseFloat(num));
			toUpper("capital","capital");
		} 
		function toUpper(lowerInputId,upperInputId){  
		    var num = $("#"+lowerInputId).val();  
		    if(isNull(num)){  
		        return ;  
		    }  
		    if(num.lastIndexOf(".") == num.length - 1 ){  
		        return ;  
		    }  
		    for ( var int = 0; int < num.length; int++) {  
		        if(checkNum(num)){  
		            break;  
		        }else{  
		            num = removeLastChar(num);  
		            int --;  
		        }  
		        if(isNull(num)) return;  
		    }  
		    $("#"+lowerInputId).val(num);  
		    $("#"+upperInputId).val(ToTrans(num));  
		      
		    function isNull(num){  
		        if(num == null || num == ""){  
		            $("#"+lowerInputId).val("");  
		            $("#"+upperInputId).val("");  
		            return true;  
		        }  
		        return false;  
		    }  
		}  
		//校验是否为正浮点数或正整数  
		function checkNum(str){  
		  var patrn=/^([+]?)\d*\.?\d+$/;  
		  return patrn.test(str);  
		};  
		  
		//移除最后一个字符  
		function removeLastChar(str){  
		    if(str == null || str == ""){  
		        return str;  
		    }  
		    return str.substring(0,str.length-1);  
		}  
		  
		function ToTrans(a) {  
		    var b = 9.999999999999E10,  
		    f = "\u96f6",  
		    h = "\u58f9",  
		    g = "\u8d30",  
		    e = "\u53c1",  
		    k = "\u8086",  
		    p = "\u4f0d",  
		    q = "\u9646",  
		    r = "\u67d2",  
		    s = "\u634c",  
		    t = "\u7396",  
		    l = "\u62fe",  
		    d = "\u4f70",  
		    i = "\u4edf",  
		    m = "\u4e07",  
		    j = "\u4ebf",  
		    u = "人民币",  
		    o = "\u5143",  
		    c = "\u89d2",  
		    n = "\u5206",  
		    v = "\u6574";  
		    a = a.toString();  
		    if (a == "") {  
		        alert("转换内容不能为空!");  
		        return "";  
		    }  
		    if (a.match(/[^,.\d]/) != null) {  
		        alert("输入有误,请输入小数点和纯数字!");  
		        return "";  
		    }  
		    if (a.match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) == null) {  
		        alert("输入有误,请输入小数点和纯数字!");  
		        return "";  
		    }  
		    a = a.replace(/,/g, "");  
		    a = a.replace(/^0+/, "");  
		    if (Number(a) > b) {  
		        alert("\u5bf9\u4e0d\u8d77,\u4f60\u8f93\u5165\u7684\u6570\u5b57\u592a\u5927\u4e86!\u6700\u5927\u6570\u5b57\u4e3a99999999999.99\uff01");  
		        return "";  
		    }  
		    b = a.split(".");  
		    if (b.length > 1) {  
		        a = b[0];  
		        b = b[1];  
		        b = b.substr(0, 2);  
		    } else {  
		        a = b[0];  
		        b = "";  
		    }  
		    h = new Array(f, h, g, e, k, p, q, r, s, t);  
		    l = new Array("", l, d, i);  
		    m = new Array("", m, j);  
		    n = new Array(c, n);  
		    c = "";  
		    if (Number(a) > 0) {  
		        for (d = j = 0; d < a.length; d++) {  
		            e = a.length - d - 1;  
		            i = a.substr(d, 1);  
		            g = e / 4;  
		            e = e % 4;  
		            if (i == "0") j++;  
		            else {  
		                if (j > 0) c += h[0];  
		                j = 0;  
		                c += h[Number(i)] + l[e];  
		            }  
		            if (e == 0 && j < 4) c += m[g];  
		        }  
		        c += o;  
		    }  
		    if (b != "") for (d = 0; d < b.length; d++) {  
		        i = b.substr(d, 1);  
		        if (i != "0") c += h[Number(i)] + n[d];  
		    }  
		    if (c == "") c = f + o;  
		    if (b.length < 2) c += v;  
		    return c;  
		}  
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>
		<c:if test="${state==0 }"><a href="${ctx}/work/paymentHr/listflowType">行政付款申请单列表</a></c:if>
		<c:if test="${state!=0 }"><a href="${ctx}/work/paymentHr/list">行政付款申请单列表</a></c:if>
		</li>
		<li class="active"><a href="${ctx}/work/paymentHr/edit?item.id=${item.id}">行政付款申请单${not empty item.id?'查看':'添加'}</a></li>
	</ul><br/>
	<div style="width:186px;height:250px; margin-left: 1100px;position: absolute;">
		<h5 style="text-align: center;margin-bottom: 8px;">审批流程</h5>
		<img alt="流程图" src="${ctxUserfiles }/staticImages/44.png">
	</div>
	<form:form id="inputForm" modelAttribute="workPaymentHrForm" action="${ctx}/work/paymentHr/save" method="post" class="form-horizontal">
	<sys:message content="${message}"/>
		<input id="id" value="${item.id }" type="hidden" name="item.id"/>
		<input id="state" value="${item.state }"type="hidden" name="item.state"/>
		<input id="flag" value="${item.flag }"type="hidden" name="item.flag"/>
		<input id="createBy" value="${item.createBy }" type="hidden" name="item.createBy"/>
		<input id="pstater" value="${processState }" type="hidden"><!-- 流程标识 -->
		
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
			<label class="control-label">申请人:</label>
			<div class="controls">
				<label class="lbl">${item.name }</label>
                <input id="name" name="item.name" value="${item.name }" type="hidden"/>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">费用详情:</label>
		<div class="controls">
			<table border="3"style="font-size:16px; width:854px;height:336px;">
				<tr>
				<td>付款人</td>
				<td><input id="drawee" name="item.drawee" type="text" class="required"/></td>
				<td rowspan="6">收款人</td>
				<td>户名</td>
				<td colspan="10"><input id="payeeName" name="item.payeeName" type="text" class="required"/></td>
				</tr>
				<tr>
				<td rowspan="5">付款事由</td>
				<td rowspan="5"><textarea rows="7" id="reason" name="item.reason"></textarea></td>
				<td>银行账号</td>
				<td colspan="10"><input id="payeeNumber" name="item.payeeNumber" type="text" class="required"/></td>
				</tr>	
				<tr>
				<td>付款凭证</td>
				<td colspan="10"><input id="voucher" name="item.voucher" type="text" /></td>
				</tr>	
				<tr>
				<td>开户银行</td>
				<td colspan="10"><input id="bank" name="item.bank" type="text" /></td>
				</tr>
				<tr>
				<td rowspan="2">付款方式</td>
				<td colspan="3"><input type="radio" value="1" name="item.type" checked="checked"/>现金</td>
				<td colspan="4"><input type="radio" value="2" name="item.type"/>内部转账</td>
				<td colspan="3"><input type="radio" value="3" name="item.type"/>划账</td>
				</tr>
				<tr>
				<td colspan="3"><input type="radio" value="4" name="item.type"/>支票</td>
				<td colspan="4"><input type="radio" value="5" name="item.type"/>汇票</td>
				<td colspan="3"><input type="radio" value="6" name="item.type"/>电邮</td>
				</tr>
				<tr>
				<td rowspan="2">人民币（大写）</td>
				<td rowspan="2" colspan="3"><input id="capital" type="text" name="item.capital" readonly="readonly"/></td>
				<td>千</td>
				<td>百</td>
				<td>十</td>
				<td>万</td>
				<td>千</td>
				<td>百</td>
				<td>十</td>
				<td>元</td>
				<td>角</td>
				<td>分</td>
				</tr>	
				<tr>
				<td><input maxlength="1" id="thousand2" type="text" name="item.thousand2" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="hundred2" type="text" name="item.hundred2" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="ten2" type="text" name="item.ten2" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="tenthousand" type="text" name="item.tenthousand" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="thousand1" type="text" name="item.thousand1" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="hundred1" type="text" name="item.hundred1" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="ten1" type="text" name="item.ten1" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="element" type="text" name="item.element" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="horn" type="text" name="item.horn" value="" class="digits moneys"/></td>
				<td><input maxlength="1" id="branch" type="text" name="item.branch" value="" class="digits moneys"/></td>
				</tr>		
			</table>
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
			<label class="control-label">申请人:</label>
			<div class="controls">
			<label class="lbl">${item.name }</label>
			</div>
		</div>
		<div class="control-group">
		<label class="control-label">费用详情:</label>
		<div class="controls">
			<table border="3" style="text-align:center;font-size:16px; width:854px;height:336px;">
				<tr>
				<td>付款人</td>
				<td style="width:300px;">${item.drawee }</td>
				<td rowspan="5">收款人</td>
				<td>户名</td>
				<td colspan="10">${item.payeeName }</td>
				</tr>
				<tr>
				<td rowspan="4">付款事由</td>
				<td rowspan="4">${item.reason }</td>
				<td>银行账号</td>
				<td colspan="10">${item.payeeNumber }</td>
				</tr>	
				<tr>
				<td>付款凭证</td>
				<td colspan="10">${item.voucher }</td>
				</tr>	
				<tr>
				<td>开户银行</td>
				<td colspan="10">${item.bank }</td>
				</tr>
				<tr>
				<td>付款方式</td>
				<td colspan="10"><c:if test="${item.type==1 }">现金</c:if>
				<c:if test="${item.type==2 }">内部转账</c:if>
				<c:if test="${item.type==3 }">划账</c:if>
				<c:if test="${item.type==4 }">支票</c:if>
				<c:if test="${item.type==5 }">汇票</c:if>
				<c:if test="${item.type==6 }">电邮</c:if></td>
				</tr>
				<tr>
				<td rowspan="2">人民币（大写）</td>
				<td rowspan="2" colspan="3">${item.capital }</td>
				<td>千</td>
				<td>百</td>
				<td>十</td>
				<td>万</td>
				<td>千</td>
				<td>百</td>
				<td>十</td>
				<td>元</td>
				<td>角</td>
				<td>分</td>
				</tr>	
				<tr>
				<td>${item.thousand2 }</td>
				<td>${item.hundred2 }</td>
				<td>${item.ten2 }</td>
				<td>${item.tenthousand }</td>
				<td>${item.thousand1 }</td>
				<td>${item.hundred1 }</td>
				<td>${item.ten1 }</td>
				<td>${item.element }</td>
				<td>${item.horn }</td>
				<td>${item.branch }</td>
				</tr>		
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
				<textarea name="item.text1" cols="2">${item.text1 }</textarea><br/><br/>
				<input id="opinion1ra1" value="1" type="radio" name="item.opinion1" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion1ra2" value="2" type="radio" name="item.opinion1" class="required"/>不同意
				<input id="opinion1" value="${item.opinion1 }" type="hidden"/>
				<div style="margin-top: 10px;">
					签字：<img src="${userSign }" width="100" height="100"/><input type="hidden" id="sign1" name="item.sign1" value="${item.sign1 }"/>
					<input type="hidden" value="<fmt:formatDate value='${item.date1 }' pattern='yyyy-MM-dd HH:mm:ss'/>" name="item.date1"/>
				</div>
			</div>
		</div>
		<div class="control-group" style="display: none;" id="examine2">
			<label class="control-label">审批意见:</label>
			<div class="controls">
				<textarea name="item.text2" cols="2">${item.text2 }</textarea><br/><br/>
				<input id="opinion2ra1" value="1" type="radio" name="item.opinion2" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion2ra2" value="2" type="radio" name="item.opinion2" class="required"/>不同意
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
				<textarea name="item.text3" cols="2">${item.text3 }</textarea><br/><br/>
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
				<textarea name="item.text4" cols="2">${item.text4 }</textarea><br/><br/>
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
				<input id="opinion5ra1" value="1" type="radio" name="item.opinion5" class="required"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="opinion5ra2" value="2" type="radio" name="item.opinion5" class="required"/>不同意
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