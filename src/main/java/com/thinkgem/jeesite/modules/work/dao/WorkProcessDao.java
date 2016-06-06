package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkProcess;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkProcessCondition;

@MyBatisDao
public interface WorkProcessDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkProcess> listWorkProcessByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkProcessCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkProcessByPageCount(@Param("condition") WorkProcessCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 流程表
	 */
	WorkProcess getWorkProcessById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 流程表
	 */
	void add(WorkProcess item);

	/**
	 * 修改
	 * @param item 流程表
	 */
	void update(WorkProcess item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	
	/**
	 * 根据用户id和单据类型查询其所绑定的流程
	 * 
	 */
	WorkProcess getWorkProcess(@Param("uid")String uid,@Param("type")Integer type);
}

