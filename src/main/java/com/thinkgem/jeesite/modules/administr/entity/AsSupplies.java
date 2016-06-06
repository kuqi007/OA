package com.thinkgem.jeesite.modules.administr.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 办公用品表
 * 
 * @creator
 * @create-time 2016-04-07 10:54:25
 */
public class AsSupplies implements Serializable{
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
	/** 删除标0-未删除，1-已删除 */
	private Integer delFlag;
	/** 商品名字 */
	private String name;
	/** 用品类型id */
	private String type;
	/** 价格 */
	private Double price;
	/** 计量单位 */
	private String company;
	/** 数量 */
	private Integer num;
	// 非持久化层
	/**商品类型名字*/
	private String typeName;
	public AsSupplies() {
		super();
	}

	/** 删除标0-未删除，1-已删除 */
	public Integer getDelFlag(){
		return this.delFlag;
	}

	/** 删除标0-未删除，1-已删除 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/** 商品名字 */
	public String getName(){
		return this.name;
	}

	/** 商品名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 用品类型id */
	public String getType(){
		return this.type;
	}

	/** 用品类型id */
	public void setType(String type){
		this.type = type;
	}
	/** 价格 */
	public Double getPrice(){
		return this.price;
	}

	/** 价格 */
	public void setPrice(Double price){
		this.price = price;
	}
	/** 计量单位 */
	public String getCompany(){
		return this.company;
	}

	/** 计量单位 */
	public void setCompany(String company){
		this.company = company;
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}