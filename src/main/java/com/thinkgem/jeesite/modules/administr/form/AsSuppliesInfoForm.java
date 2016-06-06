package com.thinkgem.jeesite.modules.administr.form;

import com.thinkgem.jeesite.modules.administr.entity.AsSuppliesInfo;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesInfoCondition;

public class AsSuppliesInfoForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsSuppliesInfo item = new AsSuppliesInfo();

	private AsSuppliesInfoCondition condition = new AsSuppliesInfoCondition();

	private Page<AsSuppliesInfo> page=new Page<AsSuppliesInfo>();
	
	public AsSuppliesInfoForm() {
		super();
	}

	public AsSuppliesInfo getItem() {
		return item;
	}

	public void setItem(AsSuppliesInfo item) {
		this.item = item;
	}

	public AsSuppliesInfoCondition getCondition() {
		return condition;
	}

	public void setCondition(AsSuppliesInfoCondition condition) {
		this.condition = condition;
	}

	public Page<AsSuppliesInfo> getPage() {
		return page;
	}

	public void setPage(Page<AsSuppliesInfo> page) {
		this.page = page;
	}

}
