package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkOutCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOut;

public class WorkOutForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkOut item = new WorkOut();

	private WorkOutCondition condition = new WorkOutCondition();
	
	private Page<WorkOut> page=new Page<WorkOut>();
	private Integer state;
	
	public WorkOutForm() {
		super();
	}

	public WorkOut getItem() {
		return item;
	}

	public void setItem(WorkOut item) {
		this.item = item;
	}

	public WorkOutCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkOutCondition condition) {
		this.condition = condition;
	}


	public Page<WorkOut> getPage() {
		return page;
	}

	public void setPage(Page<WorkOut> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


}
