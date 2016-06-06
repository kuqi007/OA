package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkLoan;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkLoanCondition;

public class WorkLoanForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkLoan item = new WorkLoan();

	private WorkLoanCondition condition = new WorkLoanCondition();
	
	private Page<WorkLoan> page=new Page<WorkLoan>();
	private Integer state;

	public WorkLoanForm() {
		super();
	}

	public WorkLoan getItem() {
		return item;
	}

	public void setItem(WorkLoan item) {
		this.item = item;
	}

	public WorkLoanCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkLoanCondition condition) {
		this.condition = condition;
	}

	public Page<WorkLoan> getPage() {
		return page;
	}

	public void setPage(Page<WorkLoan> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
