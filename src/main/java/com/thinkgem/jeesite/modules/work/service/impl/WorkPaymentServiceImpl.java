package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkPaymentDao;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkPayment;
import com.thinkgem.jeesite.modules.work.service.WorkPaymentService;


@Service("workPaymentServiceImpl")
@Transactional(value = "transactionManager")
public class WorkPaymentServiceImpl implements WorkPaymentService{

	@Resource
	private WorkPaymentDao workPaymentDao;
	@Resource
	private OfficeDao officeDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkPaymentByPage(Page<WorkPayment> page,WorkPaymentCondition condition){
		int rows = workPaymentDao.listWorkPaymentByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkPayment> list = workPaymentDao.listWorkPaymentByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkPayment> list2=new ArrayList<WorkPayment>();
		for (WorkPayment item : list) {
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
	public WorkPayment getWorkPaymentById(String id){
		return workPaymentDao.getWorkPaymentById(id);
	}

	/**
	 * 新增
	 * @param item 付款申请单
	 */
	public void add(WorkPayment item){
		workPaymentDao.add(item);
	}

	/**
	 * 修改
	 * @param item 付款申请单
	 */
	public void update(WorkPayment item){
		workPaymentDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workPaymentDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workPaymentDao.termination(id);
	}

	@Override
	public void changePayment(String id, Integer flag) {
		workPaymentDao.changePayment(id, flag);
	}
}

