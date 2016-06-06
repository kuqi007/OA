package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;

public class WorkDjustDetailsCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** e得货号 */
	private String ehavingid;
	/** 商品品牌 */
	private String brand;
	/** 供应商 */
	private String supplier;
	/** 商品名称 */
	private String name;
	/** 规格/型号 */
	private String specifications;
	/** 申请原因 */
	private String reason;
	/** 价格调整表id */
	private String djustid;

	/** e得货号 */
	public String getEhavingid(){
		return this.ehavingid;
	}

	/** e得货号 */
	public void setEhavingid(String ehavingid){
		this.ehavingid = ehavingid;
	}
	/** 商品品牌 */
	public String getBrand(){
		return this.brand;
	}

	/** 商品品牌 */
	public void setBrand(String brand){
		this.brand = brand;
	}
	/** 供应商 */
	public String getSupplier(){
		return this.supplier;
	}

	/** 供应商 */
	public void setSupplier(String supplier){
		this.supplier = supplier;
	}
	/** 商品名称 */
	public String getName(){
		return this.name;
	}

	/** 商品名称 */
	public void setName(String name){
		this.name = name;
	}
	/** 规格/型号 */
	public String getSpecifications(){
		return this.specifications;
	}

	/** 规格/型号 */
	public void setSpecifications(String specifications){
		this.specifications = specifications;
	}
	/** 申请原因 */
	public String getReason(){
		return this.reason;
	}

	/** 申请原因 */
	public void setReason(String reason){
		this.reason = reason;
	}
	/** 价格调整表id */
	public String getDjustid(){
		return this.djustid;
	}

	/** 价格调整表id */
	public void setDjustid(String djustid){
		this.djustid = djustid;
	}
}
