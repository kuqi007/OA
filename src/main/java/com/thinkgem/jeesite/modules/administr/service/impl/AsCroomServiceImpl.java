package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dao.AsCroomDao;
import com.thinkgem.jeesite.modules.administr.entity.AsCroom;
import com.thinkgem.jeesite.modules.administr.service.AsCroomService;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomCondition;

@Service("asCroomServiceImpl")
@Transactional(value = "transactionManager")
public class AsCroomServiceImpl implements AsCroomService{
	
	@Resource
	private AsCroomDao asCroomDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listAsCroomByPage(Page<AsCroom> page,AsCroomCondition condition){
		int rows = asCroomDao.listAsCroomByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsCroom> list = asCroomDao.listAsCroomByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 会议室表
	 */
	public AsCroom getAsCroomById(String id){
		return asCroomDao.getAsCroomById(id);
	}

	/**
	 * 新增
	 * @param item 会议室表
	 */
	public void add(AsCroom item){
		asCroomDao.add(item);
	}

	/**
	 * 修改
	 * @param item 会议室表
	 */
	public void update(AsCroom item){
		asCroomDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asCroomDao.delByIds(ids);
	}

}

