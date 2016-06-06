/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.work.service;



import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;

/**
 * 
 * 
 */
public interface WorkLeaveService{
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkLeaveByPage(Page<WorkLeave> page,WorkLeaveCondition condition);
	public WorkLeave getWorkLeaveById(String id);

	/**
	 * 新增
	 * @param item 请假单表
	 */
	void add(WorkLeave item);

	/**
	 * 修改
	 * @param item 请假单表
	 */
	void update(WorkLeave item);

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
