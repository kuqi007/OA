package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkDjust;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkDjustCondition;

public class WorkDjustForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkDjust item = new WorkDjust();

	private WorkDjustCondition condition = new WorkDjustCondition();
	
	private String products;
	
	private Page<WorkDjust> page=new Page<WorkDjust>();
	private Integer state;
	
	public WorkDjustForm() {
		super();
	}

	public WorkDjust getItem() {
		return item;
	}

	public void setItem(WorkDjust item) {
		this.item = item;
	}

	public WorkDjustCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkDjustCondition condition) {
		this.condition = condition;
	}

	public Page<WorkDjust> getPage() {
		return page;
	}

	public void setPage(Page<WorkDjust> page) {
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
