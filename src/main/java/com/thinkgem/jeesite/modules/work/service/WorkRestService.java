package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkRestCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRest;


public interface WorkRestService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkRestByPage(Page<WorkRest> pageResult,WorkRestCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 换休申请单
	 */
	WorkRest getWorkRestById(String id);

	/**
	 * 新增
	 * @param item 换休申请单
	 */
	void add(WorkRest item);

	/**
	 * 修改
	 * @param item 换休申请单
	 */
	void update(WorkRest item);

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

