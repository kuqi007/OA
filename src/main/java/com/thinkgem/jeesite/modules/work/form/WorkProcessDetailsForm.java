package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.modules.work.dto.WorkProcessDetailsCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkProcessDetails;

public class WorkProcessDetailsForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorkProcessDetails item = new WorkProcessDetails();

	private WorkProcessDetailsCondition condition = new WorkProcessDetailsCondition();

	public WorkProcessDetailsForm() {
		super();
	}

	public WorkProcessDetails getItem() {
		return item;
	}

	public void setItem(WorkProcessDetails item) {
		this.item = item;
	}

	public WorkProcessDetailsCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkProcessDetailsCondition condition) {
		this.condition = condition;
	}

}
