package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingDetailsCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;

@MyBatisDao
public interface WorkShoppingDetailsDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkShoppingDetails> listWorkShoppingDetailsByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkShoppingDetailsCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkShoppingDetailsByPageCount(@Param("condition") WorkShoppingDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 采购详情表
	 */
	WorkShoppingDetails getWorkShoppingDetailsById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 采购详情表
	 */
	void add(WorkShoppingDetails item);

	/**
	 * 修改
	 * @param item 采购详情表
	 */
	void update(WorkShoppingDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	public List<WorkShoppingDetails> listShoppingDetails(String id);
}

