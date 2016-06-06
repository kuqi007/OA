package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 积分撤销申请表
 * 
 * @creator
 * @create-time 2016-05-05 09:31:23
 */
public class WorkIntegral implements Serializable{
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
	/** 申请人名字 */
	private String name;
	/** 会员名字 */
	private String uname;
	/** 交易号 */
	private String number;
	/** 身份证号 */
	private String card;
	/** 积分数量 */
	private Double uintegral;
	/** 会员单位名称 */
	private String unitname;
	/** 联系电话 */
	private String telephone;
	/** 退款数量 */
	private Double refund;
	/** 备注 */
	private String remarks;
	/** it部门冻结（1-同意2-不同意） */
	private Integer opinion1;
	/** 经办人签字 */
	private String sign1;
	/** 经办人意见 */
	private String text1;
	/** 经办人签字时间 */
	private Date date1;
	/** 签字人id */
	private String people1;
	/** 客服回访结果（1-同意2-不同意） */
	private Integer opinion2;
	/** 客服签字 */
	private String sign2;
	/** 客服意见 */
	private String text2;
	/** 客服签字时间 */
	private Date date2;
	/** 签字人id */
	private String people2;
	/** 客服回访结果（1-同意2-不同意） */
	private Integer opinion2_5;
	/** 客服签字 */
	private String sign2_5;
	/** 客服意见 */
	private String text2_5;
	/** 客服签字时间 */
	private Date date2_5;
	/** 签字人id */
	private String people2_5;
	/** it部门解冻（1-同意2-不同意） */
	private Integer opinion3;
	/** it部门解冻签字 */
	private String sign3;
	/** it部门解冻意见 */
	private String text3;
	/** it部门解冻签字时间 */
	private Date date3;
	/** 签字人id */
	private String people3;
	/** 分管领导（1-同意2-不同意） */
	private Integer opinion4;
	/** 分管领导签字 */
	private String sign4;
	/** 分管领导意见 */
	private String text4;
	/** 分管领导签证时间 */
	private Date date4;
	/** 签字人id */
	private String people4;
	/** 财务经理（1-同意2-不同意） */
	private Integer opinion5;
	/** 财务经理签字 */
	private String sign5;
	/** 财务经理意见 */
	private String text5;
	/** 财务经理签字时间 */
	private Date date5;
	/** 签字人id */
	private String people5;
	/** it积分清零并解冻（1-同意2-不同意） */
	private Integer opinion6;
	/** it积分清零并解冻签字 */
	private String sign6;
	/** it积分清零并解冻意见 */
	private String text6;
	/** it积分清零并解冻签字时间 */
	private Date date6;
	/** 签字人id */
	private String people6;
	/** 会服确认（1-同意2-不同意） */
	private Integer opinion7;
	/** 会服确认签字 */
	private String sign7;
	/** 会服确认意见 */
	private String text7;
	/** 会服确认签字时间 */
	private Date date7;
	/** 签字人id */
	private String people7;
	/** 申请状态1-第一步审批，2-第二步审批 */
	private Integer state;
	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	private Integer flag;
	/** 0-未入档1-已入档 */
	private Integer record;
	/** 0-未冻结1-已冻结 */
	private Integer frozen;
	/** 公司内部自定义的唯一编号 */
	private String transaction;
	/**单据紧急状态标识*/
	private Integer emergency;
	/**审批角色id*/
	private String examination; 
	private String integralImage;
	//非持久化层
	/**部门名字*/
	private String departmentName;

