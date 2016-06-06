package com.thinkgem.jeesite.modules.checkin.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.WorkDayUtils;
import com.thinkgem.jeesite.modules.checkin.dao.IOaCheckrealDao;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckrealCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckreal;
import com.thinkgem.jeesite.modules.checkin.service.IOaCheckrealService;

@Service("oaCheckrealServiceImpl")
@Transactional(value = "transactionManager")
public class OaCheckrealServiceImpl implements IOaCheckrealService{

	@Resource
	private IOaCheckrealDao oaCheckrealDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listOaCheckrealByPage(Page<OaCheckreal> pageResult,OaCheckrealCondition condition){
		int rows = oaCheckrealDao.listOaCheckrealByPageCount(condition);
		pageResult.setCount(rows);
		pageResult.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));
		RowBounds rowBounds = new RowBounds(pageResult.getFirstResult(),pageResult.getMaxResults());
		List<OaCheckreal> list = oaCheckrealDao.listOaCheckrealByPage(rowBounds,condition);
		for (OaCheckreal oaCheckreal : list) {
			if(WorkDayUtils.isWeekend(oaCheckreal.getDate())){
				oaCheckreal.setWeekend(true);//该日期为周末
			}
			if (oaCheckreal.getSignIn().equals(oaCheckreal.getSignOut())) {
					oaCheckreal.setSignOut(null);
			}
		}
		pageResult.setList(list);
		pageResult.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 上下班签到签退表
	 */
	public OaCheckreal getOaCheckrealById(Long id){
		return oaCheckrealDao.getOaCheckrealById(id);
	}

	/**
	 * 新增
	 * @param item 上下班签到签退表
	 */
	public void add(OaCheckreal item){
		oaCheckrealDao.add(item);
	}

	/**
	 * 修改
	 * @param item 上下班签到签退表
	 */
	public void update(OaCheckreal item){
		oaCheckrealDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(Long[] ids){
		oaCheckrealDao.delByIds(ids);
	}

}

