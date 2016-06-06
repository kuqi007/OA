package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentHrCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkPayment;
import com.thinkgem.jeesite.modules.work.entity.WorkPaymentHr;


public interface WorkPaymentHrService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkPaymentByPage(Page<WorkPaymentHr> page,WorkPaymentHrCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 付款申请单
	 */
	WorkPaymentHr getWorkPaymentById(String id);

	/**
	 * 新增
	 * @param item 付款申请单
	 */
	void add(WorkPaymentHr item);

	/**
	 * 修改
	 * @param item 付款申请单
	 */
	void update(WorkPaymentHr item);
	/**改变付款状态*/
	void changePayment(String id,Integer flag);

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

