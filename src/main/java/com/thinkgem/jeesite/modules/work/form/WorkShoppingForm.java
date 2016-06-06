package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShopping;

public class WorkShoppingForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkShopping item = new WorkShopping();

	private WorkShoppingCondition condition = new WorkShoppingCondition();

	private String products;// 用品集合
	
	private Page<WorkShopping> page=new Page<WorkShopping>();
	private Integer state;
	
	public WorkShoppingForm() {
		super();
	}

	public WorkShopping getItem() {
		return item;
	}

	public void setItem(WorkShopping item) {
		this.item = item;
	}

	public WorkShoppingCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkShoppingCondition condition) {
		this.condition = condition;
	}

	public Page<WorkShopping> getPage() {
		return page;
	}

	public void setPage(Page<WorkShopping> page) {
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
