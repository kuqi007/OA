package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 办公用品申请表
 * 
 * @creator
 * @create-time 2016-04-28 09:24:04
 */
public class WorkApply implements Serializable{
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
	/** 职务id */
	private String post;
	/** 名字 */
	private String name;
	/** 部门经理（1-同意2-不同意） */
	private Integer opinion1;
	/** 部门经理签字 */
	private String sign1;
	/** 部门经理意见 */
	private String text1;
	/** 部门主管签字时间 */
	private Date date1;
	/** 签字人id */
	private String people1;
	/** 人力行政（1-同意2-不同意） */
	private Integer opinion2;
	/** 人力行政签字 */
	private String sign2;
	/** 人力行政意见 */
	private String text2;
	/** 人力行政签字时间 */
	private Date date2;
	private String people2;
	/** 申请状态1-第一步审批，2-第二步审批 */
	private Integer state;
	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	private Integer flag;
	/** 公司内部自定义的唯一编号 */
	private String transaction;
	/** 备注 */
	private String remarks;
	/**单据紧急状态标识*/
	private Integer emergency;
	/**审批角色id*/
	private String examination; 
	//非持久化层
	/**部门名字*/
	private String departmentName;

	public WorkApply() {
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
	/** 部门经理（1-同意2-不同意） */
	public Integer getOpinion1(){
		return this.opinion1;
	}

	/** 部门经理（1-同意2-不同意） */
	public void setOpinion1(Integer opinion1){
		this.opinion1 = opinion1;
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
	/** 人力行政（1-同意2-不同意） */
	public Integer getOpinion2(){
		return this.opinion2;
	}

	/** 人力行政（1-同意2-不同意） */
	public void setOpinion2(Integer opinion2){
		this.opinion2 = opinion2;
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
	/** 人力行政签字时间 */
	public Date getDate2(){
		return this.date2;
	}

	/** 人力行政签字时间 */
	public void setDate2(Date date2){
		this.date2 = date2;
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
	/** 备注 */
	public String getRemarks(){
		return this.remarks;
	}

	/** 备注 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
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

	public String getPeople2() {
		return people2;
	}

	public void setPeople2(String people2) {
		this.people2 = people2;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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