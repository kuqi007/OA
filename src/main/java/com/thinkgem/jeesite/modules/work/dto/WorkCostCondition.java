package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkCostCondition   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 部门id */
	private String department;
	private String departmentName;
	/** 名字 */
	private String name;
	/** 摘要 */
	private String abstract1;
	/** 科目1 */
	private String subject1;
	/**  */
	private String abstract2;
	/**  */
	private String subject2;
	/**  */
	private String abstract3;
	/**  */
	private String subject3;
	/**  */
	private String abstract4;
	/**  */
	private String subject4;
	/**  */
	private String abstract5;
	/**  */
	private String subject5;
	/**  */
	private String abstract6;
	/**  */
	private String subject6;
	/** 人民币合计（大写） */
	private String capital;
	/** 部门经理签字 */
	private String sign1;
	/** 部门经理意见 */
	private String text1;
	/** 签字人id */
	private String people1;
	/** 分管领导签字 */
	private String sign2;
	/** 分管领导意见 */
	private String text2;
	/** 签字人id */
	private String people2;
	/** 人力行政签字 */
	private String sign3;
	/** 人力行政意见 */
	private String text3;
	/** 签字人id */
	private String people3;
	/** 财务签字 */
	private String sign4;
	/** 财务意见 */
	private String text4;
	/** 签字人id */
	private String people4;
	/** 总经理签字 */
	private String sign5;
	/** 总经理意见 */
	private String text5;
	/** 签字人id */
	private String people5;
	/** 公司内部唯一编号 */
	private String transaction;
	
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
	/**1-查询已完成工作，包括已审批的，审批未通过的，已终止的,就是不包括正在审批的*/
	private Integer TrialIng;
	
	/** 部门id */
	public String getDepartment(){
		return this.department;
	}

	/** 部门id */
	public void setDepartment(String department){
		this.department = department;
	}
	/** 名字 */
	public String getName(){
		return this.name;
	}

	/** 名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 摘要 */
	public String getAbstract1(){
		return this.abstract1;
	}

	/** 摘要 */
	public void setAbstract1(String abstract1){
		this.abstract1 = abstract1;
	}
	/** 科目1 */
	public String getSubject1(){
		return this.subject1;
	}

	/** 科目1 */
	public void setSubject1(String subject1){
		this.subject1 = subject1;
	}
	/**  */
	public String getAbstract2(){
		return this.abstract2;
	}

	/**  */
	public void setAbstract2(String abstract2){
		this.abstract2 = abstract2;
	}
	/**  */
	public String getSubject2(){
		return this.subject2;
	}

	/**  */
	public void setSubject2(String subject2){
		this.subject2 = subject2;
	}
	/**  */
	public String getAbstract3(){
		return this.abstract3;
	}

	/**  */
	public void setAbstract3(String abstract3){
		this.abstract3 = abstract3;
	}
	/**  */
	public String getSubject3(){
		return this.subject3;
	}

	/**  */
	public void setSubject3(String subject3){
		this.subject3 = subject3;
	}
	/**  */
	public String getAbstract4(){
		return this.abstract4;
	}

	/**  */
	public void setAbstract4(String abstract4){
		this.abstract4 = abstract4;
	}
	/**  */
	public String getSubject4(){
		return this.subject4;
	}

	/**  */
	public void setSubject4(String subject4){
		this.subject4 = subject4;
	}
	/**  */
	public String getAbstract5(){
		return this.abstract5;
	}

	/**  */
	public void setAbstract5(String abstract5){
		this.abstract5 = abstract5;
	}
	/**  */
	public String getSubject5(){
		return this.subject5;
	}

	/**  */
	public void setSubject5(String subject5){
		this.subject5 = subject5;
	}
	/**  */
	public String getAbstract6(){
		return this.abstract6;
	}

	/**  */
	public void setAbstract6(String abstract6){
		this.abstract6 = abstract6;
	}
	/**  */
	public String getSubject6(){
		return this.subject6;
	}

	/**  */
	public void setSubject6(String subject6){
		this.subject6 = subject6;
	}
	/** 人民币合计（大写） */
	public String getCapital(){
		return this.capital;
	}

	/** 人民币合计（大写） */
	public void setCapital(String capital){
		this.capital = capital;
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
	/** 分管领导签字 */
	public String getSign2(){
		return this.sign2;
	}

	/** 分管领导签字 */
	public void setSign2(String sign2){
		this.sign2 = sign2;
	}
	/** 分管领导意见 */
	public String getText2(){
		return this.text2;
	}

	/** 分管领导意见 */
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
	/** 人力行政签字 */
	public String getSign3(){
		return this.sign3;
	}

	/** 人力行政签字 */
	public void setSign3(String sign3){
		this.sign3 = sign3;
	}
	/** 人力行政意见 */
	public String getText3(){
		return this.text3;
	}

	/** 人力行政意见 */
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
	/** 财务签字 */
	public String getSign4(){
		return this.sign4;
	}

	/** 财务签字 */
	public void setSign4(String sign4){
		this.sign4 = sign4;
	}
	/** 财务意见 */
	public String getText4(){
		return this.text4;
	}

	/** 财务意见 */
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
	/** 公司内部唯一编号 */
	public String getTransaction(){
		return this.transaction;
	}

	/** 公司内部唯一编号 */
	public void setTransaction(String transaction){
		this.transaction = transaction;
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
