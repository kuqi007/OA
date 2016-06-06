package com.thinkgem.jeesite.modules.administr.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 办公用品出库记录
 * @create-time 2016/4/7 9:48:38
 */
public class AsSuppliesOut implements Serializable{
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
	/** 删除标记0-未删除1-已删除 */
	private Integer delFlag;
	/** 签收人id */
	private String peopleId;
	/** 出库时间 */
	private Date time;
	/**签收状态(0-未签收1-已签收)*/
	private Integer state;
	// 非持久层
	/**申领人名字*/
	private String peopleName;
	/**签收人部门名字*/
	private String officeName;
	
	public AsSuppliesOut() {
		super();
	}


	public Integer getDelFlag() {
		return delFlag;
	}


	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}


	/** 申领人id */
	public String getPeopleId(){
		return this.peopleId;
	}

	/** 申领人id */
	public void setPeopleId(String peopleId){
		this.peopleId = peopleId;
	}

	/** 出库时间 */
	public Date getTime(){
		return this.time;
	}

	/** 出库时间 */
	public void setTime(Date time){
		this.time = time;
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

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
}