package com.thinkgem.jeesite.modules.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dao.ProductTypeDao;
import com.thinkgem.jeesite.modules.sys.dto.ProductTypeCondition;
import com.thinkgem.jeesite.modules.sys.entity.ProductType;
import com.thinkgem.jeesite.modules.sys.service.ProductTypeService;


@Service("productTypeServiceImpl")
@Transactional(value = "transactionManager")
public class ProductTypeServiceImpl implements ProductTypeService{

	@Resource
	private ProductTypeDao productTypeDao;

	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	public void listProductTypeByPage(Page<ProductType> page,ProductTypeCondition condition){
		int rows = productTypeDao.listProductTypeByPageCount(condition);
		page.setCount(rows);// 总条数
		page.setPageSize(Integer.valueOf(Global.getConfig("page.pageSize")));// 获取配置的分页信息
		List<ProductType> list = productTypeDao.listProductTypeByPage((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),condition);
		page.setList(list);// 显示数据
		page.initialize();// 初始化page参数
	}

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品类型表
	 */
	public ProductType getProductTypeById(String id){
		return productTypeDao.getProductTypeById(id);
	}

	/**
	 * 新增
	 * @param item 办公用品类型表
	 */
	public void add(ProductType item){
		productTypeDao.add(item);
	}

	/**
	 * 修改
	 * @param item 办公用品类型表
	 */
	public void update(ProductType item){
		productTypeDao.update(item);
	}

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	public void delByIds(String[] ids){
		productTypeDao.delByIds(ids);
	}
	/**
	 * 根据级别获取类型
	 * 当upper=3时，查询所有二级类别
	 * 当upper！=3时，根据upper查询类别
	 * 
	 */
	public List<ProductType> listProductType(String upper){
		if (upper.equals("3")) {
			return productTypeDao.listProductTypeTwo(upper);
		}else{
			return productTypeDao.listProductType(upper);
		}
	};
}

