package com.thinkgem.jeesite.modules.checkin.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckinoutCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckinout;

public interface IOaCheckinoutService {

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param condition 查询条件类
	 */
	void listOaCheckinoutByPage(Page<OaCheckinout> page,OaCheckinoutCondition condition);
	/**
	 * 分页查询个人第一次和最后一次考勤，时间段未今日5点到次日5点
	 * 
	 * @param pageResult
	 *            分页对象
	 * @param condition
	 *            查询条件类
	 */
	public void listOaCheckinoutByPageMe(Page<OaCheckinout> pageResult, OaCheckinoutCondition condition);
	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 考勤登记表
	 */
	OaCheckinout getOaCheckinoutById(String id);

	/**
	 * 新增
	 * @param item 考勤登记表
	 */
	void add(OaCheckinout item);

	/**
	 * 修改
	 * @param item 考勤登记表
	 */
	void update(OaCheckinout item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

}

