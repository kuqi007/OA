package com.thinkgem.jeesite.modules.checkin.entity;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 考勤登记表
 * 
 * @creator
 * @create-time 2016-05-13 15:06:47
 */
public class OaCheckinout extends DataEntity<OaCheckinout>{
	/**  */
	private static final long serialVersionUID = 1L;

	/** 工号 */
	private String userNo;
	/** 用户id */
	private String userName;
	/** 用户对象 */
	private User user;
	/** 登记时间 */
	private Date checkTime;
	/** 验证方式 */
	private String verifycode;
	/** 更新时间 */
	private Date updateTime;

	public OaCheckinout() {
		super();
	}

	/** 工号 */
	public String getUserNo(){
		return this.userNo;
	}

	/** 工号 */
	public void setUserNo(String userNo){
		this.userNo = userNo;
	}
	/** 用户id */
	public String getUserName(){
		return this.userName;
	}

	/** 用户id */
	public void setUserName(String userName){
		this.userName = userName;
	}
	/** 用户对象 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/** 登记时间 */
	public Date getCheckTime(){
		return this.checkTime;
	}

	/** 登记时间 */
	public void setCheckTime(Date checktime){
		this.checkTime = checktime;
	}
	/** 验证方式 */
	public String getVerifycode(){
		return this.verifycode;
	}

	/** 验证方式 */
	public void setVerifycode(String verifycode){
		this.verifycode = verifycode;
	}
	/** 更新时间 */
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/** 更新时间 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
}