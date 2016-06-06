package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 价格调整表
 * 
 * @creator
 * @create-time 2016-04-29 15:03:25
 */
public class WorkDjust implements Serializable{
	/**  */
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
	private String name;
	/** 分管领导（1-同意2-不同意） */
	private Integer opinion1;
	/** 分管领导签字 */
	private String sign1;
	/** 分管领导意见 */
	private String text1;
	/** 分管领导签字时间 */
	private Date date1;
	/** 签字人id */
	private String people1;
	/** 财务结算（1-同意2-不同意） */
	private Integer opinion2;
	/** 财务结算签字 */
	private String sign2;
	/** 财务结算意见 */
	private String text2;
	/** 财务结算签字时间 */
	private Date date2;
	/** 签字人id */
	private String people2;
	/** 财务经理（1-同意2-不同意） */
	private Integer opinion3;
	/** 财务经理签字 */
	private String sign3;
	/** 财务经理意见 */
	private String text3;
	/** 财务经理签字时间 */
	private Date date3;
	/** 签字人id */
	private String people3;
	/** 总经理（1-同意2-不同意） */
	private Integer opinion4;
	/** 总经理签字 */
	private String sign4;
	/** 总经理意见 */
	private String text4;
	/** 总经理签证时间 */
	private Date date4;
	/** 签字人id */
	private String people4;
	/** 产品部价格修改确认 */
	private Integer opinion5;
	/** 产品部价格修改确认签字 */
	private String sign5;
	/** 产品部价格修改确认意见 */
	private String text5;
	/** 产品部价格修改确认签字时间 */
	private Date date5;
	/** 签字人id */
	private String people5;
	/** 申请状态1-第一步审批，2-第二步审批 */
	private Integer state;
	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	private Integer flag;
	/** 公司内部自定义的唯一编号 */
	private String transaction;
	/**单据紧急状态标识*/
	private Integer emergency;
	/**审批角色id*/
	private String examination; 
	//非持久化层
	/**部门名字*/
	private String departmentName;
	
	public WorkDjust() {
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
	/** 分管领导（1-同意2-不同意） */
	public Integer getOpinion1(){
		return this.opinion1;
	}

	/** 分管领导（1-同意2-不同意） */
	public void setOpinion1(Integer opinion1){
		this.opinion1 = opinion1;
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
	/** 分管领导签字时间 */
	public Date getDate1(){
		return this.date1;
	}

	/** 分管领导签字时间 */
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
	/** 财务结算（1-同意2-不同意） */
	public Integer getOpinion2(){
		return this.opinion2;
	}

	/** 财务结算（1-同意2-不同意） */
	public void setOpinion2(Integer opinion2){
		this.opinion2 = opinion2;
	}
	/** 财务结算签字 */
	public String getSign2(){
		return this.sign2;
	}

	/** 财务结算签字 */
	public void setSign2(String sign2){
		this.sign2 = sign2;
	}
	/** 财务结算意见 */
	public String getText2(){
		return this.text2;
	}

	/** 财务结算意见 */
	public void setText2(String text2){
		this.text2 = text2;
	}
	/** 财务结算签字时间 */
	public Date getDate2(){
		return this.date2;
	}

	/** 财务结算签字时间 */
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
	/** 财务经理（1-同意2-不同意） */
	public Integer getOpinion3(){
		return this.opinion3;
	}

	/** 财务经理（1-同意2-不同意） */
	public void setOpinion3(Integer opinion3){
		this.opinion3 = opinion3;
	}
	/** 财务经理签字 */
	public String getSign3(){
		return this.sign3;
	}

	/** 财务经理签字 */
	public void setSign3(String sign3){
		this.sign3 = sign3;
	}
	/** 财务经理意见 */
	public String getText3(){
		return this.text3;
	}

	/** 财务经理意见 */
	public void setText3(String text3){
		this.text3 = text3;
	}
	/** 财务经理签字时间 */
	public Date getDate3(){
		return this.date3;
	}

	/** 财务经理签字时间 */
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
	/** 总经理（1-同意2-不同意） */
	public Integer getOpinion4(){
		return this.opinion4;
	}

	/** 总经理（1-同意2-不同意） */
	public void setOpinion4(Integer opinion4){
		this.opinion4 = opinion4;
	}
	/** 总经理签字 */
	public String getSign4(){
		return this.sign4;
	}

	/** 总经理签字 */
	public void setSign4(String sign4){
		this.sign4 = sign4;
	}
	/** 总经理意见 */
	public String getText4(){
		return this.text4;
	}

	/** 总经理意见 */
	public void setText4(String text4){
		this.text4 = text4;
	}
	/** 总经理签证时间 */
	public Date getDate4(){
		return this.date4;
	}

	/** 总经理签证时间 */
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
	/** 产品部价格修改确认 */
	public Integer getOpinion5(){
		return this.opinion5;
	}

	/** 产品部价格修改确认 */
	public void setOpinion5(Integer opinion5){
		this.opinion5 = opinion5;
	}
	/** 产品部价格修改确认签字 */
	public String getSign5(){
		return this.sign5;
	}

	/** 产品部价格修改确认签字 */
	public void setSign5(String sign5){
		this.sign5 = sign5;
	}
	/** 产品部价格修改确认意见 */
	public String getText5(){
		return this.text5;
	}

	/** 产品部价格修改确认意见 */
	public void setText5(String text5){
		this.text5 = text5;
	}
	/** 产品部价格修改确认签字时间 */
	public Date getDate5(){
		return this.date5;
	}

	/** 产品部价格修改确认签字时间 */
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
	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	public Integer getFlag(){
		return this.flag;
	}

	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	public void setFlag(Integer flag){
		this.flag = flag;
	}
	/** 公司内部自定义的唯一编号 */
	public String getTransaction(){
		return this.transaction;
	}

	/** 公司内部自定义的唯一编号 */
	public void setTransaction(String transaction){
		this.transaction = transaction;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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