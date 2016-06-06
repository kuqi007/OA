package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkCost;
import com.thinkgem.jeesite.common.persistence.Page;

import com.thinkgem.jeesite.modules.work.dto.WorkCostCondition;

public interface WorkCostService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkCostByPage(Page<WorkCost> page,WorkCostCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 费用报销单
	 */
	WorkCost getWorkCostById(String id);

	/**
	 * 新增
	 * @param item 费用报销单
	 */
	void add(WorkCost item);

	/**
	 * 修改
	 * @param item 费用报销单
	 */
	void updateAutograph(WorkCost item);
	/**
	 * 修改
	 * */
	void update(WorkCost item);
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	/**改变付款状态*/
	void changePayment(String id,Integer flag);

}

