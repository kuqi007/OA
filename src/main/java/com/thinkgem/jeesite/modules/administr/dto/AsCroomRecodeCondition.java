package com.thinkgem.jeesite.modules.administr.dto;

import java.io.Serializable;

public class AsCroomRecodeCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 申请人id */
	private String peopleId;
	/** 使用原因 */
	private String reason;
	/** 申请状态0-审核1-同意2-不同意3-同意和不同意 */
	private Integer state;

	/** 申请人id */
	public String getPeopleId(){
		return this.peopleId;
	}

	/** 申请人id */
	public void setPeopleId(String peopleId){
		this.peopleId = peopleId;
	}
	/** 使用原因 */
	public String getReason(){
		return this.reason;
	}

	/** 使用原因 */
	public void setReason(String reason){
		this.reason = reason;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
