package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.administr.dao.AsSuppliesDao;
import com.thinkgem.jeesite.modules.administr.dao.AsSuppliesInfoDao;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesInfo;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesInfoService;
import com.thinkgem.jeesite.modules.sys.dao.ProductTypeDao;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.work.dao.WorkShoppingDao;
import com.thinkgem.jeesite.modules.work.dao.WorkShoppingDetailsDao;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesInfoCondition;

@Service("asSuppliesInfoServiceImpl")
@Transactional(value = "transactionManager")
public class AsSuppliesInfoServiceImpl implements AsSuppliesInfoService{
	
	@Resource
	private AsSuppliesInfoDao asSuppliesInfoDao;
	@Resource
	private AsSuppliesDao asSuppliesDao;
	@Resource
	private ProductTypeDao productTypeDao;
	@Resource
	private WorkShoppingDao workShoppingDao;
	@Resource
	private WorkShoppingDetailsDao workShoppingDetailsDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listAsSuppliesInfoByPage(Page<AsSuppliesInfo> page,AsSuppliesInfoCondition condition){
		int rows = asSuppliesInfoDao.listAsSuppliesInfoByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsSuppliesInfo> list = asSuppliesInfoDao.listAsSuppliesInfoByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<AsSuppliesInfo> list2=new ArrayList<AsSuppliesInfo>();
		for (AsSuppliesInfo asSuppliesInfo : list) {
			AsSuppliesInfo test=asSuppliesInfo;
			AsSupplies asSupplies=asSuppliesDao.getAsSuppliesById(test.getArticles());
			if (asSupplies!=null) {
				test.setArticlesName(asSupplies.getName());
				test.setTypeName(productTypeDao.getProductTypeById(asSupplies.getType()).getName());	
			}
			list2.add(test);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品入库表
	 */
	public AsSuppliesInfo getAsSuppliesInfoById(String id){
		return asSuppliesInfoDao.getAsSuppliesInfoById(id);
	}

	/**
	 * 新增
	 * @param item 办公用品入库表
	 */
	public void add(AsSuppliesInfo item){
		asSuppliesInfoDao.add(item);
	}

	/**
	 * 修改
	 * @param item 办公用品入库表
	 */
	public void update(AsSuppliesInfo item){
		asSuppliesInfoDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asSuppliesInfoDao.delByIds(ids);
	}
	public void updateAsSuppliesById(String shoppingId,String id){
		// 更新仓库数据信息
		// 先查询到本采购单的采购详情，再根据采购详情一一更新数据
		List<WorkShoppingDetails> list=workShoppingDetailsDao.listShoppingDetails(shoppingId);
		for (WorkShoppingDetails item : list) {
			asSuppliesDao.updateSuppliesNum2(item.getArticles(),item.getNum());
		}
		// 改变采购单入库状态
		workShoppingDao.updateStorage(shoppingId);
		// 添加入库信息
		AsSuppliesInfo info=new AsSuppliesInfo();
		info.setId(IdGen.uuid());// 主键id
		info.setCreateBy(UserUtils.getUser().getId());// 创建人id
		info.setShoppingId(shoppingId);
		info.setSerialNumber(id);
		asSuppliesInfoDao.add(info);
	};
}

