package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkCost;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkCostCondition;

@MyBatisDao
public interface WorkCostDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkCost> listWorkCostByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkCostCondition condition);
	List<WorkCost> listWorkCost(@Param("condition") WorkCostCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkCostByPageCount(@Param("condition") WorkCostCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 费用报销单
	 */
	WorkCost getWorkCostById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 费用报销单
	 */
	void add(WorkCost item);

	/**
	 * 修改
	 * @param item 费用报销单
	 */
	void update(WorkCost item);
	
	/**
	 * 修改
	 * @param item 费用报销单
	 */
	void updateAutograph(WorkCost item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
	/**改变付款状态*/
	void changePayment(@Param("id")String id,@Param("flag")Integer flag);
}

