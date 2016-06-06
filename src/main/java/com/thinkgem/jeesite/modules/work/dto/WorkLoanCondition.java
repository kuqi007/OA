package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkLoanCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 部门id */
	private String department;
	private String departmentName;
	/** 名字 */
	private String name;
	/** 用途 */
	private String purpose;
	/** 人民币大写 */
	private String moneyM;
	/** 分管领导签字 */
	private String sign1;
	/** 分管领导意见 */
	private String text1;
	/** 签字人id */
	private String people1;
	/** 财务经理签字 */
	private String sign2;
	/** 财务经理意见 */
	private String text2;
	/** 签字人id */
	private String people2;
	/** 总经理签字 */
	private String sign3;
	/** 总经理意见 */
	private String text3;
	/** 签字人id */
	private String people3;
	/** 财务付款确认签字 */
	private String sign4;
	/** 财务付款确认意见 */
	private String text4;
	/** 签字人id */
	private String people4;
	/** 公司内部自定义的唯一编号 */
	private String transaction;
	private Integer state;
	private Integer flag;
	/** 签字人*/
	private String signPeople;
	/**开始时间*/
	private Date beginTime;
	/**结束时间*/
	private Date endTime;
	private String createBy;
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
	/** 名字 */
	public String getName(){
		return this.name;
	}

	/** 名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 用途 */
	public String getPurpose(){
		return this.purpose;
	}

	/** 用途 */
	public void setPurpose(String purpose){
		this.purpose = purpose;
	}
	/** 人民币大写 */
	public String getMoneyM(){
		return this.moneyM;
	}

	/** 人民币大写 */
	public void setMoneyM(String moneyM){
		this.moneyM = moneyM;
	}
	/** 分管领导签字 */
	public String getSign1(){
		return this.sign1;
	}

	/** 分管领导签字 */
	public void setSign1(String sign1){
		this.sign1 = sign1;
	}
	/** 分管领导意见 */
	public String getText1(){
		return this.text1;
	}

	/** 分管领导意见 */
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
	/** 财务经理签字 */
	public String getSign2(){
		return this.sign2;
	}

	/** 财务经理签字 */
	public void setSign2(String sign2){
		this.sign2 = sign2;
	}
	/** 财务经理意见 */
	public String getText2(){
		return this.text2;
	}

	/** 财务经理意见 */
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
	/** 总经理签字 */
	public String getSign3(){
		return this.sign3;
	}

	/** 总经理签字 */
	public void setSign3(String sign3){
		this.sign3 = sign3;
	}
	/** 总经理意见 */
	public String getText3(){
		return this.text3;
	}

	/** 总经理意见 */
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
	/** 财务付款确认签字 */
	public String getSign4(){
		return this.sign4;
	}

	/** 财务付款确认签字 */
	public void setSign4(String sign4){
		this.sign4 = sign4;
	}
	/** 财务付款确认意见 */
	public String getText4(){
		return this.text4;
	}

	/** 财务付款确认意见 */
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
	/** 公司内部自定义的唯一编号 */
	public String getTransaction(){
		return this.transaction;
	}

	/** 公司内部自定义的唯一编号 */
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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
