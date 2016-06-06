package com.thinkgem.jeesite.modules.administr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsOutDetailsCondition;

@MyBatisDao
public interface AsOutDetailsDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsOutDetails> listAsOutDetailsByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsOutDetailsCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsOutDetailsByPageCount(@Param("condition") AsOutDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 出库详情表
	 */
	AsOutDetails getAsOutDetailsById(@Param("id") String id);

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
	public List<AsOutDetails> listAsOutDetails(@Param("id")String id);
	
}

