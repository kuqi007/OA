package com.thinkgem.jeesite.modules.administr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.administr.dao.AsOutDetailsDao;
import com.thinkgem.jeesite.modules.administr.dao.AsSuppliesDao;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;
import com.thinkgem.jeesite.modules.administr.service.AsSuppliesService;
import com.thinkgem.jeesite.modules.sys.dao.ProductTypeDao;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

@Service("asSuppliesServiceImpl")
@Transactional(value = "transactionManager")
public class AsSuppliesServiceImpl implements AsSuppliesService{

	@Resource
	private AsSuppliesDao asSuppliesDao;
	@Resource
	private ProductTypeDao productTypeDao;
	@Resource
	private AsOutDetailsDao asOutDetailsDao;
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listAsSuppliesByPage(Page<AsSupplies> page,AsSuppliesCondition condition){
		int rows = asSuppliesDao.listAsSuppliesByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<AsSupplies> list = asSuppliesDao.listAsSuppliesByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		List<AsSupplies> list2=new ArrayList<AsSupplies>();
		for (AsSupplies asSupplies : list) {
			AsSupplies test=asSupplies;
			test.setTypeName(productTypeDao.getProductTypeById(test.getType()).getName());
			list2.add(test);
		}
		page.setList(list2);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品表
	 */
	public AsSupplies getAsSuppliesById(String id){
		return asSuppliesDao.getAsSuppliesById(id);
	}

	/**
	 * 新增
	 * @param item 办公用品表
	 */
	public void add(AsSupplies item){
		asSuppliesDao.add(item);
	}

	/**
	 * 修改
	 * @param item 办公用品表
	 */
	public void update(AsSupplies item){
		asSuppliesDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		asSuppliesDao.delByIds(ids);
	}
	/**查询所有用品*/
	public List<AsSupplies> listAsSupplies(){
		return asSuppliesDao.listAsSupplies();
	}

	@Override
	public void updateSuppliesNum(String []mode,String itemId) {
		User user=UserUtils.getUser();// 获取当前用户
		for (int i = 0; i < mode.length; i++) {
			AsOutDetails asOutDetails=new AsOutDetails();
			asOutDetails.setId(IdGen.uuid());// 主键id
			asOutDetails.setCreateBy(user.getId());// 创建人id
			asOutDetails.setSuppliesid(itemId);
			String [] productde=mode[i].split("-");
			String pid=productde[0];// 用品id
			Integer num=Integer.parseInt(productde[1]);// 数量
			// 从库存中减去相应用品数量
			// 先检查数据的有效性
			Integer nums=asSuppliesDao.getNum(pid);
			if (num<=nums) {
				// 减去相应数量
				asSuppliesDao.updateSuppliesNum(pid,num);
			}else{
				throw new RuntimeException("抛出个运行时异常,添加商品出库信息时商品数量可能不足。");
			}
			// 添加到出库单详情
			asOutDetails.setArticles(pid);
			asOutDetails.setNum(num);
			asOutDetailsDao.add(asOutDetails);
		}
	};
	
	@Override
	public void updateSuppliesNum2(String id, Integer num) {
			asSuppliesDao.updateSuppliesNum2(id,num);
	};
	/**
	 * 查询某类别的商品
	 * 
	 * */
	public List<AsSupplies> listAsSuppliesByType(String id){
		return asSuppliesDao.listAsSuppliesByType(id);
	};
}

