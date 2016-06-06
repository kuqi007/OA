package com.thinkgem.jeesite.modules.work.service;

import java.util.List;

import com.thinkgem.jeesite.modules.work.entity.WorkApplyDetails;
import com.thinkgem.jeesite.common.persistence.Page;

import com.thinkgem.jeesite.modules.work.dto.WorkApplyDetailsCondition;

public interface WorkApplyDetailsService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listWorkApplyDetailsByPage(Page<WorkApplyDetails> page,WorkApplyDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 
	 */
	WorkApplyDetails getWorkApplyDetailsById(String id);

	/**
	 * 新增
	 * @param item 
	 */
	void add(WorkApplyDetails item);

	/**
	 * 修改
	 * @param item 
	 */
	void update(WorkApplyDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	/**
	 * 根据申请单id查询
	 * */
	List<WorkApplyDetails> listApplyDetails(String id);
}

