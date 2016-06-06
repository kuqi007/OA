package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 差旅报销单
 * 
 * @creator
 * @create-time 2016-03-29 13:39:52
 */
public class WorkReimbursement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  */
	private String id;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createDate;
	/** 删除标记1-未删除2-已删除 */
	private Integer delFlag;
	/** 部门id */
	private String department;
	/** 出差人名字 */
	private String name;
	/** 填写时间 */
	private Date time;
	/** 出差事由 */
	private String reason;
	/** 出差时间开始 */
	private Date timeBegin;
	/** 出差时间结束 */
	private Date timeEnd;
	/** 共计天数 */
	private Integer day;
	/** 出差地点 */
	private String place;
	/** 出发时间1 */
	private Date timeSetout1;
	/** 出发时间2 */
	private Date timeSetout2;
	/** 出发时间3 */
	private Date timeSetout3;
	/** 出发时间4 */
	private Date timeSetout4;
	/** 出发时间5 */
	private Date timeSetout5;
	/** 到达时间1 */
	private Date timeArrive1;
	/** 到达时间2 */
	private Date timeArrive2;
	/** 到达时间3 */
	private Date timeArrive3;
	/** 到达时间4 */
	private Date timeArrive4;
	/** 到达时间5 */
	private Date timeArrive5;
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
	/** 交通费单据1 */
	private Integer trafficBill1;
	/** 交通费单据2 */
	private Integer trafficBill2;
	/** 交通费单据3 */
	private Integer trafficBill3;
	/** 交通费单据4 */
	private Integer trafficBill4;
	/** 交通费单据5 */
	private Integer trafficBill5;
	/** 交通费金额1 */
	private Double trafficAmount1;
	/** 交通费金额2 */
	private Double trafficAmount2;
	/** 交通费金额3 */
	private Double trafficAmount3;
	/** 交通费金额4 */
	private Double trafficAmount4;
	/** 交通费金额5 */
	private Double trafficAmount5;
	/** 出差补贴天数1 */
	private Integer subsidyDay1;
	/** 出差补贴天数2 */
	private Integer subsidyDay2;
	/** 出差补贴天数3 */
	private Integer subsidyDay3;
	/** 出差补贴天数4 */
	private Integer subsidyDay4;
	/** 出差补贴天数5 */
	private Integer subsidyDay5;
	/** 出差补贴金额1 */
	private Double subsidyAmount1;
	/** 出差补贴金额2 */
	private Double subsidyAmount2;
	/** 出差补贴金额3 */
	private Double subsidyAmount3;
	/** 出差补贴金额4 */
	private Double subsidyAmount4;
	/** 出差补贴金额5 */
	private Double subsidyAmount5;
	/** 其他费用单据张数1 */
	private Integer otherNum1;
	/** 其他费用单据张数2 */
	private Integer otherNum2;
	/** 其他费用单据张数3 */
	private Integer otherNum3;
	/** 其他费用单据张数4 */
	private Integer otherNum4;
	/** 其他费用单据张数5 */
	private Integer otherNum5;
	/** 其他费用金额1 */
	private Double otherAmount1;
	/** 其他费用金额2 */
	private Double otherAmount2;
	/** 其他费用金额3 */
	private Double otherAmount3;
	/** 其他费用金额4 */
	private Double otherAmount4;
	/** 其他费用金额5 */
	private Double otherAmount5;
	/** 合计金额 */
	private Double money;
	/** 实际出差开始 */
	private Date actualBegin;
	/** 实际出差结束 */
	private Date actualEnd;
	/** 报销总额 */
	private Double reimbursement;
	/** 预借旅费 */
	private Double borrow;
	/** 补领金额 */
	private Double replacement;
	/** 退款金额 */
	private Double refund;
	/** 人力行政执勤人员id */
	private String fill;
	private Date fillTime;
	/**起始角色设置*/
	private Integer beginRole;
	/** 部门主管（1-同意2-不同意） */
	private Integer opinion1;
	/** 部门主管签字 */
	private String sign1;
	/** 部门主管意见 */
	private String text1;
	/** 部门主管签字时间 */
	private Date date1;
	/** 签字人id */
	private String people1;
	/** 部门经理（1-同意2-不同意） */
	private Integer opinion2;
	/** 部门经理签字 */
	private String sign2;
	/** 部门经理意见 */
	private String text2;
	/** 部门经理签字时间 */
	private Date date2;
	/** 签字人id */
	private String people2;
	/** 分管领导（1-同意2-不同意） */
	private Integer opinion3;
	/** 分管领导签字 */
	private String sign3;
	/** 分管领导意见 */
	private String text3;
	/** 分管领导签字时间 */
	private Date date3;
	/** 签字人id */
	private String people3;
	/** 财务经理（1-同意2-不同意） */
	private Integer opinion4;
	/** 财务经理签字 */
	private String sign4;
	/** 财务经理意见 */
	private String text4;
	/** 财务经理签证时间 */
	private Date date4;
	/** 签字人id */
	private String people4;
	/** 总经理（1-同意2-不同意） */
	private Integer opinion5;
	/** 总经理签字 */
	private String sign5;
	/** 总经理意见 */
	private String text5;
	/** 总经理签字时间 */
	private Date date5;
	/** 签字人id */
	private String people5;
	/** 财务（1-同意2-不同意） */
	private Integer opinion6;
	/** 财务 */
	private String sign6;
	/** 财务*/
	private String text6;
	/** 财务*/
	private Date date6;
	/** 签字人id */
	private String people6;
	/** 申请状态1-第一步审批，2-第二步审批 */
	private Integer state;
	/** 0-审批中1-审批通过2-审批失败 */
	private Integer flag;
	/** 公司内部自定义编号(部门编码+员工编号) */
    private String transaction;
    /**付款标记0-未付款1-已付款*/
    private Integer flagPayment;
    /**单据紧急状态标识*/
	private Integer emergency;
	/**审批角色id*/
	private String examination; 
	//非持久化层
	/**部门名字*/
	private String departmentName;
	/**职位名称*/
	private String postName;

	public WorkReimbursement() {
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
	/** 部门id */
	public String getDepartment(){
		return this.department;
	}

	/** 部门id */
	public void setDepartment(String department){
		this.department = department;
	}
	/** 填写时间 */
	public Date getTime(){
		return this.time;
	}

	/** 填写时间 */
	public void setTime(Date time){
		this.time = time;
	}
	/** 出差事由 */
	public String getReason(){
		return this.reason;
	}

	/** 出差事由 */
	public void setReason(String reason){
		this.reason = reason;
	}
	/** 出差时间开始 */
	public Date getTimeBegin(){
		return this.timeBegin;
	}

	/** 出差时间开始 */
	public void setTimeBegin(Date timeBegin){
		this.timeBegin = timeBegin;
	}
	/** 出差时间结束 */
	public Date getTimeEnd(){
		return this.timeEnd;
	}

	/** 出差时间结束 */
	public void setTimeEnd(Date timeEnd){
		this.timeEnd = timeEnd;
	}
	/** 共计天数 */
	public Integer getDay(){
		return this.day;
	}

	/** 共计天数 */
	public void setDay(Integer day){
		this.day = day;
	}
	/** 出差地点 */
	public String getPlace(){
		return this.place;
	}

	/** 出差地点 */
	public void setPlace(String place){
		this.place = place;
	}
	/** 出发时间1 */
	public Date getTimeSetout1(){
		return this.timeSetout1;
	}

	/** 出发时间1 */
	public void setTimeSetout1(Date timeSetout1){
		this.timeSetout1 = timeSetout1;
	}
	/** 出发时间2 */
	public Date getTimeSetout2(){
		return this.timeSetout2;
	}

	/** 出发时间2 */
	public void setTimeSetout2(Date timeSetout2){
		this.timeSetout2 = timeSetout2;
	}
	/** 出发时间3 */
	public Date getTimeSetout3(){
		return this.timeSetout3;
	}

	/** 出发时间3 */
	public void setTimeSetout3(Date timeSetout3){
		this.timeSetout3 = timeSetout3;
	}
	/** 出发时间4 */
	public Date getTimeSetout4(){
		return this.timeSetout4;
	}

	/** 出发时间4 */
	public void setTimeSetout4(Date timeSetout4){
		this.timeSetout4 = timeSetout4;
	}
	/** 出发时间5 */
	public Date getTimeSetout5(){
		return this.timeSetout5;
	}

	/** 出发时间5 */
	public void setTimeSetout5(Date timeSetout5){
		this.timeSetout5 = timeSetout5;
	}
	/** 到达时间1 */
	public Date getTimeArrive1(){
		return this.timeArrive1;
	}

	/** 到达时间1 */
	public void setTimeArrive1(Date timeArrive1){
		this.timeArrive1 = timeArrive1;
	}
	/** 到达时间2 */
	public Date getTimeArrive2(){
		return this.timeArrive2;
	}

	/** 到达时间2 */
	public void setTimeArrive2(Date timeArrive2){
		this.timeArrive2 = timeArrive2;
	}
	/** 到达时间3 */
	public Date getTimeArrive3(){
		return this.timeArrive3;
	}

	/** 到达时间3 */
	public void setTimeArrive3(Date timeArrive3){
		this.timeArrive3 = timeArrive3;
	}
	/** 到达时间4 */
	public Date getTimeArrive4(){
		return this.timeArrive4;
	}

	/** 到达时间4 */
	public void setTimeArrive4(Date timeArrive4){
		this.timeArrive4 = timeArrive4;
	}
	/** 到达时间5 */
	public Date getTimeArrive5(){
		return this.timeArrive5;
	}

	/** 到达时间5 */
	public void setTimeArrive5(Date timeArrive5){
		this.timeArrive5 = timeArrive5;
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
	/** 交通费单据1 */
	public Integer getTrafficBill1(){
		return this.trafficBill1;
	}

	/** 交通费单据1 */
	public void setTrafficBill1(Integer trafficBill1){
		this.trafficBill1 = trafficBill1;
	}
	/** 交通费单据2 */
	public Integer getTrafficBill2(){
		return this.trafficBill2;
	}

	/** 交通费单据2 */
	public void setTrafficBill2(Integer trafficBill2){
		this.trafficBill2 = trafficBill2;
	}
	/** 交通费单据3 */
	public Integer getTrafficBill3(){
		return this.trafficBill3;
	}

	/** 交通费单据3 */
	public void setTrafficBill3(Integer trafficBill3){
		this.trafficBill3 = trafficBill3;
	}
	/** 交通费单据4 */
	public Integer getTrafficBill4(){
		return this.trafficBill4;
	}

	/** 交通费单据4 */
	public void setTrafficBill4(Integer trafficBill4){
		this.trafficBill4 = trafficBill4;
	}
	/** 交通费单据5 */
	public Integer getTrafficBill5(){
		return this.trafficBill5;
	}

	/** 交通费单据5 */
	public void setTrafficBill5(Integer trafficBill5){
		this.trafficBill5 = trafficBill5;
	}
	/** 交通费金额1 */
	public Double getTrafficAmount1(){
		return this.trafficAmount1;
	}

	/** 交通费金额1 */
	public void setTrafficAmount1(Double trafficAmount1){
		this.trafficAmount1 = trafficAmount1;
	}
	/** 交通费金额2 */
	public Double getTrafficAmount2(){
		return this.trafficAmount2;
	}

	/** 交通费金额2 */
	public void setTrafficAmount2(Double trafficAmount2){
		this.trafficAmount2 = trafficAmount2;
	}
	/** 交通费金额3 */
	public Double getTrafficAmount3(){
		return this.trafficAmount3;
	}

	/** 交通费金额3 */
	public void setTrafficAmount3(Double trafficAmount3){
		this.trafficAmount3 = trafficAmount3;
	}
	/** 交通费金额4 */
	public Double getTrafficAmount4(){
		return this.trafficAmount4;
	}

	/** 交通费金额4 */
	public void setTrafficAmount4(Double trafficAmount4){
		this.trafficAmount4 = trafficAmount4;
	}
	/** 交通费金额5 */
	public Double getTrafficAmount5(){
		return this.trafficAmount5;
	}

	/** 交通费金额5 */
	public void setTrafficAmount5(Double trafficAmount5){
		this.trafficAmount5 = trafficAmount5;
	}
	/** 出差补贴天数1 */
	public Integer getSubsidyDay1(){
		return this.subsidyDay1;
	}

	/** 出差补贴天数1 */
	public void setSubsidyDay1(Integer subsidyDay1){
		this.subsidyDay1 = subsidyDay1;
	}
	/** 出差补贴天数2 */
	public Integer getSubsidyDay2(){
		return this.subsidyDay2;
	}

	/** 出差补贴天数2 */
	public void setSubsidyDay2(Integer subsidyDay2){
		this.subsidyDay2 = subsidyDay2;
	}
	/** 出差补贴天数3 */
	public Integer getSubsidyDay3(){
		return this.subsidyDay3;
	}

	/** 出差补贴天数3 */
	public void setSubsidyDay3(Integer subsidyDay3){
		this.subsidyDay3 = subsidyDay3;
	}
	/** 出差补贴天数4 */
	public Integer getSubsidyDay4(){
		return this.subsidyDay4;
	}

	/** 出差补贴天数4 */
	public void setSubsidyDay4(Integer subsidyDay4){
		this.subsidyDay4 = subsidyDay4;
	}
	/** 出差补贴天数5 */
	public Integer getSubsidyDay5(){
		return this.subsidyDay5;
	}

	/** 出差补贴天数5 */
	public void setSubsidyDay5(Integer subsidyDay5){
		this.subsidyDay5 = subsidyDay5;
	}
	/** 出差补贴金额1 */
	public Double getSubsidyAmount1(){
		return this.subsidyAmount1;
	}

	/** 出差补贴金额1 */
	public void setSubsidyAmount1(Double subsidyAmount1){
		this.subsidyAmount1 = subsidyAmount1;
	}
	/** 出差补贴金额2 */
	public Double getSubsidyAmount2(){
		return this.subsidyAmount2;
	}

	/** 出差补贴金额2 */
	public void setSubsidyAmount2(Double subsidyAmount2){
		this.subsidyAmount2 = subsidyAmount2;
	}
	/** 出差补贴金额3 */
	public Double getSubsidyAmount3(){
		return this.subsidyAmount3;
	}

	/** 出差补贴金额3 */
	public void setSubsidyAmount3(Double subsidyAmount3){
		this.subsidyAmount3 = subsidyAmount3;
	}
	/** 出差补贴金额4 */
	public Double getSubsidyAmount4(){
		return this.subsidyAmount4;
	}

	/** 出差补贴金额4 */
	public void setSubsidyAmount4(Double subsidyAmount4){
		this.subsidyAmount4 = subsidyAmount4;
	}
	/** 出差补贴金额5 */
	public Double getSubsidyAmount5(){
		return this.subsidyAmount5;
	}

	/** 出差补贴金额5 */
	public void setSubsidyAmount5(Double subsidyAmount5){
		this.subsidyAmount5 = subsidyAmount5;
	}
	/** 其他费用单据张数1 */
	public Integer getOtherNum1(){
		return this.otherNum1;
	}

	/** 其他费用单据张数1 */
	public void setOtherNum1(Integer otherNum1){
		this.otherNum1 = otherNum1;
	}
	/** 其他费用单据张数2 */
	public Integer getOtherNum2(){
		return this.otherNum2;
	}

	/** 其他费用单据张数2 */
	public void setOtherNum2(Integer otherNum2){
		this.otherNum2 = otherNum2;
	}
	/** 其他费用单据张数3 */
	public Integer getOtherNum3(){
		return this.otherNum3;
	}

	/** 其他费用单据张数3 */
	public void setOtherNum3(Integer otherNum3){
		this.otherNum3 = otherNum3;
	}
	/** 其他费用单据张数4 */
	public Integer getOtherNum4(){
		return this.otherNum4;
	}

	/** 其他费用单据张数4 */
	public void setOtherNum4(Integer otherNum4){
		this.otherNum4 = otherNum4;
	}
	/** 其他费用单据张数5 */
	public Integer getOtherNum5(){
		return this.otherNum5;
	}

	/** 其他费用单据张数5 */
	public void setOtherNum5(Integer otherNum5){
		this.otherNum5 = otherNum5;
	}

	public Double getOtherAmount1() {
		return otherAmount1;
	}

	public void setOtherAmount1(Double otherAmount1) {
		this.otherAmount1 = otherAmount1;
	}

	public Double getOtherAmount2() {
		return otherAmount2;
	}

	public void setOtherAmount2(Double otherAmount2) {
		this.otherAmount2 = otherAmount2;
	}

	public Double getOtherAmount3() {
		return otherAmount3;
	}

	public void setOtherAmount3(Double otherAmount3) {
		this.otherAmount3 = otherAmount3;
	}

	public Double getOtherAmount4() {
		return otherAmount4;
	}

	public void setOtherAmount4(Double otherAmount4) {
		this.otherAmount4 = otherAmount4;
	}

	public Double getOtherAmount5() {
		return otherAmount5;
	}

	public void setOtherAmount5(Double otherAmount5) {
		this.otherAmount5 = otherAmount5;
	}

	/** 合计金额 */
	public Double getMoney(){
		return this.money;
	}

	/** 合计金额 */
	public void setMoney(Double money){
		this.money = money;
	}
	/** 实际出差开始 */
	public Date getActualBegin(){
		return this.actualBegin;
	}

	/** 实际出差开始 */
	public void setActualBegin(Date actualBegin){
		this.actualBegin = actualBegin;
	}
	/** 实际出差结束 */
	public Date getActualEnd(){
		return this.actualEnd;
	}

	/** 实际出差结束 */
	public void setActualEnd(Date actualEnd){
		this.actualEnd = actualEnd;
	}
	/** 报销总额 */
	public Double getReimbursement(){
		return this.reimbursement;
	}

	/** 报销总额 */
	public void setReimbursement(Double reimbursement){
		this.reimbursement = reimbursement;
	}
	/** 预借旅费 */
	public Double getBorrow(){
		return this.borrow;
	}

	/** 预借旅费 */
	public void setBorrow(Double borrow){
		this.borrow = borrow;
	}
	/** 补领金额 */
	public Double getReplacement(){
		return this.replacement;
	}

	/** 补领金额 */
	public void setReplacement(Double replacement){
		this.replacement = replacement;
	}
	/** 退款金额 */
	public Double getRefund(){
		return this.refund;
	}

	/** 退款金额 */
	public void setRefund(Double refund){
		this.refund = refund;
	}
	/** 部门主管（1-同意2-不同意） */
	public Integer getOpinion1(){
		return this.opinion1;
	}

	/** 部门主管（1-同意2-不同意） */
	public void setOpinion1(Integer opinion1){
		this.opinion1 = opinion1;
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
	/** 部门主管签字时间 */
	public Date getDate1(){
		return this.date1;
	}

	/** 部门主管签字时间 */
	public void setDate1(Date date1){
		this.date1 = date1;
	}
	/** 签字人id */
	public String getPeople1(){
		return this.people1;
	}

	/** 签字人id */
	public void setPeople1(String people1){
		this.people1 = people1;
	}
	/** 部门经理（1-同意2-不同意） */
	public Integer getOpinion2(){
		return this.opinion2;
	}

	/** 部门经理（1-同意2-不同意） */
	public void setOpinion2(Integer opinion2){
		this.opinion2 = opinion2;
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
	/** 部门经理签字时间 */
	public Date getDate2(){
		return this.date2;
	}

	/** 部门经理签字时间 */
	public void setDate2(Date date2){
		this.date2 = date2;
	}
	/** 签字人id */
	public String getPeople2(){
		return this.people2;
	}

	/** 签字人id */
	public void setPeople2(String people2){
		this.people2 = people2;
	}
	/** 分管领导（1-同意2-不同意） */
	public Integer getOpinion3(){
		return this.opinion3;
	}

	/** 分管领导（1-同意2-不同意） */
	public void setOpinion3(Integer opinion3){
		this.opinion3 = opinion3;
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
	/** 分管领导签字时间 */
	public Date getDate3(){
		return this.date3;
	}

	/** 分管领导签字时间 */
	public void setDate3(Date date3){
		this.date3 = date3;
	}
	/** 签字人id */
	public String getPeople3(){
		return this.people3;
	}

	/** 签字人id */
	public void setPeople3(String people3){
		this.people3 = people3;
	}
	/** 财务经理（1-同意2-不同意） */
	public Integer getOpinion4(){
		return this.opinion4;
	}

	/** 财务经理（1-同意2-不同意） */
	public void setOpinion4(Integer opinion4){
		this.opinion4 = opinion4;
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
	/** 财务经理签证时间 */
	public Date getDate4(){
		return this.date4;
	}

	/** 财务经理签证时间 */
	public void setDate4(Date date4){
		this.date4 = date4;
	}
	/** 签字人id */
	public String getPeople4(){
		return this.people4;
	}

	/** 签字人id */
	public void setPeople4(String people4){
		this.people4 = people4;
	}
	/** 总经理（1-同意2-不同意） */
	public Integer getOpinion5(){
		return this.opinion5;
	}

	/** 总经理（1-同意2-不同意） */
	public void setOpinion5(Integer opinion5){
		this.opinion5 = opinion5;
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
	/** 总经理签字时间 */
	public Date getDate5(){
		return this.date5;
	}

	/** 总经理签字时间 */
	public void setDate5(Date date5){
		this.date5 = date5;
	}
	/** 签字人id */
	public String getPeople5(){
		return this.people5;
	}

	/** 签字人id */
	public void setPeople5(String people5){
		this.people5 = people5;
	}
	/** 申请状态1-第一步审批，2-第二步审批 */
	public Integer getState(){
		return this.state;
	}

	/** 申请状态1-第一步审批，2-第二步审批 */
	public void setState(Integer state){
		this.state = state;
	}
	/** 0-审批中1-审批通过2-审批失败 */
	public Integer getFlag(){
		return this.flag;
	}

	/** 0-审批中1-审批通过2-审批失败 */
	public void setFlag(Integer flag){
		this.flag = flag;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public Integer getBeginRole() {
		return beginRole;
	}

	public void setBeginRole(Integer beginRole) {
		this.beginRole = beginRole;
	}

	public Date getFillTime() {
		return fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public Integer getFlagPayment() {
		return flagPayment;
	}

	public void setFlagPayment(Integer flagPayment) {
		this.flagPayment = flagPayment;
	}

	public Integer getOpinion6() {
		return opinion6;
	}

	public void setOpinion6(Integer opinion6) {
		this.opinion6 = opinion6;
	}

	public String getSign6() {
		return sign6;
	}

	public void setSign6(String sign6) {
		this.sign6 = sign6;
	}

	public String getText6() {
		return text6;
	}

	public void setText6(String text6) {
		this.text6 = text6;
	}

	public Date getDate6() {
		return date6;
	}

	public void setDate6(Date date6) {
		this.date6 = date6;
	}

	public String getPeople6() {
		return people6;
	}

	public void setPeople6(String people6) {
		this.people6 = people6;
	}

	public Integer getEmergency() {
		return emergency;
	}

	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

}