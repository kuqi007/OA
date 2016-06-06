package com.thinkgem.jeesite.modules.work.service;


import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingDetailsCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;



public interface WorkShoppingDetailsService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkShoppingDetailsByPage(Page<WorkShoppingDetails> page,WorkShoppingDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 采购详情表
	 */
	WorkShoppingDetails getWorkShoppingDetailsById(String id);

	/**
	 * 新增
	 * @param item 采购详情表
	 */
	void add(WorkShoppingDetails item);

	/**
	 * 修改
	 * @param item 采购详情表
	 */
	void update(WorkShoppingDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	
	/**
	 * 根据采购id查询详情
	 * 
	 * */
	List<WorkShoppingDetails> listShoppingDetails(String id);
}

