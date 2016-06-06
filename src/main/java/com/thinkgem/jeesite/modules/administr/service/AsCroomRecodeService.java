package com.thinkgem.jeesite.modules.administr.service;


import com.thinkgem.jeesite.modules.administr.entity.AsCroomRecode;

import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomRecodeCondition;

public interface AsCroomRecodeService {

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listAsCroomRecodeByPage(Page<AsCroomRecode> page,AsCroomRecodeCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 会议室申请使用记录表
	 */
	AsCroomRecode getAsCroomRecodeById(String id);

	/**
	 * 新增
	 * @param item 会议室申请使用记录表
	 */
	void add(AsCroomRecode item);

	/**
	 * 修改
	 * @param item 会议室申请使用记录表
	 */
	void update(AsCroomRecode item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	
	/**
	 * 查询输入时间的有效性
	 * 
	 */
	List<AsCroomRecode> listAsCroomRecode(Date begTime,Date endTime);
	
	/**同意OR不同意(1or2)*/
	void updateAgree(String id,Integer state);
}

