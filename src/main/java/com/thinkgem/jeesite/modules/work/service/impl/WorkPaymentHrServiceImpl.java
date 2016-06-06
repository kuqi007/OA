package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkPaymentDao;
import com.thinkgem.jeesite.modules.work.dao.WorkPaymentHrDao;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentCondition;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentHrCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkPayment;
import com.thinkgem.jeesite.modules.work.entity.WorkPaymentHr;
import com.thinkgem.jeesite.modules.work.service.WorkPaymentHrService;
import com.thinkgem.jeesite.modules.work.service.WorkPaymentService;


@Service("workPaymentHrServiceImpl")
@Transactional(value = "transactionManager")
public class WorkPaymentHrServiceImpl implements WorkPaymentHrService{

	@Resource
	private WorkPaymentHrDao workPaymentHrDao;
	@Resource
	private OfficeDao officeDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkPaymentByPage(Page<WorkPaymentHr> page,WorkPaymentHrCondition condition){
		int rows = workPaymentHrDao.listWorkPaymentByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkPaymentHr> list = workPaymentHrDao.listWorkPaymentByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkPaymentHr> list2=new ArrayList<WorkPaymentHr>();
		for (WorkPaymentHr item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 付款申请单
	 */
	public WorkPaymentHr getWorkPaymentById(String id){
		return workPaymentHrDao.getWorkPaymentById(id);
	}

	/**
	 * 新增
	 * @param item 付款申请单
	 */
	public void add(WorkPaymentHr item){
		workPaymentHrDao.add(item);
	}

	/**
	 * 修改
	 * @param item 付款申请单
	 */
	public void update(WorkPaymentHr item){
		workPaymentHrDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workPaymentHrDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workPaymentHrDao.termination(id);
	}

	@Override
	public void changePayment(String id, Integer flag) {
		workPaymentHrDao.changePayment(id, flag);
	}
}

