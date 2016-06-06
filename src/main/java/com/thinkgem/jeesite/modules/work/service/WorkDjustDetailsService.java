package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkDjustDetails;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;

import com.thinkgem.jeesite.modules.work.dto.WorkDjustDetailsCondition;

public interface WorkDjustDetailsService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkDjustDetailsByPage(Page<WorkDjustDetails> page,WorkDjustDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 价格调整表详情
	 */
	WorkDjustDetails getWorkDjustDetailsById(String id);

	/**
	 * 新增
	 * @param item 价格调整表详情
	 */
	void add(WorkDjustDetails item);

	/**
	 * 修改
	 * @param item 价格调整表详情
	 */
	void update(WorkDjustDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	List<WorkDjustDetails> listDjustDetails(String id);
}

