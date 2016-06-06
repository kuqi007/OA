package com.thinkgem.jeesite.modules.administr.dto;

import java.io.Serializable;

public class AsSuppliesOutCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 删除标记0-未删除1-已删除 */
	private String delFlag;
	/** 申领人id */
	private String peopleId;
	/** 办公用品id */
	private String articles;
	/** 申领原因 */
	private String reason;
	/**签收标记0-未签收1-已签收*/
	private Integer state;
	/** 删除标记0-未删除1-已删除 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/** 删除标记0-未删除1-已删除 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/** 申领人id */
	public String getPeopleId(){
		return this.peopleId;
	}

	/** 申领人id */
	public void setPeopleId(String peopleId){
		this.peopleId = peopleId;
	}
	/** 办公用品id */
	public String getArticles(){
		return this.articles;
	}

	/** 办公用品id */
	public void setArticles(String articles){
		this.articles = articles;
	}
	/** 申领原因 */
	public String getReason(){
		return this.reason;
	}

	/** 申领原因 */
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
