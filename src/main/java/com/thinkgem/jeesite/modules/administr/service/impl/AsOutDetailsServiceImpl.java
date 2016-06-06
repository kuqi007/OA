package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;
import com.thinkgem.jeesite.modules.administr.service.AsOutDetailsService;
import com.thinkgem.jeesite.modules.administr.dao.AsOutDetailsDao;
import com.thinkgem.jeesite.modules.administr.dto.AsOutDetailsCondition;

@Service("asOutDetailsServiceImpl")
@Transactional(value = "transactionManager")
public class AsOutDetailsServiceImpl implements AsOutDetailsService{

	@Resource
	private AsOutDetailsDao asOutDetailsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listAsOutDetailsByPage(Page<AsOutDetails> page,AsOutDetailsCondition condition){
		int rows = asOutDetailsDao.listAsOutDetailsByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsOutDetails> list = asOutDetailsDao.listAsOutDetailsByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 出库详情表
	 */
	public AsOutDetails getAsOutDetailsById(String id){
		return asOutDetailsDao.getAsOutDetailsById(id);
	}

	/**
	 * 新增
	 * @param item 出库详情表
	 */
	public void add(AsOutDetails item){
		asOutDetailsDao.add(item);
	}

	/**
	 * 修改
	 * @param item 出库详情表
	 */
	public void update(AsOutDetails item){
		asOutDetailsDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asOutDetailsDao.delByIds(ids);
	}
	/**根据出库id查询出库详情*/
	public List<AsOutDetails> listAsOutDetails(String id){
		return asOutDetailsDao.listAsOutDetails(id);
	};
}

