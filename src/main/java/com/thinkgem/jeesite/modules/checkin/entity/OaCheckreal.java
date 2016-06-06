package com.thinkgem.jeesite.modules.checkin.entity;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 上下班签到签退表
 * 
 * @creator
 * @create-time 2016-05-25 14:28:44
 */
public class OaCheckreal extends DataEntity<OaCheckreal>{
	/**  */
	private static final long serialVersionUID = 1L;
	/** 用户对象 */
	private User user;
	/** 日期 */
	private Date date;
	/** 上班签到 */
	private Date signIn;
	/** 下班签退 */
	private Date signOut;
	/** 工号 */
	private String userNo;
	/** 是否周末*/
	private boolean weekend;

	public OaCheckreal() {
		super();
	}

	/** 日期 */
	public Date getDate(){
		return this.date;
	}

	/** 日期 */
	public void setDate(Date date){
		this.date = date;
	}
	/** 上班签到 */
	public Date getSignIn(){
		return this.signIn;
	}

	/** 上班签到 */
	public void setSignIn(Date signIn){
		this.signIn = signIn;
	}
	/** 下班签退 */
	public Date getSignOut(){
		return this.signOut;
	}

	/** 下班签退 */
	public void setSignOut(Date signOut){
		this.signOut = signOut;
	}
	/** 工号 */
	public String getUserNo(){
		return this.userNo;
	}

	/** 工号 */
	public void setUserNo(String userNo){
		this.userNo = userNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}





}