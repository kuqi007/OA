/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.work.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;


@MyBatisDao
public interface WorkLeaveDao {

	/**
	 * 查询区间数据
	 * @param 
	 * @param condition 查询条件类
	 */
	List<WorkLeave> listWorkLeaveByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkLeaveCondition condition);
	List<WorkLeave> listWorkLeave(@Param("condition") WorkLeaveCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkLeaveByPageCount(@Param("condition") WorkLeaveCondition condition);
	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 加班单表
	 */
	WorkLeave getWorkLeaveById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 加班单表
	 */
	void add(WorkLeave item);

	/**
	 * 修改
	 * @param item 加班单表
	 */
	void update(WorkLeave item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	
	List<WorkLeave> ListPage();
	
	/**终止*/
	public void termination(@Param("id")String id);
}
