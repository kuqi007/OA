package com.thinkgem.jeesite.modules.sys.entity;

import java.util.Date;

/**
 * 办公用品类型表
 * 
 * @creator
 * @create-time 2016-03-22 15:02:21
 */
public class ProductType {
	/**  */
	private String id;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 删除标0-未删除，1-已删除 */
	private Integer delFlag;
	/** 类型名字 */
	private String name;
	/** 上级id */
	private String upper;
	//非持久化层
	/**部门名字*/
	private String departmentName;

	public ProductType() {
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
	/** 类型名字 */
	public String getName(){
		return this.name;
	}

	/** 类型名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 上级id */
	public String getUpper(){
		return this.upper;
	}

	/** 上级id */
	public void setUpper(String upper){
		this.upper = upper;
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