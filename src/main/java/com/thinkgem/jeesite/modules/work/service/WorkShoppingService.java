package com.thinkgem.jeesite.modules.work.service;


import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;


public interface WorkShoppingService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkShoppingByPage(Page<WorkShopping> page,WorkShoppingCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 采购申请单
	 */
	WorkShopping getWorkShoppingById(String id);

	/**
	 * 新增
	 * @param item 采购申请单
	 */
	void add(WorkShopping item);

	/**
	 * 修改
	 * @param item 采购申请单
	 */
	void update(WorkShopping item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	
	void addPrevent(String []mode,WorkShopping item);
	/**所有未入库订单*/
	List<WorkShopping> listShopping();
	
	void changePayment(String id,Integer flag);
}

