package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkApplyDetails;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyDetailsCondition;

@MyBatisDao
public interface WorkApplyDetailsDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkApplyDetails> listWorkApplyDetailsByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkApplyDetailsCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkApplyDetailsByPageCount(@Param("condition") WorkApplyDetailsCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 
	 */
	WorkApplyDetails getWorkApplyDetailsById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 
	 */
	void add(WorkApplyDetails item);

	/**
	 * 修改
	 * @param item 
	 */
	void update(WorkApplyDetails item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 根据申请单id查询
	 * */
	List<WorkApplyDetails> listApplyDetails(@Param("id")String id);

}

