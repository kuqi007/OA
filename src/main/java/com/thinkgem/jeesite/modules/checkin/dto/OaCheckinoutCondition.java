package com.thinkgem.jeesite.modules.checkin.dto;

import java.util.Date;

import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;

public class OaCheckinoutCondition {

	/** 工号 */
	private String userNo;
	/** 用户姓名 */
	private String userName;
	/** 用户id */
	private String userId;
	/** 用户部门 */
	private String office1;
	/** 用户部门对象 */
	private Office office;
	/** 用户对象 */
	private User user;
	/** 登记时间*/
	private Date checkTime;
	/** 验证方式 */
	private String verifycode;
	/**更新时间*/
	private Date updateTime;
	/**开始日期*/
	private Date beginDate;
	/**结束日期*/
	private Date endDate;

	/** 工号 */
	public String getUserNo(){
		return this.userNo;
	}

	/** 工号 */
	public void setUserNo(String userNo){
		this.userNo = userNo;
	}
	/** 用户姓名 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** 用户id */
	public String getUserId(){
		return this.userId;
	}

	/** 用户id */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/** 登记时间*/
	public Date getCheckTime() {
		return checkTime;
	}
	/** 用户部门 */
	public String getOffice1() {
		return office1;
	}

	public void setOffice1(String office) {
		this.office1 = office;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	
	/** 更新时间*/
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/** 验证方式 */
	public String getVerifycode(){
		return this.verifycode;
	}

	/** 验证方式 */
	public void setVerifycode(String verifycode){
		this.verifycode = verifycode;
	}
	/**开始日期*/
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	/**结束日期*/
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**用户对象*/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/** 用户部门对象 */
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
}
