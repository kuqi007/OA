package com.thinkgem.jeesite.modules.administr.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 办公用品入库表
 * 
 * @creator
 * @create-time 2016-04-08 13:57:31
 */
public class AsSuppliesInfo implements Serializable{
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
	/** 出库时间 */
	private Date time;
	/** 办公用品id */
	private String articles;
	/** 数量 */
	private Integer num;
	/**采购单id*/
	private String shoppingId;
	/**采购单流水号*/
	private String serialNumber;
	// 非持久层
	/**物品名*/
	private String articlesName;
	/**类型名*/
	private String typeName;
	
	public AsSuppliesInfo() {
		super();
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	/** 出库时间 */
	public Date getTime(){
		return this.time;
	}

	/** 出库时间 */
	public void setTime(Date time){
		this.time = time;
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(String shoppingId) {
		this.shoppingId = shoppingId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}