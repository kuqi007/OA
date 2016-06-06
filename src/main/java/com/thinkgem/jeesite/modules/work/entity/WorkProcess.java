package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 流程表
 * 
 * @creator
 * @create-time 2016-05-12 10:43:16
 */
public class WorkProcess implements Serializable{
	/**  */
	private static final long serialVersionUID = 1L;

	private String id;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 删除标记1-未删除2-已删除 */
	private Integer delFlag;
	/** 单据类型（1-请假单） */
	private Integer billType;
	/**流程详情*/
	private List<WorkProcessDetails> listProcessDetails=new ArrayList<WorkProcessDetails>();
	
	public WorkProcess() {
		super();
	}

	/** 删除标记1-未删除2-已删除 */
	public Integer getDelFlag(){
		return this.delFlag;
	}

	/** 删除标记1-未删除2-已删除 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/** 单据类型（1-请假单） */
	public Integer getBillType(){
		return this.billType;
	}

	/** 单据类型（1-请假单） */
	public void setBillType(Integer billType){
		this.billType = billType;
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

	public List<WorkProcessDetails> getListProcessDetails() {
		return listProcessDetails;
	}

	public void setListProcessDetails(List<WorkProcessDetails> listProcessDetails) {
		this.listProcessDetails = listProcessDetails;
	}
	
}