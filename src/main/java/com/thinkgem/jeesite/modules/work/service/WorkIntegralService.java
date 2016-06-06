package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkIntegral;
import com.thinkgem.jeesite.common.persistence.Page;

import com.thinkgem.jeesite.modules.work.dto.WorkIntegralCondition;

public interface WorkIntegralService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkIntegralByPage(Page<WorkIntegral> page,WorkIntegralCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 积分撤销申请表
	 */
	WorkIntegral getWorkIntegralById(String id);

	/**
	 * 新增
	 * @param item 积分撤销申请表
	 */
	void add(WorkIntegral item);

	/**
	 * 修改
	 * @param item 积分撤销申请表
	 */
	void update(WorkIntegral item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	/**改变冻结状态*/
	void updateFrozen(String id,Integer frozen);
	/**改变入档状态*/
	void updateRecord(String id,Integer record);
	/**实际退款数量*/
	void updateRefund(String id,Double refund);
}

