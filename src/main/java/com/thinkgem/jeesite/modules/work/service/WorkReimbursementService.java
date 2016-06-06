package com.thinkgem.jeesite.modules.work.service;


import java.util.Date;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkReimbursementCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkReimbursement;


public interface WorkReimbursementService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkReimbursementByPage(Page<WorkReimbursement> page,WorkReimbursementCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 差旅报销单
	 */
	WorkReimbursement getWorkReimbursementById(String id);

	/**
	 * 新增
	 * @param item 差旅报销单
	 */
	void add(WorkReimbursement item);

	/**
	 * 修改
	 * @param item 差旅报销单
	 */
	void update(WorkReimbursement item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	/**改变付款状态*/
	void changePayment(String id,Integer flag);
	/**更新实际出差日期*/
	void updateDate(String id,Date be,Date en);
}

