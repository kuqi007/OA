package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkOvertimeCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkOvertime;

public class WorkOvertimeForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkOvertime item = new WorkOvertime();

	private WorkOvertimeCondition condition = new WorkOvertimeCondition();
	
	private Page<WorkOvertime> page=new Page<WorkOvertime>();
	private Integer state;
	
	public WorkOvertimeForm() {
		super();
	}

	public WorkOvertime getItem() {
		return item;
	}

	public void setItem(WorkOvertime item) {
		this.item = item;
	}

	public WorkOvertimeCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkOvertimeCondition condition) {
		this.condition = condition;
	}


	public Page<WorkOvertime> getPage() {
		return page;
	}

	public void setPage(Page<WorkOvertime> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
