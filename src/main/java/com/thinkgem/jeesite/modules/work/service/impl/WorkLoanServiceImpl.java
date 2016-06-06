package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkLoanDao;
import com.thinkgem.jeesite.modules.work.entity.WorkLoan;
import com.thinkgem.jeesite.modules.work.service.WorkLoanService;
import com.thinkgem.jeesite.modules.work.dto.WorkLoanCondition;

@Service("workLoanServiceImpl")
@Transactional(value = "transactionManager")
public class WorkLoanServiceImpl implements WorkLoanService{

	@Resource
	private WorkLoanDao workLoanDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkLoanByPage(Page<WorkLoan> page,WorkLoanCondition condition){
		int rows = workLoanDao.listWorkLoanByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkLoan> list = workLoanDao.listWorkLoanByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 借款申请表
	 */
	public WorkLoan getWorkLoanById(String id){
		return workLoanDao.getWorkLoanById(id);
	}

	/**
	 * 新增
	 * @param item 借款申请表
	 */
	public void add(WorkLoan item){
		workLoanDao.add(item);
	}

	/**
	 * 修改
	 * @param item 借款申请表
	 */
	public void update(WorkLoan item){
		workLoanDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workLoanDao.delByIds(ids);
	}

	@Override
	public void changeLoan(String id, Integer flag) {
		workLoanDao.changeLoan(id,flag);
	}
	/**终止*/
	public void termination(String id){
		workLoanDao.termination(id);
	}
}

