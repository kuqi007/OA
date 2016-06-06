package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkDjustDetails;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkDjustDetailsCondition;

@MyBatisDao
public interface WorkDjustDetailsDao {

	/**
	 * 查询区间数据
	 * @param condition 查询条件类
	 */
	List<WorkDjustDetails> listWorkDjustDetailsByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkDjustDetailsCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkDjustDetailsByPageCount(@Param("condition") WorkDjustDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 价格调整表详情
	 */
	WorkDjustDetails getWorkDjustDetailsById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 价格调整表详情
	 */
	void add(WorkDjustDetails item);

	/**
	 * 修改
	 * @param item 价格调整表详情
	 */
	void update(WorkDjustDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	public List<WorkDjustDetails> listDjustDetails(String id);
}

