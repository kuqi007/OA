package com.thinkgem.jeesite.modules.administr.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 会议室表
 * 
 * @creator
 * @create-time 2016-04-11 09:53:49
 */
public class AsCroom implements Serializable{
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
	/** 会议室名称 */
	private String name;
	/** 会议室可容纳人数 */
	private Integer number;
	/** 设备情况 */
	private String equipment;
	/** 所在地点 */
	private String position;
	/** 会议室描述 */
	private String describe;
	/** 会议室管理员id */
	private String adminId;
	/** 会议室状态1-启用2-禁用 */
	private Integer state;

	public AsCroom() {
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
	/** 会议室名称 */
	public String getName(){
		return this.name;
	}

	/** 会议室名称 */
	public void setName(String name){
		this.name = name;
	}
	/** 会议室可容纳人数 */
	public Integer getNumber(){
		return this.number;
	}

	/** 会议室可容纳人数 */
	public void setNumber(Integer number){
		this.number = number;
	}
	/** 设备情况 */
	public String getEquipment(){
		return this.equipment;
	}

	/** 设备情况 */
	public void setEquipment(String equipment){
		this.equipment = equipment;
	}
	/** 所在地点 */
	public String getPosition(){
		return this.position;
	}

	/** 所在地点 */
	public void setPosition(String position){
		this.position = position;
	}
	/** 会议室描述 */
	public String getDescribe(){
		return this.describe;
	}

	/** 会议室描述 */
	public void setDescribe(String describe){
		this.describe = describe;
	}
	/** 会议室管理员id */
	public String getAdminId(){
		return this.adminId;
	}

	/** 会议室管理员id */
	public void setAdminId(String adminId){
		this.adminId = adminId;
	}
	/** 会议室状态1-启用2-禁用 */
	public Integer getState(){
		return this.state;
	}

	/** 会议室状态1-启用2-禁用 */
	public void setState(Integer state){
		this.state = state;
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
	
}