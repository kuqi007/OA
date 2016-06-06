package com.thinkgem.jeesite.modules.administr.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 固定资产表
 * 
 * @creator
 * @create-time 2016-04-12 14:20:21
 */
public class AsAssets implements Serializable{
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
	/** 资产名称 */
	private String name;
	/** 资产编号 */
	private String number;
	/** 资产型号 */
	private String model;
	/** 资产品牌 */
	private String brand;
	/** 价格 */
	private Double price;
	/** 数量 */
	private Integer count;
	/** 备注 */
	private String remarks;
	/** 所属部门id */
	private String departmentId;
	/** 购入时间 */
	private Date time;
	// 非持久层
	/**部门名字*/
	private String departmentName;

	public AsAssets() {
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
	/** 资产名称 */
	public String getName(){
		return this.name;
	}

	/** 资产名称 */
	public void setName(String name){
		this.name = name;
	}
	/** 资产编号 */
	public String getNumber(){
		return this.number;
	}

	/** 资产编号 */
	public void setNumber(String number){
		this.number = number;
	}
	/** 资产型号 */
	public String getModel(){
		return this.model;
	}

	/** 资产型号 */
	public void setModel(String model){
		this.model = model;
	}
	/** 资产品牌 */
	public String getBrand(){
		return this.brand;
	}

	/** 资产品牌 */
	public void setBrand(String brand){
		this.brand = brand;
	}
	/** 价格 */
	public Double getPrice(){
		return this.price;
	}

	/** 价格 */
	public void setPrice(Double price){
		this.price = price;
	}
	/** 数量 */
	public Integer getCount(){
		return this.count;
	}

	/** 数量 */
	public void setCount(Integer count){
		this.count = count;
	}
	/** 备注 */
	public String getRemarks(){
		return this.remarks;
	}

	/** 备注 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/** 所属部门id */
	public String getDepartmentId(){
		return this.departmentId;
	}

	/** 所属部门id */
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	/** 购入时间 */
	public Date getTime(){
		return this.time;
	}

	/** 购入时间 */
	public void setTime(Date time){
		this.time = time;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}