package com.thinkgem.jeesite.modules.administr.dto;

import java.io.Serializable;

public class AsAssetsCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 资产名称 */
	private String name;
	/** 资产编号 */
	private String number;
	/** 资产型号 */
	private String model;
	/** 资产品牌 */
	private String brand;
	/** 备注 */
	private String remarks;
	/** 所属部门id */
	private String departmentId;
	private String departmentName;

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
