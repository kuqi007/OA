package com.thinkgem.jeesite.modules.work.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkReimbursementCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkReimbursement;


@MyBatisDao
public interface WorkReimbursementDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkReimbursement> listWorkReimbursementByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkReimbursementCondition condition);
	List<WorkReimbursement> listWorkReimbursement(@Param("condition") WorkReimbursementCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkReimbursementByPageCount(@Param("condition") WorkReimbursementCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 差旅报销单
	 */
	WorkReimbursement getWorkReimbursementById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 差旅报销单
	 */
	void add(WorkReimbursement item);

	/**
	 * 修改
	 * @param item 差旅报销单
	 */
	void update(WorkReimbursement item);
	/**改变付款状态*/
	void changePayment(@Param("id")String id,@Param("flag")Integer flag);
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**终止*/
	public void termination(@Param("id")String id);
	/**更新实际出差日期*/
	void updateDate(@Param("id")String id,@Param("be")Date be,@Param("en")Date en);
}

