package com.thinkgem.jeesite.modules.sys.service;


import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dto.ProductTypeCondition;
import com.thinkgem.jeesite.modules.sys.entity.ProductType;


public interface ProductTypeService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listProductTypeByPage(Page<ProductType> page,ProductTypeCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品类型表
	 */
	ProductType getProductTypeById(String id);

	/**
	 * 新增
	 * @param item 办公用品类型表
	 */
	void add(ProductType item);

	/**
	 * 修改
	 * @param item 办公用品类型表
	 */
	void update(ProductType item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 根据级别获取类型
	 */
	List<ProductType> listProductType(String upper);
}

