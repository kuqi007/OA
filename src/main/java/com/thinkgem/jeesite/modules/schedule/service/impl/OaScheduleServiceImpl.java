package com.thinkgem.jeesite.modules.schedule.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.schedule.dao.IOaScheduleDao;
import com.thinkgem.jeesite.modules.schedule.dto.OaScheduleCondition;
import com.thinkgem.jeesite.modules.schedule.entity.OaSchedule;
import com.thinkgem.jeesite.modules.schedule.service.IOaScheduleService;

@Service("oaScheduleServiceImpl")
@Transactional(value = "transactionManager")
public class OaScheduleServiceImpl implements IOaScheduleService{

	@Resource
	private IOaScheduleDao oaScheduleDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listOaScheduleByPage(Page<OaSchedule> pageResult,OaScheduleCondition condition){
		int rows = oaScheduleDao.listOaScheduleByPageCount(condition);
		pageResult.setCount(rows);
		pageResult.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		RowBounds rowBounds = new RowBounds(pageResult.getPageNo(),pageResult.getPageSize());
		List<OaSchedule> list = oaScheduleDao.listOaScheduleByPage(rowBounds,condition);
		pageResult.setList(list);//显示数据
		pageResult.initialize();// 初始化page参数
	}
	/**
	 * 查询当前用户的日程userid
	 * @param condition 查询条件类
	 */
	public List<OaSchedule> getOaScheduleByUserId(String userId){
		List<OaSchedule> list = oaScheduleDao.getOaScheduleByUserId(userId);
		return list;
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 个人事物表; InnoDB free: 5120 kB
	 */
	public OaSchedule getOaScheduleById(String id){
		return oaScheduleDao.getOaScheduleById(id);
	}

	/**
	 * 新增
	 * @param item 个人事物表; InnoDB free: 5120 kB
	 */
	public void add(OaSchedule item){
		oaScheduleDao.add(item);
	}

	/**
	 * 修改
	 * @param item 个人事物表; InnoDB free: 5120 kB
	 */
	public void update(OaSchedule item){
		oaScheduleDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		oaScheduleDao.delByIds(ids);
	}
	
	/**
	 * 查询当前用户当日的日程安排
	 * @param condition 查询条件类
	 */
	public List<OaSchedule> getOaScheduleTodayByUserId(String userId){
		List<OaSchedule> list = oaScheduleDao.getOaScheduleTodayByUserId(userId);
		return list;
	}
	/**
	 * 查询当前用户近日的日程安排
	 * @param condition 查询条件类
	 */
	public List<OaSchedule> getOaScheduleRecnetByUserId(String userId) {
		List<OaSchedule> list = oaScheduleDao.getOaScheduleRecnetByUserId(userId);
		return list;
	}

}

