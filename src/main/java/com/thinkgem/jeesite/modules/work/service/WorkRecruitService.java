package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkRecruitCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRecruit;



public interface WorkRecruitService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkRecruitByPage(Page<WorkRecruit> page,WorkRecruitCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 招聘需求表
	 */
	WorkRecruit getWorkRecruitById(String id);

	/**
	 * 新增
	 * @param item 招聘需求表
	 */
	void add(WorkRecruit item);

	/**
	 * 修改
	 * @param item 招聘需求表
	 */
	void update(WorkRecruit item);

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

