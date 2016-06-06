package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkLeaveCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String createBy;
	/** 部门id */
	private String department;
	private String departmentName;
	/** 职务 */
	private String post;
	/** 名字 */
	private String name;
	/** 请假原因 */
	private String reason;
	/** 部门主管签字 */
	private String sign1;
	/** 部门主管意见 */
	private String text1;
	/** 部门经理签字 */
	private String sign2;
	/** 部门经理意见 */
	private String text2;
	/** 分管领导签字 */
	private String sign3;
	/** 分管领导意见 */
	private String text3;
	/** 人力行政签字 */
	private String sign4;
	/** 人力行政意见 */
	private String text4;
	/** 总经理签字 */
	private String sign5;
	/** 总经理意见 */
	private String text5;
	private Integer state;
	private Integer flag;
	/** 签字人*/
	private String signPeople;
	/**编号*/
	private String transaction;
	/**开始时间*/
	private Date beginTime;
	/**结束时间*/
	private Date endTime;
	/**1-查询已完成工作，包括已审批的，审批未通过的，已终止的,就是不包括正在审批的*/
	private Integer TrialIng;
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
	/** 职务 */
	public String getPost(){
		return this.post;
	}

	/** 职务 */
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
	/** 请假原因 */
	public String getReason(){
		return this.reason;
	}

	/** 请假原因 */
	public void setReason(String reason){
		this.reason = reason;
	}
	/** 部门主管签字 */
	public String getSign1(){
		return this.sign1;
	}

	/** 部门主管签字 */
	public void setSign1(String sign1){
		this.sign1 = sign1;
	}
	/** 部门主管意见 */
	public String getText1(){
		return this.text1;
	}

	/** 部门主管意见 */
	public void setText1(String text1){
		this.text1 = text1;
	}
	/** 部门经理签字 */
	public String getSign2(){
		return this.sign2;
	}

	/** 部门经理签字 */
	public void setSign2(String sign2){
		this.sign2 = sign2;
	}
	/** 部门经理意见 */
	public String getText2(){
		return this.text2;
	}

	/** 部门经理意见 */
	public void setText2(String text2){
		this.text2 = text2;
	}
	/** 分管领导签字 */
	public String getSign3(){
		return this.sign3;
	}

	/** 分管领导签字 */
	public void setSign3(String sign3){
		this.sign3 = sign3;
	}
	/** 分管领导意见 */
	public String getText3(){
		return this.text3;
	}

	/** 分管领导意见 */
	public void setText3(String text3){
		this.text3 = text3;
	}
	/** 人力行政签字 */
	public String getSign4(){
		return this.sign4;
	}

	/** 人力行政签字 */
	public void setSign4(String sign4){
		this.sign4 = sign4;
	}
	/** 人力行政意见 */
	public String getText4(){
		return this.text4;
	}

	/** 人力行政意见 */
	public void setText4(String text4){
		this.text4 = text4;
	}
	/** 总经理签字 */
	public String getSign5(){
		return this.sign5;
	}

	/** 总经理签字 */
	public void setSign5(String sign5){
		this.sign5 = sign5;
	}
	/** 总经理意见 */
	public String getText5(){
		return this.text5;
	}

	/** 总经理意见 */
	public void setText5(String text5){
		this.text5 = text5;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public String getSignPeople() {
		return signPeople;
	}

	public void setSignPeople(String signPeople) {
		this.signPeople = signPeople;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
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

	public Integer getTrialIng() {
		return TrialIng;
	}

	public void setTrialIng(Integer trialIng) {
		TrialIng = trialIng;
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
