package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkRestDao;
import com.thinkgem.jeesite.modules.work.dto.WorkRestCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRest;
import com.thinkgem.jeesite.modules.work.service.WorkRestService;


@Service("workRestServiceImpl")
@Transactional(value = "transactionManager")
public class WorkRestServiceImpl implements WorkRestService{

	@Resource
	private WorkRestDao workRestDao;
	@Resource
	private OfficeDao officeDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkRestByPage(Page<WorkRest> page,WorkRestCondition condition){
		int rows = workRestDao.listWorkRestByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkRest> list = workRestDao.listWorkRestByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkRest> list2=new ArrayList<WorkRest>();
		for (WorkRest item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 换休申请单
	 */
	public WorkRest getWorkRestById(String id){
		return workRestDao.getWorkRestById(id);
	}

	/**
	 * 新增
	 * @param item 换休申请单
	 */
	public void add(WorkRest item){
		workRestDao.add(item);
	}

	/**
	 * 修改
	 * @param item 换休申请单
	 */
	public void update(WorkRest item){
		workRestDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workRestDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workRestDao.termination(id);
	}
}

