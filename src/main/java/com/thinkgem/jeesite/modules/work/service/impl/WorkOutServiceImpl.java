package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkOutDao;
import com.thinkgem.jeesite.modules.work.dto.WorkOutCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOut;
import com.thinkgem.jeesite.modules.work.service.WorkOutService;


@Service("workOutServiceImpl")
@Transactional(value = "transactionManager")
public class WorkOutServiceImpl implements WorkOutService{

	@Resource
	private WorkOutDao workOutDao;
	@Resource
	private OfficeDao officeDao;
	
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkOutByPage(Page<WorkOut> page,WorkOutCondition condition){
		int rows = workOutDao.listWorkOutByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkOut> list = workOutDao.listWorkOutByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkOut> list2=new ArrayList<WorkOut>();
		for (WorkOut item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 外出单
	 */
	public WorkOut getWorkOutById(String id){
		return workOutDao.getWorkOutById(id);
	}

	/**
	 * 新增
	 * @param item 外出单
	 */
	public void add(WorkOut item){
		workOutDao.add(item);
	}

	/**
	 * 修改
	 * @param item 外出单
	 */
	public void update(WorkOut item){
		workOutDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workOutDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workOutDao.termination(id);
	}
}

