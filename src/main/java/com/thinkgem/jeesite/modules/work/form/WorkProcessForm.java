package com.thinkgem.jeesite.modules.work.form;

import com.thinkgem.jeesite.modules.work.entity.WorkPayment;
import com.thinkgem.jeesite.modules.work.entity.WorkProcess;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkProcessCondition;

public class WorkProcessForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkProcess item = new WorkProcess();

	private WorkProcessCondition condition = new WorkProcessCondition();
	
	
	private Page<WorkPayment> page=new Page<WorkPayment>();


	public WorkProcessForm() {
		super();
	}

	public WorkProcess getItem() {
		return item;
	}

	public void setItem(WorkProcess item) {
		this.item = item;
	}

	public WorkProcessCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkProcessCondition condition) {
		this.condition = condition;
	}

	public Page<WorkPayment> getPage() {
		return page;
	}

	public void setPage(Page<WorkPayment> page) {
		this.page = page;
	}

}
