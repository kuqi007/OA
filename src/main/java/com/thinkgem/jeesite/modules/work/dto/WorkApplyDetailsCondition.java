package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;

public class WorkApplyDetailsCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 申请表id */
	private String applyid;
	/** 办公用品id */
	private String articles;

	/** 申请表id */
	public String getApplyid(){
		return this.applyid;
	}

	/** 申请表id */
	public void setApplyid(String applyid){
		this.applyid = applyid;
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
