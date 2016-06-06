package com.thinkgem.jeesite.modules.administr.form;

import com.thinkgem.jeesite.modules.administr.entity.AsCroom;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomCondition;

public class AsCroomForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsCroom item = new AsCroom();

	private AsCroomCondition condition = new AsCroomCondition();

	private Page<AsCroom> page=new Page<AsCroom>();
	
	public AsCroomForm() {
		super();
	}

	public AsCroom getItem() {
		return item;
	}

	public void setItem(AsCroom item) {
		this.item = item;
	}

	public AsCroomCondition getCondition() {
		return condition;
	}

	public void setCondition(AsCroomCondition condition) {
		this.condition = condition;
	}

	public Page<AsCroom> getPage() {
		return page;
	}

	public void setPage(Page<AsCroom> page) {
		this.page = page;
	}


}
