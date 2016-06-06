<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="${ctxStatic}/index/oa.css">
<script type="text/javascript" src="${ctxStatic}/index/oa.js"></script>
<style>
 @media only screen and (max-width: 1200px) {
	.oa {
		width: 1000px;
	}
} 
</style>
<script type="text/javascript">
	function show() {
		$('#model1').modal('show');
	};
 	/* $(document).ready(function() {

	});  */
</script>
</head>

<body>

	 <!--模态框-->
	<div class="modal fade" id="model1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">查看日程详情</h4>
				</div>
				<div class="modal-body">

					<table style="margin-left: 25px;">
							<%-- <tr>
								<td class="field-label">日程标题：</td>
								<td><input  id="title" class="rhui-field" name="item.title" type="text"
									value="${item.title}" placeholder="请输入标题" style="width: 180px;" /></td>
							</tr> --%>
						<tr>
							<td class="field-label">日程内容：</td>
							<td><textarea id="title" class="rhui-field required"
									name="item.title" placeholder="记录你要做的一件事..."
									style="margin-bottom:5px;width: 180px; height: 62px; resize: none;"
									></textarea></td>
						</tr>
						<tr>
							<td class="field-label">开始时间：</td>
							<td><input id="startDate" name="item.startDate"
								class="input " style="width: 180px;height:30px" type="text"
                                       maxlength="20"
								readonly="readonly" /></td>

						</tr>
						<tr>
							<td class="field-label">结束时间：</td>
							<td><input id="endDate" name="item.endDate"
								class="input " style="width: 180px;height:30px" type="text"
								readonly="readonly" /></td>
						</tr>
					</table>
					<input type="hidden" name="item.id" id="eventid" value="${item.id}">
				</div>
				<div class="modal-footer">
					<!-- <a id="delete" class="btn btn-danger"
							onclick="return confirmx('确认要删除该日程吗？', this.href)">删除</a> -->
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button> -->
					<button type="button" class="btn btn-default" data-dismiss="modal">返回
					</button>
					<!-- 	<input id="submit" type="submit" value="新建事件"
							class="btn btn-primary" />
 -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	 <div class="oa">

		<div class="left">
			<div class="no1">
				<h3>
					<b></b><span>公告通知</span>
				</h3>
				<div class="zd">
					<ul class="list clearfix">
						<li class="current">未读公告</li>
						<li>已读公告</li>
					</ul>
					<ol class="tab">
						<li>
							<ul class="news">
								<c:choose>
									<c:when test="${empty unread}">
										<li>&gt;暂无未读公告</li>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${unread}">
											<li
												style="width: 480px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												<span>&gt;&#91;${fns:getDictLabel(item.type, 'oa_notify_type', '')}&#93;<a
													href="${ctx}/oa/oaNotify/view?id=${item.id}">
														${item.title} </a></span>

											</li>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</ul>
						</li>
						<li>
							<ul class="news">
								<c:choose>
									<c:when test="${empty read}">
										<li>&gt;暂无公告</li>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${read}">
											<li
												style="width: 480px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												<span>&gt;&#91;${fns:getDictLabel(item.type, 'oa_notify_type', '')}&#93;
													<a href="${ctx}/oa/oaNotify/view?id=${item.id}">
														${item.title}</a>
											</span>
											</li>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</ul>
						</li>
					</ol>
					<div class="submitbtn clearfix">
						<a href="${ctx}/oa/oaNotify/self" class="btnViewAll">查看全部>></a>
					</div>
				</div>
			</div>
			<%-- <div class="no6">
				<h3>
					<b></b><span>功能待定</span>
				</h3>
				<div class="zd">
					<ul class="list clearfix">
						<li class="current">未读公告</li>
						<li>已读公告</li>
					</ul>

					<ol class="tab">
						<li>
							<ul class="news">
								<c:choose>
									<c:when test="${empty unread}">
										<li>&gt;暂无未读公告</li>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${unread}">
											<li
												style="width: 480px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												<span>&gt;<a href="${ctx}/schedule/index">${item.title}</a></span>
											</li>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</ul>
						</li>
						<li>
							<ul class="news">
								<li>>暂无议</li>
								<li>>暂议</li>
								<li>>暂无会议</li>
								<li>>暂</li>
								<li>>暂无会议</li>
								<li>>暂会议</li>
							</ul>
						</li>
					</ol>
					<div class="submitbtn clearfix">
						<a href="${ctx}/schedule/index" class="btnViewAll">查看全部>></a>
					</div>
				</div>
			</div> --%>

			<div class="no3">
				<h3>
					<b></b><span>日程安排</span>
				</h3>
				<div class="zd clearfix">
					<ul class="list clearfix">
						<li class="current">今日日程</li>
						<li>近期日程</li>
					</ul>

					<ol class="tab0">
						<li>
							<ol class="news">
								<c:choose>
									<c:when test="${empty itemToday}">
										<li>&gt;暂无今日日程</li>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${itemToday}">
											<li
												style="width: 480px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><!-- 超出一行以省略号显示 -->
												<span id='spanStart'>&gt;<fmt:formatDate
														value="${item.startDate}" pattern="yy-MM-dd hh:mm" />&nbsp;&#8211;&nbsp;
													<fmt:formatDate value="${item.endDate}"
														pattern="yyyy-MM-dd hh:mm" /> &nbsp;<a
													href="javascript:show();$('#startDate').val('<fmt:formatDate value="${item.startDate}"
												pattern="yyyy-MM-dd hh:mm" />');$('#endDate').val('<fmt:formatDate value="${item.endDate}"
												pattern="yyyy-MM-dd hh:mm" />');$('#title').val('${item.title}');">${item.title}</a></span>
											</li>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</ol>
						</li>
						<li>
							<ol class="news">

								<c:choose>
									<c:when test="${empty itemRecent}">
										<li>&gt;暂无近日日程</li>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${itemRecent}">
											<li
												style="width: 480px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												<span>&gt;<fmt:formatDate value="${item.startDate}"
														pattern="yy-MM-dd hh:mm" />&nbsp;&#8211;&nbsp; <fmt:formatDate
														value="${item.endDate}" pattern="yyyy-MM-dd hh:mm" />
													&nbsp;<a
													href="javascript:show();$('#startDate').val('<fmt:formatDate value="${item.startDate}"
												pattern="yyyy-MM-dd hh:mm" />');$('#endDate').val('<fmt:formatDate value="${item.endDate}"
												pattern="yyyy-MM-dd hh:mm" />');$('#title').val('${item.title}');">${item.title}</a></span>
											</li>
										</c:forEach>
									</c:otherwise>

								</c:choose>

							</ol>
						</li>

					</ol>

				</div>
				<div class="submitbtn clearfix">
					<a href="${ctx}/schedule/index" class="btnViewAll">管理日程>></a>
				</div>

			</div>

		</div>
		<div>
			<iframe name="weather_inc"
				src="http://i.tianqi.com/index.php?c=code&id=10"
				style="margin-top: -41px; margin-left: 6px;" width="268" height="25"
				frameborder="0" marginwidth="0" marginheight="10" scrolling="no"></iframe>
		</div>
		<div class="right">
			<div class="no2">
				<h3>
					<b></b><span>我的工作</span>
				</h3>
				<div class="zd" style="height:255px;overflow:auto;">
					<ul class="list clearfix">
						<li class="current">待办工作</li>
						<li>滞留工作</li>
						<li>关注工作</li>
					</ul>
					<ol class="tab0">
						<li>
							<ol class="news">
								<c:forEach var="item" items="${listworkVo2 }">
									<li>>
									<c:if test="${item.emergency==0 }">&nbsp;<font color="#8eb475">【普通】</font></c:if>
									<c:if test="${item.emergency==1 }">&nbsp;<font color="#86a9c0">【紧急】</font></c:if>
									<c:if test="${item.emergency==2 }">&nbsp;<font color="red">【加急】</font></c:if>
									<a href="${ctx}${item.urls }">[${item.billType }]（<fmt:formatDate value="${item.time }" pattern="yyyy-MM-dd HH:mm:ss" />）${item.number }
									</a></li>
								</c:forEach>
							</ol>
						</li>
						<li>
							<ol class="news">
								<c:forEach var="item" items="${listworkVo3 }">
									<li>>
									<c:if test="${item.emergency==0 }">&nbsp;<font color="#8eb475">【普通】</font></c:if>
									<c:if test="${item.emergency==1 }">&nbsp;<font color="#86a9c0">【紧急】</font></c:if>
									<c:if test="${item.emergency==2 }">&nbsp;<font color="red">【加急】</font></c:if>
									<a href="${ctx}${item.urls }">[${item.billType }]（<fmt:formatDate value="${item.time }" pattern="yyyy-MM-dd HH:mm:ss" />）${item.number }
									</a></li>
								</c:forEach>
							</ol>
						</li>
						<li>
							<ol class="news">
							<c:forEach var="item" items="${listworkVo4 }">
							<li>>
							<c:if test="${item.emergency==0 }">&nbsp;<font color="#8eb475">【普通】</font></c:if>
							<c:if test="${item.emergency==1 }">&nbsp;<font color="#86a9c0">【紧急】</font></c:if>
							<c:if test="${item.emergency==2 }">&nbsp;<font color="red">【加急】</font></c:if>
							<a href="${ctx}${item.urls }">[${item.billType }]（<fmt:formatDate value="${item.time }" pattern="yyyy-MM-dd HH:mm:ss"/>）${item.number }</a></li>
							</c:forEach>
							</ol>
						</li>
					</ol>
				</div>

			</div>

			<div class="no5">
				<h3>
					<span>日历</span>
				</h3>
				<div>
					<%@ include
						file="/WEB-INF/views/modules/sys/include/indexCalendar.jsp"%>
				</div>
			</div>
		</div>
	</div> 
</body>
</html>
