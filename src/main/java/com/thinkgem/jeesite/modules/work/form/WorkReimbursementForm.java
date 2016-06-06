package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkReimbursementCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkReimbursement;

public class WorkReimbursementForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkReimbursement item = new WorkReimbursement();

	private WorkReimbursementCondition condition = new WorkReimbursementCondition();
	
	private Page<WorkReimbursement> page=new Page<WorkReimbursement>();
	private Integer state;

	public WorkReimbursementForm() {
		super();
	}

	public WorkReimbursement getItem() {
		return item;
	}

	public void setItem(WorkReimbursement item) {
		this.item = item;
	}

	public WorkReimbursementCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkReimbursementCondition condition) {
		this.condition = condition;
	}

	public Page<WorkReimbursement> getPage() {
		return page;
	}

	public void setPage(Page<WorkReimbursement> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
