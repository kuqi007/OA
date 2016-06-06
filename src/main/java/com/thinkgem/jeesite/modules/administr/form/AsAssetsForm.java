package com.thinkgem.jeesite.modules.administr.form;

import com.thinkgem.jeesite.modules.administr.entity.AsAssets;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.administr.dto.AsAssetsCondition;

public class AsAssetsForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AsAssets item = new AsAssets();

	private AsAssetsCondition condition = new AsAssetsCondition();

	private Page<AsAssets> page=new Page<AsAssets>();
	
	public AsAssetsForm() {
		super();
	}

	public AsAssets getItem() {
		return item;
	}

	public void setItem(AsAssets item) {
		this.item = item;
	}

	public AsAssetsCondition getCondition() {
		return condition;
	}

	public void setCondition(AsAssetsCondition condition) {
		this.condition = condition;
	}

	public Page<AsAssets> getPage() {
		return page;
	}

	public void setPage(Page<AsAssets> page) {
		this.page = page;
	}

}
