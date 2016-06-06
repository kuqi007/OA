package com.thinkgem.jeesite.modules.schedule.entity;
import java.sql.Time;
import java.util.Date;


/**
 * 个人事物表; InnoDB free: 5120 kB
 * 
 * @creator
 * @create-time 2016-03-18 11:31:53
 */
public class OaSchedule  {
	/**  */
	private String id;
	/** 归属用户 */
	private String userId;
	/** 开始时间 */
	private Time startTime;
	/** 结束时间 */
	private Time  endTime;
	/** 开始日期 */
	private Date startDate;
	/** 结束日期 */
	private Date endDate;
	/** 提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒 */
	private String noticeType;
	/** 事物标题 */
	private String title;
	/** 事物内容 */
	private String content;
	/** 删除标记 */
	private String delFlag;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private String updateBy;
	/** 创建时间 */
	private Date createDate;
	/** 更新时间 */
	private Date updateDate;
	

	public OaSchedule() {
		super();
	}

	/** 归属用户 */
	public String getUserId(){
		return this.userId;
	}

	/** 归属用户 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/** 开始时间 */
	public Time getStartTime(){
		return this.startTime;
	}

	/** 开始时间 */
	public void setStartTime(Time startTime){
		this.startTime = startTime;
	}
	/** 结束时间 */
	public Time  getEndTime(){
		return this.endTime;
	}

	/** 结束时间 */
	public void setEndTime(Time endTime){
		this.endTime = endTime;
	}
	/** 开始日期 */
	public Date getStartDate(){
		return this.startDate;
	}

	/** 开始日期 */
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	/** 结束日期 */
	public Date getEndDate(){
		return this.endDate;
	}

	/** 结束日期 */
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
	/** 提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒 */
	public String getNoticeType(){
		return this.noticeType;
	}

	/** 提醒类型(0：提醒一次，1:按日提醒，2：按周提醒，3：按月提醒 */
	public void setNoticeType(String noticeType){
		this.noticeType = noticeType;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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