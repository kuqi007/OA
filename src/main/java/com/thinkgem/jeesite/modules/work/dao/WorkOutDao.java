package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkOutCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOut;

@MyBatisDao
public interface WorkOutDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkOut> listWorkOutByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkOutCondition condition);
	List<WorkOut> listWorkOut(@Param("condition") WorkOutCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkOutByPageCount(@Param("condition") WorkOutCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 外出单
	 */
	WorkOut getWorkOutById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 外出单
	 */
	void add(WorkOut item);

	/**
	 * 修改
	 * @param item 外出单
	 */
	void update(WorkOut item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

