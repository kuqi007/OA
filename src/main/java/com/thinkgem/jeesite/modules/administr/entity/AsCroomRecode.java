package com.thinkgem.jeesite.modules.administr.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 会议室申请使用记录表
 * 
 * @creator
 * @create-time 2016-04-11 11:06:41
 */
public class AsCroomRecode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  */
	private String id;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 删除标0-未删除，1-已删除 */
	private Integer delFlag;
	/** 申请人id */
	private String peopleId;
	/** 申请时间 */
	private Date time;
	/** 预计开始时间 */
	private Date timeBegin;
	/** 预计结束时间 */
	private Date timeEnd;
	/** 使用原因 */
	private String reason;
	/** 申请状态0-审核中1-同意2-不同意 */
	private Integer state;
	/**会议室id*/
	private String croomId;
	/**备注*/
	private String text;
	// 非持久层
	/**会议室名字*/
	private String croomName;
	/**申请人名字*/
	private String peopleName;
	/**申请人部门名字*/
	private String officeName;
	
	public AsCroomRecode() {
		super();
	}

	/** 删除标0-未删除，1-已删除 */
	public Integer getDelFlag(){
		return this.delFlag;
	}

	/** 删除标0-未删除，1-已删除 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/** 申请人id */
	public String getPeopleId(){
		return this.peopleId;
	}

	/** 申请人id */
	public void setPeopleId(String peopleId){
		this.peopleId = peopleId;
	}
	/** 申请时间 */
	public Date getTime(){
		return this.time;
	}

	/** 申请时间 */
	public void setTime(Date time){
		this.time = time;
	}
	/** 预计开始时间 */
	public Date getTimeBegin(){
		return this.timeBegin;
	}

	/** 预计开始时间 */
	public void setTimeBegin(Date timeBegin){
		this.timeBegin = timeBegin;
	}
	/** 预计结束时间 */
	public Date getTimeEnd(){
		return this.timeEnd;
	}

	/** 预计结束时间 */
	public void setTimeEnd(Date timeEnd){
		this.timeEnd = timeEnd;
	}
	/** 使用原因 */
	public String getReason(){
		return this.reason;
	}

	/** 使用原因 */
	public void setReason(String reason){
		this.reason = reason;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCroomId() {
		return croomId;
	}

	public void setCroomId(String croomId) {
		this.croomId = croomId;
	}

	public String getCroomName() {
		return croomName;
	}

	public void setCroomName(String croomName) {
		this.croomName = croomName;
	}

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}