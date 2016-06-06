package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkApplyCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 部门id */
	private String department;
	private String departmentName;
	/** 职务id */
	private String post;
	/** 名字 */
	private String name;
	/** 部门经理签字 */
	private String sign1;
	/** 部门经理意见 */
	private String text1;
	/** 签字人id */
	private String people1;
	/** 人力行政签字 */
	private String sign2;
	/** 人力行政意见 */
	private String text2;
	/** 公司内部自定义的唯一编号 */
	private String transaction;
	/** 备注 */
	private String remarks;
	private Integer state;
	private Integer flag;
	private String createBy;
	/** 签字人*/
	private String signPeople;
	/**开始时间*/
	private Date beginTime;
	/**结束时间*/
	private Date endTime;
	/**审批角色id*/
	private String examination;
	/** 部门id */
	public String getDepartment(){
		return this.department;
	}

	/** 部门id */
	public void setDepartment(String department){
		this.department = department;
	}
	/** 职务id */
	public String getPost(){
		return this.post;
	}

	/** 职务id */
	public void setPost(String post){
		this.post = post;
	}
	/** 名字 */
	public String getName(){
		return this.name;
	}

	/** 名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 部门经理签字 */
	public String getSign1(){
		return this.sign1;
	}

	/** 部门经理签字 */
	public void setSign1(String sign1){
		this.sign1 = sign1;
	}
	/** 部门经理意见 */
	public String getText1(){
		return this.text1;
	}

	/** 部门经理意见 */
	public void setText1(String text1){
		this.text1 = text1;
	}
	/** 签字人id */
	public String getPeople1(){
		return this.people1;
	}

	/** 签字人id */
	public void setPeople1(String people1){
		this.people1 = people1;
	}
	/** 人力行政签字 */
	public String getSign2(){
		return this.sign2;
	}

	/** 人力行政签字 */
	public void setSign2(String sign2){
		this.sign2 = sign2;
	}
	/** 人力行政意见 */
	public String getText2(){
		return this.text2;
	}

	/** 人力行政意见 */
	public void setText2(String text2){
		this.text2 = text2;
	}
	/** 公司内部自定义的唯一编号 */
	public String getTransaction(){
		return this.transaction;
	}

	/** 公司内部自定义的唯一编号 */
	public void setTransaction(String transaction){
		this.transaction = transaction;
	}
	/** 备注 */
	public String getRemarks(){
		return this.remarks;
	}

	/** 备注 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getSignPeople() {
		return signPeople;
	}

	public void setSignPeople(String signPeople) {
		this.signPeople = signPeople;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
