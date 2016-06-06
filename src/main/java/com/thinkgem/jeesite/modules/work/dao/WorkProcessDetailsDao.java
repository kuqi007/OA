package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkProcessDetailsCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkProcessDetails;

@MyBatisDao
public interface WorkProcessDetailsDao {

	/**
	 * 查询区间数据
	 * @param condition 查询条件类
	 */
	List<WorkProcessDetails> listWorkProcessDetailsByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkProcessDetailsCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkProcessDetailsByPageCount(@Param("condition") WorkProcessDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 流程详情表
	 */
	WorkProcessDetails getWorkProcessDetailsById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 流程详情表
	 */
	void add(WorkProcessDetails item);

	/**
	 * 修改
	 * @param item 流程详情表
	 */
	void update(WorkProcessDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**根据流程表id查询流程详情信息*/
	List<WorkProcessDetails> listWorkProcessDetails(String id);

}

