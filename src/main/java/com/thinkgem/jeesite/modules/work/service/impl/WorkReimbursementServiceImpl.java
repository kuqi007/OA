package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.work.dao.WorkReimbursementDao;
import com.thinkgem.jeesite.modules.work.dto.WorkReimbursementCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkReimbursement;
import com.thinkgem.jeesite.modules.work.service.WorkReimbursementService;


@Service("workReimbursementServiceImpl")
@Transactional(value = "transactionManager")
public class WorkReimbursementServiceImpl implements WorkReimbursementService{

	@Resource
	private WorkReimbursementDao workReimbursementDao;
	@Resource
	private OfficeDao officeDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkReimbursementByPage(Page<WorkReimbursement> page,WorkReimbursementCondition condition){
		int rows = workReimbursementDao.listWorkReimbursementByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkReimbursement> list = workReimbursementDao.listWorkReimbursementByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkReimbursement> list2=new ArrayList<WorkReimbursement>();
		for (WorkReimbursement item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 差旅报销单
	 */
	public WorkReimbursement getWorkReimbursementById(String id){
		return workReimbursementDao.getWorkReimbursementById(id);
	}

	/**
	 * 新增
	 * @param item 差旅报销单
	 */
	public void add(WorkReimbursement item){
		workReimbursementDao.add(item);
	}

	/**
	 * 修改
	 * @param item 差旅报销单
	 */
	public void update(WorkReimbursement item){
		workReimbursementDao.update(item);
	}
	/**改变付款状态*/
	public void changePayment(String id,Integer flag){
		workReimbursementDao.changePayment(id,flag);
	};
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workReimbursementDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workReimbursementDao.termination(id);
	}

	@Override
	public void updateDate(String id, Date be, Date en) {
		workReimbursementDao.updateDate(id, be, en);
	}
}

