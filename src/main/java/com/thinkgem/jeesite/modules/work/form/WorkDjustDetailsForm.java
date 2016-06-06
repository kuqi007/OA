package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkDjustDetails;

import java.io.Serializable;

import com.thinkgem.jeesite.modules.work.dto.WorkDjustDetailsCondition;

public class WorkDjustDetailsForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WorkDjustDetails item = new WorkDjustDetails();

	private WorkDjustDetailsCondition condition = new WorkDjustDetailsCondition();

	public WorkDjustDetailsForm() {
		super();
	}

	public WorkDjustDetails getItem() {
		return item;
	}

	public void setItem(WorkDjustDetails item) {
		this.item = item;
	}

	public WorkDjustDetailsCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkDjustDetailsCondition condition) {
		this.condition = condition;
	}

}
