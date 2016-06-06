package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkProcess;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkProcessCondition;

public interface WorkProcessService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkProcessByPage(Page<WorkProcess> page,WorkProcessCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 流程表
	 */
	WorkProcess getWorkProcessById(String id);

	/**
	 * 新增
	 * @param item 流程表
	 */
	void add(WorkProcess item);

	/**
	 * 修改
	 * @param item 流程表
	 */
	void update(WorkProcess item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	
	/**
	 * 查询当前用户单据所绑定的流程信息
	 * @param uid 用户id
	 * @param type 单据流程标识(1-请假单2-加班3-换休4-外出5-采购6-出差7-招聘8-差旅报销9-付款10-费用报销单11-办公用品申领12-价格调整13-积分撤销14-借款申请)
	 * */
	WorkProcess listWorkProcess(String uid,Integer type);

}

