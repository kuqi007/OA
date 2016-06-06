package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkApply;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyCondition;

public class WorkApplyForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkApply item = new WorkApply();

	private WorkApplyCondition condition = new WorkApplyCondition();

	private String products;// 用品集合
	
	private Page<WorkApply> page=new Page<WorkApply>();
	private Integer state;
	
	public WorkApplyForm() {
		super();
	}

	public WorkApply getItem() {
		return item;
	}

	public void setItem(WorkApply item) {
		this.item = item;
	}

	public WorkApplyCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkApplyCondition condition) {
		this.condition = condition;
	}

	public Page<WorkApply> getPage() {
		return page;
	}

	public void setPage(Page<WorkApply> page) {
		this.page = page;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
