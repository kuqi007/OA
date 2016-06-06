package com.thinkgem.jeesite.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.dto.ProductTypeCondition;
import com.thinkgem.jeesite.modules.sys.entity.ProductType;

@MyBatisDao
public interface ProductTypeDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<ProductType> listProductTypeByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") ProductTypeCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listProductTypeByPageCount(@Param("condition") ProductTypeCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品类型表
	 */
	ProductType getProductTypeById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 办公用品类型表
	 */
	void add(ProductType item);

	/**
	 * 修改
	 * @param item 办公用品类型表
	 */
	void update(ProductType item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 根据级别获取类型
	 */
	List<ProductType> listProductType(@Param("upper")String upper);
	/**
	 * 获取所有二级类别
	 */
	List<ProductType> listProductTypeTwo(@Param("upper")String upper);

}

