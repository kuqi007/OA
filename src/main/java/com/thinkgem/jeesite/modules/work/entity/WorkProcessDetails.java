package com.thinkgem.jeesite.modules.work.entity;

import java.io.Serializable;

/**
 * 流程详情表
 * 
 * @creator
 * @create-time 2016-05-12 11:30:08
 */
public class WorkProcessDetails implements Serializable{
	/**  */
	private static final long serialVersionUID = 1L;
	private String id;
	/** 审批步奏 */
	private Integer step;
	/** 审批角色id */
	private String roleid;
	/** 状态标识 */
	private Integer state;
	/** 流程表id */
	private String processid;

	public WorkProcessDetails() {
		super();
	}

	/** 审批步奏 */
	public Integer getStep(){
		return this.step;
	}

	/** 审批步奏 */
	public void setStep(Integer step){
		this.step = step;
	}
	/** 审批角色id */
	public String getRoleid(){
		return this.roleid;
	}

	/** 审批角色id */
	public void setRoleid(String roleid){
		this.roleid = roleid;
	}
	/** 状态标识 */
	public Integer getState(){
		return this.state;
	}

	/** 状态标识 */
	public void setState(Integer state){
		this.state = state;
	}
	/** 流程表id */
	public String getProcessid(){
		return this.processid;
	}

	/** 流程表id */
	public void setProcessid(String processid){
		this.processid = processid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}