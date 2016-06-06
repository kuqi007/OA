package com.thinkgem.jeesite.modules.checkin.dto;

import java.util.Date;

import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;

public class OaCheckrealCondition {

	/** 工号 */
	private String userNo;
	/** 用户部门对象 */
	private Office office;
	/** 用户对象 */
	private User user;
	/** 日期*/
	private Date date;
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
	
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
