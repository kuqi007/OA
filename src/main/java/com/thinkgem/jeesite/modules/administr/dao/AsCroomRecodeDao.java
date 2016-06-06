package com.thinkgem.jeesite.modules.administr.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.administr.entity.AsCroomRecode;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomRecodeCondition;

@MyBatisDao
public interface AsCroomRecodeDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsCroomRecode> listAsCroomRecodeByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsCroomRecodeCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsCroomRecodeByPageCount(@Param("condition") AsCroomRecodeCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 会议室申请使用记录表
	 */
	AsCroomRecode getAsCroomRecodeById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 会议室申请使用记录表
	 */
	void add(AsCroomRecode item);

	/**
	 * 修改
	 * @param item 会议室申请使用记录表
	 */
	void update(AsCroomRecode item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 查询输入时间的有效性
	 */
	public List<AsCroomRecode> listAsCroomRecode(@Param("begTime")Date begTime, @Param("endTime")Date endTime);
	
	/**同意OR不同意(1or2)*/
	void updateAgree(@Param("id")String id,@Param("state")Integer state);
}

