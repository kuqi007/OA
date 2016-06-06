package com.thinkgem.jeesite.modules.schedule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.schedule.dto.OaScheduleCondition;
import com.thinkgem.jeesite.modules.schedule.entity.OaSchedule;

@MyBatisDao
public interface IOaScheduleDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<OaSchedule> listOaScheduleByPage(RowBounds bounds,@Param("condition") OaScheduleCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listOaScheduleByPageCount(@Param("condition") OaScheduleCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 个人事物表; InnoDB free: 5120 kB
	 */
	OaSchedule getOaScheduleById(@Param("id") String id);
	/**
	 * 根据userID查询
	 * @param userID 当前登录用户
	 * @return 个人事物表; InnoDB free: 5120 kB
	 */
	List<OaSchedule> getOaScheduleByUserId(@Param("userId") String id);

	/**
	 * 新增
	 * @param item 个人事物表; InnoDB free: 5120 kB
	 */
	void add(OaSchedule item);

	/**
	 * 修改
	 * @param item 个人事物表; InnoDB free: 5120 kB
	 */
	void update(OaSchedule item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	List<OaSchedule> getOaScheduleTodayByUserId(@Param("userId") String userId);
	List<OaSchedule> getOaScheduleRecnetByUserId(@Param("userId") String userId);
	

}

