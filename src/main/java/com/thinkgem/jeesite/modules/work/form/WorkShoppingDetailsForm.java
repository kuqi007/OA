package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkShoppingDetailsCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkShoppingDetails;

public class WorkShoppingDetailsForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkShoppingDetails item = new WorkShoppingDetails();

	private WorkShoppingDetailsCondition condition = new WorkShoppingDetailsCondition();

	private Page<WorkShoppingDetails> page=new Page<WorkShoppingDetails>();
	
	public WorkShoppingDetailsForm() {
		super();
	}

	public WorkShoppingDetails getItem() {
		return item;
	}

	public void setItem(WorkShoppingDetails item) {
		this.item = item;
	}

	public WorkShoppingDetailsCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkShoppingDetailsCondition condition) {
		this.condition = condition;
	}

	public Page<WorkShoppingDetails> getPage() {
		return page;
	}

	public void setPage(Page<WorkShoppingDetails> page) {
		this.page = page;
	}

}
