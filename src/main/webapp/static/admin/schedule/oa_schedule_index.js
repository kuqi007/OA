$(document).ready(function(){
	//初始化操作按钮
	initOperateBtn();
	//初始化表格
 	initTable();
});

/**
 * 初始化操作按钮
 */
function initOperateBtn(){
    // 新增个人事物表; InnoDB free: 5120 kB
	$("#addBtn").live("click",addOaSchedule);
	// 批量个人事物表; InnoDB free: 5120 kB
	$("#batchDelBtn").live("click",doBatchDelOaSchedule);
	// 查询
	$("#searchBtn").live("click",searchOaSchedule);
	// 刷新
	$("#refreshGridBtn").live("click",refreshGrid);
}

/**
 * 初始化表格
 */
function initTable(){
	var gh = $(window).height() - 124;
	//渲染表格骨架
	$("#table").jqGrid({
	    url:basePath + '/admin/schedule/schedule/listOaScheduleByPage.htm?m='+Math.random(),
	    datatype:"json",
	    colNames:['操作','归属用户','开始时间','结束时间','开始日期','结束日期','提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒','事物内容','删除标记',''],
		colModel:[ 
			{name:"id",index:"id",width:80,formatter:optFormater},
            {name:"userId",width:100},
            {name:"startTime",width:100},
            {name:"endTime",width:100},
            {name:"startDate",width:100},
            {name:"endDate",width:100},
            {name:"noticeType",width:100},
            {name:"remarks",width:100},
            {name:"delFlag",width:100},
			{name:"blank",width:400}
		],
		viewrecords: true,
		caption:"个人事物表; InnoDB free: 5120 kB列表",
		loadComplete: function(data){
			var width = $(window).width()-10;
			$(this).setGridWidth(width);
	   	},
	   	shrinkToFit: true,
	   	height:gh,
		jsonReader:{id: "id",root:"resultList"}
  	});
  	$("#table").jqGrid("navGrid","#pagerBar");
}


/**
 * 设置操作按钮
 * @param {Object} cellvalue
 * @param {Object} options
 * @param {Object} rowObject
 */
function optFormater(cellvalue,options,rowObject){
	var btns = [];
	var updateBtn = "<a href='javascript:;' title='修改' class='no_unl' onclick=\"updateOaScheduleFN('"+rowObject.id+"');return false;\">修改</a>";
	var removeBtn = "<a href='javascript:;' class='no_unl' title='删除' onclick=\"removeOaScheduleFN('"+rowObject.id+"');return false;\">删除</a>";
	btns.push(updateBtn);
	btns.push(removeBtn);
	return btns.join(" ");
}

/**
 * 添加个人事物表; InnoDB free: 5120 kB
 */
function addOaSchedule(){
	$.dialog.open(basePath + "/admin/schedule/schedule/edit.htm?m="+Math.random(),{
			title : "添加个人事物表; InnoDB free: 5120 kB",
			width : "600px",
			height : "400px",
			lock : true
		}
	);
}

/**
 * 删除个人事物表; InnoDB free: 5120 kB
 * @param {Object} id
 */
function removeOaScheduleFN(id){
	//删除确认
	$.dialog.confirm("确认要删除吗?",function(){
		$("body").mask("正在删除，请稍后...");
		ajaxPOST(basePath + "/admin/schedule/schedule/del.htm?m="+Math.random(),{"selIds":id},function(data){
			$("body").unmask();
			 reloadCommonGrid("table");
		});
	});
}

/**
 * 批量删除
 */
function doBatchDelOaSchedule(){
	//删除确认
	$.dialog.confirm('确认要进行批量删除吗？',function(){
		var selIds = $("#table").jqGrid("getGridParam", "selarrrow");
		ajaxPOST(basePath + "/admin/schedule/schedule/del.htm?m="+Math.random(),{"selIds":selIds.join(",")},function(data){
			reloadCommonGrid("table");
		});
	});
}

/**
 * 查询个人事物表; InnoDB free: 5120 kB
 */
function searchOaSchedule(){
	var arr = $("#searchForm").serializeArray();
	var postData = {};
	for(var i=0;i<arr.length;i++){
		var entry = arr[i];
		postData[entry["name"]]=entry["value"];
	};
	$('#table').setGridParam({
		dataType:'post',
		postData:postData
	}).trigger('reloadGrid',[{page:1}]);
};


/**
 * 修改个人事物表; InnoDB free: 5120 kB
 */
function updateOaScheduleFN(id){
	$.dialog.open(basePath + "/admin/schedule/schedule/edit.htm?m="+Math.random()+"&item.id=" + id,{
		title : "修改个人事物表; InnoDB free: 5120 kB",
		width : "600px",
		height : "400px",
		lock : true
	});
}

/**
 * 刷新表格
 */
function refreshGrid(){
    reloadCommonGrid("table");
}