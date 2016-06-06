package com.thinkgem.jeesite.modules.checkin.form;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckrealCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckreal;

public class OaCheckrealForm {

	private OaCheckreal item = new OaCheckreal();

	private OaCheckrealCondition condition = new OaCheckrealCondition();
	private Page<OaCheckreal> page=new Page<OaCheckreal>();

	public OaCheckrealForm() {
		super();
	}

	public OaCheckreal getItem() {
		return item;
	}

	public void setItem(OaCheckreal item) {
		this.item = item;
	}

	public OaCheckrealCondition getCondition() {
		return condition;
	}

	public void setCondition(OaCheckrealCondition condition) {
		this.condition = condition;
	}
	public Page<OaCheckreal> getPage() {
		return page;
	}

	public void setPage(Page<OaCheckreal> page) {
		this.page = page;
	}
}
