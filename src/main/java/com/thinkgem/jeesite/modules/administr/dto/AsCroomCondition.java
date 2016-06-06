package com.thinkgem.jeesite.modules.administr.dto;

import java.io.Serializable;

public class AsCroomCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 会议室名称 */
	private String name;
	/** 设备情况 */
	private String equipment;
	/** 所在地点 */
	private String position;
	/** 会议室描述 */
	private String describe;
	/** 会议室管理员id */
	private String adminId;

	/** 会议室名称 */
	public String getName(){
		return this.name;
	}

	/** 会议室名称 */
	public void setName(String name){
		this.name = name;
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
}
