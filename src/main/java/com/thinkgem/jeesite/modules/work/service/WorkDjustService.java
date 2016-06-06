package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkDjust;
import com.thinkgem.jeesite.common.persistence.Page;

import com.thinkgem.jeesite.modules.work.dto.WorkDjustCondition;

public interface WorkDjustService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkDjustByPage(Page<WorkDjust> page,WorkDjustCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 价格调整表
	 */
	WorkDjust getWorkDjustById(String id);

	/**
	 * 新增
	 * @param item 价格调整表
	 */
	void add(WorkDjust item);

	/**
	 * 修改
	 * @param item 价格调整表
	 */
	void update(WorkDjust item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	
	void addPrevent(String []mode,WorkDjust item);
}

