package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkRestCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRest;

public class WorkRestForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkRest item = new WorkRest();

	private WorkRestCondition condition = new WorkRestCondition();
	
	private Page<WorkRest> page=new Page<WorkRest>();
	private Integer state;

	public WorkRestForm() {
		super();
	}

	public WorkRest getItem() {
		return item;
	}

	public void setItem(WorkRest item) {
		this.item = item;
	}

	public WorkRestCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkRestCondition condition) {
		this.condition = condition;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Page<WorkRest> getPage() {
		return page;
	}

	public void setPage(Page<WorkRest> page) {
		this.page = page;
	}

}
