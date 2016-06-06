package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.administr.entity.AsCroomRecode;
import com.thinkgem.jeesite.modules.administr.service.AsCroomRecodeService;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dao.AsCroomRecodeDao;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomRecodeCondition;

@Service("asCroomRecodeServiceImpl")
@Transactional(value = "transactionManager")
public class AsCroomRecodeServiceImpl implements AsCroomRecodeService{

	@Resource
	private AsCroomRecodeDao asCroomRecodeDao;
	@Autowired
	private UserDao userDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listAsCroomRecodeByPage(Page<AsCroomRecode> page,AsCroomRecodeCondition condition){
		int rows = asCroomRecodeDao.listAsCroomRecodeByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsCroomRecode> list = asCroomRecodeDao.listAsCroomRecodeByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<AsCroomRecode> list2 =new ArrayList<AsCroomRecode>();
		for (AsCroomRecode asCroomRecode : list) {
			User user=userDao.getById(asCroomRecode.getCreateBy());
			asCroomRecode.setPeopleName(user.getName());
			asCroomRecode.setOfficeName(user.getOffice().getName());
			list2.add(asCroomRecode);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 会议室申请使用记录表
	 */
	public AsCroomRecode getAsCroomRecodeById(String id){
		return asCroomRecodeDao.getAsCroomRecodeById(id);
	}

	/**
	 * 新增
	 * @param item 会议室申请使用记录表
	 */
	public void add(AsCroomRecode item){
		asCroomRecodeDao.add(item);
	}

	/**
	 * 修改
	 * @param item 会议室申请使用记录表
	 */
	public void update(AsCroomRecode item){
		asCroomRecodeDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asCroomRecodeDao.delByIds(ids);
	}

	@Override
	public List<AsCroomRecode> listAsCroomRecode(Date begTime, Date endTime) {
		return asCroomRecodeDao.listAsCroomRecode(begTime, endTime);
	}

	@Override
	public void updateAgree(String id, Integer state) {
		asCroomRecodeDao.updateAgree(id, state);
	}

}

