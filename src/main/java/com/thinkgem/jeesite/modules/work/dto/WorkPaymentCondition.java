package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkPaymentCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 付款人姓名 */
	private String name;
	/** 部门id */
	private String department;
	private String departmentName;
	/** 付款人 */
	private String drawee;
	/** 付款事由 */
	private String reason;
	/** 收款人户名 */
	private String payeeName;
	/** 收款人账号 */
	private String payeeNumber;
	/** 付款凭证 */
	private String voucher;
	/** 开户银行 */
	private String bank;
	/** 人民币大写 */
	private String capital;
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
	private String sign1;
	/** 总经理意见 */
	private String text1;
	/** 签字人id */
	private String people1;
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
	/** 付款人 */
	public String getDrawee(){
		return this.drawee;
	}

	/** 付款人 */
	public void setDrawee(String drawee){
		this.drawee = drawee;
	}
	/** 付款事由 */
	public String getReason(){
		return this.reason;
	}

	/** 付款事由 */
	public void setReason(String reason){
		this.reason = reason;
	}
	/** 收款人户名 */
	public String getPayeeName(){
		return this.payeeName;
	}

	/** 收款人户名 */
	public void setPayeeName(String payeeName){
		this.payeeName = payeeName;
	}
	/** 收款人账号 */
	public String getPayeeNumber(){
		return this.payeeNumber;
	}

	/** 收款人账号 */
	public void setPayeeNumber(String payeeNumber){
		this.payeeNumber = payeeNumber;
	}
	/** 付款凭证 */
	public String getVoucher(){
		return this.voucher;
	}

	/** 付款凭证 */
	public void setVoucher(String voucher){
		this.voucher = voucher;
	}
	/** 开户银行 */
	public String getBank(){
		return this.bank;
	}

	/** 开户银行 */
	public void setBank(String bank){
		this.bank = bank;
	}
	/** 人民币大写 */
	public String getCapital(){
		return this.capital;
	}

	/** 人民币大写 */
	public void setCapital(String capital){
		this.capital = capital;
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
	public String getSign1(){
		return this.sign1;
	}

	/** 总经理签字 */
	public void setSign1(String sign1){
		this.sign1 = sign1;
	}
	/** 总经理意见 */
	public String getText1(){
		return this.text1;
	}

	/** 总经理意见 */
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
