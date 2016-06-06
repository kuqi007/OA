package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkRecruitDao;
import com.thinkgem.jeesite.modules.work.dto.WorkRecruitCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRecruit;
import com.thinkgem.jeesite.modules.work.service.WorkRecruitService;


@Service("workRecruitServiceImpl")
@Transactional(value = "transactionManager")
public class WorkRecruitServiceImpl implements WorkRecruitService{

	@Resource
	private WorkRecruitDao workRecruitDao;
	@Resource
	private OfficeDao officeDao;
	
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkRecruitByPage(Page<WorkRecruit> page,WorkRecruitCondition condition){
		int rows = workRecruitDao.listWorkRecruitByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkRecruit> list = workRecruitDao.listWorkRecruitByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkRecruit> list2=new ArrayList<WorkRecruit>();
		for (WorkRecruit item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 招聘需求表
	 */
	public WorkRecruit getWorkRecruitById(String id){
		return workRecruitDao.getWorkRecruitById(id);
	}

	/**
	 * 新增
	 * @param item 招聘需求表
	 */
	public void add(WorkRecruit item){
		workRecruitDao.add(item);
	}

	/**
	 * 修改
	 * @param item 招聘需求表
	 */
	public void update(WorkRecruit item){
		workRecruitDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workRecruitDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workRecruitDao.termination(id);
	}
}

