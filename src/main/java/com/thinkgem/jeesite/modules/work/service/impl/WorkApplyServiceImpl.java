package com.thinkgem.jeesite.modules.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dao.WorkApplyDao;
import com.thinkgem.jeesite.modules.work.dao.WorkApplyDetailsDao;
import com.thinkgem.jeesite.modules.work.entity.WorkApply;
import com.thinkgem.jeesite.modules.work.entity.WorkApplyDetails;
import com.thinkgem.jeesite.modules.work.service.WorkApplyService;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyCondition;

@Service("workApplyServiceImpl")
@Transactional(value = "transactionManager")
public class WorkApplyServiceImpl implements WorkApplyService{

	@Resource
	private WorkApplyDao workApplyDao;
	@Resource
	private WorkApplyDetailsDao workApplyDetailsDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listWorkApplyByPage(Page<WorkApply> page,WorkApplyCondition condition){
		int rows = workApplyDao.listWorkApplyByPageCount(condition);
		page.setCount(rows);// 总条数
		List<WorkApply> list = workApplyDao.listWorkApplyByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品申请表
	 */
	public WorkApply getWorkApplyById(String id){
		return workApplyDao.getWorkApplyById(id);
	}

	/**
	 * 新增
	 * @param item 办公用品申请表
	 */
	public void add(WorkApply item){
		workApplyDao.add(item);
	}

	/**
	 * 修改
	 * @param item 办公用品申请表
	 */
	public void update(WorkApply item){
		workApplyDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		workApplyDao.delByIds(ids);
	}
	/**终止*/
	public void termination(String id){
		workApplyDao.termination(id);
	}
	
	@Override
	public void addPrevent(String[] mode, WorkApply item) {
		User user=UserUtils.getUser();// 获取当前用户
		for (int j = 0; j < mode.length; j++) {
			String [] productde=mode[j].split("-");
			WorkApplyDetails workApplyDetails=new WorkApplyDetails();
			workApplyDetails.setArticles(productde[0]);
			workApplyDetails.setCreateBy(user.getId());
			workApplyDetails.setApplyid(item.getId());
			workApplyDetails.setId(IdGen.uuid());
			workApplyDetails.setNum(Integer.parseInt(productde[1]));
			workApplyDetailsDao.add(workApplyDetails);
		}
		workApplyDao.add(item);
	}
}

