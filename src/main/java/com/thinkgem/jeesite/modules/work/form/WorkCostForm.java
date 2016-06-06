package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkCost;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkCostCondition;

public class WorkCostForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkCost item = new WorkCost();

	private WorkCostCondition condition = new WorkCostCondition();

	private Page<WorkCost> page=new Page<WorkCost>();
	private Integer state;
	
	public WorkCostForm() {
		super();
	}

	public WorkCost getItem() {
		return item;
	}

	public void setItem(WorkCost item) {
		this.item = item;
	}

	public WorkCostCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkCostCondition condition) {
		this.condition = condition;
	}

	public Page<WorkCost> getPage() {
		return page;
	}

	public void setPage(Page<WorkCost> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
