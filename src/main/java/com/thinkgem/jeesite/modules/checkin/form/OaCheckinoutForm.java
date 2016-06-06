package com.thinkgem.jeesite.modules.checkin.form;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.checkin.dto.OaCheckinoutCondition;
import com.thinkgem.jeesite.modules.checkin.entity.OaCheckinout;

public class OaCheckinoutForm {

	private OaCheckinout item = new OaCheckinout();

	private OaCheckinoutCondition condition = new OaCheckinoutCondition();
	private Page<OaCheckinout> page=new Page<OaCheckinout>();

	public OaCheckinoutForm() {
		super();
	}

	public OaCheckinout getItem() {
		return item;
	}

	public void setItem(OaCheckinout item) {
		this.item = item;
	}
	public Page<OaCheckinout> getPage() {
		return page;
	}

	public void setPage(Page<OaCheckinout> page) {
		this.page = page;
	}
	public OaCheckinoutCondition getCondition() {
		return condition;
	}

	public void setCondition(OaCheckinoutCondition condition) {
		this.condition = condition;
	}

}
