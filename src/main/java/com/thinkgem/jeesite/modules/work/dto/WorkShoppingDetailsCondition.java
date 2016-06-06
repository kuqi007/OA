package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;

public class WorkShoppingDetailsCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 采购表id */
	private String suppliesid;
	/** 办公用品id */
	private String articles;
	/**编号*/
	private String transaction;

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	/** 采购表id */
	public String getSuppliesid(){
		return this.suppliesid;
	}

	/** 采购表id */
	public void setSuppliesid(String suppliesid){
		this.suppliesid = suppliesid;
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
