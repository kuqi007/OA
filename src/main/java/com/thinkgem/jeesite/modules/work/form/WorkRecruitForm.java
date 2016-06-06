package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkRecruitCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkRecruit;

public class WorkRecruitForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkRecruit item = new WorkRecruit();

	private WorkRecruitCondition condition = new WorkRecruitCondition();

	private Page<WorkRecruit> page=new Page<WorkRecruit>();
	private Integer state;
	
	public WorkRecruitForm() {
		super();
	}

	public WorkRecruit getItem() {
		return item;
	}

	public void setItem(WorkRecruit item) {
		this.item = item;
	}

	public WorkRecruitCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkRecruitCondition condition) {
		this.condition = condition;
	}



	public Page<WorkRecruit> getPage() {
		return page;
	}

	public void setPage(Page<WorkRecruit> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}



}
