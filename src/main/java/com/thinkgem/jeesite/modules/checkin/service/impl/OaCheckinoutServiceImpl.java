package com.thinkgem.jeesite.modules.checkin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.checkin.dao.IOaCheckinoutDao;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckinoutCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckinout;
import com.thinkgem.jeesite.modules.checkin.service.IOaCheckinoutService;

@Service("oaCheckinoutServiceImpl")
@Transactional(value = "transactionManager")
public class OaCheckinoutServiceImpl implements IOaCheckinoutService {

	@Resource
	private IOaCheckinoutDao oaCheckinoutDao;

	/**
	 * 分页查询
	 * 
	 * @param pageResult
	 *            分页对象
	 * @param condition
	 *            查询条件类
	 */
	public void listOaCheckinoutByPage(Page<OaCheckinout> pageResult, OaCheckinoutCondition condition) {
		int rows = oaCheckinoutDao.listOaCheckinoutByPageCount(condition);
		pageResult.setCount(rows);
		pageResult.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));
		RowBounds rowBounds = new RowBounds(pageResult.getFirstResult(), pageResult.getMaxResults());
		List<OaCheckinout> list = oaCheckinoutDao.listOaCheckinoutByPage(rowBounds, condition);
		pageResult.setList(list);
		pageResult.initialize();// 初始化page参数
	}

	/**
	 * 分页查询个人第一次和最后一次考勤，时间段未今日5点到次日5点
	 * 
	 * @param pageResult
	 *            分页对象
	 * @param condition
	 *            查询条件类
	 */
	public void listOaCheckinoutByPageMe(Page<OaCheckinout> pageResult, OaCheckinoutCondition condition) {
		int rows = oaCheckinoutDao.listOaCheckinoutByPageCount(condition);
		pageResult.setCount(rows);
		pageResult.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));
		RowBounds rowBounds = new RowBounds(pageResult.getFirstResult(), pageResult.getMaxResults());
		List<OaCheckinout> list = oaCheckinoutDao.listOaCheckinoutByPage(rowBounds, condition);
//		List<OaCheckinout> list2 = new ArrayList<OaCheckinout>();
//		if (list.size()!=0) {
//		list2.add(list.get(0));
//		list2.add(list.get(list.size() - 1));
//		}
		pageResult.setList(list);
		pageResult.initialize();// 初始化page参数
	}

	/**
	 * 查询特定工号的考勤记录
	 * 
	 * @param condition
	 *            查询条件类
	 */
	public List<OaCheckinout> getCheckRecordByUserNo(String userNo) {
		List<OaCheckinout> list = oaCheckinoutDao.getCheckRecordByUserNo(userNo);
		return list;
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 *            主键
	 * @return 考勤登记表
	 */
	public OaCheckinout getOaCheckinoutById(String id) {
		return oaCheckinoutDao.getOaCheckinoutById(id);
	}

	/**
	 * 新增
	 * 
	 * @param item
	 *            考勤登记表
	 */
	public void add(OaCheckinout item) {
		oaCheckinoutDao.add(item);
	}

	/**
	 * 修改
	 * 
	 * @param item
	 *            考勤登记表
	 */
	public void update(OaCheckinout item) {
		oaCheckinoutDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * 
	 * @param ids
	 *            ID集合
	 */
	public void delByIds(String[] ids) {
		oaCheckinoutDao.delByIds(ids);
	}

}
