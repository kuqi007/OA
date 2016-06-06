package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.work.entity.WorkApplyDetails;
import com.thinkgem.jeesite.modules.work.service.WorkApplyDetailsService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dao.WorkApplyDetailsDao;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyDetailsCondition;

@Service("workApplyDetailsServiceImpl")
@Transactional(value = "transactionManager")
public class WorkApplyDetailsServiceImpl implements WorkApplyDetailsService{

	@Resource
	private WorkApplyDetailsDao workApplyDetailsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkApplyDetailsByPage(Page<WorkApplyDetails> page,WorkApplyDetailsCondition condition){
		int rows = workApplyDetailsDao.listWorkApplyDetailsByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkApplyDetails> list = workApplyDetailsDao.listWorkApplyDetailsByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 
	 */
	public WorkApplyDetails getWorkApplyDetailsById(String id){
		return workApplyDetailsDao.getWorkApplyDetailsById(id);
	}

	/**
	 * 新增
	 * @param item 
	 */
	public void add(WorkApplyDetails item){
		workApplyDetailsDao.add(item);
	}

	/**
	 * 修改
	 * @param item 
	 */
	public void update(WorkApplyDetails item){
		workApplyDetailsDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workApplyDetailsDao.delByIds(ids);
	}

	@Override
	public List<WorkApplyDetails> listApplyDetails(String id) {
		return workApplyDetailsDao.listApplyDetails(id);
	}

}

