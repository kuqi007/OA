package com.thinkgem.jeesite.modules.work.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 价格调整表详情
 * 
 * @creator
 * @create-time 2016-05-03 14:15:25
 */
public class WorkDjustDetails implements Serializable{
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
	/** e得货号 */
	private String ehavingid;
	/** 商品品牌 */
	private String brand;
	/** 供应商 */
	private String supplier;
	/** 商品名称 */
	private String name;
	/** 规格/型号 */
	private String specifications;
	/** 原供货价 */
	private Double priceOld;
	/** 现供货价 */
	private Double priceNew;
	/** 上调/下调% */
	private Double percentage;
	/** 原e得价 */
	private Double onpriceOld;
	/** 现e得价 */
	private Double onpriceNew;
	/** 上调/下调% */
	private Double onpercentage;
	/** 申请原因 */
	private String reason;
	/** 调整日期 */
	private Date time;
	/** 价格调整表id */
	private String djustid;
	//非持久化层
	/**部门名字*/
	private String departmentName;

	public WorkDjustDetails() {
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
	/** e得货号 */
	public String getEhavingid(){
		return this.ehavingid;
	}

	/** e得货号 */
	public void setEhavingid(String ehavingid){
		this.ehavingid = ehavingid;
	}
	/** 商品品牌 */
	public String getBrand(){
		return this.brand;
	}

	/** 商品品牌 */
	public void setBrand(String brand){
		this.brand = brand;
	}
	/** 供应商 */
	public String getSupplier(){
		return this.supplier;
	}

	/** 供应商 */
	public void setSupplier(String supplier){
		this.supplier = supplier;
	}
	/** 商品名称 */
	public String getName(){
		return this.name;
	}

	/** 商品名称 */
	public void setName(String name){
		this.name = name;
	}
	/** 规格/型号 */
	public String getSpecifications(){
		return this.specifications;
	}

	/** 规格/型号 */
	public void setSpecifications(String specifications){
		this.specifications = specifications;
	}
	/** 原供货价 */
	public Double getPriceOld(){
		return this.priceOld;
	}

	/** 原供货价 */
	public void setPriceOld(Double priceOld){
		this.priceOld = priceOld;
	}
	/** 现供货价 */
	public Double getPriceNew(){
		return this.priceNew;
	}

	/** 现供货价 */
	public void setPriceNew(Double priceNew){
		this.priceNew = priceNew;
	}
	/** 上调/下调% */
	public Double getPercentage(){
		return this.percentage;
	}

	/** 上调/下调% */
	public void setPercentage(Double percentage){
		this.percentage = percentage;
	}
	/** 原e得价 */
	public Double getOnpriceOld(){
		return this.onpriceOld;
	}

	/** 原e得价 */
	public void setOnpriceOld(Double onpriceOld){
		this.onpriceOld = onpriceOld;
	}
	/** 现e得价 */
	public Double getOnpriceNew(){
		return this.onpriceNew;
	}

	/** 现e得价 */
	public void setOnpriceNew(Double onpriceNew){
		this.onpriceNew = onpriceNew;
	}
	/** 上调/下调% */
	public Double getOnpercentage(){
		return this.onpercentage;
	}

	/** 上调/下调% */
	public void setOnpercentage(Double onpercentage){
		this.onpercentage = onpercentage;
	}
	/** 申请原因 */
	public String getReason(){
		return this.reason;
	}

	/** 申请原因 */
	public void setReason(String reason){
		this.reason = reason;
	}
	/** 调整日期 */
	public Date getTime(){
		return this.time;
	}

	/** 调整日期 */
	public void setTime(Date time){
		this.time = time;
	}
	/** 价格调整表id */
	public String getDjustid(){
		return this.djustid;
	}

	/** 价格调整表id */
	public void setDjustid(String djustid){
		this.djustid = djustid;
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
	
}