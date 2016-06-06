package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.modules.work.service.WorkProcessService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkProcessDao;
import com.thinkgem.jeesite.modules.work.dao.WorkProcessDetailsDao;
import com.thinkgem.jeesite.modules.work.dto.WorkProcessCondition;

@Service("workProcessServiceImpl")
@Transactional(value = "transactionManager")
public class WorkProcessServiceImpl implements WorkProcessService{

	@Resource
	private WorkProcessDao workProcessDao;
	@Resource
	private WorkProcessDetailsDao workProcessDetailsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkProcessByPage(Page<WorkProcess> page,WorkProcessCondition condition){
		int rows = workProcessDao.listWorkProcessByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkProcess> list = workProcessDao.listWorkProcessByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 流程表
	 */
	public WorkProcess getWorkProcessById(String id){
		return workProcessDao.getWorkProcessById(id);
	}

	/**
	 * 新增
	 * @param item 流程表
	 */
	public void add(WorkProcess item){
		workProcessDao.add(item);
	}

	/**
	 * 修改
	 * @param item 流程表
	 */
	public void update(WorkProcess item){
		workProcessDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workProcessDao.delByIds(ids);
	}

	@Override
	public WorkProcess listWorkProcess(String uid, Integer type) {
		WorkProcess workProcess=workProcessDao.getWorkProcess(uid,type);
		workProcess.setListProcessDetails(workProcessDetailsDao.listWorkProcessDetails(workProcess.getId()));
		return workProcess;
	}

}

