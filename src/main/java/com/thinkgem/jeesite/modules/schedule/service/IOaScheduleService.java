package com.thinkgem.jeesite.modules.schedule.service;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.schedule.dto.OaScheduleCondition;
import com.thinkgem.jeesite.modules.schedule.entity.OaSchedule;

public interface IOaScheduleService {

	/**
	 * 分页查询
	 * 
	 * @param pageResult
	 *            分页对象
	 * @param condition
	 *            查询条件类
	 */
	void listOaScheduleByPage(Page<OaSchedule> pageResult, OaScheduleCondition condition);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 *            主键
	 * @return 个人事物表; InnoDB free: 5120 kB
	 */
	OaSchedule getOaScheduleById(String id);

	/**
	 * 查询当前用户的日程userid
	 * 
	 * @param userid
	 * @return
	 */
	List<OaSchedule> getOaScheduleByUserId(String userId);

	/**
	 * 新增
	 * 
	 * @param item
	 *            个人事物表; InnoDB free: 5120 kB
	 */
	void add(OaSchedule item);

	/**
	 * 修改
	 * 
	 * @param item
	 *            个人事物表; InnoDB free: 5120 kB
	 */
	void update(OaSchedule item);

	/**
	 * 根据ID集合批量删除
	 * 
	 * @param ids
	 *            ID集合
	 */
	void delByIds(String[] ids);

	/**
	 * 查询当前用户的当天的日程
	 * 
	 * @param userid
	 * @return
	 */
	List<OaSchedule> getOaScheduleTodayByUserId(String userId);

	/**
	 * 查询当前用户的近日的日程
	 * 
	 * @param userid
	 * @return
	 */
	List<OaSchedule> getOaScheduleRecnetByUserId(String userId);
}
