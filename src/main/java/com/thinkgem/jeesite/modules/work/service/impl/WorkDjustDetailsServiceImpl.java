package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.work.entity.WorkDjustDetails;
import com.thinkgem.jeesite.modules.work.service.WorkDjustDetailsService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkDjustDetailsDao;
import com.thinkgem.jeesite.modules.work.dto.WorkDjustDetailsCondition;

@Service("workDjustDetailsServiceImpl")
@Transactional(value = "transactionManager")
public class WorkDjustDetailsServiceImpl implements WorkDjustDetailsService{

	@Resource
	private WorkDjustDetailsDao workDjustDetailsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkDjustDetailsByPage(Page<WorkDjustDetails> page,WorkDjustDetailsCondition condition){
		int rows = workDjustDetailsDao.listWorkDjustDetailsByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkDjustDetails> list = workDjustDetailsDao.listWorkDjustDetailsByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 价格调整表详情
	 */
	public WorkDjustDetails getWorkDjustDetailsById(String id){
		return workDjustDetailsDao.getWorkDjustDetailsById(id);
	}

	/**
	 * 新增
	 * @param item 价格调整表详情
	 */
	public void add(WorkDjustDetails item){
		workDjustDetailsDao.add(item);
	}

	/**
	 * 修改
	 * @param item 价格调整表详情
	 */
	public void update(WorkDjustDetails item){
		workDjustDetailsDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workDjustDetailsDao.delByIds(ids);
	}

	public List<WorkDjustDetails> listDjustDetails(String id) {
		return workDjustDetailsDao.listDjustDetails(id);
	}

}

