package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkTravelCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkTravel;

public class WorkTravelForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkTravel item = new WorkTravel();

	private WorkTravelCondition condition = new WorkTravelCondition();

	private Page<WorkTravel> page=new Page<WorkTravel>();
	private Integer state;
	
	private String type;
	
	public WorkTravelForm() {
		super();
	}

	public WorkTravel getItem() {
		return item;
	}

	public void setItem(WorkTravel item) {
		this.item = item;
	}

	public WorkTravelCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkTravelCondition condition) {
		this.condition = condition;
	}

	public Page<WorkTravel> getPage() {
		return page;
	}

	public void setPage(Page<WorkTravel> page) {
		this.page = page;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
