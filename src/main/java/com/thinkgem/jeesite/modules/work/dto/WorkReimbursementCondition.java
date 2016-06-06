package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkReimbursementCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	/** 部门id */
	private String department;
	private String departmentName;
	/** 出差事由 */
	private String reason;
	/** 出差地点 */
	private String place;
	/** 交通工具1 */
	private String traffic1;
	/** 交通工具2 */
	private String traffic2;
	/** 交通工具3 */
	private String traffic3;
	/** 交通工具4 */
	private String traffic4;
	/** 交通工具5 */
	private String traffic5;
	/** 部门主管签字 */
	private String sign1;
	/** 部门主管意见 */
	private String text1;
	/** 签字人id */
	private String people1;
	/** 部门经理签字 */
	private String sign2;
	/** 部门经理意见 */
	private String text2;
	/** 签字人id */
	private String people2;
	/** 分管领导签字 */
	private String sign3;
	/** 分管领导意见 */
	private String text3;
	/** 签字人id */
	private String people3;
	/** 财务经理签字 */
	private String sign4;
	/** 财务经理意见 */
	private String text4;
	/** 签字人id */
	private String people4;
	/** 总经理签字 */
	private String sign5;
	/** 总经理意见 */
	private String text5;
	/** 签字人id */
	private String people5;
	private Integer state;
	private Integer flag;
	private String createBy;
	/** 签字人*/
	private String signPeople;
	/**编号*/
	private String transaction;
	/**开始时间*/
	private Date beginTime;
	/**结束时间*/
	private Date endTime;
	/**审批角色id*/
	private String examination; 
	/**1-查询已完成工作，包括已审批的，审批未通过的，已终止的,就是不包括正在审批的*/
	private Integer TrialIng;
	
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	/** 部门id */
	public String getDepartment(){
		return this.department;
	}

	/** 部门id */
	public void setDepartment(String department){
		this.department = department;
	}
	/** 出差事由 */
	public String getReason(){
		return this.reason;
	}

	/** 出差事由 */
	public void setReason(String reason){
		this.reason = reason;
	}
	/** 出差地点 */
	public String getPlace(){
		return this.place;
	}

	/** 出差地点 */
	public void setPlace(String place){
		this.place = place;
	}
	/** 交通工具1 */
	public String getTraffic1(){
		return this.traffic1;
	}

	/** 交通工具1 */
	public void setTraffic1(String traffic1){
		this.traffic1 = traffic1;
	}
	/** 交通工具2 */
	public String getTraffic2(){
		return this.traffic2;
	}

	/** 交通工具2 */
	public void setTraffic2(String traffic2){
		this.traffic2 = traffic2;
	}
	/** 交通工具3 */
	public String getTraffic3(){
		return this.traffic3;
	}

	/** 交通工具3 */
	public void setTraffic3(String traffic3){
		this.traffic3 = traffic3;
	}
	/** 交通工具4 */
	public String getTraffic4(){
		return this.traffic4;
	}

	/** 交通工具4 */
	public void setTraffic4(String traffic4){
		this.traffic4 = traffic4;
	}
	/** 交通工具5 */
	public String getTraffic5(){
		return this.traffic5;
	}

	/** 交通工具5 */
	public void setTraffic5(String traffic5){
		this.traffic5 = traffic5;
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
	/** 签字人id */
	public String getPeople1(){
		return this.people1;
	}

	/** 签字人id */
	public void setPeople1(String people1){
		this.people1 = people1;
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
	/** 签字人id */
	public String getPeople2(){
		return this.people2;
	}

	/** 签字人id */
	public void setPeople2(String people2){
		this.people2 = people2;
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
	/** 签字人id */
	public String getPeople3(){
		return this.people3;
	}

	/** 签字人id */
	public void setPeople3(String people3){
		this.people3 = people3;
	}
	/** 财务经理签字 */
	public String getSign4(){
		return this.sign4;
	}

	/** 财务经理签字 */
	public void setSign4(String sign4){
		this.sign4 = sign4;
	}
	/** 财务经理意见 */
	public String getText4(){
		return this.text4;
	}

	/** 财务经理意见 */
	public void setText4(String text4){
		this.text4 = text4;
	}
	/** 签字人id */
	public String getPeople4(){
		return this.people4;
	}

	/** 签字人id */
	public void setPeople4(String people4){
		this.people4 = people4;
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
	/** 签字人id */
	public String getPeople5(){
		return this.people5;
	}

	/** 签字人id */
	public void setPeople5(String people5){
		this.people5 = people5;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
