package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkPayment;

@MyBatisDao
public interface WorkPaymentDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkPayment> listWorkPaymentByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkPaymentCondition condition);
	List<WorkPayment> listWorkPayment(@Param("condition") WorkPaymentCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkPaymentByPageCount(@Param("condition") WorkPaymentCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 付款申请单
	 */
	WorkPayment getWorkPaymentById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 付款申请单
	 */
	void add(WorkPayment item);

	/**
	 * 修改
	 * @param item 付款申请单
	 */
	void update(WorkPayment item);
	/**改变付款状态*/
	void changePayment(@Param("id")String id,@Param("flag")Integer flag);
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
}

