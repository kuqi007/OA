package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkIntegral;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkIntegralCondition;

@MyBatisDao
public interface WorkIntegralDao {

	/**
	 * 查询区间数据
	 * @param condition 查询条件类
	 */
	List<WorkIntegral> listWorkIntegralByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkIntegralCondition condition);
	List<WorkIntegral> listWorkIntegral(@Param("condition") WorkIntegralCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkIntegralByPageCount(@Param("condition") WorkIntegralCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 积分撤销申请表
	 */
	WorkIntegral getWorkIntegralById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 积分撤销申请表
	 */
	void add(WorkIntegral item);

	/**
	 * 修改
	 * @param item 积分撤销申请表
	 */
	void update(WorkIntegral item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(String id);
	/**改变冻结状态*/
	void updateFrozen(@Param("id")String id,@Param("frozen")Integer frozen);
	/**改变入档状态*/
	void updateRecord(@Param("id")String id,@Param("record")Integer record);
	/**实际退款数量*/
	void updateRefund(@Param("id")String id,@Param("refund")Double refund);

}

