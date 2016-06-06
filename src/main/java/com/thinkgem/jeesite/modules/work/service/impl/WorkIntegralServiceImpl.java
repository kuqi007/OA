package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.work.entity.WorkIntegral;
import com.thinkgem.jeesite.modules.work.service.WorkIntegralService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkIntegralDao;
import com.thinkgem.jeesite.modules.work.dto.WorkIntegralCondition;

@Service("workIntegralServiceImpl")
@Transactional(value = "transactionManager")
public class WorkIntegralServiceImpl implements WorkIntegralService{

	@Resource
	private WorkIntegralDao workIntegralDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkIntegralByPage(Page<WorkIntegral> page,WorkIntegralCondition condition){
		int rows = workIntegralDao.listWorkIntegralByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkIntegral> list = workIntegralDao.listWorkIntegralByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 积分撤销申请表
	 */
	public WorkIntegral getWorkIntegralById(String id){
		return workIntegralDao.getWorkIntegralById(id);
	}

	/**
	 * 新增
	 * @param item 积分撤销申请表
	 */
	public void add(WorkIntegral item){
		workIntegralDao.add(item);
	}

	/**
	 * 修改
	 * @param item 积分撤销申请表
	 */
	public void update(WorkIntegral item){
		workIntegralDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workIntegralDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workIntegralDao.termination(id);
	}

	@Override
	public void updateFrozen(String id, Integer frozen) {
		workIntegralDao.updateFrozen(id, frozen);
	}

	@Override
	public void updateRecord(String id, Integer record) {
		workIntegralDao.updateRecord(id, record);
	}

	@Override
	public void updateRefund(String id, Double refund) {
		workIntegralDao.updateRefund(id,refund);
	}
}

