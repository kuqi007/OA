<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<link href="${ctxStatic}/fullcalendar/fullcalendar.css" rel="stylesheet" />
<link href="${ctxStatic}/fullcalendar/jquery-ui.min.css" rel="stylesheet" />
<link href="${ctxStatic}/fullcalendar/fullcalendar.print.css"
	rel="stylesheet" media="print" />
<script type="text/javascript"
	src="${ctxStatic}/fullcalendar/moment.min.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/fullcalendar/zh-cn.js"></script>
<title>日程管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
/* 时间格式化函数*/
	Date.prototype.Format = function(fmt) { //author: meizz 
		var o = {
			"M+" : this.getMonth() + 1, //月份 
			"d+" : this.getDate(), //日 
			"h+" : this.getHours(), //小时 
			"m+" : this.getMinutes(), //分 
			"s+" : this.getSeconds(), //秒 
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
			"S" : this.getMilliseconds()
		//毫秒 
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	$(document).ready(
					function() {
						$("#inputForm").validate();// 初始化表单提交验证
						$("#endDate").live("click", function() {
							var beginDate = $("#startDate").val();
							WdatePicker({
								dateFmt : 'yyyy-MM-dd HH:mm',
								isShowClear : false,
								minDate : beginDate
							});
						});

						$("#calendar")
								.fullCalendar(
										{
										theme:true,
											header : {
												left : "prev,next today",
												center : "title",
												right : "month,agendaWeek,agendaDay"
											},
											color:"#E5BA7E",
											dayClick : function(date, jsEvent,
													view) {
												$("#startDate").val((new Date(date)).Format("yyyy-MM-dd hh:mm"));
												if ($('#delete').css('display') != 'none')
													$('#delete').hide();
												$("#myModalLabel").text("新建事件");
												$("#submit").val("确认");
												//清空内容
												$("#title").val("");
												$("#endDate").val("");
												$("#eventid").val("");
												$('#model1').modal('show');
												//     $(this).css('background-color', 'red'); 
											},
											eventClick : function(calEvent,
													jsEvent, view) {
												console.log(calEvent.start);
												console.log(calEvent.end);
												$("#delete").attr(
														"href",
														"${ctx}/schedule/delete?item.id="
																+ calEvent.id);
												if ($('#delete').css('display') == 'none')
													$('#delete').show();
												$("#myModalLabel").text('编辑事件');
												$("#submit").val("确认");
												$("#title").val(calEvent.title);
												$("#startDate")
														.val(
																moment(
																		calEvent.start)
																		.format(
																				'YYYY-MM-DD HH:mm:ss'));
												$("#endDate")
														.val(
																moment(
																		calEvent.end)
																		.format(
																				'YYYY-MM-DD HH:mm:ss'));

												$("#eventid").val(calEvent.id);
												$('#model1').modal('show');
												/* $('#delete').css('display','inline'); */
											},
											/*  defaultDate: "today", */
											/* defaultView:'basicDay',  */
											weekNumbers: true,
											editable : false,
											eventLimit : true, // allow "more" link when too many events
											events : {
												url : '${ctx}/schedule/json',//你的controller的地址  
												type : 'POST',
												error : function() {
													alert('there was an error while fetching events!');
												},
											}
										});

					});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 146px;
}
</style>
</head>
<body>
	<div id="calendar"></div>
	<form:form id="inputForm" modelAttribute="scheduleForm"
		action="${ctx}/schedule/save" method="post" class="form-horizontal">
		<sys:message content="${message}" />
		<!--模态框-->
		<div class="modal fade" id="model1" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					</div>
					<div class="modal-body">

						<table style="margin-left: 25px;">
							<%-- 	<tr>
								<td class="field-label">日程标题：</td>
								<td><input  id="title" class="rhui-field" name="item.title" type="text"
									value="${item.title}" placeholder="请输入标题" style="width: 180px;" /></td>
							</tr> --%>
							<tr>
								<td class="field-label">日程内容：</td>
								<td><textarea id="title" class="rhui-field required"
										name="item.title" placeholder="记录你要做的一件事..."
										style="width: 180px; height: 62px; resize: none;"
										form="inputForm"></textarea></td>
							</tr>
							<tr>
								<td class="field-label">开始时间：</td>
								<td><input id="startDate" name="item.startDate"
									class="input Wdate" style="width: 180px;" type="text"
									onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false});"
									value="${item.startDate}"
									<%--   value="<fmt:formatDate value="${beginDate}" pattern='yyyy-MM-dd HH:mm'/>"  --%>
                                       maxlength="20"
									readonly="readonly" /></td>

							</tr>
							<tr>
								<td class="field-label">结束时间：</td>
								<td><input id="endDate" name="item.endDate"
									class="input Wdate required" style="width: 180px;" type="text"
									value="${item.endDate}"
									<%--   value="<fmt:formatDate  pattern='yyyy-MM-dd HH:mm'/>" --%>
                                       maxlength="20"
									readonly="readonly" /></td>
							</tr>
						</table>
						<input type="hidden" name="item.id" id="eventid"
							value="${item.id}">
					</div>
					<div class="modal-footer">
						<a id="delete" class="btn btn-danger"
							onclick="return confirmx('确认要删除该日程吗？', this.href)">删除</a>
						<!-- <button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button> -->
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<input id="submit" type="submit" value="新建事件"
							class="btn btn-primary" />

					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</form:form>
</body>
</html>
