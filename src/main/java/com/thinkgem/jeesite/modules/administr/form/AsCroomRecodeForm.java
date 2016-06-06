package com.thinkgem.jeesite.modules.administr.form;

import com.thinkgem.jeesite.modules.administr.entity.AsCroomRecode;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsCroomRecodeCondition;

public class AsCroomRecodeForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsCroomRecode item = new AsCroomRecode();

	private AsCroomRecodeCondition condition = new AsCroomRecodeCondition();
	
	private Page<AsCroomRecode> page=new Page<AsCroomRecode>();

	public AsCroomRecodeForm() {
		super();
	}

	public AsCroomRecode getItem() {
		return item;
	}

	public void setItem(AsCroomRecode item) {
		this.item = item;
	}

	public AsCroomRecodeCondition getCondition() {
		return condition;
	}

	public void setCondition(AsCroomRecodeCondition condition) {
		this.condition = condition;
	}

	public Page<AsCroomRecode> getPage() {
		return page;
	}

	public void setPage(Page<AsCroomRecode> page) {
		this.page = page;
	}

}
