package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkOutCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOut;



public interface WorkOutService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkOutByPage(Page<WorkOut> pageResult,WorkOutCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 外出单
	 */
	WorkOut getWorkOutById(String id);

	/**
	 * 新增
	 * @param item 外出单
	 */
	void add(WorkOut item);

	/**
	 * 修改
	 * @param item 外出单
	 */
	void update(WorkOut item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
}

