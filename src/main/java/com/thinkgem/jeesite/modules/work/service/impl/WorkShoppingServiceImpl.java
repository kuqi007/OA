package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.dao.OfficeDao;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dao.WorkShoppingDao;
import com.thinkgem.jeesite.modules.work.dao.WorkShoppingDetailsDao;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;
import com.thinkgem.jeesite.modules.work.service.WorkShoppingService;



@Service("workShoppingServiceImpl")
@Transactional(value = "transactionManager")
public class WorkShoppingServiceImpl implements WorkShoppingService{

	@Resource
	private WorkShoppingDao workShoppingDao;
	@Resource
	private OfficeDao officeDao;
	@Resource
	private WorkShoppingDetailsDao workShoppingDetailsDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkShoppingByPage(Page<WorkShopping> page,WorkShoppingCondition condition){
		int rows = workShoppingDao.listWorkShoppingByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkShopping> list = workShoppingDao.listWorkShoppingByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<WorkShopping> list2=new ArrayList<WorkShopping>();
		for (WorkShopping item : list) {
			item.setDepartmentName(officeDao.getOfficeById(item.getDepartment()).getName());
			list2.add(item);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 采购申请单
	 */
	public WorkShopping getWorkShoppingById(String id){
		return workShoppingDao.getWorkShoppingById(id);
	}

	/**
	 * 新增
	 * @param item 采购申请单
	 */
	public void add(WorkShopping item){
		workShoppingDao.add(item);
	}

	/**
	 * 修改
	 * @param item 采购申请单
	 */
	public void update(WorkShopping item){
		workShoppingDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workShoppingDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workShoppingDao.termination(id);
	}

	@Override
	public void addPrevent(String[] mode, WorkShopping item) {
		User user=UserUtils.getUser();// 获取当前用户
		for (int j = 0; j < mode.length; j++) {
			String [] productde=mode[j].split("-");
			WorkShoppingDetails shoppingDetails=new WorkShoppingDetails();
			shoppingDetails.setArticles(productde[0]);
			shoppingDetails.setCreateBy(user.getId());
			shoppingDetails.setSuppliesid(item.getId());
			shoppingDetails.setId(IdGen.uuid());
			shoppingDetails.setNum(Integer.parseInt(productde[1]));
			shoppingDetails.setPrice(Double.valueOf(productde[2]));
			workShoppingDetailsDao.add(shoppingDetails);
		}
		workShoppingDao.add(item);
	}

	@Override
	public List<WorkShopping> listShopping() {
		return workShoppingDao.listShopping();
	}

	@Override
	public void changePayment(String id, Integer flag) {
		workShoppingDao.changePayment(id, flag);
	}
}

