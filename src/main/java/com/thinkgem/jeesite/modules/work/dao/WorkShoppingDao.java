package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;

@MyBatisDao
public interface WorkShoppingDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkShopping> listWorkShoppingByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkShoppingCondition condition);
	List<WorkShopping> listWorkShopping(@Param("condition") WorkShoppingCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkShoppingByPageCount(@Param("condition") WorkShoppingCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 采购申请单
	 */
	WorkShopping getWorkShoppingById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 采购申请单
	 */
	void add(WorkShopping item);

	/**
	 * 修改
	 * @param item 采购申请单
	 */
	void update(WorkShopping item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 终止
	 * */
	void termination(@Param("id")String id);
	/**
	 * 所有未入库订单
	 * */
	List<WorkShopping> listShopping();
	/**
	 * 更新采购单入库状态
	 * */
	void updateStorage(@Param("id")String id);
	/**改变付款状态*/
	void changePayment(@Param("id")String id,@Param("flag")Integer flag);
}

