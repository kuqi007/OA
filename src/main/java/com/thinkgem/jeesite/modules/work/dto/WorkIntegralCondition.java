package com.thinkgem.jeesite.modules.work.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkIntegralCondition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 部门id */
	private String department;
	private String departmentName;
	/** 申请人名字 */
	private String name;
	/** 会员名字 */
	private String uname;
	/** 交易号 */
	private String number;
	/** 身份证号 */
	private String card;
	/** 会员单位名称 */
	private String unitname;
	/** 联系电话 */
	private String telephone;
	/** 备注 */
	private String remarks;
	/** 经办人签字 */
	private String sign1;
	/** 经办人意见 */
	private String text1;
	/** 签字人id */
	private String people1;
	/** 客服签字 */
	private String sign2;
	/** 客服意见 */
	private String text2;
	/** 签字人id */
	private String people2;
	/** it部门解冻签字 */
	private String sign3;
	/** it部门解冻意见 */
	private String text3;
	/** 签字人id */
	private String people3;
	/** 分管领导签字 */
	private String sign4;
	/** 分管领导意见 */
	private String text4;
	/** 签字人id */
	private String people4;
	/** 财务经理签字 */
	private String sign5;
	/** 财务经理意见 */
	private String text5;
	/** 签字人id */
	private String people5;
	/** it积分清零并解冻签字 */
	private String sign6;
	/** it积分清零并解冻意见 */
	private String text6;
	/** 签字人id */
	private String people6;
	/** 会服确认签字 */
	private String sign7;
	/** 会服确认意见 */
	private String text7;
	/** 签字人id */
	private String people7;
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
	/** 申请人名字 */
	public String getName(){
		return this.name;
	}

	/** 申请人名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 会员名字 */
	public String getUname(){
		return this.uname;
	}

	/** 会员名字 */
	public void setUname(String uname){
		this.uname = uname;
	}
	/** 交易号 */
	public String getNumber(){
		return this.number;
	}

	/** 交易号 */
	public void setNumber(String number){
		this.number = number;
	}
	/** 身份证号 */
	public String getCard(){
		return this.card;
	}

	/** 身份证号 */
	public void setCard(String card){
		this.card = card;
	}
	/** 会员单位名称 */
	public String getUnitname(){
		return this.unitname;
	}

	/** 会员单位名称 */
	public void setUnitname(String unitname){
		this.unitname = unitname;
	}
	/** 联系电话 */
	public String getTelephone(){
		return this.telephone;
	}

	/** 联系电话 */
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	/** 备注 */
	public String getRemarks(){
		return this.remarks;
	}

	/** 备注 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/** 经办人签字 */
	public String getSign1(){
		return this.sign1;
	}

	/** 经办人签字 */
	public void setSign1(String sign1){
		this.sign1 = sign1;
	}
	/** 经办人意见 */
	public String getText1(){
		return this.text1;
	}

	/** 经办人意见 */
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
	/** 客服签字 */
	public String getSign2(){
		return this.sign2;
	}

	/** 客服签字 */
	public void setSign2(String sign2){
		this.sign2 = sign2;
	}
	/** 客服意见 */
	public String getText2(){
		return this.text2;
	}

	/** 客服意见 */
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
	/** it部门解冻签字 */
	public String getSign3(){
		return this.sign3;
	}

	/** it部门解冻签字 */
	public void setSign3(String sign3){
		this.sign3 = sign3;
	}
	/** it部门解冻意见 */
	public String getText3(){
		return this.text3;
	}

	/** it部门解冻意见 */
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
	/** 分管领导签字 */
	public String getSign4(){
		return this.sign4;
	}

	/** 分管领导签字 */
	public void setSign4(String sign4){
		this.sign4 = sign4;
	}
	/** 分管领导意见 */
	public String getText4(){
		return this.text4;
	}

	/** 分管领导意见 */
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
	/** 财务经理签字 */
	public String getSign5(){
		return this.sign5;
	}

	/** 财务经理签字 */
	public void setSign5(String sign5){
		this.sign5 = sign5;
	}
	/** 财务经理意见 */
	public String getText5(){
		return this.text5;
	}

	/** 财务经理意见 */
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
	/** it积分清零并解冻签字 */
	public String getSign6(){
		return this.sign6;
	}

	/** it积分清零并解冻签字 */
	public void setSign6(String sign6){
		this.sign6 = sign6;
	}
	/** it积分清零并解冻意见 */
	public String getText6(){
		return this.text6;
	}

	/** it积分清零并解冻意见 */
	public void setText6(String text6){
		this.text6 = text6;
	}
	/** 签字人id */
	public String getPeople6(){
		return this.people6;
	}

	/** 签字人id */
	public void setPeople6(String people6){
		this.people6 = people6;
	}
	/** 会服确认签字 */
	public String getSign7(){
		return this.sign7;
	}

	/** 会服确认签字 */
	public void setSign7(String sign7){
		this.sign7 = sign7;
	}
	/** 会服确认意见 */
	public String getText7(){
		return this.text7;
	}

	/** 会服确认意见 */
	public void setText7(String text7){
		this.text7 = text7;
	}
	/** 签字人id */
	public String getPeople7(){
		return this.people7;
	}

	/** 签字人id */
	public void setPeople7(String people7){
		this.people7 = people7;
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
