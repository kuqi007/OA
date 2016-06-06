package com.thinkgem.jeesite.modules.administr.service;


import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesInfo;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesInfoCondition;

public interface AsSuppliesInfoService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsSuppliesInfoByPage(Page<AsSuppliesInfo> page,AsSuppliesInfoCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品入库表
	 */
	AsSuppliesInfo getAsSuppliesInfoById(String id);

	/**
	 * 新增
	 * @param item 办公用品入库表
	 */
	void add(AsSuppliesInfo item);

	/**
	 * 修改
	 * @param item 办公用品入库表
	 */
	void update(AsSuppliesInfo item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	void updateAsSuppliesById(@Param("shoppingId")String shoppingId,@Param("id") String id);
}

