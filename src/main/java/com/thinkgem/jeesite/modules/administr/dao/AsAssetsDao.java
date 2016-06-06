package com.thinkgem.jeesite.modules.administr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.administr.entity.AsAssets;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsAssetsCondition;

@MyBatisDao
public interface AsAssetsDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsAssets> listAsAssetsByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsAssetsCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsAssetsByPageCount(@Param("condition") AsAssetsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 固定资产表
	 */
	AsAssets getAsAssetsById(@Param("id") String id);

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
	 * 根据编号查询
	 */
	List<AsAssets> getAsAssetsByNumber(String number);

}

