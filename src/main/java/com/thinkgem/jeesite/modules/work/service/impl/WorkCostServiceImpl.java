package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.work.entity.WorkCost;
import com.thinkgem.jeesite.modules.work.service.WorkCostService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkCostDao;
import com.thinkgem.jeesite.modules.work.dto.WorkCostCondition;

@Service("workCostServiceImpl")
@Transactional(value = "transactionManager")
public class WorkCostServiceImpl implements WorkCostService{
	@Resource
	private WorkCostDao workCostDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkCostByPage(Page<WorkCost> page,WorkCostCondition condition){
		int rows = workCostDao.listWorkCostByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkCost> list = workCostDao.listWorkCostByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 费用报销单
	 */
	public WorkCost getWorkCostById(String id){
		return workCostDao.getWorkCostById(id);
	}

	/**
	 * 新增
	 * @param item 费用报销单
	 */
	public void add(WorkCost item){
		workCostDao.add(item);
	}

	/**
	 * 修改
	 * @param item 费用报销单
	 */
	public void update(WorkCost item){
		workCostDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workCostDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workCostDao.termination(id);
	}

	@Override
	public void updateAutograph(WorkCost item) {
		workCostDao.updateAutograph(item);
	}
	/**改变付款状态*/
	public void changePayment(String id,Integer flag){
		workCostDao.changePayment(id,flag);
	};
}

