/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.work.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkLeaveDao;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;
import com.thinkgem.jeesite.modules.work.service.WorkLeaveService;

/**
 *
 */
@Service("workLeaveServiceImpl")
@Transactional(value = "transactionManager")
public class WorkLeaveServiceImpl implements WorkLeaveService {
    
	@Resource
	private WorkLeaveDao workLeaveDao;
	@Resource
	private OfficeDao officeDao;
	
	
	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkLeaveByPage(Page<WorkLeave> page,WorkLeaveCondition condition){
		int rows = workLeaveDao.listWorkLeaveByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkLeave> list = workLeaveDao.listWorkLeaveByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkLeave> list2=new ArrayList<WorkLeave>();
		for (WorkLeave item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	@Override
	public WorkLeave getWorkLeaveById(String id) {
		return workLeaveDao.getWorkLeaveById(id);
	}

	/**
	 * 新增
	 * @param item 请假单表
	 */
	public void add(WorkLeave item){
		workLeaveDao.add(item);
	}

	/**
	 * 修改
	 * @param item 请假单表
	 */
	public void update(WorkLeave item){
		workLeaveDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workLeaveDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workLeaveDao.termination(id);
	}
}