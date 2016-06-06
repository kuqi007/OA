package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * songJian 2016-3-21 审批情况显示
 * */
public class SignVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**处理步奏*/
	private Integer step;
	/**负责人*/
	private User user;
	/**请假单负责人签字信息*/
	private String sign;
	/**操作1-同意2-不同意*/
	private Integer operation;
	/**日期*/
	private Date dateTime;
	/**意見*/
	private String text;
	/**职位名称（在20160509，做积分撤销表时开始使用）*/
	private String signName;

	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getOperation() {
		return operation;
	}
	public void setOperation(Integer operation) {
		this.operation = operation;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	
}
