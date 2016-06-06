package com.thinkgem.jeesite.modules.administr.service;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesOutCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesOut;


/**
 * 办公用品出库记录
 * @create-time 2016/4/7 9:48:39
 * @version 1.0
 */
public interface AsSuppliesOutService {

	/**
	 * 查询所有办公用品出库记录
	 */
	List<AsSuppliesOut> listAsSuppliesOutAll();

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsSuppliesOutByPage(Page<AsSuppliesOut> page,AsSuppliesOutCondition condition);
	/**
	 * 根据权限分页查询
	 * @param condition 查询条件类
	 */
	public void listAsSuppliesOutByPageClassfied(Page<AsSuppliesOut> page,AsSuppliesOutCondition condition);
	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品出库记录
	 */
	AsSuppliesOut  getAsSuppliesOutById(String id);

	/**
	 * 新增
	 * @param item 办公用品出库记录
	 */
	void add(AsSuppliesOut item);

	/**
	 * 修改
	 * @param item 办公用品出库记录
	 */
	void update(AsSuppliesOut item);
	/**
	 * 签收出库单
	 * @param 
	 */
	void updateSign(String id,Integer state);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

}