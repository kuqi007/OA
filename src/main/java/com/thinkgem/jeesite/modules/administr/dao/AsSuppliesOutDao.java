package com.thinkgem.jeesite.modules.administr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesOutCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesOut;
import com.thinkgem.jeesite.modules.sys.entity.User;


/**
 * 办公用品出库记录
 * @create-time 2016/4/7 9:48:39
 */
@MyBatisDao
public interface AsSuppliesOutDao {

	/**
	 * 查询所有办公用品出库记录
	 */
	List<AsSuppliesOut> listAsSuppliesOutAll();

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsSuppliesOut> listAsSuppliesOutByPage(@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsSuppliesOutCondition condition);
	
	/**
	 * 根据权限查询出库流水
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<AsSuppliesOut> listAsSuppliesOutByPageClassfied(@Param("user")User user,@Param("pageNoBegin")int pageNoBegin,@Param("pageSize")int pageSize,@Param("condition") AsSuppliesOutCondition condition);

	/**
	 * 根据权限查询总数
	 * @param condition 查询条件类
	 * @return 根据权限查询到的总条数
	 */
	int listAsSuppliesOutByPageCountClassfied(@Param("user")User user,@Param("condition") AsSuppliesOutCondition condition);
	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listAsSuppliesOutByPageCount(@Param("condition") AsSuppliesOutCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 办公用品出库记录
	 */
	AsSuppliesOut getAsSuppliesOutById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 办公用品出库记录
	 */
	void add(AsSuppliesOut item);

	/**
	 * 修改
	 * @param item 办公用品出库记录
	 */
	void update(AsSuppliesOut item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	/**
	 * 签收出库单
	 * @param item 出库详情表
	 */
	void updateSign(@Param("id")String id,@Param("state")Integer state);
}