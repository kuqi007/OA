package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkOvertimeCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOvertime;


@MyBatisDao
public interface WorkOvertimeDao {

	/**
	 * 查询区间数据
	 * @param
	 * @param condition 查询条件类
	 */
	List<WorkOvertime> listWorkOvertimeByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkOvertimeCondition condition);
	List<WorkOvertime> listWorkOvertime(@Param("condition") WorkOvertimeCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkOvertimeByPageCount(@Param("condition") WorkOvertimeCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 加班申请单
	 */
	WorkOvertime getWorkOvertimeById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 加班申请单
	 */
	void add(WorkOvertime item);

	/**
	 * 修改
	 * @param item 加班申请单
	 */
	void update(WorkOvertime item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

