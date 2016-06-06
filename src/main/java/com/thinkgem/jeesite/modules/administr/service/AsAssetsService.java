package com.thinkgem.jeesite.modules.administr.service;


import com.thinkgem.jeesite.modules.administr.entity.AsAssets;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsAssetsCondition;

public interface AsAssetsService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsAssetsByPage(Page<AsAssets> page,AsAssetsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 固定资产表
	 */
	AsAssets getAsAssetsById(String id);

	/**
	 * 新增
	 * @param item 固定资产表
	 */
	void add(AsAssets item);

	/**
	 * 修改
	 * @param item 固定资产表
	 */
	void update(AsAssets item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 编号查重
	 */
	boolean selectcheck(String number);
}

