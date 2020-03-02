package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 商户表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年11月04日 PM11:38:07
 */
public class TMerchantsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	private Integer id;

	/**
	 * 商户名称
	 */
	private String name;

	/**
	 * 公司名称
	 */
	private String company;

	/**
	 * 联系方式
	 */
	private String contact;

	/**
	 * 联系电话
	 */
	private String phone;

	/**
	 * 结算方式
	 */
	private Integer settlementType;

	/**
	 * 1:对公   2：对私
	 */
	private Integer payType;

	/**
	 * 公司相关信息
	 */
	private String content;

	private Double wallet=0.0;

	/**
	 * 0:上架  1：下架
	 */
	private Integer status;

	/**
	 * 我司对接人员
	 */
	private String userName;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 创建id
	 */
	private String createBy;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 修改人id
	 */
	private String updateBy;

	/**
	 * 删除标记   0：正常  1：删除
	 */
	private Integer delFlag;


	public TMerchantsEntity() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setSettlementType(Integer settlementType) {
		this.settlementType = settlementType;
	}

	public Integer getSettlementType() {
		return settlementType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
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
