package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentHrCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkPaymentHr;

public class WorkPaymentHrForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkPaymentHr item = new WorkPaymentHr();

	private WorkPaymentHrCondition condition = new WorkPaymentHrCondition();
	
	private Page<WorkPaymentHr> page=new Page<WorkPaymentHr>();
	private Integer state;

	public WorkPaymentHrForm() {
		super();
	}



	public WorkPaymentHr getItem() {
		return item;
	}



	public void setItem(WorkPaymentHr item) {
		this.item = item;
	}



	public WorkPaymentHrCondition getCondition() {
		return condition;
	}



	public void setCondition(WorkPaymentHrCondition condition) {
		this.condition = condition;
	}



	public Page<WorkPaymentHr> getPage() {
		return page;
	}



	public void setPage(Page<WorkPaymentHr> page) {
		this.page = page;
	}



	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
