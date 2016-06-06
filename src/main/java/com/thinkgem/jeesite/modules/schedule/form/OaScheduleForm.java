package com.thinkgem.jeesite.modules.schedule.form;

import com.thinkgem.jeesite.modules.schedule.dto.OaScheduleCondition;
import com.thinkgem.jeesite.modules.schedule.entity.OaSchedule;

public class OaScheduleForm {

	private OaSchedule item = new OaSchedule();

	private OaScheduleCondition condition = new OaScheduleCondition();
//	private String title;//标题
	
	/*private String content;//内容

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
*/
	public OaScheduleForm() {
		super();
	}

	public OaSchedule getItem() {
		return item;
	}

	public void setItem(OaSchedule item) {
		this.item = item;
	}

	public OaScheduleCondition getCondition() {
		return condition;
	}

	public void setCondition(OaScheduleCondition condition) {
		this.condition = condition;
	}

}
