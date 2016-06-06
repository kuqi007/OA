package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkDjust;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkDjustCondition;

@MyBatisDao
public interface WorkDjustDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkDjust> listWorkDjustByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkDjustCondition condition);
	List<WorkDjust> listWorkDjust(@Param("condition") WorkDjustCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkDjustByPageCount(@Param("condition") WorkDjustCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 价格调整表
	 */
	WorkDjust getWorkDjustById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 价格调整表
	 */
	void add(WorkDjust item);

	/**
	 * 修改
	 * @param item 价格调整表
	 */
	void update(WorkDjust item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);

}

