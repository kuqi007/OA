package com.thinkgem.jeesite.modules.sys.form;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.dto.ProductTypeCondition;
import com.thinkgem.jeesite.modules.sys.entity.ProductType;

public class ProductTypeForm {

	private ProductType item = new ProductType();

	private ProductTypeCondition condition = new ProductTypeCondition();

	private Integer state;
	
	protected Page<ProductType> page=new Page<ProductType>();
	public ProductTypeForm() {
		super();
	}

	public ProductType getItem() {
		return item;
	}

	public void setItem(ProductType item) {
		this.item = item;
	}

	public ProductTypeCondition getCondition() {
		return condition;
	}

	public void setCondition(ProductTypeCondition condition) {
		this.condition = condition;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Page<ProductType> getPage() {
		return page;
	}

	public void setPage(Page<ProductType> page) {
		this.page = page;
	}

}
