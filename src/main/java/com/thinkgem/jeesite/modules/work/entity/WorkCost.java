package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 费用报销单
 * 
 * @creator
 * @create-time 2016-04-19 15:47:01
 */
public class WorkCost implements Serializable{
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
	/** 名字 */
	private String name;
	/** 报销日期 */
	private Date time;
	/** 摘要 */
	private String abstract1;
	/** 金额 */
	private Integer money11;
	/** 金额 */
	private Integer money12;
	/** 金额 */
	private Integer money13;
	/** 金额 */
	private Integer money14;
	/** 金额 */
	private Integer money15;
	/** 金额 */
	private Integer money16;
	/** 金额 */
	private Integer money17;
	/** 金额 */
	private Integer money18;
	/** 科目1 */
	private String subject1;
	/** 单据张数 */
	private Integer num1;
	/**  */
	private String abstract2;
	/**  */
	private Integer money21;
	/**  */
	private Integer money22;
	/**  */
	private Integer money23;
	/**  */
	private Integer money24;
	/**  */
	private Integer money25;
	/**  */
	private Integer money26;
	/**  */
	private Integer money27;
	/**  */
	private Integer money28;
	/**  */
	private String subject2;
	/**  */
	private Integer num2;
	/**  */
	private String abstract3;
	/**  */
	private Integer money31;
	/**  */
	private Integer money32;
	/**  */
	private Integer money33;
	/**  */
	private Integer money34;
	/**  */
	private Integer money35;
	/**  */
	private Integer money36;
	/**  */
	private Integer money37;
	/**  */
	private Integer money38;
	/**  */
	private String subject3;
	/**  */
	private Integer num3;
	/**  */
	private String abstract4;
	/**  */
	private Integer money41;
	/**  */
	private Integer money42;
	/**  */
	private Integer money43;
	/**  */
	private Integer money44;
	/**  */
	private Integer money45;
	/**  */
	private Integer money46;
	/**  */
	private Integer money47;
	/**  */
	private Integer money48;
	/**  */
	private String subject4;
	/**  */
	private Integer num4;
	/**  */
	private String abstract5;
	/**  */
	private Integer money51;
	/**  */
	private Integer money52;
	/**  */
	private Integer money53;
	/**  */
	private Integer money54;
	/**  */
	private Integer money55;
	/**  */
	private Integer money56;
	/**  */
	private Integer money57;
	/**  */
	private Integer money58;
	/**  */
	private String subject5;
	/**  */
	private Integer num5;
	/**  */
	private String abstract6;
	/**  */
	private Integer money61;
	/**  */
	private Integer money62;
	/**  */
	private Integer money63;
	/**  */
	private Integer money64;
	/**  */
	private Integer money65;
	/**  */
	private Integer money66;
	/**  */
	private Integer money67;
	/**  */
	private Integer money68;
	/**  */
	private String subject6;
	/**  */
	private Integer num6;
	/** 人民币合计（大写） */
	private String capital;
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
	/** 人力行政（1-同意2-不同意） */
	private Integer opinion3;
	/** 人力行政签字 */
	private String sign3;
	/** 人力行政意见 */
	private String text3;
	/** 人力行政签字时间 */
	private Date date3;
	/** 签字人id */
	private String people3;
	/** 财务（1-同意2-不同意） */
	private Integer opinion4;
	/** 财务签字 */
	private String sign4;
	/** 财务意见 */
	private String text4;
	/** 财务签证时间 */
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
	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	private Integer flag;
	/** 公司内部唯一编号 */
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

