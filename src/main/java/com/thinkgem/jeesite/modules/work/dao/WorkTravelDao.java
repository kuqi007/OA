package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkTravelCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkTravel;

@MyBatisDao
public interface WorkTravelDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkTravel> listWorkTravelByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkTravelCondition condition);
	List<WorkTravel> listWorkTravel(@Param("condition") WorkTravelCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkTravelByPageCount(@Param("condition") WorkTravelCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 出差申请表
	 */
	WorkTravel getWorkTravelById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 出差申请表
	 */
	void add(WorkTravel item);

	/**
	 * 修改
	 * @param item 出差申请表
	 */
	void update(WorkTravel item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

