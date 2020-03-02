package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 收益分析表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月24日 PM6:05:45
 */
public class TEarningsEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 日期
	 */
	private String days;
	
	/**
	 * 收入
	 */
	private Double income=0.0;
	
	/**
	 * 渠道结算金额
	 */
	private Double realCost=0.0;
	
	/**
	 * 盈利
	 */
	private Double profit=0.0;

	/**
	 * 毛利率
	 *
	 * */
	private Double interRate=0.0;
	
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	

	public TEarningsEntity() {
		super();
	}

	public Double getInterRate() {
		return interRate;
	}

	public void setInterRate(Double interRate) {
		this.interRate = interRate;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setDays(String days) {
		this.days = days;
	}
	
	public String getDays() {
		return days;
	}
	
	public void setIncome(Double income) {
		this.income = income;
	}
	
	public Double getIncome() {
		return income;
	}
	
	public void setRealCost(Double realCost) {
		this.realCost = realCost;
	}
	
	public Double getRealCost() {
		return realCost;
	}
	
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
	public Double getProfit() {
		return profit;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
}
