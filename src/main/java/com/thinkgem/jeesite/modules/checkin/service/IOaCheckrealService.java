package com.thinkgem.jeesite.modules.checkin.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckrealCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckreal;

public interface IOaCheckrealService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listOaCheckrealByPage(Page<OaCheckreal> pageResult,OaCheckrealCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 上下班签到签退表
	 */
	OaCheckreal getOaCheckrealById(Long id);

	/**
	 * 新增
	 * @param item 上下班签到签退表
	 */
	void add(OaCheckreal item);

	/**
	 * 修改
	 * @param item 上下班签到签退表
	 */
	void update(OaCheckreal item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(Long[] ids);

}

