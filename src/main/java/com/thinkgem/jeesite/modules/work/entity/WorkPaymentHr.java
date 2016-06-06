package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 付款申请单
 * 
 * @creator
 * @create-time 2016-03-30 14:42:38
 */
public class WorkPaymentHr implements Serializable{
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
	/** 填写时间 */
	private Date time;
	/** 付款人姓名 */
	private String name;
	/** 付款人 */
	private String drawee;
	/** 付款事由 */
	private String reason;
	/** 收款人户名 */
	private String payeeName;
	/** 收款人账号 */
	private String payeeNumber;
	/** 千 */
	private Integer thousad1;
	/** 付款凭证 */
	private String voucher;
	/** 开户银行 */
	private String bank;
	/** 付款方式 */
	private Integer type;
	/** 人民币大写 */
	private String capital;
	/** 分 */
	private Integer branch;
	/** 角 */
	private Integer horn;
	/** 元 */
	private Integer element;
	/** 十 */
	private Integer ten1;
	/** 百 */
	private Integer hundred1;
	/** 千 */
	private Integer thousand1;
	/** 万 */
	private Integer tenthousand;
	/** 万之上的十 */
	private Integer ten2;
	/** 万之上的百 */
	private Integer hundred2;
	/** 万之上的千 */
	private Integer thousand2;
	/** 分管领导（1-同意2-不同意） */
	private Integer opinion2;
	/** 分管领导签字 */
	private String sign2;
	/** 分管领导意见 */
	private String text2;
	/** 分管领导签字时间 */
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
	/** 财务（1-同意2-不同意） */
	private Integer opinion5;
	/** 财务签字 */
	private String sign5;
	/** 财务意见 */
	private String text5;
	/** 财务签证时间 */
	private Date date5;
	/** 签字人id */
	private String people5;
	/** 部门经理（1-同意2-不同意） */
	private Integer opinion1;
	/** 部门经理签字 */
	private String sign1;
	/** 部门经理意见 */
	private String text1;
	/** 部门经理签字时间 */
	private Date date1;
	/** 签字人id */
	private String people1;
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
	/**付款金额*/
	private Integer money;

	public WorkPaymentHr() {
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
	/** 千 */
	public Integer getThousad1(){
		return this.thousad1;
	}

	/** 千 */
	public void setThousad1(Integer thousad1){
		this.thousad1 = thousad1;
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
	/** 付款方式 */
	public Integer getType(){
		return this.type;
	}

	/** 付款方式 */
	public void setType(Integer type){
		this.type = type;
	}
	/** 人民币大写 */
	public String getCapital(){
		return this.capital;
	}

	/** 人民币大写 */
	public void setCapital(String capital){
		this.capital = capital;
	}
	/** 分 */
	public Integer getBranch(){
		return this.branch;
	}

	/** 分 */
	public void setBranch(Integer branch){
		this.branch = branch;
	}
	/** 角 */
	public Integer getHorn(){
		return this.horn;
	}

	/** 角 */
	public void setHorn(Integer horn){
		this.horn = horn;
	}
	/** 元 */
	public Integer getElement(){
		return this.element;
	}

	/** 元 */
	public void setElement(Integer element){
		this.element = element;
	}
	/** 十 */
	public Integer getTen1(){
		return this.ten1;
	}

	/** 十 */
	public void setTen1(Integer ten1){
		this.ten1 = ten1;
	}
	/** 百 */
	public Integer getHundred1(){
		return this.hundred1;
	}

	/** 百 */
	public void setHundred1(Integer hundred1){
		this.hundred1 = hundred1;
	}
	/** 千 */
	public Integer getThousand1(){
		return this.thousand1;
	}

	/** 千 */
	public void setThousand1(Integer thousand1){
		this.thousand1 = thousand1;
	}
	/** 万 */
	public Integer getTenthousand(){
		return this.tenthousand;
	}

	/** 万 */
	public void setTenthousand(Integer tenthousand){
		this.tenthousand = tenthousand;
	}
	/** 万之上的十 */
	public Integer getTen2(){
		return this.ten2;
	}

	/** 万之上的十 */
	public void setTen2(Integer ten2){
		this.ten2 = ten2;
	}
	/** 万之上的百 */
	public Integer getHundred2(){
		return this.hundred2;
	}

	/** 万之上的百 */
	public void setHundred2(Integer hundred2){
		this.hundred2 = hundred2;
	}
	/** 万之上的千 */
	public Integer getThousand2(){
		return this.thousand2;
	}

	/** 万之上的千 */
	public void setThousand2(Integer thousand2){
		this.thousand2 = thousand2;
	}

	public Integer getOpinion2() {
		return opinion2;
	}

	public void setOpinion2(Integer opinion2) {
		this.opinion2 = opinion2;
	}

	public String getSign2() {
		return sign2;
	}

	public void setSign2(String sign2) {
		this.sign2 = sign2;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getPeople2() {
		return people2;
	}

	public void setPeople2(String people2) {
		this.people2 = people2;
	}

	public Integer getOpinion3() {
		return opinion3;
	}

	public void setOpinion3(Integer opinion3) {
		this.opinion3 = opinion3;
	}

	public String getSign3() {
		return sign3;
	}

	public void setSign3(String sign3) {
		this.sign3 = sign3;
	}

	public String getText3() {
		return text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public String getPeople3() {
		return people3;
	}

	public void setPeople3(String people3) {
		this.people3 = people3;
	}

	public Integer getOpinion4() {
		return opinion4;
	}

	public void setOpinion4(Integer opinion4) {
		this.opinion4 = opinion4;
	}

	public String getSign4() {
		return sign4;
	}

	public void setSign4(String sign4) {
		this.sign4 = sign4;
	}

	public String getText4() {
		return text4;
	}

	public void setText4(String text4) {
		this.text4 = text4;
	}

	public Date getDate4() {
		return date4;
	}

	public void setDate4(Date date4) {
		this.date4 = date4;
	}

	public String getPeople4() {
		return people4;
	}

	public void setPeople4(String people4) {
		this.people4 = people4;
	}

	public Integer getOpinion1() {
		return opinion1;
	}

	public void setOpinion1(Integer opinion1) {
		this.opinion1 = opinion1;
	}

	public String getSign1() {
		return sign1;
	}

	public void setSign1(String sign1) {
		this.sign1 = sign1;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getPeople1() {
		return people1;
	}

	public void setPeople1(String people1) {
		this.people1 = people1;
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getOpinion5() {
		return opinion5;
	}

	public void setOpinion5(Integer opinion5) {
		this.opinion5 = opinion5;
	}

	public String getSign5() {
		return sign5;
	}

	public void setSign5(String sign5) {
		this.sign5 = sign5;
	}

	public String getText5() {
		return text5;
	}

	public void setText5(String text5) {
		this.text5 = text5;
	}

	public Date getDate5() {
		return date5;
	}

	public void setDate5(Date date5) {
		this.date5 = date5;
	}

	public String getPeople5() {
		return people5;
	}

	public void setPeople5(String people5) {
		this.people5 = people5;
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

	public Integer getMoney() {
		Integer money=0;
		if (thousand2!=null) {
			money+=thousand2*10000000;
		}
		if(hundred2!=null){
			money+=hundred2*1000000;
		}
		if(ten2!=null){
			money+=ten2*100000;
		}
		if(tenthousand!=null){
			money+=tenthousand*10000;
		}
		if(tenthousand!=null){
			money+=thousand1*1000;
		}
		if(hundred1!=null){
			money+=hundred1*100;
		}
		if(ten1!=null){
			money+=ten1*10;
		}
		if(element!=null){
			money+=element;
		}
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	
}