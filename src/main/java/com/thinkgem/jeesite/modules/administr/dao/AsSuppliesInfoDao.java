package com.thinkgem.jeesite.modules.administr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesInfo;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesInfoCondition;

@MyBatisDao
public interface AsSuppliesInfoDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsSuppliesInfo> listAsSuppliesInfoByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsSuppliesInfoCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsSuppliesInfoByPageCount(@Param("condition") AsSuppliesInfoCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品入库表
	 */
	AsSuppliesInfo getAsSuppliesInfoById(@Param("id") String id);

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

}

