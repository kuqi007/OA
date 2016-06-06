package com.thinkgem.jeesite.modules.work.service;


import com.thinkgem.jeesite.modules.work.entity.WorkLoan;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkLoanCondition;

public interface WorkLoanService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkLoanByPage(Page<WorkLoan> page,WorkLoanCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 借款申请表
	 */
	WorkLoan getWorkLoanById(String id);

	/**
	 * 新增
	 * @param item 借款申请表
	 */
	void add(WorkLoan item);

	/**
	 * 修改
	 * @param item 借款申请表
	 */
	void update(WorkLoan item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**付款状态*/
	void changeLoan(String id,Integer flag);
	/**
	 * 终止
	 * */
	void termination(String id);
}

