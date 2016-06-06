package com.thinkgem.jeesite.modules.administr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.administr.entity.AsCroom;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomCondition;

@MyBatisDao
public interface AsCroomDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsCroom> listAsCroomByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsCroomCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsCroomByPageCount(@Param("condition") AsCroomCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 会议室表
	 */
	AsCroom getAsCroomById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 会议室表
	 */
	void add(AsCroom item);

	/**
	 * 修改
	 * @param item 会议室表
	 */
	void update(AsCroom item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

}

