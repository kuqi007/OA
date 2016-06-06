package com.thinkgem.jeesite.modules.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.modules.work.entity.WorkLoan;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.dto.WorkLoanCondition;

@MyBatisDao
public interface WorkLoanDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<WorkLoan> listWorkLoanByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") WorkLoanCondition condition);
	List<WorkLoan> listWorkLoan(@Param("condition") WorkLoanCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listWorkLoanByPageCount(@Param("condition") WorkLoanCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 借款申请表
	 */
	WorkLoan getWorkLoanById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 借款申请表
	 */
	void add(WorkLoan item);

	/**
	 * 修改
	 * @param item 借款申请表
	 */
	void update(WorkLoan item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**付款状态*/
	void changeLoan(@Param("id")String id,@Param("flag")Integer flag);
	/**
	 * 终止
	 * */
	void termination(String id);
}

