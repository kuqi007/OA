package com.thinkgem.jeesite.modules.administr.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesOutCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;
import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesOut;

public class AsSuppliesOutForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsSuppliesOut item = new AsSuppliesOut();

	private AsSuppliesOutCondition condition = new AsSuppliesOutCondition();
	
	private AsOutDetails OutDetail = new AsOutDetails();// 出库详情
	
	private String products;// 用品集合

	private Page<AsSuppliesOut> page=new Page<AsSuppliesOut>();
	
	private String urlFlag;
	
	public AsSuppliesOutForm() {
		super();
	}

	public AsSuppliesOut getItem() {
		return item;
	}

	public void setItem(AsSuppliesOut item) {
		this.item = item;
	}

	public AsSuppliesOutCondition getCondition() {
		return condition;
	}

	public void setCondition(AsSuppliesOutCondition condition) {
		this.condition = condition;
	}

	public Page<AsSuppliesOut> getPage() {
		return page;
	}

	public void setPage(Page<AsSuppliesOut> page) {
		this.page = page;
	}

	public AsOutDetails getOutDetail() {
		return OutDetail;
	}

	public void setOutDetail(AsOutDetails outDetail) {
		OutDetail = outDetail;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getUrlFlag() {
		return urlFlag;
	}

	public void setUrlFlag(String urlFlag) {
		this.urlFlag = urlFlag;
	}




}
