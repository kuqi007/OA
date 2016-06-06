package com.thinkgem.jeesite.modules.checkin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.modules.checkin.entity.OaCheckreal;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckrealCondition;

@MyBatisDao
public interface IOaCheckrealDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<OaCheckreal> listOaCheckrealByPage(RowBounds bounds,@Param("condition") OaCheckrealCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listOaCheckrealByPageCount(@Param("condition") OaCheckrealCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 上下班签到签退表
	 */
	OaCheckreal getOaCheckrealById(@Param("id") Long id);

	/**
	 * 新增
	 * @param item 上下班签到签退表
	 */
	void add(OaCheckreal item);

	/**
	 * 修改
	 * @param item 上下班签到签退表
	 */
	void update(OaCheckreal item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(Long[] ids);

}

