package com.thinkgem.jeesite.modules.sys.dto;


public class ProductTypeCondition {

	/** 类型名字 */
	private String name;
	/** 上级id */
	private String upper;

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
}