	public WorkCost() {
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
	/** 名字 */
	public String getName(){
		return this.name;
	}

	/** 名字 */
	public void setName(String name){
		this.name = name;
	}
	/** 报销日期 */
	public Date getTime(){
		return this.time;
	}

	/** 报销日期 */
	public void setTime(Date time){
		this.time = time;
	}
	/** 摘要 */
	public String getAbstract1(){
		return this.abstract1;
	}

	/** 摘要 */
	public void setAbstract1(String abstract1){
		this.abstract1 = abstract1;
	}
	/** 金额 */
	public Integer getMoney11(){
		return this.money11;
	}

	/** 金额 */
	public void setMoney11(Integer money11){
		this.money11 = money11;
	}
	/** 金额 */
	public Integer getMoney12(){
		return this.money12;
	}

	/** 金额 */
	public void setMoney12(Integer money12){
		this.money12 = money12;
	}
	/** 金额 */
	public Integer getMoney13(){
		return this.money13;
	}

	/** 金额 */
	public void setMoney13(Integer money13){
		this.money13 = money13;
	}
	/** 金额 */
	public Integer getMoney14(){
		return this.money14;
	}

	/** 金额 */
	public void setMoney14(Integer money14){
		this.money14 = money14;
	}
	/** 金额 */
	public Integer getMoney15(){
		return this.money15;
	}

	/** 金额 */
	public void setMoney15(Integer money15){
		this.money15 = money15;
	}
	/** 金额 */
	public Integer getMoney16(){
		return this.money16;
	}

	/** 金额 */
	public void setMoney16(Integer money16){
		this.money16 = money16;
	}
	/** 金额 */
	public Integer getMoney17(){
		return this.money17;
	}

	/** 金额 */
	public void setMoney17(Integer money17){
		this.money17 = money17;
	}
	/** 金额 */
	public Integer getMoney18(){
		return this.money18;
	}

	/** 金额 */
	public void setMoney18(Integer money18){
		this.money18 = money18;
	}
	/** 科目1 */
	public String getSubject1(){
		return this.subject1;
	}

	/** 科目1 */
	public void setSubject1(String subject1){
		this.subject1 = subject1;
	}
	/** 单据张数 */
	public Integer getNum1(){
		return this.num1;
	}

	/** 单据张数 */
	public void setNum1(Integer num1){
		this.num1 = num1;
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
	public Integer getMoney21(){
		return this.money21;
	}

	/**  */
	public void setMoney21(Integer money21){
		this.money21 = money21;
	}
	/**  */
	public Integer getMoney22(){
		return this.money22;
	}

	/**  */
	public void setMoney22(Integer money22){
		this.money22 = money22;
	}
	/**  */
	public Integer getMoney23(){
		return this.money23;
	}

	/**  */
	public void setMoney23(Integer money23){
		this.money23 = money23;
	}
	/**  */
	public Integer getMoney24(){
		return this.money24;
	}

	/**  */
	public void setMoney24(Integer money24){
		this.money24 = money24;
	}
	/**  */
	public Integer getMoney25(){
		return this.money25;
	}

	/**  */
	public void setMoney25(Integer money25){
		this.money25 = money25;
	}
	/**  */
	public Integer getMoney26(){
		return this.money26;
	}

	/**  */
	public void setMoney26(Integer money26){
		this.money26 = money26;
	}
	/**  */
	public Integer getMoney27(){
		return this.money27;
	}

	/**  */
	public void setMoney27(Integer money27){
		this.money27 = money27;
	}
	/**  */
	public Integer getMoney28(){
		return this.money28;
	}

	/**  */
	public void setMoney28(Integer money28){
		this.money28 = money28;
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
	public Integer getNum2(){
		return this.num2;
	}

	/**  */
	public void setNum2(Integer num2){
		this.num2 = num2;
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
	public Integer getMoney31(){
		return this.money31;
	}

	/**  */
	public void setMoney31(Integer money31){
		this.money31 = money31;
	}
	/**  */
	public Integer getMoney32(){
		return this.money32;
	}

	/**  */
	public void setMoney32(Integer money32){
		this.money32 = money32;
	}
	/**  */
	public Integer getMoney33(){
		return this.money33;
	}

	/**  */
	public void setMoney33(Integer money33){
		this.money33 = money33;
	}
	/**  */
	public Integer getMoney34(){
		return this.money34;
	}

	/**  */
	public void setMoney34(Integer money34){
		this.money34 = money34;
	}
	/**  */
	public Integer getMoney35(){
		return this.money35;
	}

	/**  */
	public void setMoney35(Integer money35){
		this.money35 = money35;
	}
	/**  */
	public Integer getMoney36(){
		return this.money36;
	}

	/**  */
	public void setMoney36(Integer money36){
		this.money36 = money36;
	}
	/**  */
	public Integer getMoney37(){
		return this.money37;
	}

	/**  */
	public void setMoney37(Integer money37){
		this.money37 = money37;
	}
	/**  */
	public Integer getMoney38(){
		return this.money38;
	}

	/**  */
	public void setMoney38(Integer money38){
		this.money38 = money38;
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
	public Integer getNum3(){
		return this.num3;
	}

	/**  */
	public void setNum3(Integer num3){
		this.num3 = num3;
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
	public Integer getMoney41(){
		return this.money41;
	}

	/**  */
	public void setMoney41(Integer money41){
		this.money41 = money41;
	}
	/**  */
	public Integer getMoney42(){
		return this.money42;
	}

	/**  */
	public void setMoney42(Integer money42){
		this.money42 = money42;
	}
	/**  */
	public Integer getMoney43(){
		return this.money43;
	}

	/**  */
	public void setMoney43(Integer money43){
		this.money43 = money43;
	}
	/**  */
	public Integer getMoney44(){
		return this.money44;
	}

	/**  */
	public void setMoney44(Integer money44){
		this.money44 = money44;
	}
	/**  */
	public Integer getMoney45(){
		return this.money45;
	}

	/**  */
	public void setMoney45(Integer money45){
		this.money45 = money45;
	}
	/**  */
	public Integer getMoney46(){
		return this.money46;
	}

	/**  */
	public void setMoney46(Integer money46){
		this.money46 = money46;
	}
	/**  */
	public Integer getMoney47(){
		return this.money47;
	}

	/**  */
	public void setMoney47(Integer money47){
		this.money47 = money47;
	}
	/**  */
	public Integer getMoney48(){
		return this.money48;
	}

	/**  */
	public void setMoney48(Integer money48){
		this.money48 = money48;
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
	public Integer getNum4(){
		return this.num4;
	}

	/**  */
	public void setNum4(Integer num4){
		this.num4 = num4;
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
	public Integer getMoney51(){
		return this.money51;
	}

	/**  */
	public void setMoney51(Integer money51){
		this.money51 = money51;
	}
	/**  */
	public Integer getMoney52(){
		return this.money52;
	}

	/**  */
	public void setMoney52(Integer money52){
		this.money52 = money52;
	}
	/**  */
	public Integer getMoney53(){
		return this.money53;
	}

	/**  */
	public void setMoney53(Integer money53){
		this.money53 = money53;
	}
	/**  */
	public Integer getMoney54(){
		return this.money54;
	}

	/**  */
	public void setMoney54(Integer money54){
		this.money54 = money54;
	}
	/**  */
	public Integer getMoney55(){
		return this.money55;
	}

	/**  */
	public void setMoney55(Integer money55){
		this.money55 = money55;
	}
	/**  */
	public Integer getMoney56(){
		return this.money56;
	}

	/**  */
	public void setMoney56(Integer money56){
		this.money56 = money56;
	}
	/**  */
	public Integer getMoney57(){
		return this.money57;
	}

	/**  */
	public void setMoney57(Integer money57){
		this.money57 = money57;
	}
	/**  */
	public Integer getMoney58(){
		return this.money58;
	}

	/**  */
	public void setMoney58(Integer money58){
		this.money58 = money58;
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
	public Integer getNum5(){
		return this.num5;
	}

	/**  */
	public void setNum5(Integer num5){
		this.num5 = num5;
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
	public Integer getMoney61(){
		return this.money61;
	}

	/**  */
	public void setMoney61(Integer money61){
		this.money61 = money61;
	}
	/**  */
	public Integer getMoney62(){
		return this.money62;
	}

	/**  */
	public void setMoney62(Integer money62){
		this.money62 = money62;
	}
	/**  */
	public Integer getMoney63(){
		return this.money63;
	}

	/**  */
	public void setMoney63(Integer money63){
		this.money63 = money63;
	}
	/**  */
	public Integer getMoney64(){
		return this.money64;
	}

	/**  */
	public void setMoney64(Integer money64){
		this.money64 = money64;
	}
	/**  */
	public Integer getMoney65(){
		return this.money65;
	}

	/**  */
	public void setMoney65(Integer money65){
		this.money65 = money65;
	}
	/**  */
	public Integer getMoney66(){
		return this.money66;
	}

	/**  */
	public void setMoney66(Integer money66){
		this.money66 = money66;
	}
	/**  */
	public Integer getMoney67(){
		return this.money67;
	}

	/**  */
	public void setMoney67(Integer money67){
		this.money67 = money67;
	}
	/**  */
	public Integer getMoney68(){
		return this.money68;
	}

	/**  */
	public void setMoney68(Integer money68){
		this.money68 = money68;
	}
	/**  */
	public String getSubject6(){
		return this.subject6;
	}

	/**  */
	public void setSubject6(String subject6){
		this.subject6 = subject6;
	}
	/**  */
	public Integer getNum6(){
		return this.num6;
	}

	/**  */
	public void setNum6(Integer num6){
		this.num6 = num6;
	}
	/** 人民币合计（大写） */
	public String getCapital(){
		return this.capital;
	}

	/** 人民币合计（大写） */
	public void setCapital(String capital){
		this.capital = capital;
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
	/** 部门经理签字时间 */
	public Date getDate1(){
		return this.date1;
	}

	/** 部门经理签字时间 */
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
	/** 分管领导（1-同意2-不同意） */
	public Integer getOpinion2(){
		return this.opinion2;
	}

	/** 分管领导（1-同意2-不同意） */
	public void setOpinion2(Integer opinion2){
		this.opinion2 = opinion2;
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
	/** 分管领导签字时间 */
	public Date getDate2(){
		return this.date2;
	}

	/** 分管领导签字时间 */
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
	/** 人力行政（1-同意2-不同意） */
	public Integer getOpinion3(){
		return this.opinion3;
	}

	/** 人力行政（1-同意2-不同意） */
	public void setOpinion3(Integer opinion3){
		this.opinion3 = opinion3;
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
	/** 人力行政签字时间 */
	public Date getDate3(){
		return this.date3;
	}

	/** 人力行政签字时间 */
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
	/** 财务（1-同意2-不同意） */
	public Integer getOpinion4(){
		return this.opinion4;
	}

	/** 财务（1-同意2-不同意） */
	public void setOpinion4(Integer opinion4){
		this.opinion4 = opinion4;
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
	/** 财务签证时间 */
	public Date getDate4(){
		return this.date4;
	}

	/** 财务签证时间 */
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
	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	public Integer getFlag(){
		return this.flag;
	}

	/** 0-审批中1-审批通过2-审批失败3-已终止 */
	public void setFlag(Integer flag){
		this.flag = flag;
	}
	/** 公司内部唯一编号 */
	public String getTransaction(){
		return this.transaction;
	}

	/** 公司内部唯一编号 */
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