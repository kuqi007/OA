package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkRestCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRest;


@MyBatisDao
public interface WorkRestDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkRest> listWorkRestByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkRestCondition condition);
	List<WorkRest> listWorkRest(@Param("condition") WorkRestCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkRestByPageCount(@Param("condition") WorkRestCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 换休申请单
	 */
	WorkRest getWorkRestById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 换休申请单
	 */
	void add(WorkRest item);

	/**
	 * 修改
	 * @param item 换休申请单
	 */
	void update(WorkRest item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

