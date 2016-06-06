package com.thinkgem.jeesite.modules.administr.service;


import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;

import com.thinkgem.jeesite.modules.administr.dto.AsOutDetailsCondition;

public interface AsOutDetailsService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsOutDetailsByPage(Page<AsOutDetails> page,AsOutDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 出库详情表
	 */
	AsOutDetails getAsOutDetailsById(String id);

	/**
	 * 新增
	 * @param item 出库详情表
	 */
	void add(AsOutDetails item);

	/**
	 * 修改
	 * @param item 出库详情表
	 */
	void update(AsOutDetails item);
	
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**根据出库id查询出库详情*/
	public List<AsOutDetails> listAsOutDetails(String id);
}

