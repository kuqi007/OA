package com.thinkgem.jeesite.modules.administr.dto;

import java.io.Serializable;

public class AsSuppliesCondition  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 商品名字 */
	private String name;
	/** 用品类型id */
	private String type;
	/** 计量单位 */
	private String company;

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
	/** 计量单位 */
	public String getCompany(){
		return this.company;
	}

	/** 计量单位 */
	public void setCompany(String company){
		this.company = company;
	}
}
