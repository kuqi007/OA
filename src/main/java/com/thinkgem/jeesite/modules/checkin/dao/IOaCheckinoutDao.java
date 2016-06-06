package com.thinkgem.jeesite.modules.checkin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.thinkgem.jeesite.modules.checkin.entity.OaCheckinout;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckinoutCondition;

@MyBatisDao
public interface IOaCheckinoutDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	List<OaCheckinout> listOaCheckinoutByPage(RowBounds bounds,@Param("condition") OaCheckinoutCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listOaCheckinoutByPageCount(@Param("condition") OaCheckinoutCondition condition);

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 考勤登记表
	 */
	OaCheckinout getOaCheckinoutById(@Param("id") String id);

	/**
	 * 新增
	 * @param item 考勤登记表
	 */
	void add(OaCheckinout item);

	/**
	 * 修改
	 * @param item 考勤登记表
	 */
	void update(OaCheckinout item);

	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);
	
	/**
	 * 根据工号查询考勤记录
	 * @param userNo工号
	 * @return 考勤登记表
	 */
	List<OaCheckinout> getCheckRecordByUserNo(@Param("userNo")String userNo);

}

