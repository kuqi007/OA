package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.administr.entity.AsAssets;
import com.thinkgem.jeesite.modules.administr.service.AsAssetsService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dao.AsAssetsDao;
import com.thinkgem.jeesite.modules.administr.dto.AsAssetsCondition;

@Service("asAssetsServiceImpl")
@Transactional(value = "transactionManager")
public class AsAssetsServiceImpl implements AsAssetsService{

	@Resource
	private AsAssetsDao asAssetsDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listAsAssetsByPage(Page<AsAssets> page,AsAssetsCondition condition){
		int rows = asAssetsDao.listAsAssetsByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsAssets> list = asAssetsDao.listAsAssetsByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 固定资产表
	 */
	public AsAssets getAsAssetsById(String id){
		return asAssetsDao.getAsAssetsById(id);
	}

	/**
	 * 新增
	 * @param item 固定资产表
	 */
	public void add(AsAssets item){
		asAssetsDao.add(item);
	}

	/**
	 * 修改
	 * @param item 固定资产表
	 */
	public void update(AsAssets item){
		asAssetsDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asAssetsDao.delByIds(ids);
	}
	/**
	 * 编号查重
	 * @param ids ID集合
	 * @return 没有从复返回true
	 */
	public boolean selectcheck(String number){
		List<AsAssets> list=asAssetsDao.getAsAssetsByNumber(number);
		if (list.size()==0) {
			return true;
		}else{
			return false;
		}
	}
}

