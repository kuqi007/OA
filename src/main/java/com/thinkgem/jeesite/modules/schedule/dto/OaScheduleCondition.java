package com.thinkgem.jeesite.modules.schedule.dto;

import java.sql.Date;

public class OaScheduleCondition{

	/** 归属用户 */
	private String userId;
	/** 提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒 */
	private String noticeType;
	/** 事物标题 */
	private String title;
	/** 事物内容 */
	private String content;
	/** 删除标记 */
	private String delFlag;
	/**开始时间*/
	private Date startDate;
	/**结束时间*/
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/** 归属用户 */
	public String getUserId(){
		return this.userId;
	}

	/** 归属用户 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/** 提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒 */
	public String getNoticeType(){
		return this.noticeType;
	}

	/** 提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒 */
	public void setNoticeType(String noticeType){
		this.noticeType = noticeType;
	}
	/** 事物标题 */
	public String getTitle(){
		return this.title;
	}

	/** 事物标题 */
	public void setTitle(String title){
		this.title = title;
	}
	/** 事物内容 */
	public String getContent(){
		return this.content;
	}

	/** 事物内容 */
	public void setContent(String content){
		this.content = content;
	}
	/** 删除标记 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/** 删除标记 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
}
