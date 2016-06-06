package com.thinkgem.jeesite.modules.work.form;


import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkLeaveCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkLeave;

public class WorkLeaveForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkLeave item = new WorkLeave();

	private WorkLeaveCondition condition = new WorkLeaveCondition();
	
	private Page<WorkLeave> page=new Page<WorkLeave>();
	
	private Integer state;
	
	public WorkLeaveForm() {
		super();
	}

	public WorkLeave getItem() {
		return item;
	}

	public void setItem(WorkLeave item) {
		this.item = item;
	}

	public WorkLeaveCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkLeaveCondition condition) {
		this.condition = condition;
	}

	public Page<WorkLeave> getPage() {
		return page;
	}

	public void setPage(Page<WorkLeave> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}



}
