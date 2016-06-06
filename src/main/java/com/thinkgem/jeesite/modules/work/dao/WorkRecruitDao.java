package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkRecruitCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRecruit;

@MyBatisDao
public interface WorkRecruitDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkRecruit> listWorkRecruitByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkRecruitCondition condition);
	List<WorkRecruit> listWorkRecruit(@Param("condition") WorkRecruitCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkRecruitByPageCount(@Param("condition") WorkRecruitCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 招聘需求表
	 */
	WorkRecruit getWorkRecruitById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 招聘需求表
	 */
	void add(WorkRecruit item);

	/**
	 * 修改
	 * @param item 招聘需求表
	 */
	void update(WorkRecruit item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

