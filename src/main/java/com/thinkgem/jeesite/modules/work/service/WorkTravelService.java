package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkTravelCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkTravel;


public interface WorkTravelService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkTravelByPage(Page<WorkTravel> page,WorkTravelCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 出差申请表
	 */
	WorkTravel getWorkTravelById(String id);

	/**
	 * 新增
	 * @param item 出差申请表
	 */
	void add(WorkTravel item);

	/**
	 * 修改
	 * @param item 出差申请表
	 */
	void update(WorkTravel item);

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

