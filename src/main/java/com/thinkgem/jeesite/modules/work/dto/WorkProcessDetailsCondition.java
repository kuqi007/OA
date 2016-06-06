package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;

public class WorkProcessDetailsCondition  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 审批角色id */
	private String roleid;
	/** 流程表id */
	private String processid;

	/** 审批角色id */
	public String getRoleid(){
		return this.roleid;
	}

	/** 审批角色id */
	public void setRoleid(String roleid){
		this.roleid = roleid;
	}
	/** 流程表id */
	public String getProcessid(){
		return this.processid;
	}

	/** 流程表id */
	public void setProcessid(String processid){
		this.processid = processid;
	}
}
