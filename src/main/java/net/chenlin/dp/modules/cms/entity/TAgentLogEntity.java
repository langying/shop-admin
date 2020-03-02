package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 渠道的推广统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:20:49
 */
public class TAgentLogEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识
	 */
	private Integer id;
	
	/**
	 * 推广人id
	 */
	private Integer agentId;

	private String agentName;

	private String channelName;

	private Double price=0.0;

	private Double cost=0.0;
	
	/**
	 * 日期
	 */
	private String days;
	
	/**
	 * pv
	 */
	private Integer pv=0;
	
	/**
	 * uv
	 */
	private Integer uv=0;
	
	/**
	 * 今日注册数
	 */
	private Integer registerNum=0;

	/**
	 * 当天登录数
	 */
	private Integer loginNum=0;

	/**
	 * 首次登录数
	 */
	private Integer firstLoginNum=0;

	/**
	 * 登录率
	 */
	private Double loginRate=0.0;

	/**
	 * 立即申请的数量
	 */
	private Integer nowApplyNum=0;

	/**
	 * 立即申请的人数
	 */
	private Integer nowApplyPnum=0;

	/**
	 * 立即申请率
	 */
	private Double nowApplyRate=0.0;

	/**
	 * 成功申请数
	 */
	private Integer applySuccessNum=0;

	/**
	 * 平均我已申请数
	 */
	private Double averageApplySuccessNum=0.0;

	/**
	 * 注册用户平均申请订单数
	 */
	private Double averageRegisterApplyNum=0.0;

	/**七天登录数*/
	private Integer loginSevenNum=0;

	/**APP首次登陆用户平均立即申请订单数 =点击立即 申请数/7天APP首次登陆数*/
	private Double averageSevenApplyNum=0.0;

	/**平均立即申请数*/
	private Double averageNowApplyNum=0.0;

	/**查询字段*/
	private Integer channelId;

	private Double discount=0.0;

	private int initNumber=0;

	private Double realCost=0.0;

	private int settleNumber=0;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;


	private Integer pageNumber;

	private Integer pageSize;

	private String startDate;

	private String endDate;


	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getSettleNumber() {
		return settleNumber;
	}

	public void setSettleNumber(int settleNumber) {
		this.settleNumber = settleNumber;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public TAgentLogEntity() {
		super();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Double getAverageNowApplyNum() {
		return averageNowApplyNum;
	}

	public void setAverageNowApplyNum(Double averageNowApplyNum) {
		this.averageNowApplyNum = averageNowApplyNum;
	}

	public Integer getLoginSevenNum() {
		return loginSevenNum;
	}

	public void setLoginSevenNum(Integer loginSevenNum) {
		this.loginSevenNum = loginSevenNum;
	}

	public Double getAverageSevenApplyNum() {
		return averageSevenApplyNum;
	}

	public void setAverageSevenApplyNum(Double averageSevenApplyNum) {
		this.averageSevenApplyNum = averageSevenApplyNum;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getDays() {
		return days;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public Integer getPv() {
		return pv;
	}

	public void setUv(Integer uv) {
		this.uv = uv;
	}

	public Integer getUv() {
		return uv;
	}

	public void setRegisterNum(Integer registerNum) {
		this.registerNum = registerNum;
	}

	public Integer getRegisterNum() {
		return registerNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	public Integer getLoginNum() {
		return loginNum;
	}

	public void setFirstLoginNum(Integer firstLoginNum) {
		this.firstLoginNum = firstLoginNum;
	}

	public Integer getFirstLoginNum() {
		return firstLoginNum;
	}

	public void setLoginRate(Double loginRate) {
		this.loginRate = loginRate;
	}

	public Double getLoginRate() {
		return loginRate;
	}

	public void setNowApplyNum(Integer nowApplyNum) {
		this.nowApplyNum = nowApplyNum;
	}

	public Integer getNowApplyNum() {
		return nowApplyNum;
	}

	public void setNowApplyPnum(Integer nowApplyPnum) {
		this.nowApplyPnum = nowApplyPnum;
	}

	public Integer getNowApplyPnum() {
		return nowApplyPnum;
	}

	public void setNowApplyRate(Double nowApplyRate) {
		this.nowApplyRate = nowApplyRate;
	}

	public Double getNowApplyRate() {
		return nowApplyRate;
	}

	public void setApplySuccessNum(Integer applySuccessNum) {
		this.applySuccessNum = applySuccessNum;
	}

	public Integer getApplySuccessNum() {
		return applySuccessNum;
	}

	public void setAverageApplySuccessNum(Double averageApplySuccessNum) {
		this.averageApplySuccessNum = averageApplySuccessNum;
	}

	public Double getAverageApplySuccessNum() {
		return averageApplySuccessNum;
	}

	public void setAverageRegisterApplyNum(Double averageRegisterApplyNum) {
		this.averageRegisterApplyNum = averageRegisterApplyNum;
	}

	public Double getAverageRegisterApplyNum() {
		return averageRegisterApplyNum;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getInitNumber() {
		return initNumber;
	}

	public void setInitNumber(int initNumber) {
		this.initNumber = initNumber;
	}

	public Double getRealCost() {
		return realCost;
	}

	public void setRealCost(Double realCost) {
		this.realCost = realCost;
	}
}
