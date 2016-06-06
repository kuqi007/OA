package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkTravelDao;
import com.thinkgem.jeesite.modules.work.dto.WorkTravelCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkTravel;
import com.thinkgem.jeesite.modules.work.service.WorkTravelService;



@Service("workTravelServiceImpl")
@Transactional(value = "transactionManager")
public class WorkTravelServiceImpl implements WorkTravelService{

	@Resource
	private WorkTravelDao workTravelDao;
	@Resource
	private OfficeDao officeDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkTravelByPage(Page<WorkTravel> page,WorkTravelCondition condition){
		int rows = workTravelDao.listWorkTravelByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkTravel> list = workTravelDao.listWorkTravelByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkTravel> list2=new ArrayList<WorkTravel>();
		for (WorkTravel item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 出差申请表
	 */
	public WorkTravel getWorkTravelById(String id){
		return workTravelDao.getWorkTravelById(id);
	}

	/**
	 * 新增
	 * @param item 出差申请表
	 */
	public void add(WorkTravel item){
		workTravelDao.add(item);
	}

	/**
	 * 修改
	 * @param item 出差申请表
	 */
	public void update(WorkTravel item){
		workTravelDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workTravelDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workTravelDao.termination(id);
	}
}

