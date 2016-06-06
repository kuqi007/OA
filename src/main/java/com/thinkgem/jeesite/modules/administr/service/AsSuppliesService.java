package com.thinkgem.jeesite.modules.administr.service;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;


public interface AsSuppliesService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsSuppliesByPage(Page<AsSupplies> page,AsSuppliesCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品表
	 */
	AsSupplies getAsSuppliesById(String id);

	/**
	 * 新增
	 * @param item 办公用品表
	 */
	void add(AsSupplies item);

	/**
	 * 修改
	 * @param item 办公用品表
	 */
	void update(AsSupplies item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 查询所有用品
	 * 
	 * */
	List<AsSupplies> listAsSupplies();
	/**
	 * 减去相应出库的商品库存数量
	 * 
	 * */
	void updateSuppliesNum(String []mode,String itemId);
	/**
	 * 增加相应出库的商品库存数量
	 * 
	 * */
	void updateSuppliesNum2(String id,Integer num);
	/**
	 * 查询某类别的商品
	 * 
	 * */
	List<AsSupplies> listAsSuppliesByType(String id);
}

