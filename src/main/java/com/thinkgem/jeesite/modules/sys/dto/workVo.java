package com.thinkgem.jeesite.modules.sys.dto;

import java.util.Date;

/**
 * songJian 2016-3-21 待审单据显示
 * */
public class workVo{
	/**单据id*/
	private String id;
	/**单据类型*/
	private String billType;
	/**单据编号*/
	private String number;
	/**单据创建时间*/
	private Date time;
	/**单据链接*/
	private String urls;
	/**单据紧急状态*/
	private Integer emergency;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public Integer getEmergency() {
		return emergency;
	}
	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}
	
}
