package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkApply;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyCondition;

public interface WorkApplyService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkApplyByPage(Page<WorkApply> page,WorkApplyCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品申请表
	 */
	WorkApply getWorkApplyById(String id);

	/**
	 * 新增
	 * @param item 办公用品申请表
	 */
	void add(WorkApply item);

	/**
	 * 修改
	 * @param item 办公用品申请表
	 */
	void update(WorkApply item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	
	void addPrevent(String []mode,WorkApply item);
}

