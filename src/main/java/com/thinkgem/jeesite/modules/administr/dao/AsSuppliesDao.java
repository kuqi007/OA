package com.thinkgem.jeesite.modules.administr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;

@MyBatisDao
public interface AsSuppliesDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsSupplies> listAsSuppliesByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsSuppliesCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsSuppliesByPageCount(@Param("condition") AsSuppliesCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品表
	 */
	AsSupplies getAsSuppliesById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 办公用品表
	 */
	void add(AsSupplies item);

	/**
	 * 修改
	 * @param item 办公用品表
	 */
	void update(AsSupplies item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 查询所有用品
	 * 
	 * */
	public List<AsSupplies> listAsSupplies();
	/**
	 * 减去相应出库的商品库存数量
	 * 
	 * */
	void updateSuppliesNum(@Param("id")String id,@Param("num")Integer num);
	/**
	 * 增加相应出库的商品库存数量
	 * 
	 * */
	void updateSuppliesNum2(@Param("id")String id,@Param("num")Integer num);
	
	
	/**
	 * 查询商品剩余库存
	 * 
	 * */
	Integer getNum(@Param("id")String id);
	/**
	 * 查询某类别的商品
	 * 
	 * */
	List<AsSupplies> listAsSuppliesByType(String id);
}

