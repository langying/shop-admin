package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 渠道月统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年12月08日 下午8:57:02
 */
public class TChannelLogEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识
	 */
	private Integer id;
	
	/**
	 * 渠道id
	 */
	private Integer channelId;

	/**
	 * 渠道名称
	 * */
	private String channelName;

	/**公司名称
	 *
	 * */
	private String company;


	
	/**
	 * 单价
	 */
	private Double price;
	
	/**
	 * 月份
	 */
	private String days;
	
	/**
	 * 渠道结算数据
	 */
	private Integer settleNumber;
	
	/**
	 * 结算金额
	 */
	private Double realCost;

	/**
	 * 对接人
	 *
	 * */
	private String userName;
	
	/**
	 * 
	 */
	private Date gmtCreate;
	

	public TChannelLogEntity() {
		super();
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	
	public Integer getChannelId() {
		return channelId;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setDays(String days) {
		this.days = days;
	}
	
	public String getDays() {
		return days;
	}
	
	public void setSettleNumber(Integer settleNumber) {
		this.settleNumber = settleNumber;
	}
	
	public Integer getSettleNumber() {
		return settleNumber;
	}
	
	public void setRealCost(Double realCost) {
		this.realCost = realCost;
	}
	
	public Double getRealCost() {
		return realCost;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
}
