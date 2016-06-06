package com.thinkgem.jeesite.modules.administr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 出库详情表
 * 
 * @creator
 * @create-time 2016-04-07 16:06:10
 */
public class AsOutDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  */
	private String id;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 删除标记0-未删除1-已删除 */
	private Integer delFlag;
	/** 出库表id */
	private String suppliesid;
	/** 办公用品id */
	private String articles;
	/** 数量 */
	private Integer num;
	// 非持久层
	/**办公用品名字*/
	private String articlesName;
	
	public AsOutDetails() {
		super();
	}

	
	public Integer getDelFlag() {
		return delFlag;
	}


	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}


	/** 出库表id */
	public String getSuppliesid(){
		return this.suppliesid;
	}

	/** 出库表id */
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
	/** 数量 */
	public Integer getNum(){
		return this.num;
	}

	/** 数量 */
	public void setNum(Integer num){
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getArticlesName() {
		return articlesName;
	}

	public void setArticlesName(String articlesName) {
		this.articlesName = articlesName;
	}
	
}