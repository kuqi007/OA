package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.work.entity.WorkDjust;
import com.thinkgem.jeesite.modules.work.entity.WorkDjustDetails;
import com.thinkgem.jeesite.modules.work.service.WorkDjustService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dao.WorkDjustDao;
import com.thinkgem.jeesite.modules.work.dao.WorkDjustDetailsDao;
import com.thinkgem.jeesite.modules.work.dto.WorkDjustCondition;

@Service("workDjustServiceImpl")
@Transactional(value = "transactionManager")
public class WorkDjustServiceImpl implements WorkDjustService{

	@Resource
	private WorkDjustDao workDjustDao;
	@Resource
	private WorkDjustDetailsDao workDjustDetailsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkDjustByPage(Page<WorkDjust> page,WorkDjustCondition condition){
		int rows = workDjustDao.listWorkDjustByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkDjust> list = workDjustDao.listWorkDjustByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 价格调整表
	 */
	public WorkDjust getWorkDjustById(String id){
		return workDjustDao.getWorkDjustById(id);
	}

	/**
	 * 新增
	 * @param item 价格调整表
	 */
	public void add(WorkDjust item){
		workDjustDao.add(item);
	}

	/**
	 * 修改
	 * @param item 价格调整表
	 */
	public void update(WorkDjust item){
		workDjustDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workDjustDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workDjustDao.termination(id);
	}

	@Override
	public void addPrevent(String[] mode, WorkDjust item) {
		User user=UserUtils.getUser();// 获取当前用户
		for (int j = 0; j < mode.length; j++) {
			String [] productde=mode[j].split("_");
			WorkDjustDetails djustDetails=new WorkDjustDetails();
			djustDetails.setCreateBy(user.getId());
			djustDetails.setId(IdGen.uuid());
			djustDetails.setDjustid(item.getId());
			djustDetails.setEhavingid(productde[0]);
			djustDetails.setBrand(productde[1]);
			djustDetails.setSupplier(productde[2]);
			djustDetails.setName(productde[3]);
			djustDetails.setSpecifications(productde[4]);
			djustDetails.setPriceOld(Double.valueOf(productde[5]));
			djustDetails.setPriceNew(Double.valueOf(productde[6]));
			djustDetails.setPercentage(Double.valueOf(productde[7]));
			djustDetails.setOnpriceOld(Double.valueOf(productde[8]));
			djustDetails.setOnpriceNew(Double.valueOf(productde[9]));
			djustDetails.setOnpercentage(Double.valueOf(productde[10]));
			djustDetails.setReason(productde[11]);
			djustDetails.setTime(DateUtils.parseDate(productde[12]));
			workDjustDetailsDao.add(djustDetails);
		}
		workDjustDao.add(item);
	}
	
}

