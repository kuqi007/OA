package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkOvertimeDao;
import com.thinkgem.jeesite.modules.work.dto.WorkOvertimeCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOvertime;
import com.thinkgem.jeesite.modules.work.service.WorkOvertimeService;



@Service("workOvertimeServiceImpl")
@Transactional(value = "transactionManager")
public class WorkOvertimeServiceImpl implements WorkOvertimeService{

	@Resource
	private WorkOvertimeDao workOvertimeDao;
	@Resource
	private OfficeDao officeDao;
	
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkOvertimeByPage(Page<WorkOvertime> page,WorkOvertimeCondition condition){
		int rows = workOvertimeDao.listWorkOvertimeByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkOvertime> list = workOvertimeDao.listWorkOvertimeByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkOvertime> list2=new ArrayList<WorkOvertime>();
		for (WorkOvertime item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 加班申请单
	 */
	public WorkOvertime getWorkOvertimeById(String id){
		return workOvertimeDao.getWorkOvertimeById(id);
	}

	/**
	 * 新增
	 * @param item 加班申请单
	 */
	public void add(WorkOvertime item){
		workOvertimeDao.add(item);
	}

	/**
	 * 修改
	 * @param item 加班申请单
	 */
	public void update(WorkOvertime item){
		workOvertimeDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workOvertimeDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workOvertimeDao.termination(id);
	}
}

