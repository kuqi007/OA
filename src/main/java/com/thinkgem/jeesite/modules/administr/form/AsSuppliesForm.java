package com.thinkgem.jeesite.modules.administr.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsSuppliesCondition;
import com.thinkgem.jeesite.modules.administr.entity.AsSupplies;

public class AsSuppliesForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsSupplies item = new AsSupplies();

	private AsSuppliesCondition condition = new AsSuppliesCondition();

	private Page<AsSupplies> page=new Page<AsSupplies>();
	
	public AsSuppliesForm() {
		super();
	}

	public AsSupplies getItem() {
		return item;
	}

	public void setItem(AsSupplies item) {
		this.item = item;
	}

	public AsSuppliesCondition getCondition() {
		return condition;
	}

	public void setCondition(AsSuppliesCondition condition) {
		this.condition = condition;
	}

	public Page<AsSupplies> getPage() {
		return page;
	}

	public void setPage(Page<AsSupplies> page) {
		this.page = page;
	}



}
