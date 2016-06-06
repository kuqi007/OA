package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkShoppingDetailsDao;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingDetailsCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;
import com.thinkgem.jeesite.modules.work.service.WorkShoppingDetailsService;



@Service("workShoppingDetailsServiceImpl")
@Transactional(value = "transactionManager")
public class WorkShoppingDetailsServiceImpl implements WorkShoppingDetailsService{

	@Resource
	private WorkShoppingDetailsDao workShoppingDetailsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkShoppingDetailsByPage(Page<WorkShoppingDetails> page,WorkShoppingDetailsCondition condition){
		int rows = workShoppingDetailsDao.listWorkShoppingDetailsByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkShoppingDetails> list = workShoppingDetailsDao.listWorkShoppingDetailsByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 采购详情表
	 */
	public WorkShoppingDetails getWorkShoppingDetailsById(String id){
		return workShoppingDetailsDao.getWorkShoppingDetailsById(id);
	}

	/**
	 * 新增
	 * @param item 采购详情表
	 */
	public void add(WorkShoppingDetails item){
		workShoppingDetailsDao.add(item);
	}

	/**
	 * 修改
	 * @param item 采购详情表
	 */
	public void update(WorkShoppingDetails item){
		workShoppingDetailsDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workShoppingDetailsDao.delByIds(ids);
	}
	public List<WorkShoppingDetails> listShoppingDetails(String id){
		return workShoppingDetailsDao.listShoppingDetails(id);
	}
	
	
}

