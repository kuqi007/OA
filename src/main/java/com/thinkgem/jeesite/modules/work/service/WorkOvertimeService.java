package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkOvertimeCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOvertime;

public interface WorkOvertimeService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkOvertimeByPage(Page<WorkOvertime> page,WorkOvertimeCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 加班申请单
	 */
	WorkOvertime getWorkOvertimeById(String id);

	/**
	 * 新增
	 * @param item 加班申请单
	 */
	void add(WorkOvertime item);

	/**
	 * 修改
	 * @param item 加班申请单
	 */
	void update(WorkOvertime item);

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

