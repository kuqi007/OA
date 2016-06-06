package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 采购详情表
 * 
 * @creator
 * @create-time 2016-04-14 16:26:25
 */
public class WorkShoppingDetails implements Serializable{
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
	/** 采购表id */
	private String suppliesid;
	/** 办公用品id */
	private String articles;
	/** 数量 */
	private Integer num;
	/**自定义价格*/
	private Double price;
	// 非持久层
	/**办公用品名字*/
	private String articlesName;
	private String company;
	
	public WorkShoppingDetails() {
		super();
	}

	/** 删除标记0-未删除1-已删除 */
	public Integer getDelFlag(){
		return this.delFlag;
	}

	/** 删除标记0-未删除1-已删除 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}