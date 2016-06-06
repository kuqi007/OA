package com.thinkgem.jeesite.modules.administr.form;

import com.thinkgem.jeesite.modules.administr.entity.AsOutDetails;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsOutDetailsCondition;

public class AsOutDetailsForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsOutDetails item = new AsOutDetails();

	private AsOutDetailsCondition condition = new AsOutDetailsCondition();

	private Page<AsOutDetails> page=new Page<AsOutDetails>();
	
	public AsOutDetailsForm() {
		super();
	}

	public AsOutDetails getItem() {
		return item;
	}

	public void setItem(AsOutDetails item) {
		this.item = item;
	}

	public AsOutDetailsCondition getCondition() {
		return condition;
	}

	public void setCondition(AsOutDetailsCondition condition) {
		this.condition = condition;
	}

	public Page<AsOutDetails> getPage() {
		return page;
	}

	public void setPage(Page<AsOutDetails> page) {
		this.page = page;
	}

}
