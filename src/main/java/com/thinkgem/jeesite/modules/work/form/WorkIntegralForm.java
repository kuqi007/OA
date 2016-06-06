package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkIntegral;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkIntegralCondition;

public class WorkIntegralForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkIntegral item = new WorkIntegral();

	private WorkIntegralCondition condition = new WorkIntegralCondition();
	
	private Integer state;
	// 2-部门主管写的3-部门领导写的4-分管领导写的5-人力行政写的
	private Integer flowType;
	
	private Page<WorkIntegral> page=new Page<WorkIntegral>();

	public WorkIntegralForm() {
		super();
	}

	public WorkIntegral getItem() {
		return item;
	}

	public void setItem(WorkIntegral item) {
		this.item = item;
	}

	public WorkIntegralCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkIntegralCondition condition) {
		this.condition = condition;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getFlowType() {
		return flowType;
	}

	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}

	public Page<WorkIntegral> getPage() {
		return page;
	}

	public void setPage(Page<WorkIntegral> page) {
		this.page = page;
	}


}
