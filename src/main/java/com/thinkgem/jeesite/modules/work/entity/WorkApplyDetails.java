package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @creator
 * @create-time 2016-04-28 14:34:15
 */
public class WorkApplyDetails  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 删除标记0-未删除1-已删除 */
	private Integer delFlag;
	/** 申请表id */
	private String applyid;
	/** 办公用品id */
	private String articles;
	/** 数量 */
	private Integer num;
	//非持久化层
	private String articlesName;
	private String company;

	public WorkApplyDetails() {
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}