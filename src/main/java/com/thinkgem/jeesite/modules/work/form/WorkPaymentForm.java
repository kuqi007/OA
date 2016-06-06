package com.thinkgem.jeesite.modules.work.form;

import java.io.Serializable;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.work.dto.WorkPaymentCondition;
import com.thinkgem.jeesite.modules.work.entity.WorkPayment;

public class WorkPaymentForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WorkPayment item = new WorkPayment();

	private WorkPaymentCondition condition = new WorkPaymentCondition();
	
	private Page<WorkPayment> page=new Page<WorkPayment>();
	private Integer state;

	public WorkPaymentForm() {
		super();
	}

	public WorkPayment getItem() {
		return item;
	}

	public void setItem(WorkPayment item) {
		this.item = item;
	}

	public WorkPaymentCondition getCondition() {
		return condition;
	}

	public void setCondition(WorkPaymentCondition condition) {
		this.condition = condition;
	}

	public Page<WorkPayment> getPage() {
		return page;
	}

	public void setPage(Page<WorkPayment> page) {
		this.page = page;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
