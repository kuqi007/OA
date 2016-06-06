package com.thinkgem.jeesite.modules.administr.service;


import com.thinkgem.jeesite.modules.administr.entity.AsCroom;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomCondition;

public interface AsCroomService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsCroomByPage(Page<AsCroom> page,AsCroomCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 会议室表
	 */
	AsCroom getAsCroomById(String id);

	/**
	 * 新增
	 * @param item 会议室表
	 */
	void add(AsCroom item);

	/**
	 * 修改
	 * @param item 会议室表
	 */
	void update(AsCroom item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

}

