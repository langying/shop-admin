package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 产品统计
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月02日 下午3:17:32
 */
public class TProductLogEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识
	 */
	private Integer id;
	
	/**
	 * 产品id
	 */
	private Integer productId;

	/**
	 * 产品名称
	 * */
	private String productName;

	private Integer merchantsId;

	private String merchantsName;

	private Integer cooperationType;
	
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
	 * uv收益
	 */
	private Double earnings=0.0;
	
	/**
	 * 日收入
	 */
	private Double income=0.0;

	/**单价*/
	private Double price=0.0;
	
	/**
	 * 注册量
	 */
	private Integer registrations=0;
	
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	
	/**
	 * 创建人id
	 */
	private String createBy;
	
	/**
	 * 修改人id
	 */
	private Date gmtModified;
	
	/**
	 * 修改人id
	 */
	private String updateBy;

	private String content;
	
	/**
	 * 删除标记   0：正常  1：删除
	 */
	private Integer delFlag;

	private Integer pageNumber;

	private Integer pageSize;

	private String name;

	private String startDate;

	private String endDate;

	private String orderNo;

	private Double upPayment=0.0;

	private Double resPayment=0.0;

	private Double wallet=0.0;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public Integer getMerchantsId() {
		return merchantsId;
	}

	public void setMerchantsId(Integer merchantsId) {
		this.merchantsId = merchantsId;
	}

	public String getMerchantsName() {
		return merchantsName;
	}

	public void setMerchantsName(String merchantsName) {
		this.merchantsName = merchantsName;
	}

	public Integer getCooperationType() {
		return cooperationType;
	}

	public void setCooperationType(Integer cooperationType) {
		this.cooperationType = cooperationType;
	}

	public Double getUpPayment() {
		return upPayment;
	}

	public void setUpPayment(Double upPayment) {
		this.upPayment = upPayment;
	}

	public Double getResPayment() {
		return resPayment;
	}

	public void setResPayment(Double resPayment) {
		this.resPayment = resPayment;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TProductLogEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
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
	
	public void setEarnings(Double earnings) {
		this.earnings = earnings;
	}
	
	public Double getEarnings() {
		return earnings;
	}
	
	public void setIncome(Double income) {
		this.income = income;
	}
	
	public Double getIncome() {
		return income;
	}
	
	public void setRegistrations(Integer registrations) {
		this.registrations = registrations;
	}
	
	public Integer getRegistrations() {
		return registrations;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	public Date getGmtModified() {
		return gmtModified;
	}
	
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public String getUpdateBy() {
		return updateBy;
	}
	
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	
	public Integer getDelFlag() {
		return delFlag;
	}
	
}
