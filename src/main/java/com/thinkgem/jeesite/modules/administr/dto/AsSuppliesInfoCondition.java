package com.thinkgem.jeesite.modules.administr.dto;

import java.io.Serializable;

public class AsSuppliesInfoCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 删除标记0-未删除1-已删除 */
	private String delFlag;
	/** 办公用品id */
	private String articles;

	/** 删除标记0-未删除1-已删除 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/** 删除标记0-未删除1-已删除 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/** 办公用品id */
	public String getArticles(){
		return this.articles;
	}

	/** 办公用品id */
	public void setArticles(String articles){
		this.articles = articles;
	}
}
