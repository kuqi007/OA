$(document).ready(function(){
	//初始化表单验证信息
	initFormValidator();
	//初始化表单提交
	initAjaxForm();
	//初始化操作按钮
	initOperateBtn();
});

/**
 * 初始化表单验证信息
 */
function initFormValidator(){
	//验证框架信息
    $.formValidator.initConfig({ validatorGroup: 1, onError: function (msg, obj, errorlist) { $.msg({ wrapID: "errorlist", type: "error", messages: errorlist, time: "5000" }); } });
    $("#userId").formValidator({validatorGroup:1}).inputValidator({min:1,max:255,onErrorMin:"归属用户不能为空",onErrorMax:"归属用户长度过长"});
    $("#noticeType").formValidator({validatorGroup:1}).inputValidator({min:1,max:255,onErrorMin:"提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒不能为空",onErrorMax:"提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒长度过长"});
    $("#remarks").formValidator({validatorGroup:1}).inputValidator({min:1,max:255,onErrorMin:"事物内容不能为空",onErrorMax:"事物内容长度过长"});
    $("#delFlag").formValidator({validatorGroup:1}).inputValidator({min:1,max:255,onErrorMin:"删除标记不能为空",onErrorMax:"删除标记长度过长"});
}

/**
 * 初始化表单提交
 */
function initAjaxForm(){
	$('#saveForm').ajaxForm({
        dataType: 'json',
        success: function(data) {
        	$("body").unmask();
        	if(data.status == "success"){
        		var win = $.dialog.open.origin;
        		win.reloadCommonGrid("table");
        		$.dialog.close();
        	}else{
        		$.dialog.alert(data.message);
        		if(typeof data.token != "undefined" && data.token.length > 0){
        			$("input[name='token']").val(data.token);
        		}
        	}
        }
    });
}

/**
 * 初始化操作按钮
 */
function initOperateBtn(){
	//保存个人事物表; InnoDB free: 5120 kB
	$("#saveBtn").live("click",saveOaSchedule);
	//关闭窗口
	$("#exitBtn").live("click",closeWin);
}

/**
 * 保存个人事物表; InnoDB free: 5120 kB
 */
function saveOaSchedule(){
	var result = $.formValidator.pageIsValid(1);
	if(!result){
		return;
	}
	$("body").mask("正在保存，请稍后...");
	$("#saveForm").submit();
}