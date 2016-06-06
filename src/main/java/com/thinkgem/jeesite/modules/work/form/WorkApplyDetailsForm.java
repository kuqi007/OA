package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkApplyDetails;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkApplyDetailsCondition;

public class WorkApplyDetailsForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkApplyDetails item = new WorkApplyDetails();

	private WorkApplyDetailsCondition condition = new WorkApplyDetailsCondition();

	private Page<WorkApplyDetails> page=new Page<WorkApplyDetails>();
	
	public WorkApplyDetailsForm() {
		super();
	}

	public WorkApplyDetails getItem() {
		return item;
	}

	public void setItem(WorkApplyDetails item) {
		this.item = item;
	}

	public WorkApplyDetailsCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkApplyDetailsCondition condition) {
		this.condition = condition;
	}

	public Page<WorkApplyDetails> getPage() {
		return page;
	}

	public void setPage(Page<WorkApplyDetails> page) {
		this.page = page;
	}

}
