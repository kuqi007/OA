package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkApply;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyCondition;

@MyBatisDao
public interface WorkApplyDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkApply> listWorkApplyByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkApplyCondition condition);
	List<WorkApply> listWorkApply(@Param("condition") WorkApplyCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkApplyByPageCount(@Param("condition") WorkApplyCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品申请表
	 */
	WorkApply getWorkApplyById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 办公用品申请表
	 */
	void add(WorkApply item);

	/**
	 * 修改
	 * @param item 办公用品申请表
	 */
	void update(WorkApply item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