	public WorkIntegral() {
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
	/** 积分数量 */
	public Double getUintegral(){
		return this.uintegral;
	}

	/** 积分数量 */
	public void setUintegral(Double uintegral){
		this.uintegral = uintegral;
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
	/** 退款数量 */
	public Double getRefund(){
		return this.refund;
	}

	/** 退款数量 */
	public void setRefund(Double refund){
		this.refund = refund;
	}
	/** 备注 */
	public String getRemarks(){
		return this.remarks;
	}

	/** 备注 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/** it部门冻结（1-同意2-不同意） */
	public Integer getOpinion1(){
		return this.opinion1;
	}

	/** it部门冻结（1-同意2-不同意） */
	public void setOpinion1(Integer opinion1){
		this.opinion1 = opinion1;
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
	/** 经办人签字时间 */
	public Date getDate1(){
		return this.date1;
	}

	/** 经办人签字时间 */
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
	/** 客服回访结果（1-同意2-不同意） */
	public Integer getOpinion2(){
		return this.opinion2;
	}

	/** 客服回访结果（1-同意2-不同意） */
	public void setOpinion2(Integer opinion2){
		this.opinion2 = opinion2;
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
	/** 客服签字时间 */
	public Date getDate2(){
		return this.date2;
	}

	/** 客服签字时间 */
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
	
	public Integer getOpinion2_5() {
		return opinion2_5;
	}

	public void setOpinion2_5(Integer opinion2_5) {
		this.opinion2_5 = opinion2_5;
	}

	public String getSign2_5() {
		return sign2_5;
	}

	public void setSign2_5(String sign2_5) {
		this.sign2_5 = sign2_5;
	}

	public String getText2_5() {
		return text2_5;
	}

	public void setText2_5(String text2_5) {
		this.text2_5 = text2_5;
	}

	public Date getDate2_5() {
		return date2_5;
	}

	public void setDate2_5(Date date2_5) {
		this.date2_5 = date2_5;
	}

	public String getPeople2_5() {
		return people2_5;
	}

	public void setPeople2_5(String people2_5) {
		this.people2_5 = people2_5;
	}

	/** it部门解冻（1-同意2-不同意） */
	public Integer getOpinion3(){
		return this.opinion3;
	}

	/** it部门解冻（1-同意2-不同意） */
	public void setOpinion3(Integer opinion3){
		this.opinion3 = opinion3;
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
	/** it部门解冻签字时间 */
	public Date getDate3(){
		return this.date3;
	}

	/** it部门解冻签字时间 */
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
	/** 分管领导（1-同意2-不同意） */
	public Integer getOpinion4(){
		return this.opinion4;
	}

	/** 分管领导（1-同意2-不同意） */
	public void setOpinion4(Integer opinion4){
		this.opinion4 = opinion4;
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
	/** 分管领导签证时间 */
	public Date getDate4(){
		return this.date4;
	}

	/** 分管领导签证时间 */
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
	/** 财务经理（1-同意2-不同意） */
	public Integer getOpinion5(){
		return this.opinion5;
	}

	/** 财务经理（1-同意2-不同意） */
	public void setOpinion5(Integer opinion5){
		this.opinion5 = opinion5;
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
	/** 财务经理签字时间 */
	public Date getDate5(){
		return this.date5;
	}

	/** 财务经理签字时间 */
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
	/** it积分清零并解冻（1-同意2-不同意） */
	public Integer getOpinion6(){
		return this.opinion6;
	}

	/** it积分清零并解冻（1-同意2-不同意） */
	public void setOpinion6(Integer opinion6){
		this.opinion6 = opinion6;
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
	/** it积分清零并解冻签字时间 */
	public Date getDate6(){
		return this.date6;
	}

	/** it积分清零并解冻签字时间 */
	public void setDate6(Date date6){
		this.date6 = date6;
	}
	/** 签字人id */
	public String getPeople6(){
		return this.people6;
	}

	/** 签字人id */
	public void setPeople6(String people6){
		this.people6 = people6;
	}
	/** 会服确认（1-同意2-不同意） */
	public Integer getOpinion7(){
		return this.opinion7;
	}

	/** 会服确认（1-同意2-不同意） */
	public void setOpinion7(Integer opinion7){
		this.opinion7 = opinion7;
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
	/** 会服确认签字时间 */
	public Date getDate7(){
		return this.date7;
	}

	/** 会服确认签字时间 */
	public void setDate7(Date date7){
		this.date7 = date7;
	}
	/** 签字人id */
	public String getPeople7(){
		return this.people7;
	}

	/** 签字人id */
	public void setPeople7(String people7){
		this.people7 = people7;
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
	/** 0-未入档1-已入档 */
	public Integer getRecord(){
		return this.record;
	}

	/** 0-未入档1-已入档 */
	public void setRecord(Integer record){
		this.record = record;
	}
	/** 0-未冻结1-已冻结 */
	public Integer getFrozen(){
		return this.frozen;
	}

	/** 0-未冻结1-已冻结 */
	public void setFrozen(Integer frozen){
		this.frozen = frozen;
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

	public String getIntegralImage() {
		return integralImage;
	}

	public void setIntegralImage(String integralImage) {
		this.integralImage = integralImage;
	}
	
}